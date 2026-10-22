package com.bytedance.apm.util;

import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.IMultipartUploader;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {
    public static i6.c a(String r10, List r11, Map r12) {
        IHttpService r13 = (IHttpService) n5.b.a(IHttpService.class);     // Catch: Exception -> L30
        if (r13 != null) goto L6;
        r13 = w0.c.l();     // Catch: Exception -> L30
    L6:
        IMultipartUploader r14 = r13.buildMultipartUpload(r10, "UTF-8", false);     // Catch: Exception -> L30
        if (r11 != null) goto L9;
    L16:
        if (r12 != null) goto L18;
    L23:
        String r15 = new String(r14.finish().b());     // Catch: Exception -> L30
        if (TextUtils.isEmpty(r15) == true) goto L29;
        JSONObject r16 = new JSONObject(r15);     // Catch: JSONException -> L27 Exception -> L30
        return new i6.c(r16.optInt(WsConstants.ERROR_CODE, 0), r16.optString("message", "").getBytes());
    L27:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L30
        goto L29
    L18:
        if (r12.isEmpty() == true) goto L23;
        Iterator r17 = r12.entrySet().iterator();     // Catch: Exception -> L30
    L21:
        if (r17.hasNext() == false) goto L23;
        Map.Entry r18 = (Map.Entry) r17.next();     // Catch: Exception -> L30
        r14.addFormField((String) r18.getKey(), (String) r18.getValue());     // Catch: Exception -> L30
        goto L21
    L9:
        if (r11.isEmpty() == true) goto L16;
        Iterator r19 = r11.iterator();     // Catch: Exception -> L30
    L12:
        if (r19.hasNext() == false) goto L16;
        File r20 = (File) r19.next();     // Catch: Exception -> L30
        if (r20.exists() == false) goto L12;
        HashMap r21 = new HashMap();     // Catch: Exception -> L30
        r14.addFilePart(r20.getName(), r20, null, r21);     // Catch: Exception -> L30
    L29:
        return null;
    }
}
