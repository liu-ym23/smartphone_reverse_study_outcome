package com.android.server.input.debug;

import android.R;
import android.animation.LayoutTransition;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Typeface;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.Slog;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.RoundedCorner;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.AccelerateInterpolator;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.server.input.InputManagerService;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public class FocusEventDebugView extends RelativeLayout {
    private static final int KEY_FADEOUT_DURATION_MILLIS = 1000;
    private static final int KEY_SEPARATION_MARGIN_DP = 16;
    private static final int KEY_TRANSITION_DURATION_MILLIS = 100;
    private static final int KEY_VIEW_MIN_WIDTH_DP = 32;
    private static final int KEY_VIEW_SIDE_PADDING_DP = 16;
    private static final int KEY_VIEW_TEXT_SIZE_SP = 12;
    private static final int KEY_VIEW_VERTICAL_PADDING_DP = 8;
    private static final int OUTER_PADDING_DP = 16;
    private static final double ROTATY_GRAPH_HEIGHT_FRACTION = 0.5d;
    private static final String TAG = null;
    private final DisplayMetrics mDm;
    private FocusEventDebugGlobalMonitor mFocusEventDebugGlobalMonitor;
    private final int mOuterPadding;
    private PressedKeyContainer mPressedKeyContainer;
    private final Map<Pair<Integer, Integer>, PressedKeyView> mPressedKeys;
    private PressedKeyContainer mPressedModifierContainer;
    private RotaryInputGraphView mRotaryInputGraphView;
    private final Supplier<RotaryInputGraphView> mRotaryInputGraphViewFactory;
    private RotaryInputValueView mRotaryInputValueView;
    private final Supplier<RotaryInputValueView> mRotaryInputValueViewFactory;
    private final InputManagerService mService;

    private static class PressedKeyContainer extends LinearLayout {
        private final ViewGroup.MarginLayoutParams mPressedKeyLayoutParams;

        public static /* synthetic */ void $r8$lambda$XW_ZGzYK77nQqvhUBkBbx8EKOpE(PressedKeyContainer r0) {
            r0.cleanUpPressedKeyViews();
        }

        PressedKeyContainer(Context c) {
            super(c);
            DisplayMetrics dm = c.getResources().getDisplayMetrics();
            int keySeparationMargin = (int) TypedValue.applyDimension(1, 16.0f, dm);
            LayoutTransition transition = new LayoutTransition();
            transition.disableTransitionType(2);
            transition.disableTransitionType(3);
            transition.disableTransitionType(1);
            transition.setDuration(100);
            setLayoutTransition(transition);
            this.mPressedKeyLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
            if (getOrientation() != 1) goto L5;
            this.mPressedKeyLayoutParams.setMargins(0, keySeparationMargin, 0, 0);
            return;
        L5:
            this.mPressedKeyLayoutParams.setMargins(keySeparationMargin, 0, 0, 0);
        }

        public void handleKeyPressed(PressedKeyView pressedKeyView) {
            addView(pressedKeyView, getChildCount(), this.mPressedKeyLayoutParams);
            invalidate();
        }

        public void handleKeyRepeat(PressedKeyView repeatedKeyView) {
        }

        public void handleKeyRelease(PressedKeyView releasedKeyView) {
            releasedKeyView.setHighlighted(false);
            releasedKeyView.clearAnimation();
            releasedKeyView.animate().alpha(0.0f).setDuration(1000).setInterpolator(new AccelerateInterpolator()).withEndAction(new FocusEventDebugView$PressedKeyContainer$$ExternalSyntheticLambda0(this)).start();
        }

        private void cleanUpPressedKeyViews() {
            int numChildrenToRemove = 0;
            int i = 0;
        L4:
            if (i >= getChildCount()) goto L9;
            View child = getChildAt(i);
            if (child.getAlpha() != 0.0f) goto L9;
            child.setVisibility(8);
            child.clearAnimation();
            numChildrenToRemove = numChildrenToRemove + 1;
            i = i + 1;
        L9:
            removeViews(0, numChildrenToRemove);
            invalidate();
        }
    }

    private static class PressedKeyView extends TextView {
        private static final ColorFilter sInvertColors = null;

        static {
            sInvertColors = new ColorMatrixColorFilter(new float[]{-1.0f, 0.0f, 0.0f, 0.0f, 255.0f, 0.0f, -1.0f, 0.0f, 0.0f, 255.0f, 0.0f, 0.0f, -1.0f, 0.0f, 255.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
        }

        PressedKeyView(Context c, String label) {
            super(c);
            DisplayMetrics dm = c.getResources().getDisplayMetrics();
            int keyViewSidePadding = (int) TypedValue.applyDimension(1, 16.0f, dm);
            int keyViewVerticalPadding = (int) TypedValue.applyDimension(1, 8.0f, dm);
            int keyViewMinWidth = (int) TypedValue.applyDimension(1, 32.0f, dm);
            int textSize = (int) TypedValue.applyDimension(2, 12.0f, dm);
            setText(label);
            setGravity(17);
            setMinimumWidth(keyViewMinWidth);
            setTextSize(textSize);
            setTypeface(Typeface.SANS_SERIF);
            setBackgroundResource(R.drawable.ic_menu_home);
            setPaddingRelative(keyViewSidePadding, keyViewVerticalPadding, keyViewSidePadding, keyViewVerticalPadding);
            setHighlighted(true);
        }

        void setHighlighted(boolean isHighlighted) {
            if (isHighlighted == false) goto L4;
            setTextColor(AudioFormat.MAIN_MASK);
            getBackground().setColorFilter(sInvertColors);
        L5:
            invalidate();
            return;
        L4:
            setTextColor(-1);
            getBackground().clearColorFilter();
            goto L5
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$4-MbPQG9vwYM0KeLxCm0j2tSBSI, reason: not valid java name */
    public static /* synthetic */ void m4611$r8$lambda$4MbPQG9vwYM0KeLxCm0j2tSBSI(FocusEventDebugView r0, MotionEvent r1) {
        r0.lambda$reportMotionEvent$6(r1);
    }

    public static /* synthetic */ void $r8$lambda$NOfikC3SqQwvKrlgqWnqfisz50A(FocusEventDebugView r0, boolean r1) {
        r0.lambda$updateShowKeyPresses$2(r1);
    }

    public static /* synthetic */ void $r8$lambda$UcEDdccFvSdN5GowJOoOhJu1fao(FocusEventDebugView r0, KeyEvent r1) {
        r0.lambda$reportKeyEvent$5(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$b1UcQjqmeeWkZ_OQz-eMn3ckhfQ, reason: not valid java name */
    public static /* synthetic */ void m4612$r8$lambda$b1UcQjqmeeWkZ_OQzeMn3ckhfQ(HorizontalScrollView r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        lambda$handleUpdateShowKeyPresses$4(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ RotaryInputGraphView $r8$lambda$clGsfRpmOqtjVN63x2YrMnEaYSg(Context r0) {
        return lambda$new$1(r0);
    }

    public static /* synthetic */ RotaryInputValueView $r8$lambda$vobHUxs2P3Uv6Szxm0TMwjZMeD0(Context r0) {
        return lambda$new$0(r0);
    }

    public static /* synthetic */ void $r8$lambda$wRBbJ_wMpYkGR2WgNIBppqz8j3M(FocusEventDebugView r0, boolean r1) {
        r0.lambda$updateShowRotaryInput$3(r1);
    }

    static {
        TAG = FocusEventDebugView.class.getSimpleName();
    }

    FocusEventDebugView(Context c, InputManagerService service, Supplier<RotaryInputValueView> rotaryInputValueViewFactory, Supplier<RotaryInputGraphView> rotaryInputGraphViewFactory) {
        super(c);
        this.mPressedKeys = new HashMap();
        setFocusableInTouchMode(true);
        this.mService = service;
        this.mRotaryInputValueViewFactory = rotaryInputValueViewFactory;
        this.mRotaryInputGraphViewFactory = rotaryInputGraphViewFactory;
        this.mDm = ((RelativeLayout) this).mContext.getResources().getDisplayMetrics();
        this.mOuterPadding = (int) TypedValue.applyDimension(1, 16.0f, this.mDm);
    }

    public FocusEventDebugView(final Context c, InputManagerService service) {
        this(c, service, new FocusEventDebugView$$ExternalSyntheticLambda5(c), new FocusEventDebugView$$ExternalSyntheticLambda6(c));
    }

    private static /* synthetic */ RotaryInputValueView lambda$new$0(Context c) {
        return new RotaryInputValueView(c);
    }

    private static /* synthetic */ RotaryInputGraphView lambda$new$1(Context c) {
        return new RotaryInputGraphView(c);
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets insets) {
        int paddingBottom = 0;
        RoundedCorner bottomLeft = insets.getRoundedCorner(3);
        if (bottomLeft != null) goto L5;
    L7:
        RoundedCorner bottomRight = insets.getRoundedCorner(2);
        if (bottomRight == null) goto L13;
        if (insets.isRound() == true) goto L13;
        paddingBottom = Math.max(paddingBottom, bottomRight.getRadius());
    L13:
        if (insets.getDisplayCutout() == null) goto L15;
        paddingBottom = Math.max(paddingBottom, insets.getDisplayCutout().getSafeInsetBottom());
    L15:
        setPadding(this.mOuterPadding, this.mOuterPadding, this.mOuterPadding, this.mOuterPadding + paddingBottom);
        setClipToPadding(false);
        invalidate();
        return super.onApplyWindowInsets(insets);
    L5:
        if (insets.isRound() == true) goto L7;
        paddingBottom = bottomLeft.getRadius();
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent event) {
        handleKeyEvent(event);
        return super.dispatchKeyEvent(event);
    }

    private /* synthetic */ void lambda$updateShowKeyPresses$2(boolean enabled) {
        handleUpdateShowKeyPresses(enabled);
    }

    public void updateShowKeyPresses(final boolean enabled) {
        post(new FocusEventDebugView$$ExternalSyntheticLambda0(this, enabled));
    }

    private /* synthetic */ void lambda$updateShowRotaryInput$3(boolean enabled) {
        handleUpdateShowRotaryInput(enabled);
    }

    public void updateShowRotaryInput(final boolean enabled) {
        post(new FocusEventDebugView$$ExternalSyntheticLambda4(this, enabled));
    }

    private void handleUpdateShowKeyPresses(boolean enabled) {
        if (enabled != showKeyPresses()) goto L5;
        return;
    L5:
        if (enabled == true) goto L8;
        removeView(this.mPressedKeyContainer);
        this.mPressedKeyContainer = null;
        removeView(this.mPressedModifierContainer);
        this.mPressedModifierContainer = null;
        return;
    L8:
        this.mPressedKeyContainer = new PressedKeyContainer(((RelativeLayout) this).mContext);
        this.mPressedKeyContainer.setOrientation(0);
        this.mPressedKeyContainer.setGravity(85);
        this.mPressedKeyContainer.setLayoutDirection(0);
        final HorizontalScrollView scroller = new HorizontalScrollView(((RelativeLayout) this).mContext);
        scroller.addView(this.mPressedKeyContainer);
        scroller.setHorizontalScrollBarEnabled(false);
        scroller.addOnLayoutChangeListener(new FocusEventDebugView$$ExternalSyntheticLambda1(scroller));
        scroller.setHorizontalFadingEdgeEnabled(true);
        RelativeLayout.LayoutParams scrollerLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        scrollerLayoutParams.addRule(12);
        scrollerLayoutParams.addRule(11);
        addView(scroller, scrollerLayoutParams);
        this.mPressedModifierContainer = new PressedKeyContainer(((RelativeLayout) this).mContext);
        this.mPressedModifierContainer.setOrientation(1);
        this.mPressedModifierContainer.setGravity(83);
        RelativeLayout.LayoutParams modifierLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        modifierLayoutParams.addRule(12);
        modifierLayoutParams.addRule(9);
        modifierLayoutParams.addRule(0, scroller.getId());
        addView(this.mPressedModifierContainer, modifierLayoutParams);
    }

    private static /* synthetic */ void lambda$handleUpdateShowKeyPresses$4(HorizontalScrollView scroller, View view, int l, int t, int r, int b, int ol, int ot, int or, int ob) {
        scroller.fullScroll(66);
    }

    void handleUpdateShowRotaryInput(boolean enabled) {
        if (enabled != showRotaryInput()) goto L5;
        return;
    L5:
        if (enabled == true) goto L8;
        this.mFocusEventDebugGlobalMonitor.dispose();
        this.mFocusEventDebugGlobalMonitor = null;
        removeView(this.mRotaryInputValueView);
        this.mRotaryInputValueView = null;
        removeView(this.mRotaryInputGraphView);
        this.mRotaryInputGraphView = null;
        return;
    L8:
        this.mFocusEventDebugGlobalMonitor = new FocusEventDebugGlobalMonitor(this, this.mService);
        this.mRotaryInputValueView = this.mRotaryInputValueViewFactory.get();
        RelativeLayout.LayoutParams valueLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        valueLayoutParams.addRule(14);
        valueLayoutParams.addRule(12);
        addView(this.mRotaryInputValueView, valueLayoutParams);
        this.mRotaryInputGraphView = this.mRotaryInputGraphViewFactory.get();
        RelativeLayout.LayoutParams graphLayoutParams = new RelativeLayout.LayoutParams(-1, (int) (((double) this.mDm.heightPixels) * ROTATY_GRAPH_HEIGHT_FRACTION));
        graphLayoutParams.addRule(13);
        addView(this.mRotaryInputGraphView, graphLayoutParams);
    }

    public void reportKeyEvent(KeyEvent event) {
        final KeyEvent keyEvent = KeyEvent.obtain(event);
        post(new FocusEventDebugView$$ExternalSyntheticLambda2(this, keyEvent));
    }

    private /* synthetic */ void lambda$reportKeyEvent$5(KeyEvent keyEvent) {
        handleKeyEvent(keyEvent);
    }

    public void reportMotionEvent(MotionEvent event) {
        if (event.getSource() == 4194304) goto L5;
        return;
    L5:
        final MotionEvent motionEvent = MotionEvent.obtain(event);
        post(new FocusEventDebugView$$ExternalSyntheticLambda3(this, motionEvent));
    }

    private /* synthetic */ void lambda$reportMotionEvent$6(MotionEvent motionEvent) {
        handleRotaryInput(motionEvent);
    }

    private void handleKeyEvent(KeyEvent keyEvent) {
        if (showKeyPresses() == true) goto L5;
        return;
    L5:
        Pair<Integer, Integer> identifier = new Pair(Integer.valueOf(keyEvent.getDeviceId()), Integer.valueOf(keyEvent.getScanCode()));
        if (KeyEvent.isModifierKey(keyEvent.getKeyCode()) == false) goto L8;
        PressedKeyContainer container = this.mPressedModifierContainer;
    L9:
        PressedKeyView pressedKeyView = this.mPressedKeys.get(identifier);
        switch(keyEvent.getAction()) {
            case 0: goto L15;
            case 1: goto L12;
            default: goto L21;
        };
    L12:
        if (pressedKeyView != null) goto L14;
        Slog.w(TAG, "Got key up for " + KeyEvent.keyCodeToString(keyEvent.getKeyCode()) + " that was not tracked as being down.");
        goto L21
    L14:
        this.mPressedKeys.remove(identifier);
        container.handleKeyRelease(pressedKeyView);
        goto L21
    L15:
        if (pressedKeyView != null) goto L17;
        PressedKeyView pressedKeyView2 = new PressedKeyView(((RelativeLayout) this).mContext, getLabel(keyEvent));
        this.mPressedKeys.put(identifier, pressedKeyView2);
        container.handleKeyPressed(pressedKeyView2);
        goto L21
    L17:
        if (keyEvent.getRepeatCount() != 0) goto L19;
        Slog.w(TAG, "Got key down for " + KeyEvent.keyCodeToString(keyEvent.getKeyCode()) + " that was already tracked as being down.");
        goto L21
    L19:
        container.handleKeyRepeat(pressedKeyView);
    L21:
        keyEvent.recycle();
        return;
    L8:
        container = this.mPressedKeyContainer;
        goto L9
    }

    void handleRotaryInput(MotionEvent motionEvent) {
        if (showRotaryInput() == true) goto L5;
        return;
    L5:
        float scrollAxisValue = motionEvent.getAxisValue(26);
        this.mRotaryInputValueView.updateValue(scrollAxisValue);
        this.mRotaryInputGraphView.addValue(scrollAxisValue, motionEvent.getEventTime());
        motionEvent.recycle();
    }

    private static String getLabel(KeyEvent event) {
        switch(event.getKeyCode()) {
            case 3: goto L51;
            case 4: goto L49;
            case 19: goto L47;
            case 20: goto L45;
            case 21: goto L43;
            case 22: goto L41;
            case 61: goto L39;
            case 62: goto L37;
            case 66: goto L35;
            case 67: goto L33;
            case 85: goto L31;
            case 111: goto L29;
            case 112: goto L27;
            case 160: goto L35;
            case 268: goto L25;
            case 269: goto L23;
            case 270: goto L21;
            case 271: goto L19;
            case 312: goto L17;
            default: goto L4;
        };
    L4:
        int unicodeChar = event.getUnicodeChar();
        if (unicodeChar != 0) goto L7;
        String label = KeyEvent.keyCodeToString(event.getKeyCode());
        if (label.startsWith("KEYCODE_") == true) goto L15;
        return label;
    L15:
        return label.substring(8);
    L7:
        if ((Integer.MIN_VALUE & unicodeChar) == 0) goto L11;
        int combiningChar = KeyCharacterMap.getCombiningChar(Integer.MAX_VALUE & unicodeChar);
        return "◌" + String.valueOf((char) combiningChar);
    L11:
        return String.valueOf((char) unicodeChar);
    L17:
        return "□";
    L19:
        return "↘";
    L21:
        return "↗";
    L23:
        return "↙";
    L25:
        return "↖";
    L27:
        return "⌦";
    L29:
        return "esc";
    L31:
        return "⏯";
    L33:
        return "⌫";
    L35:
        return "⏎";
    L37:
        return "␣";
    L39:
        return "⇥";
    L41:
        return "→";
    L43:
        return "←";
    L45:
        return "↓";
    L47:
        return "↑";
    L49:
        return "◁";
    L51:
        return "◯";
    }

    private boolean showKeyPresses() {
        if (this.mPressedKeyContainer == null) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean showRotaryInput() {
        if (this.mRotaryInputValueView == null) goto L5;
        return true;
    L5:
        return false;
    }
}
