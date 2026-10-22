package com.stepos.perfcore;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.stepos.perfcore.IPerfCore;
import com.stepos.perfcore.IPerfCoreClient;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

/* loaded from: classes.dex */
public interface IPerfCore extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.perfcore.IPerfCore";

    public static class Default implements IPerfCore {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.perfcore.IPerfCore
        public int perfHintAcqAndRelease(String[] strArr, String str, Map<String, String> map, String str2, int i) throws RemoteException {
            return 0;
        }

        @Override // com.stepos.perfcore.IPerfCore
        public int perfHintAcquire(String[] strArr, String str, Map<String, String> map, String str2) throws RemoteException {
            return 0;
        }

        @Override // com.stepos.perfcore.IPerfCore
        public int perfHintRelease(int i) throws RemoteException {
            return 0;
        }

        @Override // com.stepos.perfcore.IPerfCore
        public int setClientBinder(IPerfCoreClient iPerfCoreClient) throws RemoteException {
            return 0;
        }
    }

    int perfHintAcqAndRelease(String[] strArr, String str, Map<String, String> map, String str2, int i) throws RemoteException;

    int perfHintAcquire(String[] strArr, String str, Map<String, String> map, String str2) throws RemoteException;

    int perfHintRelease(int i) throws RemoteException;

    int setClientBinder(IPerfCoreClient iPerfCoreClient) throws RemoteException;

    public static abstract class Stub extends Binder implements IPerfCore {
        static final int TRANSACTION_perfHintAcqAndRelease = 4;
        static final int TRANSACTION_perfHintAcquire = 2;
        static final int TRANSACTION_perfHintRelease = 3;
        static final int TRANSACTION_setClientBinder = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IPerfCore.DESCRIPTOR);
        }

        public static IPerfCore asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IPerfCore.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IPerfCore)) {
                return (IPerfCore) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, final Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IPerfCore.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IPerfCore.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                IPerfCoreClient iPerfCoreClientAsInterface = IPerfCoreClient.Stub.asInterface(parcel.readStrongBinder());
                parcel.enforceNoDataAvail();
                int clientBinder = setClientBinder(iPerfCoreClientAsInterface);
                parcel2.writeNoException();
                parcel2.writeInt(clientBinder);
            } else if (i == 2) {
                final HashMap map = null;
                String[] strArrCreateStringArray = parcel.createStringArray();
                String string = parcel.readString();
                int i3 = parcel.readInt();
                if (i3 >= 0) {
                    map = new HashMap();
                }
                IntStream.range(0, i3).forEach(new IntConsumer() { // from class: com.stepos.perfcore.IPerfCore$Stub$$ExternalSyntheticLambda0
                    @Override // java.util.function.IntConsumer
                    public final void accept(int i4) {
                        Parcel parcel3 = parcel;
                        map.put(parcel3.readString(), parcel3.readString());
                    }
                });
                String string2 = parcel.readString();
                parcel.enforceNoDataAvail();
                int iPerfHintAcquire = perfHintAcquire(strArrCreateStringArray, string, map, string2);
                parcel2.writeNoException();
                parcel2.writeInt(iPerfHintAcquire);
            } else if (i == 3) {
                int i4 = parcel.readInt();
                parcel.enforceNoDataAvail();
                int iPerfHintRelease = perfHintRelease(i4);
                parcel2.writeNoException();
                parcel2.writeInt(iPerfHintRelease);
            } else if (i == 4) {
                HashMap map2 = null;
                String[] strArrCreateStringArray2 = parcel.createStringArray();
                String string3 = parcel.readString();
                int i5 = parcel.readInt();
                if (i5 >= 0) {
                    map2 = new HashMap();
                }
                final HashMap map3 = map2;
                IntStream.range(0, i5).forEach(new IntConsumer() { // from class: com.stepos.perfcore.IPerfCore$Stub$$ExternalSyntheticLambda1
                    @Override // java.util.function.IntConsumer
                    public final void accept(int i6) {
                        Parcel parcel3 = parcel;
                        map3.put(parcel3.readString(), parcel3.readString());
                    }
                });
                String string4 = parcel.readString();
                int i6 = parcel.readInt();
                parcel.enforceNoDataAvail();
                int iPerfHintAcqAndRelease = perfHintAcqAndRelease(strArrCreateStringArray2, string3, map3, string4, i6);
                parcel2.writeNoException();
                parcel2.writeInt(iPerfHintAcqAndRelease);
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        static class Proxy implements IPerfCore {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IPerfCore.DESCRIPTOR;
            }

            @Override // com.stepos.perfcore.IPerfCore
            public int setClientBinder(IPerfCoreClient iPerfCoreClient) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IPerfCore.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iPerfCoreClient);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.perfcore.IPerfCore
            public int perfHintAcquire(String[] strArr, String str, Map<String, String> map, String str2) throws RemoteException {
                final Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IPerfCore.DESCRIPTOR);
                    parcelObtain.writeStringArray(strArr);
                    parcelObtain.writeString(str);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new BiConsumer() { // from class: com.stepos.perfcore.IPerfCore$Stub$Proxy$$ExternalSyntheticLambda1
                            @Override // java.util.function.BiConsumer
                            public final void accept(Object obj, Object obj2) {
                                IPerfCore.Stub.Proxy.lambda$perfHintAcquire$0(parcelObtain, (String) obj, (String) obj2);
                            }
                        });
                    }
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            static /* synthetic */ void lambda$perfHintAcquire$0(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            @Override // com.stepos.perfcore.IPerfCore
            public int perfHintRelease(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IPerfCore.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.perfcore.IPerfCore
            public int perfHintAcqAndRelease(String[] strArr, String str, Map<String, String> map, String str2, int i) throws RemoteException {
                final Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IPerfCore.DESCRIPTOR);
                    parcelObtain.writeStringArray(strArr);
                    parcelObtain.writeString(str);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new BiConsumer() { // from class: com.stepos.perfcore.IPerfCore$Stub$Proxy$$ExternalSyntheticLambda0
                            @Override // java.util.function.BiConsumer
                            public final void accept(Object obj, Object obj2) {
                                IPerfCore.Stub.Proxy.lambda$perfHintAcqAndRelease$1(parcelObtain, (String) obj, (String) obj2);
                            }
                        });
                    }
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            static /* synthetic */ void lambda$perfHintAcqAndRelease$1(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }
        }
    }
}
