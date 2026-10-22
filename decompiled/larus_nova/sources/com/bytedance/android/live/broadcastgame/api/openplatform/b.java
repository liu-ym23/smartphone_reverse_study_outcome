package com.bytedance.android.live.broadcastgame.api.openplatform;

import android.view.Surface;
import com.bytedance.android.live.broadcastgame.api.model.u;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public interface b {
    void b(String r100);

    void c(boolean r100);

    void d(String r100, Map<String, String> r101);

    void e(u r100);

    void g(String r100, Map<String, String> r101, f.a r102);

    String getGameCategory();

    String h();

    void i(long r100, String r101, String r102, Map<String, ? extends Object> r103, boolean r104, boolean r105);

    void j(String r100);

    void k();

    void notifyStartLinkCastResult(boolean r100, Surface r101, int r102);

    void onDestroy();

    void stopGameCastToAudience();
}
