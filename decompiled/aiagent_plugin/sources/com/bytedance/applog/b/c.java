package com.bytedance.applog.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.applog.util.p;
import com.bytedance.bdinstall.aa;
import com.bytedance.bdinstall.ab;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: CustomHeaderAdapter.java */
/* JADX INFO: loaded from: classes.dex */
final class c implements ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<String> f5539a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.applog.c f5540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile SharedPreferences f5541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile JSONObject f5542d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final aa f5543e;

    static {
        f5539a = Collections.singletonList("CustomHeaderAdapter");
    }

    c(com.bytedance.applog.c r3, aa r4) {
        aa r5 = (aa) ZeusTransformUtils.wrapperContextForParams(r4, aa.class, "com.obric.aiagent.plugin");
        this.f5540b = r3;
        this.f5543e = r5;
    }

    @Override // com.bytedance.bdinstall.ab
    public Map<String, Object> a() {
        JSONObject r5 = b();
        if (r5 == null) goto L5;
        HashMap r0 = new HashMap();
        Iterator<String> r1 = r5.keys();
    L8:
        if (r1.hasNext() == false) goto L12;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L8;
        r0.put(r2, r5.opt(r2));
        goto L8
    L12:
        return r0;
    L5:
        return Collections.emptyMap();
    }

    public void a(Map<String, Object> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L5;
        return;
    L5:
        if (r8.isEmpty() == false) goto L26;
        return;
    L26:
        JSONObject r2 = b();     // Catch: Throwable -> L23
        if (p.a(r8, r2) == true) goto L12;
        this.f5540b.Z().b(f5539a, "appendHeaderInfo no value changed", new Object[0]);     // Catch: Throwable -> L23
        return;
    L12:
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L23
        if (r2 == null) goto L15;
        p.b(r3, r2);     // Catch: Throwable -> L23
    L15:
        Iterator r9 = r8.entrySet().iterator();     // Catch: Throwable -> L23
    L17:
        if (r9.hasNext() == false) goto L21;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
        if (p.a((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.aiagent.plugin")) == false) goto L17;
        r3.put((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.aiagent.plugin"), r4.getValue());     // Catch: Throwable -> L23
        goto L17
    L21:
        a(r3);     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        this.f5540b.Z().a(f5539a, "appendHeaderInfo failed", th, new Object[0]);
    }

    private void a(JSONObject r4) {
        this.f5542d = r4;
        SharedPreferences r0 = c();
        if (r0 == null) goto L9;
        SharedPreferences.Editor r1 = r0.edit();
        if (r4 == null) goto L7;
        String r2 = r4.toString();
    L8:
        r1.putString("header_custom_info", r2).apply();
        goto L9
    L7:
        r2 = "";
    L9:
        this.f5543e.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f5540b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4);
    }

    private JSONObject b() {
        if (this.f5542d != null) goto L14;
        SharedPreferences r0 = c();     // Catch: Throwable -> L11
        if (r0 == null) goto L15;
        String r1 = r0.getString("header_custom_info", null);     // Catch: Throwable -> L11
        if (p.a(r1) == false) goto L9;
        this.f5542d = new JSONObject(r1);     // Catch: Throwable -> L11
        goto L15
    L9:
        this.f5542d = new JSONObject();     // Catch: Throwable -> L11
    L15:
    L11:
        th = move-exception;
        this.f5540b.Z().a(f5539a, "getCustomInfo failed", th, new Object[0]);
    L14:
        return this.f5542d;
    }

    private SharedPreferences c() {
        if (this.f5541c != null) goto L8;
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f5540b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == null) goto L8;
        this.f5541c = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f5540b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSharedPreferences(com.bytedance.applog.b.a(this.f5540b, "header_custom"), 0);
    L8:
        return this.f5541c;
    }
}
