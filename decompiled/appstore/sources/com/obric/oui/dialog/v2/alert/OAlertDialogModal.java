package com.obric.oui.dialog.v2.alert;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.obric.common.oui.R$layout;
import com.obric.oui.dialog.base.AbstractDialogModal;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import com.obric.oui.dialog.v2.alert.style.DialogContainer;
import com.obric.oui.dialog.v2.alert.style.StyleController;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(30)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0005J\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0013\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0012J\r\u0010\u0016\u001a\u00020\f¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u001b\u0010\u000eJ\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u001e\u0010\u001dJ\u000f\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b\"\u0010!J\u000f\u0010$\u001a\u0004\u0018\u00010#¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u0004\u0018\u00010#¢\u0006\u0004\b&\u0010%J\u000f\u0010'\u001a\u0004\u0018\u00010#¢\u0006\u0004\b'\u0010%J\u000f\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020(H\u0016¢\u0006\u0004\b+\u0010*J\u000f\u0010,\u001a\u00020(H\u0016¢\u0006\u0004\b,\u0010*J\u000f\u0010-\u001a\u00020(H\u0016¢\u0006\u0004\b-\u0010*R\u0014\u00100\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00102\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010/R\u0018\u00105\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00108\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010:\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u00107R\u0014\u0010<\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010/R\u0018\u0010?\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010A\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010/R\u0018\u0010C\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u00104¨\u0006D"}, d2 = {"Lcom/obric/oui/dialog/v2/alert/OAlertDialogModal;", "Lcom/obric/oui/dialog/base/AbstractDialogModal;", "Lcom/obric/oui/dialog/v2/alert/style/DialogContainer;", "", "getIconPanelVerticalSpace", "()I", "getTitleVerticalSpace", "getMessageVerticalSpace", "getButtonVerticalSpace", "getLayout", "Lcom/obric/oui/dialog/v2/alert/style/StyleController;", "controller", "", "setTopImageStyleController", "(Lcom/obric/oui/dialog/v2/alert/style/StyleController;)V", "", "title", "setTitleText", "(Ljava/lang/CharSequence;)V", "setOnlyTitleText", "message", "setMessage", "v", "()V", "Lcom/obric/oui/dialog/v2/alert/style/ButtonStyleController;", "setButtonStyleController", "(Lcom/obric/oui/dialog/v2/alert/style/ButtonStyleController;)V", "setBodyStyleController", "getTitleStr", "()Ljava/lang/CharSequence;", "getMessageStr", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "getMessageView", "Landroid/view/View;", "getPositiveButton", "()Landroid/view/View;", "getNegativeButton", "getNeutralButton", "Landroid/widget/FrameLayout;", "getBannerSlot", "()Landroid/widget/FrameLayout;", "getIconSlot", "getBodySlot", "getButtonSlot", "E", "Landroid/widget/FrameLayout;", "bannderPanel", "F", "iconPanel", "G", "Lcom/obric/oui/dialog/v2/alert/style/StyleController;", "topImageStyleController", "H", "Landroid/widget/TextView;", "titleTextView", "I", "messageTextView", "J", "buttonPanel", "K", "Lcom/obric/oui/dialog/v2/alert/style/ButtonStyleController;", "buttonStyleController", "L", "bodyPanel", "M", "bodyStyleController", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OAlertDialogModal extends AbstractDialogModal implements DialogContainer {
    public final FrameLayout E;
    public final FrameLayout F;
    public StyleController G;
    public TextView H;
    public TextView I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final FrameLayout f14467J;
    public ButtonStyleController K;
    public final FrameLayout L;
    public StyleController M;

    private final int getButtonVerticalSpace() {
        if (this.f14467J.getVisibility() == 0) goto L7;
        return 0;
    L7:
        return this.f14467J.getMeasuredHeight();
    }

    private final int getIconPanelVerticalSpace() {
        if (this.E.getVisibility() != 0) goto L6;
        return this.E.getMeasuredHeight();
    L6:
        return this.F.getMeasuredHeight();
    }

    private final int getMessageVerticalSpace() {
        TextView r10 = this.I;
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (r10.getVisibility() != 0) goto L12;
        TextView r11 = this.I;
        if (r11 != null) goto L11;
        return 0;
    L11:
        return r11.getMeasuredHeight();
    L12:
        return 0;
    }

    private final int getTitleVerticalSpace() {
        TextView r10 = this.H;
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (r10.getVisibility() != 0) goto L12;
        TextView r11 = this.H;
        if (r11 != null) goto L11;
        return 0;
    L11:
        return r11.getMeasuredHeight();
    L12:
        return 0;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.DialogContainer
    @NotNull
    public FrameLayout getBannerSlot() {
        return this.E;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.DialogContainer
    @NotNull
    public FrameLayout getBodySlot() {
        return this.L;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.DialogContainer
    @NotNull
    public FrameLayout getButtonSlot() {
        return this.f14467J;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.DialogContainer
    @NotNull
    public FrameLayout getIconSlot() {
        return this.F;
    }

    @Override // com.obric.oui.dialog.base.AbstractDialogModal
    public int getLayout() {
        return R$layout.o_alert_dialog_v2;
    }

    @Nullable
    public final CharSequence getMessageStr() {
        TextView r10 = this.I;
        if (r10 != null) goto L6;
        return null;
    L6:
        return r10.getText();
    }

    @Nullable
    public final TextView getMessageView() {
        return this.I;
    }

    @Nullable
    public final View getNegativeButton() {
        td.c r10 = td.c.f24796a;
        ButtonStyleController r11 = this.K;
        if (r11 != null) goto L5;
        r11 = null;
    L5:
        if (r11 != null) goto L8;
        return null;
    L8:
        return r11.a();
    }

    @Nullable
    public final View getNeutralButton() {
        td.c r10 = td.c.f24796a;
        ButtonStyleController r11 = this.K;
        if (r11 != null) goto L5;
        r11 = null;
    L5:
        if (r11 != null) goto L8;
        return null;
    L8:
        return r11.b();
    }

    @Nullable
    public final View getPositiveButton() {
        td.c r10 = td.c.f24796a;
        ButtonStyleController r11 = this.K;
        if (r11 != null) goto L5;
        r11 = null;
    L5:
        if (r11 != null) goto L8;
        return null;
    L8:
        return r11.c();
    }

    @Nullable
    public final CharSequence getTitleStr() {
        TextView r10 = this.H;
        if (r10 != null) goto L6;
        return null;
    L6:
        return r10.getText();
    }

    @Nullable
    public final TextView getTitleView() {
        return this.H;
    }

    public final void setBodyStyleController(@NotNull StyleController r10) {
        q.g(r10, "controller");
        this.M = r10;
        FrameLayout r11 = this.L;
        if (getMatchParentHeight() == false) goto L5;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        r12.height = 0;
        r11.setLayoutParams(r12);
    L5:
        r11.setVisibility(0);
        Context r13 = getContext();
        q.f(r13, "context");
        r10.attachToParent(r13, this);
    }

    public final void setButtonStyleController(@NotNull ButtonStyleController r10) {
        q.g(r10, "controller");
        this.K = r10;
        Context r11 = getContext();
        q.f(r11, "context");
        r10.attachToParent(r11, this);
        r10.attachToHost(this);
    }

    public final void setMessage(@NotNull CharSequence r10) {
        q.g(r10, "message");
        TextView r11 = this.I;
        if (r11 == null) goto L6;
        r11.setVisibility(0);
        r11.setText(r10);
    L6:
        TextView r12 = this.I;
        if (r12 == null) goto L11;
        r12.setMaxLines(Channel.UNLIMITED);
        return;
    }

    public final void setOnlyTitleText(@Nullable CharSequence r10) {
        if (r10 == null) goto L9;
        TextView r11 = this.H;
        if (r11 == null) goto L10;
        r11.setVisibility(0);
        r11.setText(r10);
        Context r12 = r11.getContext();
        q.f(r12, "tv.context");
        int r13 = f.b(r12, 19);
        Context r14 = r11.getContext();
        q.f(r14, "tv.context");
        r11.setPadding(0, r13, 0, f.b(r14, 19));
        return;
    L10:
        return;
    }

    public final void setTitleText(@Nullable CharSequence r10) {
        boolean r11 = TextUtils.isEmpty(r10);
        TextView r12 = this.H;
        int r13 = 0;
        if (r12 == null) goto L9;
        if (r11 == false) goto L7;
        int r14 = 8;
    L8:
        r12.setVisibility(r14);
        r12.setText(r10);
        r12.setPadding(0, 0, 0, 0);
        goto L9
    L7:
        r14 = 0;
    L9:
        TextView r15 = this.I;
        if (r15 == null) goto L22;
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        if (r16 == null) goto L21;
        ViewGroup.MarginLayoutParams r17 = (ViewGroup.MarginLayoutParams) r16;
        if (r11 == true) goto L18;
        Context r18 = r15.getContext();
        q.f(r18, "it.context");
        r13 = f.b(r18, 8);
    L18:
        r17.topMargin = r13;
        return;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void setTopImageStyleController(@NotNull StyleController r10) {
        q.g(r10, "controller");
        this.G = r10;
        Context r11 = getContext();
        q.f(r11, "context");
        r10.attachToParent(r11, this);
    }

    public final void v() {
        TextView r10 = this.I;
        if (r10 == null) goto L7;
        r10.setMaxLines(Channel.UNLIMITED);
        return;
    }
}
