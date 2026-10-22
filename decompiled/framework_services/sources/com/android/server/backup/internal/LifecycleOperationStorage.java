package com.android.server.backup.internal;

import android.util.Slog;
import android.util.SparseArray;
import com.android.server.backup.BackupRestoreTask;
import com.android.server.backup.OperationStorage;
import com.google.android.collect.Sets;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* JADX INFO: loaded from: classes.dex */
public class LifecycleOperationStorage implements OperationStorage {
    private static final String TAG = "LifecycleOperationStorage";
    private final Map<String, Set<Integer>> mOpTokensByPackage;
    private final SparseArray<Operation> mOperations;
    private final Object mOperationsLock;
    private final int mUserId;

    public LifecycleOperationStorage(int userId) {
        this.mOperationsLock = new Object();
        this.mOperations = new SparseArray();
        this.mOpTokensByPackage = new HashMap();
        this.mUserId = userId;
    }

    @Override // com.android.server.backup.OperationStorage
    public void registerOperation(int token, int initialState, BackupRestoreTask task, int type) {
        registerOperationForPackages(token, initialState, Sets.newHashSet(), task, type);
    }

    @Override // com.android.server.backup.OperationStorage
    public void registerOperationForPackages(int token, int initialState, Set<String> packageNames, BackupRestoreTask task, int type) {
        Object r0 = this.mOperationsLock;
        monitor-enter(r0);
        this.mOperations.put(token, new Operation(initialState, task, type));     // Catch: Throwable -> L10
        Iterator<String> r1 = packageNames.iterator();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L13;
        String packageName = r1.next();     // Catch: Throwable -> L10
        Set<Integer> tokens = this.mOpTokensByPackage.get(packageName);     // Catch: Throwable -> L10
        if (tokens != null) goto L12;
        tokens = new HashSet();     // Catch: Throwable -> L10
    L12:
        tokens.add(Integer.valueOf(token));     // Catch: Throwable -> L10
        this.mOpTokensByPackage.put(packageName, tokens);     // Catch: Throwable -> L10
        goto L6
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.backup.OperationStorage
    public void removeOperation(int token) {
        Object r0 = this.mOperationsLock;
        monitor-enter(r0);
        this.mOperations.remove(token);     // Catch: Throwable -> L11
        Set<String> packagesWithTokens = this.mOpTokensByPackage.keySet();     // Catch: Throwable -> L11
        Iterator<String> r2 = packagesWithTokens.iterator();     // Catch: Throwable -> L11
    L6:
        if (r2.hasNext() == false) goto L13;
        String packageName = r2.next();     // Catch: Throwable -> L11
        Set<Integer> tokens = this.mOpTokensByPackage.get(packageName);     // Catch: Throwable -> L11
        if (tokens == null) goto L6;
        tokens.remove(Integer.valueOf(token));     // Catch: Throwable -> L11
        this.mOpTokensByPackage.put(packageName, tokens);     // Catch: Throwable -> L11
        goto L6
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.backup.OperationStorage
    public int numOperations() {
        Object r0 = this.mOperationsLock;
        monitor-enter(r0);
        int r1 = this.mOperations.size();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.backup.OperationStorage
    public boolean isBackupOperationInProgress() {
        Object r0 = this.mOperationsLock;
        monitor-enter(r0);
        int i = 0;
    L23:
    L14:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mOperations.size()) goto L18;
        Operation op = this.mOperations.valueAt(i);     // Catch: Throwable -> L14
        if (op.type != 2) goto L16;
        if (op.state != 0) goto L16;
        monitor-exit(r0);     // Catch: Throwable -> L14
        return true;
    L16:
        i = i + 1;     // Catch: Throwable -> L14
        goto L23
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return false;
    }

    @Override // com.android.server.backup.OperationStorage
    public Set<Integer> operationTokensForPackage(String packageName) {
        Object r0 = this.mOperationsLock;
        monitor-enter(r0);
        Collection<? extends Integer> tokens = (Set) this.mOpTokensByPackage.get(packageName);     // Catch: Throwable -> L7
        Set<Integer> result = Sets.newHashSet();     // Catch: Throwable -> L7
        if (tokens == null) goto L9;
        result.addAll(tokens);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return result;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.backup.OperationStorage
    public Set<Integer> operationTokensForOpType(int type) {
        Set<Integer> tokens = Sets.newHashSet();
        Object r1 = this.mOperationsLock;
        monitor-enter(r1);
        int i = 0;
    L18:
    L10:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mOperations.size()) goto L14;
        Operation op = this.mOperations.valueAt(i);     // Catch: Throwable -> L10
        int token = this.mOperations.keyAt(i);     // Catch: Throwable -> L10
        if (op.type != type) goto L12;
        tokens.add(Integer.valueOf(token));     // Catch: Throwable -> L10
    L12:
        i = i + 1;     // Catch: Throwable -> L10
        goto L18
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return tokens;
    }

    @Override // com.android.server.backup.OperationStorage
    public Set<Integer> operationTokensForOpState(int state) {
        Set<Integer> tokens = Sets.newHashSet();
        Object r1 = this.mOperationsLock;
        monitor-enter(r1);
        int i = 0;
    L18:
    L10:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mOperations.size()) goto L14;
        Operation op = this.mOperations.valueAt(i);     // Catch: Throwable -> L10
        int token = this.mOperations.keyAt(i);     // Catch: Throwable -> L10
        if (op.state != state) goto L12;
        tokens.add(Integer.valueOf(token));     // Catch: Throwable -> L10
    L12:
        i = i + 1;     // Catch: Throwable -> L10
        goto L18
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return tokens;
    }

    public boolean waitUntilOperationComplete(int token, IntConsumer callback) {
        int finalState = 0;
        Object r2 = this.mOperationsLock;
        monitor-enter(r2);
    L29:
        Operation op = this.mOperations.get(token);     // Catch: Throwable -> L11
        if (op == null) goto L16;
        if (op.state != 0) goto L15;
        this.mOperationsLock.wait();     // Catch: Throwable -> L11 InterruptedException -> L13
    L13:
        e = move-exception;
        Slog.w(TAG, "Waiting on mOperationsLock: ", e);     // Catch: Throwable -> L11
        goto L29
    L15:
        finalState = op.state;     // Catch: Throwable -> L11
    L16:
        monitor-exit(r2);     // Catch: Throwable -> L11
        removeOperation(token);
        if (op == null) goto L21;
        callback.accept(op.type);
    L21:
        if (finalState == 1) goto L36;
        return false;
    L36:
        return true;
    L11:
        th = move-exception;
        throw th;
    }

    public void onOperationComplete(int token, long result, Consumer<BackupRestoreTask> callback) {
        Object r1 = this.mOperationsLock;
        monitor-enter(r1);
        Operation op = this.mOperations.get(token);     // Catch: Throwable -> L9
        if (op != null) goto L7;
    L17:
        this.mOperationsLock.notifyAll();     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        if (op != null) goto L21;
        return;
    L21:
        if (op.callback == null) goto L29;
        callback.accept(op.callback);
        return;
    L29:
        return;
    L7:
        if (op.state != (-1)) goto L12;
        op = null;
        this.mOperations.remove(token);     // Catch: Throwable -> L9
        goto L17
    L12:
        if (op.state != 1) goto L15;
        Slog.w(TAG, "[UserID:" + this.mUserId + "] Received duplicate ack for token=" + Integer.toHexString(token));     // Catch: Throwable -> L9
        op = null;
        this.mOperations.remove(token);     // Catch: Throwable -> L9
        goto L17
    L15:
        if (op.state != 0) goto L17;
        op.state = 1;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public void cancelOperation(int token, IntConsumer operationTimedOutCallback, int cancellationReason) {
        Object r1 = this.mOperationsLock;
        monitor-enter(r1);
        Operation op = this.mOperations.get(token);     // Catch: Throwable -> L7
        if (op == null) goto L9;
        int state = op.state;     // Catch: Throwable -> L7
    L11:
        if (state != 1) goto L13;
        Slog.w(TAG, "[UserID:" + this.mUserId + "] Operation already got an ack.Should have been removed from mCurrentOperations.");     // Catch: Throwable -> L7
        op = null;
        this.mOperations.delete(token);     // Catch: Throwable -> L7
    L15:
        this.mOperationsLock.notifyAll();     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        if (op != null) goto L19;
        return;
    L19:
        if (op.callback == null) goto L27;
        op.callback.handleCancel(cancellationReason);
        return;
    L27:
        return;
    L13:
        if (state != 0) goto L15;
        Slog.d(TAG, "[UserID:" + this.mUserId + "] Cancel: token=" + Integer.toHexString(token));     // Catch: Throwable -> L7
        op.state = -1;     // Catch: Throwable -> L7
        operationTimedOutCallback.accept(op.type);     // Catch: Throwable -> L7
        goto L15
    L9:
        state = -1;
    L7:
        th = move-exception;
        throw th;
    }
}
