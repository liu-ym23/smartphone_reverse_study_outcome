package com.stepos.zeroclaw.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.zeroclaw.ipc.IZeroClawCallback;

/* loaded from: classes.dex */
public interface IZeroClawService extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.zeroclaw.ipc.IZeroClawService";

    public static class Default implements IZeroClawService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.zeroclaw.ipc.IZeroClawService
        public int getHealthState() {
            return 0;
        }

        @Override // com.stepos.zeroclaw.ipc.IZeroClawService
        public int getVersionCode() {
            return 0;
        }

        @Override // com.stepos.zeroclaw.ipc.IZeroClawService
        public String getVersionName() {
            return null;
        }

        @Override // com.stepos.zeroclaw.ipc.IZeroClawService
        public void registerCallback(IZeroClawCallback iZeroClawCallback) {
        }

        @Override // com.stepos.zeroclaw.ipc.IZeroClawService
        public Reply sendFrame(Message message) {
            return null;
        }

        @Override // com.stepos.zeroclaw.ipc.IZeroClawService
        public void unregisterCallback(IZeroClawCallback iZeroClawCallback) {
        }
    }

    public static abstract class Stub extends Binder implements IZeroClawService {
        static final int TRANSACTION_getHealthState = 6;
        static final int TRANSACTION_getVersionCode = 1;
        static final int TRANSACTION_getVersionName = 2;
        static final int TRANSACTION_registerCallback = 4;
        static final int TRANSACTION_sendFrame = 3;
        static final int TRANSACTION_unregisterCallback = 5;

        public static class Proxy implements IZeroClawService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.stepos.zeroclaw.ipc.IZeroClawService
            public int getHealthState() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IZeroClawService.DESCRIPTOR);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IZeroClawService.DESCRIPTOR;
            }

            @Override // com.stepos.zeroclaw.ipc.IZeroClawService
            public int getVersionCode() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IZeroClawService.DESCRIPTOR);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.zeroclaw.ipc.IZeroClawService
            public String getVersionName() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IZeroClawService.DESCRIPTOR);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.zeroclaw.ipc.IZeroClawService
            public void registerCallback(IZeroClawCallback iZeroClawCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IZeroClawService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iZeroClawCallback);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.zeroclaw.ipc.IZeroClawService
            public Reply sendFrame(Message message) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IZeroClawService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, message, 0);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Reply) _Parcel.readTypedObject(parcelObtain2, Reply.INSTANCE);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.zeroclaw.ipc.IZeroClawService
            public void unregisterCallback(IZeroClawCallback iZeroClawCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IZeroClawService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iZeroClawCallback);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IZeroClawService.DESCRIPTOR);
        }

        public static IZeroClawService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IZeroClawService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IZeroClawService)) ? new Proxy(iBinder) : (IZeroClawService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i10) {
            if (i2 >= 1 && i2 <= 16777215) {
                parcel.enforceInterface(IZeroClawService.DESCRIPTOR);
            }
            if (i2 == 1598968902) {
                parcel2.writeString(IZeroClawService.DESCRIPTOR);
                return true;
            }
            switch (i2) {
                case 1:
                    int versionCode = getVersionCode();
                    parcel2.writeNoException();
                    parcel2.writeInt(versionCode);
                    return true;
                case 2:
                    String versionName = getVersionName();
                    parcel2.writeNoException();
                    parcel2.writeString(versionName);
                    return true;
                case 3:
                    Reply replySendFrame = sendFrame((Message) _Parcel.readTypedObject(parcel, Message.INSTANCE));
                    parcel2.writeNoException();
                    _Parcel.writeTypedObject(parcel2, replySendFrame, 1);
                    return true;
                case 4:
                    registerCallback(IZeroClawCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    unregisterCallback(IZeroClawCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    int healthState = getHealthState();
                    parcel2.writeNoException();
                    parcel2.writeInt(healthState);
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i10);
            }
        }
    }

    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t2, int i2) {
            if (t2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t2.writeToParcel(parcel, i2);
            }
        }
    }

    int getHealthState();

    int getVersionCode();

    String getVersionName();

    void registerCallback(IZeroClawCallback iZeroClawCallback);

    Reply sendFrame(Message message);

    void unregisterCallback(IZeroClawCallback iZeroClawCallback);
}
