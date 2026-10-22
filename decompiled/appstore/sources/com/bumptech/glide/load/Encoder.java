package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public interface Encoder<T> {
    boolean encode(@NonNull T r10, @NonNull File r11, @NonNull Options r12);
}
