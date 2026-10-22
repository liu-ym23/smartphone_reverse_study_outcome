package com.obric.oui.dialog.v2.misc;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import com.obric.common.oui.R$layout;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.base.OBaseDialogModal;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.text.OTextView;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(30)
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u0000 <2\u00020\u0001:\u0002=>J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\tR\u001b\u0010\u0011\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0014\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\u001b\u0010\u0019\u001a\u00020\u00158FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001c\u001a\u00020\u00158FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u001b\u0010\u0018R\u001b\u0010!\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001f\u0010 R\u001b\u0010$\u001a\u00020\u001d8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u000e\u001a\u0004\b#\u0010 R\u001b\u0010'\u001a\u00020\u001d8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u000e\u001a\u0004\b&\u0010 R\u001b\u0010*\u001a\u00020\u001d8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u000e\u001a\u0004\b)\u0010 R$\u00102\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00106\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010-\u001a\u0004\b4\u0010/\"\u0004\b5\u00101R\u0017\u00108\u001a\u0002078\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;¨\u0006?"}, d2 = {"Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialogModal;", "Lcom/obric/oui/dialog/base/OBaseDialogModal;", "", "getLayout", "()I", "", "title", "", "setTitleText", "(Ljava/lang/CharSequence;)V", "message", "setSubtitleText", "Lcom/obric/oui/text/OTextView;", "F", "Lkotlin/Lazy;", "getTitleTextView", "()Lcom/obric/oui/text/OTextView;", "titleTextView", "G", "getSubtitleTextView", "subtitleTextView", "Lcom/obric/oui/button/OButton;", "H", "getNegativeButton", "()Lcom/obric/oui/button/OButton;", "negativeButton", "I", "getPositiveButton", "positiveButton", "Landroid/widget/FrameLayout;", "J", "getBodyContainer", "()Landroid/widget/FrameLayout;", "bodyContainer", "K", "getFooterContainer", "footerContainer", "L", "getInputView1Container", "inputView1Container", "M", "getInputView2Container", "inputView2Container", "Lcom/obric/oui/forms/OInputLayout;", "N", "Lcom/obric/oui/forms/OInputLayout;", "getInputView1", "()Lcom/obric/oui/forms/OInputLayout;", "setInputView1", "(Lcom/obric/oui/forms/OInputLayout;)V", "inputView1", "O", "getInputView2", "setInputView2", "inputView2", "Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialogModal$b;", "modifier", "Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialogModal$b;", "getModifier", "()Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialogModal$b;", "P", "a", "b", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OSimpleFormDialogModal extends OBaseDialogModal {
    public static final a P = null;
    public final Lazy F;
    public final Lazy G;
    public final Lazy H;
    public final Lazy I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final Lazy f14498J;
    public final Lazy K;
    public final Lazy L;
    public final Lazy M;
    public OInputLayout N;
    public OInputLayout O;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public static final class b {
    }

    static {
        P = new a(null);
    }

    private final FrameLayout getBodyContainer() {
        Object r10 = this.f14498J.getValue();
        q.f(r10, "<get-bodyContainer>(...)");
        return (FrameLayout) r10;
    }

    @NotNull
    public final FrameLayout getFooterContainer() {
        Object r10 = this.K.getValue();
        q.f(r10, "<get-footerContainer>(...)");
        return (FrameLayout) r10;
    }

    @Nullable
    public final OInputLayout getInputView1() {
        return this.N;
    }

    @NotNull
    public final FrameLayout getInputView1Container() {
        Object r10 = this.L.getValue();
        q.f(r10, "<get-inputView1Container>(...)");
        return (FrameLayout) r10;
    }

    @Nullable
    public final OInputLayout getInputView2() {
        return this.O;
    }

    @NotNull
    public final FrameLayout getInputView2Container() {
        Object r10 = this.M.getValue();
        q.f(r10, "<get-inputView2Container>(...)");
        return (FrameLayout) r10;
    }

    @Override // com.obric.oui.dialog.base.AbstractDialogModal
    public int getLayout() {
        return R$layout.o_simple_form_dialog;
    }

    @NotNull
    public final b getModifier() {
        return null;
    }

    @NotNull
    public final OButton getNegativeButton() {
        Object r10 = this.H.getValue();
        q.f(r10, "<get-negativeButton>(...)");
        return (OButton) r10;
    }

    @NotNull
    public final OButton getPositiveButton() {
        Object r10 = this.I.getValue();
        q.f(r10, "<get-positiveButton>(...)");
        return (OButton) r10;
    }

    @NotNull
    public final OTextView getSubtitleTextView() {
        Object r10 = this.G.getValue();
        q.f(r10, "<get-subtitleTextView>(...)");
        return (OTextView) r10;
    }

    @NotNull
    public final OTextView getTitleTextView() {
        Object r10 = this.F.getValue();
        q.f(r10, "<get-titleTextView>(...)");
        return (OTextView) r10;
    }

    public final void setInputView1(@Nullable OInputLayout r10) {
        this.N = r10;
    }

    public final void setInputView2(@Nullable OInputLayout r10) {
        this.O = r10;
    }

    public final void setSubtitleText(@NotNull CharSequence r10) {
        q.g(r10, "message");
        if (r10.length() != 0) goto L5;
        getSubtitleTextView().setVisibility(8);
        return;
    L5:
        OTextView r11 = getSubtitleTextView();
        r11.setVisibility(0);
        r11.setText(r10);
    }

    public final void setTitleText(@NotNull CharSequence r10) {
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
