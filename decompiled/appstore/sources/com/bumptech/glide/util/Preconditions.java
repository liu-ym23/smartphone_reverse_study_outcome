package com.bumptech.glide.util;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean r10, @NonNull String r11) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(r11);
    }

    @NonNull
    public static String checkNotEmpty(@Nullable String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L6;
        return r10;
    L6:
        throw new IllegalArgumentException("Must not be null or empty");
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T r10) {
        return (T) checkNotNull(r10, "Argument must not be null");
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T r10, @NonNull String r11) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new NullPointerException(r11);
    }

    @NonNull
    public static <T extends Collection<Y>, Y> T checkNotEmpty(@NonNull T r10) {
        if (r10.isEmpty() == true) goto L6;
        return r10;
    L6:
        throw new IllegalArgumentException("Must not be empty.");
    }
}
