package com.bytedance.apm.trace;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.trace.mapping.ApmPageLoadMappingTool;
import com.bytedance.services.apm.api.IActivityLifeObserver;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class PageTimeMonitor implements IActivityLifeObserver {
    private long mActivityOnCreateStartTime;
    private String mCurrentActivityName;
    private Handler mMainHandler;
    private long mMaxWaitTime;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private boolean mSwitchOn;
    private Runnable mWaitViewTimeoutRunnable;

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityResume(Activity r1) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityStarted(Activity r1) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onBackground(Activity r1) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onChange(Activity r1, Fragment r2) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onFront(Activity r1) {
    }

    public PageTimeMonitor() {
        this.mActivityOnCreateStartTime = -1;
        this.mMainHandler = new Handler(Looper.getMainLooper());
    }

    static /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener access$000(PageTimeMonitor r0) {
        return r0.mOnGlobalLayoutListener;
    }

    static /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener access$002(PageTimeMonitor r0, ViewTreeObserver.OnGlobalLayoutListener r1) {
        r0.mOnGlobalLayoutListener = r1;
        return r1;
    }

    static /* synthetic */ Runnable access$100(PageTimeMonitor r0) {
        return r0.mWaitViewTimeoutRunnable;
    }

    static /* synthetic */ Runnable access$102(PageTimeMonitor r0, Runnable r1) {
        r0.mWaitViewTimeoutRunnable = r1;
        return r1;
    }

    static /* synthetic */ Handler access$200(PageTimeMonitor r0) {
        return r0.mMainHandler;
    }

    static /* synthetic */ long access$300(PageTimeMonitor r2) {
        return r2.mActivityOnCreateStartTime;
    }

    static /* synthetic */ long access$302(PageTimeMonitor r0, long r1) {
        r0.mActivityOnCreateStartTime = r1;
        return r1;
    }

    static /* synthetic */ long access$400(PageTimeMonitor r2) {
        return r2.mMaxWaitTime;
    }

    static /* synthetic */ String access$500(PageTimeMonitor r0) {
        return r0.mCurrentActivityName;
    }

    public void init(long r1, boolean r3) {
        this.mMaxWaitTime = r1;
        this.mSwitchOn = r3;
        ActivityLifeObserver.getInstance().register(this);
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityCreated(Activity r1, Bundle r2) {
        if (this.mSwitchOn == true) goto L8;
        return;
    L8:
        handleAutoPageTraceTime(r1);     // Catch: Exception -> L7
        return;
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityPause(Activity r3) {
        this.mActivityOnCreateStartTime = 0;
        if (this.mOnGlobalLayoutListener == null) goto L6;
        r3.getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);     // Catch: Exception -> L10
        this.mOnGlobalLayoutListener = null;     // Catch: Exception -> L10
    L6:
        Runnable r4 = this.mWaitViewTimeoutRunnable;     // Catch: Exception -> L10
        if (r4 == null) goto L13;
        this.mMainHandler.removeCallbacks(r4);     // Catch: Exception -> L10
        this.mWaitViewTimeoutRunnable = null;     // Catch: Exception -> L10
        return;
    L13:
        return;
    }

    private void handleAutoPageTraceTime(Activity r4) {
        this.mActivityOnCreateStartTime = System.currentTimeMillis();
        String r0 = r4.getClass().getCanonicalName();
        this.mCurrentActivityName = r0;
        final Integer r1 = ApmPageLoadMappingTool.queryViewId(r0);
        if (r1 != null) goto L5;
        return;
    L5:
        final WeakReference r2 = new WeakReference(r4.getWindow().getDecorView());
        this.mOnGlobalLayoutListener = new AnonymousClass1(this, r2, r1);
        ((View) r2.get()).getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        Runnable r5 = new AnonymousClass2(this, r2);
        this.mWaitViewTimeoutRunnable = r5;
        this.mMainHandler.postDelayed(r5, this.mMaxWaitTime);
    }
}
