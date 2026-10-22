package com.bytedance.android.livesdk.utils;

import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class x4 implements NsdManager.DiscoveryListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MdnsServiceManager.b f159208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f159209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f159210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ NsdManager f159211d;

    public static final class a implements NsdManager.ResolveListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x4 f159212a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f159213b;

        @Override // android.net.nsd.NsdManager.ResolveListener
        public final void onServiceResolved(NsdServiceInfo r100) {
            StringBuilder r101 = new StringBuilder("onServiceResolved serviceInfo:");
            if (r100 == null) goto L5;
            String r102 = r100.toString();
        L6:
            r101.append(r102);
            String r103 = r101.toString();
            ALogger.i("MdnsServiceManager", r103);
            if (r100 == null) goto L12;
            this.f159212a.f159208a.e(r100, null);
            MdnsServiceManager.d r104 = MdnsServiceManager.f158766b.get(this.f159212a.f159209b);
            if (r104 == null) goto L13;
            r104.f158770c = 3;
            Intrinsics.checkNotNullParameter(r103, "<set-?>");
            r104.f158768a = r103;
            return;
        L13:
            return;
        L12:
            return;
        L5:
            r102 = null;
            goto L6
        }

        public a(x4 r100, String r101) {
            this.f159212a = r100;
            this.f159213b = r101;
        }

        @Override // android.net.nsd.NsdManager.ResolveListener
        public final void onResolveFailed(NsdServiceInfo r100, int r101) {
            String r102 = "ResolveFailed serviceInfo:" + r100 + " errorCode:" + r101;
            this.f159212a.f159208a.e(r100, new MdnsServiceManager.a(this.f159213b));
            MdnsServiceManager.d r103 = MdnsServiceManager.f158766b.get(this.f159212a.f159209b);
            if (r103 == null) goto L5;
            r103.f158769b = r101;
            Intrinsics.checkNotNullParameter(r102, "<set-?>");
            r103.f158768a = r102;
        L5:
            ALogger.e("MdnsServiceManager", r102);
        }
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public final void onDiscoveryStarted(String r100) {
        String r101 = "onDiscoveryStarted serviceType:" + r100;
        this.f159208a.d(r100);
        ALogger.i("MdnsServiceManager", r101);
        MdnsServiceManager.d r102 = MdnsServiceManager.f158766b.get(r100);
        if (r102 == null) goto L6;
        r102.f158770c = 1;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r102.f158768a = r101;
        return;
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public final void onDiscoveryStopped(String r100) {
        ALogger.e("MdnsServiceManager", "onDiscoveryStopped serviceType:" + r100);
        this.f159208a.c(r100);
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public final void onServiceFound(NsdServiceInfo r100) {
        StringBuilder r101 = new StringBuilder("onServiceFound serviceInfo:");
        if (r100 == null) goto L5;
        String r102 = r100.getServiceName();
    L6:
        r101.append(r102);
        r101.append(", ");
        if (r100 == null) goto L9;
        String r103 = r100.getServiceType();
    L10:
        r101.append(r103);
        String r104 = r101.toString();
        ALogger.i("MdnsServiceManager", r104);
        MdnsServiceManager.d r105 = MdnsServiceManager.f158766b.get(this.f159209b);
        if (r105 != null) goto L13;
    L15:
        if (r100 == null) goto L22;
        String r106 = r100.getServiceName();
        if (r106 != null) goto L19;
        return;
    L19:
        if (StringsKt.contains$default(r106, this.f159210c, false, 2, null) != true) goto L24;
        this.f159211d.resolveService(r100, new a(this, r104));
        return;
    L24:
        return;
    L22:
        return;
    L13:
        if (r105.f158770c >= 2) goto L15;
        r105.f158770c = 2;
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r105.f158768a = r104;
        goto L15
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public final void onServiceLost(NsdServiceInfo r100) {
        ALogger.e("MdnsServiceManager", "onServiceLost serviceInfo:" + r100);
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public final void onStartDiscoveryFailed(String r100, int r101) {
        String r102 = "StartDiscoveryFailed serviceType:" + r100 + " errorCode:" + r101;
        this.f159208a.f(r102);
        MdnsServiceManager.d r103 = MdnsServiceManager.f158766b.get(r100);
        if (r103 == null) goto L5;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r103.f158768a = r102;
        r103.f158770c = r101;
    L5:
        ALogger.e("MdnsServiceManager", r102);
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public final void onStopDiscoveryFailed(String r100, int r101) {
        String r102 = "StopDiscoveryFailed serviceType:" + r100 + " errorCode:" + r101;
        this.f159208a.e(null, new MdnsServiceManager.a(r102));
        MdnsServiceManager.d r103 = MdnsServiceManager.f158766b.get(r100);
        if (r103 == null) goto L5;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r103.f158768a = r102;
        r103.f158770c = r101;
    L5:
        ALogger.e("MdnsServiceManager", r102);
    }

    public x4(com.bytedance.android.live.browser.jsbridge.newmethods.a7 r100, String r101, String r102, NsdManager r103) {
        this.f159208a = r100;
        this.f159209b = r101;
        this.f159210c = r102;
        this.f159211d = r103;
    }
}
