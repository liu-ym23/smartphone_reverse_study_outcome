package android.hardware.anti_aging;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IAnti_aging extends IInterface {
    public static final String DESCRIPTOR = "android.hardware.anti_aging.IAnti_aging";

    public static class Default implements IAnti_aging {
        public Default() {
        }

        @Override // android.hardware.anti_aging.IAnti_aging
        public boolean FBO_isSupport() throws RemoteException {
            return false;
        }

        @Override // android.hardware.anti_aging.IAnti_aging
        public void AntiAging_GC() throws RemoteException {
        }

        @Override // android.hardware.anti_aging.IAnti_aging
        public void AntiAging_trigger(String path) throws RemoteException {
        }

        @Override // android.hardware.anti_aging.IAnti_aging
        public String AntiAging_stateCtl(String cmd) throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IAnti_aging {
        static final int TRANSACTION_AntiAging_GC = 2;
        static final int TRANSACTION_AntiAging_stateCtl = 4;
        static final int TRANSACTION_AntiAging_trigger = 3;
        static final int TRANSACTION_FBO_isSupport = 1;

        private static class Proxy implements IAnti_aging {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IAnti_aging.DESCRIPTOR;
            }

            @Override // android.hardware.anti_aging.IAnti_aging
            public boolean FBO_isSupport() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IAnti_aging.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(1, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.anti_aging.IAnti_aging
            public void AntiAging_GC() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IAnti_aging.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(2, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.anti_aging.IAnti_aging
            public void AntiAging_trigger(String path) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IAnti_aging.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(path);     // Catch: Throwable -> L6
                this.mRemote.transact(3, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.anti_aging.IAnti_aging
            public String AntiAging_stateCtl(String cmd) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IAnti_aging.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(cmd);     // Catch: Throwable -> L6
                this.mRemote.transact(4, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                String _result = _reply.readString();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, IAnti_aging.DESCRIPTOR);
        }

        public static IAnti_aging asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IAnti_aging.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IAnti_aging) == false) goto L12;
            return (IAnti_aging) iin;
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
            data.enforceInterface(IAnti_aging.DESCRIPTOR);
        L8:
            if (code != 1598968902) goto L11;
            reply.writeString(IAnti_aging.DESCRIPTOR);
            return true;
        L11:
            switch(code) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                default: goto L13;
            };
        L14:
            String _arg0 = data.readString();
            data.enforceNoDataAvail();
            String _result = AntiAging_stateCtl(_arg0);
            reply.writeNoException();
            reply.writeString(_result);
        L18:
            return true;
        L15:
            String _arg1 = data.readString();
            data.enforceNoDataAvail();
            AntiAging_trigger(_arg1);
            reply.writeNoException();
            goto L18
        L16:
            AntiAging_GC();
            reply.writeNoException();
            goto L18
        L17:
            boolean _result2 = FBO_isSupport();
            reply.writeNoException();
            reply.writeBoolean(_result2);
            goto L18
        L13:
            return super.onTransact(code, data, reply, flags);
        }
    }

    void AntiAging_GC() throws RemoteException;

    String AntiAging_stateCtl(String r1) throws RemoteException;

    void AntiAging_trigger(String r1) throws RemoteException;

    boolean FBO_isSupport() throws RemoteException;
}
