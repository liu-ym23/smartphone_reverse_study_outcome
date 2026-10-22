package com.android.server.location.contexthub;

import android.app.PendingIntent;
import android.content.Context;
import android.hardware.location.ContextHubInfo;
import android.hardware.location.IContextHubClient;
import android.hardware.location.IContextHubClientCallback;
import android.hardware.location.NanoAppMessage;
import android.os.RemoteException;
import android.util.Log;
import android.util.proto.ProtoOutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
class ContextHubClientManager {
    public static final int ACTION_CANCELLED = 2;
    public static final int ACTION_REGISTERED = 0;
    public static final int ACTION_UNREGISTERED = 1;
    private static final boolean DEBUG_LOG_ENABLED = false;
    private static final int MAX_CLIENT_ID = 32767;
    private static final int NUM_CLIENT_RECORDS = 20;
    private static final String TAG = "ContextHubClientManager";
    private final Context mContext;
    private final IContextHubWrapper mContextHubProxy;
    private final ConcurrentHashMap<Short, ContextHubClientBroker> mHostEndPointIdToClientMap;
    private int mNextHostEndPointId;
    private final ConcurrentLinkedEvictingDeque<RegistrationRecord> mRegistrationRecordDeque;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Action {
    }

    private class RegistrationRecord {
        private final int mAction;
        private final String mBroker;
        private final long mTimestamp;

        RegistrationRecord(ContextHubClientManager r3, String broker, int action) {
            this.mBroker = broker;
            this.mAction = action;
            this.mTimestamp = System.currentTimeMillis();
        }

        void dump(ProtoOutputStream proto) {
            proto.write(1112396529665L, this.mTimestamp);
            proto.write(1120986464258L, this.mAction);
            proto.write(1138166333443L, this.mBroker);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(ContextHubServiceUtil.formatDateFromTimestamp(this.mTimestamp));
            sb.append(" ");
            if (this.mAction != 0) goto L5;
            String r1 = "+ ";
        L6:
            sb.append(r1);
            sb.append(this.mBroker);
            if (this.mAction != 2) goto L10;
            sb.append(" (cancelled)");
        L10:
            return sb.toString();
        L5:
            r1 = "- ";
            goto L6
        }
    }

