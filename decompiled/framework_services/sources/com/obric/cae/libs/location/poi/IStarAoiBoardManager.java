package com.obric.cae.libs.location.poi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface IStarAoiBoardManager extends IInterface {
    public static final String DESCRIPTOR = "com.obric.cae.libs.location.poi.IStarAoiBoardManager";

    public static class Default implements IStarAoiBoardManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
        public AoiBoard findAoiBoardByPoiId(String r1) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
        public boolean isAoiBoardsRecovered() throws RemoteException {
            return false;
        }

        @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
        public List<AoiBoard> listAllAoiBoards() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
        public List<AoiBoard> listAoiBoardsByType(int r1) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
        public void registerAoiBoardCallback(IStarAoiBoardCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
        public void unregisterAoiBoardCallback() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IStarAoiBoardManager {
        static final int TRANSACTION_findAoiBoardByPoiId = 5;
        static final int TRANSACTION_isAoiBoardsRecovered = 6;
        static final int TRANSACTION_listAllAoiBoards = 3;
        static final int TRANSACTION_listAoiBoardsByType = 4;
        static final int TRANSACTION_registerAoiBoardCallback = 1;
        static final int TRANSACTION_unregisterAoiBoardCallback = 2;

        public static class Proxy implements IStarAoiBoardManager {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
            public AoiBoard findAoiBoardByPoiId(String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStarAoiBoardManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(5, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                Parcelable.Creator<AoiBoard> r6 = AoiBoard.CREATOR;     // Catch: Throwable -> L6
                if (r1.readInt() == 0) goto L8;
                AoiBoard r7 = r6.createFromParcel(r1);     // Catch: Throwable -> L6
            L9:
                AoiBoard r8 = r7;     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r8;
            L8:
                r7 = null;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return IStarAoiBoardManager.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
            public boolean isAoiBoardsRecovered() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStarAoiBoardManager.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean r4 = false;
                this.mRemote.transact(6, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r4 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r4;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
            public List<AoiBoard> listAllAoiBoards() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStarAoiBoardManager.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                ArrayList r2 = r1.createTypedArrayList(AoiBoard.CREATOR);     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
            public List<AoiBoard> listAoiBoardsByType(int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IStarAoiBoardManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(4, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                ArrayList r6 = r1.createTypedArrayList(AoiBoard.CREATOR);     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r6;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
            public void registerAoiBoardCallback(IStarAoiBoardCallback r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IStarAoiBoardManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
            public void unregisterAoiBoardCallback() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IStarAoiBoardManager.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, IStarAoiBoardManager.DESCRIPTOR);
        }

        public static IStarAoiBoardManager asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IStarAoiBoardManager.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IStarAoiBoardManager) == false) goto L12;
            return (IStarAoiBoardManager) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(IStarAoiBoardManager.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L19;
            switch(r4) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                default: goto L11;
            };
        L12:
            boolean r8 = isAoiBoardsRecovered();
            r6.writeNoException();
            r6.writeInt(r8 ? 1 : 0);
        L18:
            return true;
        L13:
            AoiBoard r9 = findAoiBoardByPoiId(r5.readString());
            r6.writeNoException();
            _Parcel.a(r6, r9);
            goto L18
        L14:
            List<AoiBoard> r10 = listAoiBoardsByType(r5.readInt());
            r6.writeNoException();
            r6.writeTypedList(r10);
            goto L18
        L15:
            List<AoiBoard> r11 = listAllAoiBoards();
            r6.writeNoException();
            r6.writeTypedList(r11);
            goto L18
        L16:
            unregisterAoiBoardCallback();
            goto L18
        L17:
            registerAoiBoardCallback(IStarAoiBoardCallback.Stub.asInterface(r5.readStrongBinder()));
            goto L18
        L11:
            return super.onTransact(r4, r5, r6, r7);
        L19:
            r6.writeString(IStarAoiBoardManager.DESCRIPTOR);
            return true;
        }
    }

    public static class _Parcel {
        public _Parcel() {
        }

        public static void a(Parcel r1, AoiBoard r2) {
            if (r2 == null) goto L4;
            r1.writeInt(1);
            r2.writeToParcel(r1, 1);
            return;
        L4:
            r1.writeInt(0);
        }
    }

    AoiBoard findAoiBoardByPoiId(String r1) throws RemoteException;

    boolean isAoiBoardsRecovered() throws RemoteException;

    List<AoiBoard> listAllAoiBoards() throws RemoteException;

    List<AoiBoard> listAoiBoardsByType(int r1) throws RemoteException;

    void registerAoiBoardCallback(IStarAoiBoardCallback r1) throws RemoteException;

    void unregisterAoiBoardCallback() throws RemoteException;
}
