package android.adpf;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface ISessionManager extends IInterface {
    public static final String DESCRIPTOR = "android.adpf.ISessionManager";

    public static class Default implements ISessionManager {
        public Default() {
        }

        @Override // android.adpf.ISessionManager
        public void associateSessionToLayers(int sessionId, int ownerUid, IBinder[] layers) throws RemoteException {
        }

        @Override // android.adpf.ISessionManager
        public void trackedSessionsDied(int[] sessionId) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ISessionManager {
        static final int TRANSACTION_associateSessionToLayers = 1;
        static final int TRANSACTION_trackedSessionsDied = 2;

        private static class Proxy implements ISessionManager {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ISessionManager.DESCRIPTOR;
            }

            @Override // android.adpf.ISessionManager
            public void associateSessionToLayers(int sessionId, int ownerUid, IBinder[] layers) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(ISessionManager.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(sessionId);     // Catch: Throwable -> L6
                _data.writeInt(ownerUid);     // Catch: Throwable -> L6
                _data.writeBinderArray(layers);     // Catch: Throwable -> L6
                this.mRemote.transact(1, _data, null, 1);     // Catch: Throwable -> L6
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.adpf.ISessionManager
            public void trackedSessionsDied(int[] sessionId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(ISessionManager.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeIntArray(sessionId);     // Catch: Throwable -> L6
                this.mRemote.transact(2, _data, null, 1);     // Catch: Throwable -> L6
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _data.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, ISessionManager.DESCRIPTOR);
        }

        public static ISessionManager asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(ISessionManager.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof ISessionManager) == false) goto L12;
            return (ISessionManager) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code < 1) goto L8;
            if (code > 16777215) goto L8;
            data.enforceInterface(ISessionManager.DESCRIPTOR);
        L8:
            if (code != 1598968902) goto L11;
            reply.writeString(ISessionManager.DESCRIPTOR);
            return true;
        L11:
            switch(code) {
                case 1: goto L15;
                case 2: goto L14;
                default: goto L13;
            };
        L14:
            int[] _arg0 = data.createIntArray();
            data.enforceNoDataAvail();
            trackedSessionsDied(_arg0);
        L16:
            return true;
        L15:
            int _arg1 = data.readInt();
            int _arg2 = data.readInt();
            IBinder[] _arg3 = data.createBinderArray();
            data.enforceNoDataAvail();
            associateSessionToLayers(_arg1, _arg2, _arg3);
            goto L16
        L13:
            return super.onTransact(code, data, reply, flags);
        }
    }

    void associateSessionToLayers(int r1, int r2, IBinder[] r3) throws RemoteException;

    void trackedSessionsDied(int[] r1) throws RemoteException;
}
