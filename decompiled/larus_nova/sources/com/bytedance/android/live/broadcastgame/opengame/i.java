package com.bytedance.android.live.broadcastgame.opengame;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public interface i {

    public interface a {
        void a(Throwable r100);

        void onInitSuccess();
    }

    void initDebug(Context r100, DataCenter r101, ViewGroup r102, com.bytedance.android.live.broadcastgame.api.openplatform.b r103, Map<String, ? extends Object> r104, a r105);

    void releaseDebug();

    void stopDebug();
}
