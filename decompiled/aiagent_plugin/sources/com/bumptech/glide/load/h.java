package com.bumptech.glide.load;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;

/* JADX INFO: compiled from: Option.java */
/* JADX INFO: loaded from: classes.dex */
public final class h<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a<Object> f3764a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T f3765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a<T> f3766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f3767d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile byte[] f3768e;

    /* JADX INFO: compiled from: Option.java */
    public interface a<T> {
        void update(byte[] r1, T r2, MessageDigest r3);
    }

    static {
        f3764a = new AnonymousClass1();
    }

    public static <T> h<T> a(String r3) {
        return new h(r3, null, c());
    }

    public static <T> h<T> a(String r2, T r3) {
        return new h(r2, r3, c());
    }

    public static <T> h<T> a(String r2, T r3, a<T> r4) {
        return new h(r2, r3, (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin"));
    }

    private h(String r3, T r4, a<T> r5) {
        a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.aiagent.plugin");
        this.f3767d = com.bumptech.glide.f.j.a(r3);
        this.f3765b = r4;
        this.f3766c = (a) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(r6), a.class, "com.obric.aiagent.plugin");
    }

    public T a() {
        return this.f3765b;
    }

    public void update(T r2, MessageDigest r3) {
        this.f3766c.update(b(), r2, r3);
    }

    private byte[] b() {
        if (this.f3768e != null) goto L6;
        this.f3768e = this.f3767d.getBytes(g.f3763a);
    L6:
        return this.f3768e;
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, h.class) == false) goto L6;
        h r4 = (h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.aiagent.plugin");
        return this.f3767d.equals(r4.f3767d);
    L6:
        return false;
    }

    public int hashCode() {
        return this.f3767d.hashCode();
    }

    private static <T> a<T> c() {
        return (a<T>) f3764a;
    }

    public String toString() {
        return "Option{key='" + this.f3767d + "'}";
    }
}
