package obric.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.SoundPool;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.GlobalProxyLancet;
import com.google.android.material.timepicker.TimeModel;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class NumberPickerEx extends LinearLayout {
    private static final boolean DBG = false;
    private static final float DEFAULT_LINE_SPACE = 2.0f;
    private static final float DEFAULT_TEXT_SCALE = 1.05f;
    private static final int DEFAULT_TEXT_SIZE = 17;
    private static final int DEFAUlT_TEXT_COLOR = 0;
    private static final int HIGHLIGHT_TEXT_COLOR = 0;
    private static final int HIGHLIGHT_TEXT_SIZE = 60;
    private static final int INITIAL_TEXT_COLOR = 0;
    private static final int SELECTOR_ADJUSTMENT_DURATION_MILLIS = 800;
    private static final int SELECTOR_MAX_FLING_VELOCITY_ADJUSTMENT = 8;
    private static final int SELECTOR_MIDDLE_ITEM_INDEX = 4;
    private static final int SELECTOR_WHEEL_ITEM_COUNT = 9;
    private static final int SIZE_UNSPECIFIED = -1;
    private static final int SNAP_SCROLL_DURATION = 300;
    private static final String TAG = "BytedanceNumberPicker";
    private static final int TEXT_WIDTH_OFFSET_IGNORE = 10;
    private static final float TOP_AND_BOTTOM_FADING_EDGE_STRENGTH = 0.0f;
    private static final String UNSET_STRING = "--";
    public static final int UNSET_YEAR = 4;
    private static final float VOLUME = 0.0945f;
    private static int mDefaultItemSize = 0;
    private static final int mHighlightItemSize = 146;
    private static SoundPool sPool;
    private static int sSoundId;
    private static final TwoDigitFormatter sTwoDigitFormatter = null;
    private float CENTER_CONTENT_OFFSET;
    private final Scroller mAdjustScroller;
    private int mBottomSelectionDividerBottom;
    private final boolean mComputeMaxWidth;
    private int mCurrentScrollOffset;
    private String[] mDisplayedValues;
    private Drawable mDrawableBg;
    private int mFirstLineY;
    private final Scroller mFlingScroller;
    private Formatter mFormatter;
    private int mHalfCircumference;
    private final boolean mHasSelectorWheel;
    private boolean mHasUnsetValue;
    private int mHeight;
    private int mHighlightColor;
    private int mHighlightSize;
    private String mHightlightSuffix;
    private int mHightlightSuffixFontSize;
    private int mHightlightSuffixMargin;
    private boolean mIngonreMoveEvents;
    private int mInitialColor;
    private int mInitialScrollOffset;
    private int mInitialValue;
    private int mItemsVisibleCount;
    private int mLargeLineGap;
    private long mLastDownEventTime;
    private float mLastDownEventY;
    private float mLastDownOrMoveEventY;
    private float mLineSpacingMultiplier;
    private final int mMaxHeight;
    private int mMaxTextHeight;
    private int mMaxValue;
    private int mMaxWidth;
    private String mMaxWidthText;
    private int mMaximumFlingVelocity;
    private int mMidTextWidth;
    private int mMiddleScrollOffset;
    private final int mMinHeight;
    private int mMinValue;
    private final int mMinWidth;
    private int mMinimumFlingVelocity;
    private int mNormalColor;
    private int mNormalLineGap;
    private int mNormalSize;
    private int mOldTime;
    private OnScrollListener mOnScrollListener;
    private OnValueChangeListener mOnValueChangeListener;
    private Paint mPaintCenterText;
    private Paint mPaintIndicator;
    private Paint mPaintOuterText;
    private int mPreviousScrollerY;
    private int mRadius;
    private float mScaleX;
    private int mScrollState;
    private int mSecondLineY;
    private int mSelectorElementHeight;
    private final SparseArray<String> mSelectorIndexToStringCache;
    private final int[] mSelectorIndices;
    private int mSelectorTextGapHeight;
    private final Paint mSelectorWheelPaint;
    private boolean mShowSoftInputOnTap;
    private int mSmallLineGap;
    private boolean mSoundEnable;
    private Runnable mSoundRunnable;
    private Rect mTempRect;
    private float mTextPadding;
    private int mTextSize;
    private int mTopSelectionDividerTop;
    private int mTouchSlop;
    private int mValue;
    private VelocityTracker mVelocityTracker;
    private int mWidth;
    private boolean mWrapSelectorWheel;
    private Context mcContext;

    public interface Formatter {
        String format(int value);
    }

    public interface OnScrollListener {
        public static final int SCROLL_STATE_FLING = 2;
        public static final int SCROLL_STATE_IDLE = 0;
        public static final int SCROLL_STATE_TOUCH_SCROLL = 1;

        void onScrollStateChange(NumberPickerEx view, int scrollState);
    }

    public interface OnValueChangeListener {
        void onValueChange(NumberPickerEx picker, int oldVal, int newVal);
    }

    private static class TwoDigitFormatter implements Formatter {
        final Object[] mArgs;
        final StringBuilder mBuilder;
        java.util.Formatter mFmt;
        char mZeroDigit;

        private static char getZeroDigit(Locale locale) {
            return '0';
        }

        TwoDigitFormatter() {
            this.mBuilder = new StringBuilder();
            this.mArgs = new Object[1];
            init(Locale.getDefault());
        }

        private void init(Locale locale) {
            this.mFmt = createFormatter(locale);
            this.mZeroDigit = getZeroDigit(locale);
        }

        @Override // obric.widget.NumberPickerEx.Formatter
        public String format(int value) {
            Locale r0 = Locale.getDefault();
            if (this.mZeroDigit == getZeroDigit(r0)) goto L5;
            init(r0);
        L5:
            this.mArgs[0] = Integer.valueOf(value);
            StringBuilder r4 = this.mBuilder;
            r4.delete(0, r4.length());
            this.mFmt.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, this.mArgs);
            return this.mFmt.toString();
        }

        private java.util.Formatter createFormatter(Locale locale) {
            return new java.util.Formatter(this.mBuilder, locale);
        }
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        return 0.0f;
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        return 0.0f;
    }

    static /* synthetic */ SoundPool access$000() {
        return sPool;
    }

    static /* synthetic */ boolean access$100(NumberPickerEx r0) {
        return r0.mSoundEnable;
    }

    static /* synthetic */ int access$200() {
        return sSoundId;
    }

    static {
        DEFAUlT_TEXT_COLOR = Color.parseColor("#4c000000");
        INITIAL_TEXT_COLOR = Color.parseColor("#e65079d9");
        HIGHLIGHT_TEXT_COLOR = Color.parseColor("#9a000000");
        mDefaultItemSize = 0;
        sTwoDigitFormatter = new TwoDigitFormatter();
    }

    public static final Formatter getTwoDigitFormatter() {
        return sTwoDigitFormatter;
    }

    public void setSoundEnable(boolean enabled) {
        this.mSoundEnable = enabled;
    }

    public NumberPickerEx(Context context) {
        this(context, null);
    }

    public NumberPickerEx(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NumberPickerEx(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mHightlightSuffix = null;
        this.mSelectorIndexToStringCache = new SparseArray();
        this.mSelectorIndices = new int[9];
        this.mNormalSize = 17;
        this.mHighlightSize = 60;
        this.mNormalColor = DEFAUlT_TEXT_COLOR;
        this.mHighlightColor = HIGHLIGHT_TEXT_COLOR;
        this.mInitialColor = INITIAL_TEXT_COLOR;
        this.mInitialScrollOffset = Integer.MIN_VALUE;
        this.mScrollState = 0;
        this.mHasUnsetValue = false;
        this.mSoundEnable = true;
        this.mOldTime = -1;
        this.mLineSpacingMultiplier = 2.0f;
        this.mItemsVisibleCount = 9;
        this.mScaleX = DEFAULT_TEXT_SCALE;
        this.mTempRect = new Rect();
        this.mSoundRunnable = new AnonymousClass1(this);
        this.mcContext = context;
        float r9 = getResources().getDisplayMetrics().density;
        if (r9 > 1.0f) goto L6;
        this.CENTER_CONTENT_OFFSET = 1.4f;
    L28:
        this.mHasSelectorWheel = true;
        this.mMinHeight = -1;
        this.mMaxHeight = -1;
        this.mMinWidth = -1;
        this.mMaxWidth = -1;
        this.mComputeMaxWidth = true;
        setWillNotDraw(!true);
        ViewConfiguration r10 = ViewConfiguration.get(context.getApplicationContext());
        this.mTouchSlop = r10.getScaledTouchSlop();
        this.mMinimumFlingVelocity = r10.getScaledMinimumFlingVelocity();
        this.mMaximumFlingVelocity = r10.getScaledMaximumFlingVelocity() / 8;
        Paint r11 = new Paint();
        r11.setAntiAlias(true);
        r11.setTextAlign(Paint.Align.CENTER);
        r11.setTextSize(this.mNormalSize);
        r11.setColor(this.mNormalColor);
        this.mSelectorWheelPaint = r11;
        Scroller r12 = new Scroller(getContext(), null, true);
        this.mFlingScroller = r12;
        if (getContext().getResources().getDisplayMetrics().density != 2.5f) goto L31;
        r12.setFriction(0.0028f);
    L32:
        Scroller r8 = new Scroller(getContext(), new DecelerateInterpolator(2.5f));
        this.mAdjustScroller = r8;
        r8.setFriction(5.0E-4f);
        this.mSmallLineGap = context.getResources().getDimensionPixelSize(R.dimen.number_picker_small_line_gap);
        this.mNormalLineGap = context.getResources().getDimensionPixelSize(R.dimen.number_picker_normal_line_gap);
        this.mLargeLineGap = context.getResources().getDimensionPixelSize(R.dimen.number_picker_large_line_gap);
        this.mHightlightSuffixFontSize = context.getResources().getDimensionPixelSize(R.dimen.obric_numberpicker_hightlight_suffix_font_size);
        this.mHightlightSuffixMargin = context.getResources().getDimensionPixelSize(R.dimen.obric_numberpicker_hightlight_suffix_margin);
        this.mInitialColor = context.getResources().getColor(R.color.calander_date_pick_select_day_color_2);
        this.mTextSize = (int) (Resources.getSystem().getDisplayMetrics().density * 17.0f);
        this.mPaintOuterText = new Paint();
        this.mPaintCenterText = new Paint();
        this.mPaintIndicator = new Paint();
        initPaints();
        return;
    L31:
        r12.setFriction(0.0015f);
        goto L32
    L6:
        if (1.0f >= r9) goto L11;
        if (r9 >= 1.3f) goto L11;
        this.CENTER_CONTENT_OFFSET = -2.0f;
    L11:
        if (1.3f >= r9) goto L16;
        if (r9 >= 2.0f) goto L16;
        this.CENTER_CONTENT_OFFSET = 4.0f;
    L16:
        if (2.0f > r9) goto L21;
        if (r9 >= 2.3f) goto L21;
        this.CENTER_CONTENT_OFFSET = 7.0f;
    L21:
        if (2.3f > r9) goto L26;
        if (r9 >= 3.0f) goto L26;
        this.CENTER_CONTENT_OFFSET = 4.0f;
    L26:
        if (r9 < 3.0f) goto L28;
        this.CENTER_CONTENT_OFFSET = r9 * 2.5f;
        goto L28
    }

    private void initPaints() {
        this.mPaintOuterText.setColor(this.mNormalColor);
        this.mPaintOuterText.setAntiAlias(true);
        this.mPaintOuterText.setTypeface(Typeface.MONOSPACE);
        this.mPaintOuterText.setTextSize(this.mTextSize);
        this.mPaintCenterText.setColor(this.mHighlightColor);
        this.mPaintCenterText.setAntiAlias(true);
        this.mPaintCenterText.setTextScaleX(this.mScaleX);
        this.mPaintCenterText.setTypeface(Typeface.MONOSPACE);
        this.mPaintCenterText.setFakeBoldText(true);
        this.mPaintCenterText.setTextSize(this.mTextSize);
        this.mPaintIndicator.setColor(this.mNormalColor);
        this.mPaintIndicator.setAntiAlias(true);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (this.mHasSelectorWheel == true) goto L6;
        super.onLayout(changed, left, top, right, bottom);
        return;
    L6:
        if (changed == false) goto L9;
        initializeSelectorWheel();
        initializeFadingEdges();
        return;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.mHasSelectorWheel == true) goto L6;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        return;
    L6:
        super.onMeasure(makeMeasureSpec(widthMeasureSpec, this.mMaxWidth), makeMeasureSpec(heightMeasureSpec, this.mMaxHeight));
        setMeasuredDimension(resolveSizeAndStateRespectingMinSize(this.mMinWidth, getMeasuredWidth(), widthMeasureSpec), resolveSizeAndStateRespectingMinSize(this.mMinHeight, getMeasuredHeight(), heightMeasureSpec));
        initializeSelectorWheel();
    }

    private boolean moveToFinalScrollerPosition(Scroller scroller) {
        scroller.forceFinished(true);
        int r1 = scroller.getFinalY() - scroller.getCurrY();
        int r7 = (this.mCurrentScrollOffset + r1) % this.mSelectorElementHeight;
        int r2 = this.mInitialScrollOffset - r7;
        if (r2 == 0) goto L16;
        int r3 = Math.abs(r2);
        int r4 = this.mSelectorElementHeight;
        if (r3 <= (r4 / 2)) goto L9;
        if (r2 <= 0) goto L8;
        r2 = r2 - r4;
        goto L9
    L8:
        r2 = r2 + r4;
    L9:
        int r5 = r1 + r2;
        int r6 = r4 * 9;
        if (Math.abs(r5) <= r6) goto L14;
        if (r5 <= 0) goto L13;
        r5 = r6;
        goto L14
    L13:
        r5 = -r6;
    L14:
        scrollBy(0, r5);
        return true;
    L16:
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (this.mHasSelectorWheel == true) goto L5;
    L24:
        return false;
    L5:
        if (isEnabled() == false) goto L24;
        if (event.getActionMasked() == 0) goto L10;
        return false;
    L10:
        float r0 = event.getY();
        this.mLastDownEventY = r0;
        this.mLastDownOrMoveEventY = r0;
        this.mLastDownEventTime = event.getEventTime();
        this.mIngonreMoveEvents = false;
        this.mShowSoftInputOnTap = false;
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.mFlingScroller.isFinished() == true) goto L14;
        this.mFlingScroller.forceFinished(true);
        this.mAdjustScroller.forceFinished(true);
        onScrollStateChange(0);
    L23:
        return true;
    L14:
        if (this.mAdjustScroller.isFinished() == true) goto L16;
        this.mFlingScroller.forceFinished(true);
        this.mAdjustScroller.forceFinished(true);
        goto L23
    L16:
        float r5 = this.mLastDownEventY;
        if (r5 < this.mTopSelectionDividerTop) goto L23;
        if (r5 > this.mBottomSelectionDividerBottom) goto L23;
        this.mShowSoftInputOnTap = true;
        goto L23
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (isEnabled() == true) goto L5;
    L43:
        return false;
    L5:
        if (this.mHasSelectorWheel == false) goto L43;
        if (this.mVelocityTracker != null) goto L10;
        this.mVelocityTracker = VelocityTracker.obtain();
    L10:
        this.mVelocityTracker.addMovement(event);
        int r0 = event.getActionMasked();
        if (r0 == 1) goto L24;
        if (r0 == 2) goto L15;
    L42:
        return true;
    L15:
        if (this.mIngonreMoveEvents == true) goto L42;
        float r9 = event.getY();
        if (this.mScrollState != 1) goto L20;
        scrollBy(0, (int) (r9 - this.mLastDownOrMoveEventY));
        invalidate();
    L23:
        this.mLastDownOrMoveEventY = r9;
        goto L42
    L20:
        if (((int) Math.abs(r9 - this.mLastDownEventY)) <= this.mTouchSlop) goto L23;
        onScrollStateChange(1);
        goto L23
    L24:
        VelocityTracker r1 = this.mVelocityTracker;
        r1.computeCurrentVelocity(1000, this.mMaximumFlingVelocity);
        int r2 = (int) r1.getYVelocity();
        if (Math.abs(r2) <= this.mMinimumFlingVelocity) goto L27;
        fling(r2);
        onScrollStateChange(2);
    L41:
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
        goto L42
    L27:
        int r3 = (int) event.getY();
        int r4 = (int) Math.abs(r3 - this.mLastDownEventY);
        long r5 = event.getEventTime() - this.mLastDownEventTime;
        if (r4 <= this.mTouchSlop) goto L30;
    L39:
        ensureScrollWheelAdjusted();
    L40:
        onScrollStateChange(0);
        goto L41
    L30:
        if (r5 >= ViewConfiguration.getTapTimeout()) goto L39;
        if (this.mShowSoftInputOnTap == false) goto L34;
        this.mShowSoftInputOnTap = false;
        goto L40
    L34:
        int r6 = (r3 / this.mSelectorElementHeight) - 4;
        if (r6 <= 0) goto L37;
        changeValueByOne(true);
        goto L40
    L37:
        if (r6 >= 0) goto L40;
        changeValueByOne(false);
        goto L40
    }

    @Override // android.view.View
    public void computeScroll() {
        Scroller r0 = this.mFlingScroller;
        if (r0.isFinished() == false) goto L7;
        r0 = this.mAdjustScroller;
        if (r0.isFinished() == false) goto L7;
        return;
    L7:
        r0.computeScrollOffset();
        int r1 = r0.getCurrY();
        if (this.mPreviousScrollerY != 0) goto L10;
        this.mPreviousScrollerY = r0.getStartY();
    L10:
        scrollBy(0, r1 - this.mPreviousScrollerY);
        this.mPreviousScrollerY = r1;
        if (r0.isFinished() == false) goto L13;
        onScrollerFinished(r0);
        return;
    L13:
        invalidate();
    }

    @Override // android.view.View
    public void scrollBy(int x, int y) {
        int[] r5 = this.mSelectorIndices;
        boolean r0 = this.mWrapSelectorWheel;
        if (r0 == true) goto L9;
        if (y <= 0) goto L9;
        if (r5[4] > this.mMinValue) goto L9;
        this.mCurrentScrollOffset = this.mInitialScrollOffset;
        return;
    L9:
        if (r0 == true) goto L15;
        if (y >= 0) goto L15;
        if (r5[4] < maxValue()) goto L15;
        this.mCurrentScrollOffset = this.mInitialScrollOffset;
        return;
    L15:
        this.mCurrentScrollOffset += y;
    L16:
        int r6 = this.mCurrentScrollOffset;
        if ((r6 - this.mInitialScrollOffset) < this.mSelectorTextGapHeight) goto L23;
        this.mCurrentScrollOffset = r6 - this.mSelectorElementHeight;
        decrementSelectorIndices(r5);
        setValueInternal(r5[4], true);
        if (this.mWrapSelectorWheel == true) goto L16;
        if (r5[4] > this.mMinValue) goto L16;
        this.mCurrentScrollOffset = this.mInitialScrollOffset;
    L23:
        int r7 = this.mCurrentScrollOffset;
        if ((r7 - this.mInitialScrollOffset) > (-this.mSelectorTextGapHeight)) goto L30;
        this.mCurrentScrollOffset = r7 + this.mSelectorElementHeight;
        incrementSelectorIndices(r5);
        setValueInternal(r5[4], true);
        if (this.mWrapSelectorWheel == true) goto L23;
        if (r5[4] < maxValue()) goto L23;
        this.mCurrentScrollOffset = this.mInitialScrollOffset;
        goto L23
    }

    public void setOnValueChangedListener(OnValueChangeListener onValueChangedListener) {
        this.mOnValueChangeListener = onValueChangedListener;
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.mOnScrollListener = onScrollListener;
    }

    public void setFormatter(Formatter formatter) {
        if (formatter != this.mFormatter) goto L5;
        return;
    L5:
        this.mFormatter = formatter;
        initializeSelectorWheelIndices();
    }

    public void setValue(int value) {
        setValueInternal(value, false);
    }

    public void setInitialValue(int value) {
        this.mInitialValue = value;
    }

    public void setHightlightSuffix(String hightlightSuffix) {
        this.mHightlightSuffix = hightlightSuffix;
    }

    private void tryComputeMaxWidth() {
        if (this.mComputeMaxWidth == true) goto L5;
        return;
    L5:
        String[] r0 = this.mDisplayedValues;
        int r1 = 0;
        if (r0 != null) goto L17;
        float r2 = 0.0f;
    L9:
        if (r1 > 9) goto L14;
        float r3 = this.mSelectorWheelPaint.measureText(formatNumberWithLocale(r1));
        if (r3 <= r2) goto L13;
        r2 = r3;
    L13:
        r1 = r1 + 1;
        goto L9
    L14:
        int r5 = this.mMaxValue;
    L15:
        if (r5 <= 0) goto L23;
        r5 = r5 / 10;
        goto L15
    L23:
        return;
    L17:
        int r4 = r0.length;
        int r6 = 0;
    L18:
        if (r1 >= r4) goto L31;
        float r7 = this.mSelectorWheelPaint.measureText(this.mDisplayedValues[r1]);
        if (r7 <= r6) goto L22;
        r6 = (int) r7;
    L22:
        r1 = r1 + 1;
        goto L18
    }

    public boolean getWrapSelectorWheel() {
        return this.mWrapSelectorWheel;
    }

    public void setWrapSelectorWheel(boolean wrapSelectorWheel) {
        if ((maxValue() - this.mMinValue) < this.mSelectorIndices.length) goto L5;
        boolean r0 = true;
    L6:
        if (wrapSelectorWheel == false) goto L9;
        if (r0 == true) goto L9;
        return;
    L9:
        if (wrapSelectorWheel == this.mWrapSelectorWheel) goto L13;
        this.mWrapSelectorWheel = wrapSelectorWheel;
        return;
    L13:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public int getValue() {
        return this.mValue;
    }

    public int getMinValue() {
        return this.mMinValue;
    }

    public void setMinValue(int minValue) {
        if (this.mMinValue != minValue) goto L5;
        return;
    L5:
        if (minValue < 0) goto L16;
        this.mMinValue = minValue;
        if (minValue <= this.mValue) goto L10;
        this.mValue = minValue;
    L10:
        if ((maxValue() - this.mMinValue) <= this.mSelectorIndices.length) goto L12;
        boolean r2 = true;
    L13:
        setWrapSelectorWheel(r2);
        initializeSelectorWheelIndices();
        tryComputeMaxWidth();
        invalidate();
        return;
    L12:
        r2 = false;
        goto L13
    L16:
        throw new IllegalArgumentException("minValue must be >= 0");
    }

    public int getMaxValue() {
        return this.mMaxValue;
    }

    public void setMaxValue(int maxValue, boolean unsetValue) {
        if (this.mMaxValue != maxValue) goto L5;
        return;
    L5:
        if (maxValue < 0) goto L16;
        this.mMaxValue = maxValue;
        if (maxValue >= this.mValue) goto L9;
        this.mValue = maxValue;
    L9:
        this.mHasUnsetValue = unsetValue;
        if ((maxValue() - this.mMinValue) <= this.mSelectorIndices.length) goto L12;
        boolean r2 = true;
    L13:
        setWrapSelectorWheel(r2);
        initializeSelectorWheelIndices();
        tryComputeMaxWidth();
        invalidate();
        return;
    L12:
        r2 = false;
        goto L13
    L16:
        throw new IllegalArgumentException("maxValue must be >= 0");
    }

    public void setMaxValue(int maxValue) {
        setMaxValue(maxValue, false);
    }

    private boolean hasUnset() {
        return this.mHasUnsetValue;
    }

    public void setTextSize(int normalSize, int highlightSize) {
        if (normalSize < 0) goto L7;
        if (highlightSize < 0) goto L7;
        this.mNormalSize = normalSize;
        this.mHighlightSize = highlightSize;
        return;
    L7:
        throw new IllegalArgumentException("the text size mus be >= 0 ");
    }

    public void setTextColor(int normalColor, int highlightColor) {
        this.mNormalColor = normalColor;
        this.mHighlightColor = highlightColor;
    }

    public void setTextSize(int textSize) {
        this.mTextSize = (int) (Resources.getSystem().getDisplayMetrics().density * textSize);
    }

    public void setTextScaleX(int scalex) {
        this.mScaleX = scalex;
    }

    public void setLineSpacemMultiplier(float lineSpacemMultiplier) {
        if (lineSpacemMultiplier >= 1.0f) goto L5;
        float r2 = 2.0f;
    L6:
        this.mLineSpacingMultiplier = r2;
        initializeSelectorWheel();
        return;
    L5:
        r2 = this.mLineSpacingMultiplier;
        goto L6
    }

    public String[] getDisplayedValues() {
        return this.mDisplayedValues;
    }

    public void setDisplayedValues(String[] displayedValues) {
        if (this.mDisplayedValues != displayedValues) goto L5;
        return;
    L5:
        this.mDisplayedValues = displayedValues;
        initializeSelectorWheelIndices();
        if (this.mDisplayedValues != null) goto L9;
        this.mMaxWidthText = null;
        return;
    L9:
        int r0 = displayedValues.length;
        int r1 = 0;
    L10:
        if (r1 >= r0) goto L20;
        if (this.mMaxWidthText != null) goto L14;
        this.mMaxWidthText = displayedValues[r1];
    L19:
        r1 = r1 + 1;
        goto L10
    L14:
        if (displayedValues[r1].length() <= this.mMaxWidthText.length()) goto L16;
        String r2 = displayedValues[r1];
    L17:
        this.mMaxWidthText = r2;
        goto L19
    L16:
        r2 = this.mMaxWidthText;
        goto L17
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mHasSelectorWheel == true) goto L6;
        super.onDraw(canvas);
        return;
    L6:
        int[] r8 = this.mSelectorIndices;
        initPaints();
        int r9 = (int) ((this.mCurrentScrollOffset - this.mInitialScrollOffset) % (this.mLineSpacingMultiplier * this.mMaxTextHeight));
        boolean r10 = false;
        if (this.mDrawableBg == null) goto L9;
        canvas.save();
        canvas.translate(0.0f, this.mFirstLineY);
        this.mDrawableBg.setBounds(0, 0, this.mWidth, this.mSecondLineY - this.mFirstLineY);
        this.mDrawableBg.draw(canvas);
        canvas.restore();
    L10:
        int r1 = 0;
    L12:
        if (r1 >= this.mItemsVisibleCount) goto L62;
        int r2 = r8[r1];
        if (looksUnset(r2) == false) goto L16;
        String r4 = UNSET_STRING;
    L18:
        if (r2 != this.mInitialValue) goto L20;
        this.mPaintOuterText.setColor(this.mInitialColor);
        this.mPaintCenterText.setColor(this.mInitialColor);
    L21:
        canvas.save();
        float r3 = this.mMaxTextHeight * this.mLineSpacingMultiplier;
        double r5 = (((double) ((r1 * r3) + r9)) * 3.141592653589793d) / ((double) this.mHalfCircumference);
        if (r5 < 3.141592653589793d) goto L24;
    L42:
        boolean r11 = r10;
        canvas.restore();
    L44:
        if (r1 == (this.mItemsVisibleCount / 2)) goto L46;
    L59:
        boolean r6 = false;
    L60:
        r1 = r1 + 1;
        r10 = r11;
        goto L12
    L46:
        if (TextUtils.isEmpty(this.mHightlightSuffix) == true) goto L59;
        if (this.mFormatter == null) goto L50;
    L55:
        this.mSelectorWheelPaint.setTextSize(this.mHightlightSuffixFontSize);
        this.mSelectorWheelPaint.setColor(this.mHighlightColor);
        this.mSelectorWheelPaint.setFakeBoldText(true);
        r6 = false;
        this.mSelectorWheelPaint.getTextBounds(r4, 0, r4.length(), this.mTempRect);
        int r7 = (int) (this.mTempRect.width() * this.mScaleX);
        if (Math.abs(r7 - this.mMidTextWidth) <= 10) goto L58;
        this.mMidTextWidth = r7;
    L58:
        int r12 = (getPaddingLeft() + (this.mMidTextWidth / 2)) + (this.mWidth / 2);
        Paint.FontMetricsInt r13 = this.mSelectorWheelPaint.getFontMetricsInt();
        int r14 = this.mSecondLineY;
        int r15 = this.mFirstLineY;
        canvas.drawText(this.mHightlightSuffix, (r12 + this.mTextPadding) + this.mHightlightSuffixMargin, ((((r14 - r15) / 2) + r15) + ((r13.bottom - r13.top) / 2)) - r13.bottom, this.mSelectorWheelPaint);
        goto L60
    L50:
        if (this.mDisplayedValues == null) goto L54;
        String r16 = this.mMaxWidthText;
        if (r16 == null) goto L55;
        r4 = r16;
        goto L55
    L54:
        r4 = formatNumberWithLocale(this.mMaxValue);
        goto L55
    L24:
        if (r5 <= 0.0d) goto L42;
        int r17 = (int) ((((double) this.mRadius) - (Math.cos(r5) * ((double) this.mRadius))) - ((Math.sin(r5) * ((double) this.mMaxTextHeight)) / 2.0d));
        r11 = false;
        canvas.translate(0.0f, r17);
        canvas.scale(1.0f, (float) Math.sin(r5));
        int r18 = this.mMaxTextHeight;
        float r19 = r18 - this.CENTER_CONTENT_OFFSET;
        int r110 = this.mFirstLineY;
        if (r17 <= r110) goto L29;
    L31:
        int r111 = this.mSecondLineY;
        if (r17 <= r111) goto L34;
    L36:
        if (r17 >= r110) goto L38;
    L40:
        canvas.clipRect(0, 0, this.mWidth, (int) r3);
        canvas.drawText(r4, getTextX(r4, this.mPaintOuterText, this.mTempRect), r19, this.mPaintOuterText);
    L41:
        canvas.restore();
        goto L44
    L38:
        if ((r18 + r17) > r111) goto L40;
        canvas.clipRect(0, 0, this.mWidth, (int) r3);
        canvas.drawText(r4, getTextX(r4, this.mPaintCenterText, this.mTempRect), r19, this.mPaintCenterText);
        goto L41
    L34:
        if ((r18 + r17) < r111) goto L36;
        canvas.save();
        canvas.clipRect(0, 0, this.mWidth, this.mSecondLineY - r17);
        canvas.drawText(r4, getTextX(r4, this.mPaintCenterText, this.mTempRect), r19, this.mPaintCenterText);
        canvas.restore();
        canvas.save();
        canvas.clipRect(0, this.mSecondLineY - r17, this.mWidth, (int) r3);
        canvas.drawText(r4, getTextX(r4, this.mPaintOuterText, this.mTempRect), r19, this.mPaintOuterText);
        canvas.restore();
        goto L41
    L29:
        if ((r18 + r17) < r110) goto L31;
        canvas.save();
        canvas.clipRect(0, 0, this.mWidth, this.mFirstLineY - r17);
        canvas.drawText(r4, getTextX(r4, this.mPaintOuterText, this.mTempRect), r19, this.mPaintOuterText);
        canvas.restore();
        canvas.save();
        canvas.clipRect(0, this.mFirstLineY - r17, this.mWidth, (int) r3);
        canvas.drawText(r4, getTextX(r4, this.mPaintCenterText, this.mTempRect), r19, this.mPaintCenterText);
        canvas.restore();
        goto L41
    L20:
        this.mPaintOuterText.setColor(this.mNormalColor);
        this.mPaintCenterText.setColor(this.mHighlightColor);
        goto L21
    L16:
        r4 = this.mSelectorIndexToStringCache.get(r2);
        goto L18
    L62:
        if (isTimeChanged(r8[2]) == false) goto L67;
        if (Math.abs(this.mFlingScroller.getFinalY() - this.mFlingScroller.getCurrY()) <= 50) goto L67;
        this.mOldTime = r8[2];
        postDelayed(this.mSoundRunnable, 10);
        return;
    L67:
        if (isTimeChanged(r8[2]) == true) goto L69;
        return;
    L69:
        if (this.mFlingScroller.getFinalY() > this.mFlingScroller.getCurrY()) goto L77;
        this.mOldTime = r8[2];
        postDelayed(this.mSoundRunnable, 30);
        return;
    L77:
        return;
    L9:
        float r20 = getPaddingLeft();
        int r21 = this.mFirstLineY;
        canvas.drawLine(r20, r21, this.mWidth, r21, this.mPaintIndicator);
        float r22 = getPaddingLeft();
        int r23 = this.mSecondLineY;
        canvas.drawLine(r22, r23, this.mWidth, r23, this.mPaintIndicator);
        goto L10
    }

    private int getTextX(String a, Paint paint, Rect rect) {
        paint.getTextBounds(a, 0, a.length(), rect);
        return (((this.mWidth - getPaddingLeft()) - ((int) (rect.width() * this.mScaleX))) / 2) + getPaddingLeft();
    }

    private boolean isTimeChanged(int newTime) {
        if (this.mOldTime != (-1)) goto L6;
        this.mOldTime = newTime;
    L6:
        if (this.mOldTime != newTime) goto L9;
        return false;
    L9:
        return true;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
        event.setClassName(NumberPicker.class.getName());
        event.setScrollable(true);
        event.setScrollY((this.mMinValue + this.mValue) * this.mSelectorElementHeight);
    }

    private int makeMeasureSpec(int measureSpec, int maxSize) {
        if (maxSize != (-1)) goto L5;
        return measureSpec;
    L5:
        int r3 = View.MeasureSpec.getSize(measureSpec);
        int r0 = View.MeasureSpec.getMode(measureSpec);
        if (r0 == Integer.MIN_VALUE) goto L15;
        if (r0 == 0) goto L13;
        if (r0 != 1073741824) goto L11;
        return measureSpec;
    L11:
        throw new IllegalArgumentException("Unknown measure mode: " + r0);
    L13:
        return View.MeasureSpec.makeMeasureSpec(maxSize, 1073741824);
    L15:
        return View.MeasureSpec.makeMeasureSpec(Math.min(r3, maxSize), 1073741824);
    }

    private int resolveSizeAndStateRespectingMinSize(int minSize, int measuredSize, int measureSpec) {
        if (minSize != (-1)) goto L5;
        return measuredSize;
    L5:
        return resolveSizeAndState(Math.max(minSize, measuredSize), measureSpec, 0);
    }

    private void initializeSelectorWheelIndices() {
        this.mSelectorIndexToStringCache.clear();
        int[] r0 = this.mSelectorIndices;
        int r1 = getValue();
        int r3 = 0;
        if (looksUnset(r1) == false) goto L10;
        int r2 = this.mMinValue;
        int r4 = this.mMaxValue;
    L5:
        int[] r5 = this.mSelectorIndices;
        if (r3 >= (r5.length / 2)) goto L8;
        int r6 = r4 - (((r5.length / 2) - r3) - 1);
        r0[r3] = r6;
        ensureCachedScrollSelectorValue(r6);
        int r7 = r2 + r3;
        r0[((this.mSelectorIndices.length / 2) + r3) + 1] = r7;
        ensureCachedScrollSelectorValue(r7);
        r3 = r3 + 1;
        goto L5
    L8:
        r0[r5.length / 2] = 4;
        ensureCachedScrollSelectorValue(4);
        return;
    L10:
        if (r3 >= this.mSelectorIndices.length) goto L20;
        int r8 = (r3 - 4) + r1;
        if (this.mWrapSelectorWheel == false) goto L14;
        r8 = getWrappedSelectorIndex(r8);
    L14:
        r0[r3] = r8;
        ensureCachedScrollSelectorValue(r8);
        r3 = r3 + 1;
        goto L10
    }

    private void setValueInternal(int current, boolean notifyChange) {
        if (this.mValue != current) goto L5;
        return;
    L5:
        int r1 = 4;
        if (looksUnset(current) == false) goto L11;
        if (this.mValue != 4) goto L11;
        return;
    L11:
        if (this.mWrapSelectorWheel == false) goto L17;
        if (looksUnset(current) == true) goto L20;
        r1 = getWrappedSelectorIndex(current);
    L20:
        int r3 = this.mValue;
        this.mValue = r1;
        if (notifyChange == false) goto L23;
        notifyChange(r3, r1);
    L23:
        initializeSelectorWheelIndices();
        invalidate();
        return;
    L17:
        if (looksUnset(current) == true) goto L20;
        r1 = Math.min(Math.max(current, this.mMinValue), this.mMaxValue);
        goto L20
    }

    private boolean looksUnset(int current) {
        if (current > this.mMaxValue) goto L7;
        if (current < this.mMinValue) goto L7;
    L9:
        return false;
    L7:
        if (hasUnset() == false) goto L9;
        return true;
    }

    private void changeValueByOne(boolean increment) {
        if (this.mHasSelectorWheel == false) goto L13;
        if (moveToFinalScrollerPosition(this.mFlingScroller) == true) goto L7;
        moveToFinalScrollerPosition(this.mAdjustScroller);
    L7:
        this.mPreviousScrollerY = 0;
        if (increment == false) goto L10;
        this.mFlingScroller.startScroll(0, 0, 0, -this.mSelectorElementHeight, 300);
    L11:
        invalidate();
        return;
    L10:
        this.mFlingScroller.startScroll(0, 0, 0, this.mSelectorElementHeight, 300);
        goto L11
    L13:
        if (increment == false) goto L15;
        setValueInternal(this.mValue + 1, true);
        return;
    L15:
        setValueInternal(this.mValue - 1, true);
    }

    private void initializeSelectorWheel() {
        initializeSelectorWheelIndices();
        int[] r0 = this.mSelectorIndices;
        float r1 = (getBottom() - getTop()) - (((r0.length - 1) * this.mNormalSize) + this.mHighlightSize);
        int r2 = ((getBottom() - getTop()) - 146) / 8;
        mDefaultItemSize = r2;
        int r3 = (int) ((r1 / r0.length) + 0.5f);
        this.mSelectorTextGapHeight = r3;
        this.mSelectorElementHeight = this.mNormalSize + r3;
        int r4 = (r2 / 2) + 6;
        this.mInitialScrollOffset = r4;
        this.mMiddleScrollOffset = (r2 * 4) + r4;
        this.mCurrentScrollOffset = r4;
        this.mTextPadding = getResources().getDimensionPixelOffset(R.dimen.number_picker_text_padding);
        this.mWidth = getMeasuredWidth();
        int r5 = getMeasuredHeight();
        this.mHeight = r5;
        int r6 = this.mWidth;
        if (r6 == 0) goto L8;
        if (r5 == 0) goto L9;
        this.mWidth = r6 - getPaddingRight();
        int r7 = this.mHeight;
        int r8 = (int) ((((double) r7) * 3.141592653589793d) / 2.0d);
        this.mHalfCircumference = r8;
        float r9 = this.mLineSpacingMultiplier;
        int r10 = (int) (r8 / ((this.mItemsVisibleCount - 1) * r9));
        this.mMaxTextHeight = r10;
        this.mRadius = r7 / 2;
        this.mFirstLineY = (int) ((r7 - (r10 * r9)) / 2.0f);
        this.mSecondLineY = (int) ((r7 + (r10 * r9)) / 2.0f);
        int r11 = (int) ((r9 * r10) + 0.5f);
        this.mSelectorTextGapHeight = r11;
        this.mSelectorElementHeight = r11;
        this.mDrawableBg = getContext().getResources().getDrawable(R.drawable.time_picker_widget_lens);
        return;
    L9:
        return;
    }

    private void initializeFadingEdges() {
        setVerticalFadingEdgeEnabled(true);
        setFadingEdgeLength(((getBottom() - getTop()) - 146) / 2);
    }

    private void onScrollerFinished(Scroller scroller) {
        if (scroller != this.mFlingScroller) goto L6;
        ensureScrollWheelAdjusted();
        onScrollStateChange(0);
        return;
    }

    private void onScrollStateChange(int scrollState) {
        if (this.mScrollState != scrollState) goto L5;
        return;
    L5:
        this.mScrollState = scrollState;
        OnScrollListener r0 = this.mOnScrollListener;
        if (r0 == null) goto L9;
        r0.onScrollStateChange(this, scrollState);
        return;
    }

    private void fling(int velocityY) {
        this.mPreviousScrollerY = 0;
        if (velocityY <= 0) goto L5;
        this.mFlingScroller.fling(0, 0, 0, velocityY, 0, 0, 0, Integer.MAX_VALUE);
    L6:
        invalidate();
        return;
    L5:
        this.mFlingScroller.fling(0, Integer.MAX_VALUE, 0, velocityY, 0, 0, 0, Integer.MAX_VALUE);
        goto L6
    }

    private int getWrappedSelectorIndex(int selectorIndex) {
        if (selectorIndex <= maxValue()) goto L7;
        return (this.mMinValue + ((selectorIndex - maxValue()) % maxValue())) - 1;
    L7:
        if (selectorIndex < this.mMinValue) goto L9;
        return selectorIndex;
    L9:
        return (maxValue() - ((this.mMinValue - selectorIndex) % (maxValue() - this.mMinValue))) + 1;
    }

    private int maxValue() {
        return this.mMaxValue + (hasUnset() ? 1 : 0);
    }

    private void incrementSelectorIndices(int[] selectorIndices) {
        int r0 = 0;
    L4:
        if (r0 >= (selectorIndices.length - 1)) goto L6;
        int r1 = r0 + 1;
        selectorIndices[r0] = selectorIndices[r1];
        r0 = r1;
        goto L4
    L6:
        int r2 = selectorIndices[selectorIndices.length - 2] + 1;
        if (this.mWrapSelectorWheel == true) goto L9;
    L11:
        selectorIndices[selectorIndices.length - 1] = r2;
        ensureCachedScrollSelectorValue(r2);
        return;
    L9:
        if (r2 <= maxValue()) goto L11;
        r2 = this.mMinValue;
        goto L11
    }

    private void decrementSelectorIndices(int[] selectorIndices) {
        int r0 = selectorIndices.length - 1;
    L3:
        if (r0 <= 0) goto L5;
        selectorIndices[r0] = selectorIndices[r0 - 1];
        r0 = r0 - 1;
        goto L3
    L5:
        int r1 = selectorIndices[1] - 1;
        if (this.mWrapSelectorWheel == true) goto L8;
    L10:
        selectorIndices[0] = r1;
        ensureCachedScrollSelectorValue(r1);
        return;
    L8:
        if (r1 >= this.mMinValue) goto L10;
        r1 = maxValue();
        goto L10
    }

    private void ensureCachedScrollSelectorValue(int selectorIndex) {
        SparseArray<String> r0 = this.mSelectorIndexToStringCache;
        if (r0.get(selectorIndex) == null) goto L5;
        return;
    L5:
        int r1 = this.mMinValue;
        if (selectorIndex < r1) goto L15;
        if (selectorIndex > this.mMaxValue) goto L15;
        String[] r2 = this.mDisplayedValues;
        if (r2 == null) goto L13;
        String r3 = r2[selectorIndex - r1];
    L18:
        r0.put(selectorIndex, r3);
        return;
    L13:
        r3 = formatNumber(selectorIndex);
    L15:
        if (hasUnset() == false) goto L17;
        return;
    L17:
        r3 = "";
        goto L18
    }

    private String formatNumber(int value) {
        Formatter r0 = this.mFormatter;
        if (r0 == null) goto L6;
        return r0.format(value);
    L6:
        return formatNumberWithLocale(value);
    }

    private void notifyChange(int previous, int current) {
        OnValueChangeListener r3 = this.mOnValueChangeListener;
        if (r3 == null) goto L6;
        r3.onValueChange(this, previous, this.mValue);
        return;
    }

    private boolean ensureScrollWheelAdjusted() {
        int r0 = this.mInitialScrollOffset - this.mCurrentScrollOffset;
        if (r0 == 0) goto L11;
        this.mPreviousScrollerY = 0;
        int r1 = Math.abs(r0);
        int r2 = this.mSelectorElementHeight;
        if (r1 <= (r2 / 2)) goto L9;
        if (r0 <= 0) goto L8;
        r2 = -r2;
    L8:
        r0 = r0 + r2;
    L9:
        Scroller r3 = this.mAdjustScroller;
        r3.startScroll(0, 0, 0, r0, 800);
        invalidate();
        return true;
    L11:
        return false;
    }

    private static String formatNumberWithLocale(int value) {
        return String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(value)});
    }

    private static void log(String msg) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, msg);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (sPool != null) goto L6;
        SoundPool r0 = new SoundPool(6, 1, 0);
        sPool = r0;
        sSoundId = r0.load(getContext().getApplicationContext(), R.raw.time_picker, 1);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SoundPool r0 = sPool;
        if (r0 == null) goto L6;
        r0.release();
        sPool = null;
        return;
    }
}
