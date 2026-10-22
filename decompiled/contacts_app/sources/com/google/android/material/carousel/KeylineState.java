package com.google.android.material.carousel;

import com.google.android.material.animation.AnimationUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class KeylineState {
    private final int firstFocalKeylineIndex;
    private final float itemSize;
    private final List<Keyline> keylines;
    private final int lastFocalKeylineIndex;

    /* JADX INFO: renamed from: com.google.android.material.carousel.KeylineState$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static final class Builder {
        private static final int NO_INDEX = -1;
        private static final float UNKNOWN_LOC = Float.MIN_VALUE;
        private int firstFocalKeylineIndex;
        private final float itemSize;
        private int lastFocalKeylineIndex;
        private float lastKeylineMaskedSize;
        private Keyline tmpFirstFocalKeyline;
        private final List<Keyline> tmpKeylines;
        private Keyline tmpLastFocalKeyline;

        private static float calculateKeylineLocationForItemPosition(float r0, float r1, int r2, int r3) {
            return (r0 - (r2 * r1)) + (r3 * r1);
        }

        Builder(float r2) {
            this.tmpKeylines = new ArrayList();
            this.firstFocalKeylineIndex = -1;
            this.lastFocalKeylineIndex = -1;
            this.lastKeylineMaskedSize = 0.0f;
            this.itemSize = r2;
        }

        Builder addKeyline(float r2, float r3, float r4) {
            return addKeyline(r2, r3, r4, false);
        }

        Builder addKeyline(float r3, float r4, float r5, boolean r6) {
            if (r5 > 0.0f) goto L5;
            return this;
        L5:
            Keyline r0 = new Keyline(Float.MIN_VALUE, r3, r4, r5);
            if (r6 == false) goto L23;
            if (this.tmpFirstFocalKeyline != null) goto L11;
            this.tmpFirstFocalKeyline = r0;
            this.firstFocalKeylineIndex = this.tmpKeylines.size();
        L11:
            if (this.lastFocalKeylineIndex == (-1)) goto L18;
            if ((this.tmpKeylines.size() - this.lastFocalKeylineIndex) <= 1) goto L18;
            throw new IllegalArgumentException("Keylines marked as focal must be placed next to each other. There cannot be non-focal keylines between focal keylines.");
        L18:
            if (r5 != this.tmpFirstFocalKeyline.maskedItemSize) goto L21;
            this.tmpLastFocalKeyline = r0;
            this.lastFocalKeylineIndex = this.tmpKeylines.size();
        L36:
            this.lastKeylineMaskedSize = r0.maskedItemSize;
            this.tmpKeylines.add(r0);
            return this;
        L21:
            throw new IllegalArgumentException("Keylines that are marked as focal must all have the same masked item size.");
        L23:
            if (this.tmpFirstFocalKeyline != null) goto L30;
            if (r0.maskedItemSize >= this.lastKeylineMaskedSize) goto L30;
            throw new IllegalArgumentException("Keylines before the first focal keyline must be ordered by incrementing masked item size.");
        L30:
            if (this.tmpLastFocalKeyline == null) goto L36;
            if (r0.maskedItemSize <= this.lastKeylineMaskedSize) goto L36;
            throw new IllegalArgumentException("Keylines after the last focal keyline must be ordered by decreasing masked item size.");
        }

        Builder addKeylineRange(float r7, float r8, float r9, int r10) {
            return addKeylineRange(r7, r8, r9, r10, false);
        }

        Builder addKeylineRange(float r3, float r4, float r5, int r6, boolean r7) {
            if (r6 > 0) goto L4;
        L9:
            return this;
        L4:
            if (r5 <= 0.0f) goto L9;
            int r0 = 0;
        L7:
            if (r0 >= r6) goto L9;
            addKeyline((r0 * r5) + r3, r4, r5, r7);
            r0 = r0 + 1;
            goto L7
        }

        KeylineState build() {
            if (this.tmpFirstFocalKeyline == null) goto L11;
            ArrayList r3 = new ArrayList();
            int r0 = 0;
        L6:
            if (r0 >= this.tmpKeylines.size()) goto L9;
            Keyline r1 = this.tmpKeylines.get(r0);
            r3.add(new Keyline(calculateKeylineLocationForItemPosition(this.tmpFirstFocalKeyline.locOffset, this.itemSize, this.firstFocalKeylineIndex, r0), r1.locOffset, r1.mask, r1.maskedItemSize));
            r0 = r0 + 1;
            goto L6
        L9:
            return new KeylineState(this.itemSize, r3, this.firstFocalKeylineIndex, this.lastFocalKeylineIndex, null);
        L11:
            throw new IllegalStateException("There must be a keyline marked as focal.");
        }
    }

    static final class Keyline {
        final float loc;
        final float locOffset;
        final float mask;
        final float maskedItemSize;

        Keyline(float r1, float r2, float r3, float r4) {
            this.loc = r1;
            this.locOffset = r2;
            this.mask = r3;
            this.maskedItemSize = r4;
        }

        static Keyline lerp(Keyline r5, Keyline r6, float r7) {
            return new Keyline(AnimationUtils.lerp(r5.loc, r6.loc, r7), AnimationUtils.lerp(r5.locOffset, r6.locOffset, r7), AnimationUtils.lerp(r5.mask, r6.mask, r7), AnimationUtils.lerp(r5.maskedItemSize, r6.maskedItemSize, r7));
        }
    }

    /* synthetic */ KeylineState(float r1, List r2, int r3, int r4, AnonymousClass1 r5) {
        this(r1, r2, r3, r4);
    }

    private KeylineState(float r1, List<Keyline> r2, int r3, int r4) {
        this.itemSize = r1;
        this.keylines = Collections.unmodifiableList(r2);
        this.firstFocalKeylineIndex = r3;
        this.lastFocalKeylineIndex = r4;
    }

    float getItemSize() {
        return this.itemSize;
    }

    List<Keyline> getKeylines() {
        return this.keylines;
    }

    Keyline getFirstFocalKeyline() {
        return this.keylines.get(this.firstFocalKeylineIndex);
    }

    int getFirstFocalKeylineIndex() {
        return this.firstFocalKeylineIndex;
    }

    Keyline getLastFocalKeyline() {
        return this.keylines.get(this.lastFocalKeylineIndex);
    }

    int getLastFocalKeylineIndex() {
        return this.lastFocalKeylineIndex;
    }

    Keyline getFirstKeyline() {
        return this.keylines.get(0);
    }

    Keyline getLastKeyline() {
        List<Keyline> r1 = this.keylines;
        return r1.get(r1.size() - 1);
    }

    static KeylineState lerp(KeylineState r6, KeylineState r7, float r8) {
        if (r6.getItemSize() != r7.getItemSize()) goto L15;
        List<Keyline> r0 = r6.getKeylines();
        List<Keyline> r1 = r7.getKeylines();
        if (r0.size() != r1.size()) goto L13;
        ArrayList r2 = new ArrayList();
        int r3 = 0;
    L8:
        if (r3 >= r6.getKeylines().size()) goto L10;
        r2.add(Keyline.lerp(r0.get(r3), r1.get(r3), r8));
        r3 = r3 + 1;
        goto L8
    L10:
        int r4 = AnimationUtils.lerp(r6.getFirstFocalKeylineIndex(), r7.getFirstFocalKeylineIndex(), r8);
        int r9 = AnimationUtils.lerp(r6.getLastFocalKeylineIndex(), r7.getLastFocalKeylineIndex(), r8);
        return new KeylineState(r6.getItemSize(), r2, r4, r9);
    L13:
        throw new IllegalArgumentException("Keylines being linearly interpolated must have the same number of keylines.");
    L15:
        throw new IllegalArgumentException("Keylines being linearly interpolated must have the same item size.");
    }

    static KeylineState reverse(KeylineState r10) {
        Builder r0 = new Builder(r10.getItemSize());
        float r1 = r10.getFirstKeyline().locOffset - (r10.getFirstKeyline().maskedItemSize / 2.0f);
        int r2 = r10.getKeylines().size() - 1;
    L3:
        if (r2 < 0) goto L12;
        Keyline r5 = r10.getKeylines().get(r2);
        float r6 = (r5.maskedItemSize / 2.0f) + r1;
        if (r2 >= r10.getFirstFocalKeylineIndex()) goto L7;
    L9:
        boolean r7 = false;
    L10:
        r0.addKeyline(r6, r5.mask, r5.maskedItemSize, r7);
        r1 = r1 + r5.maskedItemSize;
        r2 = r2 - 1;
        goto L3
    L7:
        if (r2 > r10.getLastFocalKeylineIndex()) goto L9;
        r7 = true;
        goto L10
    L12:
        return r0.build();
    }
}
