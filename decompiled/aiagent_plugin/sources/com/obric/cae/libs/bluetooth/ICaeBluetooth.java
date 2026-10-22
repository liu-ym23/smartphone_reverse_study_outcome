package com.obric.cae.libs.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.AttributionSource;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public interface ICaeBluetooth extends IInterface {

    public static class Default implements ICaeBluetooth {
        public Default() {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void addDeviceToDatabase(String r1, BluetoothDevice r2) {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void addDeviceToStaticExtDatabase(String r1, BluetoothDevice r2) {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public int getProductId(BluetoothDevice r1) {
            return 0;
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void registerEventCallback(ICaeBluetoothEventCallback r2) {
            ICaeBluetoothEventCallback r1 = (ICaeBluetoothEventCallback) ZeusTransformUtils.wrapperContextForParams(r2, ICaeBluetoothEventCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void removeDeviceFromDatabase(String r1, BluetoothDevice r2) {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void removeDeviceFromStaticExtDatabase(String r1, BluetoothDevice r2) {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void requestLeConnectionPriority(int r1, AttributionSource r2) {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void setAac3mPacketEnabled(boolean r1) {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void setBqrEventState(int r1) {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void setHARStatusChanged(int r1) {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void setLocationState(String r1) {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void unregisterEventCallback(ICaeBluetoothEventCallback r2) {
            ICaeBluetoothEventCallback r1 = (ICaeBluetoothEventCallback) ZeusTransformUtils.wrapperContextForParams(r2, ICaeBluetoothEventCallback.class, "com.obric.aiagent.plugin");
        }
    }

    public static abstract class Stub extends Binder implements ICaeBluetooth {
        private static final String DESCRIPTOR = "com.obric.cae.libs.bluetooth.ICaeBluetooth";
        static final int TRANSACTION_addDeviceToDatabase = 3;
        static final int TRANSACTION_addDeviceToStaticExtDatabase = 6;
        static final int TRANSACTION_getProductId = 8;
        static final int TRANSACTION_registerEventCallback = 1;
        static final int TRANSACTION_removeDeviceFromDatabase = 4;
        static final int TRANSACTION_removeDeviceFromStaticExtDatabase = 7;
        static final int TRANSACTION_requestLeConnectionPriority = 5;
        static final int TRANSACTION_setAac3mPacketEnabled = 12;
        static final int TRANSACTION_setBqrEventState = 11;
        static final int TRANSACTION_setHARStatusChanged = 9;
        static final int TRANSACTION_setLocationState = 10;
        static final int TRANSACTION_unregisterEventCallback = 2;

        public static class Proxy implements ICaeBluetooth {
            public static ICaeBluetooth sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r3) {
                this.mRemote = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void addDeviceToDatabase(String r5, BluetoothDevice r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().addDeviceToDatabase(r5, r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void addDeviceToStaticExtDatabase(String r5, BluetoothDevice r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.mRemote.transact(6, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().addDeviceToStaticExtDatabase(r5, r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public int getProductId(BluetoothDevice r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.mRemote.transact(8, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                int r4 = r1.readInt();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r4;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                int r6 = Stub.getDefaultImpl().getProductId(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r6;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void registerEventCallback(ICaeBluetoothEventCallback r5) {
                ICaeBluetoothEventCallback r6 = (ICaeBluetoothEventCallback) ZeusTransformUtils.wrapperContextForParams(r5, ICaeBluetoothEventCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerEventCallback(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void removeDeviceFromDatabase(String r5, BluetoothDevice r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().removeDeviceFromDatabase(r5, r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void removeDeviceFromStaticExtDatabase(String r5, BluetoothDevice r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.mRemote.transact(7, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().removeDeviceFromStaticExtDatabase(r5, r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void requestLeConnectionPriority(int r5, AttributionSource r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().requestLeConnectionPriority(r5, r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void setAac3mPacketEnabled(boolean r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5 ? 1 : 0);     // Catch: Throwable -> L13
                if (this.mRemote.transact(12, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setAac3mPacketEnabled(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void setBqrEventState(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(11, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setBqrEventState(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void setHARStatusChanged(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(9, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setHARStatusChanged(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void setLocationState(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(10, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setLocationState(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void unregisterEventCallback(ICaeBluetoothEventCallback r5) {
                ICaeBluetoothEventCallback r6 = (ICaeBluetoothEventCallback) ZeusTransformUtils.wrapperContextForParams(r5, ICaeBluetoothEventCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterEventCallback(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICaeBluetooth asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, ICaeBluetooth.class) == false) goto L13;
            return (ICaeBluetooth) ZeusTransformUtils.preCheckCast(r0, ICaeBluetooth.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        public static ICaeBluetooth getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICaeBluetooth r2) {
            ICaeBluetooth r3 = (ICaeBluetooth) ZeusTransformUtils.wrapperContextForParams(r2, ICaeBluetooth.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r3 == null) goto L7;
            Proxy.sDefaultImpl = r3;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) {
            if (r5 == 1598968902) goto L54;
            BluetoothDevice r3 = null;
            BluetoothDevice r4 = null;
            BluetoothDevice r9 = null;
            BluetoothDevice r10 = null;
            AttributionSource r11 = null;
            BluetoothDevice r12 = null;
            switch(r5) {
                case 1: goto L52;
                case 2: goto L50;
                case 3: goto L45;
                case 4: goto L40;
                case 5: goto L35;
                case 6: goto L30;
                case 7: goto L25;
                case 8: goto L20;
                case 9: goto L18;
                case 10: goto L16;
                case 11: goto L14;
                case 12: goto L8;
                default: goto L7;
            };
        L8:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L11;
            boolean r13 = true;
        L12:
            setAac3mPacketEnabled(r13);
            r7.writeNoException();
            return true;
        L11:
            r13 = false;
            goto L12
        L14:
            r6.enforceInterface(DESCRIPTOR);
            setBqrEventState(r6.readInt());
            r7.writeNoException();
            return true;
        L16:
            r6.enforceInterface(DESCRIPTOR);
            setLocationState(r6.readString());
            r7.writeNoException();
            return true;
        L18:
            r6.enforceInterface(DESCRIPTOR);
            setHARStatusChanged(r6.readInt());
            r7.writeNoException();
            return true;
        L20:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L23;
            r4 = (BluetoothDevice) ZeusTransformUtils.preCheckCast(BluetoothDevice.CREATOR.createFromParcel(r6), BluetoothDevice.class, "com.obric.aiagent.plugin");
        L23:
            int r14 = getProductId(r4);
            r7.writeNoException();
            r7.writeInt(r14);
            return true;
        L25:
            r6.enforceInterface(DESCRIPTOR);
            String r15 = r6.readString();
            if (r6.readInt() == 0) goto L28;
            r9 = (BluetoothDevice) ZeusTransformUtils.preCheckCast(BluetoothDevice.CREATOR.createFromParcel(r6), BluetoothDevice.class, "com.obric.aiagent.plugin");
        L28:
            removeDeviceFromStaticExtDatabase(r15, r9);
            r7.writeNoException();
            return true;
        L30:
            r6.enforceInterface(DESCRIPTOR);
            String r16 = r6.readString();
            if (r6.readInt() == 0) goto L33;
            r10 = (BluetoothDevice) ZeusTransformUtils.preCheckCast(BluetoothDevice.CREATOR.createFromParcel(r6), BluetoothDevice.class, "com.obric.aiagent.plugin");
        L33:
            addDeviceToStaticExtDatabase(r16, r10);
            r7.writeNoException();
            return true;
        L35:
            r6.enforceInterface(DESCRIPTOR);
            int r17 = r6.readInt();
            if (r6.readInt() == 0) goto L38;
            r11 = (AttributionSource) ZeusTransformUtils.preCheckCast(AttributionSource.CREATOR.createFromParcel(r6), AttributionSource.class, "com.obric.aiagent.plugin");
        L38:
            requestLeConnectionPriority(r17, r11);
            r7.writeNoException();
            return true;
        L40:
            r6.enforceInterface(DESCRIPTOR);
            String r18 = r6.readString();
            if (r6.readInt() == 0) goto L43;
            r12 = (BluetoothDevice) ZeusTransformUtils.preCheckCast(BluetoothDevice.CREATOR.createFromParcel(r6), BluetoothDevice.class, "com.obric.aiagent.plugin");
        L43:
            removeDeviceFromDatabase(r18, r12);
            r7.writeNoException();
            return true;
        L45:
            r6.enforceInterface(DESCRIPTOR);
            String r19 = r6.readString();
            if (r6.readInt() == 0) goto L48;
            r3 = (BluetoothDevice) ZeusTransformUtils.preCheckCast(BluetoothDevice.CREATOR.createFromParcel(r6), BluetoothDevice.class, "com.obric.aiagent.plugin");
        L48:
            addDeviceToDatabase(r19, r3);
            r7.writeNoException();
            return true;
        L50:
            r6.enforceInterface(DESCRIPTOR);
            unregisterEventCallback(ICaeBluetoothEventCallback.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L52:
            r6.enforceInterface(DESCRIPTOR);
            registerEventCallback(ICaeBluetoothEventCallback.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L7:
            return super.onTransact(r5, r6, r7, r8);
        L54:
            r7.writeString(DESCRIPTOR);
            return true;
        }
    }

    void addDeviceToDatabase(String r1, BluetoothDevice r2);

    void addDeviceToStaticExtDatabase(String r1, BluetoothDevice r2);

    int getProductId(BluetoothDevice r1);

    void registerEventCallback(ICaeBluetoothEventCallback r1);

    void removeDeviceFromDatabase(String r1, BluetoothDevice r2);

    void removeDeviceFromStaticExtDatabase(String r1, BluetoothDevice r2);

    void requestLeConnectionPriority(int r1, AttributionSource r2);

    void setAac3mPacketEnabled(boolean r1);

    void setBqrEventState(int r1);

    void setHARStatusChanged(int r1);

    void setLocationState(String r1);

    void unregisterEventCallback(ICaeBluetoothEventCallback r1);
}
