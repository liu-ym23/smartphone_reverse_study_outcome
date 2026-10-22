package com.obric.cae.libs.cldReport;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface ICldReportCallback extends IInterface {
    public static final String DESCRIPTOR = "com.obric.cae.libs.cldReport.ICldReportCallback";

    public static class Default implements ICldReportCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.cldReport.ICldReportCallback
        public void onStarted(boolean r1, int r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.cldReport.ICldReportCallback
        public void onStoped(boolean r1, int r2, String r3) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICldReportCallback {
        static final int TRANSACTION_onStarted = 1;
        static final int TRANSACTION_onStoped = 2;

        public static class Proxy implements ICldReportCallback {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ICldReportCallback.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.cldReport.ICldReportCallback
            public void onStarted(boolean r4, int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICldReportCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4 ? 1 : 0);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.cldReport.ICldReportCallback
            public void onStoped(boolean r4, int r5, String r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICldReportCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4 ? 1 : 0);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeString(r6);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, ICldReportCallback.DESCRIPTOR);
        }

        public static ICldReportCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(ICldReportCallback.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICldReportCallback) == false) goto L12;
            return (ICldReportCallback) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(ICldReportCallback.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L24;
            boolean r0 = false;
            if (r4 == 1) goto L20;
            if (r4 == 2) goto L16;
            return super.onTransact(r4, r5, r6, r7);
        L16:
            if (r5.readInt() == 0) goto L18;
            r0 = true;
        L18:
            onStoped(r0, r5.readInt(), r5.readString());
            r6.writeNoException();
        L23:
            return true;
        L20:
            if (r5.readInt() == 0) goto L22;
            r0 = true;
        L22:
            onStarted(r0, r5.readInt());
            r6.writeNoException();
            goto L23
        L24:
            r6.writeString(ICldReportCallback.DESCRIPTOR);
            return true;
        }
    }

    void onStarted(boolean r1, int r2) throws RemoteException;

    void onStoped(boolean r1, int r2, String r3) throws RemoteException;
}
