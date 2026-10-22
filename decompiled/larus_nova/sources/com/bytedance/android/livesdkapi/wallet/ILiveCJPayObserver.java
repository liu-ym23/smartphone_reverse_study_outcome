package com.bytedance.android.livesdkapi.wallet;

import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public interface ILiveCJPayObserver {
    void onEvent(String r100, Map<String, String> r101);

    void onPayCallback(LiveCJPayResult r100);
}
