package com.android.server.locksettings.recoverablekeystore.storage;

import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import com.android.security.SecureBox;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class RemoteLockscreenValidationSessionStorage {
    private static final long SESSION_TIMEOUT_MILLIS = 600000;
    private static final String TAG = "RemoteLockscreenValidation";
    final SparseArray<LockscreenVerificationSession> mSessionsByUserId;

    private class LockscreenValidationCleanupTask implements Runnable {
        final /* synthetic */ RemoteLockscreenValidationSessionStorage this$0;

        /* synthetic */ LockscreenValidationCleanupTask(RemoteLockscreenValidationSessionStorage r1, RemoteLockscreenValidationSessionStorageIA r2) {
            this(r1);
        }

        private LockscreenValidationCleanupTask(RemoteLockscreenValidationSessionStorage r1) {
            this.this$0 = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            SparseArray<LockscreenVerificationSession> r0 = this.this$0.mSessionsByUserId;     // Catch: Exception -> L21
            monitor-enter(r0);     // Catch: Exception -> L21
            ArrayList<Integer> keysToRemove = new ArrayList();     // Catch: Throwable -> L10
            int i = 0;
        L6:
            if (i >= this.this$0.mSessionsByUserId.size()) goto L13;
            long now = SystemClock.elapsedRealtime();     // Catch: Throwable -> L10
            long startTime = LockscreenVerificationSession.m5493$$Nest$mgetElapsedStartTimeMillis(this.this$0.mSessionsByUserId.valueAt(i));     // Catch: Throwable -> L10
            if ((now - startTime) <= 600000) goto L12;
            int userId = this.this$0.mSessionsByUserId.keyAt(i);     // Catch: Throwable -> L10
            keysToRemove.add(Integer.valueOf(userId));     // Catch: Throwable -> L10
        L12:
            i = i + 1;     // Catch: Throwable -> L10
            goto L6
        L13:
            Iterator<Integer> r2 = keysToRemove.iterator();     // Catch: Throwable -> L10
        L15:
            if (r2.hasNext() == false) goto L17;
            Integer userId2 = r2.next();     // Catch: Throwable -> L10
            this.this$0.mSessionsByUserId.delete(userId2.intValue());     // Catch: Throwable -> L10
            goto L15
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L10
        L32:
            return;
        L10:
            th = move-exception;
            throw th;     // Catch: Exception -> L21
        L21:
            e = move-exception;
            Log.e(RemoteLockscreenValidationSessionStorage.TAG, "Unexpected exception thrown during LockscreenValidationCleanupTask", e);
        }
    }

    public class LockscreenVerificationSession {
        private final long mElapsedStartTime;
        private final KeyPair mKeyPair;

        /* JADX INFO: renamed from: -$$Nest$mgetElapsedStartTimeMillis, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m5493$$Nest$mgetElapsedStartTimeMillis(LockscreenVerificationSession r2) {
            return r2.getElapsedStartTimeMillis();
        }

        LockscreenVerificationSession(RemoteLockscreenValidationSessionStorage this$0, KeyPair keyPair, long elapsedStartTime) {
            this.mKeyPair = keyPair;
            this.mElapsedStartTime = elapsedStartTime;
        }

        public KeyPair getKeyPair() {
            return this.mKeyPair;
        }

        private long getElapsedStartTimeMillis() {
            return this.mElapsedStartTime;
        }
    }

    public RemoteLockscreenValidationSessionStorage() {
        this.mSessionsByUserId = new SparseArray(0);
    }

    public LockscreenVerificationSession get(int userId) {
        SparseArray<LockscreenVerificationSession> r0 = this.mSessionsByUserId;
        monitor-enter(r0);
        LockscreenVerificationSession r1 = this.mSessionsByUserId.get(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public LockscreenVerificationSession startSession(int userId) {
        SparseArray<LockscreenVerificationSession> r0 = this.mSessionsByUserId;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mSessionsByUserId.get(userId) == null) goto L20;
        this.mSessionsByUserId.delete(userId);     // Catch: Throwable -> L8
    L20:
        KeyPair newKeyPair = SecureBox.genKeyPair();     // Catch: Throwable -> L8 NoSuchAlgorithmException -> L14
        LockscreenVerificationSession newSession = new LockscreenVerificationSession(this, newKeyPair, SystemClock.elapsedRealtime());     // Catch: Throwable -> L8
        this.mSessionsByUserId.put(userId, newSession);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return newSession;
    L14:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L8
    }

    public void finishSession(int userId) {
        SparseArray<LockscreenVerificationSession> r0 = this.mSessionsByUserId;
        monitor-enter(r0);
        this.mSessionsByUserId.delete(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public Runnable getLockscreenValidationCleanupTask() {
        return new LockscreenValidationCleanupTask(this, null);
    }
}
