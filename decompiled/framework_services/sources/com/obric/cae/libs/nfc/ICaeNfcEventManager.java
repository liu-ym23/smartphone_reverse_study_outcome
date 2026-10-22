package com.obric.cae.libs.nfc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface ICaeNfcEventManager extends IInterface {
    public static final String DESCRIPTOR = "com.obric.cae.libs.nfc.ICaeNfcEventManager";

    public static class Default implements ICaeNfcEventManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public int getMetricsEventCapabilities() throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public int getTransitEventAllowedAidTypes() throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public int getTransitEventSource() throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public boolean isTransitEventFilterEnabled() throws RemoteException {
            return false;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void notifyTeaEvent(String r1, Bundle r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void notifyTransitEvent(Bundle r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void registerCloudConfigCallback(ICaeNfcCloudConfigCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void registerDndConfigCallback(ICaeNfcDndConfigCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void registerForceFwEventCallback(ICaeNfcForceFwEventCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void registerPaymentChangeCallback(ICaeNfcPaymentChangeCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void registerTransitEventCallback(ICaeNfcTransitEventCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void registerVendorNciEventCallback(ICaeNfcVendorNciEventCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public int reportMetricsEvent(int r1, int r2, Bundle r3) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public boolean setTransitEventAllowedAidTypes(int r1) throws RemoteException {
            return false;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public boolean setTransitEventFilterEnabled(boolean r1) throws RemoteException {
            return false;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public boolean setTransitEventSource(int r1) throws RemoteException {
            return false;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void unregisterCloudConfigCallback(ICaeNfcCloudConfigCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void unregisterDndConfigCallback(ICaeNfcDndConfigCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void unregisterForceFwEventCallback(ICaeNfcForceFwEventCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void unregisterPaymentChangeCallback(ICaeNfcPaymentChangeCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void unregisterTransitEventCallback(ICaeNfcTransitEventCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void unregisterVendorNciEventCallback(ICaeNfcVendorNciEventCallback r1) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICaeNfcEventManager {
        static final int TRANSACTION_getMetricsEventCapabilities = 22;
        static final int TRANSACTION_getTransitEventAllowedAidTypes = 20;
        static final int TRANSACTION_getTransitEventSource = 16;
        static final int TRANSACTION_isTransitEventFilterEnabled = 18;
        static final int TRANSACTION_notifyTeaEvent = 14;
        static final int TRANSACTION_notifyTransitEvent = 13;
        static final int TRANSACTION_registerCloudConfigCallback = 1;
        static final int TRANSACTION_registerDndConfigCallback = 3;
        static final int TRANSACTION_registerForceFwEventCallback = 5;
        static final int TRANSACTION_registerPaymentChangeCallback = 11;
        static final int TRANSACTION_registerTransitEventCallback = 7;
        static final int TRANSACTION_registerVendorNciEventCallback = 9;
        static final int TRANSACTION_reportMetricsEvent = 21;
        static final int TRANSACTION_setTransitEventAllowedAidTypes = 19;
        static final int TRANSACTION_setTransitEventFilterEnabled = 17;
        static final int TRANSACTION_setTransitEventSource = 15;
        static final int TRANSACTION_unregisterCloudConfigCallback = 2;
        static final int TRANSACTION_unregisterDndConfigCallback = 4;
        static final int TRANSACTION_unregisterForceFwEventCallback = 6;
        static final int TRANSACTION_unregisterPaymentChangeCallback = 12;
        static final int TRANSACTION_unregisterTransitEventCallback = 8;
        static final int TRANSACTION_unregisterVendorNciEventCallback = 10;

        public static class Proxy implements ICaeNfcEventManager {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ICaeNfcEventManager.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public int getMetricsEventCapabilities() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeNfcEventManager.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(22, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public int getTransitEventAllowedAidTypes() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeNfcEventManager.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(20, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public int getTransitEventSource() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeNfcEventManager.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(16, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public boolean isTransitEventFilterEnabled() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeNfcEventManager.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean r4 = false;
                this.mRemote.transact(18, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r4 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r4;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void notifyTeaEvent(String r4, Bundle r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeNfcEventManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                if (r5 == null) goto L8;
                r0.writeInt(1);     // Catch: Throwable -> L6
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L6
            L9:
                this.mRemote.transact(14, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L8:
                r0.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void notifyTransitEvent(Bundle r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeNfcEventManager.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r5 == null) goto L8;
                r0.writeInt(1);     // Catch: Throwable -> L6
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L6
            L9:
                this.mRemote.transact(13, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L8:
                r0.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void registerCloudConfigCallback(ICaeNfcCloudConfigCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeNfcEventManager.DESCRIPTOR);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void registerDndConfigCallback(ICaeNfcDndConfigCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeNfcEventManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void registerForceFwEventCallback(ICaeNfcForceFwEventCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeNfcEventManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(5, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void registerPaymentChangeCallback(ICaeNfcPaymentChangeCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeNfcEventManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(11, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void registerTransitEventCallback(ICaeNfcTransitEventCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeNfcEventManager.DESCRIPTOR);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void registerVendorNciEventCallback(ICaeNfcVendorNciEventCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeNfcEventManager.DESCRIPTOR);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public int reportMetricsEvent(int r4, int r5, Bundle r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeNfcEventManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                if (r6 == null) goto L8;
                r0.writeInt(1);     // Catch: Throwable -> L6
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L6
            L9:
                this.mRemote.transact(21, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                int r7 = r1.readInt();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r7;
            L8:
                r0.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public boolean setTransitEventAllowedAidTypes(int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeNfcEventManager.DESCRIPTOR);     // Catch: Throwable -> L8
                r0.writeInt(r5);     // Catch: Throwable -> L8
                boolean r3 = false;
                this.mRemote.transact(19, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r3 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r3;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public boolean setTransitEventFilterEnabled(boolean r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeNfcEventManager.DESCRIPTOR);     // Catch: Throwable -> L8
                r0.writeInt(r5 ? 1 : 0);     // Catch: Throwable -> L8
                boolean r3 = false;
                this.mRemote.transact(17, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r3 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r3;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public boolean setTransitEventSource(int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeNfcEventManager.DESCRIPTOR);     // Catch: Throwable -> L8
                r0.writeInt(r5);     // Catch: Throwable -> L8
                boolean r3 = false;
                this.mRemote.transact(15, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r3 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r3;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void unregisterCloudConfigCallback(ICaeNfcCloudConfigCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeNfcEventManager.DESCRIPTOR);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void unregisterDndConfigCallback(ICaeNfcDndConfigCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeNfcEventManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(4, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void unregisterForceFwEventCallback(ICaeNfcForceFwEventCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeNfcEventManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void unregisterPaymentChangeCallback(ICaeNfcPaymentChangeCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeNfcEventManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(12, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void unregisterTransitEventCallback(ICaeNfcTransitEventCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeNfcEventManager.DESCRIPTOR);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void unregisterVendorNciEventCallback(ICaeNfcVendorNciEventCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeNfcEventManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
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
        }

        public Stub() {
            attachInterface(this, ICaeNfcEventManager.DESCRIPTOR);
        }

        public static ICaeNfcEventManager asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(ICaeNfcEventManager.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICaeNfcEventManager) == false) goto L12;
            return (ICaeNfcEventManager) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(ICaeNfcEventManager.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L39;
            switch(r4) {
                case 1: goto L37;
                case 2: goto L36;
                case 3: goto L35;
                case 4: goto L34;
                case 5: goto L33;
                case 6: goto L32;
                case 7: goto L31;
                case 8: goto L30;
                case 9: goto L29;
                case 10: goto L28;
                case 11: goto L27;
                case 12: goto L26;
                case 13: goto L25;
                case 14: goto L24;
                case 15: goto L23;
                case 16: goto L22;
                case 17: goto L18;
                case 18: goto L16;
                case 19: goto L15;
                case 20: goto L14;
                case 21: goto L13;
                case 22: goto L12;
                default: goto L11;
            };
        L12:
            int r8 = getMetricsEventCapabilities();
            r6.writeNoException();
            r6.writeInt(r8);
        L38:
            return true;
        L13:
            int r9 = reportMetricsEvent(r5.readInt(), r5.readInt(), (Bundle) _Parcel.a(r5, Bundle.CREATOR));
            r6.writeNoException();
            r6.writeInt(r9);
            goto L38
        L14:
            int r10 = getTransitEventAllowedAidTypes();
            r6.writeNoException();
            r6.writeInt(r10);
            goto L38
        L15:
            boolean r11 = setTransitEventAllowedAidTypes(r5.readInt());
            r6.writeNoException();
            r6.writeInt(r11 ? 1 : 0);
            goto L38
        L16:
            boolean r12 = isTransitEventFilterEnabled();
            r6.writeNoException();
            r6.writeInt(r12 ? 1 : 0);
            goto L38
        L22:
            int r13 = getTransitEventSource();
            r6.writeNoException();
            r6.writeInt(r13);
            goto L38
        L23:
            boolean r14 = setTransitEventSource(r5.readInt());
            r6.writeNoException();
            r6.writeInt(r14 ? 1 : 0);
            goto L38
        L24:
            notifyTeaEvent(r5.readString(), (Bundle) _Parcel.a(r5, Bundle.CREATOR));
            goto L38
        L25:
            notifyTransitEvent((Bundle) _Parcel.a(r5, Bundle.CREATOR));
            goto L38
        L26:
            unregisterPaymentChangeCallback(ICaeNfcPaymentChangeCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L38
        L27:
            registerPaymentChangeCallback(ICaeNfcPaymentChangeCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L38
        L28:
            unregisterVendorNciEventCallback(ICaeNfcVendorNciEventCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L38
        L29:
            registerVendorNciEventCallback(ICaeNfcVendorNciEventCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L38
        L30:
            unregisterTransitEventCallback(ICaeNfcTransitEventCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L38
        L31:
            registerTransitEventCallback(ICaeNfcTransitEventCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L38
        L32:
            unregisterForceFwEventCallback(ICaeNfcForceFwEventCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L38
        L33:
            registerForceFwEventCallback(ICaeNfcForceFwEventCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L38
        L34:
            unregisterDndConfigCallback(ICaeNfcDndConfigCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L38
        L35:
            registerDndConfigCallback(ICaeNfcDndConfigCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L38
        L36:
            unregisterCloudConfigCallback(ICaeNfcCloudConfigCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L38
        L37:
            registerCloudConfigCallback(ICaeNfcCloudConfigCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L38
        L11:
            return super.onTransact(r4, r5, r6, r7);
        L18:
            if (r5.readInt() == 0) goto L20;
            boolean r15 = true;
        L21:
            boolean r16 = setTransitEventFilterEnabled(r15);
            r6.writeNoException();
            r6.writeInt(r16 ? 1 : 0);
            goto L38
        L20:
            r15 = false;
            goto L21
        L39:
            r6.writeString(ICaeNfcEventManager.DESCRIPTOR);
            return true;
        }
    }

    public static class _Parcel {
        public _Parcel() {
        }

        public static Object a(Parcel r1, Parcelable.Creator r2) {
            if (r1.readInt() != 0) goto L7;
            return null;
        L7:
            return r2.createFromParcel(r1);
        }
    }

    int getMetricsEventCapabilities() throws RemoteException;

    int getTransitEventAllowedAidTypes() throws RemoteException;

    int getTransitEventSource() throws RemoteException;

    boolean isTransitEventFilterEnabled() throws RemoteException;

    void notifyTeaEvent(String r1, Bundle r2) throws RemoteException;

    void notifyTransitEvent(Bundle r1) throws RemoteException;

    void registerCloudConfigCallback(ICaeNfcCloudConfigCallback r1) throws RemoteException;

    void registerDndConfigCallback(ICaeNfcDndConfigCallback r1) throws RemoteException;

    void registerForceFwEventCallback(ICaeNfcForceFwEventCallback r1) throws RemoteException;

    void registerPaymentChangeCallback(ICaeNfcPaymentChangeCallback r1) throws RemoteException;

    void registerTransitEventCallback(ICaeNfcTransitEventCallback r1) throws RemoteException;

    void registerVendorNciEventCallback(ICaeNfcVendorNciEventCallback r1) throws RemoteException;

    int reportMetricsEvent(int r1, int r2, Bundle r3) throws RemoteException;

    boolean setTransitEventAllowedAidTypes(int r1) throws RemoteException;

    boolean setTransitEventFilterEnabled(boolean r1) throws RemoteException;

    boolean setTransitEventSource(int r1) throws RemoteException;

    void unregisterCloudConfigCallback(ICaeNfcCloudConfigCallback r1) throws RemoteException;

    void unregisterDndConfigCallback(ICaeNfcDndConfigCallback r1) throws RemoteException;

    void unregisterForceFwEventCallback(ICaeNfcForceFwEventCallback r1) throws RemoteException;

    void unregisterPaymentChangeCallback(ICaeNfcPaymentChangeCallback r1) throws RemoteException;

    void unregisterTransitEventCallback(ICaeNfcTransitEventCallback r1) throws RemoteException;

    void unregisterVendorNciEventCallback(ICaeNfcVendorNciEventCallback r1) throws RemoteException;
}
