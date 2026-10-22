package com.bytedance.reparo.core.h;

import com.bytedance.reparo.core.f;
import com.bytedance.reparo.core.i.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: JavaPatch.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f9258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bytedance.reparo.core.g.d f9259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d f9260d;

    public c(File r2, d r3) {
        this.f9258b = r2;
        this.f9259c = new com.bytedance.reparo.core.g.d(r2);
        this.f9260d = r3;
    }

    public d f() {
        return this.f9260d;
    }

    public void a(b r3) {
        if (this.f9259c.e() == true) goto L6;
        long r0 = System.currentTimeMillis();
        this.f9259c.a(r3);
        k.a(System.currentTimeMillis() - r0);
        return;
    }

    public Map<Class, f> g() {
        return this.f9259c.a();
    }

    public List<String> h() {
        return this.f9259c.b();
    }

    public List<String> i() {
        return this.f9259c.c();
    }

    public List<Object> j() {
        return this.f9259c.d();
    }

    public File k() {
        return this.f9258b;
    }

    @Override // com.bytedance.reparo.core.h.a
    public boolean e() {
        return !com.bytedance.reparo.core.a.b.b.d(this.f9258b);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L7;
        return true;
    L7:
        if (r4 != null) goto L10;
        return false;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, c.class) == true) goto L12;
        return false;
    L12:
        c r5 = (c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.aiagent.plugin");
        return com.bytedance.reparo.core.a.b.b.b(this.f9258b, r5.f9258b);
    }
}
