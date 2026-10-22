package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public interface Key {
    public static final Charset CHARSET = null;
    public static final String STRING_CHARSET_NAME = "UTF-8";

    static {
        CHARSET = Charset.forName("UTF-8");
    }

    boolean equals(Object r10);

    int hashCode();

    void updateDiskCacheKey(@NonNull MessageDigest r10);
}
