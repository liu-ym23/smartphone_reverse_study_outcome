package com.zyql.screenperception.api;

import a.AbstractC0291a;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.zyql.screenperception.api.IViewInspectionCallback;

/* loaded from: classes2.dex */
public interface IViewInspection extends IInterface {
    public static final String DESCRIPTOR = "com.zyql.screenperception.api.IViewInspection";

    public static class Default implements IViewInspection {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.zyql.screenperception.api.IViewInspection
        public String getRecentEvents(int i, Bundle bundle) throws RemoteException {
            return null;
        }

        @Override // com.zyql.screenperception.api.IViewInspection
        public String getViewDetails(String str, Bundle bundle) throws RemoteException {
            return null;
        }

        @Override // com.zyql.screenperception.api.IViewInspection
        public String getViewTree(Bundle bundle) throws RemoteException {
            return null;
        }

        @Override // com.zyql.screenperception.api.IViewInspection
        public void getViewTreeAsync(Bundle bundle, IViewInspectionCallback iViewInspectionCallback) throws RemoteException {
        }

        @Override // com.zyql.screenperception.api.IViewInspection
        public void listenForEvents(int i, Bundle bundle, IViewInspectionCallback iViewInspectionCallback) throws RemoteException {
        }

        @Override // com.zyql.screenperception.api.IViewInspection
        public void stopEventListening(int i) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IViewInspection {
        static final int TRANSACTION_getRecentEvents = 6;
        static final int TRANSACTION_getViewDetails = 5;
        static final int TRANSACTION_getViewTree = 1;
        static final int TRANSACTION_getViewTreeAsync = 2;
        static final int TRANSACTION_listenForEvents = 3;
        static final int TRANSACTION_stopEventListening = 4;

        public static class Proxy implements IViewInspection {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IViewInspection.DESCRIPTOR;
            }

            @Override // com.zyql.screenperception.api.IViewInspection
            public String getRecentEvents(int i, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IViewInspection.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    AbstractC0291a.b(parcelObtain, bundle);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.screenperception.api.IViewInspection
            public String getViewDetails(String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IViewInspection.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    AbstractC0291a.b(parcelObtain, bundle);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.screenperception.api.IViewInspection
            public String getViewTree(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IViewInspection.DESCRIPTOR);
                    AbstractC0291a.b(parcelObtain, bundle);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.screenperception.api.IViewInspection
            public void getViewTreeAsync(Bundle bundle, IViewInspectionCallback iViewInspectionCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IViewInspection.DESCRIPTOR);
                    AbstractC0291a.b(parcelObtain, bundle);
                    parcelObtain.writeStrongInterface(iViewInspectionCallback);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.screenperception.api.IViewInspection
            public void listenForEvents(int i, Bundle bundle, IViewInspectionCallback iViewInspectionCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IViewInspection.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    AbstractC0291a.b(parcelObtain, bundle);
                    parcelObtain.writeStrongInterface(iViewInspectionCallback);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.screenperception.api.IViewInspection
            public void stopEventListening(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IViewInspection.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IViewInspection.DESCRIPTOR);
        }

        public static IViewInspection asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IViewInspection.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IViewInspection)) ? new Proxy(iBinder) : (IViewInspection) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i6) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IViewInspection.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IViewInspection.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    Parcelable.Creator creator = Bundle.CREATOR;
                    String viewTree = getViewTree((Bundle) AbstractC0291a.a(parcel));
                    parcel2.writeNoException();
                    parcel2.writeString(viewTree);
                    return true;
                case 2:
                    Parcelable.Creator creator2 = Bundle.CREATOR;
                    getViewTreeAsync((Bundle) AbstractC0291a.a(parcel), IViewInspectionCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    int i10 = parcel.readInt();
                    Parcelable.Creator creator3 = Bundle.CREATOR;
                    listenForEvents(i10, (Bundle) AbstractC0291a.a(parcel), IViewInspectionCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    stopEventListening(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    String string = parcel.readString();
                    Parcelable.Creator creator4 = Bundle.CREATOR;
                    String viewDetails = getViewDetails(string, (Bundle) AbstractC0291a.a(parcel));
                    parcel2.writeNoException();
                    parcel2.writeString(viewDetails);
                    return true;
                case 6:
                    int i11 = parcel.readInt();
                    Parcelable.Creator creator5 = Bundle.CREATOR;
                    String recentEvents = getRecentEvents(i11, (Bundle) AbstractC0291a.a(parcel));
                    parcel2.writeNoException();
                    parcel2.writeString(recentEvents);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i6);
            }
        }
    }

    String getRecentEvents(int i, Bundle bundle) throws RemoteException;

    String getViewDetails(String str, Bundle bundle) throws RemoteException;

    String getViewTree(Bundle bundle) throws RemoteException;

    void getViewTreeAsync(Bundle bundle, IViewInspectionCallback iViewInspectionCallback) throws RemoteException;

    void listenForEvents(int i, Bundle bundle, IViewInspectionCallback iViewInspectionCallback) throws RemoteException;

    void stopEventListening(int i) throws RemoteException;
}
