package com.stepos.core.ability;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.stepos.core.callback.IInferenceCallback;
import com.stepos.core.data.base.Content;

/* loaded from: classes3.dex */
public interface IChatSession extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.core.ability.IChatSession";

    public static class Default implements IChatSession {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.core.ability.IChatSession
        public void clearHistory() throws RemoteException {
        }

        @Override // com.stepos.core.ability.IChatSession
        public void close() throws RemoteException {
        }

        @Override // com.stepos.core.ability.IChatSession
        public void generate(Content content, IInferenceCallback iInferenceCallback) throws RemoteException {
        }

        @Override // com.stepos.core.ability.IChatSession
        public String getSessionId() throws RemoteException {
            return null;
        }

        @Override // com.stepos.core.ability.IChatSession
        public int getTurnCount() throws RemoteException {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements IChatSession {
        static final int TRANSACTION_clearHistory = 4;
        static final int TRANSACTION_close = 5;
        static final int TRANSACTION_generate = 2;
        static final int TRANSACTION_getSessionId = 1;
        static final int TRANSACTION_getTurnCount = 3;

        public static class Proxy implements IChatSession {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.stepos.core.ability.IChatSession
            public void clearHistory() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IChatSession.DESCRIPTOR);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.core.ability.IChatSession
            public void close() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IChatSession.DESCRIPTOR);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.core.ability.IChatSession
            public void generate(Content content, IInferenceCallback iInferenceCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IChatSession.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, content, 0);
                    parcelObtain.writeStrongInterface(iInferenceCallback);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IChatSession.DESCRIPTOR;
            }

            @Override // com.stepos.core.ability.IChatSession
            public String getSessionId() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IChatSession.DESCRIPTOR);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.core.ability.IChatSession
            public int getTurnCount() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IChatSession.DESCRIPTOR);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IChatSession.DESCRIPTOR);
        }

        public static IChatSession asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IChatSession.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IChatSession)) ? new Proxy(iBinder) : (IChatSession) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IChatSession.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IChatSession.DESCRIPTOR);
                return true;
            }
            if (i10 == 1) {
                String sessionId = getSessionId();
                parcel2.writeNoException();
                parcel2.writeString(sessionId);
            } else if (i10 == 2) {
                generate((Content) _Parcel.readTypedObject(parcel, Content.CREATOR), IInferenceCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
            } else if (i10 == 3) {
                int turnCount = getTurnCount();
                parcel2.writeNoException();
                parcel2.writeInt(turnCount);
            } else if (i10 == 4) {
                clearHistory();
                parcel2.writeNoException();
            } else {
                if (i10 != 5) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                close();
                parcel2.writeNoException();
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
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t10, int i10) {
            if (t10 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t10.writeToParcel(parcel, i10);
            }
        }
    }

    void clearHistory() throws RemoteException;

    void close() throws RemoteException;

    void generate(Content content, IInferenceCallback iInferenceCallback) throws RemoteException;

    String getSessionId() throws RemoteException;

    int getTurnCount() throws RemoteException;
}
