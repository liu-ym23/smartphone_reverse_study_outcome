package android.hardware.ir;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IConsumerIr extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "3e04aed366e96850c6164287eaf78a8e4ab071b0";
    public static final int VERSION = 1;

    public static class Default implements IConsumerIr {
        public Default() {
        }

        @Override // android.hardware.ir.IConsumerIr
        public ConsumerIrFreqRange[] getCarrierFreqs() throws RemoteException {
            return null;
        }

        @Override // android.hardware.ir.IConsumerIr
        public void transmit(int carrierFreqHz, int[] pattern) throws RemoteException {
        }

        @Override // android.hardware.ir.IConsumerIr
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // android.hardware.ir.IConsumerIr
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IConsumerIr {
        static final int TRANSACTION_getCarrierFreqs = 1;
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_transmit = 2;

        private static class Proxy implements IConsumerIr {
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
                return IConsumerIr.DESCRIPTOR;
            }

            @Override // android.hardware.ir.IConsumerIr
            public ConsumerIrFreqRange[] getCarrierFreqs() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IConsumerIr.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(1, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                ConsumerIrFreqRange[] _result = (ConsumerIrFreqRange[]) _reply.createTypedArray(ConsumerIrFreqRange.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getCarrierFreqs is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.ir.IConsumerIr
            public void transmit(int carrierFreqHz, int[] pattern) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IConsumerIr.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(carrierFreqHz);     // Catch: Throwable -> L8
                _data.writeIntArray(pattern);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(2, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method transmit is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.ir.IConsumerIr
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain(asBinder());
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(IConsumerIr.DESCRIPTOR);     // Catch: Throwable -> L7
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

            @Override // android.hardware.ir.IConsumerIr
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain(asBinder());     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(IConsumerIr.DESCRIPTOR);     // Catch: Throwable -> L10
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
            attachInterface(this, IConsumerIr.DESCRIPTOR);
        }

        public static IConsumerIr asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IConsumerIr.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IConsumerIr) == false) goto L12;
            return (IConsumerIr) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = IConsumerIr.DESCRIPTOR;
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
            int _arg0 = data.readInt();
            int[] _arg1 = data.createIntArray();
            data.enforceNoDataAvail();
            transmit(_arg0, _arg1);
            reply.writeNoException();
        L22:
            return true;
        L21:
            ConsumerIrFreqRange[] _result = getCarrierFreqs();
            reply.writeNoException();
            reply.writeTypedArray(_result, 1);
            goto L22
        L19:
            return super.onTransact(code, data, reply, flags);
        }
    }

    ConsumerIrFreqRange[] getCarrierFreqs() throws RemoteException;

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    void transmit(int r1, int[] r2) throws RemoteException;

    static {
        DESCRIPTOR = "android$hardware$ir$IConsumerIr".replace('$', '.');
    }
}
