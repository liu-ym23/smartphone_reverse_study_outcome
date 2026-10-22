package com.stepos.core.ota;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface IOtaTaskListener extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.core.ota.IOtaTaskListener";

    void onIdleExitRequested();

    void onTaskUpdate(String str, int i10, int i11, int i12, long j10, long j11, int[] iArr, boolean z);

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class Default implements IOtaTaskListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.core.ota.IOtaTaskListener
        public void onIdleExitRequested() {
        }

        @Override // com.stepos.core.ota.IOtaTaskListener
        public void onTaskUpdate(String str, int i10, int i11, int i12, long j10, long j11, int[] iArr, boolean z) {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class Stub extends Binder implements IOtaTaskListener {
        static final int TRANSACTION_onIdleExitRequested = 2;
        static final int TRANSACTION_onTaskUpdate = 1;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static class Proxy implements IOtaTaskListener {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IOtaTaskListener.DESCRIPTOR;
            }

            @Override // com.stepos.core.ota.IOtaTaskListener
            public void onIdleExitRequested() {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IOtaTaskListener.DESCRIPTOR);
                    this.mRemote.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.core.ota.IOtaTaskListener
            public void onTaskUpdate(String str, int i10, int i11, int i12, long j10, long j11, int[] iArr, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IOtaTaskListener.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeInt(i11);
                    parcelObtain.writeInt(i12);
                    parcelObtain.writeLong(j10);
                    parcelObtain.writeLong(j11);
                    parcelObtain.writeIntArray(iArr);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IOtaTaskListener.DESCRIPTOR);
        }

        public static IOtaTaskListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IOtaTaskListener.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IOtaTaskListener)) ? new Proxy(iBinder) : (IOtaTaskListener) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IOtaTaskListener.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IOtaTaskListener.DESCRIPTOR);
                return true;
            }
            if (i10 == 1) {
                onTaskUpdate(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readLong(), parcel.createIntArray(), parcel.readInt() != 0);
            } else {
                if (i10 != 2) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                onIdleExitRequested();
            }
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
