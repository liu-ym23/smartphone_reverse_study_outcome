package com.bytedance.frameworks.baselib.network.http;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: RequestRetryResult.java */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f8356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f8357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, String> f8358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f8359d;

    public i(boolean r2) {
        this.f8357b = true;
        this.f8356a = r2;
    }

    public i(boolean r3, boolean r4, Map<String, String> r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        this.f8357b = true;
        this.f8356a = r3;
        this.f8357b = r4;
        this.f8358c = r6;
    }

    public boolean a() {
        return this.f8356a;
    }

    public boolean b() {
        return this.f8357b;
    }

    public void a(boolean r1) {
        this.f8357b = r1;
    }

    public Map<String, String> c() {
        return this.f8358c;
    }

    public void a(Map<String, String> r3) {
        this.f8358c = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
    }

    void a(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        this.f8359d = r2;
    }

    public String d() {
        return this.f8359d;
    }
}
