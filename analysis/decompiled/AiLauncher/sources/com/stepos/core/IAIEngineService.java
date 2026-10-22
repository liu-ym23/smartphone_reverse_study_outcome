package com.stepos.core;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.stepos.core.ability.AbilityInfo;
import com.stepos.core.ability.IAIAbility;
import java.util.List;

/* loaded from: classes3.dex */
public interface IAIEngineService extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.core.IAIEngineService";

    public static class Default implements IAIEngineService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.core.IAIEngineService
        public List<AbilityInfo> getAbilities() throws RemoteException {
            return null;
        }

        @Override // com.stepos.core.IAIEngineService
        public IAIAbility getAbility(String str, String str2) throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IAIEngineService {
        static final int TRANSACTION_getAbilities = 2;
        static final int TRANSACTION_getAbility = 1;

        public static class Proxy implements IAIEngineService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.stepos.core.IAIEngineService
            public List<AbilityInfo> getAbilities() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAIEngineService.DESCRIPTOR);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(AbilityInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.core.IAIEngineService
            public IAIAbility getAbility(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAIEngineService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return IAIAbility.Stub.asInterface(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IAIEngineService.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, IAIEngineService.DESCRIPTOR);
        }

        public static IAIEngineService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IAIEngineService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IAIEngineService)) ? new Proxy(iBinder) : (IAIEngineService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IAIEngineService.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IAIEngineService.DESCRIPTOR);
                return true;
            }
            if (i10 == 1) {
                IAIAbility ability = getAbility(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeStrongInterface(ability);
            } else {
                if (i10 != 2) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                List<AbilityInfo> abilities = getAbilities();
                parcel2.writeNoException();
                _Parcel.writeTypedList(parcel2, abilities, 1);
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
        public static <T extends Parcelable> void writeTypedList(Parcel parcel, List<T> list, int i10) {
            if (list == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = list.size();
            parcel.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                writeTypedObject(parcel, list.get(i11), i10);
            }
        }

        private static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t10, int i10) {
            if (t10 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t10.writeToParcel(parcel, i10);
            }
        }
    }

    List<AbilityInfo> getAbilities() throws RemoteException;

    IAIAbility getAbility(String str, String str2) throws RemoteException;
}
