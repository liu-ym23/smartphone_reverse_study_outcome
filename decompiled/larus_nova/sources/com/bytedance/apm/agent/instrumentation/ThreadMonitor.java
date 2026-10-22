package com.bytedance.apm.agent.instrumentation;

import android.content.Context;
import com.bytedance.apm.d;
import com.bytedance.apm.util.a;
import com.bytedance.apm.util.u;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public class ThreadMonitor {
    private static final String TAG = "ThreadMonitor";

    public ThreadMonitor() {
    }

    private static boolean isLocalChannel() {
        JSONObject r100 = d.f190519g;
        if (r100 != null) goto L5;
    L8:
        return false;
    L5:
        if (r100.optString("channel") == null) goto L8;
        return d.f190519g.optString("channel").contains("local");
    }

    private static boolean isDebuggable() {
        Context r100 = d.getContext();
        Boolean r101 = a.f190638b;
        if (r101 == null) goto L6;
        return r101.booleanValue();
    L6:
        if (r100 != null) goto L15;
    L7:
        return false;
    L15:
        if ((r100.getApplicationInfo().flags & 2) == 0) goto L11;
        boolean r102 = true;
    L12:
        Boolean r103 = Boolean.valueOf(r102);     // Catch: Exception -> L14
        a.f190638b = r103;     // Catch: Exception -> L14
        return r103.booleanValue();
    L11:
        r102 = false;
        goto L12
    }

    public static void sleepMonitor(long r100) throws InterruptedException {
        if (u.a() == true) goto L5;
    L9:
        Thread.sleep(r100);
        return;
    L5:
        if (r100 <= 10) goto L9;
        if (isDebuggable() == true) goto L9;
        isLocalChannel();
        goto L9
    }
}
