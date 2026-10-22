package com.bytedance.android.shopping.mall.opt;

import com.bytedance.android.shopping.api.mall.MallPageName;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes13.dex */
public final class MallOptUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f178553a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f178554b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f178555c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f178556d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f178557e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f178558f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f178559g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f178560h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f178561i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy f178562j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Lazy f178563k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Lazy f178564l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Lazy f178565m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Lazy f178566n = null;

    public static f d() {
        return (f) f178566n.getValue();
    }

    public static j93.b e() {
        return (j93.b) f178560h.getValue();
    }

    public static aa3.c f() {
        return (aa3.c) f178558f.getValue();
    }

    static {
        f178553a = LazyKt.lazy(MallOptUtil$config$2.INSTANCE);
        f178554b = LazyKt.lazy(MallOptUtil$openSchemaTurboSetting$2.INSTANCE);
        f178555c = LazyKt.lazy(MallOptUtil$openSchemaGcBlockSetting$2.INSTANCE);
        f178556d = LazyKt.lazy(MallOptUtil$preloadConfig$2.INSTANCE);
        f178557e = LazyKt.lazy(MallOptUtil$mallEnterPdOptSetting$2.INSTANCE);
        f178558f = LazyKt.lazy(MallOptUtil$preBindStrategy$2.INSTANCE);
        f178559g = LazyKt.lazy(MallOptUtil$imagePreFetchDelay$2.INSTANCE);
        f178560h = LazyKt.lazy(MallOptUtil$mallReportOpt$2.INSTANCE);
        f178561i = LazyKt.lazy(MallOptUtil$mallFlingOpt$2.INSTANCE);
        f178562j = LazyKt.lazy(MallOptUtil$delayLoadMoreCheck$2.INSTANCE);
        f178563k = LazyKt.lazy(MallOptUtil$asyncReportEvent$2.INSTANCE);
        f178564l = LazyKt.lazy(MallOptUtil$asyncReportEventBlack$2.INSTANCE);
        f178565m = LazyKt.lazy(MallOptUtil$imagePrefetchThread$2.INSTANCE);
        f178566n = LazyKt.lazy(MallOptUtil$frameDropOpt$2.INSTANCE);
    }

    public static boolean b(String r100) {
        return a(r100, MallOptUtil$frameOptVideoPlay$1.INSTANCE);
    }

    public static boolean c(String r100) {
        return a(r100, MallOptUtil$frameOptWithBg$1.INSTANCE);
    }

    public static boolean a(String r100, Function0 r101) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (d().b() == null) goto L14;
        List<String> r102 = d().b();
        if (r102 == null) goto L14;
        if (r102.contains(r100) != true) goto L14;
        return ((Boolean) r101.invoke()).booleanValue();
    L14:
        return false;
    }

    public static int g(String r100, int r101) {
        if (r100 != null) goto L5;
        return -1;
    L5:
        Integer r102 = f().e();
        if (r102 == null) goto L57;
        int r103 = r102.intValue();
        int r104 = r100.hashCode();
        if (r104 == (-1773284929)) goto L18;
        if (r104 != 556139984) goto L23;
        if (r100.equals(MallPageName.X_TAB_MALL) == false) goto L23;
        if ((r103 & 1) == 1) goto L24;
    L25:
        boolean r105 = false;
    L26:
        if (r105 == true) goto L28;
        return -1;
    L28:
        Integer r106 = f().f();
        if (r106 != null) goto L31;
        return -1;
    L31:
        if (((r106.intValue() >> r101) & 1) != 1) goto L59;
        if (r101 == 0) goto L50;
        if (r101 == 1) goto L46;
        if (r101 != 2) goto L36;
        Integer r107 = f().b();
        if (r107 != null) goto L45;
        return -1;
    L45:
        return r107.intValue();
    L36:
        if (r101 != 3) goto L61;
        Integer r108 = f().d();
        if (r108 != null) goto L41;
        return -1;
    L41:
        return r108.intValue();
    L61:
        return -1;
    L46:
        Integer r109 = f().c();
        if (r109 != null) goto L49;
        return -1;
    L49:
        return r109.intValue();
    L50:
        Integer r110 = f().a();
        if (r110 != null) goto L53;
        return -1;
    L53:
        return r110.intValue();
    L59:
        return -1;
    L24:
        r105 = true;
    L23:
        if (((r103 >> 2) & 1) != 1) goto L25;
    L18:
        if (r100.equals("order_homepage") == false) goto L23;
        if (((r103 >> 1) & 1) != 1) goto L25;
    L57:
        return -1;
    }
}
