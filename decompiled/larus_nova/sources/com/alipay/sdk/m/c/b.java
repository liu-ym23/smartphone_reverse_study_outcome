package com.alipay.sdk.m.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class b implements com.alipay.sdk.m.b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25240a = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f25241b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f25242c = 2;

    public static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: com.alipay.sdk.m.c.b$b, reason: collision with other inner class name */
    public static final class ServiceConnectionC0481b implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f25243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LinkedBlockingQueue<IBinder> f25244b;

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r100) {
        }

        public IBinder a() throws InterruptedException {
            if (this.f25243a == true) goto L7;
            this.f25243a = true;
            return this.f25244b.poll(5, TimeUnit.SECONDS);
        L7:
            throw new IllegalStateException();
        }

        public ServiceConnectionC0481b() {
            this.f25243a = false;
            this.f25244b = new LinkedBlockingQueue();
        }

        public /* synthetic */ ServiceConnectionC0481b(a r100) {
            this();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r100, IBinder r101) {
            this.f25244b.put(r101);     // Catch: InterruptedException -> L4
            return;
        }
    }

    public static final class c implements IInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public IBinder f25245a;

        public String d() throws RemoteException {
            Parcel r100 = Parcel.obtain();
            Parcel r101 = Parcel.obtain();
            r100.writeInterfaceToken(b.f25240a);     // Catch: Throwable -> L6
            INVOKEINTERFACE_com_alipay_sdk_m_c_b$c_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f25245a, 1, r100, r101, 0);     // Catch: Throwable -> L6
            r101.readException();     // Catch: Throwable -> L6
            String r102 = r101.readString();     // Catch: Throwable -> L6
            r101.recycle();
            r100.recycle();
            return r102;
        L6:
            th = move-exception;
            r101.recycle();
            r100.recycle();
            throw th;
        }

        public boolean e() throws RemoteException {
            Parcel r100 = Parcel.obtain();
            Parcel r101 = Parcel.obtain();
            r100.writeInterfaceToken(b.f25240a);     // Catch: Throwable -> L8
            boolean r102 = false;
            INVOKEINTERFACE_com_alipay_sdk_m_c_b$c_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f25245a, 2, r100, r101, 0);     // Catch: Throwable -> L8
            r101.readException();     // Catch: Throwable -> L8
            if (r101.readInt() == 0) goto L6;
            r102 = true;
        L6:
            r101.recycle();
            r100.recycle();
            return r102;
        L8:
            th = move-exception;
            r101.recycle();
            r100.recycle();
            throw th;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f25245a;
        }

        public c(IBinder r100) {
            this.f25245a = r100;
        }

        @Skip({"com.obric.assistant.interaction.impl.performance"})
        public static boolean INVOKEINTERFACE_com_alipay_sdk_m_c_b$c_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
            if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
            long r100 = SystemClock.uptimeMillis();
            boolean r101 = r110.transact(r111, r112, r113, r114);     // Catch: Throwable -> L12
            long r102 = SystemClock.uptimeMillis() - r100;
            if (r102 < 100) goto L11;
            BinderPerformanceReporter.report(r102, r110.getClass().getName(), r111, r114, new Throwable("Slow main-thread Binder transaction"));
        L11:
            return r101;
        L12:
            th = move-exception;
            long r103 = SystemClock.uptimeMillis() - r100;
            if (r103 < 100) goto L22;
            if (r110 != null) goto L17;
            String r104 = "";
        L18:
            BinderPerformanceReporter.report(r103, r104, r111, r114, new Throwable("Slow main-thread Binder transaction"));
            throw th;
        L17:
            r104 = r110.getClass().getName();
            goto L18
        L22:
            throw th;
        L5:
            return r110.transact(r111, r112, r113, r114);
        }
    }

    public b() {
    }

    @Override // com.alipay.sdk.m.b.b
    public String a(Context r100) {
        ServiceConnectionC0481b r101 = new ServiceConnectionC0481b(null);
        Intent r102 = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        r102.setPackage("com.huawei.hwid");
        if (r100.bindService(r102, r101, 1) == true) goto L12;
    L11:
        return null;
    L12:
        String r103 = new c(r101.a()).d();     // Catch: Throwable -> L7 Exception -> L10
        r100.unbindService(r101);
        return r103;
    L10:
        r100.unbindService(r101);
    L7:
        th = move-exception;
        r100.unbindService(r101);
        throw th;
    }
}
