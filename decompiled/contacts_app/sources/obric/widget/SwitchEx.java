package obric.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.os.Process;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.GlobalProxyLancet;
import java.lang.ref.WeakReference;
import obric.InvokeApi;
import obric.util.VibratorSmt;

/* JADX INFO: loaded from: classes5.dex */
public class SwitchEx extends CheckBox {
    private static final int HANDLER_MESSAGE_SET_CHECKED = 1;
    private static final int MAX_ALPHA = 255;
    private static final int MIN_ALPHA = 191;
    private static final int SHADOW_ALPHA_ANIM_DURATION = 200;
    private static final int SHADOW_MAX_ALPHA = 255;
    private static final int SHADOW_MIN_ALPHA = 0;
    public static final int STYLE_DARK = 2;
    public static final int STYLE_LIGHT = 1;
    public static final int SWITCH_BOTTOM = 0;
    public static final int SWITCH_FRAME = 2;
    public static final int SWITCH_FRAME_PRESSED = 5;
    public static final int SWITCH_MASK = 3;
    public static final int SWITCH_PRESSED = 4;
    public static final int SWITCH_UNPRESSED = 1;
    private static final String TAG = "SwitchEx";
    private static boolean isClean;
    private static int[] mDrawableIds;
    private static int mStyle;
    private static Bitmap sAlphaOffBitmap;
    private static Bitmap sAlphaOnBitmap;
    private static Bitmap sBottom;
    private static final Pair<Float, Float> sBottomDefScale = null;
    private static RectF sBottomRect;
    private static Pair<Float, Float> sBottomScale;
    private static Bitmap sBtnNormal;
    private static float sBtnOffPos;
    private static float sBtnOnPos;
    private static Bitmap sBtnPressed;
    private static float sBtnWidth;
    private static int sCachedBitmapDensityDpi;
    private static Canvas sCanvas;
    private static Bitmap sCurBtnPic;
    private static final int[] sDarkDrawableIds = null;
    private static final int[] sDrawableIds = null;
    private static Bitmap sFrame;
    private static final Pair<Float, Float> sFrameDefScale = null;
    private static Bitmap sFramePressed;
    private static final Pair<Float, Float> sFramePressedDefScale = null;
    private static RectF sFramePressedRect;
    private static Pair<Float, Float> sFramePressedScale;
    private static RectF sFrameRect;
    private static Pair<Float, Float> sFrameScale;
    private static Bitmap sMask;
    private static final Pair<Float, Float> sMaskDefScale = null;
    private static float sMaskHeight;
    private static RectF sMaskRect;
    private static Pair<Float, Float> sMaskScale;
    private static float sMaskWidth;
    private static Bitmap sOffBitmap;
    private static Bitmap sOffBitmapPressed;
    private static Bitmap sOnBitmap;
    private static Bitmap sOnBitmapPressed;
    private static Paint sPaint;
    private static final Pair<Float, Float> sPressedDefScale = null;
    private static RectF sPressedRect;
    private static Pair<Float, Float> sPressedScale;
    private static final Pair<Float, Float> sUnpressedDefScale = null;
    private static Pair<Float, Float> sUnpressedScale;
    private static PorterDuffXfermode sXfermode;
    private final float ANIMATION_FRAME_DURATION;
    private final float EXTENDED_OFFSET_Y;
    private final float VELOCITY;
    private int mAlpha;
    private float mAnimatedVelocity;
    private boolean mAnimating;
    private float mAnimationPosition;
    private int mBottomResId;
    private boolean mBroadcasting;
    private float mBtnInitPos;
    private float mBtnPos;
    private boolean mChecked;
    private int mClickTimeout;
    private float mExtendOffsetY;
    private float mFirstDownX;
    private float mFirstDownY;
    private final Handler mHandler;
    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener;
    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeWidgetListener;
    public View.OnClickListener mOnClickListener;
    private ViewParent mParent;
    private PerformClick mPerformClick;
    private int mPressedShadowAlpha;
    private float mRealPos;
    private Resources mResources;
    boolean mRestoring;
    private ValueAnimator mShadowAlphaAnim;
    private int mTouchSlop;
    private boolean mTouching;
    private float mVelocity;
    private boolean mVibrateFeedback;
    private Vibrator mVibrator;

