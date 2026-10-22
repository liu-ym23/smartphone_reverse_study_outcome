package com.bytedance.android.livehostapi.business.depend.gamecp.cloudgame;

import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u001c\u0010\u0007\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t\u0018\u00010\b\u0012\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R'\u0010\u0007\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R!\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/gamecp/cloudgame/LiveCloudGameStartParam;", "", "gameName", "", "gameIcon", "gameId", RemoteMessageConst.Notification.CHANNEL_ID, "extra2Game", "", "Lkotlin/Pair;", "extra2Sever", "", "gameOrientation", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/cloudgame/LiveGameOrientation;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Lcom/bytedance/android/livehostapi/business/depend/gamecp/cloudgame/LiveGameOrientation;)V", "getChannelId", "()Ljava/lang/String;", "getExtra2Game", "()Ljava/util/List;", "getExtra2Sever", "()Ljava/util/Map;", "getGameIcon", "getGameId", "getGameName", "getGameOrientation", "()Lcom/bytedance/android/livehostapi/business/depend/gamecp/cloudgame/LiveGameOrientation;", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCloudGameStartParam {
    private final String channelId;
    private final List<Pair<String, Object>> extra2Game;
    private final Map<String, String> extra2Sever;
    private final String gameIcon;
    private final String gameId;
    private final String gameName;
    private final LiveGameOrientation gameOrientation;

    public final String getChannelId() {
        return this.channelId;
    }

    public final List<Pair<String, Object>> getExtra2Game() {
        return this.extra2Game;
    }

    public final Map<String, String> getExtra2Sever() {
        return this.extra2Sever;
    }

    public final String getGameIcon() {
        return this.gameIcon;
    }

    public final String getGameId() {
        return this.gameId;
    }

    public final String getGameName() {
        return this.gameName;
    }

    public final LiveGameOrientation getGameOrientation() {
        return this.gameOrientation;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LiveCloudGameStartParam(String r100, String r101, String r102, String r103, List<? extends Pair<String, ? extends Object>> r104, Map<String, String> r105, LiveGameOrientation r106) {
        Intrinsics.checkNotNullParameter(r100, "gameName");
        Intrinsics.checkNotNullParameter(r101, "gameIcon");
        Intrinsics.checkNotNullParameter(r102, "gameId");
        Intrinsics.checkNotNullParameter(r103, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(r106, "gameOrientation");
        this.gameName = r100;
        this.gameIcon = r101;
        this.gameId = r102;
        this.channelId = r103;
        this.extra2Game = r104;
        this.extra2Sever = r105;
        this.gameOrientation = r106;
    }
}
