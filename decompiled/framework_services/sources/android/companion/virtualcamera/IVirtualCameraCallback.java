package android.companion.virtualcamera;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.Surface;

/* JADX INFO: loaded from: classes.dex */
public interface IVirtualCameraCallback extends IInterface {
    public static final String DESCRIPTOR = "android.companion.virtualcamera.IVirtualCameraCallback";

    public static class Default implements IVirtualCameraCallback {
        public Default() {
        }

        @Override // android.companion.virtualcamera.IVirtualCameraCallback
        public void onStreamConfigured(int streamId, Surface surface, int width, int height, int pixelFormat) throws RemoteException {
        }

        @Override // android.companion.virtualcamera.IVirtualCameraCallback
        public void onProcessCaptureRequest(int streamId, int frameId) throws RemoteException {
        }

        @Override // android.companion.virtualcamera.IVirtualCameraCallback
        public void onStreamClosed(int streamId) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IVirtualCameraCallback {
        static final int TRANSACTION_onProcessCaptureRequest = 2;
        static final int TRANSACTION_onStreamClosed = 3;
        static final int TRANSACTION_onStreamConfigured = 1;

        private static class Proxy implements IVirtualCameraCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IVirtualCameraCallback.DESCRIPTOR;
            }

            @Override // android.companion.virtualcamera.IVirtualCameraCallback
            public void onStreamConfigured(int streamId, Surface surface, int width, int height, int pixelFormat) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IVirtualCameraCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(streamId);     // Catch: Throwable -> L6
                _data.writeTypedObject(surface, 0);     // Catch: Throwable -> L6
                _data.writeInt(width);     // Catch: Throwable -> L6
                _data.writeInt(height);     // Catch: Throwable -> L6
                _data.writeInt(pixelFormat);     // Catch: Throwable -> L6
                this.mRemote.transact(1, _data, null, 1);     // Catch: Throwable -> L6
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.companion.virtualcamera.IVirtualCameraCallback
            public void onProcessCaptureRequest(int streamId, int frameId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IVirtualCameraCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(streamId);     // Catch: Throwable -> L6
                _data.writeInt(frameId);     // Catch: Throwable -> L6
                this.mRemote.transact(2, _data, null, 1);     // Catch: Throwable -> L6
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.companion.virtualcamera.IVirtualCameraCallback
            public void onStreamClosed(int streamId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IVirtualCameraCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(streamId);     // Catch: Throwable -> L6
                this.mRemote.transact(3, _data, null, 1);     // Catch: Throwable -> L6
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _data.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, IVirtualCameraCallback.DESCRIPTOR);
        }

        public static IVirtualCameraCallback asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IVirtualCameraCallback.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IVirtualCameraCallback) == false) goto L12;
            return (IVirtualCameraCallback) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch(transactionCode) {
                case 1: goto L9;
                case 2: goto L7;
                case 3: goto L5;
                default: goto L3;
            };
        L3:
            return null;
        L5:
            return "onStreamClosed";
        L7:
            return "onProcessCaptureRequest";
        L9:
            return "onStreamConfigured";
        }

        public String getTransactionName(int transactionCode) {
            return getDefaultTransactionName(transactionCode);
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code < 1) goto L8;
            if (code > 16777215) goto L8;
            data.enforceInterface(IVirtualCameraCallback.DESCRIPTOR);
        L8:
            if (code != 1598968902) goto L11;
            reply.writeString(IVirtualCameraCallback.DESCRIPTOR);
            return true;
        L11:
            switch(code) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                default: goto L13;
            };
        L14:
            int _arg0 = data.readInt();
            data.enforceNoDataAvail();
            onStreamClosed(_arg0);
        L17:
            return true;
        L15:
            int _arg1 = data.readInt();
            int _arg2 = data.readInt();
            data.enforceNoDataAvail();
            onProcessCaptureRequest(_arg1, _arg2);
            goto L17
        L16:
            int _arg3 = data.readInt();
            Surface _arg4 = (Surface) data.readTypedObject(Surface.CREATOR);
            int _arg5 = data.readInt();
            int _arg6 = data.readInt();
            int _arg7 = data.readInt();
            data.enforceNoDataAvail();
            onStreamConfigured(_arg3, _arg4, _arg5, _arg6, _arg7);
            goto L17
        L13:
            return super.onTransact(code, data, reply, flags);
        }

        public int getMaxTransactionId() {
            return 2;
        }
    }

    void onProcessCaptureRequest(int r1, int r2) throws RemoteException;

    void onStreamClosed(int r1) throws RemoteException;

    void onStreamConfigured(int r1, Surface r2, int r3, int r4, int r5) throws RemoteException;
}
