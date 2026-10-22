package com.android.server.backup.transport;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.android.server.backup.TransportManager;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
public class TransportConnectionManager {
    private static final String TAG = "TransportConnectionManager";
    private final Context mContext;
    private final Function<ComponentName, Intent> mIntentFunction;
    private Map<TransportConnection, String> mTransportClientsCallerMap;
    private int mTransportClientsCreated;
    private final Object mTransportClientsLock;
    private final TransportStats mTransportStats;
    private final int mUserId;

    public static /* synthetic */ Intent $r8$lambda$Pwv1Wjcrv8QltS66ojkBLq7QJvg(ComponentName r0) {
        return getRealTransportIntent(r0);
    }

    private static Intent getRealTransportIntent(ComponentName transportComponent) {
        return new Intent(TransportManager.SERVICE_ACTION_TRANSPORT_HOST).setComponent(transportComponent);
    }

    public TransportConnectionManager(int userId, Context context, TransportStats transportStats) {
        this(userId, context, transportStats, new TransportConnectionManager$$ExternalSyntheticLambda0());
    }

    private TransportConnectionManager(int userId, Context context, TransportStats transportStats, Function<ComponentName, Intent> intentFunction) {
        this.mTransportClientsLock = new Object();
        this.mTransportClientsCreated = 0;
        this.mTransportClientsCallerMap = new WeakHashMap();
        this.mUserId = userId;
        this.mContext = context;
        this.mTransportStats = transportStats;
        this.mIntentFunction = intentFunction;
    }

    public TransportConnection getTransportClient(ComponentName transportComponent, String caller) {
        return getTransportClient(transportComponent, null, caller);
    }

    public TransportConnection getTransportClient(ComponentName transportComponent, Bundle extras, String caller) {
        Intent bindIntent = this.mIntentFunction.apply(transportComponent);
        if (extras == null) goto L6;
        bindIntent.putExtras(extras);
    L6:
        return getTransportClient(transportComponent, caller, bindIntent);
    }

    private TransportConnection getTransportClient(ComponentName transportComponent, String caller, Intent bindIntent) {
        Object r1 = this.mTransportClientsLock;
        monitor-enter(r1);
        TransportConnection transportConnection = new TransportConnection(this.mUserId, this.mContext, this.mTransportStats, bindIntent, transportComponent, Integer.toString(this.mTransportClientsCreated), caller);     // Catch: Throwable -> L9
        this.mTransportClientsCallerMap.put(transportConnection, caller);     // Catch: Throwable -> L9
        this.mTransportClientsCreated++;     // Catch: Throwable -> L9
        TransportUtils.log(3, TAG, TransportUtils.formatMessage(null, caller, "Retrieving " + transportConnection));     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return transportConnection;
    L9:
        th = move-exception;
        Throwable r11 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r11;
    L11:
        th = move-exception;
        r11 = th;
        goto L13
    }

    public void disposeOfTransportClient(TransportConnection transportConnection, String caller) {
        transportConnection.unbind(caller);
        transportConnection.markAsDisposed();
        Object r0 = this.mTransportClientsLock;
        monitor-enter(r0);
        TransportUtils.log(3, TAG, TransportUtils.formatMessage(null, caller, "Disposing of " + transportConnection));     // Catch: Throwable -> L7
        this.mTransportClientsCallerMap.remove(transportConnection);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void dump(PrintWriter pw) {
        pw.println("Transport clients created: " + this.mTransportClientsCreated);
        Object r0 = this.mTransportClientsLock;
        monitor-enter(r0);
        pw.println("Current transport clients: " + this.mTransportClientsCallerMap.size());     // Catch: Throwable -> L11
        Iterator<TransportConnection> r1 = this.mTransportClientsCallerMap.keySet().iterator();     // Catch: Throwable -> L11
    L6:
        if (r1.hasNext() == false) goto L14;
        TransportConnection transportConnection = r1.next();     // Catch: Throwable -> L11
        String caller = this.mTransportClientsCallerMap.get(transportConnection);     // Catch: Throwable -> L11
        pw.println("    " + transportConnection + " [" + caller + "]");     // Catch: Throwable -> L11
        Iterator<String> r4 = transportConnection.getLogBuffer().iterator();     // Catch: Throwable -> L11
    L9:
        if (r4.hasNext() == false) goto L6;
        String logEntry = r4.next();     // Catch: Throwable -> L11
        pw.println("        " + logEntry);     // Catch: Throwable -> L11
        goto L9
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
