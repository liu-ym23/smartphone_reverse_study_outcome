package com.bm.badgervi;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public class BadgerVIService extends Service {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f33674b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bm.vivoid.b f33675a;

    static {
        f33674b = b.c("3c-38-3a-77-3b-3b-34-77-3e-3c-3c-38-32-37-31-77-3e-36-41-39-77-1c-38-37-37-42-3c-31-0c-42-2b-2f-36-3c-42-1e-16-21-19");
    }

    public BadgerVIService() {
        this.f33675a = new a(this);
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r100) {
        return this.f33675a;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r100, int r101, int r102) {
        return 2;
    }

    public static void b(BadgerVIService r100, IBinder r101) {
        r100.getClass();
        Parcel r102 = Parcel.obtain();
        Parcel r103 = Parcel.obtain();
        r102.writeInterfaceToken(f33674b);     // Catch: Throwable -> L6
        Intent r104 = new Intent();     // Catch: Throwable -> L6
        r104.putExtra(b.c("3e-36-41-39-0c-42-2b-2f-36-3c-42"), b.c("3e-3c-3c-38-32-37-31-36-37-3f-38-2b-42-3a-38-31-42"));     // Catch: Throwable -> L6
        r102.writeInt(1);     // Catch: Throwable -> L6
        r104.writeToParcel(r102, 0);     // Catch: Throwable -> L6
        a(r101, 2, r102, r103);     // Catch: Throwable -> L6
        r103.readException();     // Catch: Throwable -> L6
        r102.recycle();
        r103.recycle();
        return;
    L6:
        th = move-exception;
        r102.recycle();
        r103.recycle();
        throw th;
    }

    public static void c(BadgerVIService r100, IBinder r101, IBinder r102) {
        r100.getClass();
        Parcel r103 = Parcel.obtain();
        Parcel r104 = Parcel.obtain();
        r103.writeInterfaceToken(f33674b);     // Catch: Throwable -> L6
        r103.writeString(b.c("3c-38-3a-77-3b-3b-34-77-3e-3c-3c-38-32-37-31"));     // Catch: Throwable -> L6
        r103.writeString("-1");     // Catch: Throwable -> L6
        r103.writeStrongBinder(r102);     // Catch: Throwable -> L6
        a(r101, 1, r103, r104);     // Catch: Throwable -> L6
        r104.readException();     // Catch: Throwable -> L6
        r103.recycle();
        r104.recycle();
        return;
    L6:
        th = move-exception;
        r103.recycle();
        r104.recycle();
        throw th;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static void a(IBinder r110, int r111, Parcel r112, Parcel r113) throws RemoteException {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L6;
        r110.transact(r111, r112, r113, 0);
        return;
    L6:
        long r100 = SystemClock.uptimeMillis();
        r110.transact(r111, r112, r113, 0);     // Catch: Throwable -> L12
        long r101 = SystemClock.uptimeMillis() - r100;
        if (r101 < 100) goto L22;
        BinderPerformanceReporter.report(r101, r110.getClass().getName(), r111, 0, new Throwable("Slow main-thread Binder transaction"));
        return;
    L22:
        return;
    L12:
        th = move-exception;
        long r102 = SystemClock.uptimeMillis() - r100;
        if (r102 < 100) goto L23;
        if (r110 != null) goto L17;
        String r103 = "";
    L18:
        String r104 = r103;
        BinderPerformanceReporter.report(r102, r104, r111, 0, new Throwable("Slow main-thread Binder transaction"));
        throw th;
    L17:
        r103 = r110.getClass().getName();
        goto L18
    L23:
        throw th;
    }
}
