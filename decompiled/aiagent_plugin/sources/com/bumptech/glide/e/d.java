package com.bumptech.glide.e;

import com.bumptech.glide.f.j;
import com.bumptech.glide.load.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;

/* JADX INFO: compiled from: ObjectKey.java */
/* JADX INFO: loaded from: classes.dex */
public final class d implements g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f3303b;

    public d(Object r1) {
        this.f3303b = j.a(r1);
    }

    public String toString() {
        return "ObjectKey{object=" + this.f3303b + '}';
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, d.class) == false) goto L6;
        d r4 = (d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin");
        return this.f3303b.equals(r4.f3303b);
    L6:
        return false;
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        return this.f3303b.hashCode();
    }

    @Override // com.bumptech.glide.load.g
    public void a(MessageDigest r2) {
        r2.update(this.f3303b.toString().getBytes(f3763a));
    }
}
