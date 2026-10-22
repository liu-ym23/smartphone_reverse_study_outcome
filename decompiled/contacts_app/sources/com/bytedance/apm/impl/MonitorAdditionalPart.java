package com.bytedance.apm.impl;

import android.text.TextUtils;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.ss.android.http.legacy.protocol.HTTP;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class MonitorAdditionalPart implements TypedOutput {
    private final String commonParams;
    private Map<String, String> extraDispositionMap;
    private final String fileName;

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String md5Stub() {
        return null;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String mimeType() {
        return HTTP.PLAIN_TEXT_TYPE;
    }

    public MonitorAdditionalPart(String r1, String r2, Map<String, String> r3) {
        this.fileName = r1;
        this.extraDispositionMap = r3;
        if (TextUtils.isEmpty(r2) == false) goto L7;
        JSONObject r4 = new JSONObject();
        r4.put("defaultData", "none commonParams");     // Catch: JSONException -> L9
    L6:
        this.commonParams = r4.toString();
        return;
    L7:
        this.commonParams = r2;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String fileName() {
        return buildFileName(this.fileName, this.extraDispositionMap);
    }

    private String buildFileName(String r4, Map<String, String> r5) {
        StringBuilder r3 = new StringBuilder(r4).append("\"");
        Iterator<Map.Entry<String, String>> r6 = r5.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Map.Entry<String, String> r0 = r6.next();
        String r1 = r0.getKey();
        r3.append("; ").append(r1).append("=\"").append(r0.getValue()).append("\"");
        goto L4
    L6:
        r3.deleteCharAt(r3.length() - 1);
        return r3.toString();
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public long length() {
        return this.commonParams.getBytes().length;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public void writeTo(OutputStream r1) throws IOException {
        r1.write(this.commonParams.getBytes());
    }
}
