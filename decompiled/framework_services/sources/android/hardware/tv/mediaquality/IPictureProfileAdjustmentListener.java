package android.hardware.tv.mediaquality;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IPictureProfileAdjustmentListener extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "ac19fd80413145bec55462874afb34c24a47a12b";
    public static final int VERSION = 1;

    public static class Default implements IPictureProfileAdjustmentListener {
        public Default() {
        }

        @Override // android.hardware.tv.mediaquality.IPictureProfileAdjustmentListener
        public void onPictureProfileAdjusted(PictureProfile pictureProfile) throws RemoteException {
        }

        @Override // android.hardware.tv.mediaquality.IPictureProfileAdjustmentListener
        public void onParamCapabilityChanged(long pictureProfileId, ParamCapability[] caps) throws RemoteException {
        }

        @Override // android.hardware.tv.mediaquality.IPictureProfileAdjustmentListener
        public void onVendorParamCapabilityChanged(long pictureProfileId, VendorParamCapability[] caps) throws RemoteException {
        }

        @Override // android.hardware.tv.mediaquality.IPictureProfileAdjustmentListener
        public void requestPictureParameters(long pictureProfileId) throws RemoteException {
        }

        @Override // android.hardware.tv.mediaquality.IPictureProfileAdjustmentListener
        public void onStreamStatusChanged(long pictureProfileId, byte status) throws RemoteException {
        }

        @Override // android.hardware.tv.mediaquality.IPictureProfileAdjustmentListener
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // android.hardware.tv.mediaquality.IPictureProfileAdjustmentListener
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IPictureProfileAdjustmentListener {
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_onParamCapabilityChanged = 2;
        static final int TRANSACTION_onPictureProfileAdjusted = 1;
        static final int TRANSACTION_onStreamStatusChanged = 5;
        static final int TRANSACTION_onVendorParamCapabilityChanged = 3;
        static final int TRANSACTION_requestPictureParameters = 4;

        private static class Proxy implements IPictureProfileAdjustmentListener {
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
                return IPictureProfileAdjustmentListener.DESCRIPTOR;
            }

            @Override // android.hardware.tv.mediaquality.IPictureProfileAdjustmentListener
            public void onPictureProfileAdjusted(PictureProfile pictureProfile) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IPictureProfileAdjustmentListener.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeTypedObject(pictureProfile, 0);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(1, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onPictureProfileAdjusted is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.mediaquality.IPictureProfileAdjustmentListener
            public void onParamCapabilityChanged(long pictureProfileId, ParamCapability[] caps) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IPictureProfileAdjustmentListener.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeLong(pictureProfileId);     // Catch: Throwable -> L9
                _data.writeTypedArray(caps, 0);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(2, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onParamCapabilityChanged is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.mediaquality.IPictureProfileAdjustmentListener
            public void onVendorParamCapabilityChanged(long pictureProfileId, VendorParamCapability[] caps) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IPictureProfileAdjustmentListener.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeLong(pictureProfileId);     // Catch: Throwable -> L9
                _data.writeTypedArray(caps, 0);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(3, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onVendorParamCapabilityChanged is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.mediaquality.IPictureProfileAdjustmentListener
            public void requestPictureParameters(long pictureProfileId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IPictureProfileAdjustmentListener.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeLong(pictureProfileId);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(4, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method requestPictureParameters is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.mediaquality.IPictureProfileAdjustmentListener
            public void onStreamStatusChanged(long pictureProfileId, byte status) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IPictureProfileAdjustmentListener.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeLong(pictureProfileId);     // Catch: Throwable -> L9
                _data.writeByte(status);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(5, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onStreamStatusChanged is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.mediaquality.IPictureProfileAdjustmentListener
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain(asBinder());
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(IPictureProfileAdjustmentListener.DESCRIPTOR);     // Catch: Throwable -> L7
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

            @Override // android.hardware.tv.mediaquality.IPictureProfileAdjustmentListener
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain(asBinder());     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(IPictureProfileAdjustmentListener.DESCRIPTOR);     // Catch: Throwable -> L10
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
            attachInterface(this, IPictureProfileAdjustmentListener.DESCRIPTOR);
        }

        public static IPictureProfileAdjustmentListener asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IPictureProfileAdjustmentListener.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IPictureProfileAdjustmentListener) == false) goto L12;
            return (IPictureProfileAdjustmentListener) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch(transactionCode) {
                case 1: goto L17;
                case 2: goto L15;
                case 3: goto L13;
                case 4: goto L11;
                case 5: goto L9;
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
            return "onStreamStatusChanged";
        L11:
            return "requestPictureParameters";
        L13:
            return "onVendorParamCapabilityChanged";
        L15:
            return "onParamCapabilityChanged";
        L17:
            return "onPictureProfileAdjusted";
        }

        public String getTransactionName(int transactionCode) {
            return getDefaultTransactionName(transactionCode);
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = IPictureProfileAdjustmentListener.DESCRIPTOR;
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
            if (code != TRANSACTION_getInterfaceHash) goto L17;
            reply.writeNoException();
            reply.writeString(getInterfaceHash());
            return true;
        L17:
            switch(code) {
                case 1: goto L24;
                case 2: goto L23;
                case 3: goto L22;
                case 4: goto L21;
                case 5: goto L20;
                default: goto L19;
            };
        L20:
            long _arg0 = data.readLong();
            byte _arg1 = data.readByte();
            data.enforceNoDataAvail();
            onStreamStatusChanged(_arg0, _arg1);
        L25:
            return true;
        L21:
            long _arg2 = data.readLong();
            data.enforceNoDataAvail();
            requestPictureParameters(_arg2);
            goto L25
        L22:
            long _arg3 = data.readLong();
            VendorParamCapability[] _arg4 = (VendorParamCapability[]) data.createTypedArray(VendorParamCapability.CREATOR);
            data.enforceNoDataAvail();
            onVendorParamCapabilityChanged(_arg3, _arg4);
            goto L25
        L23:
            long _arg5 = data.readLong();
            ParamCapability[] _arg6 = (ParamCapability[]) data.createTypedArray(ParamCapability.CREATOR);
            data.enforceNoDataAvail();
            onParamCapabilityChanged(_arg5, _arg6);
            goto L25
        L24:
            PictureProfile _arg7 = (PictureProfile) data.readTypedObject(PictureProfile.CREATOR);
            data.enforceNoDataAvail();
            onPictureProfileAdjusted(_arg7);
            goto L25
        L19:
            return super.onTransact(code, data, reply, flags);
        }

        public int getMaxTransactionId() {
            return TRANSACTION_getInterfaceHash;
        }
    }

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    void onParamCapabilityChanged(long r1, ParamCapability[] r3) throws RemoteException;

    void onPictureProfileAdjusted(PictureProfile r1) throws RemoteException;

    void onStreamStatusChanged(long r1, byte r3) throws RemoteException;

    void onVendorParamCapabilityChanged(long r1, VendorParamCapability[] r3) throws RemoteException;

    void requestPictureParameters(long r1) throws RemoteException;

    static {
        DESCRIPTOR = "android$hardware$tv$mediaquality$IPictureProfileAdjustmentListener".replace('$', '.');
    }
}
