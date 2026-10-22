package com.obric.cae.libs.statusreport;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public interface ILinkLayerQualityListener extends IInterface {

    public static class Default implements ILinkLayerQualityListener {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.statusreport.ILinkLayerQualityListener
        public void onAverLinkLayerLevelChanged(LinkLayerQuality r1) {
        }

        @Override // com.obric.cae.libs.statusreport.ILinkLayerQualityListener
        public void onLinkLayerLevelChanged(LinkLayerQuality r1) {
        }

        @Override // com.obric.cae.libs.statusreport.ILinkLayerQualityListener
        public void onLinkLayerQualityChanged(LinkLayerQuality r1) {
        }
    }

    public static abstract class Stub extends Binder implements ILinkLayerQualityListener {
        private static final String DESCRIPTOR = "com.obric.cae.libs.statusreport.ILinkLayerQualityListener";
        static final int TRANSACTION_onAverLinkLayerLevelChanged = 3;
        static final int TRANSACTION_onLinkLayerLevelChanged = 2;
        static final int TRANSACTION_onLinkLayerQualityChanged = 1;

        public static class Proxy implements ILinkLayerQualityListener {
            public static ILinkLayerQualityListener sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r3) {
                this.mRemote = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.statusreport.ILinkLayerQualityListener
            public void onAverLinkLayerLevelChanged(LinkLayerQuality r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onAverLinkLayerLevelChanged(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.statusreport.ILinkLayerQualityListener
            public void onLinkLayerLevelChanged(LinkLayerQuality r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onLinkLayerLevelChanged(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.statusreport.ILinkLayerQualityListener
            public void onLinkLayerQualityChanged(LinkLayerQuality r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onLinkLayerQualityChanged(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
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

        public static ILinkLayerQualityListener asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, ILinkLayerQualityListener.class) == false) goto L13;
            return (ILinkLayerQualityListener) ZeusTransformUtils.preCheckCast(r0, ILinkLayerQualityListener.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        public static ILinkLayerQualityListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ILinkLayerQualityListener r2) {
            ILinkLayerQualityListener r3 = (ILinkLayerQualityListener) ZeusTransformUtils.wrapperContextForParams(r2, ILinkLayerQualityListener.class, "com.obric.aiagent.plugin");
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
        public boolean onTransact(int r6, Parcel r7, Parcel r8, int r9) {
            LinkLayerQuality r1 = null;
            if (r6 != 1) goto L5;
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L27;
            r1 = (LinkLayerQuality) ZeusTransformUtils.preCheckCast(LinkLayerQuality.CREATOR.createFromParcel(r7), LinkLayerQuality.class, "com.obric.aiagent.plugin");
        L27:
            onLinkLayerQualityChanged(r1);
            r8.writeNoException();
            return true;
        L5:
            if (r6 != 2) goto L7;
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L22;
            r1 = (LinkLayerQuality) ZeusTransformUtils.preCheckCast(LinkLayerQuality.CREATOR.createFromParcel(r7), LinkLayerQuality.class, "com.obric.aiagent.plugin");
        L22:
            onLinkLayerLevelChanged(r1);
            r8.writeNoException();
            return true;
        L7:
            if (r6 != 3) goto L9;
            r7.enforceInterface(DESCRIPTOR);
            if (r7.readInt() == 0) goto L17;
            r1 = (LinkLayerQuality) ZeusTransformUtils.preCheckCast(LinkLayerQuality.CREATOR.createFromParcel(r7), LinkLayerQuality.class, "com.obric.aiagent.plugin");
        L17:
            onAverLinkLayerLevelChanged(r1);
            r8.writeNoException();
            return true;
        L9:
            if (r6 != 1598968902) goto L11;
            r8.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r6, r7, r8, r9);
        }
    }

    void onAverLinkLayerLevelChanged(LinkLayerQuality r1);

    void onLinkLayerLevelChanged(LinkLayerQuality r1);

    void onLinkLayerQualityChanged(LinkLayerQuality r1);
}
