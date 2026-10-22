package r1;

import com.bytedance.apm.launch.LaunchCommon;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f23679a = false;

    static {
    }

    public static e.a a() {
        if (f23679a == false) goto L5;
        return null;
    L5:
        f23679a = true;
        if (a.b().a().d() == true) goto L9;
        return null;
    L9:
        if (com.bytedance.apm.internal.a.c(4) == true) goto L12;
        return null;
    L12:
        return e.b();
    }

    public static JSONObject b(e.a r11) {
        if (r11 != null) goto L5;
        return null;
    L5:
        JSONObject r10 = new JSONObject();
        JSONObject r12 = new JSONObject();
    L9:
        th = move-exception;
        th.printStackTrace();
        a.b().e(th.getLocalizedMessage());
        return null;
    L7:
        if (r11.t() == (-1)) goto L12;
        r12.put(LaunchCommon.LAUNCH_DATA_GC_COUNT, r11.t());     // Catch: Throwable -> L9
    L12:
        if (r11.u() == (-1)) goto L15;
        r12.put(LaunchCommon.LAUNCH_DATA_GC_TIME, r11.u());     // Catch: Throwable -> L9
    L15:
        if (r11.q() == (-1)) goto L18;
        r12.put(LaunchCommon.LAUNCH_DATA_BLOCK_GC_COUNT, r11.q());     // Catch: Throwable -> L9
    L18:
        if (r11.r() == (-1)) goto L21;
        r12.put(LaunchCommon.LAUNCH_DATA_BLOCK_GC_TIME, r11.r());     // Catch: Throwable -> L9
    L21:
        if (r11.w() == (-1.0d)) goto L24;
        r12.put(LaunchCommon.LAUNCH_DATA_IOWAIT_TIME, r11.w());     // Catch: Throwable -> L9
    L24:
        if (r11.B() == (-1.0d)) goto L27;
        r12.put(LaunchCommon.LAUNCH_DATA_RUNNABLE_TIME, r11.B());     // Catch: Throwable -> L9
    L27:
        if (r11.C() == (-1.0d)) goto L30;
        r12.put(LaunchCommon.LAUNCH_DATA_SLEEP_TIME, r11.C());     // Catch: Throwable -> L9
    L30:
        if (r11.A() == (-1)) goto L33;
        r12.put(LaunchCommon.LAUNCH_DATA_MINOR_FAULT, r11.A());     // Catch: Throwable -> L9
    L33:
        if (r11.z() == (-1)) goto L36;
        r12.put(LaunchCommon.LAUNCH_DATA_MAJOR_FAULT, r11.z());     // Catch: Throwable -> L9
    L36:
        if (r11.s() == (-1.0d)) goto L39;
        r12.put(LaunchCommon.LAUNCH_DATA_CPU_TIME, r11.s());     // Catch: Throwable -> L9
    L39:
        if (r11.D() == (-1)) goto L42;
        r12.put(LaunchCommon.LAUNCH_DATA_VOLUNTARY_SWITCHES, r11.D());     // Catch: Throwable -> L9
    L42:
        if (r11.v() == (-1)) goto L45;
        r12.put(LaunchCommon.LAUNCH_DATA_INVOLUNTARY_SWITCHES, r11.v());     // Catch: Throwable -> L9
    L45:
        if (r11.o() == (-1)) goto L48;
        r12.put(LaunchCommon.LAUNCH_DATA_ALL_THREAD_COUNT, r11.o());     // Catch: Throwable -> L9
    L48:
        if (r11.y() == (-1)) goto L51;
        r12.put(LaunchCommon.LAUNCH_DATA_LOCK_TIME, r11.y());     // Catch: Throwable -> L9
    L51:
        if (r11.p() == (-1)) goto L53;
        r12.put(LaunchCommon.LAUNCH_DATA_BINDER_TIME, r11.p());     // Catch: Throwable -> L9
    L53:
        r10.put(LaunchCommon.LAUNCH_DATA_LIST_DATA, r12);     // Catch: Throwable -> L9
        List r13 = r11.x();     // Catch: Throwable -> L9
        if (r13 != null) goto L56;
    L62:
        a.b().d("perf data: " + r10);     // Catch: Throwable -> L9
        return r10;
    L56:
        if (r13.isEmpty() == true) goto L62;
        JSONArray r14 = new JSONArray();     // Catch: Throwable -> L9
        Iterator r15 = r13.iterator();     // Catch: Throwable -> L9
    L59:
        if (r15.hasNext() == false) goto L61;
        r14.put((String) r15.next());     // Catch: Throwable -> L9
        goto L59
    L61:
        r10.put(LaunchCommon.LAUNCH_DATA_JAVA_THREAD_NAME_LIST, r14);     // Catch: Throwable -> L9
        goto L62
    }
}
