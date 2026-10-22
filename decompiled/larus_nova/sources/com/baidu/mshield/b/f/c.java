package com.baidu.mshield.b.f;

import java.util.zip.CRC32;

/* JADX INFO: loaded from: classes39.dex */
public class c {
    public static long a(String r100) {
        CRC32 r101 = new CRC32();
        r101.update(r100.getBytes());
        return r101.getValue();
    }
}
