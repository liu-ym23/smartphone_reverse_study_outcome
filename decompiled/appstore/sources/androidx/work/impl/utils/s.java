package androidx.work.impl.utils;

import android.content.Context;
import android.os.PowerManager;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;

/* JADX INFO: loaded from: classes.dex */
public abstract class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5849a = null;

    static {
        String r10 = androidx.work.i.i("WakeLocks");
        kotlin.jvm.internal.q.f(r10, "tagWithPrefix(\"WakeLocks\")");
        f5849a = r10;
    }

    public static final void a() {
        LinkedHashMap r10 = new LinkedHashMap();
        t r11 = t.f5850a;
        monitor-enter(r11);
        r10.putAll(r11.a());     // Catch: Throwable -> L15
        Unit r12 = Unit.f21064a;     // Catch: Throwable -> L15
        monitor-exit(r11);
        Iterator r13 = r10.entrySet().iterator();
    L8:
        if (r13.hasNext() == false) goto L14;
        Map.Entry r14 = (Map.Entry) r13.next();
        PowerManager.WakeLock r15 = (PowerManager.WakeLock) r14.getKey();
        String r16 = (String) r14.getValue();
        if (r15 == null) goto L8;
        if (r15.isHeld() != true) goto L8;
        androidx.work.i.e().k(f5849a, "WakeLock held for " + r16);
        goto L8
    L14:
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public static final PowerManager.WakeLock b(Context r10, String r11) {
        kotlin.jvm.internal.q.g(r10, "context");
        kotlin.jvm.internal.q.g(r11, "tag");
        Object r12 = r10.getApplicationContext().getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
        kotlin.jvm.internal.q.e(r12, "null cannot be cast to non-null type android.os.PowerManager");
        String r13 = "WorkManager: " + r11;
        PowerManager.WakeLock r14 = ((PowerManager) r12).newWakeLock(1, r13);
        t r15 = t.f5850a;
        monitor-enter(r15);
        String r16 = (String) r15.a().put(r14, r13);     // Catch: Throwable -> L8
        monitor-exit(r15);
        kotlin.jvm.internal.q.f(r14, "wakeLock");
        return r14;
    L8:
        th = move-exception;
        throw th;
    }
}
