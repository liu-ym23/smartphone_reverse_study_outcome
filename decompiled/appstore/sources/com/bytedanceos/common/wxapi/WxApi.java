package com.bytedanceos.common.wxapi;

import android.content.Context;
import com.bytedanceos.common.toolbox.j;

/* JADX INFO: loaded from: classes2.dex */
public class WxApi {
    public WxApi() {
    }

    public void a(Context r10, String r11) {
        j.n("wx mApi registered");
    }

    public boolean b(String r10, String r11, String r12, byte[] r13) {
        j.n("sendWebPageToWxSession: [title: " + r10 + ", desc: " + r11 + ", url: " + r12 + "]");
        return false;
    }

    public void c() {
        j.n("wx mApi unregistered");
    }
}
