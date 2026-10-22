package com.jakewharton.rxbinding.widget;

import android.widget.AbsListView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding.view.ViewEvent;

/* JADX INFO: loaded from: classes3.dex */
public final class AbsListViewScrollEvent extends ViewEvent<AbsListView> {
    private final int firstVisibleItem;
    private final int scrollState;
    private final int totalItemCount;
    private final int visibleItemCount;

    private AbsListViewScrollEvent(@NonNull AbsListView r10, int r11, int r12, int r13, int r14) {
        super(r10);
        this.scrollState = r11;
        this.firstVisibleItem = r12;
        this.visibleItemCount = r13;
        this.totalItemCount = r14;
    }

    @NonNull
    @CheckResult
    public static AbsListViewScrollEvent create(AbsListView r10, int r11, int r12, int r13, int r14) {
        return new AbsListViewScrollEvent(r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L8;
    L24:
        return false;
    L8:
        if (AbsListViewScrollEvent.class != r10.getClass()) goto L24;
        AbsListViewScrollEvent r11 = (AbsListViewScrollEvent) r10;
        if (this.scrollState == r11.scrollState) goto L14;
        return false;
    L14:
        if (this.firstVisibleItem == r11.firstVisibleItem) goto L17;
        return false;
    L17:
        if (this.visibleItemCount == r11.visibleItemCount) goto L20;
        return false;
    L20:
        if (this.totalItemCount != r11.totalItemCount) goto L23;
        return true;
    L23:
        return false;
    }

    public int firstVisibleItem() {
        return this.firstVisibleItem;
    }

    public int hashCode() {
        return (((((this.scrollState * 31) + this.firstVisibleItem) * 31) + this.visibleItemCount) * 31) + this.totalItemCount;
    }

    public int scrollState() {
        return this.scrollState;
    }

    public String toString() {
        return "AbsListViewScrollEvent{scrollState=" + this.scrollState + ", firstVisibleItem=" + this.firstVisibleItem + ", visibleItemCount=" + this.visibleItemCount + ", totalItemCount=" + this.totalItemCount + '}';
    }

    public int totalItemCount() {
        return this.totalItemCount;
    }

    public int visibleItemCount() {
        return this.visibleItemCount;
    }
}
