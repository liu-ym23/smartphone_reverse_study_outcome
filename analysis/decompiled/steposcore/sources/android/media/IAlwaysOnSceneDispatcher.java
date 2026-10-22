package android.media;

import android.media.steposmanager.AlwaysOnRecordSceneInfo;
import android.media.steposmanager.AlwaysOnRecordSceneSegment;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IAlwaysOnSceneDispatcher extends IInterface {
    public static final String DESCRIPTOR = "android.media.IAlwaysOnSceneDispatcher";

    void dispatchSceneChanged(AlwaysOnRecordSceneInfo alwaysOnRecordSceneInfo) throws RemoteException;

    void dispatchSceneSegmentClosed(AlwaysOnRecordSceneSegment alwaysOnRecordSceneSegment) throws RemoteException;

    public static class Default implements IAlwaysOnSceneDispatcher {
        @Override // android.media.IAlwaysOnSceneDispatcher
        public void dispatchSceneChanged(AlwaysOnRecordSceneInfo scene) throws RemoteException {
        }

        @Override // android.media.IAlwaysOnSceneDispatcher
        public void dispatchSceneSegmentClosed(AlwaysOnRecordSceneSegment segment) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IAlwaysOnSceneDispatcher {
        static final int TRANSACTION_dispatchSceneChanged = 1;
        static final int TRANSACTION_dispatchSceneSegmentClosed = 2;

        public Stub() {
            attachInterface(this, IAlwaysOnSceneDispatcher.DESCRIPTOR);
        }

        public static IAlwaysOnSceneDispatcher asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IAlwaysOnSceneDispatcher.DESCRIPTOR);
            if (iin != null && (iin instanceof IAlwaysOnSceneDispatcher)) {
                return (IAlwaysOnSceneDispatcher) iin;
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
                    return "dispatchSceneChanged";
                case 2:
                    return "dispatchSceneSegmentClosed";
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
                data.enforceInterface(IAlwaysOnSceneDispatcher.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IAlwaysOnSceneDispatcher.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    AlwaysOnRecordSceneInfo _arg0 = (AlwaysOnRecordSceneInfo) data.readTypedObject(AlwaysOnRecordSceneInfo.CREATOR);
                    dispatchSceneChanged(_arg0);
                    return true;
                case 2:
                    AlwaysOnRecordSceneSegment _arg02 = (AlwaysOnRecordSceneSegment) data.readTypedObject(AlwaysOnRecordSceneSegment.CREATOR);
                    dispatchSceneSegmentClosed(_arg02);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IAlwaysOnSceneDispatcher {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IAlwaysOnSceneDispatcher.DESCRIPTOR;
            }

            @Override // android.media.IAlwaysOnSceneDispatcher
            public void dispatchSceneChanged(AlwaysOnRecordSceneInfo scene) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IAlwaysOnSceneDispatcher.DESCRIPTOR);
                    _data.writeTypedObject(scene, 0);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.media.IAlwaysOnSceneDispatcher
            public void dispatchSceneSegmentClosed(AlwaysOnRecordSceneSegment segment) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IAlwaysOnSceneDispatcher.DESCRIPTOR);
                    _data.writeTypedObject(segment, 0);
                    this.mRemote.transact(2, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 1;
        }
    }
}
