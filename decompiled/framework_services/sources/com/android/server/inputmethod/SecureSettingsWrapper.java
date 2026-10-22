package com.android.server.inputmethod;

import android.content.ContentResolver;
import android.provider.Settings;
import android.util.ArrayMap;
import android.util.ArraySet;
import com.android.server.LocalServices;
import com.android.server.pm.UserManagerInternal;

/* JADX INFO: loaded from: classes2.dex */
final class SecureSettingsWrapper {
    private static final ArraySet<String> CLONE_TO_MANAGED_PROFILE = null;
    private static final ReaderWriter NOOP = null;
    private static volatile ContentResolver sContentResolver;
    private static final Object sMutationLock = null;
    private static volatile boolean sTestMode;
    private static volatile ImmutableSparseArray<ReaderWriter> sUserMap;

    private static class FakeReaderWriterImpl implements ReaderWriter {
        private final ArrayMap<String, String> mNonPersistentKeyValues;

        /* synthetic */ FakeReaderWriterImpl(SecureSettingsWrapperIA r1) {
            this();
        }

        private FakeReaderWriterImpl() {
            this.mNonPersistentKeyValues = new ArrayMap();
        }

        @Override // com.android.server.inputmethod.SecureSettingsWrapper.ReaderWriter
        public void putString(String key, String value) {
            ArrayMap<String, String> r0 = this.mNonPersistentKeyValues;
            monitor-enter(r0);
            this.mNonPersistentKeyValues.put(key, value);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.inputmethod.SecureSettingsWrapper.ReaderWriter
        public String getString(String key, String defaultValue) {
            ArrayMap<String, String> r0 = this.mNonPersistentKeyValues;
            monitor-enter(r0);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (this.mNonPersistentKeyValues.containsKey(key) == false) goto L14;
            String result = this.mNonPersistentKeyValues.get(key);     // Catch: Throwable -> L12
            if (result == null) goto L9;
            String r2 = result;
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r2;
        L9:
            r2 = defaultValue;
            goto L10
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return defaultValue;
        }

        @Override // com.android.server.inputmethod.SecureSettingsWrapper.ReaderWriter
        public void putInt(String key, int value) {
            ArrayMap<String, String> r0 = this.mNonPersistentKeyValues;
            monitor-enter(r0);
            this.mNonPersistentKeyValues.put(key, String.valueOf(value));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.inputmethod.SecureSettingsWrapper.ReaderWriter
        public int getInt(String key, int defaultValue) {
            ArrayMap<String, String> r0 = this.mNonPersistentKeyValues;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mNonPersistentKeyValues.containsKey(key) == false) goto L14;
            String result = this.mNonPersistentKeyValues.get(key);     // Catch: Throwable -> L9
            if (result == null) goto L11;
            int r2 = Integer.parseInt(result);     // Catch: Throwable -> L9
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r2;
        L11:
            r2 = defaultValue;
            goto L12
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return defaultValue;
        }
    }

    private static final class LockedUserImpl extends UnlockedUserImpl {
        private final ArrayMap<String, String> mNonPersistentKeyValues;

        LockedUserImpl(int userId, ContentResolver contentResolver) {
            super(userId, contentResolver);
            this.mNonPersistentKeyValues = new ArrayMap();
        }

