package com.bumptech.glide.load.engine;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: compiled from: EngineKey.java */
/* JADX INFO: loaded from: classes.dex */
class n implements com.bumptech.glide.load.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f3712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f3713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f3714d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Class<?> f3715e;
    private final Class<?> f;
    private final com.bumptech.glide.load.g g;
    private final Map<Class<?>, com.bumptech.glide.load.m<?>> h;
    private final com.bumptech.glide.load.i i;
    private int j;

    n(Object r3, com.bumptech.glide.load.g r4, int r5, int r6, Map<Class<?>, com.bumptech.glide.load.m<?>> r7, Class<?> r8, Class<?> r9, com.bumptech.glide.load.i r10) {
        com.bumptech.glide.load.g r11 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        this.f3712b = com.bumptech.glide.f.j.a(r3);
        this.g = (com.bumptech.glide.load.g) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(r11, "Signature must not be null"), com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
        this.f3713c = r5;
        this.f3714d = r6;
        this.h = (Map) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(r12), Map.class, "com.obric.aiagent.plugin");
        this.f3715e = (Class) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(r8, "Resource class must not be null"), Class.class, "com.obric.aiagent.plugin");
        this.f = (Class) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(r9, "Transcode class must not be null"), Class.class, "com.obric.aiagent.plugin");
        this.i = (com.bumptech.glide.load.i) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(r10), com.bumptech.glide.load.i.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, n.class) == false) goto L22;
        n r5 = (n) ZeusTransformUtils.preCheckCast(r4, n.class, "com.obric.aiagent.plugin");
        if (this.f3712b.equals(r5.f3712b) == true) goto L7;
        return false;
    L7:
        if (this.g.equals(r5.g) == true) goto L9;
        return false;
    L9:
        if (this.f3714d == r5.f3714d) goto L11;
        return false;
    L11:
        if (this.f3713c == r5.f3713c) goto L13;
        return false;
    L13:
        if (this.h.equals(r5.h) == true) goto L15;
        return false;
    L15:
        if (this.f3715e.equals(r5.f3715e) == true) goto L17;
        return false;
    L17:
        if (this.f.equals(r5.f) == true) goto L19;
        return false;
    L19:
        if (this.i.equals(r5.i) == false) goto L30;
        return true;
    L30:
        return false;
    L22:
        return false;
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        if (this.j != 0) goto L6;
        int r0 = this.f3712b.hashCode();
        this.j = r0;
        int r1 = (r0 * 31) + this.g.hashCode();
        this.j = r1;
        int r2 = (r1 * 31) + this.f3713c;
        this.j = r2;
        int r3 = (r2 * 31) + this.f3714d;
        this.j = r3;
        int r4 = (r3 * 31) + this.h.hashCode();
        this.j = r4;
        int r5 = (r4 * 31) + this.f3715e.hashCode();
        this.j = r5;
        int r6 = (r5 * 31) + this.f.hashCode();
        this.j = r6;
        this.j = (r6 * 31) + this.i.hashCode();
    L6:
        return this.j;
    }

    public String toString() {
        return "EngineKey{model=" + this.f3712b + ", width=" + this.f3713c + ", height=" + this.f3714d + ", resourceClass=" + this.f3715e + ", transcodeClass=" + this.f + ", signature=" + this.g + ", hashCode=" + this.j + ", transformations=" + this.h + ", options=" + this.i + '}';
    }

    @Override // com.bumptech.glide.load.g
    public void a(MessageDigest r1) {
        throw new UnsupportedOperationException();
    }
}
