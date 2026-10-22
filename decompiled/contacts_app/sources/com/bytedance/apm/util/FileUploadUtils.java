package com.bytedance.apm.util;

import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.IMultipartUploader;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class FileUploadUtils {
    public FileUploadUtils() {
    }

    public static HttpResponse uploadFiles(String r5, List<File> r6, Map<String, String> r7) {
        IHttpService r1 = (IHttpService) ServiceManager.getService(IHttpService.class);     // Catch: Exception -> L30
        if (r1 != null) goto L6;
        r1 = ApmContext.getHttpService();     // Catch: Exception -> L30
    L6:
        IMultipartUploader r8 = r1.buildMultipartUpload(r5, "UTF-8", false);     // Catch: Exception -> L30
        if (r6 != null) goto L9;
    L16:
        if (r7 != null) goto L18;
    L23:
        String r9 = new String(r8.finish().getResponseBytes());     // Catch: Exception -> L30
        if (TextUtils.isEmpty(r9) == true) goto L29;
        JSONObject r10 = new JSONObject(r9);     // Catch: JSONException -> L27 Exception -> L30
        return new HttpResponse(r10.optInt("error_code", 0), r10.optString("message", "").getBytes());
    L27:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L30
        goto L29
    L18:
        if (r7.isEmpty() == true) goto L23;
        Iterator<Map.Entry<String, String>> r11 = r7.entrySet().iterator();     // Catch: Exception -> L30
    L21:
        if (r11.hasNext() == false) goto L23;
        Map.Entry<String, String> r12 = r11.next();     // Catch: Exception -> L30
        r8.addFormField(r12.getKey(), r12.getValue());     // Catch: Exception -> L30
        goto L21
    L9:
        if (r6.isEmpty() == true) goto L16;
        Iterator<File> r13 = r6.iterator();     // Catch: Exception -> L30
    L12:
        if (r13.hasNext() == false) goto L16;
        File r2 = r13.next();     // Catch: Exception -> L30
        if (r2.exists() == false) goto L12;
        HashMap r3 = new HashMap();     // Catch: Exception -> L30
        r8.addFilePart(r2.getName(), r2, null, r3);     // Catch: Exception -> L30
    L29:
        return null;
    }
}
