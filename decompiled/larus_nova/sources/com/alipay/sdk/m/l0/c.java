package com.alipay.sdk.m.l0;

/* JADX INFO: loaded from: classes28.dex */
public class c {
    public static byte[] a(int r100) {
        byte[] r101 = {(byte) ((r3 >> 8) % 256), (byte) (r3 % 256), (byte) (r3 % 256), (byte) (r100 % 256)};
        int r102 = r100 >> 8;
        int r103 = r102 >> 8;
        return r101;
    }
}
