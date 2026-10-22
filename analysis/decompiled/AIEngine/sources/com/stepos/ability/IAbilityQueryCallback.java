package com.stepos.ability;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.stepos.ability.bean.AbilityMetadataParcelable;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface IAbilityQueryCallback extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.ability.IAbilityQueryCallback";

    void onComplete(boolean z, String str, List<AbilityMetadataParcelable> list);

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class Stub extends Binder implements IAbilityQueryCallback {
        static final int TRANSACTION_onComplete = 1;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
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
            public void onComplete(boolean z, String str, List<AbilityMetadataParcelable> list) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAbilityQueryCallback.DESCRIPTOR);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeString(str);
                    if (list == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        int size = list.size();
                        parcelObtain.writeInt(size);
                        for (int i10 = 0; i10 < size; i10++) {
                            AbilityMetadataParcelable abilityMetadataParcelable = list.get(i10);
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

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
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
            onComplete(parcel.readInt() != 0, parcel.readString(), parcel.createTypedArrayList(AbilityMetadataParcelable.CREATOR));
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class Default implements IAbilityQueryCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.ability.IAbilityQueryCallback
        public void onComplete(boolean z, String str, List<AbilityMetadataParcelable> list) {
        }
    }
}
