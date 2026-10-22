package com.ss.android.socialbase.downloader.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlListener;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceCallback;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback;
import com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadForbiddenCallback;
import com.ss.android.socialbase.downloader.depend.IDownloadForbiddenHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.depend.ProcessAidlCallback;
import com.ss.android.socialbase.downloader.depend.ProcessCallback;
import com.ss.android.socialbase.downloader.model.DownloadAidlTask;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class IPCUtils {
    private static Handler mMainThreadHandler;

    public IPCUtils() {
    }

    static /* synthetic */ Handler access$000() {
        return mMainThreadHandler;
    }

    static {
        mMainThreadHandler = new Handler(Looper.getMainLooper());
    }

    public static DownloadAidlTask convertDownloadTaskToAidl(final DownloadTask r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new AnonymousClass1(r1);
    }

    public static IDownloadAidlListener convertListenerToAidl(IDownloadListener r2, final boolean r3) {
        final IDownloadListener r4 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadListener.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass2(r4, r3);
    }

    public static IDownloadNotificationEventAidlListener convertDownloadNotificationEventListenerToAidl(IDownloadNotificationEventListener r2) {
        final IDownloadNotificationEventListener r3 = (IDownloadNotificationEventListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadNotificationEventListener.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass3(r3);
    }

    public static INotificationClickAidlCallback convertNotificationClickCallbackToAidl(INotificationClickCallback r2) {
        final INotificationClickCallback r3 = (INotificationClickCallback) ZeusTransformUtils.wrapperContextForParams(r2, INotificationClickCallback.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass4(r3);
    }

    public static IDownloadForbiddenAidlHandler convertForbiddenHandlerToAidl(IDownloadForbiddenHandler r2) {
        final IDownloadForbiddenHandler r3 = (IDownloadForbiddenHandler) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadForbiddenHandler.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass5(r3);
    }

    public static IDownloadAidlFileProvider convertFileProviderToAidl(IDownloadFileUriProvider r2) {
        final IDownloadFileUriProvider r3 = (IDownloadFileUriProvider) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadFileUriProvider.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass6(r3);
    }

    public static IDownloadForbiddenCallback convertForbiddenCallbackFromAidl(IDownloadForbiddenAidlCallback r2) {
        final IDownloadForbiddenAidlCallback r3 = (IDownloadForbiddenAidlCallback) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadForbiddenAidlCallback.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass7(r3);
    }

    public static IDownloadDiskSpaceAidlHandler convertDiskSpaceHandlerToAidl(IDownloadDiskSpaceHandler r2) {
        final IDownloadDiskSpaceHandler r3 = (IDownloadDiskSpaceHandler) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadDiskSpaceHandler.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass8(r3);
    }

    public static IDownloadDiskSpaceCallback convertDiskSpaceCallbackFromAidl(IDownloadDiskSpaceAidlCallback r2) {
        final IDownloadDiskSpaceAidlCallback r3 = (IDownloadDiskSpaceAidlCallback) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadDiskSpaceAidlCallback.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass9(r3);
    }

    public static IDownloadAidlDepend convertDependToAidl(IDownloadDepend r2) {
        final IDownloadDepend r3 = (IDownloadDepend) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadDepend.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass10(r3);
    }

    public static IDownloadAidlMonitorDepend convertMonitorDependToAidl(IDownloadMonitorDepend r2) {
        final IDownloadMonitorDepend r3 = (IDownloadMonitorDepend) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadMonitorDepend.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass11(r3);
    }

    public static IDownloadAidlInterceptor convertInterceptorToAidl(IDownloadInterceptor r2) {
        final IDownloadInterceptor r3 = (IDownloadInterceptor) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadInterceptor.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass12(r3);
    }

    public static DownloadTask convertDownloadTaskFromAidl(DownloadAidlTask r4) {
        DownloadAidlTask r5 = (DownloadAidlTask) ZeusTransformUtils.wrapperContextForParams(r4, DownloadAidlTask.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L19;
        return null;
    L19:
        DownloadTask r1 = new DownloadTask(r5.getDownloadInfo());     // Catch: RemoteException -> L16
        r1.notificationEventListener(convertDownloadNotificationEventListenerFromAidl(r5.getDownloadNotificationEventListener())).interceptor(convertInterceptorFromAidl(r5.getInterceptor())).depend(convertDownloadDependFromAidl(r5.getDepend())).monitorDepend(convertDownloadMonitorDependFromAidl(r5.getMonitorDepend())).forbiddenHandler(convertForbiddenHandlerFromAidl(r5.getForbiddenHandler())).diskSpaceHandler(convertDiskSpaceHandlerFromAidl(r5.getDiskSpaceHandler())).fileUriProvider(convertFileProviderFromAidl(r5.getFileProvider())).notificationClickCallback(convertNotificationClickCallbackFromAidl(r5.getNotificationClickCallback()));     // Catch: RemoteException -> L16
        IDownloadAidlListener r2 = r5.getSingleDownloadListener(ListenerType.MAIN.ordinal());     // Catch: RemoteException -> L16
        if (r2 == null) goto L8;
        r1.mainThreadListenerWithHashCode(r2.hashCode(), convertListenerFromAidl(r2));     // Catch: RemoteException -> L16
    L8:
        IDownloadAidlListener r3 = r5.getSingleDownloadListener(ListenerType.SUB.ordinal());     // Catch: RemoteException -> L16
        if (r3 == null) goto L11;
        r1.subThreadListenerWithHashCode(r3.hashCode(), convertListenerFromAidl(r3));     // Catch: RemoteException -> L16
    L11:
        IDownloadAidlListener r6 = r5.getSingleDownloadListener(ListenerType.NOTIFICATION.ordinal());     // Catch: RemoteException -> L16
        if (r6 == null) goto L14;
        r1.notificationListenerWithHashCode(r6.hashCode(), convertListenerFromAidl(r6));     // Catch: RemoteException -> L16
    L14:
        setDownloadListeners(r1, r5, ListenerType.MAIN);     // Catch: RemoteException -> L16
        setDownloadListeners(r1, r5, ListenerType.SUB);     // Catch: RemoteException -> L16
        setDownloadListeners(r1, r5, ListenerType.NOTIFICATION);     // Catch: RemoteException -> L16
        setCompletedHandlers(r1, r5);     // Catch: RemoteException -> L16
        return r1;
    L16:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private static void setDownloadListeners(DownloadTask r5, DownloadAidlTask r6, ListenerType r7) {
        DownloadAidlTask r8 = (DownloadAidlTask) ZeusTransformUtils.wrapperContextForParams(r6, DownloadAidlTask.class, "com.obric.aiagent.plugin");
        ConcurrentHashMap r0 = new ConcurrentHashMap();
        int[] r1 = r8.getDownloadListenerHashCodeLists(r7.ordinal());
        if (r1 != null) goto L5;
    L13:
        r5.setDownloadListeners(r0, r7);
        return;
    L5:
        if (r1.length <= 0) goto L13;
        int r2 = 0;
    L8:
        if (r2 >= r1.length) goto L13;
        IDownloadAidlListener r3 = r8.getDownloadListenerByHashCode(r7.ordinal(), r1[r2]);
        if (r3 == null) goto L12;
        r0.put(Integer.valueOf(r3.getOriginHashCode()), convertListenerFromAidl(r3));
    L12:
        r2 = r2 + 1;
        goto L8
    }

    private static void setCompletedHandlers(DownloadTask r2, DownloadAidlTask r3) {
        DownloadAidlTask r4 = (DownloadAidlTask) ZeusTransformUtils.wrapperContextForParams(r3, DownloadAidlTask.class, "com.obric.aiagent.plugin");
        int r0 = 0;
    L4:
        if (r0 >= r4.getDownloadCompleteHandlerSize()) goto L9;
        IDownloadCompleteAidlHandler r1 = r4.getDownloadCompleteAidlHandlerByIndex(r0);
        if (r1 == null) goto L8;
        r2.addDownloadCompleteHandler(convertDownloadCompleteHandlerFromAidl(r1));
    L8:
        r0 = r0 + 1;
        goto L4
    }

    public static IDownloadNotificationEventListener convertDownloadNotificationEventListenerFromAidl(IDownloadNotificationEventAidlListener r2) {
        final IDownloadNotificationEventAidlListener r3 = (IDownloadNotificationEventAidlListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadNotificationEventAidlListener.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass13(r3);
    }

    public static IDownloadCompleteHandler convertDownloadCompleteHandlerFromAidl(IDownloadCompleteAidlHandler r2) {
        final IDownloadCompleteAidlHandler r3 = (IDownloadCompleteAidlHandler) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadCompleteAidlHandler.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass14(r3);
    }

    public static IDownloadCompleteAidlHandler convertDownloadCompleteHandlerToAidl(IDownloadCompleteHandler r2) {
        final IDownloadCompleteHandler r3 = (IDownloadCompleteHandler) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadCompleteHandler.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass15(r3);
    }

    public static INotificationClickCallback convertNotificationClickCallbackFromAidl(INotificationClickAidlCallback r2) {
        final INotificationClickAidlCallback r3 = (INotificationClickAidlCallback) ZeusTransformUtils.wrapperContextForParams(r2, INotificationClickAidlCallback.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass16(r3);
    }

    public static IDownloadDepend convertDownloadDependFromAidl(IDownloadAidlDepend r2) {
        final IDownloadAidlDepend r3 = (IDownloadAidlDepend) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadAidlDepend.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass17(r3);
    }

    public static IDownloadMonitorDepend convertDownloadMonitorDependFromAidl(IDownloadAidlMonitorDepend r2) {
        final IDownloadAidlMonitorDepend r3 = (IDownloadAidlMonitorDepend) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadAidlMonitorDepend.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass18(r3);
    }

    public static IDownloadForbiddenHandler convertForbiddenHandlerFromAidl(IDownloadForbiddenAidlHandler r2) {
        final IDownloadForbiddenAidlHandler r3 = (IDownloadForbiddenAidlHandler) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadForbiddenAidlHandler.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass19(r3);
    }

    public static IDownloadForbiddenAidlCallback convertForbiddenCallbackToAidl(IDownloadForbiddenCallback r2) {
        final IDownloadForbiddenCallback r3 = (IDownloadForbiddenCallback) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadForbiddenCallback.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass20(r3);
    }

    public static ProcessAidlCallback convertProcessCallbackToAidl(ProcessCallback r2) {
        final ProcessCallback r3 = (ProcessCallback) ZeusTransformUtils.wrapperContextForParams(r2, ProcessCallback.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass21(r3);
    }

    public static ProcessCallback convertProcessAidlCallbackFromAidl(ProcessAidlCallback r2) {
        final ProcessAidlCallback r3 = (ProcessAidlCallback) ZeusTransformUtils.wrapperContextForParams(r2, ProcessAidlCallback.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass22(r3);
    }

    public static IDownloadDiskSpaceHandler convertDiskSpaceHandlerFromAidl(IDownloadDiskSpaceAidlHandler r2) {
        final IDownloadDiskSpaceAidlHandler r3 = (IDownloadDiskSpaceAidlHandler) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadDiskSpaceAidlHandler.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass23(r3);
    }

    public static IDownloadDiskSpaceAidlCallback convertDiskSpaceCallbackToAidl(IDownloadDiskSpaceCallback r2) {
        final IDownloadDiskSpaceCallback r3 = (IDownloadDiskSpaceCallback) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadDiskSpaceCallback.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass24(r3);
    }

    public static IDownloadInterceptor convertInterceptorFromAidl(IDownloadAidlInterceptor r2) {
        final IDownloadAidlInterceptor r3 = (IDownloadAidlInterceptor) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadAidlInterceptor.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass25(r3);
    }

    public static IDownloadFileUriProvider convertFileProviderFromAidl(IDownloadAidlFileProvider r2) {
        final IDownloadAidlFileProvider r3 = (IDownloadAidlFileProvider) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadAidlFileProvider.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass26(r3);
    }

    public static IDownloadListener convertListenerFromAidl(IDownloadAidlListener r2) {
        final IDownloadAidlListener r3 = (IDownloadAidlListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadAidlListener.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass27(r3);
    }
}
