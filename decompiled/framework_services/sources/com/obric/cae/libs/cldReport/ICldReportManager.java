package com.obric.cae.libs.cldReport;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface ICldReportManager extends IInterface {
    public static final int CLD_MODULE_TYPE_BT = 1;
    public static final int CLD_MODULE_TYPE_GNSS = 3;
    public static final int CLD_MODULE_TYPE_LOGCAT = 5;
    public static final int CLD_MODULE_TYPE_NETWORK = 2;
    public static final int CLD_MODULE_TYPE_NFC = 4;
    public static final int CLD_MODULE_TYPE_WIFI = 0;
    public static final String DESCRIPTOR = "com.obric.cae.libs.cldReport.ICldReportManager";

    public static class Default implements ICldReportManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.cldReport.ICldReportManager
        public void reportErrorEvent(int r1, int r2, int r3, int r4, String r5) throws RemoteException {
        }

        @Override // com.obric.cae.libs.cldReport.ICldReportManager
        public void startCollect(ICldReportCallback r1, int r2, int r3, int r4, int r5, String r6, boolean r7) throws RemoteException {
        }

        @Override // com.obric.cae.libs.cldReport.ICldReportManager
        public void stopCollect(ICldReportCallback r1, int r2, int r3) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICldReportManager {
        static final int TRANSACTION_reportErrorEvent = 1;
        static final int TRANSACTION_startCollect = 2;
        static final int TRANSACTION_stopCollect = 3;

        public static class Proxy implements ICldReportManager {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ICldReportManager.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.cldReport.ICldReportManager
            public void reportErrorEvent(int r4, int r5, int r6, int r7, String r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICldReportManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeInt(r6);     // Catch: Throwable -> L6
                r0.writeInt(r7);     // Catch: Throwable -> L6
                r0.writeString(r8);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.cldReport.ICldReportManager
            public void startCollect(ICldReportCallback r4, int r5, int r6, int r7, int r8, String r9, boolean r10) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICldReportManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeInt(r6);     // Catch: Throwable -> L6
                r0.writeInt(r7);     // Catch: Throwable -> L6
                r0.writeInt(r8);     // Catch: Throwable -> L6
                r0.writeString(r9);     // Catch: Throwable -> L6
                r0.writeInt(r10 ? 1 : 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.cldReport.ICldReportManager
            public void stopCollect(ICldReportCallback r4, int r5, int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICldReportManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeInt(r6);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r0, r1, 0);     // Catch: Throwable -> L6
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
            attachInterface(this, ICldReportManager.DESCRIPTOR);
        }

        public static ICldReportManager asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(ICldReportManager.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICldReportManager) == false) goto L12;
            return (ICldReportManager) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r13, Parcel r14, Parcel r15, int r16) throws RemoteException {
            if (r13 < 1) goto L8;
            if (r13 > 16777215) goto L8;
            r14.enforceInterface(ICldReportManager.DESCRIPTOR);
        L8:
            if (r13 == 1598968902) goto L24;
            if (r13 != 1) goto L11;
            reportErrorEvent(r14.readInt(), r14.readInt(), r14.readInt(), r14.readInt(), r14.readString());
            r15.writeNoException();
        L23:
            return true;
        L11:
            if (r13 != 2) goto L13;
            ICldReportCallback r5 = ICldReportCallback.Stub.asInterface(r14.readStrongBinder());
            int r6 = r14.readInt();
            int r7 = r14.readInt();
            int r8 = r14.readInt();
            int r9 = r14.readInt();
            String r10 = r14.readString();
            if (r14.readInt() == 0) goto L20;
            boolean r11 = true;
        L21:
            startCollect(r5, r6, r7, r8, r9, r10, r11);
            r15.writeNoException();
            goto L23
        L20:
            r11 = false;
            goto L21
        L13:
            if (r13 != 3) goto L15;
            stopCollect(ICldReportCallback.Stub.asInterface(r14.readStrongBinder()), r14.readInt(), r14.readInt());
            r15.writeNoException();
            goto L23
        L15:
            return super.onTransact(r13, r14, r15, r16);
        L24:
            r15.writeString(ICldReportManager.DESCRIPTOR);
            return true;
        }
    }

    void reportErrorEvent(int r1, int r2, int r3, int r4, String r5) throws RemoteException;

    void startCollect(ICldReportCallback r1, int r2, int r3, int r4, int r5, String r6, boolean r7) throws RemoteException;

    void stopCollect(ICldReportCallback r1, int r2, int r3) throws RemoteException;
}
