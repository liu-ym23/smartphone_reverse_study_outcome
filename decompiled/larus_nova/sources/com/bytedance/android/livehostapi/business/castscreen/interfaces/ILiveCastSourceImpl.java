package com.bytedance.android.livehostapi.business.castscreen.interfaces;

import com.bytedance.android.livehostapi.business.castscreen.bean.LiveCastDanmakuSetting;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/castscreen/interfaces/ILiveCastSourceImpl;", "", "addVolume", "", "step", "", "pause", "resume", "seekTo", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, "", "seekToEnd", "", "subVolume", "updateDanmakuSetting", "danmakuSetting", "Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastDanmakuSetting;", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveCastSourceImpl {
    void addVolume(int r100);

    void pause();

    void resume();

    void seekTo(long r100, boolean r101);

    void subVolume(int r100);

    void updateDanmakuSetting(LiveCastDanmakuSetting r100);
}
