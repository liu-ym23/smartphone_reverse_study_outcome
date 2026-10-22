package com.obric.autogui.modules.tfmodels;

import android.content.Context;
import com.obric.aiagent.product.ObricProductSdk;
import com.obric.aiagent.product.feature.api.IFeatureServiceKt;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.sdk.AIKernelConfig;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.model.IAutoActionLocalModelProvider;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.obric.autogui.modules.tfmodels.impl.AIKLoadingDetection;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.c.a.b;
import d.c.b.a.d;
import d.c.b.a.f;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.h;
import d.o;
import d.s;
import d.x;
import java.util.Iterator;
import java.util.Map;
import kotlinx.coroutines.am;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: compiled from: TFLiteModelProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TFLiteModelProvider implements IAutoActionLocalModelProvider {
    public static final Companion Companion = null;
    public static final String TAG = "TFLiteModelProvider";
    private static final Map<String, ITFLiteModel> mRegisteredModels = null;
    private final w<x> mInitDeferred;

    /* JADX INFO: compiled from: TFLiteModelProvider.kt */
    public static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.modules.tfmodels.TFLiteModelProvider$acquireImageClassifyModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: TFLiteModelProvider.kt */
    @f(b = "TFLiteModelProvider.kt", c = {74, 82}, d = "acquireImageClassifyModel", e = "com.obric.autogui.modules.tfmodels.TFLiteModelProvider")
    static final class AnonymousClass1 extends d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ TFLiteModelProvider this$0;

        AnonymousClass1(TFLiteModelProvider r3, d.c.d<? super AnonymousClass1> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.acquireImageClassifyModel(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.modules.tfmodels.TFLiteModelProvider$deinitModels$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TFLiteModelProvider.kt */
    @f(b = "TFLiteModelProvider.kt", c = {65}, d = "deinitModels", e = "com.obric.autogui.modules.tfmodels.TFLiteModelProvider")
    static final class C11501 extends d {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ TFLiteModelProvider this$0;

        C11501(TFLiteModelProvider r3, d.c.d<? super C11501> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return TFLiteModelProvider.access$deinitModels(this.this$0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.modules.tfmodels.TFLiteModelProvider$init$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TFLiteModelProvider.kt */
    @f(b = "TFLiteModelProvider.kt", c = {52}, d = "invokeSuspend", e = "com.obric.autogui.modules.tfmodels.TFLiteModelProvider$init$1")
    static final class C11511 extends l implements m<am, d.c.d<? super Boolean>, Object> {
        final /* synthetic */ Context $context;
        int label;
        final /* synthetic */ TFLiteModelProvider this$0;

        C11511(TFLiteModelProvider r3, Context r4, d.c.d<? super C11511> r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            this.$context = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
            super(2, r7);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C11511(this.this$0, this.$context, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Boolean> r4) {
            return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(am r3, d.c.d<? super Boolean> r4) {
            return ((C11511) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C11511.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = b.a();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L12:
            return d.c.b.a.b.a(TFLiteModelProvider.access$getMInitDeferred$p(this.this$0).a(x.f38692a));
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            TFLiteModelProvider r7 = this.this$0;
            Context r2 = this.$context;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.label = 1;
            if (TFLiteModelProvider.access$initModels(r7, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.modules.tfmodels.TFLiteModelProvider$initModels$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TFLiteModelProvider.kt */
    @f(b = "TFLiteModelProvider.kt", c = {59}, d = "initModels", e = "com.obric.autogui.modules.tfmodels.TFLiteModelProvider")
    static final class C11521 extends d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ TFLiteModelProvider this$0;

        C11521(TFLiteModelProvider r3, d.c.d<? super C11521> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return TFLiteModelProvider.access$initModels(this.this$0, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public TFLiteModelProvider() {
        this.mInitDeferred = y.a(null, 1, null);
    }

    public static final /* synthetic */ Object access$deinitModels(TFLiteModelProvider r2, d.c.d r3) {
        return r2.deinitModels((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ w access$getMInitDeferred$p(TFLiteModelProvider r0) {
        return r0.mInitDeferred;
    }

    public static final /* synthetic */ Object access$initModels(TFLiteModelProvider r2, Context r3, d.c.d r4) {
        return r2.initModels((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    static {
        Companion = new Companion(null);
        mRegisteredModels = ao.a(s.a("loading-detection-aik", new AIKLoadingDetection()));
    }

    @Override // com.obric.autogui.common.api.model.IAutoActionLocalModelProvider
    public void init(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "context");
        boolean r0 = ObricProductSdk.INSTANCE.featureService().isFeatureEnable(IFeatureServiceKt.FEATURE_KEY_KEEP_ALIVE_HIGH_LEVEL);
        Loog.INSTANCE.i(TAG, "init, keepAliveHighLevel = " + r0);
        AIKernelManager.INSTANCE.init(new AIKernelConfig.Builder(r7).appId(Long.parseLong("728048")).bindRemoteOnInit(r0).build());
        AOThreadingTools.INSTANCE.launchIO((m) ZeusTransformUtils.preCheckCast(new C11511(this, r7, null), m.class, "com.obric.aiagent.plugin"));
    }

    private final Object initModels(Context r7, d.c.d<? super x> r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, C11521.class) == false) goto L7;
        C11521 r0 = (C11521) ZeusTransformUtils.preCheckCast(r10, C11521.class, "com.obric.aiagent.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r11 = b.a();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        Iterator<ITFLiteModel> r12 = (Iterator) ZeusTransformUtils.preCheckCast(r0.L$1, Iterator.class, "com.obric.aiagent.plugin");
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(r0.L$0, Context.class, "com.obric.aiagent.plugin");
        o.a(r6);
        Context r13 = r3;
    L16:
        if (r12.hasNext() == false) goto L21;
        ITFLiteModel r4 = (ITFLiteModel) ZeusTransformUtils.preCheckCast(r12.next(), ITFLiteModel.class, "com.obric.aiagent.plugin");
        r0.L$0 = r13;
        r0.L$1 = r12;
        r0.label = 1;
        if (r4.initialize(r13, r0) != r11) goto L16;
        return r11;
    L21:
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r6);
        r12 = mRegisteredModels.values().iterator();
        r13 = r9;
    L7:
        r0 = new C11521(this, r10);
        goto L8
    }

    private final Object deinitModels(d.c.d<? super x> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, C11501.class) == false) goto L7;
        C11501 r0 = (C11501) ZeusTransformUtils.preCheckCast(r7, C11501.class, "com.obric.aiagent.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r5 = r0.result;
        Object r8 = b.a();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        Iterator<ITFLiteModel> r3 = (Iterator) ZeusTransformUtils.preCheckCast(r0.L$0, Iterator.class, "com.obric.aiagent.plugin");
        o.a(r5);
    L16:
        if (r3.hasNext() == false) goto L21;
        ITFLiteModel r9 = (ITFLiteModel) ZeusTransformUtils.preCheckCast(r3.next(), ITFLiteModel.class, "com.obric.aiagent.plugin");
        r0.L$0 = r3;
        r0.label = 1;
        if (r9.deinitialize(r0) != r8) goto L16;
        return r8;
    L21:
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r5);
        r3 = mRegisteredModels.values().iterator();
    L7:
        r0 = new C11501(this, r7);
        goto L8
    }

    @Override // com.obric.autogui.common.api.model.IAutoActionLocalModelProvider
    public Object acquireImageClassifyModel(Context r8, String r9, d.c.d<? super com.obric.autogui.common.d<IAutoActionLocalModelProvider.ImageClassifyModel<String>>> r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r12, AnonymousClass1.class, "com.obric.aiagent.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = b.a();
        int r3 = r0.label;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L19;
        if (r3 != 2) goto L18;
        ITFLiteModel r7 = (ITFLiteModel) ZeusTransformUtils.preCheckCast(r0.L$1, ITFLiteModel.class, "com.obric.aiagent.plugin");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r0.L$0, String.class, "com.obric.aiagent.plugin");
        o.a(r13);     // Catch: Throwable -> L15
    L32:
        if (ZeusTransformUtils.instanceOf(r7, IAutoActionLocalModelProvider.ImageClassifyModel.class) == false) goto L34;
        IAutoActionLocalModelProvider.ImageClassifyModel r15 = (IAutoActionLocalModelProvider.ImageClassifyModel) ZeusTransformUtils.preCheckCast(r7, IAutoActionLocalModelProvider.ImageClassifyModel.class, "com.obric.aiagent.plugin");
    L35:
        if (r15 != null) goto L39;
        return com.obric.autogui.common.d.f29012a.a("model `" + r14 + "` is not an image classify model");
    L39:
        return com.obric.autogui.common.d.f29012a.a(r15);
    L34:
        r15 = null;
    L15:
        th = th;
    L42:
        Loog.INSTANCE.e(TAG, "failed to initialize model `" + r14 + "`: " + th, th);
        return com.obric.autogui.common.d.f29012a.a("failed to initialize model `" + r14 + '`');
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r9 = (String) ZeusTransformUtils.preCheckCast(r0.L$1, String.class, "com.obric.aiagent.plugin");
        r11 = (Context) ZeusTransformUtils.preCheckCast(r0.L$0, Context.class, "com.obric.aiagent.plugin");
        o.a(r13);
    L23:
        r7 = (ITFLiteModel) ZeusTransformUtils.preCheckCast(mRegisteredModels.get(r9), ITFLiteModel.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L26;
        r0.L$0 = r9;     // Catch: Throwable -> L40
        r0.L$1 = r7;     // Catch: Throwable -> L40
        r0.label = 2;     // Catch: Throwable -> L40
        if (r7.initialize(r11, r0) != r2) goto L30;
        return r2;
    L30:
        r14 = r9;
    L40:
        th = th;
        r14 = r9;
        goto L42
    L26:
        return com.obric.autogui.common.d.f29012a.a("model `" + r9 + "` not found");
    L20:
        o.a(r13);
        w<x> r16 = this.mInitDeferred;
        r0.L$0 = r11;
        r0.L$1 = r9;
        r0.label = 1;
        if (r16.a(r0) != r2) goto L23;
        return r2;
    L7:
        r0 = new AnonymousClass1(this, r12);
        goto L8
    }
}
