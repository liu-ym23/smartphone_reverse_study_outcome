package com.ss.android.socialbase.downloader.db;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface ISqlDownloadCacheAidl extends IInterface {

    public static class Default implements ISqlDownloadCacheAidl {
        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public DownloadInfo OnDownloadTaskCancel(int r1, long r2) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public DownloadInfo OnDownloadTaskCompleted(int r1, long r2) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public DownloadInfo OnDownloadTaskConnected(int r1, long r2, String r4, String r5) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public DownloadInfo OnDownloadTaskError(int r1, long r2) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public DownloadInfo OnDownloadTaskIntercept(int r1) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public DownloadInfo OnDownloadTaskPause(int r1, long r2) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public DownloadInfo OnDownloadTaskPrepare(int r1) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public DownloadInfo OnDownloadTaskProgress(int r1, long r2) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public DownloadInfo OnDownloadTaskRetry(int r1) {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public boolean cacheExist(int r1) {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public void clearData() {
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public boolean ensureDownloadCacheSyncSuccess() {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public List<DownloadInfo> getAllDownloadInfo() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public DownloadInfo getDownloadInfo(int r1) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public List<DownloadInfo> getDownloadInfoList(String r1) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public List<DownloadInfo> getDownloadInfosByFileExtension(String r1) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public List<DownloadInfo> getDownloadInfosByFilters(String r1, String r2) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r1) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r1) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public void init(boolean r1) {
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public boolean isDownloadCacheSyncSuccess() {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public DownloadInfo onDownloadTaskStart(int r1) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public boolean removeDownloadInfo(int r1) {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public boolean removeDownloadTaskData(int r1) {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public void setInitCallback(ISqlCacheLoadCompleteCallbackAidl r2) {
            ISqlCacheLoadCompleteCallbackAidl r1 = (ISqlCacheLoadCompleteCallbackAidl) ZeusTransformUtils.wrapperContextForParams(r2, ISqlCacheLoadCompleteCallbackAidl.class, "com.obric.aiagent.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public void syncDownloadInfo(DownloadInfo r1) {
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public void syncDownloadInfoFromOtherCache(int r1) {
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public boolean updateDownloadInfo(DownloadInfo r1) {
            return false;
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements ISqlDownloadCacheAidl {
        private static final String DESCRIPTOR = "com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl";
        static final int TRANSACTION_OnDownloadTaskCancel = 21;
        static final int TRANSACTION_OnDownloadTaskCompleted = 19;
        static final int TRANSACTION_OnDownloadTaskConnected = 15;
        static final int TRANSACTION_OnDownloadTaskError = 17;
        static final int TRANSACTION_OnDownloadTaskIntercept = 23;
        static final int TRANSACTION_OnDownloadTaskPause = 20;
        static final int TRANSACTION_OnDownloadTaskPrepare = 22;
        static final int TRANSACTION_OnDownloadTaskProgress = 16;
        static final int TRANSACTION_OnDownloadTaskRetry = 18;
        static final int TRANSACTION_cacheExist = 2;
        static final int TRANSACTION_clearData = 13;
        static final int TRANSACTION_ensureDownloadCacheSyncSuccess = 25;
        static final int TRANSACTION_getAllDownloadInfo = 8;
        static final int TRANSACTION_getDownloadInfo = 3;
        static final int TRANSACTION_getDownloadInfoList = 4;
        static final int TRANSACTION_getDownloadInfosByFileExtension = 7;
        static final int TRANSACTION_getDownloadInfosByFilters = 9;
        static final int TRANSACTION_getSuccessedDownloadInfosWithMimeType = 5;
        static final int TRANSACTION_getUnCompletedDownloadInfosWithMimeType = 6;
        static final int TRANSACTION_init = 1;
        static final int TRANSACTION_isDownloadCacheSyncSuccess = 24;
        static final int TRANSACTION_onDownloadTaskStart = 14;
        static final int TRANSACTION_removeDownloadInfo = 11;
        static final int TRANSACTION_removeDownloadTaskData = 12;
        static final int TRANSACTION_setInitCallback = 28;
        static final int TRANSACTION_syncDownloadInfo = 26;
        static final int TRANSACTION_syncDownloadInfoFromOtherCache = 27;
        static final int TRANSACTION_updateDownloadInfo = 10;

        private static class Proxy implements ISqlDownloadCacheAidl {
            public static ISqlDownloadCacheAidl sDefaultImpl;
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

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public void init(boolean r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == false) goto L6;
                int r4 = 1;
            L7:
                r0.writeInt(r4);     // Catch: Throwable -> L17
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().init(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r4 = 0;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public boolean cacheExist(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeInt(r5);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L6;
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
                boolean r4 = Stub.getDefaultImpl().cacheExist(r5);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public DownloadInfo getDownloadInfo(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L6;
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

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public List<DownloadInfo> getDownloadInfoList(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L6;
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

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L6;
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

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(6, r0, r1, 0) == false) goto L6;
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

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public List<DownloadInfo> getDownloadInfosByFileExtension(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(7, r0, r1, 0) == false) goto L6;
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

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public List<DownloadInfo> getAllDownloadInfo() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(8, r0, r1, 0) == false) goto L6;
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

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public List<DownloadInfo> getDownloadInfosByFilters(String r5, String r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                if (this.mRemote.transact(9, r0, r1, 0) == false) goto L6;
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

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public boolean updateDownloadInfo(DownloadInfo r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                boolean r2 = true;
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L8:
                if (this.mRemote.transact(10, r0, r1, 0) == false) goto L10;
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

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public boolean removeDownloadInfo(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeInt(r5);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(11, r0, r1, 0) == false) goto L6;
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

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public boolean removeDownloadTaskData(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeInt(r5);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(12, r0, r1, 0) == false) goto L6;
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

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public void clearData() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(13, r0, r1, 0) == false) goto L6;
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

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public DownloadInfo onDownloadTaskStart(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
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
                DownloadInfo r6 = Stub.getDefaultImpl().onDownloadTaskStart(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r6;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public DownloadInfo OnDownloadTaskConnected(int r9, long r10, String r12, String r13) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeInt(r9);     // Catch: Throwable -> L17
                r0.writeLong(r10);     // Catch: Throwable -> L17
                r0.writeString(r12);     // Catch: Throwable -> L17
                r0.writeString(r13);     // Catch: Throwable -> L17
                if (this.mRemote.transact(15, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                DownloadInfo r8 = (DownloadInfo) ZeusTransformUtils.preCheckCast(DownloadInfo.CREATOR.createFromParcel(r1), DownloadInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r8;
            L14:
                r8 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                DownloadInfo r11 = Stub.getDefaultImpl().OnDownloadTaskConnected(r9, r10, r12, r13);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r11;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public DownloadInfo OnDownloadTaskProgress(int r5, long r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                r0.writeLong(r6);     // Catch: Throwable -> L17
                if (this.mRemote.transact(16, r0, r1, 0) == false) goto L6;
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
                DownloadInfo r7 = Stub.getDefaultImpl().OnDownloadTaskProgress(r5, r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r7;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public DownloadInfo OnDownloadTaskError(int r5, long r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                r0.writeLong(r6);     // Catch: Throwable -> L17
                if (this.mRemote.transact(17, r0, r1, 0) == false) goto L6;
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
                DownloadInfo r7 = Stub.getDefaultImpl().OnDownloadTaskError(r5, r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r7;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public DownloadInfo OnDownloadTaskRetry(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                if (this.mRemote.transact(18, r0, r1, 0) == false) goto L6;
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
                DownloadInfo r6 = Stub.getDefaultImpl().OnDownloadTaskRetry(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r6;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public DownloadInfo OnDownloadTaskCompleted(int r5, long r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                r0.writeLong(r6);     // Catch: Throwable -> L17
                if (this.mRemote.transact(19, r0, r1, 0) == false) goto L6;
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
                DownloadInfo r7 = Stub.getDefaultImpl().OnDownloadTaskCompleted(r5, r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r7;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public DownloadInfo OnDownloadTaskPause(int r5, long r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                r0.writeLong(r6);     // Catch: Throwable -> L17
                if (this.mRemote.transact(20, r0, r1, 0) == false) goto L6;
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
                DownloadInfo r7 = Stub.getDefaultImpl().OnDownloadTaskPause(r5, r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r7;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public DownloadInfo OnDownloadTaskCancel(int r5, long r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                r0.writeLong(r6);     // Catch: Throwable -> L17
                if (this.mRemote.transact(21, r0, r1, 0) == false) goto L6;
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
                DownloadInfo r7 = Stub.getDefaultImpl().OnDownloadTaskCancel(r5, r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r7;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public DownloadInfo OnDownloadTaskPrepare(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                if (this.mRemote.transact(22, r0, r1, 0) == false) goto L6;
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
                DownloadInfo r6 = Stub.getDefaultImpl().OnDownloadTaskPrepare(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r6;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public DownloadInfo OnDownloadTaskIntercept(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeInt(r5);     // Catch: Throwable -> L17
                if (this.mRemote.transact(23, r0, r1, 0) == false) goto L6;
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
                DownloadInfo r6 = Stub.getDefaultImpl().OnDownloadTaskIntercept(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r6;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public boolean isDownloadCacheSyncSuccess() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(24, r0, r1, 0) == false) goto L6;
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

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public boolean ensureDownloadCacheSyncSuccess() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(25, r0, r1, 0) == false) goto L6;
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
                boolean r4 = Stub.getDefaultImpl().ensureDownloadCacheSyncSuccess();     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public void syncDownloadInfo(DownloadInfo r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.mRemote.transact(26, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().syncDownloadInfo(r5);     // Catch: Throwable -> L17
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

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public void syncDownloadInfoFromOtherCache(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(27, r0, r1, 0) == false) goto L6;
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

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public void setInitCallback(ISqlCacheLoadCompleteCallbackAidl r5) {
                ISqlCacheLoadCompleteCallbackAidl r6 = (ISqlCacheLoadCompleteCallbackAidl) ZeusTransformUtils.wrapperContextForParams(r5, ISqlCacheLoadCompleteCallbackAidl.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(28, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setInitCallback(r6);     // Catch: Throwable -> L17
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
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ISqlDownloadCacheAidl asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, ISqlDownloadCacheAidl.class) == false) goto L13;
            return (ISqlDownloadCacheAidl) ZeusTransformUtils.preCheckCast(r0, ISqlDownloadCacheAidl.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r12, Parcel r13, Parcel r14, int r15) {
            if (r12 == 1598968902) goto L106;
            DownloadInfo r3 = null;
            boolean r4 = false;
            switch(r12) {
                case 1: goto L101;
                case 2: goto L99;
                case 3: goto L94;
                case 4: goto L92;
                case 5: goto L90;
                case 6: goto L88;
                case 7: goto L86;
                case 8: goto L84;
                case 9: goto L82;
                case 10: goto L77;
                case 11: goto L75;
                case 12: goto L73;
                case 13: goto L71;
                case 14: goto L66;
                case 15: goto L61;
                case 16: goto L56;
                case 17: goto L51;
                case 18: goto L46;
                case 19: goto L41;
                case 20: goto L36;
                case 21: goto L31;
                case 22: goto L26;
                case 23: goto L21;
                case 24: goto L19;
                case 25: goto L17;
                case 26: goto L12;
                case 27: goto L10;
                case 28: goto L8;
                default: goto L7;
            };
        L8:
            r13.enforceInterface(DESCRIPTOR);
            setInitCallback(ISqlCacheLoadCompleteCallbackAidl.Stub.asInterface(r13.readStrongBinder()));
            r14.writeNoException();
            return true;
        L10:
            r13.enforceInterface(DESCRIPTOR);
            syncDownloadInfoFromOtherCache(r13.readInt());
            r14.writeNoException();
            return true;
        L12:
            r13.enforceInterface(DESCRIPTOR);
            if (r13.readInt() == 0) goto L15;
            r3 = (DownloadInfo) ZeusTransformUtils.preCheckCast(DownloadInfo.CREATOR.createFromParcel(r13), DownloadInfo.class, "com.obric.aiagent.plugin");
        L15:
            syncDownloadInfo(r3);
            r14.writeNoException();
            return true;
        L17:
            r13.enforceInterface(DESCRIPTOR);
            boolean r11 = ensureDownloadCacheSyncSuccess();
            r14.writeNoException();
            r14.writeInt(r11 ? 1 : 0);
            return true;
        L19:
            r13.enforceInterface(DESCRIPTOR);
            boolean r16 = isDownloadCacheSyncSuccess();
            r14.writeNoException();
            r14.writeInt(r16 ? 1 : 0);
            return true;
        L21:
            r13.enforceInterface(DESCRIPTOR);
            DownloadInfo r17 = OnDownloadTaskIntercept(r13.readInt());
            r14.writeNoException();
            if (r17 == null) goto L24;
            r14.writeInt(1);
            r17.writeToParcel(r14, 1);
        L25:
            return true;
        L24:
            r14.writeInt(0);
            goto L25
        L26:
            r13.enforceInterface(DESCRIPTOR);
            DownloadInfo r18 = OnDownloadTaskPrepare(r13.readInt());
            r14.writeNoException();
            if (r18 == null) goto L29;
            r14.writeInt(1);
            r18.writeToParcel(r14, 1);
        L30:
            return true;
        L29:
            r14.writeInt(0);
            goto L30
        L31:
            r13.enforceInterface(DESCRIPTOR);
            DownloadInfo r19 = OnDownloadTaskCancel(r13.readInt(), r13.readLong());
            r14.writeNoException();
            if (r19 == null) goto L34;
            r14.writeInt(1);
            r19.writeToParcel(r14, 1);
        L35:
            return true;
        L34:
            r14.writeInt(0);
            goto L35
        L36:
            r13.enforceInterface(DESCRIPTOR);
            DownloadInfo r110 = OnDownloadTaskPause(r13.readInt(), r13.readLong());
            r14.writeNoException();
            if (r110 == null) goto L39;
            r14.writeInt(1);
            r110.writeToParcel(r14, 1);
        L40:
            return true;
        L39:
            r14.writeInt(0);
            goto L40
        L41:
            r13.enforceInterface(DESCRIPTOR);
            DownloadInfo r111 = OnDownloadTaskCompleted(r13.readInt(), r13.readLong());
            r14.writeNoException();
            if (r111 == null) goto L44;
            r14.writeInt(1);
            r111.writeToParcel(r14, 1);
        L45:
            return true;
        L44:
            r14.writeInt(0);
            goto L45
        L46:
            r13.enforceInterface(DESCRIPTOR);
            DownloadInfo r112 = OnDownloadTaskRetry(r13.readInt());
            r14.writeNoException();
            if (r112 == null) goto L49;
            r14.writeInt(1);
            r112.writeToParcel(r14, 1);
        L50:
            return true;
        L49:
            r14.writeInt(0);
            goto L50
        L51:
            r13.enforceInterface(DESCRIPTOR);
            DownloadInfo r113 = OnDownloadTaskError(r13.readInt(), r13.readLong());
            r14.writeNoException();
            if (r113 == null) goto L54;
            r14.writeInt(1);
            r113.writeToParcel(r14, 1);
        L55:
            return true;
        L54:
            r14.writeInt(0);
            goto L55
        L56:
            r13.enforceInterface(DESCRIPTOR);
            DownloadInfo r114 = OnDownloadTaskProgress(r13.readInt(), r13.readLong());
            r14.writeNoException();
            if (r114 == null) goto L59;
            r14.writeInt(1);
            r114.writeToParcel(r14, 1);
        L60:
            return true;
        L59:
            r14.writeInt(0);
            goto L60
        L61:
            r13.enforceInterface(DESCRIPTOR);
            DownloadInfo r115 = OnDownloadTaskConnected(r13.readInt(), r13.readLong(), r13.readString(), r13.readString());
            r14.writeNoException();
            if (r115 == null) goto L64;
            r14.writeInt(1);
            r115.writeToParcel(r14, 1);
        L65:
            return true;
        L64:
            r14.writeInt(0);
            goto L65
        L66:
            r13.enforceInterface(DESCRIPTOR);
            DownloadInfo r116 = onDownloadTaskStart(r13.readInt());
            r14.writeNoException();
            if (r116 == null) goto L69;
            r14.writeInt(1);
            r116.writeToParcel(r14, 1);
        L70:
            return true;
        L69:
            r14.writeInt(0);
            goto L70
        L71:
            r13.enforceInterface(DESCRIPTOR);
            clearData();
            r14.writeNoException();
            return true;
        L73:
            r13.enforceInterface(DESCRIPTOR);
            boolean r117 = removeDownloadTaskData(r13.readInt());
            r14.writeNoException();
            r14.writeInt(r117 ? 1 : 0);
            return true;
        L75:
            r13.enforceInterface(DESCRIPTOR);
            boolean r118 = removeDownloadInfo(r13.readInt());
            r14.writeNoException();
            r14.writeInt(r118 ? 1 : 0);
            return true;
        L77:
            r13.enforceInterface(DESCRIPTOR);
            if (r13.readInt() == 0) goto L80;
            r3 = (DownloadInfo) ZeusTransformUtils.preCheckCast(DownloadInfo.CREATOR.createFromParcel(r13), DownloadInfo.class, "com.obric.aiagent.plugin");
        L80:
            boolean r119 = updateDownloadInfo(r3);
            r14.writeNoException();
            r14.writeInt(r119 ? 1 : 0);
            return true;
        L82:
            r13.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r120 = getDownloadInfosByFilters(r13.readString(), r13.readString());
            r14.writeNoException();
            r14.writeTypedList(r120);
            return true;
        L84:
            r13.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r121 = getAllDownloadInfo();
            r14.writeNoException();
            r14.writeTypedList(r121);
            return true;
        L86:
            r13.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r122 = getDownloadInfosByFileExtension(r13.readString());
            r14.writeNoException();
            r14.writeTypedList(r122);
            return true;
        L88:
            r13.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r123 = getUnCompletedDownloadInfosWithMimeType(r13.readString());
            r14.writeNoException();
            r14.writeTypedList(r123);
            return true;
        L90:
            r13.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r124 = getSuccessedDownloadInfosWithMimeType(r13.readString());
            r14.writeNoException();
            r14.writeTypedList(r124);
            return true;
        L92:
            r13.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r125 = getDownloadInfoList(r13.readString());
            r14.writeNoException();
            r14.writeTypedList(r125);
            return true;
        L94:
            r13.enforceInterface(DESCRIPTOR);
            DownloadInfo r126 = getDownloadInfo(r13.readInt());
            r14.writeNoException();
            if (r126 == null) goto L97;
            r14.writeInt(1);
            r126.writeToParcel(r14, 1);
        L98:
            return true;
        L97:
            r14.writeInt(0);
            goto L98
        L99:
            r13.enforceInterface(DESCRIPTOR);
            boolean r127 = cacheExist(r13.readInt());
            r14.writeNoException();
            r14.writeInt(r127 ? 1 : 0);
            return true;
        L101:
            r13.enforceInterface(DESCRIPTOR);
            if (r13.readInt() == 0) goto L104;
            r4 = true;
        L104:
            init(r4);
            r14.writeNoException();
            return true;
        L7:
            return super.onTransact(r12, r13, r14, r15);
        L106:
            r14.writeString(DESCRIPTOR);
            return true;
        }

        public static boolean setDefaultImpl(ISqlDownloadCacheAidl r2) {
            ISqlDownloadCacheAidl r3 = (ISqlDownloadCacheAidl) ZeusTransformUtils.wrapperContextForParams(r2, ISqlDownloadCacheAidl.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r3 == null) goto L7;
            Proxy.sDefaultImpl = r3;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        public static ISqlDownloadCacheAidl getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    DownloadInfo OnDownloadTaskCancel(int r1, long r2);

    DownloadInfo OnDownloadTaskCompleted(int r1, long r2);

    DownloadInfo OnDownloadTaskConnected(int r1, long r2, String r4, String r5);

    DownloadInfo OnDownloadTaskError(int r1, long r2);

    DownloadInfo OnDownloadTaskIntercept(int r1);

    DownloadInfo OnDownloadTaskPause(int r1, long r2);

    DownloadInfo OnDownloadTaskPrepare(int r1);

    DownloadInfo OnDownloadTaskProgress(int r1, long r2);

    DownloadInfo OnDownloadTaskRetry(int r1);

    boolean cacheExist(int r1);

    void clearData();

    boolean ensureDownloadCacheSyncSuccess();

    List<DownloadInfo> getAllDownloadInfo();

    DownloadInfo getDownloadInfo(int r1);

    List<DownloadInfo> getDownloadInfoList(String r1);

    List<DownloadInfo> getDownloadInfosByFileExtension(String r1);

    List<DownloadInfo> getDownloadInfosByFilters(String r1, String r2);

    List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r1);

    List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r1);

    void init(boolean r1);

    boolean isDownloadCacheSyncSuccess();

    DownloadInfo onDownloadTaskStart(int r1);

    boolean removeDownloadInfo(int r1);

    boolean removeDownloadTaskData(int r1);

    void setInitCallback(ISqlCacheLoadCompleteCallbackAidl r1);

    void syncDownloadInfo(DownloadInfo r1);

    void syncDownloadInfoFromOtherCache(int r1);

    boolean updateDownloadInfo(DownloadInfo r1);
}
