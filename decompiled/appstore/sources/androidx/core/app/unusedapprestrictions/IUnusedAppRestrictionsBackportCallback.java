package androidx.core.app.unusedapprestrictions;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IUnusedAppRestrictionsBackportCallback extends IInterface {
    public static final String DESCRIPTOR = "androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback";

    public static abstract class a extends Binder implements IUnusedAppRestrictionsBackportCallback {

        /* JADX INFO: renamed from: androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback$a$a, reason: collision with other inner class name */
        public static class C0013a implements IUnusedAppRestrictionsBackportCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f2509a;

            public C0013a(IBinder r10) {
                this.f2509a = r10;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2509a;
            }

            @Override // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback
            public void onIsPermissionRevocationEnabledForAppResult(boolean r10, boolean r11) {
                Parcel r12 = Parcel.obtain();
                r12.writeInterfaceToken(IUnusedAppRestrictionsBackportCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeInt(r10 ? 1 : 0);     // Catch: Throwable -> L6
                r12.writeInt(r11 ? 1 : 0);     // Catch: Throwable -> L6
                this.f2509a.transact(1, r12, null, 1);     // Catch: Throwable -> L6
                r12.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                throw th;
            }
        }

        public static IUnusedAppRestrictionsBackportCallback a(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface(IUnusedAppRestrictionsBackportCallback.DESCRIPTOR);
            if (r11 == null) goto L12;
            if ((r11 instanceof IUnusedAppRestrictionsBackportCallback) == false) goto L12;
            return (IUnusedAppRestrictionsBackportCallback) r11;
        L12:
            return new C0013a(r10);
        }
    }

    void onIsPermissionRevocationEnabledForAppResult(boolean r10, boolean r11) throws RemoteException;
}
