package com.obric.aiagent.skill.manager.impl.ui;

import android.content.Context;
import android.net.Uri;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.obric.aiagent.plugin.R;
import com.obric.aiagent.skill.manager.impl.ee;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillCoverBinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f20812a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f20813b;

    /* JADX INFO: compiled from: SkillCoverBinder.kt */
    public static final class a extends BaseControllerListener<ImageInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SimpleDraweeView f20814a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ u f20815b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ s f20816c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f20817d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f20818e;
        final /* synthetic */ String f;
        final /* synthetic */ String g;
        final /* synthetic */ String h;

        a(SimpleDraweeView r3, u r4, s r5, float r6, boolean r7, String r8, String r9, String r10) {
            this.f20814a = (SimpleDraweeView) ZeusTransformUtils.wrapperContextForParams(r3, SimpleDraweeView.class, "com.obric.aiagent.plugin");
            this.f20815b = r4;
            this.f20816c = r5;
            this.f20817d = r6;
            this.f20818e = r7;
            this.f = r8;
            this.g = r9;
            this.h = r10;
        }
    }

    static {
        f20812a = new s();
    }

    private s() {
    }

    public static /* synthetic */ void a(s r6, SimpleDraweeView r7, String r8, float r9, boolean r10, String r11, int r12, Object r13) {
        SimpleDraweeView r1 = (SimpleDraweeView) ZeusTransformUtils.wrapperContextForParams(r7, SimpleDraweeView.class, "com.obric.aiagent.plugin");
        if ((r12 & 8) == 0) goto L5;
        r10 = false;
    L5:
        boolean r4 = r10;
        if ((r12 & 16) == 0) goto L8;
        r11 = "cover";
    L8:
        r6.a(r1, r8, r9, r4, r11);
    }

    public final void a(SimpleDraweeView r19, String r20, float r21, boolean r22, String r23) {
        SimpleDraweeView r11 = (SimpleDraweeView) ZeusTransformUtils.wrapperContextForParams(r19, SimpleDraweeView.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "imageView");
        d.h.b.o.e(r23, "failureLogTarget");
        if (r20 != null) goto L5;
        String r12 = "";
    L6:
        float r13 = a(r11, r21);
        String r14 = t.f20819a.a(r12);
        Object r1 = r11.getTag();
        if (ZeusTransformUtils.instanceOf(r1, u.class) == false) goto L9;
        u r6 = (u) ZeusTransformUtils.preCheckCast(r1, u.class, "com.obric.aiagent.plugin");
    L10:
        boolean r4 = false;
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L28;
        if (r6 == null) goto L14;
        String r2 = r6.a();
    L16:
        if (d.h.b.o.a(r2, r14) == true) goto L18;
    L26:
        r11.setTag(new u(r14, r13, r22, r12));
        r11.setController(null);
        r11.setHierarchy((DraweeHierarchy) ZeusTransformUtils.preCheckCast(a(r11, r13, r22, true), DraweeHierarchy.class, "com.obric.aiagent.plugin"));
        return;
    L18:
        if (r6.b() != r13) goto L20;
        r4 = true;
    L20:
        if (r4 == false) goto L26;
        if (r6.c() != r22) goto L26;
        if (d.h.b.o.a(r6.d(), r12) == false) goto L26;
        return;
    L14:
        r2 = null;
        goto L16
    L28:
        t r3 = t.f20819a;
        if (r11.getController() == null) goto L31;
        boolean r16 = true;
    L32:
        u r15 = r6;
        if (r3.a(r6, r14, r13, r22, r16) == true) goto L37;
        if (r15 == null) goto L66;
        r15.a(r12);
        return;
    L66:
        return;
    L37:
        if (r15 != null) goto L39;
    L49:
        boolean r5 = true;
    L50:
        if (r5 == false) goto L52;
        r11.setHierarchy((DraweeHierarchy) ZeusTransformUtils.preCheckCast(a(r11, r13, r22, false), DraweeHierarchy.class, "com.obric.aiagent.plugin"));
    L52:
        u r17 = new u(r14, r13, r22, r12);
        r11.setTag(r17);
        d.n.a r7 = d.n.f38560a;     // Catch: Throwable -> L55
        s r8 = (s) ZeusTransformUtils.preCheckCast(this, s.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L55
        r8.a(r11);     // Catch: Throwable -> L55
        r11.setController((DraweeController) ZeusTransformUtils.preCheckCast(((PipelineDraweeControllerBuilder) ZeusTransformUtils.preCheckCast(((PipelineDraweeControllerBuilder) ZeusTransformUtils.preCheckCast(((PipelineDraweeControllerBuilder) ZeusTransformUtils.preCheckCast(Fresco.newDraweeControllerBuilder().setOldController(r11.getController()), PipelineDraweeControllerBuilder.class, "com.obric.aiagent.plugin")).setImageRequest(ImageRequestBuilder.newBuilderWithSource(Uri.parse(r12)).build()), PipelineDraweeControllerBuilder.class, "com.obric.aiagent.plugin")).setControllerListener((ControllerListener) ZeusTransformUtils.preCheckCast(new a(r11, r17, r8, r21, r22, r23, r12, r12), ControllerListener.class, "com.obric.aiagent.plugin")), PipelineDraweeControllerBuilder.class, "com.obric.aiagent.plugin")).build(), DraweeController.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L55
        Object r0 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L55
    L57:
        Throwable r9 = d.n.c(r0);
        if (r9 != null) goto L60;
        return;
    L60:
        if (r11.getTag() != r17) goto L62;
        r11.setTag(null);
        r11.setController(null);
    L62:
        ee.f19808a.a("SkillManager", "Failed to bind skill " + r23, "Failed to bind skill " + r23 + ": " + r12, r9);
        return;
    L55:
        th = move-exception;
        d.n.a r10 = d.n.f38560a;
        r0 = d.n.f(d.o.a(th));
        goto L57
    L39:
        if (d.h.b.o.a(r15.a(), r14) == false) goto L49;
        if (r15.b() != r13) goto L43;
        boolean r18 = true;
    L44:
        if (r18 == false) goto L49;
        if (r15.c() != r22) goto L49;
        r5 = false;
        goto L50
    L43:
        r18 = false;
        goto L44
    L31:
        r16 = false;
        goto L32
    L9:
        r6 = null;
        goto L10
    L5:
        r12 = r20;
        goto L6
    }

    private final GenericDraweeHierarchy a(SimpleDraweeView r2, float r3, boolean r4, boolean r5) {
        GenericDraweeHierarchyBuilder r1 = new GenericDraweeHierarchyBuilder(ZeusTransformUtils.getResources((SimpleDraweeView) ZeusTransformUtils.wrapperContextForParams(r2, SimpleDraweeView.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin")).setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP).setRoundingParams(RoundingParams.fromCornersRadius(r3));
        if (r5 == false) goto L7;
        if (r4 == false) goto L7;
        r1.setPlaceholderImage(ZeusTransformUtils.mapRes(R.drawable.skill_default_logo, "drawable", "skill_default_logo"), ScalingUtils.ScaleType.CENTER_INSIDE);
    L7:
        return r1.build();
    }

    private final void a(SimpleDraweeView r3) {
        SimpleDraweeView r2 = (SimpleDraweeView) ZeusTransformUtils.wrapperContextForParams(r3, SimpleDraweeView.class, "com.obric.aiagent.plugin");
        if (f20813b == false) goto L8;
        if (Fresco.hasBeenInitialized() == false) goto L8;
        return;
    L8:
        if (Fresco.hasBeenInitialized() == true) goto L10;
        Fresco.initialize((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        SimpleDraweeView.enableLazySize(true);
    L10:
        f20813b = true;
    }

    private final float a(SimpleDraweeView r2, float r3) {
        return r3 * ZeusTransformUtils.getResources((SimpleDraweeView) ZeusTransformUtils.wrapperContextForParams(r2, SimpleDraweeView.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDisplayMetrics().density;
    }
}
