package com.stepos.mcp.sdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes3.dex */
public interface IMCPBinderCallback extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.mcp.sdk.IMCPBinderCallback";

    public static class Default implements IMCPBinderCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.mcp.sdk.IMCPBinderCallback
        public void onFailure(String str) {
        }

        @Override // com.stepos.mcp.sdk.IMCPBinderCallback
        public void onSuccess(String str) {
        }
    }

    public static abstract class Stub extends Binder implements IMCPBinderCallback {
        static final int TRANSACTION_onFailure = 2;
        static final int TRANSACTION_onSuccess = 1;

        public static class Proxy implements IMCPBinderCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IMCPBinderCallback.DESCRIPTOR;
            }

            @Override // com.stepos.mcp.sdk.IMCPBinderCallback
            public void onFailure(String str) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMCPBinderCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.mcp.sdk.IMCPBinderCallback
            public void onSuccess(String str) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMCPBinderCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IMCPBinderCallback.DESCRIPTOR);
        }

        public static IMCPBinderCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IMCPBinderCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IMCPBinderCallback)) ? new Proxy(iBinder) : (IMCPBinderCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i6) {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IMCPBinderCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IMCPBinderCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onSuccess(parcel.readString());
            } else {
                if (i != 2) {
                    return super.onTransact(i, parcel, parcel2, i6);
                }
                onFailure(parcel.readString());
            }
            return true;
        }
    }

    void onFailure(String str);

    void onSuccess(String str);
}
