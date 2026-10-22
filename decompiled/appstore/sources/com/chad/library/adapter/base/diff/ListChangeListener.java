package com.chad.library.adapter.base.diff;

import androidx.annotation.NonNull;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface ListChangeListener<T> {
    void onCurrentListChanged(@NonNull List<T> r10, @NonNull List<T> r11);
}
