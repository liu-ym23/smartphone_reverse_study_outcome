package com.stepos.core.ability;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.UserHandle;
import android.util.Log;
import androidx.datastore.preferences.protobuf.b1;
import b7.j;
import b7.k;
import b7.s;
import com.stepos.base.model.ModelReleaseReason;
import com.stepos.core.ability.config.AbilityConfigLoader;
import com.stepos.core.ability.config.AbilityParams;
import com.stepos.core.ability.config.cloud.AbilityConfigDiff;
import com.stepos.core.ability.factory.AbilityFactory;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.storage.ModelPathStore;
import com.stepos.core.deepbinder.IModelChangeListener;
import com.stepos.core.model.manager.ModelCacheImpl;
import com.stepos.core.model.manager.ModelRegistryImpl;
import com.stepos.core.ota.OtaEngine;
import com.stepos.deepbinder.core.api.IRecycle;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Pair;
import kotlin.Result;
import kotlin.collections.EmptyList;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import lb.n;
import mb.m;
import mb.v;
import zb.l;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes.dex */
public final class AbilityManager {
    private static final long CLOUD_APPLY_WAIT_BUDGET_MS = 300000;
    private static final String TAG = "AbilityManager";
    private static Context context;
    private static ModelCacheImpl modelCacheImpl;
    private static b7.f modelRegistry;
    public static final AbilityManager INSTANCE = new AbilityManager();
    private static final ConcurrentHashMap<String, p6.a> abilitiesConfig = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, AbilityBinderImpl> abilitiesBinder = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, String> abilityIdToToken = new ConcurrentHashMap<>();
    private static final AtomicLong totalObtained = new AtomicLong(0);
    private static final AtomicLong totalReleased = new AtomicLong(0);
    private static final AtomicInteger peakHolders = new AtomicInteger(0);
    private static final ConcurrentHashMap<Integer, ClientUidSession> uidSessions = new ConcurrentHashMap<>();
    private static final CoroutineScope leakMonitorScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    private static final ConcurrentHashMap<String, AbilityParams> abilityParams = new ConcurrentHashMap<>();
    private static volatile String currentAbilitiesJson = "[]";
    private static volatile List<String> lastCloudApply = EmptyList.f10001a;
    private static final AtomicLong cloudApplyGeneration = new AtomicLong(0);
    private static final ConcurrentHashMap<String, ConcurrentHashMap<String, String>> abilityProperties = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<IRecycle, Pair<String, Integer>> activeDeepBinderImpls = new ConcurrentHashMap<>();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class ActiveInstanceInfo {
        private final String abilityId;
        private final int callerUid;
        private final int svcHashCode;

        public ActiveInstanceInfo(String abilityId, int i10, int i11) {
            kotlin.jvm.internal.g.f(abilityId, "abilityId");
            this.abilityId = abilityId;
            this.callerUid = i10;
            this.svcHashCode = i11;
        }

        public static /* synthetic */ ActiveInstanceInfo copy$default(ActiveInstanceInfo activeInstanceInfo, String str, int i10, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                str = activeInstanceInfo.abilityId;
            }
            if ((i12 & 2) != 0) {
                i10 = activeInstanceInfo.callerUid;
            }
            if ((i12 & 4) != 0) {
                i11 = activeInstanceInfo.svcHashCode;
            }
            return activeInstanceInfo.copy(str, i10, i11);
        }

        public final String component1() {
            return this.abilityId;
        }

        public final int component2() {
            return this.callerUid;
        }

        public final int component3() {
            return this.svcHashCode;
        }

