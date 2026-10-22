package com.bytedance.android.livesdkapi.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes12.dex */
@Target({ElementType.PARAMETER, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/util/MultiSceneStatistics;", "", "Companion", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface MultiSceneStatistics {
    public static final String BIND_DURATION = "bind_duration";
    public static final String BYTELINK_DATA_RECEIVE_DURATION = "bytelink_data_receive_duration";
    public static final String CHORUS = "chorus";
    public static final String CONTAINER_FIRST_FRAME_DURATION = "container_first_frame_duration";
    public static final Companion Companion = null;
    public static final String DANMU = "danmu";
    public static final String DURATION = "duration";
    public static final String EMPTY_SEAT_LOAD_DURATION = "empty_seat_load_duration";
    public static final String EXPERIENCE_DURATION = "experience_duration";
    public static final String FEED_VIEW_LOAD_DURATION = "feed_view_load_duration";
    public static final String FIRST_SEI_LOAD_DURATION = "first_sei_load_duration";
    public static final String FIRST_USER_LIST_DURATION = "first_user_list_duration";
    public static final String GROUPPK = "grouppk";
    public static final String GUEST_BATTLE = "guest_battle";
    public static final String GUEST_SEAT_LOAD_DURATION = "guest_seat_load_duration";
    public static final String HYBRID_MAIN_DID_MOUNT_DURATION = "hybrid_main_did_mount_duration";
    public static final String HYBRID_RENDER_DID_MOUNT_DURATION = "hybrid_render_did_mount_duration";
    public static final String HYBRIYD_MAIN_DID_MOUNT = "hybriyd_main_did_mount";
    public static final String HYBRIYD_RENDER_DID_MOUNT = "hybriyd_render_did_mount";
    public static final String INTERACT_DURATION = "interact_duration";
    public static final String IS_PRELOAD = "is_preload";
    public static final String IS_PRELOAD_FINISH = "is_preload_finish";
    public static final String KTV = "ktv";
    public static final String LAST_ENTER_TO_PRELOAD_START_TIME = "last_enter_to_preload_start_time";
    public static final String LINK_MIC = "link_mic";
    public static final String LIST_V2_TIME = "list_v2_time";
    public static final String LYNX_CONTAINER_LOAD_DURATION = "lynx_container_load_duration";
    public static final String LYRIC_FIRST_FRAME_DURATION = "lyric_first_frame_duration";
    public static final String MIDI_FIRST_FRAME_DURATION = "midi_first_frame_duration";
    public static final String MULTI_LINK_MODE_TYPE = "multi_link_mode_type";
    public static final String MV_FIRST_FRAME_DURATION = "mv_first_frame_duration";
    public static final String PLAYER_FIRST_FRAME_DURATION = "player_first_frame_duration";
    public static final String PLAYMODE_FIRST_FRAME_DURATION = "playmode_first_frame_duration";
    public static final String PRELOAD_WIDGET_LOAD_DURATION = "preload_widget_load_duration";
    public static final String REAL_DURATION = "real_duration";
    public static final String REAL_EMPTY_SEAT_LOAD_DURATION = "real_empty_seat_load_duration";
    public static final String REAL_ENTER_ROOM_DURATION = "real_enter_room_duration";
    public static final String REAL_FIRST_SEI_LOAD_DURATION = "real_first_sei_load_duration";
    public static final String REAL_FIRST_USER_LIST_DURATION = "real_first_user_list_duration";
    public static final String REAL_GUEST_SEAT_LOAD_DURATION = "real_guest_seat_load_duration";
    public static final String REAL_HYBRID_MAIN_DID_MOUNT_DURATION = "real_hybrid_main_did_mount_duration";
    public static final String REAL_HYBRID_RENDER_DID_MOUNT_DURATION = "real_hybrid_render_did_mount_duration";
    public static final String REAL_PLAYER_FIRST_FRAME_DURATION = "real_player_first_frame_duration";
    public static final String REAL_RENDER_BACKGROUND_DURATION = "real_render_background_duration";
    public static final String REAL_RENDER_LYNX_EMPTY_SEAT_LIST_DURATION = "real_render_lynx_empty_seat_list_duration";
    public static final String REAL_RENDER_LYNX_GUEST_SEAT_LIST_DURATION = "real_render_lynx_guest_seat_list_duration";
    public static final String RENDER_BACKGROUND_DURATION = "render_background_duration";
    public static final String RENDER_CLIPED_BACKGROUND_DURATION = "render_cliped_background_duration";
    public static final String RENDER_LYNX_EMPTY_SEAT_LIST = "lynx_empty_seat_list";
    public static final String RENDER_LYNX_GUEST_SEAT_LIST = "lynx_guest_seat_list";
    public static final String RENDER_LYNX_RECEIVE_LAYOUT_DATA = "lynx_receive_layout_data";
    public static final String RENDER_LYNX_RECEIVE_USER_LIST_DATA = "lynx_receive_user_list_data";
    public static final String REQUEST_SONG = "request_song";
    public static final String ROOM_GROUPPK = "room_grouppk";
    public static final String UI_CONTAINER_MOUNT_DURATION = "ui_container_mount_duration";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b6\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/bytedance/android/livesdkapi/util/MultiSceneStatistics$Companion;", "", "()V", "BIND_DURATION", "", "BYTELINK_DATA_RECEIVE_DURATION", "CHORUS", "CONTAINER_FIRST_FRAME_DURATION", "DANMU", "DURATION", "EMPTY_SEAT_LOAD_DURATION", "EXPERIENCE_DURATION", "FEED_VIEW_LOAD_DURATION", "FIRST_SEI_LOAD_DURATION", "FIRST_USER_LIST_DURATION", "GROUPPK", "GUEST_BATTLE", "GUEST_SEAT_LOAD_DURATION", "HYBRID_MAIN_DID_MOUNT_DURATION", "HYBRID_RENDER_DID_MOUNT_DURATION", "HYBRIYD_MAIN_DID_MOUNT", "HYBRIYD_RENDER_DID_MOUNT", "INTERACT_DURATION", "IS_PRELOAD", "IS_PRELOAD_FINISH", "KTV", "LAST_ENTER_TO_PRELOAD_START_TIME", "LINK_MIC", "LIST_V2_TIME", "LYNX_CONTAINER_LOAD_DURATION", "LYRIC_FIRST_FRAME_DURATION", "MIDI_FIRST_FRAME_DURATION", "MULTI_LINK_MODE_TYPE", "MV_FIRST_FRAME_DURATION", "PLAYER_FIRST_FRAME_DURATION", "PLAYMODE_FIRST_FRAME_DURATION", "PRELOAD_WIDGET_LOAD_DURATION", "REAL_DURATION", "REAL_EMPTY_SEAT_LOAD_DURATION", "REAL_ENTER_ROOM_DURATION", "REAL_FIRST_SEI_LOAD_DURATION", "REAL_FIRST_USER_LIST_DURATION", "REAL_GUEST_SEAT_LOAD_DURATION", "REAL_HYBRID_MAIN_DID_MOUNT_DURATION", "REAL_HYBRID_RENDER_DID_MOUNT_DURATION", "REAL_PLAYER_FIRST_FRAME_DURATION", "REAL_RENDER_BACKGROUND_DURATION", "REAL_RENDER_LYNX_EMPTY_SEAT_LIST_DURATION", "REAL_RENDER_LYNX_GUEST_SEAT_LIST_DURATION", "RENDER_BACKGROUND_DURATION", "RENDER_CLIPED_BACKGROUND_DURATION", "RENDER_LYNX_EMPTY_SEAT_LIST", "RENDER_LYNX_GUEST_SEAT_LIST", "RENDER_LYNX_RECEIVE_LAYOUT_DATA", "RENDER_LYNX_RECEIVE_USER_LIST_DATA", "REQUEST_SONG", "ROOM_GROUPPK", "UI_CONTAINER_MOUNT_DURATION", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String BIND_DURATION = "bind_duration";
        public static final String BYTELINK_DATA_RECEIVE_DURATION = "bytelink_data_receive_duration";
        public static final String CHORUS = "chorus";
        public static final String CONTAINER_FIRST_FRAME_DURATION = "container_first_frame_duration";
        public static final String DANMU = "danmu";
        public static final String DURATION = "duration";
        public static final String EMPTY_SEAT_LOAD_DURATION = "empty_seat_load_duration";
        public static final String EXPERIENCE_DURATION = "experience_duration";
        public static final String FEED_VIEW_LOAD_DURATION = "feed_view_load_duration";
        public static final String FIRST_SEI_LOAD_DURATION = "first_sei_load_duration";
        public static final String FIRST_USER_LIST_DURATION = "first_user_list_duration";
        public static final String GROUPPK = "grouppk";
        public static final String GUEST_BATTLE = "guest_battle";
        public static final String GUEST_SEAT_LOAD_DURATION = "guest_seat_load_duration";
        public static final String HYBRID_MAIN_DID_MOUNT_DURATION = "hybrid_main_did_mount_duration";
        public static final String HYBRID_RENDER_DID_MOUNT_DURATION = "hybrid_render_did_mount_duration";
        public static final String HYBRIYD_MAIN_DID_MOUNT = "hybriyd_main_did_mount";
        public static final String HYBRIYD_RENDER_DID_MOUNT = "hybriyd_render_did_mount";
        public static final String INTERACT_DURATION = "interact_duration";
        public static final String IS_PRELOAD = "is_preload";
        public static final String IS_PRELOAD_FINISH = "is_preload_finish";
        public static final String KTV = "ktv";
        public static final String LAST_ENTER_TO_PRELOAD_START_TIME = "last_enter_to_preload_start_time";
        public static final String LINK_MIC = "link_mic";
        public static final String LIST_V2_TIME = "list_v2_time";
        public static final String LYNX_CONTAINER_LOAD_DURATION = "lynx_container_load_duration";
        public static final String LYRIC_FIRST_FRAME_DURATION = "lyric_first_frame_duration";
        public static final String MIDI_FIRST_FRAME_DURATION = "midi_first_frame_duration";
        public static final String MULTI_LINK_MODE_TYPE = "multi_link_mode_type";
        public static final String MV_FIRST_FRAME_DURATION = "mv_first_frame_duration";
        public static final String PLAYER_FIRST_FRAME_DURATION = "player_first_frame_duration";
        public static final String PLAYMODE_FIRST_FRAME_DURATION = "playmode_first_frame_duration";
        public static final String PRELOAD_WIDGET_LOAD_DURATION = "preload_widget_load_duration";
        public static final String REAL_DURATION = "real_duration";
        public static final String REAL_EMPTY_SEAT_LOAD_DURATION = "real_empty_seat_load_duration";
        public static final String REAL_ENTER_ROOM_DURATION = "real_enter_room_duration";
        public static final String REAL_FIRST_SEI_LOAD_DURATION = "real_first_sei_load_duration";
        public static final String REAL_FIRST_USER_LIST_DURATION = "real_first_user_list_duration";
        public static final String REAL_GUEST_SEAT_LOAD_DURATION = "real_guest_seat_load_duration";
        public static final String REAL_HYBRID_MAIN_DID_MOUNT_DURATION = "real_hybrid_main_did_mount_duration";
        public static final String REAL_HYBRID_RENDER_DID_MOUNT_DURATION = "real_hybrid_render_did_mount_duration";
        public static final String REAL_PLAYER_FIRST_FRAME_DURATION = "real_player_first_frame_duration";
        public static final String REAL_RENDER_BACKGROUND_DURATION = "real_render_background_duration";
        public static final String REAL_RENDER_LYNX_EMPTY_SEAT_LIST_DURATION = "real_render_lynx_empty_seat_list_duration";
        public static final String REAL_RENDER_LYNX_GUEST_SEAT_LIST_DURATION = "real_render_lynx_guest_seat_list_duration";
        public static final String RENDER_BACKGROUND_DURATION = "render_background_duration";
        public static final String RENDER_CLIPED_BACKGROUND_DURATION = "render_cliped_background_duration";
        public static final String RENDER_LYNX_EMPTY_SEAT_LIST = "lynx_empty_seat_list";
        public static final String RENDER_LYNX_GUEST_SEAT_LIST = "lynx_guest_seat_list";
        public static final String RENDER_LYNX_RECEIVE_LAYOUT_DATA = "lynx_receive_layout_data";
        public static final String RENDER_LYNX_RECEIVE_USER_LIST_DATA = "lynx_receive_user_list_data";
        public static final String REQUEST_SONG = "request_song";
        public static final String ROOM_GROUPPK = "room_grouppk";
        public static final String UI_CONTAINER_MOUNT_DURATION = "ui_container_mount_duration";

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
