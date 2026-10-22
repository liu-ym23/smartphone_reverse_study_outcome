package com.bumptech.glide.load;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;

/* JADX INFO: compiled from: Options.java */
/* JADX INFO: loaded from: classes.dex */
public final class i implements g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final androidx.b.a<h<?>, Object> f3769b;

    public i() {
        this.f3769b = new com.bumptech.glide.f.b();
    }

    public void a(i r1) {
        this.f3769b.a(r1.f3769b);
    }

    public <T> i a(h<T> r2, T r3) {
        this.f3769b.put(r2, r3);
        return this;
    }

    public <T> T a(h<T> r2) {
        if (this.f3769b.containsKey(r2) == false) goto L6;
        return (T) this.f3769b.get(r2);
    L6:
        return r2.a();
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, i.class) == false) goto L6;
        i r4 = (i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin");
        return this.f3769b.equals(r4.f3769b);
    L6:
        return false;
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        return this.f3769b.hashCode();
    }

    @Override // com.bumptech.glide.load.g
    public void a(MessageDigest r5) {
        int r0 = 0;
    L4:
        if (r0 >= this.f3769b.size()) goto L6;
        a((h) ZeusTransformUtils.preCheckCast(this.f3769b.b(r0), h.class, "com.obric.aiagent.plugin"), this.f3769b.c(r0), r5);
        r0 = r0 + 1;
        goto L4
    }

    public String toString() {
        return "Options{values=" + this.f3769b + '}';
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void a(h<T> r0, Object r1, MessageDigest r2) {
        r0.update(r1, r2);
    }
}
