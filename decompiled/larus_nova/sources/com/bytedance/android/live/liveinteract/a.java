package com.bytedance.android.live.liveinteract;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Animatable;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class a {
    public boolean A;
    public boolean B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f70869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f70870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f70871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SimpleDraweeView f70872d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f70873e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f70874f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f70875g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Interpolator f70876h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<ObjectAnimator> f70877i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f70878j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ObjectAnimator f70879k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ObjectAnimator f70880l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ObjectAnimator f70881m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ObjectAnimator f70882n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ObjectAnimator f70883o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ObjectAnimator f70884p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ObjectAnimator f70885q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ObjectAnimator f70886r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ObjectAnimator f70887s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ObjectAnimator f70888t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ObjectAnimator f70889u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ObjectAnimator f70890v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final AnimatorSet f70891w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final AnimatorSet f70892x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final AnimatorSet f70893y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final AnimatorSet f70894z;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.a$a, reason: collision with other inner class name */
    public static final class C1145a {
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f70895a;

        /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.a$b$a, reason: collision with other inner class name */
        public static final class RunnableC1146a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f70896a;

            public RunnableC1146a(b r100) {
                this.f70896a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a r100 = this.f70896a.f70895a;     // Catch: Throwable -> L6
                if (r100.A == false) goto L9;
                r100.f70881m.start();     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.a$b$b, reason: collision with other inner class name */
        public static final class RunnableC1147b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f70897a;

            public RunnableC1147b(b r100) {
                this.f70897a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a r100 = this.f70897a.f70895a;     // Catch: Throwable -> L6
                if (r100.A == false) goto L9;
                r100.f70892x.start();     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        public b(a r100) {
            this.f70895a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationEnd(r100);
            this.f70895a.f70873e.postDelayed(new RunnableC1146a(this), 300);
            this.f70895a.f70873e.postDelayed(new RunnableC1147b(this), 2000);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationStart(r100);
            this.f70895a.f70874f.setVisibility(0);
            this.f70895a.f70875g.setVisibility(0);
            this.f70895a.f70873e.setVisibility(0);
        }
    }

    public static final class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f70898a;

        /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.a$c$a, reason: collision with other inner class name */
        public static final class RunnableC1148a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f70899a;

            public RunnableC1148a(c r100) {
                this.f70899a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a r100 = this.f70899a.f70898a;     // Catch: Throwable -> L8
                if (r100.A == true) goto L5;
                return;
            L5:
                if (r100.B == false) goto L15;
                r100.f70894z.start();     // Catch: Throwable -> L8
                return;
            L15:
                return;
            L8:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L16;
                throw th;
            }
        }

        public c(a r100) {
            this.f70898a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationEnd(r100);
            a r101 = this.f70898a;
            r101.B = true;
            r101.f70873e.postDelayed(new RunnableC1148a(this), 5000);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationStart(r100);
            this.f70898a.f70869a.setVisibility(0);
        }
    }

    public static final class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f70900a;

        /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.a$d$a, reason: collision with other inner class name */
        public static final class RunnableC1149a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f70901a;

            public RunnableC1149a(d r100) {
                this.f70901a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a r100 = this.f70901a.f70900a;     // Catch: Throwable -> L6
                if (r100.A == false) goto L9;
                r100.f70894z.start();     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        public d(a r100) {
            this.f70900a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationEnd(r100);
            this.f70900a.f70873e.postDelayed(new RunnableC1149a(this), 1300);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationStart(r100);
            this.f70900a.f70871c.setVisibility(0);
            this.f70900a.f70870b.setVisibility(0);
        }
    }

    public static final class e extends BaseControllerListener<ImageInfo> {
        public e() {
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
            Intrinsics.checkNotNullParameter(r100, "id");
            super.onFinalImageSet(r100, (ImageInfo) r101, r102);
            if ((r102 instanceof AnimatedDrawable2) == false) goto L6;
            AnimatedDrawable2 r103 = (AnimatedDrawable2) r102;
            r103.setAnimationListener(new com.bytedance.android.live.liveinteract.b(r103.getFrameCount(), r102));
            return;
        }
    }

    static {
    }

    public abstract void c();

    public final void d() {
        this.B = false;
        this.f70882n.cancel();
        this.f70881m.cancel();
        this.f70874f.setAlpha(0.0f);
        this.f70873e.setAlpha(1.0f);
        this.f70893y.start();
        e r100 = new e();
        this.f70872d.setVisibility(0);
        this.f70872d.setController(Fresco.newDraweeControllerBuilder().setUri("https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_fast_invite_tick.webp").setAutoPlayAnimations(true).setControllerListener(r100).build());
    }

    public void a() {
        this.f70891w.addListener(new b(this));
        this.f70892x.addListener(new c(this));
        this.f70893y.addListener(new d(this));
    }

    public void b() {
        this.f70873e.setAlpha(1.0f);
        this.f70869a.setAlpha(1.0f);
        this.f70874f.setAlpha(1.0f);
        this.f70870b.setAlpha(0.0f);
        this.f70871c.setAlpha(1.0f);
        this.f70872d.setAlpha(1.0f);
        this.f70875g.setScaleX(1.0f);
        this.f70873e.setVisibility(4);
        this.f70869a.setVisibility(4);
        this.f70875g.setVisibility(4);
        this.f70874f.setVisibility(4);
        this.f70870b.setVisibility(4);
        this.f70871c.setVisibility(4);
        this.f70872d.setVisibility(4);
        this.A = false;
        this.B = false;
    }

    public a(View r110) {
        Intrinsics.checkNotNullParameter(r110, "itemView");
        TextView r100 = (TextView) r110.findViewById(R.id.invite_text);
        this.f70869a = r100;
        View r101 = r110.findViewById(R.id.shader);
        this.f70870b = r101;
        TextView r102 = (TextView) r110.findViewById(R.id.has_invited_text);
        this.f70871c = r102;
        SimpleDraweeView r103 = (SimpleDraweeView) r110.findViewById(R.id.tick);
        this.f70872d = r103;
        ImageView r104 = (ImageView) r110.findViewById(R.id.avatar);
        this.f70873e = r104;
        TextView r105 = (TextView) r110.findViewById(R.id.online_text);
        this.f70874f = r105;
        this.f70875g = r110.findViewById(R.id.guide_button_bg);
        Interpolator r111 = PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f);
        this.f70876h = r111;
        ArrayList r106 = new ArrayList();
        this.f70877i = r106;
        ObjectAnimator r107 = ObjectAnimator.ofFloat(r104, "alpha", new float[]{0.0f, 1.0f});
        r107.setDuration(400);
        r107.setInterpolator(r111);
        r106.add(r107);
        Unit r112 = Unit.INSTANCE;
        this.f70879k = r107;
        ObjectAnimator r108 = ObjectAnimator.ofFloat(r105, "alpha", new float[]{0.0f, 1.0f});
        r108.setDuration(400);
        r108.setInterpolator(r111);
        r106.add(r108);
        this.f70880l = r108;
        ObjectAnimator r109 = ObjectAnimator.ofFloat(r104, "alpha", new float[]{1.0f, 0.5f, 1.0f});
        r109.setDuration(1600);
        r109.setRepeatCount(4);
        r109.setInterpolator(r111);
        r106.add(r109);
        this.f70881m = r109;
        ObjectAnimator r113 = ObjectAnimator.ofFloat(r105, "alpha", new float[]{1.0f, 0.0f});
        r113.setDuration(300);
        r106.add(r113);
        this.f70882n = r113;
        ObjectAnimator r114 = ObjectAnimator.ofFloat(r100, "alpha", new float[]{0.0f, 1.0f});
        r114.setDuration(400);
        r106.add(r114);
        this.f70883o = r114;
        ObjectAnimator r115 = ObjectAnimator.ofFloat(r102, "alpha", new float[]{0.0f, 1.0f});
        r115.setDuration(400);
        r106.add(r115);
        this.f70884p = r115;
        ObjectAnimator r116 = ObjectAnimator.ofFloat(r100, "alpha", new float[]{1.0f, 0.0f});
        r116.setDuration(300);
        r106.add(r116);
        this.f70885q = r116;
        ObjectAnimator r117 = ObjectAnimator.ofFloat(r101, "alpha", new float[]{0.0f, 0.5f});
        r117.setDuration(400);
        r106.add(r117);
        this.f70886r = r117;
        ObjectAnimator r118 = ObjectAnimator.ofFloat(r103, "alpha", new float[]{1.0f, 0.0f});
        r118.setDuration(300);
        r106.add(r118);
        this.f70887s = r118;
        ObjectAnimator r119 = ObjectAnimator.ofFloat(r102, "alpha", new float[]{1.0f, 0.0f});
        r119.setDuration(300);
        r106.add(r119);
        this.f70888t = r119;
        ObjectAnimator r120 = ObjectAnimator.ofFloat(r104, "alpha", new float[]{1.0f, 0.0f});
        r120.setDuration(300);
        r106.add(r120);
        this.f70889u = r120;
        ObjectAnimator r121 = ObjectAnimator.ofFloat(r101, "alpha", new float[]{0.5f, 0.0f});
        r121.setDuration(300);
        r106.add(r121);
        this.f70890v = r121;
        this.f70891w = new AnimatorSet();
        this.f70892x = new AnimatorSet();
        this.f70893y = new AnimatorSet();
        this.f70894z = new AnimatorSet();
    }
}
