package com.bytedance.android.livesdk.livecommerce.iron.widgets;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.iron.listheader.entry.IronListHeaderEntryView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;

/* JADX INFO: loaded from: classes10.dex */
public final class c extends PopupWindow {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static int f149189v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BubbleLayout f149190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Activity f149191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f149192c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f149193d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f149194e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f149195f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f149196g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f149197h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f149198i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f149199j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f149200k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f149201l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f149202m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f149203n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f149204o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public AnimatorSet f149205p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Runnable f149206q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final a f149207r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f149208s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f149209t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f149210u;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f149211a;

        @Override // java.lang.Runnable
        public final void run() {
            c r100 = this.f149211a;     // Catch: Throwable -> L4
            PopupWindowLancet.handleDismissBeforeOrigin(r100);     // Catch: Throwable -> L4
            r100.dismiss();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(c r100) {
            this.f149211a = r100;
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f149212a;

        public b(c r100) {
            this.f149212a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f149212a.getClass();
            c r101 = this.f149212a;
            PopupWindowLancet.handleDismissBeforeOrigin(r101);
            r101.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.iron.widgets.c$c, reason: collision with other inner class name */
    public class RunnableC2306c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f149213a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BubbleLayout f149214b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f149215c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c f149216d;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.iron.widgets.c$c$a */
        public class a extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ RunnableC2306c f149217a;

            public a(RunnableC2306c r100) {
                this.f149217a = r100;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r100) {
                RunnableC2306c r101 = this.f149217a;
                if (r101.f149215c == true) goto L19;
                r101.f149214b.setVisibility(8);
                c r102 = this.f149217a.f149216d;
                AnimatorSet r103 = r102.f149205p;
                if (r103 == null) goto L8;
                r103.removeAllListeners();
                r102.f149205p.cancel();
                r102.f149205p = null;
            L8:
                if (r102.f149191b.isFinishing() == false) goto L10;
                return;
            L10:
                if (r102.isShowing() == false) goto L21;
                c.a(r102);     // Catch: Exception -> L14
                return;
            L14:
                e = move-exception;
                com.bytedance.android.ec.sdk.helper.g.f48122a.e(e);
                return;
            L21:
                return;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator r100) {
                super.onAnimationStart(r100);
                RunnableC2306c r101 = this.f149217a;
                if (r101.f149215c == false) goto L6;
                r101.f149214b.setVisibility(0);
                return;
            }
        }

        public final void a() {
            if (this.f149216d.f149205p != null) goto L5;
            return;
        L5:
            int r100 = this.f149213a;
            if (r100 != 3) goto L8;
            int r101 = this.f149214b.getMeasuredWidth();
            int r102 = (int) this.f149214b.getBubbleOffset();
        L19:
            this.f149214b.setPivotY(r102);
            this.f149214b.setPivotX(r101);
            BubbleLayout r103 = this.f149214b;
            float[] r104 = new float[2];
            boolean r105 = this.f149215c;
            float r106 = 0.0f;
            if (r105 == false) goto L22;
            float r107 = 0.0f;
        L23:
            r104[0] = r107;
            if (r105 == false) goto L26;
            float r108 = 1.0f;
        L27:
            r104[1] = r108;
            ObjectAnimator r109 = ObjectAnimator.ofFloat(r103, LiveDegradeFpsAnimator.SCALE_X, r104);
            BubbleLayout r110 = this.f149214b;
            float[] r111 = new float[2];
            boolean r112 = this.f149215c;
            if (r112 == false) goto L30;
            float r113 = 0.0f;
        L31:
            r111[0] = r113;
            if (r112 == false) goto L34;
            float r114 = 1.0f;
        L35:
            r111[1] = r114;
            ObjectAnimator r115 = ObjectAnimator.ofFloat(r110, LiveDegradeFpsAnimator.SCALE_Y, r111);
            BubbleLayout r116 = this.f149214b;
            float[] r117 = new float[2];
            boolean r118 = this.f149215c;
            if (r118 == false) goto L38;
            float r119 = 0.0f;
        L39:
            r117[0] = r119;
            if (r118 == false) goto L42;
            r106 = 1.0f;
        L42:
            r117[1] = r106;
            this.f149216d.f149205p.play(r109).with(r115).with(ObjectAnimator.ofFloat(r116, "alpha", r117));
            c r120 = this.f149216d;
            AnimatorSet r121 = r120.f149205p;
            if (this.f149215c == false) goto L45;
            long r122 = r120.f149208s;
        L46:
            r121.setDuration(r122);
            this.f149216d.getClass();
            this.f149216d.f149205p.addListener(new a(this));
            this.f149216d.f149205p.start();
            return;
        L45:
            r122 = r120.f149209t;
            goto L46
        L38:
            r119 = 1.0f;
            goto L39
        L34:
            r114 = 0.0f;
            goto L35
        L30:
            r113 = 1.0f;
            goto L31
        L26:
            r108 = 0.0f;
            goto L27
        L22:
            r107 = 1.0f;
            goto L23
        L8:
            if (r100 != 5) goto L10;
            r102 = (int) this.f149214b.getBubbleOffset();
            r101 = 0;
            goto L19
        L10:
            if (r100 != 48) goto L12;
            r101 = (int) this.f149214b.getBubbleOffset();
            r102 = this.f149214b.getMeasuredHeight();
            goto L19
        L12:
            if (r100 == 80) goto L15;
            r101 = 0;
        L14:
            r102 = 0;
            goto L19
        L15:
            r101 = (int) this.f149214b.getBubbleOffset();
            goto L14
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

        public RunnableC2306c(c r100, int r101, BubbleLayout r102, boolean r103) {
            this.f149216d = r100;
            this.f149213a = r101;
            this.f149214b = r102;
            this.f149215c = r103;
        }
    }

    @Override // android.widget.PopupWindow
    public final void dismiss() {
        if (this.f149200k == true) goto L5;
        b(false, this.f149201l);
        getContentView().removeCallbacks(this.f149207r);
        this.f149197h = 0;
        this.f149198i = 0;
    L5:
        Runnable r100 = this.f149206q;
        if (r100 == null) goto L9;
        r100.run();
        return;
    }

    public c(Activity r100) {
        super(r100);
        this.f149199j = 0;
        this.f149203n = true;
        this.f149204o = 7000;
        this.f149207r = new a(this);
        this.f149208s = 800;
        this.f149209t = 200;
        this.f149210u = false;
        this.f149191b = r100;
        this.f149193d = true;
        Resources r101 = r100.getResources();
        f149189v = (int) ((WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density * 3.0f) + 0.5f);
        setWidth(-2);
        setHeight(-2);
        setFocusable(false);
        setOutsideTouchable(false);
        setClippingEnabled(false);
        setBackgroundDrawable(new ColorDrawable(0));
        setInputMethodMode(1);
        setSoftInputMode(16);
        TextView r102 = new TextView(r100);
        this.f149192c = r102;
        r102.setTextColor(th.a.a(r100, R.color.ec_color_white));
        this.f149192c.setTextSize(13.0f);
        this.f149192c.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.f149192c.setMaxLines(2);
        this.f149192c.setGravity(17);
        c(this.f149192c);
        this.f149196g = true;
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public static void a(PopupWindow r100) {
        PopupWindowLancet.handleDismissBeforeOrigin(r100);
        super.dismiss();
    }

    public final void c(View r100) {
        BubbleLayout r101 = new BubbleLayout(this.f149191b);
        this.f149190a = r101;
        r101.setBackgroundColor(0);
        this.f149190a.addView(r100);
        this.f149190a.setGravity(17);
        ViewGroup.MarginLayoutParams r102 = new ViewGroup.MarginLayoutParams(-2, -2);
        this.f149190a.setLayoutParams(r102);
        this.f149190a.setVisibility(8);
        int r103 = this.f149202m;
        if (r103 == 0) goto L5;
        this.f149190a.setBgColor(r103);
    L5:
        this.f149190a.setNeedPath(this.f149203n);
        this.f149190a.setNeedPressFade(false);
        this.f149190a.setOnClickListener(new b(this));
        if (this.f149193d == false) goto L8;
        setContentView(this.f149190a);
        return;
    L8:
        FrameLayout r104 = new FrameLayout(this.f149191b);
        r104.addView(this.f149190a);
        r104.setOnClickListener(new com.bytedance.android.livesdk.livecommerce.iron.widgets.b(this));
        setContentView(r104);
    }

    public final void b(boolean r100, int r101) {
        BubbleLayout r102 = this.f149190a;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r100 == true) goto L7;
        this.f149200k = true;
    L7:
        AnimatorSet r103 = this.f149205p;
        if (r103 != null) goto L10;
        this.f149205p = new AnimatorSet();
    L11:
        r102.post(new RunnableC2306c(this, r101, r102, r100));
        return;
    L10:
        r103.removeAllListeners();
        this.f149205p.cancel();
        goto L11
    }

    public final void d(IronListHeaderEntryView r110, int r111, int r112) {
        this.f149197h = r112;
        this.f149198i = -9;
        this.f149199j = r111;
        if (this.f149191b.isFinishing() == false) goto L5;
        return;
    L5:
        if (r110.getWindowToken() != null) goto L8;
        return;
    L8:
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_SPLIT_FIX_POPUP_WINDOW_FORCE().booleanValue() == true) goto L10;
    L12:
        getContentView().removeCallbacks(this.f149207r);
        this.f149201l = 80;
        if (isShowing() == true) goto L53;
        int r100 = this.f149194e;
        if (r100 != 0) goto L17;
    L19:
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
    L20:
        int r101 = getContentView().getMeasuredWidth() / 2;
        BubbleLayout r102 = this.f149190a;
        if (r102 == null) goto L23;
        r102.f149104o = r101 + this.f149199j;
        r102.f149105p = 0;
    L23:
        int[] r103 = new int[2];
        r110.getLocationInWindow(r103);
        int r104 = this.f149197h + ((r110.getMeasuredWidth() - getContentView().getMeasuredWidth()) / 2);
        int r105 = f149189v + this.f149198i;
        if (this.f149193d == false) goto L29;
        OverlaySource r106 = PopupWindowLancet.resolveSource(r110);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(this, r110, r106) == true) goto L46;
        showAsDropDown(r110, r104, r105);
        PopupWindowLancet.trackAfterShow(this, r106, r110);
    L46:
        b(true, 80);
        this.f149200k = false;
        if (this.f149204o <= 0) goto L50;
        getContentView().postDelayed(this.f149207r, this.f149204o);
    L50:
        if (this.f149196g == false) goto L58;
        getContentView().setSystemUiVisibility(4102);
        return;
    L58:
        return;
    L29:
        int r107 = r104 + r103[0];
        int r108 = (r105 + r103[1]) + r110.getHeight();
        BubbleLayout r109 = this.f149190a;
        if (r109 != null) goto L32;
        ViewGroup.LayoutParams r113 = null;
    L34:
        if ((r113 instanceof ViewGroup.MarginLayoutParams) == false) goto L37;
        ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) r113;
        r114.leftMargin = r107;
        r114.topMargin = r108;
    L37:
        if (PopupWindowLancet.hasSubWindowToken(r110) == true) goto L46;
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(this) == false) goto L42;
        showAtLocation(r110, 0, 0, 0);
        goto L46
    L42:
        OverlaySource r115 = PopupWindowLancet.resolveSource(r110);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(this, r110, r115, 0, 0, 0) == true) goto L46;
        showAtLocation(r110, 0, 0, 0);
        PopupWindowLancet.trackAfterShow(this, r115, r110);
        goto L46
    L32:
        r113 = r109.getLayoutParams();
        goto L34
    L17:
        if (this.f149195f == 0) goto L19;
        getContentView().measure(View.MeasureSpec.makeMeasureSpec(r100, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f149195f, 1073741824));
        goto L20
    L53:
        a(this);
        return;
    L10:
        if (this.f149210u == false) goto L12;
        setFocusable(false);
        update();
        goto L12
    }

    @Override // android.widget.PopupWindow
    public final void showAsDropDown(View r100, int r101, int r102, int r103) {
        OverlaySource r104 = PopupWindowLancet.resolveSource(r100);     // Catch: Exception -> L7
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(this, r100, r104) == true) goto L12;
        super.showAsDropDown(r100, r101, r102, r103);     // Catch: Exception -> L7
        PopupWindowLancet.trackAfterShow(this, r104, r100);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    @Override // android.widget.PopupWindow
    public final void showAtLocation(View r100, int r101, int r110, int r111) {
    L8:
        e = move-exception;
        com.bytedance.android.ec.sdk.helper.g.f48122a.e(e);
        return;
    L3:
        if (PopupWindowLancet.hasSubWindowToken(r100) == false) goto L6;
    L17:
        return;
    L6:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(this) == false) goto L10;
        super.showAtLocation(r100, r101, r110, r111);     // Catch: Exception -> L8
        goto L17
    L10:
        OverlaySource r102 = PopupWindowLancet.resolveSource(r100);     // Catch: Exception -> L8
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(this, r100, r102, r101, r110, r111) == true) goto L17;
        super.showAtLocation(r100, r101, r110, r111);     // Catch: Exception -> L8
        PopupWindowLancet.trackAfterShow(this, r102, r100);     // Catch: Exception -> L8
        goto L17
    }
}