        @Override // com.android.server.inputmethod.SecureSettingsWrapper.UnlockedUserImpl, com.android.server.inputmethod.SecureSettingsWrapper.ReaderWriter
        public void putString(String key, String value) {
            ArrayMap<String, String> r0 = this.mNonPersistentKeyValues;
            monitor-enter(r0);
            this.mNonPersistentKeyValues.put(key, value);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.inputmethod.SecureSettingsWrapper.UnlockedUserImpl, com.android.server.inputmethod.SecureSettingsWrapper.ReaderWriter
        public String getString(String key, String defaultValue) {
            ArrayMap<String, String> r0 = this.mNonPersistentKeyValues;
            monitor-enter(r0);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (this.mNonPersistentKeyValues.containsKey(key) == false) goto L14;
            String result = this.mNonPersistentKeyValues.get(key);     // Catch: Throwable -> L12
            if (result == null) goto L9;
            String r2 = result;
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r2;
        L9:
            r2 = defaultValue;
            goto L10
        L14:
            String r1 = super.getString(key, defaultValue);     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r1;
        }

        @Override // com.android.server.inputmethod.SecureSettingsWrapper.UnlockedUserImpl, com.android.server.inputmethod.SecureSettingsWrapper.ReaderWriter
        public void putInt(String key, int value) {
            ArrayMap<String, String> r0 = this.mNonPersistentKeyValues;
            monitor-enter(r0);
            this.mNonPersistentKeyValues.put(key, String.valueOf(value));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.inputmethod.SecureSettingsWrapper.UnlockedUserImpl, com.android.server.inputmethod.SecureSettingsWrapper.ReaderWriter
        public int getInt(String key, int defaultValue) {
            ArrayMap<String, String> r0 = this.mNonPersistentKeyValues;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mNonPersistentKeyValues.containsKey(key) == false) goto L14;
            String result = this.mNonPersistentKeyValues.get(key);     // Catch: Throwable -> L9
            if (result == null) goto L11;
            int r2 = Integer.parseInt(result);     // Catch: Throwable -> L9
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r2;
        L11:
            r2 = defaultValue;
            goto L12
        L14:
            int r1 = super.getInt(key, defaultValue);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r1;
        }
    }

    private interface ReaderWriter {
        int getInt(String r1, int r2);

        String getString(String r1, String r2);

        void putInt(String r1, int r2);

        void putString(String r1, String r2);
    }

    private static class UnlockedUserImpl implements ReaderWriter {
        private final ContentResolver mContentResolver;
        private final int mUserId;

        UnlockedUserImpl(int userId, ContentResolver contentResolver) {
            this.mUserId = userId;
            this.mContentResolver = contentResolver;
        }

        @Override // com.android.server.inputmethod.SecureSettingsWrapper.ReaderWriter
        public void putString(String key, String value) {
            int userId = SecureSettingsWrapper.m4788$$Nest$smgetUserIdForClonedSettings(key, this.mUserId);
            Settings.Secure.putStringForUser(this.mContentResolver, key, value, userId);
        }

        @Override // com.android.server.inputmethod.SecureSettingsWrapper.ReaderWriter
        public String getString(String key, String defaultValue) {
            String result = Settings.Secure.getStringForUser(this.mContentResolver, key, this.mUserId);
            if (result == null) goto L6;
            return result;
        L6:
            return defaultValue;
        }

        @Override // com.android.server.inputmethod.SecureSettingsWrapper.ReaderWriter
        public void putInt(String key, int value) {
            int userId = SecureSettingsWrapper.m4788$$Nest$smgetUserIdForClonedSettings(key, this.mUserId);
            Settings.Secure.putIntForUser(this.mContentResolver, key, value, userId);
        }

