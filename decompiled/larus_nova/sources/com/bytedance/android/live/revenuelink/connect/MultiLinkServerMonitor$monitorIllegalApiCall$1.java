package com.bytedance.android.live.revenuelink.connect;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lorg/json/JSONObject;", "Lcom/bytedance/revenue/platform/api/core/JSONObject;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
final class MultiLinkServerMonitor$monitorIllegalApiCall$1 extends Lambda implements Function1<JSONObject, Unit> {
    public static final MultiLinkServerMonitor$monitorIllegalApiCall$1 INSTANCE = null;

    static {
        INSTANCE = new MultiLinkServerMonitor$monitorIllegalApiCall$1();
    }

    public MultiLinkServerMonitor$monitorIllegalApiCall$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(JSONObject r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
