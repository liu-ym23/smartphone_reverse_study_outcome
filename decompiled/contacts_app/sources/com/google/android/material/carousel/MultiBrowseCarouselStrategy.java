package com.google.android.material.carousel;

import android.content.Context;
import android.view.View;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes2.dex */
public final class MultiBrowseCarouselStrategy extends CarouselStrategy {
    private static final int[] MEDIUM_COUNTS = null;
    private static final int[] MEDIUM_COUNTS_COMPACT = null;
    private static final float MEDIUM_ITEM_FLEX_PERCENTAGE = 0.1f;
    private static final int[] SMALL_COUNTS = null;
    private final boolean forceCompactArrangement;

    static final class Arrangement {
        final float cost;
        final int largeCount;
        float largeSize;
        final int mediumCount;
        float mediumSize;
        final int priority;
        final int smallCount;
        float smallSize;

        private float calculateLargeSize(float r1, int r2, float r3, int r4, int r5) {
            if (r2 > 0) goto L5;
            r3 = 0.0f;
        L5:
            float r0 = r2;
            float r6 = r4 / 2.0f;
            return (r1 - ((r0 + r6) * r3)) / (r5 + r6);
        }

        Arrangement(int r1, float r2, float r3, float r4, int r5, float r6, int r7, float r8, int r9, float r10) {
            this.priority = r1;
            this.smallSize = MathUtils.clamp(r2, r3, r4);
            this.smallCount = r5;
            this.mediumSize = r6;
            this.mediumCount = r7;
            this.largeSize = r8;
            this.largeCount = r9;
            fit(r10, r3, r4, r8);
            this.cost = cost(r8);
        }

        public String toString() {
            return "Arrangement [priority=" + this.priority + ", smallCount=" + this.smallCount + ", smallSize=" + this.smallSize + ", mediumCount=" + this.mediumCount + ", mediumSize=" + this.mediumSize + ", largeCount=" + this.largeCount + ", largeSize=" + this.largeSize + ", cost=" + this.cost + "]";
        }

        private float getSpace() {
            return ((this.largeSize * this.largeCount) + (this.mediumSize * this.mediumCount)) + (this.smallSize * this.smallCount);
        }

        private void fit(float r10, float r11, float r12, float r13) {
            float r0 = r10 - getSpace();
            int r1 = this.smallCount;
            if (r1 > 0) goto L5;
        L7:
            if (r1 > 0) goto L9;
        L11:
            float r14 = calculateLargeSize(r10, this.smallCount, this.smallSize, this.mediumCount, this.largeCount);
            this.largeSize = r14;
            float r15 = (this.smallSize + r14) / 2.0f;
            this.mediumSize = r15;
            int r16 = this.mediumCount;
            if (r16 > 0) goto L14;
            return;
        L14:
            if (r14 == r13) goto L21;
            float r17 = (r13 - r14) * this.largeCount;
            float r18 = Math.min(Math.abs(r17), (r15 * 0.1f) * r16);
            if (r17 <= 0.0f) goto L18;
            this.mediumSize -= r18 / this.mediumCount;
            this.largeSize += r18 / this.largeCount;
            return;
        L18:
            this.mediumSize += r18 / this.mediumCount;
            this.largeSize -= r18 / this.largeCount;
            return;
        L21:
            return;
        L9:
            if (r0 >= 0.0f) goto L11;
            float r19 = this.smallSize;
            this.smallSize = r19 + Math.max(r0 / r1, r11 - r19);
            goto L11
        L5:
            if (r0 <= 0.0f) goto L7;
            float r110 = this.smallSize;
            this.smallSize = r110 + Math.min(r0 / r1, r12 - r110);
            goto L11
        }

        private boolean isValid() {
            int r0 = this.largeCount;
            if (r0 > 0) goto L5;
        L14:
            if (r0 > 0) goto L16;
        L21:
            return true;
        L16:
            if (this.smallCount <= 0) goto L21;
            if (this.largeSize > this.smallSize) goto L20;
            return false;
        L20:
            return true;
        L5:
            if (this.smallCount <= 0) goto L14;
            if (this.mediumCount <= 0) goto L14;
            float r1 = this.largeSize;
            float r3 = this.mediumSize;
            if (r1 > r3) goto L11;
            return false;
        L11:
            if (r3 > this.smallSize) goto L13;
            return false;
        L13:
            return true;
        }

        private float cost(float r2) {
            if (isValid() == true) goto L7;
            return Float.MAX_VALUE;
        L7:
            return Math.abs(r2 - this.largeSize) * this.priority;
        }
    }

    static {
        SMALL_COUNTS = new int[]{1};
        MEDIUM_COUNTS = new int[]{1, 0};
        MEDIUM_COUNTS_COMPACT = new int[]{0};
    }

    public MultiBrowseCarouselStrategy() {
        this(false);
    }

    public MultiBrowseCarouselStrategy(boolean r1) {
        this.forceCompactArrangement = r1;
    }

    private float getExtraSmallSize(Context r1) {
        return r1.getResources().getDimension(R.dimen.m3_carousel_gone_size);
    }

    private float getSmallSizeMin(Context r1) {
        return r1.getResources().getDimension(R.dimen.m3_carousel_small_item_size_min);
    }

