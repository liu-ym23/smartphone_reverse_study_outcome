package android.frameworks.vibrator;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IVibratorControlService extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "eb095ed3034973273898ca9e37bbc72566392b8a";
    public static final int VERSION = 1;

    public static class Default implements IVibratorControlService {
        public Default() {
        }

        @Override // android.frameworks.vibrator.IVibratorControlService
        public void registerVibratorController(IVibratorController controller) throws RemoteException {
        }

        @Override // android.frameworks.vibrator.IVibratorControlService
        public void unregisterVibratorController(IVibratorController controller) throws RemoteException {
        }

        @Override // android.frameworks.vibrator.IVibratorControlService
        public void setVibrationParams(VibrationParam[] params, IVibratorController token) throws RemoteException {
        }

        @Override // android.frameworks.vibrator.IVibratorControlService
        public void clearVibrationParams(int typesMask, IVibratorController token) throws RemoteException {
        }

        @Override // android.frameworks.vibrator.IVibratorControlService
        public void onRequestVibrationParamsComplete(IBinder requestToken, VibrationParam[] result) throws RemoteException {
        }

        @Override // android.frameworks.vibrator.IVibratorControlService
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // android.frameworks.vibrator.IVibratorControlService
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IVibratorControlService {
        static final int TRANSACTION_clearVibrationParams = 4;
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_onRequestVibrationParamsComplete = 5;
        static final int TRANSACTION_registerVibratorController = 1;
        static final int TRANSACTION_setVibrationParams = 3;
        static final int TRANSACTION_unregisterVibratorController = 2;

        private static class Proxy implements IVibratorControlService {
            private String mCachedHash;
            private int mCachedVersion;
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mCachedVersion = -1;
                this.mCachedHash = "-1";
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IVibratorControlService.DESCRIPTOR;
            }

            @Override // android.frameworks.vibrator.IVibratorControlService
            public void registerVibratorController(IVibratorController controller) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IVibratorControlService.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeStrongInterface(controller);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(1, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method registerVibratorController is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.frameworks.vibrator.IVibratorControlService
            public void unregisterVibratorController(IVibratorController controller) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IVibratorControlService.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeStrongInterface(controller);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(2, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method unregisterVibratorController is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.frameworks.vibrator.IVibratorControlService
            public void setVibrationParams(VibrationParam[] params, IVibratorController token) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IVibratorControlService.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeTypedArray(params, 0);     // Catch: Throwable -> L9
                _data.writeStrongInterface(token);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(3, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method setVibrationParams is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.frameworks.vibrator.IVibratorControlService
            public void clearVibrationParams(int typesMask, IVibratorController token) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IVibratorControlService.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeInt(typesMask);     // Catch: Throwable -> L9
                _data.writeStrongInterface(token);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(4, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method clearVibrationParams is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.frameworks.vibrator.IVibratorControlService
            public void onRequestVibrationParamsComplete(IBinder requestToken, VibrationParam[] result) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IVibratorControlService.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeStrongBinder(requestToken);     // Catch: Throwable -> L9
                _data.writeTypedArray(result, 0);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(5, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onRequestVibrationParamsComplete is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.frameworks.vibrator.IVibratorControlService
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain(asBinder());
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(IVibratorControlService.DESCRIPTOR);     // Catch: Throwable -> L7
                this.mRemote.transact(16777215, data, reply, 0);     // Catch: Throwable -> L7
                reply.readException();     // Catch: Throwable -> L7
                this.mCachedVersion = reply.readInt();     // Catch: Throwable -> L7
                reply.recycle();
                data.recycle();
            L7:
                th = move-exception;
                reply.recycle();
                data.recycle();
                throw th;
            L11:
                return this.mCachedVersion;
            }

            @Override // android.frameworks.vibrator.IVibratorControlService
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain(asBinder());     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(IVibratorControlService.DESCRIPTOR);     // Catch: Throwable -> L10
                this.mRemote.transact(Stub.TRANSACTION_getInterfaceHash, data, reply, 0);     // Catch: Throwable -> L10
                reply.readException();     // Catch: Throwable -> L10
                this.mCachedHash = reply.readString();     // Catch: Throwable -> L10
                reply.recycle();     // Catch: Throwable -> L8
                data.recycle();     // Catch: Throwable -> L8
                goto L13
            L10:
                th = move-exception;
                reply.recycle();     // Catch: Throwable -> L8
                data.recycle();     // Catch: Throwable -> L8
                throw th;     // Catch: Throwable -> L8
            L13:
                String r0 = this.mCachedHash;     // Catch: Throwable -> L8
                monitor-exit(this);
                return r0;
            }
        }

        public Stub() {
            markVintfStability();
            attachInterface(this, IVibratorControlService.DESCRIPTOR);
        }

        public static IVibratorControlService asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IVibratorControlService.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IVibratorControlService) == false) goto L12;
            return (IVibratorControlService) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch(transactionCode) {
                case 1: goto L17;
                case 2: goto L15;
                case 3: goto L13;
                case 4: goto L11;
                case 5: goto L9;
                case 16777214: goto L7;
                case 16777215: goto L5;
                default: goto L3;
            };
        L3:
            return null;
        L5:
            return "getInterfaceVersion";
        L7:
            return "getInterfaceHash";
        L9:
            return "onRequestVibrationParamsComplete";
        L11:
            return "clearVibrationParams";
        L13:
            return "setVibrationParams";
        L15:
            return "unregisterVibratorController";
        L17:
            return "registerVibratorController";
        }

        public String getTransactionName(int transactionCode) {
            return getDefaultTransactionName(transactionCode);
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = IVibratorControlService.DESCRIPTOR;
            if (code < 1) goto L7;
            if (code > 16777215) goto L7;
            data.enforceInterface(descriptor);
        L7:
            if (code != 1598968902) goto L10;
            reply.writeString(descriptor);
            return true;
        L10:
            if (code != 16777215) goto L14;
            reply.writeNoException();
            reply.writeInt(getInterfaceVersion());
            return true;
        L14:
            if (code != TRANSACTION_getInterfaceHash) goto L17;
            reply.writeNoException();
            reply.writeString(getInterfaceHash());
            return true;
        L17:
            switch(code) {
                case 1: goto L24;
                case 2: goto L23;
                case 3: goto L22;
                case 4: goto L21;
                case 5: goto L20;
                default: goto L19;
            };
        L20:
            IBinder _arg0 = data.readStrongBinder();
            VibrationParam[] _arg1 = (VibrationParam[]) data.createTypedArray(VibrationParam.CREATOR);
            data.enforceNoDataAvail();
            onRequestVibrationParamsComplete(_arg0, _arg1);
        L25:
            return true;
        L21:
            int _arg2 = data.readInt();
            IVibratorController _arg3 = IVibratorController.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            clearVibrationParams(_arg2, _arg3);
            goto L25
        L22:
            VibrationParam[] _arg4 = (VibrationParam[]) data.createTypedArray(VibrationParam.CREATOR);
            IVibratorController _arg5 = IVibratorController.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            setVibrationParams(_arg4, _arg5);
            goto L25
        L23:
            IVibratorController _arg6 = IVibratorController.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            unregisterVibratorController(_arg6);
            goto L25
        L24:
            IVibratorController _arg7 = IVibratorController.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            registerVibratorController(_arg7);
            goto L25
        L19:
            return super.onTransact(code, data, reply, flags);
        }

        public int getMaxTransactionId() {
            return TRANSACTION_getInterfaceHash;
        }
    }

    void clearVibrationParams(int r1, IVibratorController r2) throws RemoteException;

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    void onRequestVibrationParamsComplete(IBinder r1, VibrationParam[] r2) throws RemoteException;

    void registerVibratorController(IVibratorController r1) throws RemoteException;

    void setVibrationParams(VibrationParam[] r1, IVibratorController r2) throws RemoteException;

    void unregisterVibratorController(IVibratorController r1) throws RemoteException;

    static {
        DESCRIPTOR = "android$frameworks$vibrator$IVibratorControlService".replace('$', '.');
    }
}
