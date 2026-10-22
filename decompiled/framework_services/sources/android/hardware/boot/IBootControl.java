package android.hardware.boot;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IBootControl extends IInterface {
    public static final int COMMAND_FAILED = -2;
    public static final String DESCRIPTOR = null;
    public static final String HASH = "2400346954240a5de495a1debc81429dd012d7b7";
    public static final int INVALID_SLOT = -1;
    public static final int VERSION = 1;

    public static class Default implements IBootControl {
        public Default() {
        }

        @Override // android.hardware.boot.IBootControl
        public int getActiveBootSlot() throws RemoteException {
            return 0;
        }

        @Override // android.hardware.boot.IBootControl
        public int getCurrentSlot() throws RemoteException {
            return 0;
        }

        @Override // android.hardware.boot.IBootControl
        public int getNumberSlots() throws RemoteException {
            return 0;
        }

        @Override // android.hardware.boot.IBootControl
        public int getSnapshotMergeStatus() throws RemoteException {
            return 0;
        }

        @Override // android.hardware.boot.IBootControl
        public String getSuffix(int slot) throws RemoteException {
            return null;
        }

        @Override // android.hardware.boot.IBootControl
        public boolean isSlotBootable(int slot) throws RemoteException {
            return false;
        }

        @Override // android.hardware.boot.IBootControl
        public boolean isSlotMarkedSuccessful(int slot) throws RemoteException {
            return false;
        }

        @Override // android.hardware.boot.IBootControl
        public void markBootSuccessful() throws RemoteException {
        }

        @Override // android.hardware.boot.IBootControl
        public void setActiveBootSlot(int slot) throws RemoteException {
        }

        @Override // android.hardware.boot.IBootControl
        public void setSlotAsUnbootable(int slot) throws RemoteException {
        }

        @Override // android.hardware.boot.IBootControl
        public void setSnapshotMergeStatus(int status) throws RemoteException {
        }

        @Override // android.hardware.boot.IBootControl
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // android.hardware.boot.IBootControl
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IBootControl {
        static final int TRANSACTION_getActiveBootSlot = 1;
        static final int TRANSACTION_getCurrentSlot = 2;
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_getNumberSlots = 3;
        static final int TRANSACTION_getSnapshotMergeStatus = 4;
        static final int TRANSACTION_getSuffix = 5;
        static final int TRANSACTION_isSlotBootable = 6;
        static final int TRANSACTION_isSlotMarkedSuccessful = 7;
        static final int TRANSACTION_markBootSuccessful = 8;
        static final int TRANSACTION_setActiveBootSlot = 9;
        static final int TRANSACTION_setSlotAsUnbootable = 10;
        static final int TRANSACTION_setSnapshotMergeStatus = 11;

        private static class Proxy implements IBootControl {
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
                return IBootControl.DESCRIPTOR;
            }

            @Override // android.hardware.boot.IBootControl
            public int getActiveBootSlot() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IBootControl.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(1, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                int _result = _reply.readInt();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getActiveBootSlot is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.boot.IBootControl
            public int getCurrentSlot() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IBootControl.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(2, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                int _result = _reply.readInt();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getCurrentSlot is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.boot.IBootControl
            public int getNumberSlots() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IBootControl.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(3, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                int _result = _reply.readInt();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getNumberSlots is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.boot.IBootControl
            public int getSnapshotMergeStatus() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IBootControl.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(4, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                int _result = _reply.readInt();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getSnapshotMergeStatus is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.boot.IBootControl
            public String getSuffix(int slot) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IBootControl.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(slot);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(5, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                String _result = _reply.readString();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getSuffix is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.boot.IBootControl
            public boolean isSlotBootable(int slot) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IBootControl.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(slot);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(6, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method isSlotBootable is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.boot.IBootControl
            public boolean isSlotMarkedSuccessful(int slot) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IBootControl.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(slot);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(7, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method isSlotMarkedSuccessful is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.boot.IBootControl
            public void markBootSuccessful() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IBootControl.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(8, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method markBootSuccessful is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.boot.IBootControl
            public void setActiveBootSlot(int slot) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IBootControl.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(slot);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(9, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method setActiveBootSlot is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.boot.IBootControl
            public void setSlotAsUnbootable(int slot) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IBootControl.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(slot);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(10, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method setSlotAsUnbootable is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.boot.IBootControl
            public void setSnapshotMergeStatus(int status) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IBootControl.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(status);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(11, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method setSnapshotMergeStatus is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.boot.IBootControl
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain(asBinder());
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(IBootControl.DESCRIPTOR);     // Catch: Throwable -> L7
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

            @Override // android.hardware.boot.IBootControl
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain(asBinder());     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(IBootControl.DESCRIPTOR);     // Catch: Throwable -> L10
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
            attachInterface(this, IBootControl.DESCRIPTOR);
        }

        public static IBootControl asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IBootControl.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IBootControl) == false) goto L12;
            return (IBootControl) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = IBootControl.DESCRIPTOR;
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
                case 1: goto L30;
                case 2: goto L29;
                case 3: goto L28;
                case 4: goto L27;
                case 5: goto L26;
                case 6: goto L25;
                case 7: goto L24;
                case 8: goto L23;
                case 9: goto L22;
                case 10: goto L21;
                case 11: goto L20;
                default: goto L19;
            };
        L20:
            int _arg0 = data.readInt();
            data.enforceNoDataAvail();
            setSnapshotMergeStatus(_arg0);
            reply.writeNoException();
        L31:
            return true;
        L21:
            int _arg1 = data.readInt();
            data.enforceNoDataAvail();
            setSlotAsUnbootable(_arg1);
            reply.writeNoException();
            goto L31
        L22:
            int _arg2 = data.readInt();
            data.enforceNoDataAvail();
            setActiveBootSlot(_arg2);
            reply.writeNoException();
            goto L31
        L23:
            markBootSuccessful();
            reply.writeNoException();
            goto L31
        L24:
            int _arg3 = data.readInt();
            data.enforceNoDataAvail();
            boolean _result = isSlotMarkedSuccessful(_arg3);
            reply.writeNoException();
            reply.writeBoolean(_result);
            goto L31
        L25:
            int _arg4 = data.readInt();
            data.enforceNoDataAvail();
            boolean _result2 = isSlotBootable(_arg4);
            reply.writeNoException();
            reply.writeBoolean(_result2);
            goto L31
        L26:
            int _arg5 = data.readInt();
            data.enforceNoDataAvail();
            String _result3 = getSuffix(_arg5);
            reply.writeNoException();
            reply.writeString(_result3);
            goto L31
        L27:
            int _result4 = getSnapshotMergeStatus();
            reply.writeNoException();
            reply.writeInt(_result4);
            goto L31
        L28:
            int _result5 = getNumberSlots();
            reply.writeNoException();
            reply.writeInt(_result5);
            goto L31
        L29:
            int _result6 = getCurrentSlot();
            reply.writeNoException();
            reply.writeInt(_result6);
            goto L31
        L30:
            int _result7 = getActiveBootSlot();
            reply.writeNoException();
            reply.writeInt(_result7);
            goto L31
        L19:
            return super.onTransact(code, data, reply, flags);
        }
    }

    int getActiveBootSlot() throws RemoteException;

    int getCurrentSlot() throws RemoteException;

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    int getNumberSlots() throws RemoteException;

    int getSnapshotMergeStatus() throws RemoteException;

    String getSuffix(int r1) throws RemoteException;

    boolean isSlotBootable(int r1) throws RemoteException;

    boolean isSlotMarkedSuccessful(int r1) throws RemoteException;

    void markBootSuccessful() throws RemoteException;

    void setActiveBootSlot(int r1) throws RemoteException;

    void setSlotAsUnbootable(int r1) throws RemoteException;

    void setSnapshotMergeStatus(int r1) throws RemoteException;

    static {
        DESCRIPTOR = "android$hardware$boot$IBootControl".replace('$', '.');
    }
}
