package a70;

import com.bytedance.android.live.core.setting.d6;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import wa1.d;

/* JADX INFO: loaded from: classes45.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Long> f1985a = null;

    static {
        f1985a = new LinkedHashMap();
    }

    public static Long b() {
        Intrinsics.checkNotNullParameter("ColdStrategy_gson", "tag");
        Long r100 = (Long) ((LinkedHashMap) f1985a).get("ColdStrategy_gson");
        if (r100 == null) goto L5;
        long r101 = r100.longValue();
        return Long.valueOf(System.currentTimeMillis() - r101);
    L5:
        return null;
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Long r101 = (Long) ((LinkedHashMap) f1985a).get(r100);
        if (r101 == null) goto L6;
        e("_MAIN", r100 + " 耗时计时：" + (System.currentTimeMillis() - r101.longValue()));
        return;
    }

    public static void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        int r101 = d6.f65283a;
        Intrinsics.checkNotNullParameter("SettingReportMonitor_MAIN", "tag");
        Intrinsics.checkNotNullParameter(r100, "msg");
        wa1.a r102 = d.f558803a;
        Intrinsics.checkNotNullParameter("SettingReportMonitor_MAIN", "tag");
        wa1.a r103 = d.f558803a;
        if (r103 == null) goto L6;
        r103.e(r100);
        return;
    }

    public static void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        f1985a.put(r100, Long.valueOf(System.currentTimeMillis()));
    }

    public static boolean c(String r100, String r101) {
        if (StringsKt.contains$default(r101, "keva_remote_config_setting_keys", false, 2, null) == false) goto L5;
        return false;
    L5:
        if ((!Intrinsics.areEqual(r100, "_VALUE")) == true) goto L8;
        int r102 = d6.f65283a;
        if (d.f558804b == true) goto L8;
        return false;
    L8:
        return true;
    }

    @JvmStatic
    public static final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (c(r100, r101) == false) goto L6;
        d6.c("SettingReportMonitor".concat(r100), r101);
        return;
    }
}
