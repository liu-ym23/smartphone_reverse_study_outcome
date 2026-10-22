package com.stepos.core;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
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
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i6) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IAIEngineService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IAIEngineService.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                IAIAbility ability = getAbility(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeStrongInterface(ability);
            } else {
                if (i != 2) {
                    return super.onTransact(i, parcel, parcel2, i6);
                }
                List<AbilityInfo> abilities = getAbilities();
                parcel2.writeNoException();
                if (abilities == null) {
                    parcel2.writeInt(-1);
                } else {
                    int size = abilities.size();
                    parcel2.writeInt(size);
                    for (int i10 = 0; i10 < size; i10++) {
                        AbilityInfo abilityInfo = abilities.get(i10);
                        if (abilityInfo != null) {
                            parcel2.writeInt(1);
                            abilityInfo.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                    }
                }
            }
            return true;
        }
    }

    List<AbilityInfo> getAbilities() throws RemoteException;

    IAIAbility getAbility(String str, String str2) throws RemoteException;
}
