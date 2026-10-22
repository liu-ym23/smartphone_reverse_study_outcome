package com.obric.capabilitykit.common.execution.fileaccess;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IUriFileSharer extends IInterface {

    public static class Default implements IUriFileSharer {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.capabilitykit.common.execution.fileaccess.IUriFileSharer
        public int onRequestUriAccess(IUriFileReceiver r10, Uri r11, String r12) throws RemoteException {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements IUriFileSharer {
        private static final String DESCRIPTOR = "com.obric.capabilitykit.common.execution.fileaccess.IUriFileSharer";
        public static final int TRANSACTION_onRequestUriAccess = 1;

        public static class Proxy implements IUriFileSharer {
            public static IUriFileSharer sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r10) {
                this.mRemote = r10;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.capabilitykit.common.execution.fileaccess.IUriFileSharer
            public int onRequestUriAccess(IUriFileReceiver r10, Uri r11, String r12) throws RemoteException {
                Parcel r13 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r10 == null) goto L8;
                IBinder r15 = r10.asBinder();     // Catch: Throwable -> L6
            L9:
                r13.writeStrongBinder(r15);     // Catch: Throwable -> L6
                if (r11 == null) goto L12;
                r13.writeInt(1);     // Catch: Throwable -> L6
                r11.writeToParcel(r13, 0);     // Catch: Throwable -> L6
            L13:
                r13.writeString(r12);     // Catch: Throwable -> L6
                if (this.mRemote.transact(1, r13, r14, 0) == false) goto L16;
            L20:
                r14.readException();     // Catch: Throwable -> L6
                int r16 = r14.readInt();     // Catch: Throwable -> L6
            L18:
                r14.recycle();
                r13.recycle();
                return r16;
            L16:
                if (Stub.getDefaultImpl() == null) goto L20;
                r16 = Stub.getDefaultImpl().onRequestUriAccess(r10, r11, r12);     // Catch: Throwable -> L6
                goto L18
            L12:
                r13.writeInt(0);     // Catch: Throwable -> L6
                goto L13
            L8:
                r15 = null;
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IUriFileSharer asInterface(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface(DESCRIPTOR);
            if (r11 == null) goto L12;
            if ((r11 instanceof IUriFileSharer) == false) goto L12;
            return (IUriFileSharer) r11;
        L12:
            return new Proxy(r10);
        }

        public static IUriFileSharer getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IUriFileSharer r10) {
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r10 == null) goto L9;
            Proxy.sDefaultImpl = r10;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) throws RemoteException {
            if (r10 != 1) goto L5;
            r11.enforceInterface(DESCRIPTOR);
            IUriFileReceiver r14 = IUriFileReceiver.Stub.asInterface(r11.readStrongBinder());
            if (r11.readInt() == 0) goto L13;
            Uri r15 = (Uri) Uri.CREATOR.createFromParcel(r11);
        L14:
            int r16 = onRequestUriAccess(r14, r15, r11.readString());
            r12.writeNoException();
            r12.writeInt(r16);
            return true;
        L13:
            r15 = null;
            goto L14
        L5:
            if (r10 != 1598968902) goto L7;
            r12.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    int onRequestUriAccess(IUriFileReceiver r10, Uri r11, String r12) throws RemoteException;
}
