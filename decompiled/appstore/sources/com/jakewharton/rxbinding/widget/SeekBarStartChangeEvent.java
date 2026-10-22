package com.jakewharton.rxbinding.widget;

import android.widget.SeekBar;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class SeekBarStartChangeEvent extends SeekBarChangeEvent {
    private SeekBarStartChangeEvent(@NonNull SeekBar r10) {
        super(r10);
    }

    @NonNull
    @CheckResult
    public static SeekBarStartChangeEvent create(@NonNull SeekBar r10) {
        return new SeekBarStartChangeEvent(r10);
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof SeekBarStartChangeEvent) == true) goto L5;
    L7:
        return false;
    L5:
        if (((SeekBarStartChangeEvent) r10).view() != view()) goto L7;
        return true;
    }

    public int hashCode() {
        return view().hashCode();
    }

    public String toString() {
        return "SeekBarStartChangeEvent{view=" + view() + '}';
    }
}
