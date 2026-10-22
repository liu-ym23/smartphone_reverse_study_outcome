package com.smt.obric.appstore.ktx;

import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.session.MediaController;
import android.media.session.MediaSessionManager;
import android.os.PowerManager;
import android.service.notification.NotificationListenerService;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedanceos.common.ui.AppPermissionActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.d;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {
    public static final List a(Context r10, String r11) {
        q.g(r10, "<this>");
        q.g(r11, AppPermissionActivity.EXTRA_APP_PKG);
        List<MediaController> r12 = d(r10).getActiveSessions(new ComponentName(r10, NotificationListenerService.class));
        q.f(r12, "getActiveSessions(...)");
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L8;
        Object r15 = r14.next();
        if (q.b(((MediaController) r15).getPackageName(), r11) == false) goto L4;
        r13.add(r15);
        goto L4
    L8:
        return r13;
    }

    public static final Pair b(Context r10) {
        q.g(r10, "<this>");
        Intent r11 = r10.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean r12 = false;
        if (r11 == null) goto L5;
        int r13 = r11.getIntExtra("level", 0);
    L6:
        if (r11 == null) goto L11;
        if (r11.getIntExtra("status", 0) != 2) goto L11;
        r12 = true;
    L11:
        return d.a(Integer.valueOf(r13), Boolean.valueOf(r12));
    L5:
        r13 = 0;
        goto L6
    }

    public static final JobScheduler c(Context r10) {
        q.g(r10, "<this>");
        Object r11 = r10.getSystemService("jobscheduler");
        q.e(r11, "null cannot be cast to non-null type android.app.job.JobScheduler");
        return (JobScheduler) r11;
    }

    public static final MediaSessionManager d(Context r10) {
        q.g(r10, "<this>");
        Object r11 = r10.getSystemService("media_session");
        q.e(r11, "null cannot be cast to non-null type android.media.session.MediaSessionManager");
        return (MediaSessionManager) r11;
    }

    public static final PowerManager.WakeLock e(Context r10, String r11) {
        q.g(r10, "<this>");
        q.g(r11, "tag");
        Object r12 = r10.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
        q.e(r12, "null cannot be cast to non-null type android.os.PowerManager");
        PowerManager.WakeLock r13 = ((PowerManager) r12).newWakeLock(1, r11);
        q.f(r13, "newWakeLock(...)");
        return r13;
    }
}
