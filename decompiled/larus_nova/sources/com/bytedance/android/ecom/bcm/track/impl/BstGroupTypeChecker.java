package com.bytedance.android.ecom.bcm.track.impl;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.bcm.impl.BcmRecorder;
import com.bytedance.android.bcm.impl.model.f;
import com.bytedance.android.bcm.impl.paramcheck.BcmParamsChecker;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.inner.g;
import com.bytedance.android.btm.impl.monitor.BtmMonitor;
import com.bytedance.android.btm.impl.page.BtmPageRecorder;
import com.bytedance.android.btm.impl.page.model.PageInfo;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.support.api.entity.auth.AuthCode;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public final class BstGroupTypeChecker extends bd.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BstGroupTypeChecker f51070a = null;

    static {
        f51070a = new BstGroupTypeChecker();
    }

    public BstGroupTypeChecker() {
    }

    @Override // bd.a, bd.b
    public final void onPageCreated(Object r110) {
        super.onPageCreated(r110);
        if (r110 == null) goto L72;
        String r100 = BtmPageRecorder.f42212a;
        PageInfo r101 = BtmPageRecorder.j(r110);
        if (r101 == null) goto L73;
        int r102 = com.bytedance.android.ecom.bcm.track.impl.util.a.f51158a;
        final String r103 = com.bytedance.android.ecom.bcm.track.impl.util.a.a(r101.getPageBtm());
        boolean r104 = true;
        if (r103.length() != 0) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == false) goto L12;
        return;
    L12:
        ALogger r106 = ALogger.f41996d;
        r106.a("Params_Bst_Group_Type", false, new AnonymousClass1(r103));
        boolean r107 = BcmRecorder.f41789a;
        kc.c r108 = BcmRecorder.e(r101.getBtmPre());
        if (r108 == null) goto L74;
        Map<String, ? extends BcmParams> r109 = r108.f502367b;
        if (r109 == null) goto L75;
        String r111 = r101.getBtmPre();
        if (r111 == null) goto L76;
        BcmParams r112 = r109.get("ecom_entrance");
        if (r112 == null) goto L21;
        BcmParams r113 = r112.copy();
    L23:
        if (r103.length() != 0) goto L25;
        boolean r114 = true;
    L27:
        if (r114 == true) goto L31;
        List r115 = StringsKt.split$default(r103, new String[]{"."}, false, 0, 6, null);
        if (r115.size() < 2) goto L31;
        String r116 = ((String) ListProtector.get(r115, 0)) + "." + ((String) ListProtector.get(r115, 1)) + ".c0.d0";
    L34:
        if (BtmSetting.f42469d.c().c().h().contains(r116) == false) goto L61;
        final String r117 = new Regex("\\.e.*$").replace(r111, "");
        com.bytedance.android.bcm.impl.paramcheck.a r118 = BcmParamsChecker.f41841a.a(r117);
        if (r118 == null) goto L77;
        if (r113 == null) goto L39;
        final String r119 = BcmParams.optString$default(r113, com.bytedance.android.ec.core.event.a.KEY_BST_GROUP_TYPE, null, 2, null);
    L40:
        f r120 = r118.a(com.bytedance.android.ec.core.event.a.KEY_BST_GROUP_TYPE);
        if (r120 == null) goto L43;
        final List<Object> r121 = r120.f();
    L44:
        r106.a("Params_Bst_Group_Type", false, new BstGroupTypeChecker$checkBstGroupType$1(r117, r119, r121));
        if (r119 != null) goto L47;
    L49:
        boolean r122 = false;
    L50:
        if (r121 != null) goto L52;
    L54:
        r104 = false;
    L55:
        if (r122 == r104) goto L57;
        a(AuthCode.StatusCode.PERMISSION_EXPIRED, r117, r119, r121);
    L57:
        if (r122 == true) goto L59;
        return;
    L59:
        if (StringsKt.endsWith$default(r117, "c0.d0", false, 2, null) == false) goto L79;
        a(6003, r117, r119, r121);
        return;
    L79:
        return;
    L52:
        if (r121.contains("product") == false) goto L54;
    L47:
        if (Intrinsics.areEqual(r119, "product") == false) goto L49;
        r122 = true;
        goto L50
    L43:
        r121 = null;
        goto L44
    L39:
        r119 = null;
        goto L40
    L77:
        return;
    L61:
        if (r113 == null) goto L63;
        String r123 = BcmParams.optString$default(r113, com.bytedance.android.ec.core.event.a.KEY_BST_GROUP_TYPE, null, 2, null);
    L64:
        if (r123 != null) goto L66;
    L69:
        if (r104 == true) goto L81;
        a(6007, new Regex("\\.e.*$").replace(r111, ""), r123, null);
        return;
    L81:
        return;
    L66:
        if (r123.length() == 0) goto L69;
        r104 = false;
        goto L69
    L63:
        r123 = null;
    L31:
        r116 = "";
        goto L34
    L25:
        r114 = false;
        goto L27
    L21:
        r113 = null;
        goto L23
    L76:
        return;
    L75:
        return;
    L74:
        return;
    L9:
        r105 = false;
        goto L10
    L73:
        return;
    }

    public static void a(int r100, final String r101, final String r102, final List r103) {
        g.a.a(BtmMonitor.f42161c, r100, "bst_group_type ERROR!", null, new BstGroupTypeChecker$reportError$1(r101, r103, r102), 28);
        LinkedHashMap r104 = new LinkedHashMap();
        JSONArray r105 = new JSONArray();
        if (r103 == null) goto L8;
        Iterator r106 = r103.iterator();
    L6:
        if (r106.hasNext() == false) goto L8;
        r105.put(r106.next());
    L8:
        r104.put("bcm_key", com.bytedance.android.ec.core.event.a.KEY_BST_GROUP_TYPE);
        r104.put("arctic_bcm_params", r105);
        r104.put("origin_bcm_params", r102);
        com.bytedance.android.btm.impl.quality.b.a(r100, r101, r104);
    }
}
