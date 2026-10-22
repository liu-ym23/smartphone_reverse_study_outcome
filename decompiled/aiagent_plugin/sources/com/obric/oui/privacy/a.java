package com.obric.oui.privacy;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.Size;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.g;
import com.obric.oui.image.OImageAppIcon;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.privacy.recyclerview.PrivacyTopDownAlphaMaskRecyclerView;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.a.q;
import d.h.b.aa;
import d.h.b.h;
import d.h.b.o;
import d.l.n;
import d.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: OPrivacySheet.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0980a f36068a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f36069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.oui.privacy.b f36070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private OSheet f36071d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private RecyclerView f36072e;
    private com.obric.oui.privacy.c f;

    /* JADX INFO: renamed from: com.obric.oui.privacy.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OPrivacySheet.kt */
    public static final class C0980a {
        public /* synthetic */ C0980a(h r1) {
            this();
        }

        private C0980a() {
        }
    }

    /* JADX INFO: compiled from: OPrivacySheet.kt */
    public static final class b extends RecyclerView.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f36073a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ PrivacyTopDownAlphaMaskRecyclerView f36074b;

        b(a r1, PrivacyTopDownAlphaMaskRecyclerView r2) {
            this.f36073a = r1;
            this.f36074b = r2;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.g
        public void a(Rect r2, View r3, RecyclerView r4, RecyclerView.s r5) {
            o.e(r2, "outRect");
            o.e(r3, "view");
            o.e(r4, "parent");
            o.e(r5, "state");
            int r6 = r4.getChildAdapterPosition(r3);
            if (r6 <= 0) goto L14;
            com.obric.oui.privacy.d r7 = (com.obric.oui.privacy.d) ZeusTransformUtils.preCheckCast(p.d(a.c(this.f36073a).d(), r6), com.obric.oui.privacy.d.class, "com.obric.aiagent.plugin");
            com.obric.oui.privacy.d r8 = (com.obric.oui.privacy.d) ZeusTransformUtils.preCheckCast(p.d(a.c(this.f36073a).d(), r6 - 1), com.obric.oui.privacy.d.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L11;
            if (r8 == null) goto L11;
            if (o.a(aa.b(r7.getClass()), aa.b(r8.getClass())) == true) goto L11;
            Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f36074b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            o.c(r1, "context");
            r2.top = g.a(r1, 16);
            return;
        L11:
            if (ZeusTransformUtils.instanceOf(r7, com.obric.oui.privacy.d.b.class) == false) goto L16;
            r2.top = 0;
            return;
        L16:
            return;
        }
    }

    /* JADX INFO: compiled from: OPrivacySheet.kt */
    static final class c extends d.h.b.p implements d.h.a.b<View, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f36075a;

        c(a r1) {
            this.f36075a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(View r3) {
            a((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(View r2) {
            o.e(r2, "it");
            com.obric.oui.privacy.c r1 = a.a(this.f36075a);
            if (r1 == null) goto L7;
            r1.a();
            return;
        }
    }

    /* JADX INFO: compiled from: OPrivacySheet.kt */
    static final class d extends d.h.b.p implements d.h.a.b<View, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f36076a;

        d(a r1) {
            this.f36076a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(View r3) {
            a((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(View r2) {
            o.e(r2, "it");
            com.obric.oui.privacy.c r1 = a.a(this.f36076a);
            if (r1 == null) goto L7;
            r1.b();
            return;
        }
    }

    /* JADX INFO: compiled from: OPrivacySheet.kt */
    static final class e extends d.h.b.p implements q<Context, Integer, Integer, OButton> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f36077a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.a.b<View, x> f36078b;

        e(String r3, d.h.a.b<? super View, x> r4) {
            d.h.a.b<View, x> r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
            this.f36077a = r3;
            this.f36078b = r5;
            super(3);
        }

        /* JADX INFO: renamed from: lambda$222lRFUW2m4weDpv-Lz4vcDJnO8, reason: not valid java name */
        public static /* synthetic */ void m1144lambda$222lRFUW2m4weDpvLz4vcDJnO8(d.h.a.b r0, View r1) {
            a(r0, r1);
        }

        @Override // d.h.a.q
        public /* synthetic */ OButton invoke(Context r3, Integer r4, Integer r5) {
            return a((Context) ZeusTransformUtils.preCheckCast(r3, Context.class, "com.obric.aiagent.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).intValue());
        }

        public final OButton a(Context r10, int r11, int r12) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
            o.e(r2, "styledContext");
            OButton r13 = new OButton(r2, null, 0, 0, null, 28, null);
            String r14 = this.f36077a;
            final d.h.a.b<View, x> r9 = this.f36078b;
            r13.setText((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin"));
            r13.setLayoutParams(new ViewGroup.LayoutParams(-1, r12));
            if (r9 != null) goto L5;
            View.OnClickListener r15 = null;
        L6:
            r13.setOnClickListener(r15);
            return r13;
        L5:
            r15 = new $$Lambda$a$e$222lRFUW2m4weDpvLz4vcDJnO8(r9);
            goto L6
        }

        private static final void a(d.h.a.b r2, View r3) {
            ((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(r3);
        }
    }

    /* JADX INFO: compiled from: OPrivacySheet.kt */
    public static final class f implements com.obric.oui.dialog.a.InterfaceC0947a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f36079a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f36080b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f36081c;

        f(a r1, View r2, int r3) {
            this.f36079a = r1;
            this.f36080b = r2;
            this.f36081c = r3;
        }

        @Override // com.obric.oui.dialog.a.InterfaceC0947a
        public void a(Dialog r6, Configuration r7) {
            o.e(r6, "dialog");
            o.e(r7, "configuration");
            a r8 = this.f36079a;
            int r0 = r7.screenHeightDp;
            View r1 = this.f36080b;
            a.a(r8, r0, r1, com.obric.oui.window.a.d((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), this.f36081c);
            RecyclerView r5 = a.b(this.f36079a);
            if (r5 != null) goto L6;
            return;
        L6:
            if (r7.screenHeightDp <= 650) goto L8;
            r5.setPadding(0, g.a((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin"), 16), 0, g.a((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin"), 16));
            return;
        L8:
            r5.setPadding(0, 0, 0, 0);
        }
    }

    static {
        f36068a = new C0980a(null);
    }

    /* JADX INFO: renamed from: lambda$nYlfaoU4El5xDVm-9rZX72rOzHM, reason: not valid java name */
    public static /* synthetic */ void m1142lambda$nYlfaoU4El5xDVm9rZX72rOzHM(a r0, DialogInterface r1) {
        a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$x3Ta2fWusl8OI_dCL6q0NV5d-3E, reason: not valid java name */
    public static /* synthetic */ boolean m1143lambda$x3Ta2fWusl8OI_dCL6q0NV5d3E(a r0, DialogInterface r1, int r2, KeyEvent r3) {
        return a(r0, r1, r2, r3);
    }

    public a(Context r3, com.obric.oui.privacy.b r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r4, "config");
        this.f36069b = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
        this.f36070c = r4;
    }

    public static final /* synthetic */ com.obric.oui.privacy.c a(a r0) {
        return r0.f;
    }

    public static final /* synthetic */ void a(a r0, int r1, View r2, Size r3, int r4) {
        r0.a(r1, r2, r3, r4);
    }

    public static final /* synthetic */ RecyclerView b(a r0) {
        return r0.f36072e;
    }

    public static final /* synthetic */ com.obric.oui.privacy.b c(a r0) {
        return r0.f36070c;
    }

    public final a a(com.obric.oui.privacy.c r3) {
        com.obric.oui.privacy.c r4 = (com.obric.oui.privacy.c) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.privacy.c.class, "com.obric.aiagent.plugin");
        o.e(r4, "listener");
        this.f = r4;
        return this;
    }

    public final a a() {
        OSheet r8 = new OSheet(this.f36069b, 0, 0, false, false, 14, null);
        r8.setHeightMode(OSheet.c.f36215a);
        r8.setCanceledOnTouchOutside(false);
        r8.setCancelable(false);
        r8.setSheetBgColor(androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.oui_bg_base_2, "color", "oui_bg_base_2")));
        OTextView r0 = e();
        View r2 = a(r0);
        Size r3 = com.obric.oui.window.a.d((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r4, "context");
        int r5 = g.a(r4, r3.getHeight());
        int r1 = a(r3, r0);
        a(r5, r2, r3, r1);
        r8.setHeaderView(r2);
        r8.setBodyView(f());
        r8.setFooterView(g());
        r8.setClearDimFlag(!this.f36070c.i());
        r8.setOnDismissListener(new $$Lambda$a$nYlfaoU4El5xDVm9rZX72rOzHM(this));
        if (this.f36070c.j() == false) goto L5;
        r8.setOnKeyListener(new $$Lambda$a$x3Ta2fWusl8OI_dCL6q0NV5d3E(this));
    L5:
        r8.setOnConfigurationListener((com.obric.oui.dialog.a.InterfaceC0947a) ZeusTransformUtils.preCheckCast(new f(this, r2, r1), com.obric.oui.dialog.a.InterfaceC0947a.class, "com.obric.aiagent.plugin"));
        this.f36071d = r8;
        r8.setEnableEnterAnim(this.f36070c.k());
        r8.show();
        return this;
    }

    private static final void a(a r2, DialogInterface r3) {
        DialogInterface r4 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.aiagent.plugin");
        o.e(r2, "this$0");
        com.obric.oui.privacy.c r5 = r2.f;
        if (r5 == null) goto L7;
        r5.c();
        return;
    }

    private static final boolean a(a r2, DialogInterface r3, int r4, KeyEvent r5) {
        DialogInterface r6 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.aiagent.plugin");
        o.e(r2, "this$0");
        if (r4 == 4) goto L5;
    L16:
        return false;
    L5:
        if (r5 != null) goto L8;
    L6:
        boolean r7 = false;
    L10:
        if (r7 == false) goto L16;
        com.obric.oui.privacy.c r8 = r2.f;
        if (r8 == null) goto L15;
        r8.d();
    L15:
        return true;
    L8:
        if (r5.getAction() != 1) goto L6;
        r7 = true;
        goto L10
    }

    private final void a(int r2, View r3, Size r4, int r5) {
        if (r2 <= 650) goto L5;
        r3.setPadding(0, (int) (r4.getHeight() * 0.135f), 0, (int) ((r4.getHeight() * 0.10375f) - r5));
        return;
    L5:
        r3.setPadding(0, g.a(r3, 20), 0, g.a(r3, 12));
    }

    public final void b() {
        OSheet r0 = this.f36071d;     // Catch: Exception -> L7
        if (r0 == null) goto L10;
        r0.dismiss();     // Catch: Exception -> L7
        return;
    L10:
        return;
    }

    public final void c() {
        OSheet r0 = this.f36071d;     // Catch: Exception -> L7
        if (r0 == null) goto L10;
        r0.dismissImmediately();     // Catch: Exception -> L7
        return;
    L10:
        return;
    }

    public final OSheet d() {
        return this.f36071d;
    }

    private final View a(OTextView r15) {
        LinearLayout r0 = new LinearLayout(this.f36069b);
        r0.setOrientation(1);
        r0.setGravity(1);
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        OImageAppIcon r2 = new OImageAppIcon(this.f36069b, null, 0, 6, null);
        int r5 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_image_size_xl, "dimen", "oui_image_size_xl"));
        r2.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(r5, r5), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(this.f36070c.a(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L5;
    L8:
        boolean r7 = true;
    L9:
        if (r7 == true) goto L11;
        r2.setImagePackageName(this.f36070c.a());
    L11:
        r0.addView((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"));
        LinearLayout r3 = new LinearLayout(this.f36069b);
        r3.setOrientation(1);
        r3.setGravity(1);
        LinearLayout.LayoutParams r8 = new LinearLayout.LayoutParams(-1, -2);
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r4, "context");
        r8.leftMargin = g.a(r4, 32);
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r9, "context");
        r8.rightMargin = g.a(r9, 32);
        Context r10 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r10, "context");
        r8.topMargin = g.a(r10, 20);
        r3.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r8, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        OTextView r11 = new OTextView((Context) ZeusTransformUtils.preCheckCast(new ContextThemeWrapper(this.f36069b, ZeusTransformUtils.mapRes(R.style.Title_4_Bold, "style", "Title_4_Bold")), Context.class, "com.obric.aiagent.plugin"), null, 0, null, 14, null);
        r11.setIncludeFontPadding(true);
        r11.setTextColor(androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, "color", "oui_basic_text_1")));
        r11.setText((CharSequence) ZeusTransformUtils.preCheckCast(this.f36070c.b(), CharSequence.class, "com.obric.aiagent.plugin"));
        r11.setGravity(17);
        r11.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-2, -2), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        r3.addView((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.aiagent.plugin"));
        if (r15 == null) goto L14;
        r3.addView((View) ZeusTransformUtils.preCheckCast(r15, View.class, "com.obric.aiagent.plugin"));
    L14:
        r0.addView((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"));
        return (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin");
    L5:
        if (d.o.o.d(r6) == true) goto L8;
        r7 = false;
        goto L9
    }

    private final OTextView e() {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(this.f36070c.c(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L15;
        OTextView r2 = new OTextView((Context) ZeusTransformUtils.preCheckCast(new ContextThemeWrapper(this.f36069b, ZeusTransformUtils.mapRes(R.style.Body_1_Regular, "style", "Body_1_Regular")), Context.class, "com.obric.aiagent.plugin"), null, 0, null, 14, null);
        r2.setIncludeFontPadding(true);
        r2.setTextColor(androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, "color", "oui_basic_text_3")));
        r2.setText((CharSequence) ZeusTransformUtils.preCheckCast(this.f36070c.c(), CharSequence.class, "com.obric.aiagent.plugin"));
        if (o.a(Locale.getDefault().getLanguage(), Locale.ENGLISH.getLanguage()) == false) goto L13;
        int r10 = 17;
    L14:
        r2.setGravity(r10);
        r2.setMaxLines(3);
        r2.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams r11 = new LinearLayout.LayoutParams(-2, -2);
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r3, "context");
        r11.topMargin = g.a(r3, 8);
        r2.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r11, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return r2;
    L13:
        r10 = 8388611;
        goto L14
    L15:
        return null;
    L5:
        if (d.o.o.d(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    private final int a(Size r3, OTextView r4) {
        if (r4 != null) goto L5;
        return 0;
    L5:
        r4.measure(View.MeasureSpec.makeMeasureSpec(n.c(r3.getWidth() - (g.a(this.f36069b, 32) * 2), 0), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        return (n.c(r4.getLineCount(), 1) - 1) * r4.getLineHeight();
    }

    private final View f() {
        int r0 = g.a(this.f36069b, com.obric.oui.window.a.d(this.f36069b).getHeight());
        FrameLayout r1 = new FrameLayout(this.f36069b);
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(-1, -1);
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r4, "context");
        r2.bottomMargin = g.a(r4, 8);
        r1.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        PrivacyTopDownAlphaMaskRecyclerView r3 = new PrivacyTopDownAlphaMaskRecyclerView(this.f36069b, null, 0, 6, null);
        r3.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        if (r0 <= 650) goto L5;
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r5, "context");
        int r6 = g.a(r5, 16);
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r7, "context");
        r3.setPadding(0, r6, 0, g.a(r7, 16));
    L6:
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r8, "context");
        r3.setFadeEdgeLength(g.b(r8, 75));
        r3.setFadeTop(true);
        r3.setFadeBottom(true);
        r3.setDynamicFade(true);
        r3.setBackgroundColor(0);
        r3.setClipToPadding(false);
        r3.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), RecyclerView.h.class, "com.obric.aiagent.plugin"));
        r3.setAdapter((RecyclerView.a) ZeusTransformUtils.preCheckCast(new com.obric.oui.privacy.a.b(this.f36070c.d()), RecyclerView.a.class, "com.obric.aiagent.plugin"));
        r3.addItemDecoration((RecyclerView.g) ZeusTransformUtils.preCheckCast(new b(this, r3), RecyclerView.g.class, "com.obric.aiagent.plugin"));
        RecyclerView r9 = (RecyclerView) ZeusTransformUtils.preCheckCast(r3, RecyclerView.class, "com.obric.aiagent.plugin");
        this.f36072e = r9;
        r1.addView((View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.aiagent.plugin"));
        return (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin");
    L5:
        r3.setPadding(0, 0, 0, 0);
        goto L6
    }

    private final View g() {
        LinearLayout r1 = new LinearLayout(this.f36069b);
        r1.setOrientation(1);
        r1.setGravity(1);
        r1.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r3, "context");
        int r4 = g.a(r3, 20);
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r9, "context");
        int r10 = g.a(r9, 16);
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r11, "context");
        int r8 = g.a(r11, 20);
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r12, "context");
        r1.setPadding(r4, r10, r8, g.a(r12, 8));
        if (this.f36070c.e() == null) goto L17;
        final OTextView r5 = new OTextView((Context) ZeusTransformUtils.preCheckCast(new ContextThemeWrapper(this.f36069b, ZeusTransformUtils.mapRes(R.style.Button_1_Regular, "style", "Button_1_Regular")), Context.class, "com.obric.aiagent.plugin"), null, 0, null, 14, null);
        r5.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r5.setTextColor(androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, "color", "oui_basic_text_1")));
        r5.setGravity(8388611);
        String r13 = this.f36070c.e();
        List<String> r14 = this.f36070c.f();
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L15;
        SpannableString r15 = new SpannableString((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"));
        Iterator<String> r16 = r14.iterator();
    L8:
        if (r16.hasNext() == false) goto L14;
        final String r17 = (String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.aiagent.plugin");
        int r18 = 0;
    L10:
        int r19 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"), r17, r18, false, 4, null);
        if (r19 < 0) goto L8;
        int r110 = r17.length() + r19;
        r15.setSpan(new OPrivacySheet$buildFooterView$policyTextView$1$1(this, r17, r5), r19, r110, 33);
        r18 = r110;
        goto L10
    L14:
        r5.setText((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin"));
        r5.setMovementMethod(LinkMovementMethod.getInstance());
        r5.setHighlightColor(0);
    L16:
        r1.addView((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin"));
        goto L17
    L15:
        r5.setText((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"));
    L17:
        LinearLayout r6 = new LinearLayout(this.f36069b);
        r6.setOrientation(1);
        r6.setGravity(1);
        LinearLayout.LayoutParams r2 = new LinearLayout.LayoutParams(-1, -2);
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r7, "context");
        r2.topMargin = g.a(r7, 14);
        r6.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        Context r20 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r20, "context");
        int r21 = g.a(r20, 4);
        Context r22 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r22, "context");
        r6.setPadding(r21, 0, g.a(r22, 4), 0);
        Context r23 = this.f36069b;
        String r24 = this.f36070c.g();
        if (r24 != null) goto L20;
        r24 = this.f36069b.getString(ZeusTransformUtils.mapRes(R.string.oui_agree, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_agree"));
        o.c(r24, "context.getString(R.string.oui_agree)");
    L20:
        r6.addView((View) ZeusTransformUtils.preCheckCast(a(r23, r24, ZeusTransformUtils.mapRes(R.style.OStyleV2_OButton_L_Standard_Primary, "style", "OStyleV2_OButton_L_Standard_Primary"), (d.h.a.b) ZeusTransformUtils.preCheckCast(new c(this), d.h.a.b.class, "com.obric.aiagent.plugin")), View.class, "com.obric.aiagent.plugin"));
        Context r25 = this.f36069b;
        String r26 = this.f36070c.h();
        if (r26 != null) goto L23;
        r26 = this.f36069b.getString(ZeusTransformUtils.mapRes(R.string.oui_exit, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_exit"));
        o.c(r26, "context.getString(R.string.oui_exit)");
    L23:
        OButton r0 = a(r25, r26, ZeusTransformUtils.mapRes(R.style.OStyleV2_OButton_L_Trans_Neutral, "style", "OStyleV2_OButton_L_Trans_Neutral"), (d.h.a.b) ZeusTransformUtils.preCheckCast(new d(this), d.h.a.b.class, "com.obric.aiagent.plugin"));
        LinearLayout.LayoutParams r27 = new LinearLayout.LayoutParams(-1, -2);
        Context r28 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r28, "context");
        r27.topMargin = g.a(r28, 12);
        r0.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r27, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        r6.addView((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"));
        r1.addView((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin"));
        return (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin");
    }

    private final OButton a(Context r2, String r3, int r4, d.h.a.b<? super View, x> r5) {
        return (OButton) ZeusTransformUtils.preCheckCast(com.obric.oui.d.e.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r4, (q) ZeusTransformUtils.preCheckCast(new e(r3, (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin")), q.class, "com.obric.aiagent.plugin")), OButton.class, "com.obric.aiagent.plugin");
    }
}
