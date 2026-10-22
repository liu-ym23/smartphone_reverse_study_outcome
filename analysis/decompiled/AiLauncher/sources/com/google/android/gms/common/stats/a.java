package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.internal.C1669j;
import com.google.android.gms.common.internal.Z;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import s2.j;
import u2.C5572c;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public static final Object f19884b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static volatile a f19885c;

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f19886a = new ConcurrentHashMap();

    public static a a() {
        if (f19885c == null) {
            synchronized (f19884b) {
                try {
                    if (f19885c == null) {
                        f19885c = new a();
                    }
                } finally {
                }
            }
        }
        a aVar = f19885c;
        C1669j.k(aVar);
        return aVar;
    }

    public static void d(Context context, ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
        } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
        }
    }

    public static boolean f(ServiceConnection serviceConnection) {
        return !(serviceConnection instanceof Z);
    }

    public static final boolean g(Context context, Intent intent, ServiceConnection serviceConnection, int i10, Executor executor) {
        if (executor == null) {
            executor = null;
        }
        return (!j.g() || executor == null) ? context.bindService(intent, serviceConnection, i10) : context.bindService(intent, i10, executor, serviceConnection);
    }

    public void b(Context context, ServiceConnection serviceConnection) {
        if (!f(serviceConnection) || !this.f19886a.containsKey(serviceConnection)) {
            d(context, serviceConnection);
            return;
        }
        try {
            d(context, (ServiceConnection) this.f19886a.get(serviceConnection));
        } finally {
            this.f19886a.remove(serviceConnection);
        }
    }

    @ResultIgnorabilityUnspecified
    public final boolean c(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i10, Executor executor) {
        return e(context, str, intent, serviceConnection, 4225, true, executor);
    }

    public final boolean e(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i10, boolean z10, Executor executor) {
        ComponentName component = intent.getComponent();
        if (component != null) {
            String packageName = component.getPackageName();
            "com.google.android.gms".equals(packageName);
            try {
                if ((C5572c.a(context).a(packageName, 0).flags & 2097152) != 0) {
                    Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (!f(serviceConnection)) {
            return g(context, intent, serviceConnection, i10, executor);
        }
        ServiceConnection serviceConnection2 = (ServiceConnection) this.f19886a.putIfAbsent(serviceConnection, serviceConnection);
        if (serviceConnection2 != null && serviceConnection != serviceConnection2) {
            Log.w("ConnectionTracker", String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", serviceConnection, str, intent.getAction()));
        }
        try {
            boolean zG = g(context, intent, serviceConnection, i10, executor);
            if (zG) {
                return zG;
            }
            return false;
        } finally {
            this.f19886a.remove(serviceConnection, serviceConnection);
        }
    }
}
