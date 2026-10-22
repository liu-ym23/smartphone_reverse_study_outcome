package com.obric.oui.dialog.v2.misc;

import android.content.Context;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.base.OBaseDialog;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.forms.OPhoneInputLayout;
import com.obric.oui.text.OTextView;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.p;
import d.x;
import java.util.Objects;

/* JADX INFO: compiled from: OSimpleFormDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OSimpleFormDialog extends OBaseDialog {
    public static final a Companion = null;
    private static final String TAG = "OSimpleFormDialog";
    private final d.f bodyContainer$delegate;
    private final d.f footerContainer$delegate;
    private OInputLayout inputView1;
    private final d.f inputView1Container$delegate;
    private OInputLayout inputView2;
    private final d.f inputView2Container$delegate;
    private final c modifier;
    private final d.f negativeButton$delegate;
    private final Runnable pendingDismissTask;
    private final d.f positiveButton$delegate;
    private final d.f subtitleTextView$delegate;
    private final d.f titleTextView$delegate;

    /* JADX INFO: compiled from: OSimpleFormDialog.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OSimpleFormDialog.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f35155a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f35156b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final d.h.a.b<OInputLayout, x> f35157c;

        public b(boolean r3, boolean r4, d.h.a.b<? super OInputLayout, x> r5) {
            d.h.a.b<OInputLayout, x> r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
            this.f35155a = r3;
            this.f35156b = r4;
            this.f35157c = r6;
        }

        public /* synthetic */ b(boolean r2, boolean r3, d.h.a.b r4, int r5, d.h.b.h r6) {
            d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
            if ((r5 & 2) == 0) goto L6;
            r3 = false;
        L6:
            if ((r5 & 4) == 0) goto L8;
            r7 = null;
        L8:
            this(r2, r3, r7);
        }

        public final boolean a() {
            return this.f35155a;
        }

        public final boolean b() {
            return this.f35156b;
        }

        public final d.h.a.b<OInputLayout, x> c() {
            return this.f35157c;
        }
    }

    /* JADX INFO: compiled from: OSimpleFormDialog.kt */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CharSequence f35158a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final CharSequence f35159b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final b f35160c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final b f35161d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final OBaseDialog.a f35162e;
        private final OBaseDialog.a f;

        public c(CharSequence r3, CharSequence r4, b r5, b r6, OBaseDialog.a r7, OBaseDialog.a r8) {
            CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            CharSequence r10 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
            o.e(r9, DBDefinition.TITLE);
            o.e(r10, "subtitle");
            o.e(r5, "inputView1");
            o.e(r6, "inputView2");
            this.f35158a = r9;
            this.f35159b = r10;
            this.f35160c = r5;
            this.f35161d = r6;
            this.f35162e = r7;
            this.f = r8;
        }

        public final CharSequence a() {
            return this.f35158a;
        }

        public final CharSequence b() {
            return this.f35159b;
        }

        public final b c() {
            return this.f35160c;
        }

        public final b d() {
            return this.f35161d;
        }

        public final OBaseDialog.a e() {
            return this.f35162e;
        }

        public final OBaseDialog.a f() {
            return this.f;
        }
    }

    /* JADX INFO: compiled from: OSimpleFormDialog.kt */
    static final class d extends p implements d.h.a.a<FrameLayout> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSimpleFormDialog f35163a;

        d(OSimpleFormDialog r1) {
            this.f35163a = r1;
            super(0);
        }

        public final FrameLayout a() {
            return (FrameLayout) ZeusTransformUtils.preCheckCast(this.f35163a.findViewById(ZeusTransformUtils.mapRes(R.id.simple_form_body_container, DbHelper.COL_ID, "simple_form_body_container")), FrameLayout.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.a
        public /* synthetic */ FrameLayout invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OSimpleFormDialog.kt */
    static final class e extends p implements d.h.a.a<FrameLayout> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSimpleFormDialog f35164a;

        e(OSimpleFormDialog r1) {
            this.f35164a = r1;
            super(0);
        }

        public final FrameLayout a() {
            return (FrameLayout) ZeusTransformUtils.preCheckCast(this.f35164a.findViewById(ZeusTransformUtils.mapRes(R.id.simple_form_footer_container, DbHelper.COL_ID, "simple_form_footer_container")), FrameLayout.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.a
        public /* synthetic */ FrameLayout invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OSimpleFormDialog.kt */
    static final class f extends p implements d.h.a.a<FrameLayout> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSimpleFormDialog f35165a;

        f(OSimpleFormDialog r1) {
            this.f35165a = r1;
            super(0);
        }

        public final FrameLayout a() {
            return (FrameLayout) ZeusTransformUtils.preCheckCast(this.f35165a.findViewById(ZeusTransformUtils.mapRes(R.id.simple_form_input_1_container, DbHelper.COL_ID, "simple_form_input_1_container")), FrameLayout.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.a
        public /* synthetic */ FrameLayout invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OSimpleFormDialog.kt */
    static final class g extends p implements d.h.a.a<FrameLayout> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSimpleFormDialog f35166a;

        g(OSimpleFormDialog r1) {
            this.f35166a = r1;
            super(0);
        }

        public final FrameLayout a() {
            return (FrameLayout) ZeusTransformUtils.preCheckCast(this.f35166a.findViewById(ZeusTransformUtils.mapRes(R.id.simple_form_input_2_container, DbHelper.COL_ID, "simple_form_input_2_container")), FrameLayout.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.a
        public /* synthetic */ FrameLayout invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OSimpleFormDialog.kt */
    static final class h extends p implements d.h.a.a<OButton> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSimpleFormDialog f35167a;

        h(OSimpleFormDialog r1) {
            this.f35167a = r1;
            super(0);
        }

        public final OButton a() {
            return (OButton) ZeusTransformUtils.preCheckCast(this.f35167a.findViewById(ZeusTransformUtils.mapRes(R.id.actionNegative, DbHelper.COL_ID, "actionNegative")), OButton.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.a
        public /* synthetic */ OButton invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OSimpleFormDialog.kt */
    static final class i extends p implements d.h.a.a<OButton> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSimpleFormDialog f35168a;

        i(OSimpleFormDialog r1) {
            this.f35168a = r1;
            super(0);
        }

        public final OButton a() {
            return (OButton) ZeusTransformUtils.preCheckCast(this.f35168a.findViewById(ZeusTransformUtils.mapRes(R.id.actionPositive, DbHelper.COL_ID, "actionPositive")), OButton.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.a
        public /* synthetic */ OButton invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OSimpleFormDialog.kt */
    static final class j extends p implements d.h.a.a<OTextView> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSimpleFormDialog f35169a;

        j(OSimpleFormDialog r1) {
            this.f35169a = r1;
            super(0);
        }

        public final OTextView a() {
            return (OTextView) ZeusTransformUtils.preCheckCast(this.f35169a.findViewById(ZeusTransformUtils.mapRes(R.id.simple_form_subtitle, DbHelper.COL_ID, "simple_form_subtitle")), OTextView.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.a
        public /* synthetic */ OTextView invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OSimpleFormDialog.kt */
    static final class k extends p implements d.h.a.a<OTextView> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSimpleFormDialog f35170a;

        k(OSimpleFormDialog r1) {
            this.f35170a = r1;
            super(0);
        }

        public final OTextView a() {
            return (OTextView) ZeusTransformUtils.preCheckCast(this.f35170a.findViewById(ZeusTransformUtils.mapRes(R.id.simple_form_title, DbHelper.COL_ID, "simple_form_title")), OTextView.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.a
        public /* synthetic */ OTextView invoke() {
            return a();
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ void lambda$0GUFMXRdzdlF_qtr8fICmH6PJyI(OSimpleFormDialog r0, View r1) {
        m1037initButtons$lambda12(r0, r1);
    }

    public static /* synthetic */ void lambda$FOCmORUgBJGlXnXBwo8ccgPnic8(OSimpleFormDialog r0) {
        m1041onStart$lambda14(r0);
    }

    /* JADX INFO: renamed from: lambda$Lsf7fCAX5SCKkY-crm63JLfT8yI, reason: not valid java name */
    public static /* synthetic */ void m1038lambda$Lsf7fCAX5SCKkYcrm63JLfT8yI(OSimpleFormDialog r0) {
        m1040onStart$lambda13(r0);
    }

    public static /* synthetic */ void lambda$WF1fR0Q93MHD6AIHLELeaISSs9s(OSimpleFormDialog r0) {
        m1042pendingDismissTask$lambda0(r0);
    }

    /* JADX INFO: renamed from: lambda$vAF36aXmGmSDMdPHXZRH-_uEq2w, reason: not valid java name */
    public static /* synthetic */ void m1039lambda$vAF36aXmGmSDMdPHXZRH_uEq2w(OSimpleFormDialog r0, View r1) {
        m1036initButtons$lambda11(r0, r1);
    }

    public final c getModifier() {
        return this.modifier;
    }

    public OSimpleFormDialog(Context r4, c r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        o.e(r5, "modifier");
        super(r6);
        this.modifier = r5;
        this.titleTextView$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new k(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.subtitleTextView$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new j(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.negativeButton$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new h(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.positiveButton$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new i(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.bodyContainer$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new d(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.footerContainer$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new e(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.inputView1Container$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new f(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.inputView2Container$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new g(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.pendingDismissTask = new $$Lambda$OSimpleFormDialog$WF1fR0Q93MHD6AIHLELeaISSs9s(this);
        getTitleTextView().setIncludeFontPadding(true);
        getSubtitleTextView().setIncludeFontPadding(true);
        setTitleText(r5.a());
        setSubtitleText(r5.b());
        initInputViews();
        initButtons();
        setFixedWindowHeightPx(Integer.valueOf((int) (com.obric.oui.common.util.g.b(r6) * 0.65f)));
        setEnableLayoutHeightChangeAnim(true);
    }

    public final OTextView getTitleTextView() {
        Object r2 = this.titleTextView$delegate.b();
        o.c(r2, "<get-titleTextView>(...)");
        return (OTextView) ZeusTransformUtils.preCheckCast(r2, OTextView.class, "com.obric.aiagent.plugin");
    }

    public final OTextView getSubtitleTextView() {
        Object r2 = this.subtitleTextView$delegate.b();
        o.c(r2, "<get-subtitleTextView>(...)");
        return (OTextView) ZeusTransformUtils.preCheckCast(r2, OTextView.class, "com.obric.aiagent.plugin");
    }

    public final OButton getNegativeButton() {
        Object r2 = this.negativeButton$delegate.b();
        o.c(r2, "<get-negativeButton>(...)");
        return (OButton) ZeusTransformUtils.preCheckCast(r2, OButton.class, "com.obric.aiagent.plugin");
    }

    public final OButton getPositiveButton() {
        Object r2 = this.positiveButton$delegate.b();
        o.c(r2, "<get-positiveButton>(...)");
        return (OButton) ZeusTransformUtils.preCheckCast(r2, OButton.class, "com.obric.aiagent.plugin");
    }

    private final FrameLayout getBodyContainer() {
        Object r2 = this.bodyContainer$delegate.b();
        o.c(r2, "<get-bodyContainer>(...)");
        return (FrameLayout) ZeusTransformUtils.preCheckCast(r2, FrameLayout.class, "com.obric.aiagent.plugin");
    }

    public final FrameLayout getFooterContainer() {
        Object r2 = this.footerContainer$delegate.b();
        o.c(r2, "<get-footerContainer>(...)");
        return (FrameLayout) ZeusTransformUtils.preCheckCast(r2, FrameLayout.class, "com.obric.aiagent.plugin");
    }

    public final FrameLayout getInputView1Container() {
        Object r2 = this.inputView1Container$delegate.b();
        o.c(r2, "<get-inputView1Container>(...)");
        return (FrameLayout) ZeusTransformUtils.preCheckCast(r2, FrameLayout.class, "com.obric.aiagent.plugin");
    }

    public final FrameLayout getInputView2Container() {
        Object r2 = this.inputView2Container$delegate.b();
        o.c(r2, "<get-inputView2Container>(...)");
        return (FrameLayout) ZeusTransformUtils.preCheckCast(r2, FrameLayout.class, "com.obric.aiagent.plugin");
    }

    /* JADX INFO: renamed from: pendingDismissTask$lambda-0, reason: not valid java name */
    private static final void m1042pendingDismissTask$lambda0(OSimpleFormDialog r1) {
        o.e(r1, "this$0");
        r1.setDismissing(false);
        super.dismiss();
    }

    public final OInputLayout getInputView1() {
        return this.inputView1;
    }

    public final void setInputView1(OInputLayout r1) {
        this.inputView1 = r1;
    }

    public final OInputLayout getInputView2() {
        return this.inputView2;
    }

    public final void setInputView2(OInputLayout r1) {
        this.inputView2 = r1;
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog
    public int getLayout() {
        return ZeusTransformUtils.mapRes(R.layout.o_simple_form_dialog, "layout", "o_simple_form_dialog");
    }

    public final void setTitleText(CharSequence r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r7, DBDefinition.TITLE);
        if (r7.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
        getTitleTextView().setVisibility(8);
        ViewGroup.LayoutParams r5 = getSubtitleTextView().getLayoutParams();
        Objects.requireNonNull(r5, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin")).topMargin = 0;
        return;
    L9:
        OTextView r1 = getTitleTextView();
        r1.setVisibility(0);
        r1.setText(r7);
        OTextView r8 = getSubtitleTextView();
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        Objects.requireNonNull(r9, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r9, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin")).topMargin = com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin"), 8);
        return;
    L5:
        r0 = false;
        goto L7
    }

    public final void setSubtitleText(CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r5, "message");
        if (r5.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        getSubtitleTextView().setVisibility(8);
        return;
    L8:
        OTextView r3 = getSubtitleTextView();
        r3.setVisibility(0);
        r3.setText(r5);
        com.obric.oui.dialog.b.a((TextView) ZeusTransformUtils.preCheckCast(r3, TextView.class, "com.obric.aiagent.plugin"), r5);
        return;
    L5:
        r0 = false;
        goto L6
    }

    private final void initInputViews() {
        if (this.modifier.c().a() == true) goto L5;
        OInputLayout r0 = this.inputView1;
        if (r0 == null) goto L23;
        r0.setVisibility(8);
    L23:
        if (this.modifier.d().a() == true) goto L25;
        OInputLayout r12 = this.inputView2;
        if (r12 == null) goto L45;
        r12.setVisibility(8);
        return;
    L45:
        return;
    L25:
        if (((ViewGroup) ZeusTransformUtils.preCheckCast(getInputView2Container(), ViewGroup.class, "com.obric.aiagent.plugin")).getChildCount() != 0) goto L27;
        boolean r1 = true;
    L28:
        if (r1 == true) goto L30;
    L34:
        OInputLayout r2 = this.inputView2;
        o.a(r2);
        r2.setVisibility(0);
        d.h.a.b<OInputLayout, x> r3 = this.modifier.d().c();
        if (r3 == null) goto L44;
        OInputLayout r13 = this.inputView2;
        o.a(r13);
        r3.invoke(r13);
        return;
    L44:
        return;
    L30:
        if (this.modifier.d().b() == false) goto L32;
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r7, "context");
        OPhoneInputLayout r4 = new OPhoneInputLayout(r7, null, 0, 6, null);
        r4.showInputBackground(true);
        r4.showLabel(false);
        r4.showClear(true);
        OInputLayout r5 = (OInputLayout) ZeusTransformUtils.preCheckCast(r4, OInputLayout.class, "com.obric.aiagent.plugin");
    L33:
        this.inputView2 = r5;
        getInputView2Container().removeAllViews();
        getInputView2Container().addView((View) ZeusTransformUtils.preCheckCast(this.inputView2, View.class, "com.obric.aiagent.plugin"));
        goto L34
    L32:
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r8, "context");
        r5 = new OInputLayout(r8, null, 0, 6, null);
        r5.showInputBackground(true);
        r5.showLabel(false);
        r5.showClear(true);
        goto L33
    L27:
        r1 = false;
        goto L28
    L5:
        if (((ViewGroup) ZeusTransformUtils.preCheckCast(getInputView1Container(), ViewGroup.class, "com.obric.aiagent.plugin")).getChildCount() != 0) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == true) goto L10;
    L14:
        OInputLayout r9 = this.inputView1;
        o.a(r9);
        r9.setVisibility(0);
        d.h.a.b<OInputLayout, x> r10 = this.modifier.c().c();
        if (r10 == null) goto L23;
        OInputLayout r11 = this.inputView1;
        o.a(r11);
        r10.invoke(r11);
        goto L23
    L10:
        if (this.modifier.c().b() == false) goto L12;
        Context r14 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r14, "context");
        OPhoneInputLayout r15 = new OPhoneInputLayout(r14, null, 0, 6, null);
        r15.showInputBackground(true);
        r15.showLabel(false);
        r15.showClear(true);
        OInputLayout r16 = (OInputLayout) ZeusTransformUtils.preCheckCast(r15, OInputLayout.class, "com.obric.aiagent.plugin");
    L13:
        this.inputView1 = r16;
        getInputView1Container().removeAllViews();
        getInputView1Container().addView((View) ZeusTransformUtils.preCheckCast(this.inputView1, View.class, "com.obric.aiagent.plugin"));
        goto L14
    L12:
        Context r17 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r17, "context");
        r16 = new OInputLayout(r17, null, 0, 6, null);
        r16.showInputBackground(true);
        r16.showLabel(false);
        r16.showClear(true);
        goto L13
    L7:
        r6 = false;
        goto L8
    }

    private final void initButtons() {
        if (this.modifier.e() != null) goto L8;
        if (this.modifier.f() != null) goto L8;
        getFooterContainer().setVisibility(8);
        return;
    L8:
        if (this.modifier.e() == null) goto L16;
        getPositiveButton().setVisibility(0);
        getPositiveButton().setText((CharSequence) ZeusTransformUtils.preCheckCast(this.modifier.e().a(), CharSequence.class, "com.obric.aiagent.plugin"));
        if (this.modifier.e().b() == null) goto L12;
        getPositiveButton().setOnClickListener(new $$Lambda$OSimpleFormDialog$vAF36aXmGmSDMdPHXZRH_uEq2w(this));
    L12:
        d.h.a.b<OButton, x> r0 = this.modifier.e().c();
        if (r0 == null) goto L18;
        r0.invoke(getPositiveButton());
    L18:
        if (this.modifier.f() == null) goto L26;
        getNegativeButton().setVisibility(0);
        getNegativeButton().setText((CharSequence) ZeusTransformUtils.preCheckCast(this.modifier.f().a(), CharSequence.class, "com.obric.aiagent.plugin"));
        if (this.modifier.f().b() == null) goto L22;
        getNegativeButton().setOnClickListener(new $$Lambda$OSimpleFormDialog$0GUFMXRdzdlF_qtr8fICmH6PJyI(this));
    L22:
        d.h.a.b<OButton, x> r1 = this.modifier.f().c();
        if (r1 == null) goto L30;
        r1.invoke(getNegativeButton());
        return;
    L30:
        return;
    L26:
        getNegativeButton().setVisibility(8);
        return;
    L16:
        getPositiveButton().setVisibility(8);
        goto L18
    }

    /* JADX INFO: renamed from: initButtons$lambda-11, reason: not valid java name */
    private static final void m1036initButtons$lambda11(OSimpleFormDialog r0, View r1) {
        o.e(r0, "this$0");
        r0.modifier.e().b().invoke();
        if (r0.isAutoDismiss() == false) goto L6;
        r0.dismiss();
        return;
    }

    /* JADX INFO: renamed from: initButtons$lambda-12, reason: not valid java name */
    private static final void m1037initButtons$lambda12(OSimpleFormDialog r0, View r1) {
        o.e(r0, "this$0");
        r0.modifier.f().b().invoke();
        if (r0.isAutoDismiss() == false) goto L6;
        r0.dismiss();
        return;
    }

    @Override // com.obric.oui.dialog.base.OBaseDialog, android.app.Dialog
    public void onStart() {
        super.onStart();
        getSubtitleTextView().postDelayed(new $$Lambda$OSimpleFormDialog$Lsf7fCAX5SCKkYcrm63JLfT8yI(this), 1000);
        OInputLayout r0 = this.inputView1;
        if (r0 == null) goto L7;
        r0.postDelayed(new $$Lambda$OSimpleFormDialog$FOCmORUgBJGlXnXBwo8ccgPnic8(this), 100);
        return;
    }

    /* JADX INFO: renamed from: onStart$lambda-13, reason: not valid java name */
    private static final void m1040onStart$lambda13(OSimpleFormDialog r1) {
        o.e(r1, "this$0");
        Layout r0 = r1.getSubtitleTextView().getLayout();
        if (r0 == null) goto L6;
        r0.getLineCount();
    L6:
        r1.getSubtitleTextView().getMaxLines();
    }

    /* JADX INFO: renamed from: onStart$lambda-14, reason: not valid java name */
    private static final void m1041onStart$lambda14(OSimpleFormDialog r2) {
        o.e(r2, "this$0");
        OInputLayout r3 = r2.inputView1;     // Catch: Exception -> L11
        if (r3 == null) goto L16;
        OEditText r4 = r3.getVInput();     // Catch: Exception -> L11
        if (r4 == null) goto L17;
        r4.requestFocus();     // Catch: Exception -> L11
        return;
    L17:
        return;
    L16:
        return;
    L11:
        e = move-exception;
        com.obric.oui.d.a.b.b(TAG, "onStart, requestFocus failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog, android.app.Dialog
    public void onStop() {
        super.onStop();
        getBodyContainer().removeCallbacks(this.pendingDismissTask);
    }

    @Override // com.obric.oui.dialog.base.OBaseDialog, com.obric.oui.dialog.base.AbstractDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (isDismissing() == false) goto L7;
        com.obric.oui.d.a.b.b(TAG, "dismiss() called but dialog is already dismissing, ignore.");
        return;
    L7:
        if (getInsetsBaseYOffsetPx() <= 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == true) goto L13;
        super.dismiss();
        return;
    L13:
        setDismissing(true);
        OInputLayout r1 = this.inputView1;
        if (r1 == null) goto L17;
        r1.clearFocus();
    L17:
        OInputLayout r2 = this.inputView2;
        if (r2 == null) goto L21;
        r2.clearFocus();
    L21:
        getBodyContainer().postDelayed(this.pendingDismissTask, 100);
        return;
    L9:
        r0 = false;
        goto L10
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog
    public View getHeightChangeAnimContainer() {
        return (View) ZeusTransformUtils.preCheckCast(getBodyContainer(), View.class, "com.obric.aiagent.plugin");
    }
}
