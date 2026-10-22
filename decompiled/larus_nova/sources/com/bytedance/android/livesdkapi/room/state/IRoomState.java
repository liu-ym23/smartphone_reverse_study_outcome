package com.bytedance.android.livesdkapi.room.state;

import android.os.Bundle;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import py.k;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\u0019\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\bR\u0014\u0010\r\u001a\u00020\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u0011\u001a\u00020\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u0014\u0010\u0012\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\bR\u0014\u0010\u0013\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\bR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0016R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0004R \u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u001c8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0004R \u0010'\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u001c8&X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u001eR\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0016R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00060\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0016R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0016R\u0016\u0010/\u001a\u0004\u0018\u00010,8&X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0016\u00101\u001a\u0004\u0018\u00010,8&X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u0010.R\u0016\u00103\u001a\u0004\u0018\u00010\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\fR\u0016\u00105\u001a\u0004\u0018\u00010\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\fR\u0014\u00107\u001a\u00020\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\fR\u0016\u00109\u001a\u0004\u0018\u00010\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b8\u0010\fR\u0016\u0010;\u001a\u0004\u0018\u00010,8&X¦\u0004¢\u0006\u0006\u001a\u0004\b:\u0010.R\u0016\u0010?\u001a\u0004\u0018\u00010<8&X¦\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0016\u0010A\u001a\u0004\u0018\u00010\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b@\u0010\fR\u0016\u0010C\u001a\u0004\u0018\u00010\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\bB\u0010\fR\u0016\u0010E\u001a\u0004\u0018\u00010,8&X¦\u0004¢\u0006\u0006\u001a\u0004\bD\u0010.R\u0016\u0010G\u001a\u0004\u0018\u00010\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\bF\u0010\fR\u0014\u0010I\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\bH\u0010\bR\u0014\u0010J\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010\bR \u0010L\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u001c8&X¦\u0004¢\u0006\u0006\u001a\u0004\bK\u0010\u001eR\u0014\u0010M\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\bM\u0010\bR\u0014\u0010O\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\bN\u0010\bR\u0014\u0010P\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\bP\u0010\bR\u001c\u0010V\u001a\u00020Q8&@&X¦\u000e¢\u0006\f\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u001c\u0010W\u001a\u00020\u00068&@&X¦\u000e¢\u0006\f\u001a\u0004\bW\u0010\b\"\u0004\bX\u0010YR\u001c\u0010Z\u001a\u00020\u00068&@&X¦\u000e¢\u0006\f\u001a\u0004\bZ\u0010\b\"\u0004\b[\u0010YR\u001c\u0010\\\u001a\u00020\u00068&@&X¦\u000e¢\u0006\f\u001a\u0004\b\\\u0010\b\"\u0004\b]\u0010YR\u001c\u0010a\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b^\u0010\u0004\"\u0004\b_\u0010`R\u001e\u0010e\u001a\u0004\u0018\u00010\n8&@&X¦\u000e¢\u0006\f\u001a\u0004\bb\u0010\f\"\u0004\bc\u0010dR\u0014\u0010f\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\bf\u0010\bR\u001c\u0010i\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\bg\u0010\u0004\"\u0004\bh\u0010`¨\u0006j"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/state/IRoomState;", "", "", "getItemType", "()I", "itemType", "", "isAnchor", "()Z", "isPortrait", "", "getRoomId", "()Ljava/lang/String;", "roomId", "getRoomAnchorId", "roomAnchorId", "getRoomAnchorSecId", "roomAnchorSecId", "isFollowed", "isReplayOpen", "Lkotlin/Function0;", "isLoginFunc", "()Lkotlin/jvm/functions/Function0;", "getHasViewRightFunc", "hasViewRightFunc", "isRoomVisibleFunc", "getStreamType", "streamType", "", "getReportParams", "()Ljava/util/Map;", "reportParams", "Landroid/os/Bundle;", "getExtra", "()Landroid/os/Bundle;", "extra", "getLiveSdkVersion", "liveSdkVersion", "getEnterRoomParams", "enterRoomParams", "isKtvFun", "isInInteractionGameFun", "getPanelHeight", "panelHeight", "Lpy/k;", "getCartIcon", "()Lpy/k;", "cartIcon", "getLandscapeCartIcon", "landscapeCartIcon", "getRequestId", "requestId", "getLogPb", "logPb", "getAnchorName", "anchorName", "getTitle", "title", "getCover", "cover", "Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrl;", "getStreamUrl", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrl;", "streamUrl", "getViewCount", "viewCount", "getAnchorFollowerCount", "anchorFollowerCount", "getContentLabel", "contentLabel", "getAnchorLocation", "anchorLocation", "getEnterFromSpecialAd", "enterFromSpecialAd", Keys.API_RETURN_KEY_IS_LOGIN, "getAdLiveParams", "adLiveParams", "isKtv", "getHasViewRight", "hasViewRight", "isInInteractionGame", "", "getEpisodeId", "()J", "setEpisodeId", "(J)V", "episodeId", "isVerticalVideo", "setVerticalVideo", "(Z)V", "isInPreview", "setInPreview", "isGameRoom", "setGameRoom", "getInstantType", "setInstantType", "(I)V", "instantType", "getRouteRule", "setRouteRule", "(Ljava/lang/String;)V", "routeRule", "isRoomVisible", "getIntroType", "setIntroType", "introType", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IRoomState {
    Map<String, String> getAdLiveParams();

    String getAnchorFollowerCount();

    String getAnchorLocation();

    String getAnchorName();

    k getCartIcon();

    k getContentLabel();

    k getCover();

    boolean getEnterFromSpecialAd();

    Map<String, String> getEnterRoomParams();

    long getEpisodeId();

    Bundle getExtra();

    boolean getHasViewRight();

    Function0<Boolean> getHasViewRightFunc();

    int getInstantType();

    int getIntroType();

    int getItemType();

    k getLandscapeCartIcon();

    int getLiveSdkVersion();

    String getLogPb();

    Function0<Integer> getPanelHeight();

    Map<String, String> getReportParams();

    String getRequestId();

    String getRoomAnchorId();

    String getRoomAnchorSecId();

    String getRoomId();

    String getRouteRule();

    int getStreamType();

    IBaseStreamUrl getStreamUrl();

    String getTitle();

    String getViewCount();

    boolean isAnchor();

    boolean isFollowed();

    boolean isGameRoom();

    boolean isInInteractionGame();

    Function0<Boolean> isInInteractionGameFun();

    boolean isInPreview();

    boolean isKtv();

    Function0<Boolean> isKtvFun();

    boolean isLogin();

    Function0<Boolean> isLoginFunc();

    boolean isPortrait();

    boolean isReplayOpen();

    boolean isRoomVisible();

    Function0<Boolean> isRoomVisibleFunc();

    boolean isVerticalVideo();

    void setEpisodeId(long r100);

    void setGameRoom(boolean r100);

    void setInPreview(boolean r100);

    void setInstantType(int r100);

    void setIntroType(int r100);

    void setRouteRule(String r100);

    void setVerticalVideo(boolean r100);
}
