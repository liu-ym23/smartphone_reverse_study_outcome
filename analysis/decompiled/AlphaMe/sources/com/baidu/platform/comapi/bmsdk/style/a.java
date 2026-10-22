package com.baidu.platform.comapi.bmsdk.style;

/* loaded from: classes.dex */
public class a {
    public static int a(int i4) {
        int i5 = ((-16777216) & i4) >> 24;
        int i6 = (65280 & i4) >> 8;
        return ((i4 & 255) << 16) | (i5 << 24) | (i6 << 8) | ((16711680 & i4) >> 16);
    }
}
