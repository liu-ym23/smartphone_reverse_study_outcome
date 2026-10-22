package obric.widget.calendar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.SoundPool;
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
import obric.widget.R;

/* JADX INFO: loaded from: classes5.dex */
public class NumberPicker1Day extends LinearLayout {
    private static final boolean DBG = false;
    private static final int DEFAULT_TEXT_SIZE = 45;
    private static final int DEFAUlT_TEXT_COLOR = 0;
    private static final int SELECTOR_ADJUSTMENT_DURATION_MILLIS = 800;
    private static final int SELECTOR_MAX_FLING_VELOCITY_ADJUSTMENT = 8;
    private static final int SIZE_UNSPECIFIED = -1;
    private static final int SNAP_SCROLL_DURATION = 300;
    private static final String TAG = "BytedanceNumberPicker";
    private static final float TOP_AND_BOTTOM_FADING_EDGE_STRENGTH = 0.0f;
    private static final float VOLUME = 0.0945f;
    private static SoundPool sPool;
    private static int sSoundId;
    private static final TwoDigitFormatter sTwoDigitFormatter = null;
    private int SELECTOR_MIDDLE_ITEM_INDEX;
    private int SELECTOR_WHEEL_ITEM_COUNT;
    private final Scroller mAdjustScroller;
    private int mBottomSelectionDividerBottom;
    private final boolean mComputeMaxWidth;
    private Context mContext;
    private int mCurrentScrollOffset;
    private String[] mDisplayedValues;
    private final Scroller mFlingScroller;
    private Formatter mFormatter;
    private final boolean mHasSelectorWheel;
    private int mHighlightColor;
    private int mHighlightSize;
    private boolean mIngonreMoveEvents;
    private int mInitialScrollOffset;
    private long mLastDownEventTime;
    private float mLastDownEventY;
    private float mLastDownOrMoveEventY;
    private final int mMaxHeight;
    private int mMaxValue;
    private int mMaxWidth;
    private int mMaximumFlingVelocity;
    private int mMiddleScrollOffset;
    private final int mMinHeight;
    private int mMinValue;
    private final int mMinWidth;
    private int mMinimumFlingVelocity;
    private int mNormalColor;
    private int mNormalSize;
    private int mOldTime;
    private OnScrollListener mOnScrollListener;
    private OnValueChangeListener mOnValueChangeListener;
    private int mPreviousScrollerY;
    private int mScrollState;
    private int mSelectorElementHeight;
    private final SparseArray<String> mSelectorIndexToStringCache;
    private int[] mSelectorIndices;
    private int mSelectorTextGapHeight;
    private final Paint mSelectorWheelPaint;
    private boolean mShowSoftInputOnTap;
    private Runnable mSoundRunnable;
    private int mTopSelectionDividerTop;
    private int mTouchSlop;
    private int mValue;
    private VelocityTracker mVelocityTracker;
    private boolean mWrapSelectorWheel;

    public interface Formatter {
        String format(int value);
    }

    public interface OnScrollListener {
        public static final int SCROLL_STATE_FLING = 2;
        public static final int SCROLL_STATE_IDLE = 0;
        public static final int SCROLL_STATE_TOUCH_SCROLL = 1;

        void onScrollStateChange(NumberPicker1Day view, int scrollState);
    }

    public interface OnValueChangeListener {
        void onValueChange(NumberPicker1Day picker, int oldVal, int newVal);
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

        @Override // obric.widget.calendar.NumberPicker1Day.Formatter
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
    public String getContentDescription() {
        return "";
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        return 0.0f;
    }

    static /* synthetic */ SoundPool access$000() {
        return sPool;
    }

    static /* synthetic */ int access$100() {
        return sSoundId;
    }

    @Override // android.view.View
    public /* bridge */ /* synthetic */ CharSequence getContentDescription() {
        return getContentDescription();
    }

    static {
        DEFAUlT_TEXT_COLOR = Color.parseColor("#545454");
        sTwoDigitFormatter = new TwoDigitFormatter();
    }

    public static final Formatter getTwoDigitFormatter() {
        return sTwoDigitFormatter;
    }

    public NumberPicker1Day(Context context) {
        this(context, null);
    }

