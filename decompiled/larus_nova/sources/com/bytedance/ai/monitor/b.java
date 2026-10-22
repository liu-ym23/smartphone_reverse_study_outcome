package com.bytedance.ai.monitor;

import android.os.Handler;
import com.bytedance.ai.debug.g;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import k5.c;
import k5.d;
import k5.h;
import k5.j;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import l5.z;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f37194a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f37195b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static h f37196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CopyOnWriteArrayList<Runnable> f37197d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final HashMap<String, String> f37198e = null;

    static {
        f37194a = new AtomicBoolean(false);
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("AppletReportingThread");
        f37197d = new CopyOnWriteArrayList();
        f37198e = new HashMap();
        g.f36215a.getClass();
        ThreadMethodProxy.start(r100);
        f37195b = new Handler(r100.getLooper());
    }

    public static void c(AppletMonitorableEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (r100.b() == true) goto L5;
        return;
    L5:
        JSONObject r101 = r100.n();
        String r102 = r100.getType();
        if (Intrinsics.areEqual(r102, "jsb_event") == false) goto L11;
        h r103 = f37196c;
        if (r103 == null) goto L30;
        r103.e(r100.f37140a, r101, r100.a(), r100.f37149j);
        return;
    L30:
        return;
    L11:
        if (Intrinsics.areEqual(r102, "error_event") == false) goto L17;
        h r104 = f37196c;
        if (r104 == null) goto L15;
        r104.c(r100.f37140a, r101, r100.a(), r100.f37149j);
    L15:
        g.f36215a.getClass();
        Intrinsics.checkNotNullParameter(r101, "event");
        return;
    L17:
        if (r100.f37143d == false) goto L25;
        h r105 = f37196c;
        if (r105 == null) goto L21;
        r105.a(r100.f37140a, r101, r100.a(), r100.f37149j);
    L21:
        z.a(r101, r100.a());
        z.a(r101, r100.f37149j);
        h r106 = f37196c;
        if (r106 == null) goto L24;
        r106.d(r100.f37140a, r101);
    L24:
        g.f36215a.getClass();
        Intrinsics.checkNotNullParameter(r101, "event");
        return;
    L25:
        h r107 = f37196c;
        if (r107 == null) goto L28;
        String r108 = r100.f37140a;
        r100.a();
        r107.b(r108, r101);
    L28:
        g.f36215a.getClass();
        Intrinsics.checkNotNullParameter(r101, "event");
    }

    public static void e(final Runnable r100) {
        Function0 r101 = new d(r100);
        n5.a.f517985a.getClass();
        Intrinsics.checkNotNullParameter(r101, "task");
        r101.invoke();
    }

    public static void b(final String r100, final j r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "builder");
        final long r102 = System.currentTimeMillis();
        e(new k5.b(r100, r101, r102));
    }

    public static void d(final String r100, final j r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "builder");
        final long r102 = System.currentTimeMillis();
        e(new k5.a(r100, r101, r102));
    }

    public static void a(final AppletErrorCode r100, final String r101, final String r110, final Function1 r111) {
        Intrinsics.checkNotNullParameter(r100, "code");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r111, "build");
        final long r102 = System.currentTimeMillis();
        e(new c(r100, r101, r110, r111, r102));
    }
}
