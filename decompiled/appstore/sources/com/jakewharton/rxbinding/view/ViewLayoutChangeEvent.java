package com.jakewharton.rxbinding.view;

import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class ViewLayoutChangeEvent extends ViewEvent<View> {
    private final int bottom;
    private final int left;
    private final int oldBottom;
    private final int oldLeft;
    private final int oldRight;
    private final int oldTop;
    private final int right;
    private final int top;

    private ViewLayoutChangeEvent(@NonNull View r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18) {
        super(r10);
        this.left = r11;
        this.top = r12;
        this.right = r13;
        this.bottom = r14;
        this.oldLeft = r15;
        this.oldTop = r16;
        this.oldRight = r17;
        this.oldBottom = r18;
    }

    @NonNull
    @CheckResult
    public static ViewLayoutChangeEvent create(@NonNull View r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19) {
        return new ViewLayoutChangeEvent(r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }

    public int bottom() {
        return this.bottom;
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof ViewLayoutChangeEvent) == true) goto L8;
        return false;
    L8:
        ViewLayoutChangeEvent r11 = (ViewLayoutChangeEvent) r10;
        if (r11.view() != view()) goto L28;
        if (r11.left != this.left) goto L28;
        if (r11.top != this.top) goto L28;
        if (r11.right != this.right) goto L28;
        if (r11.bottom != this.bottom) goto L28;
        if (r11.oldLeft != this.oldLeft) goto L28;
        if (r11.oldTop != this.oldTop) goto L28;
        if (r11.oldRight != this.oldRight) goto L28;
        if (r11.oldBottom != this.oldBottom) goto L28;
        return true;
    L28:
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((629 + view().hashCode()) * 37) + this.left) * 37) + this.top) * 37) + this.right) * 37) + this.bottom) * 37) + this.oldLeft) * 37) + this.oldTop) * 37) + this.oldRight) * 37) + this.oldBottom;
    }

    public int left() {
        return this.left;
    }

    public int oldBottom() {
        return this.oldBottom;
    }

    public int oldLeft() {
        return this.oldLeft;
    }

    public int oldRight() {
        return this.oldRight;
    }

    public int oldTop() {
        return this.oldTop;
    }

    public int right() {
        return this.right;
    }

    public String toString() {
        return "ViewLayoutChangeEvent{left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ", oldLeft=" + this.oldLeft + ", oldTop=" + this.oldTop + ", oldRight=" + this.oldRight + ", oldBottom=" + this.oldBottom + '}';
    }

    public int top() {
        return this.top;
    }
}
