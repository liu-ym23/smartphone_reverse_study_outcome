package com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.handler;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\n¢\u0006\u0002\b\f"}, d2 = {"<anonymous>", "", "stageName", "", "schema", "sessionId", "timestamp", "", "triggerSource", ControlRule.KEY_EXTRA_DATA, "", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ECDeliverySessionStageHandler$defaultAction$1 extends Lambda implements Function6<String, String, String, Double, String, Map<String, ? extends Object>, Unit> {
    final /* synthetic */ b this$0;

    public ECDeliverySessionStageHandler$defaultAction$1(b r100) {
        super(6);
    }

    @Override // kotlin.jvm.functions.Function6
    public /* bridge */ /* synthetic */ Unit invoke(String r100, String r110, String r111, Double r112, String r113, Map<String, ? extends Object> r114) {
        invoke(r100, r110, r111, r112.doubleValue(), r113, r114);
        return Unit.INSTANCE;
    }

    public final void invoke(String r100, String r101, String r102, double r103, String r104, Map<String, ? extends Object> r105) {
        Intrinsics.checkNotNullParameter(r100, "stageName");
        Intrinsics.checkNotNullParameter(r101, "schema");
        Intrinsics.checkNotNullParameter(r102, "sessionId");
        Intrinsics.checkNotNullParameter(r104, "triggerSource");
        throw null;
    }
}
