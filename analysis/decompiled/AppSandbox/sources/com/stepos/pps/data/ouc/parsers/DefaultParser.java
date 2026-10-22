package com.stepos.pps.data.ouc.parsers;

import android.os.DropBoxManager;
import com.stepos.pps.data.ouc.DropBoxParseHelper;
import com.stepos.pps.data.ouc.ErrorInfo;
import com.stepos.pps.data.ouc.IDropBoxEntryParser;
import com.stepos.pps.data.util.Constants;
import com.stepos.pps.data.util.LogUtil;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class DefaultParser implements IDropBoxEntryParser {
    private static final String TAG = "PPS:DefaultParser";

    @Override // com.stepos.pps.data.ouc.IDropBoxEntryParser
    public JSONObject parse(DropBoxManager.Entry entry) throws JSONException, IOException {
        String tag = entry.getTag();
        LogUtil.d(TAG, "tag = " + tag + ", flags = " + entry.getFlags());
        JSONObject jSONObject = DropBoxParseHelper.parse(entry);
        jSONObject.put("tag", tag.toLowerCase());
        jSONObject.put("type", tag);
        jSONObject.put("dropBoxTag", tag);
        if (jSONObject.has("Package")) {
            jSONObject.put("Package", jSONObject.getString("Package").split(" ", 2)[0]);
            return jSONObject;
        }
        if (Constants.ANDROID_PROCESS.equals(jSONObject.has("Process") ? jSONObject.getString("Process") : "")) {
            jSONObject.put("Package", Constants.ANDROID_PACKAGE);
        }
        return jSONObject;
    }

    private String getType(String str) {
        if (str.contains(ErrorInfo.ERROR_TYPE_ANR)) {
            return ErrorInfo.ERROR_TYPE_ANR;
        }
        if (str.contains(ErrorInfo.ERROR_TYPE_CRASH) || str.contains("je") || str.contains("ne") || str.contains("tombstone")) {
            return ErrorInfo.ERROR_TYPE_CRASH;
        }
        if (str.contains(ErrorInfo.ERROR_TYPE_WATCHDOG) || str.contains("swt")) {
            return ErrorInfo.ERROR_TYPE_WATCHDOG;
        }
        if (str.contains(ErrorInfo.ERROR_TYPE_SYS_RESTART)) {
            return ErrorInfo.ERROR_TYPE_SYS_RESTART;
        }
        return null;
    }
}
