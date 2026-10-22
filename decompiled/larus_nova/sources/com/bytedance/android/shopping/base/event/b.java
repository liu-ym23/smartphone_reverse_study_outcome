package com.bytedance.android.shopping.base.event;

import com.bytedance.android.btm.api.model.PageFinder;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: loaded from: classes13.dex */
public interface b {
    void appendEventParamToEntranceInfo(String r100, String r101);

    void appendEventParams(Map<String, ? extends Object> r100);

    void appendEventParams(Pair<String, ? extends Object>... r100);

    void clearEventParams();

    void doEventAction(String r100, PageFinder r101, Map<String, ? extends Object> r102);

    void doEventAction(String r100, PageFinder r101, Pair<String, ? extends Object>... r102);

    void doEventAction(String r100, Map<String, ? extends Object> r101);

    void doEventAction(String r100, Pair<String, ? extends Object>... r101);

    Map<String, Object> getEventParams();

    void initEventContext(Map<String, ? extends Object> r100);

    void initEventContext(Pair<String, ? extends Object>... r100);
}
