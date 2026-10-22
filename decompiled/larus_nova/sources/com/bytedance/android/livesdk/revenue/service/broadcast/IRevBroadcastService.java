package com.bytedance.android.livesdk.revenue.service.broadcast;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import xp2.j;

/* JADX INFO: loaded from: classes11.dex */
public interface IRevBroadcastService extends dy0.a, com.bytedance.live.kmp.core.c {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/service/broadcast/IRevBroadcastService$BroadcastBizKey;", "", "MONITOR_RANK_ENTRANCE_CREATE_CARD", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum BroadcastBizKey extends Enum<BroadcastBizKey> {
        public static final BroadcastBizKey MONITOR_RANK_ENTRANCE_CREATE_CARD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BroadcastBizKey[] f157288a = null;

        static {
            BroadcastBizKey r100 = new BroadcastBizKey();
            MONITOR_RANK_ENTRANCE_CREATE_CARD = r100;
            f157288a = new BroadcastBizKey[]{r100};
        }

        public static BroadcastBizKey valueOf(String r100) {
            return (BroadcastBizKey) r27.a.a(BroadcastBizKey.class, r100);
        }

        public static BroadcastBizKey[] values() {
            return (BroadcastBizKey[]) f157288a.clone();
        }

        public BroadcastBizKey() {
            super("MONITOR_RANK_ENTRANCE_CREATE_CARD", 0);
        }
    }

    void J4(BroadcastBizKey r100);

    boolean Li(List<String> r100);

    void Ng();

    void Rk(BroadcastBizKey r100);

    Observable<Integer> W5();

    j b2(DataCenter r100);

    void downloadRequirements(List<String> r100);

    xp2.d getAudienceGameContext();

    boolean isPlayingGame();

    void markPopupShown(int r100);

    boolean rejectPkWhenReceiveCloudGroupLiveInvite();

    Observable<Response<Object>> reportRoomEvent(int r100, long r101, int r102, String r103);

    boolean shouldShowGuidePromptBubble(int r100);
}
