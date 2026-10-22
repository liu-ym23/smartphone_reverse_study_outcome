package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.common.internal.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC1665f {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f19823a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static Y f19824b = null;

    /* renamed from: c, reason: collision with root package name */
    public static HandlerThread f19825c = null;

    /* renamed from: d, reason: collision with root package name */
    public static Executor f19826d = null;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f19827e = false;

    public static int a() {
        return 4225;
    }

    public static AbstractC1665f b(Context context) {
        synchronized (f19823a) {
            try {
                if (f19824b == null) {
                    f19824b = new Y(context.getApplicationContext(), f19827e ? c().getLooper() : context.getMainLooper(), f19826d);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f19824b;
    }

    public static HandlerThread c() {
        synchronized (f19823a) {
            try {
                HandlerThread handlerThread = f19825c;
                if (handlerThread != null) {
                    return handlerThread;
                }
                HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
                f19825c = handlerThread2;
                handlerThread2.start();
                return f19825c;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void d(U u10, ServiceConnection serviceConnection, String str);

    public final void e(String str, String str2, int i10, ServiceConnection serviceConnection, String str3, boolean z10) {
        d(new U(str, str2, 4225, z10), serviceConnection, str3);
    }

    public abstract boolean f(U u10, ServiceConnection serviceConnection, String str, Executor executor);
}
