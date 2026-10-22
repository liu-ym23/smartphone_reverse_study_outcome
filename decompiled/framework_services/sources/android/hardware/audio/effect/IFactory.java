package android.hardware.audio.effect;

import android.media.audio.common.AudioUuid;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IFactory extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "34b618a587cb9977ee0cd13b173e699d2dcdb320";
    public static final int VERSION = 1;

    public static class Default implements IFactory {
        public Default() {
        }

        @Override // android.hardware.audio.effect.IFactory
        public Descriptor[] queryEffects(AudioUuid type, AudioUuid implementation, AudioUuid proxy) throws RemoteException {
            return null;
        }

        @Override // android.hardware.audio.effect.IFactory
        public Processing[] queryProcessing(Processing.Type type) throws RemoteException {
            return null;
        }

        @Override // android.hardware.audio.effect.IFactory
        public IEffect createEffect(AudioUuid implUuid) throws RemoteException {
            return null;
        }

        @Override // android.hardware.audio.effect.IFactory
        public void destroyEffect(IEffect handle) throws RemoteException {
        }

        @Override // android.hardware.audio.effect.IFactory
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // android.hardware.audio.effect.IFactory
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IFactory {
        static final int TRANSACTION_createEffect = 3;
        static final int TRANSACTION_destroyEffect = 4;
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_queryEffects = 1;
        static final int TRANSACTION_queryProcessing = 2;

        private static class Proxy implements IFactory {
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
                return IFactory.DESCRIPTOR;
            }

            @Override // android.hardware.audio.effect.IFactory
            public Descriptor[] queryEffects(AudioUuid type, AudioUuid implementation, AudioUuid proxy) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IFactory.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeTypedObject(type, 0);     // Catch: Throwable -> L8
                _data.writeTypedObject(implementation, 0);     // Catch: Throwable -> L8
                _data.writeTypedObject(proxy, 0);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(1, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                Descriptor[] _result = (Descriptor[]) _reply.createTypedArray(Descriptor.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method queryEffects is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.audio.effect.IFactory
            public Processing[] queryProcessing(Processing.Type type) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IFactory.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeTypedObject(type, 0);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(2, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                Processing[] _result = (Processing[]) _reply.createTypedArray(Processing.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method queryProcessing is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.audio.effect.IFactory
            public IEffect createEffect(AudioUuid implUuid) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IFactory.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeTypedObject(implUuid, 0);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(3, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                IEffect _result = IEffect.Stub.asInterface(_reply.readStrongBinder());     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method createEffect is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.audio.effect.IFactory
            public void destroyEffect(IEffect handle) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IFactory.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeStrongInterface(handle);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(4, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method destroyEffect is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.audio.effect.IFactory
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain(asBinder());
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(IFactory.DESCRIPTOR);     // Catch: Throwable -> L7
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

            @Override // android.hardware.audio.effect.IFactory
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain(asBinder());     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(IFactory.DESCRIPTOR);     // Catch: Throwable -> L10
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
            attachInterface(this, IFactory.DESCRIPTOR);
        }

        public static IFactory asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IFactory.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IFactory) == false) goto L12;
            return (IFactory) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = IFactory.DESCRIPTOR;
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
            IEffect _arg0 = IEffect.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            destroyEffect(_arg0);
            reply.writeNoException();
        L24:
            return true;
        L21:
            AudioUuid _arg1 = (AudioUuid) data.readTypedObject(AudioUuid.CREATOR);
            data.enforceNoDataAvail();
            IEffect _result = createEffect(_arg1);
            reply.writeNoException();
            reply.writeStrongInterface(_result);
            goto L24
        L22:
            Processing.Type _arg2 = (Processing.Type) data.readTypedObject(Processing.Type.CREATOR);
            data.enforceNoDataAvail();
            Processing[] _result2 = queryProcessing(_arg2);
            reply.writeNoException();
            reply.writeTypedArray(_result2, 1);
            goto L24
        L23:
            AudioUuid _arg3 = (AudioUuid) data.readTypedObject(AudioUuid.CREATOR);
            AudioUuid _arg4 = (AudioUuid) data.readTypedObject(AudioUuid.CREATOR);
            AudioUuid _arg5 = (AudioUuid) data.readTypedObject(AudioUuid.CREATOR);
            data.enforceNoDataAvail();
            Descriptor[] _result3 = queryEffects(_arg3, _arg4, _arg5);
            reply.writeNoException();
            reply.writeTypedArray(_result3, 1);
            goto L24
        L19:
            return super.onTransact(code, data, reply, flags);
        }
    }

    IEffect createEffect(AudioUuid r1) throws RemoteException;

    void destroyEffect(IEffect r1) throws RemoteException;

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    Descriptor[] queryEffects(AudioUuid r1, AudioUuid r2, AudioUuid r3) throws RemoteException;

    Processing[] queryProcessing(Processing.Type r1) throws RemoteException;

    static {
        DESCRIPTOR = "android$hardware$audio$effect$IFactory".replace('$', '.');
    }
}
