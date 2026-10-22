package com.uxsense.ruleTrigger;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes3.dex */
public interface IRuleCallback extends IInterface {
    public static final String DESCRIPTOR = "com.uxsense.ruleTrigger.IRuleCallback";

    public static class Default implements IRuleCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.uxsense.ruleTrigger.IRuleCallback
        public void onTriggerEvent(int i, Intent intent) throws RemoteException {
        }

        @Override // com.uxsense.ruleTrigger.IRuleCallback
        public List<TriggerRule> requestRules(String str, String str2) throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IRuleCallback {
        static final int TRANSACTION_onTriggerEvent = 2;
        static final int TRANSACTION_requestRules = 1;

        public static class Proxy implements IRuleCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IRuleCallback.DESCRIPTOR;
            }

            @Override // com.uxsense.ruleTrigger.IRuleCallback
            public void onTriggerEvent(int i, Intent intent) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRuleCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    _Parcel.writeTypedObject(parcelObtain, intent, 0);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.uxsense.ruleTrigger.IRuleCallback
            public List<TriggerRule> requestRules(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRuleCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(TriggerRule.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IRuleCallback.DESCRIPTOR);
        }

        public static IRuleCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IRuleCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IRuleCallback)) ? new Proxy(iBinder) : (IRuleCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i6) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IRuleCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IRuleCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                List<TriggerRule> listRequestRules = requestRules(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                _Parcel.writeTypedList(parcel2, listRequestRules, 1);
            } else {
                if (i != 2) {
                    return super.onTransact(i, parcel, parcel2, i6);
                }
                onTriggerEvent(parcel.readInt(), (Intent) _Parcel.readTypedObject(parcel, Intent.CREATOR));
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
        public static <T extends Parcelable> void writeTypedList(Parcel parcel, List<T> list, int i) {
            if (list == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = list.size();
            parcel.writeInt(size);
            for (int i6 = 0; i6 < size; i6++) {
                writeTypedObject(parcel, list.get(i6), i);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t9, int i) {
            if (t9 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t9.writeToParcel(parcel, i);
            }
        }
    }

    void onTriggerEvent(int i, Intent intent) throws RemoteException;

    List<TriggerRule> requestRules(String str, String str2) throws RemoteException;
}
