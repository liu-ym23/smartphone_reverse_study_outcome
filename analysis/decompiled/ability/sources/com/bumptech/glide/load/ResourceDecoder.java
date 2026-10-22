package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;

/* loaded from: classes2.dex */
public interface ResourceDecoder<T, Z> {
    @Nullable
    Resource<Z> decode(@NonNull T t9, int i, int i6, @NonNull Options options) throws IOException;

    boolean handles(@NonNull T t9, @NonNull Options options) throws IOException;
}
