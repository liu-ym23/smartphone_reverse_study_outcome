package com.bytedance.android.ec.core.event;

import com.bytedance.android.btm.api.model.PageFinder;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: loaded from: classes43.dex */
public interface c {
    void appendEventParams(Map<String, String> r100);

    void appendEventParams(Pair<String, String>... r100);

    void bindMonitorId(Long r100);

    void clearEventParams();

    void doAnyEventAction(String r100, Map<String, ? extends Object> r101, Pair<String, ? extends Object>... r102);

    void doAnyEventActionWithBtm(String r100, PageFinder r101, String r102, Map<String, ? extends Object> r103, Pair<String, ? extends Object>... r104);

    void doEventAction(String r100, String r101, PageFinder r102, Map<String, String> r103);

    void doEventAction(String r100, String r101, PageFinder r102, Pair<String, String>... r103);

    void doEventAction(String r100, Map<String, String> r101, Pair<String, String>... r102);

    void doEventAction(String r100, Pair<String, String>... r101);

    Map<String, String> getBaseParams();

    String getBaseParamsJson();

    void initEventContext(Map<String, String> r100);

    void initEventContext(Pair<String, String>... r100);
}
