package stepos.view;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.android.internal.view.AppearanceRegion;

/* loaded from: classes.dex */
public interface IDisplayUIListener extends IInterface {
    public static final String DESCRIPTOR = "stepos.view.IDisplayUIListener";

    void onDisplayEmpty(int i) throws RemoteException;

    void onDisplayFinishAsyncRotation(int i) throws RemoteException;

    void onDisplayStartAsyncRotation(int i, int i2, int i3) throws RemoteException;

    void onDisplayWatchIntentReceived(int i, String str, Intent intent) throws RemoteException;

    void onSystemBarAttributesChanged(int i, int i2, AppearanceRegion[] appearanceRegionArr, boolean z, int i3, int i4, String str) throws RemoteException;

    void onTaskWillBackStateChange(int i, int i2, boolean z) throws RemoteException;

    void onTopActivityChanged(ComponentName componentName, int i) throws RemoteException;

    void onVisibleSecureWindowState(int i, boolean z) throws RemoteException;

    public static class Default implements IDisplayUIListener {
        @Override // stepos.view.IDisplayUIListener
        public void onSystemBarAttributesChanged(int displayId, int appearance, AppearanceRegion[] appearanceRegions, boolean navbarColorManagedByIme, int behavior, int requestedVisibleTypes, String packageName) throws RemoteException {
        }

        @Override // stepos.view.IDisplayUIListener
        public void onTopActivityChanged(ComponentName topActivity, int uid) throws RemoteException {
        }

        @Override // stepos.view.IDisplayUIListener
        public void onTaskWillBackStateChange(int displayId, int taskId, boolean willBack) throws RemoteException {
        }

        @Override // stepos.view.IDisplayUIListener
        public void onDisplayEmpty(int displayId) throws RemoteException {
        }

        @Override // stepos.view.IDisplayUIListener
        public void onDisplayStartAsyncRotation(int displayId, int oldRotation, int newRotation) throws RemoteException {
        }

        @Override // stepos.view.IDisplayUIListener
        public void onDisplayFinishAsyncRotation(int displayId) throws RemoteException {
        }

        @Override // stepos.view.IDisplayUIListener
        public void onVisibleSecureWindowState(int displayId, boolean hasVisibleSecureWindow) throws RemoteException {
        }

