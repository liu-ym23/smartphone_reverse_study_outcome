package com.bytedance.android.live.core.monitor;

import android.content.SharedPreferences;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mapapi.SDKInitializer;
import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.core.monitor.trace.TraceMonitor;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.livesdk.config.gh;
import com.bytedance.android.livesdk.config.ih;
import com.bytedance.android.livesdk.config.jh;
import com.bytedance.android.livesdk.config.kh;
import com.bytedance.android.livesdk.config.p00;
import com.bytedance.android.livesdk.config.pb;
import com.bytedance.android.livesdk.config.v90;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICrashCallback;
import com.bytedance.crash.IOOMCallback;
import com.bytedance.crash.Npth;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.ies.sdk.widgets.priority.PriorityModule;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import y50.p;

/* JADX INFO: loaded from: classes45.dex */
public final class NewBroadcastMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Boolean f64916a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f64917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f64918c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f64919d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, String> f64920e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<String, String> f64921f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static e f64922g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static f f64923h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Long> f64924i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Map<String, String> f64925j = null;

    @Target({})
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0006B\b\u0012\u0006\u0010\u0003\u001a\u00020\u0002R\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/core/monitor/NewBroadcastMonitor$BUSINESSTYPE;", "", "", "type", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.PROPERTY})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    public @interface BUSINESSTYPE {
        public static final String CORE = "start_broadcast";
        public static final a Companion = null;
        public static final String EFFECT = "broadcast_effect";
        public static final String PREVIEW = "broadcast_preview";
        public static final String STICKER = "broadcast_sticker";
        public static final String TOOLBAL = "broadcast_toolbar";

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f64926a = null;

            public a() {
            }

            static {
                f64926a = new a();
            }
        }

        static {
            Companion = a.f64926a;
        }

        String type();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/core/monitor/NewBroadcastMonitor$CAPTURE;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface CAPTURE {
        public static final String BACK = "back";
        public static final a Companion = null;
        public static final String FRONT = "front";

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f64927a = null;

            public a() {
            }

            static {
                f64927a = new a();
            }
        }

        static {
            Companion = a.f64927a;
        }
    }

    @Target({})
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0006B\b\u0012\u0006\u0010\u0003\u001a\u00020\u0002R\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/core/monitor/NewBroadcastMonitor$GROUP;", "", "", "group", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.PROPERTY})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    public @interface GROUP {
        public static final String ANCHOR_BIZ_PANEL = "service_anchor_biz_panel_merge_event";
        public static final a Companion = null;
        public static final String EFFECT = "ttlive_anchor_prefix_effect_merge";
        public static final String NETWORK = "ttlive_anchor_prefix_network_merge";
        public static final String SO = "ttlive_anchor_prefix_live_core_so_load_status_merge";
        public static final String TOOLBAR = "ttlive_anchor_prefix_toolbar_merge";

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f64928a = null;

            public a() {
            }

            static {
                f64928a = new a();
            }
        }

        static {
            Companion = a.f64928a;
        }

        String group();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/core/monitor/NewBroadcastMonitor$PAGE;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface PAGE {
        public static final a Companion = null;
        public static final String PREVIEW = "preview";
        public static final String ROOM = "room";
        public static final String SUBBROADCAST = "subBroadcast";

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f64929a = null;

            public a() {
            }

            static {
                f64929a = new a();
            }
        }

        static {
            Companion = a.f64929a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/core/monitor/NewBroadcastMonitor$SERVICE;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface SERVICE {

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.EXTERNALAMERA)
        public static final String ANCHOR_EXTERNAL_AUDIO_FPS = "ttlive_anchor_external_audio_fps";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.EXTERNALAMERA)
        public static final String ANCHOR_EXTERNAL_VIDEO_FPS = "ttlive_anchor_external_video_fps";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.MULTICAMERA)
        public static final String ANCHOR_MULTICAMERA_SUBBROADCAST_ONCREATE = "ttlive_anchor_multicamera_subbroadcast_oncreate";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.MULTICAMERA)
        public static final String ANCHOR_MULTICAMERA_SUBBROADCAST_RTC_CLOSE = "ttlive_anchor_multicamera_subbroadcast_rtc_close";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.MULTICAMERA)
        public static final String ANCHOR_MULTICAMERA_SUBBROADCAST_RTC_JOIN = "ttlive_anchor_multicamera_subbroadcast_rtc_join";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "camera")
        public static final String ANCHOR_SET_EXPOSURE = "ttlive_anchor_set_exposure";
        public static final a Companion = null;

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.NEWLINK)
        public static final String NEW_LINK_ANCHOR_JSB_JUMP = "ttlive_new_link_anchor_jsb_jump";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.NEWLINK)
        public static final String NEW_LINK_ANCHOR_JSB_JUMP_SUCCESS = "ttlive_new_link_anchor_jsb_jump_success";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.NEWLINK)
        public static final String NEW_LINK_ANCHOR_PING_PAUSE = "ttlive_new_link_anchor_ping_pause";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.NEWLINK)
        public static final String NEW_LINK_AUDIENCE_JSB_JUMP = "ttlive_new_link_audience_jsb_jump";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.NEWLINK)
        public static final String NEW_LINK_AUDIENCE_PING_START = "ttlive_new_link_audience_ping_start";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = "effect")
        public static final String SERVICE_ANCHOR_ADJUST_STICKER_TAG_VALUE = "ttlive_anchor_adjust_sticker_tag_value";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "announcement")
        public static final String SERVICE_ANCHOR_ANNOUNCEMENT_HIGHLIGHT_AUDIENCE_CLOSE = "ttlive_anchor_prefix_announcement_audience_close";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "announcement")
        public static final String SERVICE_ANCHOR_ANNOUNCEMENT_HIGHLIGHT_AUTO_PUBLISH_STATUS = "ttlive_anchor_prefix_announcement_auto_publish";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "announcement")
        public static final String SERVICE_ANCHOR_ANNOUNCEMENT_HIGHLIGHT_HIDE = "ttlive_anchor_prefix_announcement_hide";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "announcement")
        public static final String SERVICE_ANCHOR_ANNOUNCEMENT_HIGHLIGHT_PUBLISH_STATUS = "ttlive_anchor_prefix_announcement_publish";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "announcement")
        public static final String SERVICE_ANCHOR_ANNOUNCEMENT_HIGHLIGHT_SHOW = "ttlive_anchor_prefix_announcement_show";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "announcement")
        public static final String SERVICE_ANCHOR_ANNOUNCEMENT_HIGHLIGHT_UN_PUBLISH_STATUS = "ttlive_anchor_prefix_announcement_unpublish";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = "effect")
        public static final String SERVICE_ANCHOR_AV_ADJUST_EFFECT_STATUS = "ttlive_anchor_av_adjust_effect_status";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = "effect")
        public static final String SERVICE_ANCHOR_BEAUTY_EFFECT_STATUS = "ttlive_anchor_beauty_effect_status";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "service_anchor_biz_panel_merge_event")
        @STAGE(stage = "start")
        public static final String SERVICE_ANCHOR_BIZ_PANEL_DATA_EVENT = "service_anchor_biz_panel_data_event";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "start")
        public static final String SERVICE_ANCHOR_BIZ_PANEL_MERGE_EVENT = "service_anchor_biz_panel_merge_event";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "start")
        public static final String SERVICE_ANCHOR_BIZ_PANEL_OPERATE_EVENT = "service_anchor_biz_panel_operate_event";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "service_anchor_biz_panel_merge_event")
        @STAGE(stage = "start")
        public static final String SERVICE_ANCHOR_BIZ_PANEL_UI_EVENT = "service_anchor_biz_panel_ui_event";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_ANCHOR_BLOCK_BACKPRESS_WITH_ROOM_CREATING = "ttlive_anchor_block_backpress_with_room_creating";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_ANCHOR_BLOCK_INFO = "ttlive_anchor_block_info";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = "effect")
        public static final String SERVICE_ANCHOR_BODY_BEAUTY_EFFECT_STATUS = "ttlive_anchor_body_beauty_effect_status";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "stop")
        public static final String SERVICE_ANCHOR_CANCEL_EDUCATION = "ttlive_anchor_prefix_cancel_education";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "stream")
        public static final String SERVICE_ANCHOR_CHANGE_BITRATE_DEGRADE_RATIO = "ttlive_anchor_prefix_change_bitrate_degrade_ratio";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "stream")
        public static final String SERVICE_ANCHOR_CHANGE_VIDEO_BITRATE = "ttlive_anchor_prefix_change_video_bitrate";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "stream")
        public static final String SERVICE_ANCHOR_CHANGE_VIDEO_FPS = "ttlive_anchor_prefix_change_video_fps";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "stream")
        public static final String SERVICE_ANCHOR_CLARITY_CHANGE = "ttlive_anchor_clarity_change";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "core")
        public static final String SERVICE_ANCHOR_CRASH_LOG = "ttlive_anchor_crash_info";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "sticker")
        public static final String SERVICE_ANCHOR_CURRENT_EXISTED_DECORATIONS = "ttlive_anchor_current_existed_decorations";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "sticker")
        public static final String SERVICE_ANCHOR_DELETE_STICKER = "ttlive_anchor_delete_sticker";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "core")
        public static final String SERVICE_ANCHOR_EXIT_LOG = "ttlive_anchor_exit_info";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = "effect")
        public static final String SERVICE_ANCHOR_FETCH_STICKER_FAIL = "ttlive_anchor_prefix_fetch_sticker_fail";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = "effect")
        public static final String SERVICE_ANCHOR_GET_CAMPAIGN_STICKER = "ttlive_anchor_prefix_get_campaign_sticker";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = "effect")
        public static final String SERVICE_ANCHOR_GET_FAVORITE_STICKER = "ttlive_anchor_prefix_get_favorite_sticker";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = "effect")
        public static final String SERVICE_ANCHOR_GET_RECOMMEND_STICKER = "ttlive_anchor_prefix_get_recommend_sticker";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = "effect")
        public static final String SERVICE_ANCHOR_GIFT_EVENT_CHANNEL_STATUS_CHANGE = "ttlive_anchor_prefix_gift_event_channel_status_change";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = "effect")
        public static final String SERVICE_ANCHOR_GIFT_MENU_STICKER_RENDER = "ttlive_anchor_prefix_gift_menu_sticker_render";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_toolbar_merge")
        @STAGE(stage = STAGE.TOOLBAR)
        public static final String SERVICE_ANCHOR_GUIDE_TOOLBAR_ADD_ITEM = "ttlive_anchor_guide_toolbar_add_item";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.TOOLBAR)
        public static final String SERVICE_ANCHOR_GUIDE_TOOLBAR_CLICK = "ttlive_anchor_guide_toolbar_click";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.TOOLBAR)
        public static final String SERVICE_ANCHOR_GUIDE_TOOLBAR_CONFIG = "ttlive_anchor_guide_toolbar_config";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_toolbar_merge")
        @STAGE(stage = STAGE.TOOLBAR)
        public static final String SERVICE_ANCHOR_GUIDE_TOOLBAR_EXCLUDE_ITEM = "ttlive_anchor_prefix_guide_toolbar_exclude_item";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_toolbar_merge")
        @STAGE(stage = STAGE.TOOLBAR)
        public static final String SERVICE_ANCHOR_GUIDE_TOOLBAR_FORCE_DELETE = "ttlive_anchor_prefix_guide_toolbar_force_delete";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_toolbar_merge")
        @STAGE(stage = STAGE.TOOLBAR)
        public static final String SERVICE_ANCHOR_GUIDE_TOOLBAR_REMOVE_ITEM = "ttlive_anchor_guide_toolbar_remove_item";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_toolbar_merge")
        @STAGE(stage = STAGE.TOOLBAR)
        public static final String SERVICE_ANCHOR_GUIDE_TOOLBAR_SHOW = "ttlive_anchor_prefix_guide_toolbar_show";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = "effect")
        public static final String SERVICE_ANCHOR_MUTEX_EFFECT = "ttlive_anchor_mutex_effect";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = "effect")
        public static final String SERVICE_ANCHOR_MV_BIND_STICKER_APPLY = "ttlive_anchor_prefix_mv_bind_sticker_apply";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = "effect")
        public static final String SERVICE_ANCHOR_MV_BIND_STICKER_REMOVE = "ttlive_anchor_prefix_mv_bind_sticker_remove";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = "effect")
        public static final String SERVICE_ANCHOR_NO_BEAUTIFY_STATUS = "ttlive_anchor_no_beautify_effect_status";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "core")
        public static final String SERVICE_ANCHOR_OOM_LOG = "ttlive_anchor_oom_info";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = "effect")
        public static final String SERVICE_ANCHOR_OPEN_STICKER_DIALOG_JSB = "ttlive_anchor_prefix_open_sticker_dialog_by_jsb";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = "effect")
        public static final String SERVICE_ANCHOR_OPEN_STICKER_DIALOG_SCHEMA = "ttlive_anchor_prefix_open_sticker_dialog_by_schema";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = "effect")
        public static final String SERVICE_ANCHOR_PERMEATE_STICKER = "ttlive_anchor_prefix_permeate_sticker";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = "effect")
        public static final String SERVICE_ANCHOR_PREVIEW_BEAUTY_FAST_RESTORE = "ttlive_anchor_prefix_preview_beauty_fast_restore";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_ANCHOR_REAL_START_IN_ROOM = "ttlive_anchor_real_start_in_room";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "core")
        public static final String SERVICE_ANCHOR_REBUILD = "ttlive_anchor_prefix_rebuild";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "core")
        public static final String SERVICE_ANCHOR_REBUILD_RESULT = "ttlive_anchor_prefix_rebuild_result";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = "effect")
        public static final String SERVICE_ANCHOR_RENDER_EFFECT = "ttlive_anchor_render_effect";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = "effect")
        public static final String SERVICE_ANCHOR_RENDER_NO_CAMERA_EFFECT = "service_anchor_render_no_camera_effect";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "stream")
        public static final String SERVICE_ANCHOR_ROOM_STATE_REQUEST = "ttlive_anchor_room_state_request";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = "effect")
        public static final String SERVICE_ANCHOR_SELECT_EFFECT = "ttlive_anchor_select_effect";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "sticker")
        public static final String SERVICE_ANCHOR_SELECT_STICKER = "ttlive_anchor_select_sticker";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = "effect")
        public static final String SERVICE_ANCHOR_SEND_EFFECT_MSG = "ttlive_anchor_prefix_send_effect_msg";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_ANCHOR_SHOW_BROADCAST_STREAM_FRAGMENT = "ttlive_anchor_show_broadcast_stream_fragment";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_ANCHOR_SHOW_SUB_BROADCAST_STREAM_FRAGMENT = "ttlive_anchor_show_sub_broadcast_stream_fragment";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = "effect")
        public static final String SERVICE_ANCHOR_START_LIVE_RESTORE_EFFECT = "ttlive_anchor_prefix_start_live_restore_effect";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "sticker")
        public static final String SERVICE_ANCHOR_STICKER_EVENT = "ttlive_anchor_sticker_event";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "sticker")
        public static final String SERVICE_ANCHOR_STICKER_PANEL_EVENT = "ttlive_anchor_sticker_panel_event";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = "effect")
        public static final String SERVICE_ANCHOR_STICKER_PREVIEW_DOWNGRADE = "ttlive_anchor_sticker_preview_downgrade";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = "effect")
        public static final String SERVICE_ANCHOR_STICKER_PREVIEW_START = "ttlive_anchor_sticker_preview_start";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "sticker")
        public static final String SERVICE_ANCHOR_STICKER_SET = "ttlive_anchor_sticker_set";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = "effect")
        public static final String SERVICE_ANCHOR_STICKER_TRY_OUT_PARAMS = "ttlive_anchor_prefix_sticker_try_out_params";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = "effect")
        public static final String SERVICE_ANCHOR_UNSELECT_EFFECT = "ttlive_anchor_unselect_effect";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "core")
        public static final String SERVICE_AUDIO_CAPTURE_CHANGE = "ttlive_audio_capture_change";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "sticker")
        public static final String SERVICE_AUDIT_STICKER_TEXT_CONTENT = "ttlive_audit_text_content";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "sticker")
        public static final String SERVICE_AUDIT_STICKER_TEXT_CONTENT_HUMAN = "ttlive_audit_sticker_text_content_human";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "sticker")
        public static final String SERVICE_AUDIT_STICKER_TEXT_CONTENT_MACHINE = "ttlive_audit_sticker_text_content_machine";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "core")
        public static final String SERVICE_CAMERA_CLICK_EXPOSURE = "ttlive_camera_click_exposure";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "core")
        public static final String SERVICE_CAMERA_CLOSE = "ttlive_camera_close";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "core")
        public static final String SERVICE_CAMERA_ERROR = "ttlive_camera_error";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "core")
        public static final String SERVICE_CAMERA_OPEN = "ttlive_camera_open";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "core")
        public static final String SERVICE_CAMERA_START_ZOOM = "ttlive_camera_start_zoom";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "stream")
        public static final String SERVICE_CAMERA_WATCHDOG_LOG = "ttlive_anchor_camera_watchdog_log";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CAST)
        public static final String SERVICE_CAST_MINIMIZE = "ttlive_anchor_prefix_cast_minimize";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CAST)
        public static final String SERVICE_CAST_RESUME = "ttlive_anchor_prefix_cast_resume";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CAST)
        public static final String SERVICE_CAST_START = "ttlive_anchor_prefix_cast_start";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CAST)
        public static final String SERVICE_CAST_START_ERROR = "ttlive_anchor_prefix_cast_start_error";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CAST)
        public static final String SERVICE_CAST_START_SUCCESS = "ttlive_anchor_prefix_cast_start_success";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.CAST)
        public static final String SERVICE_CAST_STOP = "ttlive_anchor_prefix_cast_stop";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "stream")
        public static final String SERVICE_CDN_FETCH_SPEED_TEST_INFO = "ttlive_anchor_prefix_fetch_speed_test_info";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "stream")
        public static final String SERVICE_CDN_SPEED_TEST_RESULT = "ttlive_anchor_prefix_cdn_speed_test_result";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = "core")
        public static final String SERVICE_CHANGE_EFFECT_FAVORITE = "ttlive_change_effect_favorite";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_CHANGE_LIVE_MODE = "ttlive_anchor_profix_change_live_mode";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "core")
        public static final String SERVICE_CLICK_OPEN_LIVE_FAILED = "ttlive_click_open_live_failed";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_CLICK_REPLACE_COVER = "ttlive_click_replace_cover";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "core")
        public static final String SERVICE_CLOSE_ROOM_EXP = "ttlive_anchor_close_room_exception";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "core")
        public static final String SERVICE_CLOSE_ROOM_FAILED = "ttlive_anchor_real_close_room_fail";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "core")
        public static final String SERVICE_CLOSE_ROOM_REASON = "ttlive_anchor_close_room_reason";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "start")
        public static final String SERVICE_CONTINUE_DIALOG_CONFIRM = "ttlive_anchor_prefix_continue_dialog_confirm";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "core")
        public static final String SERVICE_CONTINUE_DIALOG_SHOW = "ttlive_anchor_prefix_restart_live";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "core")
        public static final String SERVICE_CREATE_ROOM_DURATION = "ttlive_live_success_total_time";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "stream")
        public static final String SERVICE_DELAY_SEND_START_EVENT = "ttlive_delay_send_start_event";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_ENTER_BACKGROUND = "ttlive_anchor_enter_background";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_ENTER_FOREGROUND = "ttlive_anchor_enter_foreground";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_FETCH_BARRAGE_SETTING = "ttlive_fetch_barrage_setting";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "core")
        public static final String SERVICE_FETCH_CREATE_ROOM = "ttlive_fetch_create_room";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "sticker")
        public static final String SERVICE_FETCH_DECORATION_LIST = "ttlive_fetch_decoration_list";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = "core")
        public static final String SERVICE_FETCH_EFFECT_LIST = "ttlive_fetch_effect_list_new";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = "effect")
        public static final String SERVICE_FETCH_EFFECT_LIST_BY_CATEGORY = "ttlive_anchor_fetch_effect_list_by_category";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = "effect")
        public static final String SERVICE_FETCH_EFFECT_PANEL = "ttlive_anchor_fetch_effect_panel_info";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_FETCH_PREVIEW_CREATE_INFO = "ttlive_fetch_preview_room_create_info";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_FETCH_PREVIEW_PRE_CREATE_INFO = "ttlive_fetch_preview_pre_room_create_info";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_FETCH_PREVIEW_USER_PERMISSION = "ttlive_fetch_preview_user_permission";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "core")
        public static final String SERVICE_FETCH_ROOM_CONTINUE = "ttlive_fetch_room_continue";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_FETCH_ROOM_MEMBER_COUNT_LIMIT_LIST = "ttlive_anchor_fetch_room_member_count_limit_list";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_FETCH_VISIBLE_LIST = "ttlive_anchor_prefix_fetch_visible_list";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_FRAGMENT_DESTROY = "ttlive_anchor_prefix_view_destroy";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_FRAGMENT_PAUSE = "ttlive_anchor_view_disappear";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_FRAGMENT_RESUME = "ttlive_anchor_view_appear";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "core")
        public static final String SERVICE_GET_APP_EXIT_INFO_ERROR = "ttlive_anchor_prefix_exit_info_error";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_GET_COVER_IMAGE = "ttlive_get_cover_image";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "core")
        public static final String SERVICE_GET_REAL_EXIT_INFO_ERROR = "ttlive_anchor_prefix_real_exit_info_error";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_GUIDE_LIVE_SUBTYPE = "ttlive_anchor_prefix_guide_live_subType";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_GUILD_LOCATION = "ttlive_guide_location";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_INTERACTION_CREATE = "ttlive_interaction_create";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_INTERACTION_PAUSE = "ttlive_interaction_fragment_pause";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_INTERACTION_RESUME = "ttlive_interaction_fragment_resume";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "stream")
        public static final String SERVICE_LIVE_AV_RESOURCE_REQUEST = "ttlive_live_av_resource_request";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_LIVE_BROADCAST_ACTIVITY_CREATE = "ttlive_anchor_view_did_load";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_network_merge")
        @STAGE(stage = "network")
        public static final String SERVICE_LIVE_STREAM_NETWORK_STATUS = "ttlive_on_live_stream_network_status_changed";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_LIVE_SUB_BROADCAST_ACTIVITY_CREATE = "ttlive_sub_anchor_view_did_load";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "effect")
        public static final String SERVICE_MERGE_EFFECT = "ttlive_anchor_prefix_effect_merge";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "network")
        public static final String SERVICE_MERGE_NETWORK = "ttlive_anchor_prefix_network_merge";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "start")
        public static final String SERVICE_MERGE_SO = "ttlive_anchor_prefix_live_core_so_load_status_merge";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.TOOLBAR)
        public static final String SERVICE_MERGE_TOOLBAR = "ttlive_anchor_prefix_toolbar_merge";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "stream")
        public static final String SERVICE_ON_HANDLE_UPDATE_ROOM_STATUS = "ttlive_on_handle_update_room_status";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_live_core_so_load_status_merge")
        @STAGE(stage = "start")
        public static final String SERVICE_ON_LIVE_CORE_SO_LOAD_STATUS = "ttlive_live_core_so_load_status";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_ON_LIVE_MODE_CHANGE = "ttlive_on_live_mode_change";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "network")
        public static final String SERVICE_ON_LIVE_STREAM_NETWORK_LOW = "ttlive_on_live_stream_network_low";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "stop")
        public static final String SERVICE_ON_NORMAL_CLOSE_ROOM_DIALOG_CONFIRM = "ttlive_close_live_manual";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "core")
        public static final String SERVICE_ON_START_LIVE_BTN_CLICK = "ttlive_click_open_live";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "core")
        public static final String SERVICE_ON_START_LIVE_MODE_NOT_MATCH = "ttlive_anchor_prefix_live_mode_not_match";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "core")
        public static final String SERVICE_ON_START_LIVE_STREAM = "ttlive_start_live_stream";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "stream")
        public static final String SERVICE_ON_STOP_LIVE_STREAM = "ttlive_stop_live_stream";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_PAGE_DESTROY = "ttlive_anchor_prefix_page_destroy";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_PAGE_DISMISS = "ttlive_anchor_prefix_page_dismiss";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_PAGE_SHOW = "ttlive_anchor_prefix_page_show";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "stream")
        public static final String SERVICE_PAUSE_LIVE_STREAM = "ttlive_pause_live";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "stream")
        public static final String SERVICE_PAUSE_LIVE_STREAM_MANAGER = "ttlive_pause_live_stream_manager";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_PERMISSION_CHECK = "ttlive_anchor_prefix_permission_check";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "core")
        public static final String SERVICE_PING_ANCHOR_FAILED = "ttlive_anchor_close_room_fail";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "stream")
        public static final String SERVICE_PREVIEW_CHANGE_SIZE_AND_LOCATION = "ttlive_anchor_prefix_preview_change_size_and_location";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "stream")
        public static final String SERVICE_PREVIEW_SET_DISPLAY = "ttlive_anchor_prefix_preview_set_display";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "stream")
        public static final String SERVICE_PREVIEW_UPDATE_PIPELINE = "ttlive_anchor_prefix_preview_update_pipeline";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "core")
        public static final String SERVICE_PUSH_STREAM_FIRST_STREAM = "ttlive_push_first_frame";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "start")
        public static final String SERVICE_REALTIME_PANEL_DATA_MSG = "ttlive_anchor_prefix_status_center_handle_panel_data";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "start")
        public static final String SERVICE_REALTIME_SUGGEST_MSG = "ttlive_anchor_prefix_status_center_handle_suggest";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_RECEIVE_BLOCK_MSG = "ttlive_receive_block_msg";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_REPLACE_COVER_METHOD = "ttlive_replace_cover_method";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "core")
        public static final String SERVICE_RESTART_MULTIPROCESS_START = "ttlive_restart_multiprocess_start";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "core")
        public static final String SERVICE_RESTART_MULTIPROCESS_SUCCESS = "ttlive_restart_multiprocess_success";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "stream")
        public static final String SERVICE_RESUME_LIVE_STREAM = "ttlive_resume_live";

        @BUSINESSTYPE(type = "start")
        @STAGE(stage = "start")
        public static final String SERVICE_REVIEW_EDUCATION_MSG = "ttlive_anchor_prefix_education_msg";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_ROOM_MEMBER_COUNT_LIMIT_UPDATE = "ttlive_anchor_room_member_count_limit_update";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "stream")
        public static final String SERVICE_SEND_START_EVENT = "ttlive_send_start_event";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "stream")
        public static final String SERVICE_START_AUDIO_CAPTURE = "ttlive_start_audio_capture";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_START_LIVE_FRAGMENT_CREATE = "ttlive_anchor_guide_view_load";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_START_LIVE_FRAGMENT_PAUSE = "ttlive_anchor_guide_view_disappear";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_START_LIVE_FRAGMENT_RESUME = "ttlive_anchor_guide_view_appear";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "core")
        public static final String SERVICE_START_PUSH_STREAM_DURATION = "ttlive_push_first_success_time";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "start")
        public static final String SERVICE_START_TRACE = "ttlive_start_trace";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "stream")
        public static final String SERVICE_START_VIDEO_CAPTURE = "ttlive_start_video_capture";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "start")
        public static final String SERVICE_STATUS_PANEL_BIZ_MSG = "ttlive_anchor_prefix_status_center_publish_biz_message";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "start")
        public static final String SERVICE_STATUS_PANEL_ENTRANCE_CLICK = "ttlive_anchor_prefix_status_center_entrance_click";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "start")
        public static final String SERVICE_STATUS_PANEL_REQUEST_DATA = "ttlive_anchor_prefix_status_center_request";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "start")
        public static final String SERVICE_STATUS_PANEL_SELECT = "ttlive_anchor_prefix_status_center_tab_select";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "stream")
        public static final String SERVICE_STOP_AUDIO_CAPTURE = "ttlive_stop_audio_capture";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "stream")
        public static final String SERVICE_STOP_VIDEO_CAPTURE = "ttlive_stop_video_capture";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "core")
        public static final String SERVICE_STREAM_ON_ERROR_CODE = "ttlive_push_stream_error";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "stream")
        public static final String SERVICE_STREAM_ON_INFO_CODE = "ttlive_stream_info_code";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "stream")
        public static final String SERVICE_STREAM_STATE_AFTER_INTERACTION_SHOW = "ttlive_anchor_prefix_state_after_interaction_show";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "stream")
        public static final String SERVICE_STREAM_STATE_CHANGE = "ttlive_push_stream_state_change";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_SUB_ENTER_BACKGROUND = "ttlive_sub_anchor_enter_background";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_SUB_ENTER_FOREGROUND = "ttlive_sub_anchor_enter_foreground";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_SUB_FRAGMENT_DESTROY = "ttlive_anchor_sub_prefix_view_destroy";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_SUB_FRAGMENT_PAUSE = "ttlive_sub_anchor_view_disappear";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.LIFECYCLE)
        public static final String SERVICE_SUB_FRAGMENT_RESUME = "ttlive_sub_anchor_view_appear";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "stream")
        public static final String SERVICE_SWITCH_VIDEO_CAPTURE = "ttlive_switch_video_capture";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_UPDATE_CREATE_INFO = "ttlive_anchor_prefix_update_create_info";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_UPLOAD_COVER_RESULT = "ttlive_upload_cover_result";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "core")
        public static final String SERVICE_VIDEO_CAPTURE_CHANGE = "ttlive_video_capture_change";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "stream")
        public static final String SERVICE_VIDEO_FLOAT_WINDOW_CHANGE = "ttlive_video_float_window_change";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "stream")
        public static final String SERVICE_VIDEO_FLOAT_WINDOW_ERROR = "ttlive_video_float_window_error";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "stream")
        public static final String SERVICE_VIDEO_FLOAT_WINDOW_HIDE = "ttlive_video_float_window_hide";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_VIDEO_PROBE = "ttlive_anchor_prefix_video_probe";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String SERVICE_VISIBLE_MODIFY_SELECT_RANGE = "ttlive_anchor_prefix_visible_modify_select_range";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.NEWLINK)
        public static final String TTLIVE_ANCHOR_DIRECT_CONTINUE_ROOM = "ttlive_anchor_direct_continue_room";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = STAGE.NEWLINK)
        public static final String TTLIVE_ANCHOR_DIRECT_SHOW_END_PAGE = "ttlive_anchor_direct_show_end_page";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String TTLIVE_ANCHOR_LANDING_SWITCH = "ttlive_anchor_landing_switch";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @STAGE(stage = "preview")
        public static final String TTLIVE_ANCHOR_PREFIX_FETCH_RELATIONSHIP_LIST = "ttlive_anchor_prefix_fetch_relationship_list";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = "effect")
        public static final String TTLIVE_ANCHOR_PREFIX_GET_LINK_OBJ_STICKERS = "ttlive_anchor_prefix_get_link_obj_stickers";

        @BUSINESSTYPE(type = BUSINESSTYPE.CORE)
        @GROUP(group = "ttlive_anchor_prefix_effect_merge")
        @STAGE(stage = "effect")
        public static final String TTLIVE_ANCHOR_PREFIX_UPDATE_LINK_OBJ_STICKERS = "ttlive_anchor_prefix_update_link_obj_stickers";

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f64930a = null;

            public a() {
            }

            static {
                f64930a = new a();
            }
        }

        static {
            Companion = a.f64930a;
        }
    }

    @Target({})
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0006B\b\u0012\u0006\u0010\u0003\u001a\u00020\u0002R\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/core/monitor/NewBroadcastMonitor$STAGE;", "", "", "stage", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.PROPERTY})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    public @interface STAGE {
        public static final String ANNOUNCEMENT = "announcement";
        public static final String CAMERA = "camera";
        public static final String CAST = "cast";
        public static final String CORE = "core";
        public static final a Companion = null;
        public static final String EFFECT = "effect";
        public static final String EXTERNALAMERA = "externalcamera";
        public static final String LIFECYCLE = "lifecycle";
        public static final String MULTICAMERA = "multicamera";
        public static final String NETWORK = "network";
        public static final String NEWLINK = "newlink";
        public static final String PREVIEW = "preview";
        public static final String START = "start";
        public static final String STICKER = "sticker";
        public static final String STOP = "stop";
        public static final String STREAM = "stream";
        public static final String TOOLBAR = "toolbar";

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f64931a = null;

            public a() {
            }

            static {
                f64931a = new a();
            }
        }

        static {
            Companion = a.f64931a;
        }

        String stage();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/core/monitor/NewBroadcastMonitor$STATUS;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface STATUS {
        public static final a Companion = null;
        public static final int FAIL = 1;
        public static final int SUCCESS = 0;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f64932a = null;

            public a() {
            }

            static {
                f64932a = new a();
            }
        }

        static {
            Companion = a.f64932a;
        }
    }

    public static final class a extends LiveMonitor.a {
        @Override // com.bytedance.android.live.core.monitor.LiveMonitor.a
        public final LiveMonitor a() {
            return new b(super.a());
        }

        public final void n(Throwable r100) {
            if (r100 != null) goto L5;
            return;
        L5:
            if ((r100 instanceof CustomApiServerException) == false) goto L8;
            CustomApiServerException r101 = (CustomApiServerException) r100;
            i("log_id", r101.getXTtLogId());
            l(r101.getErrorCode());
            i(LocationMonitorConst.ERR_MSG, r101.getErrorMsg());
            i("err_msg_detail", r100.getMessage());
            return;
        L8:
            if ((r100 instanceof ApiServerException) == false) goto L11;
            ApiServerException r102 = (ApiServerException) r100;
            l(r102.getErrorCode());
            i(LocationMonitorConst.ERR_MSG, r102.getErrorMsg());
            i("err_msg_detail", r100.getMessage());
            return;
        L11:
            if ((r100 instanceof ApiException) == false) goto L18;
            ApiException r103 = (ApiException) r100;
            if (r103.getErrorCode() == 0) goto L15;
            int r104 = r103.getErrorCode();
        L16:
            l(r104);
            i(LocationMonitorConst.ERR_MSG, "api exception");
            i("err_msg_detail", r100.getMessage());
            return;
        L15:
            r104 = -998;
            goto L16
        L18:
            if ((r100 instanceof NetworkErrorException) == false) goto L25;
            int r105 = ((NetworkErrorException) r100).statusCode;
            if (r105 != 0) goto L23;
            r105 = -997;
        L23:
            l(r105);
            i(LocationMonitorConst.ERR_MSG, SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR);
            i("err_msg_detail", r100.getMessage());
            return;
        L25:
            if ((r100 instanceof NetworkNotAvailabeException) == false) goto L27;
            l(((NetworkNotAvailabeException) r100).getCronetInternalErrorCode());
            i(LocationMonitorConst.ERR_MSG, "network not available");
            i("err_msg_detail", r100.getMessage());
            return;
        L27:
            l(-999);
            i(LocationMonitorConst.ERR_MSG, r100.getClass().getSimpleName());
            i("err_msg_detail", r100.getMessage());
        }

        public a(String r100, LiveTracingMonitor.EventModule r101) {
            Intrinsics.checkNotNullParameter(r100, "serviceName");
            Intrinsics.checkNotNullParameter(r101, "eventModule");
            super(r100, r101);
        }
    }

    public static final class b extends LiveMonitor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LiveMonitor f64933a;

        @Override // com.bytedance.android.live.core.monitor.LiveMonitor
        public final void report() {
            Boolean r100 = NewBroadcastMonitor.f64916a;
            if (NewBroadcastMonitor.a(this.f64933a.mServiceName) == false) goto L6;
            this.f64933a.report();
        L6:
            if (jh.f120525a.getValue().booleanValue() == false) goto L104;
            LiveMonitor r101 = this.f64933a;
            String r102 = r101.mServiceName;
            if (r102 == null) goto L113;
            String r103 = (String) ((LinkedHashMap) NewBroadcastMonitor.f64921f).get(r102);
            if (r103 != null) goto L13;
            r103 = BUSINESSTYPE.CORE;
        L13:
            String r104 = (String) ((LinkedHashMap) NewBroadcastMonitor.f64920e).get(r102);
            if (r104 != null) goto L16;
            r104 = "";
        L16:
            int r105 = com.bytedance.android.live.core.monitor.trace.e.f64997m;
            com.bytedance.android.live.core.monitor.trace.e.a r106 = com.bytedance.android.live.core.monitor.trace.e.b.a(r102, r103);
            r106.f65015f = "";
            r106.f65016g = "";
            JSONObject r107 = null;
            r106.f65014e = null;
            r106.f65010a = NewBroadcastMonitor.f64918c;
            r106.b("stage", r104);
            r106.f65012c = "webcast_client_broadcast";
            JSONObject r108 = r101.mExtraLog;
            r106.f65011b = r108.optString("log_id");
            String r109 = r108.optString(LocationMonitorConst.ERR_MSG);
            boolean r110 = false;
            if (r109.length() <= 0) goto L19;
            boolean r111 = true;
        L20:
            if (r111 == true) goto L23;
            r109 = null;
        L23:
            if (r109 == null) goto L25;
            r106.f65018i = r109;
        L26:
            r108.put("trace_event_type", r102);
            String r112 = r108.optString("room_id");
            if (r112.length() <= 0) goto L29;
            boolean r113 = true;
        L30:
            if (r113 == true) goto L33;
            r112 = null;
        L33:
            if (r112 == null) goto L35;
            r106.f65014e = r112;
        L35:
            JSONObject r114 = r101.mCategory;
            if (r114 == null) goto L39;
            r106.f65017h = Integer.valueOf(r114.optInt("status_code", 0));
        L39:
            if (pb.f120965a.getValue().booleanValue() == true) goto L41;
            com.bytedance.android.live.core.monitor.trace.e r115 = r106.a();
            JSONObject r116 = r101.mCategory;
            JSONObject r117 = r101.mMetrics;
            JSONObject r118 = r101.mExtraLog;
            a60.e r119 = com.bytedance.android.live.core.monitor.trace.c.f64995a;
            Intrinsics.checkNotNullParameter(r115, "traceMeta");
            TraceMonitor.i(r115, r116, r117, r118);
            return;
        L41:
            if (gh.f120287a.getValue().booleanValue() == false) goto L71;
            List<String> r120 = c.f64934a;
            com.bytedance.android.live.core.monitor.trace.e r121 = r106.a();
            JSONObject r122 = r101.mCategory;
            JSONObject r123 = r101.mMetrics;
            JSONObject r124 = r101.mExtraLog;
            Intrinsics.checkNotNullParameter(r121, "traceMeta");
            if ((!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) == false) goto L45;
            a60.e r125 = com.bytedance.android.live.core.monitor.trace.c.f64995a;
            Intrinsics.checkNotNullParameter(r121, "traceMeta");
            TraceMonitor.i(r121, r122, r123, r124);
            return;
        L45:
            String r126 = (String) ((LinkedHashMap) NewBroadcastMonitor.f64925j).get(r121.f64998a);
            if ((!Intrinsics.areEqual(c.f64937d, r126)) == false) goto L49;
            c.b();
        L49:
            if (NewBroadcastMonitor.a(r121.f64998a) == false) goto L52;
            if (r124 == null) goto L53;
            r107 = new JSONObject(r124.toString());
        L53:
            if (r126 != null) goto L55;
        L70:
            c.a(r121, r122, r123, r107);
            return;
        L55:
            if (r126.length() <= 0) goto L57;
            r110 = true;
        L57:
            if (r110 != true) goto L70;
            if (r124 == null) goto L60;
            c.f64941h = r124;
        L60:
            c.f64937d = r126;
            if (r107 == null) goto L67;
            Iterator<T> r127 = c.f64934a.iterator();
        L64:
            if (r127.hasNext() == false) goto L66;
            r107.remove((String) r127.next());
            goto L64
        L66:
            r107.remove("trace_event_type");
        L67:
            c.f64940g = r121;
            String r128 = c.f64942i + '_' + r121.f64998a;
            Map<String, d> r129 = c.f64939f;
            d r130 = new d();
            r130.f64955a = r122;
            r130.f64956b = r123;
            r130.f64957c = r107;
            Intrinsics.checkNotNullParameter(r128, "<set-?>");
            Unit r131 = Unit.INSTANCE;
            r129.put(r128, r130);
            int r132 = c.f64942i + 1;
            c.f64942i = r132;
            if (r132 < 10) goto L106;
            c.b();
            return;
        L106:
            return;
        L52:
            r107 = r124;
            goto L53
        L71:
            List<String> r133 = c.f64934a;
            com.bytedance.android.live.core.monitor.trace.e r134 = r106.a();
            JSONObject r135 = r101.mCategory;
            JSONObject r136 = r101.mMetrics;
            JSONObject r137 = r101.mExtraLog;
            Intrinsics.checkNotNullParameter(r134, "traceMeta");
            if ((!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) == false) goto L74;
            a60.e r138 = com.bytedance.android.live.core.monitor.trace.c.f64995a;
            Intrinsics.checkNotNullParameter(r134, "traceMeta");
            TraceMonitor.i(r134, r135, r136, r137);
            return;
        L74:
            String r139 = (String) ((LinkedHashMap) NewBroadcastMonitor.f64925j).get(r134.f64998a);
            if ((!Intrinsics.areEqual(c.f64937d, r139)) == false) goto L77;
            c.b();
        L77:
            if (r137 == null) goto L79;
            r107 = new JSONObject(r137.toString());
        L79:
            if (r139 != null) goto L81;
        L99:
            c.a(r134, r135, r136, r107);
            return;
        L81:
            if (r139.length() <= 0) goto L83;
            r110 = true;
        L83:
            if (r110 != true) goto L99;
            if (r137 == null) goto L86;
            c.f64941h = r137;
        L86:
            c.f64937d = r139;
            if (r107 == null) goto L93;
            Iterator<T> r140 = c.f64934a.iterator();
        L90:
            if (r140.hasNext() == false) goto L92;
            r107.remove((String) r140.next());
            goto L90
        L92:
            r107.remove("trace_event_type");
        L93:
            c.f64940g = r134;
            String r141 = c.f64942i + '_' + r134.f64998a;
            Map<String, JSONObject> r142 = c.f64938e;
            JSONObject r143 = new JSONObject();
            r143.put("timestamp", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss_SSS", Locale.CHINA).format(Long.valueOf(System.currentTimeMillis())));
            r143.put("metric", r136);
            r143.put("category", r135);
            if (r107 == null) goto L96;
            r143.put("extra", r107);
        L96:
            r142.put(r141, r143);
            int r144 = c.f64942i + 1;
            c.f64942i = r144;
            if (r144 < 10) goto L110;
            c.b();
            return;
        L110:
            return;
        L29:
            r113 = false;
            goto L30
        L25:
            r106.f65018i = r108.optString("status_msg");
            goto L26
        L19:
            r111 = false;
            goto L20
        L113:
            return;
        }

        public b(LiveMonitor r100) {
            Intrinsics.checkNotNullParameter(r100, "liveMonitor");
            this.f64933a = r100;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final List<String> f64934a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static PthreadHandlerThreadV2 f64935b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static Handler f64936c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static String f64937d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static Map<String, JSONObject> f64938e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Map<String, d> f64939f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static com.bytedance.android.live.core.monitor.trace.e f64940g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static JSONObject f64941h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static int f64942i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final SimpleDateFormat f64943j = null;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.bytedance.android.live.core.monitor.trace.e f64944a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ JSONObject f64945b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ JSONObject f64946c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ JSONObject f64947d;

            public a(com.bytedance.android.live.core.monitor.trace.e r100, JSONObject r101, JSONObject r102, JSONObject r103) {
                this.f64944a = r100;
                this.f64945b = r101;
                this.f64946c = r102;
                this.f64947d = r103;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.bytedance.android.live.core.monitor.trace.e r100 = this.f64944a;     // Catch: Throwable -> L4
                JSONObject r101 = this.f64945b;     // Catch: Throwable -> L4
                JSONObject r102 = this.f64946c;     // Catch: Throwable -> L4
                JSONObject r103 = this.f64947d;     // Catch: Throwable -> L4
                a60.e r104 = com.bytedance.android.live.core.monitor.trace.c.f64995a;     // Catch: Throwable -> L4
                Intrinsics.checkNotNullParameter(r100, "traceMeta");     // Catch: Throwable -> L4
                TraceMonitor.i(r100, r101, r102, r103);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public static final class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.bytedance.android.live.core.monitor.trace.e f64948a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ JSONObject f64949b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ JSONObject f64950c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ JSONObject f64951d;

            public b(com.bytedance.android.live.core.monitor.trace.e r100, JSONObject r101, JSONObject r102, JSONObject r103) {
                this.f64948a = r100;
                this.f64949b = r101;
                this.f64950c = r102;
                this.f64951d = r103;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.bytedance.android.live.core.monitor.trace.e r100 = this.f64948a;     // Catch: Throwable -> L4
                JSONObject r101 = this.f64949b;     // Catch: Throwable -> L4
                JSONObject r102 = this.f64950c;     // Catch: Throwable -> L4
                JSONObject r103 = this.f64951d;     // Catch: Throwable -> L4
                a60.e r104 = com.bytedance.android.live.core.monitor.trace.c.f64995a;     // Catch: Throwable -> L4
                Intrinsics.checkNotNullParameter(r100, "traceMeta");     // Catch: Throwable -> L4
                TraceMonitor.i(r100, r101, r102, r103);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.core.monitor.NewBroadcastMonitor$c$c, reason: collision with other inner class name */
        public static final class RunnableC1068c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.bytedance.android.live.core.monitor.trace.e f64952a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ JSONObject f64953b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ JSONObject f64954c;

            public RunnableC1068c(com.bytedance.android.live.core.monitor.trace.e r100, JSONObject r101, JSONObject r102) {
                this.f64952a = r100;
                this.f64953b = r101;
                this.f64954c = r102;
            }

            @Override // java.lang.Runnable
            public final void run() {
                List<String> r100 = c.f64934a;     // Catch: Throwable -> L4
                c.a(this.f64952a, this.f64953b, null, this.f64954c);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        static {
            f64934a = CollectionsKt.listOf(new String[]{"room_id", "live_mode", "tag", "device_performance", "monitor_by", "device_id", "webcast_sdk_version", "user_id", "os", "anchor_top_flag", "anchor_trace_uuid"});
            f64937d = "";
            f64938e = new LinkedHashMap();
            f64939f = new LinkedHashMap();
            f64941h = new JSONObject();
            f64943j = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss_SSS", Locale.CHINA);
        }

        public static void b() {
            if (f64942i != 0) goto L5;
            return;
        L5:
            com.bytedance.android.live.core.monitor.trace.e r100 = f64940g;
            if (r100 != null) goto L8;
            return;
        L8:
            String r101 = f64937d;
            Intrinsics.checkNotNullParameter(r101, "<set-?>");
            r100.f64998a = r101;
            JSONObject r102 = new JSONObject();
            r102.put("count", f64942i);
            JSONObject r103 = f64941h;
            Object[] r104 = f64934a.toArray(new String[0]);
            if (r104 == null) goto L33;
            JSONObject r105 = new JSONObject(r103, (String[]) r104);
            Boolean r106 = NewBroadcastMonitor.f64916a;
            if (gh.f120287a.getValue().booleanValue() == false) goto L25;
            Map<String, d> r107 = f64939f;
            if (f64935b != null) goto L15;
            PthreadHandlerThreadV2 r108 = new PthreadHandlerThreadV2("broadcast monitor");
            f64935b = r108;
            ThreadMethodProxy.start(r108);
            f64936c = new Handler(r108.getLooper());
        L15:
            Iterator r109 = ((LinkedHashMap) r107).entrySet().iterator();
        L17:
            if (r109.hasNext() == false) goto L22;
            Map.Entry r110 = (Map.Entry) r109.next();
            String r111 = (String) r110.getKey();
            ((d) r110.getValue()).getClass();
            JSONObject r112 = ((d) r110.getValue()).f64955a;
            JSONObject r113 = ((d) r110.getValue()).f64956b;
            JSONObject r114 = ((d) r110.getValue()).f64957c;
            JSONObject r115 = new JSONObject();
            r115.put("timestamp", f64943j.format(0L));
            r115.put("metric", r113);
            r115.put("category", r112);
            if (r114 == null) goto L21;
            r115.put("extra", r114);
        L21:
            d60.b.a(r105, r111, r115);
            goto L17
        L22:
            Handler r116 = f64936c;
            if (r116 == null) goto L30;
            r116.post(new RunnableC1068c(r100, r102, r105));
        L30:
            f64940g = null;
            f64942i = 0;
            f64938e = new LinkedHashMap();
            return;
        L25:
            Iterator r117 = ((LinkedHashMap) f64938e).entrySet().iterator();
        L27:
            if (r117.hasNext() == false) goto L29;
            Map.Entry r118 = (Map.Entry) r117.next();
            d60.b.a(r105, (String) r118.getKey(), r118.getValue());
            goto L27
        L29:
            a(r100, r102, null, r105);
            goto L30
        L33:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        public static void a(com.bytedance.android.live.core.monitor.trace.e r100, JSONObject r101, JSONObject r102, JSONObject r103) {
            if (kh.f120602a.getValue().booleanValue() == true) goto L5;
            a60.e r104 = com.bytedance.android.live.core.monitor.trace.c.f64995a;
            Intrinsics.checkNotNullParameter(r100, "traceMeta");
            TraceMonitor.i(r100, r101, r102, r103);
            return;
        L5:
            if (f64935b != null) goto L7;
            PthreadHandlerThreadV2 r105 = new PthreadHandlerThreadV2("broadcast monitor");
            f64935b = r105;
            ThreadMethodProxy.start(r105);
            f64936c = new Handler(r105.getLooper());
        L7:
            Boolean r106 = NewBroadcastMonitor.f64916a;
            if (gh.f120287a.getValue().booleanValue() == true) goto L10;
            Handler r107 = f64936c;
            if (r107 == null) goto L23;
            r107.post(new b(r100, r101, r102, r103));
            return;
        L23:
            return;
        L10:
            if ((!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) == false) goto L13;
            a60.e r108 = com.bytedance.android.live.core.monitor.trace.c.f64995a;
            Intrinsics.checkNotNullParameter(r100, "traceMeta");
            TraceMonitor.i(r100, r101, r102, r103);
            return;
        L13:
            Handler r109 = f64936c;
            if (r109 == null) goto L21;
            r109.post(new a(r100, r101, r102, r103));
            return;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public JSONObject f64955a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public JSONObject f64956b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public JSONObject f64957c;

        public d() {
        }
    }

    public static final class e implements ICrashCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveMode f64958a;

        public e(LiveMode r100) {
            this.f64958a = r100;
        }

        @Override // com.bytedance.crash.ICrashCallback
        public final void onCrash(CrashType r100, String r101, Thread r110) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Boolean r111 = NewBroadcastMonitor.f64916a;
            ConcurrentHashMap<String, Long> r112 = NewBroadcastMonitor.f64924i;
            Long r102 = r112.get(r100.getName());
            if (r102 != null) goto L5;
            r102 = 0L;
        L5:
            long r103 = r102.longValue();
            long r104 = System.currentTimeMillis();
            if (Math.abs(r104 - r103) >= 10000) goto L8;
            return;
        L8:
            r112.put(r100.getName(), Long.valueOf(r104));
            a r113 = NewBroadcastMonitor.c(SERVICE.SERVICE_ANCHOR_CRASH_LOG, this.f64958a, null, 10);
            r113.l(-999);
            if (r101 == null) goto L11;
            r113.c(r100.getName());
            r113.i("crash", r101);
            r113.i("crash_type", r100.getName());
        L11:
            r113.a().report();
            if (r101 != null) goto L14;
            return;
        L14:
            if (StringsKt.contains$default(r101, "too much memory", false, 2, null) != true) goto L18;
            NewBroadcastMonitor.e(this.f64958a);
            return;
        }
    }

    public static final class f implements IOOMCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveMode f64959a;

        public f(LiveMode r100) {
            this.f64959a = r100;
        }

        @Override // com.bytedance.crash.IOOMCallback
        public final void onCrash(CrashType r100, Throwable r101, Thread r102, long r103) {
            Intrinsics.checkNotNullParameter(r100, "type");
            a r104 = NewBroadcastMonitor.c(SERVICE.SERVICE_ANCHOR_OOM_LOG, this.f64959a, null, 10);
            r104.l(-999);
            if (r101 == null) goto L5;
            r104.i("crash", r101.getMessage());
            r104.i("crash_type", r100.getName());
        L5:
            r104.a().report();
            Boolean r105 = NewBroadcastMonitor.f64916a;
            NewBroadcastMonitor.e(this.f64959a);
        }
    }

    public NewBroadcastMonitor() {
    }

    static {
        f64916a = v90.f121429a.getValue();
        f64917b = "";
        f64918c = "";
        f64919d = "";
        f64920e = new LinkedHashMap();
        f64921f = new LinkedHashMap();
        f64924i = new ConcurrentHashMap();
        f64925j = new LinkedHashMap();
    }

    public static final boolean a(String r100) {
        if (gh.f120287a.getValue().booleanValue() == true) goto L6;
        return true;
    L6:
        return Intrinsics.areEqual((String) ((LinkedHashMap) f64920e).get(r100), "core");
    }

    public static void b(a r100) {
        r100.i("tag", "ttlive_sdk");
        r100.i("os", "android");
        boolean r101 = true;
        if (f64917b.length() != 0) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L10;
        f64917b = "";
    L10:
        if (f64919d.length() == 0) goto L13;
        r101 = false;
    L13:
        if (r101 == false) goto L15;
        f64919d = "";
    L15:
        r100.i("device_id", f64917b);
        r100.i("user_id", "");
        r100.i("webcast_sdk_version", String.valueOf(com.bytedance.android.livesdk.paas.c.b()));
        r100.i("monitor_by", "new broadcast monitor");
        r100.i("anchor_trace_uuid", f64918c);
        r100.i("multi_camera_status", null);
        if (0.0f < 8.0d) goto L19;
        String r103 = "1";
    L22:
        r100.i("device_performance", r103);
        if (f64916a.booleanValue() == false) goto L26;
        r100.e("isLiveEnd", "0");
        r100.i("isLiveEnd", "0");
        r100.e("processId", null);
        r100.e("appId", null);
        return;
    L26:
        return;
    L19:
        if (0.0f <= 0) goto L21;
        r103 = "3";
        goto L22
    L21:
        r103 = "0";
        goto L22
    L5:
        r102 = false;
        goto L7
    }

    public static int d(Throwable r100) {
        if (r100 != null) goto L6;
        return -999;
    L6:
        if ((r100 instanceof CustomApiServerException) == false) goto L9;
        return ((CustomApiServerException) r100).getErrorCode();
    L9:
        if ((r100 instanceof ApiServerException) == false) goto L12;
        return ((ApiServerException) r100).getErrorCode();
    L12:
        if ((r100 instanceof ApiException) == false) goto L18;
        ApiException r101 = (ApiException) r100;
        if (r101.getErrorCode() != 0) goto L29;
        return -998;
    L29:
        return r101.getErrorCode();
    L18:
        if ((r100 instanceof NetworkErrorException) == false) goto L24;
        int r102 = ((NetworkErrorException) r100).statusCode;
        if (r102 != 0) goto L33;
        return -997;
    L33:
        return r102;
    L24:
        if ((r100 instanceof NetworkNotAvailabeException) == true) goto L26;
        return -999;
    L26:
        return ((NetworkNotAvailabeException) r100).getCronetInternalErrorCode();
    }

    public static void e(LiveMode r110) {
        Integer r100 = ih.f120453a.getValue();
        int r101 = Random.Default.nextInt(1, 10);
        if (p00.f120946a.getValue().dumpStrategy != 2) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        String r103 = "oom_npth";
    L10:
        if (r101 >= r100.intValue()) goto L47;
        String r104 = ((IPerformanceManager) k.n(IPerformanceManager.class)).getModule();
        JSONObject r105 = new JSONObject();
        r105.put(EventConstant.Key.MODULE, r104);
        r105.put("update_version_code", f64919d);
        r105.put("dump_type", r103);
        Pair[] r106 = new Pair[8];
        r106[0] = TuplesKt.to("anchor_id", null);
        r106[1] = TuplesKt.to("room_id", null);
        if (r110 == null) goto L20;
        int r111 = p.f566223a[r110.ordinal()];
        if (r111 == 1) goto L25;
        if (r111 == 2) goto L24;
        if (r111 == 3) goto L23;
        if (r111 == 4) goto L22;
        if (r111 != 5) goto L20;
        String r112 = "media";
    L26:
        r106[2] = TuplesKt.to("live_type", r112);
        r106[3] = TuplesKt.to("oom_time", Long.valueOf(System.currentTimeMillis()));
        r106[4] = TuplesKt.to("live_room_mode", null);
        r106[5] = TuplesKt.to("is_top", null);
        r106[6] = TuplesKt.to("extra_info", r105.toString());
        r106[7] = TuplesKt.to("dump_type", r103);
        Map r113 = MapsKt.mapOf(r106);
        SharedPreferences r107 = jc1.a.b().getSharedPreferences("ttlive_sdk_dump_hprof_meta", 0);
        if (r107 == null) goto L33;
        SharedPreferences.Editor r108 = r107.edit();
        if (r108 == null) goto L33;
        SharedPreferences.Editor r109 = r108.putLong("last_dump_time", System.currentTimeMillis());
        if (r109 == null) goto L33;
        r109.apply();
    L33:
        File r114 = jc1.a.b().getExternalFilesDir("dumpLiveCrashFileDir");
        if (r114 == null) goto L48;
        r114.mkdirs();
        PolarisFileWrapper r115 = new PolarisFileWrapper(r114, "livedump.hprof");
        if (r102 == false) goto L38;
        Npth.dumpHprof(r115.getAbsolutePath());
    L39:
        String r116 = new JSONObject(r113).toString();
        if (r107 == null) goto L49;
        SharedPreferences.Editor r117 = r107.edit();
        if (r117 == null) goto L50;
        SharedPreferences.Editor r118 = r117.putString("meta_info", r116);
        if (r118 == null) goto L51;
        r118.apply();
        return;
    L51:
        return;
    L50:
        return;
    L49:
        return;
    L38:
        Debug.dumpHprofData(r115.getAbsolutePath());
        goto L39
    L48:
        return;
    L22:
        r112 = "voice_live";
        goto L26
    L23:
        r112 = PriorityModule.SCENE_THIRD_PARTY;
        goto L26
    L24:
        r112 = "game";
        goto L26
    L25:
        r112 = "video_live";
    L20:
        r112 = "";
        goto L26
    L47:
        return;
    L8:
        r103 = "oom_debug";
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    @JvmStatic
    public static final void f(@SERVICE String r100) {
        Intrinsics.checkNotNullParameter(r100, "serviceName");
        a r101 = new a(r100, LiveTracingMonitor.EventModule.OPEN_LIVE);
        r101.l(0);
        b(r101);
        r101.f64904g = true;
        r101.f64903f = false;
        r101.a().report();
    }

    public static void i(LiveMode r100) {
        f64924i.clear();
        e r101 = f64922g;
        CrashType r102 = CrashType.ALL;
        Npth.unregisterCrashCallback(r101, r102);
        Npth.unregisterOOMCallback(f64923h, r102);
        e r103 = new e(r100);
        f64922g = r103;
        Npth.registerCrashCallback(r103, r102);
        f r104 = new f(r100);
        f64923h = r104;
        Npth.registerOOMCallback(r104);
    }

    @JvmStatic
    public static final void g(@SERVICE String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "serviceName");
        Intrinsics.checkNotNullParameter(r101, "map");
        a r102 = new a(r100, LiveTracingMonitor.EventModule.OPEN_LIVE);
        r102.l(0);
        b(r102);
        Iterator<Map.Entry<String, String>> r103 = r101.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Map.Entry<String, String> r104 = r103.next();
        r102.i(r104.getKey(), r104.getValue());
        goto L4
    L6:
        r102.f64904g = true;
        r102.f64903f = false;
        r102.a().report();
    }

    @JvmStatic
    public static final void h(@SERVICE String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "broadcastMonitor");
        Intrinsics.checkNotNullParameter(r101, "tag");
        a r102 = new a(r100, LiveTracingMonitor.EventModule.OPEN_LIVE);
        r102.l(0);
        r102.e("page", "room");
        r102.i("custom_tag", r101);
        b(r102);
        r102.f64904g = true;
        r102.f64903f = false;
        r102.a().report();
    }

    public static a c(String r100, LiveMode r101, String r102, int r103) {
        if ((r103 & 4) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 8) == 0) goto L8;
        r102 = null;
    L8:
        Intrinsics.checkNotNullParameter(r100, "serviceName");
        a r104 = new a(r100, LiveTracingMonitor.EventModule.OPEN_LIVE);
        r104.l(0);
        if (r101 == null) goto L11;
        r104.e("live_mode", r101.name());
        r104.i("live_mode", r101.name());
    L11:
        b(r104);
        if (r102 == null) goto L14;
        r104.e("page", r102);
        r104.i("page", r102);
    L14:
        r104.f64904g = true;
        r104.f64903f = false;
        return r104;
    }
}
