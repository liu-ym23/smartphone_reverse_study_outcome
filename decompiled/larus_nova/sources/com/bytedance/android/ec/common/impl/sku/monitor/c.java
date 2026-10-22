package com.bytedance.android.ec.common.impl.sku.monitor;

import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.core.monitor.listener.ActionRateListener;
import com.bytedance.android.ec.model.sku.SkuParams;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class c {
    public c(SkuParams r100) {
        Intrinsics.checkNotNullParameter(r100, "skuParams");
        Set<String> r101 = ECProcessMonitor.f45118a;
        com.bytedance.android.ec.core.monitor.listener.e r102 = ECProcessMonitor.p();
        JSONObject r103 = new JSONObject();
        r103.put("EVENT_PAGE_TECHNOLOGY", "Native_Android");
        r103.put("scene_type", r100.getSceneType());
        r103.put("action_type", r100.getActionType());
        int r104 = qf.a.f532712a;
        r103.put("use_new_api", qf.a.e.a(r100));
        Unit r105 = Unit.INSTANCE;
        ActionRateListener.c(r102, r103, null, false, 6);
    }
}
