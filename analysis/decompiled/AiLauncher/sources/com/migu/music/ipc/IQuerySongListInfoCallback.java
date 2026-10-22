package com.migu.music.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes2.dex */
public interface IQuerySongListInfoCallback extends IInterface {

    public static class Default implements IQuerySongListInfoCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.migu.music.ipc.IQuerySongListInfoCallback
        public void onSongListInfoReady(List<MgSong> list, int i10, String str) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IQuerySongListInfoCallback {
        private static final String DESCRIPTOR = "com.migu.music.ipc.IQuerySongListInfoCallback";
        static final int TRANSACTION_onSongListInfoReady = 1;

        public static class Proxy implements IQuerySongListInfoCallback {
            public static IQuerySongListInfoCallback sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.migu.music.ipc.IQuerySongListInfoCallback
            public void onSongListInfoReady(List<MgSong> list, int i10, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeTypedList(list);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onSongListInfoReady(list, i10, str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IQuerySongListInfoCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IQuerySongListInfoCallback)) ? new Proxy(iBinder) : (IQuerySongListInfoCallback) iInterfaceQueryLocalInterface;
        }

        public static IQuerySongListInfoCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IQuerySongListInfoCallback iQuerySongListInfoCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iQuerySongListInfoCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iQuerySongListInfoCallback;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 != 1) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            onSongListInfoReady(parcel.createTypedArrayList(MgSong.CREATOR), parcel.readInt(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }
    }

    void onSongListInfoReady(List<MgSong> list, int i10, String str) throws RemoteException;
}
