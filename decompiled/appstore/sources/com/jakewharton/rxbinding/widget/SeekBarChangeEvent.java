package com.jakewharton.rxbinding.widget;

import android.widget.SeekBar;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding.view.ViewEvent;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SeekBarChangeEvent extends ViewEvent<SeekBar> {
    public SeekBarChangeEvent(@NonNull SeekBar r10) {
        super(r10);
    }
}
