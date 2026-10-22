package com.bumptech.glide.util;

import android.text.TextUtils;
import java.util.Collection;

/* JADX INFO: loaded from: classes39.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static String checkNotEmpty(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException("Must not be null or empty");
    }

    public static <T> T checkNotNull(T r100) {
        return (T) checkNotNull(r100, "Argument must not be null");
    }

    public static <T extends Collection<Y>, Y> T checkNotEmpty(T r100) {
        if (r100.isEmpty() == true) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException("Must not be empty.");
    }

    public static void checkArgument(boolean r100, String r101) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(r101);
    }

    public static <T> T checkNotNull(T r100, String r101) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw new NullPointerException(r101);
    }
}
