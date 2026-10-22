package com.stepos.theme;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IStepOSThemeService extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.theme.IStepOSThemeService";

    void cancelChangeWallpaper() throws RemoteException;

    void cancelFontWakeUpTrialService() throws RemoteException;

    void cancelWakeUpTrialService() throws RemoteException;

    void createChangeWallpaper(String str, String str2, long j) throws RemoteException;

    boolean isTrialFontAvailable() throws RemoteException;

    void startFontWakeUpTrialService(long j, String str, int i, int i2) throws RemoteException;

    void startWakeUpTrialService(long j, String str, int i, int i2) throws RemoteException;

    public static class Default implements IStepOSThemeService {
        @Override // com.stepos.theme.IStepOSThemeService
        public void startWakeUpTrialService(long startTime, String packageName, int wakeUpCount, int intervalTime) throws RemoteException {
        }

        @Override // com.stepos.theme.IStepOSThemeService
        public void cancelWakeUpTrialService() throws RemoteException {
        }

        @Override // com.stepos.theme.IStepOSThemeService
        public void createChangeWallpaper(String intentName, String changeType, long sendTime) throws RemoteException {
        }

        @Override // com.stepos.theme.IStepOSThemeService
        public void cancelChangeWallpaper() throws RemoteException {
        }

        @Override // com.stepos.theme.IStepOSThemeService
        public void startFontWakeUpTrialService(long startTime, String fontPackageName, int wakeUpCount, int intervalTime) throws RemoteException {
        }

        @Override // com.stepos.theme.IStepOSThemeService
        public void cancelFontWakeUpTrialService() throws RemoteException {
        }

        @Override // com.stepos.theme.IStepOSThemeService
        public boolean isTrialFontAvailable() throws RemoteException {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IStepOSThemeService {
        static final int TRANSACTION_cancelChangeWallpaper = 4;
        static final int TRANSACTION_cancelFontWakeUpTrialService = 6;
        static final int TRANSACTION_cancelWakeUpTrialService = 2;
        static final int TRANSACTION_createChangeWallpaper = 3;
        static final int TRANSACTION_isTrialFontAvailable = 7;
        static final int TRANSACTION_startFontWakeUpTrialService = 5;
        static final int TRANSACTION_startWakeUpTrialService = 1;

        public Stub() {
            attachInterface(this, IStepOSThemeService.DESCRIPTOR);
        }

        public static IStepOSThemeService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IStepOSThemeService.DESCRIPTOR);
            if (iin != null && (iin instanceof IStepOSThemeService)) {
                return (IStepOSThemeService) iin;
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
                    return "startWakeUpTrialService";
                case 2:
                    return "cancelWakeUpTrialService";
                case 3:
                    return "createChangeWallpaper";
                case 4:
                    return "cancelChangeWallpaper";
                case 5:
                    return "startFontWakeUpTrialService";
                case 6:
                    return "cancelFontWakeUpTrialService";
                case 7:
                    return "isTrialFontAvailable";
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
                parcel.enforceInterface(IStepOSThemeService.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IStepOSThemeService.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    long _arg0 = parcel.readLong();
                    String _arg1 = parcel.readString();
                    int _arg2 = parcel.readInt();
                    int _arg3 = parcel.readInt();
                    startWakeUpTrialService(_arg0, _arg1, _arg2, _arg3);
                    reply.writeNoException();
                    return true;
                case 2:
                    cancelWakeUpTrialService();
                    reply.writeNoException();
                    return true;
                case 3:
                    String _arg02 = parcel.readString();
                    String _arg12 = parcel.readString();
                    long _arg22 = parcel.readLong();
                    createChangeWallpaper(_arg02, _arg12, _arg22);
                    reply.writeNoException();
                    return true;
                case 4:
                    cancelChangeWallpaper();
                    reply.writeNoException();
                    return true;
                case 5:
                    long _arg03 = parcel.readLong();
                    String _arg13 = parcel.readString();
                    int _arg23 = parcel.readInt();
                    int _arg32 = parcel.readInt();
                    startFontWakeUpTrialService(_arg03, _arg13, _arg23, _arg32);
                    reply.writeNoException();
                    return true;
                case 6:
                    cancelFontWakeUpTrialService();
                    reply.writeNoException();
                    return true;
                case 7:
                    boolean _result = isTrialFontAvailable();
                    reply.writeNoException();
                    reply.writeBoolean(_result);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IStepOSThemeService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStepOSThemeService.DESCRIPTOR;
            }

            @Override // com.stepos.theme.IStepOSThemeService
            public void startWakeUpTrialService(long startTime, String packageName, int wakeUpCount, int intervalTime) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSThemeService.DESCRIPTOR);
                    _data.writeLong(startTime);
                    _data.writeString(packageName);
                    _data.writeInt(wakeUpCount);
                    _data.writeInt(intervalTime);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.theme.IStepOSThemeService
            public void cancelWakeUpTrialService() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSThemeService.DESCRIPTOR);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.theme.IStepOSThemeService
            public void createChangeWallpaper(String intentName, String changeType, long sendTime) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSThemeService.DESCRIPTOR);
                    _data.writeString(intentName);
                    _data.writeString(changeType);
                    _data.writeLong(sendTime);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.theme.IStepOSThemeService
            public void cancelChangeWallpaper() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSThemeService.DESCRIPTOR);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.theme.IStepOSThemeService
            public void startFontWakeUpTrialService(long startTime, String fontPackageName, int wakeUpCount, int intervalTime) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSThemeService.DESCRIPTOR);
                    _data.writeLong(startTime);
                    _data.writeString(fontPackageName);
                    _data.writeInt(wakeUpCount);
                    _data.writeInt(intervalTime);
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.theme.IStepOSThemeService
            public void cancelFontWakeUpTrialService() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSThemeService.DESCRIPTOR);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.theme.IStepOSThemeService
            public boolean isTrialFontAvailable() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSThemeService.DESCRIPTOR);
                    this.mRemote.transact(7, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 6;
        }
    }
}
