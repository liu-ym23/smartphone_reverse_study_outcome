package com.android.server.media;

import android.content.ComponentName;
import android.media.MediaRoute2Info;
import android.media.MediaRoute2ProviderInfo;
import android.media.RouteDiscoveryPreference;
import android.media.RoutingSessionInfo;
import android.os.Bundle;
import android.os.UserHandle;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes2.dex */
abstract class MediaRoute2Provider {
    Callback mCallback;
    final ComponentName mComponentName;
    public final boolean mIsSystemRouteProvider;
    final Object mLock;
    private volatile MediaRoute2ProviderInfo mProviderInfo;
    final List<RoutingSessionInfo> mSessionInfos;
    final String mUniqueId;

    public interface Callback {
        void onProviderStateChanged(MediaRoute2Provider r1);

        void onRequestFailed(MediaRoute2Provider r1, long r2, int r4);

        void onSessionCreated(MediaRoute2Provider r1, long r2, RoutingSessionInfo r4);

        void onSessionReleased(MediaRoute2Provider r1, RoutingSessionInfo r2);

        void onSessionUpdated(MediaRoute2Provider r1, RoutingSessionInfo r2, Set<String> r3);
    }

    protected static class SessionCreationOrTransferRequest {
        public final long mRequestId;
        public final String mTargetOriginalRouteId;
        public final String mTransferInitiatorPackageName;
        public final UserHandle mTransferInitiatorUserHandle;
        public final int mTransferReason;

        SessionCreationOrTransferRequest(long requestId, String targetOriginalRouteId, int transferReason, UserHandle transferInitiatorUserHandle, String transferInitiatorPackageName) {
            this.mRequestId = requestId;
            this.mTargetOriginalRouteId = targetOriginalRouteId;
            this.mTransferReason = transferReason;
            this.mTransferInitiatorUserHandle = transferInitiatorUserHandle;
            this.mTransferInitiatorPackageName = transferInitiatorPackageName;
        }

        public boolean isTargetRoute(MediaRoute2Info route2Info) {
            if (route2Info != null) goto L4;
        L6:
            return false;
        L4:
            if (this.mTargetOriginalRouteId.equals(route2Info.getOriginalId()) == false) goto L6;
            return true;
        }

        public boolean isTargetRouteIdInRouteOriginalIdList(List<String> originalRouteIdList) {
            Stream<String> r0 = originalRouteIdList.stream();
            String r1 = this.mTargetOriginalRouteId;
            r1.getClass();
            return r0.anyMatch(new MediaRoute2Provider$SessionCreationOrTransferRequest$$ExternalSyntheticLambda1(r1));
        }

        public boolean isTargetRouteIdInRouteUniqueIdList(List<String> uniqueRouteIdList) {
            Stream<R> r0 = uniqueRouteIdList.stream().map(new MediaRoute2Provider$SessionCreationOrTransferRequest$$ExternalSyntheticLambda0());
            String r1 = this.mTargetOriginalRouteId;
            r1.getClass();
            return r0.anyMatch(new MediaRoute2Provider$SessionCreationOrTransferRequest$$ExternalSyntheticLambda1(r1));
        }
    }

    public abstract void deselectRoute(long r1, String r3, String r4);

    protected abstract String getDebugString();

    public abstract void prepareReleaseSession(String r1);

    public abstract void releaseSession(long r1, String r3);

    public abstract void requestCreateSession(long r1, String r3, String r4, Bundle r5, int r6, UserHandle r7, String r8);

    public abstract void selectRoute(long r1, String r3, String r4);

    public abstract void setRouteVolume(long r1, String r3, int r4);

    public abstract void setSessionVolume(long r1, String r3, int r4);

    public abstract void transferToRoute(long r1, UserHandle r3, String r4, String r5, String r6, int r7);

    public abstract void updateDiscoveryPreference(Set<String> r1, RouteDiscoveryPreference r2);

    MediaRoute2Provider(ComponentName componentName, boolean isSystemRouteProvider) {
        this.mLock = new Object();
        this.mSessionInfos = new ArrayList();
        componentName.getClass();
        this.mComponentName = componentName;
        this.mUniqueId = componentName.flattenToShortString();
        this.mIsSystemRouteProvider = isSystemRouteProvider;
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public String getUniqueId() {
        return this.mUniqueId;
    }

    public MediaRoute2ProviderInfo getProviderInfo() {
        return this.mProviderInfo;
    }

    public List<RoutingSessionInfo> getSessionInfos() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(this.mSessionInfos);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void setProviderState(MediaRoute2ProviderInfo providerInfo) {
        if (providerInfo != null) goto L4;
        this.mProviderInfo = null;
        return;
    L4:
        this.mProviderInfo = new MediaRoute2ProviderInfo.Builder(providerInfo).setUniqueId(this.mComponentName.getPackageName(), this.mUniqueId).setSystemRouteProvider(this.mIsSystemRouteProvider).build();
    }

    void notifyProviderState() {
        if (this.mCallback == null) goto L6;
        this.mCallback.onProviderStateChanged(this);
        return;
    }

    protected void notifyRequestFailed(long requestId, int reason) {
        if (this.mCallback == null) goto L6;
        this.mCallback.onRequestFailed(this, requestId, reason);
        return;
    }

    void setAndNotifyProviderState(MediaRoute2ProviderInfo providerInfo) {
        setProviderState(providerInfo);
        notifyProviderState();
    }

    public boolean hasComponentName(String packageName, String className) {
        if (this.mComponentName.getPackageName().equals(packageName) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mComponentName.getClassName().equals(className) == false) goto L7;
        return true;
    }

    public void dump(PrintWriter pw, String prefix) {
        pw.println(prefix + getDebugString());
        String prefix2 = prefix + "  ";
        if (this.mProviderInfo != null) goto L6;
        pw.println(prefix2 + "<provider info not received, yet>");
    L12:
        pw.println(prefix2 + "Active routing sessions:");
        Object r0 = this.mLock;
        monitor-enter(r0);
    L17:
        th = move-exception;
        throw th;
    L15:
        if (this.mSessionInfos.isEmpty() == false) goto L19;
        pw.println(prefix2 + "  <no active routing sessions>");     // Catch: Throwable -> L17
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L19:
        Iterator<RoutingSessionInfo> r1 = this.mSessionInfos.iterator();     // Catch: Throwable -> L17
    L21:
        if (r1.hasNext() == false) goto L23;
        RoutingSessionInfo routingSessionInfo = r1.next();     // Catch: Throwable -> L17
        routingSessionInfo.dump(pw, prefix2 + "  ");     // Catch: Throwable -> L17
        goto L21
    L6:
        if (this.mProviderInfo.getRoutes().isEmpty() == false) goto L8;
        pw.println(prefix2 + "<provider info has no routes>");
        goto L12
    L8:
        Iterator r2 = this.mProviderInfo.getRoutes().iterator();
    L10:
        if (r2.hasNext() == false) goto L12;
        MediaRoute2Info route = (MediaRoute2Info) r2.next();
        pw.printf("%s%s | %s\n", new Object[]{prefix2, route.getId(), route.getName()});
        goto L10
    }

    public String toString() {
        return getDebugString();
    }
}
