package com.bytedance.android.shopping.api.mall.common.homepage.pagecard.monitor;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.common.lib.AppLogNewUtils;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class MallDeliveryMonitor$reportDeliveryCentralizeEvent$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Map $params;

    public MallDeliveryMonitor$reportDeliveryCentralizeEvent$1(Map r100) {
        this.$params = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        JSONObject r100 = new JSONObject();
        Iterator r101 = this.$params.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry r102 = (Map.Entry) r101.next();
        r100.putOpt((String) r102.getKey(), r102.getValue());
        goto L4
    L6:
        AppLogNewUtils.onEventV3("ec_mall_delivery_centralized", r100);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
