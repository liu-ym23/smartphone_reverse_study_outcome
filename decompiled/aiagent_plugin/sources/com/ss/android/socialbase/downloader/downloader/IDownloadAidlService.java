package com.ss.android.socialbase.downloader.downloader;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback;
import com.ss.android.socialbase.downloader.depend.ProcessAidlCallback;
import com.ss.android.socialbase.downloader.model.DownloadAidlTask;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface IDownloadAidlService extends IInterface {

    public static class Default implements IDownloadAidlService {
        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void addDownloadListener(int r1, int r2, IDownloadAidlListener r3, int r4, boolean r5) {
            IDownloadAidlListener r0 = (IDownloadAidlListener) ZeusTransformUtils.wrapperContextForParams(r3, IDownloadAidlListener.class, "com.obric.aiagent.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void addDownloadListener1(int r1, int r2, IDownloadAidlListener r3, int r4, boolean r5, boolean r6) {
            IDownloadAidlListener r0 = (IDownloadAidlListener) ZeusTransformUtils.wrapperContextForParams(r3, IDownloadAidlListener.class, "com.obric.aiagent.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void addProcessCallback(ProcessAidlCallback r2) {
            ProcessAidlCallback r1 = (ProcessAidlCallback) ZeusTransformUtils.wrapperContextForParams(r2, ProcessAidlCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean canResume(int r1) {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void cancel(int r1, boolean r2) {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void clearData() {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void clearDownloadData(int r1, boolean r2, boolean r3) {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void dispatchProcessCallback(int r1, int r2) {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public List<DownloadInfo> getAllDownloadInfo() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public long getCurBytes(int r1) {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public IDownloadAidlFileProvider getDownloadFileUriProvider(int r1) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public int getDownloadId(String r1, String r2) {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public DownloadInfo getDownloadInfo(int r1) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public DownloadInfo getDownloadInfoByUrlAndPath(String r1, String r2) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public List<DownloadInfo> getDownloadInfoList(String r1) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public List<DownloadInfo> getDownloadInfosByFileExtension(String r1) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public List<DownloadInfo> getDownloadInfosByFilters(String r1, String r2) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public IDownloadNotificationEventAidlListener getDownloadNotificationEventListener(int r1) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public int getDownloadWithIndependentProcessStatus(int r1) {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String r1) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public INotificationClickAidlCallback getNotificationClickCallback(int r1) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public int getStatus(int r1) {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r1) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r1) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean isDownloadCacheSyncSuccess() {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean isDownloadSuccessAndFileNotExist(DownloadInfo r1) {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean isDownloading(int r1) {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean isHttpServiceInit() {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void pause(int r1, boolean r2) {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void pauseAll() {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean removeDownloadInfo(int r1) {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void removeDownloadListener(int r1, int r2, IDownloadAidlListener r3, int r4, boolean r5) {
            IDownloadAidlListener r0 = (IDownloadAidlListener) ZeusTransformUtils.wrapperContextForParams(r3, IDownloadAidlListener.class, "com.obric.aiagent.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean removeDownloadTaskData(int r1) {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void resetDownloadData(int r1, boolean r2) {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void restart(int r1) {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void restartAllFailedDownloadTasks(List<String> r2) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void restartAllPauseReserveOnWifiDownloadTasks(List<String> r2) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void resume(int r1) {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void setDownloadNotificationEventListener(int r1, IDownloadNotificationEventAidlListener r2) {
            IDownloadNotificationEventAidlListener r0 = (IDownloadNotificationEventAidlListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadNotificationEventAidlListener.class, "com.obric.aiagent.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void setDownloadWithIndependentProcessStatus(int r1, boolean r2) {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void setLogLevel(int r1) {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void setThrottleNetSpeed(int r1, long r2, int r4) {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void syncDownloadInfoFromOtherCache(int r1) {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void tryDownload(DownloadAidlTask r2) {
            DownloadAidlTask r1 = (DownloadAidlTask) ZeusTransformUtils.wrapperContextForParams(r2, DownloadAidlTask.class, "com.obric.aiagent.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean updateDownloadInfo(DownloadInfo r1) {
            return false;
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IDownloadAidlService {
        private static final String DESCRIPTOR = "com.ss.android.socialbase.downloader.downloader.IDownloadAidlService";
        static final int TRANSACTION_addDownloadListener = 25;
        static final int TRANSACTION_addDownloadListener1 = 26;
        static final int TRANSACTION_addProcessCallback = 39;
        static final int TRANSACTION_canResume = 4;
        static final int TRANSACTION_cancel = 3;
        static final int TRANSACTION_clearData = 37;
        static final int TRANSACTION_clearDownloadData = 22;
        static final int TRANSACTION_dispatchProcessCallback = 40;
        static final int TRANSACTION_getAllDownloadInfo = 18;
        static final int TRANSACTION_getCurBytes = 8;
        static final int TRANSACTION_getDownloadFileUriProvider = 44;
        static final int TRANSACTION_getDownloadId = 13;
        static final int TRANSACTION_getDownloadInfo = 11;
        static final int TRANSACTION_getDownloadInfoByUrlAndPath = 14;
        static final int TRANSACTION_getDownloadInfoList = 12;
        static final int TRANSACTION_getDownloadInfosByFileExtension = 17;
        static final int TRANSACTION_getDownloadInfosByFilters = 19;
        static final int TRANSACTION_getDownloadNotificationEventListener = 41;
        static final int TRANSACTION_getDownloadWithIndependentProcessStatus = 33;
        static final int TRANSACTION_getDownloadingDownloadInfosWithMimeType = 16;
        static final int TRANSACTION_getNotificationClickCallback = 42;
        static final int TRANSACTION_getStatus = 9;
        static final int TRANSACTION_getSuccessedDownloadInfosWithMimeType = 15;
        static final int TRANSACTION_getUnCompletedDownloadInfosWithMimeType = 29;
        static final int TRANSACTION_isDownloadCacheSyncSuccess = 31;
        static final int TRANSACTION_isDownloadSuccessAndFileNotExist = 27;
        static final int TRANSACTION_isDownloading = 10;
        static final int TRANSACTION_isHttpServiceInit = 28;
        static final int TRANSACTION_pause = 2;
        static final int TRANSACTION_pauseAll = 7;
        static final int TRANSACTION_removeDownloadInfo = 35;
        static final int TRANSACTION_removeDownloadListener = 24;
        static final int TRANSACTION_removeDownloadTaskData = 36;
        static final int TRANSACTION_resetDownloadData = 23;
        static final int TRANSACTION_restart = 6;
        static final int TRANSACTION_restartAllFailedDownloadTasks = 20;
        static final int TRANSACTION_restartAllPauseReserveOnWifiDownloadTasks = 21;
        static final int TRANSACTION_resume = 5;
        static final int TRANSACTION_setDownloadNotificationEventListener = 43;
        static final int TRANSACTION_setDownloadWithIndependentProcessStatus = 32;
        static final int TRANSACTION_setLogLevel = 30;
        static final int TRANSACTION_setThrottleNetSpeed = 45;
        static final int TRANSACTION_syncDownloadInfoFromOtherCache = 38;
        static final int TRANSACTION_tryDownload = 1;
        static final int TRANSACTION_updateDownloadInfo = 34;

        private static class Proxy implements IDownloadAidlService {
            public static IDownloadAidlService sDefaultImpl;
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

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void tryDownload(DownloadAidlTask r5) {
                DownloadAidlTask r6 = (DownloadAidlTask) ZeusTransformUtils.wrapperContextForParams(r5, DownloadAidlTask.class, "com.obric.aiagent.plugin");
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
                Stub.getDefaultImpl().tryDownload(r6);     // Catch: Throwable -> L17
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

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void pause(int r5, boolean r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                if (r6 == false) goto L6;
                int r3 = 1;
            L7:
                r0.writeInt(r3);     // Catch: Throwable -> L17
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().pause(r5, r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r3 = 0;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void cancel(int r5, boolean r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                if (r6 == false) goto L6;
                int r3 = 1;
            L7:
                r0.writeInt(r3);     // Catch: Throwable -> L17
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().cancel(r5, r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r3 = 0;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean canResume(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeInt(r5);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r4 = Stub.getDefaultImpl().canResume(r5);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void resume(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().resume(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void restart(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(6, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().restart(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void pauseAll() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(7, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().pauseAll();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public long getCurBytes(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(8, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                long r4 = r1.readLong();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                long r6 = Stub.getDefaultImpl().getCurBytes(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public int getStatus(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(9, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r6 = Stub.getDefaultImpl().getStatus(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean isDownloading(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeInt(r5);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(10, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r4 = Stub.getDefaultImpl().isDownloading(r5);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public DownloadInfo getDownloadInfo(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                if (this.mRemote.transact(11, r0, r1, 0) == false) goto L6;
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
                DownloadInfo r6 = Stub.getDefaultImpl().getDownloadInfo(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r6;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public List<DownloadInfo> getDownloadInfoList(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(12, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r4 = r1.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<DownloadInfo> r6 = Stub.getDefaultImpl().getDownloadInfoList(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public int getDownloadId(String r5, String r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                if (this.mRemote.transact(13, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r7 = Stub.getDefaultImpl().getDownloadId(r5, r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public DownloadInfo getDownloadInfoByUrlAndPath(String r5, String r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r5);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                if (this.mRemote.transact(14, r0, r1, 0) == false) goto L6;
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
                DownloadInfo r7 = Stub.getDefaultImpl().getDownloadInfoByUrlAndPath(r5, r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r7;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(15, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r4 = r1.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<DownloadInfo> r6 = Stub.getDefaultImpl().getSuccessedDownloadInfosWithMimeType(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(16, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r4 = r1.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<DownloadInfo> r6 = Stub.getDefaultImpl().getDownloadingDownloadInfosWithMimeType(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public List<DownloadInfo> getDownloadInfosByFileExtension(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(17, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r4 = r1.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<DownloadInfo> r6 = Stub.getDefaultImpl().getDownloadInfosByFileExtension(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public List<DownloadInfo> getAllDownloadInfo() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(18, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r4 = r1.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<DownloadInfo> r5 = Stub.getDefaultImpl().getAllDownloadInfo();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public List<DownloadInfo> getDownloadInfosByFilters(String r5, String r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                if (this.mRemote.transact(19, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r4 = r1.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<DownloadInfo> r7 = Stub.getDefaultImpl().getDownloadInfosByFilters(r5, r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void restartAllFailedDownloadTasks(List<String> r5) {
                List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeStringList(r6);     // Catch: Throwable -> L13
                if (this.mRemote.transact(20, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().restartAllFailedDownloadTasks(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void restartAllPauseReserveOnWifiDownloadTasks(List<String> r5) {
                List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeStringList(r6);     // Catch: Throwable -> L13
                if (this.mRemote.transact(21, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().restartAllPauseReserveOnWifiDownloadTasks(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void clearDownloadData(int r6, boolean r7, boolean r8) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r0.writeInt(r6);     // Catch: Throwable -> L21
                int r2 = 1;
                if (r7 == false) goto L6;
                int r4 = 1;
            L7:
                r0.writeInt(r4);     // Catch: Throwable -> L21
                if (r8 == true) goto L11;
                r2 = 0;
            L11:
                r0.writeInt(r2);     // Catch: Throwable -> L21
                if (this.mRemote.transact(22, r0, r1, 0) == false) goto L14;
            L18:
                r1.readException();     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().clearDownloadData(r6, r7, r8);     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r4 = 0;
            L21:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void resetDownloadData(int r5, boolean r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                if (r6 == false) goto L6;
                int r3 = 1;
            L7:
                r0.writeInt(r3);     // Catch: Throwable -> L17
                if (this.mRemote.transact(23, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().resetDownloadData(r5, r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r3 = 0;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void removeDownloadListener(int r8, int r9, IDownloadAidlListener r10, int r11, boolean r12) {
                IDownloadAidlListener r3 = (IDownloadAidlListener) ZeusTransformUtils.wrapperContextForParams(r10, IDownloadAidlListener.class, "com.obric.aiagent.plugin");
                Parcel r13 = Parcel.obtain();
                Parcel r6 = Parcel.obtain();
                r13.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r13.writeInt(r8);     // Catch: Throwable -> L21
                r13.writeInt(r9);     // Catch: Throwable -> L21
                if (r3 == null) goto L6;
                IBinder r0 = r3.asBinder();     // Catch: Throwable -> L21
            L7:
                r13.writeStrongBinder(r0);     // Catch: Throwable -> L21
                r13.writeInt(r11);     // Catch: Throwable -> L21
                if (r12 == false) goto L10;
                int r1 = 1;
            L11:
                r13.writeInt(r1);     // Catch: Throwable -> L21
                if (this.mRemote.transact(24, r13, r6, 0) == false) goto L14;
            L18:
                r6.readException();     // Catch: Throwable -> L21
                r6.recycle();
                r13.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().removeDownloadListener(r8, r9, r3, r11, r12);     // Catch: Throwable -> L21
                r6.recycle();
                r13.recycle();
                return;
            L10:
                r1 = 0;
                goto L11
            L6:
                r0 = null;
            L21:
                th = move-exception;
                r6.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void addDownloadListener(int r8, int r9, IDownloadAidlListener r10, int r11, boolean r12) {
                IDownloadAidlListener r3 = (IDownloadAidlListener) ZeusTransformUtils.wrapperContextForParams(r10, IDownloadAidlListener.class, "com.obric.aiagent.plugin");
                Parcel r13 = Parcel.obtain();
                Parcel r6 = Parcel.obtain();
                r13.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r13.writeInt(r8);     // Catch: Throwable -> L21
                r13.writeInt(r9);     // Catch: Throwable -> L21
                if (r3 == null) goto L6;
                IBinder r0 = r3.asBinder();     // Catch: Throwable -> L21
            L7:
                r13.writeStrongBinder(r0);     // Catch: Throwable -> L21
                r13.writeInt(r11);     // Catch: Throwable -> L21
                if (r12 == false) goto L10;
                int r1 = 1;
            L11:
                r13.writeInt(r1);     // Catch: Throwable -> L21
                if (this.mRemote.transact(25, r13, r6, 0) == false) goto L14;
            L18:
                r6.readException();     // Catch: Throwable -> L21
                r6.recycle();
                r13.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().addDownloadListener(r8, r9, r3, r11, r12);     // Catch: Throwable -> L21
                r6.recycle();
                r13.recycle();
                return;
            L10:
                r1 = 0;
                goto L11
            L6:
                r0 = null;
            L21:
                th = move-exception;
                r6.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void addDownloadListener1(int r9, int r10, IDownloadAidlListener r11, int r12, boolean r13, boolean r14) {
                IDownloadAidlListener r3 = (IDownloadAidlListener) ZeusTransformUtils.wrapperContextForParams(r11, IDownloadAidlListener.class, "com.obric.aiagent.plugin");
                Parcel r15 = Parcel.obtain();
                Parcel r7 = Parcel.obtain();
                r15.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L25
                r15.writeInt(r9);     // Catch: Throwable -> L25
                r15.writeInt(r10);     // Catch: Throwable -> L25
                if (r3 == null) goto L6;
                IBinder r0 = r3.asBinder();     // Catch: Throwable -> L25
            L7:
                r15.writeStrongBinder(r0);     // Catch: Throwable -> L25
                r15.writeInt(r12);     // Catch: Throwable -> L25
                int r1 = 1;
                if (r13 == false) goto L10;
                int r2 = 1;
            L11:
                r15.writeInt(r2);     // Catch: Throwable -> L25
                if (r14 == true) goto L15;
                r1 = 0;
            L15:
                r15.writeInt(r1);     // Catch: Throwable -> L25
                if (this.mRemote.transact(26, r15, r7, 0) == false) goto L18;
            L22:
                r7.readException();     // Catch: Throwable -> L25
                r7.recycle();
                r15.recycle();
                return;
            L18:
                if (Stub.getDefaultImpl() == null) goto L22;
                Stub.getDefaultImpl().addDownloadListener1(r9, r10, r3, r12, r13, r14);     // Catch: Throwable -> L25
                r7.recycle();
                r15.recycle();
                return;
            L10:
                r2 = 0;
                goto L11
            L6:
                r0 = null;
            L25:
                th = move-exception;
                r7.recycle();
                r15.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean isDownloadSuccessAndFileNotExist(DownloadInfo r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                boolean r2 = true;
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L8:
                if (this.mRemote.transact(27, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L20
                if (r1.readInt() != 0) goto L18;
                r2 = false;
            L18:
                r1.recycle();
                r0.recycle();
                return r2;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r5 = Stub.getDefaultImpl().isDownloadSuccessAndFileNotExist(r6);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return r5;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean isHttpServiceInit() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(28, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r4 = Stub.getDefaultImpl().isHttpServiceInit();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(29, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r4 = r1.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<DownloadInfo> r6 = Stub.getDefaultImpl().getUnCompletedDownloadInfosWithMimeType(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void setLogLevel(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(30, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setLogLevel(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean isDownloadCacheSyncSuccess() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(31, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r4 = Stub.getDefaultImpl().isDownloadCacheSyncSuccess();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void setDownloadWithIndependentProcessStatus(int r5, boolean r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                if (r6 == false) goto L6;
                int r3 = 1;
            L7:
                r0.writeInt(r3);     // Catch: Throwable -> L17
                if (this.mRemote.transact(32, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setDownloadWithIndependentProcessStatus(r5, r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r3 = 0;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public int getDownloadWithIndependentProcessStatus(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(33, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r6 = Stub.getDefaultImpl().getDownloadWithIndependentProcessStatus(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean updateDownloadInfo(DownloadInfo r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                boolean r2 = true;
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L8:
                if (this.mRemote.transact(34, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L20
                if (r1.readInt() != 0) goto L18;
                r2 = false;
            L18:
                r1.recycle();
                r0.recycle();
                return r2;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r5 = Stub.getDefaultImpl().updateDownloadInfo(r6);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return r5;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean removeDownloadInfo(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeInt(r5);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(35, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r4 = Stub.getDefaultImpl().removeDownloadInfo(r5);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean removeDownloadTaskData(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeInt(r5);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(36, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r4 = Stub.getDefaultImpl().removeDownloadTaskData(r5);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void clearData() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(37, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().clearData();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void syncDownloadInfoFromOtherCache(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(38, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().syncDownloadInfoFromOtherCache(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void addProcessCallback(ProcessAidlCallback r5) {
                ProcessAidlCallback r6 = (ProcessAidlCallback) ZeusTransformUtils.wrapperContextForParams(r5, ProcessAidlCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(39, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().addProcessCallback(r6);     // Catch: Throwable -> L17
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

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void dispatchProcessCallback(int r5, int r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                if (this.mRemote.transact(40, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().dispatchProcessCallback(r5, r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public IDownloadNotificationEventAidlListener getDownloadNotificationEventListener(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(41, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IDownloadNotificationEventAidlListener r4 = IDownloadNotificationEventAidlListener.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IDownloadNotificationEventAidlListener r6 = Stub.getDefaultImpl().getDownloadNotificationEventListener(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public INotificationClickAidlCallback getNotificationClickCallback(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(42, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                INotificationClickAidlCallback r4 = INotificationClickAidlCallback.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                INotificationClickAidlCallback r6 = Stub.getDefaultImpl().getNotificationClickCallback(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void setDownloadNotificationEventListener(int r5, IDownloadNotificationEventAidlListener r6) {
                IDownloadNotificationEventAidlListener r7 = (IDownloadNotificationEventAidlListener) ZeusTransformUtils.wrapperContextForParams(r6, IDownloadNotificationEventAidlListener.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                if (r7 == null) goto L6;
                IBinder r2 = r7.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(43, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setDownloadNotificationEventListener(r5, r7);     // Catch: Throwable -> L17
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

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public IDownloadAidlFileProvider getDownloadFileUriProvider(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(44, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                IDownloadAidlFileProvider r4 = IDownloadAidlFileProvider.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IDownloadAidlFileProvider r6 = Stub.getDefaultImpl().getDownloadFileUriProvider(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void setThrottleNetSpeed(int r5, long r6, int r8) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                r0.writeLong(r6);     // Catch: Throwable -> L13
                r0.writeInt(r8);     // Catch: Throwable -> L13
                if (this.mRemote.transact(45, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setThrottleNetSpeed(r5, r6, r8);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
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

        public static IDownloadAidlService asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IDownloadAidlService.class) == false) goto L13;
            return (IDownloadAidlService) ZeusTransformUtils.preCheckCast(r0, IDownloadAidlService.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 == 1598968902) goto L151;
            DownloadInfo r5 = null;
            IBinder r6 = null;
            IBinder r7 = null;
            IBinder r8 = null;
            DownloadInfo r9 = null;
            boolean r14 = false;
            switch(r10) {
                case 1: goto L149;
                case 2: goto L144;
                case 3: goto L139;
                case 4: goto L137;
                case 5: goto L135;
                case 6: goto L133;
                case 7: goto L131;
                case 8: goto L129;
                case 9: goto L127;
                case 10: goto L125;
                case 11: goto L120;
                case 12: goto L118;
                case 13: goto L116;
                case 14: goto L111;
                case 15: goto L109;
                case 16: goto L107;
                case 17: goto L105;
                case 18: goto L103;
                case 19: goto L101;
                case 20: goto L99;
                case 21: goto L97;
                case 22: goto L88;
                case 23: goto L83;
                case 24: goto L78;
                case 25: goto L73;
                case 26: goto L64;
                case 27: goto L59;
                case 28: goto L57;
                case 29: goto L55;
                case 30: goto L53;
                case 31: goto L51;
                case 32: goto L46;
                case 33: goto L44;
                case 34: goto L39;
                case 35: goto L37;
                case 36: goto L35;
                case 37: goto L33;
                case 38: goto L31;
                case 39: goto L29;
                case 40: goto L27;
                case 41: goto L22;
                case 42: goto L17;
                case 43: goto L15;
                case 44: goto L10;
                case 45: goto L8;
                default: goto L7;
            };
        L8:
            r11.enforceInterface(DESCRIPTOR);
            setThrottleNetSpeed(r11.readInt(), r11.readLong(), r11.readInt());
            r12.writeNoException();
            return true;
        L10:
            r11.enforceInterface(DESCRIPTOR);
            IDownloadAidlFileProvider r0 = getDownloadFileUriProvider(r11.readInt());
            r12.writeNoException();
            if (r0 == null) goto L13;
            r6 = r0.asBinder();
        L13:
            r12.writeStrongBinder(r6);
            return true;
        L15:
            r11.enforceInterface(DESCRIPTOR);
            setDownloadNotificationEventListener(r11.readInt(), IDownloadNotificationEventAidlListener.Stub.asInterface(r11.readStrongBinder()));
            r12.writeNoException();
            return true;
        L17:
            r11.enforceInterface(DESCRIPTOR);
            INotificationClickAidlCallback r1 = getNotificationClickCallback(r11.readInt());
            r12.writeNoException();
            if (r1 == null) goto L20;
            r7 = r1.asBinder();
        L20:
            r12.writeStrongBinder(r7);
            return true;
        L22:
            r11.enforceInterface(DESCRIPTOR);
            IDownloadNotificationEventAidlListener r2 = getDownloadNotificationEventListener(r11.readInt());
            r12.writeNoException();
            if (r2 == null) goto L25;
            r8 = r2.asBinder();
        L25:
            r12.writeStrongBinder(r8);
            return true;
        L27:
            r11.enforceInterface(DESCRIPTOR);
            dispatchProcessCallback(r11.readInt(), r11.readInt());
            r12.writeNoException();
            return true;
        L29:
            r11.enforceInterface(DESCRIPTOR);
            addProcessCallback(ProcessAidlCallback.Stub.asInterface(r11.readStrongBinder()));
            r12.writeNoException();
            return true;
        L31:
            r11.enforceInterface(DESCRIPTOR);
            syncDownloadInfoFromOtherCache(r11.readInt());
            r12.writeNoException();
            return true;
        L33:
            r11.enforceInterface(DESCRIPTOR);
            clearData();
            r12.writeNoException();
            return true;
        L35:
            r11.enforceInterface(DESCRIPTOR);
            boolean r3 = removeDownloadTaskData(r11.readInt());
            r12.writeNoException();
            r12.writeInt(r3 ? 1 : 0);
            return true;
        L37:
            r11.enforceInterface(DESCRIPTOR);
            boolean r4 = removeDownloadInfo(r11.readInt());
            r12.writeNoException();
            r12.writeInt(r4 ? 1 : 0);
            return true;
        L39:
            r11.enforceInterface(DESCRIPTOR);
            if (r11.readInt() == 0) goto L42;
            r9 = (DownloadInfo) ZeusTransformUtils.preCheckCast(DownloadInfo.CREATOR.createFromParcel(r11), DownloadInfo.class, "com.obric.aiagent.plugin");
        L42:
            boolean r15 = updateDownloadInfo(r9);
            r12.writeNoException();
            r12.writeInt(r15 ? 1 : 0);
            return true;
        L44:
            r11.enforceInterface(DESCRIPTOR);
            int r16 = getDownloadWithIndependentProcessStatus(r11.readInt());
            r12.writeNoException();
            r12.writeInt(r16);
            return true;
        L46:
            r11.enforceInterface(DESCRIPTOR);
            int r17 = r11.readInt();
            if (r11.readInt() == 0) goto L49;
            r14 = true;
        L49:
            setDownloadWithIndependentProcessStatus(r17, r14);
            r12.writeNoException();
            return true;
        L51:
            r11.enforceInterface(DESCRIPTOR);
            boolean r18 = isDownloadCacheSyncSuccess();
            r12.writeNoException();
            r12.writeInt(r18 ? 1 : 0);
            return true;
        L53:
            r11.enforceInterface(DESCRIPTOR);
            setLogLevel(r11.readInt());
            r12.writeNoException();
            return true;
        L55:
            r11.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r19 = getUnCompletedDownloadInfosWithMimeType(r11.readString());
            r12.writeNoException();
            r12.writeTypedList(r19);
            return true;
        L57:
            r11.enforceInterface(DESCRIPTOR);
            boolean r20 = isHttpServiceInit();
            r12.writeNoException();
            r12.writeInt(r20 ? 1 : 0);
            return true;
        L59:
            r11.enforceInterface(DESCRIPTOR);
            if (r11.readInt() == 0) goto L62;
            r5 = (DownloadInfo) ZeusTransformUtils.preCheckCast(DownloadInfo.CREATOR.createFromParcel(r11), DownloadInfo.class, "com.obric.aiagent.plugin");
        L62:
            boolean r21 = isDownloadSuccessAndFileNotExist(r5);
            r12.writeNoException();
            r12.writeInt(r21 ? 1 : 0);
            return true;
        L64:
            r11.enforceInterface(DESCRIPTOR);
            int r22 = r11.readInt();
            int r23 = r11.readInt();
            IDownloadAidlListener r24 = IDownloadAidlListener.Stub.asInterface(r11.readStrongBinder());
            int r25 = r11.readInt();
            if (r11.readInt() == 0) goto L67;
            boolean r26 = true;
        L69:
            if (r11.readInt() == 0) goto L71;
            r14 = true;
        L71:
            addDownloadListener1(r22, r23, r24, r25, r26, r14);
            r12.writeNoException();
            return true;
        L67:
            r26 = false;
            goto L69
        L73:
            r11.enforceInterface(DESCRIPTOR);
            int r27 = r11.readInt();
            int r28 = r11.readInt();
            IDownloadAidlListener r29 = IDownloadAidlListener.Stub.asInterface(r11.readStrongBinder());
            int r30 = r11.readInt();
            if (r11.readInt() == 0) goto L76;
            r14 = true;
        L76:
            addDownloadListener(r27, r28, r29, r30, r14);
            r12.writeNoException();
            return true;
        L78:
            r11.enforceInterface(DESCRIPTOR);
            int r31 = r11.readInt();
            int r32 = r11.readInt();
            IDownloadAidlListener r33 = IDownloadAidlListener.Stub.asInterface(r11.readStrongBinder());
            int r34 = r11.readInt();
            if (r11.readInt() == 0) goto L81;
            r14 = true;
        L81:
            removeDownloadListener(r31, r32, r33, r34, r14);
            r12.writeNoException();
            return true;
        L83:
            r11.enforceInterface(DESCRIPTOR);
            int r35 = r11.readInt();
            if (r11.readInt() == 0) goto L86;
            r14 = true;
        L86:
            resetDownloadData(r35, r14);
            r12.writeNoException();
            return true;
        L88:
            r11.enforceInterface(DESCRIPTOR);
            int r36 = r11.readInt();
            if (r11.readInt() == 0) goto L91;
            boolean r37 = true;
        L93:
            if (r11.readInt() == 0) goto L95;
            r14 = true;
        L95:
            clearDownloadData(r36, r37, r14);
            r12.writeNoException();
            return true;
        L91:
            r37 = false;
            goto L93
        L97:
            r11.enforceInterface(DESCRIPTOR);
            restartAllPauseReserveOnWifiDownloadTasks(r11.createStringArrayList());
            r12.writeNoException();
            return true;
        L99:
            r11.enforceInterface(DESCRIPTOR);
            restartAllFailedDownloadTasks(r11.createStringArrayList());
            r12.writeNoException();
            return true;
        L101:
            r11.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r38 = getDownloadInfosByFilters(r11.readString(), r11.readString());
            r12.writeNoException();
            r12.writeTypedList(r38);
            return true;
        L103:
            r11.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r39 = getAllDownloadInfo();
            r12.writeNoException();
            r12.writeTypedList(r39);
            return true;
        L105:
            r11.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r40 = getDownloadInfosByFileExtension(r11.readString());
            r12.writeNoException();
            r12.writeTypedList(r40);
            return true;
        L107:
            r11.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r41 = getDownloadingDownloadInfosWithMimeType(r11.readString());
            r12.writeNoException();
            r12.writeTypedList(r41);
            return true;
        L109:
            r11.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r42 = getSuccessedDownloadInfosWithMimeType(r11.readString());
            r12.writeNoException();
            r12.writeTypedList(r42);
            return true;
        L111:
            r11.enforceInterface(DESCRIPTOR);
            DownloadInfo r43 = getDownloadInfoByUrlAndPath(r11.readString(), r11.readString());
            r12.writeNoException();
            if (r43 == null) goto L114;
            r12.writeInt(1);
            r43.writeToParcel(r12, 1);
        L115:
            return true;
        L114:
            r12.writeInt(0);
            goto L115
        L116:
            r11.enforceInterface(DESCRIPTOR);
            int r44 = getDownloadId(r11.readString(), r11.readString());
            r12.writeNoException();
            r12.writeInt(r44);
            return true;
        L118:
            r11.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r45 = getDownloadInfoList(r11.readString());
            r12.writeNoException();
            r12.writeTypedList(r45);
            return true;
        L120:
            r11.enforceInterface(DESCRIPTOR);
            DownloadInfo r46 = getDownloadInfo(r11.readInt());
            r12.writeNoException();
            if (r46 == null) goto L123;
            r12.writeInt(1);
            r46.writeToParcel(r12, 1);
        L124:
            return true;
        L123:
            r12.writeInt(0);
            goto L124
        L125:
            r11.enforceInterface(DESCRIPTOR);
            boolean r47 = isDownloading(r11.readInt());
            r12.writeNoException();
            r12.writeInt(r47 ? 1 : 0);
            return true;
        L127:
            r11.enforceInterface(DESCRIPTOR);
            int r48 = getStatus(r11.readInt());
            r12.writeNoException();
            r12.writeInt(r48);
            return true;
        L129:
            r11.enforceInterface(DESCRIPTOR);
            long r49 = getCurBytes(r11.readInt());
            r12.writeNoException();
            r12.writeLong(r49);
            return true;
        L131:
            r11.enforceInterface(DESCRIPTOR);
            pauseAll();
            r12.writeNoException();
            return true;
        L133:
            r11.enforceInterface(DESCRIPTOR);
            restart(r11.readInt());
            r12.writeNoException();
            return true;
        L135:
            r11.enforceInterface(DESCRIPTOR);
            resume(r11.readInt());
            r12.writeNoException();
            return true;
        L137:
            r11.enforceInterface(DESCRIPTOR);
            boolean r50 = canResume(r11.readInt());
            r12.writeNoException();
            r12.writeInt(r50 ? 1 : 0);
            return true;
        L139:
            r11.enforceInterface(DESCRIPTOR);
            int r51 = r11.readInt();
            if (r11.readInt() == 0) goto L142;
            r14 = true;
        L142:
            cancel(r51, r14);
            r12.writeNoException();
            return true;
        L144:
            r11.enforceInterface(DESCRIPTOR);
            int r52 = r11.readInt();
            if (r11.readInt() == 0) goto L147;
            r14 = true;
        L147:
            pause(r52, r14);
            r12.writeNoException();
            return true;
        L149:
            r11.enforceInterface(DESCRIPTOR);
            tryDownload(DownloadAidlTask.Stub.asInterface(r11.readStrongBinder()));
            r12.writeNoException();
            return true;
        L7:
            return super.onTransact(r10, r11, r12, r13);
        L151:
            r12.writeString(DESCRIPTOR);
            return true;
        }

        public static boolean setDefaultImpl(IDownloadAidlService r2) {
            IDownloadAidlService r3 = (IDownloadAidlService) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadAidlService.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r3 == null) goto L7;
            Proxy.sDefaultImpl = r3;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        public static IDownloadAidlService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void addDownloadListener(int r1, int r2, IDownloadAidlListener r3, int r4, boolean r5);

    void addDownloadListener1(int r1, int r2, IDownloadAidlListener r3, int r4, boolean r5, boolean r6);

    void addProcessCallback(ProcessAidlCallback r1);

    boolean canResume(int r1);

    void cancel(int r1, boolean r2);

    void clearData();

    void clearDownloadData(int r1, boolean r2, boolean r3);

    void dispatchProcessCallback(int r1, int r2);

    List<DownloadInfo> getAllDownloadInfo();

    long getCurBytes(int r1);

    IDownloadAidlFileProvider getDownloadFileUriProvider(int r1);

    int getDownloadId(String r1, String r2);

    DownloadInfo getDownloadInfo(int r1);

    DownloadInfo getDownloadInfoByUrlAndPath(String r1, String r2);

    List<DownloadInfo> getDownloadInfoList(String r1);

    List<DownloadInfo> getDownloadInfosByFileExtension(String r1);

    List<DownloadInfo> getDownloadInfosByFilters(String r1, String r2);

    IDownloadNotificationEventAidlListener getDownloadNotificationEventListener(int r1);

    int getDownloadWithIndependentProcessStatus(int r1);

    List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String r1);

    INotificationClickAidlCallback getNotificationClickCallback(int r1);

    int getStatus(int r1);

    List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r1);

    List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r1);

    boolean isDownloadCacheSyncSuccess();

    boolean isDownloadSuccessAndFileNotExist(DownloadInfo r1);

    boolean isDownloading(int r1);

    boolean isHttpServiceInit();

    void pause(int r1, boolean r2);

    void pauseAll();

    boolean removeDownloadInfo(int r1);

    void removeDownloadListener(int r1, int r2, IDownloadAidlListener r3, int r4, boolean r5);

    boolean removeDownloadTaskData(int r1);

    void resetDownloadData(int r1, boolean r2);

    void restart(int r1);

    void restartAllFailedDownloadTasks(List<String> r1);

    void restartAllPauseReserveOnWifiDownloadTasks(List<String> r1);

    void resume(int r1);

    void setDownloadNotificationEventListener(int r1, IDownloadNotificationEventAidlListener r2);

    void setDownloadWithIndependentProcessStatus(int r1, boolean r2);

    void setLogLevel(int r1);

    void setThrottleNetSpeed(int r1, long r2, int r4);

    void syncDownloadInfoFromOtherCache(int r1);

    void tryDownload(DownloadAidlTask r1);

    boolean updateDownloadInfo(DownloadInfo r1);
}
