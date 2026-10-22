package com.obric.oui.sheet;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.FrameLayout;
import bg.h;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.animation.easy.ViewPropertySpringAnimator;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.dialog.anim.DialogAnimStyle;
import com.obric.oui.indicator.c;
import com.obric.oui.utils.log.L;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import tc.f;
import tc.g;
import tc.l;

/* JADX INFO: loaded from: classes4.dex */
public class OInsetSheet extends Dialog {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f16789h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f16790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f16791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f16792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RadiusLayout f16793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f16794e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PanelWidth f16795f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f16796g;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/sheet/OInsetSheet$PanelWidth;", "", "(Ljava/lang/String;I)V", "NARROW_WIDTH", "BOARD_WIDTH", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum PanelWidth extends Enum<PanelWidth> {
        private static final /* synthetic */ PanelWidth[] $VALUES = null;
        public static final PanelWidth BOARD_WIDTH = null;
        public static final PanelWidth NARROW_WIDTH = null;

        private static final /* synthetic */ PanelWidth[] $values() {
            return new PanelWidth[]{NARROW_WIDTH, BOARD_WIDTH};
        }

        static {
            NARROW_WIDTH = new PanelWidth("NARROW_WIDTH", 0);
            BOARD_WIDTH = new PanelWidth("BOARD_WIDTH", 1);
            $VALUES = $values();
        }

        private PanelWidth(String r10, int r11) {
            super(r10, r11);
        }

        public static PanelWidth valueOf(String r10) {
            return (PanelWidth) Enum.valueOf(PanelWidth.class, r10);
        }

        public static PanelWidth[] values() {
            return (PanelWidth[]) $VALUES.clone();
        }
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public static final /* synthetic */ int a(a r10, Context r11, int r12) {
            return r10.b(r11, r12);
        }

        public final int b(Context r10, int r11) {
            if (g.f24781a.a(r10) == true) goto L5;
            return r11;
        L5:
            return h.g(r11, f.b(r10, 440));
        }

        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16797a = null;

