package com.stepos.statsapp.v3.lib.plugin.emitter.remote;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsCallback;
import com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsInterface;
import com.stepos.statsapp.v3.lib.plugin.emitter.EmitterConfig;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import g3.C0742e;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: e, reason: collision with root package name */
    private static boolean f15912e = false;

    /* renamed from: a, reason: collision with root package name */
    private ServiceInfo f15913a;

    /* renamed from: b, reason: collision with root package name */
    private IVccOfflineStatsInterface f15914b;

    /* renamed from: c, reason: collision with root package name */
    private final d f15915c;

    /* renamed from: d, reason: collision with root package name */
    private b f15916d;

    public interface b {
        void a();

        void b(ServiceConnection serviceConnection);
    }

    private static class c {

        /* renamed from: a, reason: collision with root package name */
        private static final g f15917a = new g();
    }

    private class d implements ServiceConnection {
        private d() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                C0742e.c("V3RemoteServiceReq", "onServiceConnected, " + iBinder);
                g.this.f15914b = IVccOfflineStatsInterface.Stub.asInterface(iBinder);
                if (g.this.f15916d != null) {
                    g.this.f15916d.a();
                }
            } catch (Exception e6) {
                C0742e.d("V3RemoteServiceReq", "Exception onServiceConnected:" + e6.toString() + " - Cause:" + e6.getCause());
            }
            synchronized (g.this.f15915c) {
                g.this.f15915c.notifyAll();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            C0742e.c("V3RemoteServiceReq", "onServiceDisconnected, " + componentName);
            g.this.f15914b = null;
            if (g.this.f15916d != null) {
                g.this.f15916d.b(this);
            }
        }
    }

    public static g c() {
        return c.f15917a;
    }

    private void d(Context context) {
        boolean zBindService;
        if (this.f15913a == null) {
            C0742e.i("V3RemoteServiceReq", "offline service is null,unable to bind");
            return;
        }
        synchronized (this.f15915c) {
            Intent intent = new Intent();
            intent.setAction("com.stepos.dataservice.action.vccOfflineStats");
            intent.setPackage(this.f15913a.packageName);
            ServiceInfo serviceInfo = this.f15913a;
            intent.setComponent(new ComponentName(serviceInfo.packageName, serviceInfo.name));
            try {
                zBindService = context.bindService(intent, this.f15915c, 33);
                C0742e.c("V3RemoteServiceReq", "bindService, " + this.f15915c + " result: " + zBindService);
            } catch (Exception e6) {
                C0742e.d("V3RemoteServiceReq", "Exception:" + e6 + " - Cause:" + e6.getCause());
            }
            if (zBindService) {
                this.f15915c.wait(3000L);
                C0742e.c("V3RemoteServiceReq", "serviceConn wait END");
            }
        }
    }

    private boolean m(Context context) {
        if (this.f15913a == null) {
            C0742e.l("V3RemoteServiceReq", "checkRemoteInterface, remote service is null, reinitialize");
            e(context, null);
        }
        if (this.f15913a == null) {
            C0742e.d("V3RemoteServiceReq", "checkRemoteInterface fail, unable get remote service");
            return false;
        }
        if (this.f15914b == null) {
            C0742e.l("V3RemoteServiceReq", "checkRemoteInterface, remote interface is null, rebind service");
            d(context);
        }
        if (this.f15914b != null) {
            return true;
        }
        C0742e.d("V3RemoteServiceReq", "checkRemoteInterface fail, unable get remote interface");
        return false;
    }

    public void e(Context context, b bVar) {
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(new Intent("com.stepos.dataservice.action.vccOfflineStats"), 64);
        C0742e.c("V3RemoteServiceReq", "queryIntentServices for ACTION_VCC_OFFLINE_STATS: " + listQueryIntentServices);
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
                C0742e.c("V3RemoteServiceReq", "choose serviceName---" + str2 + " pkgName---" + str);
                this.f15913a = next.serviceInfo;
                break;
            }
        }
        if (bVar != null) {
            this.f15916d = bVar;
        }
    }

    public void f(Context context, String str, IVccOfflineStatsCallback iVccOfflineStatsCallback) {
        if (m(context)) {
            try {
                this.f15914b.setCallback(str, iVccOfflineStatsCallback);
            } catch (Throwable th) {
                C0742e.d("V3RemoteServiceReq", "setCallback error, " + th.getMessage());
            }
        }
    }

    public boolean g(Context context, String str, EmitterConfig emitterConfig) {
        if (f15912e) {
            return true;
        }
        if (!m(context)) {
            return false;
        }
        try {
            f15912e = true;
            this.f15914b.emitterUpdateConfig(str, emitterConfig);
            return true;
        } catch (Throwable th) {
            C0742e.d("V3RemoteServiceReq", "emitterUpdateConfig error, " + th.getMessage());
            return false;
        }
    }

    public boolean h(Context context, String str, String str2) {
        if (!m(context)) {
            return false;
        }
        try {
            this.f15914b.emitterUpdateEventSource(str, str2);
            return true;
        } catch (Throwable th) {
            C0742e.d("V3RemoteServiceReq", "emitterUpdateEventSource error, " + th.getMessage());
            return false;
        }
    }

    boolean i(Context context, String str, String str2, String str3, long j5, TrackerPayload trackerPayload) {
        if (!m(context)) {
            return false;
        }
        try {
            this.f15914b.emitterAddEvent(str, str2, str3, j5, trackerPayload);
            return true;
        } catch (Throwable th) {
            C0742e.d("V3RemoteServiceReq", "emitterAddEvent error, " + th.getMessage());
            return false;
        }
    }

    public boolean j(Context context, String str, String str2, String str3, List<Long> list, List<TrackerPayload> list2) {
        if (!m(context)) {
            return false;
        }
        try {
            this.f15914b.emitterBulkAddEvents(str, str2, str3, list, list2);
            return true;
        } catch (Throwable th) {
            C0742e.d("V3RemoteServiceReq", "emitterBulkAddEvents error: " + th.getMessage());
            return false;
        }
    }

    public String l(Context context, String str) {
        if (!m(context)) {
            return null;
        }
        try {
            return this.f15914b.requestAppConfig(str);
        } catch (Throwable th) {
            C0742e.d("V3RemoteServiceReq", "requestAppConfig error, " + th.getMessage());
            return null;
        }
    }

    private g() {
        this.f15915c = new d();
    }
}
