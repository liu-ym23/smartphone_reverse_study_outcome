package com.obric.oui.dialog.v2.alert.style;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.utils.ViewUtil;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultButtonStyleController.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\n\u0010\u0019\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0012H\u0016J&\u0010\u001e\u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J&\u0010%\u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J.\u0010&\u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\u0014H\u0002J\u0016\u0010*\u001a\u00020\u0014*\u00020\u000e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/obric/oui/dialog/v2/alert/style/DefaultButtonStyleController;", "Lcom/obric/oui/dialog/v2/alert/style/ButtonStyleController;", "context", "Landroid/content/Context;", "style", "", "(Landroid/content/Context;I)V", "getContext", "()Landroid/content/Context;", "customButtonViewContainer", "Landroid/widget/FrameLayout;", "dialog", "Lcom/obric/oui/dialog/base/AbstractDialog;", "negativeButton", "Lcom/obric/oui/button/OButton;", "neutralButton", "positiveButton", "rootView", "Landroid/view/View;", "attachToDialog", "", "attachToParent", "dialogContainer", "Lcom/obric/oui/dialog/v2/alert/style/DialogContainer;", "getButtonContainerLayout", "getNegativeButton", "getNeutralButton", "getPositiveButton", "setCustomNegativeButton", "view", "setNegativeButton", "text", "", "listener", "Landroid/content/DialogInterface$OnClickListener;", "textColorType", "Lcom/obric/oui/dialog/v2/alert/style/ButtonStyleController$TextColorType;", "setNeutralButton", "setPositiveButton", "positiveButtonWarning", "", "tryDismiss", "setTextColor", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class DefaultButtonStyleController extends ButtonStyleController {
    private final Context context;
    private FrameLayout customButtonViewContainer;
    private AbstractDialog dialog;
    private OButton negativeButton;
    private OButton neutralButton;
    private OButton positiveButton;
    private View rootView;
    private final int style;

    /* JADX INFO: compiled from: DefaultButtonStyleController.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[ButtonStyleController.TextColorType.values().length];
            r0[ButtonStyleController.TextColorType.Negative.ordinal()] = 1;
            r0[ButtonStyleController.TextColorType.TextReverse.ordinal()] = 2;
            r0[ButtonStyleController.TextColorType.TextReverse2.ordinal()] = 3;
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static /* synthetic */ void $r8$lambda$IYS_KiiswcFrivprDzfYYwDUJcM(DefaultButtonStyleController r0, DialogInterface.OnClickListener r1, View r2) {
        m482setPositiveButton$lambda2$lambda1(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$PcpKitKM1_HYTZTgVMMhWFY9V8w(DefaultButtonStyleController r0, DialogInterface.OnClickListener r1, View r2) {
        m481setNeutralButton$lambda8$lambda7(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$ZEFDc9WpDJPEyVuE9ySCUiUphDc(DefaultButtonStyleController r0, DialogInterface.OnClickListener r1, View r2) {
        m480setNegativeButton$lambda5$lambda4(r0, r1, r2);
    }

    @Override // com.obric.oui.dialog.v2.alert.style.ButtonStyleController
    public /* bridge */ /* synthetic */ View getNegativeButton() {
        return getNegativeButton();
    }

    @Override // com.obric.oui.dialog.v2.alert.style.ButtonStyleController
    public /* bridge */ /* synthetic */ View getNeutralButton() {
        return getNeutralButton();
    }

    @Override // com.obric.oui.dialog.v2.alert.style.ButtonStyleController
    public /* bridge */ /* synthetic */ View getPositiveButton() {
        return getPositiveButton();
    }

    protected final Context getContext() {
        return this.context;
    }

    public DefaultButtonStyleController(Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.context = r2;
        this.style = r3;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.StyleController
    public void attachToParent(Context r5, DialogContainer r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "dialogContainer");
        FrameLayout r7 = r6.getButtonSlot();
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-1, -2);
        int r1 = getButtonContainerLayout(this.style);
        View r8 = LayoutInflater.from(r5).inflate(r1, r7, false);
        r7.addView(r8, r0);
        this.rootView = r8;
        if (r8 == null) goto L6;
        r8.setVisibility(8);
    L6:
        this.positiveButton = (OButton) r8.findViewById(R.id.actionPositive);
        this.negativeButton = (OButton) r8.findViewById(R.id.actionNegative);
        this.neutralButton = (OButton) r8.findViewById(R.id.actionNeutral);
        this.customButtonViewContainer = (FrameLayout) r8.findViewById(R.id.custom_container);
    }

    public int getButtonContainerLayout(int r1) {
        if (r1 == 0) goto L8;
        if (r1 == 1) goto L13;
        return R.layout.o_dialog_button_primary;
    L13:
        return R.layout.o_dialog_button_vertical;
    L8:
        if (ViewUtil.isInLargeFont(this.context.getResources().getConfiguration().fontScale) == false) goto L11;
        return R.layout.o_dialog_button_vertical;
    L11:
        return R.layout.o_dialog_button_horizontal;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.ButtonStyleController
    public void setPositiveButton(CharSequence r4, final DialogInterface.OnClickListener r5, ButtonStyleController.TextColorType r6, boolean r7) {
        OButton r0 = this.positiveButton;
        if (r0 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r4) == false) goto L9;
        r0.setVisibility(8);
        return;
    L9:
        View r1 = this.rootView;
        if (r1 == null) goto L13;
        r1.setVisibility(0);
    L13:
        if (r7 == false) goto L15;
        r0.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.oui_basic_fill_element_2));
        r0.setTextColor(ContextCompat.getColor(getContext(), R.color.oui_functional_red_6));
    L15:
        r0.setText(r4);
        setTextColor(r0, r6);
        r0.setVisibility(0);
        r0.setOnClickListener(new DefaultButtonStyleController$$ExternalSyntheticLambda1(this, r5));
    }

    /* JADX INFO: renamed from: setPositiveButton$lambda-2$lambda-1, reason: not valid java name */
    private static final void m482setPositiveButton$lambda2$lambda1(DefaultButtonStyleController r1, DialogInterface.OnClickListener r2, View r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        AbstractDialog r4 = r1.dialog;
        if (r4 == null) goto L10;
        if (r2 == null) goto L8;
        r2.onClick(r4, -1);
    L8:
        r1.tryDismiss();
        return;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.ButtonStyleController
    public void setNegativeButton(CharSequence r4, final DialogInterface.OnClickListener r5, ButtonStyleController.TextColorType r6) {
        OButton r0 = this.negativeButton;
        if (r0 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r4) == false) goto L9;
        r0.setVisibility(8);
        return;
    L9:
        View r1 = this.rootView;
        if (r1 == null) goto L13;
        r1.setVisibility(0);
    L13:
        r0.setText(r4);
        setTextColor(r0, r6);
        r0.setVisibility(0);
        r0.setOnClickListener(new DefaultButtonStyleController$$ExternalSyntheticLambda0(this, r5));
    }

    /* JADX INFO: renamed from: setNegativeButton$lambda-5$lambda-4, reason: not valid java name */
    private static final void m480setNegativeButton$lambda5$lambda4(DefaultButtonStyleController r1, DialogInterface.OnClickListener r2, View r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        AbstractDialog r4 = r1.dialog;
        if (r4 == null) goto L10;
        if (r2 == null) goto L8;
        r2.onClick(r4, -2);
    L8:
        r1.tryDismiss();
        return;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.ButtonStyleController
    public void setNeutralButton(CharSequence r4, final DialogInterface.OnClickListener r5, ButtonStyleController.TextColorType r6) {
        OButton r0 = this.neutralButton;
        if (r0 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r4) == false) goto L9;
        r0.setVisibility(8);
        return;
    L9:
        View r1 = this.rootView;
        if (r1 == null) goto L13;
        r1.setVisibility(0);
    L13:
        r0.setText(r4);
        setTextColor(r0, r6);
        r0.setVisibility(0);
        r0.setOnClickListener(new DefaultButtonStyleController$$ExternalSyntheticLambda2(this, r5));
    }

    /* JADX INFO: renamed from: setNeutralButton$lambda-8$lambda-7, reason: not valid java name */
    private static final void m481setNeutralButton$lambda8$lambda7(DefaultButtonStyleController r1, DialogInterface.OnClickListener r2, View r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        AbstractDialog r4 = r1.dialog;
        if (r4 == null) goto L10;
        if (r2 == null) goto L8;
        r2.onClick(r4, -3);
    L8:
        r1.tryDismiss();
        return;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.ButtonStyleController
    public void setCustomNegativeButton(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        if (this.style == 2) goto L5;
        return;
    L5:
        if (this.customButtonViewContainer == null) goto L20;
        View r0 = this.rootView;
        if (r0 == null) goto L10;
        r0.setVisibility(0);
    L10:
        FrameLayout r1 = this.customButtonViewContainer;
        if (r1 == null) goto L14;
        r1.addView(r3);
    L14:
        FrameLayout r2 = this.customButtonViewContainer;
        if (r2 == null) goto L21;
        ViewExtensionsKt.makeVisible(r2);
        return;
    L21:
        return;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.ButtonStyleController
    public OButton getPositiveButton() {
        return this.positiveButton;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.ButtonStyleController
    public OButton getNegativeButton() {
        return this.negativeButton;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.ButtonStyleController
    public OButton getNeutralButton() {
        return this.neutralButton;
    }

    private final void setTextColor(OButton r1, ButtonStyleController.TextColorType r2) {
        if (r2 == null) goto L16;
        int r0 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
        if (r0 != 1) goto L6;
        int r3 = R.color.Negative;
    L14:
        r1.setTextColor(ContextCompat.getColor(r1.getContext(), r3));
        return;
    L6:
        if (r0 != 2) goto L8;
        r3 = R.color.TextReverse;
        goto L14
    L8:
        if (r0 != 3) goto L11;
        r3 = R.color.TextReverse2;
        goto L14
    L11:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.obric.oui.dialog.v2.alert.style.StyleController
    public void attachToDialog(AbstractDialog r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        this.dialog = r2;
    }

    private final void tryDismiss() {
        AbstractDialog r0 = this.dialog;
        boolean r1 = false;
        if (r0 != null) goto L6;
    L8:
        if (r1 == false) goto L10;
        return;
    L10:
        AbstractDialog r2 = this.dialog;
        if (r2 == null) goto L15;
        r2.dismiss();
        return;
    L15:
        return;
    L6:
        if (r0.isAutoDismiss() == true) goto L8;
        r1 = true;
        goto L8
    }
}
