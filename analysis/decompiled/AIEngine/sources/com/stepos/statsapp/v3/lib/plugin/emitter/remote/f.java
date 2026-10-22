package com.stepos.statsapp.v3.lib.plugin.emitter.remote;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsInterface;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: e, reason: collision with root package name */
    public static boolean f8033e = false;

    /* renamed from: a, reason: collision with root package name */
    public ServiceInfo f8034a;

    /* renamed from: b, reason: collision with root package name */
    public IVccOfflineStatsInterface f8035b;

    /* renamed from: c, reason: collision with root package name */
    public final c f8036c = new c();

    /* renamed from: d, reason: collision with root package name */
    public a f8037d;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface a {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final f f8038a = new f();
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c implements ServiceConnection {
        public c() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                ta.c.a("V3RemoteServiceReq", "onServiceConnected, " + iBinder);
                f.this.f8035b = IVccOfflineStatsInterface.Stub.asInterface(iBinder);
                a aVar = f.this.f8037d;
                if (aVar != null) {
                    ((V3OfflineEmitter) aVar).c();
                }
            } catch (Exception e10) {
                ta.c.b("V3RemoteServiceReq", "Exception onServiceConnected:" + e10.toString() + " - Cause:" + e10.getCause());
            }
            synchronized (f.this.f8036c) {
                f.this.f8036c.notifyAll();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            ta.c.a("V3RemoteServiceReq", "onServiceDisconnected, " + componentName);
            f fVar = f.this;
            fVar.f8035b = null;
            a aVar = fVar.f8037d;
            if (aVar != null) {
                V3OfflineEmitter v3OfflineEmitter = (V3OfflineEmitter) aVar;
                v3OfflineEmitter.getClass();
                try {
                    v3OfflineEmitter.f8003a.unbindService(this);
                } catch (Throwable th) {
                    ta.c.b("V3OfflineEmitter", "onServiceDisconnected error, " + th.getMessage());
                }
            }
        }
    }

    public final void a(Context context, V3OfflineEmitter v3OfflineEmitter) {
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(new Intent("com.stepos.dataservice.action.vccOfflineStats"), 64);
        ta.c.a("V3RemoteServiceReq", "queryIntentServices for ACTION_VCC_OFFLINE_STATS: " + listQueryIntentServices);
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
                ta.c.a("V3RemoteServiceReq", "choose serviceName---" + str2 + " pkgName---" + str);
                this.f8034a = next.serviceInfo;
                break;
            }
        }
        if (v3OfflineEmitter != null) {
            this.f8037d = v3OfflineEmitter;
        }
    }

    public final void b(Context context, String str, String str2, String str3, List list, List list2) {
        if (c(context)) {
            try {
                this.f8035b.emitterBulkAddEvents(str, str2, str3, list, list2);
            } catch (Throwable th) {
                ta.c.b("V3RemoteServiceReq", "emitterBulkAddEvents error: " + th.getMessage());
            }
        }
    }

    public final boolean c(Context context) {
        if (this.f8034a == null) {
            ta.c.f("V3RemoteServiceReq", "checkRemoteInterface, remote service is null, reinitialize");
            a(context, null);
        }
        if (this.f8034a == null) {
            ta.c.b("V3RemoteServiceReq", "checkRemoteInterface fail, unable get remote service");
            return false;
        }
        if (this.f8035b == null) {
            ta.c.f("V3RemoteServiceReq", "checkRemoteInterface, remote interface is null, rebind service");
            if (this.f8034a == null) {
                ta.c.d("V3RemoteServiceReq", "offline service is null,unable to bind");
            } else {
                synchronized (this.f8036c) {
                    Intent intent = new Intent();
                    intent.setAction("com.stepos.dataservice.action.vccOfflineStats");
                    intent.setPackage(this.f8034a.packageName);
                    ServiceInfo serviceInfo = this.f8034a;
                    intent.setComponent(new ComponentName(serviceInfo.packageName, serviceInfo.name));
                    try {
                        boolean zBindService = context.bindService(intent, this.f8036c, 33);
                        ta.c.a("V3RemoteServiceReq", "bindService, " + this.f8036c + " result: " + zBindService);
                        if (zBindService) {
                            this.f8036c.wait(3000L);
                            ta.c.a("V3RemoteServiceReq", "serviceConn wait END");
                        }
                    } catch (Exception e10) {
                        ta.c.b("V3RemoteServiceReq", "Exception:" + e10 + " - Cause:" + e10.getCause());
                    }
                }
            }
        }
        if (this.f8035b != null) {
            return true;
        }
        ta.c.b("V3RemoteServiceReq", "checkRemoteInterface fail, unable get remote interface");
        return false;
    }
}
