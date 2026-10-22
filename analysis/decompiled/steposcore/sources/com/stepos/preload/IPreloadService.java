package com.stepos.preload;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.UserHandle;

/* loaded from: classes.dex */
public interface IPreloadService extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.preload.IPreloadService";

    void cancelPreload(String str, UserHandle userHandle) throws RemoteException;

    void requestPreloadOnTouchDown(String str, UserHandle userHandle) throws RemoteException;

    void requestPreloadOnTouchUp(String str, UserHandle userHandle) throws RemoteException;

    public static class Default implements IPreloadService {
        @Override // com.stepos.preload.IPreloadService
        public void requestPreloadOnTouchDown(String packageName, UserHandle user) throws RemoteException {
        }

        @Override // com.stepos.preload.IPreloadService
        public void requestPreloadOnTouchUp(String packageName, UserHandle user) throws RemoteException {
        }

        @Override // com.stepos.preload.IPreloadService
        public void cancelPreload(String packageName, UserHandle user) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IPreloadService {
        static final int TRANSACTION_cancelPreload = 3;
        static final int TRANSACTION_requestPreloadOnTouchDown = 1;
        static final int TRANSACTION_requestPreloadOnTouchUp = 2;

        public Stub() {
            attachInterface(this, IPreloadService.DESCRIPTOR);
        }

        public static IPreloadService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IPreloadService.DESCRIPTOR);
            if (iin != null && (iin instanceof IPreloadService)) {
                return (IPreloadService) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch (transactionCode) {
                case 1:
                    return "requestPreloadOnTouchDown";
                case 2:
                    return "requestPreloadOnTouchUp";
                case 3:
                    return "cancelPreload";
                default:
                    return null;
            }
        }

        public String getTransactionName(int transactionCode) {
            return getDefaultTransactionName(transactionCode);
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code >= 1 && code <= 16777215) {
                data.enforceInterface(IPreloadService.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IPreloadService.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    String _arg0 = data.readString();
                    UserHandle _arg1 = (UserHandle) data.readTypedObject(UserHandle.CREATOR);
                    requestPreloadOnTouchDown(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                case 2:
                    String _arg02 = data.readString();
                    UserHandle _arg12 = (UserHandle) data.readTypedObject(UserHandle.CREATOR);
                    requestPreloadOnTouchUp(_arg02, _arg12);
                    reply.writeNoException();
                    return true;
                case 3:
                    String _arg03 = data.readString();
                    UserHandle _arg13 = (UserHandle) data.readTypedObject(UserHandle.CREATOR);
                    cancelPreload(_arg03, _arg13);
                    reply.writeNoException();
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IPreloadService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IPreloadService.DESCRIPTOR;
            }

            @Override // com.stepos.preload.IPreloadService
            public void requestPreloadOnTouchDown(String packageName, UserHandle user) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IPreloadService.DESCRIPTOR);
                    _data.writeString(packageName);
                    _data.writeTypedObject(user, 0);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.preload.IPreloadService
            public void requestPreloadOnTouchUp(String packageName, UserHandle user) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IPreloadService.DESCRIPTOR);
                    _data.writeString(packageName);
                    _data.writeTypedObject(user, 0);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.preload.IPreloadService
            public void cancelPreload(String packageName, UserHandle user) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IPreloadService.DESCRIPTOR);
                    _data.writeString(packageName);
                    _data.writeTypedObject(user, 0);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 2;
        }
    }
}
