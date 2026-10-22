package com.bytedance.android.live.platformplayer.test;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceDummyLookup;
import com.bytedance.android.live.utility.ServiceLookup;
import fs0.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@ServiceLookup("com.bytedance.android.livesdk.projectmode.LiveSdkProjectModeServiceImpl")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0006H&¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/platformplayer/test/IPlayerTest;", "Lcom/bytedance/android/live/base/IService;", "", "sei", "", "consumeSei", "Lfs0/a;", "getTestMockData", "platform-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
@ServiceDummyLookup("com.bytedance.android.livesdk.projectmode.LiveSdkProjectModeServiceDummy")
public interface IPlayerTest extends IService {
    void consumeSei(String r100);

    a getTestMockData();
}
