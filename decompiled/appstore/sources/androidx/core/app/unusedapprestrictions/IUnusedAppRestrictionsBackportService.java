package androidx.core.app.unusedapprestrictions;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IUnusedAppRestrictionsBackportService extends IInterface {
    public static final String DESCRIPTOR = "androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService";

    public static abstract class a extends Binder implements IUnusedAppRestrictionsBackportService {
        public a() {
            attachInterface(this, IUnusedAppRestrictionsBackportService.DESCRIPTOR);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 < 1) goto L8;
            if (r10 > 16777215) goto L8;
            r11.enforceInterface(IUnusedAppRestrictionsBackportService.DESCRIPTOR);
        L8:
            if (r10 == 1598968902) goto L14;
            if (r10 != 1) goto L11;
            isPermissionRevocationEnabledForApp(IUnusedAppRestrictionsBackportCallback.a.a(r11.readStrongBinder()));
            return true;
        L11:
            return super.onTransact(r10, r11, r12, r13);
        L14:
            r12.writeString(IUnusedAppRestrictionsBackportService.DESCRIPTOR);
            return true;
        }
    }

    void isPermissionRevocationEnabledForApp(IUnusedAppRestrictionsBackportCallback r10) throws RemoteException;
}
