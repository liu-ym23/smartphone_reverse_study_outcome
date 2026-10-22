package com.bytedance.apm;

import com.bytedance.compression.zstd.ZstdCompress;
import com.bytedance.compression.zstd.ZstdDictCompress;
import com.bytedance.services.apm.api.IZstdCompress;
import com.bytedance.services.apm.api.IZstdDict;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class ZstdCompressService implements IZstdCompress {
    private ZstdDictCompress cacheCompressDict;
    private byte[] lastDict;
    private int lastLevel;
    private IZstdDict lastZstdDict;

    public ZstdCompressService() {
    }

    @Override // com.bytedance.services.apm.api.IZstdCompress
    public byte[] compress(byte[] r2, byte[] r3, int r4) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if (this.cacheCompressDict != null) goto L8;
    L11:
        this.cacheCompressDict = new ZstdDictCompress(r3, r4);
        this.lastDict = r3;
        this.lastLevel = r4;
    L13:
        return ZstdCompress.compress(r2, this.cacheCompressDict);
    L8:
        if (Arrays.equals(r3, this.lastDict) == false) goto L11;
        if (r4 == this.lastLevel) goto L13;
        goto L11
    }

    @Override // com.bytedance.services.apm.api.IZstdCompress
    public byte[] compress(byte[] r1, int r2) {
        return ZstdCompress.compress(r1, r2);
    }
}
