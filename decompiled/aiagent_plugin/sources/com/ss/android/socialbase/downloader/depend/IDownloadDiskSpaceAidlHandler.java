package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public interface IDownloadDiskSpaceAidlHandler extends IInterface {

    public static class Default implements IDownloadDiskSpaceAidlHandler {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler
        public boolean cleanUpDisk(long r1, long r3, IDownloadDiskSpaceAidlCallback r5) {
            IDownloadDiskSpaceAidlCallback r0 = (IDownloadDiskSpaceAidlCallback) ZeusTransformUtils.wrapperContextForParams(r5, IDownloadDiskSpaceAidlCallback.class, "com.obric.aiagent.plugin");
            return false;
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IDownloadDiskSpaceAidlHandler {
        private static final String DESCRIPTOR = "com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler";
        static final int TRANSACTION_cleanUpDisk = 1;

        private static class Proxy implements IDownloadDiskSpaceAidlHandler {
            public static IDownloadDiskSpaceAidlHandler sDefaultImpl;
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

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler
            public boolean cleanUpDisk(long r8, long r10, IDownloadDiskSpaceAidlCallback r12) {
                IDownloadDiskSpaceAidlCallback r5 = (IDownloadDiskSpaceAidlCallback) ZeusTransformUtils.wrapperContextForParams(r12, IDownloadDiskSpaceAidlCallback.class, "com.obric.aiagent.plugin");
                Parcel r13 = Parcel.obtain();
                Parcel r6 = Parcel.obtain();
                r13.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                r13.writeLong(r8);     // Catch: Throwable -> L19
                r13.writeLong(r10);     // Catch: Throwable -> L19
                if (r5 == null) goto L6;
                IBinder r0 = r5.asBinder();     // Catch: Throwable -> L19
            L7:
                r13.writeStrongBinder(r0);     // Catch: Throwable -> L19
                boolean r1 = false;
                if (this.mRemote.transact(1, r13, r6, 0) == false) goto L10;
            L14:
                r6.readException();     // Catch: Throwable -> L19
                if (r6.readInt() == 0) goto L17;
                r1 = true;
            L17:
                r6.recycle();
                r13.recycle();
                return r1;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r7 = Stub.getDefaultImpl().cleanUpDisk(r8, r10, r5);     // Catch: Throwable -> L19
                r6.recycle();
                r13.recycle();
                return r7;
            L6:
                r0 = null;
            L19:
                th = move-exception;
                r6.recycle();
                r13.recycle();
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

        public static IDownloadDiskSpaceAidlHandler asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IDownloadDiskSpaceAidlHandler.class) == false) goto L13;
            return (IDownloadDiskSpaceAidlHandler) ZeusTransformUtils.preCheckCast(r0, IDownloadDiskSpaceAidlHandler.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r8, Parcel r9, Parcel r10, int r11) {
            if (r8 != 1) goto L5;
            r9.enforceInterface(DESCRIPTOR);
            boolean r7 = cleanUpDisk(r9.readLong(), r9.readLong(), IDownloadDiskSpaceAidlCallback.Stub.asInterface(r9.readStrongBinder()));
            r10.writeNoException();
            r10.writeInt(r7 ? 1 : 0);
            return true;
        L5:
            if (r8 != 1598968902) goto L7;
            r10.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r8, r9, r10, r11);
        }

        public static boolean setDefaultImpl(IDownloadDiskSpaceAidlHandler r2) {
            IDownloadDiskSpaceAidlHandler r3 = (IDownloadDiskSpaceAidlHandler) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadDiskSpaceAidlHandler.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r3 == null) goto L7;
            Proxy.sDefaultImpl = r3;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        public static IDownloadDiskSpaceAidlHandler getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    boolean cleanUpDisk(long r1, long r3, IDownloadDiskSpaceAidlCallback r5);
}
