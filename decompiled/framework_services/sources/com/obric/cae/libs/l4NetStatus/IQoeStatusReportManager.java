package com.obric.cae.libs.l4NetStatus;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.obric.cae.libs.appqoe.IAppQoeCallback;

/* JADX INFO: loaded from: classes3.dex */
public interface IQoeStatusReportManager extends IInterface {
    public static final String DESCRIPTOR = "com.obric.cae.libs.l4NetStatus.IQoeStatusReportManager";

    public static class Default implements IQoeStatusReportManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.l4NetStatus.IQoeStatusReportManager
        public boolean registerAppQoeCallback(String r1, IAppQoeCallback r2) throws RemoteException {
            return false;
        }

        @Override // com.obric.cae.libs.l4NetStatus.IQoeStatusReportManager
        public boolean registerQoeStatusListener(String r1, IQoeStatusListener r2) throws RemoteException {
            return false;
        }

        @Override // com.obric.cae.libs.l4NetStatus.IQoeStatusReportManager
        public boolean unregisterAppQoeCallback(String r1, IAppQoeCallback r2) throws RemoteException {
            return false;
        }

        @Override // com.obric.cae.libs.l4NetStatus.IQoeStatusReportManager
        public boolean unregisterQoeStatusListener(String r1, IQoeStatusListener r2) throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements IQoeStatusReportManager {
        static final int TRANSACTION_registerAppQoeCallback = 3;
        static final int TRANSACTION_registerQoeStatusListener = 1;
        static final int TRANSACTION_unregisterAppQoeCallback = 4;
        static final int TRANSACTION_unregisterQoeStatusListener = 2;

        public static class Proxy implements IQoeStatusReportManager {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IQoeStatusReportManager.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.l4NetStatus.IQoeStatusReportManager
            public boolean registerAppQoeCallback(String r4, IAppQoeCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IQoeStatusReportManager.DESCRIPTOR);     // Catch: Throwable -> L8
                r0.writeString(r4);     // Catch: Throwable -> L8
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L8
                boolean r2 = false;
                this.mRemote.transact(3, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r2 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r2;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.l4NetStatus.IQoeStatusReportManager
            public boolean registerQoeStatusListener(String r4, IQoeStatusListener r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IQoeStatusReportManager.DESCRIPTOR);     // Catch: Throwable -> L8
                r0.writeString(r4);     // Catch: Throwable -> L8
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L8
                boolean r6 = false;
                this.mRemote.transact(1, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r6 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r6;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.l4NetStatus.IQoeStatusReportManager
            public boolean unregisterAppQoeCallback(String r4, IAppQoeCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IQoeStatusReportManager.DESCRIPTOR);     // Catch: Throwable -> L8
                r0.writeString(r4);     // Catch: Throwable -> L8
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L8
                boolean r2 = false;
                this.mRemote.transact(4, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r2 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r2;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.l4NetStatus.IQoeStatusReportManager
            public boolean unregisterQoeStatusListener(String r4, IQoeStatusListener r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IQoeStatusReportManager.DESCRIPTOR);     // Catch: Throwable -> L8
                r0.writeString(r4);     // Catch: Throwable -> L8
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L8
                boolean r2 = false;
                this.mRemote.transact(2, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r2 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r2;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, IQoeStatusReportManager.DESCRIPTOR);
        }

        public static IQoeStatusReportManager asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IQoeStatusReportManager.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IQoeStatusReportManager) == false) goto L12;
            return (IQoeStatusReportManager) r0;
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
            r5.enforceInterface(IQoeStatusReportManager.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L17;
            switch(r4) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                default: goto L11;
            };
        L12:
            boolean r8 = unregisterAppQoeCallback(r5.readString(), IAppQoeCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            r6.writeInt(r8 ? 1 : 0);
        L16:
            return true;
        L13:
            boolean r9 = registerAppQoeCallback(r5.readString(), IAppQoeCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            r6.writeInt(r9 ? 1 : 0);
            goto L16
        L14:
            boolean r10 = unregisterQoeStatusListener(r5.readString(), IQoeStatusListener.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            r6.writeInt(r10 ? 1 : 0);
            goto L16
        L15:
            boolean r11 = registerQoeStatusListener(r5.readString(), IQoeStatusListener.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            r6.writeInt(r11 ? 1 : 0);
            goto L16
        L11:
            return super.onTransact(r4, r5, r6, r7);
        L17:
            r6.writeString(IQoeStatusReportManager.DESCRIPTOR);
            return true;
        }
    }

    boolean registerAppQoeCallback(String r1, IAppQoeCallback r2) throws RemoteException;

    boolean registerQoeStatusListener(String r1, IQoeStatusListener r2) throws RemoteException;

    boolean unregisterAppQoeCallback(String r1, IAppQoeCallback r2) throws RemoteException;

    boolean unregisterQoeStatusListener(String r1, IQoeStatusListener r2) throws RemoteException;
}
