package com.stepos.statsapp.v3.lib.plugin.emitter.remote;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import com.stepos.alphame.bluetooth.VehicleBluetoothManager;
import com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsInterface;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: e, reason: collision with root package name */
    public static boolean f12336e = false;

    /* renamed from: a, reason: collision with root package name */
    public ServiceInfo f12337a;

    /* renamed from: b, reason: collision with root package name */
    public IVccOfflineStatsInterface f12338b;

    /* renamed from: c, reason: collision with root package name */
    public final h f12339c = new h(this);

    /* renamed from: d, reason: collision with root package name */
    public f f12340d;

    public final void a(Context context, f fVar) {
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(new Intent("com.stepos.dataservice.action.vccOfflineStats"), 64);
        T2.d.a("V3RemoteServiceReq", "queryIntentServices for ACTION_VCC_OFFLINE_STATS: " + listQueryIntentServices);
        Iterator<ResolveInfo> it = listQueryIntentServices.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ResolveInfo next = it.next();
            ServiceInfo serviceInfo = next.serviceInfo;
            String str = serviceInfo.packageName;
            String str2 = serviceInfo.name;
            if ("com.stepos.dataservice".equals(str)) {
                T2.d.a("V3RemoteServiceReq", "choose serviceName---" + str2 + " pkgName---" + str);
                this.f12337a = next.serviceInfo;
                break;
            }
        }
        if (fVar != null) {
            this.f12340d = fVar;
        }
    }

    public final void b(Context context, String str, String str2, String str3, List list, List list2) {
        if (c(context)) {
            try {
                this.f12338b.emitterBulkAddEvents(str, str2, str3, list, list2);
            } catch (Throwable th) {
                T2.d.b("V3RemoteServiceReq", "emitterBulkAddEvents error: " + th.getMessage());
            }
        }
    }

    public final boolean c(Context context) {
        if (this.f12337a == null) {
            T2.d.f("V3RemoteServiceReq", "checkRemoteInterface, remote service is null, reinitialize");
            a(context, null);
        }
        if (this.f12337a == null) {
            T2.d.b("V3RemoteServiceReq", "checkRemoteInterface fail, unable get remote service");
            return false;
        }
        if (this.f12338b == null) {
            T2.d.f("V3RemoteServiceReq", "checkRemoteInterface, remote interface is null, rebind service");
            if (this.f12337a == null) {
                T2.d.d("V3RemoteServiceReq", "offline service is null,unable to bind");
            } else {
                synchronized (this.f12339c) {
                    Intent intent = new Intent();
                    intent.setAction("com.stepos.dataservice.action.vccOfflineStats");
                    intent.setPackage(this.f12337a.packageName);
                    ServiceInfo serviceInfo = this.f12337a;
                    intent.setComponent(new ComponentName(serviceInfo.packageName, serviceInfo.name));
                    try {
                        boolean zBindService = context.bindService(intent, this.f12339c, 1);
                        T2.d.a("V3RemoteServiceReq", "bindService, " + this.f12339c + " result: " + zBindService);
                        if (zBindService) {
                            this.f12339c.wait(VehicleBluetoothManager.MIN_CONNECT_DISTANCE);
                            T2.d.a("V3RemoteServiceReq", "serviceConn wait END");
                        }
                    } catch (Exception e4) {
                        T2.d.b("V3RemoteServiceReq", "Exception:" + e4 + " - Cause:" + e4.getCause());
                    }
                }
            }
        }
        if (this.f12338b != null) {
            return true;
        }
        T2.d.b("V3RemoteServiceReq", "checkRemoteInterface fail, unable get remote interface");
        return false;
    }
}
