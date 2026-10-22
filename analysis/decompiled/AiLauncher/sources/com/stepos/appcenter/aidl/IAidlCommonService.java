package com.stepos.appcenter.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.stepos.appcenter.aidl.ICommonCallback;

/* loaded from: classes3.dex */
public interface IAidlCommonService extends IInterface {

    public static class Default implements IAidlCommonService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.appcenter.aidl.IAidlCommonService
        public void doAction(BaseAidlMsg baseAidlMsg, ICommonCallback iCommonCallback) throws RemoteException {
        }

        @Override // com.stepos.appcenter.aidl.IAidlCommonService
        public BaseAidlMsg getData(BaseAidlMsg baseAidlMsg, ICommonCallback iCommonCallback) throws RemoteException {
            return null;
        }

        @Override // com.stepos.appcenter.aidl.IAidlCommonService
        public int hasPrivacyAgreed() throws RemoteException {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements IAidlCommonService {
        private static final String DESCRIPTOR = "com.stepos.appcenter.aidl.IAidlCommonService";
        static final int TRANSACTION_doAction = 1;
        static final int TRANSACTION_getData = 2;
        static final int TRANSACTION_hasPrivacyAgreed = 3;

        public static class Proxy implements IAidlCommonService {
            public static IAidlCommonService sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.stepos.appcenter.aidl.IAidlCommonService
            public void doAction(BaseAidlMsg baseAidlMsg, ICommonCallback iCommonCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (baseAidlMsg != null) {
                        parcelObtain.writeInt(1);
                        baseAidlMsg.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iCommonCallback != null ? iCommonCallback.asBinder() : null);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().doAction(baseAidlMsg, iCommonCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.stepos.appcenter.aidl.IAidlCommonService
            public BaseAidlMsg getData(BaseAidlMsg baseAidlMsg, ICommonCallback iCommonCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (baseAidlMsg != null) {
                        parcelObtain.writeInt(1);
                        baseAidlMsg.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iCommonCallback != null ? iCommonCallback.asBinder() : null);
                    if (!this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        BaseAidlMsg data = Stub.getDefaultImpl().getData(baseAidlMsg, iCommonCallback);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return data;
                    }
                    parcelObtain2.readException();
                    BaseAidlMsg baseAidlMsgCreateFromParcel = parcelObtain2.readInt() != 0 ? BaseAidlMsg.CREATOR.createFromParcel(parcelObtain2) : null;
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return baseAidlMsgCreateFromParcel;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.stepos.appcenter.aidl.IAidlCommonService
            public int hasPrivacyAgreed() throws RemoteException {
                int iHasPrivacyAgreed;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iHasPrivacyAgreed = parcelObtain2.readInt();
                    } else {
                        iHasPrivacyAgreed = Stub.getDefaultImpl().hasPrivacyAgreed();
                    }
                    return iHasPrivacyAgreed;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IAidlCommonService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IAidlCommonService)) ? new Proxy(iBinder) : (IAidlCommonService) iInterfaceQueryLocalInterface;
        }

        public static IAidlCommonService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IAidlCommonService iAidlCommonService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iAidlCommonService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iAidlCommonService;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                doAction(parcel.readInt() != 0 ? BaseAidlMsg.CREATOR.createFromParcel(parcel) : null, ICommonCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i10 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                BaseAidlMsg data = getData(parcel.readInt() != 0 ? BaseAidlMsg.CREATOR.createFromParcel(parcel) : null, ICommonCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                if (data != null) {
                    parcel2.writeInt(1);
                    data.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            if (i10 != 3) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            int iHasPrivacyAgreed = hasPrivacyAgreed();
            parcel2.writeNoException();
            parcel2.writeInt(iHasPrivacyAgreed);
            return true;
        }
    }

    void doAction(BaseAidlMsg baseAidlMsg, ICommonCallback iCommonCallback) throws RemoteException;

    BaseAidlMsg getData(BaseAidlMsg baseAidlMsg, ICommonCallback iCommonCallback) throws RemoteException;

    int hasPrivacyAgreed() throws RemoteException;
}
