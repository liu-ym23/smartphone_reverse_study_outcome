package com.bytedance.android.livesdkapi.feed;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@ServiceLookup("com.bytedance.android.livesdk.feed.LiveFeedOuterService")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\nH&J\n\u0010\f\u001a\u0004\u0018\u00010\u0001H&J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH&J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0013\u001a\u00020\nH&J\u001c\u0010\u0014\u001a\u00020\n2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH&J\u0012\u0010\u0016\u001a\u00020\n2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010\u0017\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010\u0018\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010\u0019\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H&J\u001c\u0010\u001a\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH&¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/ILiveFeedOuterService;", "Lcom/bytedance/android/live/base/IService;", "appContext", "Landroid/content/Context;", "createDrawerFeedFragment", "Landroidx/fragment/app/Fragment;", "createLiveFeedFragment", "currentLocale", "Ljava/util/Locale;", "delayInit", "", "feedProtoInit", "feedUrlService", "getSettingExtraParams", "", "", "hasShowFlowRemindInOneMonth", "", PerfLog.PARAM_KEY_CONTEXT_ID, "init", "putCommonParams", "liveCommonParams", "setAppContext", "showRecordPublishChannelDot", "updateFlowRemind", "updateRecordPublishChannel", "updateSettings", "settings", "Lcom/google/gson/JsonObject;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveFeedOuterService extends IService {
    Context appContext();

    Fragment createDrawerFeedFragment();

    Fragment createLiveFeedFragment();

    Locale currentLocale();

    void delayInit();

    void feedProtoInit();

    IService feedUrlService();

    Map<String, String> getSettingExtraParams();

    boolean hasShowFlowRemindInOneMonth(Context r100);

    void init();

    void putCommonParams(Map<String, String> r100);

    void setAppContext(Context r100);

    boolean showRecordPublishChannelDot(Context r100);

    void updateFlowRemind(Context r100);

    void updateRecordPublishChannel(Context r100);

    void updateSettings(Context r100, JsonObject r101);
}
