package com.google.android.material.carousel;

import com.google.android.material.animation.AnimationUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class KeylineStateList {
    private static final int NO_INDEX = -1;
    private final KeylineState defaultState;
    private final float leftShiftRange;
    private final List<KeylineState> leftStateSteps;
    private final float[] leftStateStepsInterpolationPoints;
    private final float rightShiftRange;
    private final List<KeylineState> rightStateSteps;
    private final float[] rightStateStepsInterpolationPoints;

    private KeylineStateList(KeylineState r4, List<KeylineState> r5, List<KeylineState> r6) {
        this.defaultState = r4;
        this.leftStateSteps = Collections.unmodifiableList(r5);
        this.rightStateSteps = Collections.unmodifiableList(r6);
        float r0 = r5.get(r5.size() - 1).getFirstKeyline().loc - r4.getFirstKeyline().loc;
        this.leftShiftRange = r0;
        float r7 = r4.getLastKeyline().loc - r6.get(r6.size() - 1).getLastKeyline().loc;
        this.rightShiftRange = r7;
        this.leftStateStepsInterpolationPoints = getStateStepInterpolationPoints(r0, r5, true);
        this.rightStateStepsInterpolationPoints = getStateStepInterpolationPoints(r7, r6, false);
    }

    static KeylineStateList from(Carousel r2, KeylineState r3) {
        return new KeylineStateList(r3, getStateStepsLeft(r3), getStateStepsRight(r2, r3));
    }

    KeylineState getDefaultState() {
        return this.defaultState;
    }

    KeylineState getLeftState() {
        List<KeylineState> r1 = this.leftStateSteps;
        return r1.get(r1.size() - 1);
    }

    KeylineState getRightState() {
        List<KeylineState> r1 = this.rightStateSteps;
        return r1.get(r1.size() - 1);
    }

    public KeylineState getShiftedState(float r6, float r7, float r8) {
        float r0 = this.leftShiftRange + r7;
        float r1 = r8 - this.rightShiftRange;
        if (r6 >= r0) goto L7;
        float r9 = AnimationUtils.lerp(1.0f, 0.0f, r7, r0, r6);
        return lerp(this.leftStateSteps, r9, this.leftStateStepsInterpolationPoints);
    L7:
        if (r6 <= r1) goto L11;
        float r10 = AnimationUtils.lerp(0.0f, 1.0f, r1, r8, r6);
        return lerp(this.rightStateSteps, r10, this.rightStateStepsInterpolationPoints);
    L11:
        return this.defaultState;
    }

    private static KeylineState lerp(List<KeylineState> r6, float r7, float[] r8) {
        int r0 = r6.size();
        float r2 = r8[0];
        int r3 = 1;
    L3:
        if (r3 >= r0) goto L10;
        float r4 = r8[r3];
        if (r7 <= r4) goto L7;
        r3 = r3 + 1;
        r2 = r4;
        goto L3
    L7:
        return KeylineState.lerp(r6.get(r3 - 1), r6.get(r3), AnimationUtils.lerp(0.0f, 1.0f, r2, r4, r7));
    L10:
        return r6.get(0);
    }

    private static float[] getStateStepInterpolationPoints(float r6, List<KeylineState> r7, boolean r8) {
        int r0 = r7.size();
        float[] r1 = new float[r0];
        int r2 = 1;
    L3:
        if (r2 >= r0) goto L13;
        int r3 = r2 - 1;
        KeylineState r4 = r7.get(r3);
        KeylineState r5 = r7.get(r2);
        if (r8 == false) goto L7;
        float r9 = r5.getFirstKeyline().loc - r4.getFirstKeyline().loc;
    L8:
        float r10 = r9 / r6;
        if (r2 != (r0 - 1)) goto L11;
        float r11 = 1.0f;
    L12:
        r1[r2] = r11;
        r2 = r2 + 1;
        goto L3
    L11:
        r11 = r1[r3] + r10;
        goto L12
    L7:
        r9 = r4.getLastKeyline().loc - r5.getLastKeyline().loc;
        goto L8
    L13:
        return r1;
    }

    private static boolean isFirstFocalItemAtLeftOfContainer(KeylineState r3) {
        if ((r3.getFirstFocalKeyline().locOffset - (r3.getFirstFocalKeyline().maskedItemSize / 2.0f)) > 0.0f) goto L5;
    L8:
        return true;
    L5:
        if (r3.getFirstFocalKeyline() == r3.getFirstKeyline()) goto L8;
        return false;
    }

    private static List<KeylineState> getStateStepsLeft(KeylineState r11) {
        ArrayList r0 = new ArrayList();
        r0.add(r11);
        int r7 = findFirstInBoundsKeylineIndex(r11);
        if (isFirstFocalItemAtLeftOfContainer(r11) == false) goto L5;
    L13:
        return r0;
    L5:
        if (r7 == (-1)) goto L13;
        int r8 = (r11.getFirstFocalKeylineIndex() - 1) - r7;
        float r9 = r11.getFirstKeyline().locOffset - (r11.getFirstKeyline().maskedItemSize / 2.0f);
        int r10 = 0;
    L8:
        if (r10 > r8) goto L13;
        KeylineState r1 = (KeylineState) r0.get(r0.size() - 1);
        int r3 = r11.getKeylines().size() - 1;
        int r2 = (r7 + r10) - 1;
        if (r2 < 0) goto L12;
        r3 = findFirstIndexAfterLastFocalKeylineWithMask(r1, r11.getKeylines().get(r2).mask) - 1;
    L12:
        r0.add(moveKeylineAndCreateKeylineState(r1, r7, r3, r9, (r11.getFirstFocalKeylineIndex() - r10) - 1, (r11.getLastFocalKeylineIndex() - r10) - 1));
        r10 = r10 + 1;
        goto L8
    }

    private static boolean isLastFocalItemAtRightOfContainer(Carousel r3, KeylineState r4) {
        if ((r4.getLastFocalKeyline().locOffset + (r4.getLastFocalKeyline().maskedItemSize / 2.0f)) < r3.getContainerWidth()) goto L5;
    L8:
        return true;
    L5:
        if (r4.getLastFocalKeyline() == r4.getLastKeyline()) goto L8;
        return false;
    }

    private static List<KeylineState> getStateStepsRight(Carousel r11, KeylineState r12) {
        ArrayList r0 = new ArrayList();
        r0.add(r12);
        int r7 = findLastInBoundsKeylineIndex(r11, r12);
        if (isLastFocalItemAtRightOfContainer(r11, r12) == false) goto L5;
    L14:
        return r0;
    L5:
        if (r7 == (-1)) goto L14;
        int r13 = r7 - r12.getLastFocalKeylineIndex();
        float r8 = r12.getFirstKeyline().locOffset - (r12.getFirstKeyline().maskedItemSize / 2.0f);
        int r10 = 0;
    L8:
        if (r10 >= r13) goto L14;
        KeylineState r1 = (KeylineState) r0.get(r0.size() - 1);
        int r2 = (r7 - r10) + 1;
        if (r2 >= r12.getKeylines().size()) goto L12;
        int r3 = findLastIndexBeforeFirstFocalKeylineWithMask(r1, r12.getKeylines().get(r2).mask) + 1;
    L13:
        r0.add(moveKeylineAndCreateKeylineState(r1, r7, r3, r8, (r12.getFirstFocalKeylineIndex() + r10) + 1, (r12.getLastFocalKeylineIndex() + r10) + 1));
        r10 = r10 + 1;
        goto L8
    L12:
        r3 = 0;
        goto L13
    }

    private static KeylineState moveKeylineAndCreateKeylineState(KeylineState r6, int r7, int r8, float r9, int r10, int r11) {
        ArrayList r0 = new ArrayList(r6.getKeylines());
        r0.add(r8, (KeylineState.Keyline) r0.remove(r7));
        KeylineState.Builder r12 = new KeylineState.Builder(r6.getItemSize());
        int r13 = 0;
    L4:
        if (r13 >= r0.size()) goto L12;
        KeylineState.Keyline r1 = (KeylineState.Keyline) r0.get(r13);
        float r2 = (r1.maskedItemSize / 2.0f) + r9;
        if (r13 < r10) goto L9;
        if (r13 > r11) goto L9;
        boolean r3 = true;
    L10:
        r12.addKeyline(r2, r1.mask, r1.maskedItemSize, r3);
        r9 = r9 + r1.maskedItemSize;
        r13 = r13 + 1;
    L9:
        r3 = false;
        goto L10
    L12:
        return r12.build();
    }

    private static int findFirstIndexAfterLastFocalKeylineWithMask(KeylineState r2, float r3) {
        int r0 = r2.getLastFocalKeylineIndex();
    L4:
        if (r0 >= r2.getKeylines().size()) goto L10;
        if (r3 == r2.getKeylines().get(r0).mask) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L10:
        return r2.getKeylines().size() - 1;
    }

    private static int findLastIndexBeforeFirstFocalKeylineWithMask(KeylineState r2, float r3) {
        int r0 = r2.getFirstFocalKeylineIndex() - 1;
    L3:
        if (r0 < 0) goto L8;
        if (r3 == r2.getKeylines().get(r0).mask) goto L6;
        r0 = r0 - 1;
        goto L3
    L6:
        return r0;
    L8:
        return 0;
    }

    private static int findFirstInBoundsKeylineIndex(KeylineState r3) {
        int r0 = 0;
    L4:
        if (r0 >= r3.getKeylines().size()) goto L9;
        if (r3.getKeylines().get(r0).locOffset >= 0.0f) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L9:
        return -1;
    }

    private static int findLastInBoundsKeylineIndex(Carousel r3, KeylineState r4) {
        int r0 = r4.getKeylines().size() - 1;
    L3:
        if (r0 < 0) goto L8;
        if (r4.getKeylines().get(r0).locOffset <= r3.getContainerWidth()) goto L6;
        r0 = r0 - 1;
        goto L3
    L6:
        return r0;
    L8:
        return -1;
    }
}
