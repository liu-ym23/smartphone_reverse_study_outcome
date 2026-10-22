package com.android.server.accessibility.autoclick;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes.dex */
public class AutoclickTypePanel {
    public static final int AUTOCLICK_TYPE_DOUBLE_CLICK = 2;
    public static final int AUTOCLICK_TYPE_DRAG = 3;
    public static final int AUTOCLICK_TYPE_LEFT_CLICK = 0;
    public static final int AUTOCLICK_TYPE_RIGHT_CLICK = 1;
    public static final int AUTOCLICK_TYPE_SCROLL = 4;
    public static final int CORNER_BOTTOM_LEFT = 1;
    public static final int CORNER_BOTTOM_RIGHT = 0;
    public static final int CORNER_TOP_LEFT = 2;
    public static final int CORNER_TOP_RIGHT = 3;
    private static final int PANEL_EDGE_MARGIN = 15;
    protected static final String POSITION_DELIMITER = ",";
    private final String TAG;
    private final ClickPanelControllerInterface mClickPanelController;
    private final AutoclickLinearLayout mContentView;
    private final Context mContext;
    private int mCurrentCorner;
    private final LinearLayout mDoubleClickButton;
    private final LinearLayout mDragButton;
    private boolean mExpanded;
    private boolean mIsDragging;
    private final LinearLayout mLeftClickButton;
    private int mPanelStartX;
    private int mPanelStartY;
    private WindowManager.LayoutParams mParams;
    private final LinearLayout mPauseButton;
    private final Drawable mPauseButtonDrawable;
    private boolean mPaused;
    private final LinearLayout mPositionButton;
    private final Drawable mResumeButtonDrawable;
    private final LinearLayout mRightClickButton;
    private final LinearLayout mScrollButton;
    private LinearLayout mSelectedButton;
    private float mTouchStartX;
    private float mTouchStartY;
    private final int mUserId;
    private final WindowManager mWindowManager;

    public @interface AutoclickType {
    }

    public interface ClickPanelControllerInterface {
        void handleAutoclickTypeChange(int r1);

        void onHoverChange(boolean r1);

        void toggleAutoclickPause(boolean r1);
    }

    public @interface Corner {
    }

