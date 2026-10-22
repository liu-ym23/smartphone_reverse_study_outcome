package com.bytedance.android.ui.ec.widget.popup;

import android.animation.AnimatorSet;
import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;

/* JADX INFO: loaded from: classes14.dex */
public class BubblePopupWindow extends PopupWindow {
    private final Activity activity;
    protected BubbleLayout bubbleView;
    private Runnable dismissListener;
    private long inAnimTime;
    private boolean isHideVirtualKey;
    private OnClickBubbleListener listener;
    public long mAutoDismissDelayMillis;
    private int mBgColor;
    private int mBubbleOffset;
    private final Runnable mDismissRunnable;
    private int mGravity;
    private boolean mIsAlreadyDismiss;
    private boolean mNeedOverShoot;
    private boolean mNeedPath;
    private boolean mNeedPressFade;
    private boolean mShowInAnim;
    private boolean mShowOutAnim;
    private TextView mTextView;
    private int mXOffset;
    private int mYOffset;
    private long outAnimTime;
    private AnimatorSet set;

    public interface OnClickBubbleListener {
        void clickBubble();
    }

    public static /* synthetic */ void a(BubblePopupWindow r100, View r101) {
        r100.lambda$setBubbleView$0(r101);
    }

    public static /* synthetic */ void access$001(PopupWindow r100) {
        super.dismiss();
    }

    public static /* synthetic */ void access$002(PopupWindow r100, View r101, int r102, int r103, int r104) {
        super.showAsDropDown(r101, r102, r103, r104);
    }

    public static /* synthetic */ void access$003(PopupWindow r100, View r101, int r102, int r103, int r104) {
        super.showAtLocation(r101, r102, r103, r104);
    }

    public int getOrientation(int r100) {
        if (r100 != 3) goto L5;
        return 2;
    L5:
        if (r100 != 48) goto L7;
        return 3;
    L7:
        if (r100 == 80) goto L9;
        return 1;
    L9:
        return 0;
    }

    private void defaultView() {
        TextView r100 = new TextView(this.activity);
        this.mTextView = r100;
        r100.setTextColor(ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT));
        this.mTextView.setTextSize(13.0f);
        this.mTextView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.mTextView.setMaxLines(2);
        this.mTextView.setGravity(17);
        setBubbleView(this.mTextView, Boolean.FALSE);
        this.isHideVirtualKey = true;
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    private void hideStatusBar() {
        if (this.isHideVirtualKey == true) goto L5;
        return;
    L5:
        getContentView().setSystemUiVisibility(4102);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (this.mIsAlreadyDismiss == true) goto L12;
        animatorEasyInOut(false, this.mGravity);
        getContentView().removeCallbacks(this.mDismissRunnable);
        this.mXOffset = 0;
        this.mYOffset = 0;
        BubbleLayout r100 = this.bubbleView;
        if (r100 == null) goto L8;
        r100.removeAllViews();
    L8:
        if (isShowing() == false) goto L12;
        INVOKESPECIAL_com_bytedance_android_ui_ec_widget_popup_BubblePopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_dismiss(this);     // Catch: Exception -> L11
    L12:
        Runnable r101 = this.dismissListener;
        if (r101 == null) goto L18;
        r101.run();
        return;
    }

    public int getHeightWithArrow() {
        BubbleLayout r100 = this.bubbleView;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getHeightWithArrow();
    }

    public void onDestroy() {
        AnimatorSet r100 = this.set;
        if (r100 == null) goto L6;
        r100.removeAllListeners();
        this.set.cancel();
        this.set = null;
    L6:
        if (this.activity.isFinishing() == false) goto L8;
        return;
    L8:
        if (isShowing() == false) goto L16;
        INVOKESPECIAL_com_bytedance_android_ui_ec_widget_popup_BubblePopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_dismiss(this);     // Catch: Exception -> L12
        return;
    L17:
        return;
    }

    public long getInAnimTime() {
        return this.inAnimTime;
    }

    public BubblePopupWindow(Activity r100) {
        this(r100, true, false);
    }

