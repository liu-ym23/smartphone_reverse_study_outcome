package com.bumptech.glide.load;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes39.dex */
public interface Key {
    public static final Charset CHARSET = null;
    public static final String STRING_CHARSET_NAME = "UTF-8";

    boolean equals(Object r100);

    int hashCode();

    void updateDiskCacheKey(MessageDigest r100);

    static {
        CHARSET = Charset.forName("UTF-8");
    }
}
