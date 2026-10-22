package com.ss.android.common.applog;

import android.content.Context;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ApplogHeaderUtils.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static String[] f37163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static String[] f37164b;

    static {
        f37163a = new String[]{"mc", "build_serial", "aliyun_uuid", "udid", "serial_number", "sim_serial_number"};
        f37164b = new String[a.i.length + 6];
        System.arraycopy(a.i, 0, f37164b, 0, a.i.length);
        System.arraycopy(f37163a, 0, f37164b, a.i.length + 0, f37163a.length);
    }

    public static void a(Context r2, JSONObject r3) {
        String r4 = com.ss.android.deviceregister.base.n.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).a();
        if (TextUtils.isEmpty(r4) == true) goto L6;
        r3.put("oaid", r4);
        return;
    }

    public static JSONObject b(Context r2, JSONObject r3) {
        String r4 = com.ss.android.deviceregister.base.n.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).a();
        if (TextUtils.isEmpty(r4) == true) goto L14;
        JSONObject r0 = new JSONObject(r3, f37164b);     // Catch: JSONException -> L9
        r0.put("oaid", r4);     // Catch: JSONException -> L8
    L7:
        return r0;
    L15:
        return r3;
    L14:
        return r3;
    }
}
