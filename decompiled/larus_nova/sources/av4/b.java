package av4;

import com.android.ttcjpaysdk.integrated.counter.CJPayBaseConstant;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.m;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f16367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f16368b = null;

    static {
        f16368b = org.koin.java.a.d(m.class);
    }

    public static void b() {
        String r100 = f16367a;
        if (r100 == null) goto L5;
        c().stopTrace(r100, Boolean.TRUE);
    L5:
        String r101 = c().createNormalTrace(null);
        f16367a = r101;
        if (r101 == null) goto L9;
        c().addNormalConsumer(r101, new a());
        return;
    }

    public static m c() {
        return (m) f16368b.getValue();
    }

    public static void a(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        String r101 = f16367a;
        if (r101 == null) goto L8;
        Iterator r102 = r100.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        Map.Entry r103 = (Map.Entry) r102.next();
        c().addTraceExtra(r101, (String) r103.getKey(), (Serializable) r103.getValue());
        goto L6
    L10:
        return;
    }

    public static void d(String r110, long r111, String r112, String r113) {
        String r100 = r110;
        Intrinsics.checkNotNullParameter(r110, "jsbName");
        Intrinsics.checkNotNullParameter(r113, "invokeFrom");
        String r101 = f16367a;
        if (r101 == null) goto L13;
        m r102 = c();
        BitableStatisticEventModel$NormalPointModel.a r103 = BitableStatisticEventModel$NormalPointModel.Companion;
        long r114 = System.currentTimeMillis();
        Pair[] r115 = new Pair[4];
        if (StringsKt.contains$default(r110, "javascript:", false, 2, null) == false) goto L7;
        r100 = StringsKt.replace$default(r110, "javascript:", "", false, 4, null);
    L7:
        r115[0] = TuplesKt.to("jsb_name", r100);
        r115[1] = TuplesKt.to(HiAnalyticsConstant.BI_KEY_COST_TIME, Long.valueOf(r111));
        if (r112 != null) goto L10;
        String r104 = "";
    L11:
        r115[2] = TuplesKt.to("msg", r104);
        r115[3] = TuplesKt.to(CJPayBaseConstant.INVOKE_FROM, r113);
        HashMap r105 = MapsKt.hashMapOf(r115);
        r103.getClass();
        r102.addNormalPoint(r101, BitableStatisticEventModel$NormalPointModel.a.b("JSB_REPORT_POINT_NAME", r114, false, r105));
        return;
    L10:
        r104 = r112;
        goto L11
    }
}
