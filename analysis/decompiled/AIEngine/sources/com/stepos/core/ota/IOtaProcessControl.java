package com.stepos.core.ota;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.stepos.core.ota.IOtaTaskListener;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface IOtaProcessControl extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.core.ota.IOtaProcessControl";

    boolean attachSource(String str, int i10);

    boolean cancel(String str);

    boolean checkUpdate(String str, int i10);

    boolean detach(String str, String str2);

    boolean download(String str, int i10, String str2, String[] strArr, boolean z);

    int getProgress(String str);

    int getStatus(String str);

    boolean pause(String str);

    boolean pauseWithReason(String str, int i10);

    void requestShutdownPersisting();

    boolean resume(String str, int i10);

    void setTaskListener(IOtaTaskListener iOtaTaskListener);

    void syncAbilityMappings(String str);

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class Default implements IOtaProcessControl {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.core.ota.IOtaProcessControl
        public boolean attachSource(String str, int i10) {
            return false;
        }

        @Override // com.stepos.core.ota.IOtaProcessControl
        public boolean cancel(String str) {
            return false;
        }

        @Override // com.stepos.core.ota.IOtaProcessControl
        public boolean checkUpdate(String str, int i10) {
            return false;
        }

        @Override // com.stepos.core.ota.IOtaProcessControl
        public boolean detach(String str, String str2) {
            return false;
        }

        @Override // com.stepos.core.ota.IOtaProcessControl
        public boolean download(String str, int i10, String str2, String[] strArr, boolean z) {
            return false;
        }

        @Override // com.stepos.core.ota.IOtaProcessControl
        public int getProgress(String str) {
            return 0;
        }

        @Override // com.stepos.core.ota.IOtaProcessControl
        public int getStatus(String str) {
            return 0;
        }

        @Override // com.stepos.core.ota.IOtaProcessControl
        public boolean pause(String str) {
            return false;
        }

        @Override // com.stepos.core.ota.IOtaProcessControl
        public boolean pauseWithReason(String str, int i10) {
            return false;
        }

        @Override // com.stepos.core.ota.IOtaProcessControl
        public boolean resume(String str, int i10) {
            return false;
        }

        @Override // com.stepos.core.ota.IOtaProcessControl
        public void requestShutdownPersisting() {
        }

        @Override // com.stepos.core.ota.IOtaProcessControl
        public void setTaskListener(IOtaTaskListener iOtaTaskListener) {
        }

        @Override // com.stepos.core.ota.IOtaProcessControl
        public void syncAbilityMappings(String str) {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class Stub extends Binder implements IOtaProcessControl {
        static final int TRANSACTION_attachSource = 13;
        static final int TRANSACTION_cancel = 7;
        static final int TRANSACTION_checkUpdate = 2;
        static final int TRANSACTION_detach = 8;
        static final int TRANSACTION_download = 3;
        static final int TRANSACTION_getProgress = 9;
        static final int TRANSACTION_getStatus = 10;
        static final int TRANSACTION_pause = 4;
        static final int TRANSACTION_pauseWithReason = 5;
        static final int TRANSACTION_requestShutdownPersisting = 12;
        static final int TRANSACTION_resume = 6;
        static final int TRANSACTION_setTaskListener = 11;
        static final int TRANSACTION_syncAbilityMappings = 1;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static class Proxy implements IOtaProcessControl {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.stepos.core.ota.IOtaProcessControl
            public boolean attachSource(String str, int i10) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IOtaProcessControl.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(13, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.core.ota.IOtaProcessControl
            public boolean cancel(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IOtaProcessControl.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.core.ota.IOtaProcessControl
            public boolean checkUpdate(String str, int i10) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IOtaProcessControl.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.core.ota.IOtaProcessControl
            public boolean detach(String str, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IOtaProcessControl.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.core.ota.IOtaProcessControl
            public boolean download(String str, int i10, String str2, String[] strArr, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IOtaProcessControl.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStringArray(strArr);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IOtaProcessControl.DESCRIPTOR;
            }

            @Override // com.stepos.core.ota.IOtaProcessControl
            public int getProgress(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IOtaProcessControl.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.core.ota.IOtaProcessControl
            public int getStatus(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IOtaProcessControl.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.core.ota.IOtaProcessControl
            public boolean pause(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IOtaProcessControl.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.core.ota.IOtaProcessControl
            public boolean pauseWithReason(String str, int i10) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IOtaProcessControl.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.core.ota.IOtaProcessControl
            public void requestShutdownPersisting() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IOtaProcessControl.DESCRIPTOR);
                    this.mRemote.transact(12, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.core.ota.IOtaProcessControl
            public boolean resume(String str, int i10) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IOtaProcessControl.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.core.ota.IOtaProcessControl
            public void setTaskListener(IOtaTaskListener iOtaTaskListener) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IOtaProcessControl.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iOtaTaskListener);
                    this.mRemote.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.core.ota.IOtaProcessControl
            public void syncAbilityMappings(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IOtaProcessControl.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IOtaProcessControl.DESCRIPTOR);
        }

        public static IOtaProcessControl asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IOtaProcessControl.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IOtaProcessControl)) ? new Proxy(iBinder) : (IOtaProcessControl) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IOtaProcessControl.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IOtaProcessControl.DESCRIPTOR);
                return true;
            }
            switch (i10) {
                case 1:
                    syncAbilityMappings(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    boolean zCheckUpdate = checkUpdate(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zCheckUpdate ? 1 : 0);
                    return true;
                case 3:
                    boolean zDownload = download(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.createStringArray(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(zDownload ? 1 : 0);
                    return true;
                case 4:
                    boolean zPause = pause(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zPause ? 1 : 0);
                    return true;
                case 5:
                    boolean zPauseWithReason = pauseWithReason(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zPauseWithReason ? 1 : 0);
                    return true;
                case 6:
                    boolean zResume = resume(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zResume ? 1 : 0);
                    return true;
                case 7:
                    boolean zCancel = cancel(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zCancel ? 1 : 0);
                    return true;
                case 8:
                    boolean zDetach = detach(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zDetach ? 1 : 0);
                    return true;
                case 9:
                    int progress = getProgress(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(progress);
                    return true;
                case 10:
                    int status = getStatus(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(status);
                    return true;
                case 11:
                    setTaskListener(IOtaTaskListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 12:
                    requestShutdownPersisting();
                    parcel2.writeNoException();
                    return true;
                case 13:
                    boolean zAttachSource = attachSource(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zAttachSource ? 1 : 0);
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
