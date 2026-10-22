package com.bytedance.android.livesdkapi.gamestickerv2;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerScene;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0013H&J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\u001a\u001a\u00020\u001bH&¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdkapi/gamestickerv2/IGameStickerServiceV2;", "", "buildContainerViewProxy", "Lcom/bytedance/android/livesdkapi/gamestickerv2/IGameStickerContainerViewProxy;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "roomId", "", "scene", "Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/GameStickerScene;", "getDataContext", "Lcom/bytedance/android/livesdkapi/gamestickerv2/IGameStickerContext;", "getLandscapeCalculator", "Lcom/bytedance/android/livesdkapi/gamestickerv2/ILandscapeLayoutCalculator;", "getPortraitCalculator", "Lcom/bytedance/android/livesdkapi/gamestickerv2/IPortraitLayoutCalculator;", "getSetting", "Lcom/bytedance/android/livesdkapi/gamestickerv2/IGameStickerSetting;", "getTaskManager", "Lcom/bytedance/android/livesdkapi/gamestickerv2/IGameStickerTaskManager;", "initDataContext", "", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "stickerTypeRoomCache", "Lcom/bytedance/android/livesdkapi/gamestickerv2/IGameStickerTypeRoomCache;", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IGameStickerServiceV2 {
    IGameStickerContainerViewProxy buildContainerViewProxy(Context r100, String r101, GameStickerScene r102);

    IGameStickerContext getDataContext(GameStickerScene r100);

    ILandscapeLayoutCalculator getLandscapeCalculator();

    IPortraitLayoutCalculator getPortraitCalculator();

    IGameStickerSetting getSetting();

    IGameStickerTaskManager getTaskManager();

    void initDataContext(Fragment r100, LifecycleOwner r101, GameStickerScene r102);

    IGameStickerTypeRoomCache stickerTypeRoomCache();
}
