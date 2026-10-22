package com.android.server.inputmethod;

/* JADX INFO: loaded from: classes2.dex */
final class InputMethodSettingsRepository {
    private static final Object sMutationLock = null;
    private static volatile ImmutableSparseArray<InputMethodSettings> sPerUserMap;

    static {
        sMutationLock = new Object();
        sPerUserMap = ImmutableSparseArray.empty();
    }

    private InputMethodSettingsRepository() {
    }

    static InputMethodSettings get(int userId) {
        InputMethodSettings obj = sPerUserMap.get(userId);
        if (obj == null) goto L6;
        return obj;
    L6:
        return InputMethodSettings.createEmptyMap(userId);
    }

    static void put(int userId, InputMethodSettings obj) {
        Object r0 = sMutationLock;
        monitor-enter(r0);
        sPerUserMap = sPerUserMap.cloneWithPutOrSelf(userId, obj);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    static void remove(int userId) {
        Object r0 = sMutationLock;
        monitor-enter(r0);
        sPerUserMap = sPerUserMap.cloneWithRemoveOrSelf(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
