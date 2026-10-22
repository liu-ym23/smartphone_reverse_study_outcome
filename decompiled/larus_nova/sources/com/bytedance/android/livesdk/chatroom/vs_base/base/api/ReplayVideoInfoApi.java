package com.bytedance.android.livesdk.chatroom.vs_base.base.api;

import am3.g;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSRoomIDData;
import com.bytedance.android.livesdkapi.depend.model.live.episode._Episode_ProtoDecoder;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0017J`\u0010\r\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b\u0018\u00010\n2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0004H'Jo\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0004H'¢\u0006\u0004\b\u0010\u0010\u0011J*\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\n2\b\b\u0001\u0010\u0012\u001a\u00020\u00042\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0004H'¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/base/api/ReplayVideoInfoApi;", "", "", "episodeId", "", "scene", "enterType", "liveReason", "enterSource", "enterSourceExtra", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/Episode;", "getCastScreenInfo", "episodeIds", "Lcom/bytedance/android/livesdk/chatroom/vs_base/base/api/ReplayVideoInfoApi$b;", "preGetEpisode", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "uid", "source", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSRoomIDData;", "preQueryVSRoomData", "b", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ReplayVideoInfoApi {

    public static final class a {
        public static /* synthetic */ Observable a(ReplayVideoInfoApi r100, Long r101, String r110, String r111, String r112, String r113, String r114, int r115) {
            if ((r115 & 4) == 0) goto L5;
            String r102 = null;
        L7:
            if ((r115 & 8) == 0) goto L9;
            r111 = "";
        L9:
            String r103 = r111;
            if ((r115 & 16) == 0) goto L12;
            String r104 = null;
        L14:
            if ((r115 & 32) == 0) goto L16;
            String r105 = null;
        L18:
            if ((r115 & 64) == 0) goto L20;
            String r106 = null;
        L22:
            return r100.preGetEpisode(r101, "pre_load_video_info", r102, r103, r104, r105, r106);
        L20:
            r106 = r114;
            goto L22
        L16:
            r105 = r113;
            goto L18
        L12:
            r104 = r112;
            goto L14
        L5:
            r102 = r110;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/base/api/ReplayVideoInfoApi$b;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/Episode;", "episode", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/Episode;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/Episode;", "setEpisode", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/Episode;)V", "", "episodeList", "Ljava/util/List;", "b", "()Ljava/util/List;", "c", "(Ljava/util/List;)V", "<init>", "()V", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b implements h {

        @SerializedName("episode")
        protected Episode episode;

        @SerializedName("episodes")
        protected List<? extends Episode> episodeList;

        public b() {
        }

        public b(g r100) {
            this.episodeList = new ArrayList();
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L12;
            if (r102 != 1) goto L8;
            this.episode = _Episode_ProtoDecoder.decodeStatic(r100);
            goto L3
        L8:
            if (r102 != 2) goto L9;
            this.episodeList.add(_Episode_ProtoDecoder.decodeStatic(r100));
            goto L3
        L9:
            am3.h.e(r100);
            goto L3
        L12:
            r100.d(r101);
        }

        public final Episode a() {
            return this.episode;
        }

        public final List<Episode> b() {
            return this.episodeList;
        }

        public final void c(List<? extends Episode> r100) {
            this.episodeList = r100;
        }
    }

    @GET("/webcast/show/episode/info/")
    Observable<Response<Episode>> getCastScreenInfo(@Query("episode_id") long r100, @Query("scene") String r101, @Query(ILiveRoomPlayFragmentConstant.EXTRA_HEAD_ENTER_TYPE) String r102, @Query("live_reason") String r103, @Query(com.bytedance.android.ec.core.event.a.KEY_ENTER_SOURCE) String r104, @Query("enter_source_extra") String r105);

    @GET("/webcast/show/episode/preload/")
    Observable<Response<b>> preGetEpisode(@Query("episode_id") Long r100, @Query("scene") String r101, @Query(ILiveRoomPlayFragmentConstant.EXTRA_HEAD_ENTER_TYPE) String r102, @Query("live_reason") String r103, @Query(com.bytedance.android.ec.core.event.a.KEY_ENTER_SOURCE) String r104, @Query("enter_source_extra") String r105, @Query("episode_ids") String r106);

    @GET("/webcast/show/schema_info/preload/")
    Observable<e<VSRoomIDData>> preQueryVSRoomData(@Query("user_id") String r100, @Query(com.bytedance.android.ec.core.event.a.KEY_ENTER_SOURCE) String r101);
}
