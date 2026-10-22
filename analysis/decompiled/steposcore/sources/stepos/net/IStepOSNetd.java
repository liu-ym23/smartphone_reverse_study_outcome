package stepos.net;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import stepos.net.IStepOSNetdUnsolicitedEventListener;

/* loaded from: classes.dex */
public interface IStepOSNetd extends IInterface {
    public static final String DESCRIPTOR = "stepos.net.IStepOSNetd";

    boolean addHostNames(String str, String str2) throws RemoteException;

    boolean enableQuickAppRulse(boolean z, String str) throws RemoteException;

    String[] executeShellToSetIptables(String str, String str2) throws RemoteException;

    String[] getHostNames() throws RemoteException;

    String[] getIptableRules(String str, String str2) throws RemoteException;

    boolean ipfwdAddVpnInterfaceForward(String str, String str2) throws RemoteException;

    boolean ipfwdRemoveVpnInterfaceForward(String str, String str2) throws RemoteException;

    boolean isAlive() throws RemoteException;

    void onFreezeUidPktState(int i, int i2) throws RemoteException;

    void registerStepOSUnsolicitedEventListener(IStepOSNetdUnsolicitedEventListener iStepOSNetdUnsolicitedEventListener) throws RemoteException;

    void resetHosts() throws RemoteException;

    String[] runIpCounterCommand(String[] strArr) throws RemoteException;

    void setFirewallUidChainRule(int i, String str, String str2) throws RemoteException;

    boolean setMobileNetworkForApp(int i, int i2, boolean z) throws RemoteException;

    boolean setVpnNetworkForApp(int i, int i2, boolean z) throws RemoteException;

    public static class Default implements IStepOSNetd {
        @Override // stepos.net.IStepOSNetd
        public boolean isAlive() throws RemoteException {
            return false;
        }

        @Override // stepos.net.IStepOSNetd
        public void registerStepOSUnsolicitedEventListener(IStepOSNetdUnsolicitedEventListener listener) throws RemoteException {
        }

        @Override // stepos.net.IStepOSNetd
        public String[] getHostNames() throws RemoteException {
            return null;
        }

        @Override // stepos.net.IStepOSNetd
        public boolean addHostNames(String ipAddr, String hostName) throws RemoteException {
            return false;
        }

        @Override // stepos.net.IStepOSNetd
        public void resetHosts() throws RemoteException {
        }

        @Override // stepos.net.IStepOSNetd
        public boolean enableQuickAppRulse(boolean enable, String port) throws RemoteException {
            return false;
        }

        @Override // stepos.net.IStepOSNetd
        public String[] getIptableRules(String table, String chain) throws RemoteException {
            return null;
        }

        @Override // stepos.net.IStepOSNetd
        public String[] executeShellToSetIptables(String table, String cmd) throws RemoteException {
            return null;
        }

        @Override // stepos.net.IStepOSNetd
        public String[] runIpCounterCommand(String[] arguments) throws RemoteException {
            return null;
        }

        @Override // stepos.net.IStepOSNetd
        public boolean ipfwdAddVpnInterfaceForward(String fromIface, String toIface) throws RemoteException {
            return false;
        }

        @Override // stepos.net.IStepOSNetd
        public boolean ipfwdRemoveVpnInterfaceForward(String fromIface, String toIface) throws RemoteException {
            return false;
        }

        @Override // stepos.net.IStepOSNetd
        public boolean setVpnNetworkForApp(int uid, int netId, boolean enable) throws RemoteException {
            return false;
        }

        @Override // stepos.net.IStepOSNetd
        public boolean setMobileNetworkForApp(int uid, int netId, boolean enable) throws RemoteException {
            return false;
        }

        @Override // stepos.net.IStepOSNetd
        public void setFirewallUidChainRule(int uid, String chain, String rule) throws RemoteException {
        }

