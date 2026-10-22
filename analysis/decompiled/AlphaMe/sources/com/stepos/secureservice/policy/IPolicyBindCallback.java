package com.stepos.secureservice.policy;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes.dex */
public interface IPolicyBindCallback extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.secureservice.policy.IPolicyBindCallback";

    public static class Default implements IPolicyBindCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.secureservice.policy.IPolicyBindCallback
        public void onErrored(String str) throws RemoteException {
        }

        @Override // com.stepos.secureservice.policy.IPolicyBindCallback
        public void onGet(List<IPolicyBindResult> list, String str, int i4, int i5, String str2) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IPolicyBindCallback {
        static final int TRANSACTION_onErrored = 2;
        static final int TRANSACTION_onGet = 1;

        public static class Proxy implements IPolicyBindCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IPolicyBindCallback.DESCRIPTOR;
            }

            @Override // com.stepos.secureservice.policy.IPolicyBindCallback
            public void onErrored(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IPolicyBindCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.secureservice.policy.IPolicyBindCallback
            public void onGet(List<IPolicyBindResult> list, String str, int i4, int i5, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IPolicyBindCallback.DESCRIPTOR);
                    _Parcel.writeTypedList(parcelObtain, list, 0);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i4);
                    parcelObtain.writeInt(i5);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IPolicyBindCallback.DESCRIPTOR);
        }

        public static IPolicyBindCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IPolicyBindCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IPolicyBindCallback)) ? new Proxy(iBinder) : (IPolicyBindCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
            if (i4 >= 1 && i4 <= 16777215) {
                parcel.enforceInterface(IPolicyBindCallback.DESCRIPTOR);
            }
            if (i4 == 1598968902) {
                parcel2.writeString(IPolicyBindCallback.DESCRIPTOR);
                return true;
            }
            if (i4 == 1) {
                onGet(parcel.createTypedArrayList(IPolicyBindResult.CREATOR), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString());
            } else {
                if (i4 != 2) {
                    return super.onTransact(i4, parcel, parcel2, i5);
                }
                onErrored(parcel.readString());
            }
            parcel2.writeNoException();
            return true;
        }
    }

    public static class _Parcel {
        private static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedList(Parcel parcel, List<T> list, int i4) {
            if (list == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = list.size();
            parcel.writeInt(size);
            for (int i5 = 0; i5 < size; i5++) {
                writeTypedObject(parcel, list.get(i5), i4);
            }
        }

        private static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t4, int i4) {
            if (t4 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t4.writeToParcel(parcel, i4);
            }
        }
    }

    void onErrored(String str) throws RemoteException;

    void onGet(List<IPolicyBindResult> list, String str, int i4, int i5, String str2) throws RemoteException;
}
