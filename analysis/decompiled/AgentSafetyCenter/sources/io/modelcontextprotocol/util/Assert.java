package io.modelcontextprotocol.util;

import g5.f;
import java.util.Collection;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class Assert {
    public static boolean hasText(@Nullable String str) {
        return (str == null || str.isBlank()) ? false : true;
    }

    public static void isTrue(boolean z10, String str) {
        if (z10) {
            return;
        }
        f.s(str);
    }

    public static void notEmpty(@Nullable Collection<?> collection, String str) {
        if (collection == null || collection.isEmpty()) {
            f.s(str);
        }
    }

    public static void notNull(@Nullable Object obj, String str) {
        if (obj != null) {
            return;
        }
        f.s(str);
    }

    public static void hasText(@Nullable String str, String str2) {
        if (hasText(str)) {
            return;
        }
        f.s(str2);
    }
}
