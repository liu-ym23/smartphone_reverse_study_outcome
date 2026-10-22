package com.stepos.pps.data.ouc.parsers;

import android.os.DropBoxManager;
import com.stepos.pps.data.ouc.DropBoxParseHelper;
import com.stepos.pps.data.ouc.ErrorInfo;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class CrashParser extends DefaultParser {
    private static final String TAG = "PPS:CrashParser";

    @Override // com.stepos.pps.data.ouc.parsers.DefaultParser, com.stepos.pps.data.ouc.IDropBoxEntryParser
    public JSONObject parse(DropBoxManager.Entry entry) throws JSONException, IOException {
        JSONObject jSONObject = super.parse(entry);
        String tag = entry.getTag();
        if (jSONObject.has("body")) {
            if (tag.contains(ErrorInfo.ERROR_TYPE_NATIVE_CRASH)) {
                JSONObject tombstone = DropBoxParseHelper.parseTombstone(jSONObject.getString("body"));
                if (tombstone.has("backtrace")) {
                    jSONObject.put("tag", tombstone.getString("backtrace"));
                    return jSONObject;
                }
            } else {
                jSONObject.put("tag", jSONObject.getString("body"));
            }
        }
        return jSONObject;
    }
}
