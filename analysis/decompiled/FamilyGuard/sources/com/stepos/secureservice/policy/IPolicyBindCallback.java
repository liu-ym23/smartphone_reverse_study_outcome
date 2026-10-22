package com.stepos.secureservice.policy;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
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
        public void onErrored(String str) {
        }

        @Override // com.stepos.secureservice.policy.IPolicyBindCallback
        public void onGet(List<IPolicyBindResult> list, String str, int i5, int i6, String str2) {
        }
    }

    public static abstract class Stub extends Binder implements IPolicyBindCallback {
        static final int TRANSACTION_onErrored = 2;
        static final int TRANSACTION_onGet = 1;

        private static class Proxy implements IPolicyBindCallback {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
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
            public void onErrored(String str) {
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
            public void onGet(List<IPolicyBindResult> list, String str, int i5, int i6, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IPolicyBindCallback.DESCRIPTOR);
                    _Parcel.writeTypedList(parcelObtain, list, 0);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i5);
                    parcelObtain.writeInt(i6);
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
        public boolean onTransact(int i5, Parcel parcel, Parcel parcel2, int i6) {
            if (i5 >= 1 && i5 <= 16777215) {
                parcel.enforceInterface(IPolicyBindCallback.DESCRIPTOR);
            }
            if (i5 == 1598968902) {
                parcel2.writeString(IPolicyBindCallback.DESCRIPTOR);
                return true;
            }
            if (i5 == 1) {
                onGet(parcel.createTypedArrayList(IPolicyBindResult.CREATOR), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
            } else {
                if (i5 != 2) {
                    return super.onTransact(i5, parcel, parcel2, i6);
                }
                onErrored(parcel.readString());
                parcel2.writeNoException();
            }
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
        public static <T extends Parcelable> void writeTypedList(Parcel parcel, List<T> list, int i5) {
            if (list == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = list.size();
            parcel.writeInt(size);
            for (int i6 = 0; i6 < size; i6++) {
                writeTypedObject(parcel, list.get(i6), i5);
            }
        }

        private static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t5, int i5) {
            if (t5 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t5.writeToParcel(parcel, i5);
            }
        }
    }

    void onErrored(String str);

    void onGet(List<IPolicyBindResult> list, String str, int i5, int i6, String str2);
}
