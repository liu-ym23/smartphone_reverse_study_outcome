package com.bytedance.platform.godzilla;

import android.app.Activity;
import android.app.Application;
import com.bytedance.platform.godzilla.common.ILog;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.common.UncaughtExceptionConsumer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import u5.b;

/* JADX INFO: loaded from: classes.dex */
public final enum GodzillaCore extends Enum<GodzillaCore> {
    private static final /* synthetic */ GodzillaCore[] $VALUES = null;
    private static final int ACTIVITY_STATE_DESTORY = 3;
    private static final int ACTIVITY_STATE_PAUSE = 1;
    private static final int ACTIVITY_STATE_RESUME = 0;
    private static final int ACTIVITY_STATE_STOP = 2;
    public static final GodzillaCore INSTANCE = null;
    private static final String TAG = "UncaughtExceptionPlugin";
    private static HashMap<Integer, WeakReference<Activity>> mActivityMaps;
    private b mConsumeExceptionHandler;
    private WeakReference<Activity> mLastDestoryActivity;
    private WeakReference<Activity> mLastPauseActivity;
    private WeakReference<Activity> mLastResumedActivity;
    private WeakReference<Activity> mLastStopActivity;

    static {
        GodzillaCore r10 = new GodzillaCore("INSTANCE", 0);
        INSTANCE = r10;
        $VALUES = new GodzillaCore[]{r10};
        mActivityMaps = new HashMap();
    }

    private GodzillaCore(String r10, int r11) {
        super(r10, r11);
        this.mLastResumedActivity = null;
        this.mLastPauseActivity = null;
        this.mLastStopActivity = null;
        this.mLastDestoryActivity = null;
        this.mConsumeExceptionHandler = null;
    }

    private void registerExceptionHandlerIfNeed() {
        if (this.mConsumeExceptionHandler != null) goto L5;
        b r10 = new b();
        this.mConsumeExceptionHandler = r10;
        r10.e();
    L5:
        Logger.d(TAG, "init mConsumeExceptionHandler:" + this.mConsumeExceptionHandler);
    }

    public static GodzillaCore valueOf(String r10) {
        return (GodzillaCore) Enum.valueOf(GodzillaCore.class, r10);
    }

    public static GodzillaCore[] values() {
        return (GodzillaCore[]) $VALUES.clone();
    }

    public void addUncaughtExceptionConsumer(UncaughtExceptionConsumer r10) {
        registerExceptionHandlerIfNeed();
        Logger.d(TAG, "add consumer:" + r10);
        this.mConsumeExceptionHandler.a(r10);
    }

    public void destroy() {
        b r10 = this.mConsumeExceptionHandler;
        if (r10 == null) goto L6;
        r10.f();
        return;
    }

    public void init(Application r10, ILog r11, Logger.Level r12) {
        if (r11 == null) goto L4;
        Logger.f(r11);
    L4:
        if (r12 == null) goto L7;
        Logger.g(r12);
        return;
    }

    public void removeUncaughtExceptionConsumer(UncaughtExceptionConsumer r10) {
        Logger.d(TAG, "remove consumer:" + r10);
        this.mConsumeExceptionHandler.g(r10);
    }
}
