package com.miui.guardprovider.aidl;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ICancellationSignal;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface IVirusScanServer extends IInterface {
    public static final String DESCRIPTOR = "com.miui.guardprovider.aidl.IVirusScanServer";

    public static class Default implements IVirusScanServer {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.miui.guardprovider.aidl.IVirusScanServer
        public ICancellationSignal startScan(List<String> r1, IScanStateListener r2, Bundle r3) {
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r1, List.class, "com.obric.aiagent.plugin");
            IScanStateListener r4 = (IScanStateListener) ZeusTransformUtils.wrapperContextForParams(r2, IScanStateListener.class, "com.obric.aiagent.plugin");
            return null;
        }

        @Override // com.miui.guardprovider.aidl.IVirusScanServer
        public ICancellationSignal startScanWithPackageNames(List<String> r1, IScanStateListener r2, Bundle r3) {
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r1, List.class, "com.obric.aiagent.plugin");
            IScanStateListener r4 = (IScanStateListener) ZeusTransformUtils.wrapperContextForParams(r2, IScanStateListener.class, "com.obric.aiagent.plugin");
            return null;
        }

        @Override // com.miui.guardprovider.aidl.IVirusScanServer
        public ICancellationSignal update(IUpdateStateListener r2) {
            IUpdateStateListener r1 = (IUpdateStateListener) ZeusTransformUtils.wrapperContextForParams(r2, IUpdateStateListener.class, "com.obric.aiagent.plugin");
            return null;
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IVirusScanServer {
        static final int TRANSACTION_startScan = 1;
        static final int TRANSACTION_startScanWithPackageNames = 2;
        static final int TRANSACTION_update = 3;

        private static class Proxy implements IVirusScanServer {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IVirusScanServer.DESCRIPTOR;
            }

            Proxy(IBinder r3) {
                this.mRemote = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.miui.guardprovider.aidl.IVirusScanServer
            public ICancellationSignal startScan(List<String> r4, IScanStateListener r5, Bundle r6) {
                List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
                IScanStateListener r8 = (IScanStateListener) ZeusTransformUtils.wrapperContextForParams(r5, IScanStateListener.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IVirusScanServer.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStringList(r7);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r8);     // Catch: Throwable -> L6
                a.a(r0, r6, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                ICancellationSignal r3 = ICancellationSignal.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.miui.guardprovider.aidl.IVirusScanServer
            public ICancellationSignal startScanWithPackageNames(List<String> r4, IScanStateListener r5, Bundle r6) {
                List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
                IScanStateListener r8 = (IScanStateListener) ZeusTransformUtils.wrapperContextForParams(r5, IScanStateListener.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IVirusScanServer.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStringList(r7);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r8);     // Catch: Throwable -> L6
                a.a(r0, r6, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                ICancellationSignal r3 = ICancellationSignal.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.miui.guardprovider.aidl.IVirusScanServer
            public ICancellationSignal update(IUpdateStateListener r4) {
                IUpdateStateListener r5 = (IUpdateStateListener) ZeusTransformUtils.wrapperContextForParams(r4, IUpdateStateListener.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IVirusScanServer.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                ICancellationSignal r3 = ICancellationSignal.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IVirusScanServer.DESCRIPTOR);
        }

        public static IVirusScanServer asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(IVirusScanServer.DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IVirusScanServer.class) == false) goto L13;
            return (IVirusScanServer) ZeusTransformUtils.preCheckCast(r0, IVirusScanServer.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(IVirusScanServer.DESCRIPTOR);
        L8:
            if (r4 != 1598968902) goto L12;
            r6.writeString(IVirusScanServer.DESCRIPTOR);
            return true;
        L12:
            if (r4 != 1) goto L14;
            ICancellationSignal r3 = startScan(r5.createStringArrayList(), IScanStateListener.Stub.asInterface(r5.readStrongBinder()), (Bundle) ZeusTransformUtils.preCheckCast(a.a(r5, Bundle.CREATOR), Bundle.class, "com.obric.aiagent.plugin"));
            r6.writeNoException();
            r6.writeStrongInterface(r3);
        L22:
            return true;
        L14:
            if (r4 != 2) goto L16;
            ICancellationSignal r8 = startScanWithPackageNames(r5.createStringArrayList(), IScanStateListener.Stub.asInterface(r5.readStrongBinder()), (Bundle) ZeusTransformUtils.preCheckCast(a.a(r5, Bundle.CREATOR), Bundle.class, "com.obric.aiagent.plugin"));
            r6.writeNoException();
            r6.writeStrongInterface(r8);
            goto L22
        L16:
            if (r4 != 3) goto L18;
            ICancellationSignal r9 = update(IUpdateStateListener.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            r6.writeStrongInterface(r9);
            goto L22
        L18:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    public static class a {
        static /* synthetic */ Object a(Parcel r2, Parcelable.Creator r3) {
            return b(r2, (Parcelable.Creator) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.Creator.class, "com.obric.aiagent.plugin"));
        }

        static /* synthetic */ void a(Parcel r2, Parcelable r3, int r4) {
            b(r2, (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin"), r4);
        }

        private static <T> T b(Parcel r2, Parcelable.Creator<T> r3) {
            Parcelable.Creator r4 = (Parcelable.Creator) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.Creator.class, "com.obric.aiagent.plugin");
            if (r2.readInt() != 0) goto L5;
            return null;
        L5:
            return (T) r4.createFromParcel(r2);
        }

        private static <T extends Parcelable> void b(Parcel r2, T r3, int r4) {
            Parcelable r5 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L5;
            r2.writeInt(1);
            r5.writeToParcel(r2, r4);
            return;
        L5:
            r2.writeInt(0);
        }
    }

    ICancellationSignal startScan(List<String> r1, IScanStateListener r2, Bundle r3);

    ICancellationSignal startScanWithPackageNames(List<String> r1, IScanStateListener r2, Bundle r3);

    ICancellationSignal update(IUpdateStateListener r1);
}
