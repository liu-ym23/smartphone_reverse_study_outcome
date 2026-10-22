package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public interface IMultiInstanceInvalidationCallback extends IInterface {
    public static final String DESCRIPTOR = null;

    public static abstract class a extends Binder implements IMultiInstanceInvalidationCallback {

        /* JADX INFO: renamed from: androidx.room.IMultiInstanceInvalidationCallback$a$a, reason: collision with other inner class name */
        public static class C0045a implements IMultiInstanceInvalidationCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f4449a;

            public C0045a(IBinder r10) {
                this.f4449a = r10;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f4449a;
            }

            @Override // androidx.room.IMultiInstanceInvalidationCallback
            public void onInvalidation(String[] r10) {
                Parcel r11 = Parcel.obtain();
                r11.writeInterfaceToken(IMultiInstanceInvalidationCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeStringArray(r10);     // Catch: Throwable -> L6
                this.f4449a.transact(1, r11, null, 1);     // Catch: Throwable -> L6
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r11.recycle();
                throw th;
            }
        }

        public a() {
            attachInterface(this, IMultiInstanceInvalidationCallback.DESCRIPTOR);
        }

        public static IMultiInstanceInvalidationCallback a(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface(IMultiInstanceInvalidationCallback.DESCRIPTOR);
            if (r11 == null) goto L12;
            if ((r11 instanceof IMultiInstanceInvalidationCallback) == false) goto L12;
            return (IMultiInstanceInvalidationCallback) r11;
        L12:
            return new C0045a(r10);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            String r14 = IMultiInstanceInvalidationCallback.DESCRIPTOR;
            if (r10 < 1) goto L8;
            if (r10 > 16777215) goto L8;
            r11.enforceInterface(r14);
        L8:
            if (r10 != 1598968902) goto L11;
            r12.writeString(r14);
            return true;
        L11:
            if (r10 != 1) goto L13;
            onInvalidation(r11.createStringArray());
            return true;
        L13:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    static {
        DESCRIPTOR = "androidx$room$IMultiInstanceInvalidationCallback".replace('$', '.');
    }

    void onInvalidation(String[] r10) throws RemoteException;
}
