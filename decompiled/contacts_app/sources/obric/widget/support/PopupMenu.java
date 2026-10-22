package obric.widget.support;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import obric.InvokeApi;
import obric.widget.R;

/* JADX INFO: loaded from: classes5.dex */
public abstract class PopupMenu {
    public static final int DIRECTION_BOTTOM = 1;
    public static final int DIRECTION_LEFT = 2;
    public static final int DIRECTION_RIGHT = 3;
    public static final int DIRECTION_TOP = 0;
    protected View mAnchorView;
    private int mArrowHeight;
    private boolean mArrowVisible;
    private int mArrowWidth;
    private boolean mAutoAdjustPopupDirection;
    protected int mBgLeftRightShadowWidth;
    protected int mBgTopBottomShadowHeight;
    private boolean mClipToScreen;
    protected int mContentAreaWidth;
    protected Context mContext;
    private PopupWindow.OnDismissListener mDismissListener;
    private int mMenuPanelBgRoundCornerRadius;
    protected View mMenuPanelView;
    private boolean mMenuPopup;
    private int mMinDistance;
    protected PopupWindow mPopupWindow;
    private boolean mRequestFocusable;
    private int mScreenHeight;
    private int mScreenWidth;
    private boolean mShowAboveAnchor;

    protected void onArrowViewInflated(ImageView arrowView) {
    }

    protected abstract void prepareShow();

    public PopupMenu(Context context) {
        this.mRequestFocusable = true;
        this.mArrowVisible = false;
        this.mClipToScreen = true;
        this.mMenuPopup = false;
        this.mAutoAdjustPopupDirection = false;
        this.mContext = context;
        this.mPopupWindow = new PopupWindow(context);
        Resources r0 = this.mContext.getResources();
        this.mBgLeftRightShadowWidth = r0.getDimensionPixelSize(R.dimen.popup_bg_left_right_shadow_width);
        this.mBgTopBottomShadowHeight = r0.getDimensionPixelSize(R.dimen.popup_bg_top_bottom_shadow_height);
        this.mMenuPanelBgRoundCornerRadius = r0.getDimensionPixelSize(R.dimen.menu_panel_bg_round_corner_radius);
        this.mArrowWidth = r0.getDimensionPixelSize(R.dimen.menu_panel_bg_arrow_width);
        this.mArrowHeight = r0.getDimensionPixelSize(R.dimen.menu_panel_bg_arrow_height);
        this.mMinDistance = r0.getDimensionPixelSize(R.dimen.menu_panel_bg_min_distance);
        WindowManager r3 = (WindowManager) context.getSystemService("window");
        if (r3 == null) goto L5;
        Point r1 = new Point();
        r3.getDefaultDisplay().getRealSize(r1);
        this.mScreenWidth = r1.x;
        this.mScreenHeight = r1.y;
        return;
    L5:
        DisplayMetrics r4 = this.mContext.getResources().getDisplayMetrics();
        this.mScreenWidth = r4.widthPixels;
        this.mScreenHeight = r4.heightPixels;
    }

    public void show(int arrowDirection, int xoffset, int yoffset, int arrowXoffset, int arrowYoffset) {
        show(arrowDirection, xoffset, yoffset, arrowXoffset, arrowYoffset, false);
    }

