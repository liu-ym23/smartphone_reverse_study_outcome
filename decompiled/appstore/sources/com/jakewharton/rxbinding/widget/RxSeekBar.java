package com.jakewharton.rxbinding.widget;

import android.widget.SeekBar;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding.internal.Preconditions;
import rx.Observable;

/* JADX INFO: loaded from: classes3.dex */
public final class RxSeekBar {
    private RxSeekBar() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Observable changeEvents(@NonNull SeekBar r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return Observable.b(new SeekBarChangeEventOnSubscribe(r10));
    }

    @NonNull
    @CheckResult
    public static Observable changes(@NonNull SeekBar r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return Observable.b(new SeekBarChangeOnSubscribe(r10, null));
    }

    @NonNull
    @CheckResult
    public static Observable systemChanges(@NonNull SeekBar r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return Observable.b(new SeekBarChangeOnSubscribe(r10, Boolean.FALSE));
    }

    @NonNull
    @CheckResult
    public static Observable userChanges(@NonNull SeekBar r10) {
        Preconditions.checkNotNull(r10, "view == null");
        return Observable.b(new SeekBarChangeOnSubscribe(r10, Boolean.TRUE));
    }
}
