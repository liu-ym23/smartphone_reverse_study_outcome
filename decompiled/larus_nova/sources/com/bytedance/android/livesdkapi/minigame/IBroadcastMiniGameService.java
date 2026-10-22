package com.bytedance.android.livesdkapi.minigame;

import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@ServiceLookup("com.bytedance.android.live.broadcast.BroadcastMiniGameService")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0003H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0014H&¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/minigame/IBroadcastMiniGameService;", "Lcom/bytedance/android/live/base/IService;", "authorize", "", "appContext", "Landroid/content/Context;", "cb", "Lcom/bytedance/android/livesdkapi/minigame/AuthorizeCallback;", "canStartLive", "Lcom/bytedance/android/livesdkapi/minigame/CanStartLiveCallback;", "getAudienceModule", "Lcom/bytedance/android/livesdkapi/minigame/IAudienceModule;", "getMessageModule", "Lcom/bytedance/android/livesdkapi/minigame/IMessageModule;", "getPushStream", "Lcom/bytedance/android/livesdkapi/minigame/IPushStream;", "initTTLiveSDK", "Lcom/bytedance/android/livesdkapi/minigame/InitLiveSDKCallback;", LiveCommonConstants.REASON_ON_DEDTROY, "twoElementAuth", "Lcom/bytedance/android/livesdkapi/minigame/TwoElementAuthCallback;", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IBroadcastMiniGameService extends IService {
    void authorize(Context r100, AuthorizeCallback r101);

    void canStartLive(CanStartLiveCallback r100);

    IAudienceModule getAudienceModule();

    IMessageModule getMessageModule();

    IPushStream getPushStream();

    void initTTLiveSDK(InitLiveSDKCallback r100);

    void onDestroy();

    void twoElementAuth(TwoElementAuthCallback r100);
}
