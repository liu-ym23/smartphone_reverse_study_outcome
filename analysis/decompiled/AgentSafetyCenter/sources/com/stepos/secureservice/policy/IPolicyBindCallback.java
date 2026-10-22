package com.stepos.secureservice.policy;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface IPolicyBindCallback extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.secureservice.policy.IPolicyBindCallback";

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class _Parcel {
        private static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedList(Parcel parcel, List<T> list, int i) {
            if (list == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = list.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                writeTypedObject(parcel, list.get(i3), i);
            }
        }

        private static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t10, int i) {
            if (t10 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t10.writeToParcel(parcel, i);
            }
        }
    }

    void onErrored(String str);

    void onGet(List<IPolicyBindResult> list, String str, int i, int i3, String str2);

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static abstract class Stub extends Binder implements IPolicyBindCallback {
        static final int TRANSACTION_onErrored = 2;
        static final int TRANSACTION_onGet = 1;

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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
            public void onGet(List<IPolicyBindResult> list, String str, int i, int i3, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IPolicyBindCallback.DESCRIPTOR);
                    _Parcel.writeTypedList(parcelObtain, list, 0);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i3);
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

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i3) {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IPolicyBindCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IPolicyBindCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onGet(parcel.createTypedArrayList(IPolicyBindResult.CREATOR), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
            } else {
                if (i != 2) {
                    return super.onTransact(i, parcel, parcel2, i3);
                }
                onErrored(parcel.readString());
                parcel2.writeNoException();
            }
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class Default implements IPolicyBindCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.secureservice.policy.IPolicyBindCallback
        public void onErrored(String str) {
        }

        @Override // com.stepos.secureservice.policy.IPolicyBindCallback
        public void onGet(List<IPolicyBindResult> list, String str, int i, int i3, String str2) {
        }
    }
}
