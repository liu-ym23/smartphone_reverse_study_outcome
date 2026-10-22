package com.obric.cae.libs.appscene;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IAppSceneCallback extends IInterface {
    public static final String DESCRIPTOR = "com.obric.cae.libs.appscene.IAppSceneCallback";

    public static class Default implements IAppSceneCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.appscene.IAppSceneCallback
        public void onAppSceneChanged(AppSceneInfo r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.appscene.IAppSceneCallback
        public void onAppSceneChangedEnter(AppSceneInfo r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.appscene.IAppSceneCallback
        public void onAppSceneChangedExit(AppSceneInfo r1) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IAppSceneCallback {
        static final int TRANSACTION_onAppSceneChanged = 1;
        static final int TRANSACTION_onAppSceneChangedEnter = 2;
        static final int TRANSACTION_onAppSceneChangedExit = 3;

        public static class Proxy implements IAppSceneCallback {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IAppSceneCallback.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.appscene.IAppSceneCallback
            public void onAppSceneChanged(AppSceneInfo r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IAppSceneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r4 == null) goto L8;
                r0.writeInt(1);     // Catch: Throwable -> L6
                r4.writeToParcel(r0, 0);     // Catch: Throwable -> L6
            L9:
                this.mRemote.transact(1, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L8:
                r0.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.appscene.IAppSceneCallback
            public void onAppSceneChangedEnter(AppSceneInfo r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IAppSceneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r5 == null) goto L8;
                r0.writeInt(1);     // Catch: Throwable -> L6
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L6
            L9:
                this.mRemote.transact(2, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L8:
                r0.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.appscene.IAppSceneCallback
            public void onAppSceneChangedExit(AppSceneInfo r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IAppSceneCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r5 == null) goto L8;
                r0.writeInt(1);     // Catch: Throwable -> L6
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L6
            L9:
                this.mRemote.transact(3, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L8:
                r0.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, IAppSceneCallback.DESCRIPTOR);
        }

        public static IAppSceneCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IAppSceneCallback.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IAppSceneCallback) == false) goto L12;
            return (IAppSceneCallback) r0;
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
            r5.enforceInterface(IAppSceneCallback.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L20;
            if (r4 != 1) goto L11;
            onAppSceneChanged((AppSceneInfo) _Parcel.a(r5, AppSceneInfo.CREATOR));
        L19:
            return true;
        L11:
            if (r4 != 2) goto L13;
            onAppSceneChangedEnter((AppSceneInfo) _Parcel.a(r5, AppSceneInfo.CREATOR));
            goto L19
        L13:
            if (r4 != 3) goto L15;
            onAppSceneChangedExit((AppSceneInfo) _Parcel.a(r5, AppSceneInfo.CREATOR));
            goto L19
        L15:
            return super.onTransact(r4, r5, r6, r7);
        L20:
            r6.writeString(IAppSceneCallback.DESCRIPTOR);
            return true;
        }
    }

    public static class _Parcel {
        public _Parcel() {
        }

        public static Object a(Parcel r1, Parcelable.Creator r2) {
            if (r1.readInt() != 0) goto L7;
            return null;
        L7:
            return r2.createFromParcel(r1);
        }
    }

    void onAppSceneChanged(AppSceneInfo r1) throws RemoteException;

    void onAppSceneChangedEnter(AppSceneInfo r1) throws RemoteException;

    void onAppSceneChangedExit(AppSceneInfo r1) throws RemoteException;
}
