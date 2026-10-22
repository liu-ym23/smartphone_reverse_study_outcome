package com.stepos.ability;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.stepos.ability.bean.AbilityMetadataParcelable;
import java.util.List;

/* loaded from: classes3.dex */
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
                    if (list == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        int size = list.size();
                        parcelObtain.writeInt(size);
                        for (int i = 0; i < size; i++) {
                            AbilityMetadataParcelable abilityMetadataParcelable = list.get(i);
                            if (abilityMetadataParcelable != null) {
                                parcelObtain.writeInt(1);
                                abilityMetadataParcelable.writeToParcel(parcelObtain, 0);
                            } else {
                                parcelObtain.writeInt(0);
                            }
                        }
                    }
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
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i6) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IAbilityQueryCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IAbilityQueryCallback.DESCRIPTOR);
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i6);
            }
            onComplete(parcel.readInt() != 0, parcel.readString(), parcel.createTypedArrayList(AbilityMetadataParcelable.INSTANCE));
            parcel2.writeNoException();
            return true;
        }
    }

    void onComplete(boolean z10, String str, List<AbilityMetadataParcelable> list) throws RemoteException;
}
