package com.stepos.ability;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public interface IScreenOpsService extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.ability.IScreenOpsService";

    public static class Default implements IScreenOpsService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.ability.IScreenOpsService
        public Bundle getEditContent(Bundle bundle) throws RemoteException {
            return null;
        }

        @Override // com.stepos.ability.IScreenOpsService
        public Bundle setEditContent(Bundle bundle, String str) throws RemoteException {
            return null;
        }

        @Override // com.stepos.ability.IScreenOpsService
        public Bundle setEditContentBatch(Bundle bundle) throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IScreenOpsService {
        static final int TRANSACTION_getEditContent = 3;
        static final int TRANSACTION_setEditContent = 1;
        static final int TRANSACTION_setEditContentBatch = 2;

        public static class Proxy implements IScreenOpsService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.stepos.ability.IScreenOpsService
            public Bundle getEditContent(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IScreenOpsService.DESCRIPTOR);
                    a.d(parcelObtain, bundle, 0);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Bundle) a.c(parcelObtain2, Bundle.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IScreenOpsService.DESCRIPTOR;
            }

            @Override // com.stepos.ability.IScreenOpsService
            public Bundle setEditContent(Bundle bundle, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IScreenOpsService.DESCRIPTOR);
                    a.d(parcelObtain, bundle, 0);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Bundle) a.c(parcelObtain2, Bundle.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IScreenOpsService
            public Bundle setEditContentBatch(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IScreenOpsService.DESCRIPTOR);
                    a.d(parcelObtain, bundle, 0);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Bundle) a.c(parcelObtain2, Bundle.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IScreenOpsService.DESCRIPTOR);
        }

        public static IScreenOpsService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IScreenOpsService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IScreenOpsService)) ? new Proxy(iBinder) : (IScreenOpsService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IScreenOpsService.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IScreenOpsService.DESCRIPTOR);
                return true;
            }
            if (i10 == 1) {
                Bundle editContent = setEditContent((Bundle) a.c(parcel, Bundle.CREATOR), parcel.readString());
                parcel2.writeNoException();
                a.d(parcel2, editContent, 1);
            } else if (i10 == 2) {
                Bundle editContentBatch = setEditContentBatch((Bundle) a.c(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                a.d(parcel2, editContentBatch, 1);
            } else {
                if (i10 != 3) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                Bundle editContent2 = getEditContent((Bundle) a.c(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                a.d(parcel2, editContent2, 1);
            }
            return true;
        }
    }

    public static class a {
        public static <T> T c(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        public static <T extends Parcelable> void d(Parcel parcel, T t10, int i10) {
            if (t10 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t10.writeToParcel(parcel, i10);
            }
        }
    }

    Bundle getEditContent(Bundle bundle) throws RemoteException;

    Bundle setEditContent(Bundle bundle, String str) throws RemoteException;

    Bundle setEditContentBatch(Bundle bundle) throws RemoteException;
}
