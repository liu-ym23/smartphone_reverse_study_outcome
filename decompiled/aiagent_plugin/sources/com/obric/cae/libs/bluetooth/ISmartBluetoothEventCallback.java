package com.obric.cae.libs.bluetooth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public interface ISmartBluetoothEventCallback extends IInterface {

    public static class Default implements ISmartBluetoothEventCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.bluetooth.ISmartBluetoothEventCallback
        public void onEBikeAware(int r1) {
        }

        @Override // com.obric.cae.libs.bluetooth.ISmartBluetoothEventCallback
        public void onEventReported(SmartBluetoothEvent r1) {
        }
    }

    public static abstract class Stub extends Binder implements ISmartBluetoothEventCallback {
        private static final String DESCRIPTOR = "com.obric.cae.libs.bluetooth.ISmartBluetoothEventCallback";
        static final int TRANSACTION_onEBikeAware = 2;
        static final int TRANSACTION_onEventReported = 1;

        public static class Proxy implements ISmartBluetoothEventCallback {
            public static ISmartBluetoothEventCallback sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r3) {
                this.mRemote = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.bluetooth.ISmartBluetoothEventCallback
            public void onEBikeAware(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onEBikeAware(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ISmartBluetoothEventCallback
            public void onEventReported(SmartBluetoothEvent r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onEventReported(r5);     // Catch: Throwable -> L17
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
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ISmartBluetoothEventCallback asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, ISmartBluetoothEventCallback.class) == false) goto L13;
            return (ISmartBluetoothEventCallback) ZeusTransformUtils.preCheckCast(r0, ISmartBluetoothEventCallback.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        public static ISmartBluetoothEventCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ISmartBluetoothEventCallback r2) {
            ISmartBluetoothEventCallback r3 = (ISmartBluetoothEventCallback) ZeusTransformUtils.wrapperContextForParams(r2, ISmartBluetoothEventCallback.class, "com.obric.aiagent.plugin");
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
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L17;
            SmartBluetoothEvent r8 = (SmartBluetoothEvent) ZeusTransformUtils.preCheckCast(SmartBluetoothEvent.CREATOR.createFromParcel(r5), SmartBluetoothEvent.class, "com.obric.aiagent.plugin");
        L18:
            onEventReported(r8);
            r6.writeNoException();
            return true;
        L17:
            r8 = null;
            goto L18
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            onEBikeAware(r5.readInt());
            r6.writeNoException();
            return true;
        L7:
            if (r4 != 1598968902) goto L9;
            r6.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void onEBikeAware(int r1);

    void onEventReported(SmartBluetoothEvent r1);
}
