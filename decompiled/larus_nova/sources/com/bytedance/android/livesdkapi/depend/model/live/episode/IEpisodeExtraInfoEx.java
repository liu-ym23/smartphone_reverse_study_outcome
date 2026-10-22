package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PrivilegeInfo;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\n\u0010\t\u001a\u0004\u0018\u00010\nH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u0016\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\b\u0010\u0012\u001a\u00020\u0013H&J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H&J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH&¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeExtraInfoEx;", "", "getHighLightFirst", "", "getHighlights", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeHighLight;", "getLiveUser", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getOwnerUserIdStr", "", "getPaidInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodePaidInfo;", "getPrivilegeInfo", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PrivilegeInfo;", "getRealMod", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IBaseEpisodeMod;", "getRoomId", "", "getStartHighLight", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeStartHighLight;", "getStatistics", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeStatistics;", "getUserStatistics", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeUserStatistics;", "getVideo", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeVideo;", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IEpisodeExtraInfoEx {
    boolean getHighLightFirst();

    List<IEpisodeHighLight> getHighlights();

    IBaseUser getLiveUser();

    String getOwnerUserIdStr();

    IEpisodePaidInfo getPaidInfo();

    Map<String, PrivilegeInfo> getPrivilegeInfo();

    IBaseEpisodeMod getRealMod();

    long getRoomId();

    IEpisodeStartHighLight getStartHighLight();

    IEpisodeStatistics getStatistics();

    IEpisodeUserStatistics getUserStatistics();

    IEpisodeVideo getVideo();
}
