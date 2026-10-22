package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public interface IMultiInstanceInvalidationService extends IInterface {
    public static final String DESCRIPTOR = null;

    public static abstract class a extends Binder implements IMultiInstanceInvalidationService {

        /* JADX INFO: renamed from: androidx.room.IMultiInstanceInvalidationService$a$a, reason: collision with other inner class name */
        public static class C0046a implements IMultiInstanceInvalidationService {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f4450a;

            public C0046a(IBinder r10) {
                this.f4450a = r10;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f4450a;
            }

            @Override // androidx.room.IMultiInstanceInvalidationService
            public void broadcastInvalidation(int r10, String[] r11) {
                Parcel r12 = Parcel.obtain();
                r12.writeInterfaceToken(IMultiInstanceInvalidationService.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeInt(r10);     // Catch: Throwable -> L6
                r12.writeStringArray(r11);     // Catch: Throwable -> L6
                this.f4450a.transact(3, r12, null, 1);     // Catch: Throwable -> L6
                r12.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                throw th;
            }

            @Override // androidx.room.IMultiInstanceInvalidationService
            public int registerCallback(IMultiInstanceInvalidationCallback r10, String r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IMultiInstanceInvalidationService.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeStrongInterface(r10);     // Catch: Throwable -> L6
                r12.writeString(r11);     // Catch: Throwable -> L6
                this.f4450a.transact(1, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                int r14 = r13.readInt();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return r14;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // androidx.room.IMultiInstanceInvalidationService
            public void unregisterCallback(IMultiInstanceInvalidationCallback r10, int r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IMultiInstanceInvalidationService.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeStrongInterface(r10);     // Catch: Throwable -> L6
                r12.writeInt(r11);     // Catch: Throwable -> L6
                this.f4450a.transact(2, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }
        }

        public a() {
            attachInterface(this, IMultiInstanceInvalidationService.DESCRIPTOR);
        }

        public static IMultiInstanceInvalidationService a(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface(IMultiInstanceInvalidationService.DESCRIPTOR);
            if (r11 == null) goto L12;
            if ((r11 instanceof IMultiInstanceInvalidationService) == false) goto L12;
            return (IMultiInstanceInvalidationService) r11;
        L12:
            return new C0046a(r10);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            String r14 = IMultiInstanceInvalidationService.DESCRIPTOR;
            if (r10 < 1) goto L8;
            if (r10 > 16777215) goto L8;
            r11.enforceInterface(r14);
        L8:
            if (r10 != 1598968902) goto L11;
            r12.writeString(r14);
            return true;
        L11:
            if (r10 != 1) goto L13;
            int r15 = registerCallback(IMultiInstanceInvalidationCallback.a.a(r11.readStrongBinder()), r11.readString());
            r12.writeNoException();
            r12.writeInt(r15);
        L21:
            return true;
        L13:
            if (r10 != 2) goto L15;
            unregisterCallback(IMultiInstanceInvalidationCallback.a.a(r11.readStrongBinder()), r11.readInt());
            r12.writeNoException();
            goto L21
        L15:
            if (r10 != 3) goto L17;
            broadcastInvalidation(r11.readInt(), r11.createStringArray());
            goto L21
        L17:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    static {
        DESCRIPTOR = "androidx$room$IMultiInstanceInvalidationService".replace('$', '.');
    }

    void broadcastInvalidation(int r10, String[] r11) throws RemoteException;

    int registerCallback(IMultiInstanceInvalidationCallback r10, String r11) throws RemoteException;

    void unregisterCallback(IMultiInstanceInvalidationCallback r10, int r11) throws RemoteException;
}
