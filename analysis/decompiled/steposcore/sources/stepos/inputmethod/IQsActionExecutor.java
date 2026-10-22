package stepos.inputmethod;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import com.android.internal.inputmethod.IRemoteInputConnection;

/* loaded from: classes.dex */
public interface IQsActionExecutor extends IInterface {
    public static final String DESCRIPTOR = "stepos.inputmethod.IQsActionExecutor";

    void bindInput(IRemoteInputConnection iRemoteInputConnection, EditorInfo editorInfo) throws RemoteException;

    boolean commitText(CharSequence charSequence, boolean z) throws RemoteException;

    EditorInfo getEditorInfo() throws RemoteException;

    IRemoteInputConnection getInputConnection() throws RemoteException;

    IBinder getWindowToken() throws RemoteException;

    void hideMySoftInput() throws RemoteException;

    void showInputMethodPicker() throws RemoteException;

    void showMySoftInput() throws RemoteException;

    void startActivity(Intent intent, Bundle bundle) throws RemoteException;

    public static class Default implements IQsActionExecutor {
        @Override // stepos.inputmethod.IQsActionExecutor
        public void showInputMethodPicker() throws RemoteException {
        }

        @Override // stepos.inputmethod.IQsActionExecutor
        public void startActivity(Intent intent, Bundle options) throws RemoteException {
        }

        @Override // stepos.inputmethod.IQsActionExecutor
        public void bindInput(IRemoteInputConnection remoteInputConnection, EditorInfo editorInfo) throws RemoteException {
        }

        @Override // stepos.inputmethod.IQsActionExecutor
        public void showMySoftInput() throws RemoteException {
        }

        @Override // stepos.inputmethod.IQsActionExecutor
        public void hideMySoftInput() throws RemoteException {
        }

        @Override // stepos.inputmethod.IQsActionExecutor
        public IBinder getWindowToken() throws RemoteException {
            return null;
        }

        @Override // stepos.inputmethod.IQsActionExecutor
        public EditorInfo getEditorInfo() throws RemoteException {
            return null;
        }

        @Override // stepos.inputmethod.IQsActionExecutor
        public IRemoteInputConnection getInputConnection() throws RemoteException {
            return null;
        }

        @Override // stepos.inputmethod.IQsActionExecutor
        public boolean commitText(CharSequence text, boolean verificationCode) throws RemoteException {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IQsActionExecutor {
        static final int TRANSACTION_bindInput = 3;
        static final int TRANSACTION_commitText = 9;
        static final int TRANSACTION_getEditorInfo = 7;
        static final int TRANSACTION_getInputConnection = 8;
        static final int TRANSACTION_getWindowToken = 6;
        static final int TRANSACTION_hideMySoftInput = 5;
        static final int TRANSACTION_showInputMethodPicker = 1;
        static final int TRANSACTION_showMySoftInput = 4;
        static final int TRANSACTION_startActivity = 2;

        public Stub() {
            attachInterface(this, IQsActionExecutor.DESCRIPTOR);
        }

        public static IQsActionExecutor asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IQsActionExecutor.DESCRIPTOR);
            if (iin != null && (iin instanceof IQsActionExecutor)) {
                return (IQsActionExecutor) iin;
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
                    return "showInputMethodPicker";
                case 2:
                    return "startActivity";
                case 3:
                    return "bindInput";
                case 4:
                    return "showMySoftInput";
                case 5:
                    return "hideMySoftInput";
                case 6:
                    return "getWindowToken";
                case 7:
                    return "getEditorInfo";
                case 8:
                    return "getInputConnection";
                case 9:
                    return "commitText";
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
                data.enforceInterface(IQsActionExecutor.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IQsActionExecutor.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    showInputMethodPicker();
                    return true;
                case 2:
                    Intent _arg0 = (Intent) data.readTypedObject(Intent.CREATOR);
                    Bundle _arg1 = (Bundle) data.readTypedObject(Bundle.CREATOR);
                    startActivity(_arg0, _arg1);
                    return true;
                case 3:
                    IRemoteInputConnection _arg02 = IRemoteInputConnection.Stub.asInterface(data.readStrongBinder());
                    EditorInfo _arg12 = (EditorInfo) data.readTypedObject(EditorInfo.CREATOR);
                    bindInput(_arg02, _arg12);
                    return true;
                case 4:
                    showMySoftInput();
                    return true;
                case 5:
                    hideMySoftInput();
                    return true;
                case 6:
                    IBinder _result = getWindowToken();
                    reply.writeNoException();
                    reply.writeStrongBinder(_result);
                    return true;
                case 7:
                    EditorInfo _result2 = getEditorInfo();
                    reply.writeNoException();
                    reply.writeTypedObject(_result2, 1);
                    return true;
                case 8:
                    IRemoteInputConnection _result3 = getInputConnection();
                    reply.writeNoException();
                    reply.writeStrongInterface(_result3);
                    return true;
                case 9:
                    CharSequence _arg03 = (CharSequence) data.readTypedObject(TextUtils.CHAR_SEQUENCE_CREATOR);
                    boolean _arg13 = data.readBoolean();
                    boolean _result4 = commitText(_arg03, _arg13);
                    reply.writeNoException();
                    reply.writeBoolean(_result4);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IQsActionExecutor {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IQsActionExecutor.DESCRIPTOR;
            }

            @Override // stepos.inputmethod.IQsActionExecutor
            public void showInputMethodPicker() throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IQsActionExecutor.DESCRIPTOR);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.inputmethod.IQsActionExecutor
            public void startActivity(Intent intent, Bundle options) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IQsActionExecutor.DESCRIPTOR);
                    _data.writeTypedObject(intent, 0);
                    _data.writeTypedObject(options, 0);
                    this.mRemote.transact(2, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.inputmethod.IQsActionExecutor
            public void bindInput(IRemoteInputConnection remoteInputConnection, EditorInfo editorInfo) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IQsActionExecutor.DESCRIPTOR);
                    _data.writeStrongInterface(remoteInputConnection);
                    _data.writeTypedObject(editorInfo, 0);
                    this.mRemote.transact(3, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.inputmethod.IQsActionExecutor
            public void showMySoftInput() throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IQsActionExecutor.DESCRIPTOR);
                    this.mRemote.transact(4, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.inputmethod.IQsActionExecutor
            public void hideMySoftInput() throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IQsActionExecutor.DESCRIPTOR);
                    this.mRemote.transact(5, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.inputmethod.IQsActionExecutor
            public IBinder getWindowToken() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IQsActionExecutor.DESCRIPTOR);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                    IBinder _result = _reply.readStrongBinder();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.inputmethod.IQsActionExecutor
            public EditorInfo getEditorInfo() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IQsActionExecutor.DESCRIPTOR);
                    this.mRemote.transact(7, _data, _reply, 0);
                    _reply.readException();
                    EditorInfo _result = (EditorInfo) _reply.readTypedObject(EditorInfo.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.inputmethod.IQsActionExecutor
            public IRemoteInputConnection getInputConnection() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IQsActionExecutor.DESCRIPTOR);
                    this.mRemote.transact(8, _data, _reply, 0);
                    _reply.readException();
                    IRemoteInputConnection _result = IRemoteInputConnection.Stub.asInterface(_reply.readStrongBinder());
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.inputmethod.IQsActionExecutor
            public boolean commitText(CharSequence text, boolean verificationCode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IQsActionExecutor.DESCRIPTOR);
                    if (text != null) {
                        _data.writeInt(1);
                        TextUtils.writeToParcel(text, _data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeBoolean(verificationCode);
                    this.mRemote.transact(9, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 8;
        }
    }
}
