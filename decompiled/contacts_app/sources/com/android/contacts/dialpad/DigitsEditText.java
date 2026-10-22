package com.android.contacts.dialpad;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Scroller;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsUtils;
import com.android.contacts.DSUtils;
import com.android.contacts.R;
import com.android.contacts.widget.CopyAll;
import com.android.contacts.widget.CopyTextViewKt;
import obric.api.TextViewSmt;

/* JADX INFO: loaded from: classes.dex */
public class DigitsEditText extends EditText {
    private static final int ALPHA_AREA = 70;
    private static final boolean DEBUG = false;
    private static final int DURATION = 300;
    private static final int GRADIENT_AREA = 30;
    private static final int RESPONSE_CONTEXT_THRESHOLD = 17;
    private static final int SET_REAL_NUMBER = 10;
    private static final int SOLID_AREA = 40;
    private static final int STATE_ANIMATION_TO_NUMBER = 3;
    private static final int STATE_ANIMATION_TO_TAIL = 2;
    private static final int STATE_DRAG = 5;
    private static final int STATE_NUMBER = 1;
    private static final int STATE_TAIL = 4;
    private static final String TAG = "DigitsEditText";
    private static final int TAIL_LENGTH = 0;
    private static final float THRESHOLD = 100.0f;
    private boolean mCallbackRemoved;
    private int mCurrentWShown;
    private int mDigitsImageLength;
    private int mDragCurrentX;
    private float mDragStartX;
    private Rect mDst;
    private int mEditMaxTextSize;
    private int mEditMinTextSize;
    private int mEditStepTextSize;
    private CopyAll mEmptyCopyAll;
    private boolean mGotWidth;
    private Bitmap mHandler;
    private int mHandlerMarginLeft;
    private Handler mHanler;
    private int mLastAdjustLength;
    private String mLastNumber;
    private Bitmap mLastNumberMirage;
    private Runnable mLongPressRunnable;
    private Drawable mMaskDrawable;
    private int mMaxPadding;
    private int mMinPadding;
    private int mNextStartX;
    private Paint mPaint;
    private Rect mRes;
    private Scroller mScroller;
    private int mState;
    private int mTailLenght;
    private int mTailPoint;

    static /* synthetic */ String access$000(DigitsEditText r0) {
        return r0.mLastNumber;
    }

    public void adjustPaddingAndTextSize(String r10) {
        int r0 = r10.length();
        int r1 = getWidth();
        if (r1 > 0) goto L5;
        return;
    L5:
        int r2 = this.mLastAdjustLength;
        if (r2 >= 0) goto L8;
    L10:
        boolean r3 = DSUtils.useDSFeature();
        if (r3 == true) goto L13;
        int r4 = r1 - (this.mMinPadding * 2);
        int r5 = r4;
    L14:
        float r6 = getTextSize();
        if (TextUtils.isEmpty(r10) == false) goto L17;
        r6 = this.mEditMaxTextSize;
    L23:
        this.mPaint.setTextSize(r6);
        int r7 = (int) Math.ceil(this.mPaint.measureText(r10));
        if (r7 > r4) goto L31;
    L25:
        int r8 = this.mEditStepTextSize;
        if ((r8 + r6) > this.mEditMaxTextSize) goto L36;
        float r9 = r8 + r6;
        this.mPaint.setTextSize(r9);
        int r11 = (int) Math.ceil(this.mPaint.measureText(r10));
        if (r11 > r4) goto L36;
        r6 = r9;
        r7 = r11;
    L36:
        if (r3 == false) goto L47;
        if (r7 > r5) goto L39;
        int r12 = this.mMaxPadding;
    L40:
        int r13 = this.mMinPadding;
        if (r12 >= r13) goto L43;
    L42:
        r12 = r13;
    L46:
        setPadding(r12, getPaddingTop(), this.mMaxPadding, getPaddingBottom());
    L48:
        setTextSize(0, r6);
        this.mLastAdjustLength = r0;
        return;
    L43:
        r13 = this.mMaxPadding;
        if (r12 <= r13) goto L46;
    L39:
        r12 = this.mMaxPadding - (r7 - r5);
        goto L40
    L47:
        setPadding(this.mMinPadding, getPaddingTop(), this.mMinPadding, getPaddingBottom());
        goto L48
    L31:
        if (r7 <= r4) goto L36;
    L32:
        int r14 = this.mEditStepTextSize;
        if ((r6 - r14) < this.mEditMinTextSize) goto L36;
        r6 = r6 - r14;
        this.mPaint.setTextSize(r6);
        r7 = (int) Math.ceil(this.mPaint.measureText(r10));
        if (r7 > r4) goto L32;
    L17:
        int r15 = this.mEditMaxTextSize;
        if (r6 <= r15) goto L20;
    L19:
        r6 = r15;
        goto L23
    L20:
        r15 = this.mEditMinTextSize;
        if (r6 >= r15) goto L23;
    L13:
        int r16 = this.mMaxPadding;
        r5 = r1 - (r16 * 2);
        r4 = (r1 - r16) - this.mMinPadding;
        goto L14
    L8:
        if (Math.abs(r0 - r2) >= 2) goto L10;
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean r1) {
        super.onWindowFocusChanged(r1);
        if (r1 == true) goto L5;
        return;
    L5:
        if (this.mGotWidth == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(getText()) == true) goto L9;
        adjustPaddingAndTextSize(getText().toString());
    L9:
        this.mGotWidth = true;
    }

