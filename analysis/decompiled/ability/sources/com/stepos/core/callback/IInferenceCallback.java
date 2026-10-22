package com.stepos.core.callback;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.stepos.core.data.base.Content;

/* loaded from: classes3.dex */
public interface IInferenceCallback extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.core.callback.IInferenceCallback";

    public static class Default implements IInferenceCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.core.callback.IInferenceCallback
        public void onComplete(String str) throws RemoteException {
        }

        @Override // com.stepos.core.callback.IInferenceCallback
        public void onError(String str, int i, String str2) throws RemoteException {
        }

        @Override // com.stepos.core.callback.IInferenceCallback
        public void onOutput(String str, Content content) throws RemoteException {
        }

        @Override // com.stepos.core.callback.IInferenceCallback
        public void onProgress(String str, int i, Content content) throws RemoteException {
        }

        @Override // com.stepos.core.callback.IInferenceCallback
        public void onRoutingDecision(String str, String str2, String str3) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IInferenceCallback {
        static final int TRANSACTION_onComplete = 3;
        static final int TRANSACTION_onError = 2;
        static final int TRANSACTION_onOutput = 1;
        static final int TRANSACTION_onProgress = 4;
        static final int TRANSACTION_onRoutingDecision = 5;

        public static class Proxy implements IInferenceCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IInferenceCallback.DESCRIPTOR;
            }

            @Override // com.stepos.core.callback.IInferenceCallback
            public void onComplete(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IInferenceCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.core.callback.IInferenceCallback
            public void onError(String str, int i, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IInferenceCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.core.callback.IInferenceCallback
            public void onOutput(String str, Content content) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IInferenceCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (content != null) {
                        parcelObtain.writeInt(1);
                        content.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.core.callback.IInferenceCallback
            public void onProgress(String str, int i, Content content) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IInferenceCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    if (content != null) {
                        parcelObtain.writeInt(1);
                        content.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.mRemote.transact(4, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.core.callback.IInferenceCallback
            public void onRoutingDecision(String str, String str2, String str3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IInferenceCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    this.mRemote.transact(5, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IInferenceCallback.DESCRIPTOR);
        }

        public static IInferenceCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IInferenceCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IInferenceCallback)) ? new Proxy(iBinder) : (IInferenceCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i6) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IInferenceCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IInferenceCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onOutput(parcel.readString(), parcel.readInt() != 0 ? Content.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                onError(parcel.readString(), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i == 3) {
                onComplete(parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i == 4) {
                onProgress(parcel.readString(), parcel.readInt(), parcel.readInt() != 0 ? Content.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i != 5) {
                return super.onTransact(i, parcel, parcel2, i6);
            }
            onRoutingDecision(parcel.readString(), parcel.readString(), parcel.readString());
            return true;
        }
    }

    void onComplete(String str) throws RemoteException;

    void onError(String str, int i, String str2) throws RemoteException;

    void onOutput(String str, Content content) throws RemoteException;

    void onProgress(String str, int i, Content content) throws RemoteException;

    void onRoutingDecision(String str, String str2, String str3) throws RemoteException;
}
