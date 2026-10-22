package com.stepos.ability;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface IScreenOpsService extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.ability.IScreenOpsService";

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class Default implements IScreenOpsService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.ability.IScreenOpsService
        public Bundle getEditContent(Bundle bundle) {
            return null;
        }

        @Override // com.stepos.ability.IScreenOpsService
        public Bundle setEditContent(Bundle bundle, String str) {
            return null;
        }

        @Override // com.stepos.ability.IScreenOpsService
        public Bundle setEditContentBatch(Bundle bundle) {
            return null;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {
        public static Object a(Parcel parcel, Parcelable.Creator creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        public static void b(Parcel parcel, Bundle bundle, int i10) {
            if (bundle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, i10);
            }
        }
    }

    Bundle getEditContent(Bundle bundle);

    Bundle setEditContent(Bundle bundle, String str);

    Bundle setEditContentBatch(Bundle bundle);

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class Stub extends Binder implements IScreenOpsService {
        static final int TRANSACTION_getEditContent = 3;
        static final int TRANSACTION_setEditContent = 1;
        static final int TRANSACTION_setEditContentBatch = 2;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
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
            public Bundle getEditContent(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IScreenOpsService.DESCRIPTOR);
                    a.b(parcelObtain, bundle, 0);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Bundle) a.a(parcelObtain2, Bundle.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IScreenOpsService.DESCRIPTOR;
            }

            @Override // com.stepos.ability.IScreenOpsService
            public Bundle setEditContent(Bundle bundle, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IScreenOpsService.DESCRIPTOR);
                    a.b(parcelObtain, bundle, 0);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Bundle) a.a(parcelObtain2, Bundle.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IScreenOpsService
            public Bundle setEditContentBatch(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IScreenOpsService.DESCRIPTOR);
                    a.b(parcelObtain, bundle, 0);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Bundle) a.a(parcelObtain2, Bundle.CREATOR);
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

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IScreenOpsService.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IScreenOpsService.DESCRIPTOR);
                return true;
            }
            if (i10 == 1) {
                Bundle editContent = setEditContent((Bundle) a.a(parcel, Bundle.CREATOR), parcel.readString());
                parcel2.writeNoException();
                a.b(parcel2, editContent, 1);
                return true;
            }
            if (i10 == 2) {
                Bundle editContentBatch = setEditContentBatch((Bundle) a.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                a.b(parcel2, editContentBatch, 1);
                return true;
            }
            if (i10 != 3) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            Bundle editContent2 = getEditContent((Bundle) a.a(parcel, Bundle.CREATOR));
            parcel2.writeNoException();
            a.b(parcel2, editContent2, 1);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
