package av4;

import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.c;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.e;
import com.bytedance.ee.bear.bitable.statistic.i;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends com.bytedance.ee.bear.bitable.statistic.common.a {
    @Override // com.bytedance.ee.bear.bitable.statistic.j
    public final List<BitableStatisticEventModel$NormalPointModel> c(e r100, BitableStatisticEventModel$NormalPointModel r101, List<BitableStatisticEventModel$NormalPointModel> r102) {
        Intrinsics.checkNotNullParameter(r100, "trace");
        Intrinsics.checkNotNullParameter(r101, "currPoint");
        Intrinsics.checkNotNullParameter(r102, "allPoints");
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.j
    public final String getTag() {
        return "BitableJsbConsumer";
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.a
    public final String i() {
        return "base_mobile_jsb_call_dev";
    }

    public a() {
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.a
    public final boolean k(i r100, e r110, BitableStatisticEventModel$NormalPointModel r111, List<BitableStatisticEventModel$NormalPointModel> r112) {
        Intrinsics.checkNotNullParameter(r100, "logger");
        Intrinsics.checkNotNullParameter(r110, "trace");
        Intrinsics.checkNotNullParameter(r111, "currPoint");
        Intrinsics.checkNotNullParameter(r112, "allPoints");
        if (TextUtils.equals(r111.getName(), "JSB_REPORT_POINT_NAME") == false) goto L43;
        HashMap r113 = new HashMap();
        r113.putAll(this.f215610b);
        HashMap<String, Serializable> r101 = r111.getExtras();
        if (r101 == null) goto L9;
        Serializable r102 = r101.get("jsb_name");
        if (r102 == null) goto L9;
        String r103 = r102.toString();
    L10:
        HashMap<String, Serializable> r114 = r111.getExtras();
        if (r114 == null) goto L41;
        Map r115 = MapsKt.toMap(r114);
        if (r115 == null) goto L41;
        Iterator r116 = r115.entrySet().iterator();
    L16:
        if (r116.hasNext() == false) goto L41;
        Map.Entry r104 = (Map.Entry) r116.next();
        if (TextUtils.equals((CharSequence) r104.getKey(), "msg") == true) goto L19;
        Serializable r105 = (Serializable) r113.put(r104.getKey(), r104.getValue());
        goto L16
    L19:
        if (r103 == null) goto L21;
        boolean r106 = StringsKt.contains$default(r103, "performCardAction", false, 2, null);
    L22:
        if (r106 == true) goto L44;
    L29:
        int r107 = c.f207079a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.jsb_consumer_oom_fix_enable") == true) goto L31;
        Serializable r108 = (Serializable) r113.put("msg_size", Integer.valueOf(r104.getValue().toString().getBytes(Charsets.UTF_8).length));
        goto L16
    L31:
        Object r109 = r104.getValue();
        if ((r109 instanceof String) == false) goto L34;
        String r117 = (String) r109;
    L35:
        if (r117 == null) goto L37;
        int r118 = r117.length();
    L38:
        Serializable r119 = (Serializable) r113.put("msg_size", Integer.valueOf(r118));
        goto L16
    L37:
        r118 = 0;
        goto L38
    L34:
        r117 = null;
        goto L35
    L44:
        String r120 = new JSONObject(r104.getValue().toString()).optString("action");     // Catch: Throwable -> L27
        if (TextUtils.isEmpty(r120) == true) goto L29;
        r113.put("action", r120);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        tt5.a.e("BitableJsbConsumer", "parse json performCardAction error", th, false);
        goto L29
    L21:
        r106 = false;
    L41:
        Unit r121 = Unit.INSTANCE;
        r100.d(r110, "base_mobile_jsb_call_dev", r113);
        return true;
    L9:
        r103 = null;
        goto L10
    L43:
        return false;
    }
}
