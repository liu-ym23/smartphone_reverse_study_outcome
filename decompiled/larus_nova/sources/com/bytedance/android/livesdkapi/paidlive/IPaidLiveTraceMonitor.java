package com.bytedance.android.livesdkapi.paidlive;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.livesdk.diagnose.DiagnoseResult;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\t\bf\u0018\u0000 \u00112\u00020\u0001:\u0005\u0010\u0011\u0012\u0013\u0014J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0005H&JV\u0010\b\u001a\u00020\u00052\b\b\u0001\u0010\t\u001a\u00020\n2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\f2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\nH&¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/paidlive/IPaidLiveTraceMonitor;", "", "getCommonCategory", "Lcom/bytedance/android/livesdkapi/paidlive/IPaidLiveTraceMonitor$CategoryGetter;", "initTrace", "", "categoryGetter", BasicTestActionHandler.TEST_ACTION_RESET, "trace", "eventType", "", "categoryMap", "", "extraParam", "paidSceneViewEntry", "paidSceneEnum", "CategoryGetter", "Companion", "PRIORITY", "SCENE", HTTP.SERVICE, "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPaidLiveTraceMonitor {
    public static final Companion Companion = null;
    public static final String KEY_CAST_SCREEN_AUTH = "cast_screen_auth";
    public static final String KEY_FLAG_SECURE_STATUS = "flag_secure_status";
    public static final String KEY_HAS_BUY_TICKET = "has_buy_ticket";
    public static final String KEY_HAS_DELIVERY = "has_delivery";
    public static final String KEY_IS_SEC_UID_NULL = "is_sec_uid_null";
    public static final String KEY_IS_TICKET_ID_NULL = "is_ticket_id_null";
    public static final String KEY_LANDSCAPE_AUTH = "landscape_auth";
    public static final String KEY_MASK_TYPE = "mask_type";
    public static final String KEY_MASK_VIEW_VISIBILITY = "mask_view_visibility";
    public static final String KEY_MUTE_STATUS = "player_mute_status";
    public static final String KEY_PAIDLIVE_SCENE = "paidlive_scene";
    public static final String KEY_PLAYER_VOLUME = "player_volume";
    public static final String KEY_REMAIN_WATCH_TIME = "remain_watch_time";
    public static final String KEY_SCOPE_CHECK_ERROR_TYPE = "scope_error_type";
    public static final String KEY_TICKET_SALE_STATE = "ticket_sale_state";
    public static final String KEY_VISIBLE = "visible";
    public static final String VALUE_DELIVERY_TIPS_MASK = "delivery_tips_mask";
    public static final String VALUE_FALSE = "false";
    public static final String VALUE_FEED_PREVIEW = "feed_preview";
    public static final String VALUE_IM_CARD = "im_card";
    public static final String VALUE_LVIDEO_THEATER = "lvideo_theater";
    public static final String VALUE_LYNX = "lynx";
    public static final String VALUE_ML_VIDEO = "ml_video";
    public static final String VALUE_PAID_CAMERA = "paid_camera";
    public static final String VALUE_PAID_ROOM = "paid_room";
    public static final String VALUE_PROFILE_CARD = "profile_card";
    public static final String VALUE_REPLAY = "replay";
    public static final String VALUE_SEARCH_PREVIEW = "search_preview";
    public static final String VALUE_TEMP_END_MASK = "temp_end_mask";
    public static final String VALUE_TRUE = "true";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0005R\u0012\u0010\u0007\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005R\u0012\u0010\u0012\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0005¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/paidlive/IPaidLiveTraceMonitor$CategoryGetter;", "", "episodeId", "", "getEpisodeId", "()Ljava/lang/String;", "isPaidlive", "isVs", "playerScene", "getPlayerScene", "roomId", "getRoomId", "ticketId", "", "getTicketId", "()J", "userId", "getUserId", "watchPaidliveStatus", "getWatchPaidliveStatus", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface CategoryGetter {
        String getEpisodeId();

        String getPlayerScene();

        String getRoomId();

        long getTicketId();

        String getUserId();

        String getWatchPaidliveStatus();

        String isPaidlive();

        String isVs();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001e\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdkapi/paidlive/IPaidLiveTraceMonitor$Companion;", "", "()V", "KEY_CAST_SCREEN_AUTH", "", "KEY_FLAG_SECURE_STATUS", "KEY_HAS_BUY_TICKET", "KEY_HAS_DELIVERY", "KEY_IS_SEC_UID_NULL", "KEY_IS_TICKET_ID_NULL", "KEY_LANDSCAPE_AUTH", "KEY_MASK_TYPE", "KEY_MASK_VIEW_VISIBILITY", "KEY_MUTE_STATUS", "KEY_PAIDLIVE_SCENE", "KEY_PLAYER_VOLUME", "KEY_REMAIN_WATCH_TIME", "KEY_SCOPE_CHECK_ERROR_TYPE", "KEY_TICKET_SALE_STATE", "KEY_VISIBLE", "VALUE_DELIVERY_TIPS_MASK", "VALUE_FALSE", "VALUE_FEED_PREVIEW", "VALUE_IM_CARD", "VALUE_LVIDEO_THEATER", "VALUE_LYNX", "VALUE_ML_VIDEO", "VALUE_PAID_CAMERA", "VALUE_PAID_ROOM", "VALUE_PROFILE_CARD", "VALUE_REPLAY", "VALUE_SEARCH_PREVIEW", "VALUE_TEMP_END_MASK", "VALUE_TRUE", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String KEY_CAST_SCREEN_AUTH = "cast_screen_auth";
        public static final String KEY_FLAG_SECURE_STATUS = "flag_secure_status";
        public static final String KEY_HAS_BUY_TICKET = "has_buy_ticket";
        public static final String KEY_HAS_DELIVERY = "has_delivery";
        public static final String KEY_IS_SEC_UID_NULL = "is_sec_uid_null";
        public static final String KEY_IS_TICKET_ID_NULL = "is_ticket_id_null";
        public static final String KEY_LANDSCAPE_AUTH = "landscape_auth";
        public static final String KEY_MASK_TYPE = "mask_type";
        public static final String KEY_MASK_VIEW_VISIBILITY = "mask_view_visibility";
        public static final String KEY_MUTE_STATUS = "player_mute_status";
        public static final String KEY_PAIDLIVE_SCENE = "paidlive_scene";
        public static final String KEY_PLAYER_VOLUME = "player_volume";
        public static final String KEY_REMAIN_WATCH_TIME = "remain_watch_time";
        public static final String KEY_SCOPE_CHECK_ERROR_TYPE = "scope_error_type";
        public static final String KEY_TICKET_SALE_STATE = "ticket_sale_state";
        public static final String KEY_VISIBLE = "visible";
        public static final String VALUE_DELIVERY_TIPS_MASK = "delivery_tips_mask";
        public static final String VALUE_FALSE = "false";
        public static final String VALUE_FEED_PREVIEW = "feed_preview";
        public static final String VALUE_IM_CARD = "im_card";
        public static final String VALUE_LVIDEO_THEATER = "lvideo_theater";
        public static final String VALUE_LYNX = "lynx";
        public static final String VALUE_ML_VIDEO = "ml_video";
        public static final String VALUE_PAID_CAMERA = "paid_camera";
        public static final String VALUE_PAID_ROOM = "paid_room";
        public static final String VALUE_PROFILE_CARD = "profile_card";
        public static final String VALUE_REPLAY = "replay";
        public static final String VALUE_SEARCH_PREVIEW = "search_preview";
        public static final String VALUE_TEMP_END_MASK = "temp_end_mask";
        public static final String VALUE_TRUE = "true";

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void trace$default(IPaidLiveTraceMonitor r100, String r101, Map r102, Map r103, String r110, String r111, int r112, Object r113) {
            if (r113 != null) goto L20;
            if ((r112 & 2) == 0) goto L6;
            r102 = new LinkedHashMap();
        L6:
            Map r104 = r102;
            if ((r112 & 4) == 0) goto L9;
            r103 = new LinkedHashMap();
        L9:
            Map r105 = r103;
            if ((r112 & 8) == 0) goto L12;
            String r106 = null;
        L14:
            if ((r112 & 16) == 0) goto L16;
            String r107 = null;
        L17:
            r100.trace(r101, r104, r105, r106, r107);
            return;
        L16:
            r107 = r111;
            goto L17
        L12:
            r106 = r110;
            goto L14
        L20:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trace");
        }
    }

    @Target({})
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/paidlive/IPaidLiveTraceMonitor$PRIORITY;", "", "priority", "", "()Ljava/lang/String;", "Companion", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.PROPERTY})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    public @interface PRIORITY {
        public static final Companion Companion = null;
        public static final String P0 = "p0";
        public static final String P1 = "p1";
        public static final String P2 = "p2";

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/paidlive/IPaidLiveTraceMonitor$PRIORITY$Companion;", "", "()V", DiagnoseResult.DIAGNOSE_LEVEL_P0, "", DiagnoseResult.DIAGNOSE_LEVEL_P1, DiagnoseResult.DIAGNOSE_LEVEL_P2, "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = null;
            public static final String P0 = "p0";
            public static final String P1 = "p1";
            public static final String P2 = "p2";

            private Companion() {
            }

            static {
                $$INSTANCE = new Companion();
            }
        }

        static {
            Companion = Companion.$$INSTANCE;
        }

        String priority();
    }

    @Target({})
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/paidlive/IPaidLiveTraceMonitor$SCENE;", "", "scene", "", "()Ljava/lang/String;", "Companion", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.PROPERTY})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    public @interface SCENE {
        public static final String CORE = "core";
        public static final Companion Companion = null;
        public static final String REFRESH_STREAM = "refresh_stream";
        public static final String REPLAY = "REPLAY";
        public static final String START_LIVE = "START_LIVE";
        public static final String TICKET_SELL = "ticket_sell";

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/paidlive/IPaidLiveTraceMonitor$SCENE$Companion;", "", "()V", "CORE", "", "REFRESH_STREAM", "REPLAY", "START_LIVE", "TICKET_SELL", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = null;
            public static final String CORE = "core";
            public static final String REFRESH_STREAM = "refresh_stream";
            public static final String REPLAY = "REPLAY";
            public static final String START_LIVE = "START_LIVE";
            public static final String TICKET_SELL = "ticket_sell";

            private Companion() {
            }

            static {
                $$INSTANCE = new Companion();
            }
        }

        static {
            Companion = Companion.$$INSTANCE;
        }

        String scene();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/paidlive/IPaidLiveTraceMonitor$SERVICE;", "", "Companion", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface SERVICE {
        public static final Companion Companion = null;

        @SCENE(scene = "START_LIVE")
        @PRIORITY(priority = "p1")
        public static final String PAIDLIVE_ANCHOR_ENTRANCE_CLICK = "paidlive_anchor_entrance_click";

        @SCENE(scene = "START_LIVE")
        @PRIORITY(priority = "p1")
        public static final String PAIDLIVE_ANCHOR_ENTRANCE_SHOW = "paidlive_anchor_entrance_show";

        @SCENE(scene = "START_LIVE")
        @PRIORITY(priority = "p1")
        public static final String PAIDLIVE_ANCHOR_RECALL_SHOW = "paidlive_anchor_recall_show";

        @SCENE(scene = "START_LIVE")
        @PRIORITY(priority = "p1")
        public static final String PAIDLIVE_ANCHOR_TICKET_INFO_UPDATE = "paidlive_anchor_ticket_info_update";

        @SCENE(scene = "START_LIVE")
        @PRIORITY(priority = "p1")
        public static final String PAIDLIVE_ANCHOR_TICKET_SCHEMA_ENTER = "paidlive_anchor_ticket_schema_enter";

        @SCENE(scene = "START_LIVE")
        @PRIORITY(priority = "p1")
        public static final String PAIDLIVE_ANCHOR_VISIBLITY_CHANGE_TO_PAID = "paidlive_anchor_visiblity_change_to_paid";

        @SCENE(scene = "core")
        @PRIORITY(priority = "p1")
        public static final String PAIDLIVE_AUDIENCE_CALL_DELIVERY_API = "paidlive_audience_call_delivery_api";

        @SCENE(scene = "core")
        @PRIORITY(priority = "p1")
        public static final String PAIDLIVE_AUDIENCE_CALL_PING_API_ZERO = "paidlive_audience_call_ping_api_zero";

        @SCENE(scene = "core")
        @PRIORITY(priority = "p1")
        public static final String PAIDLIVE_AUDIENCE_CLIENT_STATUS_CHECK_START = "paidlive_audience_client_status_check_start";

        @SCENE(scene = "core")
        @PRIORITY(priority = "p1")
        public static final String PAIDLIVE_AUDIENCE_CLIENT_STATUS_ERROR = "paidlive_audience_client_status_error";

        @SCENE(scene = "core")
        @PRIORITY(priority = "p1")
        public static final String PAIDLIVE_AUDIENCE_DELIVERY_BUTTON_CLICK = "paidlive_audience_delivery_button_click";

        @SCENE(scene = "core")
        @PRIORITY(priority = "p1")
        public static final String PAIDLIVE_AUDIENCE_DO_OPEN_TICKET_PANEL = "paidlive_audience_do_open_ticket_panel";

        @SCENE(scene = "core")
        @PRIORITY(priority = "p2")
        public static final String PAIDLIVE_AUDIENCE_FLAG_SECURE_STATUS_CHECK = "paidlive_audience_flag_secure_status_check";

        @SCENE(scene = "core")
        @PRIORITY(priority = "p0")
        public static final String PAIDLIVE_AUDIENCE_MASK_VIEW_SHOW = "paidlive_audience_mask_view_show";

        @SCENE(scene = "core")
        @PRIORITY(priority = "p1")
        public static final String PAIDLIVE_AUDIENCE_MASK_VIEW_VISIBLE_CHECK = "paidlive_audience_mask_view_visible_check";

        @SCENE(scene = "core")
        @PRIORITY(priority = "p1")
        public static final String PAIDLIVE_AUDIENCE_MUTE_STATUS_CHECK = "paidlive_audience_mute_status_check";

        @SCENE(scene = "core")
        @PRIORITY(priority = "p1")
        public static final String PAIDLIVE_AUDIENCE_MUTE_STATUS_CHECK_START = "paidlive_audience_mute_status_check_start";

        @SCENE(scene = "core")
        @PRIORITY(priority = "p0")
        public static final String PAIDLIVE_AUDIENCE_PLAYER_BIND = "paidlive_audience_player_bind";

        @SCENE(scene = "core")
        @PRIORITY(priority = "p0")
        public static final String PAIDLIVE_AUDIENCE_PLAYER_FIRST_FRAME = "paidlive_audience_player_first_frame";

        @SCENE(scene = "core")
        @PRIORITY(priority = "p0")
        public static final String PAIDLIVE_AUDIENCE_RET_TYPE_UPDATE = "paidlive_audience_ret_type_update";

        @SCENE(scene = "core")
        @PRIORITY(priority = "p2")
        public static final String PAIDLIVE_AUDIENCE_ROOM_AUTH_MONITOR = "paidlive_audience_room_auth_monitor";

        @SCENE(scene = "core")
        @PRIORITY(priority = "p0")
        public static final String PAIDLIVE_AUDIENCE_START_TEMP_WATCH = "paidlive_audience_start_temp_watch";

        @SCENE(scene = "core")
        @PRIORITY(priority = "p0")
        public static final String PAIDLIVE_AUDIENCE_TEMP_WATCH_END = "paidlive_audience_temp_watch_end";

        @SCENE(scene = "core")
        @PRIORITY(priority = "p0")
        public static final String PAIDLIVE_AUDIENCE_TICKET_BUTTON_CLICK = "paidlive_audience_ticket_button_click";

        @SCENE(scene = "core")
        @PRIORITY(priority = "p0")
        public static final String PAIDLIVE_AUDIENCE_TRY_WATCH_CARD_SHOW = "paidlive_audience_try_watch_card_show";

        @SCENE(scene = "core")
        @PRIORITY(priority = "p1")
        public static final String PAIDLIVE_CARD_CHECK_ERROR = "paidlive_card_check_error";

        @SCENE(scene = "core")
        @PRIORITY(priority = "p2")
        public static final String PAIDLIVE_DEBUG_WINDOW_SHOW = "paidlive_debug_window_show";

        @SCENE(scene = "refresh_stream")
        @PRIORITY(priority = "p0")
        public static final String PAIDLIVE_REFRESH_CHECK_STREAM_VALID = "paidlive_refresh_check_stream_valid";

        @SCENE(scene = "refresh_stream")
        @PRIORITY(priority = "p0")
        public static final String PAIDLIVE_REFRESH_REQUEST_FAIL = "paidlive_refresh_request_fail";

        @SCENE(scene = "refresh_stream")
        @PRIORITY(priority = "p0")
        public static final String PAIDLIVE_REFRESH_REQUEST_SUCCESS = "paidlive_refresh_request_success";

        @SCENE(scene = "refresh_stream")
        @PRIORITY(priority = "p0")
        public static final String PAIDLIVE_REFRESH_STREAM_FAIL = "paidlive_refresh_stream_fail";

        @SCENE(scene = "refresh_stream")
        @PRIORITY(priority = "p0")
        public static final String PAIDLIVE_REFRESH_STREAM_MASK_SHOW = "paidlive_refresh_stream_mask_show";

        @SCENE(scene = "refresh_stream")
        @PRIORITY(priority = "p0")
        public static final String PAIDLIVE_REFRESH_STREAM_START = "paidlive_refresh_stream_start";

        @SCENE(scene = "refresh_stream")
        @PRIORITY(priority = "p0")
        public static final String PAIDLIVE_REFRESH_STREAM_STATUS_VERIFY = "paidlive_refresh_stream_status_verify";

        @SCENE(scene = "refresh_stream")
        @PRIORITY(priority = "p0")
        public static final String PAIDLIVE_REFRESH_STREAM_SUCCESS = "paidlive_refresh_stream_success";

        @SCENE(scene = "refresh_stream")
        @PRIORITY(priority = "p0")
        public static final String PAIDLIVE_REFRESH_SWITCH_STREAM_DATA = "paidlive_refresh_switch_stream_data";

        @SCENE(scene = "refresh_stream")
        @PRIORITY(priority = "p0")
        public static final String PAIDLIVE_REFRESH_TIMER_END = "paidlive_refresh_timer_end";

        @SCENE(scene = "refresh_stream")
        @PRIORITY(priority = "p0")
        public static final String PAIDLIVE_REFRESH_TIMER_START = "paidlive_refresh_timer_start";

        @SCENE(scene = "REPLAY")
        public static final String PAIDLIVE_REPLAY_FLAG_SECURE_STATE = "paidlive_replay_flag_secure_state";

        @SCENE(scene = "REPLAY")
        public static final String PAIDLIVE_REPLAY_TEMP_WATCH_COUNT_DOWN = "paidlive_replay_temp_watch_count_down";

        @SCENE(scene = "REPLAY")
        public static final String PAIDLIVE_REPLAY_TEMP_WATCH_END_CLICK = "PAIDLIVE_REPLAY_TEMP_WATCH_END_CLICK";

        @SCENE(scene = "REPLAY")
        public static final String PAIDLIVE_REPLAY_TEMP_WATCH_END_DISMISS = "paidlive_replay_temp_watch_end_dismiss";

        @SCENE(scene = "REPLAY")
        public static final String PAIDLIVE_REPLAY_TEMP_WATCH_END_SHOW = "PAIDLIVE_REPLAY_TEMP_WATCH_END_SHOW";

        @SCENE(scene = "REPLAY")
        public static final String PAIDLIVE_REPLAY_TEMP_WATCH_START = "paidlive_replay_temp_watch_start";

        @SCENE(scene = "REPLAY")
        public static final String PAIDLIVE_REPLAY_TICKET_PAY_STATUS_CHANGE = "PAIDLIVE_REPLAY_TICKET_PAY_STATUS_CHANGE";

        @SCENE(scene = "REPLAY")
        public static final String PAIDLIVE_REPLAY_TICKET_PING_STATUS_UPDATE = "PAIDLIVE_REPLAY_TICKET_PING_STATUS_UPDATE";

        @SCENE(scene = "REPLAY")
        public static final String PAIDLIVE_REPLAY_TICKET_WIDGET_LOAD_STATE = "paidlive_replay_ticket_widget_load_state";

        @SCENE(scene = "core")
        @PRIORITY(priority = "p1")
        public static final String PAIDLIVE_SCOPE_CHECK_ALL = "paidlive_scope_check_all";

        @SCENE(scene = "core")
        @PRIORITY(priority = "p1")
        public static final String PAIDLIVE_SCOPE_CHECK_ERROR = "paidlive_scope_check_error";

        @SCENE(scene = "ticket_sell")
        @PRIORITY(priority = "p1")
        public static final String PAIDLIVE_TICKET_EXPLAIN_CARD_CLICK = "paidlive_ticket_explain_card_click";

        @SCENE(scene = "ticket_sell")
        @PRIORITY(priority = "p1")
        public static final String PAIDLIVE_TICKET_EXPLAIN_CARD_SHOW_STATUS = "paidlive_ticket_explain_card_show_status";

        @SCENE(scene = "ticket_sell")
        @PRIORITY(priority = "p1")
        public static final String PAIDLIVE_TICKET_GRAP_BUTTON_SHOW = "paidlive_ticket_grap_button_show";

        @SCENE(scene = "ticket_sell")
        @PRIORITY(priority = "p2")
        public static final String PAIDLIVE_TICKET_RECEIVE_TICKET_PAGE_SHOW = "paidlive_ticket_receive_ticket_page_show";

        @SCENE(scene = "ticket_sell")
        @PRIORITY(priority = "p1")
        public static final String PAIDLIVE_TICKET_TICKET_SALE_STATE_CHANGE = "paidlive_ticket_ticket_sale_state_change";

        @SCENE(scene = "ticket_sell")
        @PRIORITY(priority = "p1")
        public static final String PAIDLIVE_TICKET_TOOLBAR_CLICK = "paidlive_ticket_toolbar_click";

        @SCENE(scene = "ticket_sell")
        @PRIORITY(priority = "p1")
        public static final String PAIDLIVE_TICKET_TOOLBAR_SHOW_STATUS = "paidlive_ticket_toolbar_show_status";

        @SCENE(scene = "ticket_sell")
        @PRIORITY(priority = "p2")
        public static final String PAIDLIVE_TICKET_USER_INFO_PULL_ERROR = "paidlive_ticket_user_info_pull_error";

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\br\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u0016\u0010\b\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0002R\u0016\u0010\n\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0002R\u0016\u0010\f\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u0002R\u0016\u0010\u000e\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0002R\u0016\u0010\u0010\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0002R\u0016\u0010\u0012\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0002R\u0016\u0010\u0014\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0002R\u0016\u0010\u0016\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0002R\u0016\u0010\u0018\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u0002R\u0016\u0010\u001a\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u0002R\u0016\u0010\u001c\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u001d\u0010\u0002R\u0016\u0010\u001e\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u001f\u0010\u0002R\u0016\u0010 \u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b!\u0010\u0002R\u0016\u0010\"\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b#\u0010\u0002R\u0016\u0010$\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b%\u0010\u0002R\u0016\u0010&\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b'\u0010\u0002R\u0016\u0010(\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b)\u0010\u0002R\u0016\u0010*\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b+\u0010\u0002R\u0016\u0010,\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b-\u0010\u0002R\u0016\u0010.\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b/\u0010\u0002R\u0016\u00100\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b1\u0010\u0002R\u0016\u00102\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b3\u0010\u0002R\u0016\u00104\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b5\u0010\u0002R\u0016\u00106\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b7\u0010\u0002R\u0016\u00108\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b9\u0010\u0002R\u0016\u0010:\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b;\u0010\u0002R\u0016\u0010<\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b=\u0010\u0002R\u0016\u0010>\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b?\u0010\u0002R\u0016\u0010@\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\bA\u0010\u0002R\u0016\u0010B\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\bC\u0010\u0002R\u0016\u0010D\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\bE\u0010\u0002R\u0016\u0010F\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\bG\u0010\u0002R\u0016\u0010H\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\bI\u0010\u0002R\u0016\u0010J\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\bK\u0010\u0002R\u0016\u0010L\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\bM\u0010\u0002R\u0016\u0010N\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\bO\u0010\u0002R\u0016\u0010P\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\bQ\u0010\u0002R\u0016\u0010R\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\bS\u0010\u0002R\u0016\u0010T\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\bU\u0010\u0002R\u0016\u0010V\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\bW\u0010\u0002R\u0016\u0010X\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\bY\u0010\u0002R\u0016\u0010Z\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b[\u0010\u0002R\u0016\u0010\\\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b]\u0010\u0002R\u0016\u0010^\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b_\u0010\u0002R\u0016\u0010`\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\ba\u0010\u0002R\u0016\u0010b\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\bc\u0010\u0002R\u0016\u0010d\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\be\u0010\u0002R\u0016\u0010f\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\bg\u0010\u0002R\u0016\u0010h\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\bi\u0010\u0002R\u0016\u0010j\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\bk\u0010\u0002R\u0016\u0010l\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\bm\u0010\u0002R\u0016\u0010n\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\bo\u0010\u0002R\u0016\u0010p\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\bq\u0010\u0002R\u0016\u0010r\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\bs\u0010\u0002R\u0016\u0010t\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\bu\u0010\u0002¨\u0006v"}, d2 = {"Lcom/bytedance/android/livesdkapi/paidlive/IPaidLiveTraceMonitor$SERVICE$Companion;", "", "()V", "PAIDLIVE_ANCHOR_ENTRANCE_CLICK", "", "getPAIDLIVE_ANCHOR_ENTRANCE_CLICK$annotations", "PAIDLIVE_ANCHOR_ENTRANCE_SHOW", "getPAIDLIVE_ANCHOR_ENTRANCE_SHOW$annotations", "PAIDLIVE_ANCHOR_RECALL_SHOW", "getPAIDLIVE_ANCHOR_RECALL_SHOW$annotations", "PAIDLIVE_ANCHOR_TICKET_INFO_UPDATE", "getPAIDLIVE_ANCHOR_TICKET_INFO_UPDATE$annotations", "PAIDLIVE_ANCHOR_TICKET_SCHEMA_ENTER", "getPAIDLIVE_ANCHOR_TICKET_SCHEMA_ENTER$annotations", "PAIDLIVE_ANCHOR_VISIBLITY_CHANGE_TO_PAID", "getPAIDLIVE_ANCHOR_VISIBLITY_CHANGE_TO_PAID$annotations", "PAIDLIVE_AUDIENCE_CALL_DELIVERY_API", "getPAIDLIVE_AUDIENCE_CALL_DELIVERY_API$annotations", "PAIDLIVE_AUDIENCE_CALL_PING_API_ZERO", "getPAIDLIVE_AUDIENCE_CALL_PING_API_ZERO$annotations", "PAIDLIVE_AUDIENCE_CLIENT_STATUS_CHECK_START", "getPAIDLIVE_AUDIENCE_CLIENT_STATUS_CHECK_START$annotations", "PAIDLIVE_AUDIENCE_CLIENT_STATUS_ERROR", "getPAIDLIVE_AUDIENCE_CLIENT_STATUS_ERROR$annotations", "PAIDLIVE_AUDIENCE_DELIVERY_BUTTON_CLICK", "getPAIDLIVE_AUDIENCE_DELIVERY_BUTTON_CLICK$annotations", "PAIDLIVE_AUDIENCE_DO_OPEN_TICKET_PANEL", "getPAIDLIVE_AUDIENCE_DO_OPEN_TICKET_PANEL$annotations", "PAIDLIVE_AUDIENCE_FLAG_SECURE_STATUS_CHECK", "getPAIDLIVE_AUDIENCE_FLAG_SECURE_STATUS_CHECK$annotations", "PAIDLIVE_AUDIENCE_MASK_VIEW_SHOW", "getPAIDLIVE_AUDIENCE_MASK_VIEW_SHOW$annotations", "PAIDLIVE_AUDIENCE_MASK_VIEW_VISIBLE_CHECK", "getPAIDLIVE_AUDIENCE_MASK_VIEW_VISIBLE_CHECK$annotations", "PAIDLIVE_AUDIENCE_MUTE_STATUS_CHECK", "getPAIDLIVE_AUDIENCE_MUTE_STATUS_CHECK$annotations", "PAIDLIVE_AUDIENCE_MUTE_STATUS_CHECK_START", "getPAIDLIVE_AUDIENCE_MUTE_STATUS_CHECK_START$annotations", "PAIDLIVE_AUDIENCE_PLAYER_BIND", "getPAIDLIVE_AUDIENCE_PLAYER_BIND$annotations", "PAIDLIVE_AUDIENCE_PLAYER_FIRST_FRAME", "getPAIDLIVE_AUDIENCE_PLAYER_FIRST_FRAME$annotations", "PAIDLIVE_AUDIENCE_RET_TYPE_UPDATE", "getPAIDLIVE_AUDIENCE_RET_TYPE_UPDATE$annotations", "PAIDLIVE_AUDIENCE_ROOM_AUTH_MONITOR", "getPAIDLIVE_AUDIENCE_ROOM_AUTH_MONITOR$annotations", "PAIDLIVE_AUDIENCE_START_TEMP_WATCH", "getPAIDLIVE_AUDIENCE_START_TEMP_WATCH$annotations", "PAIDLIVE_AUDIENCE_TEMP_WATCH_END", "getPAIDLIVE_AUDIENCE_TEMP_WATCH_END$annotations", "PAIDLIVE_AUDIENCE_TICKET_BUTTON_CLICK", "getPAIDLIVE_AUDIENCE_TICKET_BUTTON_CLICK$annotations", "PAIDLIVE_AUDIENCE_TRY_WATCH_CARD_SHOW", "getPAIDLIVE_AUDIENCE_TRY_WATCH_CARD_SHOW$annotations", "PAIDLIVE_CARD_CHECK_ERROR", "getPAIDLIVE_CARD_CHECK_ERROR$annotations", "PAIDLIVE_DEBUG_WINDOW_SHOW", "getPAIDLIVE_DEBUG_WINDOW_SHOW$annotations", "PAIDLIVE_REFRESH_CHECK_STREAM_VALID", "getPAIDLIVE_REFRESH_CHECK_STREAM_VALID$annotations", "PAIDLIVE_REFRESH_REQUEST_FAIL", "getPAIDLIVE_REFRESH_REQUEST_FAIL$annotations", "PAIDLIVE_REFRESH_REQUEST_SUCCESS", "getPAIDLIVE_REFRESH_REQUEST_SUCCESS$annotations", "PAIDLIVE_REFRESH_STREAM_FAIL", "getPAIDLIVE_REFRESH_STREAM_FAIL$annotations", "PAIDLIVE_REFRESH_STREAM_MASK_SHOW", "getPAIDLIVE_REFRESH_STREAM_MASK_SHOW$annotations", "PAIDLIVE_REFRESH_STREAM_START", "getPAIDLIVE_REFRESH_STREAM_START$annotations", "PAIDLIVE_REFRESH_STREAM_STATUS_VERIFY", "getPAIDLIVE_REFRESH_STREAM_STATUS_VERIFY$annotations", "PAIDLIVE_REFRESH_STREAM_SUCCESS", "getPAIDLIVE_REFRESH_STREAM_SUCCESS$annotations", "PAIDLIVE_REFRESH_SWITCH_STREAM_DATA", "getPAIDLIVE_REFRESH_SWITCH_STREAM_DATA$annotations", "PAIDLIVE_REFRESH_TIMER_END", "getPAIDLIVE_REFRESH_TIMER_END$annotations", "PAIDLIVE_REFRESH_TIMER_START", "getPAIDLIVE_REFRESH_TIMER_START$annotations", "PAIDLIVE_REPLAY_FLAG_SECURE_STATE", "getPAIDLIVE_REPLAY_FLAG_SECURE_STATE$annotations", "PAIDLIVE_REPLAY_TEMP_WATCH_COUNT_DOWN", "getPAIDLIVE_REPLAY_TEMP_WATCH_COUNT_DOWN$annotations", "PAIDLIVE_REPLAY_TEMP_WATCH_END_CLICK", "getPAIDLIVE_REPLAY_TEMP_WATCH_END_CLICK$annotations", "PAIDLIVE_REPLAY_TEMP_WATCH_END_DISMISS", "getPAIDLIVE_REPLAY_TEMP_WATCH_END_DISMISS$annotations", "PAIDLIVE_REPLAY_TEMP_WATCH_END_SHOW", "getPAIDLIVE_REPLAY_TEMP_WATCH_END_SHOW$annotations", "PAIDLIVE_REPLAY_TEMP_WATCH_START", "getPAIDLIVE_REPLAY_TEMP_WATCH_START$annotations", "PAIDLIVE_REPLAY_TICKET_PAY_STATUS_CHANGE", "getPAIDLIVE_REPLAY_TICKET_PAY_STATUS_CHANGE$annotations", "PAIDLIVE_REPLAY_TICKET_PING_STATUS_UPDATE", "getPAIDLIVE_REPLAY_TICKET_PING_STATUS_UPDATE$annotations", "PAIDLIVE_REPLAY_TICKET_WIDGET_LOAD_STATE", "getPAIDLIVE_REPLAY_TICKET_WIDGET_LOAD_STATE$annotations", "PAIDLIVE_SCOPE_CHECK_ALL", "getPAIDLIVE_SCOPE_CHECK_ALL$annotations", "PAIDLIVE_SCOPE_CHECK_ERROR", "getPAIDLIVE_SCOPE_CHECK_ERROR$annotations", "PAIDLIVE_TICKET_EXPLAIN_CARD_CLICK", "getPAIDLIVE_TICKET_EXPLAIN_CARD_CLICK$annotations", "PAIDLIVE_TICKET_EXPLAIN_CARD_SHOW_STATUS", "getPAIDLIVE_TICKET_EXPLAIN_CARD_SHOW_STATUS$annotations", "PAIDLIVE_TICKET_GRAP_BUTTON_SHOW", "getPAIDLIVE_TICKET_GRAP_BUTTON_SHOW$annotations", "PAIDLIVE_TICKET_RECEIVE_TICKET_PAGE_SHOW", "getPAIDLIVE_TICKET_RECEIVE_TICKET_PAGE_SHOW$annotations", "PAIDLIVE_TICKET_TICKET_SALE_STATE_CHANGE", "getPAIDLIVE_TICKET_TICKET_SALE_STATE_CHANGE$annotations", "PAIDLIVE_TICKET_TOOLBAR_CLICK", "getPAIDLIVE_TICKET_TOOLBAR_CLICK$annotations", "PAIDLIVE_TICKET_TOOLBAR_SHOW_STATUS", "getPAIDLIVE_TICKET_TOOLBAR_SHOW_STATUS$annotations", "PAIDLIVE_TICKET_USER_INFO_PULL_ERROR", "getPAIDLIVE_TICKET_USER_INFO_PULL_ERROR$annotations", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = null;
            public static final String PAIDLIVE_ANCHOR_ENTRANCE_CLICK = "paidlive_anchor_entrance_click";
            public static final String PAIDLIVE_ANCHOR_ENTRANCE_SHOW = "paidlive_anchor_entrance_show";
            public static final String PAIDLIVE_ANCHOR_RECALL_SHOW = "paidlive_anchor_recall_show";
            public static final String PAIDLIVE_ANCHOR_TICKET_INFO_UPDATE = "paidlive_anchor_ticket_info_update";
            public static final String PAIDLIVE_ANCHOR_TICKET_SCHEMA_ENTER = "paidlive_anchor_ticket_schema_enter";
            public static final String PAIDLIVE_ANCHOR_VISIBLITY_CHANGE_TO_PAID = "paidlive_anchor_visiblity_change_to_paid";
            public static final String PAIDLIVE_AUDIENCE_CALL_DELIVERY_API = "paidlive_audience_call_delivery_api";
            public static final String PAIDLIVE_AUDIENCE_CALL_PING_API_ZERO = "paidlive_audience_call_ping_api_zero";
            public static final String PAIDLIVE_AUDIENCE_CLIENT_STATUS_CHECK_START = "paidlive_audience_client_status_check_start";
            public static final String PAIDLIVE_AUDIENCE_CLIENT_STATUS_ERROR = "paidlive_audience_client_status_error";
            public static final String PAIDLIVE_AUDIENCE_DELIVERY_BUTTON_CLICK = "paidlive_audience_delivery_button_click";
            public static final String PAIDLIVE_AUDIENCE_DO_OPEN_TICKET_PANEL = "paidlive_audience_do_open_ticket_panel";
            public static final String PAIDLIVE_AUDIENCE_FLAG_SECURE_STATUS_CHECK = "paidlive_audience_flag_secure_status_check";
            public static final String PAIDLIVE_AUDIENCE_MASK_VIEW_SHOW = "paidlive_audience_mask_view_show";
            public static final String PAIDLIVE_AUDIENCE_MASK_VIEW_VISIBLE_CHECK = "paidlive_audience_mask_view_visible_check";
            public static final String PAIDLIVE_AUDIENCE_MUTE_STATUS_CHECK = "paidlive_audience_mute_status_check";
            public static final String PAIDLIVE_AUDIENCE_MUTE_STATUS_CHECK_START = "paidlive_audience_mute_status_check_start";
            public static final String PAIDLIVE_AUDIENCE_PLAYER_BIND = "paidlive_audience_player_bind";
            public static final String PAIDLIVE_AUDIENCE_PLAYER_FIRST_FRAME = "paidlive_audience_player_first_frame";
            public static final String PAIDLIVE_AUDIENCE_RET_TYPE_UPDATE = "paidlive_audience_ret_type_update";
            public static final String PAIDLIVE_AUDIENCE_ROOM_AUTH_MONITOR = "paidlive_audience_room_auth_monitor";
            public static final String PAIDLIVE_AUDIENCE_START_TEMP_WATCH = "paidlive_audience_start_temp_watch";
            public static final String PAIDLIVE_AUDIENCE_TEMP_WATCH_END = "paidlive_audience_temp_watch_end";
            public static final String PAIDLIVE_AUDIENCE_TICKET_BUTTON_CLICK = "paidlive_audience_ticket_button_click";
            public static final String PAIDLIVE_AUDIENCE_TRY_WATCH_CARD_SHOW = "paidlive_audience_try_watch_card_show";
            public static final String PAIDLIVE_CARD_CHECK_ERROR = "paidlive_card_check_error";
            public static final String PAIDLIVE_DEBUG_WINDOW_SHOW = "paidlive_debug_window_show";
            public static final String PAIDLIVE_REFRESH_CHECK_STREAM_VALID = "paidlive_refresh_check_stream_valid";
            public static final String PAIDLIVE_REFRESH_REQUEST_FAIL = "paidlive_refresh_request_fail";
            public static final String PAIDLIVE_REFRESH_REQUEST_SUCCESS = "paidlive_refresh_request_success";
            public static final String PAIDLIVE_REFRESH_STREAM_FAIL = "paidlive_refresh_stream_fail";
            public static final String PAIDLIVE_REFRESH_STREAM_MASK_SHOW = "paidlive_refresh_stream_mask_show";
            public static final String PAIDLIVE_REFRESH_STREAM_START = "paidlive_refresh_stream_start";
            public static final String PAIDLIVE_REFRESH_STREAM_STATUS_VERIFY = "paidlive_refresh_stream_status_verify";
            public static final String PAIDLIVE_REFRESH_STREAM_SUCCESS = "paidlive_refresh_stream_success";
            public static final String PAIDLIVE_REFRESH_SWITCH_STREAM_DATA = "paidlive_refresh_switch_stream_data";
            public static final String PAIDLIVE_REFRESH_TIMER_END = "paidlive_refresh_timer_end";
            public static final String PAIDLIVE_REFRESH_TIMER_START = "paidlive_refresh_timer_start";
            public static final String PAIDLIVE_REPLAY_FLAG_SECURE_STATE = "paidlive_replay_flag_secure_state";
            public static final String PAIDLIVE_REPLAY_TEMP_WATCH_COUNT_DOWN = "paidlive_replay_temp_watch_count_down";
            public static final String PAIDLIVE_REPLAY_TEMP_WATCH_END_CLICK = "PAIDLIVE_REPLAY_TEMP_WATCH_END_CLICK";
            public static final String PAIDLIVE_REPLAY_TEMP_WATCH_END_DISMISS = "paidlive_replay_temp_watch_end_dismiss";
            public static final String PAIDLIVE_REPLAY_TEMP_WATCH_END_SHOW = "PAIDLIVE_REPLAY_TEMP_WATCH_END_SHOW";
            public static final String PAIDLIVE_REPLAY_TEMP_WATCH_START = "paidlive_replay_temp_watch_start";
            public static final String PAIDLIVE_REPLAY_TICKET_PAY_STATUS_CHANGE = "PAIDLIVE_REPLAY_TICKET_PAY_STATUS_CHANGE";
            public static final String PAIDLIVE_REPLAY_TICKET_PING_STATUS_UPDATE = "PAIDLIVE_REPLAY_TICKET_PING_STATUS_UPDATE";
            public static final String PAIDLIVE_REPLAY_TICKET_WIDGET_LOAD_STATE = "paidlive_replay_ticket_widget_load_state";
            public static final String PAIDLIVE_SCOPE_CHECK_ALL = "paidlive_scope_check_all";
            public static final String PAIDLIVE_SCOPE_CHECK_ERROR = "paidlive_scope_check_error";
            public static final String PAIDLIVE_TICKET_EXPLAIN_CARD_CLICK = "paidlive_ticket_explain_card_click";
            public static final String PAIDLIVE_TICKET_EXPLAIN_CARD_SHOW_STATUS = "paidlive_ticket_explain_card_show_status";
            public static final String PAIDLIVE_TICKET_GRAP_BUTTON_SHOW = "paidlive_ticket_grap_button_show";
            public static final String PAIDLIVE_TICKET_RECEIVE_TICKET_PAGE_SHOW = "paidlive_ticket_receive_ticket_page_show";
            public static final String PAIDLIVE_TICKET_TICKET_SALE_STATE_CHANGE = "paidlive_ticket_ticket_sale_state_change";
            public static final String PAIDLIVE_TICKET_TOOLBAR_CLICK = "paidlive_ticket_toolbar_click";
            public static final String PAIDLIVE_TICKET_TOOLBAR_SHOW_STATUS = "paidlive_ticket_toolbar_show_status";
            public static final String PAIDLIVE_TICKET_USER_INFO_PULL_ERROR = "paidlive_ticket_user_info_pull_error";

            private Companion() {
            }

            @SCENE(scene = "START_LIVE")
            @PRIORITY(priority = "p1")
            public static /* synthetic */ void getPAIDLIVE_ANCHOR_ENTRANCE_CLICK$annotations() {
            }

            @SCENE(scene = "START_LIVE")
            @PRIORITY(priority = "p1")
            public static /* synthetic */ void getPAIDLIVE_ANCHOR_ENTRANCE_SHOW$annotations() {
            }

            @SCENE(scene = "START_LIVE")
            @PRIORITY(priority = "p1")
            public static /* synthetic */ void getPAIDLIVE_ANCHOR_RECALL_SHOW$annotations() {
            }

            @SCENE(scene = "START_LIVE")
            @PRIORITY(priority = "p1")
            public static /* synthetic */ void getPAIDLIVE_ANCHOR_TICKET_INFO_UPDATE$annotations() {
            }

            @SCENE(scene = "START_LIVE")
            @PRIORITY(priority = "p1")
            public static /* synthetic */ void getPAIDLIVE_ANCHOR_TICKET_SCHEMA_ENTER$annotations() {
            }

            @SCENE(scene = "START_LIVE")
            @PRIORITY(priority = "p1")
            public static /* synthetic */ void getPAIDLIVE_ANCHOR_VISIBLITY_CHANGE_TO_PAID$annotations() {
            }

            @SCENE(scene = "core")
            @PRIORITY(priority = "p1")
            public static /* synthetic */ void getPAIDLIVE_AUDIENCE_CALL_DELIVERY_API$annotations() {
            }

            @SCENE(scene = "core")
            @PRIORITY(priority = "p1")
            public static /* synthetic */ void getPAIDLIVE_AUDIENCE_CALL_PING_API_ZERO$annotations() {
            }

            @SCENE(scene = "core")
            @PRIORITY(priority = "p1")
            public static /* synthetic */ void getPAIDLIVE_AUDIENCE_CLIENT_STATUS_CHECK_START$annotations() {
            }

            @SCENE(scene = "core")
            @PRIORITY(priority = "p1")
            public static /* synthetic */ void getPAIDLIVE_AUDIENCE_CLIENT_STATUS_ERROR$annotations() {
            }

            @SCENE(scene = "core")
            @PRIORITY(priority = "p1")
            public static /* synthetic */ void getPAIDLIVE_AUDIENCE_DELIVERY_BUTTON_CLICK$annotations() {
            }

            @SCENE(scene = "core")
            @PRIORITY(priority = "p1")
            public static /* synthetic */ void getPAIDLIVE_AUDIENCE_DO_OPEN_TICKET_PANEL$annotations() {
            }

            @SCENE(scene = "core")
            @PRIORITY(priority = "p2")
            public static /* synthetic */ void getPAIDLIVE_AUDIENCE_FLAG_SECURE_STATUS_CHECK$annotations() {
            }

            @SCENE(scene = "core")
            @PRIORITY(priority = "p0")
            public static /* synthetic */ void getPAIDLIVE_AUDIENCE_MASK_VIEW_SHOW$annotations() {
            }

            @SCENE(scene = "core")
            @PRIORITY(priority = "p1")
            public static /* synthetic */ void getPAIDLIVE_AUDIENCE_MASK_VIEW_VISIBLE_CHECK$annotations() {
            }

            @SCENE(scene = "core")
            @PRIORITY(priority = "p1")
            public static /* synthetic */ void getPAIDLIVE_AUDIENCE_MUTE_STATUS_CHECK$annotations() {
            }

            @SCENE(scene = "core")
            @PRIORITY(priority = "p1")
            public static /* synthetic */ void getPAIDLIVE_AUDIENCE_MUTE_STATUS_CHECK_START$annotations() {
            }

            @SCENE(scene = "core")
            @PRIORITY(priority = "p0")
            public static /* synthetic */ void getPAIDLIVE_AUDIENCE_PLAYER_BIND$annotations() {
            }

            @SCENE(scene = "core")
            @PRIORITY(priority = "p0")
            public static /* synthetic */ void getPAIDLIVE_AUDIENCE_PLAYER_FIRST_FRAME$annotations() {
            }

            @SCENE(scene = "core")
            @PRIORITY(priority = "p0")
            public static /* synthetic */ void getPAIDLIVE_AUDIENCE_RET_TYPE_UPDATE$annotations() {
            }

            @SCENE(scene = "core")
            @PRIORITY(priority = "p2")
            public static /* synthetic */ void getPAIDLIVE_AUDIENCE_ROOM_AUTH_MONITOR$annotations() {
            }

            @SCENE(scene = "core")
            @PRIORITY(priority = "p0")
            public static /* synthetic */ void getPAIDLIVE_AUDIENCE_START_TEMP_WATCH$annotations() {
            }

            @SCENE(scene = "core")
            @PRIORITY(priority = "p0")
            public static /* synthetic */ void getPAIDLIVE_AUDIENCE_TEMP_WATCH_END$annotations() {
            }

            @SCENE(scene = "core")
            @PRIORITY(priority = "p0")
            public static /* synthetic */ void getPAIDLIVE_AUDIENCE_TICKET_BUTTON_CLICK$annotations() {
            }

            @SCENE(scene = "core")
            @PRIORITY(priority = "p0")
            public static /* synthetic */ void getPAIDLIVE_AUDIENCE_TRY_WATCH_CARD_SHOW$annotations() {
            }

            @SCENE(scene = "core")
            @PRIORITY(priority = "p1")
            public static /* synthetic */ void getPAIDLIVE_CARD_CHECK_ERROR$annotations() {
            }

            @SCENE(scene = "core")
            @PRIORITY(priority = "p2")
            public static /* synthetic */ void getPAIDLIVE_DEBUG_WINDOW_SHOW$annotations() {
            }

            @SCENE(scene = "refresh_stream")
            @PRIORITY(priority = "p0")
            public static /* synthetic */ void getPAIDLIVE_REFRESH_CHECK_STREAM_VALID$annotations() {
            }

            @SCENE(scene = "refresh_stream")
            @PRIORITY(priority = "p0")
            public static /* synthetic */ void getPAIDLIVE_REFRESH_REQUEST_FAIL$annotations() {
            }

            @SCENE(scene = "refresh_stream")
            @PRIORITY(priority = "p0")
            public static /* synthetic */ void getPAIDLIVE_REFRESH_REQUEST_SUCCESS$annotations() {
            }

            @SCENE(scene = "refresh_stream")
            @PRIORITY(priority = "p0")
            public static /* synthetic */ void getPAIDLIVE_REFRESH_STREAM_FAIL$annotations() {
            }

            @SCENE(scene = "refresh_stream")
            @PRIORITY(priority = "p0")
            public static /* synthetic */ void getPAIDLIVE_REFRESH_STREAM_MASK_SHOW$annotations() {
            }

            @SCENE(scene = "refresh_stream")
            @PRIORITY(priority = "p0")
            public static /* synthetic */ void getPAIDLIVE_REFRESH_STREAM_START$annotations() {
            }

            @SCENE(scene = "refresh_stream")
            @PRIORITY(priority = "p0")
            public static /* synthetic */ void getPAIDLIVE_REFRESH_STREAM_STATUS_VERIFY$annotations() {
            }

            @SCENE(scene = "refresh_stream")
            @PRIORITY(priority = "p0")
            public static /* synthetic */ void getPAIDLIVE_REFRESH_STREAM_SUCCESS$annotations() {
            }

            @SCENE(scene = "refresh_stream")
            @PRIORITY(priority = "p0")
            public static /* synthetic */ void getPAIDLIVE_REFRESH_SWITCH_STREAM_DATA$annotations() {
            }

            @SCENE(scene = "refresh_stream")
            @PRIORITY(priority = "p0")
            public static /* synthetic */ void getPAIDLIVE_REFRESH_TIMER_END$annotations() {
            }

            @SCENE(scene = "refresh_stream")
            @PRIORITY(priority = "p0")
            public static /* synthetic */ void getPAIDLIVE_REFRESH_TIMER_START$annotations() {
            }

            @SCENE(scene = "REPLAY")
            public static /* synthetic */ void getPAIDLIVE_REPLAY_FLAG_SECURE_STATE$annotations() {
            }

            @SCENE(scene = "REPLAY")
            public static /* synthetic */ void getPAIDLIVE_REPLAY_TEMP_WATCH_COUNT_DOWN$annotations() {
            }

            @SCENE(scene = "REPLAY")
            public static /* synthetic */ void getPAIDLIVE_REPLAY_TEMP_WATCH_END_CLICK$annotations() {
            }

            @SCENE(scene = "REPLAY")
            public static /* synthetic */ void getPAIDLIVE_REPLAY_TEMP_WATCH_END_DISMISS$annotations() {
            }

            @SCENE(scene = "REPLAY")
            public static /* synthetic */ void getPAIDLIVE_REPLAY_TEMP_WATCH_END_SHOW$annotations() {
            }

            @SCENE(scene = "REPLAY")
            public static /* synthetic */ void getPAIDLIVE_REPLAY_TEMP_WATCH_START$annotations() {
            }

            @SCENE(scene = "REPLAY")
            public static /* synthetic */ void getPAIDLIVE_REPLAY_TICKET_PAY_STATUS_CHANGE$annotations() {
            }

            @SCENE(scene = "REPLAY")
            public static /* synthetic */ void getPAIDLIVE_REPLAY_TICKET_PING_STATUS_UPDATE$annotations() {
            }

            @SCENE(scene = "REPLAY")
            public static /* synthetic */ void getPAIDLIVE_REPLAY_TICKET_WIDGET_LOAD_STATE$annotations() {
            }

            @SCENE(scene = "core")
            @PRIORITY(priority = "p1")
            public static /* synthetic */ void getPAIDLIVE_SCOPE_CHECK_ALL$annotations() {
            }

            @SCENE(scene = "core")
            @PRIORITY(priority = "p1")
            public static /* synthetic */ void getPAIDLIVE_SCOPE_CHECK_ERROR$annotations() {
            }

            @SCENE(scene = "ticket_sell")
            @PRIORITY(priority = "p1")
            public static /* synthetic */ void getPAIDLIVE_TICKET_EXPLAIN_CARD_CLICK$annotations() {
            }

            @SCENE(scene = "ticket_sell")
            @PRIORITY(priority = "p1")
            public static /* synthetic */ void getPAIDLIVE_TICKET_EXPLAIN_CARD_SHOW_STATUS$annotations() {
            }

            @SCENE(scene = "ticket_sell")
            @PRIORITY(priority = "p1")
            public static /* synthetic */ void getPAIDLIVE_TICKET_GRAP_BUTTON_SHOW$annotations() {
            }

            @SCENE(scene = "ticket_sell")
            @PRIORITY(priority = "p2")
            public static /* synthetic */ void getPAIDLIVE_TICKET_RECEIVE_TICKET_PAGE_SHOW$annotations() {
            }

            @SCENE(scene = "ticket_sell")
            @PRIORITY(priority = "p1")
            public static /* synthetic */ void getPAIDLIVE_TICKET_TICKET_SALE_STATE_CHANGE$annotations() {
            }

            @SCENE(scene = "ticket_sell")
            @PRIORITY(priority = "p1")
            public static /* synthetic */ void getPAIDLIVE_TICKET_TOOLBAR_CLICK$annotations() {
            }

            @SCENE(scene = "ticket_sell")
            @PRIORITY(priority = "p1")
            public static /* synthetic */ void getPAIDLIVE_TICKET_TOOLBAR_SHOW_STATUS$annotations() {
            }

            @SCENE(scene = "ticket_sell")
            @PRIORITY(priority = "p2")
            public static /* synthetic */ void getPAIDLIVE_TICKET_USER_INFO_PULL_ERROR$annotations() {
            }

            static {
                $$INSTANCE = new Companion();
            }
        }

        static {
            Companion = Companion.$$INSTANCE;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    CategoryGetter getCommonCategory();

    void initTrace(CategoryGetter r100);

    void reset();

    void trace(@SERVICE String r100, Map<String, String> r101, Map<String, String> r102, String r103, String r104);
}
