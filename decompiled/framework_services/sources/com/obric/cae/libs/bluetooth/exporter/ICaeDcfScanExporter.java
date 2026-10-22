package com.obric.cae.libs.bluetooth.exporter;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface ICaeDcfScanExporter extends IInterface {
    public static final String DESCRIPTOR = "com.obric.cae.libs.bluetooth.exporter.ICaeDcfScanExporter";

    public static class Default implements ICaeDcfScanExporter {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.bluetooth.exporter.ICaeDcfScanExporter
        public boolean isDcfScanSupported() throws RemoteException {
            return false;
        }

        @Override // com.obric.cae.libs.bluetooth.exporter.ICaeDcfScanExporter
        public void registerDcfScanCallback(ICaeDcfScanCallbackExporter r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.exporter.ICaeDcfScanExporter
        public void unregisterDcfScanCallback(ICaeDcfScanCallbackExporter r1) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICaeDcfScanExporter {
        static final int TRANSACTION_isDcfScanSupported = 3;
        static final int TRANSACTION_registerDcfScanCallback = 1;
        static final int TRANSACTION_unregisterDcfScanCallback = 2;

        public static class Proxy implements ICaeDcfScanExporter {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ICaeDcfScanExporter.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.bluetooth.exporter.ICaeDcfScanExporter
            public boolean isDcfScanSupported() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeDcfScanExporter.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean r4 = false;
                this.mRemote.transact(3, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r4 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r4;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.exporter.ICaeDcfScanExporter
            public void registerDcfScanCallback(ICaeDcfScanCallbackExporter r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeDcfScanExporter.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.bluetooth.exporter.ICaeDcfScanExporter
            public void unregisterDcfScanCallback(ICaeDcfScanCallbackExporter r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeDcfScanExporter.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
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
            attachInterface(this, ICaeDcfScanExporter.DESCRIPTOR);
        }

        public static ICaeDcfScanExporter asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(ICaeDcfScanExporter.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICaeDcfScanExporter) == false) goto L12;
            return (ICaeDcfScanExporter) r0;
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
            r5.enforceInterface(ICaeDcfScanExporter.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L20;
            if (r4 != 1) goto L11;
            registerDcfScanCallback(ICaeDcfScanCallbackExporter.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
        L19:
            return true;
        L11:
            if (r4 != 2) goto L13;
            unregisterDcfScanCallback(ICaeDcfScanCallbackExporter.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L19
        L13:
            if (r4 != 3) goto L15;
            boolean r8 = isDcfScanSupported();
            r6.writeNoException();
            r6.writeInt(r8 ? 1 : 0);
            goto L19
        L15:
            return super.onTransact(r4, r5, r6, r7);
        L20:
            r6.writeString(ICaeDcfScanExporter.DESCRIPTOR);
            return true;
        }
    }

    boolean isDcfScanSupported() throws RemoteException;

    void registerDcfScanCallback(ICaeDcfScanCallbackExporter r1) throws RemoteException;

    void unregisterDcfScanCallback(ICaeDcfScanCallbackExporter r1) throws RemoteException;
}
