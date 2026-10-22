package com.google.android.material.carousel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.graphics.ColorUtils;
import androidx.core.math.MathUtils;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CarouselLayoutManager extends RecyclerView.LayoutManager implements Carousel {
    private static final String TAG = "CarouselLayoutManager";
    private CarouselStrategy carouselStrategy;
    private int currentFillStartPosition;
    private KeylineState currentKeylineState;
    private final DebugItemDecoration debugItemDecoration;
    private int horizontalScrollOffset;
    private boolean isDebuggingEnabled;
    private KeylineStateList keylineStateList;
    private int maxHorizontalScroll;
    private int minHorizontalScroll;

    private static final class ChildCalculations {
        View child;
        float locOffset;
        KeylineRange range;

        ChildCalculations(View r1, float r2, KeylineRange r3) {
            this.child = r1;
            this.locOffset = r2;
            this.range = r3;
        }
    }

    private static class DebugItemDecoration extends RecyclerView.ItemDecoration {
        private List<KeylineState.Keyline> keylines;
        private final Paint linePaint;

        DebugItemDecoration() {
            Paint r0 = new Paint();
            this.linePaint = r0;
            this.keylines = Collections.unmodifiableList(new ArrayList());
            r0.setStrokeWidth(5.0f);
            r0.setColor(-65281);
        }

        void setKeylines(List<KeylineState.Keyline> r1) {
            this.keylines = Collections.unmodifiableList(r1);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDrawOver(Canvas r10, RecyclerView r11, RecyclerView.State r12) {
            super.onDrawOver(r10, r11, r12);
            this.linePaint.setStrokeWidth(r11.getResources().getDimension(R.dimen.m3_carousel_debug_keyline_width));
            Iterator<KeylineState.Keyline> r13 = this.keylines.iterator();
        L4:
            if (r13.hasNext() == false) goto L6;
            KeylineState.Keyline r0 = r13.next();
            this.linePaint.setColor(ColorUtils.blendARGB(-65281, -16776961, r0.mask));
            r10.drawLine(r0.locOffset, CarouselLayoutManager.access$300((CarouselLayoutManager) r11.getLayoutManager()), r0.locOffset, CarouselLayoutManager.access$400((CarouselLayoutManager) r11.getLayoutManager()), this.linePaint);
            goto L4
        }
    }

    private static class KeylineRange {
        final KeylineState.Keyline left;
        final KeylineState.Keyline right;

        KeylineRange(KeylineState.Keyline r3, KeylineState.Keyline r4) {
            if (r3.loc > r4.loc) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkArgument(r0);
            this.left = r3;
            this.right = r4;
            return;
        L5:
            r0 = false;
            goto L6
        }
    }

    private static int calculateShouldHorizontallyScrollBy(int r1, int r2, int r3, int r4) {
        int r0 = r2 + r1;
        if (r0 < r3) goto L5;
        if (r0 > r4) goto L8;
        return r1;
    L8:
        return r4 - r2;
    L5:
        return r3 - r2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return true;
    }

    static /* synthetic */ KeylineStateList access$000(CarouselLayoutManager r0) {
        return r0.keylineStateList;
    }

    static /* synthetic */ int access$100(CarouselLayoutManager r0, KeylineState r1, int r2) {
        return r0.getScrollOffsetForPosition(r1, r2);
    }

    static /* synthetic */ int access$200(CarouselLayoutManager r0) {
        return r0.horizontalScrollOffset;
    }

    static /* synthetic */ int access$300(CarouselLayoutManager r0) {
        return r0.getParentTop();
    }

    static /* synthetic */ int access$400(CarouselLayoutManager r0) {
        return r0.getParentBottom();
    }

    public CarouselLayoutManager() {
        this.isDebuggingEnabled = false;
        this.debugItemDecoration = new DebugItemDecoration();
        this.currentFillStartPosition = 0;
        setCarouselStrategy(new MultiBrowseCarouselStrategy());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public void setCarouselStrategy(CarouselStrategy r1) {
        this.carouselStrategy = r1;
        this.keylineStateList = null;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler r7, RecyclerView.State r8) {
        if (r8.getItemCount() > 0) goto L6;
        removeAndRecycleAllViews(r7);
        this.currentFillStartPosition = 0;
        return;
    L6:
        boolean r0 = isLayoutRtl();
        if (this.keylineStateList != null) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L15;
        View r3 = r7.getViewForPosition(0);
        measureChildWithMargins(r3, 0, 0);
        KeylineState r4 = this.carouselStrategy.onFirstChildMeasuredWithMargins(this, r3);
        if (r0 == false) goto L14;
        r4 = KeylineState.reverse(r4);
    L14:
        this.keylineStateList = KeylineStateList.from(this, r4);
    L15:
        int r5 = calculateStartHorizontalScroll(this.keylineStateList);
        int r6 = calculateEndHorizontalScroll(r8, this.keylineStateList);
        if (r0 == false) goto L18;
        int r9 = r6;
    L19:
        this.minHorizontalScroll = r9;
        if (r0 == false) goto L22;
        r6 = r5;
    L22:
        this.maxHorizontalScroll = r6;
        if (r2 == false) goto L25;
        this.horizontalScrollOffset = r5;
    L26:
        this.currentFillStartPosition = MathUtils.clamp(this.currentFillStartPosition, 0, r8.getItemCount());
        updateCurrentKeylineStateForScrollOffset();
        detachAndScrapAttachedViews(r7);
        fill(r7, r8);
        return;
    L25:
        int r1 = this.horizontalScrollOffset;
        this.horizontalScrollOffset = r1 + calculateShouldHorizontallyScrollBy(0, r1, r9, r6);
        goto L26
    L18:
        r9 = r5;
        goto L19
    L9:
        r2 = false;
        goto L10
    }

    private void fill(RecyclerView.Recycler r3, RecyclerView.State r4) {
        removeAndRecycleOutOfBoundsViews(r3);
        if (getChildCount() != 0) goto L5;
        addViewsStart(r3, this.currentFillStartPosition - 1);
        addViewsEnd(r3, r4, this.currentFillStartPosition);
    L6:
        validateChildOrderIfDebugging();
        return;
    L5:
        int r0 = getPosition(getChildAt(0));
        int r1 = getPosition(getChildAt(getChildCount() - 1));
        addViewsStart(r3, r0 - 1);
        addViewsEnd(r3, r4, r1 + 1);
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State r2) {
        super.onLayoutCompleted(r2);
        if (getChildCount() != 0) goto L5;
        this.currentFillStartPosition = 0;
    L6:
        validateChildOrderIfDebugging();
        return;
    L5:
        this.currentFillStartPosition = getPosition(getChildAt(0));
        goto L6
    }

    private void addViewsStart(RecyclerView.Recycler r5, int r6) {
        int r0 = calculateChildStartForFill(r6);
    L3:
        if (r6 < 0) goto L12;
        ChildCalculations r1 = makeChildCalculations(r5, r0, r6);
        if (isLocOffsetOutOfFillBoundsStart(r1.locOffset, r1.range) == true) goto L17;
        r0 = addStart(r0, (int) this.currentKeylineState.getItemSize());
        if (isLocOffsetOutOfFillBoundsEnd(r1.locOffset, r1.range) == true) goto L11;
        addAndLayoutView(r1.child, 0, r1.locOffset);
    L11:
        r6 = r6 - 1;
        goto L3
    L17:
        return;
    }

    private void addViewsEnd(RecyclerView.Recycler r5, RecyclerView.State r6, int r7) {
        int r0 = calculateChildStartForFill(r7);
    L4:
        if (r7 >= r6.getItemCount()) goto L13;
        ChildCalculations r1 = makeChildCalculations(r5, r0, r7);
        if (isLocOffsetOutOfFillBoundsEnd(r1.locOffset, r1.range) == true) goto L18;
        r0 = addEnd(r0, (int) this.currentKeylineState.getItemSize());
        if (isLocOffsetOutOfFillBoundsStart(r1.locOffset, r1.range) == true) goto L12;
        addAndLayoutView(r1.child, -1, r1.locOffset);
    L12:
        r7 = r7 + 1;
        goto L4
    L18:
        return;
    }

    private void logChildrenIfDebugging() {
        if (this.isDebuggingEnabled == true) goto L6;
        return;
    L6:
        if (Log.isLoggable(TAG, 3) == false) goto L14;
        Log.d(TAG, "internal representation of views on the screen");
        int r0 = 0;
    L9:
        if (r0 >= getChildCount()) goto L11;
        View r2 = getChildAt(r0);
        Log.d(TAG, "item position " + getPosition(r2) + ", center:" + getDecoratedCenterXWithMargins(r2) + ", child index:" + r0);
        r0 = r0 + 1;
        goto L9
    L11:
        Log.d(TAG, "==============");
        return;
    }

    private void validateChildOrderIfDebugging() {
        if (this.isDebuggingEnabled == true) goto L5;
        return;
    L5:
        if (getChildCount() < 1) goto L18;
        int r0 = 0;
    L9:
        if (r0 >= (getChildCount() - 1)) goto L19;
        int r2 = getPosition(getChildAt(r0));
        int r3 = r0 + 1;
        int r4 = getPosition(getChildAt(r3));
        if (r2 > r4) goto L13;
        r0 = r3;
        goto L9
    L13:
        logChildrenIfDebugging();
        throw new IllegalStateException("Detected invalid child order. Child at index [" + r0 + "] had adapter position [" + r2 + "] and child at index [" + r3 + "] had adapter position [" + r4 + "].");
    L19:
        return;
    }

    private ChildCalculations makeChildCalculations(RecyclerView.Recycler r3, float r4, int r5) {
        float r0 = this.currentKeylineState.getItemSize() / 2.0f;
        View r6 = r3.getViewForPosition(r5);
        measureChildWithMargins(r6, 0, 0);
        float r7 = addEnd((int) r4, (int) r0);
        KeylineRange r8 = getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), r7, false);
        float r1 = calculateChildOffsetCenterForLocation(r6, r7, r8);
        updateChildMaskForLocation(r6, r7, r8);
        return new ChildCalculations(r6, r1, r8);
    }

    private void addAndLayoutView(View r8, int r9, float r10) {
        float r0 = this.currentKeylineState.getItemSize() / 2.0f;
        addView(r8, r9);
        layoutDecoratedWithMargins(r8, (int) (r10 - r0), getParentTop(), (int) (r10 + r0), getParentBottom());
    }

    private boolean isLocOffsetOutOfFillBoundsStart(float r3, KeylineRange r4) {
        float r5 = getMaskedItemSizeForLocOffset(r3, r4);
        int r6 = addEnd((int) r3, (int) (r5 / 2.0f));
        if (isLayoutRtl() == true) goto L5;
        if (r6 >= 0) goto L10;
        return true;
    L10:
        return false;
    L5:
        if (r6 <= getContainerWidth()) goto L10;
        return true;
    }

    private boolean isLocOffsetOutOfFillBoundsEnd(float r3, KeylineRange r4) {
        float r5 = getMaskedItemSizeForLocOffset(r3, r4);
        int r6 = addStart((int) r3, (int) (r5 / 2.0f));
        if (isLayoutRtl() == false) goto L7;
        if (r6 >= 0) goto L10;
        return true;
    L10:
        return false;
    L7:
        if (r6 <= getContainerWidth()) goto L10;
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void getDecoratedBoundsWithMargins(View r3, Rect r4) {
        super.getDecoratedBoundsWithMargins(r3, r4);
        float r5 = r4.centerX();
        float r6 = (r4.width() - getMaskedItemSizeForLocOffset(r5, getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), r5, true))) / 2.0f;
        r4.set((int) (r4.left + r6), r4.top, (int) (r4.right - r6), r4.bottom);
    }

    private float getDecoratedCenterXWithMargins(View r2) {
        Rect r0 = new Rect();
        super.getDecoratedBoundsWithMargins(r2, r0);
        return r0.centerX();
    }

    private void removeAndRecycleOutOfBoundsViews(RecyclerView.Recycler r5) {
    L3:
        if (getChildCount() <= 0) goto L8;
        View r0 = getChildAt(0);
        float r2 = getDecoratedCenterXWithMargins(r0);
        if (isLocOffsetOutOfFillBoundsStart(r2, getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), r2, true)) == false) goto L8;
        removeAndRecycleView(r0, r5);
    L8:
        if ((getChildCount() - 1) < 0) goto L12;
        View r1 = getChildAt(getChildCount() - 1);
        float r3 = getDecoratedCenterXWithMargins(r1);
        if (isLocOffsetOutOfFillBoundsEnd(r3, getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), r3, true)) == false) goto L18;
        removeAndRecycleView(r1, r5);
        goto L8
    L18:
        return;
    }

    private static KeylineRange getSurroundingKeylineRange(List<KeylineState.Keyline> r13, float r14, boolean r15) {
        float r1 = Float.MAX_VALUE;
        int r6 = -1;
        int r7 = -1;
        int r8 = -1;
        int r9 = -1;
        float r4 = -3.4028235E38f;
        int r5 = 0;
        float r2 = Float.MAX_VALUE;
        float r3 = Float.MAX_VALUE;
    L4:
        if (r5 >= r13.size()) goto L26;
        KeylineState.Keyline r10 = r13.get(r5);
        if (r15 == false) goto L8;
        float r11 = r10.locOffset;
    L9:
        float r12 = Math.abs(r11 - r14);
        if (r11 > r14) goto L15;
        if (r12 > r1) goto L15;
        r6 = r5;
        r1 = r12;
    L15:
        if (r11 <= r14) goto L20;
        if (r12 > r2) goto L20;
        r8 = r5;
        r2 = r12;
    L20:
        if (r11 > r3) goto L23;
        r7 = r5;
        r3 = r11;
    L23:
        if (r11 <= r4) goto L25;
        r9 = r5;
        r4 = r11;
    L25:
        r5 = r5 + 1;
        goto L4
    L8:
        r11 = r10.loc;
        goto L9
    L26:
        if (r6 != (-1)) goto L28;
        r6 = r7;
    L28:
        if (r8 != (-1)) goto L31;
        r8 = r9;
    L31:
        return new KeylineRange(r13.get(r6), r13.get(r8));
    }

    private void updateCurrentKeylineStateForScrollOffset() {
        int r0 = this.maxHorizontalScroll;
        int r1 = this.minHorizontalScroll;
        if (r0 <= r1) goto L5;
        this.currentKeylineState = this.keylineStateList.getShiftedState(this.horizontalScrollOffset, r1, r0);
    L10:
        this.debugItemDecoration.setKeylines(this.currentKeylineState.getKeylines());
        return;
    L5:
        if (isLayoutRtl() == false) goto L7;
        KeylineState r2 = this.keylineStateList.getRightState();
    L8:
        this.currentKeylineState = r2;
        goto L10
    L7:
        r2 = this.keylineStateList.getLeftState();
        goto L8
    }

    private int calculateStartHorizontalScroll(KeylineStateList r4) {
        boolean r0 = isLayoutRtl();
        if (r0 == false) goto L5;
        KeylineState r5 = r4.getRightState();
    L6:
        if (r0 == false) goto L8;
        KeylineState.Keyline r1 = r5.getLastFocalKeyline();
    L9:
        int r2 = getPaddingStart();
        if (r0 == false) goto L12;
        int r3 = 1;
    L14:
        return (int) (((r2 * r3) + getParentStart()) - addStart((int) r1.loc, (int) (r5.getItemSize() / 2.0f)));
    L12:
        r3 = -1;
        goto L14
    L8:
        r1 = r5.getFirstFocalKeyline();
        goto L9
    L5:
        r5 = r4.getLeftState();
        goto L6
    }

    private int calculateEndHorizontalScroll(RecyclerView.State r3, KeylineStateList r4) {
        boolean r0 = isLayoutRtl();
        if (r0 == false) goto L5;
        KeylineState r5 = r4.getLeftState();
    L6:
        if (r0 == false) goto L8;
        KeylineState.Keyline r1 = r5.getFirstFocalKeyline();
    L9:
        float r6 = ((r3.getItemCount() - 1) * r5.getItemSize()) + getPaddingEnd();
        if (r0 == false) goto L12;
        float r7 = -1.0f;
    L13:
        float r8 = r6 * r7;
        float r9 = r1.loc - getParentStart();
        float r2 = getParentEnd() - r1.loc;
        if (Math.abs(r9) <= Math.abs(r8)) goto L18;
        return 0;
    L18:
        return (int) ((r8 - r9) + r2);
    L12:
        r7 = 1.0f;
        goto L13
    L8:
        r1 = r5.getLastFocalKeyline();
        goto L9
    L5:
        r5 = r4.getRightState();
        goto L6
    }

    private int calculateChildStartForFill(int r3) {
        return addEnd((int) (getParentStart() - this.horizontalScrollOffset), (int) (this.currentKeylineState.getItemSize() * r3));
    }

    private float calculateChildOffsetCenterForLocation(View r5, float r6, KeylineRange r7) {
        float r0 = AnimationUtils.lerp(r7.left.locOffset, r7.right.locOffset, r7.left.loc, r7.right.loc, r6);
        if (r7.right != this.currentKeylineState.getFirstKeyline()) goto L5;
    L6:
        RecyclerView.LayoutParams r8 = (RecyclerView.LayoutParams) r5.getLayoutParams();
        return r0 + ((r6 - r7.right.loc) * ((1.0f - r7.right.mask) + ((r8.rightMargin + r8.leftMargin) / this.currentKeylineState.getItemSize())));
    L5:
        if (r7.left == this.currentKeylineState.getLastKeyline()) goto L6;
        return r0;
    }

    private float getMaskedItemSizeForLocOffset(float r3, KeylineRange r4) {
        return AnimationUtils.lerp(r4.left.maskedItemSize, r4.right.maskedItemSize, r4.left.locOffset, r4.right.locOffset, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateChildMaskForLocation(View r3, float r4, KeylineRange r5) {
        if ((r3 instanceof Maskable) == false) goto L6;
        Maskable r6 = (Maskable) r3;
        r6.setMaskXPercentage(AnimationUtils.lerp(r5.left.mask, r5.right.mask, r5.left.loc, r5.right.loc, r4));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void measureChildWithMargins(View r7, int r8, int r9) {
        if ((r7 instanceof Maskable) == false) goto L11;
        RecyclerView.LayoutParams r0 = (RecyclerView.LayoutParams) r7.getLayoutParams();
        Rect r1 = new Rect();
        calculateItemDecorationsForChild(r7, r1);
        int r10 = r8 + (r1.left + r1.right);
        int r11 = r9 + (r1.top + r1.bottom);
        KeylineStateList r2 = this.keylineStateList;
        if (r2 == null) goto L7;
        float r3 = r2.getDefaultState().getItemSize();
    L8:
        r7.measure(getChildMeasureSpec(getWidth(), getWidthMode(), (((getPaddingLeft() + getPaddingRight()) + r0.leftMargin) + r0.rightMargin) + r10, (int) r3, canScrollHorizontally()), getChildMeasureSpec(getHeight(), getHeightMode(), (((getPaddingTop() + getPaddingBottom()) + r0.topMargin) + r0.bottomMargin) + r11, r0.height, canScrollVertically()));
        return;
    L7:
        r3 = r0.width;
        goto L8
    L11:
        throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
    }

    private int getParentStart() {
        if (isLayoutRtl() == true) goto L7;
        return 0;
    L7:
        return getWidth();
    }

    private int getParentEnd() {
        if (isLayoutRtl() == false) goto L6;
        return 0;
    L6:
        return getWidth();
    }

    private int getParentTop() {
        return getPaddingTop();
    }

    private int getParentBottom() {
        return getHeight() - getPaddingBottom();
    }

    @Override // com.google.android.material.carousel.Carousel
    public int getContainerWidth() {
        return getWidth();
    }

    private boolean isLayoutRtl() {
        if (getLayoutDirection() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private int addStart(int r1, int r2) {
        if (isLayoutRtl() == false) goto L6;
        return r1 + r2;
    L6:
        return r1 - r2;
    }

    private int addEnd(int r1, int r2) {
        if (isLayoutRtl() == false) goto L6;
        return r1 - r2;
    L6:
        return r1 + r2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent r2) {
        super.onInitializeAccessibilityEvent(r2);
        if (getChildCount() <= 0) goto L6;
        r2.setFromIndex(getPosition(getChildAt(0)));
        r2.setToIndex(getPosition(getChildAt(getChildCount() - 1)));
        return;
    }

    private int getScrollOffsetForPosition(KeylineState r3, int r4) {
        if (isLayoutRtl() == false) goto L7;
        float r2 = ((getContainerWidth() - r3.getLastFocalKeyline().loc) - (r4 * r3.getItemSize())) - (r3.getItemSize() / 2.0f);
    L6:
        return (int) r2;
    L7:
        r2 = ((r4 * r3.getItemSize()) - r3.getFirstFocalKeyline().loc) + (r3.getItemSize() / 2.0f);
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int r3) {
        KeylineStateList r0 = this.keylineStateList;
        if (r0 != null) goto L5;
        return;
    L5:
        this.horizontalScrollOffset = getScrollOffsetForPosition(r0.getDefaultState(), r3);
        this.currentFillStartPosition = MathUtils.clamp(r3, 0, Math.max(0, getItemCount() - 1));
        updateCurrentKeylineStateForScrollOffset();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView r1, RecyclerView.State r2, int r3) {
        final Context r4 = r1.getContext();
        LinearSmoothScroller r5 = new AnonymousClass1(this, r4);
        r5.setTargetPosition(r3);
        startSmoothScroll(r5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int r2, RecyclerView.Recycler r3, RecyclerView.State r4) {
        if (canScrollHorizontally() == true) goto L7;
        return 0;
    L7:
        return scrollBy(r2, r3, r4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean requestChildRectangleOnScreen(RecyclerView r1, View r2, Rect r3, boolean r4, boolean r5) {
        KeylineStateList r6 = this.keylineStateList;
        if (r6 != null) goto L5;
        return false;
    L5:
        int r7 = getScrollOffsetForPosition(r6.getDefaultState(), getPosition(r2)) - this.horizontalScrollOffset;
        if (r5 == true) goto L10;
        if (r7 == 0) goto L10;
        r1.scrollBy(r7, 0);
        return true;
    L10:
        return false;
    }

    private int scrollBy(int r7, RecyclerView.Recycler r8, RecyclerView.State r9) {
        int r1 = 0;
        if (getChildCount() == 0) goto L12;
        if (r7 == 0) goto L12;
        int r10 = calculateShouldHorizontallyScrollBy(r7, this.horizontalScrollOffset, this.minHorizontalScroll, this.maxHorizontalScroll);
        this.horizontalScrollOffset += r10;
        updateCurrentKeylineStateForScrollOffset();
        float r0 = this.currentKeylineState.getItemSize() / 2.0f;
        int r2 = calculateChildStartForFill(getPosition(getChildAt(0)));
        Rect r3 = new Rect();
    L8:
        if (r1 >= getChildCount()) goto L10;
        offsetChildLeftAndRight(getChildAt(r1), r2, r0, r3);
        r2 = addEnd(r2, (int) this.currentKeylineState.getItemSize());
        r1 = r1 + 1;
        goto L8
    L10:
        fill(r8, r9);
        return r10;
    L12:
        return 0;
    }

    private void offsetChildLeftAndRight(View r3, float r4, float r5, Rect r6) {
        float r7 = addEnd((int) r4, (int) r5);
        KeylineRange r0 = getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), r7, false);
        float r1 = calculateChildOffsetCenterForLocation(r3, r7, r0);
        updateChildMaskForLocation(r3, r7, r0);
        super.getDecoratedBoundsWithMargins(r3, r6);
        r3.offsetLeftAndRight((int) (r1 - (r6.left + r5)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State r1) {
        return this.horizontalScrollOffset;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State r1) {
        return (int) this.keylineStateList.getDefaultState().getItemSize();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State r1) {
        return this.maxHorizontalScroll - this.minHorizontalScroll;
    }

    public void setDebuggingEnabled(RecyclerView r2, boolean r3) {
        this.isDebuggingEnabled = r3;
        r2.removeItemDecoration(this.debugItemDecoration);
        if (r3 == false) goto L5;
        r2.addItemDecoration(this.debugItemDecoration);
    L5:
        r2.invalidateItemDecorations();
    }
}
