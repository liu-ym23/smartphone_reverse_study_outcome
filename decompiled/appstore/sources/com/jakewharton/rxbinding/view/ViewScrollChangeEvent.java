package com.jakewharton.rxbinding.view;

import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class ViewScrollChangeEvent extends ViewEvent<View> {
    private final int oldScrollX;
    private final int oldScrollY;
    private final int scrollX;
    private final int scrollY;

    public ViewScrollChangeEvent(@NonNull View r10, int r11, int r12, int r13, int r14) {
        super(r10);
        this.scrollX = r11;
        this.scrollY = r12;
        this.oldScrollX = r13;
        this.oldScrollY = r14;
    }

    @NonNull
    @CheckResult
    public static ViewScrollChangeEvent create(@NonNull View r10, int r11, int r12, int r13, int r14) {
        return new ViewScrollChangeEvent(r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof ViewScrollChangeEvent) == true) goto L8;
        return false;
    L8:
        ViewScrollChangeEvent r11 = (ViewScrollChangeEvent) r10;
        if (r11.view() != view()) goto L20;
        if (r11.scrollX != this.scrollX) goto L20;
        if (r11.scrollY != this.scrollY) goto L20;
        if (r11.oldScrollX != this.oldScrollX) goto L20;
        if (r11.oldScrollY != this.oldScrollY) goto L20;
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        return ((((((((629 + view().hashCode()) * 37) + this.scrollX) * 37) + this.scrollY) * 37) + this.oldScrollX) * 37) + this.oldScrollY;
    }

    public int oldScrollX() {
        return this.oldScrollX;
    }

    public int oldScrollY() {
        return this.oldScrollY;
    }

    public int scrollX() {
        return this.scrollX;
    }

    public int scrollY() {
        return this.scrollY;
    }

    public String toString() {
        return "ViewScrollChangeEvent{scrollX=" + this.scrollX + ", scrollY=" + this.scrollY + ", oldScrollX=" + this.oldScrollX + ", oldScrollY=" + this.oldScrollY + '}';
    }
}
