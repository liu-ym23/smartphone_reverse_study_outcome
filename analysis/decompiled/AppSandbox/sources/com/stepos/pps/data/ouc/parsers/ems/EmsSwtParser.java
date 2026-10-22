package com.stepos.pps.data.ouc.parsers.ems;

import android.os.DropBoxManager;
import com.stepos.pps.data.ouc.ErrorInfo;
import com.stepos.pps.data.util.Constants;
import com.stepos.pps.reflect.ExceptionManagerStepOS;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class EmsSwtParser extends EmsDefaultParser {
    private static final String TAG = "PPS:EmsSwtParser";

    @Override // com.stepos.pps.data.ouc.parsers.ems.EmsDefaultParser, com.stepos.pps.data.ouc.parsers.DefaultParser, com.stepos.pps.data.ouc.IDropBoxEntryParser
    public JSONObject parse(DropBoxManager.Entry entry) throws JSONException, IOException {
        JSONObject jSONObject = super.parse(entry);
        if (jSONObject.has(ExceptionManagerStepOS.SUBJECT)) {
            jSONObject.put("tag", jSONObject.getString(ExceptionManagerStepOS.SUBJECT));
        }
        jSONObject.put("type", ErrorInfo.ERROR_TYPE_WATCHDOG);
        jSONObject.put("Package", Constants.ANDROID_PACKAGE);
        jSONObject.put("Process", Constants.ANDROID_PROCESS);
        return jSONObject;
    }
}
