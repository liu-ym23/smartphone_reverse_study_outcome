package com.bytedance.retrofit2;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: SsResponse.java */
/* JADX INFO: loaded from: classes.dex */
public final class ak<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.retrofit2.b.d f9461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T f9462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bytedance.retrofit2.e.i f9463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private af f9464d;

    public static <T> ak<T> a(T r2, com.bytedance.retrofit2.b.d r3) {
        Objects.requireNonNull(r3, "rawResponse == null");
        if (r3.e() == false) goto L7;
        return new ak(r3, r2, null);
    L7:
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    public static <T> ak<T> a(com.bytedance.retrofit2.e.i r2, com.bytedance.retrofit2.b.d r3) {
        com.bytedance.retrofit2.e.i r4 = (com.bytedance.retrofit2.e.i) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.retrofit2.e.i.class, "com.obric.aiagent.plugin");
        Objects.requireNonNull(r4, "body == null");
        Objects.requireNonNull(r3, "rawResponse == null");
        if (r3.e() == true) goto L7;
        return new ak(r3, null, r4);
    L7:
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    private ak(com.bytedance.retrofit2.b.d r3, T r4, com.bytedance.retrofit2.e.i r5) {
        com.bytedance.retrofit2.e.i r6 = (com.bytedance.retrofit2.e.i) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.retrofit2.e.i.class, "com.obric.aiagent.plugin");
        this.f9461a = r3;
        this.f9462b = r4;
        this.f9463c = r6;
    }

    public af a() {
        return this.f9464d;
    }

    public void a(af r1) {
        this.f9464d = r1;
    }

    public com.bytedance.retrofit2.b.d b() {
        return this.f9461a;
    }

    public int c() {
        return this.f9461a.b();
    }

    public List<com.bytedance.retrofit2.b.b> d() {
        return this.f9461a.c();
    }

    public boolean e() {
        return this.f9461a.e();
    }

    public T f() {
        return this.f9462b;
    }

    public com.bytedance.retrofit2.e.i g() {
        return this.f9463c;
    }

    public String h() {
        return this.f9461a.g();
    }
}
