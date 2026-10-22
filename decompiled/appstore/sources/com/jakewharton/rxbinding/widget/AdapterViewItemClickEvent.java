package com.jakewharton.rxbinding.widget;

import android.view.View;
import android.widget.AdapterView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding.view.ViewEvent;

/* JADX INFO: loaded from: classes3.dex */
public final class AdapterViewItemClickEvent extends ViewEvent<AdapterView<?>> {
    private final View clickedView;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final long f10388id;
    private final int position;

    private AdapterViewItemClickEvent(@NonNull AdapterView<?> r10, @NonNull View r11, int r12, long r13) {
        super(r10);
        this.clickedView = r11;
        this.position = r12;
        this.f10388id = r13;
    }

    @NonNull
    @CheckResult
    public static AdapterViewItemClickEvent create(@NonNull AdapterView<?> r10, @NonNull View r11, int r12, long r13) {
        return new AdapterViewItemClickEvent(r10, r11, r12, r13);
    }

    @NonNull
    public View clickedView() {
        return this.clickedView;
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof AdapterViewItemClickEvent) == true) goto L8;
        return false;
    L8:
        AdapterViewItemClickEvent r11 = (AdapterViewItemClickEvent) r10;
        if (r11.view() != view()) goto L18;
        if (r11.clickedView != this.clickedView) goto L18;
        if (r11.position != this.position) goto L18;
        if (r11.f10388id != this.f10388id) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        int r10 = (((((629 + view().hashCode()) * 37) + this.clickedView.hashCode()) * 37) + this.position) * 37;
        long r11 = this.f10388id;
        return r10 + ((int) (r11 ^ (r11 >>> 32)));
    }

    public long id() {
        return this.f10388id;
    }

    public int position() {
        return this.position;
    }

    public String toString() {
        return "AdapterViewItemClickEvent{view=" + view() + ", clickedView=" + this.clickedView + ", position=" + this.position + ", id=" + this.f10388id + '}';
    }
}
