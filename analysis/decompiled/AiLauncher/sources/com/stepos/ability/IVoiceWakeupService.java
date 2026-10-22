package com.stepos.ability;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.stepos.ability.IVoiceWakeupCallback;

/* loaded from: classes2.dex */
public interface IVoiceWakeupService extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.ability.IVoiceWakeupService";

    public static class Default implements IVoiceWakeupService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.ability.IVoiceWakeupService
        public void clearVoiceprint() throws RemoteException {
        }

        @Override // com.stepos.ability.IVoiceWakeupService
        public void clearVoiceprintFor(String str) throws RemoteException {
        }

        @Override // com.stepos.ability.IVoiceWakeupService
        public String[] getTrainedWordIds() throws RemoteException {
            return null;
        }

        @Override // com.stepos.ability.IVoiceWakeupService
        public boolean hasVoiceprintModel() throws RemoteException {
            return false;
        }

        @Override // com.stepos.ability.IVoiceWakeupService
        public boolean hasVoiceprintModelFor(String str) throws RemoteException {
            return false;
        }

        @Override // com.stepos.ability.IVoiceWakeupService
        public boolean isWakeupRunning() throws RemoteException {
            return false;
        }

        @Override // com.stepos.ability.IVoiceWakeupService
        public void registerCallback(IVoiceWakeupCallback iVoiceWakeupCallback) throws RemoteException {
        }

        @Override // com.stepos.ability.IVoiceWakeupService
        public void reloadModel() throws RemoteException {
        }

        @Override // com.stepos.ability.IVoiceWakeupService
        public void startTraining() throws RemoteException {
        }

        @Override // com.stepos.ability.IVoiceWakeupService
        public void startWakeup() throws RemoteException {
        }

        @Override // com.stepos.ability.IVoiceWakeupService
        public void stopWakeup() throws RemoteException {
        }

        @Override // com.stepos.ability.IVoiceWakeupService
        public void unregisterCallback(IVoiceWakeupCallback iVoiceWakeupCallback) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IVoiceWakeupService {
        static final int TRANSACTION_clearVoiceprint = 6;
        static final int TRANSACTION_clearVoiceprintFor = 12;
        static final int TRANSACTION_getTrainedWordIds = 10;
        static final int TRANSACTION_hasVoiceprintModel = 5;
        static final int TRANSACTION_hasVoiceprintModelFor = 11;
        static final int TRANSACTION_isWakeupRunning = 4;
        static final int TRANSACTION_registerCallback = 7;
        static final int TRANSACTION_reloadModel = 3;
        static final int TRANSACTION_startTraining = 9;
        static final int TRANSACTION_startWakeup = 1;
        static final int TRANSACTION_stopWakeup = 2;
        static final int TRANSACTION_unregisterCallback = 8;

        public static class Proxy implements IVoiceWakeupService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.stepos.ability.IVoiceWakeupService
            public void clearVoiceprint() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceWakeupService.DESCRIPTOR);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IVoiceWakeupService
            public void clearVoiceprintFor(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceWakeupService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(12, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IVoiceWakeupService.DESCRIPTOR;
            }

            @Override // com.stepos.ability.IVoiceWakeupService
            public String[] getTrainedWordIds() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceWakeupService.DESCRIPTOR);
                    this.mRemote.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createStringArray();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IVoiceWakeupService
            public boolean hasVoiceprintModel() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceWakeupService.DESCRIPTOR);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IVoiceWakeupService
            public boolean hasVoiceprintModelFor(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceWakeupService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IVoiceWakeupService
            public boolean isWakeupRunning() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceWakeupService.DESCRIPTOR);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IVoiceWakeupService
            public void registerCallback(IVoiceWakeupCallback iVoiceWakeupCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceWakeupService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iVoiceWakeupCallback);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IVoiceWakeupService
            public void reloadModel() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceWakeupService.DESCRIPTOR);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IVoiceWakeupService
            public void startTraining() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceWakeupService.DESCRIPTOR);
                    this.mRemote.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IVoiceWakeupService
            public void startWakeup() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceWakeupService.DESCRIPTOR);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IVoiceWakeupService
            public void stopWakeup() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceWakeupService.DESCRIPTOR);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IVoiceWakeupService
            public void unregisterCallback(IVoiceWakeupCallback iVoiceWakeupCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceWakeupService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iVoiceWakeupCallback);
                    this.mRemote.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IVoiceWakeupService.DESCRIPTOR);
        }

        public static IVoiceWakeupService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IVoiceWakeupService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IVoiceWakeupService)) ? new Proxy(iBinder) : (IVoiceWakeupService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IVoiceWakeupService.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IVoiceWakeupService.DESCRIPTOR);
                return true;
            }
            switch (i10) {
                case 1:
                    startWakeup();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    stopWakeup();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    reloadModel();
                    parcel2.writeNoException();
                    return true;
                case 4:
                    boolean zIsWakeupRunning = isWakeupRunning();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsWakeupRunning ? 1 : 0);
                    return true;
                case 5:
                    boolean zHasVoiceprintModel = hasVoiceprintModel();
                    parcel2.writeNoException();
                    parcel2.writeInt(zHasVoiceprintModel ? 1 : 0);
                    return true;
                case 6:
                    clearVoiceprint();
                    parcel2.writeNoException();
                    return true;
                case 7:
                    registerCallback(IVoiceWakeupCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 8:
                    unregisterCallback(IVoiceWakeupCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 9:
                    startTraining();
                    parcel2.writeNoException();
                    return true;
                case 10:
                    String[] trainedWordIds = getTrainedWordIds();
                    parcel2.writeNoException();
                    parcel2.writeStringArray(trainedWordIds);
                    return true;
                case 11:
                    boolean zHasVoiceprintModelFor = hasVoiceprintModelFor(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zHasVoiceprintModelFor ? 1 : 0);
                    return true;
                case 12:
                    clearVoiceprintFor(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }
    }

    void clearVoiceprint() throws RemoteException;

    void clearVoiceprintFor(String str) throws RemoteException;

    String[] getTrainedWordIds() throws RemoteException;

    boolean hasVoiceprintModel() throws RemoteException;

    boolean hasVoiceprintModelFor(String str) throws RemoteException;

    boolean isWakeupRunning() throws RemoteException;

    void registerCallback(IVoiceWakeupCallback iVoiceWakeupCallback) throws RemoteException;

    void reloadModel() throws RemoteException;

    void startTraining() throws RemoteException;

    void startWakeup() throws RemoteException;

    void stopWakeup() throws RemoteException;

    void unregisterCallback(IVoiceWakeupCallback iVoiceWakeupCallback) throws RemoteException;
}
