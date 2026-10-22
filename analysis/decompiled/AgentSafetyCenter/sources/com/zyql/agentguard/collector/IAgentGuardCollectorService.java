package com.zyql.agentguard.collector;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface IAgentGuardCollectorService extends IInterface {
    public static final String DESCRIPTOR = "com.zyql.agentguard.collector.IAgentGuardCollectorService";

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class Default implements IAgentGuardCollectorService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.zyql.agentguard.collector.IAgentGuardCollectorService
        public ParcelFileDescriptor openBundle(String str) {
            return null;
        }

        @Override // com.zyql.agentguard.collector.IAgentGuardCollectorService
        public a queryStatus(String str) {
            return null;
        }

        @Override // com.zyql.agentguard.collector.IAgentGuardCollectorService
        public String requestCollectOpenClawToday(String str) {
            return null;
        }
    }

    ParcelFileDescriptor openBundle(String str);

    a queryStatus(String str);

    String requestCollectOpenClawToday(String str);

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static abstract class Stub extends Binder implements IAgentGuardCollectorService {
        static final int TRANSACTION_openBundle = 3;
        static final int TRANSACTION_queryStatus = 2;
        static final int TRANSACTION_requestCollectOpenClawToday = 1;

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        public static class Proxy implements IAgentGuardCollectorService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IAgentGuardCollectorService.DESCRIPTOR;
            }

            @Override // com.zyql.agentguard.collector.IAgentGuardCollectorService
            public ParcelFileDescriptor openBundle(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAgentGuardCollectorService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (ParcelFileDescriptor) (parcelObtain2.readInt() != 0 ? ParcelFileDescriptor.CREATOR.createFromParcel(parcelObtain2) : null);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.agentguard.collector.IAgentGuardCollectorService
            public a queryStatus(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAgentGuardCollectorService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? a.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.agentguard.collector.IAgentGuardCollectorService
            public String requestCollectOpenClawToday(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAgentGuardCollectorService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IAgentGuardCollectorService.DESCRIPTOR);
        }

        public static IAgentGuardCollectorService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IAgentGuardCollectorService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IAgentGuardCollectorService)) ? new Proxy(iBinder) : (IAgentGuardCollectorService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i3) {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IAgentGuardCollectorService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IAgentGuardCollectorService.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                String strRequestCollectOpenClawToday = requestCollectOpenClawToday(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(strRequestCollectOpenClawToday);
                return true;
            }
            if (i == 2) {
                a aVarQueryStatus = queryStatus(parcel.readString());
                parcel2.writeNoException();
                if (aVarQueryStatus == null) {
                    parcel2.writeInt(0);
                    return true;
                }
                parcel2.writeInt(1);
                aVarQueryStatus.writeToParcel(parcel2, 1);
                return true;
            }
            if (i != 3) {
                return super.onTransact(i, parcel, parcel2, i3);
            }
            ParcelFileDescriptor parcelFileDescriptorOpenBundle = openBundle(parcel.readString());
            parcel2.writeNoException();
            if (parcelFileDescriptorOpenBundle == null) {
                parcel2.writeInt(0);
                return true;
            }
            parcel2.writeInt(1);
            parcelFileDescriptorOpenBundle.writeToParcel(parcel2, 1);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
