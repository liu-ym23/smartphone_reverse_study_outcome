package com.bumptech.glide.load.engine;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: compiled from: ResourceCacheKey.java */
/* JADX INFO: loaded from: classes.dex */
final class x implements com.bumptech.glide.load.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.bumptech.glide.f.g<Class<?>, byte[]> f3744b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.b f3745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.load.g f3746d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.g f3747e;
    private final int f;
    private final int g;
    private final Class<?> h;
    private final com.bumptech.glide.load.i i;
    private final com.bumptech.glide.load.m<?> j;

    static {
        f3744b = new com.bumptech.glide.f.g(50);
    }

    x(com.bumptech.glide.load.engine.a.b r3, com.bumptech.glide.load.g r4, com.bumptech.glide.load.g r5, int r6, int r7, com.bumptech.glide.load.m<?> r8, Class<?> r9, com.bumptech.glide.load.i r10) {
        com.bumptech.glide.load.engine.a.b r11 = (com.bumptech.glide.load.engine.a.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.engine.a.b.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.load.g r12 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.load.g r13 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.load.m<?> r14 = (com.bumptech.glide.load.m) ZeusTransformUtils.wrapperContextForParams(r8, com.bumptech.glide.load.m.class, "com.obric.aiagent.plugin");
        this.f3745c = r11;
        this.f3746d = r12;
        this.f3747e = r13;
        this.f = r6;
        this.g = r7;
        this.j = r14;
        this.h = r9;
        this.i = r10;
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, x.class) == false) goto L20;
        x r5 = (x) ZeusTransformUtils.preCheckCast(r4, x.class, "com.obric.aiagent.plugin");
        if (this.g == r5.g) goto L7;
        return false;
    L7:
        if (this.f == r5.f) goto L9;
        return false;
    L9:
        if (com.bumptech.glide.f.k.a(this.j, r5.j) == true) goto L11;
        return false;
    L11:
        if (this.h.equals(r5.h) == true) goto L13;
        return false;
    L13:
        if (this.f3746d.equals(r5.f3746d) == true) goto L15;
        return false;
    L15:
        if (this.f3747e.equals(r5.f3747e) == true) goto L17;
        return false;
    L17:
        if (this.i.equals(r5.i) == false) goto L27;
        return true;
    L27:
        return false;
    L20:
        return false;
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        int r0 = (((((this.f3746d.hashCode() * 31) + this.f3747e.hashCode()) * 31) + this.f) * 31) + this.g;
        com.bumptech.glide.load.m<?> r1 = this.j;
        if (r1 == null) goto L6;
        r0 = (r0 * 31) + r1.hashCode();
    L6:
        return (((r0 * 31) + this.h.hashCode()) * 31) + this.i.hashCode();
    }

    @Override // com.bumptech.glide.load.g
    public void a(MessageDigest r4) {
        byte[] r0 = (byte[]) ZeusTransformUtils.preCheckCast(this.f3745c.b(8, byte[].class), byte[].class, "com.obric.aiagent.plugin");
        ByteBuffer.wrap(r0).putInt(this.f).putInt(this.g).array();
        this.f3747e.a(r4);
        this.f3746d.a(r4);
        r4.update(r0);
        com.bumptech.glide.load.m<?> r1 = this.j;
        if (r1 == null) goto L5;
        r1.a(r4);
    L5:
        this.i.a(r4);
        r4.update(a());
        this.f3745c.a(r0);
    }

    private byte[] a() {
        com.bumptech.glide.f.g<Class<?>, byte[]> r0 = f3744b;
        byte[] r1 = (byte[]) ZeusTransformUtils.preCheckCast(r0.b(this.h), byte[].class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L6;
        byte[] r2 = this.h.getName().getBytes(f3763a);
        r0.b(this.h, r2);
        return r2;
    L6:
        return r1;
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f3746d + ", signature=" + this.f3747e + ", width=" + this.f + ", height=" + this.g + ", decodedResourceClass=" + this.h + ", transformation='" + this.j + "', options=" + this.i + '}';
    }
}
