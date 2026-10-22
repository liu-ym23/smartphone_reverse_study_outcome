package com.jakewharton.rxbinding.widget;

import android.widget.SeekBar;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class SeekBarProgressChangeEvent extends SeekBarChangeEvent {
    private final boolean fromUser;
    private final int progress;

    private SeekBarProgressChangeEvent(@NonNull SeekBar r10, int r11, boolean r12) {
        super(r10);
        this.progress = r11;
        this.fromUser = r12;
    }

    @NonNull
    @CheckResult
    public static SeekBarProgressChangeEvent create(@NonNull SeekBar r10, int r11, boolean r12) {
        return new SeekBarProgressChangeEvent(r10, r11, r12);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof SeekBarProgressChangeEvent) == true) goto L8;
        return false;
    L8:
        SeekBarProgressChangeEvent r11 = (SeekBarProgressChangeEvent) r10;
        if (r11.view() != view()) goto L16;
        if (r11.progress != this.progress) goto L16;
        if (r11.fromUser != this.fromUser) goto L16;
        return true;
    L16:
        return false;
    }

    public boolean fromUser() {
        return this.fromUser;
    }

    public int hashCode() {
        return ((((629 + view().hashCode()) * 37) + this.progress) * 37) + (this.fromUser ? 1 : 0);
    }

    public int progress() {
        return this.progress;
    }

    public String toString() {
        return "SeekBarProgressChangeEvent{view=" + view() + ", progress=" + this.progress + ", fromUser=" + this.fromUser + '}';
    }
}
