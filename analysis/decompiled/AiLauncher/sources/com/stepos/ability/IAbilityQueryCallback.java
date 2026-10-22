package com.stepos.ability;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.stepos.ability.bean.AbilityMetadataParcelable;
import java.util.List;

/* loaded from: classes2.dex */
public interface IAbilityQueryCallback extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.ability.IAbilityQueryCallback";

    public static class Default implements IAbilityQueryCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.ability.IAbilityQueryCallback
        public void onComplete(boolean z10, String str, List<AbilityMetadataParcelable> list) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IAbilityQueryCallback {
        static final int TRANSACTION_onComplete = 1;

        public static class Proxy implements IAbilityQueryCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IAbilityQueryCallback.DESCRIPTOR;
            }

            @Override // com.stepos.ability.IAbilityQueryCallback
            public void onComplete(boolean z10, String str, List<AbilityMetadataParcelable> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAbilityQueryCallback.DESCRIPTOR);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    parcelObtain.writeString(str);
                    a.b(parcelObtain, list, 0);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IAbilityQueryCallback.DESCRIPTOR);
        }

        public static IAbilityQueryCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IAbilityQueryCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IAbilityQueryCallback)) ? new Proxy(iBinder) : (IAbilityQueryCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IAbilityQueryCallback.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IAbilityQueryCallback.DESCRIPTOR);
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            onComplete(parcel.readInt() != 0, parcel.readString(), parcel.createTypedArrayList(AbilityMetadataParcelable.INSTANCE));
            parcel2.writeNoException();
            return true;
        }
    }

    public static class a {
        public static <T extends Parcelable> void b(Parcel parcel, List<T> list, int i10) {
            if (list == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = list.size();
            parcel.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                c(parcel, list.get(i11), i10);
            }
        }

        public static <T extends Parcelable> void c(Parcel parcel, T t10, int i10) {
            if (t10 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t10.writeToParcel(parcel, i10);
            }
        }
    }

    void onComplete(boolean z10, String str, List<AbilityMetadataParcelable> list) throws RemoteException;
}
