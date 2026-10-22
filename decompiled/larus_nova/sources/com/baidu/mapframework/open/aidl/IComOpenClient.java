package com.baidu.mapframework.open.aidl;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public interface IComOpenClient extends IInterface {

    public static abstract class a extends Binder implements IComOpenClient {

        /* JADX INFO: renamed from: com.baidu.mapframework.open.aidl.IComOpenClient$a$a, reason: collision with other inner class name */
        public static class C0636a implements IComOpenClient {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static IComOpenClient f31935a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f31936b;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f31936b;
            }

            public C0636a(IBinder r100) {
                this.f31936b = r100;
            }

            @Override // com.baidu.mapframework.open.aidl.IComOpenClient
            public String a(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken("com.baidu.mapframework.open.aidl.IComOpenClient");     // Catch: Throwable -> L13
                r101.writeString(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_baidu_mapframework_open_aidl_IComOpenClient$a$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f31936b, 1, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                String r103 = r102.readString();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (a.a() == null) goto L10;
                String r104 = a.a().a(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r104;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.baidu.mapframework.open.aidl.IComOpenClient
            public boolean a(String r100, String r101, Bundle r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken("com.baidu.mapframework.open.aidl.IComOpenClient");     // Catch: Throwable -> L20
                r103.writeString(r100);     // Catch: Throwable -> L20
                r103.writeString(r101);     // Catch: Throwable -> L20
                boolean r105 = true;
                if (r102 == null) goto L6;
                r103.writeInt(1);     // Catch: Throwable -> L20
                r102.writeToParcel(r103, 0);     // Catch: Throwable -> L20
            L8:
                if (INVOKEINTERFACE_com_baidu_mapframework_open_aidl_IComOpenClient$a$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f31936b, 2, r103, r104, 0) == false) goto L10;
            L14:
                r104.readException();     // Catch: Throwable -> L20
                if (r104.readInt() != 0) goto L18;
                r105 = false;
            L18:
                r104.recycle();
                r103.recycle();
                return r105;
            L10:
                if (a.a() == null) goto L14;
                boolean r106 = a.a().a(r100, r101, r102);     // Catch: Throwable -> L20
                r104.recycle();
                r103.recycle();
                return r106;
            L6:
                r103.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_baidu_mapframework_open_aidl_IComOpenClient$a$a_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IComOpenClient a() {
            return C0636a.f31935a;
        }

        public static IComOpenClient b(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface("com.baidu.mapframework.open.aidl.IComOpenClient");
            if (r101 == null) goto L12;
            if ((r101 instanceof IComOpenClient) == false) goto L12;
            return (IComOpenClient) r101;
        L12:
            return new C0636a(r100);
        }
    }

    String a(String r100) throws RemoteException;

    boolean a(String r100, String r101, Bundle r102) throws RemoteException;
}
