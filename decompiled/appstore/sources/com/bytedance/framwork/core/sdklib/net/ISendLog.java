package com.bytedance.framwork.core.sdklib.net;

import d5.c;

/* JADX INFO: loaded from: classes.dex */
public interface ISendLog {
    public static final int COMPRESS_TYPE_GZIP = 1;

    c sendLog(String r10, byte[] r11);
}
