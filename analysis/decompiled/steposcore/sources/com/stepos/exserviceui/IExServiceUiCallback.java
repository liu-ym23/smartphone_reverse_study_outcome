package com.stepos.exserviceui;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IExServiceUiCallback extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.exserviceui.IExServiceUiCallback";

    void onBackScreenBootGuideEvent(long j) throws RemoteException;

    void onCrashEvent(long j, String str, String str2, String str3, int i, int i2) throws RemoteException;

    void onUntrustedTouchEvent(long j, String str, String str2, int i, int i2, int i3) throws RemoteException;

    public static class Default implements IExServiceUiCallback {
        @Override // com.stepos.exserviceui.IExServiceUiCallback
        public void onUntrustedTouchEvent(long eventId, String packageName, String appName, int uid, int userId, int displayId) throws RemoteException {
        }

        @Override // com.stepos.exserviceui.IExServiceUiCallback
        public void onCrashEvent(long eventId, String packageName, String appName, String exceptionClass, int uid, int userId) throws RemoteException {
        }

        @Override // com.stepos.exserviceui.IExServiceUiCallback
        public void onBackScreenBootGuideEvent(long eventId) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IExServiceUiCallback {
        static final int TRANSACTION_onBackScreenBootGuideEvent = 3;
        static final int TRANSACTION_onCrashEvent = 2;
        static final int TRANSACTION_onUntrustedTouchEvent = 1;

        public Stub() {
            attachInterface(this, IExServiceUiCallback.DESCRIPTOR);
        }

        public static IExServiceUiCallback asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IExServiceUiCallback.DESCRIPTOR);
            if (iin != null && (iin instanceof IExServiceUiCallback)) {
                return (IExServiceUiCallback) iin;
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
                    return "onUntrustedTouchEvent";
                case 2:
                    return "onCrashEvent";
                case 3:
                    return "onBackScreenBootGuideEvent";
                default:
                    return null;
            }
        }

        public String getTransactionName(int transactionCode) {
            return getDefaultTransactionName(transactionCode);
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            Parcel parcel;
            if (code < 1 || code > 16777215) {
                parcel = data;
            } else {
                parcel = data;
                parcel.enforceInterface(IExServiceUiCallback.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IExServiceUiCallback.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    long _arg0 = parcel.readLong();
                    String _arg1 = parcel.readString();
                    String _arg2 = parcel.readString();
                    int _arg3 = parcel.readInt();
                    int _arg4 = parcel.readInt();
                    int _arg5 = parcel.readInt();
                    onUntrustedTouchEvent(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
                    return true;
                case 2:
                    long _arg02 = parcel.readLong();
                    String _arg12 = parcel.readString();
                    String _arg22 = parcel.readString();
                    String _arg32 = parcel.readString();
                    int _arg42 = parcel.readInt();
                    int _arg52 = parcel.readInt();
                    onCrashEvent(_arg02, _arg12, _arg22, _arg32, _arg42, _arg52);
                    return true;
                case 3:
                    long _arg03 = parcel.readLong();
                    onBackScreenBootGuideEvent(_arg03);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IExServiceUiCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IExServiceUiCallback.DESCRIPTOR;
            }

            @Override // com.stepos.exserviceui.IExServiceUiCallback
            public void onUntrustedTouchEvent(long eventId, String packageName, String appName, int uid, int userId, int displayId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IExServiceUiCallback.DESCRIPTOR);
                    _data.writeLong(eventId);
                    _data.writeString(packageName);
                    _data.writeString(appName);
                    _data.writeInt(uid);
                    _data.writeInt(userId);
                    _data.writeInt(displayId);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.stepos.exserviceui.IExServiceUiCallback
            public void onCrashEvent(long eventId, String packageName, String appName, String exceptionClass, int uid, int userId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IExServiceUiCallback.DESCRIPTOR);
                    _data.writeLong(eventId);
                    _data.writeString(packageName);
                    _data.writeString(appName);
                    _data.writeString(exceptionClass);
                    _data.writeInt(uid);
                    _data.writeInt(userId);
                    this.mRemote.transact(2, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.stepos.exserviceui.IExServiceUiCallback
            public void onBackScreenBootGuideEvent(long eventId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IExServiceUiCallback.DESCRIPTOR);
                    _data.writeLong(eventId);
                    this.mRemote.transact(3, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 2;
        }
    }
}
