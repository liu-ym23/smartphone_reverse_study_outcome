package com.obric.cae.libs.wifi;

import android.net.wifi.ScanResult;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.obric.cae.libs.appscene.IAppSceneCallback;
import com.obric.cae.libs.appscene.IAppSceneQueueCallback;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface ICaeSmartNetworkManager extends IInterface {
    public static final String DESCRIPTOR = "com.obric.cae.libs.wifi.ICaeSmartNetworkManager";

    public static class Default implements ICaeSmartNetworkManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public String getCurrentSecondarySsid() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public int getLinkThroughput() throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public int getLinkThroughputJitter() throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public float getLinkThroughputJitterWeight() throws RemoteException {
            return 0.0f;
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public List<ScanResult> getSecondaryWifiList() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void registerAppSceneCallback(IAppSceneCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void registerAppSceneQueueCallback(IAppSceneQueueCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void registerLinkThroughputListener(ICaeWifiLinkThroughputListener r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void registerSecondaryWifiListener(ISecondaryWifiCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void releaseAll() throws RemoteException {
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void releaseSecondaryWifi(ISecondaryWifiCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void requestSecondaryWifi(String r1, String r2, String r3, String r4, ISecondaryWifiCallback r5) throws RemoteException {
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void unregisterAppSceneCallback(IAppSceneCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void unregisterAppSceneQueueCallback(IAppSceneQueueCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void unregisterLinkThroughputListener(ICaeWifiLinkThroughputListener r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void unregisterSecondaryWifiListener(ISecondaryWifiCallback r1) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICaeSmartNetworkManager {
        static final int TRANSACTION_getCurrentSecondarySsid = 11;
        static final int TRANSACTION_getLinkThroughput = 3;
        static final int TRANSACTION_getLinkThroughputJitter = 4;
        static final int TRANSACTION_getLinkThroughputJitterWeight = 5;
        static final int TRANSACTION_getSecondaryWifiList = 12;
        static final int TRANSACTION_registerAppSceneCallback = 13;
        static final int TRANSACTION_registerAppSceneQueueCallback = 15;
        static final int TRANSACTION_registerLinkThroughputListener = 1;
        static final int TRANSACTION_registerSecondaryWifiListener = 8;
        static final int TRANSACTION_releaseAll = 10;
        static final int TRANSACTION_releaseSecondaryWifi = 7;
        static final int TRANSACTION_requestSecondaryWifi = 6;
        static final int TRANSACTION_unregisterAppSceneCallback = 14;
        static final int TRANSACTION_unregisterAppSceneQueueCallback = 16;
        static final int TRANSACTION_unregisterLinkThroughputListener = 2;
        static final int TRANSACTION_unregisterSecondaryWifiListener = 9;

        public static class Proxy implements ICaeSmartNetworkManager {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public String getCurrentSecondarySsid() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeSmartNetworkManager.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(11, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                String r2 = r1.readString();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return ICaeSmartNetworkManager.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public int getLinkThroughput() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeSmartNetworkManager.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                int r2 = r1.readInt();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public int getLinkThroughputJitter() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeSmartNetworkManager.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(4, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                int r2 = r1.readInt();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public float getLinkThroughputJitterWeight() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeSmartNetworkManager.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(5, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                float r2 = r1.readFloat();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public List<ScanResult> getSecondaryWifiList() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeSmartNetworkManager.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(12, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                ArrayList r2 = r1.createTypedArrayList(ScanResult.CREATOR);     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void registerAppSceneCallback(IAppSceneCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeSmartNetworkManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(13, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void registerAppSceneQueueCallback(IAppSceneQueueCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeSmartNetworkManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(15, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void registerLinkThroughputListener(ICaeWifiLinkThroughputListener r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeSmartNetworkManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void registerSecondaryWifiListener(ISecondaryWifiCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeSmartNetworkManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(8, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void releaseAll() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeSmartNetworkManager.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(10, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void releaseSecondaryWifi(ISecondaryWifiCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeSmartNetworkManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(7, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void requestSecondaryWifi(String r4, String r5, String r6, String r7, ISecondaryWifiCallback r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeSmartNetworkManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                r0.writeString(r6);     // Catch: Throwable -> L6
                r0.writeString(r7);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r8);     // Catch: Throwable -> L6
                this.mRemote.transact(6, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void unregisterAppSceneCallback(IAppSceneCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeSmartNetworkManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(14, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void unregisterAppSceneQueueCallback(IAppSceneQueueCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeSmartNetworkManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(16, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void unregisterLinkThroughputListener(ICaeWifiLinkThroughputListener r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeSmartNetworkManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void unregisterSecondaryWifiListener(ISecondaryWifiCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeSmartNetworkManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(9, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, ICaeSmartNetworkManager.DESCRIPTOR);
        }

        public static ICaeSmartNetworkManager asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(ICaeSmartNetworkManager.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICaeSmartNetworkManager) == false) goto L12;
            return (ICaeSmartNetworkManager) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r9, Parcel r10, Parcel r11, int r12) throws RemoteException {
            if (r9 < 1) goto L8;
            if (r9 > 16777215) goto L8;
            r10.enforceInterface(ICaeSmartNetworkManager.DESCRIPTOR);
        L8:
            if (r9 == 1598968902) goto L29;
            switch(r9) {
                case 1: goto L27;
                case 2: goto L26;
                case 3: goto L25;
                case 4: goto L24;
                case 5: goto L23;
                case 6: goto L22;
                case 7: goto L21;
                case 8: goto L20;
                case 9: goto L19;
                case 10: goto L18;
                case 11: goto L17;
                case 12: goto L16;
                case 13: goto L15;
                case 14: goto L14;
                case 15: goto L13;
                case 16: goto L12;
                default: goto L11;
            };
        L12:
            unregisterAppSceneQueueCallback(IAppSceneQueueCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
        L28:
            return true;
        L13:
            registerAppSceneQueueCallback(IAppSceneQueueCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            goto L28
        L14:
            unregisterAppSceneCallback(IAppSceneCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            goto L28
        L15:
            registerAppSceneCallback(IAppSceneCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            goto L28
        L16:
            List<ScanResult> r13 = getSecondaryWifiList();
            r11.writeNoException();
            r11.writeTypedList(r13);
            goto L28
        L17:
            String r14 = getCurrentSecondarySsid();
            r11.writeNoException();
            r11.writeString(r14);
            goto L28
        L18:
            releaseAll();
            r11.writeNoException();
            goto L28
        L19:
            unregisterSecondaryWifiListener(ISecondaryWifiCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            goto L28
        L20:
            registerSecondaryWifiListener(ISecondaryWifiCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            goto L28
        L21:
            releaseSecondaryWifi(ISecondaryWifiCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            goto L28
        L22:
            requestSecondaryWifi(r10.readString(), r10.readString(), r10.readString(), r10.readString(), ISecondaryWifiCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            goto L28
        L23:
            float r15 = getLinkThroughputJitterWeight();
            r11.writeNoException();
            r11.writeFloat(r15);
            goto L28
        L24:
            int r16 = getLinkThroughputJitter();
            r11.writeNoException();
            r11.writeInt(r16);
            goto L28
        L25:
            int r17 = getLinkThroughput();
            r11.writeNoException();
            r11.writeInt(r17);
            goto L28
        L26:
            unregisterLinkThroughputListener(ICaeWifiLinkThroughputListener.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            goto L28
        L27:
            registerLinkThroughputListener(ICaeWifiLinkThroughputListener.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            goto L28
        L11:
            return super.onTransact(r9, r10, r11, r12);
        L29:
            r11.writeString(ICaeSmartNetworkManager.DESCRIPTOR);
            return true;
        }
    }

    public static class _Parcel {
        public _Parcel() {
        }
    }

    String getCurrentSecondarySsid() throws RemoteException;

    int getLinkThroughput() throws RemoteException;

    int getLinkThroughputJitter() throws RemoteException;

    float getLinkThroughputJitterWeight() throws RemoteException;

    List<ScanResult> getSecondaryWifiList() throws RemoteException;

    void registerAppSceneCallback(IAppSceneCallback r1) throws RemoteException;

    void registerAppSceneQueueCallback(IAppSceneQueueCallback r1) throws RemoteException;

    void registerLinkThroughputListener(ICaeWifiLinkThroughputListener r1) throws RemoteException;

    void registerSecondaryWifiListener(ISecondaryWifiCallback r1) throws RemoteException;

    void releaseAll() throws RemoteException;

    void releaseSecondaryWifi(ISecondaryWifiCallback r1) throws RemoteException;

    void requestSecondaryWifi(String r1, String r2, String r3, String r4, ISecondaryWifiCallback r5) throws RemoteException;

    void unregisterAppSceneCallback(IAppSceneCallback r1) throws RemoteException;

    void unregisterAppSceneQueueCallback(IAppSceneQueueCallback r1) throws RemoteException;

    void unregisterLinkThroughputListener(ICaeWifiLinkThroughputListener r1) throws RemoteException;

    void unregisterSecondaryWifiListener(ISecondaryWifiCallback r1) throws RemoteException;
}
