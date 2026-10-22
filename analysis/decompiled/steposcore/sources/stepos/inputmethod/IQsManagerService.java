package stepos.inputmethod;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import java.util.List;
import stepos.inputmethod.IQsActionCallback;
import stepos.inputmethod.IQsActionExecutor;
import stepos.inputmethod.IQsActionListener;
import stepos.inputmethod.IQsEditorListener;

/* loaded from: classes.dex */
public interface IQsManagerService extends IInterface {
    public static final String DESCRIPTOR = "stepos.inputmethod.IQsManagerService";

    void callItemAction(CharSequence charSequence, int i, int i2, int i3, Bundle bundle) throws RemoteException;

    void callItemActionSystemUiVisibilityChange(int i, boolean z) throws RemoteException;

    IQsActionExecutor getActionExecutor(int i, long j) throws RemoteException;

    List<QsActionItem> getActionItemList(int i, int i2) throws RemoteException;

    int getImeHeight(int i, boolean z) throws RemoteException;

    boolean isEnable(int i) throws RemoteException;

    void onAppEditorBegin(int i, int i2, EditorInfo editorInfo) throws RemoteException;

    void onAppEditorEnd(int i, int i2) throws RemoteException;

    void onAppEditorTextChange(int i, int i2, CharSequence charSequence) throws RemoteException;

    void registerActionExecutor(int i, int i2, IQsActionExecutor iQsActionExecutor) throws RemoteException;

    void registerActionItem(int i, QsActionItem qsActionItem, IQsActionCallback iQsActionCallback) throws RemoteException;

    void registerActionListener(int i, IQsActionListener iQsActionListener) throws RemoteException;

    void registerEditorListener(int i, IQsEditorListener iQsEditorListener) throws RemoteException;

    void unRegisterActionExecutor(int i, int i2, IQsActionExecutor iQsActionExecutor) throws RemoteException;

    void unRegisterActionItem(int i, QsActionItem qsActionItem) throws RemoteException;

    void unRegisterActionListener(int i, IQsActionListener iQsActionListener) throws RemoteException;

    void unRegisterEditorListener(int i, IQsEditorListener iQsEditorListener) throws RemoteException;

    void updateActionItem(int i, QsActionItem qsActionItem) throws RemoteException;

    public static class Default implements IQsManagerService {
        @Override // stepos.inputmethod.IQsManagerService
        public void registerActionItem(int userId, QsActionItem item, IQsActionCallback callBack) throws RemoteException {
        }

        @Override // stepos.inputmethod.IQsManagerService
        public void unRegisterActionItem(int userId, QsActionItem item) throws RemoteException {
        }

        @Override // stepos.inputmethod.IQsManagerService
        public void updateActionItem(int userId, QsActionItem item) throws RemoteException {
        }

        @Override // stepos.inputmethod.IQsManagerService
        public void registerActionListener(int userId, IQsActionListener listener) throws RemoteException {
        }

        @Override // stepos.inputmethod.IQsManagerService
        public void unRegisterActionListener(int userId, IQsActionListener listener) throws RemoteException {
        }

        @Override // stepos.inputmethod.IQsManagerService
        public void registerActionExecutor(int displayId, int userId, IQsActionExecutor executor) throws RemoteException {
        }

        @Override // stepos.inputmethod.IQsManagerService
        public void unRegisterActionExecutor(int displayId, int userId, IQsActionExecutor executor) throws RemoteException {
        }

        @Override // stepos.inputmethod.IQsManagerService
        public int getImeHeight(int displayId, boolean virtual) throws RemoteException {
            return 0;
        }

        @Override // stepos.inputmethod.IQsManagerService
        public void callItemAction(CharSequence itemKey, int action, int displayId, int userId, Bundle data) throws RemoteException {
        }

        @Override // stepos.inputmethod.IQsManagerService
        public void callItemActionSystemUiVisibilityChange(int displayId, boolean removeWindow) throws RemoteException {
        }

        @Override // stepos.inputmethod.IQsManagerService
        public List<QsActionItem> getActionItemList(int userId, int positionFlags) throws RemoteException {
            return null;
        }

        @Override // stepos.inputmethod.IQsManagerService
        public IQsActionExecutor getActionExecutor(int displayId, long token) throws RemoteException {
            return null;
        }

        @Override // stepos.inputmethod.IQsManagerService
        public boolean isEnable(int displayId) throws RemoteException {
            return false;
        }

