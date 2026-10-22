package com.bytedance.android.service.manager.pull;

import android.content.Context;
import com.bytedance.push.pull.PullScene;

/* JADX INFO: loaded from: classes3.dex */
public class PullExternalServiceImplOfMock implements PullExternalService {
    public PullExternalServiceImplOfMock() {
    }

    @Override // com.bytedance.android.service.manager.pull.PullExternalService
    public boolean allowAutoDismissBadge() {
        return false;
    }

    @Override // com.bytedance.android.service.manager.pull.PullExternalService
    public void initOnApplication() {
    }

    @Override // com.bytedance.android.service.manager.pull.PullExternalService
    public boolean isNeedRequestOldComposeApi(int r100) {
        return false;
    }

    @Override // com.bytedance.android.service.manager.pull.PullExternalService
    public boolean isUseNewAllianceLocalPushApi() {
        return false;
    }

    @Override // com.bytedance.android.service.manager.pull.PullExternalService
    public boolean isUseNewAllianceRedBadgeApi() {
        return false;
    }

    @Override // com.bytedance.android.service.manager.pull.PullExternalService
    public boolean isUseNewApi() {
        return false;
    }

    @Override // com.bytedance.android.service.manager.pull.PullExternalService
    public boolean isUseNewApi(int r100) {
        return false;
    }

    @Override // com.bytedance.android.service.manager.pull.PullExternalService
    public boolean isUseNewOnlineLocalPushApi() {
        return false;
    }

    @Override // com.bytedance.android.service.manager.pull.PullExternalService
    public boolean isUseNewOnlineRedBadgeApi() {
        return false;
    }

    @Override // com.bytedance.android.service.manager.pull.PullExternalService
    public void requestAndShowContent(String r100) {
    }

    @Override // com.bytedance.android.service.manager.pull.PullExternalService
    public void setBadgeNumberToPushSdk(Context r100, int r101, PullScene r102) {
    }

    @Override // com.bytedance.android.service.manager.pull.PullExternalService
    public void start(PullConfiguration r100) {
    }
}
