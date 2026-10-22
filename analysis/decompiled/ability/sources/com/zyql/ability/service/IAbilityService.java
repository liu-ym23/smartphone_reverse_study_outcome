package com.zyql.ability.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.zyql.ability.service.IAbilityExecuteCallback;
import com.zyql.ability.service.IAbilityQueryCallback;
import com.zyql.ability.service.model.AbilityExeReqParcelable;

/* loaded from: classes3.dex */
public interface IAbilityService extends IInterface {
    public static final String DESCRIPTOR = "com.zyql.ability.service.IAbilityService";

    public static class Default implements IAbilityService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.zyql.ability.service.IAbilityService
        public String executeAbility(AbilityExeReqParcelable abilityExeReqParcelable, IAbilityExecuteCallback iAbilityExecuteCallback) throws RemoteException {
            return null;
        }

        @Override // com.zyql.ability.service.IAbilityService
        public String getDeviceId() throws RemoteException {
            return null;
        }

        @Override // com.zyql.ability.service.IAbilityService
        public void queryAbilityMetadata(long j5, IAbilityQueryCallback iAbilityQueryCallback) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IAbilityService {
        static final int TRANSACTION_executeAbility = 3;
        static final int TRANSACTION_getDeviceId = 1;
        static final int TRANSACTION_queryAbilityMetadata = 2;

        public static class Proxy implements IAbilityService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.zyql.ability.service.IAbilityService
            public String executeAbility(AbilityExeReqParcelable abilityExeReqParcelable, IAbilityExecuteCallback iAbilityExecuteCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAbilityService.DESCRIPTOR);
                    if (abilityExeReqParcelable != null) {
                        parcelObtain.writeInt(1);
                        abilityExeReqParcelable.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongInterface(iAbilityExecuteCallback);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.ability.service.IAbilityService
            public String getDeviceId() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAbilityService.DESCRIPTOR);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IAbilityService.DESCRIPTOR;
            }

            @Override // com.zyql.ability.service.IAbilityService
            public void queryAbilityMetadata(long j5, IAbilityQueryCallback iAbilityQueryCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAbilityService.DESCRIPTOR);
                    parcelObtain.writeLong(j5);
                    parcelObtain.writeStrongInterface(iAbilityQueryCallback);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IAbilityService.DESCRIPTOR);
        }

        public static IAbilityService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IAbilityService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IAbilityService)) ? new Proxy(iBinder) : (IAbilityService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i6) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IAbilityService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IAbilityService.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                String deviceId = getDeviceId();
                parcel2.writeNoException();
                parcel2.writeString(deviceId);
            } else if (i == 2) {
                queryAbilityMetadata(parcel.readLong(), IAbilityQueryCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
            } else {
                if (i != 3) {
                    return super.onTransact(i, parcel, parcel2, i6);
                }
                String strExecuteAbility = executeAbility((AbilityExeReqParcelable) (parcel.readInt() != 0 ? AbilityExeReqParcelable.CREATOR.createFromParcel(parcel) : null), IAbilityExecuteCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeString(strExecuteAbility);
            }
            return true;
        }
    }

    String executeAbility(AbilityExeReqParcelable abilityExeReqParcelable, IAbilityExecuteCallback iAbilityExecuteCallback) throws RemoteException;

    String getDeviceId() throws RemoteException;

    void queryAbilityMetadata(long j5, IAbilityQueryCallback iAbilityQueryCallback) throws RemoteException;
}
