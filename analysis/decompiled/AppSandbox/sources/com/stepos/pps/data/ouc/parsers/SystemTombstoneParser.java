package com.stepos.pps.data.ouc.parsers;

import android.os.DropBoxManager;
import com.stepos.pps.data.ouc.DropBoxParseHelper;
import com.stepos.pps.data.ouc.ErrorInfo;
import com.stepos.pps.data.util.Constants;
import com.stepos.pps.data.util.LogUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SystemTombstoneParser extends DefaultParser {
    private static final String TAG = "PPS:SystemTombstoneParser";
    public static final List<String> includedProcesses;

    static {
        ArrayList arrayList = new ArrayList();
        includedProcesses = arrayList;
        arrayList.add(Constants.ANDROID_PROCESS);
        arrayList.add("surfaceflinger");
        arrayList.add("servicemanager");
        arrayList.add("netd");
    }

    @Override // com.stepos.pps.data.ouc.parsers.DefaultParser, com.stepos.pps.data.ouc.IDropBoxEntryParser
    public JSONObject parse(DropBoxManager.Entry entry) throws JSONException, IOException {
        JSONObject tombstone;
        JSONObject jSONObject = super.parse(entry);
        if (jSONObject.has("body") && (tombstone = DropBoxParseHelper.parseTombstone(jSONObject.getString("body"))) != null) {
            boolean z = false;
            if (tombstone.has("app")) {
                String string = tombstone.getString("app");
                Iterator<String> it = includedProcesses.iterator();
                while (it.hasNext()) {
                    if (string.contains(it.next())) {
                        z = true;
                    }
                }
            }
            if (z) {
                jSONObject.put("type", ErrorInfo.ERROR_TYPE_CRASH);
                String string2 = tombstone.getString("app");
                if (Constants.ANDROID_PROCESS.equals(string2)) {
                    jSONObject.put("Package", Constants.ANDROID_PACKAGE);
                } else {
                    jSONObject.put("Package", string2.substring(string2.lastIndexOf("/") + 1));
                }
                jSONObject.put("Process", tombstone.getString("app"));
                if (tombstone.has("backtrace")) {
                    jSONObject.put("tag", tombstone.getString("backtrace"));
                }
                if (tombstone.has("PID")) {
                    jSONObject.put("PID", tombstone.getString("PID"));
                    return jSONObject;
                }
            } else {
                LogUtil.d(TAG, "ignore not interested process");
                throw new JSONException("ignore not interested process");
            }
        }
        return jSONObject;
    }
}
