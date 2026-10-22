package android.content.pm;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IPackageInstallObserver2 extends IInterface {

    public static abstract class a extends Binder implements IPackageInstallObserver2 {
        public static final String DESCRIPTOR = "android.content.pm.IPackageInstallObserver2";
        static final int TRANSACTION_onPackageInstalled = 2;
        static final int TRANSACTION_onUserActionRequired = 1;

        /* JADX INFO: renamed from: android.content.pm.IPackageInstallObserver2$a$a, reason: collision with other inner class name */
        public static class IPackageInstallObserver2C0003a implements IPackageInstallObserver2 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f102a;

            public IPackageInstallObserver2C0003a(IBinder r10) {
                this.f102a = r10;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f102a;
            }

            @Override // android.content.pm.IPackageInstallObserver2
            public void onPackageInstalled(String r10, int r11, String r12, Bundle r13) {
                Parcel r14 = Parcel.obtain();
                r14.writeInterfaceToken(a.DESCRIPTOR);     // Catch: Throwable -> L6
                r14.writeString(r10);     // Catch: Throwable -> L6
                r14.writeInt(r11);     // Catch: Throwable -> L6
                r14.writeString(r12);     // Catch: Throwable -> L6
                b.b(r14, r13, 0);     // Catch: Throwable -> L6
                this.f102a.transact(2, r14, null, 1);     // Catch: Throwable -> L6
                r14.recycle();
                return;
            L6:
                th = move-exception;
                r14.recycle();
                throw th;
            }

            @Override // android.content.pm.IPackageInstallObserver2
            public void onUserActionRequired(Intent r10) {
                Parcel r11 = Parcel.obtain();
                r11.writeInterfaceToken(a.DESCRIPTOR);     // Catch: Throwable -> L6
                b.b(r11, r10, 0);     // Catch: Throwable -> L6
                this.f102a.transact(1, r11, null, 1);     // Catch: Throwable -> L6
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r11.recycle();
                throw th;
            }
        }

        public a() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IPackageInstallObserver2 asInterface(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface(DESCRIPTOR);
            if (r11 == null) goto L12;
            if ((r11 instanceof IPackageInstallObserver2) == false) goto L12;
            return (IPackageInstallObserver2) r11;
        L12:
            return new IPackageInstallObserver2C0003a(r10);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) throws RemoteException {
            if (r10 < 1) goto L8;
            if (r10 > 16777215) goto L8;
            r11.enforceInterface(DESCRIPTOR);
        L8:
            if (r10 == 1598968902) goto L17;
            if (r10 != 1) goto L11;
            onUserActionRequired((Intent) b.a(r11, Intent.CREATOR));
        L16:
            return true;
        L11:
            if (r10 != 2) goto L13;
            onPackageInstalled(r11.readString(), r11.readInt(), r11.readString(), (Bundle) b.a(r11, Bundle.CREATOR));
            goto L16
        L13:
            return super.onTransact(r10, r11, r12, r13);
        L17:
            r12.writeString(DESCRIPTOR);
            return true;
        }
    }

    public static class b {
        public static /* synthetic */ Object a(Parcel r10, Parcelable.Creator r11) {
            return c(r10, r11);
        }

        public static /* synthetic */ void b(Parcel r10, Parcelable r11, int r12) {
            d(r10, r11, r12);
        }

        public static Object c(Parcel r10, Parcelable.Creator r11) {
            if (r10.readInt() != 0) goto L5;
            return null;
        L5:
            return r11.createFromParcel(r10);
        }

        public static void d(Parcel r10, Parcelable r11, int r12) {
            if (r11 == null) goto L4;
            r10.writeInt(1);
            r11.writeToParcel(r10, r12);
            return;
        L4:
            r10.writeInt(0);
        }
    }

    void onPackageInstalled(String r10, int r11, String r12, Bundle r13) throws RemoteException;

    void onUserActionRequired(Intent r10) throws RemoteException;
}
