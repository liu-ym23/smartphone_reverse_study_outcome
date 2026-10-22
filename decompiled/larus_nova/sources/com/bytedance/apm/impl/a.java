package com.bytedance.apm.impl;

import android.text.TextUtils;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class a implements TypedOutput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f190560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f190561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f190562c;

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public final String md5Stub() {
        return null;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public final String mimeType() {
        return "text/plain";
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public final String fileName() {
        String r100 = this.f190560a;
        Map<String, String> r101 = this.f190561b;
        StringBuilder r102 = new StringBuilder(r100);
        r102.append("\"");
        Iterator<Map.Entry<String, String>> r103 = r101.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Map.Entry<String, String> r104 = r103.next();
        String r105 = r104.getKey();
        String r106 = r104.getValue();
        r102.append("; ");
        r102.append(r105);
        r102.append("=\"");
        r102.append(r106);
        r102.append("\"");
        goto L4
    L6:
        r102.deleteCharAt(r102.length() - 1);
        return r102.toString();
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public final long length() {
        return this.f190562c.getBytes().length;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public final void writeTo(OutputStream r100) throws IOException {
        r100.write(this.f190562c.getBytes());
    }

    public a(String r100, Map r101) {
        this.f190560a = "params.txt";
        this.f190561b = r101;
        if (TextUtils.isEmpty(r100) == false) goto L7;
        JSONObject r102 = new JSONObject();
        r102.put("defaultData", "none commonParams");     // Catch: JSONException -> L9
    L6:
        this.f190562c = r102.toString();
        return;
    L7:
        this.f190562c = r100;
    }
}
