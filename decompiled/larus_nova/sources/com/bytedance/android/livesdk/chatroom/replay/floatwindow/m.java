package com.bytedance.android.livesdk.chatroom.replay.floatwindow;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes7.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowManager f108675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WindowManager.LayoutParams f108676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueAnimator f108677c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TimeInterpolator f108678d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f108679e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f108680f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f108681g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f108682h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f108683i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f108684j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f108685k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f108686l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f108687m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f108688n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f108689o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f108690p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f108691q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f108692r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f108693s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ReplayFloatWindowManager.a f108694t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final b f108695u;

    public static final class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f108696a;

        public a(m r100) {
            this.f108696a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            ValueAnimator r101 = this.f108696a.f108677c;
            if (r101 == null) goto L5;
            r101.removeAllUpdateListeners();
        L5:
            ValueAnimator r102 = this.f108696a.f108677c;
            if (r102 == null) goto L8;
            r102.removeAllListeners();
        L8:
            this.f108696a.f108677c = null;
        }
    }

    public final void a() {
        if (this.f108687m == false) goto L26;
        if (Build.VERSION.SDK_INT < 26) goto L7;
        this.f108676b.type = 2038;
    L34:
        WindowManager r100 = this.f108675a;     // Catch: IllegalStateException -> L12
        if (r100 == null) goto L23;
        b r101 = this.f108695u;     // Catch: IllegalStateException -> L12
        WindowManager.LayoutParams r102 = this.f108676b;     // Catch: IllegalStateException -> L12
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r101, r102);     // Catch: IllegalStateException -> L12
        r100.addView(r101, r102);     // Catch: IllegalStateException -> L12
    L23:
        this.f108693s = false;
        this.f108687m = false;
        this.f108688n = true;
    L29:
        com.bytedance.android.livesdk.chatroom.replay.floatwindow.a r103 = this.f108694t.f108638j;
        if (r103 == null) goto L32;
        r103.onShow();
    L32:
        this.f108694t.getClass();
        return;
    L12:
        e = move-exception;
        String r104 = e.getMessage();
        if (r104 != null) goto L16;
    L24:
        throw e;
    L16:
        if (StringsKt.contains$default(r104, "has already been added to the window manager", false, 2, null) == false) goto L24;
        WindowManager r105 = this.f108675a;
        if (r105 == null) goto L20;
        r105.removeView(this.f108695u);
    L20:
        WindowManager r106 = this.f108675a;
        if (r106 == null) goto L23;
        b r107 = this.f108695u;
        WindowManager.LayoutParams r108 = this.f108676b;
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r107, r108);
        r106.addView(r107, r108);
        goto L23
    L7:
        this.f108676b.type = 2002;
        goto L34
    L26:
        if (this.f108688n == false) goto L28;
        return;
    L28:
        this.f108695u.setVisibility(0);
        this.f108688n = true;
        goto L29
    }

    public final void b() {
        if (this.f108694t.f108636h == null) goto L5;
    L8:
        ValueAnimator r100 = this.f108677c;
        if (r100 == null) goto L11;
        r100.setInterpolator(this.f108694t.f108636h);
    L11:
        ValueAnimator r101 = this.f108677c;
        if (r101 == null) goto L14;
        r101.addListener(new a(this));
    L14:
        ValueAnimator r102 = this.f108677c;
        if (r102 == null) goto L20;
        ValueAnimator r103 = r102.setDuration(this.f108694t.f108635g);
        if (r103 == null) goto L21;
        r103.start();
        return;
    L21:
        return;
    L20:
        return;
    L5:
        if (this.f108678d != null) goto L7;
        this.f108678d = new DecelerateInterpolator();
    L7:
        ReplayFloatWindowManager.a r104 = this.f108694t;
        r104.f108636h = this.f108678d;
        goto L8
    }

    public m(ReplayFloatWindowManager.a r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        Intrinsics.checkNotNullParameter(r101, "mFloatView");
        this.f108694t = r100;
        this.f108695u = r101;
        WindowManager.LayoutParams r102 = new WindowManager.LayoutParams();
        this.f108676b = r102;
        this.f108687m = true;
        this.f108693s = true;
        r101.setFloatViewListener(r100.f108638j);
        Object r103 = s1.getContext().getSystemService(LiveEndPageData.TAG_WINDOW);
        if ((r103 instanceof WindowManager) == true) goto L5;
        r103 = null;
    L5:
        this.f108675a = (WindowManager) r103;
        r102.format = 1;
        r102.flags = 552;
        if (r100.f108640l == false) goto L8;
        r102.flags = 8744;
    L8:
        r102.windowAnimations = 0;
        r101.setOnTouchListener(new l(this));
        int r104 = r100.f108630b;
        int r105 = r100.f108631c;
        r102.width = r104;
        r102.height = r105;
        r102.gravity = 8388659;
        r102.x = 0;
        this.f108679e = 0;
        r102.y = 0;
        this.f108680f = 0;
        this.f108691q = r100.f108633e;
        this.f108692r = r100.f108634f;
    }

    public final void c(int r100, int r101) {
        if (this.f108693s == false) goto L5;
        return;
    L5:
        WindowManager.LayoutParams r102 = this.f108676b;
        r102.x = r100;
        this.f108679e = r100;
        r102.y = r101;
        this.f108680f = r101;
        WindowManager r103 = this.f108675a;
        if (r103 == null) goto L9;
        r103.updateViewLayout(this.f108695u, r102);
        return;
    }
}
