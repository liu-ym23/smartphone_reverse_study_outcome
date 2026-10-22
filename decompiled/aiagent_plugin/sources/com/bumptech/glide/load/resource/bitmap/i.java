package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;

/* JADX INFO: compiled from: CenterCrop.java */
/* JADX INFO: loaded from: classes.dex */
public class i extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f3800b = null;

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        return -599754482;
    }

    public i() {
    }

    static {
        f3800b = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(f3763a);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.f
    public Bitmap a(com.bumptech.glide.load.engine.a.e r2, Bitmap r3, int r4, int r5) {
        return z.a((com.bumptech.glide.load.engine.a.e) ZeusTransformUtils.wrapperContextForParams(r2, com.bumptech.glide.load.engine.a.e.class, "com.obric.aiagent.plugin"), r3, r4, r5);
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, i.class);
    }

    @Override // com.bumptech.glide.load.g
    public void a(MessageDigest r1) {
        r1.update(f3800b);
    }
}
