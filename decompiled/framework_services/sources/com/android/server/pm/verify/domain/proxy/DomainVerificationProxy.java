package com.android.server.pm.verify.domain.proxy;

import android.content.ComponentName;
import android.content.Context;
import com.android.server.DeviceIdleInternal;
import com.android.server.pm.verify.domain.DomainVerificationCollector;
import com.android.server.pm.verify.domain.DomainVerificationManagerInternal;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public interface DomainVerificationProxy {
    public static final boolean DEBUG_PROXIES = false;
    public static final String TAG = "DomainVerificationProxy";

    public interface BaseConnection {
        DeviceIdleInternal getDeviceIdleInternal();

        long getPowerSaveTempWhitelistAppDuration();

        boolean isCallerPackage(int r1, String r2);

        void schedule(int r1, Object r2);
    }

    ComponentName getComponentName();

    boolean isCallerVerifier(int r1);

    boolean runMessage(int r1, Object r2);

    void sendBroadcastForPackages(Set<String> r1);

    static <ConnectionType extends DomainVerificationProxyV1.Connection & DomainVerificationProxyV2.Connection> DomainVerificationProxy makeProxy(ComponentName componentV1, ComponentName componentV2, Context context, DomainVerificationManagerInternal manager, DomainVerificationCollector collector, ConnectionType connection) {
        if (componentV2 == null) goto L7;
        if (componentV1 == null) goto L7;
        if (Objects.equals(componentV2.getPackageName(), componentV1.getPackageName()) == true) goto L7;
        ComponentName componentV3 = null;
    L8:
        DomainVerificationProxy proxyV1 = null;
        DomainVerificationProxy proxyV2 = null;
        if (componentV3 == null) goto L11;
        Context context2 = context;
        ConnectionType connection2 = connection;
        proxyV1 = new DomainVerificationProxyV1(context2, manager, collector, connection2, componentV3);
    L12:
        if (componentV2 == null) goto L14;
        proxyV2 = new DomainVerificationProxyV2(context2, connection2, componentV2);
    L14:
        if (proxyV1 == null) goto L18;
        if (proxyV2 == null) goto L18;
        return new DomainVerificationProxyCombined(proxyV1, proxyV2);
    L18:
        if (proxyV1 == null) goto L20;
        return proxyV1;
    L20:
        if (proxyV2 == null) goto L23;
        return proxyV2;
    L23:
        return new DomainVerificationProxyUnavailable();
    L11:
        context2 = context;
        connection2 = connection;
    L7:
        componentV3 = componentV1;
        goto L8
    }
}
