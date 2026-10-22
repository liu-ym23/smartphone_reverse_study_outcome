package com.stepos.pps.data.ouc.parsers;

import android.os.DropBoxManager;
import com.stepos.pps.reflect.ExceptionManagerStepOS;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AnrParser extends DefaultParser {
    private static final String TAG = "PPS:AnrParser";

    @Override // com.stepos.pps.data.ouc.parsers.DefaultParser, com.stepos.pps.data.ouc.IDropBoxEntryParser
    public JSONObject parse(DropBoxManager.Entry entry) throws JSONException, IOException {
        JSONObject jSONObject = super.parse(entry);
        if (jSONObject.has(ExceptionManagerStepOS.SUBJECT)) {
            jSONObject.put("tag", jSONObject.getString(ExceptionManagerStepOS.SUBJECT));
        }
        return jSONObject;
    }
}
