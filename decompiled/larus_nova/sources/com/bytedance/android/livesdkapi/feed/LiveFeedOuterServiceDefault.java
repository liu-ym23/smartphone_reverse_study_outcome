package com.bytedance.android.livesdkapi.feed;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.IService;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\u001c\u0010\u0016\u001a\u00020\u000b2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u0012\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0019\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u001a\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u001b\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\u001c\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/LiveFeedOuterServiceDefault;", "Lcom/bytedance/android/livesdkapi/feed/ILiveFeedOuterService;", "()V", "appContext", "Landroid/content/Context;", "createDrawerFeedFragment", "Landroidx/fragment/app/Fragment;", "createLiveFeedFragment", "currentLocale", "Ljava/util/Locale;", "delayInit", "", "feedProtoInit", "feedUrlService", "Lcom/bytedance/android/live/base/IService;", "getSettingExtraParams", "", "", "hasShowFlowRemindInOneMonth", "", PerfLog.PARAM_KEY_CONTEXT_ID, "init", "putCommonParams", "liveCommonParams", "setAppContext", "showRecordPublishChannelDot", "updateFlowRemind", "updateRecordPublishChannel", "updateSettings", "settings", "Lcom/google/gson/JsonObject;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveFeedOuterServiceDefault implements ILiveFeedOuterService {
    public LiveFeedOuterServiceDefault() {
    }

    @Override // com.bytedance.android.livesdkapi.feed.ILiveFeedOuterService
    public Context appContext() {
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.feed.ILiveFeedOuterService
    public Fragment createDrawerFeedFragment() {
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.feed.ILiveFeedOuterService
    public Fragment createLiveFeedFragment() {
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.feed.ILiveFeedOuterService
    public Locale currentLocale() {
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.feed.ILiveFeedOuterService
    public void delayInit() {
    }

    @Override // com.bytedance.android.livesdkapi.feed.ILiveFeedOuterService
    public void feedProtoInit() {
    }

    @Override // com.bytedance.android.livesdkapi.feed.ILiveFeedOuterService
    public IService feedUrlService() {
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.feed.ILiveFeedOuterService
    public boolean hasShowFlowRemindInOneMonth(Context r100) {
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.feed.ILiveFeedOuterService
    public void init() {
    }

    @Override // com.bytedance.android.livesdkapi.feed.ILiveFeedOuterService
    public void putCommonParams(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "liveCommonParams");
    }

    @Override // com.bytedance.android.livesdkapi.feed.ILiveFeedOuterService
    public void setAppContext(Context r100) {
    }

    @Override // com.bytedance.android.livesdkapi.feed.ILiveFeedOuterService
    public boolean showRecordPublishChannelDot(Context r100) {
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.feed.ILiveFeedOuterService
    public void updateFlowRemind(Context r100) {
    }

    @Override // com.bytedance.android.livesdkapi.feed.ILiveFeedOuterService
    public void updateRecordPublishChannel(Context r100) {
    }

    @Override // com.bytedance.android.livesdkapi.feed.ILiveFeedOuterService
    public void updateSettings(Context r100, JsonObject r101) {
    }

    @Override // com.bytedance.android.livesdkapi.feed.ILiveFeedOuterService
    public Map<String, String> getSettingExtraParams() {
        return new LinkedHashMap();
    }
}
