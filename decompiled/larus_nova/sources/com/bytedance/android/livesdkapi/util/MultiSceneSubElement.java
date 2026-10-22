package com.bytedance.android.livesdkapi.util;

import com.alibaba.gaiax.model.GXAnimation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes12.dex */
@Target({ElementType.PARAMETER, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/util/MultiSceneSubElement;", "", "Companion", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface MultiSceneSubElement {
    public static final String BACKGROUND_LOAD = "background_Load";
    public static final String BIND = "bind";
    public static final String BYTELINK_DATA_RECEIVE = "bytelink_data_receive";
    public static final String CONTAINER_LOAD = "container_load";
    public static final Companion Companion = null;
    public static final String DATA_CENTER_RECEIVE_GUEST_LIST = "data_center_receive_guest_list";
    public static final String DATA_LISTENER = "data_listener";
    public static final String EMPTY_SEAT_LIST_DATA = "empty_seat_list_data";
    public static final String EMPTY_SEAT_LOAD = "empty_seat_load";
    public static final String EMPTY_SEAT_RENDER = "empty_seat_render";
    public static final String FEED_VIEW_LOADED = "feed_view_loaded";
    public static final String FEED_VIEW_SELECTED = "feed_view_selected";
    public static final String FIRST_SEI_LOAD = "first_sei_load";
    public static final String GUEST_SEAT_LOAD = "guest_seat_load";
    public static final String GUEST_SEAT_RENDER = "guest_seat_render";
    public static final String HYBRIYD_MAIN_DID_CONSTRUCTOR = "hybriyd_main_did_constructor";
    public static final String HYBRIYD_MAIN_DID_MOUNT = "hybriyd_main_did_mount";
    public static final String HYBRIYD_RENDER_DID_CONSTRUCTOR = "hybriyd_render_did_constructor";
    public static final String HYBRIYD_RENDER_DID_MOUNT = "hybriyd_render_did_mount";
    public static final String JSB_RECEIVE_GUEST_LIST = "jsb_receive_guest_list";
    public static final String JSB_RECEIVE_LAYOUT_INFO = "jsb_receive_layout_info";
    public static final String JSB_RECEIVE_LINKMIC_INFO = "jsb_receive_linkmic_info";
    public static final String LIST_V2_TIME = "list_v2_time";
    public static final String LYNX_CONTAINER_LOAD = "lynx_container_load";
    public static final String LYNX_CONTAINER_LOAD_START = "lynx_container_load_start";
    public static final String LYNX_RECEIVE_GUEST_LIST = "lynx_receive_guest_list";
    public static final String LYNX_RECEIVE_LAYOUT_INFO = "lynx_receive_layout_info";
    public static final String LYNX_RECEIVE_LINKMIC_INFO = "lynx_receive_linkmic_info";
    public static final String LYRIC_LOAD = "lyric_load";
    public static final String MIDI_LOAD = "midi_load";
    public static final String MV_LOAD = "mv_load";
    public static final String NATIVE_MICSEAT_RECEIVE_GUEST_LIST = "native_micseat_receive_guest_list";
    public static final String NATIVE_MICSEAT_RECEIVE_LAYOUT_CONFIG = "native_micseat_receive_layout_config";
    public static final String NATIVE_READY_SEND_GUEST_LIST = "native_ready_send_guest_list";
    public static final String NATIVE_READY_SEND_LAYOUT_INFO = "native_ready_send_layout_info";
    public static final String NATIVE_RECEIVE_LAYOUT_CONFIG = "native_receive_layout_config";
    public static final String NATIVE_RECEIVE_UI_LAYOUT = "native_receive_ui_layout";
    public static final String NATIVE_SEND_FRAME_INFO = "native_send_frame_info";
    public static final String NATIVE_SEND_GUEST_LIST = "native_send_guest_list";
    public static final String NATIVE_SEND_LAYOUT_INFO = "native_send_layout_info";
    public static final String NATIVE_SEND_UI_LAYOUT = "native_send_ui_layout";
    public static final String P0_WIDGET = "p0_widget";
    public static final String PLAYER_FIRST_FRAME = "player_first_frame";
    public static final String PLAYMODE_END = "playmode_end";
    public static final String PLAYMODE_START = "playmode_start";
    public static final String PRELOAD_WIDGET_LOAD = "preload_widget_load";
    public static final String RENDER_LYNX_EMPTY_SEAT_LIST = "lynx_empty_seat_list";
    public static final String RENDER_LYNX_GUEST_SEAT_LIST = "lynx_guest_seat_list";
    public static final String RENDER_LYNX_LISTENER_USER_LIST_DATA = "lynx_listener_user_list_data";
    public static final String RENDER_LYNX_RECEIVE_FRAME_INFO = "lynx_receive_frame_info";
    public static final String SEND_START_EVENT = "send_start_event";
    public static final String START = "start";
    public static final String WIDGET_LOAD = "widget_load";
    public static final String WINDOW_MANAGER_LOAD = "window_manager_load";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b5\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/bytedance/android/livesdkapi/util/MultiSceneSubElement$Companion;", "", "()V", "BACKGROUND_LOAD", "", "BIND", "BYTELINK_DATA_RECEIVE", "CONTAINER_LOAD", "DATA_CENTER_RECEIVE_GUEST_LIST", "DATA_LISTENER", "EMPTY_SEAT_LIST_DATA", "EMPTY_SEAT_LOAD", "EMPTY_SEAT_RENDER", "FEED_VIEW_LOADED", "FEED_VIEW_SELECTED", "FIRST_SEI_LOAD", "GUEST_SEAT_LOAD", "GUEST_SEAT_RENDER", "HYBRIYD_MAIN_DID_CONSTRUCTOR", "HYBRIYD_MAIN_DID_MOUNT", "HYBRIYD_RENDER_DID_CONSTRUCTOR", "HYBRIYD_RENDER_DID_MOUNT", "JSB_RECEIVE_GUEST_LIST", "JSB_RECEIVE_LAYOUT_INFO", "JSB_RECEIVE_LINKMIC_INFO", "LIST_V2_TIME", "LYNX_CONTAINER_LOAD", "LYNX_CONTAINER_LOAD_START", "LYNX_RECEIVE_GUEST_LIST", "LYNX_RECEIVE_LAYOUT_INFO", "LYNX_RECEIVE_LINKMIC_INFO", "LYRIC_LOAD", "MIDI_LOAD", "MV_LOAD", "NATIVE_MICSEAT_RECEIVE_GUEST_LIST", "NATIVE_MICSEAT_RECEIVE_LAYOUT_CONFIG", "NATIVE_READY_SEND_GUEST_LIST", "NATIVE_READY_SEND_LAYOUT_INFO", "NATIVE_RECEIVE_LAYOUT_CONFIG", "NATIVE_RECEIVE_UI_LAYOUT", "NATIVE_SEND_FRAME_INFO", "NATIVE_SEND_GUEST_LIST", "NATIVE_SEND_LAYOUT_INFO", "NATIVE_SEND_UI_LAYOUT", "P0_WIDGET", "PLAYER_FIRST_FRAME", "PLAYMODE_END", "PLAYMODE_START", "PRELOAD_WIDGET_LOAD", "RENDER_LYNX_EMPTY_SEAT_LIST", "RENDER_LYNX_GUEST_SEAT_LIST", "RENDER_LYNX_LISTENER_USER_LIST_DATA", "RENDER_LYNX_RECEIVE_FRAME_INFO", "SEND_START_EVENT", GXAnimation.STATE_START, "WIDGET_LOAD", "WINDOW_MANAGER_LOAD", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String BACKGROUND_LOAD = "background_Load";
        public static final String BIND = "bind";
        public static final String BYTELINK_DATA_RECEIVE = "bytelink_data_receive";
        public static final String CONTAINER_LOAD = "container_load";
        public static final String DATA_CENTER_RECEIVE_GUEST_LIST = "data_center_receive_guest_list";
        public static final String DATA_LISTENER = "data_listener";
        public static final String EMPTY_SEAT_LIST_DATA = "empty_seat_list_data";
        public static final String EMPTY_SEAT_LOAD = "empty_seat_load";
        public static final String EMPTY_SEAT_RENDER = "empty_seat_render";
        public static final String FEED_VIEW_LOADED = "feed_view_loaded";
        public static final String FEED_VIEW_SELECTED = "feed_view_selected";
        public static final String FIRST_SEI_LOAD = "first_sei_load";
        public static final String GUEST_SEAT_LOAD = "guest_seat_load";
        public static final String GUEST_SEAT_RENDER = "guest_seat_render";
        public static final String HYBRIYD_MAIN_DID_CONSTRUCTOR = "hybriyd_main_did_constructor";
        public static final String HYBRIYD_MAIN_DID_MOUNT = "hybriyd_main_did_mount";
        public static final String HYBRIYD_RENDER_DID_CONSTRUCTOR = "hybriyd_render_did_constructor";
        public static final String HYBRIYD_RENDER_DID_MOUNT = "hybriyd_render_did_mount";
        public static final String JSB_RECEIVE_GUEST_LIST = "jsb_receive_guest_list";
        public static final String JSB_RECEIVE_LAYOUT_INFO = "jsb_receive_layout_info";
        public static final String JSB_RECEIVE_LINKMIC_INFO = "jsb_receive_linkmic_info";
        public static final String LIST_V2_TIME = "list_v2_time";
        public static final String LYNX_CONTAINER_LOAD = "lynx_container_load";
        public static final String LYNX_CONTAINER_LOAD_START = "lynx_container_load_start";
        public static final String LYNX_RECEIVE_GUEST_LIST = "lynx_receive_guest_list";
        public static final String LYNX_RECEIVE_LAYOUT_INFO = "lynx_receive_layout_info";
        public static final String LYNX_RECEIVE_LINKMIC_INFO = "lynx_receive_linkmic_info";
        public static final String LYRIC_LOAD = "lyric_load";
        public static final String MIDI_LOAD = "midi_load";
        public static final String MV_LOAD = "mv_load";
        public static final String NATIVE_MICSEAT_RECEIVE_GUEST_LIST = "native_micseat_receive_guest_list";
        public static final String NATIVE_MICSEAT_RECEIVE_LAYOUT_CONFIG = "native_micseat_receive_layout_config";
        public static final String NATIVE_READY_SEND_GUEST_LIST = "native_ready_send_guest_list";
        public static final String NATIVE_READY_SEND_LAYOUT_INFO = "native_ready_send_layout_info";
        public static final String NATIVE_RECEIVE_LAYOUT_CONFIG = "native_receive_layout_config";
        public static final String NATIVE_RECEIVE_UI_LAYOUT = "native_receive_ui_layout";
        public static final String NATIVE_SEND_FRAME_INFO = "native_send_frame_info";
        public static final String NATIVE_SEND_GUEST_LIST = "native_send_guest_list";
        public static final String NATIVE_SEND_LAYOUT_INFO = "native_send_layout_info";
        public static final String NATIVE_SEND_UI_LAYOUT = "native_send_ui_layout";
        public static final String P0_WIDGET = "p0_widget";
        public static final String PLAYER_FIRST_FRAME = "player_first_frame";
        public static final String PLAYMODE_END = "playmode_end";
        public static final String PLAYMODE_START = "playmode_start";
        public static final String PRELOAD_WIDGET_LOAD = "preload_widget_load";
        public static final String RENDER_LYNX_EMPTY_SEAT_LIST = "lynx_empty_seat_list";
        public static final String RENDER_LYNX_GUEST_SEAT_LIST = "lynx_guest_seat_list";
        public static final String RENDER_LYNX_LISTENER_USER_LIST_DATA = "lynx_listener_user_list_data";
        public static final String RENDER_LYNX_RECEIVE_FRAME_INFO = "lynx_receive_frame_info";
        public static final String SEND_START_EVENT = "send_start_event";
        public static final String START = "start";
        public static final String WIDGET_LOAD = "widget_load";
        public static final String WINDOW_MANAGER_LOAD = "window_manager_load";

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }
}
