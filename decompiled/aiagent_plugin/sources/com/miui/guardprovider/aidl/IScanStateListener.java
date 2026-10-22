package com.miui.guardprovider.aidl;

import android.content.pm.PackageInfo;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface IScanStateListener extends IInterface {
    public static final String DESCRIPTOR = "com.miui.guardprovider.aidl.IScanStateListener";

    public static class Default implements IScanStateListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.miui.guardprovider.aidl.IScanStateListener
        public void onItemScanFinished(String r1, PackageInfo r2, List<ScanResultInfo> r3) {
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        }

        @Override // com.miui.guardprovider.aidl.IScanStateListener
        public void onItemScanStarted(String r1) {
        }

        @Override // com.miui.guardprovider.aidl.IScanStateListener
        public void onScanCompleted(int r1, String r2) {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IScanStateListener {
        static final int TRANSACTION_onItemScanFinished = 2;
        static final int TRANSACTION_onItemScanStarted = 1;
        static final int TRANSACTION_onScanCompleted = 3;

        private static class Proxy implements IScanStateListener {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IScanStateListener.DESCRIPTOR;
            }

            Proxy(IBinder r3) {
                this.mRemote = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.miui.guardprovider.aidl.IScanStateListener
            public void onItemScanStarted(String r3) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IScanStateListener.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r3);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.miui.guardprovider.aidl.IScanStateListener
            public void onItemScanFinished(String r3, PackageInfo r4, List<ScanResultInfo> r5) {
                List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IScanStateListener.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r3);     // Catch: Throwable -> L6
                a.a(r0, r4, 0);     // Catch: Throwable -> L6
                a.a(r0, r6, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.miui.guardprovider.aidl.IScanStateListener
            public void onScanCompleted(int r3, String r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IScanStateListener.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r3);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IScanStateListener.DESCRIPTOR);
        }

        public static IScanStateListener asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(IScanStateListener.DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IScanStateListener.class) == false) goto L13;
            return (IScanStateListener) ZeusTransformUtils.preCheckCast(r0, IScanStateListener.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(IScanStateListener.DESCRIPTOR);
        L8:
            if (r4 != 1598968902) goto L11;
            r6.writeString(IScanStateListener.DESCRIPTOR);
            return true;
        L11:
            if (r4 != 1) goto L13;
            onItemScanStarted(r5.readString());
        L21:
            return true;
        L13:
            if (r4 != 2) goto L15;
            onItemScanFinished(r5.readString(), (PackageInfo) ZeusTransformUtils.preCheckCast(a.a(r5, PackageInfo.CREATOR), PackageInfo.class, "com.obric.aiagent.plugin"), r5.createTypedArrayList(ScanResultInfo.CREATOR));
            goto L21
        L15:
            if (r4 != 3) goto L17;
            onScanCompleted(r5.readInt(), r5.readString());
            goto L21
        L17:
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

        static /* synthetic */ void a(Parcel r2, List r3, int r4) {
            b(r2, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), r4);
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

        private static <T extends Parcelable> void b(Parcel r5, List<T> r6, int r7) {
            List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
            if (r8 != null) goto L5;
            r5.writeInt(-1);
            return;
        L5:
            int r0 = r8.size();
            int r2 = 0;
            r5.writeInt(r0);
        L6:
            if (r2 >= r0) goto L10;
            b(r5, (Parcelable) ZeusTransformUtils.preCheckCast(r8.get(r2), Parcelable.class, "com.obric.aiagent.plugin"), r7);
            r2 = r2 + 1;
            goto L6
        }
    }

    void onItemScanFinished(String r1, PackageInfo r2, List<ScanResultInfo> r3);

    void onItemScanStarted(String r1);

    void onScanCompleted(int r1, String r2);
}
