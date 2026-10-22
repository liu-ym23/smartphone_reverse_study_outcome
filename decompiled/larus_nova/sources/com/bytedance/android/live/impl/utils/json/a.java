package com.bytedance.android.live.impl.utils.json;

import java.util.HashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<JsonItemType, Class<? extends JsonItemHelper.IJsonItem>> f69324a = null;

    static {
        f69324a = MapsKt.hashMapOf(new Pair[]{TuplesKt.to(JsonItemType.STALL_ITEM, JsonItemHelper.StallRecordItem.class), TuplesKt.to(JsonItemType.ENTER_ROOM_DURATION_ITEM, JsonItemHelper.EnterRoomDurationItem.class), TuplesKt.to(JsonItemType.WATCH_ROOM_PV_ITEM, JsonItemHelper.WatchRoomPvItem.class), TuplesKt.to(JsonItemType.WATCH_HOTROOM_PV_ITEM, JsonItemHelper.WatchHotroomPvItem.class), TuplesKt.to(JsonItemType.STALL_ROOM_SENSITIVITY, JsonItemHelper.StallRoomSensitivity.class), TuplesKt.to(JsonItemType.STALL_LIVE_SENSITIVITY, JsonItemHelper.StallLiveSensitivity.class), TuplesKt.to(JsonItemType.PREVIEW_SHOW_PV_ITEM, JsonItemHelper.PreviewShowPvItem.class), TuplesKt.to(JsonItemType.PREVIEW_CLICK_PV_ITEM, JsonItemHelper.PreviewClickPvItem.class), TuplesKt.to(JsonItemType.DEFINITION_ITEM, JsonItemHelper.DefinitionItem.class), TuplesKt.to(JsonItemType.WATCH_LIVE_DATE_ITEM, JsonItemHelper.WatchLiveDateItem.class), TuplesKt.to(JsonItemType.GIFT_SHOW_DATE_ITEM, JsonItemHelper.GiftShowDateItem.class), TuplesKt.to(JsonItemType.FIRST_FRAME_LOAD_DURATION_ITEM, JsonItemHelper.FirstFrameLoadDurationItem.class), TuplesKt.to(JsonItemType.MINI_WINDOW_LOAD_DURATION_ITEM, JsonItemHelper.MiniWindowLoadDurationItem.class), TuplesKt.to(JsonItemType.MINI_WINDOW_SHOW_DURATION_ITEM, JsonItemHelper.MiniWindowShowDurationItem.class), TuplesKt.to(JsonItemType.FIRST_ROOM_PERFORMANCE_DATA_ITEM, JsonItemHelper.FirstRoomPerformanceDataItem.class), TuplesKt.to(JsonItemType.START_LIVE_COUNT_ITEM, JsonItemHelper.StartLiveDataItem.class), TuplesKt.to(JsonItemType.RESTART_LIVE_ALERT_SHOW_REASON_3_COUNT_ITEM, JsonItemHelper.StopLiveReasonDataItem.class)});
    }
}
