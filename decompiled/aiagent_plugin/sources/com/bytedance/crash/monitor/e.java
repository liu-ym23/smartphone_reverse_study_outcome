package com.bytedance.crash.monitor;

import com.bytedance.crash.config.ConfigManager;
import com.bytedance.crash.o.r;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventConfigService.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements com.bytedance.crash.config.b {
    private static final String TAG = "NPTH-Config";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConfigManager f7588a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected f f7589d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected com.bytedance.crash.d.g f7590e;
    protected com.bytedance.crash.d.d f;

    public e(f r1) {
        this.f7589d = r1;
        ConfigManager r2 = a();
        this.f7588a = r2;
        r2.a(this);
    }

    public ConfigManager a() {
        return new ConfigManager(this.f7589d);
    }

    public void h() {
        this.f7588a.a();
    }

    public com.bytedance.crash.d.g i() {
        return this.f7590e;
    }

    public com.bytedance.crash.d.d j() {
        return this.f;
    }

    public void b(JSONObject r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        HashSet r0 = new HashSet();
        JSONObject r1 = null;
        JSONObject r7 = r6.optJSONObject("custom_event_settings");
        if (r7 == null) goto L7;
        r1 = r7.optJSONObject("allow_service_name");
    L7:
        if (r1 == null) goto L14;
        Iterator<String> r8 = r1.keys();
    L10:
        if (r8.hasNext() == false) goto L14;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin");
        if (r1.optInt(r2) != 1) goto L10;
        r0.add(r2);
    L14:
        this.f7590e = new com.bytedance.crash.d.g(r0);
    }

    private Set<String> d(JSONObject r5) {
        HashSet r4 = new HashSet();
        JSONObject r6 = r5.optJSONObject("custom_event_settings");
        if (r6 == null) goto L5;
        JSONObject r7 = r6.optJSONObject("allow_log_type");
    L6:
        if (r7 == null) goto L13;
        Iterator<String> r0 = r7.keys();
    L9:
        if (r0.hasNext() == false) goto L13;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");
        if (r7.optInt(r1) != 1) goto L9;
        r4.add(r1);
    L13:
        return r4;
    L5:
        r7 = null;
        goto L6
    }

    public void c(JSONObject r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        Set<String> r0 = d(r5);
        JSONObject r1 = new JSONObject();
        JSONObject r6 = r5.optJSONObject("exception_modules");
        boolean r2 = false;
        if (r6 == null) goto L12;
        JSONObject r7 = r6.optJSONObject("exception");
        if (r7 == null) goto L12;
        if (r7.optInt("enable_upload") != 1) goto L11;
        r2 = true;
    L11:
        r1 = r7.optJSONObject("metric_sampling");
    L12:
        this.f = new com.bytedance.crash.d.d(r0, r1, r2);
        r.a(TAG, "parseEnsureConfig:" + this.f7589d.f7595e + " " + this.f);
    }

    @Override // com.bytedance.crash.config.b
    public void a(JSONObject r3) {
        r.a(TAG, "onConfigChanged:" + this.f7589d.e());
        if (r3 != null) goto L5;
        return;
    L5:
        c(r3);
        b(r3);
        this.f7589d.c().a(j());
        this.f7589d.m().a(i());
    }
}
