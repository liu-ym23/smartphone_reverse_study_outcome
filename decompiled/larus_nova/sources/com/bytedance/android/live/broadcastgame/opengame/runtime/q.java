package com.bytedance.android.live.broadcastgame.opengame.runtime;

import android.view.Surface;
import com.bytedance.android.live.broadcastgame.api.openplatform.PluginType;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public interface q {
    void a();

    void b(String r100);

    void c(boolean r100);

    void d(com.bytedance.android.live.broadcastgame.api.openplatform.a r100);

    void e(String r100, PluginType r101, Map<String, ? extends Object> r102, boolean r103, r r104);

    void g(Map<String, String> r100);

    /* JADX INFO: renamed from: getContext */
    PluginContext mo8168getContext();

    com.bytedance.android.live.broadcastgame.opengame.t getPluginInfo();

    String h();

    Long i();

    void j(String r100);

    void k();

    void m();

    void notifyStartLinkCastResult(boolean r100, Surface r101, int r102);

    void stopGameCastToAudience();
}
