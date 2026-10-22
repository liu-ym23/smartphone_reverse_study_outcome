package com.stepos.backend.onnx;

import android.content.Context;
import android.util.Log;
import b7.k;
import com.stepos.base.model.ModelBase;
import com.stepos.core.common.log.AiEngineAtrace;
import com.stepos.core.ota.d;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Pair;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import lb.n;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TenVadOnnxModel extends ModelBase {
    private static final String ASSET_NAME = "ten_vad.onnx";
    public static final Companion Companion = new Companion(null);
    public static final int FRAME_SIZE = 256;
    private static final String MODEL_FILE_IN_DIR = "ten-vad.onnx";
    private static final String MODEL_REL_DIR = "onnx_model";
    public static final int SAMPLE_RATE = 16000;
    private static final String TAG = "TenVadOnnxModel";
    public static final float THRESHOLD = 0.5f;
    private volatile long handle;
    private volatile File modelDir;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.backend.onnx.TenVadOnnxModel$doFlowInfer$2", f = "TenVadOnnxModel.kt", l = {137, 137}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.onnx.TenVadOnnxModel$doFlowInfer$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<FlowCollector<? super Result<? extends Object>>, qb.b<? super n>, Object> {
        final /* synthetic */ Object $input;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Object obj, qb.b<? super AnonymousClass2> bVar) {
            super(2, bVar);
            this.$input = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass2 anonymousClass2 = TenVadOnnxModel.this.new AnonymousClass2(this.$input, bVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0036, code lost:
        
            if (r6 == r0) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x004b, code lost:
        
            if (r1.emit(r3, r5) == r0) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x004d, code lost:
        
            return r0;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.flow.FlowCollector] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r1v9 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                int r1 = r5.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L18
                if (r1 != r2) goto L10
                kotlin.c.b(r6)
                goto L4e
            L10:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L18:
                java.lang.Object r1 = r5.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.c.b(r6)     // Catch: java.lang.Throwable -> L20
                goto L3d
            L20:
                r6 = move-exception
                goto L39
            L22:
                kotlin.c.b(r6)
                java.lang.Object r6 = r5.L$0
                r1 = r6
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                com.stepos.backend.onnx.TenVadOnnxModel r6 = com.stepos.backend.onnx.TenVadOnnxModel.this
                java.lang.Object r4 = r5.$input
                r5.L$0 = r1     // Catch: java.lang.Throwable -> L20
                r5.label = r3     // Catch: java.lang.Throwable -> L20
                java.lang.Object r6 = r6.doInfer(r4, r5)     // Catch: java.lang.Throwable -> L20
                if (r6 != r0) goto L3d
                goto L4d
            L39:
                kotlin.Result$Failure r6 = kotlin.c.a(r6)
            L3d:
                kotlin.Result r3 = new kotlin.Result
                r3.<init>(r6)
                r6 = 0
                r5.L$0 = r6
                r5.label = r2
                java.lang.Object r5 = r1.emit(r3, r5)
                if (r5 != r0) goto L4e
            L4d:
                return r0
            L4e:
                lb.n r5 = lb.n.f10413a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.onnx.TenVadOnnxModel.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(FlowCollector<? super Result<? extends Object>> flowCollector, qb.b<? super n> bVar) {
            return ((AnonymousClass2) create(flowCollector, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TenVadOnnxModel(k config) {
        super(config);
        g.f(config, "config");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Pair<Float, Boolean> processInternal(short[] sArr) {
        Float fValueOf = Float.valueOf(0.0f);
        long j10 = this.handle;
        if (j10 == 0) {
            return new Pair<>(fValueOf, Boolean.FALSE);
        }
        float fFloatValue = ((Number) AiEngineAtrace.section("onnx/call", "ten_vad_process", new com.stepos.backend.llama.a(j10, sArr, 2))).floatValue();
        if (fFloatValue < 0.0f) {
            return new Pair<>(fValueOf, Boolean.FALSE);
        }
        return new Pair<>(Float.valueOf(fFloatValue), Boolean.valueOf(fFloatValue >= 0.5f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float processInternal$lambda$10(long j10, short[] sArr) {
        return TenVadNativeBridge.nativeProcess(j10, sArr, 256);
    }

    @Override // com.stepos.base.model.ModelBase
    public Object doCleanup(qb.b<? super n> bVar) {
        Log.i(TAG, "doCleanup");
        this.modelDir = null;
        return n.f10413a;
    }

    @Override // com.stepos.base.model.ModelBase
    public Object doClose(qb.b<? super n> bVar) {
        Object objA;
        Log.i(TAG, "doClose");
        long j10 = this.handle;
        this.handle = 0L;
        if (j10 != 0) {
            try {
                TenVadNativeBridge.nativeDestroy(j10);
                objA = n.f10413a;
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                a0.a.A("doClose: nativeDestroy failed: ", thB.getMessage(), TAG);
            }
        }
        return n.f10413a;
    }

    @Override // com.stepos.base.model.ModelBase
    public Object doFlowInfer(Object obj, qb.b<? super Flow<? extends Result<? extends Object>>> bVar) {
        return FlowKt.flowOn(FlowKt.flow(new AnonymousClass2(obj, null)), Dispatchers.getDefault());
    }

    @Override // com.stepos.base.model.ModelBase
    public Object doInfer(Object obj, qb.b<Object> bVar) {
        if (!(obj instanceof short[])) {
            throw new IllegalArgumentException("TenVadOnnxModel 期望 ShortArray (PCM16, length=256)，实际 ".concat(obj.getClass().getSimpleName()).toString());
        }
        short[] sArr = (short[]) obj;
        if (sArr.length == 256) {
            return processInternal(sArr);
        }
        throw new IllegalArgumentException(ai.onnxruntime.providers.a.a(sArr.length, "TenVadOnnxModel 帧大小必须 = 256，实际 ").toString());
    }

    @Override // com.stepos.base.model.ModelBase
    public Object doInitialize(Context context, k kVar, qb.b<? super n> bVar) throws IOException {
        Log.i(TAG, "doInitialize: modelId=" + kVar.f3090a + ", threads=" + kVar.f3096g.f6265c);
        TenVadNativeBridge tenVadNativeBridge = TenVadNativeBridge.INSTANCE;
        if (!tenVadNativeBridge.ensureLoaded()) {
            Throwable lastLoadError = tenVadNativeBridge.getLastLoadError();
            throw new IllegalStateException(ai.onnxruntime.a.k("ten-vad native libs not available: ", lastLoadError != null ? lastLoadError.getMessage() : null), lastLoadError);
        }
        File file = new File(context.getCacheDir(), "ten_vad");
        File file2 = new File(file, MODEL_REL_DIR);
        if (!file2.isDirectory()) {
            file2.mkdirs();
        }
        File file3 = new File(file2, MODEL_FILE_IN_DIR);
        InputStream inputStreamOpen = context.getAssets().open(ASSET_NAME);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file3);
            try {
                g.c(inputStreamOpen);
                jd.b.n(inputStreamOpen, fileOutputStream);
                fileOutputStream.close();
                inputStreamOpen.close();
                if (!file3.isFile() || file3.length() <= 0) {
                    throw new IllegalStateException(ai.onnxruntime.a.k("ten-vad onnx copy failed: ", file3.getAbsolutePath()).toString());
                }
                StringBuilder sbL = d.l("model file ready: ", file3.length(), file3.getAbsolutePath(), " (");
                sbL.append(" bytes)");
                Log.i(TAG, sbL.toString());
                String absolutePath = file.getAbsolutePath();
                g.e(absolutePath, "getAbsolutePath(...)");
                long jNativeCreate = TenVadNativeBridge.nativeCreate(absolutePath, 256, 0.5f);
                if (jNativeCreate == 0) {
                    throw new IllegalStateException(ai.onnxruntime.a.k("ten_vad_create failed (handle=0); modelDir=", file.getAbsolutePath()));
                }
                this.handle = jNativeCreate;
                this.modelDir = file;
                Log.i(TAG, a0.a.h("doInitialize done: handle=", jNativeCreate, " modelDir=", file.getAbsolutePath()));
                return n.f10413a;
            } finally {
            }
        } finally {
        }
    }

    @Override // com.stepos.base.model.ModelBase
    public Object doWarmup(qb.b<? super n> bVar) {
        Object objA;
        if (this.handle == 0) {
            return n.f10413a;
        }
        Log.i(TAG, "doWarmup: 跑一帧零数据预热");
        try {
            objA = new Float(TenVadNativeBridge.nativeProcess(this.handle, new short[256], 256));
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            a0.a.A("warmup 失败（不致命）: ", thB.getMessage(), TAG);
        }
        return n.f10413a;
    }

    public final Pair<Float, Boolean> process(short[] frame) {
        g.f(frame, "frame");
        if (frame.length == 256) {
            return processInternal(frame);
        }
        throw new IllegalArgumentException(ai.onnxruntime.providers.a.a(frame.length, "frame size must be 256, got ").toString());
    }

    public final void reset() {
        Object objA;
        File file = this.modelDir;
        if (file == null) {
            return;
        }
        long j10 = this.handle;
        if (j10 != 0) {
            try {
                TenVadNativeBridge.nativeDestroy(j10);
                objA = n.f10413a;
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                a0.a.A("reset: destroy old handle failed: ", thB.getMessage(), TAG);
            }
            this.handle = 0L;
        }
        String absolutePath = file.getAbsolutePath();
        g.e(absolutePath, "getAbsolutePath(...)");
        long jNativeCreate = TenVadNativeBridge.nativeCreate(absolutePath, 256, 0.5f);
        if (jNativeCreate == 0) {
            Log.w(TAG, "reset: re-create failed; subsequent process() will return non-speech");
        } else {
            this.handle = jNativeCreate;
        }
    }
}
