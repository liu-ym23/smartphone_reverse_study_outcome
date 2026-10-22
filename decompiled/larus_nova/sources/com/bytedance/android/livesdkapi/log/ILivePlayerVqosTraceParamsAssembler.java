package com.bytedance.android.livesdkapi.log;

import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\u0006H&¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/log/ILivePlayerVqosTraceParamsAssembler;", "", "assembleLivePlayerParams", "", "", "calculateFirstFrameCostInfo", "", "getLivePlayerTraceParams", "key", "init", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePlayerVqosTraceParamsAssembler {
    Map<String, String> assembleLivePlayerParams();

    void calculateFirstFrameCostInfo();

    String getLivePlayerTraceParams(String r100);

    void init();
}
