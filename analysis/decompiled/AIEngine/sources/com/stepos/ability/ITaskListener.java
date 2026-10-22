package com.stepos.ability;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.stepos.ability.bean.ExplainSnapshot;
import com.stepos.ability.bean.Task;
import com.stepos.ability.bean.ToolCallEvent;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface ITaskListener extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.ability.ITaskListener";

    void onExplainUpdated(String str, ExplainSnapshot explainSnapshot);

    void onInfoDismissed(String str, String str2, String str3, String str4);

    void onInfoRequested(String str, String str2, String str3, String str4, String str5, long j10, String str6);

    void onPackageConflict(int i10, String str, String str2, String str3, String str4, String str5);

    void onRequestRelaunch(String str, String str2, String str3);

    void onTaskEvent(Task task);

    void onToolCallEvent(ToolCallEvent toolCallEvent);

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class Stub extends Binder implements ITaskListener {
        static final int TRANSACTION_onExplainUpdated = 5;
        static final int TRANSACTION_onInfoDismissed = 4;
        static final int TRANSACTION_onInfoRequested = 3;
        static final int TRANSACTION_onPackageConflict = 6;
        static final int TRANSACTION_onRequestRelaunch = 7;
        static final int TRANSACTION_onTaskEvent = 1;
        static final int TRANSACTION_onToolCallEvent = 2;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static class Proxy implements ITaskListener {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ITaskListener.DESCRIPTOR;
            }

            @Override // com.stepos.ability.ITaskListener
            public void onExplainUpdated(String str, ExplainSnapshot explainSnapshot) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskListener.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (explainSnapshot != null) {
                        parcelObtain.writeInt(1);
                        explainSnapshot.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.ITaskListener
            public void onInfoDismissed(String str, String str2, String str3, String str4) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskListener.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.ITaskListener
            public void onInfoRequested(String str, String str2, String str3, String str4, String str5, long j10, String str6) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskListener.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    parcelObtain.writeString(str5);
                    parcelObtain.writeLong(j10);
                    parcelObtain.writeString(str6);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.ITaskListener
            public void onPackageConflict(int i10, String str, String str2, String str3, String str4, String str5) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskListener.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    parcelObtain.writeString(str5);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.ITaskListener
            public void onRequestRelaunch(String str, String str2, String str3) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskListener.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.ITaskListener
            public void onTaskEvent(Task task) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskListener.DESCRIPTOR);
                    if (task != null) {
                        parcelObtain.writeInt(1);
                        task.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.ITaskListener
            public void onToolCallEvent(ToolCallEvent toolCallEvent) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ITaskListener.DESCRIPTOR);
                    if (toolCallEvent != null) {
                        parcelObtain.writeInt(1);
                        toolCallEvent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ITaskListener.DESCRIPTOR);
        }

        public static ITaskListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ITaskListener.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ITaskListener)) ? new Proxy(iBinder) : (ITaskListener) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(ITaskListener.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(ITaskListener.DESCRIPTOR);
                return true;
            }
            switch (i10) {
                case 1:
                    onTaskEvent((Task) (parcel.readInt() != 0 ? Task.CREATOR.createFromParcel(parcel) : null));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    onToolCallEvent((ToolCallEvent) (parcel.readInt() != 0 ? ToolCallEvent.CREATOR.createFromParcel(parcel) : null));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    onInfoRequested(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    onInfoDismissed(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    onExplainUpdated(parcel.readString(), (ExplainSnapshot) (parcel.readInt() != 0 ? ExplainSnapshot.CREATOR.createFromParcel(parcel) : null));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    onPackageConflict(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    onRequestRelaunch(parcel.readString(), parcel.readString(), parcel.readString());
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

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class Default implements ITaskListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.ability.ITaskListener
        public void onTaskEvent(Task task) {
        }

        @Override // com.stepos.ability.ITaskListener
        public void onToolCallEvent(ToolCallEvent toolCallEvent) {
        }

        @Override // com.stepos.ability.ITaskListener
        public void onExplainUpdated(String str, ExplainSnapshot explainSnapshot) {
        }

        @Override // com.stepos.ability.ITaskListener
        public void onRequestRelaunch(String str, String str2, String str3) {
        }

        @Override // com.stepos.ability.ITaskListener
        public void onInfoDismissed(String str, String str2, String str3, String str4) {
        }

        @Override // com.stepos.ability.ITaskListener
        public void onPackageConflict(int i10, String str, String str2, String str3, String str4, String str5) {
        }

        @Override // com.stepos.ability.ITaskListener
        public void onInfoRequested(String str, String str2, String str3, String str4, String str5, long j10, String str6) {
        }
    }
}
