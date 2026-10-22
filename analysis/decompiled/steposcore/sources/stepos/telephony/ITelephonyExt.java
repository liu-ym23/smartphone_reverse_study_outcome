package stepos.telephony;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.telephony.CellIdentity;
import android.telephony.CellInfo;
import android.telephony.ServiceState;
import com.android.internal.telephony.OperatorInfo;
import java.util.List;
import stepos.telephony.IStepOSAsyncCallback;

/* loaded from: classes.dex */
public interface ITelephonyExt extends IInterface {
    public static final String DESCRIPTOR = "stepos.telephony.ITelephonyExt";

    boolean canSaveAdn(int i) throws RemoteException;

    void cancelMissedRecordsNotification() throws RemoteException;

    boolean changeIccLockPasswordBySlotId(String str, String str2, int i) throws RemoteException;

    int get5GMode(int i) throws RemoteException;

    List<CellInfo> getAllCellInfo(int i) throws RemoteException;

    CellIdentity getCellLocation(int i) throws RemoteException;

    Bundle getFromFramework(String str, Bundle bundle) throws RemoteException;

    boolean getIccLockEnabledBySlotId(int i) throws RemoteException;

    String getOperator(String str, String str2, String str3) throws RemoteException;

    String getScAddress(int i) throws RemoteException;

    ServiceState getServiceState() throws RemoteException;

    ServiceState getServiceStateBySlot(int i) throws RemoteException;

    boolean selectNetworkManually(OperatorInfo operatorInfo) throws RemoteException;

    void sendAsyncRequest(String str, Bundle bundle, IStepOSAsyncCallback iStepOSAsyncCallback) throws RemoteException;

    void sendToFramework(String str, Bundle bundle) throws RemoteException;

    void set5GMode(int i, int i2) throws RemoteException;

    void setDataRoamingEnabled(boolean z, int i) throws RemoteException;

    boolean setIccLockEnabledBySlotId(boolean z, String str, int i) throws RemoteException;

    boolean setNetworkSelectionModeAutomaticBySlotId(int i) throws RemoteException;

    void setScAddress(String str, int i) throws RemoteException;

    boolean setVoiceMailNumber(String str, int i) throws RemoteException;

    void updateMobileDataAlwaysOnSwitch(boolean z) throws RemoteException;

    void updatePayProtectOnSwitch(boolean z) throws RemoteException;

    int updateSafePayByPackage(String str, boolean z) throws RemoteException;

    int updateSafePaySetting(boolean z) throws RemoteException;

    public static class Default implements ITelephonyExt {
        @Override // stepos.telephony.ITelephonyExt
        public void cancelMissedRecordsNotification() throws RemoteException {
        }

        @Override // stepos.telephony.ITelephonyExt
        public boolean setVoiceMailNumber(String num, int slotId) throws RemoteException {
            return false;
        }

        @Override // stepos.telephony.ITelephonyExt
        public boolean selectNetworkManually(OperatorInfo network) throws RemoteException {
            return false;
        }

        @Override // stepos.telephony.ITelephonyExt
        public ServiceState getServiceState() throws RemoteException {
            return null;
        }

        @Override // stepos.telephony.ITelephonyExt
        public ServiceState getServiceStateBySlot(int slotId) throws RemoteException {
            return null;
        }

        @Override // stepos.telephony.ITelephonyExt
        public String getScAddress(int slotId) throws RemoteException {
            return null;
        }

        @Override // stepos.telephony.ITelephonyExt
        public void setScAddress(String address, int slotId) throws RemoteException {
        }

        @Override // stepos.telephony.ITelephonyExt
        public boolean getIccLockEnabledBySlotId(int slotId) throws RemoteException {
            return false;
        }

        @Override // stepos.telephony.ITelephonyExt
        public boolean setIccLockEnabledBySlotId(boolean enabled, String password, int slotId) throws RemoteException {
            return false;
        }

        @Override // stepos.telephony.ITelephonyExt
        public boolean changeIccLockPasswordBySlotId(String oldPassword, String newPassword, int slotId) throws RemoteException {
            return false;
        }

        @Override // stepos.telephony.ITelephonyExt
        public boolean setNetworkSelectionModeAutomaticBySlotId(int slotId) throws RemoteException {
            return false;
        }

        @Override // stepos.telephony.ITelephonyExt
        public CellIdentity getCellLocation(int slotId) throws RemoteException {
            return null;
        }

