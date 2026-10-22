package com.bytedance.android.live.openplatform.api.minigame;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleObserver;
import com.alipay.sdk.m.p.e;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.broadcast.api.model.PreviewSourceParam;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.utility.ServiceDummyLookup;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.log.filter.v;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import h70.b;
import j70.h;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
@ServiceLookup("com.bytedance.android.live.openplatform.impl.base.OpenPlatformMgAnchorServiceImpl")
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0004\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0002H&J&\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\u001c\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH&J0\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0015H&J\b\u0010\u0019\u001a\u00020\u0018H&J\u0018\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH&J\b\u0010\u001d\u001a\u00020\u000fH&J\b\u0010\u001e\u001a\u00020\u000fH&J\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u0018H&J\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0005H&J:\u0010&\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u00112(\b\u0002\u0010%\u001a\"\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010#j\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u0001`$H&J\u0014\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110'H&J\u0014\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110'H&J\u001c\u0010,\u001a\u00020\u000f2\b\u0010*\u001a\u0004\u0018\u00010\u00112\b\u0010+\u001a\u0004\u0018\u00010\u0011H&J\b\u0010-\u001a\u00020\u0018H&J\u0016\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020/\u0018\u00010.H&J\u001c\u00102\u001a\u00020\u000f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001101H&¨\u00063"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/minigame/IOpenPlatformMgAnchorService;", "Lcom/bytedance/android/live/openplatform/api/minigame/IOpenPlatformMgService;", "Lj70/h;", "Lh70/b;", "getAnchorMiniGameWidgetDescriptor", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/view/ViewGroup;", "containerView", "Lcom/bytedance/android/live/broadcast/api/model/PreviewSourceParam;", "previewSourceParam", "Landroidx/lifecycle/LifecycleObserver;", "getPreviewMiniGameWidgetLifecycleObserver", "Lorg/json/JSONObject;", "params", "", "openBottomFeaturePanel", "", e.f25671s, "Lcom/google/gson/JsonObject;", "param", "Lkotlin/Function1;", "callback", "handleCommonJSBInvoke", "", "isMiniGameMounted", "Lcom/bytedance/android/live/broadcastgame/api/model/u;", MapController.ITEM_LAYER_TAG, "mount", "unmount", "openMountedGame", "isMount", "setMountStatus", "previewItemClick", "event", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "extra", "reportMiniGameAppLog", "", "getMiniGameAppCommonLogMap", "getMiniGameLotteryCommonLogMap", "fromTaskId", "toTaskId", "previewSwitchTask", "isOpeningLynxPanelInGame", "Lkotlin/Pair;", "Lcom/bytedance/android/livesdk/log/filter/v;", "provideMgParams2LogInjector", "", "injectMgParams", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
@ServiceDummyLookup("com.bytedance.android.live.openpMglatform.api.minigame.OpenPlatformMgAnchorServiceDummy")
public interface IOpenPlatformMgAnchorService extends IOpenPlatformMgService {
    h<? extends b> getAnchorMiniGameWidgetDescriptor();

    Map<String, String> getMiniGameAppCommonLogMap();

    Map<String, String> getMiniGameLotteryCommonLogMap();

    LifecycleObserver getPreviewMiniGameWidgetLifecycleObserver(Context r100, ViewGroup r101, PreviewSourceParam r102);

    void handleCommonJSBInvoke(String r100, JsonObject r101, Function1<? super JsonObject, Unit> r102);

    void injectMgParams(Map<String, String> r100);

    boolean isMiniGameMounted();

    boolean isOpeningLynxPanelInGame();

    void mount(Context r100, u r101);

    void openBottomFeaturePanel(Context r100, JSONObject r101);

    void openMountedGame();

    void previewItemClick(Context r100);

    void previewSwitchTask(String r100, String r101);

    Pair<String, v> provideMgParams2LogInjector();

    void reportMiniGameAppLog(String r100, HashMap<String, String> r101);

    void setMountStatus(boolean r100);

    void unmount();
}
