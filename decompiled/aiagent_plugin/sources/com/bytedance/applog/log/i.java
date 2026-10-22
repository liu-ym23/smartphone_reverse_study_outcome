package com.bytedance.applog.log;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: LogInfoBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h f5709a;

    public i() {
        this.f5709a = new h();
        a(System.currentTimeMillis());
    }

    public i a(long r2) {
        this.f5709a.a(r2);
        return this;
    }

    public i a(String r2) {
        this.f5709a.a(r2);
        return this;
    }

    public i b(String r2) {
        this.f5709a.b(r2);
        return this;
    }

    public i a(int r2) {
        this.f5709a.a(r2);
        return this;
    }

    public i b(int r2) {
        this.f5709a.b(r2);
        return this;
    }

    public i a(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        this.f5709a.a(r4);
        return this;
    }

    public i c(String r2) {
        this.f5709a.c(r2);
        return this;
    }

    public i a(Throwable r2) {
        this.f5709a.a(r2);
        return this;
    }

    public h a() {
        return this.f5709a;
    }
}