        @Override // stepos.telephony.ITelephonyExt
        public int updateSafePaySetting(boolean enable) throws RemoteException {
            return 0;
        }

        @Override // stepos.telephony.ITelephonyExt
        public int updateSafePayByPackage(String packageName, boolean install) throws RemoteException {
            return 0;
        }

        @Override // stepos.telephony.ITelephonyExt
        public void updateMobileDataAlwaysOnSwitch(boolean changed) throws RemoteException {
        }

        @Override // stepos.telephony.ITelephonyExt
        public void updatePayProtectOnSwitch(boolean changed) throws RemoteException {
        }

        @Override // stepos.telephony.ITelephonyExt
        public boolean canSaveAdn(int subId) throws RemoteException {
            return false;
        }

        @Override // stepos.telephony.ITelephonyExt
        public List<CellInfo> getAllCellInfo(int slotId) throws RemoteException {
            return null;
        }

        @Override // stepos.telephony.ITelephonyExt
        public String getOperator(String numeric, String language, String nameType) throws RemoteException {
            return null;
        }

        @Override // stepos.telephony.ITelephonyExt
        public void sendToFramework(String req, Bundle msg) throws RemoteException {
        }

        @Override // stepos.telephony.ITelephonyExt
        public Bundle getFromFramework(String req, Bundle inMsg) throws RemoteException {
            return null;
        }

        @Override // stepos.telephony.ITelephonyExt
        public void sendAsyncRequest(String req, Bundle params, IStepOSAsyncCallback cb) throws RemoteException {
        }

        @Override // stepos.telephony.ITelephonyExt
        public void setDataRoamingEnabled(boolean enabled, int slotId) throws RemoteException {
        }

        @Override // stepos.telephony.ITelephonyExt
        public void set5GMode(int mode, int slotId) throws RemoteException {
        }

