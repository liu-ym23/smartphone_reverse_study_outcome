package com.android.server.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaRoute2Info;
import android.media.MediaRoute2ProviderInfo;
import android.media.MediaRouter2Utils;
import android.media.RoutingSessionInfo;
import android.os.Binder;
import android.os.Looper;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.util.LongSparseArray;
import com.android.server.BinaryTransparencyService$Digest$$ExternalSyntheticRecord1;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes2.dex */
class SystemMediaRoute2Provider2 extends SystemMediaRoute2Provider {
    private static final ComponentName COMPONENT_NAME = null;
    private static final boolean FORCE_GLOBAL_ROUTING_SESSION = true;
    private static final String PACKAGE_NAME_FOR_GLOBAL_SESSION = "";
    private static final String UNIQUE_SYSTEM_ID_PREFIX = "SYSTEM";
    private static final String UNIQUE_SYSTEM_ID_SEPARATOR = "-";
    private MediaRoute2ProviderInfo mLastSystemProviderInfo;
    private final Map<String, String> mOriginalRouteIdToProviderId;
    private final PackageManager mPackageManager;
    private final Map<String, SystemMediaSessionRecord> mPackageNameToSessionRecord;
    private final LongSparseArray<SystemMediaSessionCallbackImpl> mPendingSessionCreations;
    private final Map<String, ProviderProxyRecord> mProxyRecords;
    private final Map<String, SystemMediaSessionRecord> mSessionOriginalIdToSessionRecord;

    private static final class ProviderProxyRecord extends Record {
        private final Map<String, String> mNewOriginalIdToSourceOriginalIdMap;
        private final MediaRoute2ProviderServiceProxy mProxy;
        private final Map<String, MediaRoute2Info> mSystemMediaRoutes;

        private /* synthetic */ boolean $record$equals(Object r3) {
            if ((r3 instanceof ProviderProxyRecord) == false) goto L12;
            ProviderProxyRecord r4 = (ProviderProxyRecord) r3;
            if (Objects.equals(this.mProxy, r4.mProxy) == true) goto L7;
            return false;
        L7:
            if (Objects.equals(this.mSystemMediaRoutes, r4.mSystemMediaRoutes) == true) goto L9;
            return false;
        L9:
            if (Objects.equals(this.mNewOriginalIdToSourceOriginalIdMap, r4.mNewOriginalIdToSourceOriginalIdMap) == false) goto L16;
            return true;
        L16:
            return false;
        L12:
            return false;
        }