        @Override // stepos.net.IStepOSNetd
        public void onFreezeUidPktState(int uid, int pkt_state) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IStepOSNetd {
        static final int TRANSACTION_addHostNames = 4;
        static final int TRANSACTION_enableQuickAppRulse = 6;
        static final int TRANSACTION_executeShellToSetIptables = 8;
        static final int TRANSACTION_getHostNames = 3;
        static final int TRANSACTION_getIptableRules = 7;
        static final int TRANSACTION_ipfwdAddVpnInterfaceForward = 10;
        static final int TRANSACTION_ipfwdRemoveVpnInterfaceForward = 11;
        static final int TRANSACTION_isAlive = 1;
        static final int TRANSACTION_onFreezeUidPktState = 15;
        static final int TRANSACTION_registerStepOSUnsolicitedEventListener = 2;
        static final int TRANSACTION_resetHosts = 5;
        static final int TRANSACTION_runIpCounterCommand = 9;
        static final int TRANSACTION_setFirewallUidChainRule = 14;
        static final int TRANSACTION_setMobileNetworkForApp = 13;
        static final int TRANSACTION_setVpnNetworkForApp = 12;

        public Stub() {
            attachInterface(this, IStepOSNetd.DESCRIPTOR);
        }

        public static IStepOSNetd asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IStepOSNetd.DESCRIPTOR);
            if (iin != null && (iin instanceof IStepOSNetd)) {
                return (IStepOSNetd) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch (transactionCode) {
                case 1:
                    return "isAlive";
                case 2:
                    return "registerStepOSUnsolicitedEventListener";
                case 3:
                    return "getHostNames";
                case 4:
                    return "addHostNames";
                case 5:
                    return "resetHosts";
                case 6:
                    return "enableQuickAppRulse";
                case 7:
                    return "getIptableRules";
                case 8:
                    return "executeShellToSetIptables";
                case 9:
                    return "runIpCounterCommand";
                case 10:
                    return "ipfwdAddVpnInterfaceForward";
                case 11:
                    return "ipfwdRemoveVpnInterfaceForward";
                case 12:
                    return "setVpnNetworkForApp";
                case 13:
                    return "setMobileNetworkForApp";
                case 14:
                    return "setFirewallUidChainRule";
                case 15:
                    return "onFreezeUidPktState";
                default:
                    return null;
            }
        }

