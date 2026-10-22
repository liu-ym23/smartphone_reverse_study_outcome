package stepos.inputmethod.sms;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import stepos.inputmethod.sms.ISmsOtpCapsuleListener;

/* loaded from: classes.dex */
public interface ISmsOtpCapsuleService extends IInterface {
    public static final String DESCRIPTOR = "stepos.inputmethod.sms.ISmsOtpCapsuleService";

    void clear() throws RemoteException;

    void registerListener(ISmsOtpCapsuleListener iSmsOtpCapsuleListener) throws RemoteException;

    void show(SmsOtp smsOtp) throws RemoteException;

    void unregisterListener(ISmsOtpCapsuleListener iSmsOtpCapsuleListener) throws RemoteException;

    public static class Default implements ISmsOtpCapsuleService {
        @Override // stepos.inputmethod.sms.ISmsOtpCapsuleService
        public void show(SmsOtp otp) throws RemoteException {
        }

        @Override // stepos.inputmethod.sms.ISmsOtpCapsuleService
        public void clear() throws RemoteException {
        }

        @Override // stepos.inputmethod.sms.ISmsOtpCapsuleService
        public void registerListener(ISmsOtpCapsuleListener listener) throws RemoteException {
        }

        @Override // stepos.inputmethod.sms.ISmsOtpCapsuleService
        public void unregisterListener(ISmsOtpCapsuleListener listener) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ISmsOtpCapsuleService {
        static final int TRANSACTION_clear = 2;
        static final int TRANSACTION_registerListener = 3;
        static final int TRANSACTION_show = 1;
        static final int TRANSACTION_unregisterListener = 4;

        public Stub() {
            attachInterface(this, ISmsOtpCapsuleService.DESCRIPTOR);
        }

        public static ISmsOtpCapsuleService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(ISmsOtpCapsuleService.DESCRIPTOR);
            if (iin != null && (iin instanceof ISmsOtpCapsuleService)) {
                return (ISmsOtpCapsuleService) iin;
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
                    return "show";
                case 2:
                    return "clear";
                case 3:
                    return "registerListener";
                case 4:
                    return "unregisterListener";
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
                data.enforceInterface(ISmsOtpCapsuleService.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(ISmsOtpCapsuleService.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    SmsOtp _arg0 = (SmsOtp) data.readTypedObject(SmsOtp.CREATOR);
                    show(_arg0);
                    return true;
                case 2:
                    clear();
                    return true;
                case 3:
                    ISmsOtpCapsuleListener _arg02 = ISmsOtpCapsuleListener.Stub.asInterface(data.readStrongBinder());
                    registerListener(_arg02);
                    return true;
                case 4:
                    ISmsOtpCapsuleListener _arg03 = ISmsOtpCapsuleListener.Stub.asInterface(data.readStrongBinder());
                    unregisterListener(_arg03);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements ISmsOtpCapsuleService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ISmsOtpCapsuleService.DESCRIPTOR;
            }

            @Override // stepos.inputmethod.sms.ISmsOtpCapsuleService
            public void show(SmsOtp otp) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ISmsOtpCapsuleService.DESCRIPTOR);
                    _data.writeTypedObject(otp, 0);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.inputmethod.sms.ISmsOtpCapsuleService
            public void clear() throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ISmsOtpCapsuleService.DESCRIPTOR);
                    this.mRemote.transact(2, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.inputmethod.sms.ISmsOtpCapsuleService
            public void registerListener(ISmsOtpCapsuleListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ISmsOtpCapsuleService.DESCRIPTOR);
                    _data.writeStrongInterface(listener);
                    this.mRemote.transact(3, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.inputmethod.sms.ISmsOtpCapsuleService
            public void unregisterListener(ISmsOtpCapsuleListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ISmsOtpCapsuleService.DESCRIPTOR);
                    _data.writeStrongInterface(listener);
                    this.mRemote.transact(4, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 3;
        }
    }
}
