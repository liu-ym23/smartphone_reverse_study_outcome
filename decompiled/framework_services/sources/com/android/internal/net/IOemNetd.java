package com.android.internal.net;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IOemNetd extends IInterface {
    public static final String DESCRIPTOR = "com.android.internal.net.IOemNetd";

    public static class Default implements IOemNetd {
        public Default() {
        }

        @Override // com.android.internal.net.IOemNetd
        public boolean isAlive() throws RemoteException {
            return false;
        }

        @Override // com.android.internal.net.IOemNetd
        public void registerOemUnsolicitedEventListener(IOemNetdUnsolicitedEventListener listener) throws RemoteException {
        }

        @Override // com.android.internal.net.IOemNetd
        public void bandwidthAddBlockedUid(int uid, String ifName) throws RemoteException {
        }

        @Override // com.android.internal.net.IOemNetd
        public void bandwidthRemoveBlockedUid(int uid, String ifName) throws RemoteException {
        }

        @Override // com.android.internal.net.IOemNetd
        public void bandwidthAddBlockedUidPower(int uid, String ifName) throws RemoteException {
        }

        @Override // com.android.internal.net.IOemNetd
        public void bandwidthRemoveBlockedUidPower(int uid, String ifName) throws RemoteException {
        }

        @Override // com.android.internal.net.IOemNetd
        public void setLinkLayerPreemptionPriority(String ifName, int uid, int level) throws RemoteException {
        }

        @Override // com.android.internal.net.IOemNetd
        public void clearLinkLayerPreemptionPriority(String ifName) throws RemoteException {
        }

        @Override // com.android.internal.net.IOemNetd
        public int getLinkLayerPreemptionPriority(String ifName, int uid) throws RemoteException {
            return 0;
        }

        @Override // com.android.internal.net.IOemNetd
        public void setLinkLayerPreemptionPriorityForProtocol(String ifName, int uid, int level, String protocol) throws RemoteException {
        }

        @Override // com.android.internal.net.IOemNetd
        public int getLinkLayerPreemptionPriorityForProtocol(String ifName, int uid, String protocol) throws RemoteException {
            return 0;
        }

        @Override // com.android.internal.net.IOemNetd
        public void removeLinkLayerPreemptionPriority(String ifName, int uid) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IOemNetd {
        static final int TRANSACTION_bandwidthAddBlockedUid = 3;
        static final int TRANSACTION_bandwidthAddBlockedUidPower = 5;
        static final int TRANSACTION_bandwidthRemoveBlockedUid = 4;
        static final int TRANSACTION_bandwidthRemoveBlockedUidPower = 6;
        static final int TRANSACTION_clearLinkLayerPreemptionPriority = 8;
        static final int TRANSACTION_getLinkLayerPreemptionPriority = 9;
        static final int TRANSACTION_getLinkLayerPreemptionPriorityForProtocol = 11;
        static final int TRANSACTION_isAlive = 1;
        static final int TRANSACTION_registerOemUnsolicitedEventListener = 2;
        static final int TRANSACTION_removeLinkLayerPreemptionPriority = 12;
        static final int TRANSACTION_setLinkLayerPreemptionPriority = 7;
        static final int TRANSACTION_setLinkLayerPreemptionPriorityForProtocol = 10;

        private static class Proxy implements IOemNetd {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IOemNetd.DESCRIPTOR;
            }

            @Override // com.android.internal.net.IOemNetd
            public boolean isAlive() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IOemNetd.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(1, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // com.android.internal.net.IOemNetd
            public void registerOemUnsolicitedEventListener(IOemNetdUnsolicitedEventListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IOemNetd.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeStrongInterface(listener);     // Catch: Throwable -> L6
                this.mRemote.transact(2, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // com.android.internal.net.IOemNetd
            public void bandwidthAddBlockedUid(int uid, String ifName) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IOemNetd.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(uid);     // Catch: Throwable -> L6
                _data.writeString(ifName);     // Catch: Throwable -> L6
                this.mRemote.transact(3, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // com.android.internal.net.IOemNetd
            public void bandwidthRemoveBlockedUid(int uid, String ifName) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IOemNetd.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(uid);     // Catch: Throwable -> L6
                _data.writeString(ifName);     // Catch: Throwable -> L6
                this.mRemote.transact(4, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // com.android.internal.net.IOemNetd
            public void bandwidthAddBlockedUidPower(int uid, String ifName) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IOemNetd.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(uid);     // Catch: Throwable -> L6
                _data.writeString(ifName);     // Catch: Throwable -> L6
                this.mRemote.transact(5, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // com.android.internal.net.IOemNetd
            public void bandwidthRemoveBlockedUidPower(int uid, String ifName) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IOemNetd.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeInt(uid);     // Catch: Throwable -> L6
                _data.writeString(ifName);     // Catch: Throwable -> L6
                this.mRemote.transact(6, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // com.android.internal.net.IOemNetd
            public void setLinkLayerPreemptionPriority(String ifName, int uid, int level) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IOemNetd.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(ifName);     // Catch: Throwable -> L6
                _data.writeInt(uid);     // Catch: Throwable -> L6
                _data.writeInt(level);     // Catch: Throwable -> L6
                this.mRemote.transact(7, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // com.android.internal.net.IOemNetd
            public void clearLinkLayerPreemptionPriority(String ifName) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IOemNetd.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(ifName);     // Catch: Throwable -> L6
                this.mRemote.transact(8, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // com.android.internal.net.IOemNetd
            public int getLinkLayerPreemptionPriority(String ifName, int uid) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IOemNetd.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(ifName);     // Catch: Throwable -> L6
                _data.writeInt(uid);     // Catch: Throwable -> L6
                this.mRemote.transact(9, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                int _result = _reply.readInt();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // com.android.internal.net.IOemNetd
            public void setLinkLayerPreemptionPriorityForProtocol(String ifName, int uid, int level, String protocol) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IOemNetd.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(ifName);     // Catch: Throwable -> L6
                _data.writeInt(uid);     // Catch: Throwable -> L6
                _data.writeInt(level);     // Catch: Throwable -> L6
                _data.writeString(protocol);     // Catch: Throwable -> L6
                this.mRemote.transact(10, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // com.android.internal.net.IOemNetd
            public int getLinkLayerPreemptionPriorityForProtocol(String ifName, int uid, String protocol) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IOemNetd.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(ifName);     // Catch: Throwable -> L6
                _data.writeInt(uid);     // Catch: Throwable -> L6
                _data.writeString(protocol);     // Catch: Throwable -> L6
                this.mRemote.transact(11, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                int _result = _reply.readInt();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // com.android.internal.net.IOemNetd
            public void removeLinkLayerPreemptionPriority(String ifName, int uid) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IOemNetd.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(ifName);     // Catch: Throwable -> L6
                _data.writeInt(uid);     // Catch: Throwable -> L6
                this.mRemote.transact(12, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, IOemNetd.DESCRIPTOR);
        }

        public static IOemNetd asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IOemNetd.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IOemNetd) == false) goto L12;
            return (IOemNetd) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code < 1) goto L8;
            if (code > 16777215) goto L8;
            data.enforceInterface(IOemNetd.DESCRIPTOR);
        L8:
            if (code != 1598968902) goto L11;
            reply.writeString(IOemNetd.DESCRIPTOR);
            return true;
        L11:
            switch(code) {
                case 1: goto L25;
                case 2: goto L24;
                case 3: goto L23;
                case 4: goto L22;
                case 5: goto L21;
                case 6: goto L20;
                case 7: goto L19;
                case 8: goto L18;
                case 9: goto L17;
                case 10: goto L16;
                case 11: goto L15;
                case 12: goto L14;
                default: goto L13;
            };
        L14:
            String _arg0 = data.readString();
            int _arg1 = data.readInt();
            data.enforceNoDataAvail();
            removeLinkLayerPreemptionPriority(_arg0, _arg1);
            reply.writeNoException();
        L26:
            return true;
        L15:
            String _arg2 = data.readString();
            int _arg3 = data.readInt();
            String _arg4 = data.readString();
            data.enforceNoDataAvail();
            int _result = getLinkLayerPreemptionPriorityForProtocol(_arg2, _arg3, _arg4);
            reply.writeNoException();
            reply.writeInt(_result);
            goto L26
        L16:
            String _arg5 = data.readString();
            int _arg6 = data.readInt();
            int _arg7 = data.readInt();
            String _arg8 = data.readString();
            data.enforceNoDataAvail();
            setLinkLayerPreemptionPriorityForProtocol(_arg5, _arg6, _arg7, _arg8);
            reply.writeNoException();
            goto L26
        L17:
            String _arg9 = data.readString();
            int _arg10 = data.readInt();
            data.enforceNoDataAvail();
            int _result2 = getLinkLayerPreemptionPriority(_arg9, _arg10);
            reply.writeNoException();
            reply.writeInt(_result2);
            goto L26
        L18:
            String _arg11 = data.readString();
            data.enforceNoDataAvail();
            clearLinkLayerPreemptionPriority(_arg11);
            reply.writeNoException();
            goto L26
        L19:
            String _arg12 = data.readString();
            int _arg13 = data.readInt();
            int _arg14 = data.readInt();
            data.enforceNoDataAvail();
            setLinkLayerPreemptionPriority(_arg12, _arg13, _arg14);
            reply.writeNoException();
            goto L26
        L20:
            int _arg15 = data.readInt();
            String _arg16 = data.readString();
            data.enforceNoDataAvail();
            bandwidthRemoveBlockedUidPower(_arg15, _arg16);
            reply.writeNoException();
            goto L26
        L21:
            int _arg17 = data.readInt();
            String _arg18 = data.readString();
            data.enforceNoDataAvail();
            bandwidthAddBlockedUidPower(_arg17, _arg18);
            reply.writeNoException();
            goto L26
        L22:
            int _arg19 = data.readInt();
            String _arg20 = data.readString();
            data.enforceNoDataAvail();
            bandwidthRemoveBlockedUid(_arg19, _arg20);
            reply.writeNoException();
            goto L26
        L23:
            int _arg21 = data.readInt();
            String _arg22 = data.readString();
            data.enforceNoDataAvail();
            bandwidthAddBlockedUid(_arg21, _arg22);
            reply.writeNoException();
            goto L26
        L24:
            IOemNetdUnsolicitedEventListener _arg23 = IOemNetdUnsolicitedEventListener.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            registerOemUnsolicitedEventListener(_arg23);
            reply.writeNoException();
            goto L26
        L25:
            boolean _result3 = isAlive();
            reply.writeNoException();
            reply.writeBoolean(_result3);
            goto L26
        L13:
            return super.onTransact(code, data, reply, flags);
        }
    }

    void bandwidthAddBlockedUid(int r1, String r2) throws RemoteException;

    void bandwidthAddBlockedUidPower(int r1, String r2) throws RemoteException;

    void bandwidthRemoveBlockedUid(int r1, String r2) throws RemoteException;

    void bandwidthRemoveBlockedUidPower(int r1, String r2) throws RemoteException;

    void clearLinkLayerPreemptionPriority(String r1) throws RemoteException;

    int getLinkLayerPreemptionPriority(String r1, int r2) throws RemoteException;

    int getLinkLayerPreemptionPriorityForProtocol(String r1, int r2, String r3) throws RemoteException;

    boolean isAlive() throws RemoteException;

    void registerOemUnsolicitedEventListener(IOemNetdUnsolicitedEventListener r1) throws RemoteException;

    void removeLinkLayerPreemptionPriority(String r1, int r2) throws RemoteException;

    void setLinkLayerPreemptionPriority(String r1, int r2, int r3) throws RemoteException;

    void setLinkLayerPreemptionPriorityForProtocol(String r1, int r2, int r3, String r4) throws RemoteException;
}
