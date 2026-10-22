package vendor.stepos.hardware.thermal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.StepOSDateTimeUrlHelper;

/* loaded from: classes.dex */
public interface IThermalCallback extends IInterface {
    public static final String DESCRIPTOR = "vendor$stepos$hardware$thermal$IThermalCallback".replace('$', '.');
    public static final String HASH = "0c400c5f92d740b539cc820939fb9bb6fd9477e6";
    public static final int VERSION = 1;

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    void onThermalChanged(ThermalSample thermalSample) throws RemoteException;

    public static class Default implements IThermalCallback {
        @Override // vendor.stepos.hardware.thermal.IThermalCallback
        public void onThermalChanged(ThermalSample sample) throws RemoteException {
        }

        @Override // vendor.stepos.hardware.thermal.IThermalCallback
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // vendor.stepos.hardware.thermal.IThermalCallback
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IThermalCallback {
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_onThermalChanged = 1;

        public Stub() {
            markVintfStability();
            attachInterface(this, DESCRIPTOR);
        }

        public static IThermalCallback asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IThermalCallback)) {
                return (IThermalCallback) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = DESCRIPTOR;
            if (code >= 1 && code <= TRANSACTION_getInterfaceVersion) {
                data.enforceInterface(descriptor);
            }
            if (code == 1598968902) {
                reply.writeString(descriptor);
                return true;
            }
            if (code == TRANSACTION_getInterfaceVersion) {
                reply.writeNoException();
                reply.writeInt(getInterfaceVersion());
                return true;
            }
            if (code == TRANSACTION_getInterfaceHash) {
                reply.writeNoException();
                reply.writeString(getInterfaceHash());
                return true;
            }
            switch (code) {
                case 1:
                    ThermalSample _arg0 = (ThermalSample) data.readTypedObject(ThermalSample.CREATOR);
                    onThermalChanged(_arg0);
                    break;
            }
            return true;
        }

        private static class Proxy implements IThermalCallback {
            private IBinder mRemote;
            private int mCachedVersion = -1;
            private String mCachedHash = StepOSDateTimeUrlHelper.UNKNOW_EVENT;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }

            @Override // vendor.stepos.hardware.thermal.IThermalCallback
            public void onThermalChanged(ThermalSample sample) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeTypedObject(sample, 0);
                    boolean _status = this.mRemote.transact(1, _data, null, 1);
                    if (!_status) {
                        throw new RemoteException("Method onThermalChanged is unimplemented.");
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override // vendor.stepos.hardware.thermal.IThermalCallback
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion == -1) {
                    Parcel data = Parcel.obtain();
                    Parcel reply = Parcel.obtain();
                    try {
                        data.writeInterfaceToken(DESCRIPTOR);
                        this.mRemote.transact(Stub.TRANSACTION_getInterfaceVersion, data, reply, 0);
                        reply.readException();
                        this.mCachedVersion = reply.readInt();
                    } finally {
                        reply.recycle();
                        data.recycle();
                    }
                }
                return this.mCachedVersion;
            }

            @Override // vendor.stepos.hardware.thermal.IThermalCallback
            public synchronized String getInterfaceHash() throws RemoteException {
                if (StepOSDateTimeUrlHelper.UNKNOW_EVENT.equals(this.mCachedHash)) {
                    Parcel data = Parcel.obtain();
                    Parcel reply = Parcel.obtain();
                    try {
                        data.writeInterfaceToken(DESCRIPTOR);
                        this.mRemote.transact(Stub.TRANSACTION_getInterfaceHash, data, reply, 0);
                        reply.readException();
                        this.mCachedHash = reply.readString();
                        reply.recycle();
                        data.recycle();
                    } catch (Throwable th) {
                        reply.recycle();
                        data.recycle();
                        throw th;
                    }
                }
                return this.mCachedHash;
            }
        }
    }
}
