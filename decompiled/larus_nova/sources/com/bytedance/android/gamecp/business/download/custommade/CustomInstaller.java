package com.bytedance.android.gamecp.business.download.custommade;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.android.gamecp.business.download.AppLifecycleObserver;
import com.bytedance.android.gamecp.business.download.custommade.bean.CustomInstallInfo;
import com.bytedance.android.gamecp.business.download.custommade.bean.InstallFailReason;
import com.bytedance.android.gamecp.business.download.k1;
import com.bytedance.android.gamecp.business.download.p;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.android.gamecp.common.utils.z0;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import wu.r;

/* JADX INFO: loaded from: classes44.dex */
public final class CustomInstaller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Intent> f52577a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Object> f52578b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, LinkedList<Integer>> f52579c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static ls.a f52580d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f52581e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f52582f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f52583g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final CustomInstaller f52584h = null;

    public CustomInstaller() {
    }

    public static g b() {
        return (g) f52582f.getValue();
    }

    static {
        f52584h = new CustomInstaller();
        f52577a = new ConcurrentHashMap();
        f52578b = new ConcurrentHashMap();
        f52579c = new ConcurrentHashMap();
        f52581e = LazyKt.lazy(CustomInstaller$isPreInstall$2.INSTANCE);
        f52582f = LazyKt.lazy(CustomInstaller$sessionInstaller$2.INSTANCE);
        f52583g = LazyKt.lazy(CustomInstaller$strategy$2.INSTANCE);
    }

    public static boolean c() {
        Integer r100 = r.f561377a.getValue();
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.intValue() != 3) goto L8;
        return true;
    }

    public static void d(p r100, int r101) {
        c r102 = c.f52643a;
        AppLifecycleObserver r103 = k1.f52798a;     // Catch: Exception -> L8
        Map<String, String> r104 = k1.c(r100);     // Catch: Exception -> L8
        r104.putAll(k1.b(r100));     // Catch: Exception -> L8
        r104.put("error_code", String.valueOf(r101));     // Catch: Exception -> L8
        if (z0.f57331b != null) goto L6;
        z0.a("");     // Catch: Exception -> L8
    L6:
        r104.put("game_rom_ver", z0.f57331b);     // Catch: Exception -> L8
        com.bytedance.android.gamecp.host_api.a.b().getLogService().logV3("game_install_custom_check_error", r104);     // Catch: Exception -> L8
        return;
    }

    public static void e(String r100, InstallFailReason r101) {
        Intrinsics.checkNotNullParameter(r101, "failReason");
        if (TextUtils.isEmpty(r100) == true) goto L9;
        ConcurrentHashMap<String, LinkedList<Integer>> r102 = f52579c;
        Intrinsics.checkNotNull(r100);
        LinkedList<Integer> r103 = r102.get(r100);
        if (r103 != null) goto L7;
        r103 = new LinkedList();
        r102.put(r100, r103);
    L7:
        r103.offer(Integer.valueOf(r101.failureCode));
        return;
    }

    public static void a(Context r100, int r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        yr.c.a("CustomInstaller", "clear sessionId" + r101 + ", isClearCurSession:" + r102 + " pkgName:" + r103);
        b().h(null);
        if (c() == true) goto L5;
    L6:
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        Intrinsics.checkNotNullParameter(r103, "pkgName");
        f52577a.remove(r103);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        b().b(r100, r101, r102);
        return;
    L5:
        if (f52580d == null) goto L6;
    }

    public final void startActivity(Context r100, String r110, String r111, CustomInstallInfo r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "pkgName");
        Intrinsics.checkNotNullParameter(r111, "downloadFilePath");
        Intrinsics.checkNotNullParameter(r112, "customInstallInfo");
        if (c() == false) goto L6;
        NewCustomInstallActivity.f52586w.startActivity(y0.getContext(), new ls.a(r110, r111, r112, 0, 0));
        return;
    L6:
        CustomInstallActivity.f52546o.startActivity(r100, r110, r111, r112);
    }
}
