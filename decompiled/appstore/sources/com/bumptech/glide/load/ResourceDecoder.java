package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface ResourceDecoder<T, Z> {
    @Nullable
    Resource<Z> decode(@NonNull T r10, int r11, int r12, @NonNull Options r13) throws IOException;

    boolean handles(@NonNull T r10, @NonNull Options r11) throws IOException;
}
