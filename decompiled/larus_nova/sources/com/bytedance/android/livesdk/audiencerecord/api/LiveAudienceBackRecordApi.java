package com.bytedance.android.livesdk.audiencerecord.api;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdkapi.depend.model.backtrace.AudienceBackRecordData;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.Url;
import io.reactivex.Observable;

/* JADX INFO: loaded from: classes7.dex */
public interface LiveAudienceBackRecordApi {
    @GET("/webcast/room/backrecord/audience/")
    Observable<Response<AudienceBackRecordData>> queryAudienceBacktrack(@Query("room_id") long r100, @Query("record_seconds") long r101, @Query("delayed_seconds") long r102, @Query("end_time") long r103);

    @GET
    Call<String> queryM3U8(@Url String r100);

    @GET("/webcast/show/backrecord/audience/")
    Observable<Response<AudienceBackRecordData>> queryVideoAudienceBacktrack(@Query("episode_id") long r100, @Query("record_seconds") long r101, @Query("delayed_seconds") long r102, @Query("end_time") long r103);
}
