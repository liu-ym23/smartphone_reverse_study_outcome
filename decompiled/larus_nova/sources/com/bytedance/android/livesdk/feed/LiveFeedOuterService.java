package com.bytedance.android.livesdk.feed;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.core.setting.CoreSettingKeys;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.android.live.core.setting.TTLiveSettingUtil;
import com.bytedance.android.live.network.api.INetworkService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livesdk.feed.context.LiveFeedContext;
import com.bytedance.android.livesdk.feed.drawerfeed.DrawerFeedLiveFragment;
import com.bytedance.android.livesdk.feed.fragment.FeedLiveFragment;
import com.bytedance.android.livesdk.feed.tab.FeedUrlService;
import com.bytedance.android.livesdkapi.feed.ILiveFeedOuterService;
import com.bytedance.android.livesdkapi.init.LiveInitAssistant;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\u001c\u0010\u0016\u001a\u00020\u000b2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u0012\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0019\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u001a\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u001b\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\u001c\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/feed/LiveFeedOuterService;", "Lcom/bytedance/android/livesdkapi/feed/ILiveFeedOuterService;", "()V", "appContext", "Landroid/content/Context;", "createDrawerFeedFragment", "Landroidx/fragment/app/Fragment;", "createLiveFeedFragment", "currentLocale", "Ljava/util/Locale;", "delayInit", "", "feedProtoInit", "feedUrlService", "Lcom/bytedance/android/live/base/IService;", "getSettingExtraParams", "", "", "hasShowFlowRemindInOneMonth", "", PerfLog.PARAM_KEY_CONTEXT_ID, "init", "putCommonParams", "liveCommonParams", "setAppContext", "showRecordPublishChannelDot", "updateFlowRemind", "updateRecordPublishChannel", "updateSettings", "settings", "Lcom/google/gson/JsonObject;", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveFeedOuterService implements ILiveFeedOuterService {
    public LiveFeedOuterService() {
    }

    @Override // com.bytedance.android.livesdkapi.feed.ILiveFeedOuterService
    public Map<String, String> getSettingExtraParams() {
        if (LiveInitAssistant.INSTANCE.getInitOptimizeConfig().getPreInitLiveOptV2() == true) goto L6;
        init();
    L6:
        return TTLiveSettingUtil.getSettingExtraParams();
    }

    @Override // com.bytedance.android.livesdkapi.feed.ILiveFeedOuterService
    public Context appContext() {
        init();
        return LiveFeedContext.appContext();
    }

    @Override // com.bytedance.android.livesdkapi.feed.ILiveFeedOuterService
    public Fragment createDrawerFeedFragment() {
        init();
        return new DrawerFeedLiveFragment();
    }

    @Override // com.bytedance.android.livesdkapi.feed.ILiveFeedOuterService
    public Fragment createLiveFeedFragment() {
        init();
        ((nv1.e) LiveFeedContext.getService()).getClass();
        return new FeedLiveFragment();
    }

    @Override // com.bytedance.android.livesdkapi.feed.ILiveFeedOuterService
    public Locale currentLocale() {
        init();
        return LiveFeedContext.currentLocale();
    }

    @Override // com.bytedance.android.livesdkapi.feed.ILiveFeedOuterService
    public void delayInit() {
        init();
        LiveFeedContext.delayInit();
    }

    @Override // com.bytedance.android.livesdkapi.feed.ILiveFeedOuterService
    public void feedProtoInit() {
        init();
        LiveFeedContext.feedProtoInit();
    }

    @Override // com.bytedance.android.livesdkapi.feed.ILiveFeedOuterService
    public IService feedUrlService() {
        init();
        return new FeedUrlService();
    }

    @Override // com.bytedance.android.livesdkapi.feed.ILiveFeedOuterService
    public void init() {
        if (TTLiveSDK.hostService() == null) goto L5;
        LiveFeedContext.init(TTLiveSDK.hostService());
        return;
    L5:
        com.bytedance.android.livesdk.log.b0 r100 = com.bytedance.android.livesdk.log.b0.o();
        Throwable r101 = new Throwable("LiveFeedOuterService init: hostService empty");
        r100.getClass();
        com.bytedance.android.live.core.log.g.e("ttlive_init", r101);
    }

    @Override // com.bytedance.android.livesdkapi.feed.ILiveFeedOuterService
    public boolean hasShowFlowRemindInOneMonth(Context r100) {
        init();
        if (r100 == null) goto L10;
        SharedPreferences r101 = r100.getSharedPreferences("ttlive_open_sdk_shared_pref_cache", 0);
        if (r101 == null) goto L11;
        long r102 = r101.getLong("key_ttlive_sdk_flow_remind", 0);
        if (((int) ((System.currentTimeMillis() - r102) / 86400000)) > 30) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    L10:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.feed.ILiveFeedOuterService
    public void putCommonParams(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "liveCommonParams");
        LiveInitAssistant r101 = LiveInitAssistant.INSTANCE;
        if (r101.getInitOptimizeConfig().getPreInitLiveOptV2() == true) goto L6;
        init();
    L6:
        if (r101.getInitOptimizeConfig().getPreInitLiveOptV2() == false) goto L8;
        INetworkService r102 = (INetworkService) jc1.k.b(INetworkService.class);
    L9:
        if (r102 == null) goto L11;
        r102.putCommonParams(r100);
        return;
    L11:
        if (r101.getInitOptimizeConfig().getPreInitLiveOptV2() == false) goto L13;
        new com.bytedance.android.live.network.impl.interceptor.c().b(r100);
        return;
    L13:
        String[] r103 = {"CN", "MR", "SA", "FR", "AE"};
        r100.put("webcast_sdk_version", String.valueOf(com.bytedance.android.livesdk.paas.c.b()));
        r100.put("webcast_locale", Resources.getSystem().getConfiguration().locale.toString());
        if (SettingUtil.isLocalTest() == false) goto L25;
        int r104 = CoreSettingKeys.TEST_FAKE_REGION.getValue().intValue();
        if (r104 >= 0) goto L18;
    L20:
        String r105 = "";
    L21:
        r100.put("fake_region", r105);
        return;
    L18:
        if (r104 >= 5) goto L20;
        r105 = r103[r104];
        goto L21
    L25:
        return;
    L8:
        r102 = (INetworkService) jc1.k.f(INetworkService.class);
        goto L9
    }

    @Override // com.bytedance.android.livesdkapi.feed.ILiveFeedOuterService
    public void setAppContext(Context r100) {
        if (LiveInitAssistant.INSTANCE.getInitOptimizeConfig().getPreInitLiveOptV2() == true) goto L5;
        init();
    L5:
        LiveFeedContext.setAppContext(r100);
    }

    @Override // com.bytedance.android.livesdkapi.feed.ILiveFeedOuterService
    public boolean showRecordPublishChannelDot(Context r100) {
        init();
        if (r100 == null) goto L8;
        SharedPreferences r101 = r100.getSharedPreferences("ttlive_open_sdk_shared_pref_cache", 0);
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.getBoolean("key_ttlive_sdk_record_publish_channel_tools", true);
    L8:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.feed.ILiveFeedOuterService
    public void updateFlowRemind(Context r100) {
        init();
        if (r100 == null) goto L8;
        SharedPreferences r101 = r100.getSharedPreferences("ttlive_open_sdk_shared_pref_cache", 0);
        if (r101 == null) goto L9;
        r101.edit().putLong("key_ttlive_sdk_flow_remind", System.currentTimeMillis()).apply();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.feed.ILiveFeedOuterService
    public void updateRecordPublishChannel(Context r100) {
        init();
        if (r100 == null) goto L8;
        SharedPreferences r101 = r100.getSharedPreferences("ttlive_open_sdk_shared_pref_cache", 0);
        if (r101 == null) goto L9;
        r101.edit().putBoolean("key_ttlive_sdk_record_publish_channel_tools", false).apply();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.feed.ILiveFeedOuterService
    public void updateSettings(Context r100, JsonObject r101) {
        if (LiveInitAssistant.INSTANCE.getInitOptimizeConfig().getPreInitLiveOptV2() == true) goto L5;
        init();
    L5:
        TTLiveSettingUtil.updateSettings(r100, r101);
    }
}
