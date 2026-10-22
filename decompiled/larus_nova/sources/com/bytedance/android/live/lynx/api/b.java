package com.bytedance.android.live.lynx.api;

import com.bytedance.android.live.broadcastgame.opengame.lynx.LynxOpenPlugin$createLynxView$1;
import com.lynx.tasm.LynxView;
import java.util.Map;

/* JADX INFO: loaded from: classes46.dex */
public interface b extends io0.a {
    void a();

    void b(String r100, Object r101);

    void d(String r100, byte[] r101, Map<String, ? extends Object> r102);

    void e(LynxOpenPlugin$createLynxView$1 r100);

    LynxView getLynxView();

    String getUrl();

    void release();

    <T> void sendJsEvent(String r100, T r101);
}