    public boolean isStateNumber() {
        if (1 == this.mState) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isTailNumber() {
        int r1 = this.mState;
        if (r1 != 4) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 2) goto L8;
        return false;
    }

    public void setNumberText(String r1) {
        setText(r1);
        adjustPaddingAndTextSize(getText().toString());
        setSelection(getText().length());
    }

    public void cacheDigitsMirage() {
        if (this.mState == 1) goto L5;
        return;
    L5:
        updateMirage();
        if (this.mLastNumberMirage != null) goto L8;
        String r0 = " cache Mirage failed";
    L9:
        log("cacheDigitsMirage".concat(r0));
        saveLastNumber(getText().toString());
        this.mHandlerMarginLeft = ContactsUtils.dipTopx(this.mContext, 8.0d);
        return;
    L8:
        r0 = "cache Mirage success";
        goto L9
    }

    private void updateMirage() {
        log("updateMirage, willNotCacheDrawing " + willNotCacheDrawing());
        setDrawingCacheEnabled(true);
        Bitmap r0 = getDrawingCache();
        if (r0 != null) goto L5;
        return;
    L5:
        Bitmap r1 = this.mLastNumberMirage;
        if (r1 == null) goto L8;
        r1.recycle();
    L8:
        this.mLastNumberMirage = r0.copy(r0.getConfig(), false);
        setDrawingCacheEnabled(false);
        destroyDrawingCache();
        if (this.mHandler != null) goto L12;
        this.mHandler = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.dial_number_handle);
        return;
    }

    private void saveLastNumber(String r5) {
        this.mState = 1;
        this.mLastNumber = r5;
        Rect r6 = new Rect();
        Paint r0 = new Paint();
        r0.setTextSize(getTextSize());
        String r1 = this.mLastNumber;
        r0.getTextBounds(r1, 0, r1.length(), r6);
        this.mDigitsImageLength = r6.width();
    }

    public void dropLastNumber() {
        log("dropLastNumber");
        this.mLastNumber = "";
        Bitmap r0 = this.mLastNumberMirage;
        if (r0 == null) goto L6;
        r0.recycle();
        this.mLastNumberMirage = null;
        this.mState = 1;
        invalidate();
        return;
    }

    public void startMirageHideAnimation() {
        log("startMirageHideAnimation");
        Bitmap r0 = this.mLastNumberMirage;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isRecycled() == true) goto L20;
        int r1 = this.mLastNumberMirage.getWidth();
        int r2 = this.mDigitsImageLength;
        int r3 = (r1 - r2) / 2;
        if (r3 >= 0) goto L10;
        r3 = 0;
    L10:
        int r5 = this.mTailLenght;
        if (r2 >= r5) goto L13;
        int r6 = r3 - 40;
    L14:
        if (r2 > r1) goto L17;
        r1 = r2;
    L17:
        this.mTailPoint = (r3 + r1) + 20;
        this.mScroller.startScroll(0, 0, r6 + 0, 0, 300);
        this.mState = 2;
        invalidate();
        return;
    L13:
        r6 = ((r1 - r3) - r5) - 10;
        goto L14
    }

    public void setStateNumber() {
        this.mState = 1;
        if (this.mScroller.isFinished() == true) goto L6;
        this.mScroller.abortAnimation();
        return;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas r9) {
        int r0 = getScrollX();
        if (1 != this.mState) goto L5;
        super.onDraw(r9);
        return;
    L5:
        int r1 = this.mLastNumberMirage.getHeight();
        this.mPaint.reset();
        int r3 = this.mState;
        int r6 = 102;
        if (2 != r3) goto L14;
        if (this.mScroller.computeScrollOffset() == true) goto L10;
        getText().clear();
        this.mState = 4;
    L10:
        int r2 = this.mScroller.getCurrX();
        invalidate();
        int r4 = this.mScroller.getStartX() - this.mScroller.getFinalX();
        if (r4 == 0) goto L25;
        r6 = 102 + (((r2 - this.mScroller.getFinalX()) * 153) / r4);
    L25:
        this.mPaint.setAlpha(r6);
        this.mCurrentWShown = r2;
        this.mRes.left = r2;
        this.mRes.top = 0;
        this.mRes.right = this.mTailPoint;
        this.mRes.bottom = r1;
        this.mDst.left = r0;
        this.mDst.top = 0;
        this.mDst.right = r0 + this.mRes.width();
        this.mDst.bottom = r1;
        r9.drawBitmap(this.mLastNumberMirage, this.mRes, this.mDst, this.mPaint);
        this.mPaint.setAlpha(255);
        this.mRes.left = 0;
        this.mRes.top = 0;
        this.mRes.right = this.mHandler.getWidth();
        this.mRes.bottom = this.mHandler.getHeight();
        Rect r5 = this.mDst;
        r5.left = r5.right + this.mHandlerMarginLeft;
        this.mDst.top += (this.mDst.height() - this.mHandler.getHeight()) / 2;
        Rect r7 = this.mDst;
        r7.right = r7.left + this.mHandler.getWidth();
        Rect r8 = this.mDst;
        r8.bottom = r8.top + this.mHandler.getHeight();
        r9.drawBitmap(this.mHandler, this.mRes, this.mDst, this.mPaint);
        return;
    L14:
        if (3 != r3) goto L22;
        if (this.mScroller.computeScrollOffset() == true) goto L18;
        this.mState = 1;
        this.mHanler.sendEmptyMessage(10);
    L18:
        r2 = this.mScroller.getCurrX();
        invalidate();
        int r10 = this.mScroller.getFinalX() - this.mScroller.getStartX();
        if (r10 == 0) goto L25;
        r6 = (((r2 - this.mScroller.getStartX()) * 153) / r10) + 102;
        goto L25
    L22:
        if (5 != r3) goto L24;
        r2 = this.mNextStartX;
        goto L25
    L24:
        r2 = this.mScroller.getFinalX();
        this.mDragCurrentX = r2;
        r6 = 255;
        goto L25
    }

    public void destroy() {
        Bitmap r0 = this.mLastNumberMirage;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isRecycled() == true) goto L9;
        this.mLastNumberMirage.recycle();
        return;
    }

    public DigitsEditText(Context r3, AttributeSet r4) {
        super(r3, r4);
        this.mHandler = null;
        this.mHandlerMarginLeft = 0;
        this.mLastNumberMirage = null;
        this.mLastNumber = "";
        this.mDigitsImageLength = 0;
        this.mTailPoint = 0;
        this.mState = 1;
        this.mEditStepTextSize = 1;
        this.mCallbackRemoved = false;
        this.mPaint = new Paint();
        this.mRes = new Rect();
        this.mDst = new Rect();
        this.mLastAdjustLength = -1;
        this.mEmptyCopyAll = CopyTextViewKt.emptyCopyAll(this);
        final Looper r1 = Looper.getMainLooper();
        this.mHanler = new AnonymousClass1(this, r1);
        this.mLongPressRunnable = new AnonymousClass2(this);
        TextViewSmt.getInstance().setHiddenContextMenuItem(this, 8);
        setInputType(getInputType() | 524288);
        setShowSoftInputOnFocus(false);
        this.mTailLenght = ContactsUtils.dipTopx(getContext(), 0.0d);
        this.mScroller = new Scroller(r3, new DecelerateInterpolator(1.5f));
        this.mEditMaxTextSize = r3.getResources().getDimensionPixelSize(R.dimen.dialpad_edit_max_textsize);
        this.mEditMinTextSize = r3.getResources().getDimensionPixelSize(R.dimen.dialpad_edit_min_textsize);
        this.mMaxPadding = ContactsUtils.dipTopx(r3, 67.0d);
        this.mMinPadding = ContactsUtils.dipTopx(r3, 12.0d);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean r1, int r2, Rect r3) {
        super.onFocusChanged(r1, r2, r3);
        InputMethodManager r4 = (InputMethodManager) getContext().getSystemService("input_method");
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.isActive(this) == false) goto L9;
        r4.hideSoftInputFromWindow(getApplicationWindowToken(), 0);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r7) {
        InputMethodManager r0 = (InputMethodManager) getContext().getSystemService("input_method");
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        int r2 = this.mState;
        if (4 == r2) goto L10;
        if (5 != r2) goto L30;
        int r3 = r7.getAction();
        if (3 == r3) goto L22;
        if (1 == r3) goto L22;
        if (2 != r3) goto L26;
        float r8 = r7.getX();
        calcNextPosition(r8);
        invalidate();
        if (Math.abs(r8 - this.mDragStartX) <= 17.0f) goto L26;
    L25:
        r1 = true;
    L26:
        if (r1 == true) goto L28;
        return true;
    L28:
        if (this.mCallbackRemoved == true) goto L36;
        removeCallbacks(this.mLongPressRunnable);
        this.mCallbackRemoved = true;
        return true;
    L36:
        return true;
    L22:
        if (isTrigerToNumber(r7.getX()) == false) goto L24;
        this.mState = 3;
        startAnimationToNumber();
        goto L25
    L24:
        this.mState = 2;
        startAnimationToTial();
        goto L25
    L30:
        if (1 == r2) goto L32;
        return true;
    L32:
        return super.onTouchEvent(r7);
    L10:
        if (r7.getAction() != 0) goto L33;
        float r9 = r7.getX();
        this.mDragStartX = r9;
        calcNextPosition(r9);
        invalidate();
        this.mState = 5;
        postDelayed(this.mLongPressRunnable, ViewConfiguration.getLongPressTimeout());
        this.mCallbackRemoved = false;
        return true;
    L33:
        return true;
    L5:
        if (r0.isActive(this) == false) goto L7;
        r0.hideSoftInputFromWindow(getApplicationWindowToken(), 0);
        goto L7
    }

    @Override // android.widget.TextView, android.view.View
    public boolean performLongClick() {
        if (TextUtils.isEmpty(getText()) == false) goto L9;
        if (this.mEmptyCopyAll.canPaste() == false) goto L9;
        performHapticFeedback(0);
        this.mEmptyCopyAll.startCopyAllActionMode();
        return true;
    L9:
        return super.performLongClick();
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int r2) {
        this.mState = 1;
        return super.onTextContextMenuItem(r2);
    }

    private boolean isTrigerToNumber(float r1) {
        if (Math.abs(r1 - this.mDragStartX) <= THRESHOLD) goto L5;
        return true;
    L5:
        return false;
    }

    private void startAnimationToNumber() {
        log("startAnimationToNumber, mLastNumberMirage = " + this.mLastNumberMirage);
        int r2 = this.mCurrentWShown;
        this.mScroller.startScroll(r2, 0, 0 - r2, 0, 300);
        invalidate();
    }

    private void startAnimationToTial() {
        int r1 = this.mCurrentWShown;
        int r0 = this.mLastNumberMirage.getWidth();
        int r2 = this.mDigitsImageLength;
        int r3 = (r0 - r2) / 2;
        if (r3 >= 0) goto L5;
        r3 = 0;
    L5:
        int r4 = this.mTailLenght;
        if (r2 >= r4) goto L8;
        int r5 = r3 - 40;
    L9:
        log("startAnimationToTial, from " + r1 + " to " + r5);
        int r6 = this.mDigitsImageLength;
        if (r6 > r0) goto L13;
        r0 = r6;
    L13:
        this.mTailPoint = (r3 + r0) + 20;
        this.mScroller.startScroll(r1, 0, r5 - r1, 0, 300);
        invalidate();
        return;
    L8:
        r5 = ((r0 - r3) - r4) - 10;
        goto L9
    }

    private void calcNextPosition(float r2) {
        float r0 = this.mDragStartX - r2;
        this.mNextStartX = this.mDragCurrentX + (((int) r0) / 2);
    }

    @Override // android.widget.TextView, android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent r6) {
        if (r6.getEventType() != 16) goto L11;
        int r0 = r6.getAddedCount();
        int r1 = r6.getRemovedCount();
        int r2 = r6.getBeforeText().length();
        if (r0 <= r1) goto L7;
        r6.setRemovedCount(0);
        r6.setAddedCount(1);
        r6.setFromIndex(r2);
    L13:
        super.sendAccessibilityEventUnchecked(r6);
        return;
    L7:
        if (r1 <= r0) goto L9;
        r6.setRemovedCount(1);
        r6.setAddedCount(0);
        r6.setFromIndex(r2 - 1);
        goto L13
    L9:
        return;
    L11:
        if (r6.getEventType() != 8) goto L13;
    }

    private static void log(String r1) {
        if (ContactsUtils.DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, r1);
        return;
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        super.onTextChanged(r1, r2, r3, r4);
        CopyAll r0 = this.mEmptyCopyAll;
        if (r0 == null) goto L6;
        r0.stopCopyAllActionMode();
        return;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onVisibilityChanged(View r1, int r2) {
        super.onVisibilityChanged(r1, r2);
        CopyAll r0 = this.mEmptyCopyAll;
        if (r0 == null) goto L6;
        r0.stopCopyAllActionMode();
        return;
    }
}
