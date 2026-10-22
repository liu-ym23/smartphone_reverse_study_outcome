package com.bytedance.android.livesdkapi.log;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H&J$\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0007H&J\b\u0010\b\u001a\u00020\tH&J$\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0007H&J$\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0007H&J$\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0007H&J,\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u00072\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0016\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0003H&J$\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0007H&J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\u0016\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\tH&¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/log/ILivePlayerLoggerAssembler;", "Lcom/bytedance/android/livesdkapi/log/ILivePlayerVqosTraceParamsAssembler;", "assembleCellularParams", "", "", "assembleFullParams", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "assembleFullParamsJson", "Lorg/json/JSONObject;", "assembleNpthParams", "assembleSimplifyParams", "assembleTeaParams", "assembleTimeCostParams", "startPullTime", "", "assembleTraceIndexes", "", "assembleUsedParams", "fillBusinessParamsToVqosTrace", "", "event", "fillUsedBusinessParamsToVqosTrace", "updateBusinessParamsToVqosTrace", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePlayerLoggerAssembler extends ILivePlayerVqosTraceParamsAssembler {
    Map<String, String> assembleCellularParams();

    HashMap<String, String> assembleFullParams();

    JSONObject assembleFullParamsJson();

    HashMap<String, String> assembleNpthParams();

    HashMap<String, String> assembleSimplifyParams();

    HashMap<String, String> assembleTeaParams();

    HashMap<String, String> assembleTimeCostParams(long r100);

    Map<String, Object> assembleTraceIndexes();

    HashMap<String, String> assembleUsedParams();

    void fillBusinessParamsToVqosTrace(JSONObject r100);

    void fillUsedBusinessParamsToVqosTrace(JSONObject r100);

    void updateBusinessParamsToVqosTrace(JSONObject r100);
}
