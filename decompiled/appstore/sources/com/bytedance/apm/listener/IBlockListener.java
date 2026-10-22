package com.bytedance.apm.listener;

/* JADX INFO: loaded from: classes.dex */
public interface IBlockListener {
    void onBlockDetect(String r10, long r11, String r12, String r13);

    void onSeriousBlockDetect(String r10, long r11, String r12, String r13);
}
