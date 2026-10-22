package com.bytedance.android.live.broadcastgame.opengame.runtime;

import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public interface k {
    void e(Context r100, String r101, Map<String, ? extends Object> r102, n r103);

    void f();

    void onHide();

    void onShow(Map<String, String> r100);

    void onStart();

    void onStop();

    <T> void sendEvent(String r100, T r101);
}