        @Override // com.android.server.inputmethod.SecureSettingsWrapper.ReaderWriter
        public int getInt(String key, int defaultValue) {
            return Settings.Secure.getIntForUser(this.mContentResolver, key, defaultValue, this.mUserId);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$smgetUserIdForClonedSettings, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4788$$Nest$smgetUserIdForClonedSettings(String r0, int r1) {
        return getUserIdForClonedSettings(r0, r1);
    }

    static {
        sMutationLock = new Object();
        sUserMap = ImmutableSparseArray.empty();
        sContentResolver = null;
        sTestMode = false;
        CLONE_TO_MANAGED_PROFILE = new ArraySet();
        Settings.Secure.getCloneToManagedProfileSettings(CLONE_TO_MANAGED_PROFILE);
        NOOP = new AnonymousClass1();
    }

    static void startTestMode() {
        sTestMode = true;
    }

    static void endTestMode() {
        Object r0 = sMutationLock;
        monitor-enter(r0);
        sUserMap = ImmutableSparseArray.empty();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        sTestMode = false;
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private SecureSettingsWrapper() {
    }

    private static int getUserIdForClonedSettings(String key, int userId) {
        if (CLONE_TO_MANAGED_PROFILE.contains(key) == false) goto L6;
        return ((UserManagerInternal) LocalServices.getService(UserManagerInternal.class)).getProfileParentId(userId);
    L6:
        return userId;
    }

    private static ReaderWriter createImpl(UserManagerInternal userManagerInternal, int userId) {
        if (sTestMode == false) goto L7;
        return new FakeReaderWriterImpl(null);
    L7:
        if (userManagerInternal.isUserUnlockingOrUnlocked(userId) == false) goto L10;
        return new UnlockedUserImpl(userId, sContentResolver);
    L10:
        return new LockedUserImpl(userId, sContentResolver);
    }

    private static ReaderWriter putOrGet(int userId, ReaderWriter readerWriter) {
        boolean isUnlockedUserImpl = readerWriter instanceof UnlockedUserImpl;
        Object r1 = sMutationLock;
        monitor-enter(r1);
        ReaderWriter current = sUserMap.get(userId);     // Catch: Throwable -> L9
        if (current != null) goto L12;
        sUserMap = sUserMap.cloneWithPutOrSelf(userId, readerWriter);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return readerWriter;
    L12:
        if ((current instanceof LockedUserImpl) == false) goto L17;
        if (isUnlockedUserImpl == false) goto L17;
        sUserMap = sUserMap.cloneWithPutOrSelf(userId, readerWriter);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return readerWriter;
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L9
        return current;
    L9:
        th = move-exception;
        throw th;
    }

    private static ReaderWriter get(int userId) {
        ReaderWriter readerWriter = sUserMap.get(userId);
        if (readerWriter == null) goto L6;
        return readerWriter;
    L6:
        if (sTestMode == true) goto L8;
        UserManagerInternal userManagerInternal = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        if (userManagerInternal.exists(userId) == true) goto L14;
        return NOOP;
    L14:
        return putOrGet(userId, createImpl(userManagerInternal, userId));
    L8:
        return putOrGet(userId, new FakeReaderWriterImpl(null));
    }

    static void setContentResolver(ContentResolver contentResolver) {
        sContentResolver = contentResolver;
    }

    static void onUserStarting(int userId) {
        if (sTestMode == false) goto L6;
        putOrGet(userId, new FakeReaderWriterImpl(null));
        return;
    L6:
        putOrGet(userId, createImpl((UserManagerInternal) LocalServices.getService(UserManagerInternal.class), userId));
    }

    static void onUserUnlocking(int userId) {
        if (sTestMode == false) goto L6;
        putOrGet(userId, new FakeReaderWriterImpl(null));
        return;
    L6:
        ReaderWriter readerWriter = new UnlockedUserImpl(userId, sContentResolver);
        putOrGet(userId, readerWriter);
    }

    static void onUserStopped(int userId) {
        LockedUserImpl lockedUserImpl = new LockedUserImpl(userId, sContentResolver);
        Object r1 = sMutationLock;
        monitor-enter(r1);
        ReaderWriter current = sUserMap.get(userId);     // Catch: Throwable -> L12
        if (current == null) goto L14;
        if ((current instanceof LockedUserImpl) == true) goto L14;
        sUserMap = sUserMap.cloneWithPutOrSelf(userId, lockedUserImpl);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    static void onUserRemoved(int userId) {
        Object r0 = sMutationLock;
        monitor-enter(r0);
        sUserMap = sUserMap.cloneWithRemoveOrSelf(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    static void putString(String key, String value, int userId) {
        get(userId).putString(key, value);
    }

    static String getString(String key, String defaultValue, int userId) {
        return get(userId).getString(key, defaultValue);
    }

    static void putInt(String key, int value, int userId) {
        get(userId).putInt(key, value);
    }

    static int getInt(String key, int defaultValue, int userId) {
        return get(userId).getInt(key, defaultValue);
    }

    static void putBoolean(String r1, boolean r2, int r3) {
        get(r3).putInt(r1, r2 ? 1 : 0);
    }

    static boolean getBoolean(String r2, boolean r3, int r4) {
        if (get(r4).getInt(r2, r3 ? 1 : 0) == 1) goto L7;
        return false;
    L7:
        return true;
    }
}
