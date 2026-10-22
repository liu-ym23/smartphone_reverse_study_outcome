package com.bytedance.android.service.manager.pull;

import android.content.Context;
import com.bytedance.android.push.service.manager.annotation.ExternalService;
import com.bytedance.push.pull.PullScene;

/* JADX INFO: loaded from: classes3.dex */
@ExternalService
public interface PullExternalService {
    boolean allowAutoDismissBadge();

    void initOnApplication();

    boolean isNeedRequestOldComposeApi(int r100);

    boolean isUseNewAllianceLocalPushApi();

    boolean isUseNewAllianceRedBadgeApi();

    boolean isUseNewApi();

    boolean isUseNewApi(int r100);

    boolean isUseNewOnlineLocalPushApi();

    boolean isUseNewOnlineRedBadgeApi();

    void requestAndShowContent(String r100);

    void setBadgeNumberToPushSdk(Context r100, int r101, PullScene r102);

    void start(PullConfiguration r100);
}
