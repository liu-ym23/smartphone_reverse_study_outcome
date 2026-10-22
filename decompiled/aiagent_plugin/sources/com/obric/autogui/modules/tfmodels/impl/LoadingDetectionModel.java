package com.obric.autogui.modules.tfmodels.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.EventsUtils;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.model.IAutoActionLocalModelProvider;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.obric.autogui.modules.tfmodels.ITFLiteModel;
import com.obric.autogui.modules.tfmodels.imageclassify.ImageClassifierHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.b;
import d.h.a.m;
import d.h.b.h;
import d.o;
import d.x;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.am;
import kotlinx.coroutines.n;
import org.tensorflow.lite.support.label.Category;
import org.tensorflow.lite.task.vision.classifier.Classifications;

/* JADX INFO: compiled from: LoadingDetectionModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class LoadingDetectionModel implements IAutoActionLocalModelProvider.ImageClassifyModel<String>, ITFLiteModel {
    public static final Companion Companion = null;
    private static final AOThreadingTools.SingleThreadCoroutineScopeWrapper modelThread = null;
    private final ImageClassifierHelper mHelper;

    /* JADX INFO: compiled from: LoadingDetectionModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }

        public final AOThreadingTools.SingleThreadCoroutineScopeWrapper getModelThread() {
            return LoadingDetectionModel.access$getModelThread$cp();
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.modules.tfmodels.impl.LoadingDetectionModel$deinitialize$2, reason: invalid class name */
    /* JADX INFO: compiled from: LoadingDetectionModel.kt */
    @f(b = "LoadingDetectionModel.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.modules.tfmodels.impl.LoadingDetectionModel$deinitialize$2")
    static final class AnonymousClass2 extends l implements b<d<? super x>, Object> {
        int label;
        final /* synthetic */ LoadingDetectionModel this$0;

        AnonymousClass2(LoadingDetectionModel r3, d<? super AnonymousClass2> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(1, r5);
        }

        @Override // d.c.b.a.a
        public final d<x> create(d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, r4), d.class, "com.obric.aiagent.plugin");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(d<? super x> r3) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")), AnonymousClass2.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d<? super x> r3) {
            return invoke2((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.label != 0) goto L7;
            o.a(r2);
            LoadingDetectionModel.access$getMHelper$p(this.this$0).close();
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.modules.tfmodels.impl.LoadingDetectionModel$inferenceInternal$1, reason: invalid class name */
    /* JADX INFO: compiled from: LoadingDetectionModel.kt */
    @f(b = "LoadingDetectionModel.kt", c = {EventsUtils.FEAT_TYPE_NFC_EVENT}, d = "inferenceInternal", e = "com.obric.autogui.modules.tfmodels.impl.LoadingDetectionModel")
    static final class AnonymousClass1 extends d.c.b.a.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ LoadingDetectionModel this$0;

        AnonymousClass1(LoadingDetectionModel r3, d<? super AnonymousClass1> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return LoadingDetectionModel.access$inferenceInternal(this.this$0, null, (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.modules.tfmodels.impl.LoadingDetectionModel$initialize$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LoadingDetectionModel.kt */
    @f(b = "LoadingDetectionModel.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.modules.tfmodels.impl.LoadingDetectionModel$initialize$2")
    static final class C11582 extends l implements m<am, d<? super x>, Object> {
        final /* synthetic */ Context $context;
        int label;
        final /* synthetic */ LoadingDetectionModel this$0;

        C11582(LoadingDetectionModel r3, Context r4, d<? super C11582> r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            this.$context = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
            super(2, r7);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r3, d<?> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C11582(this.this$0, this.$context, r5), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(am r3, d<? super x> r4) {
            return ((C11582) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), C11582.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.label != 0) goto L7;
            o.a(r2);
            LoadingDetectionModel.access$getMHelper$p(this.this$0).initialize(this.$context);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public LoadingDetectionModel() {
        this.mHelper = new ImageClassifierHelper("model_wait_20250330.tflite");
    }

    public static final /* synthetic */ ImageClassifierHelper access$getMHelper$p(LoadingDetectionModel r0) {
        return r0.mHelper;
    }

    public static final /* synthetic */ AOThreadingTools.SingleThreadCoroutineScopeWrapper access$getModelThread$cp() {
        return modelThread;
    }

    public static final /* synthetic */ Object access$inferenceInternal(LoadingDetectionModel r2, Bitmap r3, d r4) {
        return r2.inferenceInternal(r3, (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin"));
    }

    static {
        Companion = new Companion(null);
        modelThread = AOThreadingTools.createSingleThreadCoroutineScope$default(AOThreadingTools.INSTANCE, "loading-det-th", false, 2, null);
    }

    @Override // com.obric.autogui.common.api.model.IAutoActionLocalModelProvider.ImageClassifyModel
    public Object inference(Bitmap r3, d<? super com.obric.autogui.common.d<String>> r4) {
        d<? super com.obric.autogui.common.d<String>> r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        Bitmap r0 = r3.copy(Bitmap.Config.ARGB_8888, true);
        r3.recycle();
        d.h.b.o.a(r0);
        return inferenceInternal(r0, r5);
    }

    private final Object inferenceInternal(Bitmap r8, d<? super com.obric.autogui.common.d<String>> r9) {
        d r10 = (d) ZeusTransformUtils.wrapperContextForParams(r9, d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r10, AnonymousClass1.class, "com.obric.aiagent.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = d.c.a.b.a();
        int r3 = r0.label;
        List<Category> r4 = null;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        Bitmap r7 = (Bitmap) ZeusTransformUtils.preCheckCast(r0.L$1, Bitmap.class, "com.obric.aiagent.plugin");
        LoadingDetectionModel this = (LoadingDetectionModel) ZeusTransformUtils.preCheckCast(r0.L$0, LoadingDetectionModel.class, "com.obric.aiagent.plugin");
        o.a(r11);     // Catch: Throwable -> L39 CancellationException -> L42
    L22:
        List r12 = (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L39 CancellationException -> L42
        Classifications r13 = (Classifications) ZeusTransformUtils.preCheckCast(p.l(r12), Classifications.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L30;
        List<Category> r1 = r13.a();
        if (r1 == null) goto L30;
        Category r5 = (Category) ZeusTransformUtils.preCheckCast(p.l(r1), Category.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L30;
        String r6 = r5.a();
    L31:
        if (r6 != null) goto L33;
        Loog.INSTANCE.i(LogUtil.INSTANCE.getCLAZZ_TAG(this), " - cannot get inference result: label == null");
        Loog r14 = Loog.INSTANCE;
        String r15 = LogUtil.INSTANCE.getCLAZZ_TAG(this);
        StringBuilder r16 = new StringBuilder().append(" - result = ").append(r12).append(", ");
        if (r13 == null) goto L37;
        r4 = r13.a();
    L37:
        r14.i(r15, r16.append(r4).toString());
        return com.obric.autogui.common.d.f29012a.a("cannot get inference result");
    L33:
        return com.obric.autogui.common.d.f29012a.a(r6);
    L30:
        r6 = null;
        goto L31
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        o.a(r11);
        r0.L$0 = this;     // Catch: Throwable -> L39 CancellationException -> L42
        r0.L$1 = r8;     // Catch: Throwable -> L39 CancellationException -> L42
        r0.label = 1;     // Catch: Throwable -> L39 CancellationException -> L42
        kotlinx.coroutines.o r17 = new kotlinx.coroutines.o(d.c.a.b.a((d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin")), 1);     // Catch: Throwable -> L39 CancellationException -> L42
        r17.e();     // Catch: Throwable -> L39 CancellationException -> L42
        access$getModelThread$cp().launch((b) ZeusTransformUtils.preCheckCast(new LoadingDetectionModel$inferenceInternal$results$r$1$1(this, r8, (n) ZeusTransformUtils.preCheckCast(r17, n.class, "com.obric.aiagent.plugin"), null), b.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L39 CancellationException -> L42
        r11 = r17.h();     // Catch: Throwable -> L39 CancellationException -> L42
        if (r11 != d.c.a.b.a()) goto L20;
        d.c.b.a.h.c((d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L39 CancellationException -> L42
    L20:
        if (r11 != r2) goto L22;
        return r2;
    L42:
        Loog.INSTANCE.w(LogUtil.INSTANCE.getCLAZZ_TAG(this), "the inference is cancelled. the results (if any) will be ignored.");
        return com.obric.autogui.common.d.f29012a.a("the inference is cancelled");
    L39:
        th = move-exception;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "failed to inference: " + th, th);
        return com.obric.autogui.common.d.f29012a.a("failed to inference");
    L7:
        r0 = new AnonymousClass1(this, r10);
        goto L8
    }

    @Override // com.obric.autogui.modules.tfmodels.ITFLiteModel
    public Object initialize(Context r6, d<? super x> r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        d r9 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.aiagent.plugin");
        Object r5 = AOThreadingTools.INSTANCE.runIn((AOThreadingTools.AOThreadLauncher) ZeusTransformUtils.preCheckCast(modelThread, AOThreadingTools.AOThreadLauncher.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new C11582(this, r8, null), m.class, "com.obric.aiagent.plugin"), r9);
        if (r5 != d.c.a.b.a()) goto L6;
        return r5;
    L6:
        return x.f38692a;
    }

    @Override // com.obric.autogui.modules.tfmodels.ITFLiteModel
    public Object deinitialize(d<? super x> r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        modelThread.launch((b) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, null), b.class, "com.obric.aiagent.plugin"));
        return x.f38692a;
    }
}
