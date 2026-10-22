package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface INotificationSideChannel extends IInterface {
    public static final String DESCRIPTOR = "android.support.v4.app.INotificationSideChannel";

    public static class Default implements INotificationSideChannel {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void cancel(String r10, int r11, String r12) throws RemoteException {
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void cancelAll(String r10) throws RemoteException {
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void notify(String r10, int r11, String r12, Notification r13) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements INotificationSideChannel {
        static final int TRANSACTION_cancel = 2;
        static final int TRANSACTION_cancelAll = 3;
        static final int TRANSACTION_notify = 1;

        public static class Proxy implements INotificationSideChannel {
            private IBinder mRemote;

            public Proxy(IBinder r10) {
                this.mRemote = r10;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // android.support.v4.app.INotificationSideChannel
            public void cancel(String r10, int r11, String r12) throws RemoteException {
                Parcel r13 = Parcel.obtain();
                r13.writeInterfaceToken(INotificationSideChannel.DESCRIPTOR);     // Catch: Throwable -> L6
                r13.writeString(r10);     // Catch: Throwable -> L6
                r13.writeInt(r11);     // Catch: Throwable -> L6
                r13.writeString(r12);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r13, null, 1);     // Catch: Throwable -> L6
                r13.recycle();
                return;
            L6:
                th = move-exception;
                r13.recycle();
                throw th;
            }

            @Override // android.support.v4.app.INotificationSideChannel
            public void cancelAll(String r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                r11.writeInterfaceToken(INotificationSideChannel.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeString(r10);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r11, null, 1);     // Catch: Throwable -> L6
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r11.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return INotificationSideChannel.DESCRIPTOR;
            }

            @Override // android.support.v4.app.INotificationSideChannel
            public void notify(String r10, int r11, String r12, Notification r13) throws RemoteException {
                Parcel r14 = Parcel.obtain();
                r14.writeInterfaceToken(INotificationSideChannel.DESCRIPTOR);     // Catch: Throwable -> L6
                r14.writeString(r10);     // Catch: Throwable -> L6
                r14.writeInt(r11);     // Catch: Throwable -> L6
                r14.writeString(r12);     // Catch: Throwable -> L6
                _Parcel.access$100(r14, r13, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r14, null, 1);     // Catch: Throwable -> L6
                r14.recycle();
                return;
            L6:
                th = move-exception;
                r14.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, INotificationSideChannel.DESCRIPTOR);
        }

        public static INotificationSideChannel asInterface(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface(INotificationSideChannel.DESCRIPTOR);
            if (r11 == null) goto L12;
            if ((r11 instanceof INotificationSideChannel) == false) goto L12;
            return (INotificationSideChannel) r11;
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
            r11.enforceInterface(INotificationSideChannel.DESCRIPTOR);
        L8:
            if (r10 == 1598968902) goto L20;
            if (r10 != 1) goto L11;
            notify(r11.readString(), r11.readInt(), r11.readString(), (Notification) _Parcel.access$000(r11, Notification.CREATOR));
        L19:
            return true;
        L11:
            if (r10 != 2) goto L13;
            cancel(r11.readString(), r11.readInt(), r11.readString());
            goto L19
        L13:
            if (r10 != 3) goto L15;
            cancelAll(r11.readString());
            goto L19
        L15:
            return super.onTransact(r10, r11, r12, r13);
        L20:
            r12.writeString(INotificationSideChannel.DESCRIPTOR);
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

    void cancel(String r10, int r11, String r12) throws RemoteException;

    void cancelAll(String r10) throws RemoteException;

    void notify(String r10, int r11, String r12, Notification r13) throws RemoteException;
}
