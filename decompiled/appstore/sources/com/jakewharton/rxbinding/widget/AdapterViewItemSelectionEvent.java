package com.jakewharton.rxbinding.widget;

import android.view.View;
import android.widget.AdapterView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class AdapterViewItemSelectionEvent extends AdapterViewSelectionEvent {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final long f10390id;
    private final int position;
    private final View selectedView;

    private AdapterViewItemSelectionEvent(@NonNull AdapterView<?> r10, @NonNull View r11, int r12, long r13) {
        super(r10);
        this.selectedView = r11;
        this.position = r12;
        this.f10390id = r13;
    }

    @NonNull
    @CheckResult
    public static AdapterViewSelectionEvent create(@NonNull AdapterView<?> r10, @NonNull View r11, int r12, long r13) {
        return new AdapterViewItemSelectionEvent(r10, r11, r12, r13);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof AdapterViewItemSelectionEvent) == true) goto L8;
        return false;
    L8:
        AdapterViewItemSelectionEvent r11 = (AdapterViewItemSelectionEvent) r10;
        if (r11.view() != view()) goto L18;
        if (r11.selectedView != this.selectedView) goto L18;
        if (r11.position != this.position) goto L18;
        if (r11.f10390id != this.f10390id) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        int r10 = (((((629 + view().hashCode()) * 37) + this.selectedView.hashCode()) * 37) + this.position) * 37;
        long r11 = this.f10390id;
        return r10 + ((int) (r11 ^ (r11 >>> 32)));
    }

    public long id() {
        return this.f10390id;
    }

    public int position() {
        return this.position;
    }

    @NonNull
    public View selectedView() {
        return this.selectedView;
    }

    public String toString() {
        return "AdapterViewItemSelectionEvent{view=" + view() + ", selectedView=" + this.selectedView + ", position=" + this.position + ", id=" + this.f10390id + '}';
    }
}
