package com.bytedance.location.protobuf;

/* JADX INFO: loaded from: classes3.dex */
final class Android {
    private static boolean ASSUME_ANDROID;
    private static final boolean IS_ROBOLECTRIC = false;
    private static final Class<?> MEMORY_CLASS = null;

    private Android() {
    }

    static {
        MEMORY_CLASS = getClassForName("libcore.io.Memory");
        if (ASSUME_ANDROID == false) goto L5;
    L7:
        boolean r0 = false;
    L8:
        IS_ROBOLECTRIC = r0;
        return;
    L5:
        if (getClassForName("org.robolectric.Robolectric") == null) goto L7;
        r0 = true;
        goto L8
    }

    static boolean isOnAndroidDevice() {
        if (ASSUME_ANDROID == false) goto L5;
    L10:
        return true;
    L5:
        if (MEMORY_CLASS != null) goto L7;
    L9:
        return false;
    L7:
        if (IS_ROBOLECTRIC == true) goto L9;
        goto L9
    }

    static Class<?> getMemoryClass() {
        return MEMORY_CLASS;
    }

    private static <T> Class<T> getClassForName(String r2) {
        return (Class<T>) Class.forName(r2);
    L5:
        return null;
    }
}
