package com.stepos.mcp.sdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.stepos.mcp.sdk.IMCPBinderCallback;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface IMCPBinderService extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.mcp.sdk.IMCPBinderService";

    void register(String str, IMCPBinderCallback iMCPBinderCallback);

    void request(String str, String str2);

    void unregister(String str);

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static abstract class Stub extends Binder implements IMCPBinderService {
        static final int TRANSACTION_register = 1;
        static final int TRANSACTION_request = 3;
        static final int TRANSACTION_unregister = 2;

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i3) {
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
                    return super.onTransact(i, parcel, parcel2, i3);
                }
                request(parcel.readString(), parcel.readString());
            }
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class Default implements IMCPBinderService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.mcp.sdk.IMCPBinderService
        public void unregister(String str) {
        }

        @Override // com.stepos.mcp.sdk.IMCPBinderService
        public void register(String str, IMCPBinderCallback iMCPBinderCallback) {
        }

        @Override // com.stepos.mcp.sdk.IMCPBinderService
        public void request(String str, String str2) {
        }
    }
}
