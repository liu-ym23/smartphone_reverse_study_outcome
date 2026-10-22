package com.bytedance.applog.collector;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.applog.c;
import com.bytedance.applog.log.f;
import com.bytedance.applog.store.h;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Navigator implements Application.ActivityLifecycleCallbacks {
    public static final int DELAY_MULTY_PROC = 500;
    private static final String RESUME_EVENT_NAME = "applog_activity_resume";
    private final c appLogInstance;
    private volatile a callback;
    private boolean hasAnyActivityResumed;
    private boolean isCodeLaunch;
    private volatile boolean mTrackResumeEvent;
    private int sActiveCount;
    private h sCurActPage;
    private String sLastActivity;
    private long sLastActivityPauseTs;
    private final HashSet<Integer> sNewActivity;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r1, Bundle r2) {
        Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.aiagent.plugin");
    }

    public void setTrackResumeEvent(boolean r1) {
        this.mTrackResumeEvent = r1;
    }

    public Navigator(c r4) {
        this.sActiveCount = 0;
        this.sNewActivity = new HashSet(8);
        this.isCodeLaunch = true;
        this.hasAnyActivityResumed = false;
        this.mTrackResumeEvent = false;
        this.appLogInstance = r4;
    }

    public h getCurPage() {
        return this.sCurActPage;
    }

    public void setCallback(a r3) {
        this.callback = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
    }

    public String getPageName() {
        h r0 = getCurPage();
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0.w;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        onActivityResumed(r4.getClass().getName(), r4.hashCode());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResumed(String r11, int r12) {
        long r6 = System.currentTimeMillis();
        this.appLogInstance.Z().d("onActivityResumed: {}", new Object[]{r11});
        if (this.sCurActPage == null) goto L5;
    L7:
        Object[] r9 = false;
    L8:
        h r13 = resumePage(r11, "", r6, this.sLastActivity);
        this.sCurActPage = r13;
        r13.x = !this.sNewActivity.remove(Integer.valueOf(r12)) ? 1 : 0;
        if (this.mTrackResumeEvent == true) goto L11;
    L24:
        this.hasAnyActivityResumed = true;
        return;
    L11:
        if (this.hasAnyActivityResumed == true) goto L14;
        this.appLogInstance.a(RESUME_EVENT_NAME, "{\"v\":1}");
        goto L24
    L14:
        if (r9 == false) goto L20;
        long r2 = this.sLastActivityPauseTs;
        if (r2 >= (r6 - WsConstants.EXIT_DELAY_TIME)) goto L20;
        if (r2 <= (r6 - OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS)) goto L20;
        this.appLogInstance.a(RESUME_EVENT_NAME, "{\"v\":2}");
    L20:
        if (r9 == false) goto L24;
        if (this.sLastActivityPauseTs >= (r6 - OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS)) goto L24;
        this.appLogInstance.a(RESUME_EVENT_NAME, "{\"v\":3}");
        goto L24
    L5:
        if (this.sLastActivityPauseTs <= 0) goto L7;
        r9 = true;
        goto L8
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r6) {
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r6, Activity.class, "com.obric.aiagent.plugin");
        long r0 = System.currentTimeMillis();
        f r2 = this.appLogInstance.Z();
        Object[] r3 = new Object[1];
        if (r7 == null) goto L5;
        String r8 = r7.getClass().getName();
    L6:
        r3[0] = r8;
        r2.d("onActivityPaused:{}", r3);
        h r9 = this.sCurActPage;
        if (r9 == null) goto L10;
        this.sLastActivity = r9.w;
        this.sLastActivityPauseTs = r0;
        pausePage(r9, r0);
        this.sCurActPage = null;
        return;
    L10:
        return;
    L5:
        r8 = "";
        goto L6
    }

    public h resumePage(String r3, String r4, long r5, String r7) {
        h r0 = new h();
        if (TextUtils.isEmpty(r4) == true) goto L5;
        r0.w = r3 + ":" + r4;
    L6:
        r0.a(r5);
        r0.u = -1;
        if (r7 != null) goto L10;
        r7 = "";
    L10:
        r0.v = r7;
        a r6 = this.callback;
        if (r6 != null) goto L20;
    L18:
        this.appLogInstance.a(r0);
        return r0;
    L20:
        JSONObject r8 = new JSONObject();     // Catch: Throwable -> L16
        r6.a(r0.w, r8);     // Catch: Throwable -> L16
        if (r8.length() <= 0) goto L18;
        r0.z = r8.toString();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        this.appLogInstance.Z().a("Navigator callback onResume:{} failed", th, new Object[]{r0.w});
        goto L18
    L5:
        r0.w = r3;
        goto L6
    }

    public h pausePage(h r4, long r5) {
        h r0 = (h) ZeusTransformUtils.preCheckCast(r4.l(), h.class, "com.obric.aiagent.plugin");
        r0.a(r5);
        long r6 = r5 - r4.f5992b;
        if (r6 > 0) goto L5;
        r6 = 1000;
    L5:
        r0.u = r6;
        a r7 = this.callback;
        if (r7 != null) goto L15;
    L13:
        this.appLogInstance.a(r0);
        return r0;
    L15:
        JSONObject r8 = new JSONObject();     // Catch: Throwable -> L11
        r7.b(r0.w, r8);     // Catch: Throwable -> L11
        if (r8.length() <= 0) goto L13;
        r0.z = r8.toString();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        this.appLogInstance.Z().a("Navigator callback onPause:{} failed", th, new Object[]{r0.w});
        goto L13
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        this.sActiveCount++;
        this.isCodeLaunch = false;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        if (this.sLastActivity == null) goto L8;
        int r5 = this.sActiveCount - 1;
        this.sActiveCount = r5;
        if (r5 > 0) goto L9;
        this.sLastActivity = null;
        this.sLastActivityPauseTs = 0;
        return;
    L9:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        this.sNewActivity.remove(Integer.valueOf(r4.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r2, Bundle r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        this.sNewActivity.add(Integer.valueOf(r4.hashCode()));
    }
}
