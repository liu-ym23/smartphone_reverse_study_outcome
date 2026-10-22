package vendor.bytedance.thermalextservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IThermalPackageApplier extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "9fa87beb6e476c774f619c66a68b52aab48242b3";
    public static final int VERSION = 2;

    public static class Default implements IThermalPackageApplier {
        public Default() {
        }

        @Override // vendor.bytedance.thermalextservice.IThermalPackageApplier
        public void applyThermalPackage(ThermalPackageApplyRequest request, ParcelFileDescriptor srcFd, IThermalPackageApplyCallback callback) throws RemoteException {
        }

        @Override // vendor.bytedance.thermalextservice.IThermalPackageApplier
        public void applyThermalPackageBytes(ThermalPackageApplyRequest request, byte[] payload, IThermalPackageApplyCallback callback) throws RemoteException {
        }

        @Override // vendor.bytedance.thermalextservice.IThermalPackageApplier
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // vendor.bytedance.thermalextservice.IThermalPackageApplier
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IThermalPackageApplier {
        static final int TRANSACTION_applyThermalPackage = 1;
        static final int TRANSACTION_applyThermalPackageBytes = 2;
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;

        private static class Proxy implements IThermalPackageApplier {
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
                return IThermalPackageApplier.DESCRIPTOR;
            }

            @Override // vendor.bytedance.thermalextservice.IThermalPackageApplier
            public void applyThermalPackage(ThermalPackageApplyRequest request, ParcelFileDescriptor srcFd, IThermalPackageApplyCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IThermalPackageApplier.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeTypedObject(request, 0);     // Catch: Throwable -> L9
                _data.writeTypedObject(srcFd, 0);     // Catch: Throwable -> L9
                _data.writeStrongInterface(callback);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(1, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method applyThermalPackage is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // vendor.bytedance.thermalextservice.IThermalPackageApplier
            public void applyThermalPackageBytes(ThermalPackageApplyRequest request, byte[] payload, IThermalPackageApplyCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IThermalPackageApplier.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeTypedObject(request, 0);     // Catch: Throwable -> L9
                _data.writeByteArray(payload);     // Catch: Throwable -> L9
                _data.writeStrongInterface(callback);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(2, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method applyThermalPackageBytes is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // vendor.bytedance.thermalextservice.IThermalPackageApplier
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(IThermalPackageApplier.DESCRIPTOR);     // Catch: Throwable -> L7
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

            @Override // vendor.bytedance.thermalextservice.IThermalPackageApplier
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain();     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(IThermalPackageApplier.DESCRIPTOR);     // Catch: Throwable -> L10
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
            attachInterface(this, IThermalPackageApplier.DESCRIPTOR);
        }

        public static IThermalPackageApplier asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IThermalPackageApplier.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IThermalPackageApplier) == false) goto L12;
            return (IThermalPackageApplier) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = IThermalPackageApplier.DESCRIPTOR;
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
                case 1: goto L21;
                case 2: goto L20;
                default: goto L19;
            };
        L20:
            ThermalPackageApplyRequest _arg0 = (ThermalPackageApplyRequest) data.readTypedObject(ThermalPackageApplyRequest.CREATOR);
            byte[] _arg1 = data.createByteArray();
            IThermalPackageApplyCallback _arg2 = IThermalPackageApplyCallback.Stub.asInterface(data.readStrongBinder());
            applyThermalPackageBytes(_arg0, _arg1, _arg2);
        L22:
            return true;
        L21:
            ThermalPackageApplyRequest _arg3 = (ThermalPackageApplyRequest) data.readTypedObject(ThermalPackageApplyRequest.CREATOR);
            ParcelFileDescriptor _arg4 = (ParcelFileDescriptor) data.readTypedObject(ParcelFileDescriptor.CREATOR);
            IThermalPackageApplyCallback _arg5 = IThermalPackageApplyCallback.Stub.asInterface(data.readStrongBinder());
            applyThermalPackage(_arg3, _arg4, _arg5);
            goto L22
        L19:
            return super.onTransact(code, data, reply, flags);
        }
    }

    void applyThermalPackage(ThermalPackageApplyRequest r1, ParcelFileDescriptor r2, IThermalPackageApplyCallback r3) throws RemoteException;

    void applyThermalPackageBytes(ThermalPackageApplyRequest r1, byte[] r2, IThermalPackageApplyCallback r3) throws RemoteException;

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    static {
        DESCRIPTOR = "vendor$bytedance$thermalextservice$IThermalPackageApplier".replace('$', '.');
    }
}
