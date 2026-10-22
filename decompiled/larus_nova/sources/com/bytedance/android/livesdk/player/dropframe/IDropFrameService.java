package com.bytedance.android.livesdk.player.dropframe;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ServiceLookup("com.bytedance.android.livesdk.player.dropframe.DropFrameServiceImpl")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J \u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/player/dropframe/IDropFrameService;", "Lcom/bytedance/android/live/base/IService;", "init", "", "setDropFrame", "enable", "", "dropInterval", "minFrameRate", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IDropFrameService extends IService {
    void init();

    void setDropFrame(int r100, int r101, int r102);
}
