package com.obric.cae.libs.statusreport;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface ICaeStatusReportManager extends IInterface {
    public static final String DESCRIPTOR = "com.obric.cae.libs.statusreport.ICaeStatusReportManager";

    public static class Default implements ICaeStatusReportManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.statusreport.ICaeStatusReportManager
        public String getCaeVersion() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.statusreport.ICaeStatusReportManager
        public LinkLayerQuality getLinkLayerQuality(String r1) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.statusreport.ICaeStatusReportManager
        public boolean registerLinkLayerQualityChangedListener(String r1, ILinkLayerQualityListener r2) throws RemoteException {
            return false;
        }

        @Override // com.obric.cae.libs.statusreport.ICaeStatusReportManager
        public boolean unregisterLinkLayerQualityChangedListener(String r1, ILinkLayerQualityListener r2) throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements ICaeStatusReportManager {
        static final int TRANSACTION_getCaeVersion = 4;
        static final int TRANSACTION_getLinkLayerQuality = 3;
        static final int TRANSACTION_registerLinkLayerQualityChangedListener = 1;
        static final int TRANSACTION_unregisterLinkLayerQualityChangedListener = 2;

        public static class Proxy implements ICaeStatusReportManager {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cae.libs.statusreport.ICaeStatusReportManager
            public String getCaeVersion() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeStatusReportManager.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(4, r0, r1, 0);     // Catch: Throwable -> L6
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
                return ICaeStatusReportManager.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.statusreport.ICaeStatusReportManager
            public LinkLayerQuality getLinkLayerQuality(String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeStatusReportManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                Parcelable.Creator<LinkLayerQuality> r6 = LinkLayerQuality.CREATOR;     // Catch: Throwable -> L6
                if (r1.readInt() == 0) goto L8;
                LinkLayerQuality r7 = r6.createFromParcel(r1);     // Catch: Throwable -> L6
            L9:
                LinkLayerQuality r8 = r7;     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r8;
            L8:
                r7 = null;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.statusreport.ICaeStatusReportManager
            public boolean registerLinkLayerQualityChangedListener(String r4, ILinkLayerQualityListener r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeStatusReportManager.DESCRIPTOR);     // Catch: Throwable -> L8
                r0.writeString(r4);     // Catch: Throwable -> L8
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L8
                boolean r6 = false;
                this.mRemote.transact(1, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r6 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r6;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.statusreport.ICaeStatusReportManager
            public boolean unregisterLinkLayerQualityChangedListener(String r4, ILinkLayerQualityListener r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeStatusReportManager.DESCRIPTOR);     // Catch: Throwable -> L8
                r0.writeString(r4);     // Catch: Throwable -> L8
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L8
                boolean r2 = false;
                this.mRemote.transact(2, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r2 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r2;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, ICaeStatusReportManager.DESCRIPTOR);
        }

        public static ICaeStatusReportManager asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(ICaeStatusReportManager.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICaeStatusReportManager) == false) goto L12;
            return (ICaeStatusReportManager) r0;
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
            r5.enforceInterface(ICaeStatusReportManager.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L17;
            switch(r4) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                default: goto L11;
            };
        L12:
            String r8 = getCaeVersion();
            r6.writeNoException();
            r6.writeString(r8);
        L16:
            return true;
        L13:
            LinkLayerQuality r9 = getLinkLayerQuality(r5.readString());
            r6.writeNoException();
            _Parcel.a(r6, r9);
            goto L16
        L14:
            boolean r10 = unregisterLinkLayerQualityChangedListener(r5.readString(), ILinkLayerQualityListener.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            r6.writeInt(r10 ? 1 : 0);
            goto L16
        L15:
            boolean r11 = registerLinkLayerQualityChangedListener(r5.readString(), ILinkLayerQualityListener.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            r6.writeInt(r11 ? 1 : 0);
            goto L16
        L11:
            return super.onTransact(r4, r5, r6, r7);
        L17:
            r6.writeString(ICaeStatusReportManager.DESCRIPTOR);
            return true;
        }
    }

    public static class _Parcel {
        public _Parcel() {
        }

        public static void a(Parcel r1, LinkLayerQuality r2) {
            if (r2 == null) goto L4;
            r1.writeInt(1);
            r2.writeToParcel(r1, 1);
            return;
        L4:
            r1.writeInt(0);
        }
    }

    String getCaeVersion() throws RemoteException;

    LinkLayerQuality getLinkLayerQuality(String r1) throws RemoteException;

    boolean registerLinkLayerQualityChangedListener(String r1, ILinkLayerQualityListener r2) throws RemoteException;

    boolean unregisterLinkLayerQualityChangedListener(String r1, ILinkLayerQualityListener r2) throws RemoteException;
}
