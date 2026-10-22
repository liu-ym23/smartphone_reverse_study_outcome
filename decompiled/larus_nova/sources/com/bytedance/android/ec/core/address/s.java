package com.bytedance.android.ec.core.address;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f43712a = 0;

    public s() {
    }

    static {
    }

    public static void c(boolean r100, String r101) {
        Pair[] r102 = new Pair[2];
        if (r100 == false) goto L5;
        String r103 = "setting_null";
    L6:
        r102[0] = TuplesKt.to("category", r103);
        r102[1] = TuplesKt.to("detail", r101);
        a(1002, "SETTINGS_RETURN_NULL", MapsKt.mapOf(r102));
        return;
    L5:
        r103 = "parse_error";
        goto L6
    }

    public static void a(int r100, String r101, Map r102) {
        JSONObject r103 = new JSONObject();
        r103.put("code", r100);
        r103.put("message", r101);
        if (r102 == null) goto L10;
        Set r104 = r102.entrySet();
        if (r104 == null) goto L10;
        Iterator r105 = r104.iterator();
    L8:
        if (r105.hasNext() == false) goto L10;
        Map.Entry r106 = (Map.Entry) r105.next();
        r103.put((String) r106.getKey(), r106.getValue());
    L10:
        AddressEventReporter.d("ec_address_sdk_monitor", r103);
    }

    public static void d(Integer r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "source");
        a(2002, "REPORT_ADDRESS_NET_ERROR", MapsKt.mapOf(new Pair[]{TuplesKt.to("status_code", r100), TuplesKt.to("source", r101), TuplesKt.to("log_id", r102)}));
    }

    public static void b(boolean r100, Integer r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r102, "changeType");
        Pair[] r104 = new Pair[4];
        if (r100 == false) goto L5;
        String r105 = "list_empty";
    L6:
        r104[0] = TuplesKt.to("category", r105);
        r104[1] = TuplesKt.to("status_code", r101);
        r104[2] = TuplesKt.to("change_type", r102);
        r104[3] = TuplesKt.to("log_id", r103);
        a(2001, "GET_ADDRESS_NET_ERROR", MapsKt.mapOf(r104));
        return;
    L5:
        r105 = "net_error";
        goto L6
    }
}
