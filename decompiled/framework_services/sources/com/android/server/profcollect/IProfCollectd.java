package com.android.server.profcollect;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IProfCollectd extends IInterface {
    public static final String DESCRIPTOR = "com.android.server.profcollect.IProfCollectd";

    public static class Default implements IProfCollectd {
        public Default() {
        }

        @Override // com.android.server.profcollect.IProfCollectd
        public void trace_system(String tag) throws RemoteException {
        }

        @Override // com.android.server.profcollect.IProfCollectd
        public void trace_process(String tag, String processes, float duration) throws RemoteException {
        }

        @Override // com.android.server.profcollect.IProfCollectd
        public void process() throws RemoteException {
        }

        @Override // com.android.server.profcollect.IProfCollectd
        public String report(int usageSetting) throws RemoteException {
            return null;
        }

        @Override // com.android.server.profcollect.IProfCollectd
        public String get_supported_provider() throws RemoteException {
            return null;
        }

        @Override // com.android.server.profcollect.IProfCollectd
        public void registerProviderStatusCallback(IProviderStatusCallback cb) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IProfCollectd {
        static final int TRANSACTION_get_supported_provider = 5;
        static final int TRANSACTION_process = 3;
        static final int TRANSACTION_registerProviderStatusCallback = 6;
        static final int TRANSACTION_report = 4;
        static final int TRANSACTION_trace_process = 2;
        static final int TRANSACTION_trace_system = 1;

        private static class Proxy implements IProfCollectd {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IProfCollectd.DESCRIPTOR;
            }

            @Override // com.android.server.profcollect.IProfCollectd
            public void trace_system(String tag) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IProfCollectd.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(tag);     // Catch: Throwable -> L6
                this.mRemote.transact(1, _data, _reply, 0);     // Catch: Throwable -> L6
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

            @Override // com.android.server.profcollect.IProfCollectd
            public void trace_process(String tag, String processes, float duration) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IProfCollectd.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(tag);     // Catch: Throwable -> L6
                _data.writeString(processes);     // Catch: Throwable -> L6
                _data.writeFloat(duration);     // Catch: Throwable -> L6
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

            @Override // com.android.server.profcollect.IProfCollectd
            public void process() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IProfCollectd.DESCRIPTOR);     // Catch: Throwable -> L6
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

            @Override // com.android.server.profcollect.IProfCollectd
            public String report(int usageSetting) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IProfCollectd.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(usageSetting);     // Catch: Throwable -> L6
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

            @Override // com.android.server.profcollect.IProfCollectd
            public String get_supported_provider() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IProfCollectd.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(5, _data, _reply, 0);     // Catch: Throwable -> L6
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

            @Override // com.android.server.profcollect.IProfCollectd
            public void registerProviderStatusCallback(IProviderStatusCallback cb) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IProfCollectd.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeStrongInterface(cb);     // Catch: Throwable -> L6
                this.mRemote.transact(6, _data, _reply, 0);     // Catch: Throwable -> L6
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
        }

        public Stub() {
            attachInterface(this, IProfCollectd.DESCRIPTOR);
        }

        public static IProfCollectd asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IProfCollectd.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IProfCollectd) == false) goto L12;
            return (IProfCollectd) iin;
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
            data.enforceInterface(IProfCollectd.DESCRIPTOR);
        L8:
            if (code != 1598968902) goto L11;
            reply.writeString(IProfCollectd.DESCRIPTOR);
            return true;
        L11:
            switch(code) {
                case 1: goto L19;
                case 2: goto L18;
                case 3: goto L17;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                default: goto L13;
            };
        L14:
            IProviderStatusCallback _arg0 = IProviderStatusCallback.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            registerProviderStatusCallback(_arg0);
            reply.writeNoException();
        L20:
            return true;
        L15:
            String _result = get_supported_provider();
            reply.writeNoException();
            reply.writeString(_result);
            goto L20
        L16:
            int _arg1 = data.readInt();
            data.enforceNoDataAvail();
            String _result2 = report(_arg1);
            reply.writeNoException();
            reply.writeString(_result2);
            goto L20
        L17:
            process();
            reply.writeNoException();
            goto L20
        L18:
            String _arg2 = data.readString();
            String _arg3 = data.readString();
            float _arg4 = data.readFloat();
            data.enforceNoDataAvail();
            trace_process(_arg2, _arg3, _arg4);
            reply.writeNoException();
            goto L20
        L19:
            String _arg5 = data.readString();
            data.enforceNoDataAvail();
            trace_system(_arg5);
            reply.writeNoException();
            goto L20
        L13:
            return super.onTransact(code, data, reply, flags);
        }
    }

    String get_supported_provider() throws RemoteException;

    void process() throws RemoteException;

    void registerProviderStatusCallback(IProviderStatusCallback r1) throws RemoteException;

    String report(int r1) throws RemoteException;

    void trace_process(String r1, String r2, float r3) throws RemoteException;

    void trace_system(String r1) throws RemoteException;
}
