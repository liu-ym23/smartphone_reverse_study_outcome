package com.bumptech.glide.load.engine;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;

/* JADX INFO: compiled from: DataCacheKey.java */
/* JADX INFO: loaded from: classes.dex */
final class d implements com.bumptech.glide.load.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.g f3612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.g f3613c;

    d(com.bumptech.glide.load.g r3, com.bumptech.glide.load.g r4) {
        com.bumptech.glide.load.g r5 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.load.g r6 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
        this.f3612b = r5;
        this.f3613c = r6;
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, d.class) == false) goto L10;
        d r5 = (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin");
        if (this.f3612b.equals(r5.f3612b) == true) goto L7;
        return false;
    L7:
        if (this.f3613c.equals(r5.f3613c) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        return (this.f3612b.hashCode() * 31) + this.f3613c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f3612b + ", signature=" + this.f3613c + '}';
    }

    @Override // com.bumptech.glide.load.g
    public void a(MessageDigest r2) {
        this.f3612b.a(r2);
        this.f3613c.a(r2);
    }
}
