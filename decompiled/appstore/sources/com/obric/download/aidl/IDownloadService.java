package com.obric.download.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.obric.download.base.DownloadInfo;
import com.obric.download.base.DownloadTask;
import com.obric.download.base.TaskOperateResult;

/* JADX INFO: loaded from: classes4.dex */
public interface IDownloadService extends IInterface {

    public static abstract class a extends Binder implements IDownloadService {

        /* JADX INFO: renamed from: com.obric.download.aidl.IDownloadService$a$a, reason: collision with other inner class name */
        public static class C0182a implements IDownloadService {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static IDownloadService f11858b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f11859a;

            public C0182a(IBinder r10) {
                this.f11859a = r10;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f11859a;
            }

            @Override // com.obric.download.aidl.IDownloadService
            public void cancelAllTask() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.obric.download.aidl.IDownloadService");     // Catch: Throwable -> L10
                if (this.f11859a.transact(11, r10, r11, 0) == false) goto L6;
            L12:
                r11.readException();     // Catch: Throwable -> L10
                r11.recycle();
                r10.recycle();
                return;
            L6:
                if (a.b() == null) goto L12;
                a.b().cancelAllTask();     // Catch: Throwable -> L10
                r11.recycle();
                r10.recycle();
                return;
            L10:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.download.aidl.IDownloadService
            public TaskOperateResult cancelTaskById(int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.obric.download.aidl.IDownloadService");     // Catch: Throwable -> L10
                r11.writeInt(r10);     // Catch: Throwable -> L10
                if (this.f11859a.transact(9, r11, r12, 0) == false) goto L6;
            L12:
                r12.readException();     // Catch: Throwable -> L10
                if (r12.readInt() == 0) goto L16;
                TaskOperateResult r13 = TaskOperateResult.CREATOR.a(r12);     // Catch: Throwable -> L10
            L17:
                r12.recycle();
                r11.recycle();
                return r13;
            L16:
                r13 = null;
                goto L17
            L6:
                if (a.b() == null) goto L12;
                TaskOperateResult r14 = a.b().cancelTaskById(r10);     // Catch: Throwable -> L10
                r12.recycle();
                r11.recycle();
                return r14;
            L10:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.download.aidl.IDownloadService
            public TaskOperateResult cancelTaskByIdList(String r10, int[] r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.obric.download.aidl.IDownloadService");     // Catch: Throwable -> L10
                r12.writeString(r10);     // Catch: Throwable -> L10
                r12.writeIntArray(r11);     // Catch: Throwable -> L10
                if (this.f11859a.transact(10, r12, r13, 0) == false) goto L6;
            L12:
                r13.readException();     // Catch: Throwable -> L10
                if (r13.readInt() == 0) goto L16;
                TaskOperateResult r14 = TaskOperateResult.CREATOR.a(r13);     // Catch: Throwable -> L10
            L17:
                r13.recycle();
                r12.recycle();
                return r14;
            L16:
                r14 = null;
                goto L17
            L6:
                if (a.b() == null) goto L12;
                TaskOperateResult r15 = a.b().cancelTaskByIdList(r10, r11);     // Catch: Throwable -> L10
                r13.recycle();
                r12.recycle();
                return r15;
            L10:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.obric.download.aidl.IDownloadService
            public void degradeDownload(int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.obric.download.aidl.IDownloadService");     // Catch: Throwable -> L10
                r11.writeInt(r10);     // Catch: Throwable -> L10
                if (this.f11859a.transact(12, r11, r12, 0) == false) goto L6;
            L12:
                r12.readException();     // Catch: Throwable -> L10
                r12.recycle();
                r11.recycle();
                return;
            L6:
                if (a.b() == null) goto L12;
                a.b().degradeDownload(r10);     // Catch: Throwable -> L10
                r12.recycle();
                r11.recycle();
                return;
            L10:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.download.aidl.IDownloadService
            public DownloadInfo getDownloadInfo(int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.obric.download.aidl.IDownloadService");     // Catch: Throwable -> L10
                r11.writeInt(r10);     // Catch: Throwable -> L10
                if (this.f11859a.transact(15, r11, r12, 0) == false) goto L6;
            L12:
                r12.readException();     // Catch: Throwable -> L10
                if (r12.readInt() == 0) goto L16;
                DownloadInfo r13 = DownloadInfo.CREATOR.a(r12);     // Catch: Throwable -> L10
            L17:
                r12.recycle();
                r11.recycle();
                return r13;
            L16:
                r13 = null;
                goto L17
            L6:
                if (a.b() == null) goto L12;
                DownloadInfo r14 = a.b().getDownloadInfo(r10);     // Catch: Throwable -> L10
                r12.recycle();
                r11.recycle();
                return r14;
            L10:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.download.aidl.IDownloadService
            public void getDownloadInfoAsync(int r10, IGetDownloadInfoListCallback r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.obric.download.aidl.IDownloadService");     // Catch: Throwable -> L6
                r12.writeInt(r10);     // Catch: Throwable -> L6
                if (r11 == null) goto L8;
                IBinder r14 = r11.asBinder();     // Catch: Throwable -> L6
            L9:
                r12.writeStrongBinder(r14);     // Catch: Throwable -> L6
                if (this.f11859a.transact(16, r12, r13, 0) == false) goto L12;
            L16:
                r13.readException();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L12:
                if (a.b() == null) goto L16;
                a.b().getDownloadInfoAsync(r10, r11);     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L8:
                r14 = null;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.obric.download.aidl.IDownloadService
            public void getDownloadInfoList(String r10, IGetDownloadInfoListCallback r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.obric.download.aidl.IDownloadService");     // Catch: Throwable -> L6
                r12.writeString(r10);     // Catch: Throwable -> L6
                if (r11 == null) goto L8;
                IBinder r14 = r11.asBinder();     // Catch: Throwable -> L6
            L9:
                r12.writeStrongBinder(r14);     // Catch: Throwable -> L6
                if (this.f11859a.transact(17, r12, r13, 0) == false) goto L12;
            L16:
                r13.readException();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L12:
                if (a.b() == null) goto L16;
                a.b().getDownloadInfoList(r10, r11);     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L8:
                r14 = null;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.obric.download.aidl.IDownloadService
            public void getDownloadInfoListByStatusList(String r10, int[] r11, IGetDownloadInfoListCallback r12) {
                Parcel r13 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken("com.obric.download.aidl.IDownloadService");     // Catch: Throwable -> L6
                r13.writeString(r10);     // Catch: Throwable -> L6
                r13.writeIntArray(r11);     // Catch: Throwable -> L6
                if (r12 == null) goto L8;
                IBinder r15 = r12.asBinder();     // Catch: Throwable -> L6
            L9:
                r13.writeStrongBinder(r15);     // Catch: Throwable -> L6
                if (this.f11859a.transact(18, r13, r14, 0) == false) goto L12;
            L16:
                r14.readException();     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L12:
                if (a.b() == null) goto L16;
                a.b().getDownloadInfoListByStatusList(r10, r11, r12);     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L8:
                r15 = null;
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.obric.download.aidl.IDownloadService
            public int getTaskStatus(int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.obric.download.aidl.IDownloadService");     // Catch: Throwable -> L10
                r11.writeInt(r10);     // Catch: Throwable -> L10
                if (this.f11859a.transact(14, r11, r12, 0) == false) goto L6;
            L12:
                r12.readException();     // Catch: Throwable -> L10
                int r13 = r12.readInt();     // Catch: Throwable -> L10
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                if (a.b() == null) goto L12;
                int r14 = a.b().getTaskStatus(r10);     // Catch: Throwable -> L10
                r12.recycle();
                r11.recycle();
                return r14;
            L10:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.download.aidl.IDownloadService
            public void init(String r10, String r11, int r12, String r13) {
                Parcel r14 = Parcel.obtain();
                Parcel r15 = Parcel.obtain();
                r14.writeInterfaceToken("com.obric.download.aidl.IDownloadService");     // Catch: Throwable -> L10
                r14.writeString(r10);     // Catch: Throwable -> L10
                r14.writeString(r11);     // Catch: Throwable -> L10
                r14.writeInt(r12);     // Catch: Throwable -> L10
                r14.writeString(r13);     // Catch: Throwable -> L10
                if (this.f11859a.transact(1, r14, r15, 0) == false) goto L6;
            L12:
                r15.readException();     // Catch: Throwable -> L10
                r15.recycle();
                r14.recycle();
                return;
            L6:
                if (a.b() == null) goto L12;
                a.b().init(r10, r11, r12, r13);     // Catch: Throwable -> L10
                r15.recycle();
                r14.recycle();
                return;
            L10:
                th = move-exception;
                r15.recycle();
                r14.recycle();
                throw th;
            }

            @Override // com.obric.download.aidl.IDownloadService
            public TaskOperateResult pauseTaskById(int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.obric.download.aidl.IDownloadService");     // Catch: Throwable -> L10
                r11.writeInt(r10);     // Catch: Throwable -> L10
                if (this.f11859a.transact(6, r11, r12, 0) == false) goto L6;
            L12:
                r12.readException();     // Catch: Throwable -> L10
                if (r12.readInt() == 0) goto L16;
                TaskOperateResult r13 = TaskOperateResult.CREATOR.a(r12);     // Catch: Throwable -> L10
            L17:
                r12.recycle();
                r11.recycle();
                return r13;
            L16:
                r13 = null;
                goto L17
            L6:
                if (a.b() == null) goto L12;
                TaskOperateResult r14 = a.b().pauseTaskById(r10);     // Catch: Throwable -> L10
                r12.recycle();
                r11.recycle();
                return r14;
            L10:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.download.aidl.IDownloadService
            public TaskOperateResult prioritySubmitTask(int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.obric.download.aidl.IDownloadService");     // Catch: Throwable -> L10
                r11.writeInt(r10);     // Catch: Throwable -> L10
                if (this.f11859a.transact(3, r11, r12, 0) == false) goto L6;
            L12:
                r12.readException();     // Catch: Throwable -> L10
                if (r12.readInt() == 0) goto L16;
                TaskOperateResult r13 = TaskOperateResult.CREATOR.a(r12);     // Catch: Throwable -> L10
            L17:
                r12.recycle();
                r11.recycle();
                return r13;
            L16:
                r13 = null;
                goto L17
            L6:
                if (a.b() == null) goto L12;
                TaskOperateResult r14 = a.b().prioritySubmitTask(r10);     // Catch: Throwable -> L10
                r12.recycle();
                r11.recycle();
                return r14;
            L10:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.download.aidl.IDownloadService
            public void registerCallback(String r10, String r11, IDownloadCallback r12) {
                Parcel r13 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken("com.obric.download.aidl.IDownloadService");     // Catch: Throwable -> L6
                r13.writeString(r10);     // Catch: Throwable -> L6
                r13.writeString(r11);     // Catch: Throwable -> L6
                if (r12 == null) goto L8;
                IBinder r15 = r12.asBinder();     // Catch: Throwable -> L6
            L9:
                r13.writeStrongBinder(r15);     // Catch: Throwable -> L6
                if (this.f11859a.transact(4, r13, r14, 0) == false) goto L12;
            L16:
                r14.readException();     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L12:
                if (a.b() == null) goto L16;
                a.b().registerCallback(r10, r11, r12);     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L8:
                r15 = null;
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.obric.download.aidl.IDownloadService
            public void registerNotificationClickCallback(String r10, String r11, INotificationClickCallback r12) {
                Parcel r13 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken("com.obric.download.aidl.IDownloadService");     // Catch: Throwable -> L6
                r13.writeString(r10);     // Catch: Throwable -> L6
                r13.writeString(r11);     // Catch: Throwable -> L6
                if (r12 == null) goto L8;
                IBinder r15 = r12.asBinder();     // Catch: Throwable -> L6
            L9:
                r13.writeStrongBinder(r15);     // Catch: Throwable -> L6
                if (this.f11859a.transact(19, r13, r14, 0) == false) goto L12;
            L16:
                r14.readException();     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L12:
                if (a.b() == null) goto L16;
                a.b().registerNotificationClickCallback(r10, r11, r12);     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L8:
                r15 = null;
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.obric.download.aidl.IDownloadService
            public TaskOperateResult restartTaskById(int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.obric.download.aidl.IDownloadService");     // Catch: Throwable -> L10
                r11.writeInt(r10);     // Catch: Throwable -> L10
                if (this.f11859a.transact(8, r11, r12, 0) == false) goto L6;
            L12:
                r12.readException();     // Catch: Throwable -> L10
                if (r12.readInt() == 0) goto L16;
                TaskOperateResult r13 = TaskOperateResult.CREATOR.a(r12);     // Catch: Throwable -> L10
            L17:
                r12.recycle();
                r11.recycle();
                return r13;
            L16:
                r13 = null;
                goto L17
            L6:
                if (a.b() == null) goto L12;
                TaskOperateResult r14 = a.b().restartTaskById(r10);     // Catch: Throwable -> L10
                r12.recycle();
                r11.recycle();
                return r14;
            L10:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.download.aidl.IDownloadService
            public void resumeAllTask(String r10, boolean r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.obric.download.aidl.IDownloadService");     // Catch: Throwable -> L10
                r12.writeString(r10);     // Catch: Throwable -> L10
                r12.writeInt(r11 ? 1 : 0);     // Catch: Throwable -> L10
                if (this.f11859a.transact(20, r12, r13, 0) == false) goto L6;
            L12:
                r13.readException();     // Catch: Throwable -> L10
                r13.recycle();
                r12.recycle();
                return;
            L6:
                if (a.b() == null) goto L12;
                a.b().resumeAllTask(r10, r11);     // Catch: Throwable -> L10
                r13.recycle();
                r12.recycle();
                return;
            L10:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.obric.download.aidl.IDownloadService
            public TaskOperateResult resumeTaskById(int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.obric.download.aidl.IDownloadService");     // Catch: Throwable -> L10
                r11.writeInt(r10);     // Catch: Throwable -> L10
                if (this.f11859a.transact(7, r11, r12, 0) == false) goto L6;
            L12:
                r12.readException();     // Catch: Throwable -> L10
                if (r12.readInt() == 0) goto L16;
                TaskOperateResult r13 = TaskOperateResult.CREATOR.a(r12);     // Catch: Throwable -> L10
            L17:
                r12.recycle();
                r11.recycle();
                return r13;
            L16:
                r13 = null;
                goto L17
            L6:
                if (a.b() == null) goto L12;
                TaskOperateResult r14 = a.b().resumeTaskById(r10);     // Catch: Throwable -> L10
                r12.recycle();
                r11.recycle();
                return r14;
            L10:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.download.aidl.IDownloadService
            public void setExtraInfo(int r10, String r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.obric.download.aidl.IDownloadService");     // Catch: Throwable -> L10
                r12.writeInt(r10);     // Catch: Throwable -> L10
                r12.writeString(r11);     // Catch: Throwable -> L10
                if (this.f11859a.transact(22, r12, r13, 0) == false) goto L6;
            L12:
                r13.readException();     // Catch: Throwable -> L10
                r13.recycle();
                r12.recycle();
                return;
            L6:
                if (a.b() == null) goto L12;
                a.b().setExtraInfo(r10, r11);     // Catch: Throwable -> L10
                r13.recycle();
                r12.recycle();
                return;
            L10:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.obric.download.aidl.IDownloadService
            public void setNotificationClickReceiver(String r10, String r11, String r12) {
                Parcel r13 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken("com.obric.download.aidl.IDownloadService");     // Catch: Throwable -> L10
                r13.writeString(r10);     // Catch: Throwable -> L10
                r13.writeString(r11);     // Catch: Throwable -> L10
                r13.writeString(r12);     // Catch: Throwable -> L10
                if (this.f11859a.transact(21, r13, r14, 0) == false) goto L6;
            L12:
                r14.readException();     // Catch: Throwable -> L10
                r14.recycle();
                r13.recycle();
                return;
            L6:
                if (a.b() == null) goto L12;
                a.b().setNotificationClickReceiver(r10, r11, r12);     // Catch: Throwable -> L10
                r14.recycle();
                r13.recycle();
                return;
            L10:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.obric.download.aidl.IDownloadService
            public void setWifiOnly(int r10, boolean r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.obric.download.aidl.IDownloadService");     // Catch: Throwable -> L10
                r12.writeInt(r10);     // Catch: Throwable -> L10
                r12.writeInt(r11 ? 1 : 0);     // Catch: Throwable -> L10
                if (this.f11859a.transact(23, r12, r13, 0) == false) goto L6;
            L12:
                r13.readException();     // Catch: Throwable -> L10
                r13.recycle();
                r12.recycle();
                return;
            L6:
                if (a.b() == null) goto L12;
                a.b().setWifiOnly(r10, r11);     // Catch: Throwable -> L10
                r13.recycle();
                r12.recycle();
                return;
            L10:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.obric.download.aidl.IDownloadService
            public TaskOperateResult submitTask(DownloadTask r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.obric.download.aidl.IDownloadService");     // Catch: Throwable -> L6
                if (r10 == null) goto L8;
                r11.writeInt(1);     // Catch: Throwable -> L6
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L6
            L10:
                if (this.f11859a.transact(2, r11, r12, 0) == false) goto L12;
            L16:
                r12.readException();     // Catch: Throwable -> L6
                if (r12.readInt() == 0) goto L20;
                TaskOperateResult r13 = TaskOperateResult.CREATOR.a(r12);     // Catch: Throwable -> L6
            L21:
                r12.recycle();
                r11.recycle();
                return r13;
            L20:
                r13 = null;
                goto L21
            L12:
                if (a.b() == null) goto L16;
                TaskOperateResult r14 = a.b().submitTask(r10);     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return r14;
            L8:
                r11.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.download.aidl.IDownloadService
            public void unregisterCallback(String r10, String r11, IDownloadCallback r12) {
                Parcel r13 = Parcel.obtain();
                Parcel r14 = Parcel.obtain();
                r13.writeInterfaceToken("com.obric.download.aidl.IDownloadService");     // Catch: Throwable -> L6
                r13.writeString(r10);     // Catch: Throwable -> L6
                r13.writeString(r11);     // Catch: Throwable -> L6
                if (r12 == null) goto L8;
                IBinder r15 = r12.asBinder();     // Catch: Throwable -> L6
            L9:
                r13.writeStrongBinder(r15);     // Catch: Throwable -> L6
                if (this.f11859a.transact(5, r13, r14, 0) == false) goto L12;
            L16:
                r14.readException();     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L12:
                if (a.b() == null) goto L16;
                a.b().unregisterCallback(r10, r11, r12);     // Catch: Throwable -> L6
                r14.recycle();
                r13.recycle();
                return;
            L8:
                r15 = null;
            L6:
                th = move-exception;
                r14.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.obric.download.aidl.IDownloadService
            public void upgradeDownload(int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.obric.download.aidl.IDownloadService");     // Catch: Throwable -> L10
                r11.writeInt(r10);     // Catch: Throwable -> L10
                if (this.f11859a.transact(13, r11, r12, 0) == false) goto L6;
            L12:
                r12.readException();     // Catch: Throwable -> L10
                r12.recycle();
                r11.recycle();
                return;
            L6:
                if (a.b() == null) goto L12;
                a.b().upgradeDownload(r10);     // Catch: Throwable -> L10
                r12.recycle();
                r11.recycle();
                return;
            L10:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }
        }

        public static IDownloadService a(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface("com.obric.download.aidl.IDownloadService");
            if (r11 == null) goto L12;
            if ((r11 instanceof IDownloadService) == false) goto L12;
            return (IDownloadService) r11;
        L12:
            return new C0182a(r10);
        }

        public static IDownloadService b() {
            return C0182a.f11858b;
        }
    }

    void cancelAllTask() throws RemoteException;

    TaskOperateResult cancelTaskById(int r10) throws RemoteException;

    TaskOperateResult cancelTaskByIdList(String r10, int[] r11) throws RemoteException;

    void degradeDownload(int r10) throws RemoteException;

    DownloadInfo getDownloadInfo(int r10) throws RemoteException;

    void getDownloadInfoAsync(int r10, IGetDownloadInfoListCallback r11) throws RemoteException;

    void getDownloadInfoList(String r10, IGetDownloadInfoListCallback r11) throws RemoteException;

    void getDownloadInfoListByStatusList(String r10, int[] r11, IGetDownloadInfoListCallback r12) throws RemoteException;

    int getTaskStatus(int r10) throws RemoteException;

    void init(String r10, String r11, int r12, String r13) throws RemoteException;

    TaskOperateResult pauseTaskById(int r10) throws RemoteException;

    TaskOperateResult prioritySubmitTask(int r10) throws RemoteException;

    void registerCallback(String r10, String r11, IDownloadCallback r12) throws RemoteException;

    void registerNotificationClickCallback(String r10, String r11, INotificationClickCallback r12) throws RemoteException;

    TaskOperateResult restartTaskById(int r10) throws RemoteException;

    void resumeAllTask(String r10, boolean r11) throws RemoteException;

    TaskOperateResult resumeTaskById(int r10) throws RemoteException;

    void setExtraInfo(int r10, String r11) throws RemoteException;

    void setNotificationClickReceiver(String r10, String r11, String r12) throws RemoteException;

    void setWifiOnly(int r10, boolean r11) throws RemoteException;

    TaskOperateResult submitTask(DownloadTask r10) throws RemoteException;

    void unregisterCallback(String r10, String r11, IDownloadCallback r12) throws RemoteException;

    void upgradeDownload(int r10) throws RemoteException;
}
