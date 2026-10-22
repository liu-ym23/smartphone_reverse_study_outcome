package android.media.alwayson.service;

import android.media.alwayson.AlwaysOnCaptureConfig;
import android.media.alwayson.AlwaysOnPreRollFetchResult;
import android.media.steposmanager.AlwaysOnRecordSceneInfo;
import android.media.steposmanager.AlwaysOnRecordSceneSegment;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IAlwaysOnVoiceClient extends IInterface {
    public static final String DESCRIPTOR = "android.media.alwayson.service.IAlwaysOnVoiceClient";

    void onCaptureRequest(AlwaysOnCaptureConfig alwaysOnCaptureConfig, AlwaysOnPreRollFetchResult alwaysOnPreRollFetchResult) throws RemoteException;

    void onCaptureStop(int i, int i2, String str) throws RemoteException;

    void onCaptureUpdate(AlwaysOnCaptureConfig alwaysOnCaptureConfig) throws RemoteException;

    void onReady() throws RemoteException;

    void onSceneChanged(AlwaysOnRecordSceneInfo alwaysOnRecordSceneInfo) throws RemoteException;

    void onSceneSegmentClosed(AlwaysOnRecordSceneSegment alwaysOnRecordSceneSegment) throws RemoteException;

    void onVoiceActivity() throws RemoteException;

    public static class Default implements IAlwaysOnVoiceClient {
        @Override // android.media.alwayson.service.IAlwaysOnVoiceClient
        public void onCaptureRequest(AlwaysOnCaptureConfig config, AlwaysOnPreRollFetchResult preRoll) throws RemoteException {
        }

        @Override // android.media.alwayson.service.IAlwaysOnVoiceClient
        public void onCaptureUpdate(AlwaysOnCaptureConfig config) throws RemoteException {
        }

        @Override // android.media.alwayson.service.IAlwaysOnVoiceClient
        public void onCaptureStop(int stopScope, int reason, String optionalCallerTag) throws RemoteException {
        }

        @Override // android.media.alwayson.service.IAlwaysOnVoiceClient
        public void onReady() throws RemoteException {
        }

        @Override // android.media.alwayson.service.IAlwaysOnVoiceClient
        public void onVoiceActivity() throws RemoteException {
        }

        @Override // android.media.alwayson.service.IAlwaysOnVoiceClient
        public void onSceneChanged(AlwaysOnRecordSceneInfo scene) throws RemoteException {
        }

        @Override // android.media.alwayson.service.IAlwaysOnVoiceClient
        public void onSceneSegmentClosed(AlwaysOnRecordSceneSegment segment) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IAlwaysOnVoiceClient {
        static final int TRANSACTION_onCaptureRequest = 1;
        static final int TRANSACTION_onCaptureStop = 3;
        static final int TRANSACTION_onCaptureUpdate = 2;
        static final int TRANSACTION_onReady = 4;
        static final int TRANSACTION_onSceneChanged = 6;
        static final int TRANSACTION_onSceneSegmentClosed = 7;
        static final int TRANSACTION_onVoiceActivity = 5;

        public Stub() {
            attachInterface(this, IAlwaysOnVoiceClient.DESCRIPTOR);
        }

        public static IAlwaysOnVoiceClient asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IAlwaysOnVoiceClient.DESCRIPTOR);
            if (iin != null && (iin instanceof IAlwaysOnVoiceClient)) {
                return (IAlwaysOnVoiceClient) iin;
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
                    return "onCaptureRequest";
                case 2:
                    return "onCaptureUpdate";
                case 3:
                    return "onCaptureStop";
                case 4:
                    return "onReady";
                case 5:
                    return "onVoiceActivity";
                case 6:
                    return "onSceneChanged";
                case 7:
                    return "onSceneSegmentClosed";
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
                data.enforceInterface(IAlwaysOnVoiceClient.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IAlwaysOnVoiceClient.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    AlwaysOnCaptureConfig _arg0 = (AlwaysOnCaptureConfig) data.readTypedObject(AlwaysOnCaptureConfig.CREATOR);
                    AlwaysOnPreRollFetchResult _arg1 = (AlwaysOnPreRollFetchResult) data.readTypedObject(AlwaysOnPreRollFetchResult.CREATOR);
                    onCaptureRequest(_arg0, _arg1);
                    return true;
                case 2:
                    AlwaysOnCaptureConfig _arg02 = (AlwaysOnCaptureConfig) data.readTypedObject(AlwaysOnCaptureConfig.CREATOR);
                    onCaptureUpdate(_arg02);
                    return true;
                case 3:
                    int _arg03 = data.readInt();
                    int _arg12 = data.readInt();
                    String _arg2 = data.readString();
                    onCaptureStop(_arg03, _arg12, _arg2);
                    return true;
                case 4:
                    onReady();
                    return true;
                case 5:
                    onVoiceActivity();
                    return true;
                case 6:
                    AlwaysOnRecordSceneInfo _arg04 = (AlwaysOnRecordSceneInfo) data.readTypedObject(AlwaysOnRecordSceneInfo.CREATOR);
                    onSceneChanged(_arg04);
                    return true;
                case 7:
                    AlwaysOnRecordSceneSegment _arg05 = (AlwaysOnRecordSceneSegment) data.readTypedObject(AlwaysOnRecordSceneSegment.CREATOR);
                    onSceneSegmentClosed(_arg05);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IAlwaysOnVoiceClient {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IAlwaysOnVoiceClient.DESCRIPTOR;
            }

            @Override // android.media.alwayson.service.IAlwaysOnVoiceClient
            public void onCaptureRequest(AlwaysOnCaptureConfig config, AlwaysOnPreRollFetchResult preRoll) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IAlwaysOnVoiceClient.DESCRIPTOR);
                    _data.writeTypedObject(config, 0);
                    _data.writeTypedObject(preRoll, 0);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.media.alwayson.service.IAlwaysOnVoiceClient
            public void onCaptureUpdate(AlwaysOnCaptureConfig config) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IAlwaysOnVoiceClient.DESCRIPTOR);
                    _data.writeTypedObject(config, 0);
                    this.mRemote.transact(2, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.media.alwayson.service.IAlwaysOnVoiceClient
            public void onCaptureStop(int stopScope, int reason, String optionalCallerTag) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IAlwaysOnVoiceClient.DESCRIPTOR);
                    _data.writeInt(stopScope);
                    _data.writeInt(reason);
                    _data.writeString(optionalCallerTag);
                    this.mRemote.transact(3, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.media.alwayson.service.IAlwaysOnVoiceClient
            public void onReady() throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IAlwaysOnVoiceClient.DESCRIPTOR);
                    this.mRemote.transact(4, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.media.alwayson.service.IAlwaysOnVoiceClient
            public void onVoiceActivity() throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IAlwaysOnVoiceClient.DESCRIPTOR);
                    this.mRemote.transact(5, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.media.alwayson.service.IAlwaysOnVoiceClient
            public void onSceneChanged(AlwaysOnRecordSceneInfo scene) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IAlwaysOnVoiceClient.DESCRIPTOR);
                    _data.writeTypedObject(scene, 0);
                    this.mRemote.transact(6, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.media.alwayson.service.IAlwaysOnVoiceClient
            public void onSceneSegmentClosed(AlwaysOnRecordSceneSegment segment) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IAlwaysOnVoiceClient.DESCRIPTOR);
                    _data.writeTypedObject(segment, 0);
                    this.mRemote.transact(7, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 6;
        }
    }
}
