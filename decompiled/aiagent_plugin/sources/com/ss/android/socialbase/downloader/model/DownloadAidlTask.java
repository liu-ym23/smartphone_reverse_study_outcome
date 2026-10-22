package com.ss.android.socialbase.downloader.model;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlListener;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public interface DownloadAidlTask extends IInterface {

    public static class Default implements DownloadAidlTask {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadAidlDepend getDepend() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadDiskSpaceAidlHandler getDiskSpaceHandler() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadCompleteAidlHandler getDownloadCompleteAidlHandlerByIndex(int r1) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public int getDownloadCompleteHandlerSize() {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public DownloadInfo getDownloadInfo() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadAidlListener getDownloadListenerByHashCode(int r1, int r2) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public int[] getDownloadListenerHashCodeLists(int r1) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadNotificationEventAidlListener getDownloadNotificationEventListener() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadAidlFileProvider getFileProvider() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadForbiddenAidlHandler getForbiddenHandler() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadAidlInterceptor getInterceptor() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadAidlMonitorDepend getMonitorDepend() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public INotificationClickAidlCallback getNotificationClickCallback() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadAidlListener getSingleDownloadListener(int r1) {
            return null;
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements DownloadAidlTask {
        private static final String DESCRIPTOR = "com.ss.android.socialbase.downloader.model.DownloadAidlTask";
        static final int TRANSACTION_getDepend = 8;
        static final int TRANSACTION_getDiskSpaceHandler = 10;
        static final int TRANSACTION_getDownloadCompleteAidlHandlerByIndex = 14;
        static final int TRANSACTION_getDownloadCompleteHandlerSize = 13;
        static final int TRANSACTION_getDownloadInfo = 1;
        static final int TRANSACTION_getDownloadListenerByHashCode = 3;
        static final int TRANSACTION_getDownloadListenerHashCodeLists = 2;
        static final int TRANSACTION_getDownloadNotificationEventListener = 5;
        static final int TRANSACTION_getFileProvider = 12;
        static final int TRANSACTION_getForbiddenHandler = 9;
        static final int TRANSACTION_getInterceptor = 7;
        static final int TRANSACTION_getMonitorDepend = 11;
        static final int TRANSACTION_getNotificationClickCallback = 6;
        static final int TRANSACTION_getSingleDownloadListener = 4;

        private static class Proxy implements DownloadAidlTask {
            public static DownloadAidlTask sDefaultImpl;
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

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public DownloadInfo getDownloadInfo() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                DownloadInfo r4 = (DownloadInfo) ZeusTransformUtils.preCheckCast(DownloadInfo.CREATOR.createFromParcel(r1), DownloadInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                DownloadInfo r5 = Stub.getDefaultImpl().getDownloadInfo();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r5;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public int[] getDownloadListenerHashCodeLists(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int[] r4 = r1.createIntArray();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int[] r6 = Stub.getDefaultImpl().getDownloadListenerHashCodeLists(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadAidlListener getDownloadListenerByHashCode(int r5, int r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IDownloadAidlListener r4 = IDownloadAidlListener.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IDownloadAidlListener r7 = Stub.getDefaultImpl().getDownloadListenerByHashCode(r5, r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadAidlListener getSingleDownloadListener(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IDownloadAidlListener r4 = IDownloadAidlListener.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IDownloadAidlListener r6 = Stub.getDefaultImpl().getSingleDownloadListener(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadNotificationEventAidlListener getDownloadNotificationEventListener() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IDownloadNotificationEventAidlListener r4 = IDownloadNotificationEventAidlListener.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IDownloadNotificationEventAidlListener r5 = Stub.getDefaultImpl().getDownloadNotificationEventListener();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public INotificationClickAidlCallback getNotificationClickCallback() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(6, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                INotificationClickAidlCallback r4 = INotificationClickAidlCallback.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                INotificationClickAidlCallback r5 = Stub.getDefaultImpl().getNotificationClickCallback();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadAidlInterceptor getInterceptor() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(7, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IDownloadAidlInterceptor r4 = IDownloadAidlInterceptor.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IDownloadAidlInterceptor r5 = Stub.getDefaultImpl().getInterceptor();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadAidlDepend getDepend() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(8, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IDownloadAidlDepend r4 = IDownloadAidlDepend.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IDownloadAidlDepend r5 = Stub.getDefaultImpl().getDepend();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadForbiddenAidlHandler getForbiddenHandler() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(9, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IDownloadForbiddenAidlHandler r4 = IDownloadForbiddenAidlHandler.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IDownloadForbiddenAidlHandler r5 = Stub.getDefaultImpl().getForbiddenHandler();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadDiskSpaceAidlHandler getDiskSpaceHandler() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(10, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IDownloadDiskSpaceAidlHandler r4 = IDownloadDiskSpaceAidlHandler.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IDownloadDiskSpaceAidlHandler r5 = Stub.getDefaultImpl().getDiskSpaceHandler();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadAidlMonitorDepend getMonitorDepend() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(11, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IDownloadAidlMonitorDepend r4 = IDownloadAidlMonitorDepend.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IDownloadAidlMonitorDepend r5 = Stub.getDefaultImpl().getMonitorDepend();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadAidlFileProvider getFileProvider() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(12, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IDownloadAidlFileProvider r4 = IDownloadAidlFileProvider.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IDownloadAidlFileProvider r5 = Stub.getDefaultImpl().getFileProvider();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public int getDownloadCompleteHandlerSize() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(13, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r5 = Stub.getDefaultImpl().getDownloadCompleteHandlerSize();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadCompleteAidlHandler getDownloadCompleteAidlHandlerByIndex(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(14, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IDownloadCompleteAidlHandler r4 = IDownloadCompleteAidlHandler.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IDownloadCompleteAidlHandler r6 = Stub.getDefaultImpl().getDownloadCompleteAidlHandlerByIndex(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
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

        public static DownloadAidlTask asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, DownloadAidlTask.class) == false) goto L13;
            return (DownloadAidlTask) ZeusTransformUtils.preCheckCast(r0, DownloadAidlTask.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 == 1598968902) goto L72;
            IBinder r0 = null;
            switch(r4) {
                case 1: goto L67;
                case 2: goto L65;
                case 3: goto L60;
                case 4: goto L55;
                case 5: goto L50;
                case 6: goto L45;
                case 7: goto L40;
                case 8: goto L35;
                case 9: goto L30;
                case 10: goto L25;
                case 11: goto L20;
                case 12: goto L15;
                case 13: goto L13;
                case 14: goto L8;
                default: goto L7;
            };
        L8:
            r5.enforceInterface(DESCRIPTOR);
            IDownloadCompleteAidlHandler r3 = getDownloadCompleteAidlHandlerByIndex(r5.readInt());
            r6.writeNoException();
            if (r3 == null) goto L11;
            r0 = r3.asBinder();
        L11:
            r6.writeStrongBinder(r0);
            return true;
        L13:
            r5.enforceInterface(DESCRIPTOR);
            int r8 = getDownloadCompleteHandlerSize();
            r6.writeNoException();
            r6.writeInt(r8);
            return true;
        L15:
            r5.enforceInterface(DESCRIPTOR);
            IDownloadAidlFileProvider r9 = getFileProvider();
            r6.writeNoException();
            if (r9 == null) goto L18;
            r0 = r9.asBinder();
        L18:
            r6.writeStrongBinder(r0);
            return true;
        L20:
            r5.enforceInterface(DESCRIPTOR);
            IDownloadAidlMonitorDepend r10 = getMonitorDepend();
            r6.writeNoException();
            if (r10 == null) goto L23;
            r0 = r10.asBinder();
        L23:
            r6.writeStrongBinder(r0);
            return true;
        L25:
            r5.enforceInterface(DESCRIPTOR);
            IDownloadDiskSpaceAidlHandler r11 = getDiskSpaceHandler();
            r6.writeNoException();
            if (r11 == null) goto L28;
            r0 = r11.asBinder();
        L28:
            r6.writeStrongBinder(r0);
            return true;
        L30:
            r5.enforceInterface(DESCRIPTOR);
            IDownloadForbiddenAidlHandler r12 = getForbiddenHandler();
            r6.writeNoException();
            if (r12 == null) goto L33;
            r0 = r12.asBinder();
        L33:
            r6.writeStrongBinder(r0);
            return true;
        L35:
            r5.enforceInterface(DESCRIPTOR);
            IDownloadAidlDepend r13 = getDepend();
            r6.writeNoException();
            if (r13 == null) goto L38;
            r0 = r13.asBinder();
        L38:
            r6.writeStrongBinder(r0);
            return true;
        L40:
            r5.enforceInterface(DESCRIPTOR);
            IDownloadAidlInterceptor r14 = getInterceptor();
            r6.writeNoException();
            if (r14 == null) goto L43;
            r0 = r14.asBinder();
        L43:
            r6.writeStrongBinder(r0);
            return true;
        L45:
            r5.enforceInterface(DESCRIPTOR);
            INotificationClickAidlCallback r15 = getNotificationClickCallback();
            r6.writeNoException();
            if (r15 == null) goto L48;
            r0 = r15.asBinder();
        L48:
            r6.writeStrongBinder(r0);
            return true;
        L50:
            r5.enforceInterface(DESCRIPTOR);
            IDownloadNotificationEventAidlListener r16 = getDownloadNotificationEventListener();
            r6.writeNoException();
            if (r16 == null) goto L53;
            r0 = r16.asBinder();
        L53:
            r6.writeStrongBinder(r0);
            return true;
        L55:
            r5.enforceInterface(DESCRIPTOR);
            IDownloadAidlListener r17 = getSingleDownloadListener(r5.readInt());
            r6.writeNoException();
            if (r17 == null) goto L58;
            r0 = r17.asBinder();
        L58:
            r6.writeStrongBinder(r0);
            return true;
        L60:
            r5.enforceInterface(DESCRIPTOR);
            IDownloadAidlListener r18 = getDownloadListenerByHashCode(r5.readInt(), r5.readInt());
            r6.writeNoException();
            if (r18 == null) goto L63;
            r0 = r18.asBinder();
        L63:
            r6.writeStrongBinder(r0);
            return true;
        L65:
            r5.enforceInterface(DESCRIPTOR);
            int[] r19 = getDownloadListenerHashCodeLists(r5.readInt());
            r6.writeNoException();
            r6.writeIntArray(r19);
            return true;
        L67:
            r5.enforceInterface(DESCRIPTOR);
            DownloadInfo r20 = getDownloadInfo();
            r6.writeNoException();
            if (r20 == null) goto L70;
            r6.writeInt(1);
            r20.writeToParcel(r6, 1);
        L71:
            return true;
        L70:
            r6.writeInt(0);
            goto L71
        L7:
            return super.onTransact(r4, r5, r6, r7);
        L72:
            r6.writeString(DESCRIPTOR);
            return true;
        }

        public static boolean setDefaultImpl(DownloadAidlTask r2) {
            DownloadAidlTask r3 = (DownloadAidlTask) ZeusTransformUtils.wrapperContextForParams(r2, DownloadAidlTask.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r3 == null) goto L7;
            Proxy.sDefaultImpl = r3;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        public static DownloadAidlTask getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    IDownloadAidlDepend getDepend();

    IDownloadDiskSpaceAidlHandler getDiskSpaceHandler();

    IDownloadCompleteAidlHandler getDownloadCompleteAidlHandlerByIndex(int r1);

    int getDownloadCompleteHandlerSize();

    DownloadInfo getDownloadInfo();

    IDownloadAidlListener getDownloadListenerByHashCode(int r1, int r2);

    int[] getDownloadListenerHashCodeLists(int r1);

    IDownloadNotificationEventAidlListener getDownloadNotificationEventListener();

    IDownloadAidlFileProvider getFileProvider();

    IDownloadForbiddenAidlHandler getForbiddenHandler();

    IDownloadAidlInterceptor getInterceptor();

    IDownloadAidlMonitorDepend getMonitorDepend();

    INotificationClickAidlCallback getNotificationClickCallback();

    IDownloadAidlListener getSingleDownloadListener(int r1);
}
