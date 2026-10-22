package android.content.pm;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IPackageInstallObserver extends IInterface {
    public static final String DESCRIPTOR = "android.content.pm.IPackageInstallObserver";

    public static abstract class a extends Binder implements IPackageInstallObserver {
        static final int TRANSACTION_packageInstalled = 1;

        /* JADX INFO: renamed from: android.content.pm.IPackageInstallObserver$a$a, reason: collision with other inner class name */
        public static class IPackageInstallObserverC0002a implements IPackageInstallObserver {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f101a;

            public IPackageInstallObserverC0002a(IBinder r10) {
                this.f101a = r10;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f101a;
            }

            @Override // android.content.pm.IPackageInstallObserver
            public void packageInstalled(String r10, int r11) {
                Parcel r12 = Parcel.obtain();
                r12.writeInterfaceToken(IPackageInstallObserver.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeString(r10);     // Catch: Throwable -> L6
                r12.writeInt(r11);     // Catch: Throwable -> L6
                this.f101a.transact(1, r12, null, 1);     // Catch: Throwable -> L6
                r12.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                throw th;
            }
        }

        public a() {
            attachInterface(this, IPackageInstallObserver.DESCRIPTOR);
        }

        public static IPackageInstallObserver asInterface(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface(IPackageInstallObserver.DESCRIPTOR);
            if (r11 == null) goto L12;
            if ((r11 instanceof IPackageInstallObserver) == false) goto L12;
            return (IPackageInstallObserver) r11;
        L12:
            return new IPackageInstallObserverC0002a(r10);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) throws RemoteException {
            if (r10 < 1) goto L8;
            if (r10 > 16777215) goto L8;
            r11.enforceInterface(IPackageInstallObserver.DESCRIPTOR);
        L8:
            if (r10 == 1598968902) goto L14;
            if (r10 != 1) goto L11;
            packageInstalled(r11.readString(), r11.readInt());
            return true;
        L11:
            return super.onTransact(r10, r11, r12, r13);
        L14:
            r12.writeString(IPackageInstallObserver.DESCRIPTOR);
            return true;
        }
    }

    void packageInstalled(String r10, int r11) throws RemoteException;
}