    public void show(int arrowDirection, int xoffset, int yoffset, int arrowXoffset, int arrowYoffset, boolean arrowXoffsetIncludeArrowWidth) {
        prepareShow();
        this.mPopupWindow.setWidth(getPopupWindowWidth());
        this.mPopupWindow.setHeight(-2);
        InvokeApi.xPopupWindow.setClipToScreenEnabled(this.mPopupWindow, true);
        this.mPopupWindow.setOutsideTouchable(true);
        this.mPopupWindow.setFocusable(this.mRequestFocusable);
        this.mPopupWindow.setBackgroundDrawable(this.mContext.getResources().getDrawable(android.R.color.transparent));
        this.mPopupWindow.setOnDismissListener(this.mDismissListener);
        this.mPopupWindow.update();
        int[] r0 = new int[2];
        this.mAnchorView.getLocationInWindow(r0);
        this.mPopupWindow.setAnimationStyle(getAnimationStyle());
        View r7 = createContentViewWithArrow(arrowDirection, arrowXoffset, arrowYoffset);
        if (this.mArrowVisible == true) goto L5;
        setArrowVisible(r7, false);
    L5:
        int r9 = r0[0] + xoffset;
        int r10 = r0[1] + yoffset;
        setArrowLocOnLayout(r7, arrowDirection, arrowXoffset, arrowYoffset, arrowXoffsetIncludeArrowWidth);
        this.mPopupWindow.setContentView(r7);
        if (this.mMenuPopup == false) goto L13;
        this.mMenuPanelView.measure(0, View.MeasureSpec.makeMeasureSpec(this.mScreenHeight, Integer.MIN_VALUE));
        int r1 = this.mMenuPanelView.getMeasuredHeight();
        if (this.mArrowVisible == false) goto L10;
        int r2 = this.mArrowHeight;
    L11:
        r10 = r10 - ((r1 + r2) + this.mAnchorView.getMeasuredHeight());
        goto L13
    L10:
        r2 = 0;
    L13:
        if (this.mClipToScreen == true) goto L27;
        this.mMenuPanelView.measure(0, View.MeasureSpec.makeMeasureSpec(this.mScreenHeight, Integer.MIN_VALUE));
        int r3 = this.mMinDistance;
        int r4 = this.mContext.getResources().getConfiguration().orientation;
        int r5 = (((this.mBgLeftRightShadowWidth + r9) + this.mContentAreaWidth) + r3) - this.mScreenWidth;
        int r6 = (((this.mBgTopBottomShadowHeight + r10) + this.mMenuPanelView.getMeasuredHeight()) + r3) - this.mScreenHeight;
        if (this.mAutoAdjustPopupDirection == false) goto L23;
        if (r5 <= 0) goto L18;
        r9 = Math.max(r9 - this.mContentAreaWidth, -(this.mBgLeftRightShadowWidth - this.mMinDistance));
    L18:
        int r8 = this.mContext.getResources().getDimensionPixelSize(InvokeApi.xComAndroidInternalR.getResId("dimen", "status_bar_height"));
        int r11 = r10 - this.mMenuPanelView.getMeasuredHeight();
        int r12 = this.mBgTopBottomShadowHeight;
        int r13 = this.mMinDistance;
        int r14 = (r11 + r12) - r13;
        if (r14 >= r8) goto L22;
        if (r6 <= 0) goto L27;
    L26:
        r10 = r10 - r6;
        goto L27
    L22:
        r10 = (r14 + r13) - r12;
        goto L27
    L23:
        if (r5 <= 0) goto L25;
        r9 = r9 - r5;
    L25:
        if (r6 > 0) goto L26;
    L27:
        this.mPopupWindow.showAtLocation(this.mAnchorView, 51, r9, r10);
    }

    public int getPopupWindowWidth() {
        return this.mContentAreaWidth + (this.mBgLeftRightShadowWidth * 2);
    }

    public int getLeftRightShadowWidth() {
        return this.mBgLeftRightShadowWidth;
    }

    public int getMenuPanelBgRoundCornerRadius() {
        return this.mMenuPanelBgRoundCornerRadius;
    }

    public void showCenter() {
        showCenter(0, 0);
    }

    public void showCenter(int yoffset, int arrowYoffset) {
        show(0, (getAnchorView().getWidth() / 2) - (getPopupWindowWidth() / 2), yoffset, ((getPopupWindowWidth() / 2) - getLeftRightShadowWidth()) - getMenuPanelBgRoundCornerRadius(), arrowYoffset, true);
    }

    public void setShowAboveAnchor(boolean aboveAnchor) {
        this.mShowAboveAnchor = aboveAnchor;
    }

    private int getAnimationStyle() {
        if (this.mShowAboveAnchor == false) goto L6;
        return InvokeApi.xComAndroidInternalR.getResId("style", "Animation_DropDownUp");
    L6:
        return InvokeApi.xComAndroidInternalR.getResId("style", "Animation_DropDownDown");
    }

    public boolean isShowing() {
        return this.mPopupWindow.isShowing();
    }

    public void dismiss() {
        this.mPopupWindow.dismiss();
        this.mPopupWindow.setContentView(null);
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener listener) {
        this.mDismissListener = listener;
    }

