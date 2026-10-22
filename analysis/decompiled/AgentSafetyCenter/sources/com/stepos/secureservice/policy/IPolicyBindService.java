package com.stepos.secureservice.policy;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.stepos.secureservice.policy.IPolicyBindCallback;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface IPolicyBindService extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.secureservice.policy.IPolicyBindService";

    void getPrivateConfig(IPolicyBindCallback iPolicyBindCallback, String str, int i, String str2);

    void getPublicConfig(IPolicyBindCallback iPolicyBindCallback, String str, int i);

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static abstract class Stub extends Binder implements IPolicyBindService {
        static final int TRANSACTION_getPrivateConfig = 2;
        static final int TRANSACTION_getPublicConfig = 1;

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        public static class Proxy implements IPolicyBindService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IPolicyBindService.DESCRIPTOR;
            }

            @Override // com.stepos.secureservice.policy.IPolicyBindService
            public void getPrivateConfig(IPolicyBindCallback iPolicyBindCallback, String str, int i, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IPolicyBindService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iPolicyBindCallback);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.secureservice.policy.IPolicyBindService
            public void getPublicConfig(IPolicyBindCallback iPolicyBindCallback, String str, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IPolicyBindService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iPolicyBindCallback);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IPolicyBindService.DESCRIPTOR);
        }

        public static IPolicyBindService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IPolicyBindService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IPolicyBindService)) ? new Proxy(iBinder) : (IPolicyBindService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i3) {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IPolicyBindService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IPolicyBindService.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                getPublicConfig(IPolicyBindCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
            } else {
                if (i != 2) {
                    return super.onTransact(i, parcel, parcel2, i3);
                }
                getPrivateConfig(IPolicyBindCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
            }
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class Default implements IPolicyBindService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.secureservice.policy.IPolicyBindService
        public void getPublicConfig(IPolicyBindCallback iPolicyBindCallback, String str, int i) {
        }

        @Override // com.stepos.secureservice.policy.IPolicyBindService
        public void getPrivateConfig(IPolicyBindCallback iPolicyBindCallback, String str, int i, String str2) {
        }
    }
}