        private /* synthetic */ Object[] $record$getFieldsAsObjects() {
            return new Object[]{this.mProxy, this.mSystemMediaRoutes, this.mNewOriginalIdToSourceOriginalIdMap};
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmNewOriginalIdToSourceOriginalIdMap, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m5783$$Nest$fgetmNewOriginalIdToSourceOriginalIdMap(ProviderProxyRecord r0) {
            return r0.mNewOriginalIdToSourceOriginalIdMap;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmProxy, reason: not valid java name */
        static /* bridge */ /* synthetic */ MediaRoute2ProviderServiceProxy m5784$$Nest$fgetmProxy(ProviderProxyRecord r0) {
            return r0.mProxy;
        }

        private ProviderProxyRecord(MediaRoute2ProviderServiceProxy mProxy, Map<String, MediaRoute2Info> mSystemMediaRoutes, Map<String, String> mNewOriginalIdToSourceOriginalIdMap) {
            this.mProxy = mProxy;
            this.mSystemMediaRoutes = mSystemMediaRoutes;
            this.mNewOriginalIdToSourceOriginalIdMap = mNewOriginalIdToSourceOriginalIdMap;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return $record$equals(o);
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return SystemMediaRoute2Provider2$ProviderProxyRecord$$ExternalSyntheticRecord0.m(this.mProxy, this.mSystemMediaRoutes, this.mNewOriginalIdToSourceOriginalIdMap);
        }

        public Map<String, String> mNewOriginalIdToSourceOriginalIdMap() {
            return this.mNewOriginalIdToSourceOriginalIdMap;
        }

        public MediaRoute2ProviderServiceProxy mProxy() {
            return this.mProxy;
        }

        public Map<String, MediaRoute2Info> mSystemMediaRoutes() {
            return this.mSystemMediaRoutes;
        }

        @Override // java.lang.Record
        public final String toString() {
            return BinaryTransparencyService$Digest$$ExternalSyntheticRecord1.m($record$getFieldsAsObjects(), ProviderProxyRecord.class, "mProxy;mSystemMediaRoutes;mNewOriginalIdToSourceOriginalIdMap");
        }

        public Stream<MediaRoute2Info> getRoutesStream() {
            return this.mSystemMediaRoutes.values().stream();
        }

        public MediaRoute2Info getRouteByOriginalId(String routeOriginalId) {
            return this.mSystemMediaRoutes.get(routeOriginalId);
        }

        public void requestCreateSystemMediaSession(long requestId, int uid, String packageName, String originalRouteId, MediaRoute2ProviderServiceProxy.SystemMediaSessionCallback callback) {
            String targetRouteId = this.mNewOriginalIdToSourceOriginalIdMap.get(originalRouteId);
            if (targetRouteId != null) goto L5;
            Log.w("MR2SystemProvider", "Failed system media session creation due to lack of mapping for id: " + originalRouteId);
            callback.onRequestFailed(requestId, 3);
            return;
        L5:
            this.mProxy.requestCreateSystemMediaSession(requestId, uid, packageName, targetRouteId, null, callback);
        }

        public void releaseSession(long requestId, String originalSessionId) {
            this.mProxy.releaseSession(requestId, originalSessionId);
        }

        public static ProviderProxyRecord createFor(MediaRoute2ProviderServiceProxy serviceProxy) {
            MediaRoute2ProviderInfo providerInfo = serviceProxy.getProviderInfo();
            if (providerInfo != null) goto L6;
            return null;
        L6:
            Map<String, MediaRoute2Info> routesMap = new ArrayMap();
            Map<String, String> idMap = new ArrayMap();
            Iterator r3 = providerInfo.getRoutes().iterator();
        L8:
            if (r3.hasNext() == false) goto L20;
            MediaRoute2Info sourceRoute = (MediaRoute2Info) r3.next();
            if (sourceRoute.supportsSystemMediaRouting() == false) goto L8;
            String id = SystemMediaRoute2Provider2.m5781$$Nest$smasUniqueSystemId(providerInfo.getUniqueId(), sourceRoute.getOriginalId());
            MediaRoute2Info.Builder newRouteBuilder = new MediaRoute2Info.Builder(id, sourceRoute);
            if ((sourceRoute.getSupportedRoutingTypes() & 1) == 0) goto L16;
            newRouteBuilder.addFeature("android.media.route.feature.LIVE_AUDIO");
        L16:
            if ((sourceRoute.getSupportedRoutingTypes() & 2) == 0) goto L18;
            newRouteBuilder.addFeature("android.media.route.feature.LIVE_VIDEO");
        L18:
            routesMap.put(id, newRouteBuilder.build());
            idMap.put(id, sourceRoute.getOriginalId());
            goto L8
        L20:
            return new ProviderProxyRecord(serviceProxy, Collections.unmodifiableMap(routesMap), Collections.unmodifiableMap(idMap));
        }
    }

    private class SystemMediaSessionCallbackImpl implements MediaRoute2ProviderServiceProxy.SystemMediaSessionCallback {
        private final String mClientPackageName;
        private final String mProviderId;
        private final long mRequestId;
        private SystemMediaSessionRecord mSessionRecord;
        final /* synthetic */ SystemMediaRoute2Provider2 this$0;

        public static /* synthetic */ void $r8$lambda$RiFURMZHTPqWUfAAtF9ZRzZvqKQ(SystemMediaSessionCallbackImpl r0, RoutingSessionInfo r1) {
            r0.lambda$onSessionUpdate$0(r1);
        }

        public static /* synthetic */ void $r8$lambda$briXX4VJSkP5cSMFhRjqJtdIij8(SystemMediaSessionCallbackImpl r0, long r1, int r3) {
            r0.lambda$onRequestFailed$1(r1, r3);
        }

        public static /* synthetic */ void $r8$lambda$wLWyvuDh2eSGULi4izl3P6D9WZU(SystemMediaSessionCallbackImpl r0) {
            r0.lambda$onSessionReleased$2();
        }

        /* synthetic */ SystemMediaSessionCallbackImpl(SystemMediaRoute2Provider2 r1, String r2, long r3, String r5, SystemMediaRoute2Provider2IA r6) {
            this(r1, r2, r3, r5);
        }

        private SystemMediaSessionCallbackImpl(SystemMediaRoute2Provider2 r1, String providerId, long requestId, String clientPackageName) {
            this.this$0 = r1;
            this.mProviderId = providerId;
            this.mRequestId = requestId;
            this.mClientPackageName = clientPackageName;
        }

        @Override // com.android.server.media.MediaRoute2ProviderServiceProxy.SystemMediaSessionCallback
        public void onSessionUpdate(final RoutingSessionInfo sessionInfo) {
            this.this$0.mHandler.post(new SystemMediaRoute2Provider2$SystemMediaSessionCallbackImpl$$ExternalSyntheticLambda1(this, sessionInfo));
        }

        private /* synthetic */ void lambda$onSessionUpdate$0(RoutingSessionInfo sessionInfo) {
            if (this.mSessionRecord == null) goto L5;
            this.mSessionRecord.onSessionUpdate(sessionInfo);
            return;
        L5:
            SystemMediaSessionRecord systemMediaSessionRecord = new SystemMediaSessionRecord(this.this$0, this.mProviderId, sessionInfo);
            Object r1 = this.this$0.mLock;
            monitor-enter(r1);
            this.mSessionRecord = systemMediaSessionRecord;     // Catch: Throwable -> L11
            SystemMediaRoute2Provider2.m5779$$Nest$fgetmSessionOriginalIdToSessionRecord(this.this$0).put(SystemMediaSessionRecord.m5788$$Nest$fgetmOriginalId(systemMediaSessionRecord), systemMediaSessionRecord);     // Catch: Throwable -> L11
            SystemMediaRoute2Provider2.m5776$$Nest$fgetmPackageNameToSessionRecord(this.this$0).put(this.mClientPackageName, systemMediaSessionRecord);     // Catch: Throwable -> L11
            SystemMediaRoute2Provider2.m5777$$Nest$fgetmPendingSessionCreations(this.this$0).remove(this.mRequestId);     // Catch: Throwable -> L11
            RoutingSessionInfo translatedSession = SystemMediaSessionRecord.m5790$$Nest$fgetmTranslatedSessionInfo(systemMediaSessionRecord);     // Catch: Throwable -> L11
            monitor-exit(r1);     // Catch: Throwable -> L11
            SystemMediaRoute2Provider2.m5780$$Nest$monSessionOverrideUpdated(this.this$0, translatedSession);
            return;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.media.MediaRoute2ProviderServiceProxy.SystemMediaSessionCallback
        public void onRequestFailed(final long requestId, final int reason) {
            this.this$0.mHandler.post(new SystemMediaRoute2Provider2$SystemMediaSessionCallbackImpl$$ExternalSyntheticLambda2(this, requestId, reason));
        }

        private /* synthetic */ void lambda$onRequestFailed$1(long requestId, int reason) {
            if (this.mSessionRecord == null) goto L5;
            this.mSessionRecord.onRequestFailed(requestId, reason);
        L5:
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            SystemMediaRoute2Provider2.m5777$$Nest$fgetmPendingSessionCreations(this.this$0).remove(this.mRequestId);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            this.this$0.notifyRequestFailed(requestId, reason);
            return;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.media.MediaRoute2ProviderServiceProxy.SystemMediaSessionCallback
        public void onSessionReleased() {
            this.this$0.mHandler.post(new SystemMediaRoute2Provider2$SystemMediaSessionCallbackImpl$$ExternalSyntheticLambda0(this));
        }

        private /* synthetic */ void lambda$onSessionReleased$2() {
            if (this.mSessionRecord == null) goto L7;
            this.mSessionRecord.onSessionReleased();
            return;
        L7:
            throw new IllegalStateException();
        }
    }

    private class SystemMediaSessionRecord implements MediaRoute2ProviderServiceProxy.SystemMediaSessionCallback {
        private final String mOriginalId;
        private final String mProviderId;
        private RoutingSessionInfo mSourceSessionInfo;
        private RoutingSessionInfo mTranslatedSessionInfo;
        final /* synthetic */ SystemMediaRoute2Provider2 this$0;

        /* JADX INFO: renamed from: $r8$lambda$B-46izx6eQNj7SJmuwQQVpnsPiY, reason: not valid java name */
        public static /* synthetic */ String m5785$r8$lambda$B46izx6eQNj7SJmuwQQVpnsPiY(RoutingSessionInfo r0, String r1) {
            return lambda$asSystemProviderSession$2(r0, r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$KyKSxB0Ku4M1_q4Ry-XouAnbgMU, reason: not valid java name */
        public static /* synthetic */ String m5786$r8$lambda$KyKSxB0Ku4M1_q4RyXouAnbgMU(RoutingSessionInfo r0, String r1) {
            return lambda$asSystemProviderSession$3(r0, r1);
        }

        public static /* synthetic */ String $r8$lambda$W2dIP_AAv4iOZEbvOq9jwi3B_7M(RoutingSessionInfo r0, String r1) {
            return lambda$asSystemProviderSession$0(r0, r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$wHZ2qQbxsBrXSSmnjmOdA3-tDKI, reason: not valid java name */
        public static /* synthetic */ String m5787$r8$lambda$wHZ2qQbxsBrXSSmnjmOdA3tDKI(RoutingSessionInfo r0, String r1) {
            return lambda$asSystemProviderSession$1(r0, r1);
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmOriginalId, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m5788$$Nest$fgetmOriginalId(SystemMediaSessionRecord r0) {
            return r0.mOriginalId;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSourceSessionInfo, reason: not valid java name */
        static /* bridge */ /* synthetic */ RoutingSessionInfo m5789$$Nest$fgetmSourceSessionInfo(SystemMediaSessionRecord r0) {
            return r0.mSourceSessionInfo;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmTranslatedSessionInfo, reason: not valid java name */
        static /* bridge */ /* synthetic */ RoutingSessionInfo m5790$$Nest$fgetmTranslatedSessionInfo(SystemMediaSessionRecord r0) {
            return r0.mTranslatedSessionInfo;
        }

        /* JADX INFO: renamed from: -$$Nest$mremoveSelfFromSessionMaps, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5791$$Nest$mremoveSelfFromSessionMaps(SystemMediaSessionRecord r0) {
            r0.removeSelfFromSessionMaps();
        }

        SystemMediaSessionRecord(SystemMediaRoute2Provider2 r2, String providerId, RoutingSessionInfo sessionInfo) {
            this.this$0 = r2;
            this.mProviderId = providerId;
            this.mSourceSessionInfo = sessionInfo;
            this.mOriginalId = SystemMediaRoute2Provider2.m5781$$Nest$smasUniqueSystemId(sessionInfo.getProviderId(), sessionInfo.getOriginalId());
            this.mTranslatedSessionInfo = asSystemProviderSession(sessionInfo);
        }

        public String getServiceSessionId() {
            return this.mSourceSessionInfo.getOriginalId();
        }

        @Override // com.android.server.media.MediaRoute2ProviderServiceProxy.SystemMediaSessionCallback
        public void onSessionUpdate(RoutingSessionInfo sessionInfo) {
            RoutingSessionInfo translatedSessionInfo = asSystemProviderSession(sessionInfo);
            Object r1 = this.this$0.mLock;
            monitor-enter(r1);
            this.mSourceSessionInfo = sessionInfo;     // Catch: Throwable -> L8
            this.mTranslatedSessionInfo = translatedSessionInfo;     // Catch: Throwable -> L8
            monitor-exit(r1);     // Catch: Throwable -> L8
            SystemMediaRoute2Provider2.m5780$$Nest$monSessionOverrideUpdated(this.this$0, translatedSessionInfo);
            return;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.media.MediaRoute2ProviderServiceProxy.SystemMediaSessionCallback
        public void onRequestFailed(long requestId, int reason) {
            this.this$0.notifyRequestFailed(requestId, reason);
        }

        @Override // com.android.server.media.MediaRoute2ProviderServiceProxy.SystemMediaSessionCallback
        public void onSessionReleased() {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            removeSelfFromSessionMaps();     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            this.this$0.notifyGlobalSessionInfoUpdated();
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public ProviderProxyRecord getProxyRecord() {
            ProviderProxyRecord provider = (ProviderProxyRecord) SystemMediaRoute2Provider2.m5778$$Nest$fgetmProxyRecords(this.this$0).get(this.mProviderId);
            if (provider != null) goto L5;
            removeSelfFromSessionMaps();
        L5:
            return provider;
        }

        private void removeSelfFromSessionMaps() {
            SystemMediaRoute2Provider2.m5779$$Nest$fgetmSessionOriginalIdToSessionRecord(this.this$0).remove(this.mOriginalId);
            SystemMediaRoute2Provider2.m5776$$Nest$fgetmPackageNameToSessionRecord(this.this$0).remove(this.mSourceSessionInfo.getClientPackageName());
        }

        private RoutingSessionInfo asSystemProviderSession(final RoutingSessionInfo session) {
            final RoutingSessionInfo.Builder builder = new RoutingSessionInfo.Builder(session, this.mOriginalId).setProviderId(this.this$0.mUniqueId).setSystemSession(true).clearSelectedRoutes().clearSelectableRoutes().clearDeselectableRoutes().clearTransferableRoutes();
            Stream<R> r1 = session.getSelectedRoutes().stream().map(new SystemMediaRoute2Provider2$SystemMediaSessionRecord$$ExternalSyntheticLambda0(session));
            builder.getClass();
            r1.forEach(new SystemMediaRoute2Provider2$SystemMediaSessionRecord$$ExternalSyntheticLambda1(builder));
            Stream<R> r2 = session.getSelectableRoutes().stream().map(new SystemMediaRoute2Provider2$SystemMediaSessionRecord$$ExternalSyntheticLambda2(session));
            builder.getClass();
            r2.forEach(new SystemMediaRoute2Provider2$SystemMediaSessionRecord$$ExternalSyntheticLambda3(builder));
            Stream<R> r3 = session.getDeselectableRoutes().stream().map(new SystemMediaRoute2Provider2$SystemMediaSessionRecord$$ExternalSyntheticLambda4(session));
            builder.getClass();
            r3.forEach(new SystemMediaRoute2Provider2$SystemMediaSessionRecord$$ExternalSyntheticLambda5(builder));
            Stream<R> r4 = session.getTransferableRoutes().stream().map(new SystemMediaRoute2Provider2$SystemMediaSessionRecord$$ExternalSyntheticLambda6(session));
            builder.getClass();
            r4.forEach(new SystemMediaRoute2Provider2$$ExternalSyntheticLambda1(builder));
            return builder.build();
        }

        private static /* synthetic */ String lambda$asSystemProviderSession$0(RoutingSessionInfo session, String it) {
            return SystemMediaRoute2Provider2.m5782$$Nest$smuniqueIdAsSystemRouteId(session.getProviderId(), it);
        }

        private static /* synthetic */ String lambda$asSystemProviderSession$1(RoutingSessionInfo session, String it) {
            return SystemMediaRoute2Provider2.m5782$$Nest$smuniqueIdAsSystemRouteId(session.getProviderId(), it);
        }

        private static /* synthetic */ String lambda$asSystemProviderSession$2(RoutingSessionInfo session, String it) {
            return SystemMediaRoute2Provider2.m5782$$Nest$smuniqueIdAsSystemRouteId(session.getProviderId(), it);
        }

        private static /* synthetic */ String lambda$asSystemProviderSession$3(RoutingSessionInfo session, String it) {
            return SystemMediaRoute2Provider2.m5782$$Nest$smuniqueIdAsSystemRouteId(session.getProviderId(), it);
        }
    }

    public static /* synthetic */ void $r8$lambda$lw79SEdqVwBQKy9kaI56s6o5cFc(SystemMediaRoute2Provider2 r0, MediaRoute2ProviderInfo.Builder r1, String r2, MediaRoute2Info r3) {
        r0.lambda$updateProviderInfo$0(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageNameToSessionRecord, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m5776$$Nest$fgetmPackageNameToSessionRecord(SystemMediaRoute2Provider2 r0) {
        return r0.mPackageNameToSessionRecord;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPendingSessionCreations, reason: not valid java name */
    static /* bridge */ /* synthetic */ LongSparseArray m5777$$Nest$fgetmPendingSessionCreations(SystemMediaRoute2Provider2 r0) {
        return r0.mPendingSessionCreations;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmProxyRecords, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m5778$$Nest$fgetmProxyRecords(SystemMediaRoute2Provider2 r0) {
        return r0.mProxyRecords;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSessionOriginalIdToSessionRecord, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m5779$$Nest$fgetmSessionOriginalIdToSessionRecord(SystemMediaRoute2Provider2 r0) {
        return r0.mSessionOriginalIdToSessionRecord;
    }

    /* JADX INFO: renamed from: -$$Nest$monSessionOverrideUpdated, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5780$$Nest$monSessionOverrideUpdated(SystemMediaRoute2Provider2 r0, RoutingSessionInfo r1) {
        r0.onSessionOverrideUpdated(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smasUniqueSystemId, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m5781$$Nest$smasUniqueSystemId(String r0, String r1) {
        return asUniqueSystemId(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smuniqueIdAsSystemRouteId, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m5782$$Nest$smuniqueIdAsSystemRouteId(String r0, String r1) {
        return uniqueIdAsSystemRouteId(r0, r1);
    }

    static {
        COMPONENT_NAME = new ComponentName(SystemMediaRoute2Provider2.class.getPackage().getName(), SystemMediaRoute2Provider2.class.getName());
    }

    public static SystemMediaRoute2Provider2 create(Context context, UserHandle user, Looper looper) {
        SystemMediaRoute2Provider2 instance = new SystemMediaRoute2Provider2(context, user, looper);
        instance.updateProviderState();
        instance.updateSessionInfosIfNeeded();
        return instance;
    }

    private SystemMediaRoute2Provider2(Context context, UserHandle user, Looper looper) {
        super(context, COMPONENT_NAME, user, looper);
        this.mProxyRecords = new ArrayMap();
        this.mSessionOriginalIdToSessionRecord = new ArrayMap();
        this.mPackageNameToSessionRecord = new ArrayMap();
        this.mOriginalRouteIdToProviderId = new ArrayMap();
        this.mPendingSessionCreations = new LongSparseArray();
        this.mPackageManager = context.getPackageManager();
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @Override // com.android.server.media.SystemMediaRoute2Provider, com.android.server.media.MediaRoute2Provider
    public void transferToRoute(long requestId, UserHandle clientUserHandle, String clientPackageName, String sessionOriginalId, String routeOriginalId, int transferReason) {
        Object r11 = this.mLock;
        monitor-enter(r11);
        String clientPackageName2 = "";
        String targetProviderProxyId = this.mOriginalRouteIdToProviderId.get(routeOriginalId);     // Catch: Throwable -> L8
        ProviderProxyRecord targetProviderProxyRecord = this.mProxyRecords.get(targetProviderProxyId);     // Catch: Throwable -> L8
        if (targetProviderProxyRecord == null) goto L10;
        MediaRoute2Info r2 = targetProviderProxyRecord.getRouteByOriginalId(routeOriginalId);     // Catch: Throwable -> L8
    L11:
        MediaRoute2Info serviceTargetRoute = r2;
        SystemMediaSessionRecord existingSessionRecord = getSessionRecordByPackageName("");     // Catch: Throwable -> L8
        if (existingSessionRecord != null) goto L73;
        clientUserHandle = clientUserHandle;
    L39:
        if (serviceTargetRoute != null) goto L71;
        super.transferToRoute(requestId, clientUserHandle, "", sessionOriginalId, routeOriginalId, transferReason);     // Catch: Throwable -> L8
    L60:
        monitor-exit(r11);     // Catch: Throwable -> L8
        return;
    L71:
        boolean isGlobalSession = TextUtils.isEmpty("");     // Catch: Throwable -> L54
        if (isGlobalSession == false) goto L43;
        int uid = -1;
    L46:
        SystemMediaSessionCallbackImpl pendingCreationCallback = new SystemMediaSessionCallbackImpl(this, targetProviderProxyId, requestId, clientPackageName2, null);     // Catch: Throwable -> L54
        this.mPendingSessionCreations.put(requestId, pendingCreationCallback);     // Catch: Throwable -> L8
        targetProviderProxyRecord.requestCreateSystemMediaSession(requestId, uid, "", routeOriginalId, pendingCreationCallback);     // Catch: Throwable -> L52
    L52:
        th = th;
    L64:
        monitor-exit(r11);     // Catch: Throwable -> L8
        throw th;
    L43:
        int uid2 = fetchUid("", clientUserHandle);     // Catch: Throwable -> L54
        if (uid2 == (-1)) goto L58;
        uid = uid2;
        goto L46
    L58:
        throw new IllegalArgumentException("Cannot resolve transfer for  and " + clientUserHandle);     // Catch: Throwable -> L8
    L54:
        th = th;
        goto L64
    L73:
        RoutingSessionInfo existingSession = SystemMediaSessionRecord.m5789$$Nest$fgetmSourceSessionInfo(existingSessionRecord);     // Catch: Throwable -> L30
        if (targetProviderProxyId == null) goto L34;
        if (TextUtils.equals(targetProviderProxyId, existingSession.getProviderId()) == false) goto L34;
        if (serviceTargetRoute == null) goto L20;
        ProviderProxyRecord.m5784$$Nest$fgetmProxy(targetProviderProxyRecord).transferToRoute(requestId, clientUserHandle, "", existingSession.getOriginalId(), (String) ProviderProxyRecord.m5783$$Nest$fgetmNewOriginalIdToSourceOriginalIdMap(targetProviderProxyRecord).get(routeOriginalId), transferReason);     // Catch: Throwable -> L28
    L26:
        monitor-exit(r11);     // Catch: Throwable -> L8
        return;
    L28:
        th = th;
        goto L64
    L20:
        notifyRequestFailed(requestId, 3);     // Catch: Throwable -> L8
    L34:
        ProviderProxyRecord currentProxyRecord = existingSessionRecord.getProxyRecord();     // Catch: Throwable -> L8
        if (currentProxyRecord == null) goto L39;
        currentProxyRecord.releaseSession(requestId, existingSession.getOriginalId());     // Catch: Throwable -> L8
        SystemMediaSessionRecord.m5791$$Nest$mremoveSelfFromSessionMaps(existingSessionRecord);     // Catch: Throwable -> L8
    L30:
        th = th;
        goto L64
    L10:
        r2 = null;
    L8:
        th = th;
        goto L64
    }

    @Override // com.android.server.media.SystemMediaRoute2Provider
    public RoutingSessionInfo getSessionForPackage(String packageName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        RoutingSessionInfo systemSession = super.getSessionForPackage(packageName);     // Catch: Throwable -> L9
        if (systemSession != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L11:
        SystemMediaSessionRecord overridingSession = getSessionRecordByPackageName(packageName);     // Catch: Throwable -> L9
        if (overridingSession == null) goto L20;
        RoutingSessionInfo.Builder builder = new RoutingSessionInfo.Builder(SystemMediaSessionRecord.m5790$$Nest$fgetmTranslatedSessionInfo(overridingSession)).setProviderId(this.mUniqueId).setSystemSession(true);     // Catch: Throwable -> L9
        Iterator r4 = this.mLastSystemProviderInfo.getRoutes().iterator();     // Catch: Throwable -> L9
    L15:
        if (r4.hasNext() == false) goto L17;
        MediaRoute2Info systemRoute = (MediaRoute2Info) r4.next();     // Catch: Throwable -> L9
        builder.addTransferableRoute(systemRoute.getOriginalId());     // Catch: Throwable -> L9
        goto L15
    L17:
        RoutingSessionInfo r5 = builder.build();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r5;
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return systemSession;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.media.SystemMediaRoute2Provider, com.android.server.media.MediaRoute2Provider
    public void setRouteVolume(long requestId, String routeOriginalId, int volume) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        String targetProviderProxyId = this.mOriginalRouteIdToProviderId.get(routeOriginalId);     // Catch: Throwable -> L9
        ProviderProxyRecord targetProviderProxyRecord = this.mProxyRecords.get(targetProviderProxyId);     // Catch: Throwable -> L9
        if (targetProviderProxyRecord == null) goto L12;
        String serviceTargetRoute = (String) ProviderProxyRecord.m5783$$Nest$fgetmNewOriginalIdToSourceOriginalIdMap(targetProviderProxyRecord).get(routeOriginalId);     // Catch: Throwable -> L9
        if (serviceTargetRoute == null) goto L11;
        ProviderProxyRecord.m5784$$Nest$fgetmProxy(targetProviderProxyRecord).setRouteVolume(requestId, serviceTargetRoute, volume);     // Catch: Throwable -> L9
        goto L12
    L11:
        notifyRequestFailed(requestId, 3);     // Catch: Throwable -> L9
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        super.setRouteVolume(requestId, routeOriginalId, volume);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.media.SystemMediaRoute2Provider, com.android.server.media.MediaRoute2Provider
    public void setSessionVolume(long requestId, String sessionOriginalId, int volume) {
        if ("SYSTEM_SESSION".equals(sessionOriginalId) == false) goto L6;
        super.setSessionVolume(requestId, sessionOriginalId, volume);
        return;
    L6:
        Object r0 = this.mLock;
        monitor-enter(r0);
        SystemMediaSessionRecord sessionRecord = getSessionRecordByOriginalId(sessionOriginalId);     // Catch: Throwable -> L11
        if (sessionRecord == null) goto L13;
        ProviderProxyRecord proxyRecord = sessionRecord.getProxyRecord();     // Catch: Throwable -> L11
    L14:
        if (proxyRecord == null) goto L19;
        ProviderProxyRecord.m5784$$Nest$fgetmProxy(proxyRecord).setSessionVolume(requestId, sessionRecord.getServiceSessionId(), volume);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L11
        notifyRequestFailed(requestId, 3);
        return;
    L13:
        proxyRecord = null;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.media.SystemMediaRoute2Provider, com.android.server.media.MediaRoute2Provider
    public void selectRoute(long requestId, String sessionId, String routeId) {
        if ("SYSTEM_SESSION".equals(sessionId) == false) goto L6;
        super.selectRoute(requestId, sessionId, routeId);
        return;
    L6:
        Object r0 = this.mLock;
        monitor-enter(r0);
        SystemMediaSessionRecord sessionRecord = getSessionRecordByOriginalId(sessionId);     // Catch: Throwable -> L11
        if (sessionRecord == null) goto L13;
        ProviderProxyRecord proxyRecord = sessionRecord.getProxyRecord();     // Catch: Throwable -> L11
    L14:
        if (proxyRecord == null) goto L21;
        String targetSourceRouteId = (String) ProviderProxyRecord.m5783$$Nest$fgetmNewOriginalIdToSourceOriginalIdMap(proxyRecord).get(routeId);     // Catch: Throwable -> L11
        if (targetSourceRouteId == null) goto L18;
        ProviderProxyRecord.m5784$$Nest$fgetmProxy(proxyRecord).selectRoute(requestId, sessionRecord.getServiceSessionId(), targetSourceRouteId);     // Catch: Throwable -> L11
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L11
        notifyRequestFailed(requestId, 3);
        return;
    L13:
        proxyRecord = null;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.media.SystemMediaRoute2Provider, com.android.server.media.MediaRoute2Provider
    public void deselectRoute(long requestId, String sessionId, String routeId) {
        if ("SYSTEM_SESSION".equals(sessionId) == false) goto L6;
        super.selectRoute(requestId, sessionId, routeId);
        return;
    L6:
        Object r0 = this.mLock;
        monitor-enter(r0);
        SystemMediaSessionRecord sessionRecord = getSessionRecordByOriginalId(sessionId);     // Catch: Throwable -> L11
        if (sessionRecord == null) goto L13;
        ProviderProxyRecord proxyRecord = sessionRecord.getProxyRecord();     // Catch: Throwable -> L11
    L14:
        if (proxyRecord == null) goto L21;
        String targetSourceRouteId = (String) ProviderProxyRecord.m5783$$Nest$fgetmNewOriginalIdToSourceOriginalIdMap(proxyRecord).get(routeId);     // Catch: Throwable -> L11
        if (targetSourceRouteId == null) goto L18;
        ProviderProxyRecord.m5784$$Nest$fgetmProxy(proxyRecord).deselectRoute(requestId, sessionRecord.getServiceSessionId(), targetSourceRouteId);     // Catch: Throwable -> L11
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L11
        notifyRequestFailed(requestId, 3);
        return;
    L13:
        proxyRecord = null;
    L11:
        th = move-exception;
        throw th;
    }

    private SystemMediaSessionRecord getSessionRecordByOriginalId(String sessionOriginalId) {
        return getSessionRecordByPackageName("");
    }

    private SystemMediaSessionRecord getSessionRecordByPackageName(String clientPackageName) {
        return this.mPackageNameToSessionRecord.get("");
    }

    private int fetchUid(String clientPackageName, UserHandle clientUserHandle) {
        long token = Binder.clearCallingIdentity();
        int r2 = this.mPackageManager.getApplicationInfoAsUser(clientPackageName, 0, clientUserHandle).uid;     // Catch: Throwable -> L6 PackageManager.NameNotFoundException -> L8
        Binder.restoreCallingIdentity(token);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L12:
        Binder.restoreCallingIdentity(token);
        return -1;
    }

    @Override // com.android.server.media.SystemMediaRoute2Provider
    protected void onSystemSessionInfoUpdated() {
        updateSessionInfo();
    }

    @Override // com.android.server.media.SystemMediaRoute2Provider
    public void updateSystemMediaRoutesFromProxy(MediaRoute2ProviderServiceProxy serviceProxy) {
        ProviderProxyRecord proxyRecord = ProviderProxyRecord.createFor(serviceProxy);
        Object r1 = this.mLock;
        monitor-enter(r1);
        if (proxyRecord != null) goto L8;
        this.mProxyRecords.remove(serviceProxy.mUniqueId);     // Catch: Throwable -> L6
    L9:
        updateProviderInfo();     // Catch: Throwable -> L6
        monitor-exit(r1);     // Catch: Throwable -> L6
        updateSessionInfo();
        notifyProviderState();
        notifyGlobalSessionInfoUpdated();
        return;
    L8:
        this.mProxyRecords.put(serviceProxy.mUniqueId, proxyRecord);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.media.SystemMediaRoute2Provider
    public void onSystemProviderRoutesChanged(MediaRoute2ProviderInfo providerInfo) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mLastSystemProviderInfo = providerInfo;     // Catch: Throwable -> L8
        updateProviderInfo();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        updateSessionInfo();
        notifyGlobalSessionInfoUpdated();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void updateSessionInfo() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        SystemMediaSessionRecord globalSessionInfoRecord = getSessionRecordByPackageName("");     // Catch: Throwable -> L7
        if (globalSessionInfoRecord == null) goto L9;
        RoutingSessionInfo globalSessionInfo = SystemMediaSessionRecord.m5790$$Nest$fgetmTranslatedSessionInfo(globalSessionInfoRecord);     // Catch: Throwable -> L7
    L11:
        if (globalSessionInfo != null) goto L13;
        globalSessionInfo = this.mSystemSessionInfo;     // Catch: Throwable -> L7
    L13:
        if (globalSessionInfo != null) goto L16;
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L16:
        RoutingSessionInfo.Builder builder = new RoutingSessionInfo.Builder(globalSessionInfo);     // Catch: Throwable -> L7
        if (globalSessionInfo != this.mSystemSessionInfo) goto L19;
        this.mProxyRecords.values().stream().flatMap(new SystemMediaRoute2Provider2$$ExternalSyntheticLambda2()).map(new SystemMediaRoute2Provider2$$ExternalSyntheticLambda0()).forEach(new SystemMediaRoute2Provider2$$ExternalSyntheticLambda1(builder));     // Catch: Throwable -> L7
    L20:
        this.mSessionInfos.clear();     // Catch: Throwable -> L7
        this.mSessionInfos.add(builder.build());     // Catch: Throwable -> L7
        Iterator<SystemMediaSessionRecord> r4 = this.mPackageNameToSessionRecord.values().iterator();     // Catch: Throwable -> L7
    L22:
        if (r4.hasNext() == false) goto L24;
        SystemMediaSessionRecord sessionRecords = r4.next();     // Catch: Throwable -> L7
        this.mSessionInfos.add(SystemMediaSessionRecord.m5790$$Nest$fgetmTranslatedSessionInfo(sessionRecords));     // Catch: Throwable -> L7
        goto L22
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L19:
        this.mLastSystemProviderInfo.getRoutes().stream().map(new SystemMediaRoute2Provider2$$ExternalSyntheticLambda0()).forEach(new SystemMediaRoute2Provider2$$ExternalSyntheticLambda1(builder));     // Catch: Throwable -> L7
        goto L20
    L9:
        globalSessionInfo = null;
    L7:
        th = move-exception;
        throw th;
    }

    private void updateProviderInfo() {
        final MediaRoute2ProviderInfo.Builder builder = new MediaRoute2ProviderInfo.Builder(this.mLastSystemProviderInfo);
        this.mOriginalRouteIdToProviderId.clear();
        Iterator<ProviderProxyRecord> r1 = this.mProxyRecords.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ProviderProxyRecord proxyRecord = r1.next();
        final String proxyId = ProviderProxyRecord.m5784$$Nest$fgetmProxy(proxyRecord).mUniqueId;
        proxyRecord.getRoutesStream().forEach(new SystemMediaRoute2Provider2$$ExternalSyntheticLambda3(this, builder, proxyId));
        goto L4
    L6:
        setProviderState(builder.build());
    }

    private /* synthetic */ void lambda$updateProviderInfo$0(MediaRoute2ProviderInfo.Builder builder, String proxyId, MediaRoute2Info route) {
        builder.addRoute(route);
        this.mOriginalRouteIdToProviderId.put(route.getOriginalId(), proxyId);
    }

    @Override // com.android.server.media.SystemMediaRoute2Provider
    void notifyGlobalSessionInfoUpdated() {
        if (this.mCallback != null) goto L5;
        return;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L8:
        if (this.mSessionInfos.isEmpty() == false) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L13:
        Set<String> packageNamesWithRoutingSessionOverrides = this.mPackageNameToSessionRecord.keySet();     // Catch: Throwable -> L11
        RoutingSessionInfo sessionInfo = (RoutingSessionInfo) this.mSessionInfos.getFirst();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        this.mCallback.onSessionUpdated(this, sessionInfo, packageNamesWithRoutingSessionOverrides);
    }

    private void onSessionOverrideUpdated(RoutingSessionInfo sessionInfo) {
        RoutingSessionInfo.Builder builder = new RoutingSessionInfo.Builder(sessionInfo);
        this.mLastSystemProviderInfo.getRoutes().stream().map(new SystemMediaRoute2Provider2$$ExternalSyntheticLambda0()).forEach(new SystemMediaRoute2Provider2$$ExternalSyntheticLambda1(builder));
        this.mCallback.onSessionUpdated(this, builder.build(), Set.of());
    }

    private static String uniqueIdAsSystemRouteId(String providerId, String uniqueRouteId) {
        return asUniqueSystemId(providerId, MediaRouter2Utils.getOriginalId(uniqueRouteId));
    }

    private static String asUniqueSystemId(String providerId, String originalId) {
        return "SYSTEM-" + providerId + UNIQUE_SYSTEM_ID_SEPARATOR + originalId;
    }
}
