package com.android.server.companion.transport;

import android.companion.AssociationInfo;
import android.companion.IOnMessageReceivedListener;
import android.companion.IOnTransportsChangedListener;
import android.content.Context;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Slog;
import android.util.SparseArray;
import com.android.server.companion.association.AssociationStore;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public class CompanionTransportManager {
    private static final String TAG = "CDM_CompanionTransportManager";
    private final AssociationStore mAssociationStore;
    private final Context mContext;
    private final SparseArray<Set<IOnMessageReceivedListener>> mMessageListeners;
    private boolean mSecureTransportEnabled;
    private final SparseArray<Transport> mTransports;
    private final RemoteCallbackList<IOnTransportsChangedListener> mTransportsListeners;

    public static class EmulatedTransport extends RawTransport {
        @Override // com.android.server.companion.transport.RawTransport
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        EmulatedTransport(int associationId, ParcelFileDescriptor fd, Context context) {
            super(associationId, fd, context);
        }

        public void processMessage(int messageType, int sequence, byte[] data) throws IOException {
            handleMessage(messageType, sequence, data);
        }

        @Override // com.android.server.companion.transport.RawTransport, com.android.server.companion.transport.Transport
        protected void sendMessage(int messageType, int sequence, byte[] data) throws IOException {
            Slog.e("CDM_CompanionTransport", "Black-holing emulated message type 0x" + Integer.toHexString(messageType) + " sequence " + sequence + " length " + data.length + " to association " + this.mAssociationId);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$36uuzDRclPDQIPJiNfz_-SR7-wo, reason: not valid java name */
    public static /* synthetic */ void m2972$r8$lambda$36uuzDRclPDQIPJiNfz_SR7wo(CompanionTransportManager r0, IOnTransportsChangedListener r1, IOnTransportsChangedListener r2) {
        r0.lambda$addListener$0(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$XfXBCcfHQMio55TByIyfN2lJwbo(CompanionTransportManager r0, IOnTransportsChangedListener r1) {
        r0.lambda$notifyOnTransportsChanged$1(r1);
    }

    public CompanionTransportManager(Context context, AssociationStore associationStore) {
        this.mSecureTransportEnabled = true;
        this.mTransports = new SparseArray();
        this.mTransportsListeners = new RemoteCallbackList();
        this.mMessageListeners = new SparseArray();
        this.mContext = context;
        this.mAssociationStore = associationStore;
    }

    public void addListener(int message, IOnMessageReceivedListener listener) {
        SparseArray<Set<IOnMessageReceivedListener>> r0 = this.mMessageListeners;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mMessageListeners.contains(message) == true) goto L9;
        this.mMessageListeners.put(message, new HashSet());     // Catch: Throwable -> L7
    L9:
        this.mMessageListeners.get(message).add(listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        SparseArray<Transport> r1 = this.mTransports;
        monitor-enter(r1);
        int i = 0;
    L28:
    L17:
        th = move-exception;
        throw th;
    L15:
        if (i >= this.mTransports.size()) goto L20;
        this.mTransports.valueAt(i).addListener(message, listener);     // Catch: Throwable -> L17
        i = i + 1;     // Catch: Throwable -> L17
        goto L28
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L17
    }

    public void addListener(final IOnTransportsChangedListener listener) {
        Slog.i(TAG, "Registering OnTransportsChangedListener");
        SparseArray<Transport> r0 = this.mTransports;
        monitor-enter(r0);
        this.mTransportsListeners.register(listener);     // Catch: Throwable -> L7
        this.mTransportsListeners.broadcast(new CompanionTransportManager$$ExternalSyntheticLambda0(this, listener));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$addListener$0(IOnTransportsChangedListener listener, IOnTransportsChangedListener listener1) {
        if (listener1 != listener) goto L9;
        listener.onTransportsChanged(getAssociationsWithTransport());     // Catch: RemoteException -> L5
        return;
    L6:
        return;
    }

    public void removeListener(IOnTransportsChangedListener listener) {
        SparseArray<Transport> r0 = this.mTransports;
        monitor-enter(r0);
        this.mTransportsListeners.unregister(listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeListener(int messageType, IOnMessageReceivedListener listener) {
        SparseArray<Set<IOnMessageReceivedListener>> r0 = this.mMessageListeners;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mMessageListeners.contains(messageType) == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mMessageListeners.get(messageType).remove(listener);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    public void sendMessage(int message, byte[] data, int[] associationIds) {
        Slog.d(TAG, "Sending message 0x" + Integer.toHexString(message) + " data length " + data.length);
        SparseArray<Transport> r0 = this.mTransports;
        monitor-enter(r0);
        int i = 0;
    L18:
    L10:
        th = move-exception;
        throw th;
    L6:
        if (i >= associationIds.length) goto L14;
        if (this.mTransports.contains(associationIds[i]) == false) goto L12;
        this.mTransports.get(associationIds[i]).sendMessage(message, data);     // Catch: Throwable -> L10
    L12:
        i = i + 1;     // Catch: Throwable -> L10
        goto L18
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    public void attachSystemDataTransport(int associationId, ParcelFileDescriptor fd, int flags) {
        Slog.i(TAG, "Attaching transport for association id=[" + associationId + "]...");
        AssociationInfo association = this.mAssociationStore.getAssociationWithCallerChecks(associationId);
        TransportUtils.enforceAssociationCanUseTransportFlags(association, flags);
        SparseArray<Transport> r1 = this.mTransports;
        monitor-enter(r1);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mTransports.contains(associationId) == false) goto L9;
        detachSystemDataTransport(associationId);     // Catch: Throwable -> L7
    L9:
        initializeTransport(association, fd, null, flags);     // Catch: Throwable -> L7
        notifyOnTransportsChanged();     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        Slog.i(TAG, "Transport attached.");
    }

    public void detachSystemDataTransport(int associationId) {
        Slog.i(TAG, "Detaching transport for association id=[" + associationId + "]...");
        this.mAssociationStore.getAssociationWithCallerChecks(associationId);
        SparseArray<Transport> r0 = this.mTransports;
        monitor-enter(r0);
        Transport transport = (Transport) this.mTransports.removeReturnOld(associationId);     // Catch: Throwable -> L8
        if (transport != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        transport.stop();     // Catch: Throwable -> L8
        notifyOnTransportsChanged();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        Slog.i(TAG, "Transport detached.");
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private List<AssociationInfo> getAssociationsWithTransport() {
        List<AssociationInfo> associations = new ArrayList();
        SparseArray<Transport> r1 = this.mTransports;
        monitor-enter(r1);
        int i = 0;
    L18:
    L10:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mTransports.size()) goto L14;
        AssociationInfo association = this.mAssociationStore.getAssociationById(this.mTransports.keyAt(i));     // Catch: Throwable -> L10
        if (association == null) goto L12;
        associations.add(association);     // Catch: Throwable -> L10
    L12:
        i = i + 1;     // Catch: Throwable -> L10
        goto L18
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return associations;
    }

    private void notifyOnTransportsChanged() {
        SparseArray<Transport> r0 = this.mTransports;
        monitor-enter(r0);
        this.mTransportsListeners.broadcast(new CompanionTransportManager$$ExternalSyntheticLambda1(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$notifyOnTransportsChanged$1(IOnTransportsChangedListener listener) {
        listener.onTransportsChanged(getAssociationsWithTransport());     // Catch: RemoteException -> L4
        return;
    }

    private void initializeTransport(AssociationInfo association, ParcelFileDescriptor fd, byte[] preSharedKey, int flags) {
        Slog.i(TAG, "Initializing transport");
        int associationId = association.getId();
        if (isSecureTransportEnabled() == true) goto L6;
        Slog.i(TAG, "Secure channel is disabled. Creating raw transport");
        Transport transport = new RawTransport(associationId, fd, this.mContext);
    L15:
        addMessageListenersToTransport(transport);
        transport.setOnTransportClosedListener(new CompanionTransportManager$$ExternalSyntheticLambda2(this));
        transport.start();
        SparseArray<Transport> r12 = this.mTransports;
        monitor-enter(r12);
        this.mTransports.put(associationId, transport);     // Catch: Throwable -> L20
        monitor-exit(r12);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    L6:
        if (Build.isDebuggable() == false) goto L9;
        Slog.d(TAG, "Creating an unauthenticated secure channel");
        byte[] testKey = "CDM".getBytes(StandardCharsets.UTF_8);
        Transport transport2 = new SecureTransport(associationId, fd, this.mContext, testKey, null, 0);
        transport = transport2;
        goto L15
    L9:
        if (preSharedKey == null) goto L12;
        Slog.d(TAG, "Creating a PSK-authenticated secure channel");
        transport = new SecureTransport(associationId, fd, this.mContext, preSharedKey, null, 0);
        goto L15
    L12:
        if ("android.companion.COMPANION_DEVICE_WEARABLE_SENSING".equals(association.getDeviceProfile()) == false) goto L14;
        Slog.d(TAG, "Creating a secure channel with extended patch difference allowance");
        transport = new SecureTransport(associationId, fd, this.mContext, 1);
        goto L15
    L14:
        Slog.d(TAG, "Creating a secure channel");
        transport = new SecureTransport(associationId, fd, this.mContext, flags);
        goto L15
    }

    public Future<?> requestPermissionRestore(int associationId, byte[] data) {
        SparseArray<Transport> r0 = this.mTransports;
        monitor-enter(r0);
        Transport transport = this.mTransports.get(associationId);     // Catch: Throwable -> L9
        if (transport != null) goto L11;
        CompletableFuture r2 = CompletableFuture.failedFuture(new IOException("Missing transport"));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L11:
        Future r3 = transport.sendMessage(1669491075, data);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public void dump(PrintWriter out) {
        SparseArray<Transport> r0 = this.mTransports;
        monitor-enter(r0);
        out.append("System Data Transports: ");     // Catch: Throwable -> L7
        if (this.mTransports.size() != 0) goto L9;
        out.append("<empty>\n");     // Catch: Throwable -> L7
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        out.append("\n");     // Catch: Throwable -> L7
        int i = 0;
    L11:
        if (i >= this.mTransports.size()) goto L13;
        int associationId = this.mTransports.keyAt(i);     // Catch: Throwable -> L7
        Transport transport = this.mTransports.get(associationId);     // Catch: Throwable -> L7
        out.append("  ").append(transport.toString()).append('\n');     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public void enableSecureTransport(boolean enabled) {
        this.mSecureTransportEnabled = enabled;
    }

    public EmulatedTransport createEmulatedTransport(int associationId) {
        SparseArray<Transport> r0 = this.mTransports;
        monitor-enter(r0);
        FileDescriptor fd = new FileDescriptor();     // Catch: Throwable -> L7
        ParcelFileDescriptor pfd = new ParcelFileDescriptor(fd);     // Catch: Throwable -> L7
        EmulatedTransport transport = new EmulatedTransport(associationId, pfd, this.mContext);     // Catch: Throwable -> L7
        addMessageListenersToTransport(transport);     // Catch: Throwable -> L7
        this.mTransports.put(associationId, transport);     // Catch: Throwable -> L7
        notifyOnTransportsChanged();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return transport;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean isSecureTransportEnabled() {
        return this.mSecureTransportEnabled;
    }

    private void addMessageListenersToTransport(Transport transport) {
        SparseArray<Set<IOnMessageReceivedListener>> r0 = this.mMessageListeners;
        monitor-enter(r0);
        int i = 0;
    L19:
    L11:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mMessageListeners.size()) goto L15;
        Iterator<IOnMessageReceivedListener> r2 = this.mMessageListeners.valueAt(i).iterator();     // Catch: Throwable -> L11
    L9:
        if (r2.hasNext() == false) goto L13;
        IOnMessageReceivedListener listener = r2.next();     // Catch: Throwable -> L11
        transport.addListener(this.mMessageListeners.keyAt(i), listener);     // Catch: Throwable -> L11
        goto L9
    L13:
        i = i + 1;     // Catch: Throwable -> L11
        goto L19
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    void detachSystemDataTransport(Transport transport) {
        int associationId = transport.mAssociationId;
        AssociationInfo association = this.mAssociationStore.getAssociationById(associationId);
        if (association == null) goto L6;
        detachSystemDataTransport(association.getId());
        return;
    }
}
