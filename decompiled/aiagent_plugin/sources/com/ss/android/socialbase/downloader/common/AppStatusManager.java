package com.ss.android.socialbase.downloader.common;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AppStatusManager {
    private static final int STATUS_BACKGROUND = 0;
    private static final int STATUS_FOREGROUND = 1;
    private static final int STATUS_UNKNOWN = -1;
    private volatile boolean isActivityOnPause;
    private volatile int mAppStatus;
    private final List<AppStatusChangeListener> mAppStatusChangeListeners;
    private Application mApplication;
    private final Application.ActivityLifecycleCallbacks mCallbacks;
    private WeakReference<Activity> mTopActivity;
    private int mTopActivityHashCode;

    public interface AppStatusChangeListener {
        void onAppBackground();

        void onAppForeground();
    }

    private static class Holder {
        private static final AppStatusManager INSTANCE = null;

        private Holder() {
        }

        static /* synthetic */ AppStatusManager access$000() {
            return INSTANCE;
        }

        static {
            INSTANCE = new AppStatusManager(null);
        }
    }

    public interface InnerAppStatusChangeCaller {
        boolean isAppInBackground();
    }

    @Deprecated
    public void setInnerAppStatusChangeCaller(InnerAppStatusChangeCaller r2) {
        InnerAppStatusChangeCaller r1 = (InnerAppStatusChangeCaller) ZeusTransformUtils.wrapperContextForParams(r2, InnerAppStatusChangeCaller.class, "com.obric.aiagent.plugin");
    }

    /* synthetic */ AppStatusManager(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ WeakReference access$202(AppStatusManager r0, WeakReference r1) {
        r0.mTopActivity = r1;
        return r1;
    }

    static /* synthetic */ int access$300(AppStatusManager r0) {
        return r0.mTopActivityHashCode;
    }

    static /* synthetic */ int access$302(AppStatusManager r0, int r1) {
        r0.mTopActivityHashCode = r1;
        return r1;
    }

    static /* synthetic */ boolean access$402(AppStatusManager r0, boolean r1) {
        r0.isActivityOnPause = r1;
        return r1;
    }

    static /* synthetic */ void access$500(AppStatusManager r0) {
        r0.dispatchAppForeground();
    }

    static /* synthetic */ void access$600(AppStatusManager r0) {
        r0.dispatchAppBackground();
    }

    public static AppStatusManager getInstance() {
        return Holder.access$000();
    }

    private AppStatusManager() {
        this.mAppStatusChangeListeners = new ArrayList();
        this.mAppStatus = -1;
        this.isActivityOnPause = false;
        this.mCallbacks = new AnonymousClass1(this);
    }

    public void init(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (this.mApplication == null) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, Application.class) == false) goto L18;
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.mApplication != null) goto L10;
        Application r5 = (Application) ZeusTransformUtils.preCheckCast(r4, Application.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        this.mApplication = r5;     // Catch: Throwable -> L12
        r5.registerActivityLifecycleCallbacks(this.mCallbacks);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    }

    public boolean isAppForeground() {
        if (getRealStatus() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isAppBackground() {
        if (getRealStatus() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private int getRealStatus() {
        int r0 = this.mAppStatus;
        if (r0 != (-1)) goto L6;
        boolean r1 = checkAppForeground();
        this.mAppStatus = r1 ? 1 : 0;
        return r1 ? 1 : 0;
    L6:
        return r0;
    }

    public boolean isAppFocus() {
        if (isAppForeground() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.isActivityOnPause == true) goto L7;
        return true;
    }

    public void registerAppSwitchListener(AppStatusChangeListener r3) {
        AppStatusChangeListener r4 = (AppStatusChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, AppStatusChangeListener.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        List<AppStatusChangeListener> r0 = this.mAppStatusChangeListeners;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.mAppStatusChangeListeners.contains(r4) == true) goto L10;
        this.mAppStatusChangeListeners.add(r4);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
    }

    public void unregisterAppSwitchListener(AppStatusChangeListener r3) {
        AppStatusChangeListener r4 = (AppStatusChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, AppStatusChangeListener.class, "com.obric.aiagent.plugin");
        List<AppStatusChangeListener> r0 = this.mAppStatusChangeListeners;
        monitor-enter(r0);
        this.mAppStatusChangeListeners.remove(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public Activity getTopActivity() {
        WeakReference<Activity> r2 = this.mTopActivity;
        if (r2 != null) goto L6;
        return null;
    L6:
        return (Activity) ZeusTransformUtils.preCheckCast(r2.get(), Activity.class, "com.obric.aiagent.plugin");
    }

    private Object[] collectAppSwitchListeners() {
        List<AppStatusChangeListener> r0 = this.mAppStatusChangeListeners;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mAppStatusChangeListeners.size() <= 0) goto L7;
        Object[] r2 = this.mAppStatusChangeListeners.toArray();     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L7:
        r2 = null;
        goto L8
    }

    private void dispatchAppForeground() {
        this.mAppStatus = 1;
        Object[] r5 = collectAppSwitchListeners();
        if (r5 == null) goto L7;
        int r0 = r5.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        ((AppStatusChangeListener) ZeusTransformUtils.preCheckCast(r5[r1], AppStatusChangeListener.class, "com.obric.aiagent.plugin")).onAppForeground();
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    private void dispatchAppBackground() {
        int r0 = 0;
        this.mAppStatus = 0;
        Object[] r5 = collectAppSwitchListeners();
        if (r5 == null) goto L7;
        int r1 = r5.length;
    L5:
        if (r0 >= r1) goto L9;
        ((AppStatusChangeListener) ZeusTransformUtils.preCheckCast(r5[r0], AppStatusChangeListener.class, "com.obric.aiagent.plugin")).onAppBackground();
        r0 = r0 + 1;
        goto L5
    L9:
        return;
    }

    private boolean checkAppForeground() {
        Application r6 = this.mApplication;     // Catch: Throwable -> L21
        if (r6 != null) goto L6;
        return false;
    L6:
        ActivityManager r2 = (ActivityManager) ZeusTransformUtils.preCheckCast(r6.getSystemService("activity"), ActivityManager.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        String r7 = r6.getPackageName();     // Catch: Throwable -> L21
        List<ActivityManager.RunningAppProcessInfo> r3 = r2.getRunningAppProcesses();     // Catch: Throwable -> L21
        if (r3 != null) goto L9;
    L20:
        return false;
    L9:
        if (r3.isEmpty() == true) goto L20;
        Iterator<ActivityManager.RunningAppProcessInfo> r4 = r3.iterator();     // Catch: Throwable -> L21
    L13:
        if (r4.hasNext() == false) goto L20;
        ActivityManager.RunningAppProcessInfo r5 = (ActivityManager.RunningAppProcessInfo) ZeusTransformUtils.preCheckCast(r4.next(), ActivityManager.RunningAppProcessInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        if (r5.importance != 100) goto L13;
        if (TextUtils.equals(r5.processName, r7) == false) goto L13;
        return true;
    L21:
        th = move-exception;
        th.printStackTrace();
        return false;
    }
}
