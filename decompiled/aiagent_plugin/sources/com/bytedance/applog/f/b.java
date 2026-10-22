package com.bytedance.applog.f;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.applog.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventForwardLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static a a(c r3, JSONObject r4) {
        JSONObject r5 = r4.optJSONObject("applog_forward");
        if (r5 != null) goto L6;
        return null;
    L6:
        a r6 = a.a(r5);
        SharedPreferences.Editor r7 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSharedPreferences(b(r3), 0).edit();
        r7.putInt("version", r6.a());
        r7.putLong("interval", r6.b());
        r7.putStringSet("events", r6.c());
        r7.putString("forward_report_host", r6.d());
        r7.putString("forward_report_path", r6.e());
        r7.putInt("forward_open", r6.f());
        r7.apply();
        return r6;
    }

    public static a a(c r5) {
        a r0 = new a();
        SharedPreferences r6 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSharedPreferences(b(r5), 0);
        int r1 = r6.getInt("version", -1);
        if (r1 != (-1)) goto L6;
        return null;
    L6:
        r0.a(r1);
        r0.a(r6.getLong("interval", 60000));
        r0.a(r6.getStringSet("events", new HashSet()));
        r0.c(r6.getString("forward_report_path", ""));
        r0.b(r6.getString("forward_report_host", ""));
        r0.b(r6.getInt("forward_open", 0));
        return r0;
    }

    private static String b(c r1) {
        return com.bytedance.applog.b.a(r1, "applog_forward");
    }
}
