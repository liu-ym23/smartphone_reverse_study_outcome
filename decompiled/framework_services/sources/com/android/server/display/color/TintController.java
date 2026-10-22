package com.android.server.display.color;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.Slog;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
abstract class TintController {
    private static final long TRANSITION_DURATION = 3000;
    private ValueAnimator mAnimator;
    private Boolean mIsActivated;
    private final Object mLock;

    public abstract int getLevel();

    public abstract float[] getMatrix();

    public abstract boolean isAvailable(Context r1);

    public abstract void setMatrix(int r1);

    public abstract void setUp(Context r1, boolean r2);

    TintController() {
        this.mLock = new Object();
    }

    public ValueAnimator getAnimator() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ValueAnimator r1 = this.mAnimator;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void setAnimator(ValueAnimator animator) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mAnimator = animator;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void cancelAnimator() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mAnimator == null) goto L9;
        this.mAnimator.cancel();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    public void endAnimator() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mAnimator == null) goto L9;
        this.mAnimator.end();     // Catch: Throwable -> L7
        this.mAnimator = null;     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    public void setActivated(Boolean isActivated) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mIsActivated = isActivated;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isActivated() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsActivated != null) goto L7;
    L11:
        boolean r1 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L7:
        if (this.mIsActivated.booleanValue() == false) goto L11;
        r1 = true;
        goto L12
    }

    public boolean isActivatedStateNotSet() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsActivated != null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    public long getTransitionDurationMilliseconds() {
        return 3000;
    }

    public long getTransitionDurationMilliseconds(boolean direction) {
        return 3000;
    }

    public void dump(PrintWriter pw) {
    }

    static String matrixToString(float[] matrix, int columns) {
        if (matrix == null) goto L15;
        if (columns <= 0) goto L15;
        StringBuilder sb = new StringBuilder("");
        int i = 0;
    L8:
        if (i >= matrix.length) goto L14;
        if ((i % columns) != 0) goto L12;
        sb.append("\n      ");
    L12:
        sb.append(String.format("%9.6f", new Object[]{Float.valueOf(matrix[i])}));
        i = i + 1;
        goto L8
    L14:
        return sb.toString();
    L15:
        StringBuilder r1 = new StringBuilder();
        r1.append("Invalid arguments when formatting matrix to string, matrix is null: ");
        if (matrix != null) goto L18;
        boolean r2 = true;
    L19:
        r1.append(r2);
        r1.append(" columns: ");
        r1.append(columns);
        Slog.e("ColorDisplayService", r1.toString());
        return "";
    L18:
        r2 = false;
        goto L19
    }
}
