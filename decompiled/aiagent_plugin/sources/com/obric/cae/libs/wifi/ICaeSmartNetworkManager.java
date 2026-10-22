package com.obric.cae.libs.wifi;

import android.net.wifi.ScanResult;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface ICaeSmartNetworkManager extends IInterface {

    public static class Default implements ICaeSmartNetworkManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public String getCurrentSecondarySsid() {
            return null;
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public int getLinkThroughput() {
            return 0;
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public int getLinkThroughputJitter() {
            return 0;
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public float getLinkThroughputJitterWeight() {
            return 0.0f;
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public List<ScanResult> getSecondaryWifiList() {
            return null;
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void registerLinkThroughputListener(ICaeWifiLinkThroughputListener r2) {
            ICaeWifiLinkThroughputListener r1 = (ICaeWifiLinkThroughputListener) ZeusTransformUtils.wrapperContextForParams(r2, ICaeWifiLinkThroughputListener.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void registerSecondaryWifiListener(ISecondaryWifiCallback r2) {
            ISecondaryWifiCallback r1 = (ISecondaryWifiCallback) ZeusTransformUtils.wrapperContextForParams(r2, ISecondaryWifiCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void releaseAll() {
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void releaseSecondaryWifi(ISecondaryWifiCallback r2) {
            ISecondaryWifiCallback r1 = (ISecondaryWifiCallback) ZeusTransformUtils.wrapperContextForParams(r2, ISecondaryWifiCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void requestSecondaryWifi(String r1, String r2, String r3, String r4, ISecondaryWifiCallback r5) {
            ISecondaryWifiCallback r0 = (ISecondaryWifiCallback) ZeusTransformUtils.wrapperContextForParams(r5, ISecondaryWifiCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void unregisterLinkThroughputListener(ICaeWifiLinkThroughputListener r2) {
            ICaeWifiLinkThroughputListener r1 = (ICaeWifiLinkThroughputListener) ZeusTransformUtils.wrapperContextForParams(r2, ICaeWifiLinkThroughputListener.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void unregisterSecondaryWifiListener(ISecondaryWifiCallback r2) {
            ISecondaryWifiCallback r1 = (ISecondaryWifiCallback) ZeusTransformUtils.wrapperContextForParams(r2, ISecondaryWifiCallback.class, "com.obric.aiagent.plugin");
        }
    }

    public static abstract class Stub extends Binder implements ICaeSmartNetworkManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.wifi.ICaeSmartNetworkManager";
        static final int TRANSACTION_getCurrentSecondarySsid = 11;
        static final int TRANSACTION_getLinkThroughput = 3;
        static final int TRANSACTION_getLinkThroughputJitter = 4;
        static final int TRANSACTION_getLinkThroughputJitterWeight = 5;
        static final int TRANSACTION_getSecondaryWifiList = 12;
        static final int TRANSACTION_registerLinkThroughputListener = 1;
        static final int TRANSACTION_registerSecondaryWifiListener = 8;
        static final int TRANSACTION_releaseAll = 10;
        static final int TRANSACTION_releaseSecondaryWifi = 7;
        static final int TRANSACTION_requestSecondaryWifi = 6;
        static final int TRANSACTION_unregisterLinkThroughputListener = 2;
        static final int TRANSACTION_unregisterSecondaryWifiListener = 9;

        public static class Proxy implements ICaeSmartNetworkManager {
            public static ICaeSmartNetworkManager sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r3) {
                this.mRemote = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public String getCurrentSecondarySsid() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(11, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r5 = Stub.getDefaultImpl().getCurrentSecondarySsid();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public int getLinkThroughput() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r5 = Stub.getDefaultImpl().getLinkThroughput();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public int getLinkThroughputJitter() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r5 = Stub.getDefaultImpl().getLinkThroughputJitter();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public float getLinkThroughputJitterWeight() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                float r4 = r1.readFloat();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                float r5 = Stub.getDefaultImpl().getLinkThroughputJitterWeight();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public List<ScanResult> getSecondaryWifiList() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(12, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r4 = r1.createTypedArrayList(ScanResult.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<ScanResult> r5 = Stub.getDefaultImpl().getSecondaryWifiList();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void registerLinkThroughputListener(ICaeWifiLinkThroughputListener r5) {
                ICaeWifiLinkThroughputListener r6 = (ICaeWifiLinkThroughputListener) ZeusTransformUtils.wrapperContextForParams(r5, ICaeWifiLinkThroughputListener.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerLinkThroughputListener(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void registerSecondaryWifiListener(ISecondaryWifiCallback r5) {
                ISecondaryWifiCallback r6 = (ISecondaryWifiCallback) ZeusTransformUtils.wrapperContextForParams(r5, ISecondaryWifiCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(8, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerSecondaryWifiListener(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void releaseAll() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(10, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().releaseAll();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void releaseSecondaryWifi(ISecondaryWifiCallback r5) {
                ISecondaryWifiCallback r6 = (ISecondaryWifiCallback) ZeusTransformUtils.wrapperContextForParams(r5, ISecondaryWifiCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(7, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().releaseSecondaryWifi(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void requestSecondaryWifi(String r8, String r9, String r10, String r11, ISecondaryWifiCallback r12) {
                ISecondaryWifiCallback r5 = (ISecondaryWifiCallback) ZeusTransformUtils.wrapperContextForParams(r12, ISecondaryWifiCallback.class, "com.obric.aiagent.plugin");
                Parcel r13 = Parcel.obtain();
                Parcel r6 = Parcel.obtain();
                r13.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r13.writeString(r8);     // Catch: Throwable -> L17
                r13.writeString(r9);     // Catch: Throwable -> L17
                r13.writeString(r10);     // Catch: Throwable -> L17
                r13.writeString(r11);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                IBinder r0 = r5.asBinder();     // Catch: Throwable -> L17
            L7:
                r13.writeStrongBinder(r0);     // Catch: Throwable -> L17
                if (this.mRemote.transact(6, r13, r6, 0) == false) goto L10;
            L14:
                r6.readException();     // Catch: Throwable -> L17
                r6.recycle();
                r13.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().requestSecondaryWifi(r8, r9, r10, r11, r5);     // Catch: Throwable -> L17
                r6.recycle();
                r13.recycle();
                return;
            L6:
                r0 = null;
            L17:
                th = move-exception;
                r6.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void unregisterLinkThroughputListener(ICaeWifiLinkThroughputListener r5) {
                ICaeWifiLinkThroughputListener r6 = (ICaeWifiLinkThroughputListener) ZeusTransformUtils.wrapperContextForParams(r5, ICaeWifiLinkThroughputListener.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterLinkThroughputListener(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void unregisterSecondaryWifiListener(ISecondaryWifiCallback r5) {
                ISecondaryWifiCallback r6 = (ISecondaryWifiCallback) ZeusTransformUtils.wrapperContextForParams(r5, ISecondaryWifiCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(9, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterSecondaryWifiListener(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICaeSmartNetworkManager asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, ICaeSmartNetworkManager.class) == false) goto L13;
            return (ICaeSmartNetworkManager) ZeusTransformUtils.preCheckCast(r0, ICaeSmartNetworkManager.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        public static ICaeSmartNetworkManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICaeSmartNetworkManager r2) {
            ICaeSmartNetworkManager r3 = (ICaeSmartNetworkManager) ZeusTransformUtils.wrapperContextForParams(r2, ICaeSmartNetworkManager.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r3 == null) goto L7;
            Proxy.sDefaultImpl = r3;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r8, Parcel r9, Parcel r10, int r11) {
            if (r8 == 1598968902) goto L31;
            switch(r8) {
                case 1: goto L29;
                case 2: goto L27;
                case 3: goto L25;
                case 4: goto L23;
                case 5: goto L21;
                case 6: goto L19;
                case 7: goto L17;
                case 8: goto L15;
                case 9: goto L13;
                case 10: goto L11;
                case 11: goto L9;
                case 12: goto L7;
                default: goto L6;
            };
        L7:
            r9.enforceInterface(DESCRIPTOR);
            List<ScanResult> r7 = getSecondaryWifiList();
            r10.writeNoException();
            r10.writeTypedList(r7);
            return true;
        L9:
            r9.enforceInterface(DESCRIPTOR);
            String r12 = getCurrentSecondarySsid();
            r10.writeNoException();
            r10.writeString(r12);
            return true;
        L11:
            r9.enforceInterface(DESCRIPTOR);
            releaseAll();
            r10.writeNoException();
            return true;
        L13:
            r9.enforceInterface(DESCRIPTOR);
            unregisterSecondaryWifiListener(ISecondaryWifiCallback.Stub.asInterface(r9.readStrongBinder()));
            r10.writeNoException();
            return true;
        L15:
            r9.enforceInterface(DESCRIPTOR);
            registerSecondaryWifiListener(ISecondaryWifiCallback.Stub.asInterface(r9.readStrongBinder()));
            r10.writeNoException();
            return true;
        L17:
            r9.enforceInterface(DESCRIPTOR);
            releaseSecondaryWifi(ISecondaryWifiCallback.Stub.asInterface(r9.readStrongBinder()));
            r10.writeNoException();
            return true;
        L19:
            r9.enforceInterface(DESCRIPTOR);
            requestSecondaryWifi(r9.readString(), r9.readString(), r9.readString(), r9.readString(), ISecondaryWifiCallback.Stub.asInterface(r9.readStrongBinder()));
            r10.writeNoException();
            return true;
        L21:
            r9.enforceInterface(DESCRIPTOR);
            float r13 = getLinkThroughputJitterWeight();
            r10.writeNoException();
            r10.writeFloat(r13);
            return true;
        L23:
            r9.enforceInterface(DESCRIPTOR);
            int r14 = getLinkThroughputJitter();
            r10.writeNoException();
            r10.writeInt(r14);
            return true;
        L25:
            r9.enforceInterface(DESCRIPTOR);
            int r15 = getLinkThroughput();
            r10.writeNoException();
            r10.writeInt(r15);
            return true;
        L27:
            r9.enforceInterface(DESCRIPTOR);
            unregisterLinkThroughputListener(ICaeWifiLinkThroughputListener.Stub.asInterface(r9.readStrongBinder()));
            r10.writeNoException();
            return true;
        L29:
            r9.enforceInterface(DESCRIPTOR);
            registerLinkThroughputListener(ICaeWifiLinkThroughputListener.Stub.asInterface(r9.readStrongBinder()));
            r10.writeNoException();
            return true;
        L6:
            return super.onTransact(r8, r9, r10, r11);
        L31:
            r10.writeString(DESCRIPTOR);
            return true;
        }
    }

    String getCurrentSecondarySsid();

    int getLinkThroughput();

    int getLinkThroughputJitter();

    float getLinkThroughputJitterWeight();

    List<ScanResult> getSecondaryWifiList();

    void registerLinkThroughputListener(ICaeWifiLinkThroughputListener r1);

    void registerSecondaryWifiListener(ISecondaryWifiCallback r1);

    void releaseAll();

    void releaseSecondaryWifi(ISecondaryWifiCallback r1);

    void requestSecondaryWifi(String r1, String r2, String r3, String r4, ISecondaryWifiCallback r5);

    void unregisterLinkThroughputListener(ICaeWifiLinkThroughputListener r1);

    void unregisterSecondaryWifiListener(ISecondaryWifiCallback r1);
}
