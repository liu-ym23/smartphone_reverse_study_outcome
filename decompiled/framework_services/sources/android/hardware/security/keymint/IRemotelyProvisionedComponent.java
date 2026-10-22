package android.hardware.security.keymint;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IRemotelyProvisionedComponent extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "7d14edbfab5c490efa407ba55fa80614bb48ae8e";
    public static final int STATUS_FAILED = 1;
    public static final int STATUS_INVALID_EEK = 5;
    public static final int STATUS_INVALID_MAC = 2;
    public static final int STATUS_PRODUCTION_KEY_IN_TEST_REQUEST = 3;
    public static final int STATUS_REMOVED = 6;
    public static final int STATUS_TEST_KEY_IN_PRODUCTION_REQUEST = 4;
    public static final int VERSION = 3;

    public static class Default implements IRemotelyProvisionedComponent {
        public Default() {
        }

        @Override // android.hardware.security.keymint.IRemotelyProvisionedComponent
        public RpcHardwareInfo getHardwareInfo() throws RemoteException {
            return null;
        }

        @Override // android.hardware.security.keymint.IRemotelyProvisionedComponent
        public byte[] generateEcdsaP256KeyPair(boolean testMode, MacedPublicKey macedPublicKey) throws RemoteException {
            return null;
        }

        @Override // android.hardware.security.keymint.IRemotelyProvisionedComponent
        public byte[] generateCertificateRequest(boolean testMode, MacedPublicKey[] keysToSign, byte[] endpointEncryptionCertChain, byte[] challenge, DeviceInfo deviceInfo, ProtectedData protectedData) throws RemoteException {
            return null;
        }

        @Override // android.hardware.security.keymint.IRemotelyProvisionedComponent
        public byte[] generateCertificateRequestV2(MacedPublicKey[] keysToSign, byte[] challenge) throws RemoteException {
            return null;
        }

        @Override // android.hardware.security.keymint.IRemotelyProvisionedComponent
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // android.hardware.security.keymint.IRemotelyProvisionedComponent
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IRemotelyProvisionedComponent {
        static final int TRANSACTION_generateCertificateRequest = 3;
        static final int TRANSACTION_generateCertificateRequestV2 = 4;
        static final int TRANSACTION_generateEcdsaP256KeyPair = 2;
        static final int TRANSACTION_getHardwareInfo = 1;
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;

        private static class Proxy implements IRemotelyProvisionedComponent {
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
                return IRemotelyProvisionedComponent.DESCRIPTOR;
            }

            @Override // android.hardware.security.keymint.IRemotelyProvisionedComponent
            public RpcHardwareInfo getHardwareInfo() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IRemotelyProvisionedComponent.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(1, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                RpcHardwareInfo _result = (RpcHardwareInfo) _reply.readTypedObject(RpcHardwareInfo.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getHardwareInfo is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.security.keymint.IRemotelyProvisionedComponent
            public byte[] generateEcdsaP256KeyPair(boolean testMode, MacedPublicKey macedPublicKey) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IRemotelyProvisionedComponent.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeBoolean(testMode);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(2, _data, _reply, 0);     // Catch: Throwable -> L9
                if (_status == false) goto L14;
                _reply.readException();     // Catch: Throwable -> L9
                byte[] _result = _reply.createByteArray();     // Catch: Throwable -> L9
                if (_reply.readInt() == 0) goto L11;
                macedPublicKey.readFromParcel(_reply);     // Catch: Throwable -> L9
            L11:
                _reply.recycle();
                _data.recycle();
                return _result;
            L14:
                throw new RemoteException("Method generateEcdsaP256KeyPair is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.security.keymint.IRemotelyProvisionedComponent
            public byte[] generateCertificateRequest(boolean testMode, MacedPublicKey[] keysToSign, byte[] endpointEncryptionCertChain, byte[] challenge, DeviceInfo deviceInfo, ProtectedData protectedData) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IRemotelyProvisionedComponent.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeBoolean(testMode);     // Catch: Throwable -> L8
                _data.writeTypedArray(keysToSign, 0);     // Catch: Throwable -> L8
                _data.writeByteArray(endpointEncryptionCertChain);     // Catch: Throwable -> L8
                _data.writeByteArray(challenge);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(3, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L16;
                _reply.readException();     // Catch: Throwable -> L8
                byte[] _result = _reply.createByteArray();     // Catch: Throwable -> L8
                if (_reply.readInt() == 0) goto L11;
                deviceInfo.readFromParcel(_reply);     // Catch: Throwable -> L8
            L11:
                if (_reply.readInt() == 0) goto L13;
                protectedData.readFromParcel(_reply);     // Catch: Throwable -> L8
            L13:
                _reply.recycle();
                _data.recycle();
                return _result;
            L16:
                throw new RemoteException("Method generateCertificateRequest is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.security.keymint.IRemotelyProvisionedComponent
            public byte[] generateCertificateRequestV2(MacedPublicKey[] keysToSign, byte[] challenge) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IRemotelyProvisionedComponent.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeTypedArray(keysToSign, 0);     // Catch: Throwable -> L8
                _data.writeByteArray(challenge);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(4, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                byte[] _result = _reply.createByteArray();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method generateCertificateRequestV2 is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.security.keymint.IRemotelyProvisionedComponent
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain(asBinder());
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(IRemotelyProvisionedComponent.DESCRIPTOR);     // Catch: Throwable -> L7
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

            @Override // android.hardware.security.keymint.IRemotelyProvisionedComponent
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain(asBinder());     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(IRemotelyProvisionedComponent.DESCRIPTOR);     // Catch: Throwable -> L10
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
            attachInterface(this, IRemotelyProvisionedComponent.DESCRIPTOR);
        }

        public static IRemotelyProvisionedComponent asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IRemotelyProvisionedComponent.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IRemotelyProvisionedComponent) == false) goto L12;
            return (IRemotelyProvisionedComponent) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = IRemotelyProvisionedComponent.DESCRIPTOR;
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
            MacedPublicKey[] _arg0 = (MacedPublicKey[]) data.createTypedArray(MacedPublicKey.CREATOR);
            byte[] _arg1 = data.createByteArray();
            data.enforceNoDataAvail();
            byte[] _result = generateCertificateRequestV2(_arg0, _arg1);
            reply.writeNoException();
            reply.writeByteArray(_result);
        L24:
            return true;
        L21:
            boolean _arg2 = data.readBoolean();
            MacedPublicKey[] _arg3 = (MacedPublicKey[]) data.createTypedArray(MacedPublicKey.CREATOR);
            byte[] _arg4 = data.createByteArray();
            byte[] _arg5 = data.createByteArray();
            DeviceInfo _arg6 = new DeviceInfo();
            ProtectedData _arg7 = new ProtectedData();
            data.enforceNoDataAvail();
            byte[] _result2 = generateCertificateRequest(_arg2, _arg3, _arg4, _arg5, _arg6, _arg7);
            reply.writeNoException();
            reply.writeByteArray(_result2);
            reply.writeTypedObject(_arg6, 1);
            reply.writeTypedObject(_arg7, 1);
            goto L24
        L22:
            boolean _arg8 = data.readBoolean();
            MacedPublicKey _arg9 = new MacedPublicKey();
            data.enforceNoDataAvail();
            byte[] _result3 = generateEcdsaP256KeyPair(_arg8, _arg9);
            reply.writeNoException();
            reply.writeByteArray(_result3);
            reply.writeTypedObject(_arg9, 1);
            goto L24
        L23:
            RpcHardwareInfo _result4 = getHardwareInfo();
            reply.writeNoException();
            reply.writeTypedObject(_result4, 1);
            goto L24
        L19:
            return super.onTransact(code, data, reply, flags);
        }
    }

    byte[] generateCertificateRequest(boolean r1, MacedPublicKey[] r2, byte[] r3, byte[] r4, DeviceInfo r5, ProtectedData r6) throws RemoteException;

    byte[] generateCertificateRequestV2(MacedPublicKey[] r1, byte[] r2) throws RemoteException;

    byte[] generateEcdsaP256KeyPair(boolean r1, MacedPublicKey r2) throws RemoteException;

    RpcHardwareInfo getHardwareInfo() throws RemoteException;

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    static {
        DESCRIPTOR = "android$hardware$security$keymint$IRemotelyProvisionedComponent".replace('$', '.');
    }
}
