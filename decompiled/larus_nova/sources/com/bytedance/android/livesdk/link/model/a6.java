package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ICityEffect;
import com.bytedance.android.livesdkapi.depend.model.live.linker.IMatchEffect;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\r\u001a\u0004\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/a6;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/f1;", "Lcom/bytedance/android/livesdk/link/model/t4;", "getLinkIconConfig", "()Lcom/bytedance/android/livesdk/link/model/t4;", "getLinkIconConfig$annotations", "()V", "linkIconConfig", "Lcom/bytedance/android/livesdk/link/model/t6;", "getUiConfig", "()Lcom/bytedance/android/livesdk/link/model/t6;", "getUiConfig$annotations", "uiConfig", "", "getBattleDisplayEntrance", "()Z", "getBattleDisplayEntrance$annotations", "battleDisplayEntrance", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a6 extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.f1>, com.bytedance.android.livesdk.link.model.bridge.f1 {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.f1, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.link.model.bridge.f1, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    /* synthetic */ int getApplyType();

    @FieldName(name = "battle_display_entrance")
    boolean getBattleDisplayEntrance();

    /* synthetic */ ICityEffect getCityEffect();

    @FieldName(name = "client_ui_info")
    /* synthetic */ ClientUIInfo getClientUiInfo();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "link_icon_config")
    t4 getLinkIconConfig();

    /* synthetic */ List<com.bytedance.android.livesdk.link.model.bridge.k> getLinkUsers();

    /* synthetic */ Map<Long, com.bytedance.android.livesdk.link.model.bridge.g2> getLinkerContentMap();

    /* synthetic */ IMatchEffect getMatchEffect();

    @FieldName(name = "msg_board_item")
    /* synthetic */ IMessageBoardInfo getMessageBoardInfo();

    @FieldName(name = "pre_link_users")
    /* synthetic */ List<com.bytedance.android.livesdk.link.model.bridge.k> getPreOnlineUsers();

    @FieldName(name = "ui_config")
    t6 getUiConfig();

    /* synthetic */ String getUserIdString();

    /* synthetic */ long getVersion();

    /* synthetic */ void setApplyType(int r100);

    /* synthetic */ void setCityEffect(ICityEffect r100);

    /* synthetic */ void setLinkUsers(List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r100);

    /* synthetic */ void setLinkerContentMap(Map<Long, ? extends com.bytedance.android.livesdk.link.model.bridge.g2> r100);

    /* synthetic */ void setMatchEffect(IMatchEffect r100);

    @FieldName(name = "msg_board_item#setter")
    /* synthetic */ void setMessageBoardInfo(IMessageBoardInfo r100);

    @FieldName(name = "pre_link_users#setter")
    /* synthetic */ void setPreOnlineUsers(List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r100);

    /* synthetic */ void setUserIdString(String r100);

    /* synthetic */ void setVersion(long r100);
}
