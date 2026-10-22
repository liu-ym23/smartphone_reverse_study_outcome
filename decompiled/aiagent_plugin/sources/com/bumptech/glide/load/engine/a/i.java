package com.bumptech.glide.load.engine.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: IntegerArrayAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public final class i implements a<int[]> {
    private static final String TAG = "IntegerArrayPool";

    @Override // com.bumptech.glide.load.engine.a.a
    public String a() {
        return TAG;
    }

    @Override // com.bumptech.glide.load.engine.a.a
    public int b() {
        return 4;
    }

    @Override // com.bumptech.glide.load.engine.a.a
    public /* synthetic */ int a(int[] r3) {
        return a2((int[]) ZeusTransformUtils.preCheckCast(r3, int[].class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bumptech.glide.load.engine.a.a
    public /* synthetic */ int[] a(int r1) {
        return b(r1);
    }

    public i() {
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public int a2(int[] r1) {
        return r1.length;
    }

    public int[] b(int r1) {
        return new int[r1];
    }
}
