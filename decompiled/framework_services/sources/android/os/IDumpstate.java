package android.os;

import java.io.FileDescriptor;

/* JADX INFO: loaded from: classes.dex */
public interface IDumpstate extends IInterface {
    public static final int BUGREPORT_FLAG_DEFER_CONSENT = 2;
    public static final int BUGREPORT_FLAG_KEEP_BUGREPORT_ON_RETRIEVAL = 4;
    public static final int BUGREPORT_FLAG_USE_PREDUMPED_UI_DATA = 1;
    public static final int BUGREPORT_MODE_DEFAULT = 6;
    public static final int BUGREPORT_MODE_FULL = 0;
    public static final int BUGREPORT_MODE_INTERACTIVE = 1;
    public static final int BUGREPORT_MODE_ONBOARDING = 7;
    public static final int BUGREPORT_MODE_REMOTE = 2;
    public static final int BUGREPORT_MODE_TELEPHONY = 4;
    public static final int BUGREPORT_MODE_WEAR = 3;
    public static final int BUGREPORT_MODE_WIFI = 5;
    public static final String DESCRIPTOR = "android.os.IDumpstate";

    public static class Default implements IDumpstate {
        public Default() {
        }

        @Override // android.os.IDumpstate
        public void preDumpUiData(String callingPackage) throws RemoteException {
        }

        @Override // android.os.IDumpstate
        public void startBugreport(int callingUid, String callingPackage, FileDescriptor bugreportFd, FileDescriptor screenshotFd, int bugreportMode, int bugreportFlags, IDumpstateListener listener, boolean isScreenshotRequested, boolean skipUserConsent) throws RemoteException {
        }

        @Override // android.os.IDumpstate
        public void cancelBugreport(int callingUid, String callingPackage) throws RemoteException {
        }

