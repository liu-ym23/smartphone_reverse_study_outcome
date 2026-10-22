package com.baidu.platform.comapi.bmsdk.style;

/* JADX INFO: loaded from: classes39.dex */
public class a {
    public static int a(int r100) {
        int r101 = ((-16777216) & r100) >> 24;
        int r102 = (16711680 & r100) >> 16;
        int r103 = (65280 & r100) >> 8;
        int r104 = (r100 & 255) << 16;
        return ((r104 | (r101 << 24)) | (r103 << 8)) | r102;
    }
}
