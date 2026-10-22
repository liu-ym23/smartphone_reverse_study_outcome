package stepai.android.mindx.base;

import X6.m;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import stepai.android.mindx.base.ILLMCallbackHandler;
import stepai.android.mindx.base.LLMInterface;

/* loaded from: classes4.dex */
public interface LLMInterface extends IInterface {
    public static final String DESCRIPTOR = "stepai.android.mindx.base.LLMInterface";

    public static class Default implements LLMInterface {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // stepai.android.mindx.base.LLMInterface
        public void chat(int i, String str, String str2) throws RemoteException {
        }

        @Override // stepai.android.mindx.base.LLMInterface
        public void chatWithImages(int i, String str, String str2, Bundle bundle) throws RemoteException {
        }

        @Override // stepai.android.mindx.base.LLMInterface
        public boolean checkResourceSupport(int i) throws RemoteException {
            return false;
        }

        @Override // stepai.android.mindx.base.LLMInterface
        public void init(ILLMCallbackHandler iLLMCallbackHandler, String str) throws RemoteException {
        }

        @Override // stepai.android.mindx.base.LLMInterface
        public void recordPathList(String str) throws RemoteException {
        }

        @Override // stepai.android.mindx.base.LLMInterface
        public void stream(int i, String str, String str2) throws RemoteException {
        }

        @Override // stepai.android.mindx.base.LLMInterface
        public void streamWithImages(int i, String str, String str2, Bundle bundle) throws RemoteException {
        }

        @Override // stepai.android.mindx.base.LLMInterface
        public Map<String, String> syncTraceBuffer() throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements LLMInterface {
        static final int TRANSACTION_chat = 4;
        static final int TRANSACTION_chatWithImages = 5;
        static final int TRANSACTION_checkResourceSupport = 6;
        static final int TRANSACTION_init = 1;
        static final int TRANSACTION_recordPathList = 7;
        static final int TRANSACTION_stream = 2;
        static final int TRANSACTION_streamWithImages = 3;
        static final int TRANSACTION_syncTraceBuffer = 8;

        public static class Proxy implements LLMInterface {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$syncTraceBuffer$0(Parcel parcel, Map map, int i) {
                map.put(parcel.readString(), parcel.readString());
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // stepai.android.mindx.base.LLMInterface
            public void chat(int i, String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(LLMInterface.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // stepai.android.mindx.base.LLMInterface
            public void chatWithImages(int i, String str, String str2, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(LLMInterface.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // stepai.android.mindx.base.LLMInterface
            public boolean checkResourceSupport(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(LLMInterface.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return LLMInterface.DESCRIPTOR;
            }

            @Override // stepai.android.mindx.base.LLMInterface
            public void init(ILLMCallbackHandler iLLMCallbackHandler, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(LLMInterface.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iLLMCallbackHandler);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // stepai.android.mindx.base.LLMInterface
            public void recordPathList(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(LLMInterface.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // stepai.android.mindx.base.LLMInterface
            public void stream(int i, String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(LLMInterface.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // stepai.android.mindx.base.LLMInterface
            public void streamWithImages(int i, String str, String str2, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(LLMInterface.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // stepai.android.mindx.base.LLMInterface
            public Map<String, String> syncTraceBuffer() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                final Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(LLMInterface.DESCRIPTOR);
                    this.mRemote.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    int i = parcelObtain2.readInt();
                    final HashMap map = i < 0 ? null : new HashMap();
                    IntStream.range(0, i).forEach(new IntConsumer() { // from class: stepai.android.mindx.base.a
                        @Override // java.util.function.IntConsumer
                        public final void accept(int i6) {
                            LLMInterface.Stub.Proxy.lambda$syncTraceBuffer$0(parcelObtain2, map, i6);
                        }
                    });
                    return map;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, LLMInterface.DESCRIPTOR);
        }

        public static LLMInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(LLMInterface.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof LLMInterface)) ? new Proxy(iBinder) : (LLMInterface) iInterfaceQueryLocalInterface;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onTransact$0(Parcel parcel, String str, String str2) {
            parcel.writeString(str);
            parcel.writeString(str2);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i6) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(LLMInterface.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(LLMInterface.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    init(ILLMCallbackHandler.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    stream(parcel.readInt(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    streamWithImages(parcel.readInt(), parcel.readString(), parcel.readString(), (Bundle) (parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    chat(parcel.readInt(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    chatWithImages(parcel.readInt(), parcel.readString(), parcel.readString(), (Bundle) (parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    boolean zCheckResourceSupport = checkResourceSupport(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zCheckResourceSupport ? 1 : 0);
                    return true;
                case 7:
                    recordPathList(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    Map<String, String> mapSyncTraceBuffer = syncTraceBuffer();
                    parcel2.writeNoException();
                    if (mapSyncTraceBuffer == null) {
                        parcel2.writeInt(-1);
                        return true;
                    }
                    parcel2.writeInt(mapSyncTraceBuffer.size());
                    mapSyncTraceBuffer.forEach(new m(parcel2, 2));
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i6);
            }
        }
    }

    void chat(int i, String str, String str2) throws RemoteException;

    void chatWithImages(int i, String str, String str2, Bundle bundle) throws RemoteException;

    boolean checkResourceSupport(int i) throws RemoteException;

    void init(ILLMCallbackHandler iLLMCallbackHandler, String str) throws RemoteException;

    void recordPathList(String str) throws RemoteException;

    void stream(int i, String str, String str2) throws RemoteException;

    void streamWithImages(int i, String str, String str2, Bundle bundle) throws RemoteException;

    Map<String, String> syncTraceBuffer() throws RemoteException;
}
