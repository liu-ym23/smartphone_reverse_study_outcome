package com.bytedance.android.live.room.api.experience.service;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import g61.a;
import kotlin.Metadata;
import l61.b;

/* JADX INFO: loaded from: classes47.dex */
@ServiceLookup("com.bytedance.android.live.service.LiveTopSpeedExpService")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u000b\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\u0006H&J\b\u0010\r\u001a\u00020\u0006H&J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH&¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/room/api/experience/service/ILiveTopSpeedExpService;", "Lcom/bytedance/android/live/base/IService;", "Ll61/b;", "scene", "Lg61/a;", "listener", "", "registerExpBizListener", "unregisterExpBizListener", "", "isDegradingForScene", "isDegradingForSwitch", "showExpOptDialog", "showTopSpeedGuideDialog", "", "prefCode", "riskCode", "showTopSpeedPush", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveTopSpeedExpService extends IService {
    boolean isDegradingForScene(b r100);

    boolean isDegradingForSwitch();

    void registerExpBizListener(b r100, a r101);

    void showExpOptDialog();

    void showTopSpeedGuideDialog();

    void showTopSpeedPush(int r100, int r101);

    void unregisterExpBizListener(b r100, a r101);
}
