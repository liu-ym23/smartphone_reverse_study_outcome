package android.hardware.tv.mediaquality;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface ISoundProfileAdjustmentListener extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "ac19fd80413145bec55462874afb34c24a47a12b";
    public static final int VERSION = 1;

    public static class Default implements ISoundProfileAdjustmentListener {
        public Default() {
        }

        @Override // android.hardware.tv.mediaquality.ISoundProfileAdjustmentListener
        public void onSoundProfileAdjusted(SoundProfile soundProfile) throws RemoteException {
        }

        @Override // android.hardware.tv.mediaquality.ISoundProfileAdjustmentListener
        public void onParamCapabilityChanged(long soundProfileId, ParamCapability[] caps) throws RemoteException {
        }

        @Override // android.hardware.tv.mediaquality.ISoundProfileAdjustmentListener
        public void onVendorParamCapabilityChanged(long soundProfileId, VendorParamCapability[] caps) throws RemoteException {
        }

        @Override // android.hardware.tv.mediaquality.ISoundProfileAdjustmentListener
        public void requestSoundParameters(long SoundProfileId) throws RemoteException {
        }

        @Override // android.hardware.tv.mediaquality.ISoundProfileAdjustmentListener
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // android.hardware.tv.mediaquality.ISoundProfileAdjustmentListener
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ISoundProfileAdjustmentListener {
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_onParamCapabilityChanged = 2;
        static final int TRANSACTION_onSoundProfileAdjusted = 1;
        static final int TRANSACTION_onVendorParamCapabilityChanged = 3;
        static final int TRANSACTION_requestSoundParameters = 4;

        private static class Proxy implements ISoundProfileAdjustmentListener {
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
                return ISoundProfileAdjustmentListener.DESCRIPTOR;
            }

            @Override // android.hardware.tv.mediaquality.ISoundProfileAdjustmentListener
            public void onSoundProfileAdjusted(SoundProfile soundProfile) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(ISoundProfileAdjustmentListener.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeTypedObject(soundProfile, 0);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(1, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onSoundProfileAdjusted is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.mediaquality.ISoundProfileAdjustmentListener
            public void onParamCapabilityChanged(long soundProfileId, ParamCapability[] caps) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(ISoundProfileAdjustmentListener.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeLong(soundProfileId);     // Catch: Throwable -> L9
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

            @Override // android.hardware.tv.mediaquality.ISoundProfileAdjustmentListener
            public void onVendorParamCapabilityChanged(long soundProfileId, VendorParamCapability[] caps) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(ISoundProfileAdjustmentListener.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeLong(soundProfileId);     // Catch: Throwable -> L9
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

            @Override // android.hardware.tv.mediaquality.ISoundProfileAdjustmentListener
            public void requestSoundParameters(long SoundProfileId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(ISoundProfileAdjustmentListener.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeLong(SoundProfileId);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(4, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method requestSoundParameters is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.mediaquality.ISoundProfileAdjustmentListener
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain(asBinder());
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(ISoundProfileAdjustmentListener.DESCRIPTOR);     // Catch: Throwable -> L7
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

            @Override // android.hardware.tv.mediaquality.ISoundProfileAdjustmentListener
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain(asBinder());     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(ISoundProfileAdjustmentListener.DESCRIPTOR);     // Catch: Throwable -> L10
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
            attachInterface(this, ISoundProfileAdjustmentListener.DESCRIPTOR);
        }

        public static ISoundProfileAdjustmentListener asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(ISoundProfileAdjustmentListener.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof ISoundProfileAdjustmentListener) == false) goto L12;
            return (ISoundProfileAdjustmentListener) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch(transactionCode) {
                case 1: goto L15;
                case 2: goto L13;
                case 3: goto L11;
                case 4: goto L9;
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
            return "requestSoundParameters";
        L11:
            return "onVendorParamCapabilityChanged";
        L13:
            return "onParamCapabilityChanged";
        L15:
            return "onSoundProfileAdjusted";
        }

        public String getTransactionName(int transactionCode) {
            return getDefaultTransactionName(transactionCode);
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = ISoundProfileAdjustmentListener.DESCRIPTOR;
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
                case 1: goto L23;
                case 2: goto L22;
                case 3: goto L21;
                case 4: goto L20;
                default: goto L19;
            };
        L20:
            long _arg0 = data.readLong();
            data.enforceNoDataAvail();
            requestSoundParameters(_arg0);
        L24:
            return true;
        L21:
            long _arg1 = data.readLong();
            VendorParamCapability[] _arg2 = (VendorParamCapability[]) data.createTypedArray(VendorParamCapability.CREATOR);
            data.enforceNoDataAvail();
            onVendorParamCapabilityChanged(_arg1, _arg2);
            goto L24
        L22:
            long _arg3 = data.readLong();
            ParamCapability[] _arg4 = (ParamCapability[]) data.createTypedArray(ParamCapability.CREATOR);
            data.enforceNoDataAvail();
            onParamCapabilityChanged(_arg3, _arg4);
            goto L24
        L23:
            SoundProfile _arg5 = (SoundProfile) data.readTypedObject(SoundProfile.CREATOR);
            data.enforceNoDataAvail();
            onSoundProfileAdjusted(_arg5);
            goto L24
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

    void onSoundProfileAdjusted(SoundProfile r1) throws RemoteException;

    void onVendorParamCapabilityChanged(long r1, VendorParamCapability[] r3) throws RemoteException;

    void requestSoundParameters(long r1) throws RemoteException;

    static {
        DESCRIPTOR = "android$hardware$tv$mediaquality$ISoundProfileAdjustmentListener".replace('$', '.');
    }
}