        @Override // stepos.view.IDisplayUIListener
        public void onDisplayWatchIntentReceived(int displayId, String packageName, Intent activityIntent) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IDisplayUIListener {
        static final int TRANSACTION_onDisplayEmpty = 4;
        static final int TRANSACTION_onDisplayFinishAsyncRotation = 6;
        static final int TRANSACTION_onDisplayStartAsyncRotation = 5;
        static final int TRANSACTION_onDisplayWatchIntentReceived = 8;
        static final int TRANSACTION_onSystemBarAttributesChanged = 1;
        static final int TRANSACTION_onTaskWillBackStateChange = 3;
        static final int TRANSACTION_onTopActivityChanged = 2;
        static final int TRANSACTION_onVisibleSecureWindowState = 7;

        public Stub() {
            attachInterface(this, IDisplayUIListener.DESCRIPTOR);
        }

        public static IDisplayUIListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IDisplayUIListener.DESCRIPTOR);
            if (iin != null && (iin instanceof IDisplayUIListener)) {
                return (IDisplayUIListener) iin;
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
                    return "onSystemBarAttributesChanged";
                case 2:
                    return "onTopActivityChanged";
                case 3:
                    return "onTaskWillBackStateChange";
                case 4:
                    return "onDisplayEmpty";
                case 5:
                    return "onDisplayStartAsyncRotation";
                case 6:
                    return "onDisplayFinishAsyncRotation";
                case 7:
                    return "onVisibleSecureWindowState";
                case 8:
                    return "onDisplayWatchIntentReceived";
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
                data.enforceInterface(IDisplayUIListener.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IDisplayUIListener.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    int _arg0 = data.readInt();
                    int _arg1 = data.readInt();
                    AppearanceRegion[] _arg2 = (AppearanceRegion[]) data.createTypedArray(AppearanceRegion.CREATOR);
                    boolean _arg3 = data.readBoolean();
                    int _arg4 = data.readInt();
                    int _arg5 = data.readInt();
                    String _arg6 = data.readString();
                    onSystemBarAttributesChanged(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6);
                    return true;
                case 2:
                    ComponentName _arg02 = (ComponentName) data.readTypedObject(ComponentName.CREATOR);
                    int _arg12 = data.readInt();
                    onTopActivityChanged(_arg02, _arg12);
                    return true;
                case 3:
                    int _arg03 = data.readInt();
                    int _arg13 = data.readInt();
                    boolean _arg22 = data.readBoolean();
                    onTaskWillBackStateChange(_arg03, _arg13, _arg22);
                    return true;
                case 4:
                    int _arg04 = data.readInt();
                    onDisplayEmpty(_arg04);
                    return true;
                case 5:
                    int _arg05 = data.readInt();
                    int _arg14 = data.readInt();
                    int _arg23 = data.readInt();
                    onDisplayStartAsyncRotation(_arg05, _arg14, _arg23);
                    return true;
                case 6:
                    int _arg06 = data.readInt();
                    onDisplayFinishAsyncRotation(_arg06);
                    return true;
                case 7:
                    int _arg07 = data.readInt();
                    boolean _arg15 = data.readBoolean();
                    onVisibleSecureWindowState(_arg07, _arg15);
                    return true;
                case 8:
                    int _arg08 = data.readInt();
                    String _arg16 = data.readString();
                    Intent _arg24 = (Intent) data.readTypedObject(Intent.CREATOR);
                    onDisplayWatchIntentReceived(_arg08, _arg16, _arg24);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IDisplayUIListener {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IDisplayUIListener.DESCRIPTOR;
            }

            @Override // stepos.view.IDisplayUIListener
            public void onSystemBarAttributesChanged(int displayId, int appearance, AppearanceRegion[] appearanceRegions, boolean navbarColorManagedByIme, int behavior, int requestedVisibleTypes, String packageName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IDisplayUIListener.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeInt(appearance);
                    _data.writeTypedArray(appearanceRegions, 0);
                    _data.writeBoolean(navbarColorManagedByIme);
                    _data.writeInt(behavior);
                    _data.writeInt(requestedVisibleTypes);
                    _data.writeString(packageName);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.view.IDisplayUIListener
            public void onTopActivityChanged(ComponentName topActivity, int uid) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IDisplayUIListener.DESCRIPTOR);
                    _data.writeTypedObject(topActivity, 0);
                    _data.writeInt(uid);
                    this.mRemote.transact(2, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.view.IDisplayUIListener
            public void onTaskWillBackStateChange(int displayId, int taskId, boolean willBack) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IDisplayUIListener.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeInt(taskId);
                    _data.writeBoolean(willBack);
                    this.mRemote.transact(3, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.view.IDisplayUIListener
            public void onDisplayEmpty(int displayId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IDisplayUIListener.DESCRIPTOR);
                    _data.writeInt(displayId);
                    this.mRemote.transact(4, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.view.IDisplayUIListener
            public void onDisplayStartAsyncRotation(int displayId, int oldRotation, int newRotation) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IDisplayUIListener.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeInt(oldRotation);
                    _data.writeInt(newRotation);
                    this.mRemote.transact(5, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.view.IDisplayUIListener
            public void onDisplayFinishAsyncRotation(int displayId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IDisplayUIListener.DESCRIPTOR);
                    _data.writeInt(displayId);
                    this.mRemote.transact(6, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.view.IDisplayUIListener
            public void onVisibleSecureWindowState(int displayId, boolean hasVisibleSecureWindow) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IDisplayUIListener.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeBoolean(hasVisibleSecureWindow);
                    this.mRemote.transact(7, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.view.IDisplayUIListener
            public void onDisplayWatchIntentReceived(int displayId, String packageName, Intent activityIntent) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IDisplayUIListener.DESCRIPTOR);
                    _data.writeInt(displayId);
                    _data.writeString(packageName);
                    _data.writeTypedObject(activityIntent, 0);
                    this.mRemote.transact(8, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 7;
        }
    }
}
