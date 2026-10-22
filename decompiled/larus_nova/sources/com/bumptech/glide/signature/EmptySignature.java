package com.bumptech.glide.signature;

import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes39.dex */
public final class EmptySignature implements Key {
    private static final EmptySignature EMPTY_KEY = null;

    public String toString() {
        return "EmptySignature";
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
    }

    static {
        EMPTY_KEY = new EmptySignature();
    }

    private EmptySignature() {
    }

    public static EmptySignature obtain() {
        return EMPTY_KEY;
    }
}
