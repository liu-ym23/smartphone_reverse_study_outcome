package com.stepos.appui.bridge;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes3.dex */
public interface ISurfaceControlCallback extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.appui.bridge.ISurfaceControlCallback";

    public static class Default implements ISurfaceControlCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.appui.bridge.ISurfaceControlCallback
        public void callTool(String str) throws RemoteException {
        }

        @Override // com.stepos.appui.bridge.ISurfaceControlCallback
        public void onSizeChanged(int i10, int i11) throws RemoteException {
        }

        @Override // com.stepos.appui.bridge.ISurfaceControlCallback
        public void openExternal(String str) throws RemoteException {
        }

        @Override // com.stepos.appui.bridge.ISurfaceControlCallback
        public String requestDisplayMode() throws RemoteException {
            return null;
        }

        @Override // com.stepos.appui.bridge.ISurfaceControlCallback
        public void sendFollowUpMessage(String str) throws RemoteException {
        }

        @Override // com.stepos.appui.bridge.ISurfaceControlCallback
        public void setWidgetState(String str) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ISurfaceControlCallback {
        static final int TRANSACTION_callTool = 1;
        static final int TRANSACTION_onSizeChanged = 6;
        static final int TRANSACTION_openExternal = 4;
        static final int TRANSACTION_requestDisplayMode = 2;
        static final int TRANSACTION_sendFollowUpMessage = 3;
        static final int TRANSACTION_setWidgetState = 5;

        public static class Proxy implements ISurfaceControlCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.stepos.appui.bridge.ISurfaceControlCallback
            public void callTool(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISurfaceControlCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return ISurfaceControlCallback.DESCRIPTOR;
            }

            @Override // com.stepos.appui.bridge.ISurfaceControlCallback
            public void onSizeChanged(int i10, int i11) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISurfaceControlCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeInt(i11);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.appui.bridge.ISurfaceControlCallback
            public void openExternal(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISurfaceControlCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.appui.bridge.ISurfaceControlCallback
            public String requestDisplayMode() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISurfaceControlCallback.DESCRIPTOR);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.appui.bridge.ISurfaceControlCallback
            public void sendFollowUpMessage(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISurfaceControlCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.appui.bridge.ISurfaceControlCallback
            public void setWidgetState(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISurfaceControlCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ISurfaceControlCallback.DESCRIPTOR);
        }

        public static ISurfaceControlCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ISurfaceControlCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ISurfaceControlCallback)) ? new Proxy(iBinder) : (ISurfaceControlCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(ISurfaceControlCallback.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(ISurfaceControlCallback.DESCRIPTOR);
                return true;
            }
            switch (i10) {
                case 1:
                    callTool(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    String strRequestDisplayMode = requestDisplayMode();
                    parcel2.writeNoException();
                    parcel2.writeString(strRequestDisplayMode);
                    return true;
                case 3:
                    sendFollowUpMessage(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    openExternal(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    setWidgetState(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    onSizeChanged(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }
    }

    void callTool(String str) throws RemoteException;

    void onSizeChanged(int i10, int i11) throws RemoteException;

    void openExternal(String str) throws RemoteException;

    String requestDisplayMode() throws RemoteException;

    void sendFollowUpMessage(String str) throws RemoteException;

    void setWidgetState(String str) throws RemoteException;
}