    public static void INVOKESPECIAL_com_bytedance_android_ui_ec_widget_popup_BubblePopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_dismiss(PopupWindow r100) {
        PopupWindowLancet.handleDismissBeforeOrigin(r100);
        access$001(r100);
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_popup_BubblePopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_dismiss(BubblePopupWindow r100) {
        PopupWindowLancet.handleDismissBeforeOrigin(r100);
        r100.dismiss();
    }

    public static /* synthetic */ int access$000(BubblePopupWindow r100) {
        return r100.mGravity;
    }

    public static /* synthetic */ AnimatorSet access$200(BubblePopupWindow r100) {
        return r100.set;
    }

    public static /* synthetic */ long access$300(BubblePopupWindow r100) {
        return r100.inAnimTime;
    }

    public static /* synthetic */ long access$400(BubblePopupWindow r100) {
        return r100.outAnimTime;
    }

    public static /* synthetic */ boolean access$500(BubblePopupWindow r100) {
        return r100.mNeedOverShoot;
    }

    private /* synthetic */ void lambda$setBubbleView$0(View r100) {
        OnClickBubbleListener r101 = this.listener;
        if (r101 == null) goto L5;
        r101.clickBubble();
    L5:
        INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_popup_BubblePopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_dismiss(this);
    }

    private void setBubbleOffset(int r100) {
        this.mBubbleOffset = r100;
    }

    public void setArrowLongSize(int r100) {
        BubbleLayout r101 = this.bubbleView;
        if (r101 == null) goto L6;
        r101.setArrowLongSize(r100);
        return;
    }

    public void setArrowVerticalSize(int r100) {
        BubbleLayout r101 = this.bubbleView;
        if (r101 == null) goto L6;
        r101.setArrowVerticalSize(r100);
        return;
    }

    public void setAutoDismissDelayMillis(long r100) {
        this.mAutoDismissDelayMillis = r100;
    }

    public void setBgColor(int r100) {
        this.mBgColor = r100;
        BubbleLayout r101 = this.bubbleView;
        if (r101 == null) goto L6;
        r101.setBgColor(r100);
        return;
    }

    public void setHorizontalPadding(int r100) {
        BubbleLayout r101 = this.bubbleView;
        if (r101 == null) goto L6;
        r101.setHorizontalPadding(r100);
        return;
    }

    public void setInAnimTime(long r100) {
        this.inAnimTime = r100;
    }

    public void setNeedPath(boolean r100) {
        this.mNeedPath = r100;
        BubbleLayout r101 = this.bubbleView;
        if (r101 == null) goto L6;
        r101.setNeedPath(r100);
        return;
    }

    public void setOutAnimTime(long r100) {
        this.outAnimTime = r100;
    }

    public void setShadowLayerColor(int r100) {
        BubbleLayout r101 = this.bubbleView;
        if (r101 == null) goto L6;
        r101.setShadowLayerColor(r100);
        return;
    }

    public void setShadowLayerYOffset(int r100) {
        BubbleLayout r101 = this.bubbleView;
        if (r101 == null) goto L6;
        r101.setShadowLayerYOffset(r100);
        return;
    }

    public void setShowOutAnim(boolean r100) {
        this.mShowOutAnim = r100;
    }

    public void setXOffset(int r100) {
        this.mXOffset = r100;
    }

    public void setYOffset(int r100) {
        this.mYOffset = r100;
    }

    public void show(View r100) {
        show(r100, 80, true);
    }

    private void animatorEasyInOut(final boolean r100, final int r101) {
        final BubbleLayout r102 = this.bubbleView;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r100 == true) goto L7;
    L10:
        if (r100 == false) goto L12;
    L15:
        if (r100 == true) goto L17;
        this.mIsAlreadyDismiss = true;
    L17:
        AnimatorSet r103 = this.set;
        if (r103 != null) goto L20;
        this.set = new AnimatorSet();
    L21:
        r102.post(new AnonymousClass2(this, r101, r102, r100));
        return;
    L20:
        r103.removeAllListeners();
        this.set.cancel();
        goto L21
    L12:
        if (this.mShowOutAnim == true) goto L15;
        r102.setVisibility(8);
        return;
    L7:
        if (this.mShowInAnim == true) goto L10;
        r102.setVisibility(0);
    }

