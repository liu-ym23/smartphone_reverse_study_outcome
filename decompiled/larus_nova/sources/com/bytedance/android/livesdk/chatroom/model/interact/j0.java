package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u00022\u00020\u0002R\u001c\u0010\b\u001a\u00020\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\t8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u000f8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00158&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010 \u001a\u0004\u0018\u00010\u001b8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/j0;", "Lvh7/c;", "", "", "getScene", "()I", "setScene", "(I)V", "scene", "", "getRivalLinkmicId", "()J", "setRivalLinkmicId", "(J)V", "rivalLinkmicId", "", "getRivalLinkmicIdStr", "()Ljava/lang/String;", "setRivalLinkmicIdStr", "(Ljava/lang/String;)V", "rivalLinkmicIdStr", "Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "getMultiRtcInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "setMultiRtcInfo", "(Lcom/bytedance/android/livesdk/link/model/bridge/v1;)V", "multiRtcInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/u1;", "getMultiLiveCoreInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/u1;", "setMultiLiveCoreInfo", "(Lcom/bytedance/android/livesdk/link/model/bridge/u1;)V", "multiLiveCoreInfo", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface j0 extends vh7.c<j0> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    /* synthetic */ String getAccessToken();

    /* synthetic */ String getAppId();

    /* synthetic */ String getAppSign();

    /* synthetic */ com.bytedance.android.livesdk.chatroom.model.v getChorusCDNInfo();

    /* synthetic */ ClientUIInfo getClientUIInfo();

    /* synthetic */ String getFunctionType2();

    /* synthetic */ int getLinkMicId();

    /* synthetic */ String getLinkMicIdStr();

    /* synthetic */ String getLinkerSessionId();

    /* synthetic */ String getLiveCoreExtInfo();

    com.bytedance.android.livesdk.link.model.bridge.u1 getMultiLiveCoreInfo();

    com.bytedance.android.livesdk.link.model.bridge.v1 getMultiRtcInfo();

    /* synthetic */ List<Integer> getPlayModes();

    long getRivalLinkmicId();

    String getRivalLinkmicIdStr();

    /* synthetic */ String getRtcExtInfo();

    int getScene();

    /* synthetic */ String getSubRoomToken();

    /* synthetic */ int getUiLayout();

    /* synthetic */ int getVendor();

    /* synthetic */ boolean isFirstInit();

    /* synthetic */ boolean isFlexibleTeamFight();

    /* synthetic */ boolean isSupportVideo();

    /* synthetic */ boolean isTeamFightShowing();

    /* synthetic */ void setChorusCDNInfo(com.bytedance.android.livesdk.chatroom.model.v r100);

    /* synthetic */ void setClientUIInfo(ClientUIInfo r100);

    /* synthetic */ void setFirstInit(boolean r100);

    /* synthetic */ void setFlexibleTeamFight(boolean r100);

    /* synthetic */ void setFunctionType2(String r100);

    /* synthetic */ void setLinkMicIdStr(String r100);

    /* synthetic */ void setLinkerSessionId(String r100);

    /* synthetic */ void setLiveCoreExtInfo(String r100);

    void setMultiLiveCoreInfo(com.bytedance.android.livesdk.link.model.bridge.u1 r100);

    void setMultiRtcInfo(com.bytedance.android.livesdk.link.model.bridge.v1 r100);

    /* synthetic */ void setPlayModes(List<Integer> r100);

    void setRivalLinkmicId(long r100);

    void setRivalLinkmicIdStr(String r100);

    /* synthetic */ void setRtcExtInfo(String r100);

    void setScene(int r100);

    /* synthetic */ void setSubRoomToken(String r100);

    /* synthetic */ void setSubRtcExtInfo(String r100);

    /* synthetic */ void setSupportVideo(boolean r100);

    /* synthetic */ void setTeamFightShowing(boolean r100);

    /* synthetic */ void setUiLayout(int r100);

    /* synthetic */ void setVendor(int r100);
}
