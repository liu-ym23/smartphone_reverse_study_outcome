package com.bumptech.glide.load.engine;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: compiled from: DataCacheWriter.java */
/* JADX INFO: loaded from: classes.dex */
class e<DataType> implements com.bumptech.glide.load.engine.b.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.d<DataType> f3637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DataType f3638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.i f3639c;

    e(com.bumptech.glide.load.d<DataType> r3, DataType r4, com.bumptech.glide.load.i r5) {
        this.f3637a = (com.bumptech.glide.load.d) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.d.class, "com.obric.aiagent.plugin");
        this.f3638b = r4;
        this.f3639c = r5;
    }

    @Override // com.bumptech.glide.load.engine.b.a.b
    public boolean a(File r3) {
        return this.f3637a.a(this.f3638b, r3, this.f3639c);
    }
}
