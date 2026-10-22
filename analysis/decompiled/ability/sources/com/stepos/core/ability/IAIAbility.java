package com.stepos.core.ability;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.stepos.core.ability.IChatSession;
import com.stepos.core.callback.IBoolCallback;
import com.stepos.core.callback.IInferenceCallback;
import com.stepos.core.data.base.Content;
import g1.AbstractC1451a;

/* loaded from: classes3.dex */
public interface IAIAbility extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.core.ability.IAIAbility";

    public static class Default implements IAIAbility {
        @Override // com.stepos.core.ability.IAIAbility
        public boolean acquire() throws RemoteException {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.core.ability.IAIAbility
        public boolean cancel() throws RemoteException {
            return false;
        }

        @Override // com.stepos.core.ability.IAIAbility
        public void cancelByUser() throws RemoteException {
        }

        @Override // com.stepos.core.ability.IAIAbility
        public boolean cancelInfer(String str) throws RemoteException {
            return false;
        }

        @Override // com.stepos.core.ability.IAIAbility
        public void completeInput(String str) throws RemoteException {
        }

        @Override // com.stepos.core.ability.IAIAbility
        public IChatSession createSession() throws RemoteException {
            return null;
        }

        @Override // com.stepos.core.ability.IAIAbility
        public Content execute(String str, Content content) throws RemoteException {
            return null;
        }

        @Override // com.stepos.core.ability.IAIAbility
        public void feedInput(String str, Content content) throws RemoteException {
        }

        @Override // com.stepos.core.ability.IAIAbility
        public AbilityInfo getInfo() throws RemoteException {
            return null;
        }

        @Override // com.stepos.core.ability.IAIAbility
        public void infer(String str, Content content, IInferenceCallback iInferenceCallback) throws RemoteException {
        }

        @Override // com.stepos.core.ability.IAIAbility
        public void preload(IBoolCallback iBoolCallback) throws RemoteException {
        }

        @Override // com.stepos.core.ability.IAIAbility
        public void release() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IAIAbility {
        static final int TRANSACTION_acquire = 1;
        static final int TRANSACTION_cancel = 5;
        static final int TRANSACTION_cancelByUser = 11;
        static final int TRANSACTION_cancelInfer = 10;
        static final int TRANSACTION_completeInput = 8;
        static final int TRANSACTION_createSession = 12;
        static final int TRANSACTION_execute = 6;
        static final int TRANSACTION_feedInput = 7;
        static final int TRANSACTION_getInfo = 4;
        static final int TRANSACTION_infer = 3;
        static final int TRANSACTION_preload = 9;
        static final int TRANSACTION_release = 2;

        public static class Proxy implements IAIAbility {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.stepos.core.ability.IAIAbility
            public boolean acquire() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAIAbility.DESCRIPTOR);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.stepos.core.ability.IAIAbility
            public boolean cancel() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAIAbility.DESCRIPTOR);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.core.ability.IAIAbility
            public void cancelByUser() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAIAbility.DESCRIPTOR);
                    this.mRemote.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.core.ability.IAIAbility
            public boolean cancelInfer(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAIAbility.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.core.ability.IAIAbility
            public void completeInput(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAIAbility.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.core.ability.IAIAbility
            public IChatSession createSession() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAIAbility.DESCRIPTOR);
                    this.mRemote.transact(12, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return IChatSession.Stub.asInterface(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.core.ability.IAIAbility
            public Content execute(String str, Content content) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAIAbility.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    AbstractC1451a.b(parcelObtain, content, 0);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Content) AbstractC1451a.a(parcelObtain2, Content.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.core.ability.IAIAbility
            public void feedInput(String str, Content content) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAIAbility.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    AbstractC1451a.b(parcelObtain, content, 0);
                    this.mRemote.transact(7, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.core.ability.IAIAbility
            public AbilityInfo getInfo() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAIAbility.DESCRIPTOR);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (AbilityInfo) AbstractC1451a.a(parcelObtain2, AbilityInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IAIAbility.DESCRIPTOR;
            }

            @Override // com.stepos.core.ability.IAIAbility
            public void infer(String str, Content content, IInferenceCallback iInferenceCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAIAbility.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    AbstractC1451a.b(parcelObtain, content, 0);
                    parcelObtain.writeStrongInterface(iInferenceCallback);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.core.ability.IAIAbility
            public void preload(IBoolCallback iBoolCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAIAbility.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iBoolCallback);
                    this.mRemote.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.core.ability.IAIAbility
            public void release() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAIAbility.DESCRIPTOR);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IAIAbility.DESCRIPTOR);
        }

        public static IAIAbility asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IAIAbility.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IAIAbility)) ? new Proxy(iBinder) : (IAIAbility) iInterfaceQueryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i6) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IAIAbility.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IAIAbility.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    boolean zAcquire = acquire();
                    parcel2.writeNoException();
                    parcel2.writeInt(zAcquire ? 1 : 0);
                    return true;
                case 2:
                    release();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    infer(parcel.readString(), (Content) AbstractC1451a.a(parcel, Content.CREATOR), IInferenceCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    AbilityInfo info = getInfo();
                    parcel2.writeNoException();
                    AbstractC1451a.b(parcel2, info, 1);
                    return true;
                case 5:
                    boolean zCancel = cancel();
                    parcel2.writeNoException();
                    parcel2.writeInt(zCancel ? 1 : 0);
                    return true;
                case 6:
                    Content contentExecute = execute(parcel.readString(), (Content) AbstractC1451a.a(parcel, Content.CREATOR));
                    parcel2.writeNoException();
                    AbstractC1451a.b(parcel2, contentExecute, 1);
                    return true;
                case 7:
                    feedInput(parcel.readString(), (Content) AbstractC1451a.a(parcel, Content.CREATOR));
                    return true;
                case 8:
                    completeInput(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    preload(IBoolCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 10:
                    boolean zCancelInfer = cancelInfer(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zCancelInfer ? 1 : 0);
                    return true;
                case 11:
                    cancelByUser();
                    parcel2.writeNoException();
                    return true;
                case 12:
                    IChatSession iChatSessionCreateSession = createSession();
                    parcel2.writeNoException();
                    parcel2.writeStrongInterface(iChatSessionCreateSession);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i6);
            }
        }
    }

    boolean acquire() throws RemoteException;

    boolean cancel() throws RemoteException;

    void cancelByUser() throws RemoteException;

    boolean cancelInfer(String str) throws RemoteException;

    void completeInput(String str) throws RemoteException;

    IChatSession createSession() throws RemoteException;

    Content execute(String str, Content content) throws RemoteException;

    void feedInput(String str, Content content) throws RemoteException;

    AbilityInfo getInfo() throws RemoteException;

    void infer(String str, Content content, IInferenceCallback iInferenceCallback) throws RemoteException;

    void preload(IBoolCallback iBoolCallback) throws RemoteException;

    void release() throws RemoteException;
}
