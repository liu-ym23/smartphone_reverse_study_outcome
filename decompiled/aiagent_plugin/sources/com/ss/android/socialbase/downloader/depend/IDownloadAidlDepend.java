package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public interface IDownloadAidlDepend extends IInterface {

    public static class Default implements IDownloadAidlDepend {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend
        public void monitorLogSend(DownloadInfo r1, BaseException r2, int r3) {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IDownloadAidlDepend {
        private static final String DESCRIPTOR = "com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend";
        static final int TRANSACTION_monitorLogSend = 1;

        private static class Proxy implements IDownloadAidlDepend {
            public static IDownloadAidlDepend sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder r3) {
                this.mRemote = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend
            public void monitorLogSend(DownloadInfo r5, BaseException r6, int r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L7:
                if (r6 == null) goto L9;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L10:
                r0.writeInt(r7);     // Catch: Throwable -> L20
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().monitorLogSend(r5, r6, r7);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L9:
                r0.writeInt(0);     // Catch: Throwable -> L20
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
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
            attachInterface(this, DESCRIPTOR);
        }

        public static IDownloadAidlDepend asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IDownloadAidlDepend.class) == false) goto L13;
            return (IDownloadAidlDepend) ZeusTransformUtils.preCheckCast(r0, IDownloadAidlDepend.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            BaseException r1 = null;
            if (r5.readInt() == 0) goto L13;
            DownloadInfo r8 = (DownloadInfo) ZeusTransformUtils.preCheckCast(DownloadInfo.CREATOR.createFromParcel(r5), DownloadInfo.class, "com.obric.aiagent.plugin");
        L15:
            if (r5.readInt() == 0) goto L17;
            r1 = (BaseException) ZeusTransformUtils.preCheckCast(BaseException.CREATOR.createFromParcel(r5), BaseException.class, "com.obric.aiagent.plugin");
        L17:
            monitorLogSend(r8, r1, r5.readInt());
            r6.writeNoException();
            return true;
        L13:
            r8 = null;
            goto L15
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }

        public static boolean setDefaultImpl(IDownloadAidlDepend r2) {
            IDownloadAidlDepend r3 = (IDownloadAidlDepend) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadAidlDepend.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r3 == null) goto L7;
            Proxy.sDefaultImpl = r3;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        public static IDownloadAidlDepend getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void monitorLogSend(DownloadInfo r1, BaseException r2, int r3);
}
