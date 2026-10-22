package com.obric.oui.sheet.v2;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$string;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.view.WindowInsetsCompat;
import kotlin.jvm.internal.q;
import tc.l;

/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f16921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OSheetBase f16922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RadiusLayout f16923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f16924d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f16925e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f16926f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewGroup f16927g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f16928h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f16929i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f16930j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public OSheet.HeightMode f16931k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f16932l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f16933m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public OSheetTitleBar f16934n;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16935a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f16936b = null;

        static {
            int[] r10 = new int[OSheet.HeightMode.values().length];
            r10[OSheet.HeightMode.FULL_HEIGHT.ordinal()] = 1;
            r10[OSheet.HeightMode.WRAP_HEIGHT.ordinal()] = 2;
            f16935a = r10;
            int[] r11 = new int[OSheet.Header.values().length];
            r11[OSheet.Header.PAGE.ordinal()] = 1;
            r11[OSheet.Header.ACTION.ordinal()] = 2;
            r11[OSheet.Header.MODAL.ordinal()] = 3;
            r11[OSheet.Header.ONLY_TITLE.ordinal()] = 4;
            r11[OSheet.Header.PAGE_WITH_CLOSE.ordinal()] = 5;
            f16936b = r11;
        }
    }

    public h(Context r10, OSheetBase r11, RadiusLayout r12, FrameLayout r13, FrameLayout r14, FrameLayout r15, ViewGroup r16, View r17) {
        q.g(r10, "context");
        q.g(r11, "sheet");
        q.g(r12, "rootContainer");
        q.g(r13, "headerContainer");
        q.g(r14, "bodyContainer");
        q.g(r15, "footerContainer");
        q.g(r16, "scaffoldContainer");
        q.g(r17, "dimView");
        this.f16921a = r10;
        this.f16922b = r11;
        this.f16923c = r12;
        this.f16924d = r13;
        this.f16925e = r14;
        this.f16926f = r15;
        this.f16927g = r16;
        this.f16928h = r17;
        this.f16931k = OSheet.HeightMode.WRAP_HEIGHT;
        this.f16933m = r12.getPaddingBottom();
    }

    public static /* synthetic */ WindowInsets a(h r10, View r11, WindowInsets r12) {
        return u(r10, r11, r12);
    }

    public static /* synthetic */ void b(View r10) {
        w(r10);
    }

    public static final WindowInsets u(h r10, View r11, WindowInsets r12) {
        q.g(r10, "this$0");
        q.g(r11, "v");
        q.g(r12, "insets");
        if (r10.f16932l == true) goto L5;
    L8:
        WindowInsetsCompat r13 = WindowInsetsCompat.m(r12);
        q.f(r13, "toWindowInsetsCompat(insets)");
        int r14 = r13.g(WindowInsetsCompat.Type.c()).f25230d;
        int r15 = wd.a.f25402a.d(r11);
        if (r15 <= 0) goto L11;
        r11.setPadding(0, 0, 0, r15);
    L17:
        return r12;
    L11:
        td.i.d(r11, 0);
        if (r14 == 0) goto L14;
    L16:
        r11.setPadding(0, 0, 0, r14 + r10.f16933m);
        goto L17
    L14:
        if (r11.getRootWindowInsets() == null) goto L16;
        WindowInsetsCompat r16 = WindowInsetsCompat.m(r11.getRootWindowInsets());
        q.f(r16, "toWindowInsetsCompat(v.rootWindowInsets)");
        r14 = r16.g(WindowInsetsCompat.Type.c()).f25230d;
        goto L16
    L5:
        if ((r10.f16926f.getChildAt(0) instanceof OSheetFooterBtnContainer) == true) goto L8;
        r11.setPadding(0, 0, 0, r10.f16933m);
        return r12;
    }

    public static final void w(View r10) {
    }

    public final void A() {
        int r10 = this.f16921a.getResources().getDisplayMetrics().widthPixels;
        int r11 = e.a(this.f16921a, r10);
        td.i.e(this.f16923c, r11);
        float r12 = tc.f.e(this.f16921a, 36);
        this.f16923c.c(r12, r12, 0.0f, 0.0f);
    }

    public final void c() {
        this.f16930j = (((this.f16929i - this.f16924d.getHeight()) - this.f16926f.getHeight()) - this.f16923c.getPaddingTop()) - this.f16923c.getPaddingBottom();
    }

    public final FrameLayout d() {
        return this.f16924d;
    }

    public final OSheetTitleBar e() {
        return this.f16934n;
    }

    public final int f() {
        return this.f16930j;
    }

    public final OSheetBase g() {
        return this.f16922b;
    }

    public final boolean h() {
        if (this.f16923c.getHeight() < this.f16929i) goto L5;
        return true;
    L5:
        return false;
    }

    public final void i(Size r10) {
        q.g(r10, "fullWindowSize");
        x(r10);
        z();
        SheetAnimStyle.f16915a.c(this.f16923c);
        c();
        this.f16923c.requestLayout();
    }

    public final void j() {
        this.f16923c.setOnApplyWindowInsetsListener(null);
    }

    public final void k(View r10) {
        l(this.f16925e, r10);
    }

    public final void l(ViewGroup r10, View r11) {
        if (r11 == null) goto L12;
        if (r10 == null) goto L6;
        l.m(r10);
    L6:
        if (r10 == null) goto L9;
        r10.removeAllViews();
    L9:
        if (r10 == null) goto L20;
        r10.addView(r11);
        return;
    L20:
        return;
    L12:
        if (r10 == null) goto L15;
        r10.removeAllViews();
    L15:
        if (r10 == null) goto L21;
        l.k(r10);
        return;
    }

    public final void m(Integer r10, boolean r11, View.OnClickListener r12, Integer r13, boolean r14, View.OnClickListener r15) {
        OSheetFooterBtnContainer r16 = new OSheetFooterBtnContainer(this.f16921a, null, 2, null);
        r16.b(r10, r11, r12, r13, r14, r15);
        o(r16);
    }

    public final void n(String r10, boolean r11, View.OnClickListener r12, String r13, boolean r14, View.OnClickListener r15) {
        OSheetFooterBtnContainer r16 = new OSheetFooterBtnContainer(this.f16921a, null, 2, null);
        r16.c(r10, r11, r12, r13, r14, r15);
        o(r16);
    }

    public final void o(View r10) {
        l(this.f16926f, r10);
    }

    public final void p(OSheet.Header r19, Integer r20, Integer r21, String r22, String r23, boolean r24, View.OnClickListener r25, View.OnClickListener r26, Integer r27, Integer r28, String r29, String r30, Integer r31, Integer r32, SheetMoveDelegate r33) {
        q.g(r19, "style");
        if (r20 == null) goto L5;
        String r10 = this.f16921a.getString(r20.intValue());
    L6:
        if (r21 == null) goto L8;
        String r11 = this.f16921a.getString(r21.intValue());
    L9:
        if (r27 == null) goto L11;
        String r12 = this.f16921a.getString(r27.intValue());
    L12:
        if (r28 == null) goto L14;
        String r13 = this.f16921a.getString(r28.intValue());
    L15:
        int r14 = a.f16936b[r19.ordinal()];
        if (r14 != 1) goto L18;
        AttributeSet r15 = null;
        int r16 = 0;
        OSheetTitleBar r17 = new OSheetTitleBar(this.f16921a, r15, r16, 6, null);
        r17.setTitleText(r10);
        r17.setSubTitleText(r11);
        if (r25 == null) goto L75;
        r17.findViewById(R$id.left_action_back).setOnClickListener(r25);
    L75:
        OSheetTitleBar r18 = r17;
    L76:
        if (r18 == null) goto L85;
        r18.setClipChildren(false);
        if (r24 == false) goto L83;
        if (r33 == null) goto L83;
        r18.b(this.f16921a, r33);
    L83:
        q(r18);
        r18.applyMaskMaterial(g().isContentOverlayMode());
        d().setClipChildren(false);
        return;
    L85:
        return;
    L18:
        if (r14 != 2) goto L20;
        AttributeSet r110 = null;
        int r111 = 0;
        OSheetTitleBar r34 = new OSheetTitleBar(this.f16921a, r110, r111, 6, null);
        r34.setShowLeftBack(false);
        r34.setTitleText(r10);
        r34.setSubTitleText(r11);
        Context r112 = r34.getContext();
        q.f(r112, "context");
        LinearLayout r113 = r34.getMLeftContainer();
        if (r31 != null) goto L58;
        int r35 = R$drawable.oui_ic_title_bar_close;
    L57:
        int r114 = r35;
        OIconButtonFloating r36 = r34.e(r112, r113, r114, r34.getContext().getColorStateList(R$color.oui_text_1), Integer.valueOf(R$string.oui_iv_close_desc));
        r36.setId(R$id.btn_start_action);
        r36.setContentDescription(r12);
        if (r25 == null) goto L63;
        r36.setOnClickListener(r25);
    L63:
        Context r37 = r34.getContext();
        q.f(r37, "context");
        LinearLayout r38 = r34.getMRightContainer();
        if (r32 != null) goto L66;
        int r39 = R$drawable.oui_ic_title_bar_confirm;
    L67:
        int r310 = r39;
        OIconButtonFloating r40 = r34.f(r37, r38, r310, r34.getContext().getColorStateList(R$color.oui_on_accent_default), Integer.valueOf(R$string.oui_confirm));
        r40.setId(R$id.btn_end_action);
        r40.setContentDescription(r13);
        if (r26 == null) goto L44;
        r40.setOnClickListener(r26);
    L44:
        r18 = r34;
        goto L76
    L66:
        r39 = r32.intValue();
        goto L67
    L58:
        r35 = r31.intValue();
        goto L57
    L20:
        if (r14 != 3) goto L22;
        AttributeSet r115 = null;
        int r116 = 0;
        r18 = new OSheetTitleBar(this.f16921a, r115, r116, 6, null);
        r18.setShowLeftBack(false);
        r18.setTitleText(r10);
        r18.setSubTitleText(r11);
        Context r41 = r18.getContext();
        q.f(r41, "context");
        LinearLayout r42 = r18.getMRightContainer();
        if (r32 != null) goto L49;
        int r43 = R$drawable.oui_ic_title_bar_close;
    L50:
        int r311 = r43;
        OIconButtonFloating r44 = r18.e(r41, r42, r311, r18.getContext().getColorStateList(R$color.oui_text_1), Integer.valueOf(R$string.oui_iv_close_desc));
        r44.setId(R$id.btn_end_action);
        r44.setContentDescription(r13);
        if (r26 == null) goto L76;
        r44.setOnClickListener(r26);
        goto L76
    L49:
        r43 = r32.intValue();
        goto L50
    L22:
        if (r14 != 4) goto L24;
        AttributeSet r45 = null;
        int r46 = 0;
        r18 = new OSheetTitleBar(this.f16921a, r45, r46, 6, null);
        r18.setShowLeftBack(false);
        r18.setTitleText(r10);
        r18.setSubTitleText(r11);
        goto L76
    L24:
        if (r14 == 5) goto L26;
        r18 = null;
        goto L76
    L26:
        AttributeSet r117 = null;
        int r118 = 0;
        r34 = new OSheetTitleBar(this.f16921a, r117, r118, 6, null);
        r34.setTitleText(r10);
        r34.setSubTitleText(r11);
        if (r25 == null) goto L33;
        View r47 = r34.findViewById(R$id.left_action_back);
        if (r47 == null) goto L33;
        r47.setOnClickListener(r25);
    L33:
        Context r48 = r34.getContext();
        q.f(r48, "context");
        LinearLayout r49 = r34.getMRightContainer();
        if (r32 != null) goto L36;
        int r50 = R$drawable.oui_ic_title_bar_close;
    L37:
        int r312 = r50;
        OIconButtonFloating r51 = r34.e(r48, r49, r312, r34.getContext().getColorStateList(R$color.oui_text_1), Integer.valueOf(R$string.oui_iv_close_desc));
        r51.setId(R$id.btn_end_action);
        if (r13 == null) goto L41;
        r51.setContentDescription(r13);
    L41:
        if (r26 == null) goto L44;
        r51.setOnClickListener(r26);
        goto L44
    L36:
        r50 = r32.intValue();
        goto L37
    L14:
        r13 = r30;
        goto L15
    L11:
        r12 = r29;
        goto L12
    L8:
        r11 = r23;
        goto L9
    L5:
        r10 = r22;
        goto L6
    }

    public final void q(View r10) {
        if ((r10 instanceof OSheetTitleBar) == false) goto L5;
        this.f16934n = (OSheetTitleBar) r10;
    L6:
        l(this.f16924d, r10);
        return;
    L5:
        this.f16934n = null;
        goto L6
    }

    public final void r(OSheet.HeightMode r10) {
        q.g(r10, "<set-?>");
        this.f16931k = r10;
    }

    public final void s(boolean r10) {
        this.f16932l = r10;
    }

    public final void t() {
        this.f16923c.setOnApplyWindowInsetsListener(new f(this));
    }

    public final void v(Size r10) {
        q.g(r10, "fullWindowSize");
        this.f16923c.setOnClickListener(new g());
        this.f16927g.setClipChildren(false);
        this.f16928h.setBackgroundColor(-16777216);
        this.f16928h.setAlpha(0.0f);
        l.k(this.f16928h);
        x(r10);
        z();
        SheetAnimStyle.f16915a.c(this.f16923c);
        c();
    }

    public final void x(Size r10) {
        q.g(r10, "fullWindowSize");
        if (r10.getWidth() <= r10.getHeight()) goto L5;
        this.f16929i = (int) (r10.getHeight() * 0.84f);
        return;
    L5:
        this.f16929i = (int) (r10.getHeight() * 0.93f);
    }

    public final void y() {
        this.f16923c.setMaxHeight(this.f16929i);
        int r10 = a.f16935a[this.f16931k.ordinal()];
        boolean r11 = false;
        if (r10 != 1) goto L5;
        td.i.c(this.f16923c, this.f16929i);
        if ((this.f16927g instanceof LinearLayout) == false) goto L27;
        ViewGroup.LayoutParams r12 = this.f16925e.getLayoutParams();
        if (r12 == null) goto L26;
        LinearLayout.LayoutParams r13 = (LinearLayout.LayoutParams) r12;
        r13.weight = 1.0f;
        r13.height = 0;
        this.f16925e.setLayoutParams(r13);
    L30:
        this.f16927g.getLayoutParams().height = -1;
    L31:
        RadiusLayout r14 = this.f16923c;
        if (this.f16931k != OSheet.HeightMode.WRAP_HEIGHT) goto L34;
        r11 = true;
    L34:
        r14.setMeasureHeightUnspecified(r11);
        RadiusLayout r15 = this.f16923c;
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        if (r16 == null) goto L39;
        FrameLayout.LayoutParams r17 = (FrameLayout.LayoutParams) r16;
        r17.gravity = 81;
        r15.setLayoutParams(r17);
        return;
    L39:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L27:
        ViewGroup.LayoutParams r18 = this.f16925e.getLayoutParams();
        if (r18 == null) goto L41;
        r18.height = -1;
        this.f16925e.setLayoutParams(r18);
        goto L30
    L41:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L5:
        if (r10 != 2) goto L31;
        td.i.c(this.f16923c, -2);
        if ((this.f16927g instanceof LinearLayout) == false) goto L14;
        ViewGroup.LayoutParams r19 = this.f16925e.getLayoutParams();
        if (r19 == null) goto L13;
        LinearLayout.LayoutParams r20 = (LinearLayout.LayoutParams) r19;
        r20.weight = 0.0f;
        r20.height = -2;
        this.f16925e.setLayoutParams(r20);
    L17:
        this.f16927g.getLayoutParams().height = -2;
        goto L31
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L14:
        ViewGroup.LayoutParams r21 = this.f16925e.getLayoutParams();
        if (r21 == null) goto L19;
        r21.height = -2;
        this.f16925e.setLayoutParams(r21);
        goto L17
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void z() {
        A();
        y();
    }
}
