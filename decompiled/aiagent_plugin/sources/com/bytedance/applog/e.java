package com.bytedance.applog;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: CompressResult.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f5573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f5574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, String> f5575c;

    public e() {
        this.f5574b = -1;
    }

    public byte[] a() {
        return this.f5573a;
    }

    public void a(byte[] r1) {
        this.f5573a = r1;
    }

    public int b() {
        return this.f5574b;
    }

    public void a(int r1) {
        this.f5574b = r1;
    }

    public Map<String, String> c() {
        return this.f5575c;
    }

    public void a(Map<String, String> r3) {
        this.f5575c = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
    }
}
