package com.android.server.wm;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.HardwareBuffer;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Slog;
import android.view.SurfaceControl;
import android.window.ScreenCapture;
import com.android.server.am.IZswContentProviderHelper;
import com.zte.zscreenshot.aidl.IZScreenshotCallback;
import com.zte.zscreenshot.aidl.IZScreenshotController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ZScreenshotController extends IZScreenshotController.Stub {
    private static volatile ZScreenshotController CONTROLLER = null;
    private static final String TAG = "ZScreenshotController";
    private static final int TICK_TIME = 100;
    private final HashMap<IBinder, AppDataItem> mAppDataMap;
    private Context mContext;
    private final Handler mHandler;
    private boolean mIsInit;
    private Runnable mScreenshotLayerRunnable;
    private ActivityTaskManagerService mService;

    /* JADX INFO: renamed from: com.android.server.wm.ZScreenshotController$3, reason: invalid class name */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ ZScreenshotController this$0;

        public static /* synthetic */ int $r8$lambda$FpQwhS__ZgQ8N8sRlRM65qaHDZQ(Map.Entry r0, Map.Entry r1) {
            return lambda$run$0(r0, r1);
        }

        AnonymousClass3(ZScreenshotController this$0) {
            this.this$0 = this$0;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<Map.Entry<IBinder, AppDataItem>> entryList = new ArrayList(ZScreenshotController.m10488$$Nest$fgetmAppDataMap(this.this$0).entrySet());
            entryList.sort(new ZScreenshotController$3$$ExternalSyntheticLambda0());
            long time = System.currentTimeMillis();
            HardwareBuffer lastBuffer = null;
            Iterator<Map.Entry<IBinder, AppDataItem>> r4 = entryList.iterator();
        L4:
            if (r4.hasNext() == false) goto L17;
            Map.Entry<IBinder, AppDataItem> entry = r4.next();
            AppDataItem item = entry.getValue();
            if (item.mShare == true) goto L11;
            if (((time - item.mLastCallbackTime) + 20) <= item.mInterval) goto L11;
            item.mLastCallbackTime = time;
            lastBuffer = ZScreenshotController.m10492$$Nest$mstartScreenshot(this.this$0, item, null);
        L11:
            if (item.mShare == false) goto L4;
            if (lastBuffer == null) goto L4;
            if (((time - item.mLastCallbackTime) + 20) <= item.mInterval) goto L4;
            item.mLastCallbackTime = time;
            lastBuffer = ZScreenshotController.m10492$$Nest$mstartScreenshot(this.this$0, item, lastBuffer);
            goto L4
        L17:
            ZScreenshotController.m10489$$Nest$fgetmHandler(this.this$0).removeCallbacks(ZScreenshotController.m10490$$Nest$fgetmScreenshotLayerRunnable(this.this$0));
            ZScreenshotController.m10489$$Nest$fgetmHandler(this.this$0).postDelayed(ZScreenshotController.m10490$$Nest$fgetmScreenshotLayerRunnable(this.this$0), 100);
        }

        private static /* synthetic */ int lambda$run$0(Map.Entry e1, Map.Entry e2) {
            return ((AppDataItem) e1.getValue()).compareTo2((AppDataItem) e2.getValue());
        }
    }

    private static class AppDataItem implements Comparable<AppDataItem> {
        public IZScreenshotCallback mCallback;
        public BinderDeath mDeath;
        public long mInterval;
        public long mLastCallbackTime;
        public String mName;
        public boolean mNeedClose;
        public Rect mRect;
        public float mScale;
        public boolean mShare;
        public boolean mShotAll;

        /* synthetic */ AppDataItem(ZScreenshotControllerIA r1) {
            this();
        }

        private AppDataItem() {
            this.mName = "";
            this.mInterval = 1000;
            this.mRect = new Rect(0, 0, 100, 100);
            this.mScale = 1.0f;
            this.mLastCallbackTime = 0;
            this.mShotAll = false;
            this.mNeedClose = true;
            this.mShare = false;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(AppDataItem r1) {
            return compareTo2(r1);
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(AppDataItem another) {
            if (this.mInterval <= another.mInterval) goto L6;
            return 1;
        L6:
            return -1;
        }

        public String toString() {
            return "AppDataItem{mName=" + this.mName + ", mInterval=" + this.mInterval + ", mRect=" + this.mRect + ", mScale=" + this.mScale + ", mShotAll=" + this.mShotAll + ", mNeedClose=" + this.mNeedClose + ", mShare=" + this.mShare + '}';
        }
    }

    private class BinderDeath implements IBinder.DeathRecipient {
        private AppDataItem mItem;
        private String mName;
        private IBinder mToken;
        final /* synthetic */ ZScreenshotController this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmItem, reason: not valid java name */
        static /* bridge */ /* synthetic */ AppDataItem m10494$$Nest$fgetmItem(BinderDeath r0) {
            return r0.mItem;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmName, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m10495$$Nest$fgetmName(BinderDeath r0) {
            return r0.mName;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmToken, reason: not valid java name */
        static /* bridge */ /* synthetic */ IBinder m10496$$Nest$fgetmToken(BinderDeath r0) {
            return r0.mToken;
        }

        public BinderDeath(ZScreenshotController r1, String name, AppDataItem item, IBinder token) {
            this.this$0 = r1;
            this.mName = name;
            this.mItem = item;
            this.mToken = token;
            token.linkToDeath(this, 0);     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            ZScreenshotController.m10489$$Nest$fgetmHandler(this.this$0).post(new AnonymousClass1(this));
        }

        public String toString() {
            return "BinderDeath{mPackageName=" + this.mName + ", mToken=" + this.mToken + '}';
        }
    }

    public static /* synthetic */ int $r8$lambda$EhKTOlQnskfugViK8fRK3zgtuJE(Map.Entry r0, Map.Entry r1) {
        return lambda$traversalList$1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$MzCGM0g6wUAHa57d26GcJvZMgiU(ZScreenshotController r0, ActivityTaskManagerService r1) {
        r0.lambda$onSystemReady$0(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$hxOe84GDha_Xu4TmFNpcX-a_PG0, reason: not valid java name */
    public static /* synthetic */ int m10487$r8$lambda$hxOe84GDha_Xu4TmFNpcXa_PG0(AppDataItem r0, AppDataItem r1) {
        return lambda$traversalList$2(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAppDataMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ HashMap m10488$$Nest$fgetmAppDataMap(ZScreenshotController r0) {
        return r0.mAppDataMap;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m10489$$Nest$fgetmHandler(ZScreenshotController r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmScreenshotLayerRunnable, reason: not valid java name */
    static /* bridge */ /* synthetic */ Runnable m10490$$Nest$fgetmScreenshotLayerRunnable(ZScreenshotController r0) {
        return r0.mScreenshotLayerRunnable;
    }

    /* JADX INFO: renamed from: -$$Nest$mpostStart, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10491$$Nest$mpostStart(ZScreenshotController r0, Bundle r1, IZScreenshotCallback r2) {
        r0.postStart(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mstartScreenshot, reason: not valid java name */
    static /* bridge */ /* synthetic */ HardwareBuffer m10492$$Nest$mstartScreenshot(ZScreenshotController r0, AppDataItem r1, HardwareBuffer r2) {
        return r0.startScreenshot(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mtraversalList, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10493$$Nest$mtraversalList(ZScreenshotController r0) {
        r0.traversalList();
    }

    private ZScreenshotController() {
        this.mAppDataMap = new HashMap();
        this.mScreenshotLayerRunnable = new AnonymousClass3(this);
        HandlerThread handlerThread = new HandlerThread(TAG);
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
    }

    public static ZScreenshotController getInstance() {
        monitor-enter(ZScreenshotController.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (CONTROLLER != null) goto L9;
        CONTROLLER = new ZScreenshotController();     // Catch: Throwable -> L7
    L9:
        monitor-exit(ZScreenshotController.class);     // Catch: Throwable -> L7
        return CONTROLLER;
    }

    public ZScreenshotController onSystemReady(Context context, final ActivityTaskManagerService activityTaskManager) {
        if (this.mContext == null) goto L5;
    L7:
        return this;
    L5:
        if (this.mIsInit == true) goto L7;
        this.mContext = context;
        this.mHandler.post(new ZScreenshotController$$ExternalSyntheticLambda0(this, activityTaskManager));
        goto L7
    }

    private /* synthetic */ void lambda$onSystemReady$0(ActivityTaskManagerService activityTaskManager) {
        this.mIsInit = true;
        this.mService = activityTaskManager;
        onInit();
    }

    private void onInit() {
        Slog.i(TAG, "onInit");
    }

    public void invoke(String name, Bundle data, IZScreenshotCallback callback) {
    }

    public void ZScreenshot(Bundle bundle, IZScreenshotCallback callback) {
        if (this.mIsInit == true) goto L5;
        return;
    }

    public void stop(final IZScreenshotCallback callback) {
        this.mHandler.post(new AnonymousClass1(this, callback));
    }

    public void start(final Bundle bundle, final IZScreenshotCallback callback) {
        if (this.mIsInit == true) goto L5;
        return;
    L5:
        this.mHandler.post(new AnonymousClass2(this, bundle, callback));
    }

    private void postStart(Bundle bundle, IZScreenshotCallback callback) {
    L10:
        e = move-exception;
        e.printStackTrace();
        Slog.e(TAG, "start e=" + e);
        return;
    L4:
        if (this.mAppDataMap.containsKey(callback.asBinder()) == true) goto L33;
        AppDataItem item = new AppDataItem(null);     // Catch: Exception -> L10
        if (bundle != null) goto L8;
    L12:
        if (bundle != null) goto L14;
    L16:
        if (bundle != null) goto L18;
    L20:
        if (bundle != null) goto L22;
    L24:
        if (bundle != null) goto L26;
    L28:
        item.mCallback = callback;     // Catch: Exception -> L10
        BinderDeath death = new BinderDeath(this, item.mName, item, callback.asBinder());     // Catch: Exception -> L10
        item.mDeath = death;     // Catch: Exception -> L10
        if (item.mInterval != 0) goto L31;
        item.mLastCallbackTime = System.currentTimeMillis();     // Catch: Exception -> L10
        startScreenshot(item, null);     // Catch: Exception -> L10
    L32:
        Slog.i(TAG, "start data=" + item + " callback=" + callback);     // Catch: Exception -> L10
        goto L33
    L31:
        this.mAppDataMap.put(callback.asBinder(), item);     // Catch: Exception -> L10
        goto L32
    L26:
        if (bundle.containsKey(IZswContentProviderHelper.DUMP_ALL) == false) goto L28;
        item.mShotAll = bundle.getBoolean(IZswContentProviderHelper.DUMP_ALL);     // Catch: Exception -> L10
        goto L28
    L22:
        if (bundle.containsKey("scale") == false) goto L24;
        item.mScale = bundle.getFloat("scale");     // Catch: Exception -> L10
        goto L24
    L18:
        if (bundle.containsKey("rect") == false) goto L20;
        item.mRect = (Rect) bundle.getParcelable("rect", Rect.class);     // Catch: Exception -> L10
        goto L20
    L14:
        if (bundle.containsKey("interval") == false) goto L16;
        item.mInterval = bundle.getLong("interval");     // Catch: Exception -> L10
        goto L16
    L8:
        if (bundle.containsKey("name") == false) goto L12;
        item.mName = bundle.getString("name");     // Catch: Exception -> L10
    L33:
        traversalList();     // Catch: Exception -> L10
        if (this.mAppDataMap.size() <= 0) goto L42;
        this.mHandler.removeCallbacks(this.mScreenshotLayerRunnable);     // Catch: Exception -> L10
        this.mHandler.postDelayed(this.mScreenshotLayerRunnable, 100);     // Catch: Exception -> L10
        return;
    }

    private void traversalList() {
        List<Map.Entry<IBinder, AppDataItem>> entryList = new ArrayList(this.mAppDataMap.entrySet());
        entryList.sort(new ZScreenshotController$$ExternalSyntheticLambda1());
        List<AppDataItem> shareList = new ArrayList();
        long min = -1;
        AppDataItem minItem = new AppDataItem(null);
        Iterator<Map.Entry<IBinder, AppDataItem>> r5 = entryList.iterator();
    L4:
        if (r5.hasNext() == false) goto L16;
        Map.Entry<IBinder, AppDataItem> entry = r5.next();
        AppDataItem item = entry.getValue();
        item.mShare = false;
        if (min < 0) goto L7;
        if ((item.mInterval % min) != 0) goto L4;
        if (item.mRect.equals(minItem.mRect) == false) goto L4;
        if (Math.abs(item.mScale - minItem.mScale) >= 0.001f) goto L4;
        item.mShare = true;
        shareList.add(item);
        goto L4
    L7:
        min = item.mInterval;
        minItem = item;
        shareList.add(item);
        goto L4
    L16:
        shareList.sort(new ZScreenshotController$$ExternalSyntheticLambda2());
        boolean first = true;
        Iterator<AppDataItem> r6 = shareList.iterator();
    L18:
        if (r6.hasNext() == false) goto L24;
        AppDataItem item2 = r6.next();
        if (first == true) goto L21;
        item2.mNeedClose = false;
        goto L18
    L21:
        first = false;
        item2.mNeedClose = true;
        goto L18
    L24:
        Iterator<Map.Entry<IBinder, AppDataItem>> r7 = entryList.iterator();
    L26:
        if (r7.hasNext() == false) goto L28;
        Map.Entry<IBinder, AppDataItem> entry2 = r7.next();
        Slog.w(TAG, "traversalList item=" + entry2.getValue());
        goto L26
    }

    private static /* synthetic */ int lambda$traversalList$1(Map.Entry e1, Map.Entry e2) {
        return ((AppDataItem) e1.getValue()).compareTo2((AppDataItem) e2.getValue());
    }

    private static /* synthetic */ int lambda$traversalList$2(AppDataItem e1, AppDataItem e2) {
        return e2.compareTo2(e1);
    }

    private HardwareBuffer startScreenshot(AppDataItem data, HardwareBuffer lastBuffer) {
        if (data != null) goto L5;
    L17:
        Slog.w(TAG, "startScreenshot null data");
        return null;
    L5:
        if (data.mCallback == null) goto L17;
        long time = System.currentTimeMillis();
        if (lastBuffer != null) goto L10;
        HardwareBuffer buffer = screenshot(data);
    L11:
        Slog.i(TAG, "startScreenshot data=" + data + " spent=" + (System.currentTimeMillis() - time) + " lastBuffer=" + lastBuffer);
        Bundle outBundle = new Bundle();
        outBundle.putParcelable("buffer", buffer);
        outBundle.putBoolean("needclose", data.mNeedClose);
        data.mCallback.callback(outBundle);     // Catch: RemoteException -> L14
    L16:
        return buffer;
    L14:
        e = move-exception;
        e.printStackTrace();
        Slog.e(TAG, "startScreenshot e=" + e);
        goto L16
    L10:
        buffer = lastBuffer;
        goto L11
    }

    private HardwareBuffer screenshot(AppDataItem data) {
        ActivityRecord topResumedActivity = this.mService.mRootWindowContainer.getTopResumedActivity();
        if (topResumedActivity != null) goto L7;
        Slog.e(TAG, "screenshot topResumedActivity == null");
        return null;
    L7:
        if (topResumedActivity.inMultiWindowMode() == false) goto L9;
    L11:
        boolean isFull = false;
    L13:
        if (isFull == true) goto L15;
    L29:
        ScreenCapture.LayerCaptureArgs captureArgs = new ScreenCapture.LayerCaptureArgs.Builder(topResumedActivity.getDisplayContent().getSurfaceControl()).setCaptureSecureLayers(true).setAllowProtected(true).setSourceCrop(data.mRect).setFrameScale(data.mScale).setHintForSeamlessTransition(true).build();
        Slog.i(TAG, "screenshot display content");
        ScreenCapture.ScreenshotHardwareBuffer screenshotBuffer = ScreenCapture.captureLayers(captureArgs);
        if (screenshotBuffer != null) goto L32;
        HardwareBuffer buffer = null;
    L34:
        if (isInvalidHardwareBuffer(buffer) == false) goto L37;
        Slog.e(TAG, "screenshot isInvalidHardwareBuffer " + screenshotBuffer);
        return null;
    L37:
        return buffer;
    L32:
        buffer = screenshotBuffer.getHardwareBuffer();
        goto L34
    L15:
        if (data.mShotAll == true) goto L29;
        SurfaceControl topSurface = topResumedActivity.mSurfaceControl;
        if (topSurface != null) goto L20;
        Slog.e(TAG, "screenshot topSurface == null");
        return null;
    L20:
        ScreenCapture.ScreenshotHardwareBuffer screenshotBuffer2 = ScreenCapture.captureLayersExcluding(topSurface, data.mRect, data.mScale, 1, new SurfaceControl[0]);
        Slog.i(TAG, "screenshot layer");
        if (screenshotBuffer2 != null) goto L23;
        HardwareBuffer buffer2 = null;
    L25:
        if (isInvalidHardwareBuffer(buffer2) == false) goto L28;
        Slog.e(TAG, "screenshot isInvalidHardwareBuffer " + screenshotBuffer2);
        return null;
    L28:
        return buffer2;
    L23:
        buffer2 = screenshotBuffer2.getHardwareBuffer();
        goto L25
    L9:
        if (topResumedActivity.occludesParent() == false) goto L11;
        isFull = true;
        goto L13
    }

    private boolean isInvalidHardwareBuffer(HardwareBuffer buffer) {
        if (buffer != null) goto L5;
        return true;
    L5:
        if (buffer.isClosed() == false) goto L7;
        return true;
    L7:
        if (buffer.getWidth() > 1) goto L9;
        return true;
    L9:
        if (buffer.getHeight() <= 1) goto L17;
        return false;
    L17:
        return true;
    }
}
