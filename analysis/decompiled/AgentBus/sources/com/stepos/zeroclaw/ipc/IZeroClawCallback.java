package com.stepos.zeroclaw.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public interface IZeroClawCallback extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.zeroclaw.ipc.IZeroClawCallback";

    public static class Default implements IZeroClawCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.zeroclaw.ipc.IZeroClawCallback
        public void onAsyncReply(int i2, Reply reply) {
        }

        @Override // com.stepos.zeroclaw.ipc.IZeroClawCallback
        public void onEvent(Message message) {
        }
    }

    public static abstract class Stub extends Binder implements IZeroClawCallback {
        static final int TRANSACTION_onAsyncReply = 2;
        static final int TRANSACTION_onEvent = 1;

        public static class Proxy implements IZeroClawCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IZeroClawCallback.DESCRIPTOR;
            }

            @Override // com.stepos.zeroclaw.ipc.IZeroClawCallback
            public void onAsyncReply(int i2, Reply reply) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IZeroClawCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    _Parcel.writeTypedObject(parcelObtain, reply, 0);
                    this.mRemote.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.zeroclaw.ipc.IZeroClawCallback
            public void onEvent(Message message) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IZeroClawCallback.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, message, 0);
                    this.mRemote.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IZeroClawCallback.DESCRIPTOR);
        }

        public static IZeroClawCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IZeroClawCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IZeroClawCallback)) ? new Proxy(iBinder) : (IZeroClawCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i10) {
            if (i2 >= 1 && i2 <= 16777215) {
                parcel.enforceInterface(IZeroClawCallback.DESCRIPTOR);
            }
            if (i2 == 1598968902) {
                parcel2.writeString(IZeroClawCallback.DESCRIPTOR);
                return true;
            }
            if (i2 == 1) {
                onEvent((Message) _Parcel.readTypedObject(parcel, Message.INSTANCE));
            } else {
                if (i2 != 2) {
                    return super.onTransact(i2, parcel, parcel2, i10);
                }
                onAsyncReply(parcel.readInt(), (Reply) _Parcel.readTypedObject(parcel, Reply.INSTANCE));
            }
            return true;
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

    void onAsyncReply(int i2, Reply reply);

    void onEvent(Message message);
}
