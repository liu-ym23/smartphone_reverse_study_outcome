package com.obric.oui.sheet.v2;

import android.content.Context;
import android.os.Build;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.common.util.g;
import com.obric.oui.common.util.k;
import com.obric.oui.d.i;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Objects;

/* JADX INFO: compiled from: OSheetBase.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f36229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.oui.sheet.v2.a f36230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RadiusLayout f36231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final FrameLayout f36232d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final FrameLayout f36233e;
    private final FrameLayout f;
    private final ViewGroup g;
    private final View h;
    private int i;
    private int j;
    private OSheet.c k;
    private boolean l;
    private int m;
    private OSheetTitleBar n;

    /* JADX INFO: compiled from: OSheetBase.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f36234a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f36235b = null;

        static {
            int[] r0 = new int[OSheet.c.values().length];
            r0[OSheet.c.f36215a.ordinal()] = 1;
            r0[OSheet.c.f36216b.ordinal()] = 2;
            f36234a = r0;
            int[] r1 = new int[OSheet.b.values().length];
            r1[OSheet.b.f36211b.ordinal()] = 1;
            r1[OSheet.b.f36212c.ordinal()] = 2;
            r1[OSheet.b.f36213d.ordinal()] = 3;
            r1[OSheet.b.f36214e.ordinal()] = 4;
            r1[OSheet.b.f.ordinal()] = 5;
            f36235b = r1;
        }
    }

    private static final void d(View r0) {
    }

    /* JADX INFO: renamed from: lambda$2piNqOK6-FnN2KwzVvrzw-YZE8w, reason: not valid java name */
    public static /* synthetic */ WindowInsets m1182lambda$2piNqOK6FnN2KwzVvrzwYZE8w(c r0, View r1, WindowInsets r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$dVzgFYGaad_d8mTShOi2nQ_wWv0(View r0) {
        d(r0);
    }

    public c(Context r3, com.obric.oui.sheet.v2.a r4, RadiusLayout r5, FrameLayout r6, FrameLayout r7, FrameLayout r8, ViewGroup r9, View r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        com.obric.oui.sheet.v2.a r12 = (com.obric.oui.sheet.v2.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin");
        o.e(r11, "context");
        o.e(r12, "sheet");
        o.e(r5, "rootContainer");
        o.e(r6, "headerContainer");
        o.e(r7, "bodyContainer");
        o.e(r8, "footerContainer");
        o.e(r9, "scaffoldContainer");
        o.e(r10, "dimView");
        this.f36229a = ZeusTransformUtils.wrapperContext(r11, "com.obric.aiagent.plugin");
        this.f36230b = r12;
        this.f36231c = r5;
        this.f36232d = r6;
        this.f36233e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.k = OSheet.c.f36216b;
        this.m = r5.getPaddingBottom();
    }

    public final com.obric.oui.sheet.v2.a a() {
        return this.f36230b;
    }

    public final FrameLayout b() {
        return this.f36232d;
    }

    public final void a(int r1) {
        this.i = r1;
    }

    public final int c() {
        return this.i;
    }

    public final void a(OSheet.c r2) {
        o.e(r2, "<set-?>");
        this.k = r2;
    }

    public final void a(boolean r1) {
        this.l = r1;
    }

    public final OSheetTitleBar d() {
        return this.n;
    }

    public final void a(Size r4) {
        o.e(r4, "fullWindowSize");
        this.f36231c.setOnClickListener($$Lambda$c$dVzgFYGaad_d8mTShOi2nQ_wWv0.INSTANCE);
        this.g.setClipChildren(false);
        this.h.setBackgroundColor(-16777216);
        this.h.setAlpha(0.0f);
        k.b(this.h);
        b(r4);
        e();
        d.f36236a.a((View) ZeusTransformUtils.preCheckCast(this.f36231c, View.class, "com.obric.aiagent.plugin"));
        j();
    }

    public final void b(Size r3) {
        o.e(r3, "fullWindowSize");
        if (r3.getWidth() <= r3.getHeight()) goto L5;
        this.i = (int) (r3.getHeight() * 0.84f);
        return;
    L5:
        this.i = (int) (r3.getHeight() * 0.93f);
    }

    public final void c(Size r4) {
        o.e(r4, "fullWindowSize");
        b(r4);
        e();
        d.f36236a.a((View) ZeusTransformUtils.preCheckCast(this.f36231c, View.class, "com.obric.aiagent.plugin"));
        j();
        this.f36231c.requestLayout();
    }

    public final void e() {
        f();
        g();
    }

    public final void f() {
        int r0 = ZeusTransformUtils.getResources(this.f36229a, "com.obric.aiagent.plugin").getDisplayMetrics().widthPixels;
        int r1 = b.a(this.f36229a, r0);
        i.a((View) ZeusTransformUtils.preCheckCast(this.f36231c, View.class, "com.obric.aiagent.plugin"), r1);
        float r2 = g.b(this.f36229a, 36);
        this.f36231c.setRadius(r2, r2, 0.0f, 0.0f);
    }

    public final void g() {
        this.f36231c.setMaxHeight(this.i);
        int r0 = a.f36234a[this.k.ordinal()];
        boolean r3 = false;
        if (r0 != 1) goto L5;
        i.b((View) ZeusTransformUtils.preCheckCast(this.f36231c, View.class, "com.obric.aiagent.plugin"), this.i);
        if (ZeusTransformUtils.instanceOf(this.g, LinearLayout.class) == false) goto L15;
        ViewGroup.LayoutParams r1 = this.f36233e.getLayoutParams();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r2 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r1, LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r2.weight = 1.0f;
        r2.height = 0;
        this.f36233e.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
    L16:
        this.g.getLayoutParams().height = -1;
    L17:
        RadiusLayout r4 = this.f36231c;
        if (this.k != OSheet.c.f36216b) goto L20;
        r3 = true;
    L20:
        r4.setMeasureHeightUnspecified(r3);
        RadiusLayout r8 = this.f36231c;
        ViewGroup.LayoutParams r5 = r8.getLayoutParams();
        Objects.requireNonNull(r5, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r6 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r5, FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r6.gravity = 81;
        r8.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r6, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    L15:
        ViewGroup.LayoutParams r7 = this.f36233e.getLayoutParams();
        Objects.requireNonNull(r7, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        r7.height = -1;
        this.f36233e.setLayoutParams(r7);
        goto L16
    L5:
        if (r0 != 2) goto L17;
        i.b((View) ZeusTransformUtils.preCheckCast(this.f36231c, View.class, "com.obric.aiagent.plugin"), -2);
        if (ZeusTransformUtils.instanceOf(this.g, LinearLayout.class) == false) goto L10;
        ViewGroup.LayoutParams r9 = this.f36233e.getLayoutParams();
        Objects.requireNonNull(r9, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r10 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r9, LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r10.weight = 0.0f;
        r10.height = -2;
        this.f36233e.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r10, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
    L11:
        this.g.getLayoutParams().height = -2;
        goto L17
    L10:
        ViewGroup.LayoutParams r11 = this.f36233e.getLayoutParams();
        Objects.requireNonNull(r11, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        r11.height = -2;
        this.f36233e.setLayoutParams(r11);
        goto L11
    }

    public final void h() {
        this.f36231c.setOnApplyWindowInsetsListener(new $$Lambda$c$2piNqOK6FnN2KwzVvrzwYZE8w(this));
    }

    private static final WindowInsets a(c r6, View r7, WindowInsets r8) {
        o.e(r6, "this$0");
        o.e(r7, "v");
        o.e(r8, "insets");
        if (r6.l == true) goto L5;
    L8:
        com.obric.oui.view.g r0 = com.obric.oui.view.g.a(r8);
        o.c(r0, "toWindowInsetsCompat(insets)");
        int r2 = r0.b(com.obric.oui.view.g.m.b()).f36824e;
        if (r2 == 0) goto L11;
    L13:
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r3, "v.context");
        if (com.obric.oui.window.a.f(r3) == true) goto L18;
        if (r2 <= 0) goto L18;
        int r4 = 40;
    L19:
        int r5 = Math.max(r2, g.a(r7, r4)) + r6.m;
        int r9 = r0.a(com.obric.oui.view.g.m.a()).f36824e;
        if (Build.VERSION.SDK_INT < 30) goto L22;
        int r10 = Math.max(r9, com.obric.oui.window.a.f36851a.a(r7));
    L23:
        if (r10 <= 0) goto L25;
        r7.setPadding(0, 0, 0, Math.max(r5, r10));
    L26:
        return r8;
    L25:
        i.c(r7, 0);
        r7.setPadding(0, 0, 0, r5);
        goto L26
    L22:
        r10 = 0;
    L18:
        r4 = 24;
        goto L19
    L11:
        if (r7.getRootWindowInsets() == null) goto L13;
        com.obric.oui.view.g r11 = com.obric.oui.view.g.a(r7.getRootWindowInsets());
        o.c(r11, "toWindowInsetsCompat(v.rootWindowInsets)");
        r2 = r11.b(com.obric.oui.view.g.m.b()).f36824e;
        goto L13
    L5:
        if (ZeusTransformUtils.instanceOf(r6.f.getChildAt(0), OSheetFooterBtnContainer.class) == true) goto L8;
        r7.setPadding(0, 0, 0, r6.m);
        return r8;
    }

    public final void i() {
        this.f36231c.setOnApplyWindowInsetsListener(null);
    }

    public final void a(OSheet.b r23, Integer r24, Integer r25, String r26, String r27, boolean r28, View.OnClickListener r29, View.OnClickListener r30, Integer r31, Integer r32, String r33, String r34, Integer r35, Integer r36, e r37) {
        View.OnClickListener r1 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r29, View.OnClickListener.class, "com.obric.aiagent.plugin");
        View.OnClickListener r3 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r30, View.OnClickListener.class, "com.obric.aiagent.plugin");
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r37, e.class, "com.obric.aiagent.plugin");
        o.e(r23, "style");
        if (r24 == null) goto L5;
        String r5 = this.f36229a.getString(r24.intValue());
    L6:
        if (r25 == null) goto L8;
        String r7 = this.f36229a.getString(r25.intValue());
    L9:
        if (r31 == null) goto L11;
        String r8 = this.f36229a.getString(r31.intValue());
    L12:
        if (r32 == null) goto L14;
        String r9 = this.f36229a.getString(r32.intValue());
    L15:
        int r6 = a.f36235b[r23.ordinal()];
        if (r6 == 1) goto L73;
        e r210 = r4;
        String r211 = r8;
        String r212 = r9;
        if (r6 != 2) goto L20;
        OSheetTitleBar r10 = new OSheetTitleBar(this.f36229a, null, 0, 6, null);
        r10.setShowLeftBack(false);
        r10.setTitleText(r5);
        r10.setSubTitleText(r7);
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r11, "context");
        ViewGroup r12 = (ViewGroup) ZeusTransformUtils.preCheckCast(r10.getMLeftContainer(), ViewGroup.class, "com.obric.aiagent.plugin");
        if (r35 != null) goto L58;
        int r13 = ZeusTransformUtils.mapRes(R.drawable.oui_ic_title_bar_close, "drawable", "oui_ic_title_bar_close");
    L59:
        int r38 = r13;
        OIconButtonFloating r0 = r10.createNeutralIconButton(r11, r12, r38, ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getColorStateList(ZeusTransformUtils.mapRes(R.color.oui_text_1, "color", "oui_text_1")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.oui_iv_close_desc, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_iv_close_desc")));
        r0.setId(ZeusTransformUtils.mapRes(R.id.btn_start_action, DbHelper.COL_ID, "btn_start_action"));
        r0.setContentDescription((CharSequence) ZeusTransformUtils.preCheckCast(r211, CharSequence.class, "com.obric.aiagent.plugin"));
        if (r1 == null) goto L63;
        r0.setOnClickListener(r1);
    L63:
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r2, "context");
        ViewGroup r14 = (ViewGroup) ZeusTransformUtils.preCheckCast(r10.getMRightContainer(), ViewGroup.class, "com.obric.aiagent.plugin");
        if (r36 != null) goto L66;
        int r15 = ZeusTransformUtils.mapRes(R.drawable.oui_ic_title_bar_confirm, "drawable", "oui_ic_title_bar_confirm");
    L67:
        int r39 = r15;
        OIconButtonFloating r16 = r10.createPrimaryIconButton(r2, r14, r39, ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getColorStateList(ZeusTransformUtils.mapRes(R.color.oui_on_accent_default, "color", "oui_on_accent_default")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.oui_confirm, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_confirm")));
        r16.setId(ZeusTransformUtils.mapRes(R.id.btn_end_action, DbHelper.COL_ID, "btn_end_action"));
        r16.setContentDescription((CharSequence) ZeusTransformUtils.preCheckCast(r212, CharSequence.class, "com.obric.aiagent.plugin"));
        if (r3 == null) goto L71;
        r16.setOnClickListener(r3);
    L71:
        c r17 = this;
    L72:
        OSheetTitleBar r18 = r10;
    L78:
        if (r18 == null) goto L87;
        r18.setClipChildren(false);
        if (r28 == false) goto L85;
        if (r210 == null) goto L85;
        r18.createHandleView(r17.f36229a, r210);
    L85:
        r17.a((View) ZeusTransformUtils.preCheckCast(r18, View.class, "com.obric.aiagent.plugin"));
        r18.applyMaskMaterial(a().isContentOverlayMode());
        b().setClipChildren(false);
        return;
    L87:
        return;
    L66:
        r15 = r36.intValue();
        goto L67
    L58:
        r13 = r35.intValue();
        goto L59
    L20:
        if (r6 != 3) goto L22;
        r18 = new OSheetTitleBar(this.f36229a, null, 0, 6, null);
        r18.setShowLeftBack(false);
        r18.setTitleText(r5);
        r18.setSubTitleText(r7);
        Context r19 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r18.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r19, "context");
        ViewGroup r20 = (ViewGroup) ZeusTransformUtils.preCheckCast(r18.getMRightContainer(), ViewGroup.class, "com.obric.aiagent.plugin");
        if (r36 != null) goto L50;
        int r21 = ZeusTransformUtils.mapRes(R.drawable.oui_ic_title_bar_close, "drawable", "oui_ic_title_bar_close");
    L51:
        int r310 = r21;
        OIconButtonFloating r22 = r18.createNeutralIconButton(r19, r20, r310, ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r18.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getColorStateList(ZeusTransformUtils.mapRes(R.color.oui_text_1, "color", "oui_text_1")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.oui_iv_close_desc, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_iv_close_desc")));
        r22.setId(ZeusTransformUtils.mapRes(R.id.btn_end_action, DbHelper.COL_ID, "btn_end_action"));
        r22.setContentDescription((CharSequence) ZeusTransformUtils.preCheckCast(r212, CharSequence.class, "com.obric.aiagent.plugin"));
        if (r3 == null) goto L26;
        r22.setOnClickListener(r3);
    L26:
        r17 = this;
        goto L78
    L50:
        r21 = r36.intValue();
        goto L51
    L22:
        if (r6 != 4) goto L24;
        r18 = new OSheetTitleBar(this.f36229a, null, 0, 6, null);
        r18.setShowLeftBack(false);
        r18.setTitleText(r5);
        r18.setSubTitleText(r7);
        goto L26
    L24:
        if (r6 == 5) goto L27;
        r18 = null;
        goto L26
    L27:
        r10 = new OSheetTitleBar(this.f36229a, null, 0, 6, null);
        r10.setTitleText(r5);
        r10.setSubTitleText(r7);
        if (r1 == null) goto L34;
        View r40 = r10.findViewById(ZeusTransformUtils.mapRes(R.id.left_action_back, DbHelper.COL_ID, "left_action_back"));
        if (r40 == null) goto L34;
        r40.setOnClickListener(r1);
    L34:
        Context r41 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r41, "context");
        ViewGroup r42 = (ViewGroup) ZeusTransformUtils.preCheckCast(r10.getMRightContainer(), ViewGroup.class, "com.obric.aiagent.plugin");
        if (r36 != null) goto L37;
        int r43 = ZeusTransformUtils.mapRes(R.drawable.oui_ic_title_bar_close, "drawable", "oui_ic_title_bar_close");
    L38:
        int r311 = r43;
        OIconButtonFloating r44 = r10.createNeutralIconButton(r41, r42, r311, ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getColorStateList(ZeusTransformUtils.mapRes(R.color.oui_text_1, "color", "oui_text_1")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.oui_iv_close_desc, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_iv_close_desc")));
        r44.setId(ZeusTransformUtils.mapRes(R.id.btn_end_action, DbHelper.COL_ID, "btn_end_action"));
        if (r212 == null) goto L42;
        r44.setContentDescription((CharSequence) ZeusTransformUtils.preCheckCast(r212, CharSequence.class, "com.obric.aiagent.plugin"));
    L42:
        if (r3 == null) goto L45;
        r44.setOnClickListener(r3);
    L45:
        r17 = this;
        goto L72
    L37:
        r43 = r36.intValue();
        goto L38
    L73:
        r210 = r4;
        r17 = this;
        OSheetTitleBar r45 = new OSheetTitleBar(r17.f36229a, null, 0, 6, null);
        r45.setTitleText(r5);
        r45.setSubTitleText(r7);
        if (r1 == null) goto L77;
        r45.findViewById(ZeusTransformUtils.mapRes(R.id.left_action_back, DbHelper.COL_ID, "left_action_back")).setOnClickListener(r1);
    L77:
        r18 = r45;
        goto L78
    L14:
        r9 = r34;
        goto L15
    L11:
        r8 = r33;
        goto L12
    L8:
        r7 = r27;
        goto L9
    L5:
        r5 = r26;
        goto L6
    }

    public final void a(View r4) {
        if (ZeusTransformUtils.instanceOf(r4, OSheetTitleBar.class) == false) goto L5;
        this.n = (OSheetTitleBar) ZeusTransformUtils.preCheckCast(r4, OSheetTitleBar.class, "com.obric.aiagent.plugin");
    L6:
        a((ViewGroup) ZeusTransformUtils.preCheckCast(this.f36232d, ViewGroup.class, "com.obric.aiagent.plugin"), r4);
        return;
    L5:
        this.n = null;
        goto L6
    }

    public final void b(View r4) {
        a((ViewGroup) ZeusTransformUtils.preCheckCast(this.f36233e, ViewGroup.class, "com.obric.aiagent.plugin"), r4);
    }

    public final void c(View r4) {
        a((ViewGroup) ZeusTransformUtils.preCheckCast(this.f, ViewGroup.class, "com.obric.aiagent.plugin"), r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(Integer r10, boolean r11, View.OnClickListener r12, Integer r13, boolean r14, View.OnClickListener r15) {
        View.OnClickListener r5 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r12, View.OnClickListener.class, "com.obric.aiagent.plugin");
        View.OnClickListener r8 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r15, View.OnClickListener.class, "com.obric.aiagent.plugin");
        OSheetFooterBtnContainer r16 = new OSheetFooterBtnContainer(this.f36229a, null, 2, 0 == true ? 1 : 0);
        r16.setButtons(r10, r11, r5, r13, r14, r8);
        c((View) ZeusTransformUtils.preCheckCast(r16, View.class, "com.obric.aiagent.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(String r10, boolean r11, View.OnClickListener r12, String r13, boolean r14, View.OnClickListener r15) {
        View.OnClickListener r5 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r12, View.OnClickListener.class, "com.obric.aiagent.plugin");
        View.OnClickListener r8 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r15, View.OnClickListener.class, "com.obric.aiagent.plugin");
        OSheetFooterBtnContainer r16 = new OSheetFooterBtnContainer(this.f36229a, null, 2, 0 == true ? 1 : 0);
        r16.setButtons(r10, r11, r5, r13, r14, r8);
        c((View) ZeusTransformUtils.preCheckCast(r16, View.class, "com.obric.aiagent.plugin"));
    }

    public final void j() {
        if (this.f36230b.isContentOverlayMode() == false) goto L5;
        int r0 = 0;
    L6:
        this.j = (((this.i - r0) - this.f.getHeight()) - this.f36231c.getPaddingTop()) - this.f36231c.getPaddingBottom();
        return;
    L5:
        r0 = this.f36232d.getHeight();
        goto L6
    }

    public final int k() {
        return this.j;
    }

    public final boolean l() {
        if (this.f36231c.getHeight() < this.i) goto L5;
        return true;
    L5:
        return false;
    }

    public final void a(ViewGroup r2, View r3) {
        if (r3 == null) goto L13;
        if (r2 == null) goto L7;
        k.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"));
    L7:
        if (r2 == null) goto L10;
        r2.removeAllViews();
    L10:
        if (r2 == null) goto L21;
        r2.addView(r3);
        return;
    L21:
        return;
    L13:
        if (r2 == null) goto L16;
        r2.removeAllViews();
    L16:
        if (r2 == null) goto L22;
        k.b((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"));
        return;
    }

    public final void b(ViewGroup r2, View r3) {
        if (r3 == null) goto L10;
        if (r2 == null) goto L7;
        k.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"));
    L7:
        if (r2 == null) goto L15;
        r2.addView(r3);
        return;
    L15:
        return;
    L10:
        if (r2 == null) goto L16;
        k.b((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"));
        return;
    }
}
