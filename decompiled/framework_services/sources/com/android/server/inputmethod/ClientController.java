package com.android.server.inputmethod;

import android.content.pm.PackageManagerInternal;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.ArrayMap;
import com.android.internal.inputmethod.IInputMethodClient;
import com.android.internal.inputmethod.IRemoteInputConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
final class ClientController {
    private final List<ClientControllerCallback> mCallbacks;
    private final ArrayMap<IBinder, ClientState> mClients;
    private final PackageManagerInternal mPackageManagerInternal;

    interface ClientControllerCallback {
        void onClientRemoved(ClientState r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$eF4cD2NQlJ6H-Idt0s1NiLWRSeA, reason: not valid java name */
    public static /* synthetic */ void m4634$r8$lambda$eF4cD2NQlJ6HIdt0s1NiLWRSeA(ClientController r0, IInputMethodClientInvoker r1) {
        r0.lambda$addClient$0(r1);
    }

    ClientController(PackageManagerInternal packageManagerInternal) {
        this.mClients = new ArrayMap();
        this.mCallbacks = new ArrayList();
        this.mPackageManagerInternal = packageManagerInternal;
    }

    ClientState addClient(final IInputMethodClientInvoker clientInvoker, IRemoteInputConnection fallbackInputConnection, int selfReportedDisplayId, int callerUid, int callerPid) {
        IBinder.DeathRecipient deathRecipient = new ClientController$$ExternalSyntheticLambda0(this, clientInvoker);
        int numClients = this.mClients.size();
        int i = 0;
    L3:
        if (i >= numClients) goto L21;
        ClientState state = this.mClients.valueAt(i);
        if (state.mUid != callerUid) goto L13;
        if (state.mPid != callerPid) goto L13;
        if (state.mSelfReportedDisplayId != selfReportedDisplayId) goto L13;
        throw new SecurityException("uid=" + callerUid + "/pid=" + callerPid + "/displayId=" + selfReportedDisplayId + " is already registered");
    L13:
        i = i + 1;
        goto L3
    L21:
        clientInvoker.asBinder().linkToDeath(deathRecipient, 0);     // Catch: RemoteException -> L18
        ClientState cs = new ClientState(clientInvoker, fallbackInputConnection, callerUid, callerPid, selfReportedDisplayId, deathRecipient);
        this.mClients.put(clientInvoker.asBinder(), cs);
        return cs;
    L18:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    private /* synthetic */ void lambda$addClient$0(IInputMethodClientInvoker clientInvoker) {
        monitor-enter(ImfLock.class);
        removeClientAsBinder(clientInvoker.asBinder());     // Catch: Throwable -> L7
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    boolean removeClient(IInputMethodClient client) {
        return removeClientAsBinder(client.asBinder());
    }

    private boolean removeClientAsBinder(IBinder binder) {
        ClientState cs = this.mClients.remove(binder);
        if (cs != null) goto L5;
        return false;
    L5:
        binder.unlinkToDeath(cs.mClientDeathRecipient, 0);
        int i = 0;
    L7:
        if (i >= this.mCallbacks.size()) goto L9;
        this.mCallbacks.get(i).onClientRemoved(cs);
        i = i + 1;
        goto L7
    L9:
        return true;
    }

    void addClientControllerCallback(ClientControllerCallback callback) {
        this.mCallbacks.add(callback);
    }

    ClientState getClient(IBinder binder) {
        return this.mClients.get(binder);
    }

    void forAllClients(Consumer<ClientState> consumer) {
        int i = 0;
    L4:
        if (i >= this.mClients.size()) goto L7;
        consumer.accept(this.mClients.valueAt(i));
        i = i + 1;
        goto L4
    }

    boolean verifyClientAndPackageMatch(IInputMethodClient client, String packageName) {
        ClientState cs = this.mClients.get(client.asBinder());
        if (cs == null) goto L7;
        return InputMethodUtils.checkIfPackageBelongsToUid(this.mPackageManagerInternal, cs.mUid, packageName);
    L7:
        throw new IllegalArgumentException("unknown client " + client.asBinder());
    }
}