        public final ActiveInstanceInfo copy(String abilityId, int i10, int i11) {
            kotlin.jvm.internal.g.f(abilityId, "abilityId");
            return new ActiveInstanceInfo(abilityId, i10, i11);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ActiveInstanceInfo)) {
                return false;
            }
            ActiveInstanceInfo activeInstanceInfo = (ActiveInstanceInfo) obj;
            return kotlin.jvm.internal.g.b(this.abilityId, activeInstanceInfo.abilityId) && this.callerUid == activeInstanceInfo.callerUid && this.svcHashCode == activeInstanceInfo.svcHashCode;
        }

        public final String getAbilityId() {
            return this.abilityId;
        }

        public final int getCallerUid() {
            return this.callerUid;
        }

        public final int getSvcHashCode() {
            return this.svcHashCode;
        }

        public int hashCode() {
            return Integer.hashCode(this.svcHashCode) + ai.onnxruntime.a.d(this.callerUid, this.abilityId.hashCode() * 31, 31);
        }

        public String toString() {
            return ai.onnxruntime.a.j(")", this.svcHashCode, h0.e.f("ActiveInstanceInfo(abilityId=", this.abilityId, ", callerUid=", this.callerUid, ", svcHashCode="));
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Counters {
        private final int currentHolders;
        private final long obtained;
        private final int peakHolders;
        private final long released;

        public Counters(long j10, long j11, int i10, int i11) {
            this.obtained = j10;
            this.released = j11;
            this.peakHolders = i10;
            this.currentHolders = i11;
        }

        public static /* synthetic */ Counters copy$default(Counters counters, long j10, long j11, int i10, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                j10 = counters.obtained;
            }
            long j12 = j10;
            if ((i12 & 2) != 0) {
                j11 = counters.released;
            }
            long j13 = j11;
            if ((i12 & 4) != 0) {
                i10 = counters.peakHolders;
            }
            int i13 = i10;
            if ((i12 & 8) != 0) {
                i11 = counters.currentHolders;
            }
            return counters.copy(j12, j13, i13, i11);
        }

        public final long component1() {
            return this.obtained;
        }

        public final long component2() {
            return this.released;
        }

        public final int component3() {
            return this.peakHolders;
        }

        public final int component4() {
            return this.currentHolders;
        }

        public final Counters copy(long j10, long j11, int i10, int i11) {
            return new Counters(j10, j11, i10, i11);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Counters)) {
                return false;
            }
            Counters counters = (Counters) obj;
            return this.obtained == counters.obtained && this.released == counters.released && this.peakHolders == counters.peakHolders && this.currentHolders == counters.currentHolders;
        }

        public final int getCurrentHolders() {
            return this.currentHolders;
        }

        public final long getObtained() {
            return this.obtained;
        }

        public final int getPeakHolders() {
            return this.peakHolders;
        }

        public final long getReleased() {
            return this.released;
        }

        public int hashCode() {
            return Integer.hashCode(this.currentHolders) + ai.onnxruntime.a.d(this.peakHolders, a0.a.c(Long.hashCode(this.obtained) * 31, this.released, 31), 31);
        }

        public String toString() {
            long j10 = this.obtained;
            long j11 = this.released;
            int i10 = this.peakHolders;
            int i11 = this.currentHolders;
            StringBuilder sbQ = ai.onnxruntime.a.q(j10, "Counters(obtained=", ", released=");
            sbQ.append(j11);
            sbQ.append(", peakHolders=");
            sbQ.append(i10);
            sbQ.append(", currentHolders=");
            sbQ.append(i11);
            sbQ.append(")");
            return sbQ.toString();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class LeaseDeathHandler {
        public static final LeaseDeathHandler INSTANCE = new LeaseDeathHandler();

        private LeaseDeathHandler() {
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x005f A[Catch: all -> 0x0065, TRY_LEAVE, TryCatch #1 {all -> 0x0065, blocks: (B:22:0x005b, B:24:0x005f), top: B:39:0x005b }] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0074  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void onClientDied(java.lang.String r7, int r8, int r9, boolean r10) {
            /*
                r6 = this;
                java.lang.String r6 = "token"
                kotlin.jvm.internal.g.f(r7, r6)
                com.stepos.core.ability.AbilityManager r0 = com.stepos.core.ability.AbilityManager.INSTANCE     // Catch: java.lang.Throwable -> L16
                com.stepos.base.model.ModelReleaseReason r3 = com.stepos.base.model.ModelReleaseReason.f6322c     // Catch: java.lang.Throwable -> L16
                r4 = 2
                r5 = 0
                r2 = 0
                r1 = r7
                com.stepos.core.ability.AbilityManager.releaseAbility$default(r0, r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L13
                lb.n r6 = lb.n.f10413a     // Catch: java.lang.Throwable -> L13
                goto L1d
            L13:
                r0 = move-exception
            L14:
                r6 = r0
                goto L19
            L16:
                r0 = move-exception
                r1 = r7
                goto L14
            L19:
                kotlin.Result$Failure r6 = kotlin.c.a(r6)
            L1d:
                java.lang.Throwable r6 = kotlin.Result.b(r6)
                java.lang.String r7 = "AbilityManager"
                if (r6 == 0) goto L36
                com.stepos.core.common.log.LogModule r0 = com.stepos.core.common.log.LogModule.ABILITY
                java.lang.String r6 = r6.getMessage()
                java.lang.String r2 = "releaseAbility("
                java.lang.String r3 = ") failed in DeathRecipient: "
                java.lang.String r6 = ai.onnxruntime.a.l(r2, r1, r3, r6)
                com.stepos.core.common.log.AIEngineLogger.w(r0, r7, r6)
            L36:
                z6.b.a(r8, r9)     // Catch: java.lang.Throwable -> L3c
                lb.n r6 = lb.n.f10413a     // Catch: java.lang.Throwable -> L3c
                goto L42
            L3c:
                r0 = move-exception
                r6 = r0
                kotlin.Result$Failure r6 = kotlin.c.a(r6)
            L42:
                java.lang.Throwable r6 = kotlin.Result.b(r6)
                if (r6 == 0) goto L5b
                com.stepos.core.common.log.LogModule r0 = com.stepos.core.common.log.LogModule.ABILITY
                java.lang.String r6 = r6.getMessage()
                java.lang.String r1 = ","
                java.lang.String r2 = ") failed: "
                java.lang.String r3 = "closeAllForUid("
                java.lang.StringBuilder r1 = h0.e.d(r8, r3, r9, r1, r2)
                a0.a.x(r1, r6, r0, r7)
            L5b:
                com.stepos.core.model.manager.ModelCacheImpl r6 = b7.j.f3087b     // Catch: java.lang.Throwable -> L65
                if (r6 == 0) goto L68
                r6.scheduleIdleCheck()     // Catch: java.lang.Throwable -> L65
                lb.n r6 = lb.n.f10413a     // Catch: java.lang.Throwable -> L65
                goto L6e
            L65:
                r0 = move-exception
                r6 = r0
                goto L6a
            L68:
                r6 = 0
                goto L6e
            L6a:
                kotlin.Result$Failure r6 = kotlin.c.a(r6)
            L6e:
                java.lang.Throwable r6 = kotlin.Result.b(r6)
                if (r6 == 0) goto L7f
                com.stepos.core.common.log.LogModule r0 = com.stepos.core.common.log.LogModule.ABILITY
                java.lang.String r6 = r6.getMessage()
                java.lang.String r1 = "scheduleIdleCheck failed: "
                ai.onnxruntime.a.w(r1, r6, r0, r7)
            L7f:
                if (r10 == 0) goto L92
                if (r8 <= 0) goto L92
                com.stepos.core.common.log.LogModule r6 = com.stepos.core.common.log.LogModule.ABILITY
                java.lang.String r10 = " (user="
                java.lang.String r0 = ") fully cleaned up (all PIDs dead)"
                java.lang.String r1 = "UID "
                java.lang.String r8 = com.stepos.core.ota.d.e(r8, r1, r9, r10, r0)
                com.stepos.core.common.log.AIEngineLogger.i(r6, r7, r8)
            L92:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.AbilityManager.LeaseDeathHandler.onClientDied(java.lang.String, int, int, boolean):void");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.AbilityManager$applyCloudConfig$1", f = "AbilityManager.kt", l = {936}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.AbilityManager$applyCloudConfig$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        final /* synthetic */ long $myGen;
        final /* synthetic */ String $newJson;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, long j10, qb.b<? super AnonymousClass1> bVar) {
            super(2, bVar);
            this.$newJson = str;
            this.$myGen = j10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$newJson, this.$myGen, bVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0077  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x011e  */
        /* JADX WARN: Type inference failed for: r4v16, types: [T, java.lang.AutoCloseable] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0115 -> B:31:0x0118). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x011c -> B:31:0x0118). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) {
            /*
                Method dump skipped, instructions count: 508
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.AbilityManager.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((AnonymousClass1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.AbilityManager$startLeakMonitor$1", f = "AbilityManager.kt", l = {605}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.AbilityManager$startLeakMonitor$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02941 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public C02941(qb.b<? super C02941> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            C02941 c02941 = new C02941(bVar);
            c02941.L$0 = obj;
            return c02941;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0071  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0032 -> B:14:0x0035). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                int r1 = r8.label
                r2 = 1
                if (r1 == 0) goto L19
                if (r1 != r2) goto L11
                java.lang.Object r1 = r8.L$0
                kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                kotlin.c.b(r9)
                goto L35
            L11:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L19:
                kotlin.c.b(r9)
                java.lang.Object r9 = r8.L$0
                kotlinx.coroutines.CoroutineScope r9 = (kotlinx.coroutines.CoroutineScope) r9
                r1 = r9
            L21:
                boolean r9 = kotlinx.coroutines.CoroutineScopeKt.isActive(r1)
                if (r9 == 0) goto L71
                r8.L$0 = r1
                r8.label = r2
                r3 = 120000(0x1d4c0, double:5.9288E-319)
                java.lang.Object r9 = kotlinx.coroutines.DelayKt.delay(r3, r8)
                if (r9 != r0) goto L35
                return r0
            L35:
                com.stepos.core.ability.AbilityManager r9 = com.stepos.core.ability.AbilityManager.INSTANCE
                com.stepos.core.ability.AbilityManager.access$cleanupStaleBinders(r9)
                com.stepos.core.model.manager.ModelCacheImpl r9 = b7.j.f3087b
                if (r9 != 0) goto L3f
                goto L21
            L3f:
                r3 = 300000(0x493e0, double:1.482197E-318)
                java.util.List r3 = r9.getIdleModelsOlderThan(r3)
                boolean r4 = r3.isEmpty()
                if (r4 != 0) goto L21
                com.stepos.core.common.log.LogModule r4 = com.stepos.core.common.log.LogModule.ABILITY
                int r5 = r3.size()
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                java.lang.String r7 = "[LeakMonitor] Found "
                r6.<init>(r7)
                r6.append(r5)
                java.lang.String r5 = " leaked models: "
                r6.append(r5)
                r6.append(r3)
                java.lang.String r3 = r6.toString()
                java.lang.String r5 = "AbilityManager"
                com.stepos.core.common.log.AIEngineLogger.w(r4, r5, r3)
                r9.evictAllIdle()
                goto L21
            L71:
                lb.n r8 = lb.n.f10413a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.AbilityManager.C02941.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((C02941) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    private AbilityManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<String> applyAbortSummary(String str, String str2, int i10) {
        String strFmtApplyWall = fmtApplyWall();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        StringBuilder sbS = ai.onnxruntime.a.s("生效状态: ", str, "  at=", strFmtApplyWall, "  monoMs=");
        sbS.append(jElapsedRealtime);
        sbS.append("  jsonLen=");
        sbS.append(i10);
        return m.b0(sbS.toString(), ai.onnxruntime.a.k("  ", str2), "  磁盘已是新配置、内存仍是旧配置，下次冷启动生效");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyDiffLocked(String str) {
        Object objA;
        Object objA2;
        String str2 = currentAbilitiesJson;
        AbilityConfigDiff.Result resultCompute = AbilityConfigDiff.INSTANCE.compute(str2, str);
        if (resultCompute.getAddedIds().isEmpty() && resultCompute.getRemovedIds().isEmpty() && resultCompute.getChangedIds().isEmpty()) {
            currentAbilitiesJson = str;
            lastCloudApply = buildApplySummary("APPLIED(no-change)", resultCompute, str2, str);
            return;
        }
        List<p6.a> abilities = AbilityConfigLoader.INSTANCE.parseAbilities(str);
        int iA0 = v.a0(m.Z(abilities, 10));
        if (iA0 < 16) {
            iA0 = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iA0);
        for (Object obj : abilities) {
            linkedHashMap.put(((p6.a) obj).f11416a, obj);
        }
        for (String str3 : resultCompute.getRemovedIds()) {
            try {
                objA2 = Boolean.valueOf(INSTANCE.unregister(str3));
            } catch (Throwable th) {
                objA2 = kotlin.c.a(th);
            }
            Throwable thB = Result.b(objA2);
            if (thB != null) {
                AIEngineLogger.w(LogModule.ABILITY, TAG, ai.onnxruntime.a.l("remove ", str3, " failed: ", thB.getMessage()));
            }
        }
        ArrayList arrayListD0 = kotlin.collections.a.D0(resultCompute.getAddedIds(), resultCompute.getChangedIds());
        int size = arrayListD0.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj2 = arrayListD0.get(i10);
            i10++;
            String str4 = (String) obj2;
            p6.a aVar = (p6.a) linkedHashMap.get(str4);
            if (aVar != null) {
                if (resultCompute.getChangedIds().contains(str4)) {
                    try {
                        INSTANCE.unregister(str4);
                    } catch (Throwable th2) {
                        kotlin.c.a(th2);
                    }
                }
                try {
                    objA = INSTANCE.register(aVar);
                } catch (Throwable th3) {
                    objA = kotlin.c.a(th3);
                }
                Throwable thB2 = Result.b(objA);
                if (thB2 != null) {
                    AIEngineLogger.w(LogModule.ABILITY, TAG, ai.onnxruntime.a.l("register ", str4, " failed: ", thB2.getMessage()));
                }
            }
        }
        Map<String, AbilityParams> params = AbilityConfigLoader.INSTANCE.parseParams(str);
        ConcurrentHashMap<String, AbilityParams> concurrentHashMap = abilityParams;
        concurrentHashMap.clear();
        concurrentHashMap.putAll(params);
        currentAbilitiesJson = str;
        LogModule logModule = LogModule.ABILITY;
        int size2 = resultCompute.getAddedIds().size();
        int size3 = resultCompute.getRemovedIds().size();
        int size4 = resultCompute.getChangedIds().size();
        StringBuilder sbD = h0.e.d(size2, "applyCloudConfig done: +", size3, " -", " ~");
        sbD.append(size4);
        AIEngineLogger.i(logModule, TAG, sbD.toString());
        lastCloudApply = buildApplySummary("APPLIED", resultCompute, str2, str);
    }

    private final List<String> buildApplySummary(String str, AbilityConfigDiff.Result result, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        String strFmtApplyWall = fmtApplyWall();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int length = str3.length();
        StringBuilder sbS = ai.onnxruntime.a.s("生效状态: ", str, "  at=", strFmtApplyWall, "  monoMs=");
        sbS.append(jElapsedRealtime);
        sbS.append("  jsonLen=");
        sbS.append(length);
        arrayList.add(sbS.toString());
        Iterator<T> it = result.getAddedIds().iterator();
        while (it.hasNext()) {
            arrayList.add("  + 新增  " + ((String) it.next()));
        }
        Iterator<T> it2 = result.getRemovedIds().iterator();
        while (it2.hasNext()) {
            arrayList.add("  - 移除  " + ((String) it2.next()));
        }
        if (!result.getChangedIds().isEmpty()) {
            AbilityConfigDiff.FieldDiffer fieldDiffer = AbilityConfigDiff.INSTANCE.fieldDiffer(str2, str3);
            for (String str4 : result.getChangedIds()) {
                arrayList.add("  ~ 修改  " + str4);
                Iterator<T> it3 = fieldDiffer.diff(str4).iterator();
                while (it3.hasNext()) {
                    arrayList.add("        " + ((String) it3.next()));
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cleanupStaleBinders() {
        Iterator<Map.Entry<String, AbilityBinderImpl>> it = abilitiesBinder.entrySet().iterator();
        int i10 = 0;
        while (it.hasNext()) {
            Map.Entry<String, AbilityBinderImpl> next = it.next();
            kotlin.jvm.internal.g.e(next, "next(...)");
            Map.Entry<String, AbilityBinderImpl> entry = next;
            String key = entry.getKey();
            kotlin.jvm.internal.g.e(key, "component1(...)");
            String str = key;
            AbilityBinderImpl value = entry.getValue();
            kotlin.jvm.internal.g.e(value, "component2(...)");
            AbilityBinderImpl abilityBinderImpl = value;
            int callerPid = abilityBinderImpl.getCallerPid();
            if (callerPid > 0 && !isProcessAlive(callerPid)) {
                AIEngineLogger.w(LogModule.ABILITY, TAG, "Detected dead client process: pid=" + callerPid + ", token=" + str + ", releasing");
                AbilityBinderImpl.releaseBinder$default(abilityBinderImpl, true, false, ModelReleaseReason.f6322c, 2, null);
                it.remove();
                i10++;
            }
        }
        if (i10 > 0) {
            AIEngineLogger.i(LogModule.ABILITY, TAG, "Cleaned up " + i10 + " stale ability binder(s)");
        }
    }

    private final String fmtApplyWall() {
        String str = new SimpleDateFormat("MM-dd HH:mm:ss", Locale.US).format(new Date(System.currentTimeMillis()));
        kotlin.jvm.internal.g.e(str, "format(...)");
        return str;
    }

    private static final boolean forceRecycleByAbility$lambda$16(String str, Ref$IntRef ref$IntRef, Map.Entry entry) {
        kotlin.jvm.internal.g.f(entry, "<destruct>");
        Object key = entry.getKey();
        kotlin.jvm.internal.g.e(key, "component1(...)");
        IRecycle iRecycle = (IRecycle) key;
        Object value = entry.getValue();
        kotlin.jvm.internal.g.e(value, "component2(...)");
        if (!kotlin.jvm.internal.g.b(((Pair) value).f9985a, str)) {
            return false;
        }
        try {
            iRecycle.onRecycle();
            n nVar = n.f10413a;
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
        ref$IntRef.f10074a++;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final boolean forceRecycleByUid$lambda$18(int i10, Ref$IntRef ref$IntRef, Map.Entry entry) {
        kotlin.jvm.internal.g.f(entry, "<destruct>");
        Object key = entry.getKey();
        kotlin.jvm.internal.g.e(key, "component1(...)");
        IRecycle iRecycle = (IRecycle) key;
        Object value = entry.getValue();
        kotlin.jvm.internal.g.e(value, "component2(...)");
        if (((Number) ((Pair) value).f9986b).intValue() != i10) {
            return false;
        }
        try {
            iRecycle.onRecycle();
            n nVar = n.f10413a;
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
        ref$IntRef.f10074a++;
        return true;
    }

    private final p6.d<?, ?> getAbility(String str) {
        p6.a aVar = abilitiesConfig.get(str);
        if (aVar != null) {
            return AbilityFactory.INSTANCE.createAbility(aVar);
        }
        throw new IllegalArgumentException(ai.onnxruntime.a.k("Ability not registered: ", str));
    }

    public static /* synthetic */ Object getAbilityAsBinder$default(AbilityManager abilityManager, String str, int i10, int i11, qb.b bVar, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = 0;
        }
        return abilityManager.getAbilityAsBinder(str, i10, i11, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void getAbilityAsBinder$lambda$36(java.lang.String r4, int r5, int r6, int r7) {
        /*
            com.stepos.core.common.log.LogModule r0 = com.stepos.core.common.log.LogModule.ABILITY
            java.lang.String r1 = " pid="
            java.lang.String r2 = " uid="
            java.lang.String r3 = "Client died: token="
            java.lang.StringBuilder r1 = h0.e.f(r3, r4, r1, r5, r2)
            r1.append(r6)
            java.lang.String r2 = " userId="
            r1.append(r2)
            r1.append(r7)
            java.lang.String r2 = ", releasing immediately"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "AbilityManager"
            com.stepos.core.common.log.AIEngineLogger.w(r0, r2, r1)
            if (r6 <= 0) goto L57
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.stepos.core.ability.ClientUidSession> r0 = com.stepos.core.ability.AbilityManager.uidSessions
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)
            java.lang.Object r1 = r0.get(r1)
            com.stepos.core.ability.ClientUidSession r1 = (com.stepos.core.ability.ClientUidSession) r1
            if (r1 == 0) goto L42
            java.util.Set r2 = r1.getPids()
            if (r2 == 0) goto L42
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r2.remove(r5)
        L42:
            if (r1 == 0) goto L57
            java.util.Set r5 = r1.getPids()
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L57
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)
            r0.remove(r5)
            r5 = 1
            goto L58
        L57:
            r5 = 0
        L58:
            com.stepos.core.ability.AbilityManager$LeaseDeathHandler r0 = com.stepos.core.ability.AbilityManager.LeaseDeathHandler.INSTANCE
            r0.onClientDied(r4, r6, r7, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.AbilityManager.getAbilityAsBinder$lambda$36(java.lang.String, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getBinderByCallerAndAbility$lambda$31$lambda$30(int i10) {
        return Math.max(i10, abilitiesBinder.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List initialize$lambda$22(String modelId) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        Collection<p6.a> collectionValues = abilitiesConfig.values();
        kotlin.jvm.internal.g.e(collectionValues, "<get-values>(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            List<k> list = ((p6.a) obj).f11419d;
            if (list == null || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (kotlin.jvm.internal.g.b(((k) it.next()).f3090a, modelId)) {
                        arrayList.add(obj);
                        break;
                    }
                }
            }
        }
        ArrayList arrayList2 = new ArrayList(m.Z(arrayList, 10));
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj2 = arrayList.get(i10);
            i10++;
            arrayList2.add(((p6.a) obj2).f11416a);
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initialize$lambda$26(String algorithmId, String newPath) {
        List<k> list;
        kotlin.jvm.internal.g.f(algorithmId, "algorithmId");
        kotlin.jvm.internal.g.f(newPath, "newPath");
        AIEngineLogger.i(LogModule.ABILITY, TAG, h0.e.c("OTA path change observed: abilityId=", algorithmId, ", newPath=", newPath, " (sandbox routing handled by VersionedModelCache.switchVersion)"));
        Collection<p6.a> collectionValues = abilitiesConfig.values();
        kotlin.jvm.internal.g.e(collectionValues, "<get-values>(...)");
        Collection<p6.a> collection = collectionValues;
        if (collection.isEmpty()) {
            return;
        }
        for (p6.a aVar : collection) {
            if (aVar.f11422g && ((list = aVar.f11419d) == null || !list.isEmpty())) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (kotlin.jvm.internal.g.b(((k) it.next()).f3090a, algorithmId)) {
                        BuildersKt__Builders_commonKt.launch$default(leakMonitorScope, null, null, new AbilityManager$initialize$3$1(algorithmId, null), 3, null);
                        return;
                    }
                }
            }
        }
    }

    private final boolean isProcessAlive(int i10) {
        try {
            return new File("/proc/" + i10).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void preheatResidentAbilities$default(AbilityManager abilityManager, l lVar, l lVar2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            lVar = null;
        }
        if ((i10 & 2) != 0) {
            lVar2 = null;
        }
        abilityManager.preheatResidentAbilities(lVar, lVar2);
    }

    public static /* synthetic */ void releaseAbility$default(AbilityManager abilityManager, String str, boolean z, ModelReleaseReason modelReleaseReason, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z = false;
        }
        if ((i10 & 4) != 0) {
            modelReleaseReason = ModelReleaseReason.f6321b;
        }
        abilityManager.releaseAbility(str, z, modelReleaseReason);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean releaseAbility$lambda$37(String str, Map.Entry it) {
        kotlin.jvm.internal.g.f(it, "it");
        return kotlin.jvm.internal.g.b(it.getValue(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean releaseAbility$lambda$38(l lVar, Object obj) {
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConcurrentHashMap setAbilityProperty$lambda$48(String it) {
        kotlin.jvm.internal.g.f(it, "it");
        return new ConcurrentHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConcurrentHashMap setAbilityProperty$lambda$49(l lVar, Object obj) {
        return (ConcurrentHashMap) lVar.invoke(obj);
    }

    private final void startLeakMonitor() {
        BuildersKt__Builders_commonKt.launch$default(leakMonitorScope, null, null, new C02941(null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void startResidentPreheat$default(AbilityManager abilityManager, l lVar, l lVar2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            lVar = null;
        }
        if ((i10 & 2) != 0) {
            lVar2 = null;
        }
        abilityManager.startResidentPreheat(lVar, lVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startResidentPreheat$lambda$63(l lVar, l lVar2) {
        Object objA;
        try {
            INSTANCE.preheatResidentAbilities(lVar, lVar2);
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            ai.onnxruntime.a.w("preheatResidentAbilities failed (non-fatal): ", thB.getMessage(), LogModule.ABILITY, TAG);
        }
    }

    public final void applyCloudConfig(byte[] bytes) {
        kotlin.jvm.internal.g.f(bytes, "bytes");
        BuildersKt__Builders_commonKt.launch$default(leakMonitorScope, null, null, new AnonymousClass1(new String(bytes, gc.a.f9106b), cloudApplyGeneration.incrementAndGet(), null), 3, null);
    }

    public final Boolean checkModelFilesExist(String abilityId) {
        String strWireSharedRuntime$lambda$11;
        kotlin.jvm.internal.g.f(abilityId, "abilityId");
        p6.a aVar = abilitiesConfig.get(abilityId);
        if (aVar == null) {
            return null;
        }
        List<k> list = aVar.f11419d;
        if (list == null || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (!((k) it.next()).f3098j) {
                    com.stepos.core.ota.d dVar = jd.b.f9768a;
                    List<k> list2 = aVar.f11419d;
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : list2) {
                        if (!((k) obj).f3098j) {
                            arrayList.add(obj);
                        }
                    }
                    boolean z = true;
                    if (!arrayList.isEmpty()) {
                        int size = arrayList.size();
                        int i10 = 0;
                        loop2: while (i10 < size) {
                            Object obj2 = arrayList.get(i10);
                            i10++;
                            k kVar = (k) obj2;
                            if (dVar == null || (strWireSharedRuntime$lambda$11 = OtaEngine.wireSharedRuntime$lambda$11(abilityId, kVar.f3091b)) == null) {
                                strWireSharedRuntime$lambda$11 = kVar.f3091b;
                            }
                            List<File> listC = b7.m.c(new File(strWireSharedRuntime$lambda$11));
                            if (!listC.isEmpty()) {
                                if (!listC.isEmpty()) {
                                    for (File file : listC) {
                                        if (file.length() <= 0 || !file.canRead()) {
                                        }
                                    }
                                }
                            }
                            z = false;
                            break;
                        }
                    }
                    return Boolean.valueOf(z);
                }
            }
        }
        return Boolean.TRUE;
    }

    public final boolean containsAbility(String id2) {
        kotlin.jvm.internal.g.f(id2, "id");
        return abilitiesConfig.containsKey(id2);
    }

    public final List<String> dumpCloudConfig() {
        String strA = ai.onnxruntime.providers.a.a(currentAbilitiesJson.length(), "currentAbilitiesJsonLen=");
        List<String> list = lastCloudApply;
        if (!list.isEmpty()) {
            return kotlin.collections.a.D0(b1.P(strA), list);
        }
        return b1.P("生效状态: NEVER_APPLIED  " + strA);
    }

    public final List<p6.a> findAbilityConfigsByModelId(String modelId) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        Collection<p6.a> collectionValues = abilitiesConfig.values();
        kotlin.jvm.internal.g.e(collectionValues, "<get-values>(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            List<k> list = ((p6.a) obj).f11419d;
            if (list == null || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (kotlin.jvm.internal.g.b(((k) it.next()).f3090a, modelId)) {
                        arrayList.add(obj);
                        break;
                    }
                }
            }
        }
        return arrayList;
    }

    public final List<p6.a> findAbilityConfigsByType(String type) {
        kotlin.jvm.internal.g.f(type, "type");
        Collection<p6.a> collectionValues = abilitiesConfig.values();
        kotlin.jvm.internal.g.e(collectionValues, "<get-values>(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (kotlin.jvm.internal.g.b(((p6.a) obj).f11417b.f11434a, type)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final int forceRecycleAll() {
        Object objA;
        Set<IRecycle> setKeySet = activeDeepBinderImpls.keySet();
        kotlin.jvm.internal.g.e(setKeySet, "<get-keys>(...)");
        List listO0 = kotlin.collections.a.O0(setKeySet);
        Iterator it = listO0.iterator();
        while (it.hasNext()) {
            try {
                ((IRecycle) it.next()).onRecycle();
                objA = n.f10413a;
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                AIEngineLogger.e(LogModule.ABILITY, TAG, "forceRecycleAll: onRecycle failed", thB);
            }
        }
        activeDeepBinderImpls.clear();
        AIEngineLogger.i(LogModule.ABILITY, TAG, "forceRecycleAll: recycled " + listO0.size() + " instances");
        return listO0.size();
    }

    public final int forceRecycleByAbility(String abilityId) {
        kotlin.jvm.internal.g.f(abilityId, "abilityId");
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        Set<Map.Entry<IRecycle, Pair<String, Integer>>> setEntrySet = activeDeepBinderImpls.entrySet();
        kotlin.jvm.internal.g.e(setEntrySet, "<get-entries>(...)");
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            if (forceRecycleByAbility$lambda$16(abilityId, ref$IntRef, (Map.Entry) it.next())) {
                it.remove();
            }
        }
        int i10 = ref$IntRef.f10074a;
        if (i10 > 0) {
            AIEngineLogger.i(LogModule.ABILITY, TAG, ai.onnxruntime.a.i("forceRecycleByAbility(", i10, abilityId, "): recycled ", " instances"));
        }
        return ref$IntRef.f10074a;
    }

    public final int forceRecycleByUid(int i10) {
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        Set<Map.Entry<IRecycle, Pair<String, Integer>>> setEntrySet = activeDeepBinderImpls.entrySet();
        kotlin.jvm.internal.g.e(setEntrySet, "<get-entries>(...)");
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            if (forceRecycleByUid$lambda$18(i10, ref$IntRef, (Map.Entry) it.next())) {
                it.remove();
            }
        }
        int i11 = ref$IntRef.f10074a;
        if (i11 > 0) {
            AIEngineLogger.i(LogModule.ABILITY, TAG, com.stepos.core.ota.d.e(i10, "forceRecycleByUid(", i11, "): recycled ", " instances"));
        }
        return ref$IntRef.f10074a;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.stepos.core.ability.AbilityInfo> getAbilities() {
        /*
            r17 = this;
            java.util.concurrent.ConcurrentHashMap<java.lang.String, p6.a> r0 = com.stepos.core.ability.AbilityManager.abilitiesConfig
            java.util.Collection r0 = r0.values()
            java.lang.String r1 = "<get-values>(...)"
            kotlin.jvm.internal.g.e(r0, r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r2 = mb.m.Z(r0, r2)
            r1.<init>(r2)
            java.util.Iterator r0 = r0.iterator()
        L1c:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L6f
            java.lang.Object r2 = r0.next()
            p6.a r2 = (p6.a) r2
            java.util.List<b7.k> r3 = r2.f11419d
            p6.b r4 = r2.f11417b
            java.lang.Object r3 = kotlin.collections.a.v0(r3)
            b7.k r3 = (b7.k) r3
            com.stepos.core.ability.AbilityInfo r5 = new com.stepos.core.ability.AbilityInfo
            r15 = 511(0x1ff, float:7.16E-43)
            r16 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            java.lang.String r6 = r2.f11416a
            r5.setId(r6)
            java.lang.String r2 = r2.f11418c
            int r6 = r2.length()
            if (r6 != 0) goto L53
            java.lang.String r2 = r4.f11434a
        L53:
            r5.setName(r2)
            if (r3 == 0) goto L66
            java.lang.String r2 = r3.f3094e
            if (r2 == 0) goto L66
            boolean r3 = gc.q.t0(r2)
            if (r3 != 0) goto L63
            goto L64
        L63:
            r2 = 0
        L64:
            if (r2 != 0) goto L68
        L66:
            java.lang.String r2 = r4.f11434a
        L68:
            r5.setDescription(r2)
            r1.add(r5)
            goto L1c
        L6f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.AbilityManager.getAbilities():java.util.List");
    }

    public final Object getAbilityAsBinder(String str, final int i10, final int i11, qb.b<? super IAIAbility> bVar) throws RemoteException {
        LogModule logModule = LogModule.ABILITY;
        StringBuilder sbF = h0.e.f("getAbilityAsBinder: ", str, ", callerPid=", i10, ", callerUid=");
        sbF.append(i11);
        AIEngineLogger.d(logModule, TAG, sbF.toString());
        String str2 = str + ":" + i11 + ":" + i10;
        ConcurrentHashMap<String, AbilityBinderImpl> concurrentHashMap = abilitiesBinder;
        AbilityBinderImpl abilityBinderImpl = concurrentHashMap.get(str2);
        if (abilityBinderImpl != null) {
            AIEngineLogger.d(logModule, TAG, "Reusing existing binder for " + str2);
            return abilityBinderImpl.createBinder();
        }
        AbilityBinderImpl abilityBinderImpl2 = new AbilityBinderImpl(null, getAbility(str), null, i10, i11, 5, null);
        concurrentHashMap.put(abilityBinderImpl2.getToken(), abilityBinderImpl2);
        abilityIdToToken.put(abilityBinderImpl2.getAbilityId(), abilityBinderImpl2.getToken());
        IAIAbility iAIAbilityCreateBinder = abilityBinderImpl2.createBinder();
        if (i11 > 0) {
            ConcurrentHashMap<Integer, ClientUidSession> concurrentHashMap2 = uidSessions;
            Integer num = new Integer(i11);
            ClientUidSession clientUidSession = concurrentHashMap2.get(num);
            if (clientUidSession == null) {
                clientUidSession = new ClientUidSession(i11, null, 0L, 6, null);
                ClientUidSession clientUidSessionPutIfAbsent = concurrentHashMap2.putIfAbsent(num, clientUidSession);
                if (clientUidSessionPutIfAbsent != null) {
                    clientUidSession = clientUidSessionPutIfAbsent;
                }
            }
            clientUidSession.getPids().add(new Integer(i10));
        }
        final String token = abilityBinderImpl2.getToken();
        final int iHashCode = UserHandle.getUserHandleForUid(i11).hashCode();
        try {
            iAIAbilityCreateBinder.asBinder().linkToDeath(new IBinder.DeathRecipient() { // from class: com.stepos.core.ability.i
                @Override // android.os.IBinder.DeathRecipient
                public final void binderDied() {
                    int i12 = i11;
                    int i13 = iHashCode;
                    AbilityManager.getAbilityAsBinder$lambda$36(token, i10, i12, i13);
                }
            }, 0);
            return iAIAbilityCreateBinder;
        } catch (RemoteException unused) {
            ai.onnxruntime.a.w("Client already dead when linking: token=", token, LogModule.ABILITY, TAG);
            releaseAbility$default(this, token, false, ModelReleaseReason.f6322c, 2, null);
            throw new IllegalStateException("Client process already dead");
        }
    }

    public final p6.a getAbilityConfig(String id2) {
        kotlin.jvm.internal.g.f(id2, "id");
        return abilitiesConfig.get(id2);
    }

    public final synchronized p6.d<?, ?> getAbilityDirect(String id2) {
        AbilityBinderImpl abilityBinderImpl;
        kotlin.jvm.internal.g.f(id2, "id");
        ConcurrentHashMap<String, String> concurrentHashMap = abilityIdToToken;
        String str = concurrentHashMap.get(id2);
        if (str != null && (abilityBinderImpl = abilitiesBinder.get(str)) != null) {
            return abilityBinderImpl.getAbility();
        }
        p6.d<?, ?> ability = getAbility(id2);
        AbilityBinderImpl abilityBinderImpl2 = new AbilityBinderImpl(null, ability, null, 0, 0, 29, null);
        abilitiesBinder.put(abilityBinderImpl2.getToken(), abilityBinderImpl2);
        concurrentHashMap.put(id2, abilityBinderImpl2.getToken());
        return ability;
    }

    public final AbilityParams getAbilityParams(String id2) {
        kotlin.jvm.internal.g.f(id2, "id");
        return abilityParams.get(id2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String getAbilityProperty(java.lang.String r7, java.lang.String r8) {
        /*
            r6 = this;
            java.lang.String r6 = "abilityId"
            kotlin.jvm.internal.g.f(r7, r6)
            java.lang.String r6 = "name"
            kotlin.jvm.internal.g.f(r8, r6)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, p6.a> r6 = com.stepos.core.ability.AbilityManager.abilitiesConfig
            java.lang.Object r6 = r6.get(r7)
            p6.a r6 = (p6.a) r6
            r0 = 0
            if (r6 != 0) goto L17
            goto Ldf
        L17:
            java.util.List<b7.k> r1 = r6.f11419d
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r2 = com.stepos.core.ability.AbilityManager.abilityIdToToken
            java.lang.Object r2 = r2.get(r7)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L2c
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.stepos.core.ability.AbilityBinderImpl> r3 = com.stepos.core.ability.AbilityManager.abilitiesBinder
            java.lang.Object r2 = r3.get(r2)
            com.stepos.core.ability.AbilityBinderImpl r2 = (com.stepos.core.ability.AbilityBinderImpl) r2
            goto L2d
        L2c:
            r2 = r0
        L2d:
            int r3 = r8.hashCode()
            switch(r3) {
                case -1714660125: goto Lb1;
                case -649893435: goto La1;
                case -475629664: goto L6b;
                case 733187439: goto L4d;
                case 1736037254: goto L36;
                default: goto L34;
            }
        L34:
            goto Lb9
        L36:
            java.lang.String r6 = "token.limit"
            boolean r1 = r8.equals(r6)
            if (r1 != 0) goto L40
            goto Lb9
        L40:
            if (r2 == 0) goto L4a
            java.lang.String r6 = r2.getProperty(r6)
            if (r6 != 0) goto L49
            goto L4a
        L49:
            return r6
        L4a:
            java.lang.String r6 = "4096"
            return r6
        L4d:
            java.lang.String r6 = "algorithm.is_busy"
            boolean r6 = r8.equals(r6)
            if (r6 != 0) goto L56
            goto Lb9
        L56:
            if (r2 == 0) goto L68
            boolean r6 = r2.isBusy()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            java.lang.String r6 = r6.toString()
            if (r6 != 0) goto L67
            goto L68
        L67:
            return r6
        L68:
            java.lang.String r6 = "false"
            return r6
        L6b:
            java.lang.String r6 = "plugins"
            boolean r6 = r8.equals(r6)
            if (r6 != 0) goto L74
            goto Lb9
        L74:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Iterator r7 = r1.iterator()
        L7d:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L91
            java.lang.Object r8 = r7.next()
            b7.k r8 = (b7.k) r8
            java.util.Set<java.lang.String> r8 = r8.h
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            mb.q.g0(r6, r8)
            goto L7d
        L91:
            java.util.List r0 = kotlin.collections.a.o0(r6)
            r4 = 0
            r5 = 62
            java.lang.String r1 = ","
            r2 = 0
            r3 = 0
            java.lang.String r6 = kotlin.collections.a.z0(r0, r1, r2, r3, r4, r5)
            return r6
        La1:
            java.lang.String r1 = "support_cloud"
            boolean r1 = r8.equals(r1)
            if (r1 != 0) goto Laa
            goto Lb9
        Laa:
            boolean r6 = r6.f11424j
            java.lang.String r6 = java.lang.String.valueOf(r6)
            return r6
        Lb1:
            java.lang.String r6 = "current_model"
            boolean r6 = r8.equals(r6)
            if (r6 != 0) goto Ld4
        Lb9:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String>> r6 = com.stepos.core.ability.AbilityManager.abilityProperties
            java.lang.Object r6 = r6.get(r7)
            java.util.concurrent.ConcurrentHashMap r6 = (java.util.concurrent.ConcurrentHashMap) r6
            if (r6 == 0) goto Lcd
            java.lang.Object r6 = r6.get(r8)
            java.lang.String r6 = (java.lang.String) r6
            if (r6 != 0) goto Lcc
            goto Lcd
        Lcc:
            return r6
        Lcd:
            if (r2 == 0) goto Ldf
            java.lang.String r6 = r2.getProperty(r8)
            return r6
        Ld4:
            java.lang.Object r6 = kotlin.collections.a.v0(r1)
            b7.k r6 = (b7.k) r6
            if (r6 == 0) goto Ldf
            java.lang.String r6 = r6.f3090a
            return r6
        Ldf:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.AbilityManager.getAbilityProperty(java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0051  */
    /* JADX WARN: Type inference failed for: r2v2, types: [kotlin.Result$Failure] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.util.ArrayList] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.stepos.core.ability.AbilityHolderInfo> getActiveHolders() {
        /*
            Method dump skipped, instructions count: 393
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.AbilityManager.getActiveHolders():java.util.List");
    }

    public final int getActiveInstanceCount() {
        return activeDeepBinderImpls.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<ActiveInstanceInfo> getActiveInstances() {
        Set<Map.Entry<IRecycle, Pair<String, Integer>>> setEntrySet = activeDeepBinderImpls.entrySet();
        kotlin.jvm.internal.g.e(setEntrySet, "<get-entries>(...)");
        Set<Map.Entry<IRecycle, Pair<String, Integer>>> set = setEntrySet;
        ArrayList arrayList = new ArrayList(m.Z(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            kotlin.jvm.internal.g.c(entry);
            Object key = entry.getKey();
            kotlin.jvm.internal.g.e(key, "component1(...)");
            Object value = entry.getValue();
            kotlin.jvm.internal.g.e(value, "component2(...)");
            Pair pair = (Pair) value;
            arrayList.add(new ActiveInstanceInfo((String) pair.f9985a, ((Number) pair.f9986b).intValue(), System.identityHashCode((IRecycle) key)));
        }
        return arrayList;
    }

    public final List<p6.a> getAllAbilityConfigs() {
        Collection<p6.a> collectionValues = abilitiesConfig.values();
        kotlin.jvm.internal.g.e(collectionValues, "<get-values>(...)");
        return kotlin.collections.a.O0(collectionValues);
    }

    public final synchronized AbilityBinderImpl getBinderByAbilityId(String id2) {
        kotlin.jvm.internal.g.f(id2, "id");
        return getBinderByCallerAndAbility(Process.myUid(), Process.myPid(), id2);
    }

    public final synchronized AbilityBinderImpl getBinderByCallerAndAbility(int i10, int i11, String id2) {
        AbilityBinderImpl abilityBinderImpl;
        kotlin.jvm.internal.g.f(id2, "id");
        abilityBinderImpl = new AbilityBinderImpl(null, getAbility(id2), null, i11, i10, 5, null);
        abilitiesBinder.put(abilityBinderImpl.getToken(), abilityBinderImpl);
        abilityIdToToken.put(id2, abilityBinderImpl.getToken());
        totalObtained.incrementAndGet();
        peakHolders.updateAndGet(new g());
        return abilityBinderImpl;
    }

    public final Counters getCounters() {
        return new Counters(totalObtained.get(), totalReleased.get(), peakHolders.get(), abilitiesBinder.size());
    }

    public final k getModelConfig(String modelId) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        b7.f fVar = modelRegistry;
        if (fVar == null) {
            return null;
        }
        if (fVar != null) {
            return fVar.get(modelId);
        }
        kotlin.jvm.internal.g.l("modelRegistry");
        throw null;
    }

    public final b7.f getModelRegistry() {
        b7.f fVar = modelRegistry;
        if (fVar == null) {
            throw new IllegalStateException("AbilityManager not initialized");
        }
        if (fVar != null) {
            return fVar;
        }
        kotlin.jvm.internal.g.l("modelRegistry");
        throw null;
    }

    public final void initialize(Context context2) {
        kotlin.jvm.internal.g.f(context2, "context");
        context = context2.getApplicationContext();
        Context applicationContext = context2.getApplicationContext();
        if (applicationContext == null) {
            applicationContext = context2;
        }
        l7.a.f10344a = applicationContext;
        ModelRegistryImpl modelRegistryImpl = new ModelRegistryImpl();
        modelRegistry = modelRegistryImpl;
        synchronized (j.f3088c) {
            if (j.f3089d != null) {
                throw new IllegalStateException("IModelRegistry already registered. Call unregister() first if you want to replace.");
            }
            j.f3089d = modelRegistryImpl;
            n nVar = n.f10413a;
        }
        b7.f fVar = modelRegistry;
        if (fVar == null) {
            kotlin.jvm.internal.g.l("modelRegistry");
            throw null;
        }
        ModelCacheImpl modelCacheImpl2 = new ModelCacheImpl(context2, fVar, null, null, 0, 0, 0L, 124, null);
        modelCacheImpl = modelCacheImpl2;
        synchronized (j.f3086a) {
            if (j.f3087b != null) {
                throw new IllegalStateException("IModelCache already registered. Call unregister() first if you want to replace.");
            }
            j.f3087b = modelCacheImpl2;
        }
        synchronized (s.f3119a) {
            if (s.f3120b != null) {
                throw new IllegalStateException("VersionedModelCache already registered");
            }
            s.f3120b = modelCacheImpl2;
        }
        LogModule logModule = LogModule.ABILITY;
        AIEngineLogger.i(logModule, TAG, "SandboxCacheHolder registered (merged into ModelCacheImpl)");
        ConcurrentHashMap<String, ConcurrentHashMap<String, IModelChangeListener>> concurrentHashMap = f7.c.f8774a;
        f7.c.f8776c = new b6.i(23);
        Log.i("ModelChangeBroadcaster", "abilityResolver set");
        AIEngineLogger.i(logModule, TAG, "ModelChangeBroadcaster.setAbilityResolver registered");
        AbilityFactory.INSTANCE.discoverProviders(context2);
        Iterator it = ServiceLoader.load(p6.e.class, context2.getClassLoader()).iterator();
        kotlin.jvm.internal.g.e(it, "iterator(...)");
        int i10 = 0;
        while (it.hasNext()) {
            p6.e eVar = (p6.e) it.next();
            List<p6.a> listInitialize = eVar.initialize(context2);
            Iterator<T> it2 = listInitialize.iterator();
            while (it2.hasNext()) {
                INSTANCE.register((p6.a) it2.next());
                i10++;
            }
            AIEngineLogger.d(LogModule.ABILITY, TAG, ai.onnxruntime.a.i("SPI: ", listInitialize.size(), eVar.getClass().getSimpleName(), " loaded ", " abilities"));
        }
        LogModule logModule2 = LogModule.ABILITY;
        Set<String> setKeySet = abilitiesConfig.keySet();
        kotlin.jvm.internal.g.e(setKeySet, "<get-keys>(...)");
        AIEngineLogger.i(logModule2, TAG, "initialize complete: totalAbilities=" + i10 + ", ids=" + kotlin.collections.a.O0(setKeySet));
        AbilityConfigLoader abilityConfigLoader = AbilityConfigLoader.INSTANCE;
        abilityParams.putAll(abilityConfigLoader.loadParams(context2));
        currentAbilitiesJson = abilityConfigLoader.effectiveJsonForRecord$ability_release(context2);
        ModelPathStore.INSTANCE.registerListener(new f());
    }

    public final boolean isAbilityEnabled(String id2) {
        kotlin.jvm.internal.g.f(id2, "id");
        p6.a abilityConfig = getAbilityConfig(id2);
        if (abilityConfig != null) {
            return abilityConfig.c();
        }
        return false;
    }

    public final boolean isCloudEnabled(String id2) {
        kotlin.jvm.internal.g.f(id2, "id");
        p6.a abilityConfig = getAbilityConfig(id2);
        if (abilityConfig != null) {
            return abilityConfig.f11424j;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012f A[Catch: all -> 0x0124, TRY_LEAVE, TryCatch #1 {all -> 0x0124, blocks: (B:41:0x00f7, B:43:0x00fb, B:47:0x0129, B:49:0x012f, B:52:0x0139, B:57:0x016e, B:58:0x0172, B:40:0x00f3, B:37:0x00ea, B:54:0x0165), top: B:67:0x00fb, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void preheatResidentAbilities(zb.l<? super java.lang.String, java.lang.Boolean> r18, zb.l<? super java.lang.String, lb.n> r19) {
        /*
            Method dump skipped, instructions count: 457
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.AbilityManager.preheatResidentAbilities(zb.l, zb.l):void");
    }

    public final p6.a register(p6.a ability) {
        kotlin.jvm.internal.g.f(ability, "ability");
        abilitiesConfig.put(ability.f11416a, ability);
        if (modelRegistry != null) {
            for (k kVar : ability.f11419d) {
                b7.f fVar = modelRegistry;
                if (fVar == null) {
                    kotlin.jvm.internal.g.l("modelRegistry");
                    throw null;
                }
                if (!fVar.contains(kVar.f3090a)) {
                    b7.f fVar2 = modelRegistry;
                    if (fVar2 == null) {
                        kotlin.jvm.internal.g.l("modelRegistry");
                        throw null;
                    }
                    fVar2.register(kVar);
                    AIEngineLogger.d(LogModule.ABILITY, TAG, "Auto-registered model to registry: " + kVar.f3090a);
                }
            }
        }
        return ability;
    }

    public final void registerActiveImpl(String abilityId, IRecycle impl) {
        kotlin.jvm.internal.g.f(abilityId, "abilityId");
        kotlin.jvm.internal.g.f(impl, "impl");
        int callingUid = Binder.getCallingUid();
        ConcurrentHashMap<IRecycle, Pair<String, Integer>> concurrentHashMap = activeDeepBinderImpls;
        concurrentHashMap.put(impl, new Pair<>(abilityId, Integer.valueOf(callingUid)));
        LogModule logModule = LogModule.ABILITY;
        int iIdentityHashCode = System.identityHashCode(impl);
        int size = concurrentHashMap.size();
        StringBuilder sbF = h0.e.f("registerActiveImpl: abilityId=", abilityId, " uid=", callingUid, " svc=");
        sbF.append(iIdentityHashCode);
        sbF.append(", total=");
        sbF.append(size);
        AIEngineLogger.d(logModule, TAG, sbF.toString());
    }

    public final void releaseAbility(String id2, boolean z, ModelReleaseReason reason) {
        kotlin.jvm.internal.g.f(id2, "id");
        kotlin.jvm.internal.g.f(reason, "reason");
        AbilityBinderImpl abilityBinderImplRemove = abilitiesBinder.remove(id2);
        if (abilityBinderImplRemove == null) {
            AIEngineLogger.w(LogModule.ABILITY, TAG, "releaseAbility: binder not found for token=" + id2 + " (already released?)");
            return;
        }
        totalReleased.incrementAndGet();
        LogModule logModule = LogModule.ABILITY;
        StringBuilder sbF = h0.e.f("releaseAbility: token=", id2, ", callerPid=", abilityBinderImplRemove.getCallerPid(), ", drain=");
        sbF.append(z);
        sbF.append(", reason=");
        sbF.append(reason);
        AIEngineLogger.i(logModule, TAG, sbF.toString());
        abilityIdToToken.entrySet().removeIf(new b9.b(new e(id2, 0), 2));
        abilityBinderImplRemove.releaseBinder(true, z, reason);
    }

    public final boolean setAbilityProperty(String id2, String name, String value) {
        kotlin.jvm.internal.g.f(id2, "id");
        kotlin.jvm.internal.g.f(name, "name");
        kotlin.jvm.internal.g.f(value, "value");
        if (!containsAbility(id2)) {
            return false;
        }
        ConcurrentHashMap<String, String> concurrentHashMapComputeIfAbsent = abilityProperties.computeIfAbsent(id2, new h(new b6.i(24), 0));
        kotlin.jvm.internal.g.e(concurrentHashMapComputeIfAbsent, "computeIfAbsent(...)");
        concurrentHashMapComputeIfAbsent.put(name, value);
        return true;
    }

    public final void setAliveMode(String abilityId, boolean z) {
        p6.a aVar;
        kotlin.jvm.internal.g.f(abilityId, "abilityId");
        ModelCacheImpl modelCacheImpl2 = modelCacheImpl;
        if (modelCacheImpl2 == null || (aVar = abilitiesConfig.get(abilityId)) == null) {
            return;
        }
        Iterator<T> it = aVar.f11419d.iterator();
        while (it.hasNext()) {
            modelCacheImpl2.setKeepAlive(((k) it.next()).f3090a, z);
        }
    }

    public final void startResidentPreheat(l<? super String, Boolean> lVar, l<? super String, n> lVar2) {
        Thread thread = new Thread(new androidx.appcompat.app.l(7, lVar, lVar2), "aiengine-resident-preheat");
        thread.setDaemon(true);
        thread.setPriority(1);
        thread.start();
    }

    public final boolean unregister(String id2) {
        kotlin.jvm.internal.g.f(id2, "id");
        Set<Map.Entry<String, AbilityBinderImpl>> setEntrySet = abilitiesBinder.entrySet();
        kotlin.jvm.internal.g.e(setEntrySet, "<get-entries>(...)");
        for (Map.Entry entry : kotlin.collections.a.O0(setEntrySet)) {
            kotlin.jvm.internal.g.c(entry);
            Object key = entry.getKey();
            kotlin.jvm.internal.g.e(key, "component1(...)");
            String str = (String) key;
            Object value = entry.getValue();
            kotlin.jvm.internal.g.e(value, "component2(...)");
            if (kotlin.jvm.internal.g.b(((AbilityBinderImpl) value).getAbilityId(), id2)) {
                releaseAbility$default(INSTANCE, str, false, null, 6, null);
            }
        }
        return abilitiesConfig.remove(id2) != null;
    }

    public final void unregisterActiveImpl(IRecycle impl) {
        kotlin.jvm.internal.g.f(impl, "impl");
        ConcurrentHashMap<IRecycle, Pair<String, Integer>> concurrentHashMap = activeDeepBinderImpls;
        if (concurrentHashMap.remove(impl) != null) {
            AIEngineLogger.d(LogModule.ABILITY, TAG, a0.a.f("unregisterActiveImpl: svc=", System.identityHashCode(impl), concurrentHashMap.size(), " removed, total="));
        }
    }
}
