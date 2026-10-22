package stepos.inputmethod;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;

/* loaded from: classes.dex */
public interface IQsEditorListener extends IInterface {
    public static final String DESCRIPTOR = "stepos.inputmethod.IQsEditorListener";

    void onEditorBegin(int i, int i2, EditorInfo editorInfo) throws RemoteException;

    void onEditorEnd(int i, int i2) throws RemoteException;

    void onEditorTextChange(int i, int i2, CharSequence charSequence) throws RemoteException;

    public static class Default implements IQsEditorListener {
        @Override // stepos.inputmethod.IQsEditorListener
        public void onEditorBegin(int userId, int displayId, EditorInfo editorInfo) throws RemoteException {
        }

        @Override // stepos.inputmethod.IQsEditorListener
        public void onEditorTextChange(int userId, int displayId, CharSequence text) throws RemoteException {
        }

        @Override // stepos.inputmethod.IQsEditorListener
        public void onEditorEnd(int userId, int displayId) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IQsEditorListener {
        static final int TRANSACTION_onEditorBegin = 1;
        static final int TRANSACTION_onEditorEnd = 3;
        static final int TRANSACTION_onEditorTextChange = 2;

        public Stub() {
            attachInterface(this, IQsEditorListener.DESCRIPTOR);
        }

        public static IQsEditorListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IQsEditorListener.DESCRIPTOR);
            if (iin != null && (iin instanceof IQsEditorListener)) {
                return (IQsEditorListener) iin;
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
                    return "onEditorBegin";
                case 2:
                    return "onEditorTextChange";
                case 3:
                    return "onEditorEnd";
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
                data.enforceInterface(IQsEditorListener.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IQsEditorListener.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    int _arg0 = data.readInt();
                    int _arg1 = data.readInt();
                    EditorInfo _arg2 = (EditorInfo) data.readTypedObject(EditorInfo.CREATOR);
                    onEditorBegin(_arg0, _arg1, _arg2);
                    return true;
                case 2:
                    int _arg02 = data.readInt();
                    int _arg12 = data.readInt();
                    CharSequence _arg22 = (CharSequence) data.readTypedObject(TextUtils.CHAR_SEQUENCE_CREATOR);
                    onEditorTextChange(_arg02, _arg12, _arg22);
                    return true;
                case 3:
                    int _arg03 = data.readInt();
                    int _arg13 = data.readInt();
                    onEditorEnd(_arg03, _arg13);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IQsEditorListener {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IQsEditorListener.DESCRIPTOR;
            }

            @Override // stepos.inputmethod.IQsEditorListener
            public void onEditorBegin(int userId, int displayId, EditorInfo editorInfo) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IQsEditorListener.DESCRIPTOR);
                    _data.writeInt(userId);
                    _data.writeInt(displayId);
                    _data.writeTypedObject(editorInfo, 0);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.inputmethod.IQsEditorListener
            public void onEditorTextChange(int userId, int displayId, CharSequence text) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IQsEditorListener.DESCRIPTOR);
                    _data.writeInt(userId);
                    _data.writeInt(displayId);
                    if (text != null) {
                        _data.writeInt(1);
                        TextUtils.writeToParcel(text, _data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.mRemote.transact(2, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.inputmethod.IQsEditorListener
            public void onEditorEnd(int userId, int displayId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IQsEditorListener.DESCRIPTOR);
                    _data.writeInt(userId);
                    _data.writeInt(displayId);
                    this.mRemote.transact(3, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 2;
        }
    }
}
