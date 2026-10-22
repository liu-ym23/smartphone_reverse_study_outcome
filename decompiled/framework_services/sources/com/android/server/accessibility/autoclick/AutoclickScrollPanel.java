package com.android.server.accessibility.autoclick;

import android.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.ImageButton;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class AutoclickScrollPanel {
    public static final int DIRECTION_DOWN = 1;
    public static final int DIRECTION_EXIT = 4;
    public static final int DIRECTION_LEFT = 2;
    public static final int DIRECTION_NONE = 5;
    public static final int DIRECTION_RIGHT = 3;
    public static final int DIRECTION_UP = 0;
    private final View mContentView;
    private final Context mContext;
    private final ImageButton mDownButton;
    private final ImageButton mExitButton;
    private boolean mInScrollMode;
    private final ImageButton mLeftButton;
    private final ImageButton mRightButton;
    private ScrollPanelControllerInterface mScrollPanelController;
    private final ImageButton mUpButton;
    private final WindowManager mWindowManager;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollDirection {
    }

    public interface ScrollPanelControllerInterface {
        void onHoverButtonChange(int r1, boolean r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$J0jBWuJaJLMR5-Kxli3d9cIylf0, reason: not valid java name */
    public static /* synthetic */ boolean m747$r8$lambda$J0jBWuJaJLMR5Kxli3d9cIylf0(AutoclickScrollPanel r0, int r1, View r2, MotionEvent r3) {
        return r0.lambda$setupHoverListenerForButton$0(r1, r2, r3);
    }

    public AutoclickScrollPanel(Context context, WindowManager windowManager, ScrollPanelControllerInterface controller) {
        this.mInScrollMode = false;
        this.mContext = context;
        this.mWindowManager = windowManager;
        this.mScrollPanelController = controller;
        this.mContentView = LayoutInflater.from(context).inflate(R.layout.accessibility_autoclick_scroll_panel, null);
        this.mUpButton = (ImageButton) this.mContentView.findViewById(R.id.textLongMessage);
        this.mLeftButton = (ImageButton) this.mContentView.findViewById(R.id.textEnableTextConversionSuggestions);
        this.mRightButton = (ImageButton) this.mContentView.findViewById(R.id.textFilter);
        this.mDownButton = (ImageButton) this.mContentView.findViewById(R.id.textCapWords);
        this.mExitButton = (ImageButton) this.mContentView.findViewById(R.id.textEmailAddress);
        initializeButtonState();
    }

    private void initializeButtonState() {
        setupHoverListenerForButton(this.mUpButton, 0);
        setupHoverListenerForButton(this.mLeftButton, 2);
        setupHoverListenerForButton(this.mRightButton, 3);
        setupHoverListenerForButton(this.mDownButton, 1);
        setupHoverListenerForButton(this.mExitButton, 4);
    }

    public void show() {
        if (this.mInScrollMode == false) goto L5;
        return;
    L5:
        this.mWindowManager.addView(this.mContentView, getLayoutParams());
        this.mInScrollMode = true;
    }

    public void hide() {
        if (this.mInScrollMode == true) goto L5;
        return;
    L5:
        this.mWindowManager.removeView(this.mContentView);
        this.mInScrollMode = false;
    }

    private void setupHoverListenerForButton(ImageButton button, final int direction) {
        button.setOnHoverListener(new AutoclickScrollPanel$$ExternalSyntheticLambda0(this, direction));
    }

    private /* synthetic */ boolean lambda$setupHoverListenerForButton$0(int direction, View v, MotionEvent event) {
        if (this.mScrollPanelController != null) goto L6;
        return true;
    L6:
        switch(event.getAction()) {
            case 7: goto L11;
            case 8: goto L7;
            case 9: goto L9;
            case 10: goto L8;
            default: goto L7;
        };
    L7:
        return true;
    L8:
        boolean hovered = false;
    L13:
        this.mScrollPanelController.onHoverButtonChange(direction, hovered);
        return true;
    L9:
        hovered = true;
        goto L13
    L11:
        if (direction == 4) goto L15;
        hovered = true;
        goto L13
    L15:
        return true;
    }

    private WindowManager.LayoutParams getLayoutParams() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2038;
        layoutParams.flags = 8;
        layoutParams.privateFlags |= 16;
        layoutParams.setFitInsetsTypes(WindowInsets.Type.statusBars());
        layoutParams.layoutInDisplayCutoutMode = 3;
        layoutParams.format = -3;
        layoutParams.setTitle(AutoclickScrollPanel.class.getSimpleName());
        layoutParams.accessibilityTitle = this.mContext.getString(R.string.accessibility_dialog_button_uninstall);
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public boolean isVisible() {
        return this.mInScrollMode;
    }

    public View getContentViewForTesting() {
        return this.mContentView;
    }

    public WindowManager.LayoutParams getLayoutParamsForTesting() {
        return getLayoutParams();
    }
}
