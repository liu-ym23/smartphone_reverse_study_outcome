package com.stepos.pps.data.ouc.parsers;

import android.os.DropBoxManager;
import com.stepos.pps.data.util.Constants;
import java.io.IOException;
import java.text.SimpleDateFormat;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SystemRestartParser extends DefaultParser {
    private static final String TAG = "PPS:SystemRestartParser";

    @Override // com.stepos.pps.data.ouc.parsers.DefaultParser, com.stepos.pps.data.ouc.IDropBoxEntryParser
    public JSONObject parse(DropBoxManager.Entry entry) throws JSONException, IOException {
        JSONObject jSONObject = super.parse(entry);
        jSONObject.put("tag", entry.getTag() + " \n\n :" + new SimpleDateFormat("yyyyMMddHHmmss").format(Long.valueOf(entry.getTimeMillis())));
        jSONObject.put("Package", Constants.ANDROID_PACKAGE);
        jSONObject.put("Process", Constants.ANDROID_PROCESS);
        return jSONObject;
    }
}
