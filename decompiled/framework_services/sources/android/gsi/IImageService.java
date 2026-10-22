package android.gsi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface IImageService extends IInterface {
    public static final int CREATE_IMAGE_DEFAULT = 0;
    public static final int CREATE_IMAGE_READONLY = 1;
    public static final int CREATE_IMAGE_ZERO_FILL = 2;
    public static final String DESCRIPTOR = "android.gsi.IImageService";
    public static final int IMAGE_ERROR = 1;
    public static final int IMAGE_OK = 0;

    public static class Default implements IImageService {
        public Default() {
        }

        @Override // android.gsi.IImageService
        public void createBackingImage(String name, long size, int flags, IProgressCallback on_progress) throws RemoteException {
        }

        @Override // android.gsi.IImageService
        public void deleteBackingImage(String name) throws RemoteException {
        }

        @Override // android.gsi.IImageService
        public void mapImageDevice(String name, int timeout_ms, MappedImage mapping) throws RemoteException {
        }

        @Override // android.gsi.IImageService
        public void unmapImageDevice(String name) throws RemoteException {
        }

        @Override // android.gsi.IImageService
        public boolean backingImageExists(String name) throws RemoteException {
            return false;
        }

        @Override // android.gsi.IImageService
        public boolean isImageMapped(String name) throws RemoteException {
            return false;
        }

        @Override // android.gsi.IImageService
        public int getAvbPublicKey(String name, AvbPublicKey dst) throws RemoteException {
            return 0;
        }

        @Override // android.gsi.IImageService
        public List<String> getAllBackingImages() throws RemoteException {
            return null;
        }

        @Override // android.gsi.IImageService
        public void zeroFillNewImage(String name, long bytes) throws RemoteException {
        }

        @Override // android.gsi.IImageService
        public void removeAllImages() throws RemoteException {
        }

        @Override // android.gsi.IImageService
        public void disableImage(String name) throws RemoteException {
        }

        @Override // android.gsi.IImageService
        public void removeDisabledImages() throws RemoteException {
        }

        @Override // android.gsi.IImageService
        public boolean isImageDisabled(String name) throws RemoteException {
            return false;
        }

        @Override // android.gsi.IImageService
        public String getMappedImageDevice(String name) throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IImageService {
        static final int TRANSACTION_backingImageExists = 5;
        static final int TRANSACTION_createBackingImage = 1;
        static final int TRANSACTION_deleteBackingImage = 2;
        static final int TRANSACTION_disableImage = 11;
        static final int TRANSACTION_getAllBackingImages = 8;
        static final int TRANSACTION_getAvbPublicKey = 7;
        static final int TRANSACTION_getMappedImageDevice = 14;
        static final int TRANSACTION_isImageDisabled = 13;
        static final int TRANSACTION_isImageMapped = 6;
        static final int TRANSACTION_mapImageDevice = 3;
        static final int TRANSACTION_removeAllImages = 10;
        static final int TRANSACTION_removeDisabledImages = 12;
        static final int TRANSACTION_unmapImageDevice = 4;
        static final int TRANSACTION_zeroFillNewImage = 9;

        private static class Proxy implements IImageService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IImageService.DESCRIPTOR;
            }

            @Override // android.gsi.IImageService
            public void createBackingImage(String name, long size, int flags, IProgressCallback on_progress) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IImageService.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(name);     // Catch: Throwable -> L6
                _data.writeLong(size);     // Catch: Throwable -> L6
                _data.writeInt(flags);     // Catch: Throwable -> L6
                _data.writeStrongInterface(on_progress);     // Catch: Throwable -> L6
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

            @Override // android.gsi.IImageService
            public void deleteBackingImage(String name) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IImageService.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(name);     // Catch: Throwable -> L6
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

            @Override // android.gsi.IImageService
            public void mapImageDevice(String name, int timeout_ms, MappedImage mapping) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IImageService.DESCRIPTOR);     // Catch: Throwable -> L7
                _data.writeString(name);     // Catch: Throwable -> L7
                _data.writeInt(timeout_ms);     // Catch: Throwable -> L7
                this.mRemote.transact(3, _data, _reply, 0);     // Catch: Throwable -> L7
                _reply.readException();     // Catch: Throwable -> L7
                if (_reply.readInt() == 0) goto L9;
                mapping.readFromParcel(_reply);     // Catch: Throwable -> L7
            L9:
                _reply.recycle();
                _data.recycle();
                return;
            L7:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.gsi.IImageService
            public void unmapImageDevice(String name) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IImageService.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(name);     // Catch: Throwable -> L6
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

            @Override // android.gsi.IImageService
            public boolean backingImageExists(String name) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IImageService.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(name);     // Catch: Throwable -> L6
                this.mRemote.transact(5, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.gsi.IImageService
            public boolean isImageMapped(String name) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IImageService.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(name);     // Catch: Throwable -> L6
                this.mRemote.transact(6, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.gsi.IImageService
            public int getAvbPublicKey(String name, AvbPublicKey dst) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IImageService.DESCRIPTOR);     // Catch: Throwable -> L7
                _data.writeString(name);     // Catch: Throwable -> L7
                this.mRemote.transact(7, _data, _reply, 0);     // Catch: Throwable -> L7
                _reply.readException();     // Catch: Throwable -> L7
                int _result = _reply.readInt();     // Catch: Throwable -> L7
                if (_reply.readInt() == 0) goto L9;
                dst.readFromParcel(_reply);     // Catch: Throwable -> L7
            L9:
                _reply.recycle();
                _data.recycle();
                return _result;
            L7:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.gsi.IImageService
            public List<String> getAllBackingImages() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IImageService.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(8, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                List<String> _result = _reply.createStringArrayList();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.gsi.IImageService
            public void zeroFillNewImage(String name, long bytes) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IImageService.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(name);     // Catch: Throwable -> L6
                _data.writeLong(bytes);     // Catch: Throwable -> L6
                this.mRemote.transact(9, _data, _reply, 0);     // Catch: Throwable -> L6
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

            @Override // android.gsi.IImageService
            public void removeAllImages() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IImageService.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(10, _data, _reply, 0);     // Catch: Throwable -> L6
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

            @Override // android.gsi.IImageService
            public void disableImage(String name) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IImageService.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(name);     // Catch: Throwable -> L6
                this.mRemote.transact(11, _data, _reply, 0);     // Catch: Throwable -> L6
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

            @Override // android.gsi.IImageService
            public void removeDisabledImages() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IImageService.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(12, _data, _reply, 0);     // Catch: Throwable -> L6
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

            @Override // android.gsi.IImageService
            public boolean isImageDisabled(String name) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IImageService.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(name);     // Catch: Throwable -> L6
                this.mRemote.transact(13, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.gsi.IImageService
            public String getMappedImageDevice(String name) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IImageService.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(name);     // Catch: Throwable -> L6
                this.mRemote.transact(14, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                String _result = _reply.readString();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, IImageService.DESCRIPTOR);
        }

        public static IImageService asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IImageService.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IImageService) == false) goto L12;
            return (IImageService) iin;
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
            data.enforceInterface(IImageService.DESCRIPTOR);
        L8:
            if (code != 1598968902) goto L11;
            reply.writeString(IImageService.DESCRIPTOR);
            return true;
        L11:
            switch(code) {
                case 1: goto L27;
                case 2: goto L26;
                case 3: goto L25;
                case 4: goto L24;
                case 5: goto L23;
                case 6: goto L22;
                case 7: goto L21;
                case 8: goto L20;
                case 9: goto L19;
                case 10: goto L18;
                case 11: goto L17;
                case 12: goto L16;
                case 13: goto L15;
                case 14: goto L14;
                default: goto L13;
            };
        L14:
            String _arg0 = data.readString();
            data.enforceNoDataAvail();
            String _result = getMappedImageDevice(_arg0);
            reply.writeNoException();
            reply.writeString(_result);
        L28:
            return true;
        L15:
            String _arg1 = data.readString();
            data.enforceNoDataAvail();
            boolean _result2 = isImageDisabled(_arg1);
            reply.writeNoException();
            reply.writeBoolean(_result2);
            goto L28
        L16:
            removeDisabledImages();
            reply.writeNoException();
            goto L28
        L17:
            String _arg2 = data.readString();
            data.enforceNoDataAvail();
            disableImage(_arg2);
            reply.writeNoException();
            goto L28
        L18:
            removeAllImages();
            reply.writeNoException();
            goto L28
        L19:
            String _arg3 = data.readString();
            long _arg4 = data.readLong();
            data.enforceNoDataAvail();
            zeroFillNewImage(_arg3, _arg4);
            reply.writeNoException();
            goto L28
        L20:
            List<String> _result3 = getAllBackingImages();
            reply.writeNoException();
            reply.writeStringList(_result3);
            goto L28
        L21:
            String _arg5 = data.readString();
            AvbPublicKey _arg6 = new AvbPublicKey();
            data.enforceNoDataAvail();
            int _result4 = getAvbPublicKey(_arg5, _arg6);
            reply.writeNoException();
            reply.writeInt(_result4);
            reply.writeTypedObject(_arg6, 1);
            goto L28
        L22:
            String _arg7 = data.readString();
            data.enforceNoDataAvail();
            boolean _result5 = isImageMapped(_arg7);
            reply.writeNoException();
            reply.writeBoolean(_result5);
            goto L28
        L23:
            String _arg8 = data.readString();
            data.enforceNoDataAvail();
            boolean _result6 = backingImageExists(_arg8);
            reply.writeNoException();
            reply.writeBoolean(_result6);
            goto L28
        L24:
            String _arg9 = data.readString();
            data.enforceNoDataAvail();
            unmapImageDevice(_arg9);
            reply.writeNoException();
            goto L28
        L25:
            String _arg10 = data.readString();
            int _arg11 = data.readInt();
            MappedImage _arg12 = new MappedImage();
            data.enforceNoDataAvail();
            mapImageDevice(_arg10, _arg11, _arg12);
            reply.writeNoException();
            reply.writeTypedObject(_arg12, 1);
            goto L28
        L26:
            String _arg13 = data.readString();
            data.enforceNoDataAvail();
            deleteBackingImage(_arg13);
            reply.writeNoException();
            goto L28
        L27:
            String _arg14 = data.readString();
            long _arg15 = data.readLong();
            int _arg16 = data.readInt();
            IProgressCallback _arg17 = IProgressCallback.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            createBackingImage(_arg14, _arg15, _arg16, _arg17);
            reply.writeNoException();
            goto L28
        L13:
            return super.onTransact(code, data, reply, flags);
        }
    }

    boolean backingImageExists(String r1) throws RemoteException;

    void createBackingImage(String r1, long r2, int r4, IProgressCallback r5) throws RemoteException;

    void deleteBackingImage(String r1) throws RemoteException;

    void disableImage(String r1) throws RemoteException;

    List<String> getAllBackingImages() throws RemoteException;

    int getAvbPublicKey(String r1, AvbPublicKey r2) throws RemoteException;

    String getMappedImageDevice(String r1) throws RemoteException;

    boolean isImageDisabled(String r1) throws RemoteException;

    boolean isImageMapped(String r1) throws RemoteException;

    void mapImageDevice(String r1, int r2, MappedImage r3) throws RemoteException;

    void removeAllImages() throws RemoteException;

    void removeDisabledImages() throws RemoteException;

    void unmapImageDevice(String r1) throws RemoteException;

    void zeroFillNewImage(String r1, long r2) throws RemoteException;
}
