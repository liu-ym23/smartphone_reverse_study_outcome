package com.android.soundrecorder;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IAudioWaveformCallback extends IInterface {
    public static final String DESCRIPTOR = "com.android.soundrecorder.IAudioWaveformCallback";

    public static class Default implements IAudioWaveformCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.android.soundrecorder.IAudioWaveformCallback
        public void onRecordingStateChanged(String str, int i10) throws RemoteException {
        }

        @Override // com.android.soundrecorder.IAudioWaveformCallback
        public void onSummaryStateChanged(int i10, int i11, String str) throws RemoteException {
        }

        @Override // com.android.soundrecorder.IAudioWaveformCallback
        public void onWaveformData(int i10, long j10, long j11) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IAudioWaveformCallback {
        static final int TRANSACTION_onRecordingStateChanged = 2;
        static final int TRANSACTION_onSummaryStateChanged = 3;
        static final int TRANSACTION_onWaveformData = 1;

        public static class Proxy implements IAudioWaveformCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IAudioWaveformCallback.DESCRIPTOR;
            }

            @Override // com.android.soundrecorder.IAudioWaveformCallback
            public void onRecordingStateChanged(String str, int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAudioWaveformCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.android.soundrecorder.IAudioWaveformCallback
            public void onSummaryStateChanged(int i10, int i11, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAudioWaveformCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeInt(i11);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.android.soundrecorder.IAudioWaveformCallback
            public void onWaveformData(int i10, long j10, long j11) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAudioWaveformCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeLong(j10);
                    parcelObtain.writeLong(j11);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IAudioWaveformCallback.DESCRIPTOR);
        }

        public static IAudioWaveformCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IAudioWaveformCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IAudioWaveformCallback)) ? new Proxy(iBinder) : (IAudioWaveformCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IAudioWaveformCallback.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IAudioWaveformCallback.DESCRIPTOR);
                return true;
            }
            if (i10 == 1) {
                onWaveformData(parcel.readInt(), parcel.readLong(), parcel.readLong());
                parcel2.writeNoException();
            } else if (i10 == 2) {
                onRecordingStateChanged(parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
            } else {
                if (i10 != 3) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                onSummaryStateChanged(parcel.readInt(), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
            }
            return true;
        }
    }

    void onRecordingStateChanged(String str, int i10) throws RemoteException;

    void onSummaryStateChanged(int i10, int i11, String str) throws RemoteException;

    void onWaveformData(int i10, long j10, long j11) throws RemoteException;
}
