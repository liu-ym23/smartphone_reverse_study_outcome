package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IMultiInstanceInvalidationService extends IInterface {

    public static class Default implements IMultiInstanceInvalidationService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public void broadcastInvalidation(int clientId, String[] tables) throws RemoteException {
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public int registerCallback(IMultiInstanceInvalidationCallback callback, String name) throws RemoteException {
            return 0;
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public void unregisterCallback(IMultiInstanceInvalidationCallback callback, int clientId) throws RemoteException {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IMultiInstanceInvalidationService {
        private static final String DESCRIPTOR = "androidx.room.IMultiInstanceInvalidationService";
        static final int TRANSACTION_broadcastInvalidation = 3;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_unregisterCallback = 2;

        private static class Proxy implements IMultiInstanceInvalidationService {
            public static IMultiInstanceInvalidationService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // androidx.room.IMultiInstanceInvalidationService
            public int registerCallback(IMultiInstanceInvalidationCallback callback, String name) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (callback == null) goto L6;
                IBinder r2 = callback.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                r0.writeString(name);     // Catch: Throwable -> L17
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                int r4 = r1.readInt();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r4;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                int r5 = Stub.getDefaultImpl().registerCallback(callback, name);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r5;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // androidx.room.IMultiInstanceInvalidationService
            public void unregisterCallback(IMultiInstanceInvalidationCallback callback, int clientId) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (callback == null) goto L6;
                IBinder r2 = callback.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                r0.writeInt(clientId);     // Catch: Throwable -> L17
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterCallback(callback, clientId);     // Catch: Throwable -> L17
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

            @Override // androidx.room.IMultiInstanceInvalidationService
            public void broadcastInvalidation(int clientId, String[] tables) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(clientId);     // Catch: Throwable -> L12
                r0.writeStringArray(tables);     // Catch: Throwable -> L12
                if (this.mRemote.transact(3, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().broadcastInvalidation(clientId, tables);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
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

        public static IMultiInstanceInvalidationService asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface r0 = obj.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IMultiInstanceInvalidationService) == false) goto L12;
            return (IMultiInstanceInvalidationService) r0;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code != 1) goto L5;
            data.enforceInterface(DESCRIPTOR);
            int r3 = registerCallback(IMultiInstanceInvalidationCallback.Stub.asInterface(data.readStrongBinder()), data.readString());
            reply.writeNoException();
            reply.writeInt(r3);
            return true;
        L5:
            if (code != 2) goto L7;
            data.enforceInterface(DESCRIPTOR);
            unregisterCallback(IMultiInstanceInvalidationCallback.Stub.asInterface(data.readStrongBinder()), data.readInt());
            reply.writeNoException();
            return true;
        L7:
            if (code != 3) goto L9;
            data.enforceInterface(DESCRIPTOR);
            broadcastInvalidation(data.readInt(), data.createStringArray());
            return true;
        L9:
            if (code != 1598968902) goto L11;
            reply.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(code, data, reply, flags);
        }

        public static boolean setDefaultImpl(IMultiInstanceInvalidationService impl) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (impl == null) goto L7;
            Proxy.sDefaultImpl = impl;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        public static IMultiInstanceInvalidationService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void broadcastInvalidation(int clientId, String[] tables) throws RemoteException;

    int registerCallback(IMultiInstanceInvalidationCallback callback, String name) throws RemoteException;

    void unregisterCallback(IMultiInstanceInvalidationCallback callback, int clientId) throws RemoteException;
}
