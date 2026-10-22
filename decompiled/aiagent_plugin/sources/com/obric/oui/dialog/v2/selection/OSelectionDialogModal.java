package com.obric.oui.dialog.v2.selection;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.base.OBaseDialogModal;
import com.obric.oui.text.OTextView;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.p;
import d.x;
import java.util.Objects;

/* JADX INFO: compiled from: OSelectionDialogModal.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OSelectionDialogModal extends OBaseDialogModal {
    private final d.f bodyContainerView$delegate;
    private final d.f buttonContainerView$delegate;
    private final a modifier;
    private final d.f negativeButton$delegate;
    private final d.f positiveButton$delegate;
    private final d.f subtitleTextView$delegate;
    private final d.f titleTextView$delegate;

    /* JADX INFO: compiled from: OSelectionDialogModal.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CharSequence f35218a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final CharSequence f35219b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final d.h.a.b<ViewGroup, View> f35220c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final OBaseDialogModal.a f35221d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final OBaseDialogModal.a f35222e;

        public final CharSequence a() {
            return this.f35218a;
        }

        public final CharSequence b() {
            return this.f35219b;
        }

        public final d.h.a.b<ViewGroup, View> c() {
            return this.f35220c;
        }

        public final OBaseDialogModal.a d() {
            return this.f35221d;
        }

        public final OBaseDialogModal.a e() {
            return this.f35222e;
        }
    }

    /* JADX INFO: compiled from: OSelectionDialogModal.kt */
    static final class b extends p implements d.h.a.a<ViewGroup> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSelectionDialogModal f35223a;

        b(OSelectionDialogModal r1) {
            this.f35223a = r1;
            super(0);
        }

        public final ViewGroup a() {
            return (ViewGroup) ZeusTransformUtils.preCheckCast(this.f35223a.findViewById(ZeusTransformUtils.mapRes(R.id.selection_dialog_body_container, DbHelper.COL_ID, "selection_dialog_body_container")), ViewGroup.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.a
        public /* synthetic */ ViewGroup invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OSelectionDialogModal.kt */
    static final class c extends p implements d.h.a.a<ViewGroup> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSelectionDialogModal f35224a;

        c(OSelectionDialogModal r1) {
            this.f35224a = r1;
            super(0);
        }

        public final ViewGroup a() {
            return (ViewGroup) ZeusTransformUtils.preCheckCast(this.f35224a.findViewById(ZeusTransformUtils.mapRes(R.id.selection_dialog_btn_container, DbHelper.COL_ID, "selection_dialog_btn_container")), ViewGroup.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.a
        public /* synthetic */ ViewGroup invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OSelectionDialogModal.kt */
    static final class d extends p implements d.h.a.a<OButton> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSelectionDialogModal f35225a;

        d(OSelectionDialogModal r1) {
            this.f35225a = r1;
            super(0);
        }

        public final OButton a() {
            return (OButton) ZeusTransformUtils.preCheckCast(this.f35225a.findViewById(ZeusTransformUtils.mapRes(R.id.actionNegative, DbHelper.COL_ID, "actionNegative")), OButton.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.a
        public /* synthetic */ OButton invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OSelectionDialogModal.kt */
    static final class e extends p implements d.h.a.a<OButton> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSelectionDialogModal f35226a;

        e(OSelectionDialogModal r1) {
            this.f35226a = r1;
            super(0);
        }

        public final OButton a() {
            return (OButton) ZeusTransformUtils.preCheckCast(this.f35226a.findViewById(ZeusTransformUtils.mapRes(R.id.actionPositive, DbHelper.COL_ID, "actionPositive")), OButton.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.a
        public /* synthetic */ OButton invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OSelectionDialogModal.kt */
    static final class f extends p implements d.h.a.a<OTextView> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSelectionDialogModal f35227a;

        f(OSelectionDialogModal r1) {
            this.f35227a = r1;
            super(0);
        }

        public final OTextView a() {
            return (OTextView) ZeusTransformUtils.preCheckCast(this.f35227a.findViewById(ZeusTransformUtils.mapRes(R.id.selection_dialog_sub_title, DbHelper.COL_ID, "selection_dialog_sub_title")), OTextView.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.a
        public /* synthetic */ OTextView invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OSelectionDialogModal.kt */
    static final class g extends p implements d.h.a.a<OTextView> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSelectionDialogModal f35228a;

        g(OSelectionDialogModal r1) {
            this.f35228a = r1;
            super(0);
        }

        public final OTextView a() {
            return (OTextView) ZeusTransformUtils.preCheckCast(this.f35228a.findViewById(ZeusTransformUtils.mapRes(R.id.selection_dialog_title, DbHelper.COL_ID, "selection_dialog_title")), OTextView.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.a
        public /* synthetic */ OTextView invoke() {
            return a();
        }
    }

    public static /* synthetic */ void lambda$7fDzo4BY6EttGrNAJIKpk9eu9nY(OSelectionDialogModal r0) {
        m1057show$lambda12(r0);
    }

    public static /* synthetic */ void lambda$FTRcHgRdW4a9LQSAcjZiuatTPss(d.h.a.a r0, OSelectionDialogModal r1, View r2) {
        m1055initButtons$lambda10$lambda9(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$uG1cpAhmE7zOb4iF4grU4CXfPOM(d.h.a.a r0, OSelectionDialogModal r1, View r2) {
        m1056initButtons$lambda8$lambda7(r0, r1, r2);
    }

    public OSelectionDialogModal(Context r3, a r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r4, "modifier");
        super(r5);
        this.modifier = r4;
        this.titleTextView$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new g(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.subtitleTextView$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new f(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.bodyContainerView$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new b(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.buttonContainerView$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new c(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.positiveButton$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new e(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.negativeButton$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new d(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
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

    @Override // com.obric.oui.dialog.base.AbstractDialogModal
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
        d.h.a.b<ViewGroup, View> r0 = this.modifier.c();
        if (r0 == null) goto L7;
        View r1 = (View) ZeusTransformUtils.preCheckCast(r0.invoke(getBodyContainerView()), View.class, "com.obric.aiagent.plugin");
        getBodyContainerView().removeAllViews();
        getBodyContainerView().addView(r1);
        return;
    }

    private final void initButtons() {
        if (this.modifier.d() != null) goto L8;
        if (this.modifier.e() != null) goto L8;
        getButtonContainerView().setVisibility(8);
        return;
    L8:
        if (this.modifier.d() == null) goto L17;
        getPositiveButton().setVisibility(0);
        getPositiveButton().setText((CharSequence) ZeusTransformUtils.preCheckCast(this.modifier.d().a(), CharSequence.class, "com.obric.aiagent.plugin"));
        final d.h.a.a<x> r0 = this.modifier.d().b();
        if (r0 == null) goto L13;
        getPositiveButton().setOnClickListener(new $$Lambda$OSelectionDialogModal$uG1cpAhmE7zOb4iF4grU4CXfPOM(r0, this));
    L13:
        d.h.a.b<OButton, x> r1 = this.modifier.d().c();
        if (r1 == null) goto L19;
        r1.invoke(getPositiveButton());
    L19:
        if (this.modifier.e() == null) goto L28;
        getNegativeButton().setVisibility(0);
        getNegativeButton().setText((CharSequence) ZeusTransformUtils.preCheckCast(this.modifier.e().a(), CharSequence.class, "com.obric.aiagent.plugin"));
        final d.h.a.a<x> r2 = this.modifier.e().b();
        if (r2 == null) goto L24;
        getNegativeButton().setOnClickListener(new $$Lambda$OSelectionDialogModal$FTRcHgRdW4a9LQSAcjZiuatTPss(r2, this));
    L24:
        d.h.a.b<OButton, x> r3 = this.modifier.e().c();
        if (r3 == null) goto L32;
        r3.invoke(getNegativeButton());
        return;
    L32:
        return;
    L28:
        getNegativeButton().setVisibility(8);
        return;
    L17:
        getPositiveButton().setVisibility(8);
        goto L19
    }

    /* JADX INFO: renamed from: initButtons$lambda-8$lambda-7, reason: not valid java name */
    private static final void m1056initButtons$lambda8$lambda7(d.h.a.a r1, OSelectionDialogModal r2, View r3) {
        d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r1, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "$click");
        o.e(r2, "this$0");
        r4.invoke();
        if (r2.isAutoDismiss() == false) goto L6;
        r2.dismiss();
        return;
    }

    /* JADX INFO: renamed from: initButtons$lambda-10$lambda-9, reason: not valid java name */
    private static final void m1055initButtons$lambda10$lambda9(d.h.a.a r1, OSelectionDialogModal r2, View r3) {
        d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r1, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "$click");
        o.e(r2, "this$0");
        r4.invoke();
        if (r2.isAutoDismiss() == false) goto L6;
        r2.dismiss();
        return;
    }

    @Override // com.obric.oui.dialog.base.OBaseDialogModal, com.obric.oui.dialog.base.AbstractDialogModal
    public void show(ViewGroup r2) {
        if (getShowAnimRunning() == false) goto L5;
        return;
    L5:
        super.show(r2);
        getBodyContainerView().post(new $$Lambda$OSelectionDialogModal$7fDzo4BY6EttGrNAJIKpk9eu9nY(this));
    }

    /* JADX INFO: renamed from: show$lambda-12, reason: not valid java name */
    private static final void m1057show$lambda12(OSelectionDialogModal r4) {
        o.e(r4, "this$0");
        ViewGroup r0 = r4.getBodyContainerView();
        ViewGroup.LayoutParams r1 = r4.getBodyContainerView().getLayoutParams();
        if (r4.getMaxRootViewHeightGap() <= 0) goto L5;
        int r2 = r4.getBodyContainerView().getMeasuredHeight() - r4.getMaxRootViewHeightGap();
    L6:
        r1.height = r2;
        r0.setLayoutParams(r1);
        r4.getBodyContainerView().requestLayout();
        return;
    L5:
        r2 = -2;
        goto L6
    }
}
