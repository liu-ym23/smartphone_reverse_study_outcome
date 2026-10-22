package com.bytedance.apm;

import com.bytedance.compression.zstd.ZstdCompress;
import com.bytedance.compression.zstd.ZstdDictCompress;
import java.util.Arrays;

/* JADX INFO: compiled from: ZstdCompressService.java */
/* JADX INFO: loaded from: classes.dex */
public class k implements com.bytedance.services.apm.api.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f4714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ZstdDictCompress f4716c;

    public k() {
    }

    @Override // com.bytedance.services.apm.api.k
    public byte[] a(byte[] r2, byte[] r3, int r4) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if (this.f4716c != null) goto L8;
    L11:
        this.f4716c = new ZstdDictCompress(r3, r4);
        this.f4714a = r3;
        this.f4715b = r4;
    L13:
        return ZstdCompress.compress(r2, this.f4716c);
    L8:
        if (Arrays.equals(r3, this.f4714a) == false) goto L11;
        if (r4 == this.f4715b) goto L13;
        goto L11
    }

    @Override // com.bytedance.services.apm.api.k
    public byte[] a(byte[] r1, int r2) {
        return ZstdCompress.compress(r1, r2);
    }
}
