package c60;

import a60.c;
import a60.d;
import b60.b;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.trace.e;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.RandomKt;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, c> f22527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Random f22528b;

    /* JADX INFO: renamed from: c60.a$a, reason: collision with other inner class name */
    public static final class C0408a {
    }

    static {
    }

    public a() {
        this.f22527a = new ConcurrentHashMap();
        this.f22528b = RandomKt.Random(System.currentTimeMillis());
    }

    public static String c(e r100) {
        return "productId=" + r100.f65002e + " businessType=" + r100.f64999b + " eventType=" + r100.f64998a + " traceId=" + r100.f65000c + " step=" + r100.f65003f + " logId=" + r100.f65001d;
    }

    public final boolean b(d r110, b r111) {
        Intrinsics.checkNotNullParameter(r110, "event");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        e r112 = r110.f1934a;
        String r100 = r112.f65002e;
        if (r100 != null) goto L5;
        r100 = "null";
    L5:
        String r101 = r100 + '-' + r112.f64999b;
        String r102 = r101 + '-' + r112.f64998a;
        if (r112.f65003f != null) goto L8;
        String[] r103 = {r102, r101, r100};
    L9:
        List<c> r113 = r111.getConfig().g();
        if (r113 != null) goto L12;
        r113 = CollectionsKt.emptyList();
    L12:
        Iterator<c> r114 = r113.iterator();
    L14:
        if (r114.hasNext() == false) goto L21;
        c r104 = r114.next();
        int r105 = r103.length;
        int r106 = 0;
    L16:
        if (r106 >= r105) goto L14;
        if (a(r104, r112, r103[r106]) == false) goto L19;
        r106 = r106 + 1;
        goto L16
    L19:
        return false;
    L21:
        int r115 = r103.length;
        int r107 = 0;
    L22:
        if (r107 >= r115) goto L35;
        String r108 = r103[r107];
        c r109 = (c) ((ConcurrentHashMap) this.f22527a).get(r108);
        c r116 = null;
        if (r109 != null) goto L27;
    L30:
        if (r116 == null) goto L34;
        if (a(r116, r112, r108) == true) goto L34;
        return false;
    L34:
        r107 = r107 + 1;
        goto L22
    L27:
        if (System.currentTimeMillis() < r109.f1933a) goto L29;
        r109 = null;
    L29:
        r116 = r109;
        goto L30
    L35:
        return true;
    L8:
        r103 = new String[]{r102, r101, r102 + '-' + r112.f65003f, r100};
        goto L9
    }

    public final boolean a(c r100, e r101, String r102) {
        if (Intrinsics.areEqual(r102, r100.a()) == true) goto L5;
    L12:
        return true;
    L5:
        if (r100.b() > 0) goto L9;
        ALogger.i("FuseEventFilter", "filter " + c(r101) + " with key " + r100.a());
        return false;
    L9:
        if ((this.f22528b.nextInt(100) + 1) <= r100.b()) goto L12;
        ALogger.i("FuseEventFilter", "filter " + c(r101) + " with key " + r100.a() + " and rate " + r100.b());
        return false;
    }
}