    private float getSmallSizeMax(Context r1) {
        return r1.getResources().getDimension(R.dimen.m3_carousel_small_item_size_max);
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    KeylineState onFirstChildMeasuredWithMargins(Carousel r22, View r23) {
        float r2 = r22.getContainerWidth();
        RecyclerView.LayoutParams r1 = (RecyclerView.LayoutParams) r23.getLayoutParams();
        float r3 = r1.leftMargin + r1.rightMargin;
        float r4 = getSmallSizeMin(r23.getContext()) + r3;
        float r5 = getSmallSizeMax(r23.getContext()) + r3;
        float r6 = r23.getMeasuredWidth();
        float r9 = Math.min(r6 + r3, r2);
        float r7 = MathUtils.clamp((r6 / 3.0f) + r3, getSmallSizeMin(r23.getContext()) + r3, getSmallSizeMax(r23.getContext()) + r3);
        float r8 = (r9 + r7) / 2.0f;
        int[] r10 = SMALL_COUNTS;
        if (this.forceCompactArrangement == false) goto L5;
        int[] r11 = MEDIUM_COUNTS_COMPACT;
    L6:
        int r12 = (int) Math.max(1.0d, Math.floor(((r2 - (maxValue(r11) * r8)) - (maxValue(r10) * r5)) / r9));
        int r13 = (int) Math.ceil(r2 / r9);
        int r14 = (r13 - r12) + 1;
        int[] r15 = new int[r14];
        int r16 = 0;
    L7:
        if (r16 >= r14) goto L9;
        r15[r16] = r13 - r16;
        r16 = r16 + 1;
        goto L7
    L9:
        Arrangement r17 = findLowestCostArrangement(r2, r7, r4, r5, r10, r8, r11, r9, r15);
        float r0 = getExtraSmallSize(r23.getContext()) + r3;
        float r18 = r0 / 2.0f;
        float r19 = 0.0f - r18;
        float r110 = (r17.largeSize / 2.0f) + 0.0f;
        float r20 = r110 + (Math.max(0, r17.largeCount - 1) * r17.largeSize);
        float r21 = (r17.largeSize / 2.0f) + r20;
        if (r17.mediumCount <= 0) goto L13;
        r20 = (r17.mediumSize / 2.0f) + r21;
    L13:
        if (r17.mediumCount <= 0) goto L16;
        r21 = (r17.mediumSize / 2.0f) + r20;
    L16:
        if (r17.smallCount <= 0) goto L18;
        float r24 = r21 + (r17.smallSize / 2.0f);
    L19:
        float r25 = r22.getContainerWidth() + r18;
        float r26 = getChildMaskPercentage(r0, r17.largeSize, r3);
        float r27 = getChildMaskPercentage(r17.smallSize, r17.largeSize, r3);
        float r28 = getChildMaskPercentage(r17.mediumSize, r17.largeSize, r3);
        KeylineState.Builder r29 = new KeylineState.Builder(r17.largeSize).addKeyline(r19, r26, r0).addKeylineRange(r110, 0.0f, r17.largeSize, r17.largeCount, true);
        if (r17.mediumCount <= 0) goto L23;
        r29.addKeyline(r20, r28, r17.mediumSize);
    L23:
        if (r17.smallCount <= 0) goto L25;
        r29.addKeylineRange(r24, r27, r17.smallSize, r17.smallCount);
    L25:
        r29.addKeyline(r25, r26, r0);
        return r29.build();
    L18:
        r24 = r20;
        goto L19
    L5:
        r11 = MEDIUM_COUNTS;
        goto L6
    }

    private static Arrangement findLowestCostArrangement(float r25, float r26, float r27, float r28, int[] r29, float r30, int[] r31, float r32, int[] r33) {
        int r3 = r33.length;
        Arrangement r4 = null;
        int r5 = 1;
        int r7 = 0;
    L3:
        if (r7 >= r3) goto L19;
        int r19 = r33[r7];
        int r15 = r31.length;
        int r14 = 0;
    L5:
        if (r14 >= r15) goto L18;
        int r20 = r31[r14];
        int r13 = r29.length;
        int r12 = 0;
    L7:
        if (r12 >= r13) goto L17;
        int r9 = r5;
        int r21 = r12;
        int r22 = r13;
        int r23 = r14;
        int r24 = r15;
        Arrangement r11 = new Arrangement(r9, r26, r27, r28, r29[r12], r30, r20, r32, r19, r25);
        if (r4 == null) goto L13;
        if (r11.cost < r4.cost) goto L13;
    L16:
        r5 = r5 + 1;
        r12 = r21 + 1;
        r13 = r22;
        r14 = r23;
        r15 = r24;
    L13:
        if (r11.cost == 0.0f) goto L14;
        r4 = r11;
        goto L16
    L14:
        return r11;
    L17:
        r14 = r14 + 1;
        goto L5
    L18:
        r7 = r7 + 1;
        goto L3
    L19:
        return r4;
    }

    private static int maxValue(int[] r4) {
        int r0 = r4.length;
        int r1 = Integer.MIN_VALUE;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        int r3 = r4[r2];
        if (r3 <= r1) goto L7;
        r1 = r3;
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        return r1;
    }
}
