package com.stepos.pps.data.ouc;

import android.os.DropBoxManager;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public interface IDropBoxEntryParser {
    JSONObject parse(DropBoxManager.Entry entry) throws JSONException, IOException;
}
