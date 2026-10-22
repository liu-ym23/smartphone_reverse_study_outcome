package com.bytedance.android.gamecp.host_api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kjc.b;
import kjc.c;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class GameCpTargetUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f57346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f57347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f57348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f57349d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f57350e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f57351f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final List<Integer> f57352g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final GameCpTargetUtils f57353h = null;

    public GameCpTargetUtils() {
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [T, kotlin.Unit] */
    /* JADX WARN: Type inference failed for: r3v6, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v8, types: [T, java.lang.Object] */
    private final void call() {
        boolean r100 = false;
        f57346a = false;
        f57347b = false;
        f57348c = false;
        f57349d = false;
        f57350e = false;
        f57351f = false;
        if (a.b().getHostContext().c() == false) goto L6;
        f57351f = true;
        a.b().getLogService().W("getHostContext().isSaaS()");
        return;
    L6:
        c r101 = new c();
        if (1 != kjc.a.a()) goto L11;
        f57346a = true;
        a.b().getLogService().W("isDouyin");
        return;
    L11:
        if (2 != kjc.a.a()) goto L15;
        f57347b = true;
        a.b().getLogService().W("isDylite");
        return;
    L15:
        if (3 != kjc.a.a()) goto L19;
        f57348c = true;
        a.b().getLogService().W("isHuoshan");
        return;
    L19:
        if (4 != kjc.a.a()) goto L23;
        f57349d = true;
        a.b().getLogService().W("isJingXuan");
        return;
    L23:
        if (5 != kjc.a.a()) goto L26;
        f57350e = true;
        a.b().getLogService().W("isLegou");
        return;
    L26:
        GameCpTargetUtils$call$1$6 r102 = GameCpTargetUtils$call$1$6.INSTANCE;
        Intrinsics.checkNotNullParameter(r101, "$this$onSaaS");
        Intrinsics.checkNotNullParameter(r102, "block");
        List r103 = (List) a.b().getLiveService().A("live_gmcp_douyin_host_app_id_config", new ArrayList().getClass(), f57352g, Boolean.FALSE);
        int r104 = a();
        List r105 = r103;
        if (r105 != null) goto L29;
    L32:
        boolean r106 = true;
    L33:
        if (r106 == false) goto L45;
        a.b().getLogService().W("onSaaS: hostAppIdConfig.isNullOrEmpty()");
        if (f57346a == true) goto L45;
        if (f57347b == true) goto L45;
        if (f57348c == true) goto L45;
        if (f57349d == true) goto L45;
        if (f57350e == true) goto L45;
        r101.f503730a.f503729a = r102.invoke();
        r101.f503731b = true;
    L63:
        if (r101.f503731b == true) goto L65;
        b<T> r107 = r101.f503730a;
        f57346a = true;
        a.b().getLogService().W("onDefault");
        r107.f503729a = Unit.INSTANCE;
    L65:
        T r108 = r101.f503730a.f503729a;
        return;
    L45:
        if (r103 == null) goto L59;
        Iterator r109 = r103.iterator();
        boolean r110 = false;
    L48:
        if (r109.hasNext() == false) goto L58;
        Integer r111 = Integer.valueOf(((Number) r109.next()).intValue());
        if (r111.intValue() != r104) goto L52;
        boolean r112 = true;
    L53:
        if (r112 == true) goto L56;
        r111 = null;
    L56:
        if (r111 == null) goto L48;
        r111.intValue();
        r110 = true;
        goto L48
    L52:
        r112 = false;
        goto L53
    L58:
        r100 = r110;
    L59:
        a.b().getLogService().W("onSaaS: " + r100);
        if (r100 == true) goto L63;
        r101.f503730a.f503729a = r102.invoke();
        r101.f503731b = true;
        goto L63
    L29:
        if (r105.isEmpty() == true) goto L32;
        r106 = false;
        goto L33
    }

    static {
        f57353h = new GameCpTargetUtils();
        f57352g = CollectionsKt.listOf(new Integer[]{1128, 2329, 8663, 568863, 561124, 615883});
    }

    public static final boolean b() {
        f57353h.call();
        return f57346a;
    }

    public static final boolean c() {
        f57353h.call();
        if (f57346a == false) goto L5;
    L14:
        return true;
    L5:
        if (f57347b == true) goto L14;
        if (f57348c == true) goto L14;
        if (f57350e == true) goto L14;
        if (f57349d == true) goto L14;
        return false;
    }

    public static final boolean d() {
        f57353h.call();
        if (f57346a == false) goto L5;
    L8:
        return true;
    L5:
        if (f57348c == true) goto L8;
        return false;
    }

    public static final boolean e() {
        f57353h.call();
        return f57347b;
    }

    public static final boolean f() {
        f57353h.call();
        return f57348c;
    }

    public static final boolean h() {
        f57353h.call();
        return f57351f;
    }

    public static final int a() {
        int r100 = a.b().getHostContext().hostAppId();
        a.b().getLogService().W("appId: " + r100);
        return r100;
    }

    public static final boolean g() {
        if (a() != 1967) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean i() {
        if (a() != 32) goto L5;
        return true;
    L5:
        return false;
    }
}
