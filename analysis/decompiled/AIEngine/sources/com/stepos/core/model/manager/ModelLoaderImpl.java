package com.stepos.core.model.manager;

import android.content.Context;
import android.util.Log;
import b7.e;
import cb.s;
import com.stepos.base.model.ModelLoadException;
import com.stepos.base.model.ModelNotReadyException;
import com.stepos.core.common.storage.ModelPathStore;
import com.stepos.core.error.AIEngineError;
import com.stepos.core.model.factory.AIModelFactory;
import com.stepos.core.ota.crypto.AtRestSealer;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelLoaderImpl implements b7.e {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "ModelLoaderImpl";
    private final ExecutorService loadExecutor;
    private final ConcurrentHashMap<String, b7.a> loadedModels;
    private final ConcurrentHashMap<String, Future<?>> loadingTasks;
    private final AIModelFactory modelFactory;
    private final ConcurrentHashMap<String, AtomicInteger> progressMap;
    private final CoroutineScope scope;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.model.manager.ModelLoaderImpl$loadModelInternal$2", f = "ModelLoaderImpl.kt", l = {388}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.model.manager.ModelLoaderImpl$loadModelInternal$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
        final /* synthetic */ b7.k $config;
        final /* synthetic */ Context $context;
        final /* synthetic */ b7.a $model;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(b7.a aVar, Context context, b7.k kVar, qb.b<? super AnonymousClass2> bVar) {
            super(2, bVar);
            this.$model = aVar;
            this.$context = context;
            this.$config = kVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            return new AnonymousClass2(this.$model, this.$context, this.$config, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objMo11initializegIAlus;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                b7.a aVar = this.$model;
                Context context = this.$context;
                this.label = 1;
                objMo11initializegIAlus = aVar.mo11initializegIAlus(context, this);
                if (objMo11initializegIAlus == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
                objMo11initializegIAlus = ((Result) obj).f9987a;
            }
            if (!(objMo11initializegIAlus instanceof Result.Failure)) {
                return lb.n.f10413a;
            }
            Throwable thB = Result.b(objMo11initializegIAlus);
            if (thB == null) {
                throw new ModelLoadException("Model initialization failed: ".concat(this.$config.f3090a), (Integer) null, 6);
            }
            throw thB;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
            return ((AnonymousClass2) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.model.manager.ModelLoaderImpl$unload$1", f = "ModelLoaderImpl.kt", l = {159}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.model.manager.ModelLoaderImpl$unload$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super Result<? extends lb.n>>, Object> {
        final /* synthetic */ b7.a $model;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(b7.a aVar, qb.b<? super AnonymousClass1> bVar) {
            super(2, bVar);
            this.$model = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            return new AnonymousClass1(this.$model, bVar);
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, qb.b<? super Result<? extends lb.n>> bVar) {
            return invoke2(coroutineScope, (qb.b<? super Result<lb.n>>) bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objMo9closeIoAF18A;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                b7.a aVar = this.$model;
                this.label = 1;
                objMo9closeIoAF18A = aVar.mo9closeIoAF18A(this);
                if (objMo9closeIoAF18A == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
                objMo9closeIoAF18A = ((Result) obj).f9987a;
            }
            return new Result(objMo9closeIoAF18A);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, qb.b<? super Result<lb.n>> bVar) {
            return ((AnonymousClass1) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    public ModelLoaderImpl() {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new p());
        kotlin.jvm.internal.g.e(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        this.loadExecutor = executorServiceNewSingleThreadExecutor;
        this.scope = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(executorServiceNewSingleThreadExecutor).plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.loadingTasks = new ConcurrentHashMap<>();
        this.progressMap = new ConcurrentHashMap<>();
        this.loadedModels = new ConcurrentHashMap<>();
        this.modelFactory = new AIModelFactory();
    }

    private final boolean declaresOpaqueEntry(String str) {
        return (str == null || !gc.o.e0(str, ".json", true) || str.equals("bundle_config.json")) ? false : true;
    }

    private final String legacyEntryPathOf(File file, String str) {
        if (declaresOpaqueEntry(str) && str != null) {
            if (gc.q.m0(str, '/')) {
                ai.onnxruntime.a.x("modelFile '", str, "' 含子目录，违反 entry 必须在包根，已忽略", TAG);
                return null;
            }
            File file2 = new File(file, str);
            if (!file2.isFile()) {
                file2 = null;
            }
            if (file2 != null) {
                return file2.getAbsolutePath();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n load$lambda$2(int i10, String str, b7.k kVar) {
        kotlin.jvm.internal.g.f(str, "<unused var>");
        kotlin.jvm.internal.g.f(kVar, "<unused var>");
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadAsync$lambda$4(e.a aVar, String str, ModelLoaderImpl modelLoaderImpl, b7.k kVar, Context context) {
        try {
            try {
                aVar.d();
                b7.k kVarRescueModelPath$model_release = modelLoaderImpl.rescueModelPath$model_release(kVar);
                e.b bVarValidate = modelLoaderImpl.validate(kVarRescueModelPath$model_release);
                if (bVarValidate.f3072a) {
                    modelLoaderImpl.updateProgress(str, 10, "Validation passed", aVar);
                    modelLoaderImpl.loadModelInternal(context, kVarRescueModelPath$model_release, new b7.i(1, modelLoaderImpl, str));
                    modelLoaderImpl.updateProgress(str, 100, "Load complete", aVar);
                    aVar.e();
                } else {
                    modelLoaderImpl.validationException(kVarRescueModelPath$model_release, bVarValidate, "Validation failed: " + bVarValidate.f3076e);
                    aVar.a();
                }
            } catch (InterruptedException unused) {
                Log.i(TAG, "Model loading cancelled: " + str);
                aVar.b();
            } catch (Exception e10) {
                Log.e(TAG, "Model loading failed: " + str, e10);
                aVar.a();
            }
        } finally {
            modelLoaderImpl.loadingTasks.remove(str);
            modelLoaderImpl.progressMap.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n loadAsync$lambda$4$lambda$3(ModelLoaderImpl modelLoaderImpl, String str, e.a aVar, int i10, String message, b7.k kVar) {
        kotlin.jvm.internal.g.f(message, "message");
        kotlin.jvm.internal.g.f(kVar, "<unused var>");
        modelLoaderImpl.updateProgress(str, ((int) (i10 * 0.8d)) + 10, message, aVar);
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread loadExecutor$lambda$1(Runnable runnable) {
        return com.stepos.core.ota.d.n(runnable, "ModelLoader", true);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final b7.a loadModelInternal(android.content.Context r19, b7.k r20, zb.q<? super java.lang.Integer, ? super java.lang.String, ? super b7.k, lb.n> r21) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.model.manager.ModelLoaderImpl.loadModelInternal(android.content.Context, b7.k, zb.q):b7.a");
    }

    private final String manifestEntryPathOf(File file) {
        Object objA;
        File file2 = new File(file, AtRestSealer.MODEL_MANIFEST);
        if (!file2.isFile()) {
            file2 = null;
        }
        if (file2 != null) {
            try {
                String strOptString = new JSONObject(wb.d.Z(file2, gc.a.f9106b)).optString("entry", "");
                kotlin.jvm.internal.g.e(strOptString, "optString(...)");
                objA = gc.q.L0(strOptString).toString();
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                a0.a.w("manifest entry 解析失败: ", file2.getAbsolutePath(), ": ", thB.getMessage(), TAG);
                return null;
            }
            String str = (String) objA;
            if (str.length() != 0 && !gc.q.m0(str, '/')) {
                File file3 = new File(file, str);
                if (!file3.isFile()) {
                    file3 = null;
                }
                if (file3 != null) {
                    return file3.getAbsolutePath();
                }
                return null;
            }
        }
        return null;
    }

    private final void updateProgress(String str, int i10, String str2, e.a aVar) {
        AtomicInteger atomicInteger = this.progressMap.get(str);
        if (atomicInteger != null) {
            atomicInteger.set(i10);
        }
        aVar.c();
        Log.d(TAG, "Load progress [" + str + "]: " + i10 + "% - " + str2);
    }

    private final boolean validateModelIntegrity(File file) {
        List<File> listC = b7.m.c(file);
        if (listC.isEmpty()) {
            return false;
        }
        if (listC != null && listC.isEmpty()) {
            return true;
        }
        for (File file2 : listC) {
            if (file2.length() <= 0 || !file2.canRead()) {
                return false;
            }
        }
        return true;
    }

    private final ModelLoadException validationException(b7.k kVar, e.b bVar, String message) {
        if (bVar.f3073b || !gc.q.t0(ModelPathStore.INSTANCE.getPath(kVar.f3090a))) {
            return new ModelLoadException(message, Integer.valueOf(AIEngineError.MODEL_LOAD_FAILED), 2);
        }
        kotlin.jvm.internal.g.f(message, "message");
        return new ModelNotReadyException(message, null, Integer.valueOf(AIEngineError.MODEL_FILE_NOT_FOUND));
    }

    public boolean cancel(String modelId) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        Future<?> future = this.loadingTasks.get(modelId);
        if (future == null || future.isDone()) {
            return false;
        }
        future.cancel(true);
        this.loadingTasks.remove(modelId);
        this.progressMap.remove(modelId);
        Log.i(TAG, "Loading cancelled for model: ".concat(modelId));
        return true;
    }

    public final List<b7.a> getLoadedModels() {
        Collection<b7.a> collectionValues = this.loadedModels.values();
        kotlin.jvm.internal.g.e(collectionValues, "<get-values>(...)");
        return kotlin.collections.a.O0(collectionValues);
    }

    public int getProgress(String modelId) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        AtomicInteger atomicInteger = this.progressMap.get(modelId);
        if (atomicInteger != null) {
            return atomicInteger.get();
        }
        return -1;
    }

    public boolean isLoading(String modelId) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        return this.loadingTasks.containsKey(modelId);
    }

    @Override // b7.e
    public b7.a load(Context context, b7.k config) throws ModelLoadException {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(config, "config");
        b7.k kVarRescueModelPath$model_release = rescueModelPath$model_release(config);
        Log.i(TAG, "Loading model: " + kVarRescueModelPath$model_release.f3090a + ", path: " + kVarRescueModelPath$model_release.f3091b);
        e.b bVarValidate = validate(kVarRescueModelPath$model_release);
        if (bVarValidate.f3072a) {
            return loadModelInternal(context, kVarRescueModelPath$model_release, new q());
        }
        throw validationException(kVarRescueModelPath$model_release, bVarValidate, ai.onnxruntime.a.k("Model validation failed: ", bVarValidate.f3076e));
    }

    public final boolean loadAndCache(Context context, b7.k config) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(config, "config");
        String str = config.f3090a;
        try {
            this.loadedModels.put(str, load(context, config));
            return true;
        } catch (Exception e10) {
            Log.e(TAG, "Failed to load model: " + str, e10);
            return false;
        }
    }

    public void loadAsync(Context context, b7.k config, e.a callback) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(config, "config");
        kotlin.jvm.internal.g.f(callback, "callback");
        String str = config.f3090a;
        if (this.loadingTasks.containsKey(str)) {
            new ModelLoadException("Model is already loading", (Integer) null, 6);
            callback.a();
        } else {
            this.progressMap.put(str, new AtomicInteger(0));
            this.loadingTasks.put(str, this.loadExecutor.submit(new s(str, this, config, context, 1)));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final b7.k rescueModelPath$model_release(b7.k r10) {
        /*
            r9 = this;
            java.lang.String r0 = "config"
            kotlin.jvm.internal.g.f(r10, r0)
            java.lang.String r0 = r10.f3091b
            java.lang.String r1 = r10.f3092c
            java.lang.String r2 = r10.f3090a
            int r3 = r2.length()
            if (r3 != 0) goto L13
            goto L9b
        L13:
            com.stepos.core.common.storage.ModelPathStore r3 = com.stepos.core.common.storage.ModelPathStore.INSTANCE
            java.lang.String r3 = r3.getPath(r2)
            int r4 = r3.length()
            if (r4 != 0) goto L21
            goto L9b
        L21:
            java.io.File r4 = new java.io.File
            r4.<init>(r3)
            boolean r3 = r4.isDirectory()
            if (r3 != 0) goto L2d
            goto L9b
        L2d:
            java.lang.String r3 = r4.getAbsolutePath()
            java.io.File r5 = new java.io.File
            r5.<init>(r0)
            java.lang.String r5 = r5.getAbsolutePath()
            boolean r3 = kotlin.jvm.internal.g.b(r3, r5)
            java.io.File r5 = new java.io.File
            r5.<init>(r0)
            java.lang.String r5 = r5.getAbsolutePath()
            if (r1 == 0) goto L87
            java.io.File r6 = new java.io.File
            r6.<init>(r1)
            java.lang.String r6 = r6.getAbsolutePath()
            kotlin.jvm.internal.g.c(r6)
            java.lang.String r7 = java.io.File.separator
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r5)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            r8 = 0
            boolean r7 = gc.o.k0(r6, r7, r8)
            if (r7 == 0) goto L83
            java.lang.String r7 = r4.getAbsolutePath()
            int r5 = r5.length()
            java.lang.String r5 = r6.substring(r5)
            java.lang.String r6 = "substring(...)"
            kotlin.jvm.internal.g.e(r5, r6)
            java.lang.String r5 = a0.a.j(r7, r5)
            goto L84
        L83:
            r5 = r1
        L84:
            if (r5 == 0) goto L87
            goto L93
        L87:
            java.lang.String r5 = r9.manifestEntryPathOf(r4)
            if (r5 != 0) goto L93
            java.lang.String r5 = r10.f3093d
            java.lang.String r5 = r9.legacyEntryPathOf(r4, r5)
        L93:
            if (r3 == 0) goto L9c
            boolean r9 = kotlin.jvm.internal.g.b(r5, r1)
            if (r9 == 0) goto L9c
        L9b:
            return r10
        L9c:
            java.lang.String r9 = "ModelLoaderImpl"
            if (r3 != 0) goto Lb8
            java.lang.String r3 = r4.getAbsolutePath()
            java.lang.String r6 = "' 过期，改用 ModelPathStore["
            java.lang.String r7 = "] -> "
            java.lang.String r8 = "rescueModelPath: '"
            java.lang.StringBuilder r0 = ai.onnxruntime.a.s(r8, r0, r6, r2, r7)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            android.util.Log.w(r9, r0)
        Lb8:
            boolean r0 = kotlin.jvm.internal.g.b(r5, r1)
            if (r0 != 0) goto Lcb
            java.lang.String r0 = "' -> '"
            java.lang.String r2 = "'"
            java.lang.String r3 = "rescueModelPath: configPath '"
            java.lang.String r0 = h0.e.c(r3, r1, r0, r5, r2)
            android.util.Log.w(r9, r0)
        Lcb:
            java.lang.String r9 = r4.getAbsolutePath()
            java.lang.String r0 = "getAbsolutePath(...)"
            kotlin.jvm.internal.g.e(r9, r0)
            r0 = 0
            r1 = 16377(0x3ff9, float:2.2949E-41)
            b7.k r9 = b7.k.a(r10, r9, r5, r0, r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.model.manager.ModelLoaderImpl.rescueModelPath$model_release(b7.k):b7.k");
    }

    public final void shutdown() {
        unloadAll();
        Collection<Future<?>> collectionValues = this.loadingTasks.values();
        kotlin.jvm.internal.g.e(collectionValues, "<get-values>(...)");
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            ((Future) it.next()).cancel(true);
        }
        this.loadingTasks.clear();
        this.progressMap.clear();
        this.loadExecutor.shutdown();
        Log.i(TAG, "ModelLoader shutdown");
    }

    public void unload(b7.a model) {
        kotlin.jvm.internal.g.f(model, "model");
        try {
            BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(model, null), 1, null);
            Log.i(TAG, "Model unloaded: " + model.getConfig().f3090a);
        } catch (Exception e10) {
            Log.e(TAG, "Failed to unload model", e10);
        }
    }

    public final void unloadAll() {
        Set<String> setKeySet = this.loadedModels.keySet();
        kotlin.jvm.internal.g.e(setKeySet, "<get-keys>(...)");
        for (String str : kotlin.collections.a.O0(setKeySet)) {
            kotlin.jvm.internal.g.c(str);
            unloadById(str);
        }
    }

    public final boolean unloadById(String modelId) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        try {
            b7.a aVarRemove = this.loadedModels.remove(modelId);
            if (aVarRemove == null) {
                return false;
            }
            unload(aVarRemove);
            Log.i(TAG, "Model unloaded: ".concat(modelId));
            return true;
        } catch (Exception e10) {
            Log.e(TAG, "Failed to unload model: ".concat(modelId), e10);
            return false;
        }
    }

    public e.b validate(b7.k config) {
        kotlin.jvm.internal.g.f(config, "config");
        String str = config.f3093d;
        if (config.f3098j) {
            return new e.b(true, true, true, true, null);
        }
        String strM = jd.b.M(config.f3091b);
        String str2 = config.f3092c;
        String strConcat = null;
        String strM2 = str2 != null ? jd.b.M(str2) : null;
        File file = new File(strM);
        boolean zIsEmpty = b7.m.c(file).isEmpty();
        boolean z = !zIsEmpty;
        boolean zExists = strM2 != null ? new File(strM2).exists() : !declaresOpaqueEntry(str);
        boolean zValidateModelIntegrity = validateModelIntegrity(file);
        boolean z3 = !zIsEmpty && zExists && zValidateModelIntegrity;
        if (zIsEmpty) {
            String str3 = config.f3090a;
            strConcat = (str3.length() <= 0 || !gc.q.t0(ModelPathStore.INSTANCE.getPath(str3))) ? "Model path not found: ".concat(strM) : h0.e.c("Model not yet ready (preinstall extract may still be in progress, retry later): modelId='", str3, "' requestedPath='", strM, "'");
        } else if (!zExists) {
            strConcat = strM2 != null ? "Config file not found: ".concat(strM2) : h0.e.c("Opaque package entry unresolved: modelFile='", str, "' under ", strM, " (expects model_manifest.json entry, or the same-named .json at package root)");
        } else if (!zValidateModelIntegrity) {
            strConcat = "Model integrity check failed: file empty, unreadable, or directory empty";
        }
        return new e.b(z3, z, zExists, zValidateModelIntegrity, strConcat);
    }
}
