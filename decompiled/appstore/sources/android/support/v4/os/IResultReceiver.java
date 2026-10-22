package android.support.v4.os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IResultReceiver extends IInterface {
    public static final String DESCRIPTOR = "android.support.v4.os.IResultReceiver";

    public static class Default implements IResultReceiver {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.support.v4.os.IResultReceiver
        public void send(int r10, Bundle r11) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IResultReceiver {
        static final int TRANSACTION_send = 1;

        public static class Proxy implements IResultReceiver {
            private IBinder mRemote;

            public Proxy(IBinder r10) {
                this.mRemote = r10;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IResultReceiver.DESCRIPTOR;
            }

            @Override // android.support.v4.os.IResultReceiver
            public void send(int r10, Bundle r11) throws RemoteException {
                Parcel r12 = Parcel.obtain();
                r12.writeInterfaceToken(IResultReceiver.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeInt(r10);     // Catch: Throwable -> L6
                _Parcel.access$100(r12, r11, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r12, null, 1);     // Catch: Throwable -> L6
                r12.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, IResultReceiver.DESCRIPTOR);
        }

        public static IResultReceiver asInterface(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface(IResultReceiver.DESCRIPTOR);
            if (r11 == null) goto L12;
            if ((r11 instanceof IResultReceiver) == false) goto L12;
            return (IResultReceiver) r11;
        L12:
            return new Proxy(r10);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) throws RemoteException {
            if (r10 < 1) goto L8;
            if (r10 > 16777215) goto L8;
            r11.enforceInterface(IResultReceiver.DESCRIPTOR);
        L8:
            if (r10 == 1598968902) goto L14;
            if (r10 != 1) goto L11;
            send(r11.readInt(), (Bundle) _Parcel.access$000(r11, Bundle.CREATOR));
            return true;
        L11:
            return super.onTransact(r10, r11, r12, r13);
        L14:
            r12.writeString(IResultReceiver.DESCRIPTOR);
            return true;
        }
    }

    public static class _Parcel {
        public _Parcel() {
        }

        public static /* synthetic */ Object access$000(Parcel r10, Parcelable.Creator r11) {
            return readTypedObject(r10, r11);
        }

        public static /* synthetic */ void access$100(Parcel r10, Parcelable r11, int r12) {
            writeTypedObject(r10, r11, r12);
        }

        private static <T> T readTypedObject(Parcel r10, Parcelable.Creator<T> r11) {
            if (r10.readInt() != 0) goto L5;
            return null;
        L5:
            return r11.createFromParcel(r10);
        }

        private static <T extends Parcelable> void writeTypedObject(Parcel r10, T r11, int r12) {
            if (r11 == null) goto L4;
            r10.writeInt(1);
            r11.writeToParcel(r10, r12);
            return;
        L4:
            r10.writeInt(0);
        }
    }

    void send(int r10, Bundle r11) throws RemoteException;
}
