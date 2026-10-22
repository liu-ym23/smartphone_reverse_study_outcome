package com.bytedance.android.livesdk.player.roisr;

import android.graphics.RectF;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ServiceLookup("com.bytedance.android.livesdk.player.roisr.RoiSrServiceImpl")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\"\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH&J1\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0002\u0010\u000fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/player/roisr/IRoiSrService;", "Lcom/bytedance/android/live/base/IService;", "forceClose", "", "close", "", "init", "update", "player", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "enable", EffectConfiguration.KEY_REGION, "Landroid/graphics/RectF;", "bgColor", "", "(Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;ZLandroid/graphics/RectF;Ljava/lang/Long;)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IRoiSrService extends IService {
    void forceClose(boolean r100);

    void init();

    void update(ILivePlayerClient r100, boolean r101, RectF r102);

    void update(ILivePlayerClient r100, boolean r101, RectF r102, Long r103);
}
