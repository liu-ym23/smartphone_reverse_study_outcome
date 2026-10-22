package c90;

import android.animation.AnimatorSet;
import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.bytedance.android.live.core.widget.bubble.LiveBubbleLayout;
import com.bytedance.android.live.core.widget.bubble.LiveBubbleTextView;
import com.bytedance.android.livesdk.popup.manager.LivePopupWindow;
import com.bytedance.common.utility.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a extends LivePopupWindow {
    public final Activity A;
    public final View B;
    public final d C;
    public final c D;
    public final e E;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f22772g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f22773h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f22774i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f22775j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f22776k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f22777l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f22778m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f22779n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f22780o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f22781p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final long f22782q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f22783r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f22784s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f22785t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f22786u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public LiveBubbleLayout f22787v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public LiveBubbleTextView f22788w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f22789x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f22790y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public AnimatorSet f22791z;

    /* JADX INFO: renamed from: c90.a$a, reason: collision with other inner class name */
    public static class C0416a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f22792a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f22793b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f22794c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f22795d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f22796e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f22797f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public View f22798g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f22799h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f22800i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f22801j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final float f22802k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final float f22803l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f22804m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public c f22805n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public d f22806o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f22807p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public float f22808q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f22809r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f22810s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final boolean f22811t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final float f22812u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final int f22813v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final int f22814w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public final Activity f22815x;

        public final Activity getActivity() {
            return this.f22815x;
        }

        public C0416a(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            this.f22815x = r100;
            this.f22793b = true;
            this.f22796e = 5000;
            this.f22797f = true;
            this.f22801j = "";
            this.f22802k = 197.0f;
            this.f22803l = 13.0f;
            this.f22807p = true;
            this.f22808q = 12.0f;
            this.f22809r = true;
            this.f22811t = true;
            this.f22812u = UIUtils.dip2Px(r100, 8.0f);
            this.f22813v = (int) UIUtils.dip2Px(r100, 56.0f);
            this.f22814w = (int) UIUtils.dip2Px(r100, 7.0f);
        }

        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "str");
            this.f22801j = r100;
        }
    }

    public static final class b {
    }

    public interface c {
        void bubbleDismiss();
    }

    public interface d {
        void bubbleShow();
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f22816a;

        public e(a r100) {
            this.f22816a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a r100 = this.f22816a;     // Catch: Throwable -> L4
            int r101 = r100.f22772g;     // Catch: Throwable -> L4
            r100.d(false);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f22817a;

        public f(a r100) {
            this.f22817a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f22817a.getClass();
            a r101 = this.f22817a;
            PopupWindowLancet.handleDismissBeforeOrigin(r101);
            r101.dismiss();
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.popup.manager.LivePopupWindow, android.widget.PopupWindow
    public final void dismiss() {
        if (this.f22789x == true) goto L6;
        d(false);
        getContentView().removeCallbacks(this.E);
        this.f22780o = 0;
        this.f22781p = 0;
        return;
    }

    public final void f() {
        int r100 = this.f22783r;
        if (r100 != 0) goto L5;
    L7:
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        return;
    L5:
        if (this.f22784s == 0) goto L7;
        int r101 = View.MeasureSpec.makeMeasureSpec(r100, 1073741824);
        int r102 = View.MeasureSpec.makeMeasureSpec(this.f22784s, 1073741824);
        getContentView().measure(r101, r102);
    }

    public final void g() {
        AnimatorSet r100 = this.f22791z;
        if (r100 == null) goto L5;
        r100.removeAllListeners();
    L5:
        AnimatorSet r101 = this.f22791z;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        this.f22791z = null;
        if (this.A.isFinishing() == false) goto L11;
        return;
    L11:
        if (isShowing() == false) goto L19;
        PopupWindowLancet.handleDismissBeforeOrigin(this);     // Catch: Exception -> L15
        super.dismiss();     // Catch: Exception -> L15
        return;
    L20:
        return;
    }

    public final int e() {
        f();
        return getContentView().getMeasuredWidth();
    }

    public a(C0416a r210) {
        Intrinsics.checkNotNullParameter(r210, "builder");
        this.f22776k = true;
        this.f22777l = true;
        this.f22782q = 5000;
        this.f22785t = true;
        Activity r100 = r210.getActivity();
        this.A = r100;
        this.f22772g = 0;
        this.f22774i = 0.0f;
        int r101 = r210.f22792a;
        this.f22775j = r101;
        boolean r102 = r210.f22793b;
        this.f22776k = r102;
        this.f22779n = false;
        this.f22780o = r210.f22794c;
        this.f22781p = r210.f22795d;
        this.f22782q = r210.f22796e;
        boolean r103 = r210.f22797f;
        View r104 = r210.f22798g;
        this.B = r104;
        int r110 = r210.f22800i;
        this.f22784s = r110;
        int r111 = r210.f22799h;
        this.f22783r = r111;
        String r112 = r210.f22801j;
        float r113 = r210.f22802k;
        float r114 = r210.f22803l;
        int r115 = r210.f22804m;
        this.D = r210.f22805n;
        this.C = r210.f22806o;
        this.f22785t = r210.f22807p;
        float r105 = r210.f22808q;
        boolean r106 = r210.f22809r;
        this.f22778m = r210.f22810s;
        boolean r107 = r210.f22811t;
        float r108 = r210.f22812u;
        int r109 = r210.f22813v;
        int r116 = r210.f22814w;
        UIUtils.dip2Px(r100, 3.0f);
        setWidth(-2);
        setHeight(-2);
        setFocusable(false);
        setOutsideTouchable(r106);
        setClippingEnabled(false);
        setBackgroundDrawable(new ColorDrawable(0));
        setInputMethodMode(1);
        setSoftInputMode(16);
        if (r103 == true) goto L9;
        if (r104 == null) goto L9;
        h(r104);
        LiveBubbleLayout r117 = this.f22787v;
        if (r117 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L8:
        r117.setUseDefaultView(false);
        int r118 = 2;
    L48:
        if (r111 == 0) goto L51;
        if (r110 == 0) goto L51;
        setWidth(r111);
        setHeight(r110);
        int r119 = LiveBubbleLayout.C;
        LiveBubbleLayout.G = getWidth();
    L51:
        boolean r120 = this.f22779n;
        if (r120 == false) goto L56;
        if (r120 == false) goto L56;
        getContentView().setSystemUiVisibility(4102);
    L56:
        if (r101 == 0) goto L61;
        LiveBubbleLayout r121 = this.f22787v;
        if (r121 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L60:
        r121.setMBgColor(r101);
    L61:
        if (r107 == true) goto L67;
        LiveBubbleLayout r122 = this.f22787v;
        if (r122 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L65:
        r122.setNeedAddColor(false);
    L67:
        LiveBubbleLayout r123 = this.f22787v;
        if (r123 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L70:
        r123.setMNeedPath(r102);
        LiveBubbleLayout r124 = this.f22787v;
        if (r124 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L73:
        int r125 = this.f22772g;
        if (r125 == 3) goto L84;
        if (r125 != 5) goto L77;
    L83:
        r118 = 1;
        goto L84
    L77:
        if (r125 != 48) goto L79;
        r118 = 3;
        goto L84
    L79:
        if (r125 != 80) goto L83;
        r118 = 0;
    L84:
        r124.setBubbleOrientation(r118);
        if (r105 == 0.0f) goto L90;
        LiveBubbleLayout r126 = this.f22787v;
        if (r126 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L89:
        r126.setMPadding(r105);
    L90:
        LiveBubbleLayout r127 = this.f22787v;
        if (r127 != null) goto L93;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L93:
        r127.setCornerRadius(r108);
        LiveBubbleLayout r128 = this.f22787v;
        if (r128 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L96:
        r128.setDefaultHeight(r109);
        LiveBubbleLayout r129 = this.f22787v;
        if (r129 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L99:
        r129.setArrowHeight(r116);
        this.E = new e(this);
        return;
    L9:
        LiveBubbleTextView r130 = new LiveBubbleTextView(this.A, null);
        this.f22788w = r130;
        if (r115 == 0) goto L12;
        r130.setTextColor(r115);
    L13:
        LiveBubbleTextView r131 = this.f22788w;
        if (r131 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L16:
        r131.setTextSize(1, 13.0f);
        LiveBubbleTextView r132 = this.f22788w;
        if (r132 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L19:
        r132.setTextAlignment(5);
        LiveBubbleTextView r133 = this.f22788w;
        if (r133 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L22:
        r133.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        LiveBubbleTextView r134 = this.f22788w;
        if (r134 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L25:
        r134.setGravity(17);
        LiveBubbleTextView r135 = this.f22788w;
        if (r135 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L28:
        r135.setMaxWidth((int) UIUtils.dip2Px(r100, r113));
        LiveBubbleTextView r136 = this.f22788w;
        if (r136 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L31:
        r118 = 2;
        r136.setMaxLines(2);
        LiveBubbleTextView r137 = this.f22788w;
        if (r137 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L34:
        h(r137);
        this.f22779n = true;
        if (TextUtils.isEmpty(r112) == true) goto L41;
        LiveBubbleTextView r138 = this.f22788w;
        if (r138 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L39:
        r138.setText(r112);
    L41:
        if (r114 == 0.0f) goto L47;
        LiveBubbleTextView r139 = this.f22788w;
        if (r139 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L45:
        r139.setTextSize(1, r114);
    L47:
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        goto L48
    L12:
        r130.setTextColor(r100.getResources().getColor(R.color.ttlive_uikit_const_tInverse2));
        goto L13
    }

    public final void d(boolean r100) {
        LiveBubbleLayout r101 = this.f22787v;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L5:
        if (r100 == true) goto L7;
        this.f22789x = true;
    L7:
        this.f22791z = new AnimatorSet();
        if (r101 == null) goto L11;
        r101.post(new c90.b(this, r101, r100));
        return;
    }

    public final void h(View r100) {
        LiveBubbleLayout r101 = new LiveBubbleLayout(this.A);
        this.f22787v = r101;
        r101.setBackgroundColor(0);
        LiveBubbleLayout r102 = this.f22787v;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L5:
        r102.addView(r100);
        LiveBubbleLayout r103 = this.f22787v;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L8:
        r103.setGravity(17);
        ViewGroup.MarginLayoutParams r104 = new ViewGroup.MarginLayoutParams(-2, -2);
        LiveBubbleLayout r105 = this.f22787v;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L11:
        r105.setLayoutParams(r104);
        LiveBubbleLayout r106 = this.f22787v;
        if (r106 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L14:
        r106.setVisibility(8);
        if (this.f22775j == 0) goto L20;
        LiveBubbleLayout r107 = this.f22787v;
        if (r107 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L19:
        r107.setMBgColor(this.f22775j);
    L20:
        LiveBubbleLayout r108 = this.f22787v;
        if (r108 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L23:
        r108.setMNeedPath(this.f22776k);
        LiveBubbleLayout r109 = this.f22787v;
        if (r109 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L26:
        r109.setMNeedArrow(this.f22785t);
        LiveBubbleLayout r110 = this.f22787v;
        if (r110 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L29:
        r110.setMNeedPressFade(false);
        LiveBubbleLayout r111 = this.f22787v;
        if (r111 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L32:
        r111.setMNeedShadow(this.f22778m);
        LiveBubbleLayout r112 = this.f22787v;
        if (r112 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L35:
        r112.setMShadowColor(0);
        LiveBubbleLayout r113 = this.f22787v;
        if (r113 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L38:
        r113.setOnClickListener(new f(this));
        LiveBubbleLayout r114 = this.f22787v;
        if (r114 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L41:
        setContentView(r114);
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public final void i(View r110, int r111, boolean r112) {
        if (this.A.isFinishing() == true) goto L74;
        if (r110 != null) goto L6;
        return;
    L6:
        if (r110.getWindowToken() == null) goto L78;
        r110.getMeasuredHeight();
        r110.getMeasuredWidth();
        getContentView().removeCallbacks(this.E);
        this.f22772g = r111;
        LiveBubbleLayout r100 = this.f22787v;
        if (r100 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L11:
        this.f22790y = r100.getPADDING();
        if (isShowing() == false) goto L14;
        PopupWindowLancet.handleDismissBeforeOrigin(this);
        super.dismiss();
        return;
    L14:
        if (r111 == 3) goto L22;
        if (r111 == 5) goto L21;
        if (r111 == 48) goto L20;
        if (r111 != 80) goto L21;
        int r101 = 0;
    L23:
        int r102 = this.f22783r;
        if (r102 != 0) goto L26;
    L28:
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
    L29:
        if (r112 == false) goto L37;
        if (r111 == 80) goto L35;
        if (r111 == 48) goto L35;
        f();
        this.f22773h = getContentView().getMeasuredHeight() / 2.0f;
    L39:
        LiveBubbleLayout r103 = this.f22787v;
        if (r103 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L42:
        r103.f66587r = this.f22773h + this.f22774i;
        r103.f66588s = r101;
        int[] r104 = new int[2];
        r110.getLocationOnScreen(r104);
        if (r111 == 3) goto L65;
        if (r111 != 5) goto L46;
        if (r112 == false) goto L63;
        int r113 = r110.getMeasuredHeight();
        f();
        int r114 = (r113 - getContentView().getMeasuredHeight()) / 2;
    L64:
        c(this, r110, (r104[0] + this.f22780o) + r110.getWidth(), ((r104[1] + this.f22781p) + r114) + ((int) UIUtils.dip2Px(this.A, 1.3f)));
    L69:
        this.f22789x = false;
        if (this.f22782q <= 0) goto L76;
        getContentView().postDelayed(this.E, this.f22782q);
        return;
    L76:
        return;
    L63:
        r114 = 0;
        goto L64
    L46:
        if (r111 == 48) goto L57;
        if (r111 != 80) goto L69;
        if (r112 == false) goto L51;
        int r115 = (r110.getMeasuredWidth() - e()) / 2;
    L52:
        int r116 = (this.f22780o + r115) + ((int) UIUtils.dip2Px(this.A, 1.4f));
        int r117 = this.f22781p + ((int) UIUtils.dip2Px(this.A, 1.3f));
        OverlaySource r105 = PopupWindowLancet.resolveSource(r110);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(this, r110, r105) == true) goto L56;
        showAsDropDown(r110, r116, r117);
        PopupWindowLancet.trackAfterShow(this, r105, r110);
    L56:
        d(true);
        goto L69
    L51:
        r115 = 0;
        goto L52
    L57:
        if (r112 == false) goto L59;
        int r118 = (r110.getMeasuredWidth() - e()) / 2;
    L60:
        int r119 = ((r104[0] + this.f22780o) + r118) + ((int) UIUtils.dip2Px(this.A, 1.4f));
        int r120 = r104[1];
        f();
        c(this, r110, r119, ((r120 - getContentView().getMeasuredHeight()) + this.f22781p) + ((int) UIUtils.dip2Px(this.A, 1.3f)));
        goto L69
    L59:
        r118 = 0;
        goto L60
    L65:
        if (r112 == false) goto L67;
        int r121 = r110.getMeasuredHeight();
        f();
        int r122 = (r121 - getContentView().getMeasuredHeight()) / 2;
    L68:
        c(this, r110, (r104[0] + this.f22780o) - e(), ((r104[1] + this.f22781p) + r122) + ((int) UIUtils.dip2Px(this.A, 1.3f)));
        goto L69
    L67:
        r122 = 0;
    L35:
        this.f22773h = e() / 2.0f;
        goto L39
    L37:
        if (this.f22786u == true) goto L39;
        this.f22774i += this.f22790y * 8;
        this.f22786u = true;
        goto L39
    L26:
        if (this.f22784s == 0) goto L28;
        getContentView().measure(View.MeasureSpec.makeMeasureSpec(r102, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f22784s, 1073741824));
        goto L29
    L20:
        r101 = 3;
    L21:
        r101 = 1;
        goto L23
    L22:
        r101 = 2;
        goto L23
    L78:
        return;
    }

    public static void c(a r100, View r101, int r110, int r111) {
        if (PopupWindowLancet.hasSubWindowToken(r101) == false) goto L6;
        return;
    L6:
        if ((r100 instanceof PopupWindow) == true) goto L8;
    L11:
        OverlaySource r102 = PopupWindowLancet.resolveSource(r101);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r100, r101, r102, 0, r110, r111) == false) goto L14;
        return;
    L14:
        r100.showAtLocation(r101, 0, r110, r111);
        PopupWindowLancet.trackAfterShow(r100, r102, r101);
        return;
    L8:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r100) == false) goto L11;
        r100.showAtLocation(r101, 0, r110, r111);
    }

    @Override // com.bytedance.android.livesdk.popup.manager.LivePopupWindow, android.widget.PopupWindow
    public final void showAtLocation(View r100, int r101, int r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (PopupWindowLancet.hasSubWindowToken(r100) == false) goto L7;
    L13:
        d(true);     // Catch: Exception -> L15
        return;
    L7:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(this) == false) goto L9;
        super.showAtLocation(r100, r101, r110, r111);     // Catch: Exception -> L15
        goto L13
    L9:
        OverlaySource r102 = PopupWindowLancet.resolveSource(r100);     // Catch: Exception -> L15
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(this, r100, r102, r101, r110, r111) == true) goto L13;
        super.showAtLocation(r100, r101, r110, r111);     // Catch: Exception -> L15
        PopupWindowLancet.trackAfterShow(this, r102, r100);     // Catch: Exception -> L15
    }
}