        @Override // stepos.telephony.ITelephonyExt
        public int get5GMode(int slotId) throws RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ITelephonyExt {
        static final int TRANSACTION_canSaveAdn = 17;
        static final int TRANSACTION_cancelMissedRecordsNotification = 1;
        static final int TRANSACTION_changeIccLockPasswordBySlotId = 10;
        static final int TRANSACTION_get5GMode = 25;
        static final int TRANSACTION_getAllCellInfo = 18;
        static final int TRANSACTION_getCellLocation = 12;
        static final int TRANSACTION_getFromFramework = 21;
        static final int TRANSACTION_getIccLockEnabledBySlotId = 8;
        static final int TRANSACTION_getOperator = 19;
        static final int TRANSACTION_getScAddress = 6;
        static final int TRANSACTION_getServiceState = 4;
        static final int TRANSACTION_getServiceStateBySlot = 5;
        static final int TRANSACTION_selectNetworkManually = 3;
        static final int TRANSACTION_sendAsyncRequest = 22;
        static final int TRANSACTION_sendToFramework = 20;
        static final int TRANSACTION_set5GMode = 24;
        static final int TRANSACTION_setDataRoamingEnabled = 23;
        static final int TRANSACTION_setIccLockEnabledBySlotId = 9;
        static final int TRANSACTION_setNetworkSelectionModeAutomaticBySlotId = 11;
        static final int TRANSACTION_setScAddress = 7;
        static final int TRANSACTION_setVoiceMailNumber = 2;
        static final int TRANSACTION_updateMobileDataAlwaysOnSwitch = 15;
        static final int TRANSACTION_updatePayProtectOnSwitch = 16;
        static final int TRANSACTION_updateSafePayByPackage = 14;
        static final int TRANSACTION_updateSafePaySetting = 13;

        public Stub() {
            attachInterface(this, ITelephonyExt.DESCRIPTOR);
        }

        public static ITelephonyExt asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(ITelephonyExt.DESCRIPTOR);
            if (iin != null && (iin instanceof ITelephonyExt)) {
                return (ITelephonyExt) iin;
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
                    return "cancelMissedRecordsNotification";
                case 2:
                    return "setVoiceMailNumber";
                case 3:
                    return "selectNetworkManually";
                case 4:
                    return "getServiceState";
                case 5:
                    return "getServiceStateBySlot";
                case 6:
                    return "getScAddress";
                case 7:
                    return "setScAddress";
                case 8:
                    return "getIccLockEnabledBySlotId";
                case 9:
                    return "setIccLockEnabledBySlotId";
                case 10:
                    return "changeIccLockPasswordBySlotId";
                case 11:
                    return "setNetworkSelectionModeAutomaticBySlotId";
                case 12:
                    return "getCellLocation";
                case 13:
                    return "updateSafePaySetting";
                case 14:
                    return "updateSafePayByPackage";
                case 15:
                    return "updateMobileDataAlwaysOnSwitch";
                case 16:
                    return "updatePayProtectOnSwitch";
                case 17:
                    return "canSaveAdn";
                case 18:
                    return "getAllCellInfo";
                case 19:
                    return "getOperator";
                case 20:
                    return "sendToFramework";
                case 21:
                    return "getFromFramework";
                case 22:
                    return "sendAsyncRequest";
                case 23:
                    return "setDataRoamingEnabled";
                case 24:
                    return "set5GMode";
                case 25:
                    return "get5GMode";
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
                data.enforceInterface(ITelephonyExt.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(ITelephonyExt.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    cancelMissedRecordsNotification();
                    return true;
                case 2:
                    String _arg0 = data.readString();
                    int _arg1 = data.readInt();
                    boolean _result = setVoiceMailNumber(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeBoolean(_result);
                    return true;
                case 3:
                    OperatorInfo _arg02 = (OperatorInfo) data.readTypedObject(OperatorInfo.CREATOR);
                    boolean _result2 = selectNetworkManually(_arg02);
                    reply.writeNoException();
                    reply.writeBoolean(_result2);
                    return true;
                case 4:
                    ServiceState _result3 = getServiceState();
                    reply.writeNoException();
                    reply.writeTypedObject(_result3, 1);
                    return true;
                case 5:
                    int _arg03 = data.readInt();
                    ServiceState _result4 = getServiceStateBySlot(_arg03);
                    reply.writeNoException();
                    reply.writeTypedObject(_result4, 1);
                    return true;
                case 6:
                    int _arg04 = data.readInt();
                    String _result5 = getScAddress(_arg04);
                    reply.writeNoException();
                    reply.writeString(_result5);
                    return true;
                case 7:
                    String _arg05 = data.readString();
                    int _arg12 = data.readInt();
                    setScAddress(_arg05, _arg12);
                    return true;
                case 8:
                    int _arg06 = data.readInt();
                    boolean _result6 = getIccLockEnabledBySlotId(_arg06);
                    reply.writeNoException();
                    reply.writeBoolean(_result6);
                    return true;
                case 9:
                    boolean _arg07 = data.readBoolean();
                    String _arg13 = data.readString();
                    int _arg2 = data.readInt();
                    boolean _result7 = setIccLockEnabledBySlotId(_arg07, _arg13, _arg2);
                    reply.writeNoException();
                    reply.writeBoolean(_result7);
                    return true;
                case 10:
                    String _arg08 = data.readString();
                    String _arg14 = data.readString();
                    int _arg22 = data.readInt();
                    boolean _result8 = changeIccLockPasswordBySlotId(_arg08, _arg14, _arg22);
                    reply.writeNoException();
                    reply.writeBoolean(_result8);
                    return true;
                case 11:
                    int _arg09 = data.readInt();
                    boolean _result9 = setNetworkSelectionModeAutomaticBySlotId(_arg09);
                    reply.writeNoException();
                    reply.writeBoolean(_result9);
                    return true;
                case 12:
                    int _arg010 = data.readInt();
                    CellIdentity _result10 = getCellLocation(_arg010);
                    reply.writeNoException();
                    reply.writeTypedObject(_result10, 1);
                    return true;
                case 13:
                    boolean _arg011 = data.readBoolean();
                    int _result11 = updateSafePaySetting(_arg011);
                    reply.writeNoException();
                    reply.writeInt(_result11);
                    return true;
                case 14:
                    String _arg012 = data.readString();
                    boolean _arg15 = data.readBoolean();
                    int _result12 = updateSafePayByPackage(_arg012, _arg15);
                    reply.writeNoException();
                    reply.writeInt(_result12);
                    return true;
                case 15:
                    boolean _arg013 = data.readBoolean();
                    updateMobileDataAlwaysOnSwitch(_arg013);
                    return true;
                case 16:
                    boolean _arg014 = data.readBoolean();
                    updatePayProtectOnSwitch(_arg014);
                    return true;
                case 17:
                    int _arg015 = data.readInt();
                    boolean _result13 = canSaveAdn(_arg015);
                    reply.writeNoException();
                    reply.writeBoolean(_result13);
                    return true;
                case 18:
                    int _arg016 = data.readInt();
                    List<CellInfo> _result14 = getAllCellInfo(_arg016);
                    reply.writeNoException();
                    _Parcel.writeTypedList(reply, _result14, 1);
                    return true;
                case 19:
                    String _arg017 = data.readString();
                    String _arg16 = data.readString();
                    String _arg23 = data.readString();
                    String _result15 = getOperator(_arg017, _arg16, _arg23);
                    reply.writeNoException();
                    reply.writeString(_result15);
                    return true;
                case 20:
                    String _arg018 = data.readString();
                    Bundle _arg17 = (Bundle) data.readTypedObject(Bundle.CREATOR);
                    sendToFramework(_arg018, _arg17);
                    return true;
                case 21:
                    String _arg019 = data.readString();
                    Bundle _arg18 = (Bundle) data.readTypedObject(Bundle.CREATOR);
                    Bundle _result16 = getFromFramework(_arg019, _arg18);
                    reply.writeNoException();
                    reply.writeTypedObject(_result16, 1);
                    return true;
                case 22:
                    String _arg020 = data.readString();
                    Bundle _arg19 = (Bundle) data.readTypedObject(Bundle.CREATOR);
                    IStepOSAsyncCallback _arg24 = IStepOSAsyncCallback.Stub.asInterface(data.readStrongBinder());
                    sendAsyncRequest(_arg020, _arg19, _arg24);
                    return true;
                case 23:
                    boolean _arg021 = data.readBoolean();
                    int _arg110 = data.readInt();
                    setDataRoamingEnabled(_arg021, _arg110);
                    return true;
                case 24:
                    int _arg022 = data.readInt();
                    int _arg111 = data.readInt();
                    set5GMode(_arg022, _arg111);
                    return true;
                case 25:
                    int _arg023 = data.readInt();
                    int _result17 = get5GMode(_arg023);
                    reply.writeNoException();
                    reply.writeInt(_result17);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements ITelephonyExt {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ITelephonyExt.DESCRIPTOR;
            }

            @Override // stepos.telephony.ITelephonyExt
            public void cancelMissedRecordsNotification() throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ITelephonyExt.DESCRIPTOR);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.telephony.ITelephonyExt
            public boolean setVoiceMailNumber(String num, int slotId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ITelephonyExt.DESCRIPTOR);
                    _data.writeString(num);
                    _data.writeInt(slotId);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.telephony.ITelephonyExt
            public boolean selectNetworkManually(OperatorInfo network) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ITelephonyExt.DESCRIPTOR);
                    _data.writeTypedObject(network, 0);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.telephony.ITelephonyExt
            public ServiceState getServiceState() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ITelephonyExt.DESCRIPTOR);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                    ServiceState _result = (ServiceState) _reply.readTypedObject(ServiceState.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.telephony.ITelephonyExt
            public ServiceState getServiceStateBySlot(int slotId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ITelephonyExt.DESCRIPTOR);
                    _data.writeInt(slotId);
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                    ServiceState _result = (ServiceState) _reply.readTypedObject(ServiceState.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.telephony.ITelephonyExt
            public String getScAddress(int slotId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ITelephonyExt.DESCRIPTOR);
                    _data.writeInt(slotId);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.telephony.ITelephonyExt
            public void setScAddress(String address, int slotId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ITelephonyExt.DESCRIPTOR);
                    _data.writeString(address);
                    _data.writeInt(slotId);
                    this.mRemote.transact(7, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.telephony.ITelephonyExt
            public boolean getIccLockEnabledBySlotId(int slotId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ITelephonyExt.DESCRIPTOR);
                    _data.writeInt(slotId);
                    this.mRemote.transact(8, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.telephony.ITelephonyExt
            public boolean setIccLockEnabledBySlotId(boolean enabled, String password, int slotId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ITelephonyExt.DESCRIPTOR);
                    _data.writeBoolean(enabled);
                    _data.writeString(password);
                    _data.writeInt(slotId);
                    this.mRemote.transact(9, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.telephony.ITelephonyExt
            public boolean changeIccLockPasswordBySlotId(String oldPassword, String newPassword, int slotId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ITelephonyExt.DESCRIPTOR);
                    _data.writeString(oldPassword);
                    _data.writeString(newPassword);
                    _data.writeInt(slotId);
                    this.mRemote.transact(10, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.telephony.ITelephonyExt
            public boolean setNetworkSelectionModeAutomaticBySlotId(int slotId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ITelephonyExt.DESCRIPTOR);
                    _data.writeInt(slotId);
                    this.mRemote.transact(11, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.telephony.ITelephonyExt
            public CellIdentity getCellLocation(int slotId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ITelephonyExt.DESCRIPTOR);
                    _data.writeInt(slotId);
                    this.mRemote.transact(12, _data, _reply, 0);
                    _reply.readException();
                    CellIdentity _result = (CellIdentity) _reply.readTypedObject(CellIdentity.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.telephony.ITelephonyExt
            public int updateSafePaySetting(boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ITelephonyExt.DESCRIPTOR);
                    _data.writeBoolean(enable);
                    this.mRemote.transact(13, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.telephony.ITelephonyExt
            public int updateSafePayByPackage(String packageName, boolean install) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ITelephonyExt.DESCRIPTOR);
                    _data.writeString(packageName);
                    _data.writeBoolean(install);
                    this.mRemote.transact(14, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.telephony.ITelephonyExt
            public void updateMobileDataAlwaysOnSwitch(boolean changed) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ITelephonyExt.DESCRIPTOR);
                    _data.writeBoolean(changed);
                    this.mRemote.transact(15, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.telephony.ITelephonyExt
            public void updatePayProtectOnSwitch(boolean changed) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ITelephonyExt.DESCRIPTOR);
                    _data.writeBoolean(changed);
                    this.mRemote.transact(16, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.telephony.ITelephonyExt
            public boolean canSaveAdn(int subId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ITelephonyExt.DESCRIPTOR);
                    _data.writeInt(subId);
                    this.mRemote.transact(17, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.telephony.ITelephonyExt
            public List<CellInfo> getAllCellInfo(int slotId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ITelephonyExt.DESCRIPTOR);
                    _data.writeInt(slotId);
                    this.mRemote.transact(18, _data, _reply, 0);
                    _reply.readException();
                    List<CellInfo> _result = _reply.createTypedArrayList(CellInfo.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.telephony.ITelephonyExt
            public String getOperator(String numeric, String language, String nameType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ITelephonyExt.DESCRIPTOR);
                    _data.writeString(numeric);
                    _data.writeString(language);
                    _data.writeString(nameType);
                    this.mRemote.transact(19, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.telephony.ITelephonyExt
            public void sendToFramework(String req, Bundle msg) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ITelephonyExt.DESCRIPTOR);
                    _data.writeString(req);
                    _data.writeTypedObject(msg, 0);
                    this.mRemote.transact(20, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.telephony.ITelephonyExt
            public Bundle getFromFramework(String req, Bundle inMsg) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ITelephonyExt.DESCRIPTOR);
                    _data.writeString(req);
                    _data.writeTypedObject(inMsg, 0);
                    this.mRemote.transact(21, _data, _reply, 0);
                    _reply.readException();
                    Bundle _result = (Bundle) _reply.readTypedObject(Bundle.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.telephony.ITelephonyExt
            public void sendAsyncRequest(String req, Bundle params, IStepOSAsyncCallback cb) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ITelephonyExt.DESCRIPTOR);
                    _data.writeString(req);
                    _data.writeTypedObject(params, 0);
                    _data.writeStrongInterface(cb);
                    this.mRemote.transact(22, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.telephony.ITelephonyExt
            public void setDataRoamingEnabled(boolean enabled, int slotId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ITelephonyExt.DESCRIPTOR);
                    _data.writeBoolean(enabled);
                    _data.writeInt(slotId);
                    this.mRemote.transact(23, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.telephony.ITelephonyExt
            public void set5GMode(int mode, int slotId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ITelephonyExt.DESCRIPTOR);
                    _data.writeInt(mode);
                    _data.writeInt(slotId);
                    this.mRemote.transact(24, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.telephony.ITelephonyExt
            public int get5GMode(int slotId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ITelephonyExt.DESCRIPTOR);
                    _data.writeInt(slotId);
                    this.mRemote.transact(25, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 24;
        }
    }

    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedList(Parcel parcel, List<T> value, int parcelableFlags) {
            if (value == null) {
                parcel.writeInt(-1);
                return;
            }
            int N = value.size();
            parcel.writeInt(N);
            for (int i = 0; i < N; i++) {
                parcel.writeTypedObject(value.get(i), parcelableFlags);
            }
        }
    }
}
