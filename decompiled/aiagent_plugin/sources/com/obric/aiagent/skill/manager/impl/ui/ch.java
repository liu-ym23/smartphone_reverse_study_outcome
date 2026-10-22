package com.obric.aiagent.skill.manager.impl.ui;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.obric.aiagent.skill.manager.impl.ee;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillSourceIconBinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ch f20743a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f20744b;

    /* JADX INFO: compiled from: SkillSourceIconBinder.kt */
    public static final class a extends BaseControllerListener<ImageInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SimpleDraweeView f20745a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ cj f20746b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ch f20747c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextView f20748d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f20749e;
        final /* synthetic */ String f;

        a(SimpleDraweeView r3, cj r4, ch r5, TextView r6, float r7, String r8) {
            this.f20745a = (SimpleDraweeView) ZeusTransformUtils.wrapperContextForParams(r3, SimpleDraweeView.class, "com.obric.aiagent.plugin");
            this.f20746b = r4;
            this.f20747c = r5;
            this.f20748d = r6;
            this.f20749e = r7;
            this.f = r8;
        }
    }

    static {
        f20743a = new ch();
    }

    private ch() {
    }

    public final void a(SimpleDraweeView r19, TextView r20, String r21, float r22) {
        SimpleDraweeView r9 = (SimpleDraweeView) ZeusTransformUtils.wrapperContextForParams(r19, SimpleDraweeView.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "imageView");
        d.h.b.o.e(r20, "sourceText");
        ((GenericDraweeHierarchy) ZeusTransformUtils.preCheckCast(r9.getHierarchy(), GenericDraweeHierarchy.class, "com.obric.aiagent.plugin")).setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        GenericDraweeHierarchy r1 = (GenericDraweeHierarchy) ZeusTransformUtils.preCheckCast(r9.getHierarchy(), GenericDraweeHierarchy.class, "com.obric.aiagent.plugin");
        RoundingParams r2 = ((GenericDraweeHierarchy) ZeusTransformUtils.preCheckCast(r9.getHierarchy(), GenericDraweeHierarchy.class, "com.obric.aiagent.plugin")).getRoundingParams();
        if (r2 == null) goto L7;
        RoundingParams r3 = r2.setCornersRadius(a(r9, r22));
        if (r3 == null) goto L7;
    L8:
        r1.setRoundingParams(r3);
        if (r21 != null) goto L11;
        String r6 = "";
    L13:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L16;
        r9.setTag(null);
        r9.setController(null);
        a(r9, r20, false);
        return;
    L16:
        int r4 = ci.f20750a.a(r22, ZeusTransformUtils.getResources(r9, "com.obric.aiagent.plugin").getDisplayMetrics().density);
        String r11 = ci.f20750a.a(r6);
        Object r5 = r9.getTag();
        if (ZeusTransformUtils.instanceOf(r5, cj.class) == false) goto L19;
        cj r7 = (cj) ZeusTransformUtils.preCheckCast(r5, cj.class, "com.obric.aiagent.plugin");
    L20:
        a(r9, r20, true);
        ci r10 = ci.f20750a;
        if (r9.getController() == null) goto L23;
        boolean r12 = true;
    L25:
        if (r10.a(r7, r11, r4, r12) == true) goto L29;
        if (r7 == null) goto L50;
        r7.a(r6);
        return;
    L50:
        return;
    L29:
        cj r8 = new cj(r11, r4, r6, false, 8, null);
        r9.setTag(r8);
        d.n.a r13 = d.n.f38560a;     // Catch: Throwable -> L36
        ch r14 = (ch) ZeusTransformUtils.preCheckCast(this, ch.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L36
        r14.a(r9);     // Catch: Throwable -> L36
        cj r15 = r8;
        DraweeController r16 = null;
        boolean r17 = false;
        r9.setController((DraweeController) ZeusTransformUtils.preCheckCast(((PipelineDraweeControllerBuilder) ZeusTransformUtils.preCheckCast(((PipelineDraweeControllerBuilder) ZeusTransformUtils.preCheckCast(((PipelineDraweeControllerBuilder) ZeusTransformUtils.preCheckCast(((PipelineDraweeControllerBuilder) ZeusTransformUtils.preCheckCast(Fresco.newDraweeControllerBuilder().setOldController(r9.getController()), PipelineDraweeControllerBuilder.class, "com.obric.aiagent.plugin")).setImageRequest(ImageRequestBuilder.newBuilderWithSource(Uri.parse(r6)).setResizeOptions(new ResizeOptions(r4, r4)).build()), PipelineDraweeControllerBuilder.class, "com.obric.aiagent.plugin")).setAutoPlayAnimations(true), PipelineDraweeControllerBuilder.class, "com.obric.aiagent.plugin")).setControllerListener((ControllerListener) ZeusTransformUtils.preCheckCast(new a(r9, r8, r14, r20, r22, r6), ControllerListener.class, "com.obric.aiagent.plugin")), PipelineDraweeControllerBuilder.class, "com.obric.aiagent.plugin")).build(), DraweeController.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L34
        Object r0 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L34
    L39:
        Throwable r18 = d.n.c(r0);
        if (r18 != null) goto L42;
        return;
    L42:
        if (r9.getTag() != r15) goto L44;
        r9.setTag(r16);
        r9.setController(r16);
        f20743a.a(r9, r20, r17);
    L44:
        ee.f19808a.a("SkillManager", "Failed to bind skill source icon", "Failed to bind skill source icon", r18);
        return;
    L34:
        th = th;
    L38:
        d.n.a r23 = d.n.f38560a;
        r0 = d.n.f(d.o.a(th));
    L36:
        th = th;
        r15 = r8;
        r17 = false;
        r16 = null;
        goto L38
    L23:
        r12 = false;
        goto L25
    L19:
        r7 = null;
        goto L20
    L11:
        r6 = r21;
    L7:
        r3 = RoundingParams.fromCornersRadius(a(r9, r22));
        goto L8
    }

    private final void a(SimpleDraweeView r6, TextView r7, boolean r8) {
        SimpleDraweeView r9 = (SimpleDraweeView) ZeusTransformUtils.wrapperContextForParams(r6, SimpleDraweeView.class, "com.obric.aiagent.plugin");
        ViewParent r0 = r9.getParent();
        ViewGroup.MarginLayoutParams r3 = null;
        if (ZeusTransformUtils.instanceOf(r0, View.class) == false) goto L5;
        View r1 = (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin");
    L6:
        int r2 = 0;
        if (r1 == null) goto L12;
        if (r8 == false) goto L10;
        int r4 = 0;
    L11:
        r1.setVisibility(r4);
        goto L12
    L10:
        r4 = 8;
    L12:
        ViewGroup.LayoutParams r5 = r7.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r5, ViewGroup.MarginLayoutParams.class) == false) goto L15;
        r3 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
    L15:
        if (r3 != null) goto L17;
        return;
    L17:
        if (r8 == false) goto L20;
        r2 = (int) a(r9, 4.0f);
    L20:
        if (r3.getMarginStart() == r2) goto L23;
        r3.setMarginStart(r2);
        r7.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    L23:
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final void a(SimpleDraweeView r3) {
        SimpleDraweeView r2 = (SimpleDraweeView) ZeusTransformUtils.wrapperContextForParams(r3, SimpleDraweeView.class, "com.obric.aiagent.plugin");
        if (f20744b == false) goto L8;
        if (Fresco.hasBeenInitialized() == false) goto L8;
        return;
    L8:
        if (Fresco.hasBeenInitialized() == true) goto L10;
        Fresco.initialize((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        SimpleDraweeView.enableLazySize(true);
    L10:
        f20744b = true;
    }

    private final float a(SimpleDraweeView r2, float r3) {
        return r3 * ZeusTransformUtils.getResources((SimpleDraweeView) ZeusTransformUtils.wrapperContextForParams(r2, SimpleDraweeView.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDisplayMetrics().density;
    }
}
