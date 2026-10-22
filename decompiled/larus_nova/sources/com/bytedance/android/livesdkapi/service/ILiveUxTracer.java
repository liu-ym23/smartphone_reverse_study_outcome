package com.bytedance.android.livesdkapi.service;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes12.dex */
@ServiceLookup("com.bytedance.android.livesdkapi.service.ILiveUxTracer")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 !2\u00020\u0001:\u0001!J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J&\u0010\t\u001a\u00020\u00072\b\b\u0001\u0010\n\u001a\u00020\u00052\b\b\u0001\u0010\u000b\u001a\u00020\u00052\b\b\u0001\u0010\f\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H&J\u001c\u0010\u000e\u001a\u00020\u00072\b\b\u0001\u0010\n\u001a\u00020\u00052\b\b\u0001\u0010\u000f\u001a\u00020\u0005H&J8\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00052\b\b\u0001\u0010\u0012\u001a\u00020\u00052\b\b\u0001\u0010\u0013\u001a\u00020\u00052\b\b\u0001\u0010\u0014\u001a\u00020\u00052\b\b\u0001\u0010\u0015\u001a\u00020\u0005H&J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0005H&J\u001c\u0010\u0017\u001a\u00020\u00112\b\b\u0001\u0010\n\u001a\u00020\u00052\b\b\u0001\u0010\u000f\u001a\u00020\u0005H&J\b\u0010\u0018\u001a\u00020\u0011H&J\b\u0010\u0019\u001a\u00020\u0011H&J\u001a\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H&J\u0016\u0010\u001c\u001a\u00020\u00112\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00110\u001eH&J\u0018\u0010\u001f\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0007H&¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdkapi/service/ILiveUxTracer;", "Lcom/bytedance/android/live/base/IService;", "getArgument", "", "key", "", "getDirectDuration", "", "name", "getSceneDurationMs", "scene", "start", "end", "getSingleTimeStamp", "getTimeStamp", "milestone", "markDurationForReport", "", "sceneStart", "milestoneStart", "sceneEnd", "mileStoneEnd", "recordSingleTimeStamp", "recordTimeStamp", "report", BasicTestActionHandler.TEST_ACTION_RESET, "setArgument", "value", "setBeforeReportCallback", "callback", "Lkotlin/Function0;", "traceDirectDuration", "durationMs", "Companion", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveUxTracer extends IService {
    public static final String ARG_APP_FIRST_AFTER_START_UP = "first_after_app_launch";
    public static final String ARG_BOOLEAN_IS_COMMERCE_ROOM = "is_commerce_room";
    public static final String ARG_INT_APPLICATION_ACTIVE = "app_state";
    public static final String ARG_INT_NEW_ANCHOR = "new_anchor";
    public static final String ARG_INT_ROLE_TYPE = "role_type";
    public static final String ARG_INT_VERIFY_INTERRUPTED = "interrupt_verify";
    public static final String ARG_ROOM_SLIDE_CONTAINER_CREATE = "slide_container_create";
    public static final String ARG_STRING_ANCHOR_ID = "anchor_id";
    public static final String ARG_STRING_EVENT_SESSION_ID = "event_session_id";
    public static final String ARG_STRING_EVENT_SOURCE = "event_source";
    public static final String ARG_STRING_NETWORK_STATUS_MSG = "network_status";
    public static final String ARG_STRING_ROOM_ID = "room_id";
    public static final Companion Companion = null;
    public static final String MILESTONE_END = "end";
    public static final String MILESTONE_START = "start";
    public static final String SCENE_ENTER_ROOM = "enter_room";
    public static final String SCENE_ENTER_ROOM_API_DURATION = "enter_room_api_duration";
    public static final String SCENE_INTERACTION_LIFECYCLE_ACTIVITY_CREATE = "interaction_activity_create";
    public static final String SCENE_INTERACTION_LIFECYCLE_RESUME = "interaction_resume";
    public static final String SCENE_SINGLE_INTERACTION_CREATE = "interaction_create";
    public static final String SCENE_SINGLE_INTERACTION_ENTER_ROOM = "interaction_enter_room";
    public static final String SCENE_SINGLE_PLAY_ENTER_SUCCEED = "play_enter_succeed";
    public static final String SCENE_SINGLE_PLAY_PART_SHOW_INTERACTION = "play_part_show_interaction";
    public static final String SCENE_SINGLE_PLAY_SHOW_INTERACTION = "play_show_interaction";
    public static final String SCENE_SINGLE_TOOLBAR_MANAGER_ROOM_ENTER = "toolbar_manager_room_enter";
    public static final String SCENE_START_LIVE = "start_live";
    public static final String SCENE_TOOLBAR_CONFIG_VIEWS = "toolbar_config_views";
    public static final String SCENE_WIDGET_LOAD_TOOLBAR = "widget_load_toolbar";
    public static final String TAG = "LiveUxTracer";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001e\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002 !B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdkapi/service/ILiveUxTracer$Companion;", "", "()V", "ARG_APP_FIRST_AFTER_START_UP", "", "ARG_BOOLEAN_IS_COMMERCE_ROOM", "ARG_INT_APPLICATION_ACTIVE", "ARG_INT_NEW_ANCHOR", "ARG_INT_ROLE_TYPE", "ARG_INT_VERIFY_INTERRUPTED", "ARG_ROOM_SLIDE_CONTAINER_CREATE", "ARG_STRING_ANCHOR_ID", "ARG_STRING_EVENT_SESSION_ID", "ARG_STRING_EVENT_SOURCE", "ARG_STRING_NETWORK_STATUS_MSG", "ARG_STRING_ROOM_ID", "MILESTONE_END", "MILESTONE_START", "SCENE_ENTER_ROOM", "SCENE_ENTER_ROOM_API_DURATION", "SCENE_INTERACTION_LIFECYCLE_ACTIVITY_CREATE", "SCENE_INTERACTION_LIFECYCLE_RESUME", "SCENE_SINGLE_INTERACTION_CREATE", "SCENE_SINGLE_INTERACTION_ENTER_ROOM", "SCENE_SINGLE_PLAY_ENTER_SUCCEED", "SCENE_SINGLE_PLAY_PART_SHOW_INTERACTION", "SCENE_SINGLE_PLAY_SHOW_INTERACTION", "SCENE_SINGLE_TOOLBAR_MANAGER_ROOM_ENTER", "SCENE_START_LIVE", "SCENE_TOOLBAR_CONFIG_VIEWS", "SCENE_WIDGET_LOAD_TOOLBAR", "TAG", "Milestone", "Scene", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String ARG_APP_FIRST_AFTER_START_UP = "first_after_app_launch";
        public static final String ARG_BOOLEAN_IS_COMMERCE_ROOM = "is_commerce_room";
        public static final String ARG_INT_APPLICATION_ACTIVE = "app_state";
        public static final String ARG_INT_NEW_ANCHOR = "new_anchor";
        public static final String ARG_INT_ROLE_TYPE = "role_type";
        public static final String ARG_INT_VERIFY_INTERRUPTED = "interrupt_verify";
        public static final String ARG_ROOM_SLIDE_CONTAINER_CREATE = "slide_container_create";
        public static final String ARG_STRING_ANCHOR_ID = "anchor_id";
        public static final String ARG_STRING_EVENT_SESSION_ID = "event_session_id";
        public static final String ARG_STRING_EVENT_SOURCE = "event_source";
        public static final String ARG_STRING_NETWORK_STATUS_MSG = "network_status";
        public static final String ARG_STRING_ROOM_ID = "room_id";
        public static final String MILESTONE_END = "end";
        public static final String MILESTONE_START = "start";
        public static final String SCENE_ENTER_ROOM = "enter_room";
        public static final String SCENE_ENTER_ROOM_API_DURATION = "enter_room_api_duration";
        public static final String SCENE_INTERACTION_LIFECYCLE_ACTIVITY_CREATE = "interaction_activity_create";
        public static final String SCENE_INTERACTION_LIFECYCLE_RESUME = "interaction_resume";
        public static final String SCENE_SINGLE_INTERACTION_CREATE = "interaction_create";
        public static final String SCENE_SINGLE_INTERACTION_ENTER_ROOM = "interaction_enter_room";
        public static final String SCENE_SINGLE_PLAY_ENTER_SUCCEED = "play_enter_succeed";
        public static final String SCENE_SINGLE_PLAY_PART_SHOW_INTERACTION = "play_part_show_interaction";
        public static final String SCENE_SINGLE_PLAY_SHOW_INTERACTION = "play_show_interaction";
        public static final String SCENE_SINGLE_TOOLBAR_MANAGER_ROOM_ENTER = "toolbar_manager_room_enter";
        public static final String SCENE_START_LIVE = "start_live";
        public static final String SCENE_TOOLBAR_CONFIG_VIEWS = "toolbar_config_views";
        public static final String SCENE_WIDGET_LOAD_TOOLBAR = "widget_load_toolbar";
        public static final String TAG = "LiveUxTracer";

        @Retention(RetentionPolicy.RUNTIME)
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0086\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/ILiveUxTracer$Companion$Milestone;", "", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
        public @interface Milestone {
        }

        @Retention(RetentionPolicy.RUNTIME)
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0086\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/ILiveUxTracer$Companion$Scene;", "", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
        public @interface Scene {
        }

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    Object getArgument(String r100);

    long getDirectDuration(String r100);

    long getSceneDurationMs(@Companion.Scene String r100, @Companion.Milestone String r101, @Companion.Milestone String r102);

    long getSingleTimeStamp(String r100);

    long getTimeStamp(@Companion.Scene String r100, @Companion.Milestone String r101);

    void markDurationForReport(String r100, @Companion.Scene String r101, @Companion.Milestone String r102, @Companion.Scene String r103, @Companion.Milestone String r104);

    void recordSingleTimeStamp(String r100);

    void recordTimeStamp(@Companion.Scene String r100, @Companion.Milestone String r101);

    void report();

    void reset();

    void setArgument(String r100, Object r101);

    void setBeforeReportCallback(Function0<Unit> r100);

    void traceDirectDuration(String r100, long r101);
}
