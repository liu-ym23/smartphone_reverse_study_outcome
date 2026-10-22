package com.obric.oui.dialog.v2.alert;

import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.GlobalProxyLancet;
import com.obric.common.oui.R;
import com.obric.oui.animation.easy.ViewPropertySpringAnimator;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.common.util.ResourceUtils;
import com.obric.oui.dialog.anim.DialogAnimStyle;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import com.obric.oui.dialog.v2.alert.style.DialogContainer;
import com.obric.oui.dialog.v2.alert.style.StyleController;
import com.obric.oui.utils.KtExt;
import com.obric.oui.utils.log.L;
import com.obric.oui.window.OWindowConfigController;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: OAlertDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0006\u0010\u001b\u001a\u00020\u001aJ\b\u0010\u001c\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u000bH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u000bH\u0016J\b\u0010!\u001a\u00020\u000bH\u0016J\b\u0010\"\u001a\u00020\u001fH\u0002J\n\u0010#\u001a\u0004\u0018\u00010$H\u0014J\b\u0010%\u001a\u00020\u001fH\u0002J\b\u0010&\u001a\u00020\u000bH\u0016J\b\u0010'\u001a\u00020\u001fH\u0016J\b\u0010(\u001a\u0004\u0018\u00010)J\b\u0010*\u001a\u00020\u001fH\u0002J\b\u0010+\u001a\u0004\u0018\u00010\u0016J\b\u0010,\u001a\u0004\u0018\u00010$J\b\u0010-\u001a\u0004\u0018\u00010$J\b\u0010.\u001a\u0004\u0018\u00010$J\b\u0010/\u001a\u0004\u0018\u00010)J\b\u00100\u001a\u00020\u001fH\u0002J\b\u00101\u001a\u0004\u0018\u00010\u0016J\u0012\u00102\u001a\u00020\u001a2\b\u00103\u001a\u0004\u0018\u000104H\u0014J\b\u00105\u001a\u00020\u001aH\u0014J\u0006\u00106\u001a\u00020\u001aJ\b\u00107\u001a\u00020\u001aH\u0016J\b\u00108\u001a\u00020\u001aH\u0016J\u000e\u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\u000eJ\u000e\u0010;\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\u000eJ\u0018\u0010<\u001a\u00020\u001a2\u0006\u0010=\u001a\u00020)2\b\b\u0002\u0010>\u001a\u00020\u0006J\u0010\u0010?\u001a\u00020\u001a2\b\u0010@\u001a\u0004\u0018\u00010)J\u0010\u0010A\u001a\u00020\u001a2\b\u0010@\u001a\u0004\u0018\u00010)J\u000e\u0010B\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\u000eJ\b\u0010C\u001a\u00020\u001aH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/obric/oui/dialog/v2/alert/OAlertDialog;", "Lcom/obric/oui/dialog/base/AbstractDialog;", "Lcom/obric/oui/dialog/v2/alert/style/DialogContainer;", "context", "Landroid/content/Context;", "withHeightMatchParent", "", "(Landroid/content/Context;Z)V", "TAG", "", "bannderPanel", "Landroid/widget/FrameLayout;", "bodyPanel", "bodyStyleController", "Lcom/obric/oui/dialog/v2/alert/style/StyleController;", "buttonPanel", "buttonStyleController", "headerPanel", "Landroid/view/ViewGroup;", "iconPanel", "messageMoreThanTwoLines", "messageTextView", "Landroid/widget/TextView;", "titleTextView", "topImageStyleController", "adjustContentHeight", "", "allowMoreThanTwoLinesMessage", "dismiss", "getBannerSlot", "getBodyMarginSpace", "", "getBodySlot", "getButtonSlot", "getButtonVerticalSpace", "getHeightChangeAnimContainer", "Landroid/view/View;", "getIconPanelVerticalSpace", "getIconSlot", "getLayout", "getMessageStr", "", "getMessageVerticalSpace", "getMessageView", "getNegativeButton", "getNeutralButton", "getPositiveButton", "getTitleStr", "getTitleVerticalSpace", "getTitleView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "originDismiss", "performEnterAnimation", "performExitAnimation", "setBodyStyleController", "controller", "setButtonStyleController", "setMessage", "message", "moreThanTwoLines", "setOnlyTitleText", "title", "setTitleText", "setTopImageStyleController", "show", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OAlertDialog extends AbstractDialog implements DialogContainer {
    private final String TAG;
    private final FrameLayout bannderPanel;
    private final FrameLayout bodyPanel;
    private StyleController bodyStyleController;
    private final FrameLayout buttonPanel;
    private StyleController buttonStyleController;
    private final ViewGroup headerPanel;
    private final FrameLayout iconPanel;
    private boolean messageMoreThanTwoLines;
    private TextView messageTextView;
    private TextView titleTextView;
    private StyleController topImageStyleController;

    /* JADX INFO: renamed from: $r8$lambda$gAGq4ydqJ7-4XhQMQEZB3exC1Kg, reason: not valid java name */
    public static /* synthetic */ void m470$r8$lambda$gAGq4ydqJ74XhQMQEZB3exC1Kg(OAlertDialog r0) {
        m472onStart$lambda8(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$m15tSjQ3aBtWi9ge3PF-cZjRfzo, reason: not valid java name */
    public static /* synthetic */ void m471$r8$lambda$m15tSjQ3aBtWi9ge3PFcZjRfzo(OAlertDialog r0) {
        m473performEnterAnimation$lambda10(r0);
    }

    public /* synthetic */ OAlertDialog(Context r1, boolean r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        this(r1, r2);
    }

    public OAlertDialog(Context r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, false, r3);
        this.TAG = "OAlertDialog";
        View r4 = findViewById(R.id.bannerPanel);
        Intrinsics.checkNotNullExpressionValue(r4, "findViewById(R.id.bannerPanel)");
        this.bannderPanel = (FrameLayout) r4;
        View r5 = findViewById(R.id.iconPanel);
        Intrinsics.checkNotNullExpressionValue(r5, "findViewById(R.id.iconPanel)");
        this.iconPanel = (FrameLayout) r5;
        View r6 = findViewById(R.id.header_container);
        Intrinsics.checkNotNullExpressionValue(r6, "findViewById(R.id.header_container)");
        this.headerPanel = (ViewGroup) r6;
        TextView r7 = (TextView) findViewById(R.id.textTitle);
        this.titleTextView = r7;
        if (r7 == null) goto L6;
        r7.setIncludeFontPadding(true);
    L6:
        TextView r8 = (TextView) findViewById(R.id.textSubTitle);
        this.messageTextView = r8;
        if (r8 == null) goto L10;
        r8.setIncludeFontPadding(true);
    L10:
        View r9 = findViewById(R.id.button_container);
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(R.id.button_container)");
        this.buttonPanel = (FrameLayout) r9;
        View r10 = findViewById(R.id.body_container);
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById(R.id.body_container)");
        this.bodyPanel = (FrameLayout) r10;
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog
    public int getLayout() {
        return R.layout.o_alert_dialog_v2;
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog
    protected View getHeightChangeAnimContainer() {
        return this.headerPanel;
    }

    public final void setTopImageStyleController(StyleController r3) {
        Intrinsics.checkNotNullParameter(r3, "controller");
        this.topImageStyleController = r3;
        Context r0 = getContext();
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        r3.attachToParent(r0, this);
    }

    public final void setTitleText(CharSequence r6) {
        boolean r0 = TextUtils.isEmpty(r6);
        TextView r1 = this.titleTextView;
        int r3 = 0;
        if (r1 == null) goto L9;
        if (r0 == false) goto L7;
        int r4 = 8;
    L8:
        r1.setVisibility(r4);
        r1.setText(r6);
        r1.setPadding(0, 0, 0, 0);
        goto L9
    L7:
        r4 = 0;
    L9:
        TextView r5 = this.messageTextView;
        if (r5 == null) goto L22;
        ViewGroup.LayoutParams r7 = r5.getLayoutParams();
        if (r7 == null) goto L21;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7;
        if (r0 == true) goto L18;
        r3 = OUnitExtensionKt.vdp(r5, 8);
    L18:
        r8.topMargin = r3;
        return;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void setOnlyTitleText(CharSequence r4) {
        if (r4 == null) goto L9;
        TextView r3 = this.titleTextView;
        if (r3 == null) goto L10;
        r3.setVisibility(0);
        r3.setText(r4);
        TextView r5 = r3;
        r3.setPadding(0, OUnitExtensionKt.vdp(r5, 19), 0, OUnitExtensionKt.vdp(r5, 19));
        return;
    L10:
        return;
    }

    public static /* synthetic */ void setMessage$default(OAlertDialog r0, CharSequence r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        r0.setMessage(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMessage");
    }

    public final void setMessage(CharSequence r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        TextView r4 = this.messageTextView;
        if (r4 == null) goto L6;
        r4.setVisibility(0);
        r4.setText(r2);
    L6:
        TextView r1 = this.messageTextView;
        if (r1 == null) goto L11;
        r1.setMaxLines(Integer.MAX_VALUE);
        return;
    }

    public final void allowMoreThanTwoLinesMessage() {
        TextView r1 = this.messageTextView;
        if (r1 == null) goto L7;
        r1.setMaxLines(Integer.MAX_VALUE);
        return;
    }

    public final void setButtonStyleController(StyleController r3) {
        Intrinsics.checkNotNullParameter(r3, "controller");
        this.buttonStyleController = r3;
        Context r0 = getContext();
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        r3.attachToParent(r0, this);
    }

    public final void setBodyStyleController(StyleController r4) {
        Intrinsics.checkNotNullParameter(r4, "controller");
        this.bodyStyleController = r4;
        FrameLayout r0 = this.bodyPanel;
        if (getMatchParentHeight() == false) goto L5;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        r1.height = 0;
        r0.setLayoutParams(r1);
    L5:
        r0.setVisibility(0);
        Context r2 = getContext();
        Intrinsics.checkNotNullExpressionValue(r2, "context");
        r4.attachToParent(r2, this);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle r3) {
        if (getHideFirstFrame() == false) goto L5;
        getRootView().setAlpha(0.0f);
    L5:
        super.onCreate(r3);
        StyleController r4 = this.topImageStyleController;
        if (r4 == null) goto L9;
        r4.attachToDialog(this);
    L9:
        StyleController r5 = this.buttonStyleController;
        if (r5 == null) goto L13;
        r5.attachToDialog(this);
    L13:
        StyleController r6 = this.bodyStyleController;
        if (r6 == null) goto L18;
        r6.attachToDialog(this);
        return;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        performEnterAnimation();
        TextView r0 = this.messageTextView;
        if (r0 == null) goto L7;
        r0.postDelayed(new OAlertDialog$$ExternalSyntheticLambda1(this), 1000);
        return;
    }

    /* JADX INFO: renamed from: onStart$lambda-8, reason: not valid java name */
    private static final void m472onStart$lambda8(OAlertDialog r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        TextView r0 = r1.messageTextView;
        if (r0 == null) goto L9;
        Layout r2 = r0.getLayout();
        if (r2 == null) goto L9;
        r2.getLineCount();
    L9:
        TextView r3 = r1.messageTextView;
        if (r3 == null) goto L14;
        r3.getMaxLines();
        return;
    }

    public void performExitAnimation() {
        ViewPropertySpringAnimator r0 = DialogAnimStyle.dialogBottomHide$default(DialogAnimStyle.INSTANCE, getRootView(), getWindow(), !getAdaptWindowDim(), false, 4, null);
        ViewPropertySpringAnimator.setListener$default(r0, null, new OAlertDialog$performExitAnimation$1$1(this), new OAlertDialog$performExitAnimation$1$2(this), 1, null);
        r0.start();
    }

    public void performEnterAnimation() {
        getRootView().post(new OAlertDialog$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: renamed from: performEnterAnimation$lambda-10, reason: not valid java name */
    private static final void m473performEnterAnimation$lambda10(final OAlertDialog r9) {
        Intrinsics.checkNotNullParameter(r9, "this$0");
        DialogAnimStyle r1 = DialogAnimStyle.INSTANCE;
        View r2 = r9.getRootView();
        Window r3 = r9.getWindow();
        boolean r4 = !r9.getAdaptWindowDim();
        Context r0 = r9.getContext();
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        ViewPropertySpringAnimator r5 = DialogAnimStyle.dialogBottomShow$default(r1, r2, r3, r4, r9.getTargetWindowDimAmount(r0), false, 8, null).start();
        if (r9.getHideFirstFrame() == false) goto L5;
        r5.setListener(new OAlertDialog$performEnterAnimation$1$1(r9), new OAlertDialog$performEnterAnimation$1$2(r9), new OAlertDialog$performEnterAnimation$1$3(r9));
        return;
    L5:
        ViewPropertySpringAnimator.setListener$default(r5, null, new OAlertDialog$performEnterAnimation$1$4(r9), new OAlertDialog$performEnterAnimation$1$5(r9), 1, null);
    }

    public final void originDismiss() {
        super.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("OAlertDialog", "origin Dismiss exception!", e);
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        performExitAnimation();
    }

    public final CharSequence getTitleStr() {
        TextView r0 = this.titleTextView;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getText();
    }

    public final CharSequence getMessageStr() {
        TextView r0 = this.messageTextView;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getText();
    }

    public final TextView getTitleView() {
        return this.titleTextView;
    }

    public final TextView getMessageView() {
        return this.messageTextView;
    }

    public final View getPositiveButton() {
        KtExt r0 = KtExt.INSTANCE;
        StyleController r2 = this.buttonStyleController;
        if (r2 != null) goto L6;
    L4:
        r2 = null;
    L7:
        ButtonStyleController r3 = (ButtonStyleController) r2;
        if (r3 != null) goto L11;
        return null;
    L11:
        return r3.getPositiveButton();
    L6:
        if ((r2 instanceof ButtonStyleController) == false) goto L4;
        goto L4
    }

    public final View getNegativeButton() {
        KtExt r0 = KtExt.INSTANCE;
        StyleController r2 = this.buttonStyleController;
        if (r2 != null) goto L6;
    L4:
        r2 = null;
    L7:
        ButtonStyleController r3 = (ButtonStyleController) r2;
        if (r3 != null) goto L11;
        return null;
    L11:
        return r3.getNegativeButton();
    L6:
        if ((r2 instanceof ButtonStyleController) == false) goto L4;
        goto L4
    }

    public final View getNeutralButton() {
        KtExt r0 = KtExt.INSTANCE;
        StyleController r2 = this.buttonStyleController;
        if (r2 != null) goto L6;
    L4:
        r2 = null;
    L7:
        ButtonStyleController r3 = (ButtonStyleController) r2;
        if (r3 != null) goto L11;
        return null;
    L11:
        return r3.getNeutralButton();
    L6:
        if ((r2 instanceof ButtonStyleController) == false) goto L4;
        goto L4
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog, android.app.Dialog
    public void show() {
        super.show();
        Context r0 = getContext();
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        adjustContentHeight(r0);
    }

    private final void adjustContentHeight(Context r14) {
        FrameLayout r2 = this.bodyPanel;
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.getVisibility() == 0) goto L8;
        return;
    L8:
        if (ResourceUtils.INSTANCE.isLandscape(r14) == false) goto L25;
        int r3 = OWindowConfigController.INSTANCE.getNavigationBarHeight(r14);     // Catch: Exception -> L19
        if (getWidthMatch() == false) goto L12;
        r3 = r3 - OUnitExtensionKt.cdp(r14, 16);     // Catch: Exception -> L19
    L12:
        int r4 = getIconPanelVerticalSpace();     // Catch: Exception -> L19
        int r5 = getTitleVerticalSpace();     // Catch: Exception -> L19
        int r6 = getMessageVerticalSpace();     // Catch: Exception -> L19
        int r7 = getButtonVerticalSpace();     // Catch: Exception -> L19
        int r8 = getBodyMarginSpace();     // Catch: Exception -> L19
        int r9 = OUnitExtensionKt.getScreenHeight(r14);     // Catch: Exception -> L19
        int r10 = OUnitExtensionKt.cdp(r14, 300);     // Catch: Exception -> L19
        int r11 = OUnitExtensionKt.cdp(r14, AbstractDialog.HORIZONTAL_MAX_WIDTH);     // Catch: Exception -> L19
        int r12 = OUnitExtensionKt.cdp(r14, AbstractDialog.HORIZONTAL_TOP_SYSBAR_HEIGHT);     // Catch: Exception -> L19
        if (r9 <= r10) goto L15;
        r10 = r9 - r12;     // Catch: Exception -> L19
    L15:
        int r13 = (((((r10 - r3) - r4) - r5) - r6) - r7) - r8;     // Catch: Exception -> L19
        int r15 = RangesKt.coerceIn(r13, 0, r10 - OUnitExtensionKt.cdp(r14, 52));     // Catch: Exception -> L19
        r2.measure(View.MeasureSpec.makeMeasureSpec(r11, Integer.MIN_VALUE), 0);     // Catch: Exception -> L19
        int r16 = r2.getMeasuredHeight();     // Catch: Exception -> L19
        L.d(this.TAG, "adjustContentHeight, maxHeight: " + r10 + ", HORIZONTAL_MAX_HEIGHT: 300, availableHeight: " + r13 + ", measured BodyHeight: " + r16 + ", maxBodyHeight: " + r15 + ", iconPanelVerticalSpace: " + r4 + ", titleVerticalSpace: " + r5 + ", messageVerticalSpace: " + r6 + ", buttonVerticalSpace: " + r7 + ", bodyMarginSpace: " + r8);     // Catch: Exception -> L19
        if (r16 <= r15) goto L26;
        L.i(this.TAG, "adjustContentHeight, from: " + r16 + " to: " + r15);     // Catch: Exception -> L19
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();     // Catch: Exception -> L19
        r0.height = r15;     // Catch: Exception -> L19
        r2.setLayoutParams(r0);     // Catch: Exception -> L19
        return;
    L26:
        return;
    L19:
        e = move-exception;
        L.e(this.TAG, "adjustContentHeight error", e);
        return;
    }

    private final int getIconPanelVerticalSpace() {
        FrameLayout r0 = this.iconPanel;
        int r1 = 0;
        if (r0 != null) goto L5;
        return 0;
    L5:
        r0.measure(0, 0);
        if (this.iconPanel.getVisibility() != 0) goto L8;
        int r2 = this.iconPanel.getMeasuredHeight();
    L9:
        KtExt r3 = KtExt.INSTANCE;
        ViewGroup.LayoutParams r4 = this.iconPanel.getLayoutParams();
        if (r4 != null) goto L13;
    L11:
        r4 = null;
    L14:
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
        if (r5 == null) goto L19;
        r1 = r5.topMargin;
    L19:
        return r2 + r1;
    L13:
        if ((r4 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
    L8:
        r2 = 0;
        goto L9
    }

    private final int getTitleVerticalSpace() {
        TextView r0 = this.titleTextView;
        int r1 = 0;
        if (r0 != null) goto L5;
        return 0;
    L5:
        Intrinsics.checkNotNull(r0);
        r0.measure(0, 0);
        TextView r2 = this.titleTextView;
        Intrinsics.checkNotNull(r2);
        if (r2.getVisibility() != 0) goto L8;
        TextView r3 = this.titleTextView;
        Intrinsics.checkNotNull(r3);
        int r4 = r3.getMeasuredHeight();
    L9:
        KtExt r5 = KtExt.INSTANCE;
        TextView r6 = this.titleTextView;
        Intrinsics.checkNotNull(r6);
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (r7 != null) goto L13;
    L11:
        r7 = null;
    L14:
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7;
        if (r8 == null) goto L19;
        r1 = r8.topMargin;
    L19:
        return r4 + r1;
    L13:
        if ((r7 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
    L8:
        r4 = 0;
        goto L9
    }

    private final int getMessageVerticalSpace() {
        TextView r0 = this.messageTextView;
        int r1 = 0;
        if (r0 != null) goto L5;
        return 0;
    L5:
        Intrinsics.checkNotNull(r0);
        r0.measure(0, 0);
        TextView r2 = this.messageTextView;
        Intrinsics.checkNotNull(r2);
        if (r2.getVisibility() != 0) goto L8;
        TextView r3 = this.messageTextView;
        Intrinsics.checkNotNull(r3);
        int r4 = r3.getMeasuredHeight();
    L9:
        KtExt r5 = KtExt.INSTANCE;
        TextView r6 = this.messageTextView;
        Intrinsics.checkNotNull(r6);
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (r7 != null) goto L13;
    L11:
        r7 = null;
    L14:
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7;
        if (r8 == null) goto L19;
        r1 = r8.topMargin;
    L19:
        return r4 + r1;
    L13:
        if ((r7 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
    L8:
        r4 = 0;
        goto L9
    }

    private final int getButtonVerticalSpace() {
        FrameLayout r0 = this.buttonPanel;
        int r1 = 0;
        if (r0 != null) goto L5;
        return 0;
    L5:
        r0.measure(0, 0);
        if (this.buttonPanel.getVisibility() != 0) goto L8;
        int r2 = this.buttonPanel.getMeasuredHeight();
    L9:
        KtExt r3 = KtExt.INSTANCE;
        ViewGroup.LayoutParams r4 = this.buttonPanel.getLayoutParams();
        if (r4 != null) goto L13;
    L11:
        r4 = null;
    L14:
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
        if (r5 == null) goto L19;
        r1 = r5.topMargin;
    L19:
        return r2 + r1;
    L13:
        if ((r4 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
    L8:
        r2 = 0;
        goto L9
    }

    private final int getBodyMarginSpace() {
        if (this.bodyPanel != null) goto L5;
        return 0;
    L5:
        KtExt r0 = KtExt.INSTANCE;
        ViewGroup.LayoutParams r3 = this.bodyPanel.getLayoutParams();
        if (r3 != null) goto L9;
    L7:
        r3 = null;
    L10:
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r3;
        if (r4 != null) goto L14;
        return 0;
    L14:
        return r4.topMargin;
    L9:
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        goto L7
    }

    @Override // com.obric.oui.dialog.v2.alert.style.DialogContainer
    public FrameLayout getBannerSlot() {
        return this.bannderPanel;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.DialogContainer
    public FrameLayout getIconSlot() {
        return this.iconPanel;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.DialogContainer
    public FrameLayout getBodySlot() {
        return this.bodyPanel;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.DialogContainer
    public FrameLayout getButtonSlot() {
        return this.buttonPanel;
    }
}
