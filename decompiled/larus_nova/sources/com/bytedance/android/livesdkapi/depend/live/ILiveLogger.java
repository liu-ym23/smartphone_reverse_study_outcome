package com.bytedance.android.livesdkapi.depend.live;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public interface ILiveLogger {
    Map<String, String> getFilterParamsByName(String r100);

    JSONObject getLiveAlogCommonParams();

    Map<String, String> getLiveLogCommonFilterParams(String r100);

    void hostDataMapping(Map<String, String> r100);
}
