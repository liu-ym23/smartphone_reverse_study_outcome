package com.bytedance.apm;

import com.bytedance.compression.zstd.ZstdCompress;
import com.bytedance.compression.zstd.ZstdDictCompress;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements ff7.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f190611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f190612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ZstdDictCompress f190613c;

    public l() {
    }

    @Override // ff7.j
    public final byte[] a(byte[] r100) {
        return ZstdCompress.compress(r100, 15);
    }

    @Override // ff7.j
    public final byte[] b(byte[] r100, byte[] r101) {
        if (this.f190613c != null) goto L5;
    L8:
        this.f190613c = new ZstdDictCompress(r101, 15);
        this.f190611a = r101;
        this.f190612b = 15;
    L10:
        return ZstdCompress.compress(r100, this.f190613c);
    L5:
        if (Arrays.equals(r101, this.f190611a) == false) goto L8;
        if (15 == this.f190612b) goto L10;
        goto L8
    }
}
