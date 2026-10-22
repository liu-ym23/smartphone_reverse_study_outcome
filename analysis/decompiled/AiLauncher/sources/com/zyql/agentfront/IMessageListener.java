package com.zyql.agentfront;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.zyql.agentfront.bean.Message;

/* loaded from: classes4.dex */
public interface IMessageListener extends IInterface {
    public static final String DESCRIPTOR = "com.zyql.agentfront.IMessageListener";

    public static class Default implements IMessageListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.zyql.agentfront.IMessageListener
        public void onBindFailed(String str) throws RemoteException {
        }

        @Override // com.zyql.agentfront.IMessageListener
        public void onConnected() throws RemoteException {
        }

        @Override // com.zyql.agentfront.IMessageListener
        public void onDisconnected() throws RemoteException {
        }

        @Override // com.zyql.agentfront.IMessageListener
        public void onMessageReceived(Message message) throws RemoteException {
        }

        @Override // com.zyql.agentfront.IMessageListener
        public void onMessageSent(String str, boolean z10, String str2) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IMessageListener {
        static final int TRANSACTION_onBindFailed = 3;
        static final int TRANSACTION_onConnected = 1;
        static final int TRANSACTION_onDisconnected = 2;
        static final int TRANSACTION_onMessageReceived = 4;
        static final int TRANSACTION_onMessageSent = 5;

        public static class Proxy implements IMessageListener {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IMessageListener.DESCRIPTOR;
            }

            @Override // com.zyql.agentfront.IMessageListener
            public void onBindFailed(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMessageListener.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.agentfront.IMessageListener
            public void onConnected() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMessageListener.DESCRIPTOR);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.agentfront.IMessageListener
            public void onDisconnected() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMessageListener.DESCRIPTOR);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.agentfront.IMessageListener
            public void onMessageReceived(Message message) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMessageListener.DESCRIPTOR);
                    a.d(parcelObtain, message, 0);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.agentfront.IMessageListener
            public void onMessageSent(String str, boolean z10, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMessageListener.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IMessageListener.DESCRIPTOR);
        }

        public static IMessageListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IMessageListener.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IMessageListener)) ? new Proxy(iBinder) : (IMessageListener) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IMessageListener.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IMessageListener.DESCRIPTOR);
                return true;
            }
            if (i10 == 1) {
                onConnected();
                parcel2.writeNoException();
            } else if (i10 == 2) {
                onDisconnected();
                parcel2.writeNoException();
            } else if (i10 == 3) {
                onBindFailed(parcel.readString());
                parcel2.writeNoException();
            } else if (i10 == 4) {
                onMessageReceived((Message) a.c(parcel, Message.INSTANCE));
                parcel2.writeNoException();
            } else {
                if (i10 != 5) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                onMessageSent(parcel.readString(), parcel.readInt() != 0, parcel.readString());
                parcel2.writeNoException();
            }
            return true;
        }
    }

    public static class a {
        public static <T> T c(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        public static <T extends Parcelable> void d(Parcel parcel, T t10, int i10) {
            if (t10 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t10.writeToParcel(parcel, i10);
            }
        }
    }

    void onBindFailed(String str) throws RemoteException;

    void onConnected() throws RemoteException;

    void onDisconnected() throws RemoteException;

    void onMessageReceived(Message message) throws RemoteException;

    void onMessageSent(String str, boolean z10, String str2) throws RemoteException;
}
