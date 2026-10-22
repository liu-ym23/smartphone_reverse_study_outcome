package stepos.inputmethod.sms;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ISmsOtpCapsuleListener extends IInterface {
    public static final String DESCRIPTOR = "stepos.inputmethod.sms.ISmsOtpCapsuleListener";

    void onCapsuleUpdate(SmsOtp smsOtp) throws RemoteException;

    public static class Default implements ISmsOtpCapsuleListener {
        @Override // stepos.inputmethod.sms.ISmsOtpCapsuleListener
        public void onCapsuleUpdate(SmsOtp otp) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ISmsOtpCapsuleListener {
        static final int TRANSACTION_onCapsuleUpdate = 1;

        public Stub() {
            attachInterface(this, ISmsOtpCapsuleListener.DESCRIPTOR);
        }

        public static ISmsOtpCapsuleListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(ISmsOtpCapsuleListener.DESCRIPTOR);
            if (iin != null && (iin instanceof ISmsOtpCapsuleListener)) {
                return (ISmsOtpCapsuleListener) iin;
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
                    return "onCapsuleUpdate";
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
                data.enforceInterface(ISmsOtpCapsuleListener.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(ISmsOtpCapsuleListener.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    SmsOtp _arg0 = (SmsOtp) data.readTypedObject(SmsOtp.CREATOR);
                    onCapsuleUpdate(_arg0);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements ISmsOtpCapsuleListener {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ISmsOtpCapsuleListener.DESCRIPTOR;
            }

            @Override // stepos.inputmethod.sms.ISmsOtpCapsuleListener
            public void onCapsuleUpdate(SmsOtp otp) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ISmsOtpCapsuleListener.DESCRIPTOR);
                    _data.writeTypedObject(otp, 0);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 0;
        }
    }
}
