package com.obric.cae.libs.bluetooth.exporter;

import android.bluetooth.BluetoothDevice;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.obric.cae.libs.bluetooth.BtDeviceInfoExtEvent;

/* JADX INFO: loaded from: classes3.dex */
public interface ICaeBluetoothExporter extends IInterface {
    public static final String DESCRIPTOR = "com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter";

    public static class Default implements ICaeBluetoothExporter {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
        public boolean disableBle() throws RemoteException {
            return false;
        }

        @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
        public boolean enableBle() throws RemoteException {
            return false;
        }

        @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
        public BtDeviceInfoExtEvent getDeviceType(BluetoothDevice r1) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
        public int getProductId(BluetoothDevice r1) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
        public boolean isAbsoluteVolumeSupported(BluetoothDevice r1) throws RemoteException {
            return false;
        }

        @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
        public void registerEventCallback(ICaeBluetoothCallbackExporter r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
        public void unregisterEventCallback(ICaeBluetoothCallbackExporter r1) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICaeBluetoothExporter {
        static final int TRANSACTION_disableBle = 7;
        static final int TRANSACTION_enableBle = 6;
        static final int TRANSACTION_getDeviceType = 4;
        static final int TRANSACTION_getProductId = 3;
        static final int TRANSACTION_isAbsoluteVolumeSupported = 5;
        static final int TRANSACTION_registerEventCallback = 1;
        static final int TRANSACTION_unregisterEventCallback = 2;

        public static class Proxy implements ICaeBluetoothExporter {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
            public boolean disableBle() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeBluetoothExporter.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean r4 = false;
                this.mRemote.transact(7, r0, r1, 0);     // Catch: Throwable -> L8
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

            @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
            public boolean enableBle() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeBluetoothExporter.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean r4 = false;
                this.mRemote.transact(6, r0, r1, 0);     // Catch: Throwable -> L8
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

            @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
            public BtDeviceInfoExtEvent getDeviceType(BluetoothDevice r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeBluetoothExporter.DESCRIPTOR);     // Catch: Throwable -> L6
                _Parcel.a(r0, r5, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(4, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                Parcelable.Creator<BtDeviceInfoExtEvent> r6 = BtDeviceInfoExtEvent.CREATOR;     // Catch: Throwable -> L6
                if (r1.readInt() == 0) goto L8;
                BtDeviceInfoExtEvent r7 = r6.createFromParcel(r1);     // Catch: Throwable -> L6
            L9:
                BtDeviceInfoExtEvent r8 = r7;     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r8;
            L8:
                r7 = null;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return ICaeBluetoothExporter.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
            public int getProductId(BluetoothDevice r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeBluetoothExporter.DESCRIPTOR);     // Catch: Throwable -> L6
                _Parcel.a(r0, r5, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                int r6 = r1.readInt();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r6;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
            public boolean isAbsoluteVolumeSupported(BluetoothDevice r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeBluetoothExporter.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean r2 = false;
                _Parcel.a(r0, r5, 0);     // Catch: Throwable -> L8
                this.mRemote.transact(5, r0, r1, 0);     // Catch: Throwable -> L8
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

            @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
            public void registerEventCallback(ICaeBluetoothCallbackExporter r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeBluetoothExporter.DESCRIPTOR);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
            public void unregisterEventCallback(ICaeBluetoothCallbackExporter r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeBluetoothExporter.DESCRIPTOR);     // Catch: Throwable -> L6
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
            attachInterface(this, ICaeBluetoothExporter.DESCRIPTOR);
        }

        public static ICaeBluetoothExporter asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(ICaeBluetoothExporter.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICaeBluetoothExporter) == false) goto L12;
            return (ICaeBluetoothExporter) r0;
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
            r5.enforceInterface(ICaeBluetoothExporter.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L20;
            switch(r4) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                default: goto L11;
            };
        L12:
            boolean r8 = disableBle();
            r6.writeNoException();
            r6.writeInt(r8 ? 1 : 0);
        L19:
            return true;
        L13:
            boolean r9 = enableBle();
            r6.writeNoException();
            r6.writeInt(r9 ? 1 : 0);
            goto L19
        L14:
            boolean r10 = isAbsoluteVolumeSupported((BluetoothDevice) _Parcel.a(r5, BluetoothDevice.CREATOR));
            r6.writeNoException();
            r6.writeInt(r10 ? 1 : 0);
            goto L19
        L15:
            BtDeviceInfoExtEvent r11 = getDeviceType((BluetoothDevice) _Parcel.a(r5, BluetoothDevice.CREATOR));
            r6.writeNoException();
            _Parcel.a(r6, r11, 1);
            goto L19
        L16:
            int r12 = getProductId((BluetoothDevice) _Parcel.a(r5, BluetoothDevice.CREATOR));
            r6.writeNoException();
            r6.writeInt(r12);
            goto L19
        L17:
            unregisterEventCallback(ICaeBluetoothCallbackExporter.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L19
        L18:
            registerEventCallback(ICaeBluetoothCallbackExporter.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L19
        L11:
            return super.onTransact(r4, r5, r6, r7);
        L20:
            r6.writeString(ICaeBluetoothExporter.DESCRIPTOR);
            return true;
        }
    }

    public static class _Parcel {
        public _Parcel() {
        }

        public static Object a(Parcel r1, Parcelable.Creator r2) {
            if (r1.readInt() != 0) goto L7;
            return null;
        L7:
            return r2.createFromParcel(r1);
        }

        public static void a(Parcel r1, Parcelable r2, int r3) {
            if (r2 == null) goto L4;
            r1.writeInt(1);
            r2.writeToParcel(r1, r3);
            return;
        L4:
            r1.writeInt(0);
        }
    }

    boolean disableBle() throws RemoteException;

    boolean enableBle() throws RemoteException;

    BtDeviceInfoExtEvent getDeviceType(BluetoothDevice r1) throws RemoteException;

    int getProductId(BluetoothDevice r1) throws RemoteException;

    boolean isAbsoluteVolumeSupported(BluetoothDevice r1) throws RemoteException;

    void registerEventCallback(ICaeBluetoothCallbackExporter r1) throws RemoteException;

    void unregisterEventCallback(ICaeBluetoothCallbackExporter r1) throws RemoteException;
}