    private static final class CheckHandler extends Handler {
        private WeakReference<SwitchEx> weakReference;

        CheckHandler(SwitchEx switchEx) {
            this.weakReference = new WeakReference(switchEx);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message msg) {
            WeakReference<SwitchEx> r2 = this.weakReference;
            if (r2 == null) goto L9;
            SwitchEx r3 = r2.get();
            if (msg.what != 1) goto L10;
            if (r3 == null) goto L11;
            SwitchEx.access$000(r3, ((Boolean) msg.obj).booleanValue(), false, true);
            return;
        L11:
            return;
        L10:
            return;
        }
    }

    private final class PerformClick implements Runnable {
        final /* synthetic */ SwitchEx this$0;

        private PerformClick(final SwitchEx this$0) {
            this.this$0 = this$0;
        }

        /* synthetic */ PerformClick(SwitchEx r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.performClick();
        }
    }

    static /* synthetic */ void access$000(SwitchEx r0, boolean r1, boolean r2, boolean r3) {
        r0.setChecked(r1, r2, r3);
    }

    static /* synthetic */ int access$202(SwitchEx r0, int r1) {
        r0.mPressedShadowAlpha = r1;
        return r1;
    }

    static {
        sXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        sCanvas = new Canvas();
        sPaint = new Paint();
        int[] r1 = {R.drawable.switch_ex_bottom_2, R.drawable.switch_ex_unpressed, R.drawable.switch_ex_frame, R.drawable.switch_ex_mask, R.drawable.switch_ex_pressed, R.drawable.switch_ex_frame_pressed};
        sDrawableIds = r1;
        sDarkDrawableIds = new int[]{R.drawable.switch_ex_bottom_dark, R.drawable.switch_ex_unpressed_dark, R.drawable.switch_ex_frame_dark, R.drawable.switch_ex_mask_dark, R.drawable.switch_ex_pressed_dark, R.drawable.switch_ex_frame_pressed_dark};
        mDrawableIds = r1;
        mStyle = 1;
        Float r2 = Float.valueOf(286.0f);
        Float r3 = Float.valueOf(144.0f);
        sBottomDefScale = new Pair(r2, r3);
        sUnpressedDefScale = new Pair(r2, r3);
        Float r4 = Float.valueOf(198.0f);
        sFrameDefScale = new Pair(r4, r3);
        sMaskDefScale = new Pair(r4, r3);
        sPressedDefScale = new Pair(r2, r3);
        sFramePressedDefScale = new Pair(r4, r3);
        sMaskRect = new RectF();
        sBottomRect = new RectF();
        sFrameRect = new RectF();
        sFramePressedRect = new RectF();
        sPressedRect = new RectF();
    }

