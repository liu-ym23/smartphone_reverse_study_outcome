package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.v;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: GifFrameResourceDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public final class f implements k<com.bumptech.glide.b.a, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.e f3885a;

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(com.bumptech.glide.b.a r1, i r2) {
        com.bumptech.glide.b.a r0 = (com.bumptech.glide.b.a) ZeusTransformUtils.wrapperContextForParams(r1, com.bumptech.glide.b.a.class, "com.obric.aiagent.plugin");
        return true;
    }

    @Override // com.bumptech.glide.load.k
    public /* synthetic */ v<Bitmap> a(com.bumptech.glide.b.a r3, int r4, int r5, i r6) {
        return a2((com.bumptech.glide.b.a) ZeusTransformUtils.preCheckCast(r3, com.bumptech.glide.b.a.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    @Override // com.bumptech.glide.load.k
    public /* synthetic */ boolean a(com.bumptech.glide.b.a r3, i r4) {
        return a2((com.bumptech.glide.b.a) ZeusTransformUtils.preCheckCast(r3, com.bumptech.glide.b.a.class, "com.obric.aiagent.plugin"), r4);
    }

    public f(com.bumptech.glide.load.engine.a.e r3) {
        this.f3885a = (com.bumptech.glide.load.engine.a.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.engine.a.e.class, "com.obric.aiagent.plugin");
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public v<Bitmap> a2(com.bumptech.glide.b.a r1, int r2, int r3, i r4) {
        return com.bumptech.glide.load.resource.bitmap.e.a(((com.bumptech.glide.b.a) ZeusTransformUtils.wrapperContextForParams(r1, com.bumptech.glide.b.a.class, "com.obric.aiagent.plugin")).i(), this.f3885a);
    }
}
