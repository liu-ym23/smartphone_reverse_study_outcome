package com.bytedance.android.shopping.api.mall.common.homepage.pagecard.monitor;

import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.g;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.common.lib.AppLogNewUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class MallDeliveryMonitor$reportDeliveryEvent$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ boolean $isSuccess;
    final /* synthetic */ JSONObject $json;
    final /* synthetic */ String $uuid;
    final /* synthetic */ MallDeliveryMonitor this$0;

    public MallDeliveryMonitor$reportDeliveryEvent$1(MallDeliveryMonitor r100, String r101, JSONObject r102, boolean r103) {
        this.this$0 = r100;
        this.$uuid = r101;
        this.$json = r102;
        this.$isSuccess = r103;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Map r100 = (Map) ((LinkedHashMap) this.this$0.f170365a).get(this.$uuid);
        if (r100 == null) goto L8;
        Iterator r101 = r100.entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        Map.Entry r102 = (Map.Entry) r101.next();
        this.$json.putOpt((String) r102.getKey(), r102.getValue());
    L8:
        this.$json.putOpt("is_success", Integer.valueOf(this.$isSuccess ? 1 : 0));
        AppLogNewUtils.onEventV3("ec_mall_delivery", this.$json);
        Lazy r103 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(g.a.f47480b, "report ec_mall_delivery, isSuccess = " + this.$isSuccess + ", json = " + this.$json);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
