package bm9;

import android.os.SystemClock;
import com.larus.trace.RealTimeNavEndReason;
import com.larus.trace.RealTimeNavStartFailReason;
import com.larus.trace.RealTimeNavStartResult;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.b3;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f19654a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile String f19655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile int f19656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile Long f19657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile Long f19658e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile Long f19659f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile Long f19660g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile Long f19661h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static JSONObject f19662i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static JSONObject f19663j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static Long f19664k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f19665l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static String f19666m;

    static {
        f19654a = new a();
    }

    public a() {
    }

    public final synchronized void c() {
        monitor-enter(this);
        f19655b = null;     // Catch: Throwable -> L7
        f19657d = null;     // Catch: Throwable -> L7
        f19658e = null;     // Catch: Throwable -> L7
        f19659f = null;     // Catch: Throwable -> L7
        f19660g = null;     // Catch: Throwable -> L7
        f19661h = null;     // Catch: Throwable -> L7
        f19662i = null;     // Catch: Throwable -> L7
        f19663j = null;     // Catch: Throwable -> L7
        f19664k = null;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(String r100, Object r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "key");     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r101, "value");     // Catch: Throwable -> L11
        if (f19663j != null) goto L6;
        f19663j = new JSONObject();     // Catch: Throwable -> L11
    L6:
        JSONObject r102 = f19663j;     // Catch: Throwable -> L11
        if (r102 == null) goto L9;
        r102.put(r100, r101);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(String r100, Object r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "key");     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r101, "value");     // Catch: Throwable -> L11
        if (f19662i != null) goto L6;
        f19662i = new JSONObject();     // Catch: Throwable -> L11
    L6:
        JSONObject r102 = f19662i;     // Catch: Throwable -> L11
        if (r102 == null) goto L9;
        r102.put(r100, r101);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static void d(RealTimeNavEndReason r100, String r101, int r102) {
        a r103 = f19654a;
        String r104 = null;
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        monitor-enter(r103);
    L26:
        th = move-exception;
        throw th;
    L10:
        if (f19655b != null) goto L12;
    L24:
        monitor-exit(r103);
        return;
    L12:
        if (Intrinsics.areEqual(f19655b, f19666m) == true) goto L24;
        f19666m = f19655b;     // Catch: Throwable -> L26
        r103.a("engine_type", Integer.valueOf(f19656c));     // Catch: Throwable -> L26
        Long r105 = f19664k;     // Catch: Throwable -> L26
        if (r105 == null) goto L17;
        Long r106 = Long.valueOf(SystemClock.elapsedRealtime() - r105.longValue());     // Catch: Throwable -> L26
    L18:
        String r107 = f19655b;     // Catch: Throwable -> L26
        JSONObject r108 = f19663j;     // Catch: Throwable -> L26
        if (r108 == null) goto L21;
        r104 = r108.toString();     // Catch: Throwable -> L26
    L21:
        b3.a(r107, r106, r100, r101, r104);     // Catch: Throwable -> L26
        r103.c();     // Catch: Throwable -> L26
        monitor-exit(r103);
        return;
    L17:
        r106 = null;
        goto L18
    }

    public static void e(RealTimeNavStartResult r110, RealTimeNavStartFailReason r111, String r112, int r113) {
        a r100 = f19654a;
        String r101 = null;
        if ((r113 & 2) == 0) goto L5;
        RealTimeNavStartFailReason r114 = null;
    L7:
        if ((r113 & 4) == 0) goto L9;
        String r115 = null;
    L10:
        monitor-enter(r100);
        Intrinsics.checkNotNullParameter(r110, "result");     // Catch: Throwable -> L28
        if (f19655b != null) goto L14;
    L26:
        monitor-exit(r100);
        return;
    L14:
        if (Intrinsics.areEqual(f19655b, f19665l) == true) goto L26;
        f19665l = f19655b;     // Catch: Throwable -> L28
        r100.b("engine_type", Integer.valueOf(f19656c));     // Catch: Throwable -> L28
        Long r102 = f19657d;     // Catch: Throwable -> L28
        if (r102 == null) goto L19;
        Long r103 = Long.valueOf(SystemClock.elapsedRealtime() - r102.longValue());     // Catch: Throwable -> L28
    L20:
        String r104 = f19655b;     // Catch: Throwable -> L28
        Long r105 = f19658e;     // Catch: Throwable -> L28
        Long r106 = f19659f;     // Catch: Throwable -> L28
        Long r107 = f19660g;     // Catch: Throwable -> L28
        Long r108 = f19661h;     // Catch: Throwable -> L28
        JSONObject r109 = f19662i;     // Catch: Throwable -> L28
        if (r109 == null) goto L23;
        r101 = r109.toString();     // Catch: Throwable -> L28
    L23:
        b3.b(r104, r110, r105, r106, r107, r108, r103, r114, r115, r101);     // Catch: Throwable -> L28
        f19664k = Long.valueOf(SystemClock.elapsedRealtime());     // Catch: Throwable -> L28
        monitor-exit(r100);
        return;
    L19:
        r103 = null;
    L28:
        th = move-exception;
        throw th;
    L9:
        r115 = r112;
        goto L10
    L5:
        r114 = r111;
        goto L7
    }
}
