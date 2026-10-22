package com.stepos.mcp.sdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.stepos.mcp.sdk.IMCPBinderCallback;

/* loaded from: classes3.dex */
public interface IMCPBinderService extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.mcp.sdk.IMCPBinderService";

    public static class Default implements IMCPBinderService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.mcp.sdk.IMCPBinderService
        public void register(String str, IMCPBinderCallback iMCPBinderCallback) {
        }

        @Override // com.stepos.mcp.sdk.IMCPBinderService
        public void request(String str, String str2) {
        }

        @Override // com.stepos.mcp.sdk.IMCPBinderService
        public void unregister(String str) {
        }
    }

    public static abstract class Stub extends Binder implements IMCPBinderService {
        static final int TRANSACTION_register = 1;
        static final int TRANSACTION_request = 3;
        static final int TRANSACTION_unregister = 2;

        public static class Proxy implements IMCPBinderService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IMCPBinderService.DESCRIPTOR;
            }

            @Override // com.stepos.mcp.sdk.IMCPBinderService
            public void register(String str, IMCPBinderCallback iMCPBinderCallback) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMCPBinderService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongInterface(iMCPBinderCallback);
                    this.mRemote.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.mcp.sdk.IMCPBinderService
            public void request(String str, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMCPBinderService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(3, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.mcp.sdk.IMCPBinderService
            public void unregister(String str) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMCPBinderService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IMCPBinderService.DESCRIPTOR);
        }

        public static IMCPBinderService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IMCPBinderService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IMCPBinderService)) ? new Proxy(iBinder) : (IMCPBinderService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i6) {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IMCPBinderService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IMCPBinderService.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                register(parcel.readString(), IMCPBinderCallback.Stub.asInterface(parcel.readStrongBinder()));
            } else if (i == 2) {
                unregister(parcel.readString());
            } else {
                if (i != 3) {
                    return super.onTransact(i, parcel, parcel2, i6);
                }
                request(parcel.readString(), parcel.readString());
            }
            return true;
        }
    }

    void register(String str, IMCPBinderCallback iMCPBinderCallback);

    void request(String str, String str2);

    void unregister(String str);
}
