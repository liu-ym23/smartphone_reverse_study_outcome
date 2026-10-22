package com.bytedance.android.ec.window.base.common.bubble;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class r extends PopupWindow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ECWindowBubbleStrategy f49130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AnimatorSet f49131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f49132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s f49133d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f49134e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f49135f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f49136g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f49137h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f49138i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<ECWindowBubbleStrategy> f49139j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final g f49140k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Rect f49141l;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f49142a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f49143b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f49144c;

        /* JADX INFO: renamed from: com.bytedance.android.ec.window.base.common.bubble.r$a$a, reason: collision with other inner class name */
        public static final class C0843a extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f49145a;

            public C0843a(a r100) {
                this.f49145a = r100;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
                super.onAnimationEnd(r100);
                a r101 = this.f49145a;
                if (r101.f49144c == true) goto L15;
                r101.f49143b.setVisibility(8);
                g r102 = this.f49145a.f49142a.f49140k;
                if (r102 == null) goto L7;
                r102.onDismiss();
            L7:
                r r103 = this.f49145a.f49142a;
                AnimatorSet r104 = r103.f49131b;
                if (r104 == null) goto L10;
                r104.removeAllListeners();
            L10:
                AnimatorSet r105 = r103.f49131b;
                if (r105 == null) goto L13;
                r105.cancel();
            L13:
                r103.f49131b = null;
                PopupWindowLancet.handleDismissBeforeOrigin(r103);
                r103.dismiss();
                return;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
                super.onAnimationStart(r100);
                a r101 = this.f49145a;
                if (r101.f49144c == false) goto L9;
                g r102 = r101.f49142a.f49140k;
                if (r102 == null) goto L7;
                r102.onShow();
            L7:
                this.f49145a.f49143b.setVisibility(0);
                return;
            }
        }

        public a(r r100, View r101, boolean r102) {
            this.f49142a = r100;
            this.f49143b = r101;
            this.f49144c = r102;
        }

        public final void a() {
            if (this.f49142a.f49131b != null) goto L5;
            return;
        L5:
            View r100 = this.f49143b;
            float[] r101 = new float[2];
            boolean r102 = this.f49144c;
            float r103 = 0.0f;
            if (r102 == false) goto L8;
            float r104 = 0.0f;
        L9:
            r101[0] = r104;
            if (r102 == false) goto L12;
            r103 = 1.0f;
        L12:
            r101[1] = r103;
            ObjectAnimator r105 = ObjectAnimator.ofFloat(r100, "alpha", r101);
            r105.setInterpolator(new LinearInterpolator());
            if (this.f49144c == false) goto L15;
            long r106 = this.f49142a.f49137h;
        L16:
            r105.setDuration(r106);
            this.f49143b.setVisibility(0);
            AnimatorSet r107 = this.f49142a.f49131b;
            if (r107 == null) goto L19;
            r107.play(r105);
        L19:
            AnimatorSet r108 = this.f49142a.f49131b;
            if (r108 == null) goto L22;
            r108.addListener(new C0843a(this));
        L22:
            AnimatorSet r109 = this.f49142a.f49131b;
            if (r109 == null) goto L26;
            r109.start();
            return;
        L26:
            return;
        L15:
            r106 = this.f49142a.f49138i;
            goto L16
        L8:
            r104 = 1.0f;
            goto L9
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void b() {
        Iterator<ECWindowBubbleStrategy> r100 = this.f49139j.iterator();
    L3:
        boolean r101 = false;
        if (r100.hasNext() == false) goto L77;
        ECWindowBubbleStrategy r102 = r100.next();
        this.f49130a = r102;
        int[] r103 = null;
        if (r102 == null) goto L16;
        Integer r104 = r102.f49112c;
        if (r104 == null) goto L16;
        int r105 = r104.intValue();
        FrameLayout r106 = new FrameLayout(this.f49134e.getContext());
        r106.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r106.setBackgroundResource(r105);
        ViewParent r107 = this.f49135f.getParent();
        if ((r107 instanceof ViewGroup) == true) goto L12;
        r107 = null;
    L12:
        ViewGroup r108 = (ViewGroup) r107;
        if (r108 == null) goto L15;
        r108.removeAllViews();
    L15:
        r106.addView(this.f49135f);
        Unit r109 = Unit.INSTANCE;
        setContentView(r106);
    L17:
        getContentView().setVisibility(4);
        ECWindowBubbleStrategy r110 = this.f49130a;
        if (r110 == null) goto L64;
        int r111 = this.f49134e.getMeasuredWidth();
        int r112 = this.f49134e.getMeasuredHeight();
        getContentView().measure(0, 0);
        int r113 = getContentView().getMeasuredWidth();
        getContentView().measure(0, 0);
        int r114 = getContentView().getMeasuredHeight();
        int[] r115 = new int[2];
        int r116 = r110.f49110a;
        if (r116 == 1) goto L33;
        if (r116 == 2) goto L26;
        if (r116 == 3) goto L33;
        if (r116 == 4) goto L26;
    L40:
        int r117 = 0;
    L41:
        if (r116 == 1) goto L49;
        if (r116 == 2) goto L48;
        if (r116 == 3) goto L47;
        if (r116 != 4) goto L50;
        r115[0] = r110.f49113d + r117;
        r115[1] = r110.f49114e;
    L50:
        int[] r118 = new int[2];
        this.f49134e.getLocationInWindow(r118);
        this.f49134e.getLocationOnScreen(r118);
        r118[1] = r118[1] + r112;
        Rect r119 = this.f49141l;
        if (r119 != null) goto L53;
        Resources r120 = th.a.f(this.f49134e.getContext());
        DisplayMetrics r121 = WindowDisplayMetricsOverride.apply(r120, r120.getDisplayMetrics());
        r119 = new Rect(0, 0, r121.widthPixels, r121.heightPixels);
    L53:
        int r122 = r118[0] + r115[0];
        if (r122 >= r119.left) goto L56;
    L63:
        dm.a.a("WINDOW").i("Out of range");
        r103 = new int[]{-1, -1};
        goto L64
    L56:
        if ((r122 + r113) > r119.right) goto L63;
        int r123 = r118[1] + r115[1];
        if (r123 < r119.top) goto L63;
        if ((r123 + r114) > r119.bottom) goto L63;
        r103 = r115;
        goto L64
    L47:
        r115[0] = r110.f49113d + r111;
        r115[1] = r110.f49114e - r117;
        goto L50
    L48:
        r115[0] = r110.f49113d + r117;
        r115[1] = (r110.f49114e - r114) - r112;
        goto L50
    L49:
        r115[0] = r110.f49113d - r113;
        r115[1] = r110.f49114e - r117;
    L26:
        int r124 = r110.f49111b;
        if (2 != r124) goto L29;
        r117 = (r111 - r113) / 2;
        goto L41
    L29:
        if (3 != r124) goto L31;
        r117 = (r111 / 2) - r113;
        goto L41
    L31:
        if (1 != r124) goto L40;
        r117 = r111 / 2;
    L33:
        int r125 = r110.f49111b;
        if (2 != r125) goto L36;
        r117 = (r112 + r114) / 2;
        goto L41
    L36:
        if (3 != r125) goto L38;
        r117 = (r112 / 2) + r114;
        goto L41
    L38:
        if (1 != r125) goto L40;
        r117 = r112 / 2;
    L64:
        if (r103 == null) goto L75;
        int r126 = r103[0];
        if (r126 == (-1)) goto L68;
    L70:
        View r127 = this.f49134e;
        int r128 = r103[1];
        OverlaySource r129 = PopupWindowLancet.resolveSource(r127);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(this, r127, r129) == true) goto L74;
        showAsDropDown(r127, r126, r128);
        PopupWindowLancet.trackAfterShow(this, r129, r127);
    L74:
        r101 = true;
        goto L75
    L68:
        if (r103[1] != (-1)) goto L70;
    L75:
        if (r101 == false) goto L3;
        r101 = true;
    L16:
        setContentView(this.f49135f);
    L77:
        if (r101 == true) goto L86;
        dm.a.a("WINDOW").i("No enough range to show bubble");
        return;
    }

    @Override // android.widget.PopupWindow
    public final void dismiss() {
        PopupWindowLancet.handleDismissBeforeOrigin(this);
        super.dismiss();
        if (this.f49132c == true) goto L6;
        a(false);
        getContentView().removeCallbacks(this.f49133d);
        return;
    }

    public final void a(boolean r100) {
        View r101 = getContentView();
        if (r100 == true) goto L5;
        this.f49132c = true;
    L5:
        this.f49131b = new AnimatorSet();
        r101.post(new a(this, r101, r100));
    }

    @Override // android.widget.PopupWindow
    public final void showAsDropDown(View r100, int r101, int r102) {
        OverlaySource r103 = PopupWindowLancet.resolveSource(r100);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(this, r100, r103) == true) goto L6;
        super.showAsDropDown(r100, r101, r102);
        PopupWindowLancet.trackAfterShow(this, r103, r100);
    L6:
        a(true);
        getContentView().postDelayed(this.f49133d, this.f49136g);
        this.f49132c = false;
    }

    public r(View r110, String r111, q r112, List r210, g r211, int r212) {
        if ((r212 & 4) == 0) goto L5;
        q r100 = new q(0);
    L6:
        long r101 = 0;
        if ((r212 & 8) == 0) goto L9;
        long r102 = 3000;
    L11:
        if ((r212 & 16) == 0) goto L13;
        long r113 = 300;
    L15:
        if ((r212 & 32) == 0) goto L18;
        r101 = 300;
    L18:
        if ((r212 & 64) == 0) goto L20;
        List r103 = l.f49124a;
    L22:
        if ((r212 & 128) == 0) goto L24;
        g r104 = null;
    L25:
        Intrinsics.checkNotNullParameter(r110, "anchorView");
        Intrinsics.checkNotNullParameter(r111, "popupText");
        Intrinsics.checkNotNullParameter(r100, "bubbleTextConfig");
        Intrinsics.checkNotNullParameter(r103, "strategies");
        TextView r105 = new TextView(r110.getContext());
        g r213 = r104;
        FrameLayout.LayoutParams r114 = new FrameLayout.LayoutParams(-2, -2);
        r114.gravity = 17;
        Unit r106 = Unit.INSTANCE;
        r105.setLayoutParams(r114);
        r105.setText(r111);
        r105.setTextSize(r100.f49128a);
        r105.setTypeface(Typeface.defaultFromStyle(1));
        r105.setTextColor((int) r100.f49129b);
        Intrinsics.checkNotNullParameter(r110, "anchorView");
        Intrinsics.checkNotNullParameter(r105, "popupView");
        Intrinsics.checkNotNullParameter(r103, "strategies");
        this.f49134e = r110;
        this.f49135f = r105;
        this.f49136g = r102;
        this.f49137h = r113;
        this.f49138i = r101;
        this.f49139j = r103;
        this.f49140k = r213;
        this.f49141l = null;
        this.f49130a = (ECWindowBubbleStrategy) CollectionsKt.getOrNull(r103, 0);
        this.f49133d = new s(this);
        setWidth(-2);
        setHeight(-2);
        setOutsideTouchable(true);
        setTouchable(true);
        return;
    L24:
        r104 = r211;
        goto L25
    L20:
        r103 = r210;
        goto L22
    L13:
        r113 = 0;
        goto L15
    L9:
        r102 = 0;
        goto L11
    L5:
        r100 = r112;
        goto L6
    }
}