    public void setBubbleView(View r100, Boolean r101) {
        BubbleLayout r102 = new BubbleLayout(this.activity, r101);
        this.bubbleView = r102;
        r102.setBackgroundColor(0);
        this.bubbleView.removeAllViews();
        this.bubbleView.addView(r100);
        this.bubbleView.setGravity(17);
        ViewGroup.LayoutParams r103 = new ViewGroup.LayoutParams(-2, -2);
        this.bubbleView.setLayoutParams(r103);
        this.bubbleView.setVisibility(8);
        int r104 = this.mBgColor;
        if (r104 == 0) goto L5;
        this.bubbleView.setBgColor(r104);
    L5:
        this.bubbleView.setNeedPath(this.mNeedPath);
        this.bubbleView.setNeedPressFade(this.mNeedPressFade);
        this.bubbleView.setOnClickListener(new c(this));
        setContentView(this.bubbleView);
    }

    public BubblePopupWindow(Activity r100, boolean r101, boolean r102) {
        super(r100);
        this.mBubbleOffset = 0;
        this.mShowInAnim = true;
        this.mShowOutAnim = true;
        this.mNeedPath = true;
        this.mAutoDismissDelayMillis = 7000;
        this.mDismissRunnable = new AnonymousClass1(this);
        this.inAnimTime = 800;
        this.outAnimTime = 200;
        this.activity = r100;
        setWidth(-2);
        setHeight(-2);
        setFocusable(false);
        setOutsideTouchable(false);
        setClippingEnabled(false);
        setBackgroundDrawable(new ColorDrawable(0));
        setInputMethodMode(1);
        setSoftInputMode(16);
        if (r101 == false) goto L6;
        defaultView();
        return;
    }

    public static /* synthetic */ void access$100(BubblePopupWindow r100, boolean r101, int r102) {
        r100.animatorEasyInOut(r101, r102);
    }

