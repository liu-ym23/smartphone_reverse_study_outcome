package androidx.core.app.unusedapprestrictions;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
public interface IUnusedAppRestrictionsBackportCallback extends IInterface {
    public static final String DESCRIPTOR = null;

    public static class Default implements IUnusedAppRestrictionsBackportCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback
        public void onIsPermissionRevocationEnabledForAppResult(boolean r1, boolean r2) throws RemoteException {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IUnusedAppRestrictionsBackportCallback {
        static final int TRANSACTION_onIsPermissionRevocationEnabledForAppResult = 1;

        private static class Proxy implements IUnusedAppRestrictionsBackportCallback {
            private IBinder mRemote;

            Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }

            @Override // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback
            public void onIsPermissionRevocationEnabledForAppResult(boolean r4, boolean r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L13
                int r1 = 0;
                if (r4 == false) goto L6;
                int r6 = 1;
            L7:
                r0.writeInt(r6);     // Catch: Throwable -> L13
                if (r5 == false) goto L10;
                r1 = 1;
            L10:
                r0.writeInt(r1);     // Catch: Throwable -> L13
                this.mRemote.transact(1, r0, null, 1);     // Catch: Throwable -> L13
                r0.recycle();
                return;
            L6:
                r6 = 0;
            L13:
                th = move-exception;
                r0.recycle();
                throw th;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IUnusedAppRestrictionsBackportCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IUnusedAppRestrictionsBackportCallback) == false) goto L12;
            return (IUnusedAppRestrictionsBackportCallback) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            String r0 = DESCRIPTOR;
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(r0);
        L8:
            if (r4 == 1598968902) goto L21;
            if (r4 != 1) goto L11;
            boolean r8 = false;
            if (r5.readInt() == 0) goto L15;
            boolean r9 = true;
        L17:
            if (r5.readInt() == 0) goto L19;
            r8 = true;
        L19:
            onIsPermissionRevocationEnabledForAppResult(r9, r8);
            return true;
        L15:
            r9 = false;
            goto L17
        L11:
            return super.onTransact(r4, r5, r6, r7);
        L21:
            r6.writeString(r0);
            return true;
        }
    }

    void onIsPermissionRevocationEnabledForAppResult(boolean r1, boolean r2) throws RemoteException;

    static {
        DESCRIPTOR = "androidx$core$app$unusedapprestrictions$IUnusedAppRestrictionsBackportCallback".replace(Typography.dollar, '.');
    }
}
