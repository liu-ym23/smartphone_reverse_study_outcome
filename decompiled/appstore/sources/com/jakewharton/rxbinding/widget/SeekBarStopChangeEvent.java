package com.jakewharton.rxbinding.widget;

import android.widget.SeekBar;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class SeekBarStopChangeEvent extends SeekBarChangeEvent {
    private SeekBarStopChangeEvent(@NonNull SeekBar r10) {
        super(r10);
    }

    @NonNull
    @CheckResult
    public static SeekBarStopChangeEvent create(@NonNull SeekBar r10) {
        return new SeekBarStopChangeEvent(r10);
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof SeekBarStopChangeEvent) == true) goto L5;
    L7:
        return false;
    L5:
        if (((SeekBarStopChangeEvent) r10).view() != view()) goto L7;
        return true;
    }

    public int hashCode() {
        return view().hashCode();
    }

    public String toString() {
        return "SeekBarStopChangeEvent{view=" + view() + '}';
    }
}
