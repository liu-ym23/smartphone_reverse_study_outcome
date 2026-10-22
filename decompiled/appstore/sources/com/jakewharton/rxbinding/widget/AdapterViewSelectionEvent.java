package com.jakewharton.rxbinding.widget;

import android.widget.AdapterView;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding.view.ViewEvent;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AdapterViewSelectionEvent extends ViewEvent<AdapterView<?>> {
    public AdapterViewSelectionEvent(@NonNull AdapterView<?> r10) {
        super(r10);
    }
}
