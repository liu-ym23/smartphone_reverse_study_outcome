package com.bytedance.retrofit2.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;

/* JADX INFO: compiled from: TTNetExceptionStorage.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f9545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f9546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f9547c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f9548d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f9549e;

    public c() {
        this.f9545a = false;
        this.f9546b = false;
        this.f9547c = "empty url";
        this.f9548d = "empty traceCode";
        this.f9549e = null;
    }

    public c(String r1) {
        super(r1);
        this.f9545a = false;
        this.f9546b = false;
        this.f9547c = "empty url";
        this.f9548d = "empty traceCode";
        this.f9549e = null;
    }

    public c(String r1, Throwable r2) {
        super(r1, r2);
        this.f9545a = false;
        this.f9546b = false;
        this.f9547c = "empty url";
        this.f9548d = "empty traceCode";
        this.f9549e = null;
    }

    public void a(boolean r1, boolean r2, String r3, String r4, Object r5) {
        this.f9545a = r1;
        this.f9546b = r2;
        this.f9547c = r3;
        this.f9548d = r4;
        this.f9549e = r5;
    }

    public static c a(Exception r7, String r8, String r9, Object r10) {
        if (ZeusTransformUtils.instanceOf(r7, c.class) == true) goto L5;
        c r6 = new c(r7.getMessage(), r7);
        r6.a(false, true, r8, r9, r10);
        return r6;
    L5:
        return (c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin");
    }
}
