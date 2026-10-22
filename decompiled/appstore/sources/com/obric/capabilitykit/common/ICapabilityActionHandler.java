package com.obric.capabilitykit.common;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.obric.capabilitykit.common.execution.IntentCalling;
import com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver;

/* JADX INFO: loaded from: classes3.dex */
public interface ICapabilityActionHandler extends IInterface {

    public static class Default implements ICapabilityActionHandler {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public int getVersion() throws RemoteException {
            return 0;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public boolean handleAction(String r10) throws RemoteException {
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public boolean handleIntentCalling(IntentCalling r10) throws RemoteException {
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public int isTaskRunning(String r10, String r11) throws RemoteException {
            return 0;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public boolean openUriFile(Uri r10, IUriFileReceiver r11, String r12) throws RemoteException {
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public boolean stopAction(String r10, String r11) throws RemoteException {
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public boolean stopComplexTask(String r10) throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements ICapabilityActionHandler {
        private static final String DESCRIPTOR = "com.obric.capabilitykit.common.ICapabilityActionHandler";
        public static final int TRANSACTION_getVersion = 1;
        public static final int TRANSACTION_handleAction = 2;
        public static final int TRANSACTION_handleIntentCalling = 3;
        public static final int TRANSACTION_isTaskRunning = 7;
        public static final int TRANSACTION_openUriFile = 4;
        public static final int TRANSACTION_stopAction = 6;
        public static final int TRANSACTION_stopComplexTask = 5;

        public static class Proxy implements ICapabilityActionHandler {
            public static ICapabilityActionHandler sDefaultImpl;
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

            @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
            public int getVersion() throws RemoteException {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (this.mRemote.transact(1, r10, r11, 0) == false) goto L6;
            L12:
                r11.readException();     // Catch: Throwable -> L10
                int r12 = r11.readInt();     // Catch: Throwable -> L10
            L8:
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (Stub.getDefaultImpl() == null) goto L12;
                r12 = Stub.getDefaultImpl().getVersion();     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
            public boolean handleAction(String r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r11.writeString(r10);     // Catch: Throwable -> L10
                boolean r13 = false;
                if (this.mRemote.transact(2, r11, r12, 0) == false) goto L6;
            L12:
                r12.readException();     // Catch: Throwable -> L10
                if (r12.readInt() == 0) goto L15;
                r13 = true;
            L15:
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (Stub.getDefaultImpl() == null) goto L12;
                boolean r14 = Stub.getDefaultImpl().handleAction(r10);     // Catch: Throwable -> L10
                r12.recycle();
                r11.recycle();
                return r14;
            L10:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
            public boolean handleIntentCalling(IntentCalling r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                boolean r13 = true;
                if (r10 == null) goto L8;
                r11.writeInt(1);     // Catch: Throwable -> L6
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L6
            L10:
                if (this.mRemote.transact(3, r11, r12, 0) == false) goto L12;
            L16:
                r12.readException();     // Catch: Throwable -> L6
                if (r12.readInt() != 0) goto L20;
                r13 = false;
            L20:
                r12.recycle();
                r11.recycle();
                return r13;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                boolean r14 = Stub.getDefaultImpl().handleIntentCalling(r10);     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return r14;
            L8:
                r11.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
            public int isTaskRunning(String r10, String r11) throws RemoteException {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r12.writeString(r10);     // Catch: Throwable -> L10
                r12.writeString(r11);     // Catch: Throwable -> L10
                if (this.mRemote.transact(7, r12, r13, 0) == false) goto L6;
            L12:
                r13.readException();     // Catch: Throwable -> L10
                int r14 = r13.readInt();     // Catch: Throwable -> L10
            L8:
                r13.recycle();
                r12.recycle();
                return r14;
            L6:
                if (Stub.getDefaultImpl() == null) goto L12;
                r14 = Stub.getDefaultImpl().isTaskRunning(r10, r11);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
            public boolean openUriFile(Uri r10, IUriFileReceiver r11, String r12) throws RemoteException {
                Parcel r13 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                boolean r15 = true;
                if (r10 == null) goto L8;
                r13.writeInt(1);     // Catch: Throwable -> L6
                r10.writeToParcel(r13, 0);     // Catch: Throwable -> L6
            L9:
                if (r11 == null) goto L11;
                IBinder r16 = r11.asBinder();     // Catch: Throwable -> L6
            L12:
                r13.writeStrongBinder(r16);     // Catch: Throwable -> L6
                r13.writeString(r12);     // Catch: Throwable -> L6
                if (this.mRemote.transact(4, r13, r14, 0) == false) goto L15;
            L19:
                r14.readException();     // Catch: Throwable -> L6
                if (r14.readInt() != 0) goto L23;
                r15 = false;
            L23:
                r14.recycle();
                r13.recycle();
                return r15;
            L15:
                if (Stub.getDefaultImpl() == null) goto L19;
                boolean r17 = Stub.getDefaultImpl().openUriFile(r10, r11, r12);     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return r17;
            L11:
                r16 = null;
                goto L12
            L8:
                r13.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
            public boolean stopAction(String r10, String r11) throws RemoteException {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r12.writeString(r10);     // Catch: Throwable -> L10
                r12.writeString(r11);     // Catch: Throwable -> L10
                boolean r14 = false;
                if (this.mRemote.transact(6, r12, r13, 0) == false) goto L6;
            L12:
                r13.readException();     // Catch: Throwable -> L10
                if (r13.readInt() == 0) goto L15;
                r14 = true;
            L15:
                r13.recycle();
                r12.recycle();
                return r14;
            L6:
                if (Stub.getDefaultImpl() == null) goto L12;
                boolean r15 = Stub.getDefaultImpl().stopAction(r10, r11);     // Catch: Throwable -> L10
                r13.recycle();
                r12.recycle();
                return r15;
            L10:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
            public boolean stopComplexTask(String r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r11.writeString(r10);     // Catch: Throwable -> L10
                boolean r13 = false;
                if (this.mRemote.transact(5, r11, r12, 0) == false) goto L6;
            L12:
                r12.readException();     // Catch: Throwable -> L10
                if (r12.readInt() == 0) goto L15;
                r13 = true;
            L15:
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (Stub.getDefaultImpl() == null) goto L12;
                boolean r14 = Stub.getDefaultImpl().stopComplexTask(r10);     // Catch: Throwable -> L10
                r12.recycle();
                r11.recycle();
                return r14;
            L10:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICapabilityActionHandler asInterface(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface(DESCRIPTOR);
            if (r11 == null) goto L12;
            if ((r11 instanceof ICapabilityActionHandler) == false) goto L12;
            return (ICapabilityActionHandler) r11;
        L12:
            return new Proxy(r10);
        }

        public static ICapabilityActionHandler getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICapabilityActionHandler r10) {
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
            if (r10 == 1598968902) goto L23;
            IntentCalling r14 = null;
            Uri r15 = null;
            switch(r10) {
                case 1: goto L22;
                case 2: goto L21;
                case 3: goto L17;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L8;
                default: goto L7;
            };
        L8:
            r11.enforceInterface(DESCRIPTOR);
            int r16 = isTaskRunning(r11.readString(), r11.readString());
        L9:
            r12.writeNoException();
            r12.writeInt(r16);
            return true;
        L11:
            r11.enforceInterface(DESCRIPTOR);
            r16 = stopAction(r11.readString(), r11.readString());
            goto L9
        L12:
            r11.enforceInterface(DESCRIPTOR);
            r16 = stopComplexTask(r11.readString());
            goto L9
        L13:
            r11.enforceInterface(DESCRIPTOR);
            if (r11.readInt() == 0) goto L16;
            r15 = (Uri) Uri.CREATOR.createFromParcel(r11);
        L16:
            r16 = openUriFile(r15, IUriFileReceiver.Stub.asInterface(r11.readStrongBinder()), r11.readString());
            goto L9
        L17:
            r11.enforceInterface(DESCRIPTOR);
            if (r11.readInt() == 0) goto L20;
            r14 = IntentCalling.CREATOR.createFromParcel(r11);
        L20:
            r16 = handleIntentCalling(r14);
            goto L9
        L21:
            r11.enforceInterface(DESCRIPTOR);
            r16 = handleAction(r11.readString());
            goto L9
        L22:
            r11.enforceInterface(DESCRIPTOR);
            r16 = getVersion();
            goto L9
        L7:
            return super.onTransact(r10, r11, r12, r13);
        L23:
            r12.writeString(DESCRIPTOR);
            return true;
        }
    }

    int getVersion() throws RemoteException;

    boolean handleAction(String r10) throws RemoteException;

    boolean handleIntentCalling(IntentCalling r10) throws RemoteException;

    int isTaskRunning(String r10, String r11) throws RemoteException;

    boolean openUriFile(Uri r10, IUriFileReceiver r11, String r12) throws RemoteException;

    boolean stopAction(String r10, String r11) throws RemoteException;

    boolean stopComplexTask(String r10) throws RemoteException;
}
