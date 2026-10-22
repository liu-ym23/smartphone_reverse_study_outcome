package com.bytedance.android.shopping.prepurchase.arch.container.intf;

import com.bytedance.android.btm.api.model.PageFinder;
import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: loaded from: classes13.dex */
public interface h {
    void appendEventParams(Pair<String, ? extends Object>... r100);

    Map<String, Object> getEventParams();

    void o(String r100);

    void p(LinkedTreeMap r100);

    void q(String r100, PageFinder r101, Map<String, ? extends Object> r102);
}
