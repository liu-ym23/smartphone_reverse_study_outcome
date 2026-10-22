package vendor.awinic.hardware.tiktap.vibrator;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.android.server.media.projection.IMediaProjectionManagerServiceExt;

/* JADX INFO: loaded from: classes3.dex */
public interface ITiktapVibrator extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "3f5f3b638a441a66271a24da96a78da0cdd15e96";
    public static final int VERSION = 1;

    public static class Default implements ITiktapVibrator {
        public Default() {
        }

        @Override // vendor.awinic.hardware.tiktap.vibrator.ITiktapVibrator
        public void init(ITiktapCallback callback) throws RemoteException {
        }

        @Override // vendor.awinic.hardware.tiktap.vibrator.ITiktapVibrator
        public void setDynamicScale(int scale, ITiktapCallback callback) throws RemoteException {
        }

        @Override // vendor.awinic.hardware.tiktap.vibrator.ITiktapVibrator
        public void setF0(int f0, ITiktapCallback callback) throws RemoteException {
        }

        @Override // vendor.awinic.hardware.tiktap.vibrator.ITiktapVibrator
        public void stop(ITiktapCallback callback) throws RemoteException {
        }

        @Override // vendor.awinic.hardware.tiktap.vibrator.ITiktapVibrator
        public void setAmplitude(int amplitude, ITiktapCallback callback) throws RemoteException {
        }

        @Override // vendor.awinic.hardware.tiktap.vibrator.ITiktapVibrator
        public void performHeParam(int interval, int amplitude, int freq, ITiktapCallback callback) throws RemoteException {
        }

        @Override // vendor.awinic.hardware.tiktap.vibrator.ITiktapVibrator
        public void off(ITiktapCallback callback) throws RemoteException {
        }

        @Override // vendor.awinic.hardware.tiktap.vibrator.ITiktapVibrator
        public void on(int timeoutMs, ITiktapCallback callback) throws RemoteException {
        }

        @Override // vendor.awinic.hardware.tiktap.vibrator.ITiktapVibrator
        public int perform(int effect_id, byte strength, ITiktapCallback callback) throws RemoteException {
            return 0;
        }

        @Override // vendor.awinic.hardware.tiktap.vibrator.ITiktapVibrator
        public void performEnvelope(int[] envInfo, boolean fastFlag, ITiktapCallback callback) throws RemoteException {
        }

        @Override // vendor.awinic.hardware.tiktap.vibrator.ITiktapVibrator
        public void performRtp(ParcelFileDescriptor hdl, ITiktapCallback callback) throws RemoteException {
        }

        @Override // vendor.awinic.hardware.tiktap.vibrator.ITiktapVibrator
        public void performHe(int looper, int interval, int amplitude, int freq, int[] he, ITiktapCallback callback) throws RemoteException {
        }

        @Override // vendor.awinic.hardware.tiktap.vibrator.ITiktapVibrator
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // vendor.awinic.hardware.tiktap.vibrator.ITiktapVibrator
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ITiktapVibrator {
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_init = 1;
        static final int TRANSACTION_off = 7;
        static final int TRANSACTION_on = 8;
        static final int TRANSACTION_perform = 9;
        static final int TRANSACTION_performEnvelope = 10;
        static final int TRANSACTION_performHe = 12;
        static final int TRANSACTION_performHeParam = 6;
        static final int TRANSACTION_performRtp = 11;
        static final int TRANSACTION_setAmplitude = 5;
        static final int TRANSACTION_setDynamicScale = 2;
        static final int TRANSACTION_setF0 = 3;
        static final int TRANSACTION_stop = 4;

        private static class Proxy implements ITiktapVibrator {
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
                return ITiktapVibrator.DESCRIPTOR;
            }

            @Override // vendor.awinic.hardware.tiktap.vibrator.ITiktapVibrator
            public void init(ITiktapCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(ITiktapVibrator.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeStrongInterface(callback);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(1, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method init is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // vendor.awinic.hardware.tiktap.vibrator.ITiktapVibrator
            public void setDynamicScale(int scale, ITiktapCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(ITiktapVibrator.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeInt(scale);     // Catch: Throwable -> L9
                _data.writeStrongInterface(callback);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(2, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method setDynamicScale is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // vendor.awinic.hardware.tiktap.vibrator.ITiktapVibrator
            public void setF0(int f0, ITiktapCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(ITiktapVibrator.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeInt(f0);     // Catch: Throwable -> L9
                _data.writeStrongInterface(callback);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(3, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method setF0 is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // vendor.awinic.hardware.tiktap.vibrator.ITiktapVibrator
            public void stop(ITiktapCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(ITiktapVibrator.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeStrongInterface(callback);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(4, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method stop is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // vendor.awinic.hardware.tiktap.vibrator.ITiktapVibrator
            public void setAmplitude(int amplitude, ITiktapCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(ITiktapVibrator.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeInt(amplitude);     // Catch: Throwable -> L9
                _data.writeStrongInterface(callback);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(5, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method setAmplitude is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // vendor.awinic.hardware.tiktap.vibrator.ITiktapVibrator
            public void performHeParam(int interval, int amplitude, int freq, ITiktapCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(ITiktapVibrator.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeInt(interval);     // Catch: Throwable -> L9
                _data.writeInt(amplitude);     // Catch: Throwable -> L9
                _data.writeInt(freq);     // Catch: Throwable -> L9
                _data.writeStrongInterface(callback);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(6, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method performHeParam is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // vendor.awinic.hardware.tiktap.vibrator.ITiktapVibrator
            public void off(ITiktapCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(ITiktapVibrator.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeStrongInterface(callback);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(7, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method off is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // vendor.awinic.hardware.tiktap.vibrator.ITiktapVibrator
            public void on(int timeoutMs, ITiktapCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(ITiktapVibrator.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeInt(timeoutMs);     // Catch: Throwable -> L9
                _data.writeStrongInterface(callback);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(8, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method on is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // vendor.awinic.hardware.tiktap.vibrator.ITiktapVibrator
            public int perform(int effect_id, byte strength, ITiktapCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(ITiktapVibrator.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(effect_id);     // Catch: Throwable -> L8
                _data.writeByte(strength);     // Catch: Throwable -> L8
                _data.writeStrongInterface(callback);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(9, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                int _result = _reply.readInt();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method perform is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.awinic.hardware.tiktap.vibrator.ITiktapVibrator
            public void performEnvelope(int[] envInfo, boolean fastFlag, ITiktapCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(ITiktapVibrator.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeIntArray(envInfo);     // Catch: Throwable -> L9
                _data.writeBoolean(fastFlag);     // Catch: Throwable -> L9
                _data.writeStrongInterface(callback);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(10, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method performEnvelope is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // vendor.awinic.hardware.tiktap.vibrator.ITiktapVibrator
            public void performRtp(ParcelFileDescriptor hdl, ITiktapCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(ITiktapVibrator.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeTypedObject(hdl, 0);     // Catch: Throwable -> L9
                _data.writeStrongInterface(callback);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(11, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method performRtp is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // vendor.awinic.hardware.tiktap.vibrator.ITiktapVibrator
            public void performHe(int looper, int interval, int amplitude, int freq, int[] he, ITiktapCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(ITiktapVibrator.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeInt(looper);     // Catch: Throwable -> L9
                _data.writeInt(interval);     // Catch: Throwable -> L9
                _data.writeInt(amplitude);     // Catch: Throwable -> L9
                _data.writeInt(freq);     // Catch: Throwable -> L9
                _data.writeIntArray(he);     // Catch: Throwable -> L9
                _data.writeStrongInterface(callback);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(12, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method performHe is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // vendor.awinic.hardware.tiktap.vibrator.ITiktapVibrator
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain(asBinder());
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(ITiktapVibrator.DESCRIPTOR);     // Catch: Throwable -> L7
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

            @Override // vendor.awinic.hardware.tiktap.vibrator.ITiktapVibrator
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain(asBinder());     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(ITiktapVibrator.DESCRIPTOR);     // Catch: Throwable -> L10
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
            attachInterface(this, ITiktapVibrator.DESCRIPTOR);
        }

        public static ITiktapVibrator asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(ITiktapVibrator.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof ITiktapVibrator) == false) goto L12;
            return (ITiktapVibrator) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch(transactionCode) {
                case 1: goto L31;
                case 2: goto L29;
                case 3: goto L27;
                case 4: goto L25;
                case 5: goto L23;
                case 6: goto L21;
                case 7: goto L19;
                case 8: goto L17;
                case 9: goto L15;
                case 10: goto L13;
                case 11: goto L11;
                case 12: goto L9;
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
            return "performHe";
        L11:
            return "performRtp";
        L13:
            return "performEnvelope";
        L15:
            return "perform";
        L17:
            return "on";
        L19:
            return "off";
        L21:
            return "performHeParam";
        L23:
            return "setAmplitude";
        L25:
            return IMediaProjectionManagerServiceExt.NODE_STOP;
        L27:
            return "setF0";
        L29:
            return "setDynamicScale";
        L31:
            return "init";
        }

        public String getTransactionName(int transactionCode) {
            return getDefaultTransactionName(transactionCode);
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = ITiktapVibrator.DESCRIPTOR;
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
                case 1: goto L31;
                case 2: goto L30;
                case 3: goto L29;
                case 4: goto L28;
                case 5: goto L27;
                case 6: goto L26;
                case 7: goto L25;
                case 8: goto L24;
                case 9: goto L23;
                case 10: goto L22;
                case 11: goto L21;
                case 12: goto L20;
                default: goto L19;
            };
        L20:
            int _arg0 = data.readInt();
            int _arg1 = data.readInt();
            int _arg2 = data.readInt();
            int _arg3 = data.readInt();
            int[] _arg4 = data.createIntArray();
            ITiktapCallback _arg5 = ITiktapCallback.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            performHe(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
        L32:
            return true;
        L21:
            ParcelFileDescriptor _arg6 = (ParcelFileDescriptor) data.readTypedObject(ParcelFileDescriptor.CREATOR);
            ITiktapCallback _arg7 = ITiktapCallback.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            performRtp(_arg6, _arg7);
            goto L32
        L22:
            int[] _arg8 = data.createIntArray();
            boolean _arg9 = data.readBoolean();
            ITiktapCallback _arg10 = ITiktapCallback.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            performEnvelope(_arg8, _arg9, _arg10);
            goto L32
        L23:
            int _arg11 = data.readInt();
            byte _arg12 = data.readByte();
            ITiktapCallback _arg13 = ITiktapCallback.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            int _result = perform(_arg11, _arg12, _arg13);
            reply.writeNoException();
            reply.writeInt(_result);
            goto L32
        L24:
            int _arg14 = data.readInt();
            ITiktapCallback _arg15 = ITiktapCallback.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            on(_arg14, _arg15);
            goto L32
        L25:
            ITiktapCallback _arg16 = ITiktapCallback.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            off(_arg16);
            goto L32
        L26:
            int _arg17 = data.readInt();
            int _arg18 = data.readInt();
            int _arg19 = data.readInt();
            ITiktapCallback _arg20 = ITiktapCallback.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            performHeParam(_arg17, _arg18, _arg19, _arg20);
            goto L32
        L27:
            int _arg21 = data.readInt();
            ITiktapCallback _arg22 = ITiktapCallback.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            setAmplitude(_arg21, _arg22);
            goto L32
        L28:
            ITiktapCallback _arg23 = ITiktapCallback.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            stop(_arg23);
            goto L32
        L29:
            int _arg24 = data.readInt();
            ITiktapCallback _arg25 = ITiktapCallback.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            setF0(_arg24, _arg25);
            goto L32
        L30:
            int _arg26 = data.readInt();
            ITiktapCallback _arg27 = ITiktapCallback.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            setDynamicScale(_arg26, _arg27);
            goto L32
        L31:
            ITiktapCallback _arg28 = ITiktapCallback.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            init(_arg28);
            goto L32
        L19:
            return super.onTransact(code, data, reply, flags);
        }

        public int getMaxTransactionId() {
            return TRANSACTION_getInterfaceHash;
        }
    }

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    void init(ITiktapCallback r1) throws RemoteException;

    void off(ITiktapCallback r1) throws RemoteException;

    void on(int r1, ITiktapCallback r2) throws RemoteException;

    int perform(int r1, byte r2, ITiktapCallback r3) throws RemoteException;

    void performEnvelope(int[] r1, boolean r2, ITiktapCallback r3) throws RemoteException;

    void performHe(int r1, int r2, int r3, int r4, int[] r5, ITiktapCallback r6) throws RemoteException;

    void performHeParam(int r1, int r2, int r3, ITiktapCallback r4) throws RemoteException;

    void performRtp(ParcelFileDescriptor r1, ITiktapCallback r2) throws RemoteException;

    void setAmplitude(int r1, ITiktapCallback r2) throws RemoteException;

    void setDynamicScale(int r1, ITiktapCallback r2) throws RemoteException;

    void setF0(int r1, ITiktapCallback r2) throws RemoteException;

    void stop(ITiktapCallback r1) throws RemoteException;

    static {
        DESCRIPTOR = "vendor$awinic$hardware$tiktap$vibrator$ITiktapVibrator".replace('$', '.');
    }
}
