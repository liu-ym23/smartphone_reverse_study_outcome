package com.bytedance.android.live.liveinteract.animation.tasklet;

import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.utils.EPointF;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.gift.model.o0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class z extends com.bytedance.android.live.liveinteract.animation.tasklet.b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f71265i = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f71266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HSImageView f71267d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f71268e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f71269f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final o0 f71270g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.live.liveinteract.animation.e f71271h;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f71272a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HSImageView f71273b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ z f71274c;

        public b(FrameLayout r100, HSImageView r101, z r102) {
            this.f71272a = r100;
            this.f71273b = r101;
            this.f71274c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f71272a.removeView(this.f71273b);     // Catch: Throwable -> L4
            m r100 = this.f71274c.f71266c;     // Catch: Throwable -> L4
            r100.getClass();     // Catch: Throwable -> L4
            c0.f71172a.remove(r100.f71210a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.animation.tasklet.d
    public final void start() {
        StringBuilder r100 = new StringBuilder("SenderSeatTasklet.");
        o0 r101 = this.f71270g;
        py.k r102 = null;
        if (r101 == null) goto L5;
        py.k r103 = r101.getTrayDynamicImg();
    L6:
        r100.append(r103);
        ALogger.i("InteractAnimation.SenderSeatTasklet", r100.toString());
        m r104 = this.f71266c;
        r104.getClass();
        HashMap<String, HSImageView> r105 = c0.f71172a;
        HSImageView r106 = r105.get(r104.f71210a);
        if (r106 == null) goto L13;
        DraweeController r107 = r106.getController();
        if (r107 == null) goto L14;
        Animatable r108 = r107.getAnimatable();
        if (r108 == null) goto L14;
        r108.stop();
    L14:
        this.f71267d = r106;
        FrameLayout r109 = this.f71271h.vj();
        if (r106.getParent() != null) goto L17;
        r109.addView(r106);
    L17:
        int r110 = 0;
        boolean r111 = true;
        if (r106.getController() != null) goto L23;
        o0 r112 = this.f71270g;
        if (r112 == null) goto L22;
        r102 = r112.getTrayDynamicImg();
    L22:
        r106.setController(Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(a1.b(r102, 1)).setAutoPlayAnimations(false).setControllerListener(new b0(this, r106)).build());
    L28:
        int[] r113 = new int[2];
        this.f71271h.vj().getLocationOnScreen(r113);
        ViewGroup.LayoutParams r114 = r106.getLayoutParams();
        r114.width = (int) s1.e(50.0f);
        r114.height = (int) s1.e(50.0f);
        r106.setLayoutParams(r114);
        PointF r115 = this.f71167a.f79403d.f79396a;
        if (r115 == null) goto L74;
        r106.setX((r115.x - r113[0]) - (r106.getLayoutParams().width / 2));
        r106.setY((r115.y - r113[1]) - (r106.getLayoutParams().height / 2));
        String r116 = (String) ListProtector.get(this.f71167a.f79403d.f79397b, 0);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.s r117 = this.f71167a.f79401b.f79385m;
        EPointF r118 = this.f71271h.Mj(r116);
        if (r118 != null) goto L35;
    L37:
        r111 = false;
    L38:
        float r119 = 0.0f;
        if (r111 == false) goto L56;
        r106.setScaleX(-1.0f);
        int r120 = ed0.a.f472184a;
        if (r117 == null) goto L43;
        r110 = r117.a();
    L43:
        int r121 = -r110;
        int r122 = this.f71269f;
        Intrinsics.checkNotNullParameter(r115, "centerPoint");
        if (r118 == null) goto L55;
        PointF r123 = new PointF();
        double r124 = Math.toRadians(r121);
        float r125 = r122 / 2.0f;
        if ((r121 % 90) != 0) goto L53;
        if (r121 >= 0) goto L50;
        r123.x = r115.x;
        r123.y = r115.y - (r122 / 2);
    L54:
        r119 = ed0.b.a(r115, r123, r118);
        goto L55
    L50:
        if (r121 != 0) goto L52;
        r123.x = r115.x - r125;
        r123.y = r115.y;
        goto L54
    L52:
        r123.x = r115.x;
        r123.y = r115.y + (r122 / 2);
        goto L54
    L53:
        r123.x = r115.x - r125;
        r123.y = (float) (((double) r115.y) + ((Math.tan(r124) * ((double) r122)) / ((double) 2.0f)));
    L55:
        r106.setRotation(r119);
        return;
    L56:
        r106.setScaleX(1.0f);
        int r126 = ed0.a.f472184a;
        if (r117 == null) goto L59;
        r110 = r117.a();
    L59:
        int r127 = -r110;
        int r128 = this.f71269f;
        Intrinsics.checkNotNullParameter(r115, "centerPoint");
        if (r118 == null) goto L71;
        double r129 = Math.toRadians(r127);
        float r130 = r128 / 2.0f;
        PointF r131 = new PointF();
        if ((r127 % 90) != 0) goto L69;
        if (r127 >= 0) goto L66;
        r131.x = r115.x;
        r131.y = r115.y - (r128 / 2);
    L70:
        r119 = ed0.b.a(r115, r131, r118);
        goto L71
    L66:
        if (r127 != 0) goto L68;
        r131.x = r115.x + r130;
        r131.y = r115.y;
        goto L70
    L68:
        r131.x = r115.x;
        r131.y = r115.y + (r128 / 2);
        goto L70
    L69:
        r131.x = r115.x + r130;
        r131.y = (float) (((double) r115.y) + (Math.tan(r129) * ((double) r130)));
    L71:
        r106.setRotation(r119);
        return;
    L35:
        if (r115.x <= ((PointF) r118).x) goto L37;
    L74:
        return;
    L23:
        DraweeController r132 = r106.getController();
        if (r132 == null) goto L28;
        Animatable r133 = r132.getAnimatable();
        if (r133 == null) goto L28;
        AnimatedDrawable2 r134 = (AnimatedDrawable2) r133;
        r134.setAnimationListener(new a0(this, r106));
        com.bytedance.android.live.core.utils.fresco.c.b(r134);
        r133.start();
        goto L28
    L13:
        r106 = r104.f71211b.b();
        r105.put(r104.f71210a, r106);
        goto L14
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.animation.tasklet.d
    public final void stop() {
        HSImageView r100 = this.f71267d;
        if (r100 == null) goto L15;
        DraweeController r101 = r100.getController();
        if (r101 == null) goto L9;
        Animatable r102 = r101.getAnimatable();
        if (r102 == null) goto L9;
        r102.stop();
    L9:
        DraweeController r103 = r100.getController();
        if (r103 == null) goto L12;
        Animatable r104 = r103.getAnimatable();
    L13:
        b(r100, r104);
        return;
    L12:
        r104 = null;
        goto L13
    }

    public final void b(HSImageView r100, Animatable r101) {
        StringBuilder r102 = new StringBuilder("onAnimationStop.Tasklet:");
        r102.append(hashCode());
        r102.append(",drawable:");
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        r102.append(r103);
        r102.append(",running:");
        if (r101 == null) goto L9;
        Boolean r104 = Boolean.valueOf(r101.isRunning());
    L10:
        r102.append(r104);
        ALogger.d("InteractAnimation.SenderSeatTasklet", r102.toString());
        if (this.f71268e == false) goto L13;
        return;
    L13:
        DraweeController r105 = r100.getController();
        if (r105 == null) goto L19;
        Animatable r106 = r105.getAnimatable();
        if (r106 == null) goto L19;
        if (r106.isRunning() != true) goto L19;
    L20:
        this.f71268e = true;
        return;
    L19:
        r100.setController(null);
        FrameLayout r107 = this.f71271h.vj();
        r107.post(new b(r107, r100, this));
        goto L20
    L9:
        r104 = null;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public z(com.bytedance.android.live.liveinteract.videotalk.emoji.model.p r100, com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r101, o0 r102, com.bytedance.android.live.liveinteract.animation.e r103, com.bytedance.android.live.liveinteract.animation.tasklet.a r104) {
        Intrinsics.checkNotNullParameter(r100, "revenueData");
        Intrinsics.checkNotNullParameter(r101, "animationData");
        Intrinsics.checkNotNullParameter(r103, "mSeatInfoProvider");
        Intrinsics.checkNotNullParameter(r104, "mAnimationViewProvider");
        super(r100, r101);
        this.f71270g = r102;
        this.f71271h = r103;
        String r105 = r100.f79401b.f79374b;
        if (r105 != null) goto L5;
        r105 = "";
    L5:
        this.f71266c = new m(r105, r104);
        this.f71269f = (int) s1.e(50.0f);
    }
}