    public SwitchEx(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.checkboxStyle);
    }

    public SwitchEx(Context context) {
        this(context, null);
    }

    public static void initSwitchBitmap(Resources r) {
        if (isDensityDpiChanged(r) == false) goto L6;
        clearSwitchBitmap(false);
    L6:
        if (sBottom != null) goto L8;
    L17:
        sBottom = ((BitmapDrawable) r.getDrawable(mDrawableIds[0])).getBitmap();
        sBtnNormal = ((BitmapDrawable) r.getDrawable(mDrawableIds[1])).getBitmap();
        sBtnPressed = ((BitmapDrawable) r.getDrawable(mDrawableIds[4])).getBitmap();
        sFrame = ((BitmapDrawable) r.getDrawable(mDrawableIds[2])).getBitmap();
        sFramePressed = ((BitmapDrawable) r.getDrawable(mDrawableIds[5])).getBitmap();
        sMask = ((BitmapDrawable) r.getDrawable(mDrawableIds[3])).getBitmap();
        sCurBtnPic = sBtnNormal;
        initDrawableScaleThroughDpi(r);
    L18:
        sPaint.setColor(-1);
        sBtnWidth = ((Float) sUnpressedScale.first).floatValue();
        sMaskWidth = ((Float) sMaskScale.first).floatValue();
        sMaskHeight = ((Float) sMaskScale.second).floatValue();
        float r2 = sBtnWidth;
        sBtnOnPos = r2 / 2.0f;
        sBtnOffPos = sMaskWidth - (r2 / 2.0f);
        initBitmap();
        return;
    L8:
        if (sBtnNormal == null) goto L17;
        if (sFrame == null) goto L17;
        if (sMask == null) goto L17;
        if (sBtnPressed == null) goto L17;
        if (sFramePressed != null) goto L18;
        goto L17
    }

    private static void initDrawableScaleThroughDpi(Resources r) {
        int r1 = r.getConfiguration().densityDpi;
        sBottomScale = changeScaleThroughDpi(sBottomDefScale, r1);
        sUnpressedScale = changeScaleThroughDpi(sUnpressedDefScale, r1);
        sFrameScale = changeScaleThroughDpi(sFrameDefScale, r1);
        sMaskScale = changeScaleThroughDpi(sMaskDefScale, r1);
        sPressedScale = changeScaleThroughDpi(sPressedDefScale, r1);
        sFramePressedScale = changeScaleThroughDpi(sFramePressedDefScale, r1);
        sCachedBitmapDensityDpi = r1;
    }

    private static boolean isDensityDpiChanged(Resources r) {
        if (sCachedBitmapDensityDpi == r.getConfiguration().densityDpi) goto L5;
        return true;
    L5:
        return false;
    }

    private static Pair<Float, Float> changeScaleThroughDpi(Pair<Float, Float> scale, int currentDpi) {
        if (currentDpi != 480) goto L5;
        return scale;
    L5:
        float r3 = currentDpi;
        return Pair.create(Float.valueOf((((Float) scale.first).floatValue() * r3) / 480.0f), Float.valueOf((r3 * ((Float) scale.second).floatValue()) / 480.0f));
    }

    public static void clearSwitchBitmap() {
        clearSwitchBitmap(true);
    }

    private static void clearSwitchBitmap(boolean resetStyle) {
        sBottom = null;
        sBtnNormal = null;
        sBtnPressed = null;
        sFrame = null;
        sFramePressed = null;
        sMask = null;
        sAlphaOnBitmap = null;
        sAlphaOffBitmap = null;
        sOnBitmap = null;
        sOnBitmapPressed = null;
        sOffBitmap = null;
        sOffBitmapPressed = null;
        isClean = true;
        if (resetStyle == false) goto L6;
        mStyle = 1;
        applySwithStyle();
        return;
    }

    public SwitchEx(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.VELOCITY = 350.0f;
        this.EXTENDED_OFFSET_Y = 2.0f;
        this.ANIMATION_FRAME_DURATION = 16.0f;
        this.mPressedShadowAlpha = 0;
        this.mAlpha = 255;
        this.mChecked = false;
        this.mRestoring = false;
        this.mHandler = new CheckHandler(this);
        if (this.mResources != null) goto L5;
        this.mResources = context.getResources();
    L5:
        setVibrateFeedbackEnabled(true);
        initSwitchResource();
        initView(context);
    }

    private void initSwitchResource() {
        applySwithStyle();
        initSwitchBitmap(this.mResources);
    }

    private static void applySwithStyle() {
        int r0 = mStyle;
        if (r0 != 2) goto L6;
        int[] r1 = sDarkDrawableIds;
    L12:
        mDrawableIds = r1;
        return;
    L6:
        if (r0 != 1) goto L9;
        r1 = sDrawableIds;
        goto L12
    L9:
        if (mDrawableIds != null) goto L11;
        r1 = sDrawableIds;
        goto L12
    L11:
        r1 = null;
        goto L12
    }

    private void initView(Context context) {
        this.mClickTimeout = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        if (this.mChecked == false) goto L5;
        float r3 = sBtnOnPos;
    L6:
        this.mBtnPos = r3;
        this.mRealPos = getRealPos(r3);
        float r4 = getResources().getDisplayMetrics().density;
        this.mVelocity = (int) ((350.0f * r4) + 0.5f);
        this.mExtendOffsetY = (int) ((r4 * 2.0f) + 0.5f);
        return;
    L5:
        r3 = sBtnOffPos;
        goto L6
    }

    private static void initBitmap() {
        isClean = false;
        if (sAlphaOnBitmap != null) goto L5;
    L14:
        sAlphaOnBitmap = createBitmap(MIN_ALPHA, getRealPos(sBtnOnPos), 0);
        sAlphaOffBitmap = createBitmap(MIN_ALPHA, getRealPos(sBtnOffPos), 0);
        sOnBitmap = createBitmap(255, getRealPos(sBtnOnPos), 0);
        sOnBitmapPressed = createBitmap(255, getRealPos(sBtnOnPos), 255);
        sOffBitmap = createBitmap(255, getRealPos(sBtnOffPos), 0);
        sOffBitmapPressed = createBitmap(255, getRealPos(sBtnOffPos), 255);
        return;
    L5:
        if (sAlphaOffBitmap == null) goto L14;
        if (sOnBitmap == null) goto L14;
        if (sOffBitmap == null) goto L14;
        if (sOnBitmapPressed == null) goto L14;
        if (sOffBitmapPressed == null) goto L14;
    }

    @Deprecated
    public void setSwitchDrawable(int type, Bitmap bitmap) {
        setSwitchDrawableStyle(2);
    }

    public void setSwitchDrawableStyle(int style) {
        if (mStyle != style) goto L5;
        return;
    L5:
        mStyle = style;
        clearSwitchBitmap(false);
        initSwitchResource();
        invalidate();
    }

    public void setSwitchDrawables(SparseIntArray sparseIntArray) {
        setDrawableIds(new int[]{sparseIntArray.get(0), sparseIntArray.get(1), sparseIntArray.get(2), sparseIntArray.get(3), sparseIntArray.get(4), sparseIntArray.get(5)});
        clearSwitchBitmap(false);
        initSwitchBitmap(this.mResources);
        invalidate();
    }

    private static void setDrawableIds(int[] drawableIds) {
        mDrawableIds = drawableIds;
    }

    public void setBottomDrawable(int resId) {
        if (this.mBottomResId != resId) goto L5;
        return;
    L5:
        this.mBottomResId = resId;
        sBottom = ((BitmapDrawable) this.mResources.getDrawable(resId)).getBitmap();
        resetBitmaps();
    }

    public void setFrameDrawable(int resId) {
        if (resId != (-1)) goto L5;
        sFrame = ((BitmapDrawable) this.mResources.getDrawable(R.drawable.switch_ex_frame)).getBitmap();
    L6:
        resetBitmaps();
        return;
    L5:
        sFrame = ((BitmapDrawable) this.mResources.getDrawable(resId)).getBitmap();
        goto L6
    }

    private void resetBitmaps() {
        sAlphaOnBitmap = null;
        sAlphaOffBitmap = null;
        sOnBitmap = null;
        sOnBitmapPressed = null;
        sOffBitmap = null;
        sOffBitmapPressed = null;
        initBitmap();
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean enabled) {
        if (enabled == false) goto L4;
        int r0 = 255;
    L5:
        this.mAlpha = r0;
        super.setEnabled(enabled);
        return;
    L4:
        r0 = MIN_ALPHA;
        goto L5
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public boolean isChecked() {
        return this.mChecked;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!this.mChecked);
    }

    private void setCheckedFromUser(boolean checked) {
        this.mHandler.removeMessages(1);
        Handler r2 = this.mHandler;
        r2.sendMessageDelayed(r2.obtainMessage(1, Boolean.valueOf(checked)), 20);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean checked) {
        setChecked(checked, true, false);
    }

    private void setChecked(boolean checked, boolean needInvalidate, boolean fromUser) {
        if (this.mChecked == checked) goto L27;
        this.mChecked = checked;
        if (needInvalidate == false) goto L10;
        if (checked == false) goto L8;
        float r2 = sBtnOnPos;
    L9:
        this.mBtnPos = r2;
        this.mRealPos = getRealPos(r2);
        invalidate();
        goto L10
    L8:
        r2 = sBtnOffPos;
    L10:
        InvokeApi.xView.notifyViewAccessibilityStateChangedIfNeeded(this, 0);
        if (this.mBroadcasting == false) goto L13;
        return;
    L13:
        if (this.mRestoring == true) goto L29;
        this.mBroadcasting = true;
        CompoundButton.OnCheckedChangeListener r3 = this.mOnCheckedChangeListener;
        if (r3 == null) goto L18;
        r3.onCheckedChanged(this, this.mChecked);
    L18:
        CompoundButton.OnCheckedChangeListener r4 = this.mOnCheckedChangeWidgetListener;
        if (r4 == null) goto L21;
        r4.onCheckedChanged(this, this.mChecked);
    L21:
        if (fromUser == true) goto L23;
    L25:
        this.mBroadcasting = false;
        return;
    L23:
        if (this.mVibrateFeedback == false) goto L25;
        vibrateFeedback();
        goto L25
    L29:
        return;
    }

    public void setVibrateFeedbackEnabled(boolean enabled) {
        this.mVibrateFeedback = enabled;
    }

    private void vibrateFeedback() {
        if (checkVibratePermission() == true) goto L6;
        return;
    L6:
        if (this.mVibrator != null) goto L8;
        this.mVibrator = (Vibrator) getContext().getApplicationContext().getSystemService("vibrator");
        VibrationEffect r0 = VibrationEffect.get(0);
        this.mVibrator.vibrate(r0);
    L8:
        this.mVibrator.cancel();
        VibratorSmt.vibrateEffect(this.mVibrator, 0);
    }

    private boolean checkVibratePermission() {
        Context r3 = getContext();
        if (r3.checkPermission("android.permission.VIBRATE", Process.myPid(), Process.myUid()) != 0) goto L6;
        return true;
    L6:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "android.permission.VIBRATE permission DENIED for package : " + r3.getPackageName());
        return false;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        this.mRestoring = true;
        super.onRestoreInstanceState(state);
        this.mRestoring = false;
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener listener) {
        this.mOnCheckedChangeListener = listener;
    }

    void setOnCheckedChangeWidgetListener(CompoundButton.OnCheckedChangeListener listener) {
        this.mOnCheckedChangeWidgetListener = listener;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (this.mAnimating == false) goto L5;
    L46:
        return true;
    L5:
        if (isEnabled() == false) goto L46;
        int r0 = event.getAction();
        float r2 = event.getX();
        float r3 = event.getY();
        float r4 = Math.abs(r2 - this.mFirstDownX);
        float r5 = Math.abs(r3 - this.mFirstDownY);
        if (r0 != 0) goto L10;
        attemptClaimDrag();
        this.mTouching = true;
        cancelShadowAlphaAnim();
        this.mPressedShadowAlpha = 255;
        this.mFirstDownX = r2;
        this.mFirstDownY = r3;
        if (this.mChecked == false) goto L43;
        float r9 = sBtnOnPos;
    L44:
        this.mBtnInitPos = r9;
    L45:
        invalidate();
        goto L46
    L43:
        r9 = sBtnOffPos;
        goto L44
    L10:
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L15;
        if (r0 != 3) goto L45;
    L15:
        float r6 = (this.mBtnInitPos + event.getX()) - this.mFirstDownX;
        this.mBtnPos = r6;
        float r7 = sBtnOnPos;
        if (r6 < r7) goto L18;
        this.mBtnPos = r7;
    L18:
        float r8 = this.mBtnPos;
        float r10 = sBtnOffPos;
        if (r8 > r10) goto L21;
        this.mBtnPos = r10;
    L21:
        this.mRealPos = getRealPos(this.mBtnPos);
        if (r0 == 2) goto L45;
        boolean r1 = false;
        this.mTouching = false;
        startShadowAlphaAnimation();
        float r11 = event.getEventTime() - event.getDownTime();
        int r12 = this.mTouchSlop;
        if (r5 < r12) goto L27;
    L36:
        float r13 = this.mBtnPos;
        float r14 = sBtnOnPos;
        float r15 = sBtnOffPos;
        if (r13 <= (((r14 - r15) / 2.0f) + r15)) goto L39;
        r1 = true;
    L39:
        startAnimation(r1);
        setCheckedFromUser(r1);
        goto L45
    L27:
        if (r4 >= r12) goto L36;
        if (r11 >= this.mClickTimeout) goto L36;
        if (this.mPerformClick != null) goto L34;
        this.mPerformClick = new PerformClick(this, null);
    L34:
        if (post(this.mPerformClick) == true) goto L45;
        performClick();
        goto L45
    }

    @Override // android.widget.CompoundButton, android.view.View
    public boolean performClick() {
        View.OnClickListener r0 = this.mOnClickListener;
        if (r0 == null) goto L5;
        r0.onClick(this);
    L5:
        startAnimation(!this.mChecked);
        setCheckedFromUser(!this.mChecked);
        return true;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener l) {
        if (isClickable() == true) goto L5;
        setClickable(true);
    L5:
        this.mOnClickListener = l;
    }

    private void attemptClaimDrag() {
        ViewParent r0 = getParent();
        this.mParent = r0;
        if (r0 == null) goto L6;
        r0.requestDisallowInterceptTouchEvent(true);
        return;
    }

    private static float getRealPos(float btnPos) {
        return btnPos - (sBtnWidth / 2.0f);
    }

    private Bitmap createBitmap() {
        return createBitmap(this.mAlpha, this.mRealPos, this.mPressedShadowAlpha);
    }

    private static Bitmap createBitmap(int alpha, float pos, int shadowAlpha) {
        Bitmap r0 = Bitmap.createBitmap(Math.round(((Float) sMaskScale.first).floatValue()), Math.round(((Float) sMaskScale.second).floatValue()), Bitmap.Config.ARGB_8888);
        sCanvas.setBitmap(r0);
        sPaint.setAlpha(alpha);
        sMaskRect.set(0.0f, 0.0f, ((Float) sMaskScale.first).floatValue(), ((Float) sMaskScale.second).floatValue());
        sCanvas.drawBitmap(sMask, null, sMaskRect, sPaint);
        sPaint.setXfermode(sXfermode);
        sBottomRect.set(pos, 0.0f, ((Float) sBottomScale.first).floatValue() + pos, ((Float) sBottomScale.second).floatValue());
        sCanvas.drawBitmap(sBottom, null, sBottomRect, sPaint);
        sPaint.setXfermode(null);
        sFrameRect.set(0.0f, 0.0f, ((Float) sFrameScale.first).floatValue(), ((Float) sFrameScale.second).floatValue());
        sCanvas.drawBitmap(sFrame, null, sFrameRect, sPaint);
        if (shadowAlpha <= 0) goto L5;
        int r7 = sPaint.getAlpha();
        sPaint.setAlpha(shadowAlpha);
        sFramePressedRect.set(0.0f, 0.0f, ((Float) sFramePressedScale.first).floatValue(), ((Float) sFramePressedScale.second).floatValue());
        sCanvas.drawBitmap(sFramePressed, null, sFramePressedRect, sPaint);
        sPaint.setAlpha(r7);
    L5:
        sPressedRect.set(pos, 0.0f, ((Float) sPressedScale.first).floatValue() + pos, ((Float) sPressedScale.second).floatValue());
        if (shadowAlpha != 255) goto L8;
        sCanvas.drawBitmap(sBtnPressed, null, sPressedRect, sPaint);
    L9:
        return r0;
    L8:
        sCanvas.drawBitmap(sCurBtnPic, null, sPressedRect, sPaint);
        goto L9
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (isClean == false) goto L5;
    L6:
        initSwitchBitmap(this.mResources);
    L7:
        canvas.save();
        float r0 = getRealPos(sBtnOnPos);
        float r1 = getRealPos(sBtnOffPos);
        if (this.mAlpha == 255) goto L10;
        float r2 = this.mRealPos;
        if (r2 != r1) goto L30;
        Bitmap r3 = sAlphaOffBitmap;
    L33:
        sPaint.setAlpha(this.mAlpha);
        canvas.drawBitmap(r3, 0.0f, this.mExtendOffsetY, sPaint);
        canvas.restore();
        float r7 = this.mRealPos;
        if (r7 > r1) goto L37;
        stopAnimation();
        this.mAnimationPosition = sBtnOffPos;
        return;
    L37:
        if (r7 < r0) goto L40;
        stopAnimation();
        this.mAnimationPosition = sBtnOnPos;
        return;
    L40:
        if (this.mAnimating == false) goto L45;
        doAnimation();
        return;
    L45:
        return;
    L30:
        if (r2 != r0) goto L32;
        r3 = sAlphaOnBitmap;
        goto L33
    L32:
        r3 = createBitmap();
        goto L33
    L10:
        if (this.mRealPos != r1) goto L18;
        if (isShadowAlphaAnimRunning() == true) goto L18;
        if (this.mTouching == false) goto L16;
        r3 = sOffBitmapPressed;
        goto L33
    L16:
        r3 = sOffBitmap;
    L18:
        if (this.mRealPos == r0) goto L20;
    L25:
        r3 = createBitmap();
        goto L33
    L20:
        if (isShadowAlphaAnimRunning() == true) goto L25;
        if (this.mTouching == false) goto L24;
        r3 = sOnBitmapPressed;
        goto L33
    L24:
        r3 = sOnBitmap;
        goto L33
    L5:
        if (isDensityDpiChanged(this.mResources) == false) goto L7;
        goto L6
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension((int) sMaskWidth, (int) (sMaskHeight + (this.mExtendOffsetY * 2.0f)));
    }

    private void startAnimation(boolean turnOn) {
        if (turnOn == false) goto L4;
        float r1 = this.mVelocity;
    L5:
        this.mAnimatedVelocity = r1;
        this.mAnimationPosition = this.mBtnPos;
        this.mAnimating = true;
        doAnimation();
        return;
    L4:
        r1 = -this.mVelocity;
        goto L5
    }

    private void stopAnimation() {
        this.mAnimating = false;
    }

    private void doAnimation() {
        float r0 = this.mAnimationPosition + ((this.mAnimatedVelocity * 16.0f) / 1000.0f);
        this.mAnimationPosition = r0;
        if (r0 > sBtnOffPos) goto L6;
        stopAnimation();
        this.mAnimationPosition = sBtnOffPos;
    L8:
        moveView(this.mAnimationPosition);
        return;
    L6:
        if (r0 < sBtnOnPos) goto L8;
        stopAnimation();
        this.mAnimationPosition = sBtnOnPos;
        goto L8
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cancelShadowAlphaAnim();
    }

    private void startShadowAlphaAnimation() {
        if (this.mShadowAlphaAnim != null) goto L5;
        ValueAnimator r0 = ValueAnimator.ofInt(new int[]{255, 0});
        this.mShadowAlphaAnim = r0;
        r0.addUpdateListener(new AnonymousClass1(this));
        this.mShadowAlphaAnim.setDuration(200);
    L5:
        this.mShadowAlphaAnim.start();
    }

    private boolean isShadowAlphaAnimRunning() {
        ValueAnimator r0 = this.mShadowAlphaAnim;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isRunning() == false) goto L7;
        return true;
    }

    private void cancelShadowAlphaAnim() {
        if (isShadowAlphaAnimRunning() == false) goto L6;
        this.mShadowAlphaAnim.cancel();
        return;
    }

    private void moveView(float position) {
        this.mBtnPos = position;
        this.mRealPos = getRealPos(position);
        invalidate();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
        event.setClassName(SwitchEx.class.getName());
        event.setChecked(this.mChecked);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName(SwitchEx.class.getName());
        info.setCheckable(true);
        info.setChecked(this.mChecked);
    }
}
