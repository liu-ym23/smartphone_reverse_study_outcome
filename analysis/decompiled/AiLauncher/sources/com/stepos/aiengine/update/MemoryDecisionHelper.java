package com.stepos.aiengine.update;

import La.C;
import La.D;
import android.app.ActivityManager;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import java.io.File;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.text.Regex;
import l9.i;
import v9.C5685n;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0015\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/stepos/aiengine/update/MemoryDecisionHelper;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "initTimeMs", "", "modelMemoryMb", "", "shouldReleaseImmediately", "(Landroid/content/Context;JI)Z", "delayReleaseMs", "(J)J", "idleTimeoutMs", "(Landroid/content/Context;)J", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)I", Const.INTENT_KEY_PKGNAME, "()I", "c", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MemoryDecisionHelper {
    public static final MemoryDecisionHelper INSTANCE = new MemoryDecisionHelper();

    public static /* synthetic */ boolean shouldReleaseImmediately$default(MemoryDecisionHelper memoryDecisionHelper, Context context, long j10, int i10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return memoryDecisionHelper.shouldReleaseImmediately(context, j10, i10);
    }

    public final int a(Context context) {
        Object systemService = context.getSystemService("activity");
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        if (activityManager == null) {
            return 0;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return (int) (memoryInfo.totalMem / 1048576);
    }

    public final int b() {
        return c();
    }

    public final int c() {
        Long lY;
        try {
            Object obj = null;
            Iterator it = i.l(new File("/proc/self/status"), null, 1, null).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (D.X((String) next, "VmRSS:", false, 2, null)) {
                    obj = next;
                    break;
                }
            }
            String str = (String) obj;
            if (str == null || (lY = C.y(new Regex("[^0-9]").l(str, ""))) == null) {
                return 0;
            }
            return (int) (lY.longValue() / 1024);
        } catch (Exception unused) {
            return 0;
        }
    }

    public final long delayReleaseMs(long initTimeMs) {
        double d10 = 1000;
        return (long) (C5685n.h((initTimeMs * 4) / d10, 10.0d) * d10);
    }

    public final long idleTimeoutMs(Context context) {
        p.i(context, "context");
        return (a(context) >= 8192 ? C5685n.n(30 - ((b() / 500) * 5), 15, 30) : 15) * 1000;
    }

    public final boolean shouldReleaseImmediately(Context context, long initTimeMs, int modelMemoryMb) {
        int iB;
        p.i(context, "context");
        if (initTimeMs < 500) {
            return true;
        }
        int iA = a(context);
        if ((1 > iA || iA >= 8192) && (iB = b()) <= 2048) {
            return iB > 1024 && modelMemoryMb > iB / 4;
        }
        return true;
    }
}
