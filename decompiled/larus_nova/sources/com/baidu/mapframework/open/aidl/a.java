package com.baidu.mapframework.open.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.baidu.mapframework.open.aidl.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0637a extends Binder implements a {

        /* JADX INFO: renamed from: com.baidu.mapframework.open.aidl.a$a$a, reason: collision with other inner class name */
        public static class C0638a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static a f31937a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f31938b;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f31938b;
            }

            public C0638a(IBinder r100) {
                this.f31938b = r100;
            }

            @Override // com.baidu.mapframework.open.aidl.a
            public void a(b r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken("com.baidu.mapframework.open.aidl.IMapOpenService");     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_baidu_mapframework_open_aidl_a$a$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f31938b, 1, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (AbstractBinderC0637a.a() == null) goto L14;
                AbstractBinderC0637a.a().a(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r103 = null;
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_baidu_mapframework_open_aidl_a$a$a_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static a a() {
            return C0638a.f31937a;
        }

        public static a b(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface("com.baidu.mapframework.open.aidl.IMapOpenService");
            if (r101 == null) goto L12;
            if ((r101 instanceof a) == false) goto L12;
            return (a) r101;
        L12:
            return new C0638a(r100);
        }
    }

    void a(b r100) throws RemoteException;
}
