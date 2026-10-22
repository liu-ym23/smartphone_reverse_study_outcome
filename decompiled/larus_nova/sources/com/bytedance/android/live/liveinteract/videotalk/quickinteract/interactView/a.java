package com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.QuickInteractTask;
import com.larus.nova.R;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f79574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f79575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f79576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f79577d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n f79578e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.f f79579f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AnimatorSet f79580g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AnimatorSet f79581h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AnimatorSet f79582i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f79583j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public QuickInteractTask f79584k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f79585l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f79586m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f79587n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.f.a f79588o;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.a$a, reason: collision with other inner class name */
    public static final class C1238a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f79589a;

        public C1238a(Function0 r100) {
            this.f79589a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationStart(r100);
            Function0 r101 = this.f79589a;
            if (r101 == null) goto L6;
            Unit r102 = (Unit) r101.invoke();
            return;
        }
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f79590a;

        public b(Function0 r100) {
            this.f79590a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationEnd(r100);
            Function0 r101 = this.f79590a;
            if (r101 == null) goto L6;
            Unit r102 = (Unit) r101.invoke();
            return;
        }
    }

    public static final class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f79591a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f79592b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0 f79593c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ QuickInteractTask f79594d;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            Function0 r101 = this.f79593c;
            if (r101 == null) goto L5;
            Unit r102 = (Unit) r101.invoke();
        L5:
            a r103 = this.f79591a;
            r103.f79584k = null;
            r103.f79581h = null;
            AnimatorSet r104 = r103.f79582i;
            if (r104 == null) goto L10;
            boolean r105 = true;
            if (r104.isStarted() != true) goto L10;
        L11:
            if (r105 == true) goto L16;
            this.f79591a.f79583j = 0;
            com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.f79516r0.getClass();
            com.bytedance.android.live.liveinteract.videotalk.quickinteract.b r106 = com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C1237b.a();
            if (r106 == null) goto L17;
            r106.k7(this.f79594d);
            return;
        L17:
            return;
        L16:
            return;
        L10:
            r105 = false;
            goto L11
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationStart(r100);
            Function0 r101 = this.f79592b;
            if (r101 == null) goto L6;
            Unit r102 = (Unit) r101.invoke();
            return;
        }

        public c(a r100, Function0 r101, Function0 r102, QuickInteractTask r103) {
            this.f79591a = r100;
            this.f79592b = r101;
            this.f79593c = r102;
            this.f79594d = r103;
        }
    }

    public static final class d implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f79595a;

        public d(a r100) {
            this.f79595a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Object r101 = r100.getAnimatedValue();
            if (r101 == null) goto L7;
            float r102 = ((Float) r101).floatValue();
            a r103 = this.f79595a;
            r103.f79576c.setAlpha((1 - r102) * r103.f79587n);
            this.f79595a.f79577d.setAlpha(r102);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class e implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f79596a;

        public e(a r100) {
            this.f79596a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Object r101 = r100.getAnimatedValue();
            if (r101 == null) goto L7;
            float r102 = ((Float) r101).floatValue();
            a r103 = this.f79596a;
            r103.f79576c.setAlpha((1 - r102) * r103.f79587n);
            this.f79596a.f79577d.setAlpha(r102);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class f extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f79597a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f79598b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f79599c;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            a r101 = this.f79597a;
            r101.f79580g = null;
            AnimatorSet r102 = r101.f79582i;
            if (r102 == null) goto L7;
            boolean r103 = true;
            if (r102.isStarted() != true) goto L7;
        L8:
            if (r103 == true) goto L10;
            this.f79597a.f79583j = 0;
        L10:
            this.f79598b.invoke(this.f79599c);
            return;
        L7:
            r103 = false;
            goto L8
        }

        public f(a r100, Function1 r101, String r102) {
            this.f79597a = r100;
            this.f79598b = r101;
            this.f79599c = r102;
        }
    }

    public final void b() {
        AnimatorSet r100 = this.f79581h;
        if (r100 != null) goto L5;
    L9:
        this.f79581h = null;
        return;
    L5:
        if (r100.isStarted() != true) goto L9;
        AnimatorSet r101 = this.f79581h;
        if (r101 == null) goto L9;
        r101.end();
        goto L9
    }

    public final void c() {
        AnimatorSet r100 = this.f79580g;
        if (r100 != null) goto L5;
    L9:
        this.f79580g = null;
        return;
    L5:
        if (r100.isStarted() != true) goto L9;
        AnimatorSet r101 = this.f79580g;
        if (r101 == null) goto L9;
        r101.end();
        goto L9
    }

    public final void f() {
        c();
        b();
        n r100 = this.f79578e;
        if (r100.f79620a.getCurrentView().getId() != R.id.interact_content) goto L5;
        r100.f79620a.reset();
        r100.f79620a.showNext();
    L5:
        View r101 = null;
        r100.f79624e = null;
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.f r102 = this.f79579f;
        r102.f79606a.setCurrentText("0");
        View r103 = r102.f79606a.getNextView();
        if ((r103 instanceof TextView) == false) goto L9;
        r101 = r103;
    L9:
        TextView r104 = (TextView) r101;
        if (r104 == null) goto L12;
        r104.setText("0");
    L12:
        r102.f79609d = "0";
    }

    public a(View r100, com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.f.a r101) {
        Intrinsics.checkNotNullParameter(r100, "parentContext");
        Intrinsics.checkNotNullParameter(r101, "animationCallback");
        this.f79588o = r101;
        this.f79574a = r100.findViewById(R.id.main_container_view);
        this.f79575b = r100.findViewById(R.id.flash_shadow_mask);
        View r102 = r100.findViewById(R.id.interact_static_bg);
        this.f79576c = r102;
        this.f79577d = r100.findViewById(R.id.interact_animation_bg);
        ImageView r103 = (ImageView) r100.findViewById(R.id.interact_icon);
        this.f79578e = new n(r100);
        this.f79579f = new com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.f(r100);
        this.f79587n = r102.getAlpha();
    }

    public final Animator d(long r100, long r101) {
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r102.setStartDelay(r100);
        r102.setDuration(r101);
        r102.addUpdateListener(new d(this));
        return r102;
    }

    public final Animator e(long r100, long r101) {
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r102.setStartDelay(r100);
        r102.setDuration(r101);
        r102.addUpdateListener(new e(this));
        return r102;
    }

    public final void g(String r100, Function1<? super String, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_SCORE);
        Intrinsics.checkNotNullParameter(r101, "onNormalScoreUpdated");
        if (this.f79583j == 3) goto L12;
        AnimatorSet r102 = this.f79582i;
        if (r102 == null) goto L9;
        if (r102.isRunning() == true) goto L12;
    L9:
        if (this.f79585l == true) goto L12;
        boolean r103 = false;
    L13:
        if (r103 == false) goto L16;
        c();
        return;
    L16:
        c();
        this.f79583j = 1;
        this.f79580g = new AnimatorSet();
        if (this.f79586m == false) goto L21;
        AnimatorSet r104 = com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.f.a(this.f79579f, r100, 0, 4);
        AnimatorSet r105 = this.f79580g;
        if (r105 == null) goto L31;
        r105.play(r104);
    L31:
        AnimatorSet r106 = this.f79580g;
        if (r106 == null) goto L34;
        r106.addListener(new f(this, r101, r100));
    L34:
        AnimatorSet r107 = this.f79580g;
        if (r107 == null) goto L38;
        r107.start();
        return;
    L38:
        return;
    L21:
        Animator r108 = d(0, 200);
        AnimatorSet r109 = com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.f.a(this.f79579f, r100, 0, 6);
        AnimatorSet r110 = this.f79580g;
        if (r110 == null) goto L26;
        AnimatorSet.Builder r111 = r110.play(r108);
        if (r111 == null) goto L26;
        r111.before(r109);
    L26:
        Animator r112 = e(500, 200);
        AnimatorSet r113 = this.f79580g;
        if (r113 == null) goto L31;
        AnimatorSet.Builder r114 = r113.play(r109);
        if (r114 == null) goto L31;
        r114.before(r112);
    L12:
        r103 = true;
        goto L13
    }

    public final void a(QuickInteractTask r110, Function0<Unit> r111, Function0<Unit> r112, Function0<Unit> r210, Function0<Unit> r211) {
        Intrinsics.checkNotNullParameter(r110, "task");
        boolean r100 = false;
        if (this.f79583j == 3) goto L12;
        AnimatorSet r101 = this.f79582i;
        if (r101 == null) goto L9;
        if (r101.isRunning() == true) goto L12;
    L9:
        if (this.f79585l == true) goto L12;
        boolean r102 = false;
    L13:
        if (r102 == false) goto L16;
        b();
        return;
    L16:
        b();
        this.f79583j = 2;
        this.f79584k = r110;
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.f r103 = this.f79579f;
        String r104 = r110.f79479b;
        if (this.f79586m == false) goto L19;
        long r113 = 0;
    L20:
        AnimatorSet r105 = com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.f.a(r103, r104, r113, 4);
        AnimatorSet r106 = new AnimatorSet();
        this.f79581h = r106;
        if (this.f79586m == false) goto L23;
        r106.play(r105);
    L29:
        if (r110.f79480c <= 0) goto L31;
        r100 = true;
    L31:
        if (r100 == false) goto L50;
        n r107 = this.f79578e;
        r107.getClass();
        Intrinsics.checkNotNullParameter(r110, "task");
        ImageUtil.loadRoundImage(r107.f79621b, r110.f79482e);
        r107.f79622c.setText(r110.f79483f);
        ValueAnimator r108 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r108.setStartDelay(300);
        r108.setDuration(350);
        r108.addUpdateListener(new k(r107));
        r108.addListener(new l(r107, r110));
        ValueAnimator r114 = ValueAnimator.ofInt(new int[]{0, 1});
        r114.setDuration(350);
        r114.setStartDelay(300);
        r114.addListener(new m(r107, r110));
        AnimatorSet r109 = new AnimatorSet();
        r109.play(r108).with(r114);
        AnimatorSet r115 = this.f79581h;
        if (r115 == null) goto L37;
        AnimatorSet.Builder r116 = r115.play(r105);
        if (r116 == null) goto L37;
        r116.before(r109);
    L37:
        r109.addListener(new C1238a(r210));
        long r117 = (r110.f79480c * ((long) 1000)) - ((long) TTVideoEngineInterface.PLAYER_OPTION_AE_LU_RANG);
        n r118 = this.f79578e;
        r118.getClass();
        Intrinsics.checkNotNullParameter(r110, "task");
        ValueAnimator r119 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r119.setStartDelay(r117);
        r119.setDuration(350);
        r119.addUpdateListener(new h(r118));
        r119.addListener(new i(r118));
        ValueAnimator r120 = ValueAnimator.ofInt(new int[]{0, 1});
        r120.setDuration(350);
        r120.setStartDelay(r117);
        r120.addListener(new j(r118));
        AnimatorSet r121 = new AnimatorSet();
        r121.play(r119).with(r120);
        AnimatorSet r122 = this.f79581h;
        if (r122 == null) goto L42;
        AnimatorSet.Builder r123 = r122.play(r109);
        if (r123 == null) goto L42;
        r123.before(r121);
    L42:
        r121.addListener(new b(r211));
        if (this.f79586m == true) goto L56;
        Animator r124 = e(r117, 350);
        AnimatorSet r125 = this.f79581h;
        if (r125 == null) goto L56;
        AnimatorSet.Builder r126 = r125.play(r121);
        if (r126 == null) goto L56;
        r126.with(r124);
    L56:
        AnimatorSet r127 = this.f79581h;
        if (r127 == null) goto L59;
        r127.addListener(new c(this, r111, r112, r110));
    L59:
        AnimatorSet r128 = this.f79581h;
        if (r128 == null) goto L63;
        r128.start();
        return;
    L63:
        return;
    L50:
        if (this.f79586m == true) goto L56;
        Animator r129 = e(500, 200);
        AnimatorSet r130 = this.f79581h;
        if (r130 == null) goto L56;
        AnimatorSet.Builder r131 = r130.play(r105);
        if (r131 == null) goto L56;
        r131.before(r129);
        goto L56
    L23:
        Animator r132 = d(0, 200);
        AnimatorSet r133 = this.f79581h;
        if (r133 == null) goto L29;
        AnimatorSet.Builder r134 = r133.play(r132);
        if (r134 == null) goto L29;
        r134.before(r105);
        goto L29
    L19:
        r113 = 300;
    L12:
        r102 = true;
        goto L13
    }
}