    public void show(View r110, int r111, boolean r112) {
        if (this.activity.isFinishing() == true) goto L59;
        if (r110 != null) goto L6;
        return;
    L6:
        if (r110.getWindowToken() == null) goto L62;
        getContentView().removeCallbacks(this.mDismissRunnable);
        this.mGravity = r111;
        if (isShowing() == true) goto L57;
        int r100 = getOrientation(r111);
        getContentView().measure(0, 0);
        if (r112 == false) goto L21;
        BubbleLayout r101 = this.bubbleView;
        if (r101 == null) goto L15;
        int r102 = r101.getHorizontalPadding();
    L16:
        if (r111 == 80) goto L20;
        if (r111 == 48) goto L20;
        int r103 = (getContentView().getMeasuredHeight() + (r102 * 2)) / 2;
    L22:
        BubbleLayout r104 = this.bubbleView;
        if (r104 == null) goto L25;
        r104.setBubbleParams(r100, r103 + this.mBubbleOffset);
    L25:
        int[] r105 = new int[2];
        r110.getLocationInWindow(r105);
        int r106 = getContentView().getHeight();
        if (r106 != 0) goto L30;
        BubbleLayout r107 = this.bubbleView;
        if (r107 == null) goto L30;
        r106 = r107.getHeightWithArrow();
    L30:
        int r108 = getContentView().getMeasuredWidth() + (this.bubbleView.getHorizontalPadding() * 2);
        if (r111 != 3) goto L33;
        if (r112 == false) goto L51;
        int r113 = (r110.getMeasuredHeight() - r106) / 2;
    L52:
        INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_popup_BubblePopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAtLocation(this, r110, 0, (r105[0] + this.mXOffset) - r108, (r105[1] + this.mYOffset) + r113);
        animatorEasyInOut(true, r111);
    L53:
        this.mIsAlreadyDismiss = false;
        if (this.mAutoDismissDelayMillis <= 0) goto L56;
        getContentView().postDelayed(this.mDismissRunnable, this.mAutoDismissDelayMillis);
    L56:
        hideStatusBar();
        return;
    L51:
        r113 = 0;
        goto L52
    L33:
        if (r111 == 5) goto L45;
        if (r111 == 48) goto L41;
        if (r111 != 80) goto L53;
        if (r112 == false) goto L39;
        int r114 = (r110.getMeasuredWidth() - r108) / 2;
    L40:
        INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_popup_BubblePopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAsDropDown(this, r110, this.mXOffset + r114, this.mYOffset);
        animatorEasyInOut(true, r111);
        goto L53
    L39:
        r114 = 0;
        goto L40
    L41:
        if (r112 == false) goto L43;
        int r115 = (r110.getMeasuredWidth() - r108) / 2;
    L44:
        INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_popup_BubblePopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAtLocation(this, r110, 0, (r105[0] + this.mXOffset) + r115, (r105[1] - r106) + this.mYOffset);
        animatorEasyInOut(true, r111);
        goto L53
    L43:
        r115 = 0;
        goto L44
    L45:
        if (r112 == false) goto L47;
        int r116 = (r110.getMeasuredHeight() - r106) / 2;
    L48:
        INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_popup_BubblePopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAtLocation(this, r110, 0, (r105[0] + this.mXOffset) + r110.getWidth(), (r105[1] + this.mYOffset) + r116);
        animatorEasyInOut(true, r111);
        goto L53
    L47:
        r116 = 0;
    L20:
        r103 = (getContentView().getMeasuredWidth() + (r102 * 2)) / 2;
        goto L22
    L15:
        r102 = 0;
        goto L16
    L21:
        r103 = 0;
        goto L22
    L57:
        INVOKESPECIAL_com_bytedance_android_ui_ec_widget_popup_BubblePopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_dismiss(this);
        return;
    L62:
        return;
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_popup_BubblePopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAsDropDown(BubblePopupWindow r100, View r101, int r102, int r103) {
        OverlaySource r104 = PopupWindowLancet.resolveSource(r101);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r100, r101, r104) == false) goto L5;
        return;
    L5:
        r100.showAsDropDown(r101, r102, r103);
        PopupWindowLancet.trackAfterShow(r100, r104, r101);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View r100, int r101, int r102, int r103) {
        INVOKESPECIAL_com_bytedance_android_ui_ec_widget_popup_BubblePopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAsDropDown(this, r100, r101, r102, r103);     // Catch: Exception -> L4
        return;
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View r100, int r101, int r102, int r103) {
        INVOKESPECIAL_com_bytedance_android_ui_ec_widget_popup_BubblePopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAtLocation(this, r100, r101, r102, r103);     // Catch: Exception -> L4
        return;
    }

    public static void INVOKESPECIAL_com_bytedance_android_ui_ec_widget_popup_BubblePopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAsDropDown(PopupWindow r100, View r101, int r102, int r103, int r104) {
        OverlaySource r105 = PopupWindowLancet.resolveSource(r101);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r100, r101, r105) == false) goto L5;
        return;
    L5:
        access$002(r100, r101, r102, r103, r104);
        PopupWindowLancet.trackAfterShow(r100, r105, r101);
    }

    public static void INVOKESPECIAL_com_bytedance_android_ui_ec_widget_popup_BubblePopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAtLocation(PopupWindow r100, View r101, int r102, int r110, int r111) {
        if (PopupWindowLancet.hasSubWindowToken(r101) == false) goto L6;
        return;
    L6:
        if ((r100 instanceof PopupWindow) == true) goto L8;
    L11:
        OverlaySource r103 = PopupWindowLancet.resolveSource(r101);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r100, r101, r103, r102, r110, r111) == false) goto L14;
        return;
    L14:
        access$003(r100, r101, r102, r110, r111);
        PopupWindowLancet.trackAfterShow(r100, r103, r101);
        return;
    L8:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r100) == false) goto L11;
        access$003(r100, r101, r102, r110, r111);
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_popup_BubblePopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAtLocation(BubblePopupWindow r100, View r101, int r102, int r110, int r111) {
        if (PopupWindowLancet.hasSubWindowToken(r101) == false) goto L6;
        return;
    L6:
        if ((r100 instanceof PopupWindow) == true) goto L8;
    L11:
        OverlaySource r103 = PopupWindowLancet.resolveSource(r101);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r100, r101, r103, r102, r110, r111) == false) goto L14;
        return;
    L14:
        r100.showAtLocation(r101, r102, r110, r111);
        PopupWindowLancet.trackAfterShow(r100, r103, r101);
        return;
    L8:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r100) == false) goto L11;
        r100.showAtLocation(r101, r102, r110, r111);
    }

    public void show(View r100, int r101, int r102, int r103, int r104) {
        setXOffset(r102);
        setYOffset(r103);
        setBubbleOffset(r101);
        show(r100, r104, true);
    }
}