    protected View createContentViewWithArrow(int arrowDirection, int arrowXoffset, int arrowYoffset) {
        if (arrowDirection == 0) goto L12;
        if (arrowDirection == 1) goto L11;
        if (arrowDirection == 2) goto L10;
        if (arrowDirection != 3) goto L9;
        int r3 = R.layout.popup_menu_layout_for_right;
    L13:
        View r4 = LayoutInflater.from(this.mContext).inflate(r3, null);
        FrameLayout r5 = (FrameLayout) r4.findViewById(R.id.place_holder);
        ImageView r6 = (ImageView) r4.findViewById(R.id.arrow);
        onArrowViewInflated(r6);
        if (arrowDirection == 0) goto L20;
        if (arrowDirection == 1) goto L20;
        if (arrowDirection == 2) goto L19;
        if (arrowDirection == 3) goto L19;
    L21:
        if (arrowDirection == 0) goto L29;
        if (arrowDirection == 1) goto L28;
        if (arrowDirection == 2) goto L27;
        if (arrowDirection != 3) goto L30;
        r5.addView(this.mMenuPanelView);
    L30:
        r5.setBackgroundResource(R.drawable.popup_menu_bg_shadow);
        this.mMenuPanelView.setOnClickListener(new AnonymousClass1(this));
        r5.setOnClickListener(new AnonymousClass2(this));
        return r4;
    L27:
        r5.addView(this.mMenuPanelView);
        goto L30
    L28:
        r5.addView(this.mMenuPanelView);
        goto L30
    L29:
        r5.addView(this.mMenuPanelView);
    L19:
        r6.setY((arrowYoffset + this.mBgTopBottomShadowHeight) + this.mMenuPanelBgRoundCornerRadius);
    L20:
        int r10 = this.mMenuPanelBgRoundCornerRadius;
        r6.setX(Math.min(arrowXoffset + r10, (this.mContentAreaWidth - r10) - this.mArrowWidth) + this.mBgLeftRightShadowWidth);
        goto L21
    L9:
        throw new IllegalArgumentException("unknown direction value:" + arrowDirection);
    L10:
        r3 = R.layout.popup_menu_layout_for_left;
        goto L13
    L11:
        r3 = R.layout.popup_menu_layout_for_bottom;
        setShowAboveAnchor(true);
        goto L13
    L12:
        r3 = R.layout.popup_menu_layout_for_top;
        goto L13
    }

    public void setAnchorView(View anchorView) {
        this.mAnchorView = anchorView;
    }

    public View getAnchorView() {
        return this.mAnchorView;
    }

    public void setContentAreaWidth(int width) {
        this.mContentAreaWidth = width;
    }

    public void setFocusable(boolean focusable) {
        this.mRequestFocusable = focusable;
    }

    private void setArrowVisible(View contentView, boolean visible) {
        if (contentView != null) goto L14;
        return;
    L14:
        View r0 = contentView.findViewById(R.id.arrow);     // Catch: Exception -> L10
        if (r0 == null) goto L13;
        if (visible == false) goto L8;
        r0.setVisibility(0);     // Catch: Exception -> L10
        goto L13
    L8:
        r0.setVisibility(8);     // Catch: Exception -> L10
    L13:
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
    }

    public void setArrowInvisible() {
        this.mArrowVisible = false;
    }

    public PopupWindow getPopupWindow() {
        return this.mPopupWindow;
    }

    public void setClipToScreenEnabled(boolean enabled) {
        this.mClipToScreen = enabled;
    }

    public void setAutoAdjustPopupDirection(boolean enabled) {
        this.mAutoAdjustPopupDirection = enabled;
    }

    public void setMenuPopup(boolean popup) {
        this.mMenuPopup = popup;
    }

    private void setArrowLocOnLayout(View contentView, int arrowDirection, int arrowXoffset, int arrowYoffset, boolean arrowXoffsetIncludeArrowWidth) {
        final ImageView r1 = (ImageView) contentView.findViewById(R.id.arrow);
        if (r1 == null) goto L7;
        if (arrowXoffsetIncludeArrowWidth == false) goto L8;
        r1.addOnLayoutChangeListener(new AnonymousClass3(this, r1));
        return;
    L8:
        return;
    }
}
