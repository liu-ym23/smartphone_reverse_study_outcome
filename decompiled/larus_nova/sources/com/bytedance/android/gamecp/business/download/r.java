package com.bytedance.android.gamecp.business.download;

import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class r {
    public static final String a(String r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        if (r100.length() != 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L16;
        return new JSONObject(r100).optString(BindCardPayConfirmConstants.Key.TRACE_ID);
    L17:
        return "";
    L16:
        return "";
    L7:
        r101 = false;
        goto L8
    }
}
