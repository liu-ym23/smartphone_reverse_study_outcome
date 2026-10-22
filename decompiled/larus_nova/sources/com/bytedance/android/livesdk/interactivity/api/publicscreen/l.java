package com.bytedance.android.livesdk.interactivity.api.publicscreen;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.model.PublicScreenHeatState;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.config.MessagePluginType;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public interface l {
    com.bytedance.live.datacontext.m<? extends Boolean> getHasChangeOrientation();

    com.bytedance.live.datacontext.j<List<tlc.d>> getHistoryMentionChat();

    com.bytedance.live.datacontext.j<Object> getLikeEggSyncModel();

    com.bytedance.live.datacontext.m<? extends PublicScreenHeatState> getMessageHeat();

    com.bytedance.live.datacontext.j<? extends v42.b> getMessageLogicFacade();

    x getMessagePlugin(Object r100);

    h52.a<h52.d, ? extends h52.c> getMessagePluginByType(MessagePluginType r100);

    com.bytedance.live.datacontext.i<g> getMessageSourceManager();

    e52.a getTextConfig();

    h52.b<? extends h52.c> getViewBinderPluginByItemType(int r100);

    com.bytedance.live.datacontext.m<? extends com.bytedance.android.livesdk.interactivity.api.publicscreen.model.f> getWaitMessageState();

    void insertMessage(i r100);

    void insertMessageSourceData(h52.d r100);

    com.bytedance.live.datacontext.m<? extends Boolean> isMessageListEmpty();

    void registerMessagePlugin(h52.a<h52.d, ? extends h52.c> r100);

    void registerPlugin(x r100);

    void unregisterMessagePlugin(h52.a<h52.d, ? extends h52.c> r100);
}