    public NumberPicker1Day(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NumberPicker1Day(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.SELECTOR_WHEEL_ITEM_COUNT = 3;
        this.SELECTOR_MIDDLE_ITEM_INDEX = 3 / 2;
        this.mSelectorIndexToStringCache = new SparseArray();
        this.mSelectorIndices = new int[this.SELECTOR_WHEEL_ITEM_COUNT];
        int r5 = DEFAUlT_TEXT_COLOR;
        this.mNormalColor = r5;
        this.mHighlightColor = r5;
        this.mInitialScrollOffset = Integer.MIN_VALUE;
        boolean r6 = false;
        this.mScrollState = 0;
        this.mOldTime = -1;
        this.mSoundRunnable = new AnonymousClass1(this);
        this.mContext = context;
        int r0 = context.getResources().getDimensionPixelSize(R.dimen.date_pick_title_textsize);
        this.mNormalSize = r0;
        this.mHighlightSize = r0;
        this.mHasSelectorWheel = true;
        this.mMinHeight = -1;
        this.mMaxHeight = -1;
        this.mMinWidth = -1;
        this.mMaxWidth = -1;
        int r1 = context.getResources().getInteger(R.integer.time_picker_wheel_item_count);
        this.SELECTOR_WHEEL_ITEM_COUNT = r1;
        this.SELECTOR_MIDDLE_ITEM_INDEX = r1 / 2;
        this.mSelectorIndices = new int[r1];
        if (this.mMaxWidth != (-1)) goto L5;
        r6 = true;
    L5:
        this.mComputeMaxWidth = r6;
        setWillNotDraw(!true);
        ViewConfiguration r4 = ViewConfiguration.get(context.getApplicationContext());
        this.mTouchSlop = r4.getScaledTouchSlop();
        this.mMinimumFlingVelocity = r4.getScaledMinimumFlingVelocity();
        this.mMaximumFlingVelocity = r4.getScaledMaximumFlingVelocity() / 8;
        Paint r7 = new Paint();
        r7.setAntiAlias(true);
        r7.setTextAlign(Paint.Align.CENTER);
        r7.setTextSize(this.mNormalSize);
        r7.setColor(this.mNormalColor);
        this.mSelectorWheelPaint = r7;
        Scroller r8 = new Scroller(this.mContext, null, true);
        this.mFlingScroller = r8;
        if (this.mContext.getResources().getDisplayMetrics().density != 2.5f) goto L8;
        r8.setFriction(0.0028f);
    L9:
        Scroller r9 = new Scroller(this.mContext, new DecelerateInterpolator(2.5f));
        this.mAdjustScroller = r9;
        r9.setFriction(5.0E-4f);
        return;
    L8:
        r8.setFriction(0.0015f);
        goto L9
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
        int r6 = this.SELECTOR_WHEEL_ITEM_COUNT * r4;
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
        int r6 = (r3 / this.mSelectorElementHeight) - this.SELECTOR_MIDDLE_ITEM_INDEX;
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
        int[] r4 = this.mSelectorIndices;
        boolean r0 = this.mWrapSelectorWheel;
        if (r0 == true) goto L9;
        if (y <= 0) goto L9;
        if (r4[this.SELECTOR_MIDDLE_ITEM_INDEX] > this.mMinValue) goto L9;
        this.mCurrentScrollOffset = this.mInitialScrollOffset;
        return;
    L9:
        if (r0 == true) goto L15;
        if (y >= 0) goto L15;
        if (r4[this.SELECTOR_MIDDLE_ITEM_INDEX] < this.mMaxValue) goto L15;
        this.mCurrentScrollOffset = this.mInitialScrollOffset;
        return;
    L15:
        this.mCurrentScrollOffset += y;
    L16:
        int r5 = this.mCurrentScrollOffset;
        if ((r5 - this.mInitialScrollOffset) <= this.mSelectorTextGapHeight) goto L23;
        this.mCurrentScrollOffset = r5 - this.mSelectorElementHeight;
        decrementSelectorIndices(r4);
        setValueInternal(r4[this.SELECTOR_MIDDLE_ITEM_INDEX], true);
        if (this.mWrapSelectorWheel == true) goto L16;
        if (r4[this.SELECTOR_MIDDLE_ITEM_INDEX] > this.mMinValue) goto L16;
        this.mCurrentScrollOffset = this.mInitialScrollOffset;
    L23:
        int r6 = this.mCurrentScrollOffset;
        if ((r6 - this.mInitialScrollOffset) >= (-this.mSelectorTextGapHeight)) goto L30;
        this.mCurrentScrollOffset = r6 + this.mSelectorElementHeight;
        incrementSelectorIndices(r4);
        setValueInternal(r4[this.SELECTOR_MIDDLE_ITEM_INDEX], true);
        if (this.mWrapSelectorWheel == true) goto L23;
        if (r4[this.SELECTOR_MIDDLE_ITEM_INDEX] < this.mMaxValue) goto L23;
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
        if ((this.mMaxValue - this.mMinValue) < this.mSelectorIndices.length) goto L5;
        boolean r0 = true;
    L6:
        if (wrapSelectorWheel == false) goto L9;
        if (r0 == true) goto L9;
        return;
    L9:
        if (wrapSelectorWheel == this.mWrapSelectorWheel) goto L13;
        this.mWrapSelectorWheel = wrapSelectorWheel;
        initializeSelectorWheelIndices();
        invalidate();
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
        if ((this.mMaxValue - minValue) <= this.mSelectorIndices.length) goto L12;
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

    public void setMaxValue(int maxValue) {
        if (this.mMaxValue != maxValue) goto L5;
        return;
    L5:
        if (maxValue < 0) goto L16;
        this.mMaxValue = maxValue;
        if (maxValue >= this.mValue) goto L10;
        this.mValue = maxValue;
    L10:
        if ((maxValue - this.mMinValue) <= this.mSelectorIndices.length) goto L12;
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

    public void setTextSize(int normalSize, int highlightSize) {
        if (normalSize < 0) goto L7;
        if (highlightSize < 0) goto L7;
        this.mNormalSize = normalSize;
        this.mHighlightSize = highlightSize;
        return;
    L7:
        throw new IllegalArgumentException("the text size mus be >= 0 ");
    }

    private float getTextSizeByOffset(int offset) {
        int r0 = this.mMiddleScrollOffset;
        int r1 = this.mSelectorElementHeight;
        if (offset <= (r0 - r1)) goto L17;
        if (offset >= (r0 + r1)) goto L17;
        if (offset >= r0) goto L11;
        int r4 = this.mNormalSize;
        return (float) (((double) r4) + (((((double) (offset - (r0 - r1))) * 1.0d) / ((double) r1)) * ((double) (this.mHighlightSize - r4))));
    L11:
        if (offset < r0) goto L15;
        int r5 = this.mNormalSize;
        return (float) (((double) r5) + (((((double) ((r0 + r1) - offset)) * 1.0d) / ((double) r1)) * ((double) (this.mHighlightSize - r5))));
    L15:
        return this.mNormalSize;
    L17:
        return this.mNormalSize;
    }

    public void setTextColor(int normalColor, int highlightColor) {
        this.mNormalColor = normalColor;
        this.mHighlightColor = highlightColor;
    }

    private int getTextColorByOffset(int offset) {
        int r0 = this.mMiddleScrollOffset;
        int r1 = this.mSelectorElementHeight;
        if (offset <= (r0 - r1)) goto L19;
        if (offset >= (r0 + r1)) goto L19;
        if (offset != r0) goto L11;
        return this.mHighlightColor;
    L11:
        if (offset >= r0) goto L13;
        float r3 = ((offset - (r0 - r1)) * 1.0f) / r1;
    L14:
        if (offset < r0) goto L16;
        r3 = (((r0 + r1) - offset) * 1.0f) / r1;
    L16:
        int r8 = this.mNormalColor;
        int r2 = r8 & 16777215;
        int r7 = this.mHighlightColor;
        int r4 = 16777215 & r7;
        int r5 = r2 & 255;
        int r6 = (r2 >> 8) & 255;
        int r9 = (r2 >> 16) & 255;
        int r10 = r8 >> 24;
        return (((int) (r10 + (((r7 >> 24) - r10) * r3))) << 24) | ((((int) (r9 + ((((r4 >> 16) & 255) - r9) * r3))) << 16) | ((((int) (r5 + (((r4 & 255) - r5) * r3))) | 0) | (((int) (r6 + ((((r4 >> 8) & 255) - r6) * r3))) << 8)));
    L13:
        r3 = 1.0f;
    L19:
        return this.mNormalColor;
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
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mHasSelectorWheel == true) goto L6;
        super.onDraw(canvas);
        return;
    L6:
        int r0 = this.mCurrentScrollOffset;
        int r1 = (getRight() - getLeft()) / 2;
        int[] r3 = this.mSelectorIndices;
        int r5 = 0;
    L8:
        if (r5 >= r3.length) goto L15;
        String r6 = this.mSelectorIndexToStringCache.get(r3[r5]);
        this.mSelectorWheelPaint.setTextSize(getTextSizeByOffset(r0));
        this.mSelectorWheelPaint.setColor(getTextColorByOffset(r0));
        Paint r7 = this.mSelectorWheelPaint;
        if (r5 != (r3.length / 2)) goto L12;
        boolean r8 = true;
    L13:
        r7.setFakeBoldText(r8);
        canvas.drawText(r6, r1, r0, this.mSelectorWheelPaint);
        r0 = r0 + this.mSelectorElementHeight;
        r5 = r5 + 1;
        goto L8
    L12:
        r8 = false;
        goto L13
    L15:
        if (isTimeChanged(r3[2]) == false) goto L20;
        if (Math.abs(this.mFlingScroller.getFinalY() - this.mFlingScroller.getCurrY()) <= 50) goto L20;
        this.mOldTime = r3[2];
        postDelayed(this.mSoundRunnable, 10);
        return;
    L20:
        if (isTimeChanged(r3[2]) == true) goto L22;
        return;
    L22:
        if (this.mFlingScroller.getFinalY() > this.mFlingScroller.getCurrY()) goto L30;
        this.mOldTime = r3[2];
        postDelayed(this.mSoundRunnable, 30);
        return;
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
        event.setClassName(NumberPicker1Day.class.getName());
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
        int r2 = 0;
    L4:
        if (r2 >= this.mSelectorIndices.length) goto L9;
        int r3 = (r2 - this.SELECTOR_MIDDLE_ITEM_INDEX) + r1;
        if (this.mWrapSelectorWheel == false) goto L8;
        r3 = getWrappedSelectorIndex(r3);
    L8:
        r0[r2] = r3;
        ensureCachedScrollSelectorValue(r3);
        r2 = r2 + 1;
        goto L4
    }

    private void setValueInternal(int current, boolean notifyChange) {
        if (this.mValue != current) goto L6;
        return;
    L6:
        if (this.mWrapSelectorWheel == false) goto L8;
        int r2 = getWrappedSelectorIndex(current);
    L9:
        int r0 = this.mValue;
        this.mValue = r2;
        if (notifyChange == false) goto L12;
        notifyChange(r0, r2);
    L12:
        initializeSelectorWheelIndices();
        invalidate();
        return;
    L8:
        r2 = Math.min(Math.max(current, this.mMinValue), this.mMaxValue);
        goto L9
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
        int r1 = (int) ((((getBottom() - getTop()) - (r0.length * this.mNormalSize)) / r0.length) + 0.5f);
        this.mSelectorTextGapHeight = r1;
        this.mSelectorElementHeight = this.mNormalSize + r1;
        int r2 = (getHeight() + this.mNormalSize) / 2;
        int r3 = this.mSelectorElementHeight;
        int r4 = this.SELECTOR_MIDDLE_ITEM_INDEX;
        int r5 = r2 - (r3 * r4);
        this.mInitialScrollOffset = r5;
        this.mMiddleScrollOffset = (r4 * r3) + r5;
        this.mCurrentScrollOffset = r5;
    }

    private void initializeFadingEdges() {
        setVerticalFadingEdgeEnabled(true);
        setFadingEdgeLength(((getBottom() - getTop()) - this.mNormalSize) / 2);
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
        int r0 = this.mMaxValue;
        if (selectorIndex > r0) goto L5;
        int r1 = this.mMinValue;
        if (selectorIndex < r1) goto L9;
        return selectorIndex;
    L9:
        return (r0 - ((r1 - selectorIndex) % (r0 - r1))) + 1;
    L5:
        return (this.mMinValue + ((selectorIndex - r0) % r0)) - 1;
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
        if (r2 <= this.mMaxValue) goto L11;
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
        r1 = this.mMaxValue;
        goto L10
    }

    private void ensureCachedScrollSelectorValue(int selectorIndex) {
        SparseArray<String> r0 = this.mSelectorIndexToStringCache;
        if (r0.get(selectorIndex) == null) goto L5;
        return;
    L5:
        int r1 = this.mMinValue;
        if (selectorIndex >= r1) goto L8;
    L14:
        String r3 = "";
    L15:
        r0.put(selectorIndex, r3);
        return;
    L8:
        if (selectorIndex > this.mMaxValue) goto L14;
        String[] r2 = this.mDisplayedValues;
        if (r2 == null) goto L13;
        r3 = r2[selectorIndex - r1];
        goto L15
    L13:
        r3 = formatNumber(selectorIndex);
        goto L15
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
