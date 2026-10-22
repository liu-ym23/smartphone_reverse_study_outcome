package com.obric.oui.dialog.v2.selection;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.base.OBaseDialog;
import com.obric.oui.text.OTextView;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.p;
import d.x;
import java.util.Objects;

/* JADX INFO: compiled from: OSelectionDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OSelectionDialog extends OBaseDialog {
    public static final a Companion = null;
    private static final String TAG = "OSelectionDialog";
    private final d.f bodyContainerView$delegate;
    private final d.f buttonContainerView$delegate;
    private final b modifier;
    private final d.f negativeButton$delegate;
    private final d.f positiveButton$delegate;
    private final d.f subtitleTextView$delegate;
    private final d.f titleTextView$delegate;

    /* JADX INFO: compiled from: OSelectionDialog.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OSelectionDialog.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CharSequence f35207a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final CharSequence f35208b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final d.h.a.b<ViewGroup, View> f35209c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final OBaseDialog.a f35210d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final OBaseDialog.a f35211e;

        public final CharSequence a() {
            return this.f35207a;
        }

        public final CharSequence b() {
            return this.f35208b;
        }

        public final d.h.a.b<ViewGroup, View> c() {
            return this.f35209c;
        }

        public final OBaseDialog.a d() {
            return this.f35210d;
        }

        public final OBaseDialog.a e() {
            return this.f35211e;
        }
    }

    /* JADX INFO: compiled from: OSelectionDialog.kt */
    static final class c extends p implements d.h.a.a<ViewGroup> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSelectionDialog f35212a;

        c(OSelectionDialog r1) {
            this.f35212a = r1;
            super(0);
        }

        public final ViewGroup a() {
            return (ViewGroup) ZeusTransformUtils.preCheckCast(this.f35212a.findViewById(ZeusTransformUtils.mapRes(R.id.selection_dialog_body_container, DbHelper.COL_ID, "selection_dialog_body_container")), ViewGroup.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.a
        public /* synthetic */ ViewGroup invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OSelectionDialog.kt */
    static final class d extends p implements d.h.a.a<ViewGroup> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSelectionDialog f35213a;

        d(OSelectionDialog r1) {
            this.f35213a = r1;
            super(0);
        }

        public final ViewGroup a() {
            return (ViewGroup) ZeusTransformUtils.preCheckCast(this.f35213a.findViewById(ZeusTransformUtils.mapRes(R.id.selection_dialog_btn_container, DbHelper.COL_ID, "selection_dialog_btn_container")), ViewGroup.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.a
        public /* synthetic */ ViewGroup invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OSelectionDialog.kt */
    static final class e extends p implements d.h.a.a<OButton> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSelectionDialog f35214a;

        e(OSelectionDialog r1) {
            this.f35214a = r1;
            super(0);
        }

        public final OButton a() {
            return (OButton) ZeusTransformUtils.preCheckCast(this.f35214a.findViewById(ZeusTransformUtils.mapRes(R.id.actionNegative, DbHelper.COL_ID, "actionNegative")), OButton.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.a
        public /* synthetic */ OButton invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OSelectionDialog.kt */
    static final class f extends p implements d.h.a.a<OButton> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSelectionDialog f35215a;

        f(OSelectionDialog r1) {
            this.f35215a = r1;
            super(0);
        }

        public final OButton a() {
            return (OButton) ZeusTransformUtils.preCheckCast(this.f35215a.findViewById(ZeusTransformUtils.mapRes(R.id.actionPositive, DbHelper.COL_ID, "actionPositive")), OButton.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.a
        public /* synthetic */ OButton invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OSelectionDialog.kt */
    static final class g extends p implements d.h.a.a<OTextView> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSelectionDialog f35216a;

        g(OSelectionDialog r1) {
            this.f35216a = r1;
            super(0);
        }

        public final OTextView a() {
            return (OTextView) ZeusTransformUtils.preCheckCast(this.f35216a.findViewById(ZeusTransformUtils.mapRes(R.id.selection_dialog_sub_title, DbHelper.COL_ID, "selection_dialog_sub_title")), OTextView.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.a
        public /* synthetic */ OTextView invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OSelectionDialog.kt */
    static final class h extends p implements d.h.a.a<OTextView> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSelectionDialog f35217a;

        h(OSelectionDialog r1) {
            this.f35217a = r1;
            super(0);
        }

        public final OTextView a() {
            return (OTextView) ZeusTransformUtils.preCheckCast(this.f35217a.findViewById(ZeusTransformUtils.mapRes(R.id.selection_dialog_title, DbHelper.COL_ID, "selection_dialog_title")), OTextView.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.a
        public /* synthetic */ OTextView invoke() {
            return a();
        }
    }

    static {
        Companion = new a(null);
    }

    /* JADX INFO: renamed from: lambda$EgxPUJQU-8NfaXylsGrSbgfqQNc, reason: not valid java name */
    public static /* synthetic */ void m1054lambda$EgxPUJQU8NfaXylsGrSbgfqQNc(OSelectionDialog r0, View r1) {
        m1052initButtons$lambda6(r0, r1);
    }

    public static /* synthetic */ void lambda$Ngn3VdOAaEmnurgeUF9XF48ZUtA(OSelectionDialog r0, View r1) {
        m1053initButtons$lambda7(r0, r1);
    }

    public OSelectionDialog(Context r3, b r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r4, "modifier");
        super(r5);
        this.modifier = r4;
        this.titleTextView$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new h(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.subtitleTextView$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new g(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.bodyContainerView$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new c(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.buttonContainerView$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new d(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.positiveButton$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new f(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.negativeButton$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new e(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        getTitleTextView().setIncludeFontPadding(true);
        getSubtitleTextView().setIncludeFontPadding(true);
        setTitleText(r4.a());
        setSubtitleText(r4.b());
        initBody();
        initButtons();
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

    private final ViewGroup getBodyContainerView() {
        Object r2 = this.bodyContainerView$delegate.b();
        o.c(r2, "<get-bodyContainerView>(...)");
        return (ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.aiagent.plugin");
    }

    private final ViewGroup getButtonContainerView() {
        Object r2 = this.buttonContainerView$delegate.b();
        o.c(r2, "<get-buttonContainerView>(...)");
        return (ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.aiagent.plugin");
    }

    public final OButton getPositiveButton() {
        Object r2 = this.positiveButton$delegate.b();
        o.c(r2, "<get-positiveButton>(...)");
        return (OButton) ZeusTransformUtils.preCheckCast(r2, OButton.class, "com.obric.aiagent.plugin");
    }

    public final OButton getNegativeButton() {
        Object r2 = this.negativeButton$delegate.b();
        o.c(r2, "<get-negativeButton>(...)");
        return (OButton) ZeusTransformUtils.preCheckCast(r2, OButton.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog
    public int getLayout() {
        return ZeusTransformUtils.mapRes(R.layout.o_selection_dialog, "layout", "o_selection_dialog");
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
        ViewGroup.LayoutParams r8 = getSubtitleTextView().getLayoutParams();
        Objects.requireNonNull(r8, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r8, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        Context r10 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r10, "context");
        r9.topMargin = com.obric.oui.common.util.g.a(r10, 8);
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

    public final void setContainerView(View r2) {
        o.e(r2, "view");
        getBodyContainerView().removeAllViews();
        getBodyContainerView().addView(r2);
    }

    private final void initBody() {
        if (this.modifier.c() == null) goto L6;
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.modifier.c().invoke(getBodyContainerView()), View.class, "com.obric.aiagent.plugin");
        getBodyContainerView().removeAllViews();
        getBodyContainerView().addView(r0);
        return;
    }

    private final void initButtons() {
        if (this.modifier.d() != null) goto L8;
        if (this.modifier.e() != null) goto L8;
        getButtonContainerView().setVisibility(8);
        return;
    L8:
        if (this.modifier.d() == null) goto L16;
        getPositiveButton().setVisibility(0);
        getPositiveButton().setText((CharSequence) ZeusTransformUtils.preCheckCast(this.modifier.d().a(), CharSequence.class, "com.obric.aiagent.plugin"));
        if (this.modifier.d().b() == null) goto L12;
        getPositiveButton().setOnClickListener(new $$Lambda$OSelectionDialog$EgxPUJQU8NfaXylsGrSbgfqQNc(this));
    L12:
        d.h.a.b<OButton, x> r0 = this.modifier.d().c();
        if (r0 == null) goto L18;
        r0.invoke(getPositiveButton());
    L18:
        if (this.modifier.e() == null) goto L26;
        getNegativeButton().setVisibility(0);
        getNegativeButton().setText((CharSequence) ZeusTransformUtils.preCheckCast(this.modifier.e().a(), CharSequence.class, "com.obric.aiagent.plugin"));
        if (this.modifier.e().b() == null) goto L22;
        getNegativeButton().setOnClickListener(new $$Lambda$OSelectionDialog$Ngn3VdOAaEmnurgeUF9XF48ZUtA(this));
    L22:
        d.h.a.b<OButton, x> r1 = this.modifier.e().c();
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

    /* JADX INFO: renamed from: initButtons$lambda-6, reason: not valid java name */
    private static final void m1052initButtons$lambda6(OSelectionDialog r0, View r1) {
        o.e(r0, "this$0");
        r0.modifier.d().b().invoke();
        if (r0.isAutoDismiss() == false) goto L6;
        r0.dismiss();
        return;
    }

    /* JADX INFO: renamed from: initButtons$lambda-7, reason: not valid java name */
    private static final void m1053initButtons$lambda7(OSelectionDialog r0, View r1) {
        o.e(r0, "this$0");
        r0.modifier.e().b().invoke();
        if (r0.isAutoDismiss() == false) goto L6;
        r0.dismiss();
        return;
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog, android.app.Dialog
    public void show() {
        if (getShowAnimRunning() == false) goto L5;
        return;
    L5:
        super.show();
        if (getMaxRootViewHeightGap() <= 0) goto L9;
        ViewGroup r0 = getBodyContainerView();
        ViewGroup.LayoutParams r1 = getBodyContainerView().getLayoutParams();
        r1.height = getBodyContainerView().getMeasuredHeight() - getMaxRootViewHeightGap();
        r0.setLayoutParams(r1);
        return;
    }
}
