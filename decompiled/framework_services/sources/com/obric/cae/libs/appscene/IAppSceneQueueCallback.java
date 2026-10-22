package com.obric.cae.libs.appscene;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface IAppSceneQueueCallback extends IInterface {
    public static final String DESCRIPTOR = "com.obric.cae.libs.appscene.IAppSceneQueueCallback";

    public static class Default implements IAppSceneQueueCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.appscene.IAppSceneQueueCallback
        public void onAppSceneQueueChanged(List<BaseAppScene> r1) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IAppSceneQueueCallback {
        static final int TRANSACTION_onAppSceneQueueChanged = 1;

        public static class Proxy implements IAppSceneQueueCallback {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IAppSceneQueueCallback.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.appscene.IAppSceneQueueCallback
            public void onAppSceneQueueChanged(List<BaseAppScene> r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IAppSceneQueueCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeTypedList(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, IAppSceneQueueCallback.DESCRIPTOR);
        }

        public static IAppSceneQueueCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IAppSceneQueueCallback.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IAppSceneQueueCallback) == false) goto L12;
            return (IAppSceneQueueCallback) r0;
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
            r5.enforceInterface(IAppSceneQueueCallback.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L14;
            if (r4 != 1) goto L11;
            onAppSceneQueueChanged(r5.createTypedArrayList(BaseAppScene.CREATOR));
            return true;
        L11:
            return super.onTransact(r4, r5, r6, r7);
        L14:
            r6.writeString(IAppSceneQueueCallback.DESCRIPTOR);
            return true;
        }
    }

    public static class _Parcel {
        public _Parcel() {
        }
    }

    void onAppSceneQueueChanged(List<BaseAppScene> r1) throws RemoteException;
}
