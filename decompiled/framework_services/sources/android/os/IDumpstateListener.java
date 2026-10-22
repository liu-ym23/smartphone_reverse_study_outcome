package android.os;

/* JADX INFO: loaded from: classes.dex */
public interface IDumpstateListener extends IInterface {
    public static final int BUGREPORT_ERROR_ANOTHER_REPORT_IN_PROGRESS = 5;
    public static final int BUGREPORT_ERROR_INVALID_INPUT = 1;
    public static final int BUGREPORT_ERROR_NO_BUGREPORT_TO_RETRIEVE = 6;
    public static final int BUGREPORT_ERROR_RUNTIME_ERROR = 2;
    public static final int BUGREPORT_ERROR_USER_CONSENT_TIMED_OUT = 4;
    public static final int BUGREPORT_ERROR_USER_DENIED_CONSENT = 3;
    public static final String DESCRIPTOR = "android.os.IDumpstateListener";

    public static class Default implements IDumpstateListener {
        public Default() {
        }

        @Override // android.os.IDumpstateListener
        public void onProgress(int progress) throws RemoteException {
        }

        @Override // android.os.IDumpstateListener
        public void onError(int errorCode) throws RemoteException {
        }

        @Override // android.os.IDumpstateListener
        public void onFinished(String bugreportFile) throws RemoteException {
        }

        @Override // android.os.IDumpstateListener
        public void onScreenshotTaken(boolean success) throws RemoteException {
        }

        @Override // android.os.IDumpstateListener
        public void onUiIntensiveBugreportDumpsFinished() throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IDumpstateListener {
        static final int TRANSACTION_onError = 2;
        static final int TRANSACTION_onFinished = 3;
        static final int TRANSACTION_onProgress = 1;
        static final int TRANSACTION_onScreenshotTaken = 4;
        static final int TRANSACTION_onUiIntensiveBugreportDumpsFinished = 5;

        private static class Proxy implements IDumpstateListener {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IDumpstateListener.DESCRIPTOR;
            }

            @Override // android.os.IDumpstateListener
            public void onProgress(int progress) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IDumpstateListener.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(progress);     // Catch: Throwable -> L6
                this.mRemote.transact(1, _data, null, 1);     // Catch: Throwable -> L6
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.os.IDumpstateListener
            public void onError(int errorCode) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IDumpstateListener.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(errorCode);     // Catch: Throwable -> L6
                this.mRemote.transact(2, _data, null, 1);     // Catch: Throwable -> L6
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.os.IDumpstateListener
            public void onFinished(String bugreportFile) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IDumpstateListener.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(bugreportFile);     // Catch: Throwable -> L6
                this.mRemote.transact(3, _data, null, 1);     // Catch: Throwable -> L6
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.os.IDumpstateListener
            public void onScreenshotTaken(boolean success) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IDumpstateListener.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeBoolean(success);     // Catch: Throwable -> L6
                this.mRemote.transact(4, _data, null, 1);     // Catch: Throwable -> L6
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.os.IDumpstateListener
            public void onUiIntensiveBugreportDumpsFinished() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IDumpstateListener.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(5, _data, null, 1);     // Catch: Throwable -> L6
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _data.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, IDumpstateListener.DESCRIPTOR);
        }

        public static IDumpstateListener asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IDumpstateListener.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IDumpstateListener) == false) goto L12;
            return (IDumpstateListener) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code < 1) goto L8;
            if (code > 16777215) goto L8;
            data.enforceInterface(IDumpstateListener.DESCRIPTOR);
        L8:
            if (code != 1598968902) goto L11;
            reply.writeString(IDumpstateListener.DESCRIPTOR);
            return true;
        L11:
            switch(code) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                default: goto L13;
            };
        L14:
            onUiIntensiveBugreportDumpsFinished();
        L19:
            return true;
        L15:
            boolean _arg0 = data.readBoolean();
            data.enforceNoDataAvail();
            onScreenshotTaken(_arg0);
            goto L19
        L16:
            String _arg1 = data.readString();
            data.enforceNoDataAvail();
            onFinished(_arg1);
            goto L19
        L17:
            int _arg2 = data.readInt();
            data.enforceNoDataAvail();
            onError(_arg2);
            goto L19
        L18:
            int _arg3 = data.readInt();
            data.enforceNoDataAvail();
            onProgress(_arg3);
            goto L19
        L13:
            return super.onTransact(code, data, reply, flags);
        }
    }

    void onError(int r1) throws RemoteException;

    void onFinished(String r1) throws RemoteException;

    void onProgress(int r1) throws RemoteException;

    void onScreenshotTaken(boolean r1) throws RemoteException;

    void onUiIntensiveBugreportDumpsFinished() throws RemoteException;
}
