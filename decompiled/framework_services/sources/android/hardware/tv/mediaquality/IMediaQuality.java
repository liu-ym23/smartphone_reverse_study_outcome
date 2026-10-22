package android.hardware.tv.mediaquality;

import android.os.BadParcelableException;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IMediaQuality extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "ac19fd80413145bec55462874afb34c24a47a12b";
    public static final int VERSION = 1;

    public static class Default implements IMediaQuality {
        public Default() {
        }

        @Override // android.hardware.tv.mediaquality.IMediaQuality
        public void setAmbientBacklightCallback(IMediaQualityCallback callback) throws RemoteException {
        }

        @Override // android.hardware.tv.mediaquality.IMediaQuality
        public void setAmbientBacklightDetector(AmbientBacklightSettings settings) throws RemoteException {
        }

        @Override // android.hardware.tv.mediaquality.IMediaQuality
        public void setAmbientBacklightDetectionEnabled(boolean enabled) throws RemoteException {
        }

        @Override // android.hardware.tv.mediaquality.IMediaQuality
        public boolean getAmbientBacklightDetectionEnabled() throws RemoteException {
            return false;
        }

        @Override // android.hardware.tv.mediaquality.IMediaQuality
        public boolean isAutoPqSupported() throws RemoteException {
            return false;
        }

        @Override // android.hardware.tv.mediaquality.IMediaQuality
        public boolean getAutoPqEnabled() throws RemoteException {
            return false;
        }

        @Override // android.hardware.tv.mediaquality.IMediaQuality
        public void setAutoPqEnabled(boolean enable) throws RemoteException {
        }

        @Override // android.hardware.tv.mediaquality.IMediaQuality
        public boolean isAutoSrSupported() throws RemoteException {
            return false;
        }

        @Override // android.hardware.tv.mediaquality.IMediaQuality
        public boolean getAutoSrEnabled() throws RemoteException {
            return false;
        }

        @Override // android.hardware.tv.mediaquality.IMediaQuality
        public void setAutoSrEnabled(boolean enable) throws RemoteException {
        }

        @Override // android.hardware.tv.mediaquality.IMediaQuality
        public boolean isAutoAqSupported() throws RemoteException {
            return false;
        }

        @Override // android.hardware.tv.mediaquality.IMediaQuality
        public boolean getAutoAqEnabled() throws RemoteException {
            return false;
        }

        @Override // android.hardware.tv.mediaquality.IMediaQuality
        public void setAutoAqEnabled(boolean enable) throws RemoteException {
        }

        @Override // android.hardware.tv.mediaquality.IMediaQuality
        public IPictureProfileChangedListener getPictureProfileListener() throws RemoteException {
            return null;
        }

        @Override // android.hardware.tv.mediaquality.IMediaQuality
        public void setPictureProfileAdjustmentListener(IPictureProfileAdjustmentListener listener) throws RemoteException {
        }

        @Override // android.hardware.tv.mediaquality.IMediaQuality
        public void sendDefaultPictureParameters(PictureParameters pictureParameters) throws RemoteException {
        }

        @Override // android.hardware.tv.mediaquality.IMediaQuality
        public ISoundProfileChangedListener getSoundProfileListener() throws RemoteException {
            return null;
        }

        @Override // android.hardware.tv.mediaquality.IMediaQuality
        public void setSoundProfileAdjustmentListener(ISoundProfileAdjustmentListener listener) throws RemoteException {
        }

        @Override // android.hardware.tv.mediaquality.IMediaQuality
        public void sendDefaultSoundParameters(SoundParameters soundParameters) throws RemoteException {
        }

        @Override // android.hardware.tv.mediaquality.IMediaQuality
        public void getParamCaps(byte[] paramNames, ParamCapability[] caps) throws RemoteException {
        }

        @Override // android.hardware.tv.mediaquality.IMediaQuality
        public void getVendorParamCaps(VendorParameterIdentifier[] names, VendorParamCapability[] caps) throws RemoteException {
        }

        @Override // android.hardware.tv.mediaquality.IMediaQuality
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // android.hardware.tv.mediaquality.IMediaQuality
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IMediaQuality {
        static final int TRANSACTION_getAmbientBacklightDetectionEnabled = 4;
        static final int TRANSACTION_getAutoAqEnabled = 12;
        static final int TRANSACTION_getAutoPqEnabled = 6;
        static final int TRANSACTION_getAutoSrEnabled = 9;
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_getParamCaps = 20;
        static final int TRANSACTION_getPictureProfileListener = 14;
        static final int TRANSACTION_getSoundProfileListener = 17;
        static final int TRANSACTION_getVendorParamCaps = 21;
        static final int TRANSACTION_isAutoAqSupported = 11;
        static final int TRANSACTION_isAutoPqSupported = 5;
        static final int TRANSACTION_isAutoSrSupported = 8;
        static final int TRANSACTION_sendDefaultPictureParameters = 16;
        static final int TRANSACTION_sendDefaultSoundParameters = 19;
        static final int TRANSACTION_setAmbientBacklightCallback = 1;
        static final int TRANSACTION_setAmbientBacklightDetectionEnabled = 3;
        static final int TRANSACTION_setAmbientBacklightDetector = 2;
        static final int TRANSACTION_setAutoAqEnabled = 13;
        static final int TRANSACTION_setAutoPqEnabled = 7;
        static final int TRANSACTION_setAutoSrEnabled = 10;
        static final int TRANSACTION_setPictureProfileAdjustmentListener = 15;
        static final int TRANSACTION_setSoundProfileAdjustmentListener = 18;

        private static class Proxy implements IMediaQuality {
            private String mCachedHash;
            private int mCachedVersion;
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mCachedVersion = -1;
                this.mCachedHash = "-1";
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IMediaQuality.DESCRIPTOR;
            }

            @Override // android.hardware.tv.mediaquality.IMediaQuality
            public void setAmbientBacklightCallback(IMediaQualityCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IMediaQuality.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeStrongInterface(callback);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(1, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method setAmbientBacklightCallback is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.mediaquality.IMediaQuality
            public void setAmbientBacklightDetector(AmbientBacklightSettings settings) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IMediaQuality.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeTypedObject(settings, 0);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(2, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method setAmbientBacklightDetector is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.mediaquality.IMediaQuality
            public void setAmbientBacklightDetectionEnabled(boolean enabled) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IMediaQuality.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeBoolean(enabled);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(3, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method setAmbientBacklightDetectionEnabled is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.mediaquality.IMediaQuality
            public boolean getAmbientBacklightDetectionEnabled() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IMediaQuality.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(4, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getAmbientBacklightDetectionEnabled is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.mediaquality.IMediaQuality
            public boolean isAutoPqSupported() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IMediaQuality.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(5, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method isAutoPqSupported is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.mediaquality.IMediaQuality
            public boolean getAutoPqEnabled() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IMediaQuality.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(6, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getAutoPqEnabled is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.mediaquality.IMediaQuality
            public void setAutoPqEnabled(boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IMediaQuality.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeBoolean(enable);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(7, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method setAutoPqEnabled is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.mediaquality.IMediaQuality
            public boolean isAutoSrSupported() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IMediaQuality.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(8, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method isAutoSrSupported is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.mediaquality.IMediaQuality
            public boolean getAutoSrEnabled() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IMediaQuality.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(9, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getAutoSrEnabled is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.mediaquality.IMediaQuality
            public void setAutoSrEnabled(boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IMediaQuality.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeBoolean(enable);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(10, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method setAutoSrEnabled is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.mediaquality.IMediaQuality
            public boolean isAutoAqSupported() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IMediaQuality.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(11, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method isAutoAqSupported is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.mediaquality.IMediaQuality
            public boolean getAutoAqEnabled() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IMediaQuality.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(12, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getAutoAqEnabled is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.mediaquality.IMediaQuality
            public void setAutoAqEnabled(boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IMediaQuality.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeBoolean(enable);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(13, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method setAutoAqEnabled is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.mediaquality.IMediaQuality
            public IPictureProfileChangedListener getPictureProfileListener() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IMediaQuality.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(14, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                IPictureProfileChangedListener _result = IPictureProfileChangedListener.Stub.asInterface(_reply.readStrongBinder());     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getPictureProfileListener is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.mediaquality.IMediaQuality
            public void setPictureProfileAdjustmentListener(IPictureProfileAdjustmentListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IMediaQuality.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeStrongInterface(listener);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(15, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method setPictureProfileAdjustmentListener is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.mediaquality.IMediaQuality
            public void sendDefaultPictureParameters(PictureParameters pictureParameters) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IMediaQuality.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeTypedObject(pictureParameters, 0);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(16, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method sendDefaultPictureParameters is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.mediaquality.IMediaQuality
            public ISoundProfileChangedListener getSoundProfileListener() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IMediaQuality.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(17, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                ISoundProfileChangedListener _result = ISoundProfileChangedListener.Stub.asInterface(_reply.readStrongBinder());     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getSoundProfileListener is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.mediaquality.IMediaQuality
            public void setSoundProfileAdjustmentListener(ISoundProfileAdjustmentListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IMediaQuality.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeStrongInterface(listener);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(18, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method setSoundProfileAdjustmentListener is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.mediaquality.IMediaQuality
            public void sendDefaultSoundParameters(SoundParameters soundParameters) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IMediaQuality.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeTypedObject(soundParameters, 0);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(19, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method sendDefaultSoundParameters is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.mediaquality.IMediaQuality
            public void getParamCaps(byte[] paramNames, ParamCapability[] caps) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IMediaQuality.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeByteArray(paramNames);     // Catch: Throwable -> L8
                _data.writeInt(caps.length);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(20, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.readTypedArray(caps, ParamCapability.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method getParamCaps is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.mediaquality.IMediaQuality
            public void getVendorParamCaps(VendorParameterIdentifier[] names, VendorParamCapability[] caps) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IMediaQuality.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeTypedArray(names, 0);     // Catch: Throwable -> L8
                _data.writeInt(caps.length);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(21, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.readTypedArray(caps, VendorParamCapability.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method getVendorParamCaps is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.mediaquality.IMediaQuality
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain(asBinder());
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(IMediaQuality.DESCRIPTOR);     // Catch: Throwable -> L7
                this.mRemote.transact(16777215, data, reply, 0);     // Catch: Throwable -> L7
                reply.readException();     // Catch: Throwable -> L7
                this.mCachedVersion = reply.readInt();     // Catch: Throwable -> L7
                reply.recycle();
                data.recycle();
            L7:
                th = move-exception;
                reply.recycle();
                data.recycle();
                throw th;
            L11:
                return this.mCachedVersion;
            }

            @Override // android.hardware.tv.mediaquality.IMediaQuality
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain(asBinder());     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(IMediaQuality.DESCRIPTOR);     // Catch: Throwable -> L10
                this.mRemote.transact(Stub.TRANSACTION_getInterfaceHash, data, reply, 0);     // Catch: Throwable -> L10
                reply.readException();     // Catch: Throwable -> L10
                this.mCachedHash = reply.readString();     // Catch: Throwable -> L10
                reply.recycle();     // Catch: Throwable -> L8
                data.recycle();     // Catch: Throwable -> L8
                goto L13
            L10:
                th = move-exception;
                reply.recycle();     // Catch: Throwable -> L8
                data.recycle();     // Catch: Throwable -> L8
                throw th;     // Catch: Throwable -> L8
            L13:
                String r0 = this.mCachedHash;     // Catch: Throwable -> L8
                monitor-exit(this);
                return r0;
            }
        }

        public Stub() {
            markVintfStability();
            attachInterface(this, IMediaQuality.DESCRIPTOR);
        }

        public static IMediaQuality asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IMediaQuality.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IMediaQuality) == false) goto L12;
            return (IMediaQuality) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch(transactionCode) {
                case 1: goto L49;
                case 2: goto L47;
                case 3: goto L45;
                case 4: goto L43;
                case 5: goto L41;
                case 6: goto L39;
                case 7: goto L37;
                case 8: goto L35;
                case 9: goto L33;
                case 10: goto L31;
                case 11: goto L29;
                case 12: goto L27;
                case 13: goto L25;
                case 14: goto L23;
                case 15: goto L21;
                case 16: goto L19;
                case 17: goto L17;
                case 18: goto L15;
                case 19: goto L13;
                case 20: goto L11;
                case 21: goto L9;
                case 16777214: goto L7;
                case 16777215: goto L5;
                default: goto L3;
            };
        L3:
            return null;
        L5:
            return "getInterfaceVersion";
        L7:
            return "getInterfaceHash";
        L9:
            return "getVendorParamCaps";
        L11:
            return "getParamCaps";
        L13:
            return "sendDefaultSoundParameters";
        L15:
            return "setSoundProfileAdjustmentListener";
        L17:
            return "getSoundProfileListener";
        L19:
            return "sendDefaultPictureParameters";
        L21:
            return "setPictureProfileAdjustmentListener";
        L23:
            return "getPictureProfileListener";
        L25:
            return "setAutoAqEnabled";
        L27:
            return "getAutoAqEnabled";
        L29:
            return "isAutoAqSupported";
        L31:
            return "setAutoSrEnabled";
        L33:
            return "getAutoSrEnabled";
        L35:
            return "isAutoSrSupported";
        L37:
            return "setAutoPqEnabled";
        L39:
            return "getAutoPqEnabled";
        L41:
            return "isAutoPqSupported";
        L43:
            return "getAmbientBacklightDetectionEnabled";
        L45:
            return "setAmbientBacklightDetectionEnabled";
        L47:
            return "setAmbientBacklightDetector";
        L49:
            return "setAmbientBacklightCallback";
        }

        public String getTransactionName(int transactionCode) {
            return getDefaultTransactionName(transactionCode);
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = IMediaQuality.DESCRIPTOR;
            if (code < 1) goto L7;
            if (code > 16777215) goto L7;
            data.enforceInterface(descriptor);
        L7:
            if (code != 1598968902) goto L10;
            reply.writeString(descriptor);
            return true;
        L10:
            if (code != 16777215) goto L14;
            reply.writeNoException();
            reply.writeInt(getInterfaceVersion());
            return true;
        L14:
            if (code != TRANSACTION_getInterfaceHash) goto L18;
            reply.writeNoException();
            reply.writeString(getInterfaceHash());
            return true;
        L18:
            switch(code) {
                case 1: goto L55;
                case 2: goto L54;
                case 3: goto L53;
                case 4: goto L52;
                case 5: goto L51;
                case 6: goto L50;
                case 7: goto L49;
                case 8: goto L48;
                case 9: goto L47;
                case 10: goto L46;
                case 11: goto L45;
                case 12: goto L44;
                case 13: goto L43;
                case 14: goto L42;
                case 15: goto L41;
                case 16: goto L40;
                case 17: goto L39;
                case 18: goto L38;
                case 19: goto L37;
                case 20: goto L29;
                case 21: goto L21;
                default: goto L20;
            };
        L21:
            VendorParameterIdentifier[] _arg0 = (VendorParameterIdentifier[]) data.createTypedArray(VendorParameterIdentifier.CREATOR);
            int _arg1_length = data.readInt();
            if (_arg1_length > 1000000) goto L28;
            if (_arg1_length >= 0) goto L25;
            VendorParamCapability[] _arg1 = null;
        L26:
            data.enforceNoDataAvail();
            getVendorParamCaps(_arg0, _arg1);
            reply.writeNoException();
            reply.writeTypedArray(_arg1, 1);
        L56:
            return true;
        L25:
            _arg1 = new VendorParamCapability[_arg1_length];
            goto L26
        L28:
            throw new BadParcelableException("Array too large: " + _arg1_length);
        L29:
            byte[] _arg2 = data.createByteArray();
            int _arg1_length2 = data.readInt();
            if (_arg1_length2 > 1000000) goto L36;
            if (_arg1_length2 >= 0) goto L33;
            ParamCapability[] _arg3 = null;
        L34:
            data.enforceNoDataAvail();
            getParamCaps(_arg2, _arg3);
            reply.writeNoException();
            reply.writeTypedArray(_arg3, 1);
            goto L56
        L33:
            _arg3 = new ParamCapability[_arg1_length2];
            goto L34
        L36:
            throw new BadParcelableException("Array too large: " + _arg1_length2);
        L37:
            SoundParameters _arg4 = (SoundParameters) data.readTypedObject(SoundParameters.CREATOR);
            data.enforceNoDataAvail();
            sendDefaultSoundParameters(_arg4);
            reply.writeNoException();
            goto L56
        L38:
            ISoundProfileAdjustmentListener _arg5 = ISoundProfileAdjustmentListener.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            setSoundProfileAdjustmentListener(_arg5);
            reply.writeNoException();
            goto L56
        L39:
            ISoundProfileChangedListener _result = getSoundProfileListener();
            reply.writeNoException();
            reply.writeStrongInterface(_result);
            goto L56
        L40:
            PictureParameters _arg6 = (PictureParameters) data.readTypedObject(PictureParameters.CREATOR);
            data.enforceNoDataAvail();
            sendDefaultPictureParameters(_arg6);
            reply.writeNoException();
            goto L56
        L41:
            IPictureProfileAdjustmentListener _arg7 = IPictureProfileAdjustmentListener.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            setPictureProfileAdjustmentListener(_arg7);
            reply.writeNoException();
            goto L56
        L42:
            IPictureProfileChangedListener _result2 = getPictureProfileListener();
            reply.writeNoException();
            reply.writeStrongInterface(_result2);
            goto L56
        L43:
            boolean _arg8 = data.readBoolean();
            data.enforceNoDataAvail();
            setAutoAqEnabled(_arg8);
            reply.writeNoException();
            goto L56
        L44:
            boolean _result3 = getAutoAqEnabled();
            reply.writeNoException();
            reply.writeBoolean(_result3);
            goto L56
        L45:
            boolean _result4 = isAutoAqSupported();
            reply.writeNoException();
            reply.writeBoolean(_result4);
            goto L56
        L46:
            boolean _arg9 = data.readBoolean();
            data.enforceNoDataAvail();
            setAutoSrEnabled(_arg9);
            reply.writeNoException();
            goto L56
        L47:
            boolean _result5 = getAutoSrEnabled();
            reply.writeNoException();
            reply.writeBoolean(_result5);
            goto L56
        L48:
            boolean _result6 = isAutoSrSupported();
            reply.writeNoException();
            reply.writeBoolean(_result6);
            goto L56
        L49:
            boolean _arg10 = data.readBoolean();
            data.enforceNoDataAvail();
            setAutoPqEnabled(_arg10);
            reply.writeNoException();
            goto L56
        L50:
            boolean _result7 = getAutoPqEnabled();
            reply.writeNoException();
            reply.writeBoolean(_result7);
            goto L56
        L51:
            boolean _result8 = isAutoPqSupported();
            reply.writeNoException();
            reply.writeBoolean(_result8);
            goto L56
        L52:
            boolean _result9 = getAmbientBacklightDetectionEnabled();
            reply.writeNoException();
            reply.writeBoolean(_result9);
            goto L56
        L53:
            boolean _arg11 = data.readBoolean();
            data.enforceNoDataAvail();
            setAmbientBacklightDetectionEnabled(_arg11);
            reply.writeNoException();
            goto L56
        L54:
            AmbientBacklightSettings _arg12 = (AmbientBacklightSettings) data.readTypedObject(AmbientBacklightSettings.CREATOR);
            data.enforceNoDataAvail();
            setAmbientBacklightDetector(_arg12);
            reply.writeNoException();
            goto L56
        L55:
            IMediaQualityCallback _arg13 = IMediaQualityCallback.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            setAmbientBacklightCallback(_arg13);
            reply.writeNoException();
            goto L56
        L20:
            return super.onTransact(code, data, reply, flags);
        }

        public int getMaxTransactionId() {
            return TRANSACTION_getInterfaceHash;
        }
    }

    boolean getAmbientBacklightDetectionEnabled() throws RemoteException;

    boolean getAutoAqEnabled() throws RemoteException;

    boolean getAutoPqEnabled() throws RemoteException;

    boolean getAutoSrEnabled() throws RemoteException;

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    void getParamCaps(byte[] r1, ParamCapability[] r2) throws RemoteException;

    IPictureProfileChangedListener getPictureProfileListener() throws RemoteException;

    ISoundProfileChangedListener getSoundProfileListener() throws RemoteException;

    void getVendorParamCaps(VendorParameterIdentifier[] r1, VendorParamCapability[] r2) throws RemoteException;

    boolean isAutoAqSupported() throws RemoteException;

    boolean isAutoPqSupported() throws RemoteException;

    boolean isAutoSrSupported() throws RemoteException;

    void sendDefaultPictureParameters(PictureParameters r1) throws RemoteException;

    void sendDefaultSoundParameters(SoundParameters r1) throws RemoteException;

    void setAmbientBacklightCallback(IMediaQualityCallback r1) throws RemoteException;

    void setAmbientBacklightDetectionEnabled(boolean r1) throws RemoteException;

    void setAmbientBacklightDetector(AmbientBacklightSettings r1) throws RemoteException;

    void setAutoAqEnabled(boolean r1) throws RemoteException;

    void setAutoPqEnabled(boolean r1) throws RemoteException;

    void setAutoSrEnabled(boolean r1) throws RemoteException;

    void setPictureProfileAdjustmentListener(IPictureProfileAdjustmentListener r1) throws RemoteException;

    void setSoundProfileAdjustmentListener(ISoundProfileAdjustmentListener r1) throws RemoteException;

    static {
        DESCRIPTOR = "android$hardware$tv$mediaquality$IMediaQuality".replace('$', '.');
    }
}
