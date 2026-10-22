package com.obric.cae.libs.statusreport;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public interface ICaeStatusReportManager extends IInterface {

    public static class Default implements ICaeStatusReportManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.statusreport.ICaeStatusReportManager
        public String getCaeVersion() {
            return null;
        }

        @Override // com.obric.cae.libs.statusreport.ICaeStatusReportManager
        public LinkLayerQuality getLinkLayerQuality(String r1) {
            return null;
        }

        @Override // com.obric.cae.libs.statusreport.ICaeStatusReportManager
        public boolean registerLinkLayerQualityChangedListener(String r1, ILinkLayerQualityListener r2) {
            ILinkLayerQualityListener r0 = (ILinkLayerQualityListener) ZeusTransformUtils.wrapperContextForParams(r2, ILinkLayerQualityListener.class, "com.obric.aiagent.plugin");
            return false;
        }

        @Override // com.obric.cae.libs.statusreport.ICaeStatusReportManager
        public boolean unregisterLinkLayerQualityChangedListener(String r1, ILinkLayerQualityListener r2) {
            ILinkLayerQualityListener r0 = (ILinkLayerQualityListener) ZeusTransformUtils.wrapperContextForParams(r2, ILinkLayerQualityListener.class, "com.obric.aiagent.plugin");
            return false;
        }
    }

    public static abstract class Stub extends Binder implements ICaeStatusReportManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.statusreport.ICaeStatusReportManager";
        static final int TRANSACTION_getCaeVersion = 4;
        static final int TRANSACTION_getLinkLayerQuality = 3;
        static final int TRANSACTION_registerLinkLayerQualityChangedListener = 1;
        static final int TRANSACTION_unregisterLinkLayerQualityChangedListener = 2;

        public static class Proxy implements ICaeStatusReportManager {
            public static ICaeStatusReportManager sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r3) {
                this.mRemote = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cae.libs.statusreport.ICaeStatusReportManager
            public String getCaeVersion() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r5 = Stub.getDefaultImpl().getCaeVersion();     // Catch: Throwable -> L13
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

            @Override // com.obric.cae.libs.statusreport.ICaeStatusReportManager
            public LinkLayerQuality getLinkLayerQuality(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                LinkLayerQuality r4 = (LinkLayerQuality) ZeusTransformUtils.preCheckCast(LinkLayerQuality.CREATOR.createFromParcel(r1), LinkLayerQuality.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                LinkLayerQuality r6 = Stub.getDefaultImpl().getLinkLayerQuality(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r6;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.statusreport.ICaeStatusReportManager
            public boolean registerLinkLayerQualityChangedListener(String r5, ILinkLayerQualityListener r6) {
                ILinkLayerQualityListener r7 = (ILinkLayerQualityListener) ZeusTransformUtils.wrapperContextForParams(r6, ILinkLayerQualityListener.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                r0.writeString(r5);     // Catch: Throwable -> L19
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L19
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L19
                boolean r3 = false;
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L19
                if (r1.readInt() == 0) goto L17;
                r3 = true;
            L17:
                r1.recycle();
                r0.recycle();
                return r3;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r4 = Stub.getDefaultImpl().registerLinkLayerQualityChangedListener(r5, r7);     // Catch: Throwable -> L19
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                r2 = null;
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.statusreport.ICaeStatusReportManager
            public boolean unregisterLinkLayerQualityChangedListener(String r5, ILinkLayerQualityListener r6) {
                ILinkLayerQualityListener r7 = (ILinkLayerQualityListener) ZeusTransformUtils.wrapperContextForParams(r6, ILinkLayerQualityListener.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                r0.writeString(r5);     // Catch: Throwable -> L19
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L19
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L19
                boolean r3 = false;
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L19
                if (r1.readInt() == 0) goto L17;
                r3 = true;
            L17:
                r1.recycle();
                r0.recycle();
                return r3;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r4 = Stub.getDefaultImpl().unregisterLinkLayerQualityChangedListener(r5, r7);     // Catch: Throwable -> L19
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                r2 = null;
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICaeStatusReportManager asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, ICaeStatusReportManager.class) == false) goto L13;
            return (ICaeStatusReportManager) ZeusTransformUtils.preCheckCast(r0, ICaeStatusReportManager.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        public static ICaeStatusReportManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICaeStatusReportManager r2) {
            ICaeStatusReportManager r3 = (ICaeStatusReportManager) ZeusTransformUtils.wrapperContextForParams(r2, ICaeStatusReportManager.class, "com.obric.aiagent.plugin");
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
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 == 1598968902) goto L24;
            if (r4 != 1) goto L6;
            r5.enforceInterface(DESCRIPTOR);
            boolean r3 = registerLinkLayerQualityChangedListener(r5.readString(), ILinkLayerQualityListener.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            r6.writeInt(r3 ? 1 : 0);
            return true;
        L6:
            if (r4 != 2) goto L8;
            r5.enforceInterface(DESCRIPTOR);
            boolean r8 = unregisterLinkLayerQualityChangedListener(r5.readString(), ILinkLayerQualityListener.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            r6.writeInt(r8 ? 1 : 0);
            return true;
        L8:
            if (r4 != 3) goto L10;
            r5.enforceInterface(DESCRIPTOR);
            LinkLayerQuality r9 = getLinkLayerQuality(r5.readString());
            r6.writeNoException();
            if (r9 == null) goto L18;
            r6.writeInt(1);
            r9.writeToParcel(r6, 1);
        L19:
            return true;
        L18:
            r6.writeInt(0);
            goto L19
        L10:
            if (r4 != 4) goto L12;
            r5.enforceInterface(DESCRIPTOR);
            String r10 = getCaeVersion();
            r6.writeNoException();
            r6.writeString(r10);
            return true;
        L12:
            return super.onTransact(r4, r5, r6, r7);
        L24:
            r6.writeString(DESCRIPTOR);
            return true;
        }
    }

    String getCaeVersion();

    LinkLayerQuality getLinkLayerQuality(String r1);

    boolean registerLinkLayerQualityChangedListener(String r1, ILinkLayerQualityListener r2);

    boolean unregisterLinkLayerQualityChangedListener(String r1, ILinkLayerQualityListener r2);
}
