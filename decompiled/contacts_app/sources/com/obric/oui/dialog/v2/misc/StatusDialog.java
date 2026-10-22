package com.obric.oui.dialog.v2.misc;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.obric.common.oui.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.dialog.base.OBaseDialog;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.text.OTextView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StatusDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 +2\u00020\u0001:\u0002+,B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020%H\u0002J\u000e\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020(R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0013\u0010\u0010R\u001b\u0010\u0015\u001a\u00020\u00168FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\f\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\f\u001a\u0004\b \u0010\u001d¨\u0006-"}, d2 = {"Lcom/obric/oui/dialog/v2/misc/StatusDialog;", "Lcom/obric/oui/dialog/base/OBaseDialog;", "context", "Landroid/content/Context;", "modifier", "Lcom/obric/oui/dialog/v2/misc/StatusDialog$Modifier;", "(Landroid/content/Context;Lcom/obric/oui/dialog/v2/misc/StatusDialog$Modifier;)V", "buttonContainerView", "Landroid/view/View;", "getButtonContainerView", "()Landroid/view/View;", "buttonContainerView$delegate", "Lkotlin/Lazy;", "negativeButton", "Lcom/obric/oui/button/OButton;", "getNegativeButton", "()Lcom/obric/oui/button/OButton;", "negativeButton$delegate", "positiveButton", "getPositiveButton", "positiveButton$delegate", "processView", "Lcom/obric/oui/progress/ODownloadProgressView;", "getProcessView", "()Lcom/obric/oui/progress/ODownloadProgressView;", "processView$delegate", "subtitleTextView", "Lcom/obric/oui/text/OTextView;", "getSubtitleTextView", "()Lcom/obric/oui/text/OTextView;", "subtitleTextView$delegate", "titleTextView", "getTitleTextView", "titleTextView$delegate", "getLayout", "", "initButtons", "", "setSubtitleText", "message", "", "setTitleText", "title", "Companion", "Modifier", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StatusDialog extends OBaseDialog {
    public static final Companion Companion = null;
    private static final String TAG = "StatusDialog";
    private final Lazy buttonContainerView$delegate;
    private final Modifier modifier;
    private final Lazy negativeButton$delegate;
    private final Lazy positiveButton$delegate;
    private final Lazy processView$delegate;
    private final Lazy subtitleTextView$delegate;
    private final Lazy titleTextView$delegate;

    /* JADX INFO: compiled from: StatusDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/dialog/v2/misc/StatusDialog$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: StatusDialog.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/obric/oui/dialog/v2/misc/StatusDialog$Modifier;", "", "title", "", "subtitle", "positiveButton", "Lcom/obric/oui/dialog/base/OBaseDialog$ButtonConfig;", "negativeButton", "(Ljava/lang/String;Ljava/lang/String;Lcom/obric/oui/dialog/base/OBaseDialog$ButtonConfig;Lcom/obric/oui/dialog/base/OBaseDialog$ButtonConfig;)V", "getNegativeButton", "()Lcom/obric/oui/dialog/base/OBaseDialog$ButtonConfig;", "getPositiveButton", "getSubtitle", "()Ljava/lang/String;", "getTitle", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Modifier {
        private final OBaseDialog.ButtonConfig negativeButton;
        private final OBaseDialog.ButtonConfig positiveButton;
        private final String subtitle;
        private final String title;

        public Modifier(String r2, String r3, OBaseDialog.ButtonConfig r4, OBaseDialog.ButtonConfig r5) {
            Intrinsics.checkNotNullParameter(r2, "title");
            Intrinsics.checkNotNullParameter(r3, "subtitle");
            this.title = r2;
            this.subtitle = r3;
            this.positiveButton = r4;
            this.negativeButton = r5;
        }

        public /* synthetic */ Modifier(String r2, String r3, OBaseDialog.ButtonConfig r4, OBaseDialog.ButtonConfig r5, int r6, DefaultConstructorMarker r7) {
            if ((r6 & 4) == 0) goto L6;
            r4 = null;
        L6:
            if ((r6 & 8) == 0) goto L8;
            r5 = null;
        L8:
            this(r2, r3, r4, r5);
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getSubtitle() {
            return this.subtitle;
        }

        public final OBaseDialog.ButtonConfig getPositiveButton() {
            return this.positiveButton;
        }

        public final OBaseDialog.ButtonConfig getNegativeButton() {
            return this.negativeButton;
        }
    }

    public static /* synthetic */ void $r8$lambda$SdmqAIqwxjygHmZiOMRwWMoC6lU(StatusDialog r0, View r1) {
        m491initButtons$lambda7(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$yGT85dNcfGsT58mEneGzKqshllI(StatusDialog r0, View r1) {
        m490initButtons$lambda6(r0, r1);
    }

    static {
        Companion = new Companion(null);
    }

    public StatusDialog(Context r2, Modifier r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "modifier");
        super(r2);
        this.modifier = r3;
        this.processView$delegate = LazyKt.lazy(new StatusDialog$processView$2(this));
        this.titleTextView$delegate = LazyKt.lazy(new StatusDialog$titleTextView$2(this));
        this.subtitleTextView$delegate = LazyKt.lazy(new StatusDialog$subtitleTextView$2(this));
        this.buttonContainerView$delegate = LazyKt.lazy(new StatusDialog$buttonContainerView$2(this));
        this.negativeButton$delegate = LazyKt.lazy(new StatusDialog$negativeButton$2(this));
        this.positiveButton$delegate = LazyKt.lazy(new StatusDialog$positiveButton$2(this));
        getTitleTextView().setIncludeFontPadding(true);
        getSubtitleTextView().setIncludeFontPadding(true);
        setTitleText(r3.getTitle());
        setSubtitleText(r3.getSubtitle());
        initButtons();
    }

    public final ODownloadProgressView getProcessView() {
        Object r1 = this.processView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-processView>(...)");
        return (ODownloadProgressView) r1;
    }

    private final OTextView getTitleTextView() {
        Object r1 = this.titleTextView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-titleTextView>(...)");
        return (OTextView) r1;
    }

    private final OTextView getSubtitleTextView() {
        Object r1 = this.subtitleTextView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-subtitleTextView>(...)");
        return (OTextView) r1;
    }

    private final View getButtonContainerView() {
        Object r1 = this.buttonContainerView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-buttonContainerView>(...)");
        return (View) r1;
    }

    private final OButton getNegativeButton() {
        Object r1 = this.negativeButton$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-negativeButton>(...)");
        return (OButton) r1;
    }

    private final OButton getPositiveButton() {
        Object r1 = this.positiveButton$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-positiveButton>(...)");
        return (OButton) r1;
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog
    public int getLayout() {
        return R.layout.o_status_dialog;
    }

    public final void setTitleText(String r5) {
        Intrinsics.checkNotNullParameter(r5, "title");
        String r6 = r5;
        if (r6.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L13;
        getTitleTextView().setVisibility(8);
        ViewGroup.LayoutParams r4 = getSubtitleTextView().getLayoutParams();
        if (r4 == null) goto L12;
        ((ViewGroup.MarginLayoutParams) r4).topMargin = 0;
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L13:
        OTextView r1 = getTitleTextView();
        r1.setVisibility(0);
        r1.setText(r6);
        OTextView r7 = getSubtitleTextView();
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        if (r8 == null) goto L18;
        ((ViewGroup.MarginLayoutParams) r8).topMargin = OUnitExtensionKt.vdp(r7, 8);
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L5:
        r0 = false;
        goto L7
    }

    public final void setSubtitleText(String r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        String r4 = r3;
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        getSubtitleTextView().setVisibility(8);
        return;
    L8:
        OTextView r2 = getSubtitleTextView();
        r2.setVisibility(0);
        r2.setText(r4);
        return;
    L5:
        r0 = false;
        goto L6
    }

    private final void initButtons() {
        if (this.modifier.getPositiveButton() == null) goto L5;
    L7:
        setCanceledOnTouchOutside(false);
        if (this.modifier.getPositiveButton() == null) goto L16;
        getPositiveButton().setVisibility(0);
        getPositiveButton().setText(this.modifier.getPositiveButton().getText());
        if (this.modifier.getPositiveButton().getOnClick() == null) goto L12;
        getPositiveButton().setOnClickListener(new StatusDialog$$ExternalSyntheticLambda0(this));
    L12:
        Function1<OButton, Unit> r2 = this.modifier.getPositiveButton().getCustomizer();
        if (r2 == null) goto L18;
        r2.invoke(getPositiveButton());
    L18:
        if (this.modifier.getNegativeButton() == null) goto L26;
        getNegativeButton().setVisibility(0);
        getNegativeButton().setText(this.modifier.getNegativeButton().getText());
        if (this.modifier.getNegativeButton().getOnClick() == null) goto L22;
        getNegativeButton().setOnClickListener(new StatusDialog$$ExternalSyntheticLambda1(this));
    L22:
        Function1<OButton, Unit> r0 = this.modifier.getNegativeButton().getCustomizer();
        if (r0 == null) goto L30;
        r0.invoke(getNegativeButton());
        return;
    L30:
        return;
    L26:
        getNegativeButton().setVisibility(8);
        return;
    L16:
        getPositiveButton().setVisibility(8);
        goto L18
    L5:
        if (this.modifier.getNegativeButton() != null) goto L7;
        setCanceledOnTouchOutside(true);
        getButtonContainerView().setVisibility(8);
    }

    /* JADX INFO: renamed from: initButtons$lambda-6, reason: not valid java name */
    private static final void m490initButtons$lambda6(StatusDialog r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.modifier.getPositiveButton().getOnClick().invoke();
        if (r0.isAutoDismiss() == false) goto L6;
        r0.dismiss();
        return;
    }

    /* JADX INFO: renamed from: initButtons$lambda-7, reason: not valid java name */
    private static final void m491initButtons$lambda7(StatusDialog r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.modifier.getNegativeButton().getOnClick().invoke();
        if (r0.isAutoDismiss() == false) goto L6;
        r0.dismiss();
        return;
    }
}
