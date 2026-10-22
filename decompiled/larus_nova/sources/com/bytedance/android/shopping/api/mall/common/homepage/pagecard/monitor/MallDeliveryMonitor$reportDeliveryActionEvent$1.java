package com.bytedance.android.shopping.api.mall.common.homepage.pagecard.monitor;

import android.net.Uri;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.g;
import com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.SessionSettingUtil;
import com.bytedance.locallife.cube.PrefetchTiming;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class MallDeliveryMonitor$reportDeliveryActionEvent$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ JSONObject $json;
    final /* synthetic */ String $process;
    final /* synthetic */ String $uuid;
    final /* synthetic */ MallDeliveryMonitor this$0;

    public MallDeliveryMonitor$reportDeliveryActionEvent$1(MallDeliveryMonitor r100, String r101, String r102, JSONObject r103) {
        this.this$0 = r100;
        this.$uuid = r101;
        this.$process = r102;
        this.$json = r103;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Set<String> r100 = (Set) ((LinkedHashMap) this.this$0.f170368d).get(this.$uuid);
        if (r100 != null) goto L6;
        r100 = new LinkedHashSet();
        this.this$0.f170368d.put(this.$uuid, r100);
    L6:
        if (r100.contains(this.$process) == false) goto L8;
        return;
    L8:
        r100.add(this.$process);
        if (Intrinsics.areEqual(this.$process, "view_appeared") == false) goto L11;
    L14:
        Integer r101 = (Integer) ((LinkedHashMap) this.this$0.f170370f).get(this.$uuid);
        if (r101 != null) goto L18;
    L20:
        String r102 = "1";
    L21:
        this.$json.putOpt("mall_visible", r102);
        JSONObject r103 = this.$json;
        MallDeliveryMonitor r104 = this.this$0;
        String r105 = this.$uuid;
        if (r104.f170374j.length() <= 0) goto L24;
        boolean r106 = true;
    L25:
        if (r106 == false) goto L27;
        String r107 = r104.f170374j;
    L42:
        r103.putOpt("origin_schema", r107);
    L44:
        if ((!Intrinsics.areEqual(this.$process, "delivery_identify")) == false) goto L51;
        String r108 = (String) ((LinkedHashMap) this.this$0.f170373i).get(this.$uuid);
        if (r108 != null) goto L49;
        r108 = "-1";
    L49:
        if ((true ^ Intrinsics.areEqual(r108, "-1")) == false) goto L51;
        this.$json.putOpt(ChameleonOpenTracker.ParamKey.RES_VERSION, r108);
    L51:
        AppLogNewUtils.onEventV3("ec_mall_delivery_action_full", this.$json);
        if (((List) SessionSettingUtil.f170349f.getValue()).contains(this.$process) == false) goto L54;
        AppLogNewUtils.onEventV3("ec_mall_delivery_action", this.$json);
    L54:
        Lazy r109 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(g.a.f47480b, "report ec_mall_delivery_action, uuid = " + this.$uuid + ", process = " + this.$process + ", json = " + this.$json);
        return;
    L27:
        Map r110 = (Map) ((LinkedHashMap) r104.f170365a).get(r105);
        Object r111 = null;
        if (r110 == null) goto L30;
        Object r112 = r110.get("delivery_value");
    L32:
        if ((r112 instanceof String) == false) goto L35;
        r111 = r112;
    L35:
        String r113 = (String) r111;
        if (r113 != null) goto L56;
        r113 = "";
    L56:
        String r114 = Uri.decode(r113);     // Catch: Exception -> L40
    L41:
        r104.f170374j = r114;
        r107 = r114;
    L40:
        r114 = r113;
        goto L41
    L30:
        r112 = null;
        goto L32
    L24:
        r106 = false;
        goto L25
    L18:
        if (r101.intValue() != 1) goto L20;
        r102 = "2";
        goto L21
    L11:
        if (Intrinsics.areEqual(this.$process, "tti") == true) goto L14;
        if (Intrinsics.areEqual(this.$process, PrefetchTiming.ROUTER) == false) goto L44;
        goto L14
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
