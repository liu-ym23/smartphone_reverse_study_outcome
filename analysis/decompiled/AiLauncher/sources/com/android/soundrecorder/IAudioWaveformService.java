package com.android.soundrecorder;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.android.soundrecorder.IAudioWaveformCallback;

/* loaded from: classes.dex */
public interface IAudioWaveformService extends IInterface {
    public static final String DESCRIPTOR = "com.android.soundrecorder.IAudioWaveformService";

    public static class Default implements IAudioWaveformService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.android.soundrecorder.IAudioWaveformService
        public String getCurrentTaskId() throws RemoteException {
            return null;
        }

        @Override // com.android.soundrecorder.IAudioWaveformService
        public int getSummaryState(int i10) throws RemoteException {
            return 0;
        }

        @Override // com.android.soundrecorder.IAudioWaveformService
        public boolean isRecording() throws RemoteException {
            return false;
        }

        @Override // com.android.soundrecorder.IAudioWaveformService
        public boolean pauseRecording() throws RemoteException {
            return false;
        }

        @Override // com.android.soundrecorder.IAudioWaveformService
        public void registerCallback(IAudioWaveformCallback iAudioWaveformCallback, String str) throws RemoteException {
        }

        @Override // com.android.soundrecorder.IAudioWaveformService
        public boolean resumeRecording() throws RemoteException {
            return false;
        }

        @Override // com.android.soundrecorder.IAudioWaveformService
        public String startRecording() throws RemoteException {
            return null;
        }

        @Override // com.android.soundrecorder.IAudioWaveformService
        public boolean stopRecording() throws RemoteException {
            return false;
        }

        @Override // com.android.soundrecorder.IAudioWaveformService
        public void unregisterCallback(IAudioWaveformCallback iAudioWaveformCallback, String str) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IAudioWaveformService {
        static final int TRANSACTION_getCurrentTaskId = 5;
        static final int TRANSACTION_getSummaryState = 9;
        static final int TRANSACTION_isRecording = 4;
        static final int TRANSACTION_pauseRecording = 6;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_resumeRecording = 7;
        static final int TRANSACTION_startRecording = 3;
        static final int TRANSACTION_stopRecording = 8;
        static final int TRANSACTION_unregisterCallback = 2;

        public static class Proxy implements IAudioWaveformService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.android.soundrecorder.IAudioWaveformService
            public String getCurrentTaskId() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAudioWaveformService.DESCRIPTOR);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IAudioWaveformService.DESCRIPTOR;
            }

            @Override // com.android.soundrecorder.IAudioWaveformService
            public int getSummaryState(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAudioWaveformService.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.android.soundrecorder.IAudioWaveformService
            public boolean isRecording() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAudioWaveformService.DESCRIPTOR);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.android.soundrecorder.IAudioWaveformService
            public boolean pauseRecording() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAudioWaveformService.DESCRIPTOR);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.android.soundrecorder.IAudioWaveformService
            public void registerCallback(IAudioWaveformCallback iAudioWaveformCallback, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAudioWaveformService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iAudioWaveformCallback);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.android.soundrecorder.IAudioWaveformService
            public boolean resumeRecording() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAudioWaveformService.DESCRIPTOR);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.android.soundrecorder.IAudioWaveformService
            public String startRecording() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAudioWaveformService.DESCRIPTOR);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.android.soundrecorder.IAudioWaveformService
            public boolean stopRecording() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAudioWaveformService.DESCRIPTOR);
                    this.mRemote.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.android.soundrecorder.IAudioWaveformService
            public void unregisterCallback(IAudioWaveformCallback iAudioWaveformCallback, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAudioWaveformService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iAudioWaveformCallback);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IAudioWaveformService.DESCRIPTOR);
        }

        public static IAudioWaveformService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IAudioWaveformService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IAudioWaveformService)) ? new Proxy(iBinder) : (IAudioWaveformService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IAudioWaveformService.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IAudioWaveformService.DESCRIPTOR);
                return true;
            }
            switch (i10) {
                case 1:
                    registerCallback(IAudioWaveformCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    unregisterCallback(IAudioWaveformCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    String strStartRecording = startRecording();
                    parcel2.writeNoException();
                    parcel2.writeString(strStartRecording);
                    return true;
                case 4:
                    boolean zIsRecording = isRecording();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsRecording ? 1 : 0);
                    return true;
                case 5:
                    String currentTaskId = getCurrentTaskId();
                    parcel2.writeNoException();
                    parcel2.writeString(currentTaskId);
                    return true;
                case 6:
                    boolean zPauseRecording = pauseRecording();
                    parcel2.writeNoException();
                    parcel2.writeInt(zPauseRecording ? 1 : 0);
                    return true;
                case 7:
                    boolean zResumeRecording = resumeRecording();
                    parcel2.writeNoException();
                    parcel2.writeInt(zResumeRecording ? 1 : 0);
                    return true;
                case 8:
                    boolean zStopRecording = stopRecording();
                    parcel2.writeNoException();
                    parcel2.writeInt(zStopRecording ? 1 : 0);
                    return true;
                case 9:
                    int summaryState = getSummaryState(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(summaryState);
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }
    }

    String getCurrentTaskId() throws RemoteException;

    int getSummaryState(int i10) throws RemoteException;

    boolean isRecording() throws RemoteException;

    boolean pauseRecording() throws RemoteException;

    void registerCallback(IAudioWaveformCallback iAudioWaveformCallback, String str) throws RemoteException;

    boolean resumeRecording() throws RemoteException;

    String startRecording() throws RemoteException;

    boolean stopRecording() throws RemoteException;

    void unregisterCallback(IAudioWaveformCallback iAudioWaveformCallback, String str) throws RemoteException;
}
