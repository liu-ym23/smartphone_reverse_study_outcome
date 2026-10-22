package d1;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.util.Log;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.google.android.gms.common.internal.s;
import f1.C0558b;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: d1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0535a {

    /* renamed from: b, reason: collision with root package name */
    public static final Object f12413b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static volatile C0535a f12414c;

    /* renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap f12415a;

    public final void a(Context context, ServiceConnection serviceConnection) {
        if (!(serviceConnection instanceof s)) {
            ConcurrentHashMap concurrentHashMap = this.f12415a;
            if (concurrentHashMap.containsKey(serviceConnection)) {
                try {
                    try {
                        context.unbindService((ServiceConnection) concurrentHashMap.get(serviceConnection));
                    } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
                    }
                    return;
                } finally {
                    concurrentHashMap.remove(serviceConnection);
                }
            }
        }
        try {
            context.unbindService(serviceConnection);
        } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused2) {
        }
    }

    public final boolean b(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i4) {
        ComponentName component = intent.getComponent();
        if (component != null) {
            String packageName = component.getPackageName();
            "com.google.android.gms".equals(packageName);
            try {
                if ((C0558b.a(context).f13046b.getPackageManager().getApplicationInfo(packageName, 0).flags & BmLocated.ALIGN_BOTTOM) != 0) {
                    Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (!(!(serviceConnection instanceof s))) {
            return context.bindService(intent, serviceConnection, i4);
        }
        ConcurrentHashMap concurrentHashMap = this.f12415a;
        ServiceConnection serviceConnection2 = (ServiceConnection) concurrentHashMap.putIfAbsent(serviceConnection, serviceConnection);
        if (serviceConnection2 != null && serviceConnection != serviceConnection2) {
            Log.w("ConnectionTracker", String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", serviceConnection, str, intent.getAction()));
        }
        try {
            boolean zBindService = context.bindService(intent, serviceConnection, i4);
            if (zBindService) {
                return zBindService;
            }
            return false;
        } finally {
            concurrentHashMap.remove(serviceConnection, serviceConnection);
        }
    }
}