        public String getTransactionName(int transactionCode) {
            return getDefaultTransactionName(transactionCode);
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code >= 1 && code <= 16777215) {
                data.enforceInterface(IStepOSNetd.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IStepOSNetd.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    boolean _result = isAlive();
                    reply.writeNoException();
                    reply.writeBoolean(_result);
                    return true;
                case 2:
                    IStepOSNetdUnsolicitedEventListener _arg0 = IStepOSNetdUnsolicitedEventListener.Stub.asInterface(data.readStrongBinder());
                    registerStepOSUnsolicitedEventListener(_arg0);
                    return true;
                case 3:
                    String[] _result2 = getHostNames();
                    reply.writeNoException();
                    reply.writeStringArray(_result2);
                    return true;
                case 4:
                    String _arg02 = data.readString();
                    String _arg1 = data.readString();
                    boolean _result3 = addHostNames(_arg02, _arg1);
                    reply.writeNoException();
                    reply.writeBoolean(_result3);
                    return true;
                case 5:
                    resetHosts();
                    return true;
                case 6:
                    boolean _arg03 = data.readBoolean();
                    String _arg12 = data.readString();
                    boolean _result4 = enableQuickAppRulse(_arg03, _arg12);
                    reply.writeNoException();
                    reply.writeBoolean(_result4);
                    return true;
                case 7:
                    String _arg04 = data.readString();
                    String _arg13 = data.readString();
                    String[] _result5 = getIptableRules(_arg04, _arg13);
                    reply.writeNoException();
                    reply.writeStringArray(_result5);
                    return true;
                case 8:
                    String _arg05 = data.readString();
                    String _arg14 = data.readString();
                    String[] _result6 = executeShellToSetIptables(_arg05, _arg14);
                    reply.writeNoException();
                    reply.writeStringArray(_result6);
                    return true;
                case 9:
                    String[] _arg06 = data.createStringArray();
                    String[] _result7 = runIpCounterCommand(_arg06);
                    reply.writeNoException();
                    reply.writeStringArray(_result7);
                    return true;
                case 10:
                    String _arg07 = data.readString();
                    String _arg15 = data.readString();
                    boolean _result8 = ipfwdAddVpnInterfaceForward(_arg07, _arg15);
                    reply.writeNoException();
                    reply.writeBoolean(_result8);
                    return true;
                case 11:
                    String _arg08 = data.readString();
                    String _arg16 = data.readString();
                    boolean _result9 = ipfwdRemoveVpnInterfaceForward(_arg08, _arg16);
                    reply.writeNoException();
                    reply.writeBoolean(_result9);
                    return true;
                case 12:
                    int _arg09 = data.readInt();
                    int _arg17 = data.readInt();
                    boolean _arg2 = data.readBoolean();
                    boolean _result10 = setVpnNetworkForApp(_arg09, _arg17, _arg2);
                    reply.writeNoException();
                    reply.writeBoolean(_result10);
                    return true;
                case 13:
                    int _arg010 = data.readInt();
                    int _arg18 = data.readInt();
                    boolean _arg22 = data.readBoolean();
                    boolean _result11 = setMobileNetworkForApp(_arg010, _arg18, _arg22);
                    reply.writeNoException();
                    reply.writeBoolean(_result11);
                    return true;
                case 14:
                    int _arg011 = data.readInt();
                    String _arg19 = data.readString();
                    String _arg23 = data.readString();
                    setFirewallUidChainRule(_arg011, _arg19, _arg23);
                    return true;
                case 15:
                    int _arg012 = data.readInt();
                    int _arg110 = data.readInt();
                    onFreezeUidPktState(_arg012, _arg110);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IStepOSNetd {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStepOSNetd.DESCRIPTOR;
            }

            @Override // stepos.net.IStepOSNetd
            public boolean isAlive() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSNetd.DESCRIPTOR);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.net.IStepOSNetd
            public void registerStepOSUnsolicitedEventListener(IStepOSNetdUnsolicitedEventListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSNetd.DESCRIPTOR);
                    _data.writeStrongInterface(listener);
                    this.mRemote.transact(2, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.net.IStepOSNetd
            public String[] getHostNames() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSNetd.DESCRIPTOR);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                    String[] _result = _reply.createStringArray();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.net.IStepOSNetd
            public boolean addHostNames(String ipAddr, String hostName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSNetd.DESCRIPTOR);
                    _data.writeString(ipAddr);
                    _data.writeString(hostName);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.net.IStepOSNetd
            public void resetHosts() throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSNetd.DESCRIPTOR);
                    this.mRemote.transact(5, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.net.IStepOSNetd
            public boolean enableQuickAppRulse(boolean enable, String port) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSNetd.DESCRIPTOR);
                    _data.writeBoolean(enable);
                    _data.writeString(port);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.net.IStepOSNetd
            public String[] getIptableRules(String table, String chain) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSNetd.DESCRIPTOR);
                    _data.writeString(table);
                    _data.writeString(chain);
                    this.mRemote.transact(7, _data, _reply, 0);
                    _reply.readException();
                    String[] _result = _reply.createStringArray();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.net.IStepOSNetd
            public String[] executeShellToSetIptables(String table, String cmd) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSNetd.DESCRIPTOR);
                    _data.writeString(table);
                    _data.writeString(cmd);
                    this.mRemote.transact(8, _data, _reply, 0);
                    _reply.readException();
                    String[] _result = _reply.createStringArray();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.net.IStepOSNetd
            public String[] runIpCounterCommand(String[] arguments) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSNetd.DESCRIPTOR);
                    _data.writeStringArray(arguments);
                    this.mRemote.transact(9, _data, _reply, 0);
                    _reply.readException();
                    String[] _result = _reply.createStringArray();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.net.IStepOSNetd
            public boolean ipfwdAddVpnInterfaceForward(String fromIface, String toIface) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSNetd.DESCRIPTOR);
                    _data.writeString(fromIface);
                    _data.writeString(toIface);
                    this.mRemote.transact(10, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.net.IStepOSNetd
            public boolean ipfwdRemoveVpnInterfaceForward(String fromIface, String toIface) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSNetd.DESCRIPTOR);
                    _data.writeString(fromIface);
                    _data.writeString(toIface);
                    this.mRemote.transact(11, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.net.IStepOSNetd
            public boolean setVpnNetworkForApp(int uid, int netId, boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSNetd.DESCRIPTOR);
                    _data.writeInt(uid);
                    _data.writeInt(netId);
                    _data.writeBoolean(enable);
                    this.mRemote.transact(12, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.net.IStepOSNetd
            public boolean setMobileNetworkForApp(int uid, int netId, boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSNetd.DESCRIPTOR);
                    _data.writeInt(uid);
                    _data.writeInt(netId);
                    _data.writeBoolean(enable);
                    this.mRemote.transact(13, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.net.IStepOSNetd
            public void setFirewallUidChainRule(int uid, String chain, String rule) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSNetd.DESCRIPTOR);
                    _data.writeInt(uid);
                    _data.writeString(chain);
                    _data.writeString(rule);
                    this.mRemote.transact(14, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.net.IStepOSNetd
            public void onFreezeUidPktState(int uid, int pkt_state) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSNetd.DESCRIPTOR);
                    _data.writeInt(uid);
                    _data.writeInt(pkt_state);
                    this.mRemote.transact(15, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 14;
        }
    }
}
