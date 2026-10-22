package com.bytedance.android.livesdk.revenue.message;

/* JADX INFO: loaded from: classes11.dex */
public interface b {
    void addMessageListener(String r100, vlc.l r101);

    void h(vlc.b r100);

    void i(String r100, vlc.l r101, String r102);

    void j(tlc.d r100, boolean r101);

    void release();

    void removeMessageListener(String r100, vlc.l r101);

    void startMessage();
}
