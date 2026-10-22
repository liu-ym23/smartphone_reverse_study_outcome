package com.stepos.core.ability;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.core.ability.IChatSession;
import com.stepos.core.callback.IBoolCallback;
import com.stepos.core.callback.IInferenceCallback;
import com.stepos.core.callback.IReleaseCallback;
import com.stepos.core.data.base.Content;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface IAIAbility extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.core.ability.IAIAbility";

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t8, int i10) {
            if (t8 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t8.writeToParcel(parcel, i10);
            }
        }
    }

    boolean acquire();

    boolean cancel();

    void cancelByUser();

    boolean cancelInfer(String str);

    void completeInput(String str);

    IChatSession createSession();

    Content execute(String str, Content content);

    void feedInput(String str, Content content);

    AbilityInfo getInfo();

    void infer(String str, Content content, IInferenceCallback iInferenceCallback);

    void preload(IBoolCallback iBoolCallback);

    void registerReleaseCallback(IReleaseCallback iReleaseCallback);

    void release();

    void unregisterReleaseCallback();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class Default implements IAIAbility {
        @Override // com.stepos.core.ability.IAIAbility
        public boolean acquire() {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.core.ability.IAIAbility
        public boolean cancel() {
            return false;
        }

        @Override // com.stepos.core.ability.IAIAbility
        public boolean cancelInfer(String str) {
            return false;
        }

        @Override // com.stepos.core.ability.IAIAbility
        public IChatSession createSession() {
            return null;
        }

        @Override // com.stepos.core.ability.IAIAbility
        public Content execute(String str, Content content) {
            return null;
        }

        @Override // com.stepos.core.ability.IAIAbility
        public AbilityInfo getInfo() {
            return null;
        }

        @Override // com.stepos.core.ability.IAIAbility
        public void cancelByUser() {
        }

        @Override // com.stepos.core.ability.IAIAbility
        public void release() {
        }

        @Override // com.stepos.core.ability.IAIAbility
        public void unregisterReleaseCallback() {
        }

        @Override // com.stepos.core.ability.IAIAbility
        public void completeInput(String str) {
        }

        @Override // com.stepos.core.ability.IAIAbility
        public void preload(IBoolCallback iBoolCallback) {
        }

        @Override // com.stepos.core.ability.IAIAbility
        public void registerReleaseCallback(IReleaseCallback iReleaseCallback) {
        }

        @Override // com.stepos.core.ability.IAIAbility
        public void feedInput(String str, Content content) {
        }

        @Override // com.stepos.core.ability.IAIAbility
        public void infer(String str, Content content, IInferenceCallback iInferenceCallback) {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
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
        static final int TRANSACTION_registerReleaseCallback = 13;
        static final int TRANSACTION_release = 2;
        static final int TRANSACTION_unregisterReleaseCallback = 14;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static class Proxy implements IAIAbility {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.stepos.core.ability.IAIAbility
            public boolean acquire() {
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
            public boolean cancel() {
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
            public void cancelByUser() {
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
            public boolean cancelInfer(String str) {
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
            public void completeInput(String str) {
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
            public IChatSession createSession() {
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
            public Content execute(String str, Content content) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAIAbility.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    _Parcel.writeTypedObject(parcelObtain, content, 0);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Content) _Parcel.readTypedObject(parcelObtain2, Content.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.core.ability.IAIAbility
            public void feedInput(String str, Content content) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAIAbility.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    _Parcel.writeTypedObject(parcelObtain, content, 0);
                    this.mRemote.transact(7, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.core.ability.IAIAbility
            public AbilityInfo getInfo() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAIAbility.DESCRIPTOR);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (AbilityInfo) _Parcel.readTypedObject(parcelObtain2, AbilityInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IAIAbility.DESCRIPTOR;
            }

            @Override // com.stepos.core.ability.IAIAbility
            public void infer(String str, Content content, IInferenceCallback iInferenceCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAIAbility.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    _Parcel.writeTypedObject(parcelObtain, content, 0);
                    parcelObtain.writeStrongInterface(iInferenceCallback);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.core.ability.IAIAbility
            public void preload(IBoolCallback iBoolCallback) {
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
            public void registerReleaseCallback(IReleaseCallback iReleaseCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAIAbility.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iReleaseCallback);
                    this.mRemote.transact(13, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.core.ability.IAIAbility
            public void release() {
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

            @Override // com.stepos.core.ability.IAIAbility
            public void unregisterReleaseCallback() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAIAbility.DESCRIPTOR);
                    this.mRemote.transact(14, parcelObtain, parcelObtain2, 0);
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

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IAIAbility.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IAIAbility.DESCRIPTOR);
                return true;
            }
            switch (i10) {
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
                    infer(parcel.readString(), (Content) _Parcel.readTypedObject(parcel, Content.CREATOR), IInferenceCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    AbilityInfo info = getInfo();
                    parcel2.writeNoException();
                    _Parcel.writeTypedObject(parcel2, info, 1);
                    return true;
                case 5:
                    boolean zCancel = cancel();
                    parcel2.writeNoException();
                    parcel2.writeInt(zCancel ? 1 : 0);
                    return true;
                case 6:
                    Content contentExecute = execute(parcel.readString(), (Content) _Parcel.readTypedObject(parcel, Content.CREATOR));
                    parcel2.writeNoException();
                    _Parcel.writeTypedObject(parcel2, contentExecute, 1);
                    return true;
                case 7:
                    feedInput(parcel.readString(), (Content) _Parcel.readTypedObject(parcel, Content.CREATOR));
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
                case 13:
                    registerReleaseCallback(IReleaseCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 14:
                    unregisterReleaseCallback();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
