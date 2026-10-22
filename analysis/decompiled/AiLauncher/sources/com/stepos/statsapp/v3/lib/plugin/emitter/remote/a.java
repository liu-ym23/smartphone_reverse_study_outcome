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
import com.stepos.statsapp.v3.lib.plugin.utils.StepOSUtils;
import com.stepos.statsapp.v3.utils.log.Logger;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name */
    private static final String f30761e = "V3RemoteServiceReq";

    /* renamed from: f, reason: collision with root package name */
    private static final long f30762f = 3000;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f30763g = false;

    /* renamed from: a, reason: collision with root package name */
    private ServiceInfo f30764a;

    /* renamed from: b, reason: collision with root package name */
    private IVccOfflineStatsInterface f30765b;

    /* renamed from: c, reason: collision with root package name */
    private final d f30766c;

    /* renamed from: d, reason: collision with root package name */
    private b f30767d;

    public interface b {
        void a();

        void a(ServiceConnection serviceConnection);
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private static final a f30768a = new a();

        private c() {
        }
    }

    public class d implements ServiceConnection {
        private d() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                Logger.d(a.f30761e, "onServiceConnected, " + iBinder);
                a.this.f30765b = IVccOfflineStatsInterface.Stub.asInterface(iBinder);
                if (a.this.f30767d != null) {
                    a.this.f30767d.a();
                }
            } catch (Exception e10) {
                Logger.e(a.f30761e, "Exception onServiceConnected:" + e10.toString() + " - Cause:" + e10.getCause());
            }
            synchronized (a.this.f30766c) {
                a.this.f30766c.notifyAll();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Logger.d(a.f30761e, "onServiceDisconnected, " + componentName);
            a.this.f30765b = null;
            if (a.this.f30767d != null) {
                a.this.f30767d.a(this);
            }
        }
    }

    private a() {
        this.f30766c = new d();
    }

    private boolean b(Context context) {
        if (this.f30764a == null) {
            Logger.w(f30761e, "checkRemoteInterface, remote service is null, reinitialize");
            a(context, (b) null);
        }
        if (this.f30764a == null) {
            Logger.e(f30761e, "checkRemoteInterface fail, unable get remote service");
            return false;
        }
        if (this.f30765b == null) {
            Logger.w(f30761e, "checkRemoteInterface, remote interface is null, rebind service");
            a(context);
        }
        if (this.f30765b != null) {
            return true;
        }
        Logger.e(f30761e, "checkRemoteInterface fail, unable get remote interface");
        return false;
    }

    public static a a() {
        return c.f30768a;
    }

    public void a(Context context, b bVar) {
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(new Intent(StepOSUtils.ACTION_VCC_OFFLINE_STATS_PHONE), 64);
        Logger.d(f30761e, "queryIntentServices for ACTION_VCC_OFFLINE_STATS: " + listQueryIntentServices);
        Iterator<ResolveInfo> it = listQueryIntentServices.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ResolveInfo next = it.next();
            ServiceInfo serviceInfo = next.serviceInfo;
            String str = serviceInfo.packageName;
            String str2 = serviceInfo.name;
            if (StepOSUtils.DATASERVICE_PACKAGENAME_PHONE.equals(str)) {
                Logger.d(f30761e, "choose serviceName---" + str2 + " pkgName---" + str);
                this.f30764a = next.serviceInfo;
                break;
            }
        }
        if (bVar != null) {
            this.f30767d = bVar;
        }
    }

    public boolean b(Context context, String str, String str2, String str3, long j10, TrackerPayload trackerPayload) {
        if (!b(context)) {
            return false;
        }
        try {
            this.f30765b.emitterAddEventRealtime(str, str2, str3, j10, trackerPayload);
            return true;
        } catch (Throwable th) {
            Logger.e(f30761e, "emitterAddEvent error, " + th.getMessage());
            return false;
        }
    }

    public boolean a(Context context, String str, String str2, String str3, long j10, TrackerPayload trackerPayload) {
        if (!b(context)) {
            return false;
        }
        try {
            this.f30765b.emitterAddEvent(str, str2, str3, j10, trackerPayload);
            return true;
        } catch (Throwable th) {
            Logger.e(f30761e, "emitterAddEvent error, " + th.getMessage());
            return false;
        }
    }

    public String b(Context context, String str) {
        if (!b(context)) {
            return null;
        }
        try {
            return this.f30765b.requestAppConfig(str);
        } catch (Throwable th) {
            Logger.e(f30761e, "requestAppConfig error, " + th.getMessage());
            return null;
        }
    }

    public boolean a(Context context, String str, String str2, String str3, List<Long> list, List<TrackerPayload> list2) {
        if (!b(context)) {
            return false;
        }
        try {
            this.f30765b.emitterBulkAddEvents(str, str2, str3, list, list2);
            return true;
        } catch (Throwable th) {
            Logger.e(f30761e, "emitterBulkAddEvents error: " + th.getMessage());
            return false;
        }
    }

    public boolean a(Context context, String str, EmitterConfig emitterConfig) {
        if (f30763g) {
            return true;
        }
        if (!b(context)) {
            return false;
        }
        try {
            f30763g = true;
            this.f30765b.emitterUpdateConfig(str, emitterConfig);
            return true;
        } catch (Throwable th) {
            Logger.e(f30761e, "emitterUpdateConfig error, " + th.getMessage());
            return false;
        }
    }

    public String a(Context context, String str) {
        if (!b(context)) {
            return null;
        }
        try {
            return this.f30765b.emitterGetUmid(str);
        } catch (Throwable th) {
            Logger.e(f30761e, "emitterGetUmid error, " + th.getMessage());
            return null;
        }
    }

    public boolean a(Context context, String str, String str2) {
        if (!b(context)) {
            return false;
        }
        try {
            this.f30765b.emitterUpdateEventSource(str, str2);
            return true;
        } catch (Throwable th) {
            Logger.e(f30761e, "emitterUpdateEventSource error, " + th.getMessage());
            return false;
        }
    }

    public void a(Context context, String str, IVccOfflineStatsCallback iVccOfflineStatsCallback) {
        if (b(context)) {
            try {
                this.f30765b.setCallback(str, iVccOfflineStatsCallback);
            } catch (Throwable th) {
                Logger.e(f30761e, "setCallback error, " + th.getMessage());
            }
        }
    }

    private void a(Context context) {
        boolean zBindService;
        if (this.f30764a == null) {
            Logger.i(f30761e, "offline service is null,unable to bind");
            return;
        }
        synchronized (this.f30766c) {
            Intent intent = new Intent();
            intent.setAction(StepOSUtils.ACTION_VCC_OFFLINE_STATS_PHONE);
            intent.setPackage(this.f30764a.packageName);
            ServiceInfo serviceInfo = this.f30764a;
            intent.setComponent(new ComponentName(serviceInfo.packageName, serviceInfo.name));
            try {
                zBindService = context.bindService(intent, this.f30766c, 33);
                Logger.d(f30761e, "bindService, " + this.f30766c + " result: " + zBindService);
            } catch (Exception e10) {
                Logger.e(f30761e, "Exception:" + e10 + " - Cause:" + e10.getCause());
            }
            if (zBindService) {
                this.f30766c.wait(3000L);
                Logger.d(f30761e, "serviceConn wait END");
            }
        }
    }
}
