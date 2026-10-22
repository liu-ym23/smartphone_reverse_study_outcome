package android.hardware.audio.effect;

import android.hardware.common.fmq.MQDescriptor;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IEffect extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "34b618a587cb9977ee0cd13b173e699d2dcdb320";
    public static final int VERSION = 1;

    public static class Default implements IEffect {
        public Default() {
        }

        @Override // android.hardware.audio.effect.IEffect
        public OpenEffectReturn open(Parameter.Common common, Parameter.Specific specific) throws RemoteException {
            return null;
        }

        @Override // android.hardware.audio.effect.IEffect
        public void close() throws RemoteException {
        }

        @Override // android.hardware.audio.effect.IEffect
        public Descriptor getDescriptor() throws RemoteException {
            return null;
        }

        @Override // android.hardware.audio.effect.IEffect
        public void command(int commandId) throws RemoteException {
        }

        @Override // android.hardware.audio.effect.IEffect
        public byte getState() throws RemoteException {
            return 0;
        }

        @Override // android.hardware.audio.effect.IEffect
        public void setParameter(Parameter param) throws RemoteException {
        }

        @Override // android.hardware.audio.effect.IEffect
        public Parameter getParameter(Parameter.Id paramId) throws RemoteException {
            return null;
        }

        @Override // android.hardware.audio.effect.IEffect
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // android.hardware.audio.effect.IEffect
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static class OpenEffectReturn implements Parcelable {
        public static final Parcelable.Creator<OpenEffectReturn> CREATOR = null;
        public MQDescriptor<Float, Byte> inputDataMQ;
        public MQDescriptor<Float, Byte> outputDataMQ;
        public MQDescriptor<Status, Byte> statusMQ;

        public OpenEffectReturn() {
        }

        public final int getStability() {
            return 1;
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel _aidl_parcel, int _aidl_flag) {
            int _aidl_start_pos = _aidl_parcel.dataPosition();
            _aidl_parcel.writeInt(0);
            _aidl_parcel.writeTypedObject(this.statusMQ, _aidl_flag);
            _aidl_parcel.writeTypedObject(this.inputDataMQ, _aidl_flag);
            _aidl_parcel.writeTypedObject(this.outputDataMQ, _aidl_flag);
            int _aidl_end_pos = _aidl_parcel.dataPosition();
            _aidl_parcel.setDataPosition(_aidl_start_pos);
            _aidl_parcel.writeInt(_aidl_end_pos - _aidl_start_pos);
            _aidl_parcel.setDataPosition(_aidl_end_pos);
        }

        public final void readFromParcel(Parcel _aidl_parcel) {
            int _aidl_start_pos = _aidl_parcel.dataPosition();
            int _aidl_parcelable_size = _aidl_parcel.readInt();
            if (_aidl_parcelable_size < 4) goto L41;
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L8;
            this.statusMQ = (MQDescriptor) _aidl_parcel.readTypedObject(MQDescriptor.CREATOR);     // Catch: Throwable -> L38
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
            this.inputDataMQ = (MQDescriptor) _aidl_parcel.readTypedObject(MQDescriptor.CREATOR);     // Catch: Throwable -> L38
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L26;
            this.outputDataMQ = (MQDescriptor) _aidl_parcel.readTypedObject(MQDescriptor.CREATOR);     // Catch: Throwable -> L38
            if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L37;
            _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
            return;
        L37:
            throw new BadParcelableException("Overflow in the size of parcelable");
        L26:
            if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L30;
            _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
            return;
        L30:
            throw new BadParcelableException("Overflow in the size of parcelable");
        L17:
            if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L21;
            _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
            return;
        L21:
            throw new BadParcelableException("Overflow in the size of parcelable");
        L8:
            if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L12;
            _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
            return;
        L12:
            throw new BadParcelableException("Overflow in the size of parcelable");
        L41:
            throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L38
        L38:
            th = move-exception;
            if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L45;
            _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
            throw th;
        L45:
            throw new BadParcelableException("Overflow in the size of parcelable");
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            int _mask = 0 | describeContents(this.statusMQ);
            return (_mask | describeContents(this.inputDataMQ)) | describeContents(this.outputDataMQ);
        }

        private int describeContents(Object _v) {
            if (_v != null) goto L6;
            return 0;
        L6:
            if ((_v instanceof Parcelable) == true) goto L8;
            return 0;
        L8:
            return ((Parcelable) _v).describeContents();
        }
    }

    public static class Status implements Parcelable {
        public static final Parcelable.Creator<Status> CREATOR = null;
        public int fmqConsumed;
        public int fmqProduced;
        public int status;

        public Status() {
            this.status = 0;
            this.fmqConsumed = 0;
            this.fmqProduced = 0;
        }

        public final int getStability() {
            return 1;
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel _aidl_parcel, int _aidl_flag) {
            int _aidl_start_pos = _aidl_parcel.dataPosition();
            _aidl_parcel.writeInt(0);
            _aidl_parcel.writeInt(this.status);
            _aidl_parcel.writeInt(this.fmqConsumed);
            _aidl_parcel.writeInt(this.fmqProduced);
            int _aidl_end_pos = _aidl_parcel.dataPosition();
            _aidl_parcel.setDataPosition(_aidl_start_pos);
            _aidl_parcel.writeInt(_aidl_end_pos - _aidl_start_pos);
            _aidl_parcel.setDataPosition(_aidl_end_pos);
        }

        public final void readFromParcel(Parcel _aidl_parcel) {
            int _aidl_start_pos = _aidl_parcel.dataPosition();
            int _aidl_parcelable_size = _aidl_parcel.readInt();
            if (_aidl_parcelable_size < 4) goto L41;
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L8;
            this.status = _aidl_parcel.readInt();     // Catch: Throwable -> L38
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
            this.fmqConsumed = _aidl_parcel.readInt();     // Catch: Throwable -> L38
            if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L26;
            this.fmqProduced = _aidl_parcel.readInt();     // Catch: Throwable -> L38
            if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L37;
            _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
            return;
        L37:
            throw new BadParcelableException("Overflow in the size of parcelable");
        L26:
            if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L30;
            _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
            return;
        L30:
            throw new BadParcelableException("Overflow in the size of parcelable");
        L17:
            if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L21;
            _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
            return;
        L21:
            throw new BadParcelableException("Overflow in the size of parcelable");
        L8:
            if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L12;
            _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
            return;
        L12:
            throw new BadParcelableException("Overflow in the size of parcelable");
        L41:
            throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L38
        L38:
            th = move-exception;
            if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L45;
            _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
            throw th;
        L45:
            throw new BadParcelableException("Overflow in the size of parcelable");
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements IEffect {
        static final int TRANSACTION_close = 2;
        static final int TRANSACTION_command = 4;
        static final int TRANSACTION_getDescriptor = 3;
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_getParameter = 7;
        static final int TRANSACTION_getState = 5;
        static final int TRANSACTION_open = 1;
        static final int TRANSACTION_setParameter = 6;

        private static class Proxy implements IEffect {
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
                return IEffect.DESCRIPTOR;
            }

            @Override // android.hardware.audio.effect.IEffect
            public OpenEffectReturn open(Parameter.Common common, Parameter.Specific specific) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IEffect.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeTypedObject(common, 0);     // Catch: Throwable -> L8
                _data.writeTypedObject(specific, 0);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(1, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                OpenEffectReturn _result = (OpenEffectReturn) _reply.readTypedObject(OpenEffectReturn.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method open is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.audio.effect.IEffect
            public void close() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IEffect.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(2, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method close is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.audio.effect.IEffect
            public Descriptor getDescriptor() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IEffect.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(3, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                Descriptor _result = (Descriptor) _reply.readTypedObject(Descriptor.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getDescriptor is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.audio.effect.IEffect
            public void command(int commandId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IEffect.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(commandId);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(4, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method command is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.audio.effect.IEffect
            public byte getState() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IEffect.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(5, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                byte _result = _reply.readByte();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getState is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.audio.effect.IEffect
            public void setParameter(Parameter param) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IEffect.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeTypedObject(param, 0);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(6, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method setParameter is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.audio.effect.IEffect
            public Parameter getParameter(Parameter.Id paramId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IEffect.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeTypedObject(paramId, 0);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(7, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                Parameter _result = (Parameter) _reply.readTypedObject(Parameter.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getParameter is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.audio.effect.IEffect
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain(asBinder());
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(IEffect.DESCRIPTOR);     // Catch: Throwable -> L7
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

            @Override // android.hardware.audio.effect.IEffect
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain(asBinder());     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(IEffect.DESCRIPTOR);     // Catch: Throwable -> L10
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
            attachInterface(this, IEffect.DESCRIPTOR);
        }

        public static IEffect asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IEffect.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IEffect) == false) goto L12;
            return (IEffect) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = IEffect.DESCRIPTOR;
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
                case 1: goto L26;
                case 2: goto L25;
                case 3: goto L24;
                case 4: goto L23;
                case 5: goto L22;
                case 6: goto L21;
                case 7: goto L20;
                default: goto L19;
            };
        L20:
            Parameter.Id _arg0 = (Parameter.Id) data.readTypedObject(Parameter.Id.CREATOR);
            data.enforceNoDataAvail();
            Parameter _result = getParameter(_arg0);
            reply.writeNoException();
            reply.writeTypedObject(_result, 1);
        L27:
            return true;
        L21:
            Parameter _arg1 = (Parameter) data.readTypedObject(Parameter.CREATOR);
            data.enforceNoDataAvail();
            setParameter(_arg1);
            reply.writeNoException();
            goto L27
        L22:
            byte _result2 = getState();
            reply.writeNoException();
            reply.writeByte(_result2);
            goto L27
        L23:
            int _arg2 = data.readInt();
            data.enforceNoDataAvail();
            command(_arg2);
            reply.writeNoException();
            goto L27
        L24:
            Descriptor _result3 = getDescriptor();
            reply.writeNoException();
            reply.writeTypedObject(_result3, 1);
            goto L27
        L25:
            close();
            reply.writeNoException();
            goto L27
        L26:
            Parameter.Common _arg3 = (Parameter.Common) data.readTypedObject(Parameter.Common.CREATOR);
            Parameter.Specific _arg4 = (Parameter.Specific) data.readTypedObject(Parameter.Specific.CREATOR);
            data.enforceNoDataAvail();
            OpenEffectReturn _result4 = open(_arg3, _arg4);
            reply.writeNoException();
            reply.writeTypedObject(_result4, 1);
            goto L27
        L19:
            return super.onTransact(code, data, reply, flags);
        }
    }

    void close() throws RemoteException;

    void command(int r1) throws RemoteException;

    Descriptor getDescriptor() throws RemoteException;

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    Parameter getParameter(Parameter.Id r1) throws RemoteException;

    byte getState() throws RemoteException;

    OpenEffectReturn open(Parameter.Common r1, Parameter.Specific r2) throws RemoteException;

    void setParameter(Parameter r1) throws RemoteException;

    static {
        DESCRIPTOR = "android$hardware$audio$effect$IEffect".replace('$', '.');
    }
}
