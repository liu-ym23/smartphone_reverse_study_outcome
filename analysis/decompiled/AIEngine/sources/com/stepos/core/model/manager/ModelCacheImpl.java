package com.stepos.core.model.manager;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import androidx.lifecycle.j0;
import b7.t;
import com.stepos.base.model.InferenceConfig;
import com.stepos.base.model.ModelReleaseReason;
import com.stepos.base.model.ModelState;
import com.stepos.base.model.ReleasePriority;
import com.stepos.base.model.ReleaseReason;
import com.stepos.base.model.b;
import com.stepos.base.model.data.BackendType;
import com.stepos.base.model.data.ModelType;
import com.stepos.base.task.data.TaskPriority;
import com.stepos.core.ability.speech.AsrFilePcmSegmentPolicy;
import com.stepos.core.ability.speech.PcmDumpBudget;
import com.stepos.core.ability.speech.TtsCloudConfig;
import com.stepos.core.common.cloud.FileStorageUploader;
import com.stepos.core.model.factory.AIModelFactory;
import com.stepos.core.model.manager.ModelCacheImpl;
import com.stepos.core.model.task.AITaskSupervisor;
import com.stepos.core.model.task.TaskHistory;
import com.stepos.core.performance.data.ModelMeta;
import com.stepos.core.performance.data.PreInitAction;
import com.stepos.core.performance.orchestrator.PerformanceOrchestratorImpl;
import com.stepos.core.performance.signal.SignalHub;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelCacheImpl implements b7.b, t {
    private static final long CLOSE_UNDER_LOCK_TIMEOUT_MS = 20000;
    public static final Companion Companion = new Companion(null);
    private static final long LEAK_MONITOR_INTERVAL_MS = 120000;
    private static final long LOAD_FAILURE_BACKOFF_MS = 60000;
    public static final String MODEL_TYPE_LLM = "llm";
    public static final String MODEL_TYPE_VLM = "vlm";
    private static final String TAG = "ModelCache";
    private final ConcurrentHashMap<String, String> backendCache;
    private final ConcurrentHashMap<String, AtomicBoolean> closingFlags;
    private final ConcurrentHashMap<String, b7.k> configCache;
    private final Context context;
    private final ConcurrentHashMap<String, Mutex> createLocks;
    private volatile int currentMemoryLimitMb;
    private final lb.d deviceTotalRamMb$delegate;
    private final AtomicLong hitCount;
    private final ConcurrentHashMap<String, Long> initTimeCache;
    private final ConcurrentHashMap.KeySetView<String, Boolean> keepAliveModelIds;
    private final ConcurrentHashMap<String, Long> lastAccessTime;
    private final ConcurrentHashMap<String, Long> lastUsedAtMonoNs;
    private final ConcurrentHashMap<String, Pair<Long, Long>> loadDeltaCache;
    private final ConcurrentHashMap<String, Long> loadFailureBackoff;
    private final int maxCapacity;
    private final ConcurrentHashMap<String, TaskPriority> maxTierByModel;
    private final int memoryLimitMb;
    private final AtomicLong missCount;
    private final ConcurrentHashMap<String, b7.a> modelCache;
    private final b7.c modelFactory;
    private final ConcurrentHashMap<String, d7.b> modelInfoCache;
    private final b7.e modelLoader;
    private final b7.f modelRegistry;
    private final lb.d orchestrator$delegate;
    private final ThreadLocal<String> pendingAcquireToken;
    private final ConcurrentHashMap<String, Runnable> pendingReleases;
    private final ConcurrentHashMap.KeySetView<String, Boolean> preloadedModels;
    private final ModelRefManager refManager;
    private final Handler releaseHandler;
    private final HandlerThread releaseThread;
    private final long unloadDelayMs;
    private final CopyOnWriteArrayList<zb.l<String, lb.n>> unloadListeners;
    private final VersionRouter versionRouter;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class ReleasableEntry implements b7.r {
        private final boolean isBackground;
        private final long lastUsedAtMonoNs;
        private final String modelId;
        private final ReleasePriority priority;
        final /* synthetic */ ModelCacheImpl this$0;

        public ReleasableEntry(ModelCacheImpl modelCacheImpl, String modelId, long j10) {
            kotlin.jvm.internal.g.f(modelId, "modelId");
            this.this$0 = modelCacheImpl;
            this.modelId = modelId;
            this.lastUsedAtMonoNs = j10;
            this.priority = modelCacheImpl.keepAliveModelIds.contains(getModelId()) ? ReleasePriority.f6335a : ReleasePriority.f6336b;
        }

        @Override // b7.r
        public long getLastUsedAtMonoNs() {
            return this.lastUsedAtMonoNs;
        }

        @Override // b7.r
        public String getModelId() {
            return this.modelId;
        }

        @Override // b7.r
        public ReleasePriority getPriority() {
            return this.priority;
        }

        public boolean isBackground() {
            return this.isBackground;
        }

        @Override // b7.r
        public boolean isInUse() {
            return this.this$0.refManager.count(getModelId()) > 0;
        }

        @Override // b7.r
        public void release(ReleaseReason reason) {
            Object objA;
            Object objPutIfAbsent;
            kotlin.jvm.internal.g.f(reason, "reason");
            ConcurrentHashMap concurrentHashMap = this.this$0.closingFlags;
            String modelId = getModelId();
            Object atomicBoolean = concurrentHashMap.get(modelId);
            if (atomicBoolean == null && (objPutIfAbsent = concurrentHashMap.putIfAbsent(modelId, (atomicBoolean = new AtomicBoolean(false)))) != null) {
                atomicBoolean = objPutIfAbsent;
            }
            if (((AtomicBoolean) atomicBoolean).compareAndSet(false, true)) {
                Log.i(ModelCacheImpl.TAG, "Releasable.release: modelId=" + getModelId() + " reason=" + reason);
                try {
                    objA = this.this$0.remove(getModelId());
                } catch (Throwable th) {
                    objA = kotlin.c.a(th);
                }
                Throwable thB = Result.b(objA);
                if (thB != null) {
                    Log.w(ModelCacheImpl.TAG, ai.onnxruntime.a.l("Releasable.release: remove(", getModelId(), ") failed: ", thB.getMessage()), thB);
                }
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class VersionRouter {
        private final ConcurrentHashMap<String, Integer> currentVersion = new ConcurrentHashMap<>();
        private final ConcurrentHashMap<Pair<String, Integer>, DrainEntry> drainingInstances = new ConcurrentHashMap<>();
        private final Mutex routerLock = MutexKt.Mutex$default(false, 1, null);
        private final ThreadLocal<Boolean> currentAcquireForeground = new ThreadLocal<>();
        private final int requiredHealthySuccesses = 1;
        private final ConcurrentHashMap.KeySetView<Pair<String, Integer>, Boolean> confirmedVersions = ConcurrentHashMap.newKeySet();
        private final ConcurrentHashMap<Pair<String, Integer>, Integer> healthySuccessCounts = new ConcurrentHashMap<>();
        private final ExecutorService confirmExecutor = Executors.newSingleThreadExecutor(new l());

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public final class DrainEntry {
            private final b7.a iModel;
            private final AtomicInteger refCount;
            final /* synthetic */ VersionRouter this$0;

            public DrainEntry(VersionRouter versionRouter, b7.a iModel, AtomicInteger refCount) {
                kotlin.jvm.internal.g.f(iModel, "iModel");
                kotlin.jvm.internal.g.f(refCount, "refCount");
                this.this$0 = versionRouter;
                this.iModel = iModel;
                this.refCount = refCount;
            }

            public final b7.a getIModel() {
                return this.iModel;
            }

            public final AtomicInteger getRefCount() {
                return this.refCount;
            }
        }

        public VersionRouter() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Thread confirmExecutor$lambda$1(Runnable runnable) {
            return com.stepos.core.ota.d.n(runnable, "ModelVersionConfirm", true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Integer confirmVersionHealthyAsync$lambda$5(Integer a10, Integer b10) {
            kotlin.jvm.internal.g.f(a10, "a");
            kotlin.jvm.internal.g.f(b10, "b");
            return Integer.valueOf(b10.intValue() + a10.intValue());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Integer confirmVersionHealthyAsync$lambda$6(zb.p pVar, Object obj, Object obj2) {
            return (Integer) pVar.invoke(obj, obj2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void confirmVersionHealthyAsync$lambda$9(VersionRouter versionRouter, Pair pair, String str, int i10) {
            Object objA;
            try {
                versionRouter.confirmVersionHealthyLocked(str, i10);
                objA = lb.n.f10413a;
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                versionRouter.confirmedVersions.remove(pair);
                Log.w(ModelCacheImpl.TAG, "confirmVersionHealthy failed: " + str + " v" + i10, thB);
            }
            versionRouter.healthySuccessCounts.remove(pair);
        }

        private final void confirmVersionHealthyLocked(String str, int i10) {
            BuildersKt__BuildersKt.runBlocking$default(null, new ModelCacheImpl$VersionRouter$confirmVersionHealthyLocked$1(this, str, i10, null), 1, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void detachToDraining(String str, int i10) {
            b7.a aVar = (b7.a) ModelCacheImpl.this.modelCache.remove(str);
            if (aVar == null) {
                return;
            }
            int iClear = ModelCacheImpl.this.refManager.clear(str);
            ModelCacheImpl.this.modelInfoCache.remove(str);
            ModelCacheImpl.this.lastAccessTime.remove(str);
            ModelCacheImpl.this.lastUsedAtMonoNs.remove(str);
            ModelCacheImpl.this.closingFlags.remove(str);
            ModelCacheImpl.this.backendCache.remove(str);
            ModelCacheImpl.this.preloadedModels.remove(str);
            ModelCacheImpl.this.loadDeltaCache.remove(str);
            ModelCacheImpl.this.cancelPendingRelease(str);
            this.drainingInstances.put(new Pair<>(str, Integer.valueOf(i10)), new DrainEntry(this, aVar, new AtomicInteger(iClear)));
            StringBuilder sb2 = new StringBuilder("detachToDraining: ");
            sb2.append(str);
            sb2.append(" v");
            sb2.append(i10);
            sb2.append(" moved to draining (refCount=");
            sb2.append(iClear);
            ai.onnxruntime.a.y(sb2, ", not closed)", ModelCacheImpl.TAG);
        }

        public static /* synthetic */ void releaseHandle$default(VersionRouter versionRouter, String str, int i10, com.stepos.base.model.a aVar, String str2, ModelReleaseReason modelReleaseReason, int i11, Object obj) {
            if ((i11 & 8) != 0) {
                str2 = null;
            }
            String str3 = str2;
            if ((i11 & 16) != 0) {
                modelReleaseReason = ModelReleaseReason.f6321b;
            }
            versionRouter.releaseHandle(str, i10, aVar, str3, modelReleaseReason);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void releaseHandle$lambda$2(String str, int i10, DrainEntry drainEntry) {
            try {
                BuildersKt__BuildersKt.runBlocking$default(null, new ModelCacheImpl$VersionRouter$releaseHandle$1$1(drainEntry, null), 1, null);
                Log.i(ModelCacheImpl.TAG, "draining unload: " + str + " v" + i10 + " closed (refCount=0)");
            } catch (Exception e10) {
                String message = e10.getMessage();
                StringBuilder sbF = h0.e.f("draining unload failed: ", str, " v", i10, ": ");
                sbF.append(message);
                Log.e(ModelCacheImpl.TAG, sbF.toString(), e10);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void rotateBackupForSwitch(String str, int i10, String str2) {
            File file = new File(str2);
            if (!file.isDirectory()) {
                a0.a.A("rotateBackup skipped: oldDir not a directory: ", str2, ModelCacheImpl.TAG);
                return;
            }
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                Log.e(ModelCacheImpl.TAG, "rotateBackup failed: cannot infer modelDirRoot from " + str2);
                return;
            }
            File file2 = new File(parentFile, ".backup");
            if (!file2.exists() && !file2.mkdirs()) {
                Log.e(ModelCacheImpl.TAG, "rotateBackup failed: cannot create " + file2);
                return;
            }
            File[] fileArrListFiles = file2.listFiles();
            if (fileArrListFiles != null) {
                for (File file3 : fileArrListFiles) {
                    if (file3.isDirectory() && !kotlin.jvm.internal.g.b(file3.getName(), String.valueOf(i10))) {
                        Log.i(ModelCacheImpl.TAG, "rotateBackup: removed older N-2 backup " + file3.getName() + ", deleted=" + wb.d.T(file3));
                    }
                }
            }
            File file4 = new File(file2, String.valueOf(i10));
            if (file4.exists()) {
                wb.d.T(file4);
            }
            if (file.renameTo(file4)) {
                lb.d dVar = g7.a.f9073a;
                String absolutePath = file4.getAbsolutePath();
                kotlin.jvm.internal.g.e(absolutePath, "getAbsolutePath(...)");
                g7.a.c(str, absolutePath);
                ai.onnxruntime.a.y(h0.e.f("rotateBackup: ", str, " v", i10, " moved to "), file4.getAbsolutePath(), ModelCacheImpl.TAG);
                return;
            }
            Log.e(ModelCacheImpl.TAG, "rotateBackup rename failed: " + str2 + " -> " + file4.getAbsolutePath());
        }

        public final b7.n acquire(String modelId) {
            kotlin.jvm.internal.g.f(modelId, "modelId");
            return (b7.n) BuildersKt__BuildersKt.runBlocking$default(null, new ModelCacheImpl$VersionRouter$acquire$1(this, modelId, ModelCacheImpl.this, null), 1, null);
        }

        public final void confirmVersionHealthyAsync(final String modelId) {
            kotlin.jvm.internal.g.f(modelId, "modelId");
            Integer num = this.currentVersion.get(modelId);
            if (num != null) {
                final int iIntValue = num.intValue();
                final Pair<String, Integer> pair = new Pair<>(modelId, num);
                if (this.confirmedVersions.contains(pair)) {
                    return;
                }
                Integer numMerge = this.healthySuccessCounts.merge(pair, 1, new n(new m(0), 0));
                if ((numMerge != null ? numMerge.intValue() : 1) >= this.requiredHealthySuccesses && this.confirmedVersions.add(pair)) {
                    this.confirmExecutor.execute(new Runnable() { // from class: com.stepos.core.model.manager.o
                        @Override // java.lang.Runnable
                        public final void run() {
                            ModelCacheImpl.VersionRouter.confirmVersionHealthyAsync$lambda$9(this.f7468a, pair, modelId, iIntValue);
                        }
                    });
                }
            }
        }

        public final void deactivate(String modelId) {
            kotlin.jvm.internal.g.f(modelId, "modelId");
            BuildersKt__BuildersKt.runBlocking$default(null, new ModelCacheImpl$VersionRouter$deactivate$1(this, modelId, ModelCacheImpl.this, null), 1, null);
        }

        public final ThreadLocal<Boolean> getCurrentAcquireForeground() {
            return this.currentAcquireForeground;
        }

        public final int getCurrentVersion(String modelId) {
            kotlin.jvm.internal.g.f(modelId, "modelId");
            Integer num = this.currentVersion.get(modelId);
            if (num != null) {
                return num.intValue();
            }
            return -1;
        }

        public final void releaseHandle(final String modelId, final int i10, com.stepos.base.model.a instance, String str, ModelReleaseReason reason) {
            kotlin.jvm.internal.g.f(modelId, "modelId");
            kotlin.jvm.internal.g.f(instance, "instance");
            kotlin.jvm.internal.g.f(reason, "reason");
            Integer num = this.currentVersion.get(modelId);
            if (num != null && i10 == num.intValue()) {
                ModelCacheImpl.this.releaseByModelId(modelId, str, reason);
                return;
            }
            Pair pair = new Pair(modelId, Integer.valueOf(i10));
            final DrainEntry drainEntry = this.drainingInstances.get(pair);
            if (drainEntry != null) {
                if (drainEntry.getRefCount().decrementAndGet() > 0) {
                    return;
                }
                this.drainingInstances.remove(pair);
                ModelCacheImpl.this.getReleaseHandler().post(new Runnable() { // from class: com.stepos.core.model.manager.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        ModelCacheImpl.VersionRouter.releaseHandle$lambda$2(modelId, i10, drainEntry);
                    }
                });
                return;
            }
            Log.w(ModelCacheImpl.TAG, "releaseHandle: draining entry not found for " + modelId + " v" + i10);
        }

        public final boolean rollback(String modelId, int i10, String reason) {
            kotlin.jvm.internal.g.f(modelId, "modelId");
            kotlin.jvm.internal.g.f(reason, "reason");
            return ((Boolean) BuildersKt__BuildersKt.runBlocking$default(null, new ModelCacheImpl$VersionRouter$rollback$1(this, modelId, i10, ModelCacheImpl.this, reason, null), 1, null)).booleanValue();
        }

        public final List<t.a> snapshot() {
            ArrayList arrayList = new ArrayList();
            Enumeration enumerationKeys = ModelCacheImpl.this.modelCache.keys();
            kotlin.jvm.internal.g.e(enumerationKeys, "keys(...)");
            ArrayList list = Collections.list(enumerationKeys);
            kotlin.jvm.internal.g.e(list, "list(...)");
            ModelCacheImpl modelCacheImpl = ModelCacheImpl.this;
            int size = list.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = list.get(i10);
                i10++;
                String str = (String) obj;
                Integer num = this.currentVersion.get(str);
                int iIntValue = num != null ? num.intValue() : -1;
                kotlin.jvm.internal.g.c(str);
                int iCount = modelCacheImpl.refManager.count(str);
                Long l10 = (Long) modelCacheImpl.lastUsedAtMonoNs.get(str);
                long jLongValue = l10 != null ? l10.longValue() : 0L;
                long j10 = (((d7.b) modelCacheImpl.modelInfoCache.get(str)) != null ? r6.f8406g : 0L) * PcmDumpBudget.BYTES_PER_MB;
                String str2 = (String) modelCacheImpl.backendCache.get(str);
                if (str2 == null) {
                    str2 = "";
                }
                arrayList.add(new t.a(str, iIntValue, true, iCount, jLongValue, j10, str2));
            }
            for (Map.Entry<Pair<String, Integer>, DrainEntry> entry : this.drainingInstances.entrySet()) {
                Pair<String, Integer> key = entry.getKey();
                DrainEntry value = entry.getValue();
                arrayList.add(new t.a(key.f9985a, key.f9986b.intValue(), false, value.getRefCount().get(), 0L, 0L, value.getIModel().getConfig().f3096g.f6263a));
            }
            return arrayList;
        }

        public final void switchVersion(String modelId, int i10, String newPath, String installer) {
            kotlin.jvm.internal.g.f(modelId, "modelId");
            kotlin.jvm.internal.g.f(newPath, "newPath");
            kotlin.jvm.internal.g.f(installer, "installer");
            BuildersKt__BuildersKt.runBlocking$default(null, new ModelCacheImpl$VersionRouter$switchVersion$1(this, modelId, i10, newPath, ModelCacheImpl.this, installer, null), 1, null);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.model.manager.ModelCacheImpl", f = "ModelCacheImpl.kt", l = {1916, 454, 465}, m = "acquire")
    /* renamed from: com.stepos.core.model.manager.ModelCacheImpl$acquire$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(qb.b<? super AnonymousClass1> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ModelCacheImpl.this.acquire(null, false, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.model.manager.ModelCacheImpl", f = "ModelCacheImpl.kt", l = {288, 303}, m = "evictQnnModels")
    /* renamed from: com.stepos.core.model.manager.ModelCacheImpl$evictQnnModels$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03811 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C03811(qb.b<? super C03811> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ModelCacheImpl.this.evictQnnModels(null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.model.manager.ModelCacheImpl$removeAndCloseSync$3", f = "ModelCacheImpl.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.model.manager.ModelCacheImpl$removeAndCloseSync$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
        final /* synthetic */ CountDownLatch $latch;
        final /* synthetic */ String $modelId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(CountDownLatch countDownLatch, String str, qb.b<? super AnonymousClass3> bVar) {
            super(2, bVar);
            this.$latch = countDownLatch;
            this.$modelId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            return new AnonymousClass3(this.$latch, this.$modelId, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            if (!this.$latch.await(AsrFilePcmSegmentPolicy.MAX_SEGMENT_MS, TimeUnit.MILLISECONDS)) {
                Log.e(ModelCacheImpl.TAG, "Timeout waiting for QNN model close: " + this.$modelId);
            }
            return lb.n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
            return ((AnonymousClass3) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    public ModelCacheImpl(Context context, b7.f modelRegistry, b7.c modelFactory, b7.e modelLoader, int i10, int i11, long j10) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(modelRegistry, "modelRegistry");
        kotlin.jvm.internal.g.f(modelFactory, "modelFactory");
        kotlin.jvm.internal.g.f(modelLoader, "modelLoader");
        this.context = context;
        this.modelRegistry = modelRegistry;
        this.modelFactory = modelFactory;
        this.modelLoader = modelLoader;
        this.maxCapacity = i10;
        this.memoryLimitMb = i11;
        this.unloadDelayMs = j10;
        this.refManager = new ModelRefManager();
        this.unloadListeners = new CopyOnWriteArrayList<>();
        this.pendingAcquireToken = new ThreadLocal<>();
        this.loadFailureBackoff = new ConcurrentHashMap<>();
        this.modelCache = new ConcurrentHashMap<>();
        this.modelInfoCache = new ConcurrentHashMap<>();
        this.lastAccessTime = new ConcurrentHashMap<>();
        this.lastUsedAtMonoNs = new ConcurrentHashMap<>();
        this.closingFlags = new ConcurrentHashMap<>();
        this.createLocks = new ConcurrentHashMap<>();
        this.configCache = new ConcurrentHashMap<>();
        this.backendCache = new ConcurrentHashMap<>();
        this.keepAliveModelIds = ConcurrentHashMap.newKeySet();
        this.maxTierByModel = new ConcurrentHashMap<>();
        this.hitCount = new AtomicLong(0L);
        this.missCount = new AtomicLong(0L);
        this.currentMemoryLimitMb = i11;
        HandlerThread handlerThread = new HandlerThread("model-release");
        handlerThread.start();
        this.releaseThread = handlerThread;
        this.releaseHandler = new Handler(handlerThread.getLooper());
        this.pendingReleases = new ConcurrentHashMap<>();
        this.initTimeCache = new ConcurrentHashMap<>();
        this.loadDeltaCache = new ConcurrentHashMap<>();
        this.preloadedModels = ConcurrentHashMap.newKeySet();
        this.orchestrator$delegate = kotlin.b.b(new zb.a() { // from class: com.stepos.core.model.manager.f
            @Override // zb.a
            public final Object invoke() {
                return ModelCacheImpl.orchestrator_delegate$lambda$1(this.f7450a);
            }
        });
        scheduleLeakMonitor();
        Log.i(TAG, "ModelCacheImpl initialized");
        this.deviceTotalRamMb$delegate = kotlin.b.b(new j0(this, 4));
        this.versionRouter = new VersionRouter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Mutex acquire$lambda$10(String it) {
        kotlin.jvm.internal.g.f(it, "it");
        return MutexKt.Mutex$default(false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Mutex acquire$lambda$11(zb.l lVar, Object obj) {
        return (Mutex) lVar.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n acquire$lambda$20$lambda$13$lambda$12(String str, boolean z, String str2, p6.g it) {
        kotlin.jvm.internal.g.f(it, "it");
        it.onLoadEmpty(str, str, z, str2, "cache hit (after lock)");
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n acquire$lambda$20$lambda$14(String str, boolean z, String str2, p6.g it) {
        kotlin.jvm.internal.g.f(it, "it");
        it.onBeforeLoad(str, str, z, str2);
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n acquire$lambda$20$lambda$15(String str, boolean z, String str2, Throwable th, p6.g it) {
        kotlin.jvm.internal.g.f(it, "it");
        it.onLoadFailed(str, str, z, str2, th);
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n acquire$lambda$20$lambda$18(String str, boolean z, String str2, long j10, p6.g it) {
        kotlin.jvm.internal.g.f(it, "it");
        it.onAfterLoad(str, str, z, str2, j10);
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n acquire$lambda$20$lambda$19(String str, boolean z, String str2, p6.g it) {
        kotlin.jvm.internal.g.f(it, "it");
        it.onLoadedToInvoke(str, str, z, str2);
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n acquire$lambda$9$lambda$8(String str, boolean z, String str2, p6.g it) {
        kotlin.jvm.internal.g.f(it, "it");
        it.onLoadEmpty(str, str, z, str2, "cache hit (fast path)");
        return lb.n.f10413a;
    }

    private final void applyOrchestratorPreInit(PreInitAction preInitAction, String str) {
        if (preInitAction instanceof PreInitAction.NoOp) {
            return;
        }
        if (preInitAction instanceof PreInitAction.EvictAll) {
            PreInitAction.EvictAll evictAll = (PreInitAction.EvictAll) preInitAction;
            Log.i(TAG, "onPreInit: orchestrator EvictAll — " + evictAll.getReason());
            evictAllIdle();
            if (evictAll.getNeedsGc()) {
                System.gc();
                return;
            }
            return;
        }
        if (!(preInitAction instanceof PreInitAction.EvictCategory)) {
            if (!(preInitAction instanceof PreInitAction.EvictToRetain)) {
                throw new NoWhenBranchMatchedException();
            }
            PreInitAction.EvictToRetain evictToRetain = (PreInitAction.EvictToRetain) preInitAction;
            Log.i(TAG, "onPreInit: orchestrator EvictToRetain(" + evictToRetain.getRetainMb() + "MB) — " + evictToRetain.getReason());
            evictByRetainBudget(evictToRetain.getRetainMb());
            return;
        }
        Set<String> setKeySet = this.modelCache.keySet();
        kotlin.jvm.internal.g.e(setKeySet, "<get-keys>(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            String str2 = (String) obj;
            if (!kotlin.jvm.internal.g.b(str2, str)) {
                ModelRefManager modelRefManager = this.refManager;
                kotlin.jvm.internal.g.c(str2);
                if (modelRefManager.count(str2) <= 0 && !this.keepAliveModelIds.contains(str2)) {
                    b7.k kVar = this.configCache.get(str2);
                    if ((kVar != null ? modelCategoryFromConfig(kVar) : null) == ((PreInitAction.EvictCategory) preInitAction).getCategory()) {
                        arrayList.add(obj);
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        Log.i(TAG, "onPreInit: orchestrator EvictCategory(" + ((PreInitAction.EvictCategory) preInitAction).getCategory() + ") — " + arrayList.size() + " idle");
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj2 = arrayList.get(i10);
            i10++;
            String str3 = (String) obj2;
            kotlin.jvm.internal.g.c(str3);
            remove(str3);
        }
    }

    private final BackendType backendTypeFromKey(String str) {
        return gc.o.k0(str, "QNN_", false) ? BackendType.f6357a : gc.q.l0(str, "LLAMA", true) ? BackendType.f6358b : gc.q.l0(str, "ONNX", true) ? BackendType.f6359c : BackendType.f6360d;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final d7.b buildModelInfo(b7.k r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = -1
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            com.stepos.base.model.data.ModelType r6 = r19.modelTypeFromConfig(r20)
            d7.a r3 = r1.f3097i
            java.lang.String r4 = r1.f3094e
            r5 = r4
            java.lang.String r4 = r1.f3090a
            if (r3 == 0) goto L1b
            int r3 = r3.f8393b
        L19:
            r9 = r3
            goto L1e
        L1b:
            int r3 = r6.f6371a
            goto L19
        L1e:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, kotlin.Pair<java.lang.Long, java.lang.Long>> r3 = r0.loadDeltaCache
            java.lang.Object r3 = r3.get(r4)
            kotlin.Pair r3 = (kotlin.Pair) r3
            if (r3 != 0) goto L2d
            kotlin.Pair r3 = new kotlin.Pair
            r3.<init>(r2, r2)
        L2d:
            A r2 = r3.f9985a
            java.lang.Number r2 = (java.lang.Number) r2
            long r15 = r2.longValue()
            B r2 = r3.f9986b
            java.lang.Number r2 = (java.lang.Number) r2
            long r17 = r2.longValue()
            if (r5 == 0) goto L4a
            boolean r2 = gc.q.t0(r5)
            if (r2 != 0) goto L47
            r2 = r5
            goto L48
        L47:
            r2 = 0
        L48:
            if (r2 != 0) goto L4b
        L4a:
            r2 = r4
        L4b:
            java.lang.String r7 = r1.f3091b
            java.lang.String r8 = r1.f3092c
            if (r5 != 0) goto L55
            java.lang.String r3 = ""
            r10 = r3
            goto L56
        L55:
            r10 = r5
        L56:
            com.stepos.base.model.ModelState r3 = com.stepos.base.model.ModelState.f6326a
            long r11 = java.lang.System.currentTimeMillis()
            com.stepos.base.model.InferenceConfig r1 = r1.f3096g
            java.lang.String r1 = r1.f6263a
            com.stepos.base.model.data.BackendType r13 = r0.backendTypeFromKey(r1)
            boolean r14 = r6.f6372b
            d7.b r3 = new d7.b
            r5 = r2
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r13, r14, r15, r17)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.model.manager.ModelCacheImpl.buildModelInfo(b7.k):d7.b");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelPendingRelease(String str) {
        Runnable runnableRemove = this.pendingReleases.remove(str);
        if (runnableRemove != null) {
            this.releaseHandler.removeCallbacks(runnableRemove);
            Log.d(TAG, "Cancelled pending idle release for: " + str + " (hot reuse)");
        }
    }

    private final void checkAndEvictForMemoryBudget(b7.k kVar) {
        d7.a aVar = kVar.f3097i;
        int i10 = aVar != null ? aVar.f8393b : 500;
        int totalMemoryMb = getTotalMemoryMb();
        int i11 = this.currentMemoryLimitMb;
        int i12 = totalMemoryMb + i10;
        if (i12 <= i11) {
            return;
        }
        int i13 = i12 - i11;
        StringBuilder sbD = h0.e.d(totalMemoryMb, "Memory budget exceeded: used=", i10, "MB + new≈", "MB > budget=");
        sbD.append(i11);
        sbD.append("MB, need to free ");
        sbD.append(i13);
        sbD.append("MB");
        Log.i(TAG, sbD.toString());
        Log.i(TAG, com.stepos.core.ota.d.e(evictByMemory(i13), "Memory budget eviction: freed ", i13, "MB (needed ", "MB)"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void clear$lambda$35(List list, ModelCacheImpl modelCacheImpl) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            A a10 = pair.f9985a;
            kotlin.jvm.internal.g.e(a10, "component1(...)");
            String str = (String) a10;
            B b10 = pair.f9986b;
            kotlin.jvm.internal.g.e(b10, "component2(...)");
            try {
                try {
                } catch (Exception e10) {
                    Log.e(TAG, "Failed to close model in clear(): " + e10.getMessage(), e10);
                }
            } finally {
                modelCacheImpl.fireUnloadListeners(str);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void closeUnderCreateLock(java.lang.String r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 526
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.model.manager.ModelCacheImpl.closeUnderCreateLock(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Mutex closeUnderCreateLock$lambda$71(String it) {
        kotlin.jvm.internal.g.f(it, "it");
        return MutexKt.Mutex$default(false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Mutex closeUnderCreateLock$lambda$72(zb.l lVar, Object obj) {
        return (Mutex) lVar.invoke(obj);
    }

    private final long computeDeferredDelayMs(String str) {
        long deferredReleaseDelayMs;
        d7.a aVar;
        if (getDeviceTotalRamMb() < 8192) {
            Log.d(TAG, "computeDeferredDelayMs: device RAM " + getDeviceTotalRamMb() + "MB <8GB, immediate release");
            return 0L;
        }
        long processMemoryMb = getProcessMemoryMb();
        Long l10 = this.initTimeCache.get(str);
        long jLongValue = l10 != null ? l10.longValue() : FileStorageUploader.LOG_HEARTBEAT_MS;
        b7.k kVar = this.configCache.get(str);
        long j10 = (kVar == null || (aVar = kVar.f3097i) == null) ? jLongValue / 10 : aVar.f8393b;
        long j11 = 4;
        if (j10 * j11 > processMemoryMb && processMemoryMb > 1024) {
            StringBuilder sbQ = ai.onnxruntime.a.q(j10, "computeDeferredDelayMs: model memory ratio too high (modelMem=", "MB × 4 > selfMem=");
            sbQ.append(processMemoryMb);
            sbQ.append("MB), immediate release");
            Log.d(TAG, sbQ.toString());
            return 0L;
        }
        if (processMemoryMb > 2048) {
            Log.d(TAG, "computeDeferredDelayMs: process memory " + processMemoryMb + "MB >2GB, immediate release");
            return 0L;
        }
        if (jLongValue < 500) {
            Log.d(TAG, "computeDeferredDelayMs: init time " + jLongValue + "ms <500ms, immediate release");
            return 0L;
        }
        try {
            deferredReleaseDelayMs = getOrchestrator().cachedVerdict().getDeferredReleaseDelayMs();
        } catch (Exception unused) {
            deferredReleaseDelayMs = -1;
        }
        if (deferredReleaseDelayMs == 0) {
            Log.d(TAG, "computeDeferredDelayMs: verdict.deferredReleaseDelayMs=0 (memory pressure), immediate release");
            return 0L;
        }
        long jB0 = dc.h.b0(jLongValue * j11, 3000L, TtsCloudConfig.DEFAULT_AUDIO_DONE_IDLE_WATCHDOG_MS);
        long jComputeIdleTimeoutMs = computeIdleTimeoutMs();
        if (deferredReleaseDelayMs > 0) {
            jB0 = Math.min(jB0, deferredReleaseDelayMs);
        }
        long jMin = Math.min(jB0, jComputeIdleTimeoutMs);
        if (!this.preloadedModels.contains(str)) {
            return jMin;
        }
        long j12 = 2 * jMin;
        StringBuilder sbQ2 = ai.onnxruntime.a.q(jMin, "computeDeferredDelayMs: preloaded model, doubling delay ", "ms → ");
        sbQ2.append(j12);
        sbQ2.append("ms");
        Log.d(TAG, sbQ2.toString());
        return j12;
    }

    private final long computeIdleTimeoutMs() {
        long idleTimeoutMs;
        try {
            idleTimeoutMs = getOrchestrator().cachedVerdict().getIdleTimeoutMs();
        } catch (Exception unused) {
            idleTimeoutMs = -1;
        }
        if (idleTimeoutMs > 0) {
            return idleTimeoutMs;
        }
        if (getDeviceTotalRamMb() < 8192) {
            return 15000L;
        }
        long processMemoryMb = AsrFilePcmSegmentPolicy.MAX_SEGMENT_MS - ((getProcessMemoryMb() / 500) * FileStorageUploader.LOG_HEARTBEAT_MS);
        if (processMemoryMb < 15000) {
            return 15000L;
        }
        return processMemoryMb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object createAndInitModel(b7.k kVar, qb.b<? super b7.a> bVar) throws Exception {
        String str = kVar.f3090a;
        d7.a aVar = kVar.f3097i;
        String strA = InferenceConfig.a.a(kVar.f3096g.f6263a);
        String str2 = kVar.f3091b;
        StringBuilder sbS = ai.onnxruntime.a.s("Creating model: ", str, ", backend=", strA, ", path=");
        sbS.append(str2);
        Log.i(TAG, sbS.toString());
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.stepos.base.model.b bVar2 = com.stepos.base.model.b.f6348a;
        b.C0044b c0044bE = bVar2.e();
        long j10 = c0044bE.f6355a;
        try {
            b7.a aVarLoad = this.modelLoader.load(this.context, kVar);
            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
            b.C0044b c0044bE2 = bVar2.e();
            long j11 = c0044bE2.f6355a;
            this.initTimeCache.put(str, new Long(jElapsedRealtime2));
            long j12 = c0044bE.f6356b;
            if (j12 >= 0) {
                long j13 = c0044bE2.f6356b;
                if (j13 >= 0 && j10 >= 0 && j11 >= 0) {
                    this.loadDeltaCache.put(str, new Pair<>(new Long(j13 - j12), new Long(j11 - j10)));
                }
            }
            TaskHistory taskHistory = TaskHistory.INSTANCE;
            taskHistory.recordInitTime(str, jElapsedRealtime2);
            try {
                SignalHub signalHub = getOrchestrator().signalHub();
                String str3 = kVar.f3090a;
                signalHub.updateModelHistory(str3, taskHistory.getAverageInitTimeMs(str3), aVar != null ? aVar.f8393b : 0L, taskHistory.getAverageInvokeTimeMs(str), taskHistory.getAverageTtftMs(str));
                signalHub.invalidate();
            } catch (Exception e10) {
                a0.a.A("signalHub history sync after init: ", e10.getMessage(), TAG);
            }
            com.stepos.base.model.b.f6348a.getClass();
            String strB = com.stepos.base.model.b.b(c0044bE);
            String strB2 = com.stepos.base.model.b.b(c0044bE2);
            String strA2 = com.stepos.base.model.b.a(c0044bE, c0044bE2);
            int i10 = aVar != null ? aVar.f8393b : -1;
            StringBuilder sbL = com.stepos.core.ota.d.l("✅ Model ready: ", jElapsedRealtime2, str, " (init=");
            ai.onnxruntime.a.z(sbL, "ms, ", strB, " → ", strB2);
            sbL.append(", ");
            sbL.append(strA2);
            sbL.append(", bundle.memoryMB=");
            sbL.append(i10);
            ai.onnxruntime.a.y(sbL, ")", TAG);
            return aVarLoad;
        } catch (Exception e11) {
            Log.e(TAG, "IModelLoader also failed: " + e11.getMessage());
            throw e11;
        }
    }

    private final Pair<b7.a, String> detachFromCache(String str, boolean z) {
        b7.a aVarRemove = this.modelCache.remove(str);
        if (aVarRemove == null && z) {
            return new Pair<>(null, null);
        }
        this.modelInfoCache.remove(str);
        this.lastAccessTime.remove(str);
        this.lastUsedAtMonoNs.remove(str);
        this.refManager.clear(str);
        this.configCache.remove(str);
        String strRemove = this.backendCache.remove(str);
        this.preloadedModels.remove(str);
        this.loadDeltaCache.remove(str);
        this.maxTierByModel.remove(str);
        this.closingFlags.remove(str);
        return new Pair<>(aVarRemove, strRemove);
    }

    public static /* synthetic */ Pair detachFromCache$default(ModelCacheImpl modelCacheImpl, String str, boolean z, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z = false;
        }
        return modelCacheImpl.detachFromCache(str, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long deviceTotalRamMb_delegate$lambda$69(ModelCacheImpl modelCacheImpl) {
        Object systemService = modelCacheImpl.context.getSystemService("activity");
        kotlin.jvm.internal.g.d(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem / PcmDumpBudget.BYTES_PER_MB;
    }

    private final String evictLRU() {
        Object next;
        Set<Map.Entry<String, Long>> setEntrySet = this.lastAccessTime.entrySet();
        kotlin.jvm.internal.g.e(setEntrySet, "<get-entries>(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : setEntrySet) {
            Map.Entry entry = (Map.Entry) obj;
            ModelRefManager modelRefManager = this.refManager;
            Object key = entry.getKey();
            kotlin.jvm.internal.g.e(key, "<get-key>(...)");
            if (modelRefManager.count((String) key) == 0 && !this.keepAliveModelIds.contains(entry.getKey())) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                Object value = ((Map.Entry) next).getValue();
                kotlin.jvm.internal.g.e(value, "<get-value>(...)");
                long jLongValue = ((Number) value).longValue();
                do {
                    Object next2 = it.next();
                    Object value2 = ((Map.Entry) next2).getValue();
                    kotlin.jvm.internal.g.e(value2, "<get-value>(...)");
                    long jLongValue2 = ((Number) value2).longValue();
                    if (jLongValue > jLongValue2) {
                        next = next2;
                        jLongValue = jLongValue2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        Map.Entry entry2 = (Map.Entry) next;
        String str = entry2 != null ? (String) entry2.getKey() : null;
        if (str == null) {
            return null;
        }
        remove(str);
        Log.d(TAG, "Evicted LRU model: ".concat(str));
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x01b4, code lost:
    
        if (r1.removeAndCloseSync(r12, r3) == r9) goto L75;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0280  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x01b4 -> B:56:0x01b8). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:76:0x0270 -> B:77:0x0272). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object evictQnnModels(java.lang.String r22, qb.b<? super java.lang.Integer> r23) {
        /*
            Method dump skipped, instructions count: 659
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.model.manager.ModelCacheImpl.evictQnnModels(java.lang.String, qb.b):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void executeIdleRelease(String str) throws Throwable {
        this.pendingReleases.remove(str);
        if (this.modelCache.get(str) == null) {
            return;
        }
        if (this.refManager.count(str) > 0) {
            Log.d(TAG, "idle release skipped: " + str + " has been re-acquired");
            return;
        }
        if (this.keepAliveModelIds.contains(str)) {
            Log.d(TAG, "idle release skipped: " + str + " is keepAlive-pinned");
            return;
        }
        Log.i(TAG, "idle " + str + " → close");
        closeUnderCreateLock(str);
    }

    private final void fireUnloadListeners(String str) {
        Object objA;
        Iterator<T> it = this.unloadListeners.iterator();
        while (it.hasNext()) {
            try {
                ((zb.l) it.next()).invoke(str);
                objA = lb.n.f10413a;
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                Log.w(TAG, ai.onnxruntime.a.l("unloadListener threw for ", str, ": ", thB.getMessage()), thB);
            }
        }
    }

    private final long getDeviceTotalRamMb() {
        return ((Number) this.deviceTotalRamMb$delegate.getValue()).longValue();
    }

    private final PerformanceOrchestratorImpl getOrchestrator() {
        return (PerformanceOrchestratorImpl) this.orchestrator$delegate.getValue();
    }

    private final long getProcessMemoryMb() {
        Debug.getMemoryInfo(new Debug.MemoryInfo());
        return ((Debug.getNativeHeapAllocatedSize() / 1024) + r6.getTotalPss()) / 1024;
    }

    private final boolean isQnnBackend(String str) {
        return gc.o.k0(str, "QNN_", false);
    }

    private final d7.b minimalModelInfo(b7.k kVar) {
        Object objA;
        Object objA2;
        String str = kVar.f3090a;
        ModelType modelType = ModelType.f6369l;
        try {
            objA = kVar.f3091b;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = "";
        }
        String str2 = (String) objA;
        try {
            objA2 = kVar.f3092c;
        } catch (Throwable th2) {
            objA2 = kotlin.c.a(th2);
        }
        if (objA2 instanceof Result.Failure) {
            objA2 = null;
        }
        String str3 = (String) objA2;
        ModelState modelState = ModelState.f6326a;
        return new d7.b(str, str, modelType, str2, str3, 0, "", System.currentTimeMillis(), BackendType.f6360d, false, -1L, -1L);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.stepos.core.performance.data.ModelCategory modelCategoryFromConfig(b7.k r5) {
        /*
            Method dump skipped, instructions count: 279
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.model.manager.ModelCacheImpl.modelCategoryFromConfig(b7.k):com.stepos.core.performance.data.ModelCategory");
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.stepos.base.model.data.ModelType modelTypeFromConfig(b7.k r5) {
        /*
            Method dump skipped, instructions count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.model.manager.ModelCacheImpl.modelTypeFromConfig(b7.k):com.stepos.base.model.data.ModelType");
    }

    private final void notifyLoadObservers(zb.l<? super p6.g, lb.n> lVar) {
        try {
            AITaskSupervisor.Companion.getInstance(this.context).notifyLifecycleObservers(lVar);
        } catch (Exception e10) {
            a0.a.v("Skip observer notification: ", e10.getMessage(), TAG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PerformanceOrchestratorImpl orchestrator_delegate$lambda$1(ModelCacheImpl modelCacheImpl) {
        return PerformanceOrchestratorImpl.Companion.getInstance(modelCacheImpl.context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TaskPriority recordAcquireTier$lambda$75(TaskPriority old, TaskPriority taskPriority) {
        kotlin.jvm.internal.g.f(old, "old");
        kotlin.jvm.internal.g.f(taskPriority, "new");
        return old.ordinal() <= taskPriority.ordinal() ? old : taskPriority;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TaskPriority recordAcquireTier$lambda$76(zb.p pVar, Object obj, Object obj2) {
        return (TaskPriority) pVar.invoke(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void releaseByModelId(String str, String str2, ModelReleaseReason modelReleaseReason) {
        boolean zRelease = this.refManager.release(str, str2, modelReleaseReason);
        StringBuilder sbF = h0.e.f("Released model: ", str, ", refCount: ", this.refManager.count(str), ", reason=");
        sbF.append(modelReleaseReason);
        Log.d(TAG, sbF.toString());
        if (zRelease) {
            long jComputeDeferredDelayMs = computeDeferredDelayMs(str);
            if (jComputeDeferredDelayMs <= 0) {
                Log.d(TAG, "Model " + str + " idle, immediate close (high memory pressure)");
                this.releaseHandler.post(new androidx.appcompat.app.l(10, this, str));
                return;
            }
            StringBuilder sbL = com.stepos.core.ota.d.l("Model ", jComputeDeferredDelayMs, str, " idle, deferred close in ");
            sbL.append("ms");
            Log.d(TAG, sbL.toString());
            androidx.room.o oVar = new androidx.room.o(9, this, str);
            this.pendingReleases.put(str, oVar);
            this.releaseHandler.postDelayed(oVar, jComputeDeferredDelayMs);
        }
    }

    public static /* synthetic */ void releaseByModelId$default(ModelCacheImpl modelCacheImpl, String str, String str2, ModelReleaseReason modelReleaseReason, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            modelReleaseReason = ModelReleaseReason.f6321b;
        }
        modelCacheImpl.releaseByModelId(str, str2, modelReleaseReason);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void remove$lambda$28$lambda$27(String str, ModelCacheImpl modelCacheImpl, b7.a aVar) {
        com.stepos.base.model.b bVar = com.stepos.base.model.b.f6348a;
        b.C0044b c0044bE = bVar.e();
        try {
            BuildersKt__BuildersKt.runBlocking$default(null, new ModelCacheImpl$remove$1$1$1(aVar, null), 1, null);
            b.C0044b c0044bE2 = bVar.e();
            Log.i(TAG, "✅ Model closed: " + str + " (" + com.stepos.base.model.b.b(c0044bE) + " → " + com.stepos.base.model.b.b(c0044bE2) + ", " + com.stepos.base.model.b.a(c0044bE, c0044bE2) + ")");
        } catch (Exception e10) {
            b.C0044b c0044bE3 = com.stepos.base.model.b.f6348a.e();
            Log.e(TAG, "Failed to close model " + str + " (" + com.stepos.base.model.b.b(c0044bE) + " → " + com.stepos.base.model.b.b(c0044bE3) + "): " + e10.getMessage(), e10);
        } finally {
            modelCacheImpl.fireUnloadListeners(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object removeAndCloseSync(final String str, qb.b<? super lb.n> bVar) {
        cancelPendingRelease(str);
        final b7.a aVarRemove = this.modelCache.remove(str);
        this.modelInfoCache.remove(str);
        this.lastAccessTime.remove(str);
        this.refManager.clear(str);
        this.configCache.remove(str);
        String strRemove = this.backendCache.remove(str);
        this.preloadedModels.remove(str);
        this.loadDeltaCache.remove(str);
        this.maxTierByModel.remove(str);
        if (aVarRemove == null) {
            return lb.n.f10413a;
        }
        Log.i(TAG, h0.e.c("Closing QNN model (sync, via releaseHandler): ", str, " (backend=", strRemove, ")"));
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.releaseHandler.post(new Runnable() { // from class: com.stepos.core.model.manager.h
            @Override // java.lang.Runnable
            public final void run() {
                ModelCacheImpl.removeAndCloseSync$lambda$6(str, this, countDownLatch, aVarRemove);
            }
        });
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass3(countDownLatch, str, null), bVar);
        return objWithContext == CoroutineSingletons.f10059a ? objWithContext : lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeAndCloseSync$lambda$6(String str, ModelCacheImpl modelCacheImpl, CountDownLatch countDownLatch, b7.a aVar) {
        com.stepos.base.model.b bVar = com.stepos.base.model.b.f6348a;
        b.C0044b c0044bE = bVar.e();
        try {
            try {
                BuildersKt__BuildersKt.runBlocking$default(null, new ModelCacheImpl$removeAndCloseSync$2$1(aVar, null), 1, null);
                b.C0044b c0044bE2 = bVar.e();
                Log.i(TAG, "✅ QNN model closed (sync): " + str + " (" + com.stepos.base.model.b.b(c0044bE) + " → " + com.stepos.base.model.b.b(c0044bE2) + ", " + com.stepos.base.model.b.a(c0044bE, c0044bE2) + ")");
            } catch (Exception e10) {
                b.C0044b c0044bE3 = com.stepos.base.model.b.f6348a.e();
                Log.e(TAG, "Close failed for " + str + " (" + com.stepos.base.model.b.b(c0044bE) + " → " + com.stepos.base.model.b.b(c0044bE3) + "): " + e10.getMessage(), e10);
            }
        } finally {
            modelCacheImpl.fireUnloadListeners(str);
            countDownLatch.countDown();
        }
    }

    private final void scheduleLeakMonitor() {
        this.releaseHandler.postDelayed(new Runnable() { // from class: com.stepos.core.model.manager.ModelCacheImpl.scheduleLeakMonitor.1
            @Override // java.lang.Runnable
            public void run() {
                Object objA;
                Set setKeySet = ModelCacheImpl.this.modelCache.keySet();
                kotlin.jvm.internal.g.e(setKeySet, "<get-keys>(...)");
                ModelCacheImpl modelCacheImpl = ModelCacheImpl.this;
                ArrayList arrayList = new ArrayList();
                for (Object obj : setKeySet) {
                    String str = (String) obj;
                    ModelRefManager modelRefManager = modelCacheImpl.refManager;
                    kotlin.jvm.internal.g.c(str);
                    if (modelRefManager.count(str) == 0 && modelCacheImpl.pendingReleases.get(str) == null) {
                        arrayList.add(obj);
                    }
                }
                ModelCacheImpl modelCacheImpl2 = ModelCacheImpl.this;
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj2 = arrayList.get(i10);
                    i10++;
                    String str2 = (String) obj2;
                    ai.onnxruntime.a.x("LeakMonitor: force-releasing idle model ", str2, " (no pending release, refCount=0)", ModelCacheImpl.TAG);
                    try {
                        kotlin.jvm.internal.g.c(str2);
                        modelCacheImpl2.executeIdleRelease(str2);
                        objA = lb.n.f10413a;
                    } catch (Throwable th) {
                        objA = kotlin.c.a(th);
                    }
                    Throwable thB = Result.b(objA);
                    if (thB != null) {
                        Log.e(ModelCacheImpl.TAG, ai.onnxruntime.a.l("LeakMonitor: release failed for ", str2, ": ", thB.getMessage()), thB);
                    }
                }
                ModelCacheImpl.this.getReleaseHandler().postDelayed(this, 120000L);
            }
        }, 120000L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02bc A[Catch: all -> 0x02fc, TryCatch #5 {all -> 0x02fc, blocks: (B:74:0x02b5, B:78:0x02db, B:80:0x02f6, B:85:0x0303, B:77:0x02bc, B:73:0x02b1, B:94:0x0325, B:96:0x0343, B:100:0x035c, B:101:0x0391, B:64:0x0260, B:70:0x02ab), top: B:113:0x0260, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02f6 A[Catch: all -> 0x02fc, TryCatch #5 {all -> 0x02fc, blocks: (B:74:0x02b5, B:78:0x02db, B:80:0x02f6, B:85:0x0303, B:77:0x02bc, B:73:0x02b1, B:94:0x0325, B:96:0x0343, B:100:0x035c, B:101:0x0391, B:64:0x0260, B:70:0x02ab), top: B:113:0x0260, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0343 A[Catch: all -> 0x02fc, TryCatch #5 {all -> 0x02fc, blocks: (B:74:0x02b5, B:78:0x02db, B:80:0x02f6, B:85:0x0303, B:77:0x02bc, B:73:0x02b1, B:94:0x0325, B:96:0x0343, B:100:0x035c, B:101:0x0391, B:64:0x0260, B:70:0x02ab), top: B:113:0x0260, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x035a  */
    /* JADX WARN: Type inference failed for: r1v0, types: [b7.k, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object acquire(b7.k r24, boolean r25, qb.b<? super b7.a> r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 918
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.model.manager.ModelCacheImpl.acquire(b7.k, boolean, qb.b):java.lang.Object");
    }

    @Override // b7.b
    public void addUnloadListener(zb.l<? super String, lb.n> listener) {
        kotlin.jvm.internal.g.f(listener, "listener");
        this.unloadListeners.add(listener);
    }

    @Override // b7.b
    public int capacity() {
        return this.maxCapacity;
    }

    public int clear() {
        int size = this.modelCache.size();
        Set<String> setKeySet = this.pendingReleases.keySet();
        kotlin.jvm.internal.g.e(setKeySet, "<get-keys>(...)");
        for (String str : kotlin.collections.a.O0(setKeySet)) {
            kotlin.jvm.internal.g.c(str);
            cancelPendingRelease(str);
        }
        Set<Map.Entry<String, b7.a>> setEntrySet = this.modelCache.entrySet();
        kotlin.jvm.internal.g.e(setEntrySet, "<get-entries>(...)");
        Set<Map.Entry<String, b7.a>> set = setEntrySet;
        ArrayList arrayList = new ArrayList(mb.m.Z(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            arrayList.add(new Pair(entry.getKey(), entry.getValue()));
        }
        this.releaseHandler.post(new androidx.room.o(8, arrayList, this));
        this.modelCache.clear();
        this.modelInfoCache.clear();
        this.lastAccessTime.clear();
        this.lastUsedAtMonoNs.clear();
        this.closingFlags.clear();
        this.refManager.clearAll();
        this.configCache.clear();
        this.backendCache.clear();
        this.preloadedModels.clear();
        this.maxTierByModel.clear();
        return size;
    }

    public Object clearAll(qb.b<? super lb.n> bVar) {
        Log.i(TAG, "Clearing all cached models");
        clear();
        return lb.n.f10413a;
    }

    public final void confirmVersionHealthy(String modelId) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        this.versionRouter.confirmVersionHealthyAsync(modelId);
    }

    @Override // b7.b
    public boolean contains(String modelId) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        return this.modelCache.containsKey(modelId);
    }

    @Override // b7.t
    public void deactivate(String modelId) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        this.versionRouter.deactivate(modelId);
    }

    public final int evict(zb.l<? super b7.r, Boolean> predicate, ReleaseReason reason) {
        Object objA;
        AtomicBoolean atomicBooleanPutIfAbsent;
        kotlin.jvm.internal.g.f(predicate, "predicate");
        kotlin.jvm.internal.g.f(reason, "reason");
        ArrayList arrayList = new ArrayList();
        Enumeration<String> enumerationKeys = this.modelCache.keys();
        kotlin.jvm.internal.g.e(enumerationKeys, "keys(...)");
        ArrayList list = Collections.list(enumerationKeys);
        kotlin.jvm.internal.g.e(list, "list(...)");
        int size = list.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = list.get(i10);
            i10++;
            String str = (String) obj;
            Long l10 = this.lastUsedAtMonoNs.get(str);
            if (l10 != null) {
                long jLongValue = l10.longValue();
                kotlin.jvm.internal.g.c(str);
                arrayList.add(new ReleasableEntry(this, str, jLongValue));
            }
        }
        int size2 = arrayList.size();
        int i11 = 0;
        int i12 = 0;
        while (i12 < size2) {
            Object obj2 = arrayList.get(i12);
            i12++;
            ReleasableEntry releasableEntry = (ReleasableEntry) obj2;
            if (predicate.invoke(releasableEntry).booleanValue()) {
                ConcurrentHashMap<String, AtomicBoolean> concurrentHashMap = this.closingFlags;
                String modelId = releasableEntry.getModelId();
                AtomicBoolean atomicBoolean = concurrentHashMap.get(modelId);
                if (atomicBoolean == null && (atomicBooleanPutIfAbsent = concurrentHashMap.putIfAbsent(modelId, (atomicBoolean = new AtomicBoolean(false)))) != null) {
                    atomicBoolean = atomicBooleanPutIfAbsent;
                }
                if (atomicBoolean.compareAndSet(false, true)) {
                    i11++;
                    Log.i(TAG, "evict: closing modelId=" + releasableEntry.getModelId() + " reason=" + reason);
                    try {
                        objA = remove(releasableEntry.getModelId());
                    } catch (Throwable th) {
                        objA = kotlin.c.a(th);
                    }
                    Throwable thB = Result.b(objA);
                    if (thB != null) {
                        Log.w(TAG, ai.onnxruntime.a.l("evict: remove(", releasableEntry.getModelId(), ") failed: ", thB.getMessage()), thB);
                    }
                }
            }
        }
        return i11;
    }

    @Override // b7.b
    public void evictAllIdle() {
        Enumeration<String> enumerationKeys = this.modelCache.keys();
        kotlin.jvm.internal.g.e(enumerationKeys, "keys(...)");
        ArrayList list = Collections.list(enumerationKeys);
        kotlin.jvm.internal.g.e(list, "list(...)");
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i10 = 0;
        int i11 = 0;
        while (i11 < size) {
            Object obj = list.get(i11);
            i11++;
            String str = (String) obj;
            ModelRefManager modelRefManager = this.refManager;
            kotlin.jvm.internal.g.c(str);
            if (modelRefManager.count(str) <= 0 && !this.keepAliveModelIds.contains(str)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        Log.i(TAG, "evictAllIdle: releasing " + arrayList.size() + " idle models");
        int size2 = arrayList.size();
        while (i10 < size2) {
            Object obj2 = arrayList.get(i10);
            i10++;
            String str2 = (String) obj2;
            kotlin.jvm.internal.g.c(str2);
            remove(str2);
            Log.d(TAG, "evictAllIdle: released ".concat(str2));
        }
    }

    public int evictByMemory(int i10) {
        Object obj;
        String str;
        int i11 = 0;
        while (i11 < i10 && !this.modelCache.isEmpty()) {
            Set<Map.Entry<String, Long>> setEntrySet = this.lastAccessTime.entrySet();
            kotlin.jvm.internal.g.e(setEntrySet, "<get-entries>(...)");
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : setEntrySet) {
                Map.Entry entry = (Map.Entry) obj2;
                ModelRefManager modelRefManager = this.refManager;
                Object key = entry.getKey();
                kotlin.jvm.internal.g.e(key, "<get-key>(...)");
                if (modelRefManager.count((String) key) == 0 && !this.keepAliveModelIds.contains(entry.getKey())) {
                    arrayList.add(obj2);
                }
            }
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                Object next = it.next();
                if (it.hasNext()) {
                    Object value = ((Map.Entry) next).getValue();
                    kotlin.jvm.internal.g.e(value, "<get-value>(...)");
                    long jLongValue = ((Number) value).longValue();
                    do {
                        Object next2 = it.next();
                        Object value2 = ((Map.Entry) next2).getValue();
                        kotlin.jvm.internal.g.e(value2, "<get-value>(...)");
                        long jLongValue2 = ((Number) value2).longValue();
                        if (jLongValue > jLongValue2) {
                            next = next2;
                            jLongValue = jLongValue2;
                        }
                    } while (it.hasNext());
                }
                obj = next;
            } else {
                obj = null;
            }
            Map.Entry entry2 = (Map.Entry) obj;
            if (entry2 == null || (str = (String) entry2.getKey()) == null) {
                break;
            }
            d7.b bVar = this.modelInfoCache.get(str);
            int i12 = bVar != null ? bVar.f8406g : 0;
            remove(str);
            Log.d(TAG, "Evicted LRU model: ".concat(str));
            i11 += i12;
        }
        return i11;
    }

    @Override // b7.b
    public void evictByRetainBudget(int i10) {
        Set<Map.Entry<String, Long>> setEntrySet = this.lastAccessTime.entrySet();
        kotlin.jvm.internal.g.e(setEntrySet, "<get-entries>(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : setEntrySet) {
            Map.Entry entry = (Map.Entry) obj;
            ModelRefManager modelRefManager = this.refManager;
            Object key = entry.getKey();
            kotlin.jvm.internal.g.e(key, "<get-key>(...)");
            if (modelRefManager.count((String) key) <= 0 && !this.keepAliveModelIds.contains(entry.getKey())) {
                arrayList.add(obj);
            }
        }
        for (Object obj2 : kotlin.collections.a.I0(arrayList, new Comparator() { // from class: com.stepos.core.model.manager.ModelCacheImpl$evictByRetainBudget$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t8, T t10) {
                return ob.b.a((Long) ((Map.Entry) t8).getValue(), (Long) ((Map.Entry) t10).getValue());
            }
        })) {
            kotlin.jvm.internal.g.e(obj2, "next(...)");
            Object key2 = ((Map.Entry) obj2).getKey();
            kotlin.jvm.internal.g.e(key2, "component1(...)");
            String str = (String) key2;
            if (getTotalMemoryMb() <= i10) {
                return;
            }
            StringBuilder sbF = h0.e.f("evictByRetainBudget: releasing ", str, " (totalMb=", getTotalMemoryMb(), ", target=");
            sbF.append(i10);
            sbF.append(")");
            Log.i(TAG, sbF.toString());
            remove(str);
        }
    }

    @Override // b7.b
    public b7.a get(String modelId) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        b7.a aVar = this.modelCache.get(modelId);
        if (aVar == null) {
            this.missCount.incrementAndGet();
            return aVar;
        }
        this.hitCount.incrementAndGet();
        this.lastAccessTime.put(modelId, Long.valueOf(System.currentTimeMillis()));
        this.lastUsedAtMonoNs.put(modelId, Long.valueOf(SystemClock.elapsedRealtimeNanos()));
        return aVar;
    }

    @Override // b7.b
    public b7.k getAcquiredConfig(String modelId) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        return this.configCache.get(modelId);
    }

    @Override // b7.b
    public List<d7.b> getAllModelInfo() {
        Collection<d7.b> collectionValues = this.modelInfoCache.values();
        kotlin.jvm.internal.g.e(collectionValues, "<get-values>(...)");
        return kotlin.collections.a.O0(collectionValues);
    }

    @Override // b7.b
    public int getAvailableMemoryMb() {
        return this.currentMemoryLimitMb - getTotalMemoryMb();
    }

    @Override // b7.t
    public int getCurrentVersion(String modelId) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        return this.versionRouter.getCurrentVersion(modelId);
    }

    @Override // b7.b
    public long getHitCount() {
        return this.hitCount.get();
    }

    @Override // b7.b
    public float getHitRate() {
        long j10 = this.missCount.get() + this.hitCount.get();
        if (j10 > 0) {
            return this.hitCount.get() / j10;
        }
        return 0.0f;
    }

    @Override // b7.b
    public List<String> getIdleModelsOlderThan(long j10) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Enumeration<String> enumerationKeys = this.modelCache.keys();
        kotlin.jvm.internal.g.e(enumerationKeys, "keys(...)");
        ArrayList list = Collections.list(enumerationKeys);
        kotlin.jvm.internal.g.e(list, "list(...)");
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = list.get(i10);
            i10++;
            String str = (String) obj;
            ModelRefManager modelRefManager = this.refManager;
            kotlin.jvm.internal.g.c(str);
            boolean z = modelRefManager.count(str) <= 0;
            Long l10 = this.lastAccessTime.get(str);
            long jLongValue = l10 != null ? l10.longValue() : 0L;
            if (z && jCurrentTimeMillis - jLongValue > j10) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final List<b7.r> getLRUSnapshot() {
        AtomicBoolean atomicBoolean;
        Enumeration<String> enumerationKeys = this.modelCache.keys();
        kotlin.jvm.internal.g.e(enumerationKeys, "keys(...)");
        ArrayList list = Collections.list(enumerationKeys);
        kotlin.jvm.internal.g.e(list, "list(...)");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = list.get(i10);
            i10++;
            String str = (String) obj;
            if (!this.keepAliveModelIds.contains(str) && ((atomicBoolean = this.closingFlags.get(str)) == null || !atomicBoolean.get())) {
                Long l10 = this.lastUsedAtMonoNs.get(str);
                if (l10 != null) {
                    long jLongValue = l10.longValue();
                    kotlin.jvm.internal.g.c(str);
                    arrayList.add(new ReleasableEntry(this, str, jLongValue));
                }
            }
        }
        if (arrayList.size() > 1) {
            mb.q.k0(arrayList, new Comparator() { // from class: com.stepos.core.model.manager.ModelCacheImpl$getLRUSnapshot$$inlined$sortBy$1
                @Override // java.util.Comparator
                public final int compare(T t8, T t10) {
                    return ob.b.a(Long.valueOf(((b7.r) t8).getLastUsedAtMonoNs()), Long.valueOf(((b7.r) t10).getLastUsedAtMonoNs()));
                }
            });
        }
        return arrayList;
    }

    public Long getLastInitMs(String modelId) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        return this.initTimeCache.get(modelId);
    }

    @Override // b7.b
    public List<String> getLoadedModels() {
        Enumeration<String> enumerationKeys = this.modelCache.keys();
        kotlin.jvm.internal.g.e(enumerationKeys, "keys(...)");
        ArrayList list = Collections.list(enumerationKeys);
        kotlin.jvm.internal.g.e(list, "list(...)");
        return list;
    }

    public final TaskPriority getMaxTier(String modelId) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        TaskPriority taskPriority = this.maxTierByModel.get(modelId);
        return taskPriority == null ? TaskPriority.h : taskPriority;
    }

    @Override // b7.b
    public long getMissCount() {
        return this.missCount.get();
    }

    public final b7.e getModelLoader() {
        return this.modelLoader;
    }

    @Override // b7.b
    public int getRefCount(String modelId) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        return this.refManager.count(modelId);
    }

    public final Handler getReleaseHandler() {
        return this.releaseHandler;
    }

    @Override // b7.b
    public int getTotalMemoryMb() {
        Collection<d7.b> collectionValues = this.modelInfoCache.values();
        kotlin.jvm.internal.g.e(collectionValues, "<get-values>(...)");
        Iterator<T> it = collectionValues.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            i10 += ((d7.b) it.next()).f8406g;
        }
        return i10;
    }

    public Set<Integer> holderUidsOf(String modelId) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        return this.refManager.holderUidsOf(modelId);
    }

    public boolean isAvailable(String modelId) {
        File[] fileArrListFiles;
        kotlin.jvm.internal.g.f(modelId, "modelId");
        b7.k kVar = this.configCache.get(modelId);
        if (kVar == null) {
            return false;
        }
        String str = kVar.f3091b;
        if (str.length() > 0) {
            File file = new File(str);
            if (!file.exists()) {
                a0.a.A("isAvailable=false: model path not found: ", str, TAG);
                return false;
            }
            if (file.isDirectory() && ((fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length == 0)) {
                a0.a.A("isAvailable=false: model dir is empty: ", str, TAG);
                return false;
            }
        }
        String str2 = kVar.f3092c;
        if (str2 == null || str2.length() == 0) {
            return true;
        }
        File file2 = new File(str2);
        if (file2.exists() && file2.length() != 0) {
            return true;
        }
        a0.a.A("isAvailable=false: config not found or empty: ", str2, TAG);
        return false;
    }

    public boolean isLoaded(String modelId) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        return this.modelCache.containsKey(modelId);
    }

    @Override // b7.b
    public void markPreloaded(String modelId) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        this.preloadedModels.add(modelId);
        Log.d(TAG, "Model marked as preloaded (AFTER_INIT): ".concat(modelId));
    }

    @Override // b7.b
    public void onPreInit(b7.k config) {
        PreInitAction preInitActionDecidePreInit;
        kotlin.jvm.internal.g.f(config, "config");
        String str = config.f3090a;
        d7.a aVar = config.f3097i;
        int i10 = 0;
        int i11 = aVar != null ? aVar.f8393b : 0;
        String str2 = config.f3096g.f6263a;
        try {
            preInitActionDecidePreInit = getOrchestrator().decidePreInit(new ModelMeta(str, i11, modelCategoryFromConfig(config)));
        } catch (Exception e10) {
            a0.a.A("decidePreInit failed: ", e10.getMessage(), TAG);
            preInitActionDecidePreInit = PreInitAction.NoOp.INSTANCE;
        }
        if (!(preInitActionDecidePreInit instanceof PreInitAction.NoOp)) {
            applyOrchestratorPreInit(preInitActionDecidePreInit, str);
            return;
        }
        if (i11 > 3000) {
            Log.i(TAG, ai.onnxruntime.a.i("onPreInit: heavy model ", i11, str, " (", "MB), evicting all idle"));
            evictAllIdle();
            return;
        }
        if (getProcessMemoryMb() > 2048) {
            Log.i(TAG, "onPreInit: high memory pressure, evicting all idle + GC");
            evictAllIdle();
            System.gc();
            return;
        }
        Enumeration<String> enumerationKeys = this.modelCache.keys();
        kotlin.jvm.internal.g.e(enumerationKeys, "keys(...)");
        ArrayList list = Collections.list(enumerationKeys);
        kotlin.jvm.internal.g.e(list, "list(...)");
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i12 = 0;
        while (i12 < size) {
            Object obj = list.get(i12);
            i12++;
            String str3 = (String) obj;
            if (!kotlin.jvm.internal.g.b(str3, str)) {
                ModelRefManager modelRefManager = this.refManager;
                kotlin.jvm.internal.g.c(str3);
                if (modelRefManager.count(str3) <= 0 && !this.keepAliveModelIds.contains(str3) && kotlin.jvm.internal.g.b(this.backendCache.get(str3), str2)) {
                    arrayList.add(obj);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        StringBuilder sbE = h0.e.e("onPreInit: evicting ", arrayList.size(), " idle competitors (backend=", InferenceConfig.a.a(str2), ") for ");
        sbE.append(str);
        Log.i(TAG, sbE.toString());
        int size2 = arrayList.size();
        while (i10 < size2) {
            Object obj2 = arrayList.get(i10);
            i10++;
            String str4 = (String) obj2;
            kotlin.jvm.internal.g.c(str4);
            remove(str4);
        }
    }

    @Override // b7.t
    public void preload(String modelId) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        b7.n nVarAcquire = acquire(modelId);
        try {
            lb.n nVar = lb.n.f10413a;
            xb.a.a(nVarAcquire, null);
        } finally {
        }
    }

    public String put(String modelId, b7.a model, d7.b info) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        kotlin.jvm.internal.g.f(model, "model");
        kotlin.jvm.internal.g.f(info, "info");
        String strEvictLRU = (this.modelCache.size() < this.maxCapacity || this.modelCache.containsKey(modelId)) ? null : evictLRU();
        this.modelCache.put(modelId, model);
        this.modelInfoCache.put(modelId, info);
        this.lastAccessTime.put(modelId, Long.valueOf(System.currentTimeMillis()));
        this.lastUsedAtMonoNs.put(modelId, Long.valueOf(SystemClock.elapsedRealtimeNanos()));
        this.closingFlags.remove(modelId);
        return strEvictLRU;
    }

    public final void recordAcquireTier(String modelId, TaskPriority tier) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        kotlin.jvm.internal.g.f(tier, "tier");
        this.maxTierByModel.merge(modelId, tier, new n(new m(1), 1));
    }

    @Override // b7.b
    public String refReleaseStats(String modelId) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        return this.refManager.releaseStats(modelId);
    }

    @Override // b7.b
    public String refReleaseStatsAll() {
        return this.refManager.releaseStatsAll();
    }

    @Override // b7.b
    public List<String> refSnapshot(String modelId) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        List<ModelRefRecord> listSnapshot = this.refManager.snapshot(modelId);
        ArrayList arrayList = new ArrayList(mb.m.Z(listSnapshot, 10));
        for (ModelRefRecord modelRefRecord : listSnapshot) {
            long acquiredAtNs = (jElapsedRealtimeNanos - modelRefRecord.getAcquiredAtNs()) / 1000000000;
            String refToken = modelRefRecord.getRefToken();
            ModelAcquireSource source = modelRefRecord.getSource();
            int uid = modelRefRecord.getHolder().getUid();
            StringBuilder sb2 = new StringBuilder("token=");
            sb2.append(refToken);
            sb2.append(" src=");
            sb2.append(source);
            sb2.append(" uid=");
            com.stepos.core.ota.d.s(sb2, uid, " age=", acquiredAtNs);
            sb2.append("s");
            arrayList.add(sb2.toString());
        }
        return arrayList;
    }

    public void release(b7.k config) {
        kotlin.jvm.internal.g.f(config, "config");
        releaseByModelId$default(this, config.f3090a, null, null, 6, null);
    }

    @Override // b7.t
    public void releaseHandle(String modelId, int i10, com.stepos.base.model.a instance, String str, ModelReleaseReason reason) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        kotlin.jvm.internal.g.f(instance, "instance");
        kotlin.jvm.internal.g.f(reason, "reason");
        this.versionRouter.releaseHandle(modelId, i10, instance, str, reason);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b7.a remove(String modelId) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        cancelPendingRelease(modelId);
        Pair pairDetachFromCache$default = detachFromCache$default(this, modelId, false, 2, null);
        b7.a aVar = (b7.a) pairDetachFromCache$default.f9985a;
        String str = (String) pairDetachFromCache$default.f9986b;
        if (aVar != null) {
            Log.i(TAG, h0.e.c("Closing model async: ", modelId, " (backend=", str, ")"));
            this.releaseHandler.post(new i(modelId, this, aVar, 0));
        }
        return aVar;
    }

    @Override // b7.t
    public boolean rollback(String modelId, int i10, String reason) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        kotlin.jvm.internal.g.f(reason, "reason");
        return this.versionRouter.rollback(modelId, i10, reason);
    }

    @Override // b7.b
    public void scheduleIdleCheck() {
        Enumeration<String> enumerationKeys = this.modelCache.keys();
        kotlin.jvm.internal.g.e(enumerationKeys, "keys(...)");
        ArrayList list = Collections.list(enumerationKeys);
        kotlin.jvm.internal.g.e(list, "list(...)");
        int i10 = 0;
        if (!list.isEmpty()) {
            int size = list.size();
            int i11 = 0;
            while (i11 < size) {
                Object obj = list.get(i11);
                i11++;
                String str = (String) obj;
                ModelRefManager modelRefManager = this.refManager;
                kotlin.jvm.internal.g.c(str);
                if (modelRefManager.count(str) <= 0 && (i10 = i10 + 1) < 0) {
                    mb.m.e0();
                    throw null;
                }
            }
        }
        Log.d(TAG, "scheduleIdleCheck: " + i10 + " idle models in cache");
    }

    public final void setKeepAlive(String modelId, boolean z) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        ConcurrentHashMap.KeySetView<String, Boolean> keySetView = this.keepAliveModelIds;
        if (z) {
            keySetView.add(modelId);
        } else {
            keySetView.remove(modelId);
        }
        Log.d(TAG, "setKeepAlive: modelId=" + modelId + ", alive=" + z);
    }

    public void setMemoryLimit(int i10) {
        this.currentMemoryLimitMb = i10;
    }

    @Override // b7.b
    public int size() {
        return this.modelCache.size();
    }

    @Override // b7.t
    public List<t.a> snapshot() {
        return this.versionRouter.snapshot();
    }

    public final List<Pair<String, TaskPriority>> snapshotMaxTierByModel() {
        Set<Map.Entry<String, TaskPriority>> setEntrySet = this.maxTierByModel.entrySet();
        kotlin.jvm.internal.g.e(setEntrySet, "<get-entries>(...)");
        Set<Map.Entry<String, TaskPriority>> set = setEntrySet;
        ArrayList arrayList = new ArrayList(mb.m.Z(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            arrayList.add(new Pair(entry.getKey(), entry.getValue()));
        }
        final Comparator comparator = new Comparator() { // from class: com.stepos.core.model.manager.ModelCacheImpl$snapshotMaxTierByModel$$inlined$compareBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t8, T t10) {
                return ob.b.a(Integer.valueOf(((TaskPriority) ((Pair) t8).f9986b).ordinal()), Integer.valueOf(((TaskPriority) ((Pair) t10).f9986b).ordinal()));
            }
        };
        return kotlin.collections.a.I0(arrayList, new Comparator() { // from class: com.stepos.core.model.manager.ModelCacheImpl$snapshotMaxTierByModel$$inlined$thenBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t8, T t10) {
                int iCompare = comparator.compare(t8, t10);
                return iCompare != 0 ? iCompare : ob.b.a((Comparable) ((Pair) t8).f9985a, (Comparable) ((Pair) t10).f9985a);
            }
        });
    }

    @Override // b7.t
    public void switchVersion(String modelId, int i10, String newPath, String installer) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        kotlin.jvm.internal.g.f(newPath, "newPath");
        kotlin.jvm.internal.g.f(installer, "installer");
        this.versionRouter.switchVersion(modelId, i10, newPath, installer);
    }

    public void touch(String modelId) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        if (this.modelCache.containsKey(modelId)) {
            this.lastAccessTime.put(modelId, Long.valueOf(System.currentTimeMillis()));
            this.lastUsedAtMonoNs.put(modelId, Long.valueOf(SystemClock.elapsedRealtimeNanos()));
        }
    }

    public /* synthetic */ ModelCacheImpl(Context context, b7.f fVar, b7.c cVar, b7.e eVar, int i10, int i11, long j10, int i12, kotlin.jvm.internal.e eVar2) {
        this(context, fVar, (i12 & 4) != 0 ? new AIModelFactory() : cVar, (i12 & 8) != 0 ? new ModelLoaderImpl() : eVar, (i12 & 16) != 0 ? 3 : i10, (i12 & 32) != 0 ? 2048 : i11, (i12 & 64) != 0 ? 30000L : j10);
    }

    @Override // b7.t
    public b7.n acquire(String modelId) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        return this.versionRouter.acquire(modelId);
    }

    public final b7.n acquire(String modelId, boolean z) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        this.versionRouter.getCurrentAcquireForeground().set(Boolean.valueOf(z));
        try {
            return this.versionRouter.acquire(modelId);
        } finally {
            this.versionRouter.getCurrentAcquireForeground().remove();
        }
    }
}
