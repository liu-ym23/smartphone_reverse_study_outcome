package com.bytedance.android.livehostapi.business;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.business.castscreen.interfaces.ILiveCastMatchRoomLandScapeAnimCallback;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J:\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H&¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/IHostMultiDeviceResume;", "Lcom/bytedance/android/live/base/IService;", "canUseNew", "", "hostIconEnable", "liveIconOpt", "startResume", "", "isLandScape", "roomId", "", "anchorId", "", "roomSchema", "pointData", "callback", "Lcom/bytedance/android/livehostapi/business/castscreen/interfaces/ILiveCastMatchRoomLandScapeAnimCallback;", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IHostMultiDeviceResume extends IService {
    boolean canUseNew();

    boolean hostIconEnable();

    boolean liveIconOpt();

    void startResume(boolean r100, long r101, String r102, String r103, String r104, ILiveCastMatchRoomLandScapeAnimCallback r105);
}
