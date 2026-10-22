package com.android.ttcjpaysdk.base.framework.manager;

import android.content.Context;
import android.os.Build;
import android.util.SparseArray;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\u0013\u001a\u00020\rR\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/manager/CJScreenshotRiskManager;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "()V", "activityWR", "Ljava/lang/ref/WeakReference;", "Landroidx/appcompat/app/AppCompatActivity;", "cjScreenCaptureManager", "Lcom/android/ttcjpaysdk/base/framework/manager/CJScreenCaptureManager;", "mScreenShotListener", "Lcom/android/ttcjpaysdk/base/framework/manager/ScreenShotManager$ScreenShotListener;", "page", "", LiveCommonConstants.REASON_ON_DEDTROY, "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "startScreenShot", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "stopScreenShot", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJScreenshotRiskManager implements DefaultLifecycleObserver {
    public static final Companion Companion = null;
    public static final String TAG = "CJScreenshotRiskManager";
    private static final SparseArray<CJScreenshotRiskManager> managerList = null;
    private static CJPayScreenshotMessage screenshotMessage;
    private WeakReference<AppCompatActivity> activityWR;
    private CJScreenCaptureManager cjScreenCaptureManager;
    private final ScreenShotManager.ScreenShotListener mScreenShotListener;
    private int page;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J \u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/manager/CJScreenshotRiskManager$Companion;", "", "()V", "TAG", "", "managerList", "Landroid/util/SparseArray;", "Lcom/android/ttcjpaysdk/base/framework/manager/CJScreenshotRiskManager;", "screenshotMessage", "Lcom/android/ttcjpaysdk/base/framework/manager/CJPayScreenshotMessage;", "getLatestScreenshotMessage", "saveScreenshotMessage", "", "page", "", "startScreenShot", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "hashcode", "stopScreenShot", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final String getLatestScreenshotMessage() {
            String r100 = CJScreenshotRiskManager.access$getScreenshotMessage$cp().getMessage();
            CJLogger.d(CJScreenshotRiskManager.TAG, "getMessage--message: " + r100);
            return r100;
        }

        private final synchronized void saveScreenshotMessage(int r100) {
            monitor-enter(this);
            CJScreenshotRiskManager.access$getScreenshotMessage$cp().save(r100);     // Catch: Throwable -> L7
            CJLogger.d(CJScreenshotRiskManager.TAG, "saveScreenshotMessage--page: " + r100);     // Catch: Throwable -> L7
            monitor-exit(this);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public final void stopScreenShot(int r100) {
            CJScreenshotRiskManager r101 = (CJScreenshotRiskManager) CJScreenshotRiskManager.access$getManagerList$cp().get(r100);
            if (r101 == null) goto L5;
            r101.stopScreenShot();
        L5:
            CJScreenshotRiskManager.access$getManagerList$cp().remove(r100);
        }

        public static final /* synthetic */ void access$saveScreenshotMessage(Companion r100, int r101) {
            r100.saveScreenshotMessage(r101);
        }

        public final void startScreenShot(Context r100, int r101, int r102) {
            CJScreenshotRiskManager r103 = new CJScreenshotRiskManager();
            r103.startScreenShot(r100, r102);
            CJScreenshotRiskManager.access$getManagerList$cp().put(r101, r103);
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onCreate(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onCreate(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onPause(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onPause(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onResume(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onResume(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onStart(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onStart(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onStop(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onStop(this, r100);
    }

    static {
        Companion = new Companion(null);
        managerList = new SparseArray();
        screenshotMessage = new CJPayScreenshotMessage();
    }

    public final void stopScreenShot() {
        WeakReference<AppCompatActivity> r100 = this.activityWR;
        if (r100 == null) goto L12;
        AppCompatActivity r101 = r100.get();
        if (r101 == null) goto L12;
        if (Build.VERSION.SDK_INT < 34) goto L11;
        CJScreenCaptureManager r102 = this.cjScreenCaptureManager;
        if (r102 == null) goto L12;
        r102.unregisterListener(r101);
        goto L12
    L11:
        ScreenShotManager.unregisterScreenShotObserver(r101, this.mScreenShotListener);
    L12:
        CJLogger.d(TAG, "stopScreenShot--page: " + this.page);
    }

    public CJScreenshotRiskManager() {
        this.mScreenShotListener = new CJScreenshotRiskManager$mScreenShotListener$1(this);
        this.page = -1;
    }

    public static final /* synthetic */ SparseArray access$getManagerList$cp() {
        return managerList;
    }

    public static final /* synthetic */ CJPayScreenshotMessage access$getScreenshotMessage$cp() {
        return screenshotMessage;
    }

    public static final /* synthetic */ int access$getPage$p(CJScreenshotRiskManager r100) {
        return r100.page;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        stopScreenShot();
        WeakReference<AppCompatActivity> r101 = this.activityWR;
        if (r101 == null) goto L9;
        AppCompatActivity r102 = r101.get();
        if (r102 == null) goto L9;
        Lifecycle r103 = r102.getLifecycle();
        if (r103 == null) goto L9;
        r103.removeObserver(this);
    L9:
        CJLogger.d(TAG, "onDestroy--page: " + this.page);
    }

    public final void startScreenShot(Context r100, final int r101) {
        if ((r100 instanceof AppCompatActivity) == false) goto L5;
        AppCompatActivity r102 = (AppCompatActivity) r100;
    L6:
        if (r102 != null) goto L8;
        return;
    L8:
        this.activityWR = new WeakReference(r102);
        this.page = r101;
        r102.getLifecycle().addObserver(this);
        if (Build.VERSION.SDK_INT >= 34) goto L11;
        ScreenShotManager.registerScreenShotObserver(r102, this.mScreenShotListener);
    L17:
        CJLogger.d(TAG, "startScreenShot--page: " + r101);
        return;
    L11:
        if (this.cjScreenCaptureManager != null) goto L13;
        this.cjScreenCaptureManager = new CJScreenCaptureManager(new AnonymousClass1(r101));
    L13:
        CJScreenCaptureManager r103 = this.cjScreenCaptureManager;
        if (r103 == null) goto L17;
        r103.registerListener(r102);
        goto L17
    L5:
        r102 = null;
        goto L6
    }
}
