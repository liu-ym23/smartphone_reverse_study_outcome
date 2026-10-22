package com.bumptech.glide.load.resource.a;

import com.bumptech.glide.f.j;
import com.bumptech.glide.load.engine.v;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: BytesResource.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements v<byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f3775a;

    @Override // com.bumptech.glide.load.engine.v
    public void f() {
    }

    @Override // com.bumptech.glide.load.engine.v
    public /* synthetic */ byte[] d() {
        return a();
    }

    public b(byte[] r3) {
        this.f3775a = (byte[]) ZeusTransformUtils.preCheckCast(j.a(r3), byte[].class, "com.obric.aiagent.plugin");
    }

    @Override // com.bumptech.glide.load.engine.v
    public Class<byte[]> c() {
        return byte[].class;
    }

    public byte[] a() {
        return this.f3775a;
    }

    @Override // com.bumptech.glide.load.engine.v
    public int e() {
        return this.f3775a.length;
    }
}
