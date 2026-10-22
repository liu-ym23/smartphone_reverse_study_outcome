package com.stepos.statsapp.v3.lib.plugin;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsCallback;
import com.stepos.statsapp.v3.lib.plugin.emitter.EmitterConfig;
import com.stepos.statsapp.v3.lib.plugin.net.NetResponse;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public interface IVccOfflineStatsInterface extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsInterface";

    public static class Default implements IVccOfflineStatsInterface {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsInterface
        public void emitterAddEvent(String str, String str2, String str3, long j10, TrackerPayload trackerPayload) throws RemoteException {
        }

        @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsInterface
        public void emitterAddEventRealtime(String str, String str2, String str3, long j10, TrackerPayload trackerPayload) throws RemoteException {
        }

        @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsInterface
        public void emitterBulkAddEvents(String str, String str2, String str3, List list, List list2) throws RemoteException {
        }

        @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsInterface
        public void emitterFlush(String str) throws RemoteException {
        }

        @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsInterface
        public String emitterGetUmid(String str) throws RemoteException {
            return null;
        }

        @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsInterface
        public void emitterUpdateConfig(String str, EmitterConfig emitterConfig) throws RemoteException {
        }

        @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsInterface
        public void emitterUpdateEventSource(String str, String str2) throws RemoteException {
        }

        @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsInterface
        public NetResponse netRequest(String str, Map map, String str2) throws RemoteException {
            return null;
        }

        @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsInterface
        public String requestAppConfig(String str) throws RemoteException {
            return null;
        }

        @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsInterface
        public void setCallback(String str, IVccOfflineStatsCallback iVccOfflineStatsCallback) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IVccOfflineStatsInterface {
        static final int TRANSACTION_emitterAddEvent = 1;
        static final int TRANSACTION_emitterAddEventRealtime = 2;
        static final int TRANSACTION_emitterBulkAddEvents = 3;
        static final int TRANSACTION_emitterFlush = 4;
        static final int TRANSACTION_emitterGetUmid = 6;
        static final int TRANSACTION_emitterUpdateConfig = 5;
        static final int TRANSACTION_emitterUpdateEventSource = 7;
        static final int TRANSACTION_netRequest = 8;
        static final int TRANSACTION_requestAppConfig = 10;
        static final int TRANSACTION_setCallback = 9;

        public static class Proxy implements IVccOfflineStatsInterface {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsInterface
            public void emitterAddEvent(String str, String str2, String str3, long j10, TrackerPayload trackerPayload) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVccOfflineStatsInterface.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeLong(j10);
                    a.b(parcelObtain, trackerPayload, 0);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsInterface
            public void emitterAddEventRealtime(String str, String str2, String str3, long j10, TrackerPayload trackerPayload) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVccOfflineStatsInterface.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeLong(j10);
                    a.b(parcelObtain, trackerPayload, 0);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsInterface
            public void emitterBulkAddEvents(String str, String str2, String str3, List list, List list2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVccOfflineStatsInterface.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeList(list);
                    parcelObtain.writeList(list2);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsInterface
            public void emitterFlush(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVccOfflineStatsInterface.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsInterface
            public String emitterGetUmid(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVccOfflineStatsInterface.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsInterface
            public void emitterUpdateConfig(String str, EmitterConfig emitterConfig) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVccOfflineStatsInterface.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    a.b(parcelObtain, emitterConfig, 0);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsInterface
            public void emitterUpdateEventSource(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVccOfflineStatsInterface.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IVccOfflineStatsInterface.DESCRIPTOR;
            }

            @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsInterface
            public NetResponse netRequest(String str, Map map, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVccOfflineStatsInterface.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeMap(map);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (NetResponse) a.b(parcelObtain2, NetResponse.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsInterface
            public String requestAppConfig(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVccOfflineStatsInterface.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsInterface
            public void setCallback(String str, IVccOfflineStatsCallback iVccOfflineStatsCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVccOfflineStatsInterface.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongInterface(iVccOfflineStatsCallback);
                    this.mRemote.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IVccOfflineStatsInterface.DESCRIPTOR);
        }

        public static IVccOfflineStatsInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IVccOfflineStatsInterface.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IVccOfflineStatsInterface)) ? new Proxy(iBinder) : (IVccOfflineStatsInterface) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IVccOfflineStatsInterface.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IVccOfflineStatsInterface.DESCRIPTOR);
                return true;
            }
            switch (i10) {
                case 1:
                    emitterAddEvent(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong(), (TrackerPayload) a.b(parcel, TrackerPayload.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    emitterAddEventRealtime(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong(), (TrackerPayload) a.b(parcel, TrackerPayload.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    String string = parcel.readString();
                    String string2 = parcel.readString();
                    String string3 = parcel.readString();
                    ClassLoader classLoader = getClass().getClassLoader();
                    emitterBulkAddEvents(string, string2, string3, parcel.readArrayList(classLoader), parcel.readArrayList(classLoader));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    emitterFlush(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    emitterUpdateConfig(parcel.readString(), (EmitterConfig) a.b(parcel, EmitterConfig.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    String strEmitterGetUmid = emitterGetUmid(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strEmitterGetUmid);
                    return true;
                case 7:
                    emitterUpdateEventSource(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    NetResponse netResponseNetRequest = netRequest(parcel.readString(), parcel.readHashMap(getClass().getClassLoader()), parcel.readString());
                    parcel2.writeNoException();
                    a.b(parcel2, netResponseNetRequest, 1);
                    return true;
                case 9:
                    setCallback(parcel.readString(), IVccOfflineStatsCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 10:
                    String strRequestAppConfig = requestAppConfig(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strRequestAppConfig);
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }
    }

    public static class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T b(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void b(Parcel parcel, T t10, int i10) {
            if (t10 != null) {
                parcel.writeInt(1);
                t10.writeToParcel(parcel, i10);
            } else {
                parcel.writeInt(0);
            }
        }
    }

    void emitterAddEvent(String str, String str2, String str3, long j10, TrackerPayload trackerPayload) throws RemoteException;

    void emitterAddEventRealtime(String str, String str2, String str3, long j10, TrackerPayload trackerPayload) throws RemoteException;

    void emitterBulkAddEvents(String str, String str2, String str3, List list, List list2) throws RemoteException;

    void emitterFlush(String str) throws RemoteException;

    String emitterGetUmid(String str) throws RemoteException;

    void emitterUpdateConfig(String str, EmitterConfig emitterConfig) throws RemoteException;

    void emitterUpdateEventSource(String str, String str2) throws RemoteException;

    NetResponse netRequest(String str, Map map, String str2) throws RemoteException;

    String requestAppConfig(String str) throws RemoteException;

    void setCallback(String str, IVccOfflineStatsCallback iVccOfflineStatsCallback) throws RemoteException;
}
