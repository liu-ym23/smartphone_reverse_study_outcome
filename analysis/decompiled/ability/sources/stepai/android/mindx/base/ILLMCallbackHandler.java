package stepai.android.mindx.base;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes4.dex */
public interface ILLMCallbackHandler extends IInterface {
    public static final String DESCRIPTOR = "stepai.android.mindx.base.ILLMCallbackHandler";

    public static class Default implements ILLMCallbackHandler {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // stepai.android.mindx.base.ILLMCallbackHandler
        public void onChatReceive(int i, String str, String str2) throws RemoteException {
        }

        @Override // stepai.android.mindx.base.ILLMCallbackHandler
        public void onInitResult(int i, String str) throws RemoteException {
        }

        @Override // stepai.android.mindx.base.ILLMCallbackHandler
        public void onStreamReceive(int i, String str, String str2) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ILLMCallbackHandler {
        static final int TRANSACTION_onChatReceive = 3;
        static final int TRANSACTION_onInitResult = 1;
        static final int TRANSACTION_onStreamReceive = 2;

        public static class Proxy implements ILLMCallbackHandler {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ILLMCallbackHandler.DESCRIPTOR;
            }

            @Override // stepai.android.mindx.base.ILLMCallbackHandler
            public void onChatReceive(int i, String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ILLMCallbackHandler.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // stepai.android.mindx.base.ILLMCallbackHandler
            public void onInitResult(int i, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ILLMCallbackHandler.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // stepai.android.mindx.base.ILLMCallbackHandler
            public void onStreamReceive(int i, String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ILLMCallbackHandler.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ILLMCallbackHandler.DESCRIPTOR);
        }

        public static ILLMCallbackHandler asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ILLMCallbackHandler.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ILLMCallbackHandler)) ? new Proxy(iBinder) : (ILLMCallbackHandler) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i6) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ILLMCallbackHandler.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(ILLMCallbackHandler.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onInitResult(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
            } else if (i == 2) {
                onStreamReceive(parcel.readInt(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
            } else {
                if (i != 3) {
                    return super.onTransact(i, parcel, parcel2, i6);
                }
                onChatReceive(parcel.readInt(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
            }
            return true;
        }
    }

    void onChatReceive(int i, String str, String str2) throws RemoteException;

    void onInitResult(int i, String str) throws RemoteException;

    void onStreamReceive(int i, String str, String str2) throws RemoteException;
}
