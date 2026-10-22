package com.android.server.wm;

import android.app.IApplicationThread;
import android.app.compat.CompatChanges;
import android.app.servertransaction.ClientTransaction;
import android.app.servertransaction.ClientTransactionItem;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.Trace;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.Slog;

/* JADX INFO: loaded from: classes3.dex */
class ClientLifecycleManager {
    private static final long ENABLE_BUNDLE_LAUNCH_ACTIVITY_ITEM = 324203798;
    private static final String TAG = "ClientLifecycleManager";
    final ArrayMap<IBinder, ClientTransaction> mPendingTransactions;
    private WindowManagerService mWms;

    ClientLifecycleManager() {
        this.mPendingTransactions = new ArrayMap();
    }

    void setWindowManager(WindowManagerService wms) {
        this.mWms = wms;
    }

    boolean scheduleTransaction(ClientTransaction transaction) {
        RemoteException e = transaction.schedule();
        if (e == null) goto L6;
        WindowProcessController wpc = this.mWms.mAtmService.getProcessController(transaction.getClient());
        Slog.w(TAG, "Failed to deliver transaction for " + wpc + "\ntransaction=" + this, e);
        return false;
    L6:
        return true;
    }

    boolean scheduleTransactionItemNow(IApplicationThread client, ClientTransactionItem transactionItem) throws RemoteException {
        ClientTransaction clientTransaction = new ClientTransaction(client);
        clientTransaction.addTransactionItem(transactionItem);
        boolean res = scheduleTransaction(clientTransaction);
        if (res == false) goto L6;
        return res;
    L6:
        throw new DeadObjectException();
    }

    boolean scheduleTransactionItem(IApplicationThread client, ClientTransactionItem item) throws RemoteException {
        ClientTransaction clientTransaction = getOrCreatePendingTransaction(client);
        clientTransaction.addTransactionItem(item);
        boolean res = onClientTransactionItemScheduled(clientTransaction, false);
        if (res == false) goto L6;
        return res;
    L6:
        throw new DeadObjectException();
    }

    boolean scheduleTransactionItems(IApplicationThread client, ClientTransactionItem... items) throws RemoteException {
        return scheduleTransactionItems(client, false, items);
    }

    boolean scheduleTransactionItems(IApplicationThread client, boolean shouldDispatchImmediately, ClientTransactionItem... items) throws RemoteException {
        ClientTransaction clientTransaction = getOrCreatePendingTransaction(client);
        int size = items.length;
        int i = 0;
    L3:
        if (i >= size) goto L5;
        clientTransaction.addTransactionItem(items[i]);
        i = i + 1;
        goto L3
    L5:
        boolean res = onClientTransactionItemScheduled(clientTransaction, shouldDispatchImmediately);
        if (res == false) goto L9;
        return res;
    L9:
        throw new DeadObjectException();
    }

    void dispatchPendingTransactions() {
        if (this.mPendingTransactions.isEmpty() == false) goto L5;
        return;
    L5:
        Trace.traceBegin(32, "clientTransactionsDispatched");
        int size = this.mPendingTransactions.size();
        int i = 0;
    L6:
        if (i >= size) goto L8;
        ClientTransaction transaction = this.mPendingTransactions.valueAt(i);
        scheduleTransaction(transaction);
        i = i + 1;
        goto L6
    L8:
        this.mPendingTransactions.clear();
        Trace.traceEnd(32);
    }

    void dispatchPendingTransaction(IApplicationThread client) {
        ClientTransaction pendingTransaction = this.mPendingTransactions.remove(client.asBinder());
        if (pendingTransaction == null) goto L6;
        scheduleTransaction(pendingTransaction);
        return;
    }

    void onLayoutContinued() {
        if (shouldDispatchPendingTransactionsImmediately() == false) goto L6;
        dispatchPendingTransactions();
        return;
    }

    private ClientTransaction getOrCreatePendingTransaction(IApplicationThread client) {
        IBinder clientBinder = client.asBinder();
        ClientTransaction pendingTransaction = this.mPendingTransactions.get(clientBinder);
        if (pendingTransaction == null) goto L5;
        return pendingTransaction;
    L5:
        ClientTransaction transaction = new ClientTransaction(client);
        this.mPendingTransactions.put(clientBinder, transaction);
        return transaction;
    }

    private boolean onClientTransactionItemScheduled(ClientTransaction clientTransaction, boolean shouldDispatchImmediately) {
        if (shouldDispatchImmediately == false) goto L4;
    L8:
        this.mPendingTransactions.remove(clientTransaction.getClient().asBinder());
        return scheduleTransaction(clientTransaction);
    L4:
        if (shouldDispatchPendingTransactionsImmediately() == true) goto L8;
        return true;
    }

    private boolean shouldDispatchPendingTransactionsImmediately() {
        if (this.mWms != null) goto L6;
        return true;
    L6:
        if (this.mWms.mWindowPlacerLocked.isLayoutDeferred() == false) goto L8;
    L12:
        return false;
    L8:
        if (this.mWms.mWindowPlacerLocked.isTraversalScheduled() == true) goto L12;
        if (this.mWms.mWindowPlacerLocked.isInLayout() == true) goto L12;
        return true;
    }

    static boolean shouldDispatchLaunchActivityItemIndependently(String appPackageName, int appUid) {
        return !CompatChanges.isChangeEnabled(ENABLE_BUNDLE_LAUNCH_ACTIVITY_ITEM, appPackageName, UserHandle.getUserHandleForUid(appUid));
    }
}
