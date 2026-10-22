package com.stepos.aiengine.update;

import O7.i;
import android.app.ActivityManager;
import android.content.Context;
import g1.AbstractC1451a;
import j9.t;
import java.io.File;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/aiengine/update/MemoryDecisionHelper;", "", "Landroid/content/Context;", "context", "", "initTimeMs", "", "modelMemoryMb", "", "shouldReleaseImmediately", "(Landroid/content/Context;JI)Z", "delayReleaseMs", "(J)J", "idleTimeoutMs", "(Landroid/content/Context;)J", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MemoryDecisionHelper {
    public static final MemoryDecisionHelper INSTANCE = new MemoryDecisionHelper();

    public static int a(Context context) {
        Object systemService = context.getSystemService("activity");
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        if (activityManager == null) {
            return 0;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return (int) (memoryInfo.totalMem / 1048576);
    }

    public static int b() {
        Object next;
        Long lG0;
        try {
            Iterator it = i.W(new File("/proc/self/status")).iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (t.e0((String) next, "VmRSS:", false)) {
                    break;
                }
            }
            String str = (String) next;
            if (str == null || (lG0 = t.g0(new Regex("[^0-9]").f(str, ""))) == null) {
                return 0;
            }
            return (int) (lG0.longValue() / 1024);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static /* synthetic */ boolean shouldReleaseImmediately$default(MemoryDecisionHelper memoryDecisionHelper, Context context, long j5, int i, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            i = 0;
        }
        return memoryDecisionHelper.shouldReleaseImmediately(context, j5, i);
    }

    public final long delayReleaseMs(long initTimeMs) {
        double d = 1000;
        double d6 = (initTimeMs * 4) / d;
        if (d6 > 10.0d) {
            d6 = 10.0d;
        }
        return (long) (d6 * d);
    }

    public final long idleTimeoutMs(Context context) {
        k.f(context, "context");
        return (a(context) >= 8192 ? AbstractC1451a.u(30 - ((b() / 500) * 5), 15, 30) : 15) * 1000;
    }

    public final boolean shouldReleaseImmediately(Context context, long initTimeMs, int modelMemoryMb) {
        int iA;
        int iB;
        k.f(context, "context");
        return initTimeMs < 500 || (1 <= (iA = a(context)) && iA < 8192) || (iB = b()) > 2048 || (iB > 1024 && modelMemoryMb > iB / 4);
    }
}
