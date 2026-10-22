package com.android.server.input.debug;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Rect;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.util.Slog;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.SurfaceControl;
import android.view.ViewConfiguration;
import android.view.ViewRootImpl;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.server.input.TouchpadFingerState;
import com.android.server.input.TouchpadHardwareProperties;
import com.android.server.input.TouchpadHardwareState;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public class TouchpadDebugView extends LinearLayout {
    private static final int BUTTON_PRESSED_BACKGROUND_COLOR = 0;
    private static final int BUTTON_RELEASED_BACKGROUND_COLOR = 0;
    private static final float DEFAULT_RES_X = 47.0f;
    private static final float DEFAULT_RES_Y = 45.0f;
    private static final float MAX_SCREEN_HEIGHT_PROPORTION = 0.4f;
    private static final float MAX_SCREEN_WIDTH_PROPORTION = 0.4f;
    private static final float MIN_SCALE_FACTOR = 10.0f;
    private static final int ROUNDED_CORNER_RADIUS_DP = 24;
    private static final String TAG = "TouchpadDebugView";
    private static final int TEXT_PADDING_DP = 12;
    private static final float TEXT_SIZE_SP = 16.0f;
    private TextView mGestureInfoView;
    private TouchpadHardwareState mLastTouchpadState;
    private int mLatestGestureType;
    private int mScreenHeight;
    private int mScreenWidth;
    private float mTouchDownX;
    private float mTouchDownY;
    private final int mTouchSlop;
    private final TouchpadHardwareProperties mTouchpadHardwareProperties;
    private final int mTouchpadId;
    private TouchpadSelectionView mTouchpadSelectionView;
    private TouchpadVisualizationView mTouchpadVisualizationView;
    private final WindowManager.LayoutParams mWindowLayoutParams;
    private int mWindowLocationBeforeDragX;
    private int mWindowLocationBeforeDragY;
    private final WindowManager mWindowManager;

    /* JADX INFO: renamed from: $r8$lambda$hVfjbUWxFvWaxm-hd4RfCwE-EcM, reason: not valid java name */
    public static /* synthetic */ void m4620$r8$lambda$hVfjbUWxFvWaxmhd4RfCwEEcM(TouchpadDebugView r0) {
        r0.lambda$onAttachedToWindow$0();
    }

    static {
        BUTTON_PRESSED_BACKGROUND_COLOR = Color.rgb(118, 151, 99);
        BUTTON_RELEASED_BACKGROUND_COLOR = Color.rgb(84, 85, 169);
    }

    public TouchpadDebugView(Context context, int touchpadId, TouchpadHardwareProperties touchpadHardwareProperties, Consumer<Integer> touchpadSwitchHandler) {
        super(context);
        this.mLatestGestureType = 0;
        this.mLastTouchpadState = new TouchpadHardwareState(0.0f, 0, 0, 0, new TouchpadFingerState[0]);
        this.mTouchpadId = touchpadId;
        WindowManager r1 = (WindowManager) getContext().getSystemService(WindowManager.class);
        r1.getClass();
        this.mWindowManager = r1;
        this.mTouchpadHardwareProperties = touchpadHardwareProperties;
        init(context, touchpadId, touchpadSwitchHandler);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mWindowLayoutParams = new WindowManager.LayoutParams();
        this.mWindowLayoutParams.type = 2038;
        this.mWindowLayoutParams.flags = 264;
        this.mWindowLayoutParams.privateFlags |= 16;
        this.mWindowLayoutParams.setFitInsetsTypes(0);
        this.mWindowLayoutParams.layoutInDisplayCutoutMode = 3;
        this.mWindowLayoutParams.format = -3;
        this.mWindowLayoutParams.setTitle("TouchpadDebugView - display " + ((LinearLayout) this).mContext.getDisplayId());
        this.mWindowLayoutParams.x = 40;
        this.mWindowLayoutParams.y = 100;
        this.mWindowLayoutParams.width = -2;
        this.mWindowLayoutParams.height = -2;
        this.mWindowLayoutParams.gravity = 51;
    }

    private void init(Context context, int touchpadId, Consumer<Integer> touchpadSwitchHandler) {
        updateScreenDimensions();
        setOrientation(1);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        setBackgroundColor(0);
        this.mTouchpadSelectionView = new TouchpadSelectionView(context, touchpadId, touchpadSwitchHandler);
        this.mTouchpadSelectionView.setBackgroundColor(BUTTON_RELEASED_BACKGROUND_COLOR);
        this.mTouchpadSelectionView.setGravity(17);
        int paddingInDP = (int) TypedValue.applyDimension(1, 12.0f, getResources().getDisplayMetrics());
        this.mTouchpadSelectionView.setPadding(paddingInDP, paddingInDP, paddingInDP, paddingInDP);
        this.mTouchpadSelectionView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.mTouchpadVisualizationView = new TouchpadVisualizationView(context, this.mTouchpadHardwareProperties);
        this.mGestureInfoView = new TextView(context);
        this.mGestureInfoView.setTextSize(TEXT_SIZE_SP);
        this.mGestureInfoView.setText("Latest Gesture: ");
        this.mGestureInfoView.setGravity(17);
        this.mGestureInfoView.setPadding(paddingInDP, paddingInDP, paddingInDP, paddingInDP);
        this.mGestureInfoView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        updateTheme(getResources().getConfiguration().uiMode);
        addView(this.mTouchpadSelectionView);
        addView(this.mTouchpadVisualizationView);
        addView(this.mGestureInfoView);
        updateViewsDimensions();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        postDelayed(new TouchpadDebugView$$ExternalSyntheticLambda0(this), 100);
    }

    private /* synthetic */ void lambda$onAttachedToWindow$0() {
        ViewRootImpl viewRootImpl = getRootView().getViewRootImpl();
        if (viewRootImpl != null) goto L6;
        Slog.d(TAG, "ViewRootImpl is null.");
        return;
    L6:
        SurfaceControl surfaceControl = viewRootImpl.getSurfaceControl();
        if (surfaceControl != null) goto L9;
    L19:
        Slog.d(TAG, "SurfaceControl is invalid or has been released.");
        return;
    L9:
        if (surfaceControl.isValid() == false) goto L19;
        SurfaceControl.Transaction transaction = new SurfaceControl.Transaction();
        transaction.setCornerRadius(surfaceControl, TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics())).apply();     // Catch: Throwable -> L13
        transaction.close();
        return;
    L13:
        th = move-exception;
        transaction.close();     // Catch: Throwable -> L16
    L18:
        throw th;
    L16:
        th = move-exception;
        th.addSuppressed(th);
        goto L18
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getClassification() != 3) goto L5;
    L23:
        return false;
    L5:
        if (event.getClassification() == 5) goto L23;
        switch(event.getAction()) {
            case 0: goto L21;
            case 1: goto L17;
            case 2: goto L13;
            case 3: goto L11;
            default: goto L10;
        };
    L11:
        this.mWindowLayoutParams.x = this.mWindowLocationBeforeDragX;
        this.mWindowLayoutParams.y = this.mWindowLocationBeforeDragY;
        this.mWindowManager.updateViewLayout(this, this.mWindowLayoutParams);
        return true;
    L13:
        float deltaX = (event.getRawX() - this.mWindowLayoutParams.x) - this.mTouchDownX;
        float deltaY = (event.getRawY() - this.mWindowLayoutParams.y) - this.mTouchDownY;
        if (isSlopExceeded(deltaX, deltaY) == false) goto L16;
        this.mWindowLayoutParams.x = Math.max(0, Math.min((int) (event.getRawX() - this.mTouchDownX), this.mScreenWidth - getWidth()));
        this.mWindowLayoutParams.y = Math.max(0, Math.min((int) (event.getRawY() - this.mTouchDownY), this.mScreenHeight - getHeight()));
        this.mWindowManager.updateViewLayout(this, this.mWindowLayoutParams);
    L16:
        return true;
    L17:
        float deltaX2 = event.getRawX();
        float deltaX3 = (deltaX2 - this.mWindowLayoutParams.x) - this.mTouchDownX;
        float deltaY2 = (event.getRawY() - this.mWindowLayoutParams.y) - this.mTouchDownY;
        if (isSlopExceeded(deltaX3, deltaY2) == true) goto L20;
        performClick();
    L20:
        return true;
    L21:
        this.mWindowLocationBeforeDragX = this.mWindowLayoutParams.x;
        this.mWindowLocationBeforeDragY = this.mWindowLayoutParams.y;
        this.mTouchDownX = event.getRawX() - this.mWindowLocationBeforeDragX;
        this.mTouchDownY = event.getRawY() - this.mWindowLocationBeforeDragY;
        return true;
    L10:
        return super.onTouchEvent(event);
    }

    @Override // android.view.View
    public boolean performClick() {
        super.performClick();
        Slog.d(TAG, "You tapped the window!");
        return true;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        updateTheme(newConfig.uiMode);
        updateScreenDimensions();
        updateViewsDimensions();
        WindowManager.LayoutParams r0 = this.mWindowLayoutParams;
        r0.x = Math.max(0, Math.min(this.mWindowLayoutParams.x, this.mScreenWidth - getWidth()));
        WindowManager.LayoutParams r1 = this.mWindowLayoutParams;
        r1.y = Math.max(0, Math.min(this.mWindowLayoutParams.y, this.mScreenHeight - getHeight()));
        this.mWindowManager.updateViewLayout(this, this.mWindowLayoutParams);
    }

    private void updateTheme(int uiMode) {
        int currentNightMode = uiMode & 48;
        if (currentNightMode != 32) goto L5;
        setNightModeTheme();
        return;
    L5:
        setLightModeTheme();
    }

    private void setLightModeTheme() {
        this.mTouchpadVisualizationView.setLightModeTheme();
        this.mGestureInfoView.setBackgroundColor(-1);
        this.mGestureInfoView.setTextColor(AudioFormat.MAIN_MASK);
    }

    private void setNightModeTheme() {
        this.mTouchpadVisualizationView.setNightModeTheme();
        this.mGestureInfoView.setBackgroundColor(AudioFormat.MAIN_MASK);
        this.mGestureInfoView.setTextColor(-1);
    }

    private boolean isSlopExceeded(float deltaX, float deltaY) {
        if (((deltaX * deltaX) + (deltaY * deltaY)) < (this.mTouchSlop * this.mTouchSlop)) goto L5;
        return true;
    L5:
        return false;
    }

    private void updateViewsDimensions() {
        if (this.mTouchpadHardwareProperties.getResX() != 0.0f) goto L5;
        float resX = DEFAULT_RES_X;
    L7:
        if (this.mTouchpadHardwareProperties.getResY() != 0.0f) goto L9;
        float resY = DEFAULT_RES_Y;
    L10:
        float touchpadHeightMm = Math.abs(this.mTouchpadHardwareProperties.getBottom() - this.mTouchpadHardwareProperties.getTop()) / resY;
        float touchpadWidthMm = Math.abs(this.mTouchpadHardwareProperties.getLeft() - this.mTouchpadHardwareProperties.getRight()) / resX;
        float maxViewWidthPx = this.mScreenWidth * 0.4f;
        float maxViewHeightPx = this.mScreenHeight * 0.4f;
        float minScaleFactorPx = TypedValue.applyDimension(1, MIN_SCALE_FACTOR, getResources().getDisplayMetrics());
        if ((touchpadWidthMm * minScaleFactorPx) <= maxViewWidthPx) goto L13;
        float scaleFactorBasedOnWidth = maxViewWidthPx / touchpadWidthMm;
    L15:
        if ((touchpadHeightMm * minScaleFactorPx) <= maxViewHeightPx) goto L17;
        float scaleFactorBasedOnHeight = maxViewHeightPx / touchpadHeightMm;
    L18:
        float scaleFactorUsed = Math.min(scaleFactorBasedOnHeight, scaleFactorBasedOnWidth);
        this.mTouchpadVisualizationView.setLayoutParams(new LinearLayout.LayoutParams((int) (touchpadWidthMm * scaleFactorUsed), (int) (touchpadHeightMm * scaleFactorUsed)));
        this.mTouchpadVisualizationView.updateScaleFactor(scaleFactorUsed);
        this.mTouchpadVisualizationView.invalidate();
        return;
    L17:
        scaleFactorBasedOnHeight = minScaleFactorPx;
        goto L18
    L13:
        scaleFactorBasedOnWidth = minScaleFactorPx;
        goto L15
    L9:
        resY = this.mTouchpadHardwareProperties.getResY();
        goto L10
    L5:
        resX = this.mTouchpadHardwareProperties.getResX();
        goto L7
    }

    private void updateScreenDimensions() {
        Rect windowBounds = this.mWindowManager.getCurrentWindowMetrics().getBounds();
        this.mScreenWidth = windowBounds.width();
        this.mScreenHeight = windowBounds.height();
    }

    public int getTouchpadId() {
        return this.mTouchpadId;
    }

    public WindowManager.LayoutParams getWindowLayoutParams() {
        return this.mWindowLayoutParams;
    }

    TextView getGestureInfoView() {
        return this.mGestureInfoView;
    }

    public void updateHardwareState(TouchpadHardwareState touchpadHardwareState, int deviceId) {
        if (deviceId == this.mTouchpadId) goto L5;
        return;
    L5:
        this.mTouchpadVisualizationView.onTouchpadHardwareStateNotified(touchpadHardwareState);
        if (this.mLastTouchpadState.getButtonsDown() != 0) goto L11;
        if (touchpadHardwareState.getButtonsDown() <= 0) goto L13;
        onTouchpadButtonPress();
    L13:
        this.mLastTouchpadState = touchpadHardwareState;
        return;
    L11:
        if (touchpadHardwareState.getButtonsDown() != 0) goto L13;
        onTouchpadButtonRelease();
        goto L13
    }

    private void onTouchpadButtonPress() {
        Slog.d(TAG, "You clicked me!");
        this.mTouchpadSelectionView.setBackgroundColor(BUTTON_PRESSED_BACKGROUND_COLOR);
    }

    private void onTouchpadButtonRelease() {
        Slog.d(TAG, "You released the click");
        this.mTouchpadSelectionView.setBackgroundColor(BUTTON_RELEASED_BACKGROUND_COLOR);
    }

    public void updateGestureInfo(int newGestureType, int deviceId) {
        if (deviceId == this.mTouchpadId) goto L5;
        return;
    L5:
        if (this.mLatestGestureType == newGestureType) goto L9;
        this.mGestureInfoView.setText(getGestureText(newGestureType));
        this.mLatestGestureType = newGestureType;
        return;
    }

    static String getGestureText(int gestureType) {
        switch(gestureType) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            case 9: goto L6;
            case 10: goto L5;
            case 11: goto L4;
            default: goto L3;
        };
    L3:
        String mGestureName = "Unknown Gesture";
    L16:
        return "Latest Gesture: " + mGestureName;
    L4:
        mGestureName = "Mouse Wheel";
        goto L16
    L5:
        mGestureName = "Four Finger Swipe Lift, 4 Fingers";
        goto L16
    L6:
        mGestureName = "Four Finger Swipe, 4 Fingers";
        goto L16
    L7:
        mGestureName = "Metrics";
        goto L16
    L8:
        mGestureName = "Swipe Lift, 3 Fingers";
        goto L16
    L9:
        mGestureName = "Pinch, 2 Fingers";
        goto L16
    L10:
        mGestureName = "Swipe, 3 Fingers";
        goto L16
    L11:
        mGestureName = "Fling";
        goto L16
    L12:
        mGestureName = "Buttons Change, 1 Fingers";
        goto L16
    L13:
        mGestureName = "Scroll, 2 Fingers";
        goto L16
    L14:
        mGestureName = "Move, 1 Finger";
        goto L16
    }
}
