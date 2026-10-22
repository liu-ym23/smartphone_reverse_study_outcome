package com.obric.cae.libs.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.AttributionSource;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface ICaeBluetooth extends IInterface {
    public static final String DESCRIPTOR = "com.obric.cae.libs.bluetooth.ICaeBluetooth";

    public static class Default implements ICaeBluetooth {
        public Default() {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void addDeviceToDatabase(String r1, BluetoothDevice r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void addDeviceToStaticExtDatabase(String r1, BluetoothDevice r2) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public BdimPredictEvent getBdimEvent(BluetoothDevice r1) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public int getProductId(BluetoothDevice r1) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void registerEventCallback(ICaeBluetoothEventCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void removeDeviceFromDatabase(String r1, BluetoothDevice r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void removeDeviceFromStaticExtDatabase(String r1, BluetoothDevice r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void requestLeConnectionPriority(int r1, AttributionSource r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void setAac3mPacketEnabled(boolean r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void setBqrEventState(int r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void setHARStatusChanged(int r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void setLocationState(String r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void setModelPredictType(BluetoothDevice r1, String r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void unregisterEventCallback(ICaeBluetoothEventCallback r1) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICaeBluetooth {
        static final int TRANSACTION_addDeviceToDatabase = 3;
        static final int TRANSACTION_addDeviceToStaticExtDatabase = 6;
        static final int TRANSACTION_getBdimEvent = 10;
        static final int TRANSACTION_getProductId = 8;
        static final int TRANSACTION_registerEventCallback = 1;
        static final int TRANSACTION_removeDeviceFromDatabase = 4;
        static final int TRANSACTION_removeDeviceFromStaticExtDatabase = 7;
        static final int TRANSACTION_requestLeConnectionPriority = 5;
        static final int TRANSACTION_setAac3mPacketEnabled = 14;
        static final int TRANSACTION_setBqrEventState = 13;
        static final int TRANSACTION_setHARStatusChanged = 11;
        static final int TRANSACTION_setLocationState = 12;
        static final int TRANSACTION_setModelPredictType = 9;
        static final int TRANSACTION_unregisterEventCallback = 2;

        public static class Proxy implements ICaeBluetooth {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void addDeviceToDatabase(String r4, BluetoothDevice r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeBluetooth.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                _Parcel.a(r0, r5, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void addDeviceToStaticExtDatabase(String r4, BluetoothDevice r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeBluetooth.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                _Parcel.a(r0, r5, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(6, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public BdimPredictEvent getBdimEvent(BluetoothDevice r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeBluetooth.DESCRIPTOR);     // Catch: Throwable -> L6
                _Parcel.a(r0, r5, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(10, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                Parcelable.Creator<BdimPredictEvent> r6 = BdimPredictEvent.CREATOR;     // Catch: Throwable -> L6
                if (r1.readInt() == 0) goto L8;
                BdimPredictEvent r7 = r6.createFromParcel(r1);     // Catch: Throwable -> L6
            L9:
                BdimPredictEvent r8 = r7;     // Catch: Throwable -> L6
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
                return ICaeBluetooth.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public int getProductId(BluetoothDevice r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeBluetooth.DESCRIPTOR);     // Catch: Throwable -> L6
                _Parcel.a(r0, r5, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(8, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void registerEventCallback(ICaeBluetoothEventCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeBluetooth.DESCRIPTOR);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void removeDeviceFromDatabase(String r4, BluetoothDevice r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeBluetooth.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                _Parcel.a(r0, r5, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(4, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void removeDeviceFromStaticExtDatabase(String r4, BluetoothDevice r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeBluetooth.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                _Parcel.a(r0, r5, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(7, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void requestLeConnectionPriority(int r4, AttributionSource r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeBluetooth.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                _Parcel.a(r0, r5, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(5, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void setAac3mPacketEnabled(boolean r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeBluetooth.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r5 ? 1 : 0);     // Catch: Throwable -> L6
                this.mRemote.transact(14, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void setBqrEventState(int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeBluetooth.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(13, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void setHARStatusChanged(int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeBluetooth.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(11, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void setLocationState(String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeBluetooth.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(12, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void setModelPredictType(BluetoothDevice r4, String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeBluetooth.DESCRIPTOR);     // Catch: Throwable -> L6
                _Parcel.a(r0, r4, 0);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(9, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void unregisterEventCallback(ICaeBluetoothEventCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeBluetooth.DESCRIPTOR);     // Catch: Throwable -> L6
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
            attachInterface(this, ICaeBluetooth.DESCRIPTOR);
        }

        public static ICaeBluetooth asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(ICaeBluetooth.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICaeBluetooth) == false) goto L12;
            return (ICaeBluetooth) r0;
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
            r5.enforceInterface(ICaeBluetooth.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L31;
            switch(r4) {
                case 1: goto L29;
                case 2: goto L28;
                case 3: goto L27;
                case 4: goto L26;
                case 5: goto L25;
                case 6: goto L24;
                case 7: goto L23;
                case 8: goto L22;
                case 9: goto L21;
                case 10: goto L20;
                case 11: goto L19;
                case 12: goto L18;
                case 13: goto L17;
                case 14: goto L13;
                default: goto L11;
            };
        L17:
            setBqrEventState(r5.readInt());
            r6.writeNoException();
        L30:
            return true;
        L18:
            setLocationState(r5.readString());
            r6.writeNoException();
            goto L30
        L19:
            setHARStatusChanged(r5.readInt());
            r6.writeNoException();
            goto L30
        L20:
            BdimPredictEvent r8 = getBdimEvent((BluetoothDevice) _Parcel.a(r5, BluetoothDevice.CREATOR));
            r6.writeNoException();
            _Parcel.a(r6, r8, 1);
            goto L30
        L21:
            setModelPredictType((BluetoothDevice) _Parcel.a(r5, BluetoothDevice.CREATOR), r5.readString());
            r6.writeNoException();
            goto L30
        L22:
            int r9 = getProductId((BluetoothDevice) _Parcel.a(r5, BluetoothDevice.CREATOR));
            r6.writeNoException();
            r6.writeInt(r9);
            goto L30
        L23:
            removeDeviceFromStaticExtDatabase(r5.readString(), (BluetoothDevice) _Parcel.a(r5, BluetoothDevice.CREATOR));
            r6.writeNoException();
            goto L30
        L24:
            addDeviceToStaticExtDatabase(r5.readString(), (BluetoothDevice) _Parcel.a(r5, BluetoothDevice.CREATOR));
            r6.writeNoException();
            goto L30
        L25:
            requestLeConnectionPriority(r5.readInt(), (AttributionSource) _Parcel.a(r5, AttributionSource.CREATOR));
            r6.writeNoException();
            goto L30
        L26:
            removeDeviceFromDatabase(r5.readString(), (BluetoothDevice) _Parcel.a(r5, BluetoothDevice.CREATOR));
            r6.writeNoException();
            goto L30
        L27:
            addDeviceToDatabase(r5.readString(), (BluetoothDevice) _Parcel.a(r5, BluetoothDevice.CREATOR));
            r6.writeNoException();
            goto L30
        L28:
            unregisterEventCallback(ICaeBluetoothEventCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L30
        L29:
            registerEventCallback(ICaeBluetoothEventCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L30
        L11:
            return super.onTransact(r4, r5, r6, r7);
        L13:
            if (r5.readInt() == 0) goto L15;
            boolean r10 = true;
        L16:
            setAac3mPacketEnabled(r10);
            r6.writeNoException();
            goto L30
        L15:
            r10 = false;
            goto L16
        L31:
            r6.writeString(ICaeBluetooth.DESCRIPTOR);
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

    void addDeviceToDatabase(String r1, BluetoothDevice r2) throws RemoteException;

    void addDeviceToStaticExtDatabase(String r1, BluetoothDevice r2) throws RemoteException;

    BdimPredictEvent getBdimEvent(BluetoothDevice r1) throws RemoteException;

    int getProductId(BluetoothDevice r1) throws RemoteException;

    void registerEventCallback(ICaeBluetoothEventCallback r1) throws RemoteException;

    void removeDeviceFromDatabase(String r1, BluetoothDevice r2) throws RemoteException;

    void removeDeviceFromStaticExtDatabase(String r1, BluetoothDevice r2) throws RemoteException;

    void requestLeConnectionPriority(int r1, AttributionSource r2) throws RemoteException;

    void setAac3mPacketEnabled(boolean r1) throws RemoteException;

    void setBqrEventState(int r1) throws RemoteException;

    void setHARStatusChanged(int r1) throws RemoteException;

    void setLocationState(String r1) throws RemoteException;

    void setModelPredictType(BluetoothDevice r1, String r2) throws RemoteException;

    void unregisterEventCallback(ICaeBluetoothEventCallback r1) throws RemoteException;
}
