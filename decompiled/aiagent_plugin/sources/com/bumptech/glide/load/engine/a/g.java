package com.bumptech.glide.load.engine.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ByteArrayAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public final class g implements a<byte[]> {
    private static final String TAG = "ByteArrayPool";

    @Override // com.bumptech.glide.load.engine.a.a
    public String a() {
        return TAG;
    }

    @Override // com.bumptech.glide.load.engine.a.a
    public int b() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.a.a
    public /* synthetic */ int a(byte[] r3) {
        return a2((byte[]) ZeusTransformUtils.preCheckCast(r3, byte[].class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bumptech.glide.load.engine.a.a
    public /* synthetic */ byte[] a(int r1) {
        return b(r1);
    }

    public g() {
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public int a2(byte[] r1) {
        return r1.length;
    }

    public byte[] b(int r1) {
        return new byte[r1];
    }
}
