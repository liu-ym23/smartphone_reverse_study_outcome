package com.bytedance.android.annie.bridge.method;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class c1 implements n56.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Context> f38579a;

    public c1(WeakReference<Context> r100) {
        this.f38579a = r100;
    }

    @Override // n56.c
    public void call(n56.f r100, JSONObject r101) throws Exception {
        r101.put("code", 0);
        String r102 = r100.f518032d.optString("type");
        if (TextUtils.isEmpty(r102) == false) goto L7;
        r101.put("code", 0);
        return;
    L7:
        if (r100.f518032d.has("args") == false) goto L9;
        JSONObject r103 = JSONObjectProtectorUtils.getJSONObject(r100.f518032d, "args");
    L11:
        if ("scheme".equals(r102) == false) goto L18;
        if (r103 != null) goto L14;
        r101.put("code", 0);
        return;
    L14:
        String r104 = JSONObjectProtectorUtils.getString(r103, "url");
        Context r105 = this.f38579a.get();
        if (r105 == null) goto L20;
        w9.a.f558719a.j0(r105, UriProtector.parse(r104), null, null);
        return;
    L20:
        return;
    L18:
        return;
    L9:
        r103 = null;
        goto L11
    }
}