    public static /* synthetic */ void $r8$lambda$D68nlVp6xjS9Wo1LuwN9593ZoXo(long r0, int r2, ContextHubClientBroker r3) {
        lambda$onNanoAppAborted$3(r0, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$c2Il9-BWetUvA8luiqG9ayZwY00, reason: not valid java name */
    public static /* synthetic */ void m5165$r8$lambda$c2Il9BWetUvA8luiqG9ayZwY00(NanoAppMessage r0, List r1, List r2, ContextHubClientBroker r3) {
        lambda$broadcastMessage$4(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$dZA3TWiIN-T1mKMHgcJrbffkIqY, reason: not valid java name */
    public static /* synthetic */ void m5166$r8$lambda$dZA3TWiINT1mKMHgcJrbffkIqY(long r0, ContextHubClientBroker r2) {
        lambda$onNanoAppLoaded$0(r0, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$e-iC4WX48vYRIuoFWK9-Eu7FnEg, reason: not valid java name */
    public static /* synthetic */ void m5167$r8$lambda$eiC4WX48vYRIuoFWK9Eu7FnEg(ContextHubClientBroker r0) {
        lambda$onHubReset$2(r0);
    }

    public static /* synthetic */ void $r8$lambda$lMwWO07FgoVq4AhBZdqZpLCqaSI(long r0, ContextHubClientBroker r2) {
        lambda$onNanoAppUnloaded$1(r0, r2);
    }

    ContextHubClientManager(Context context, IContextHubWrapper contextHubProxy) {
        this.mHostEndPointIdToClientMap = new ConcurrentHashMap();
        this.mNextHostEndPointId = 0;
        this.mRegistrationRecordDeque = new ConcurrentLinkedEvictingDeque(20);
        this.mContext = context;
        this.mContextHubProxy = contextHubProxy;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.os.IBinder, com.android.server.location.contexthub.ContextHubClientBroker, java.lang.Object] */
    IContextHubClient registerClient(ContextHubInfo r11, IContextHubClientCallback r12, String r13, ContextHubTransactionManager r14, String r15) {
        monitor-enter(this);
        short r5 = getHostEndPointId();     // Catch: Throwable -> L11
        ?? r0 = new ContextHubClientBroker(this.mContext, this.mContextHubProxy, this, r11, r5, r12, r13, r14, r15);     // Catch: Throwable -> L11
        this.mHostEndPointIdToClientMap.put(Short.valueOf(r5), (ContextHubClientBroker) r0);     // Catch: Throwable -> L11
        this.mRegistrationRecordDeque.add(new RegistrationRecord(this, r0.toString(), 0));     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        r0.attachDeathRecipient();     // Catch: RemoteException -> L8
        Log.d(TAG, "Registered client with host endpoint ID " + r0.getHostEndPointId());
        return IContextHubClient.Stub.asInterface(r0);
    L9:
        Log.e(TAG, "Failed to attach death recipient to client");
        r0.close();
        return null;
    L11:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [android.os.IBinder, com.android.server.location.contexthub.ContextHubClientBroker] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    IContextHubClient registerClient(ContextHubInfo r14, PendingIntent r15, long r16, String r18, ContextHubTransactionManager r19) {
        String r1 = "Regenerated";
        monitor-enter(this);
        ContextHubClientBroker r0 = getClientBroker(r14.getId(), r15, r16);     // Catch: Throwable -> L8
        if (r0 != null) goto L11;
        short r7 = getHostEndPointId();     // Catch: Throwable -> L8
        ContextHubClientBroker r2 = new ContextHubClientBroker(this.mContext, this.mContextHubProxy, this, r14, r7, r15, r16, r18, r19);     // Catch: Throwable -> L8
        this.mHostEndPointIdToClientMap.put(Short.valueOf(r7), r2);     // Catch: Throwable -> L8
        r1 = "Registered";
        this.mRegistrationRecordDeque.add(new RegistrationRecord(this, r2.toString(), 0));     // Catch: Throwable -> L8
        ?? r3 = r2;
    L12:
        monitor-exit(this);     // Catch: Throwable -> L15
        Log.d(TAG, r1 + " client with host endpoint ID " + r3.getHostEndPointId());
        return IContextHubClient.Stub.asInterface(r3);
    L11:
        r0.setAttributionTag(r18);     // Catch: Throwable -> L15
        r3 = r0;
    L8:
        th = th;
    L16:
        monitor-exit(this);     // Catch: Throwable -> L15
        throw th;
    L15:
        th = th;
        goto L16
    }

    byte onMessageFromNanoApp(int contextHubId, short hostEndpointId, NanoAppMessage message, List<String> nanoappPermissions, List<String> messagePermissions) {
        if (message.isBroadcastMessage() == true) goto L5;
        ContextHubClientBroker proxy = this.mHostEndPointIdToClientMap.get(Short.valueOf(hostEndpointId));
        if (proxy != null) goto L18;
        ContextHubEventLogger.getInstance().logMessageFromNanoapp(contextHubId, message, false);
        Log.e(TAG, "Cannot send message to unregistered client (host endpoint ID = " + hostEndpointId + ")");
        return 4;
    L18:
        ContextHubEventLogger.getInstance().logMessageFromNanoapp(contextHubId, message, true);
        return proxy.sendMessageToClient(message, nanoappPermissions, messagePermissions);
    L5:
        if (message.isReliable() == false) goto L9;
        Log.e(TAG, "Received reliable broadcast message from 0x" + Long.toHexString(message.getNanoAppId()));
        return 2;
    L9:
        if (messagePermissions.isEmpty() == true) goto L12;
        Log.e(TAG, "Received broadcast message with permissions from 0x" + Long.toHexString(message.getNanoAppId()));
        return 2;
    L12:
        ContextHubEventLogger.getInstance().logMessageFromNanoapp(contextHubId, message, true);
        broadcastMessage(contextHubId, message, nanoappPermissions, messagePermissions);
        return 0;
    }

    void unregisterClient(short hostEndPointId) {
        ContextHubClientBroker broker = this.mHostEndPointIdToClientMap.get(Short.valueOf(hostEndPointId));
        if (broker == null) goto L10;
        if (broker.isPendingIntentCancelled() == false) goto L7;
        int action = 2;
    L8:
        this.mRegistrationRecordDeque.add(new RegistrationRecord(this, broker.toString(), action));
        goto L10
    L7:
        action = 1;
    L10:
        if (this.mHostEndPointIdToClientMap.remove(Short.valueOf(hostEndPointId)) == null) goto L12;
        Log.d(TAG, "Unregistered client with host endpoint ID " + hostEndPointId);
        return;
    L12:
        Log.e(TAG, "Cannot unregister non-existing client with host endpoint ID " + hostEndPointId);
    }

    private static /* synthetic */ void lambda$onNanoAppLoaded$0(long nanoAppId, ContextHubClientBroker client) {
        client.onNanoAppLoaded(nanoAppId);
    }

    void onNanoAppLoaded(int contextHubId, final long nanoAppId) {
        forEachClientOfHub(contextHubId, new ContextHubClientManager$$ExternalSyntheticLambda2(nanoAppId));
    }

    private static /* synthetic */ void lambda$onNanoAppUnloaded$1(long nanoAppId, ContextHubClientBroker client) {
        client.onNanoAppUnloaded(nanoAppId);
    }

    void onNanoAppUnloaded(int contextHubId, final long nanoAppId) {
        forEachClientOfHub(contextHubId, new ContextHubClientManager$$ExternalSyntheticLambda1(nanoAppId));
    }

    private static /* synthetic */ void lambda$onHubReset$2(ContextHubClientBroker client) {
        client.onHubReset();
    }

    void onHubReset(int contextHubId) {
        forEachClientOfHub(contextHubId, new ContextHubClientManager$$ExternalSyntheticLambda0());
    }

    private static /* synthetic */ void lambda$onNanoAppAborted$3(long nanoAppId, int abortCode, ContextHubClientBroker client) {
        client.onNanoAppAborted(nanoAppId, abortCode);
    }

    void onNanoAppAborted(int contextHubId, final long nanoAppId, final int abortCode) {
        forEachClientOfHub(contextHubId, new ContextHubClientManager$$ExternalSyntheticLambda3(nanoAppId, abortCode));
    }

    void forEachClientOfHub(int contextHubId, Consumer<ContextHubClientBroker> callback) {
        Iterator<ContextHubClientBroker> r0 = this.mHostEndPointIdToClientMap.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        ContextHubClientBroker broker = r0.next();
        if (broker.getAttachedContextHubId() != contextHubId) goto L4;
        callback.accept(broker);
        goto L4
    }

    private short getHostEndPointId() {
        if (this.mHostEndPointIdToClientMap.size() == 32768) goto L20;
        int id = this.mNextHostEndPointId;
        int i = 0;
    L6:
        if (i > MAX_CLIENT_ID) goto L18;
        int r4 = 0;
        if (this.mHostEndPointIdToClientMap.containsKey(Short.valueOf((short) id)) == false) goto L9;
        if (id == MAX_CLIENT_ID) goto L16;
        r4 = id + 1;
    L16:
        id = r4;
        i = i + 1;
        goto L6
    L9:
        if (id == MAX_CLIENT_ID) goto L12;
        r4 = id + 1;
    L12:
        this.mNextHostEndPointId = r4;
    L18:
        return (short) id;
    L20:
        throw new IllegalStateException("Could not register client - max limit exceeded");
    }

    private void broadcastMessage(int contextHubId, final NanoAppMessage message, final List<String> nanoappPermissions, final List<String> messagePermissions) {
        forEachClientOfHub(contextHubId, new ContextHubClientManager$$ExternalSyntheticLambda4(message, nanoappPermissions, messagePermissions));
    }

    private static /* synthetic */ void lambda$broadcastMessage$4(NanoAppMessage message, List nanoappPermissions, List messagePermissions, ContextHubClientBroker client) {
        client.sendMessageToClient(message, nanoappPermissions, messagePermissions);
    }

    private ContextHubClientBroker getClientBroker(int contextHubId, PendingIntent pendingIntent, long nanoAppId) {
        Iterator<ContextHubClientBroker> r0 = this.mHostEndPointIdToClientMap.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        ContextHubClientBroker broker = r0.next();
        if (broker.hasPendingIntent(pendingIntent, nanoAppId) == false) goto L4;
        if (broker.getAttachedContextHubId() != contextHubId) goto L4;
        return broker;
    L11:
        return null;
    }

    void dump(ProtoOutputStream proto) {
        Iterator<ContextHubClientBroker> r0 = this.mHostEndPointIdToClientMap.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ContextHubClientBroker broker = r0.next();
        long token = proto.start(2246267895809L);
        broker.dump(proto);
        proto.end(token);
        goto L4
    L6:
        Iterator<RegistrationRecord> it = this.mRegistrationRecordDeque.descendingIterator();
    L8:
        if (it.hasNext() == false) goto L10;
        long token2 = proto.start(2246267895810L);
        it.next().dump(proto);
        proto.end(token2);
        goto L8
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<ContextHubClientBroker> r1 = this.mHostEndPointIdToClientMap.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ContextHubClientBroker broker = r1.next();
        sb.append(broker);
        sb.append(System.lineSeparator());
        goto L4
    L6:
        sb.append(System.lineSeparator());
        sb.append("Registration History:");
        sb.append(System.lineSeparator());
        Iterator<RegistrationRecord> it = this.mRegistrationRecordDeque.descendingIterator();
    L8:
        if (it.hasNext() == false) goto L11;
        sb.append(it.next());
        sb.append(System.lineSeparator());
        goto L8
    L11:
        return sb.toString();
    }
}
