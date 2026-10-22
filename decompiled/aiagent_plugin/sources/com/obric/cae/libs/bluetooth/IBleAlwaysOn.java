package com.obric.cae.libs.bluetooth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public interface IBleAlwaysOn extends IInterface {

    public static class Default implements IBleAlwaysOn {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.bluetooth.IBleAlwaysOn
        public void registerEventCallback(IBleAlwaysOnCallback r2) {
            IBleAlwaysOnCallback r1 = (IBleAlwaysOnCallback) ZeusTransformUtils.wrapperContextForParams(r2, IBleAlwaysOnCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.cae.libs.bluetooth.IBleAlwaysOn
        public void setCaeWakeLockState(boolean r1) {
        }

        @Override // com.obric.cae.libs.bluetooth.IBleAlwaysOn
        public void unregisterEventCallback(IBleAlwaysOnCallback r2) {
            IBleAlwaysOnCallback r1 = (IBleAlwaysOnCallback) ZeusTransformUtils.wrapperContextForParams(r2, IBleAlwaysOnCallback.class, "com.obric.aiagent.plugin");
        }
    }

    public static abstract class Stub extends Binder implements IBleAlwaysOn {
        private static final String DESCRIPTOR = "com.obric.cae.libs.bluetooth.IBleAlwaysOn";
        static final int TRANSACTION_registerEventCallback = 1;
        static final int TRANSACTION_setCaeWakeLockState = 3;
        static final int TRANSACTION_unregisterEventCallback = 2;

        public static class Proxy implements IBleAlwaysOn {
            public static IBleAlwaysOn sDefaultImpl;
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

            @Override // com.obric.cae.libs.bluetooth.IBleAlwaysOn
            public void registerEventCallback(IBleAlwaysOnCallback r5) {
                IBleAlwaysOnCallback r6 = (IBleAlwaysOnCallback) ZeusTransformUtils.wrapperContextForParams(r5, IBleAlwaysOnCallback.class, "com.obric.aiagent.plugin");
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

            @Override // com.obric.cae.libs.bluetooth.IBleAlwaysOn
            public void setCaeWakeLockState(boolean r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5 ? 1 : 0);     // Catch: Throwable -> L13
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setCaeWakeLockState(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.IBleAlwaysOn
            public void unregisterEventCallback(IBleAlwaysOnCallback r5) {
                IBleAlwaysOnCallback r6 = (IBleAlwaysOnCallback) ZeusTransformUtils.wrapperContextForParams(r5, IBleAlwaysOnCallback.class, "com.obric.aiagent.plugin");
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

        public static IBleAlwaysOn asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IBleAlwaysOn.class) == false) goto L13;
            return (IBleAlwaysOn) ZeusTransformUtils.preCheckCast(r0, IBleAlwaysOn.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        public static IBleAlwaysOn getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IBleAlwaysOn r2) {
            IBleAlwaysOn r3 = (IBleAlwaysOn) ZeusTransformUtils.wrapperContextForParams(r2, IBleAlwaysOn.class, "com.obric.aiagent.plugin");
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
            registerEventCallback(IBleAlwaysOnCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            unregisterEventCallback(IBleAlwaysOnCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L7:
            if (r4 != 3) goto L9;
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L17;
            boolean r8 = true;
        L18:
            setCaeWakeLockState(r8);
            r6.writeNoException();
            return true;
        L17:
            r8 = false;
            goto L18
        L9:
            if (r4 != 1598968902) goto L11;
            r6.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void registerEventCallback(IBleAlwaysOnCallback r1);

    void setCaeWakeLockState(boolean r1);

    void unregisterEventCallback(IBleAlwaysOnCallback r1);
}
