package com.obric.matrix.platform.server;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public interface IServerBroker extends IInterface {

    public static class Default implements IServerBroker {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.matrix.platform.server.IServerBroker
        public byte[] invoke(int r1, byte[] r2) {
            return null;
        }

        @Override // com.obric.matrix.platform.server.IServerBroker
        public void invokeAsyn(int r1, byte[] r2, IServerCallback r3) {
            IServerCallback r0 = (IServerCallback) ZeusTransformUtils.wrapperContextForParams(r3, IServerCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.matrix.platform.server.IServerBroker
        public void registerServerCallback(String r1, IServerCallback r2) {
            IServerCallback r0 = (IServerCallback) ZeusTransformUtils.wrapperContextForParams(r2, IServerCallback.class, "com.obric.aiagent.plugin");
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IServerBroker {
        private static final String DESCRIPTOR = "com.obric.matrix.platform.server.IServerBroker";
        static final int TRANSACTION_invoke = 1;
        static final int TRANSACTION_invokeAsyn = 2;
        static final int TRANSACTION_registerServerCallback = 3;

        private static class Proxy implements IServerBroker {
            public static IServerBroker sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder r3) {
                this.mRemote = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.matrix.platform.server.IServerBroker
            public byte[] invoke(int r5, byte[] r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                r0.writeByteArray(r6);     // Catch: Throwable -> L13
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                byte[] r4 = r1.createByteArray();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                byte[] r7 = Stub.getDefaultImpl().invoke(r5, r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.server.IServerBroker
            public void invokeAsyn(int r5, byte[] r6, IServerCallback r7) {
                IServerCallback r8 = (IServerCallback) ZeusTransformUtils.wrapperContextForParams(r7, IServerCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                r0.writeByteArray(r6);     // Catch: Throwable -> L17
                if (r8 == null) goto L6;
                IBinder r2 = r8.asBinder();     // Catch: Throwable -> L17
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
                Stub.getDefaultImpl().invokeAsyn(r5, r6, r8);     // Catch: Throwable -> L17
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

            @Override // com.obric.matrix.platform.server.IServerBroker
            public void registerServerCallback(String r5, IServerCallback r6) {
                IServerCallback r7 = (IServerCallback) ZeusTransformUtils.wrapperContextForParams(r6, IServerCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerServerCallback(r5, r7);     // Catch: Throwable -> L17
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

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IServerBroker asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IServerBroker.class) == false) goto L13;
            return (IServerBroker) ZeusTransformUtils.preCheckCast(r0, IServerBroker.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            byte[] r3 = invoke(r5.readInt(), r5.createByteArray());
            r6.writeNoException();
            r6.writeByteArray(r3);
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            invokeAsyn(r5.readInt(), r5.createByteArray(), IServerCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L7:
            if (r4 != 3) goto L9;
            r5.enforceInterface(DESCRIPTOR);
            registerServerCallback(r5.readString(), IServerCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L9:
            if (r4 != 1598968902) goto L11;
            r6.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r4, r5, r6, r7);
        }

        public static boolean setDefaultImpl(IServerBroker r2) {
            IServerBroker r3 = (IServerBroker) ZeusTransformUtils.wrapperContextForParams(r2, IServerBroker.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        public static IServerBroker getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    byte[] invoke(int r1, byte[] r2);

    void invokeAsyn(int r1, byte[] r2, IServerCallback r3);

    void registerServerCallback(String r1, IServerCallback r2);
}
