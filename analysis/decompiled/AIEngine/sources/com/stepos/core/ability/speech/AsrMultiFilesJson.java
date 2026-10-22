package com.stepos.core.ability.speech;

import com.stepos.core.ability.speech.AsrFileResult;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import v6.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrMultiFilesJson {
    public static final AsrMultiFilesJson INSTANCE = new AsrMultiFilesJson();

    private AsrMultiFilesJson() {
    }

    private final JSONArray utterancesToSegments(List<AsrFileResult.Utterance> list, long j10) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        if (!list.isEmpty()) {
            for (AsrFileResult.Utterance utterance : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("start", utterance.getStartTime() + j10);
                jSONObject.put("end", utterance.getEndTime() + j10);
                jSONObject.put("sentence", utterance.getText());
                String speakerId = utterance.getSpeakerId();
                if (speakerId != null) {
                    jSONObject.put("speaker_id", speakerId);
                }
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }

    public final String fileError(int i10, String error) {
        kotlin.jvm.internal.g.f(error, "error");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("multi_files_event", "file_error");
        jSONObject.put("multi_files_index", i10);
        jSONObject.put(AsrSseEvent.TYPE_ERROR, error);
        String string = jSONObject.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        return string;
    }

    public final String fileResult(int i10, AsrFileResult result, long j10) {
        kotlin.jvm.internal.g.f(result, "result");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("multi_files_event", "file_result");
        jSONObject.put("multi_files_index", i10);
        jSONObject.put("text", result.getText());
        jSONObject.put("duration", result.getDuration());
        jSONObject.put("time_offset_ms", j10);
        jSONObject.put("language", "zh");
        jSONObject.put("emotion", "");
        jSONObject.put("event", "");
        jSONObject.put("withitn", true);
        jSONObject.put("segments", INSTANCE.utterancesToSegments(result.getUtterances(), j10));
        String string = jSONObject.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        return string;
    }

    public final String finalMerged(List<c.b> items, Map<Integer, AsrFileResult> results) throws JSONException {
        kotlin.jvm.internal.g.f(items, "items");
        kotlin.jvm.internal.g.f(results, "results");
        StringBuilder sb2 = new StringBuilder();
        JSONArray jSONArray = new JSONArray();
        int size = items.size();
        String str = "";
        for (int i10 = 0; i10 < size; i10++) {
            AsrFileResult asrFileResult = results.get(Integer.valueOf(i10));
            if (asrFileResult != null) {
                sb2.append(asrFileResult.getText());
                if (str.length() == 0) {
                    str = "zh";
                }
                JSONArray jSONArrayUtterancesToSegments = utterancesToSegments(asrFileResult.getUtterances(), items.get(i10).f13395b);
                int length = jSONArrayUtterancesToSegments.length();
                for (int i11 = 0; i11 < length; i11++) {
                    jSONArray.put(jSONArrayUtterancesToSegments.getJSONObject(i11));
                }
            }
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("multi_files_event", "final");
        jSONObject.put("text", sb2.toString());
        jSONObject.put("language", str);
        jSONObject.put("emotion", "");
        jSONObject.put("event", "");
        jSONObject.put("withitn", true);
        jSONObject.put("segments", jSONArray);
        String string = jSONObject.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        return string;
    }
}
