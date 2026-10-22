package com.bytedance.apm6.service.perf;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface IPerfFilterManager {
    void addPerfTag(String r10, String r11);

    ConcurrentHashMap<String, String> getPerfFilters();

    JSONObject getPerfFiltersJson();

    JSONObject getRealTimeMemInfo();

    CopyOnWriteArraySet<String> getSceneSet();

    String getSceneString();

    void removePerfTag(String r10, String r11);

    void startScene(String r10);

    void stopScene(String r10);
}
