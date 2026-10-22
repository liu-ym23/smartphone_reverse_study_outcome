package com.bytedance.android.livesdk.chatroom.progressbar;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ServiceLookup("com.bytedance.android.livesdk.chatroom.playback4live.LivePlaybackCastService")
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u001a\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&J\b\u0010\u000f\u001a\u00020\nH&J\b\u0010\u0010\u001a\u00020\nH&¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/progressbar/IProgressCastService;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/android/livesdk/chatroom/progressbar/b;", "getProgressCastStreamShiftService", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "", "isByteMatchCasting", "Lcom/bytedance/live/datacontext/m;", "castScreenMode", "", "liveGoRealTime", "", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, "seekTo", "pause", "resume", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IProgressCastService extends IService {
    m<Boolean> castScreenMode(DataCenter r100);

    b getProgressCastStreamShiftService();

    boolean isByteMatchCasting(DataCenter r100);

    void liveGoRealTime();

    void pause();

    void resume();

    void seekTo(long r100);
}
