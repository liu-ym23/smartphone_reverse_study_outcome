package com.stepos.secureservice.certification;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.secureservice.certification.IEncryptCallback;
import com.stepos.secureservice.certification.IEncryptCallbackV2;
import com.stepos.secureservice.certification.IEncryptMultiCallback;
import com.stepos.secureservice.certification.IOAIDCallback;
import com.stepos.secureservice.certification.ISafeGetPublicKeyCallback;
import com.stepos.secureservice.certification.ISafeRSASignCallback;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface ISafeCertService extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.secureservice.certification.ISafeCertService";

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t8, int i10) {
            if (t8 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t8.writeToParcel(parcel, i10);
            }
        }
    }

    void encrypt(byte[] bArr, IEncryptCallback iEncryptCallback);

    void encryptMulti(List<String> list, IEncryptMultiCallback iEncryptMultiCallback);

    void encryptV2(int i10, Bundle bundle, IEncryptCallbackV2 iEncryptCallbackV2);

    void getOAID(IOAIDCallback iOAIDCallback);

    void getSafePublicKey(ISafeGetPublicKeyCallback iSafeGetPublicKeyCallback);

    void rsaSign(byte[] bArr, ISafeRSASignCallback iSafeRSASignCallback);

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class Stub extends Binder implements ISafeCertService {
        static final int TRANSACTION_encrypt = 2;
        static final int TRANSACTION_encryptMulti = 3;
        static final int TRANSACTION_encryptV2 = 4;
        static final int TRANSACTION_getOAID = 1;
        static final int TRANSACTION_getSafePublicKey = 5;
        static final int TRANSACTION_rsaSign = 6;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static class Proxy implements ISafeCertService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.stepos.secureservice.certification.ISafeCertService
            public void encrypt(byte[] bArr, IEncryptCallback iEncryptCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISafeCertService.DESCRIPTOR);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeStrongInterface(iEncryptCallback);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.secureservice.certification.ISafeCertService
            public void encryptMulti(List<String> list, IEncryptMultiCallback iEncryptMultiCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISafeCertService.DESCRIPTOR);
                    parcelObtain.writeStringList(list);
                    parcelObtain.writeStrongInterface(iEncryptMultiCallback);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.secureservice.certification.ISafeCertService
            public void encryptV2(int i10, Bundle bundle, IEncryptCallbackV2 iEncryptCallbackV2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISafeCertService.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    parcelObtain.writeStrongInterface(iEncryptCallbackV2);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return ISafeCertService.DESCRIPTOR;
            }

            @Override // com.stepos.secureservice.certification.ISafeCertService
            public void getOAID(IOAIDCallback iOAIDCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISafeCertService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iOAIDCallback);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.secureservice.certification.ISafeCertService
            public void getSafePublicKey(ISafeGetPublicKeyCallback iSafeGetPublicKeyCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISafeCertService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iSafeGetPublicKeyCallback);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.secureservice.certification.ISafeCertService
            public void rsaSign(byte[] bArr, ISafeRSASignCallback iSafeRSASignCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISafeCertService.DESCRIPTOR);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeStrongInterface(iSafeRSASignCallback);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ISafeCertService.DESCRIPTOR);
        }

        public static ISafeCertService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ISafeCertService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ISafeCertService)) ? new Proxy(iBinder) : (ISafeCertService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(ISafeCertService.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(ISafeCertService.DESCRIPTOR);
                return true;
            }
            switch (i10) {
                case 1:
                    getOAID(IOAIDCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    encrypt(parcel.createByteArray(), IEncryptCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    encryptMulti(parcel.createStringArrayList(), IEncryptMultiCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    encryptV2(parcel.readInt(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR), IEncryptCallbackV2.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    getSafePublicKey(ISafeGetPublicKeyCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    rsaSign(parcel.createByteArray(), ISafeRSASignCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class Default implements ISafeCertService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.secureservice.certification.ISafeCertService
        public void getOAID(IOAIDCallback iOAIDCallback) {
        }

        @Override // com.stepos.secureservice.certification.ISafeCertService
        public void getSafePublicKey(ISafeGetPublicKeyCallback iSafeGetPublicKeyCallback) {
        }

        @Override // com.stepos.secureservice.certification.ISafeCertService
        public void encrypt(byte[] bArr, IEncryptCallback iEncryptCallback) {
        }

        @Override // com.stepos.secureservice.certification.ISafeCertService
        public void encryptMulti(List<String> list, IEncryptMultiCallback iEncryptMultiCallback) {
        }

        @Override // com.stepos.secureservice.certification.ISafeCertService
        public void rsaSign(byte[] bArr, ISafeRSASignCallback iSafeRSASignCallback) {
        }

        @Override // com.stepos.secureservice.certification.ISafeCertService
        public void encryptV2(int i10, Bundle bundle, IEncryptCallbackV2 iEncryptCallbackV2) {
        }
    }
}
