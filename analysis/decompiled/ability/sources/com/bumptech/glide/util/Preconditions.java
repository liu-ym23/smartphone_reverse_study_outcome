package com.bumptech.glide.util;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;

/* loaded from: classes2.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean z10) {
        checkArgument(z10, "");
    }

    @NonNull
    public static String checkNotEmpty(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must not be null or empty");
        }
        return str;
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T t9) {
        return (T) checkNotNull(t9, "Argument must not be null");
    }

    public static void checkArgument(boolean z10, @NonNull String str) {
        if (!z10) {
            throw new IllegalArgumentException(str);
        }
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T t9, @NonNull String str) {
        if (t9 != null) {
            return t9;
        }
        throw new NullPointerException(str);
    }

    @NonNull
    public static <T extends Collection<Y>, Y> T checkNotEmpty(@NonNull T t9) {
        if (t9.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        return t9;
    }
}
