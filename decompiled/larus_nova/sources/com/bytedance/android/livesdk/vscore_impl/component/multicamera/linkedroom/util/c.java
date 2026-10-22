package com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.util;

import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSLinkedRoomInfo;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR0\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_impl/component/multicamera/linkedroom/util/c;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSLinkedRoomInfo;", "linkedRoomInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSLinkedRoomInfo;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSLinkedRoomInfo;", "setLinkedRoomInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSLinkedRoomInfo;)V", "", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/Episode;", "roomEpisodeMap", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "setRoomEpisodeMap", "(Ljava/util/Map;)V", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("link_info")
    private VSLinkedRoomInfo linkedRoomInfo;

    @SerializedName("room_episode_map")
    private Map<Long, ? extends Episode> roomEpisodeMap;

    public c() {
    }

    public final VSLinkedRoomInfo a() {
        return this.linkedRoomInfo;
    }

    public final Map<Long, Episode> b() {
        return this.roomEpisodeMap;
    }
}
