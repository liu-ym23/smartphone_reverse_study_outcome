package com.bytedance.services.apm.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: HttpResponse.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, String> f11179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f11180c;

    public c(int r1, byte[] r2) {
        this.f11178a = r1;
        this.f11180c = r2;
    }

    public c(int r3, Map<String, String> r4, byte[] r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        this.f11178a = r3;
        this.f11179b = r6;
        this.f11180c = r5;
    }

    public int a() {
        return this.f11178a;
    }

    public byte[] b() {
        return this.f11180c;
    }

    public Map<String, String> c() {
        return this.f11179b;
    }
}
