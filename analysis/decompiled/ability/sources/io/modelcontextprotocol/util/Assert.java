package io.modelcontextprotocol.util;

import java.util.Collection;
import reactor.util.annotation.Nullable;

/* loaded from: classes3.dex */
public final class Assert {
    public static void hasText(@Nullable String str, String str2) {
        if (!hasText(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void isTrue(boolean z10, String str) {
        if (!z10) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void notEmpty(@Nullable Collection<?> collection, String str) {
        if (collection == null || collection.isEmpty()) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void notNull(@Nullable Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static boolean hasText(@Nullable String str) {
        return (str == null || str.isBlank()) ? false : true;
    }
}
