package com.bytedance.android.ec.core.address;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.ec.core.utils.b2;
import com.bytedance.android.ec.core.utils.z1;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class AddressEventReporter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f43648a = 0;

    static {
    }

    public static void a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        kc.a.C6534a r101 = null;
        Object r102 = null;
        r101 = null;
        kc.a r103 = BtmSDK.getBcmChainByFinder$default(BtmSDK.INSTANCE, null, 3, false, 4, null);
        String r104 = null;
        if (r103 == null) goto L23;
        List<kc.a.C6534a> r105 = r103.f502353a;
        if (r105 == null) goto L23;
        Iterator<T> r106 = r105.iterator();
    L8:
        if (r106.hasNext() == false) goto L21;
        Object r107 = r106.next();
        kc.a.C6534a r108 = (kc.a.C6534a) r107;
        if (BtmSDK.INSTANCE.removeBcmChainPageId() == false) goto L15;
        if (r108 == null) goto L13;
        String r109 = r108.f502356c;
    L14:
        String r110 = cd.a.b(r109);
    L19:
        if ((!Intrinsics.areEqual(r110, "a1.b0440.c0.d0")) == false) goto L8;
        r102 = r107;
        goto L21
    L13:
        r109 = null;
        goto L14
    L15:
        if (r108 == null) goto L17;
        r110 = r108.f502355b;
        goto L19
    L17:
        r110 = null;
    L21:
        r101 = (kc.a.C6534a) r102;
    L23:
        if (BtmSDK.INSTANCE.removeBcmChainPageId() == false) goto L27;
        if (r101 == null) goto L26;
        r104 = r101.f502356c;
    L26:
        r104 = cd.a.b(r104);
    L29:
        JSONObject r111 = new JSONObject();
        r111.put("address_strategy_type", z.d(r100));
        r111.put("btm", r104);
        r111.put("enable_location_stub", true);
        r111.put("receive_address_id", z.b(r100));
        r111.put("address_type", z.e(r100));
        Unit r112 = Unit.INSTANCE;
        d("ec_sdk_change_address", r111);
        return;
    L27:
        if (r101 == null) goto L29;
        r104 = r101.f502355b;
        goto L29
    }

    public static void c(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        String r101 = z.f();
        JSONObject r102 = new JSONObject();
        r102.put("address_strategy_type", z.d(r100));
        r102.put("btm", r101);
        r102.put("enable_location_stub", true);
        r102.put("receive_address_id", z.b(r100));
        r102.put("address_type", z.e(r100));
        Unit r103 = Unit.INSTANCE;
        d("ec_sdk_select_address", r102);
    }

    public static void d(final String r100, final JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "params");
        b2.a(new AddressEventReporter$sendEvent$1(r101, r100));
    }

    public static void b(String r100, String r101, o83.b r102) {
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        JSONObject r103 = new JSONObject();
        if (r102.f522367d == false) goto L5;
        int r104 = 1;
    L6:
        r103.put("source_address_type", r104);
        r103.put("sdk_address_type", r102.f522366c);
        JSONObject r105 = r102.f522364a;
        if (r105 == null) goto L10;
        String r106 = z.d(r105);
        if (r106 == null) goto L10;
    L11:
        r103.put("address_strategy_type", r106);
        r103.put("btm", r100);
        r103.put("enable_location_stub", true);
        JSONObject r107 = r102.f522364a;
        if (r107 == null) goto L16;
        JSONObject r108 = r107.optJSONObject("log_extra");
        if (r108 == null) goto L16;
        z1.b(r103, r108);
    L16:
        JSONObject r109 = r102.f522364a;
        Integer r110 = null;
        if (r109 == null) goto L19;
        String r111 = z.b(r109);
    L20:
        r103.put("receive_address_id", r111);
        JSONObject r112 = r102.f522364a;
        if (r112 == null) goto L23;
        r110 = z.e(r112);
    L23:
        r103.put("address_type", r110);
        r103.put("request_time", z.j());
        r103.put("pre_main_btm", r101);
        Unit r113 = Unit.INSTANCE;
        d("ec_sdk_get_address", r103);
        return;
    L19:
        r111 = null;
    L10:
        r106 = "no_address";
        goto L11
    L5:
        r104 = 2;
        goto L6
    }
}
