package com.bumptech.glide.load.resource.d;

import com.bumptech.glide.load.engine.v;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: GifDrawableBytesTranscoder.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements e<GifDrawable, byte[]> {
    public d() {
    }

    @Override // com.bumptech.glide.load.resource.d.e
    public v<byte[]> a(v<GifDrawable> r1, i r2) {
        return new com.bumptech.glide.load.resource.a.b(com.bumptech.glide.f.a.a(((GifDrawable) ZeusTransformUtils.preCheckCast(((v) ZeusTransformUtils.wrapperContextForParams(r1, v.class, "com.obric.aiagent.plugin")).d(), GifDrawable.class, "com.obric.aiagent.plugin")).getBuffer()));
    }
}