        @Override // android.os.IDumpstate
        public void retrieveBugreport(int callingUid, String callingPackage, int userId, FileDescriptor bugreportFd, String bugreportFile, boolean keepBugreportOnRetrieval, boolean skipUserConsent, IDumpstateListener listener) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IDumpstate {
        static final int TRANSACTION_cancelBugreport = 3;
        static final int TRANSACTION_preDumpUiData = 1;
        static final int TRANSACTION_retrieveBugreport = 4;
        static final int TRANSACTION_startBugreport = 2;

        private static class Proxy implements IDumpstate {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IDumpstate.DESCRIPTOR;
            }

            @Override // android.os.IDumpstate
            public void preDumpUiData(String callingPackage) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IDumpstate.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(callingPackage);     // Catch: Throwable -> L6
                this.mRemote.transact(1, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IDumpstate
            public void startBugreport(int callingUid, String callingPackage, FileDescriptor bugreportFd, FileDescriptor screenshotFd, int bugreportMode, int bugreportFlags, IDumpstateListener listener, boolean isScreenshotRequested, boolean skipUserConsent) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IDumpstate.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(callingUid);     // Catch: Throwable -> L6
                _data.writeString(callingPackage);     // Catch: Throwable -> L6
                _data.writeRawFileDescriptor(bugreportFd);     // Catch: Throwable -> L6
                _data.writeRawFileDescriptor(screenshotFd);     // Catch: Throwable -> L6
                _data.writeInt(bugreportMode);     // Catch: Throwable -> L6
                _data.writeInt(bugreportFlags);     // Catch: Throwable -> L6
                _data.writeStrongInterface(listener);     // Catch: Throwable -> L6
                _data.writeBoolean(isScreenshotRequested);     // Catch: Throwable -> L6
                _data.writeBoolean(skipUserConsent);     // Catch: Throwable -> L6
                this.mRemote.transact(2, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IDumpstate
            public void cancelBugreport(int callingUid, String callingPackage) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IDumpstate.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(callingUid);     // Catch: Throwable -> L6
                _data.writeString(callingPackage);     // Catch: Throwable -> L6
                this.mRemote.transact(3, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.os.IDumpstate
            public void retrieveBugreport(int callingUid, String callingPackage, int userId, FileDescriptor bugreportFd, String bugreportFile, boolean keepBugreportOnRetrieval, boolean skipUserConsent, IDumpstateListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IDumpstate.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(callingUid);     // Catch: Throwable -> L6
                _data.writeString(callingPackage);     // Catch: Throwable -> L6
                _data.writeInt(userId);     // Catch: Throwable -> L6
                _data.writeRawFileDescriptor(bugreportFd);     // Catch: Throwable -> L6
                _data.writeString(bugreportFile);     // Catch: Throwable -> L6
                _data.writeBoolean(keepBugreportOnRetrieval);     // Catch: Throwable -> L6
                _data.writeBoolean(skipUserConsent);     // Catch: Throwable -> L6
                _data.writeStrongInterface(listener);     // Catch: Throwable -> L6
                this.mRemote.transact(4, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, IDumpstate.DESCRIPTOR);
        }

        public static IDumpstate asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IDumpstate.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IDumpstate) == false) goto L12;
            return (IDumpstate) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code >= 1) goto L5;
        L7:
            Parcel r13 = data;
        L9:
            if (code != 1598968902) goto L13;
            reply.writeString(IDumpstate.DESCRIPTOR);
            return true;
        L13:
            switch(code) {
                case 1: goto L19;
                case 2: goto L18;
                case 3: goto L17;
                case 4: goto L16;
                default: goto L15;
            };
        L16:
            int _arg0 = r13.readInt();
            String _arg1 = r13.readString();
            int _arg2 = r13.readInt();
            FileDescriptor _arg3 = r13.readRawFileDescriptor();
            String _arg4 = r13.readString();
            boolean _arg5 = r13.readBoolean();
            boolean _arg6 = r13.readBoolean();
            IDumpstateListener _arg7 = IDumpstateListener.Stub.asInterface(r13.readStrongBinder());
            r13.enforceNoDataAvail();
            retrieveBugreport(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7);
            reply.writeNoException();
        L20:
            return true;
        L17:
            int _arg8 = r13.readInt();
            String _arg9 = r13.readString();
            r13.enforceNoDataAvail();
            cancelBugreport(_arg8, _arg9);
            reply.writeNoException();
            goto L20
        L18:
            int _arg10 = r13.readInt();
            String _arg11 = r13.readString();
            FileDescriptor _arg12 = r13.readRawFileDescriptor();
            FileDescriptor _arg13 = r13.readRawFileDescriptor();
            int _arg14 = r13.readInt();
            int _arg15 = r13.readInt();
            IDumpstateListener _arg16 = IDumpstateListener.Stub.asInterface(r13.readStrongBinder());
            boolean _arg17 = r13.readBoolean();
            boolean _arg18 = r13.readBoolean();
            r13.enforceNoDataAvail();
            startBugreport(_arg10, _arg11, _arg12, _arg13, _arg14, _arg15, _arg16, _arg17, _arg18);
            reply.writeNoException();
            goto L20
        L19:
            String _arg19 = r13.readString();
            r13.enforceNoDataAvail();
            preDumpUiData(_arg19);
            reply.writeNoException();
            goto L20
        L15:
            return super.onTransact(code, data, reply, flags);
        L5:
            if (code > 16777215) goto L7;
            r13 = data;
            r13.enforceInterface(IDumpstate.DESCRIPTOR);
            goto L9
        }
    }

    void cancelBugreport(int r1, String r2) throws RemoteException;

    void preDumpUiData(String r1) throws RemoteException;

    void retrieveBugreport(int r1, String r2, int r3, FileDescriptor r4, String r5, boolean r6, boolean r7, IDumpstateListener r8) throws RemoteException;

    void startBugreport(int r1, String r2, FileDescriptor r3, FileDescriptor r4, int r5, int r6, IDumpstateListener r7, boolean r8, boolean r9) throws RemoteException;
}
