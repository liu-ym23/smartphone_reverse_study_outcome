package com.baidu.bbalbscesium.m;

import java.security.MessageDigest;

/* JADX INFO: loaded from: classes39.dex */
public final class d {
    private d() {
    }

    public static byte[] a(byte[] r100) {
        return MessageDigest.getInstance("SHA-1").digest(r100);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
