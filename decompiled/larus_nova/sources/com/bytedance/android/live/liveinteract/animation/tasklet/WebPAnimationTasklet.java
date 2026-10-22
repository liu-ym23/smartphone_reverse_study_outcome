package com.bytedance.android.live.liveinteract.animation.tasklet;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.SystemClock;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.cache.common.CacheKey;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class WebPAnimationTasklet extends b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f71153l = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HSImageView f71154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f71155d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.live.liveinteract.videotalk.emoji.model.n f71156e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public py.k f71157f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f71158g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageRequest f71159h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.live.liveinteract.animation.e f71160i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.bytedance.android.live.liveinteract.animation.tasklet.a f71161j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function2<d, Boolean, Unit> f71162k;

    public static final class a {
    }

    static {
    }

    public final void d() {
        HSImageView r100 = this.f71154c;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mWebPView");
    L5:
        DraweeController r101 = r100.getController();
        if (r101 == null) goto L10;
        Animatable r102 = r101.getAnimatable();
        if (r102 == null) goto L10;
        r102.stop();
    L10:
        HSImageView r103 = this.f71154c;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mWebPView");
    L13:
        r103.setController(null);
    }

    @Override // com.bytedance.android.live.liveinteract.animation.tasklet.d
    public final void start() {
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.n r100 = this.f71167a.f79402c;
        if (r100 == null) goto L16;
        this.f71156e = r100;
        List<py.k> r101 = this.f71168b.getResources();
        if (r101 == null) goto L16;
        if (r101.isEmpty() == true) goto L16;
        py.k r102 = (py.k) ListProtector.get(r101, 0);
        if (r102 == null) goto L16;
        if (r102.isValid() == false) goto L16;
        this.f71157f = r102;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.g r103 = this.f71167a.f79400a;
        if (r103 == null) goto L20;
        FrameLayout r104 = r103.a();
    L21:
        FrameLayout r105 = this.f71160i.vj();
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.n r106 = this.f71167a.f79402c;
        if (r106 == null) goto L26;
        Integer r107 = r106.f79395f;
        if (r107 == null) goto L26;
        int r108 = r107.intValue();
    L28:
        if (this.f71168b.getLevel() < r108) goto L31;
        if (r104 == null) goto L31;
    L32:
        this.f71155d = r104;
        boolean r109 = true;
    L33:
        if (r109 == true) goto L36;
        ALogger.e("InteractAnimation.WebPAnimationTasklet", "start#resource parse failed.");
        return;
    L36:
        HSImageView r110 = this.f71161j.b();
        this.f71154c = r110;
        if (r110 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("mWebPView");
    L39:
        r110.setVisibility(8);
        int r111 = this.f71168b.getLevel();
        FrameLayout r112 = this.f71155d;
        if (r112 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("mAnimContainer");
    L42:
        int r113 = r112.getChildCount();
        int r114 = 0;
    L43:
        if (r114 >= r113) goto L53;
        FrameLayout r115 = this.f71155d;
        if (r115 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("mAnimContainer");
    L47:
        Object r116 = r115.getChildAt(r114).getTag();
        if ((r116 instanceof com.bytedance.android.live.liveinteract.animation.a) == false) goto L52;
        if (((com.bytedance.android.live.liveinteract.animation.a) r116).f70963a <= r111) goto L52;
    L54:
        HSImageView r117 = this.f71154c;
        if (r117 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("mWebPView");
    L57:
        r117.setTag(new com.bytedance.android.live.liveinteract.animation.a(r111));
        FrameLayout r118 = this.f71155d;
        if (r118 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("mAnimContainer");
    L60:
        HSImageView r119 = this.f71154c;
        if (r119 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("mWebPView");
    L63:
        r118.addView(r119, r114);
        HSImageView r120 = this.f71154c;
        if (r120 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("mWebPView");
    L66:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r121 = this.f71168b;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.n r122 = this.f71156e;
        if (r122 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("mMP4Info");
    L69:
        PointF r123 = r122.f79390a;
        int r124 = r122.f79391b;
        int r125 = r122.f79392c;
        double r126 = r122.f79393d;
        double r127 = r124;
        double r128 = (r126 * 1.0d) / r127;
        double r129 = r122.f79394e;
        double r130 = r125;
        double r131 = (r129 * 1.0d) / r130;
        py.k r132 = this.f71157f;
        if (r132 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("mWebPImageModel");
    L72:
        int r133 = r132.getWidth();
        py.k r134 = this.f71157f;
        if (r134 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("mWebPImageModel");
    L75:
        double r135 = ((double) r133) * r128;
        double r136 = ((double) r134.getHeight()) * r131;
        double r137 = ((((double) r121.getX()) * 1.0d) / r127) * r126;
        double r138 = ((((double) r121.getY()) * 1.0d) / r130) * r129;
        int[] r139 = new int[2];
        FrameLayout r140 = this.f71155d;
        if (r140 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("mAnimContainer");
    L78:
        r140.getLocationOnScreen(r139);
        float r141 = 2;
        r120.setX((((float) (r137 + ((double) r123.x))) - (((float) r135) / r141)) - r139[0]);
        r120.setY((((float) (r138 + ((double) r123.y))) - (((float) r136) / r141)) - r139[1]);
        ViewGroup.LayoutParams r142 = r120.getLayoutParams();
        if (r142 != null) goto L81;
        r142 = new FrameLayout.LayoutParams(-2, -2);
    L81:
        r142.width = (int) r135;
        r142.height = (int) r136;
        r120.setLayoutParams(r142);
        final long r143 = SystemClock.uptimeMillis();
        Function1<Boolean, Unit> r144 = new AnonymousClass1(this, r143);
        HSImageView r145 = this.f71154c;
        if (r145 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("mWebPView");
    L84:
        r145.setVisibility(0);
        py.k r146 = this.f71157f;
        if (r146 != null) goto L87;
        Intrinsics.throwUninitializedPropertyAccessException("mWebPImageModel");
    L87:
        ImageRequest[] r147 = a1.b(r146, 1);
        if (this.f71159h != null) goto L93;
        if (r147 == null) goto L91;
        ImageRequest r148 = r147[0];
    L92:
        this.f71159h = r148;
        goto L93
    L91:
        r148 = null;
    L93:
        AbstractDraweeController r149 = Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(r147).setAutoPlayAnimations(false).setControllerListener(new f0(this, r144)).build();
        if (vm2.d.G() == true) goto L96;
    L107:
        HSImageView r150 = this.f71154c;
        if (r150 != null) goto L110;
        Intrinsics.throwUninitializedPropertyAccessException("mWebPView");
    L110:
        r150.setController(r149);
        return;
    L96:
        if ((r149 instanceof PipelineDraweeController) == false) goto L107;
        PipelineDraweeController r151 = (PipelineDraweeController) r149;
        HSImageView r152 = this.f71154c;
        if (r152 != null) goto L100;
        Intrinsics.throwUninitializedPropertyAccessException("mWebPView");
    L100:
        Context r153 = r152.getContext();
        if (r147 == null) goto L105;
        ImageRequest r154 = r147[0];
        if (r154 == null) goto L105;
        Uri r155 = r154.getSourceUri();
    L106:
        com.bytedance.android.live.core.utils.fresco.c.a(r151, r153, String.valueOf(r155));
    L105:
        r155 = null;
    L52:
        r114 = r114 + 1;
        goto L43
    L53:
        r114 = -1;
    L31:
        r104 = r105;
    L26:
        r108 = 5;
        goto L28
    L20:
        r104 = null;
    L16:
        r109 = false;
        goto L33
    }

    @Override // com.bytedance.android.live.liveinteract.animation.tasklet.d
    public final void stop() {
        d();
        HSImageView r100 = this.f71154c;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mWebPView");
    L5:
        r100.post(new g0(this));
    }

    public static final /* synthetic */ HSImageView b(WebPAnimationTasklet r100) {
        HSImageView r101 = r100.f71154c;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mWebPView");
    L5:
        return r101;
    }

    public static final void c(WebPAnimationTasklet r100) {
        if (r100.f71158g == true) goto L15;
        Function2<d, Boolean, Unit> r101 = r100.f71162k;
        if (r101 == null) goto L8;
        Unit r102 = r101.invoke(r100, Boolean.FALSE);
    L8:
        r100.stop();
        if (vm2.d.G() == false) goto L13;
        CountingMemoryCache<CacheKey, CloseableImage> r103 = com.bytedance.android.live.core.utils.fresco.e.f66139a;
        if (r103 == null) goto L13;
        r103.removeAll(new d0(r100));
    L13:
        r100.f71158g = true;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WebPAnimationTasklet(com.bytedance.android.live.liveinteract.videotalk.emoji.model.p r100, com.bytedance.android.live.liveinteract.animation.c r101, com.bytedance.android.live.liveinteract.animation.e r102, com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r103, com.bytedance.android.live.liveinteract.animation.tasklet.a r104, Function2<? super d, ? super Boolean, Unit> r105) {
        Intrinsics.checkNotNullParameter(r100, "revenueData");
        Intrinsics.checkNotNullParameter(r101, "mTask");
        Intrinsics.checkNotNullParameter(r102, "mSeatInfoProvider");
        Intrinsics.checkNotNullParameter(r103, "animationData");
        Intrinsics.checkNotNullParameter(r104, "mViewProvider");
        super(r100, r103);
        this.f71160i = r102;
        this.f71161j = r104;
        this.f71162k = r105;
    }
}
