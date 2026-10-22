package com.obric.matrix.platform.sdk.ones.dataanalysis;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes4.dex */
public interface IDataService extends IInterface {

    public static abstract class a extends Binder implements IDataService {

        /* JADX INFO: renamed from: com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService$a$a, reason: collision with other inner class name */
        public static class C0185a implements IDataService {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static IDataService f11906b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f11907a;

            public C0185a(IBinder r10) {
                this.f11907a = r10;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f11907a;
            }

            @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
            public String getDeviceId() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService");     // Catch: Throwable -> L10
                if (this.f11907a.transact(1, r10, r11, 0) == false) goto L6;
            L12:
                r11.readException();     // Catch: Throwable -> L10
                String r12 = r11.readString();     // Catch: Throwable -> L10
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (a.b() == null) goto L12;
                String r13 = a.b().getDeviceId();     // Catch: Throwable -> L10
                r11.recycle();
                r10.recycle();
                return r13;
            L10:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
            public String getInstallId() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService");     // Catch: Throwable -> L10
                if (this.f11907a.transact(2, r10, r11, 0) == false) goto L6;
            L12:
                r11.readException();     // Catch: Throwable -> L10
                String r12 = r11.readString();     // Catch: Throwable -> L10
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (a.b() == null) goto L12;
                String r13 = a.b().getInstallId();     // Catch: Throwable -> L10
                r11.recycle();
                r10.recycle();
                return r13;
            L10:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
            public void onEvent(String r10, String r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService");     // Catch: Throwable -> L10
                r12.writeString(r10);     // Catch: Throwable -> L10
                r12.writeString(r11);     // Catch: Throwable -> L10
                if (this.f11907a.transact(5, r12, r13, 0) == false) goto L6;
            L12:
                r13.readException();     // Catch: Throwable -> L10
                r13.recycle();
                r12.recycle();
                return;
            L6:
                if (a.b() == null) goto L12;
                a.b().onEvent(r10, r11);     // Catch: Throwable -> L10
                r13.recycle();
                r12.recycle();
                return;
            L10:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
            public void registerDeviceInfoListener(IDeviceInfoCallback r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService");     // Catch: Throwable -> L6
                if (r10 == null) goto L8;
                IBinder r13 = r10.asBinder();     // Catch: Throwable -> L6
            L9:
                r11.writeStrongBinder(r13);     // Catch: Throwable -> L6
                if (this.f11907a.transact(3, r11, r12, 0) == false) goto L12;
            L16:
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L12:
                if (a.b() == null) goto L16;
                a.b().registerDeviceInfoListener(r10);     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L8:
                r13 = null;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
            public void unregisterDeviceInfoListener(IDeviceInfoCallback r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService");     // Catch: Throwable -> L6
                if (r10 == null) goto L8;
                IBinder r13 = r10.asBinder();     // Catch: Throwable -> L6
            L9:
                r11.writeStrongBinder(r13);     // Catch: Throwable -> L6
                if (this.f11907a.transact(4, r11, r12, 0) == false) goto L12;
            L16:
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L12:
                if (a.b() == null) goto L16;
                a.b().unregisterDeviceInfoListener(r10);     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L8:
                r13 = null;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }
        }

        public static IDataService a(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface("com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService");
            if (r11 == null) goto L12;
            if ((r11 instanceof IDataService) == false) goto L12;
            return (IDataService) r11;
        L12:
            return new C0185a(r10);
        }

        public static IDataService b() {
            return C0185a.f11906b;
        }
    }

    String getDeviceId() throws RemoteException;

    String getInstallId() throws RemoteException;

    void onEvent(String r10, String r11) throws RemoteException;

    void registerDeviceInfoListener(IDeviceInfoCallback r10) throws RemoteException;

    void unregisterDeviceInfoListener(IDeviceInfoCallback r10) throws RemoteException;
}
