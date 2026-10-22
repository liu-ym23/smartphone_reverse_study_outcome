package com.stepos.pps.data.ouc.parsers.ems;

import android.os.DropBoxManager;
import com.stepos.pps.data.ouc.ErrorInfo;
import com.stepos.pps.data.ouc.parsers.DefaultParser;
import com.stepos.pps.data.util.LogUtil;
import com.stepos.pps.reflect.ExceptionManagerStepOS;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import stepos.com.android.os.StatsLogEnums;

/* loaded from: classes.dex */
public class EmsDefaultParser extends DefaultParser {
    public static final String SPLIT_LINE = "\n====================================================================================================\n";
    private static final String TAG = "PPS:EmsDefaultParser";

    @Override // com.stepos.pps.data.ouc.parsers.DefaultParser, com.stepos.pps.data.ouc.IDropBoxEntryParser
    public JSONObject parse(DropBoxManager.Entry entry) throws JSONException, IOException {
        String string;
        int iIndexOf;
        JSONObject jSONObject = super.parse(entry);
        if (jSONObject.has("ShouldUpload") && !jSONObject.getBoolean("ShouldUpload")) {
            LogUtil.i(TAG, "Do not need to upload this log!!! tag = " + entry.getTag());
            throw new JSONException("Do not need to upload this log");
        }
        if (jSONObject.has("body") && (iIndexOf = (string = jSONObject.getString("body")).indexOf(SPLIT_LINE)) > 0) {
            jSONObject.put(ExceptionManagerStepOS.SUBJECT, string.substring(0, iIndexOf));
            jSONObject.put("body", string.substring(iIndexOf + StatsLogEnums.InvalidConfigReasonEnum.INVALID_CONFIG_REASON_VALUE_METRIC_HIST_GENERATED_BINS_INVALID_MIN_MAX_VALUE));
        }
        if (jSONObject.has(ExceptionManagerStepOS.SUBJECT)) {
            jSONObject.put("tag", buildTagWithPrefix(entry.getTag(), jSONObject.getString(ExceptionManagerStepOS.SUBJECT)));
        }
        if (!jSONObject.has("type")) {
            jSONObject.put("type", ErrorInfo.ERROR_TYPE_EMS);
        }
        if (jSONObject.has("ZipLogFile")) {
            jSONObject.put("extFile", new File(jSONObject.getString("ZipLogFile")));
        }
        return jSONObject;
    }

    private String buildTagWithPrefix(String str, String str2) {
        return "[[ " + str + " ]]  \n\n" + str2;
    }
}