    /* JADX INFO: renamed from: $r8$lambda$57OX0rR8--VAxgyx22alQ0WZoVw, reason: not valid java name */
    public static /* synthetic */ void m748$r8$lambda$57OX0rR8VAxgyx22alQ0WZoVw(AutoclickTypePanel r0, View r1) {
        r0.lambda$initializeButtonState$2(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$AknxtO-E76stN5RP2cX6X-GMmEk, reason: not valid java name */
    public static /* synthetic */ void m749$r8$lambda$AknxtOE76stN5RP2cX6XGMmEk(AutoclickTypePanel r0, View r1) {
        r0.lambda$initializeButtonState$4(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$FfiK5Uw3dYQWfKLQP-Ioc7hlpJU, reason: not valid java name */
    public static /* synthetic */ void m750$r8$lambda$FfiK5Uw3dYQWfKLQPIoc7hlpJU(AutoclickTypePanel r0, View r1) {
        r0.lambda$initializeButtonState$3(r1);
    }

    public static /* synthetic */ void $r8$lambda$H0aA6R8l5RdVtqrS7VzqahPI6Ag(AutoclickTypePanel r0, View r1) {
        r0.lambda$initializeButtonState$6(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$Jok28F_iePa94uFzq4wGXvVJ5CU(AutoclickTypePanel r0, View r1, MotionEvent r2) {
        return r0.onPanelTouch(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$RsBtQonrwbPQtkH6kwUoeN5TDGY(AutoclickTypePanel r0, View r1) {
        r0.lambda$initializeButtonState$1(r1);
    }

    public static /* synthetic */ void $r8$lambda$UcQhnL6g5NzSN2luUF_fR4adGUs(AutoclickTypePanel r0, View r1) {
        r0.lambda$initializeButtonState$5(r1);
    }

    public static /* synthetic */ void $r8$lambda$Xshp8ZORxYqlEXoUaUvtGD3fuGY(AutoclickTypePanel r0, View.OnClickListener r1, View r2) {
        r0.lambda$wrapWithTogglePauseListener$7(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$fY-QQNLDz9shZOpM0fhkBSPKnW4, reason: not valid java name */
    public static /* synthetic */ void m751$r8$lambda$fYQQNLDz9shZOpM0fhkBSPKnW4(AutoclickTypePanel r0, View r1) {
        r0.lambda$initializeButtonState$0(r1);
    }

    public AutoclickTypePanel(Context context, WindowManager windowManager, int userId, ClickPanelControllerInterface clickPanelController) {
        this.TAG = AutoclickTypePanel.class.getSimpleName();
        this.mIsDragging = false;
        this.mExpanded = false;
        this.mPaused = false;
        this.mCurrentCorner = 0;
        this.mContext = context;
        this.mWindowManager = windowManager;
        this.mUserId = userId;
        this.mClickPanelController = clickPanelController;
        this.mParams = getDefaultLayoutParams();
        this.mPauseButtonDrawable = this.mContext.getDrawable(R.drawable.activated_background_light);
        this.mResumeButtonDrawable = this.mContext.getDrawable(R.drawable.activity_embedding_divider_handle);
        this.mContentView = (AutoclickLinearLayout) LayoutInflater.from(context).inflate(R.layout.accessibility_autoclick_type_panel, null);
        AutoclickLinearLayout r0 = this.mContentView;
        final ClickPanelControllerInterface r1 = this.mClickPanelController;
        r1.getClass();
        r0.setOnHoverChangedListener(new AutoclickTypePanel$$ExternalSyntheticLambda7(r1));
        this.mLeftClickButton = (LinearLayout) this.mContentView.findViewById(R.id.accessibility_autoclick_left_click_layout);
        this.mRightClickButton = (LinearLayout) this.mContentView.findViewById(R.id.accessibility_autoclick_right_click_layout);
        this.mDoubleClickButton = (LinearLayout) this.mContentView.findViewById(R.id.accessibility_autoclick_double_click_layout);
        this.mScrollButton = (LinearLayout) this.mContentView.findViewById(R.id.accessibility_autoclick_scroll_layout);
        this.mDragButton = (LinearLayout) this.mContentView.findViewById(R.id.accessibility_autoclick_drag_layout);
        this.mPauseButton = (LinearLayout) this.mContentView.findViewById(R.id.accessibility_autoclick_pause_layout);
        this.mPositionButton = (LinearLayout) this.mContentView.findViewById(R.id.accessibility_autoclick_position_layout);
        initializeButtonState();
        this.mContentView.setOnTouchListener(new AutoclickTypePanel$$ExternalSyntheticLambda8(this));
    }

    private boolean onPanelTouch(View v, MotionEvent event) {
        switch(event.getAction()) {
            case 0: goto L14;
            case 1: goto L10;
            case 2: goto L5;
            case 3: goto L10;
            default: goto L4;
        };
    L4:
        return false;
    L5:
        this.mIsDragging = true;
        this.mParams.gravity = 51;
        if (this.mIsDragging == false) goto L8;
        float deltaX = event.getRawX() - this.mTouchStartX;
        float deltaY = event.getRawY() - this.mTouchStartY;
        WindowManager.LayoutParams r3 = this.mParams;
        r3.x = this.mPanelStartX + ((int) deltaX);
        WindowManager.LayoutParams r4 = this.mParams;
        r4.y = this.mPanelStartY + ((int) deltaY);
        this.mWindowManager.updateViewLayout(this.mContentView, this.mParams);
    L8:
        return true;
    L14:
        this.mTouchStartX = event.getRawX();
        this.mTouchStartY = event.getRawY();
        int[] location = new int[2];
        v.getLocationOnScreen(location);
        this.mPanelStartX = location[0];
        this.mPanelStartY = location[1];
        return true;
    L10:
        if (this.mIsDragging == false) goto L12;
        snapToNearestEdge(this.mParams);
    L12:
        this.mIsDragging = false;
        return true;
    }

    private void snapToNearestEdge(WindowManager.LayoutParams params) {
        int screenWidth = this.mContext.getResources().getDisplayMetrics().widthPixels;
        int yPosition = params.y;
        if (params.x >= (screenWidth / 2)) goto L5;
        boolean isOnLeftHalf = true;
    L6:
        if (isOnLeftHalf == false) goto L8;
        params.gravity = 8388659;
        this.mCurrentCorner = 1;
    L9:
        params.x = 15;
        params.y = yPosition;
        this.mWindowManager.updateViewLayout(this.mContentView, params);
        return;
    L8:
        params.gravity = 8388661;
        this.mCurrentCorner = 3;
        goto L9
    L5:
        isOnLeftHalf = false;
        goto L6
    }

    private void initializeButtonState() {
        this.mLeftClickButton.setOnClickListener(wrapWithTogglePauseListener(new AutoclickTypePanel$$ExternalSyntheticLambda0(this)));
        this.mRightClickButton.setOnClickListener(wrapWithTogglePauseListener(new AutoclickTypePanel$$ExternalSyntheticLambda1(this)));
        this.mDoubleClickButton.setOnClickListener(wrapWithTogglePauseListener(new AutoclickTypePanel$$ExternalSyntheticLambda2(this)));
        this.mScrollButton.setOnClickListener(wrapWithTogglePauseListener(new AutoclickTypePanel$$ExternalSyntheticLambda3(this)));
        this.mDragButton.setOnClickListener(wrapWithTogglePauseListener(new AutoclickTypePanel$$ExternalSyntheticLambda4(this)));
        this.mPositionButton.setOnClickListener(wrapWithTogglePauseListener(new AutoclickTypePanel$$ExternalSyntheticLambda5(this)));
        this.mPauseButton.setOnClickListener(new AutoclickTypePanel$$ExternalSyntheticLambda6(this));
        resetSelectedClickType();
    }

    private /* synthetic */ void lambda$initializeButtonState$0(View v) {
        togglePanelExpansion(0);
    }

    private /* synthetic */ void lambda$initializeButtonState$1(View v) {
        togglePanelExpansion(1);
    }

    private /* synthetic */ void lambda$initializeButtonState$2(View v) {
        togglePanelExpansion(2);
    }

    private /* synthetic */ void lambda$initializeButtonState$3(View v) {
        togglePanelExpansion(4);
    }

    private /* synthetic */ void lambda$initializeButtonState$4(View v) {
        togglePanelExpansion(3);
    }

    private /* synthetic */ void lambda$initializeButtonState$5(View v) {
        moveToNextCorner();
    }

    private /* synthetic */ void lambda$initializeButtonState$6(View v) {
        togglePause();
    }

    public void resetSelectedClickType() {
        hideAllClickTypeButtons();
        this.mLeftClickButton.setVisibility(0);
        setSelectedClickType(0);
    }

    private void setSelectedClickType(int clickType) {
        LinearLayout selectedButton = getButtonFromClickType(clickType);
        if (this.mSelectedButton == null) goto L5;
        toggleSelectedButtonStyle(this.mSelectedButton, false);
    L5:
        this.mSelectedButton = selectedButton;
        this.mClickPanelController.handleAutoclickTypeChange(clickType);
        toggleSelectedButtonStyle(selectedButton, true);
    }

    private void toggleSelectedButtonStyle(LinearLayout button, boolean isSelected) {
        GradientDrawable gradientDrawable = (GradientDrawable) button.getBackground();
        Context r1 = this.mContext;
        int r2 = R.color.primary_text_dark_disable_only;
        if (isSelected == false) goto L5;
        int r4 = 17171215;
    L6:
        gradientDrawable.setColor(r1.getColor(r4));
        ImageButton imageButton = (ImageButton) button.getChildAt(0);
        Drawable drawable = imageButton.getDrawable();
        Drawable r5 = drawable.mutate();
        Context r6 = this.mContext;
        if (isSelected == true) goto L10;
        r2 = 17171215;
    L10:
        r5.setTint(r6.getColor(r2));
        return;
    L5:
        r4 = 17171227;
        goto L6
    }

    public void show() {
        restorePanelPosition();
        this.mWindowManager.addView(this.mContentView, this.mParams);
    }

    public void hide() {
        toggleSelectedButtonStyle(this.mSelectedButton, false);
        savePanelPosition();
        this.mWindowManager.removeView(this.mContentView);
    }

    public boolean isPaused() {
        return this.mPaused;
    }

    public boolean isHovered() {
        return this.mContentView.isHovered();
    }

    private void togglePanelExpansion(int clickType) {
        LinearLayout button = getButtonFromClickType(clickType);
        if (this.mExpanded == false) goto L5;
        hideAllClickTypeButtons();
        button.setVisibility(0);
        setSelectedClickType(clickType);
    L6:
        this.mExpanded = !this.mExpanded;
        return;
    L5:
        showAllClickTypeButtons();
        goto L6
    }

    private void togglePause() {
        this.mPaused = !this.mPaused;
        this.mClickPanelController.toggleAutoclickPause(this.mPaused);
        ImageButton imageButton = (ImageButton) this.mPauseButton.getChildAt(0);
        if (this.mPaused == false) goto L5;
        imageButton.setImageDrawable(this.mResumeButtonDrawable);
        return;
    L5:
        imageButton.setImageDrawable(this.mPauseButtonDrawable);
    }

    private void hideAllClickTypeButtons() {
        this.mLeftClickButton.setVisibility(8);
        this.mRightClickButton.setVisibility(8);
        this.mDoubleClickButton.setVisibility(8);
        this.mDragButton.setVisibility(8);
        this.mScrollButton.setVisibility(8);
    }

    private void showAllClickTypeButtons() {
        this.mLeftClickButton.setVisibility(0);
        this.mRightClickButton.setVisibility(0);
        this.mDoubleClickButton.setVisibility(0);
        this.mDragButton.setVisibility(0);
        this.mScrollButton.setVisibility(0);
    }

    private LinearLayout getButtonFromClickType(int clickType) {
        switch(clickType) {
            case 0: goto L10;
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            default: goto L4;
        };
    L4:
        throw new IllegalArgumentException("Unknown clickType " + clickType);
    L11:
        return this.mScrollButton;
    L12:
        return this.mDragButton;
    L13:
        return this.mDoubleClickButton;
    L14:
        return this.mRightClickButton;
    L10:
        return this.mLeftClickButton;
    }

    private void moveToNextCorner() {
        int nextCorner = (this.mCurrentCorner + 1) % 4;
        this.mCurrentCorner = nextCorner;
        setPanelPositionForCorner(this.mParams, this.mCurrentCorner);
        this.mWindowManager.updateViewLayout(this.mContentView, this.mParams);
    }

    private void setPanelPositionForCorner(WindowManager.LayoutParams params, int corner) {
        switch(corner) {
            case 0: goto L9;
            case 1: goto L8;
            case 2: goto L7;
            case 3: goto L6;
            default: goto L5;
        };
    L6:
        params.gravity = 8388661;
        params.x = 15;
        params.y = 30;
        return;
    L7:
        params.gravity = 8388659;
        params.x = 15;
        params.y = 30;
        return;
    L8:
        params.gravity = 8388691;
        params.x = 15;
        params.y = 90;
        return;
    L9:
        params.gravity = 8388693;
        params.x = 15;
        params.y = 90;
        return;
    L5:
        throw new IllegalArgumentException("Invalid corner: " + corner);
    }

    private void savePanelPosition() {
        String positionString = TextUtils.join(POSITION_DELIMITER, new String[]{String.valueOf(this.mParams.gravity), String.valueOf(this.mParams.x), String.valueOf(this.mParams.y), String.valueOf(this.mCurrentCorner)});
        Settings.Secure.putStringForUser(this.mContext.getContentResolver(), "accessibility_autoclick_panel_position", positionString, this.mUserId);
    }

    private void restorePanelPosition() {
        String savedPosition = Settings.Secure.getStringForUser(this.mContext.getContentResolver(), "accessibility_autoclick_panel_position", this.mUserId);
        if (savedPosition != null) goto L6;
        setPanelPositionForCorner(this.mParams, 0);
        this.mCurrentCorner = 0;
        return;
    L6:
        String[] parts = TextUtils.split(savedPosition, POSITION_DELIMITER);
        if (isValidPositionParts(parts) == true) goto L10;
        setPanelPositionForCorner(this.mParams, 0);
        this.mCurrentCorner = 0;
        return;
    L10:
        WindowManager.LayoutParams r3 = this.mParams;
        r3.gravity = Integer.parseInt(parts[0]);
        WindowManager.LayoutParams r1 = this.mParams;
        r1.x = Integer.parseInt(parts[1]);
        WindowManager.LayoutParams r2 = this.mParams;
        r2.y = Integer.parseInt(parts[2]);
        this.mCurrentCorner = Integer.parseInt(parts[3]);
    }

    private boolean isValidPositionParts(String[] parts) {
        if (parts != null) goto L5;
    L28:
        return false;
    L5:
        if (parts.length != 4) goto L28;
        int gravity = Integer.parseInt(parts[0]);
        int x = Integer.parseInt(parts[1]);
        int y = Integer.parseInt(parts[2]);
        int cornerIndex = Integer.parseInt(parts[3]);
        if (gravity != 8388659) goto L10;
    L16:
        int screenWidth = this.mContext.getResources().getDisplayMetrics().widthPixels;
        int screenHeight = this.mContext.getResources().getDisplayMetrics().heightPixels;
        if (x < 0) goto L27;
        if (x > screenWidth) goto L27;
        if (y < 0) goto L27;
        if (y > screenHeight) goto L27;
        if (cornerIndex < 0) goto L26;
        if (cornerIndex >= 4) goto L26;
        return true;
    L26:
        return false;
    L27:
        return false;
    L10:
        if (gravity == 8388661) goto L16;
        if (gravity == 8388691) goto L16;
        if (gravity == 8388693) goto L16;
        return false;
    }

    private View.OnClickListener wrapWithTogglePauseListener(final View.OnClickListener listener) {
        return new AutoclickTypePanel$$ExternalSyntheticLambda9(this, listener);
    }

    private /* synthetic */ void lambda$wrapWithTogglePauseListener$7(View.OnClickListener listener, View v) {
        listener.onClick(v);
        if (this.mPaused == false) goto L6;
        togglePause();
        return;
    }

    boolean getExpansionStateForTesting() {
        return this.mExpanded;
    }

    AutoclickLinearLayout getContentViewForTesting() {
        return this.mContentView;
    }

    int getCurrentCornerForTesting() {
        return this.mCurrentCorner;
    }

    WindowManager.LayoutParams getLayoutParamsForTesting() {
        return this.mParams;
    }

    boolean getIsDraggingForTesting() {
        return this.mIsDragging;
    }

    private WindowManager.LayoutParams getDefaultLayoutParams() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2038;
        layoutParams.flags = 8;
        layoutParams.privateFlags |= 16;
        layoutParams.setFitInsetsTypes(WindowInsets.Type.statusBars());
        layoutParams.layoutInDisplayCutoutMode = 3;
        layoutParams.format = -3;
        layoutParams.setTitle(AutoclickTypePanel.class.getSimpleName());
        layoutParams.accessibilityTitle = this.mContext.getString(R.string.accessibility_edit_shortcut_menu_volume_title);
        layoutParams.width = -2;
        layoutParams.height = -2;
        setPanelPositionForCorner(layoutParams, 0);
        return layoutParams;
    }
}