        @Override // stepos.inputmethod.IQsManagerService
        public void registerEditorListener(int userId, IQsEditorListener listener) throws RemoteException {
        }

        @Override // stepos.inputmethod.IQsManagerService
        public void unRegisterEditorListener(int userId, IQsEditorListener listener) throws RemoteException {
        }

        @Override // stepos.inputmethod.IQsManagerService
        public void onAppEditorBegin(int userId, int displayId, EditorInfo editorInfo) throws RemoteException {
        }

        @Override // stepos.inputmethod.IQsManagerService
        public void onAppEditorTextChange(int userId, int displayId, CharSequence text) throws RemoteException {
        }

        @Override // stepos.inputmethod.IQsManagerService
        public void onAppEditorEnd(int userId, int displayId) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IQsManagerService {
        static final int TRANSACTION_callItemAction = 9;
        static final int TRANSACTION_callItemActionSystemUiVisibilityChange = 10;
        static final int TRANSACTION_getActionExecutor = 12;
        static final int TRANSACTION_getActionItemList = 11;
        static final int TRANSACTION_getImeHeight = 8;
        static final int TRANSACTION_isEnable = 13;
        static final int TRANSACTION_onAppEditorBegin = 16;
        static final int TRANSACTION_onAppEditorEnd = 18;
        static final int TRANSACTION_onAppEditorTextChange = 17;
        static final int TRANSACTION_registerActionExecutor = 6;
        static final int TRANSACTION_registerActionItem = 1;
        static final int TRANSACTION_registerActionListener = 4;
        static final int TRANSACTION_registerEditorListener = 14;
        static final int TRANSACTION_unRegisterActionExecutor = 7;
        static final int TRANSACTION_unRegisterActionItem = 2;
        static final int TRANSACTION_unRegisterActionListener = 5;
        static final int TRANSACTION_unRegisterEditorListener = 15;
        static final int TRANSACTION_updateActionItem = 3;

        public Stub() {
            attachInterface(this, IQsManagerService.DESCRIPTOR);
        }

        public static IQsManagerService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IQsManagerService.DESCRIPTOR);
            if (iin != null && (iin instanceof IQsManagerService)) {
                return (IQsManagerService) iin;
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
                    return "registerActionItem";
                case 2:
                    return "unRegisterActionItem";
                case 3:
                    return "updateActionItem";
                case 4:
                    return "registerActionListener";
                case 5:
                    return "unRegisterActionListener";
                case 6:
                    return "registerActionExecutor";
                case 7:
                    return "unRegisterActionExecutor";
                case 8:
                    return "getImeHeight";
                case 9:
                    return "callItemAction";
                case 10:
                    return "callItemActionSystemUiVisibilityChange";
                case 11:
                    return "getActionItemList";
                case 12:
                    return "getActionExecutor";
                case 13:
                    return "isEnable";
                case 14:
                    return "registerEditorListener";
                case 15:
                    return "unRegisterEditorListener";
                case 16:
                    return "onAppEditorBegin";
                case 17:
                    return "onAppEditorTextChange";
                case 18:
                    return "onAppEditorEnd";
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
                data.enforceInterface(IQsManagerService.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IQsManagerService.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    int _arg0 = data.readInt();
                    QsActionItem _arg1 = (QsActionItem) data.readTypedObject(QsActionItem.CREATOR);
                    IQsActionCallback _arg2 = IQsActionCallback.Stub.asInterface(data.readStrongBinder());
                    registerActionItem(_arg0, _arg1, _arg2);
                    return true;
                case 2:
                    int _arg02 = data.readInt();
                    QsActionItem _arg12 = (QsActionItem) data.readTypedObject(QsActionItem.CREATOR);
                    unRegisterActionItem(_arg02, _arg12);
                    return true;
                case 3:
                    int _arg03 = data.readInt();
                    QsActionItem _arg13 = (QsActionItem) data.readTypedObject(QsActionItem.CREATOR);
                    updateActionItem(_arg03, _arg13);
                    return true;
                case 4:
                    int _arg04 = data.readInt();
                    IQsActionListener _arg14 = IQsActionListener.Stub.asInterface(data.readStrongBinder());
                    registerActionListener(_arg04, _arg14);
                    return true;
                case 5:
                    int _arg05 = data.readInt();
                    IQsActionListener _arg15 = IQsActionListener.Stub.asInterface(data.readStrongBinder());
                    unRegisterActionListener(_arg05, _arg15);
                    return true;
                case 6:
                    int _arg06 = data.readInt();
                    int _arg16 = data.readInt();
                    IQsActionExecutor _arg22 = IQsActionExecutor.Stub.asInterface(data.readStrongBinder());
                    registerActionExecutor(_arg06, _arg16, _arg22);
                    return true;
                case 7:
                    int _arg07 = data.readInt();
                    int _arg17 = data.readInt();
                    IQsActionExecutor _arg23 = IQsActionExecutor.Stub.asInterface(data.readStrongBinder());
                    unRegisterActionExecutor(_arg07, _arg17, _arg23);
                    return true;
                case 8:
                    int _arg08 = data.readInt();
                    boolean _arg18 = data.readBoolean();
                    int _result = getImeHeight(_arg08, _arg18);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case 9:
                    CharSequence _arg09 = (CharSequence) data.readTypedObject(TextUtils.CHAR_SEQUENCE_CREATOR);
                    int _arg19 = data.readInt();
                    int _arg24 = data.readInt();
                    int _arg3 = data.readInt();
                    Bundle _arg4 = (Bundle) data.readTypedObject(Bundle.CREATOR);
                    callItemAction(_arg09, _arg19, _arg24, _arg3, _arg4);
                    return true;
                case 10:
                    int _arg010 = data.readInt();
                    boolean _arg110 = data.readBoolean();
                    callItemActionSystemUiVisibilityChange(_arg010, _arg110);
                    return true;
                case 11:
                    int _arg011 = data.readInt();
                    int _arg111 = data.readInt();
                    List<QsActionItem> _result2 = getActionItemList(_arg011, _arg111);
                    reply.writeNoException();
                    _Parcel.writeTypedList(reply, _result2, 1);
                    return true;
                case 12:
                    int _arg012 = data.readInt();
                    long _arg112 = data.readLong();
                    IQsActionExecutor _result3 = getActionExecutor(_arg012, _arg112);
                    reply.writeNoException();
                    reply.writeStrongInterface(_result3);
                    return true;
                case 13:
                    int _arg013 = data.readInt();
                    boolean _result4 = isEnable(_arg013);
                    reply.writeNoException();
                    reply.writeBoolean(_result4);
                    return true;
                case 14:
                    int _arg014 = data.readInt();
                    IQsEditorListener _arg113 = IQsEditorListener.Stub.asInterface(data.readStrongBinder());
                    registerEditorListener(_arg014, _arg113);
                    return true;
                case 15:
                    int _arg015 = data.readInt();
                    IQsEditorListener _arg114 = IQsEditorListener.Stub.asInterface(data.readStrongBinder());
                    unRegisterEditorListener(_arg015, _arg114);
                    return true;
                case 16:
                    int _arg016 = data.readInt();
                    int _arg115 = data.readInt();
                    EditorInfo _arg25 = (EditorInfo) data.readTypedObject(EditorInfo.CREATOR);
                    onAppEditorBegin(_arg016, _arg115, _arg25);
                    reply.writeNoException();
                    return true;
                case 17:
                    int _arg017 = data.readInt();
                    int _arg116 = data.readInt();
                    CharSequence _arg26 = (CharSequence) data.readTypedObject(TextUtils.CHAR_SEQUENCE_CREATOR);
                    onAppEditorTextChange(_arg017, _arg116, _arg26);
                    reply.writeNoException();
                    return true;
                case 18:
                    int _arg018 = data.readInt();
                    int _arg117 = data.readInt();
                    onAppEditorEnd(_arg018, _arg117);
                    reply.writeNoException();
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IQsManagerService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IQsManagerService.DESCRIPTOR;
            }

            @Override // stepos.inputmethod.IQsManagerService
            public void registerActionItem(int userId, QsActionItem item, IQsActionCallback callBack) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IQsManagerService.DESCRIPTOR);
                    _data.writeInt(userId);
                    _data.writeTypedObject(item, 0);
                    _data.writeStrongInterface(callBack);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.inputmethod.IQsManagerService
            public void unRegisterActionItem(int userId, QsActionItem item) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IQsManagerService.DESCRIPTOR);
                    _data.writeInt(userId);
                    _data.writeTypedObject(item, 0);
                    this.mRemote.transact(2, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.inputmethod.IQsManagerService
            public void updateActionItem(int userId, QsActionItem item) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IQsManagerService.DESCRIPTOR);
                    _data.writeInt(userId);
                    _data.writeTypedObject(item, 0);
                    this.mRemote.transact(3, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.inputmethod.IQsManagerService
            public void registerActionListener(int userId, IQsActionListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IQsManagerService.DESCRIPTOR);
                    _data.writeInt(userId);
                    _data.writeStrongInterface(listener);
                    this.mRemote.transact(4, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.inputmethod.IQsManagerService
            public void unRegisterActionListener(int userId, IQsActionListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IQsManagerService.DESCRIPTOR);
                    _data.writeInt(userId);
                    _data.writeStrongInterface(listener);
                    this.mRemote.transact(5, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.inputmethod.IQsManagerService
            public void registerActionExecutor(int displayId, int userId, IQsActionExecutor executor) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IQsManagerService.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeInt(userId);
                    _data.writeStrongInterface(executor);
                    this.mRemote.transact(6, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.inputmethod.IQsManagerService
            public void unRegisterActionExecutor(int displayId, int userId, IQsActionExecutor executor) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IQsManagerService.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeInt(userId);
                    _data.writeStrongInterface(executor);
                    this.mRemote.transact(7, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.inputmethod.IQsManagerService
            public int getImeHeight(int displayId, boolean virtual) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IQsManagerService.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeBoolean(virtual);
                    this.mRemote.transact(8, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.inputmethod.IQsManagerService
            public void callItemAction(CharSequence itemKey, int action, int displayId, int userId, Bundle data) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IQsManagerService.DESCRIPTOR);
                    if (itemKey != null) {
                        _data.writeInt(1);
                        TextUtils.writeToParcel(itemKey, _data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(action);
                    _data.writeInt(displayId);
                    _data.writeInt(userId);
                    _data.writeTypedObject(data, 0);
                    this.mRemote.transact(9, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.inputmethod.IQsManagerService
            public void callItemActionSystemUiVisibilityChange(int displayId, boolean removeWindow) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IQsManagerService.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeBoolean(removeWindow);
                    this.mRemote.transact(10, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.inputmethod.IQsManagerService
            public List<QsActionItem> getActionItemList(int userId, int positionFlags) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IQsManagerService.DESCRIPTOR);
                    _data.writeInt(userId);
                    _data.writeInt(positionFlags);
                    this.mRemote.transact(11, _data, _reply, 0);
                    _reply.readException();
                    List<QsActionItem> _result = _reply.createTypedArrayList(QsActionItem.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.inputmethod.IQsManagerService
            public IQsActionExecutor getActionExecutor(int displayId, long token) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IQsManagerService.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeLong(token);
                    this.mRemote.transact(12, _data, _reply, 0);
                    _reply.readException();
                    IQsActionExecutor _result = IQsActionExecutor.Stub.asInterface(_reply.readStrongBinder());
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.inputmethod.IQsManagerService
            public boolean isEnable(int displayId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IQsManagerService.DESCRIPTOR);
                    _data.writeInt(displayId);
                    this.mRemote.transact(13, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.inputmethod.IQsManagerService
            public void registerEditorListener(int userId, IQsEditorListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IQsManagerService.DESCRIPTOR);
                    _data.writeInt(userId);
                    _data.writeStrongInterface(listener);
                    this.mRemote.transact(14, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.inputmethod.IQsManagerService
            public void unRegisterEditorListener(int userId, IQsEditorListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IQsManagerService.DESCRIPTOR);
                    _data.writeInt(userId);
                    _data.writeStrongInterface(listener);
                    this.mRemote.transact(15, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.inputmethod.IQsManagerService
            public void onAppEditorBegin(int userId, int displayId, EditorInfo editorInfo) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IQsManagerService.DESCRIPTOR);
                    _data.writeInt(userId);
                    _data.writeInt(displayId);
                    _data.writeTypedObject(editorInfo, 0);
                    this.mRemote.transact(16, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.inputmethod.IQsManagerService
            public void onAppEditorTextChange(int userId, int displayId, CharSequence text) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IQsManagerService.DESCRIPTOR);
                    _data.writeInt(userId);
                    _data.writeInt(displayId);
                    if (text != null) {
                        _data.writeInt(1);
                        TextUtils.writeToParcel(text, _data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.mRemote.transact(17, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.inputmethod.IQsManagerService
            public void onAppEditorEnd(int userId, int displayId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IQsManagerService.DESCRIPTOR);
                    _data.writeInt(userId);
                    _data.writeInt(displayId);
                    this.mRemote.transact(18, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 17;
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
