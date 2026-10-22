package com.obric.oui.dialog.v2.misc;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RequiresApi;
import com.obric.common.oui.R$layout;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.base.OBaseDialogModal;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.text.OTextView;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(30)
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\tR\u001b\u0010\u0011\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0019\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0015R\u001b\u0010\u001e\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010#\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u000e\u001a\u0004\b!\u0010\"R\u001b\u0010&\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u000e\u001a\u0004\b%\u0010\"¨\u0006'"}, d2 = {"Lcom/obric/oui/dialog/v2/misc/StatusDialogModal;", "Lcom/obric/oui/dialog/base/OBaseDialogModal;", "", "getLayout", "()I", "", "title", "", "setTitleText", "(Ljava/lang/String;)V", "message", "setSubtitleText", "Lcom/obric/oui/progress/ODownloadProgressView;", "F", "Lkotlin/Lazy;", "getProcessView", "()Lcom/obric/oui/progress/ODownloadProgressView;", "processView", "Lcom/obric/oui/text/OTextView;", "G", "getTitleTextView", "()Lcom/obric/oui/text/OTextView;", "titleTextView", "H", "getSubtitleTextView", "subtitleTextView", "Landroid/view/View;", "I", "getButtonContainerView", "()Landroid/view/View;", "buttonContainerView", "Lcom/obric/oui/button/OButton;", "J", "getNegativeButton", "()Lcom/obric/oui/button/OButton;", "negativeButton", "K", "getPositiveButton", "positiveButton", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StatusDialogModal extends OBaseDialogModal {
    public final Lazy F;
    public final Lazy G;
    public final Lazy H;
    public final Lazy I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final Lazy f14499J;
    public final Lazy K;

    private final View getButtonContainerView() {
        Object r10 = this.I.getValue();
        q.f(r10, "<get-buttonContainerView>(...)");
        return (View) r10;
    }

    private final OButton getNegativeButton() {
        Object r10 = this.f14499J.getValue();
        q.f(r10, "<get-negativeButton>(...)");
        return (OButton) r10;
    }

    private final OButton getPositiveButton() {
        Object r10 = this.K.getValue();
        q.f(r10, "<get-positiveButton>(...)");
        return (OButton) r10;
    }

    private final OTextView getSubtitleTextView() {
        Object r10 = this.H.getValue();
        q.f(r10, "<get-subtitleTextView>(...)");
        return (OTextView) r10;
    }

    private final OTextView getTitleTextView() {
        Object r10 = this.G.getValue();
        q.f(r10, "<get-titleTextView>(...)");
        return (OTextView) r10;
    }

    @Override // com.obric.oui.dialog.base.AbstractDialogModal
    public int getLayout() {
        return R$layout.o_status_dialog;
    }

    @NotNull
    public final ODownloadProgressView getProcessView() {
        Object r10 = this.F.getValue();
        q.f(r10, "<get-processView>(...)");
        return (ODownloadProgressView) r10;
    }

    public final void setSubtitleText(@NotNull String r10) {
        q.g(r10, "message");
        if (r10.length() != 0) goto L5;
        getSubtitleTextView().setVisibility(8);
        return;
    L5:
        OTextView r11 = getSubtitleTextView();
        r11.setVisibility(0);
        r11.setText(r10);
    }

    public final void setTitleText(@NotNull String r10) {
        q.g(r10, "title");
        if (r10.length() != 0) goto L9;
        getTitleTextView().setVisibility(8);
        ViewGroup.LayoutParams r11 = getSubtitleTextView().getLayoutParams();
        if (r11 == null) goto L8;
        ((ViewGroup.MarginLayoutParams) r11).topMargin = 0;
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L9:
        OTextView r12 = getTitleTextView();
        r12.setVisibility(0);
        r12.setText(r10);
        OTextView r13 = getSubtitleTextView();
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if (r14 == null) goto L14;
        int r15 = f.r(r13, 8);
        ((ViewGroup.MarginLayoutParams) r14).topMargin = r15;
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
}
