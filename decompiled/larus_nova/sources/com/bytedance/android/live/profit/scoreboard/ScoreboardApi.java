package com.bytedance.android.live.profit.scoreboard;

import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J2\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u0004H'J(\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'JP\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\r\u001a\u00020\u00042\b\b\u0001\u0010\u000e\u001a\u00020\u00042\b\b\u0001\u0010\u000f\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u0004H'J@\u0010\u0018\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0016j\u0002`\u00170\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0013\u001a\u00020\u00042\b\b\u0001\u0010\u0015\u001a\u00020\u0014H'J6\u0010\u001a\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0016j\u0002`\u00190\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0013\u001a\u00020\u0004H'¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/profit/scoreboard/ScoreboardApi;", "", "", "miniAppId", "", "roomId", "counterId", "Lio/reactivex/Single;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/profit/scoreboard/dto/m;", "getCounterInfo", "Lcom/bytedance/android/live/profit/scoreboard/dto/l;", "getCounterConfig", "otherRoomId", "duration", "counterSettings", "prevRoundId", "Lcom/bytedance/android/live/profit/scoreboard/dto/g;", "gameRoundStart", "roundId", "", "accept", "", "Lcom/bytedance/android/live/profit/scoreboard/dto/GameRoundAcceptResponse;", "gameRoundAccept", "Lcom/bytedance/android/live/profit/scoreboard/dto/GameRoundReadyResponse;", "gameRoundReady", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ScoreboardApi {
    @GET("/webcast/openapi/tool/round/accept/")
    Single<com.bytedance.android.live.network.response.e<Unit>> gameRoundAccept(@Query("app_id") String r100, @Query("room_id") long r101, @Query("round_id") long r102, @Query("accept") boolean r103);

    @GET("/webcast/openapi/tool/round/ready/")
    Single<com.bytedance.android.live.network.response.e<Unit>> gameRoundReady(@Query("app_id") String r100, @Query("room_id") long r101, @Query("round_id") long r102);

    @GET("/webcast/openapi/tool/round/start/")
    Single<com.bytedance.android.live.network.response.e<com.bytedance.android.live.profit.scoreboard.dto.g>> gameRoundStart(@Query("app_id") String r100, @Query("room_id") long r101, @Query("other_room_id") long r102, @Query("duration") long r103, @Query("counter_settings") String r104, @Query("prev_round_id") long r105);

    @GET("/webcast/openapi/tool/counter/config/")
    Single<com.bytedance.android.live.network.response.e<com.bytedance.android.live.profit.scoreboard.dto.l>> getCounterConfig(@Query("app_id") String r100, @Query("room_id") long r101);

    @GET("/webcast/openapi/tool/counter/info/")
    Single<com.bytedance.android.live.network.response.e<com.bytedance.android.live.profit.scoreboard.dto.m>> getCounterInfo(@Query("app_id") String r100, @Query("room_id") long r101, @Query("counter_id") long r102);
}
