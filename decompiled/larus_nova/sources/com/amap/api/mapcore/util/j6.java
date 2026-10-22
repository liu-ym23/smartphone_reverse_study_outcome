package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
final class j6 implements o5.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private k6 f27462a;

    @Override // com.amap.api.mapcore.util.o5.d
    public final String a() {
        int r100 = k6.f27506h;
        return null;
    }

    @Override // com.amap.api.mapcore.util.o5.d
    public final Map<String, String> b() {
        return this.f27462a.a();
    }

    public j6() {
        this.f27462a = new k6();
    }

    @Override // com.amap.api.mapcore.util.o5.d
    public final String a(Context r100, String r101) {
        JSONObject r102 = new JSONObject(r101);     // Catch: JSONException -> L8
        if (r102.optInt(x5.b("UY29kZQ")) != 1) goto L10;
        String r103 = new JSONObject(r102.optString(x5.b("FZGF0YQ"))).optString(x5.b("FYWRpdQ"));     // Catch: JSONException -> L8
        if (TextUtils.isEmpty(r103) == true) goto L10;
        f6.a(r100).a(r103);     // Catch: JSONException -> L8
        return r103;
    L10:
        return "";
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    @Override // com.amap.api.mapcore.util.o5.d
    public final y7 a(byte[] r100, Map<String, String> r101) {
        return new q7(r100, r101);
    }

    @Override // com.amap.api.mapcore.util.o5.d
    public final String a(String r100, String r101, String r102, String r103) {
        return this.f27462a.a(r100, r101, r102, r103);
    }
}