        static {
            int[] r10 = new int[PanelWidth.values().length];
            r10[PanelWidth.NARROW_WIDTH.ordinal()] = 1;
            r10[PanelWidth.BOARD_WIDTH.ordinal()] = 2;
            f16797a = r10;
        }
    }

    static {
        f16789h = new a(null);
    }

    public OInsetSheet(Context r10) {
        q.g(r10, "context");
        super(r10);
        this.f16795f = PanelWidth.BOARD_WIDTH;
        Window r11 = getWindow();
        if (r11 == null) goto L6;
        r11.requestFeature(1);
    L6:
        setContentView(R$layout.o_inset_sheet_container);
        B();
        x();
    }

    public static /* synthetic */ WindowInsets a(OInsetSheet r10, View r11, WindowInsets r12) {
        return y(r10, r11, r12);
    }

    public static /* synthetic */ void b(OInsetSheet r10) {
        n(r10);
    }

    public static final void n(final OInsetSheet r15) {
        q.g(r15, "this$0");
        DialogAnimStyle r10 = DialogAnimStyle.f14342a;
        RadiusLayout r11 = r15.h();
        Window r12 = r15.getWindow();
        boolean r13 = r15.k();
        Context r14 = r15.getContext();
        q.f(r14, "context");
        ViewPropertySpringAnimator r16 = ViewPropertySpringAnimator.o(DialogAnimStyle.j(r10, r11, r12, r13, r15.i(r14), false, 8, null), null, null, OInsetSheet$performEnterAnimation$1$anim$1.INSTANCE, 3, null);
        if (r15.f16796g == false) goto L5;
        ViewPropertySpringAnimator.o(r16, new OInsetSheet$performEnterAnimation$1$1(r15), null, null, 6, null);
    L5:
        r16.q();
    }

    public static final WindowInsets y(OInsetSheet r10, View r11, WindowInsets r12) {
        q.g(r10, "this$0");
        q.g(r11, "v");
        q.g(r12, "insets");
        wd.a r13 = wd.a.f25402a;
        int r14 = r13.f(r10.getContext());
        int r15 = r13.d(r10.h());
        if (r15 <= 0) goto L10;
        PanelWidth r16 = r10.f16795f;
        int r17 = b.f16797a[r16.ordinal()];
        if (r17 == 1) goto L9;
        if (r17 != 2) goto L17;
        r11.setPadding(0, 0, 0, r15);
    L17:
        return r12.consumeSystemWindowInsets();
    L9:
        c.d(r10.h(), r15 + f.r(r11, 16));
        goto L17
    L10:
        PanelWidth r18 = r10.f16795f;
        int r19 = b.f16797a[r18.ordinal()];
        if (r19 == 1) goto L15;
        if (r19 != 2) goto L17;
        c.d(r10.h(), 0);
        r10.h().setPadding(0, 0, 0, r14);
        goto L17
    L15:
        c.d(r10.h(), r14);
        r10.h().setPadding(0, 0, 0, 0);
        goto L17
    }

    public final void A(PanelWidth r10) {
        q.g(r10, Style.KEY_WIDTH);
        this.f16795f = r10;
        int r11 = b.f16797a[r10.ordinal()];
        if (r11 == 1) goto L7;
        if (r11 != 2) goto L10;
        int r12 = getContext().getResources().getDisplayMetrics().widthPixels;
        a r13 = f16789h;
        Context r14 = getContext();
        q.f(r14, "context");
        int r15 = a.a(r13, r14, r12);
        c.e(h(), r15);
        float r16 = getContext().getResources().getDimension(R$dimen.oui_r_l3);
        h().c(r16, r16, 0.0f, 0.0f);
        return;
    L10:
        return;
    L7:
        int r17 = getContext().getResources().getDisplayMetrics().widthPixels - (getContext().getResources().getDimensionPixelSize(R$dimen.oui_dialog_narrow_layout_margin) * 2);
        a r18 = f16789h;
        Context r19 = getContext();
        q.f(r19, "context");
        int r20 = a.a(r18, r19, r17);
        c.e(h(), r20);
        h().setRadius(getContext().getResources().getDimension(R$dimen.oui_r_l2));
    }

    public final void B() {
        View r10 = findViewById(R$id.root_constraint);
        q.f(r10, "findViewById(R.id.root_constraint)");
        z((RadiusLayout) r10);
        h().setMeasureHeightUnspecified(true);
        View r11 = findViewById(R$id.header_container);
        q.f(r11, "findViewById(R.id.header_container)");
        v((FrameLayout) r11);
        View r12 = findViewById(R$id.content_container);
        q.f(r12, "findViewById(R.id.content_container)");
        s((FrameLayout) r12);
        View r13 = findViewById(R$id.foot_container);
        q.f(r13, "findViewById(R.id.foot_container)");
        t((FrameLayout) r13);
        DialogAnimStyle.f14342a.c(h());
    }

    public final void c(Context r10) {
        if (g.f24781a.a(r10) == false) goto L13;
        h().measure(0, 0);     // Catch: Exception -> L8
        int r11 = ((f.b(r10, 296) - wd.a.f25402a.f(r10)) - f().getMeasuredHeight()) - e().getMeasuredHeight();     // Catch: Exception -> L8
        d().measure(View.MeasureSpec.makeMeasureSpec(f.b(r10, 440), Integer.MIN_VALUE), 0);     // Catch: Exception -> L8
        int r12 = d().getMeasuredHeight();     // Catch: Exception -> L8
        int r13 = h.k(r11, 0, f.b(r10, 244));     // Catch: Exception -> L8
        if (r12 <= r13) goto L14;
        L.e("OInsetSheet", "adjustContentHeight, measured contentHeight: " + r12 + ", final contentHeight: " + r13);     // Catch: Exception -> L8
        FrameLayout r14 = d();     // Catch: Exception -> L8
        ViewGroup.LayoutParams r15 = d().getLayoutParams();     // Catch: Exception -> L8
        r15.height = r13;     // Catch: Exception -> L8
        r14.setLayoutParams(r15);     // Catch: Exception -> L8
        return;
    L14:
        return;
    L8:
        e = move-exception;
        L.c("OInsetSheet", "adjustContentHeight error", e);
        return;
    }

    public final FrameLayout d() {
        FrameLayout r10 = this.f16792c;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("contentContainer");
        return null;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        o();
    }

    public final FrameLayout e() {
        FrameLayout r10 = this.f16791b;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("footerContainer");
        return null;
    }

    public final FrameLayout f() {
        FrameLayout r10 = this.f16790a;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("headerContainer");
        return null;
    }

    public final boolean g() {
        return this.f16794e;
    }

    public final RadiusLayout h() {
        RadiusLayout r10 = this.f16793d;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("rootContainer");
        return null;
    }

    public final float i(Context r10) {
        if ((r10.getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        return 0.5f;
    L5:
        return 0.16f;
    }

    public final void j(Window r10) {
        if (r10 == null) goto L6;
        r10.setNavigationBarContrastEnforced(false);
    L6:
        if (r10 == null) goto L9;
        r10.setDecorFitsSystemWindows(false);
    L9:
        if (r10 == null) goto L12;
        r10.clearFlags(134217728);
    L12:
        if (r10 == null) goto L15;
        r10.addFlags(Integer.MIN_VALUE);
    L15:
        if (r10 == null) goto L18;
        r10.setNavigationBarColor(0);
    L18:
        if (r10 == null) goto L22;
        r10.setNavigationBarDividerColor(0);
        return;
    }

    public final boolean k() {
        return !this.f16794e;
    }

    public final void l() {
        super.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("OAlertDialog", "origin Dismiss exception!", e);
    }

    public final void m() {
        h().post(new com.obric.oui.sheet.b(this));
    }

    public void o() {
        ViewPropertySpringAnimator r10 = DialogAnimStyle.g(DialogAnimStyle.f14342a, h(), getWindow(), k(), false, 4, null);
        ViewPropertySpringAnimator.o(r10, null, new OInsetSheet$performExitAnimation$1$1(this), new OInsetSheet$performExitAnimation$1$2(this), 1, null);
        r10.q();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        if (this.f16796g == false) goto L6;
        h().setAlpha(0.0f);
        return;
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        m();
    }

    public final void p(ViewGroup r10, View r11) {
        if (r11 == null) goto L12;
        if (r10 == null) goto L6;
        l.m(r10);
    L6:
        if (r10 == null) goto L9;
        r10.removeAllViews();
    L9:
        if (r10 == null) goto L17;
        r10.addView(r11);
        return;
    L17:
        return;
    L12:
        if (r10 == null) goto L18;
        l.k(r10);
        return;
    }

    public final void q(boolean r10) {
        this.f16794e = r10;
    }

    public final void r(View r10) {
        p(d(), r10);
    }

    public final void s(FrameLayout r10) {
        q.g(r10, "<set-?>");
        this.f16792c = r10;
    }

    @Override // android.app.Dialog
    public void show() {
        Context r10 = getContext();
        q.f(r10, "context");
        c(r10);
        super.show();
        Window r11 = getWindow();
        if (r11 == null) goto L18;
        r11.setBackgroundDrawableResource(R.color.transparent);
        j(r11);
        if (g() == false) goto L8;
        r11.clearFlags(2);
    L10:
        if ((r11.getContext().getResources().getConfiguration().uiMode & 48) != 32) goto L12;
        float r12 = 0.5f;
    L13:
        WindowManager.LayoutParams r13 = r11.getAttributes();
        if (k() == true) goto L16;
        r13.dimAmount = r12;
    L16:
        r13.setFitInsetsSides(WindowInsets.Side.all() ^ 8);
        r13.gravity = 80;
        r11.setAttributes(r13);
        return;
    L12:
        r12 = 0.16f;
        goto L13
    L8:
        r11.addFlags(2);
        goto L10
    }

    public final void t(FrameLayout r10) {
        q.g(r10, "<set-?>");
        this.f16791b = r10;
    }

    public final void u(View r10) {
        p(e(), r10);
    }

    public final void v(FrameLayout r10) {
        q.g(r10, "<set-?>");
        this.f16790a = r10;
    }

    public final void w(View r10) {
        p(f(), r10);
    }

    public final void x() {
        h().setOnApplyWindowInsetsListener(new com.obric.oui.sheet.a(this));
    }

    public final void z(RadiusLayout r10) {
        q.g(r10, "<set-?>");
        this.f16793d = r10;
    }
}
