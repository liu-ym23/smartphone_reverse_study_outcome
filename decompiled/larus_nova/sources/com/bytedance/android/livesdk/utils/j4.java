package com.bytedance.android.livesdk.utils;

import com.bytedance.android.livesdk.projectmode.ILiveSdkProjectModeService;
import com.bytedance.android.livesdkapi.service.ILiveStreamMockService;

/* JADX INFO: loaded from: classes11.dex */
public final class j4 implements ILiveStreamMockService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j4 f158997a = null;

    public j4() {
    }

    static {
        f158997a = new j4();
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveStreamMockService
    public final String getMockResolution() {
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L7;
        ((ILiveSdkProjectModeService) jc1.k.n(ILiveSdkProjectModeService.class)).getTestMockData().a();
        return null;
    L7:
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveStreamMockService
    public final String getMockStreamData() {
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L7;
        ((ILiveSdkProjectModeService) jc1.k.n(ILiveSdkProjectModeService.class)).getTestMockData().a();
        return null;
    L7:
        return null;
    }
}
