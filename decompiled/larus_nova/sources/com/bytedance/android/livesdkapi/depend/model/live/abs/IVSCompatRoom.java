package com.bytedance.android.livesdkapi.depend.model.live.abs;

import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeBasic;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSToolbarConfigData;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH&J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH&J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\bH&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/abs/IVSCompatRoom;", "Lcom/bytedance/android/livesdkapi/depend/model/live/abs/IRoomData;", "getEpID", "", "()Ljava/lang/Long;", "getEpisodeBasic", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodeBasic;", "getPannelToolbarList", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSToolbarConfigData;", "getRoomAuthStatus", "Lcom/bytedance/android/livesdkapi/depend/model/live/RoomAuthStatus;", "getToolbarList", "getVsRoles", "", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IVSCompatRoom extends IRoomData {
    Long getEpID();

    EpisodeBasic getEpisodeBasic();

    List<VSToolbarConfigData> getPannelToolbarList();

    @Override // com.bytedance.android.livesdkapi.depend.model.live.abs.IRoomData
    RoomAuthStatus getRoomAuthStatus();

    List<VSToolbarConfigData> getToolbarList();

    List<Integer> getVsRoles();
}
