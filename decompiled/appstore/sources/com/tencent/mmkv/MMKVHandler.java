package com.tencent.mmkv;

/* JADX INFO: loaded from: classes4.dex */
public interface MMKVHandler {
    void mmkvLog(MMKVLogLevel r10, String r11, int r12, String r13, String r14);

    MMKVRecoverStrategic onMMKVCRCCheckFail(String r10);

    MMKVRecoverStrategic onMMKVFileLengthError(String r10);

    boolean wantLogRedirecting();
}
