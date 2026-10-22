package com.obric.oui.dialog.v2.misc;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.base.OBaseDialogModal;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.text.OTextView;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.p;
import d.x;
import java.util.Objects;

/* JADX INFO: compiled from: StatusDialogModal.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class StatusDialogModal extends OBaseDialogModal {
    private final d.f buttonContainerView$delegate;
    private final a modifier;
    private final d.f negativeButton$delegate;
    private final d.f positiveButton$delegate;
    private final d.f processView$delegate;
    private final d.f subtitleTextView$delegate;
    private final d.f titleTextView$delegate;

    /* JADX INFO: compiled from: StatusDialogModal.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f35197a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f35198b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final OBaseDialogModal.a f35199c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final OBaseDialogModal.a f35200d;

        public final String a() {
            return this.f35197a;
        }

        public final String b() {
            return this.f35198b;
        }

        public final OBaseDialogModal.a c() {
            return this.f35199c;
        }

        public final OBaseDialogModal.a d() {
            return this.f35200d;
        }
    }

    /* JADX INFO: compiled from: StatusDialogModal.kt */
    static final class b extends p implements d.h.a.a<View> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ StatusDialogModal f35201a;

        b(StatusDialogModal r1) {
            this.f35201a = r1;
            super(0);
        }

        public final View a() {
            return this.f35201a.findViewById(ZeusTransformUtils.mapRes(R.id.status_dialog_btn_container, DbHelper.COL_ID, "status_dialog_btn_container"));
        }

        @Override // d.h.a.a
        public /* synthetic */ View invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: StatusDialogModal.kt */
    static final class c extends p implements d.h.a.a<OButton> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ StatusDialogModal f35202a;

        c(StatusDialogModal r1) {
            this.f35202a = r1;
            super(0);
        }

        public final OButton a() {
            return (OButton) ZeusTransformUtils.preCheckCast(this.f35202a.findViewById(ZeusTransformUtils.mapRes(R.id.actionNegative, DbHelper.COL_ID, "actionNegative")), OButton.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.a
        public /* synthetic */ OButton invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: StatusDialogModal.kt */
    static final class d extends p implements d.h.a.a<OButton> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ StatusDialogModal f35203a;

        d(StatusDialogModal r1) {
            this.f35203a = r1;
            super(0);
        }

        public final OButton a() {
            return (OButton) ZeusTransformUtils.preCheckCast(this.f35203a.findViewById(ZeusTransformUtils.mapRes(R.id.actionPositive, DbHelper.COL_ID, "actionPositive")), OButton.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.a
        public /* synthetic */ OButton invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: StatusDialogModal.kt */
    static final class e extends p implements d.h.a.a<ODownloadProgressView> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ StatusDialogModal f35204a;

        e(StatusDialogModal r1) {
            this.f35204a = r1;
            super(0);
        }

        public final ODownloadProgressView a() {
            return (ODownloadProgressView) ZeusTransformUtils.preCheckCast(this.f35204a.findViewById(ZeusTransformUtils.mapRes(R.id.status_progress_view, DbHelper.COL_ID, "status_progress_view")), ODownloadProgressView.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.a
        public /* synthetic */ ODownloadProgressView invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: StatusDialogModal.kt */
    static final class f extends p implements d.h.a.a<OTextView> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ StatusDialogModal f35205a;

        f(StatusDialogModal r1) {
            this.f35205a = r1;
            super(0);
        }

        public final OTextView a() {
            return (OTextView) ZeusTransformUtils.preCheckCast(this.f35205a.findViewById(ZeusTransformUtils.mapRes(R.id.status_dialog_sub_title, DbHelper.COL_ID, "status_dialog_sub_title")), OTextView.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.a
        public /* synthetic */ OTextView invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: StatusDialogModal.kt */
    static final class g extends p implements d.h.a.a<OTextView> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ StatusDialogModal f35206a;

        g(StatusDialogModal r1) {
            this.f35206a = r1;
            super(0);
        }

        public final OTextView a() {
            return (OTextView) ZeusTransformUtils.preCheckCast(this.f35206a.findViewById(ZeusTransformUtils.mapRes(R.id.status_dialog_title, DbHelper.COL_ID, "status_dialog_title")), OTextView.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.a
        public /* synthetic */ OTextView invoke() {
            return a();
        }
    }

    public static /* synthetic */ void lambda$494HDymXq_MXxE8SqiX1rDlM6Gw(d.h.a.a r0, StatusDialogModal r1, View r2) {
        m1050initButtons$lambda7$lambda6(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$NH0L9nAO1GROQTOAxpQCf8hSmVY(d.h.a.a r0, StatusDialogModal r1, View r2) {
        m1051initButtons$lambda9$lambda8(r0, r1, r2);
    }

    public StatusDialogModal(Context r3, a r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r4, "modifier");
        super(r5);
        this.modifier = r4;
        this.processView$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new e(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.titleTextView$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new g(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.subtitleTextView$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new f(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.buttonContainerView$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new b(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.negativeButton$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new c(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.positiveButton$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new d(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        getTitleTextView().setIncludeFontPadding(true);
        getSubtitleTextView().setIncludeFontPadding(true);
        setTitleText(r4.a());
        setSubtitleText(r4.b());
        initButtons();
    }

    public final ODownloadProgressView getProcessView() {
        Object r2 = this.processView$delegate.b();
        o.c(r2, "<get-processView>(...)");
        return (ODownloadProgressView) ZeusTransformUtils.preCheckCast(r2, ODownloadProgressView.class, "com.obric.aiagent.plugin");
    }

    private final OTextView getTitleTextView() {
        Object r2 = this.titleTextView$delegate.b();
        o.c(r2, "<get-titleTextView>(...)");
        return (OTextView) ZeusTransformUtils.preCheckCast(r2, OTextView.class, "com.obric.aiagent.plugin");
    }

    private final OTextView getSubtitleTextView() {
        Object r2 = this.subtitleTextView$delegate.b();
        o.c(r2, "<get-subtitleTextView>(...)");
        return (OTextView) ZeusTransformUtils.preCheckCast(r2, OTextView.class, "com.obric.aiagent.plugin");
    }

    private final View getButtonContainerView() {
        Object r2 = this.buttonContainerView$delegate.b();
        o.c(r2, "<get-buttonContainerView>(...)");
        return (View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin");
    }

    private final OButton getNegativeButton() {
        Object r2 = this.negativeButton$delegate.b();
        o.c(r2, "<get-negativeButton>(...)");
        return (OButton) ZeusTransformUtils.preCheckCast(r2, OButton.class, "com.obric.aiagent.plugin");
    }

    private final OButton getPositiveButton() {
        Object r2 = this.positiveButton$delegate.b();
        o.c(r2, "<get-positiveButton>(...)");
        return (OButton) ZeusTransformUtils.preCheckCast(r2, OButton.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.oui.dialog.base.AbstractDialogModal
    public int getLayout() {
        return ZeusTransformUtils.mapRes(R.layout.o_status_dialog, "layout", "o_status_dialog");
    }

    public final void setTitleText(String r6) {
        o.e(r6, DBDefinition.TITLE);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
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
        r1.setText((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"));
        OTextView r7 = getSubtitleTextView();
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        Objects.requireNonNull(r8, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r8, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin")).topMargin = com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.aiagent.plugin"), 8);
        return;
    L5:
        r0 = false;
        goto L7
    }

    public final void setSubtitleText(String r4) {
        o.e(r4, "message");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        getSubtitleTextView().setVisibility(8);
        return;
    L8:
        OTextView r3 = getSubtitleTextView();
        r3.setVisibility(0);
        r3.setText((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"));
        com.obric.oui.dialog.b.a((TextView) ZeusTransformUtils.preCheckCast(r3, TextView.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        r0 = false;
        goto L6
    }

    private final void initButtons() {
        if (this.modifier.c() == null) goto L5;
    L7:
        setCanceledOnTouchOutside(false);
        if (this.modifier.c() == null) goto L17;
        getPositiveButton().setVisibility(0);
        getPositiveButton().setText((CharSequence) ZeusTransformUtils.preCheckCast(this.modifier.c().a(), CharSequence.class, "com.obric.aiagent.plugin"));
        final d.h.a.a<x> r2 = this.modifier.c().b();
        if (r2 == null) goto L13;
        getPositiveButton().setOnClickListener(new $$Lambda$StatusDialogModal$494HDymXq_MXxE8SqiX1rDlM6Gw(r2, this));
    L13:
        d.h.a.b<OButton, x> r3 = this.modifier.c().c();
        if (r3 == null) goto L19;
        r3.invoke(getPositiveButton());
    L19:
        if (this.modifier.d() == null) goto L28;
        getNegativeButton().setVisibility(0);
        getNegativeButton().setText((CharSequence) ZeusTransformUtils.preCheckCast(this.modifier.d().a(), CharSequence.class, "com.obric.aiagent.plugin"));
        final d.h.a.a<x> r0 = this.modifier.d().b();
        if (r0 == null) goto L24;
        getNegativeButton().setOnClickListener(new $$Lambda$StatusDialogModal$NH0L9nAO1GROQTOAxpQCf8hSmVY(r0, this));
    L24:
        d.h.a.b<OButton, x> r1 = this.modifier.d().c();
        if (r1 == null) goto L32;
        r1.invoke(getNegativeButton());
        return;
    L32:
        return;
    L28:
        getNegativeButton().setVisibility(8);
        return;
    L17:
        getPositiveButton().setVisibility(8);
        goto L19
    L5:
        if (this.modifier.d() != null) goto L7;
        setCanceledOnTouchOutside(true);
        getButtonContainerView().setVisibility(8);
    }

    /* JADX INFO: renamed from: initButtons$lambda-7$lambda-6, reason: not valid java name */
    private static final void m1050initButtons$lambda7$lambda6(d.h.a.a r1, StatusDialogModal r2, View r3) {
        d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r1, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "$click");
        o.e(r2, "this$0");
        r4.invoke();
        if (r2.isAutoDismiss() == false) goto L6;
        r2.dismiss();
        return;
    }

    /* JADX INFO: renamed from: initButtons$lambda-9$lambda-8, reason: not valid java name */
    private static final void m1051initButtons$lambda9$lambda8(d.h.a.a r1, StatusDialogModal r2, View r3) {
        d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r1, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "$click");
        o.e(r2, "this$0");
        r4.invoke();
        if (r2.isAutoDismiss() == false) goto L6;
        r2.dismiss();
        return;
    }
}
