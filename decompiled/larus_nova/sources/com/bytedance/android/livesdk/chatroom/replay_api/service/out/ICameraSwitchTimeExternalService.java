package com.bytedance.android.livesdk.chatroom.replay_api.service.out;

import com.ss.ttvideoengine.portrait.PortraitEngine;
import kotlin.Metadata;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
public interface ICameraSwitchTimeExternalService {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u001c\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay_api/service/out/ICameraSwitchTimeExternalService$EventName;", "", "start_switch_stream", "start_pull_stream", PortraitEngine.LABEL_FIRST_FRAME, "playing", "stream_start", "stream_sdk_dns_analysis_end", "stream_prepare_block_end", "stream_player_dns_analysis_end", "stream_tfo_fall_back_time", "stream_tcp_connect_end", "stream_tcp_first_package_end", "stream_first_video_package_end", "stream_first_audio_package_end", "stream_first_video_frame_decode_end", "stream_first_audio_frame_decode_end", "stream_first_frame_from_player_core", "stream_first_frame_render_end", "stream_video_device_open_start", "stream_video_device_open_end", "stream_audio_device_open_start", "stream_audio_device_open_end", "stream_prepare_end", "stream_set_surface_time", "stream_video_device_wait_start", "stream_video_device_wait_end", "stream_find_stream_info_start", "stream_find_stream_info_end", "vs-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum EventName extends Enum<EventName> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EventName[] f110378a = null;
        public static final EventName first_frame = null;
        public static final EventName playing = null;
        public static final EventName start_pull_stream = null;
        public static final EventName start_switch_stream = null;
        public static final EventName stream_audio_device_open_end = null;
        public static final EventName stream_audio_device_open_start = null;
        public static final EventName stream_find_stream_info_end = null;
        public static final EventName stream_find_stream_info_start = null;
        public static final EventName stream_first_audio_frame_decode_end = null;
        public static final EventName stream_first_audio_package_end = null;
        public static final EventName stream_first_frame_from_player_core = null;
        public static final EventName stream_first_frame_render_end = null;
        public static final EventName stream_first_video_frame_decode_end = null;
        public static final EventName stream_first_video_package_end = null;
        public static final EventName stream_player_dns_analysis_end = null;
        public static final EventName stream_prepare_block_end = null;
        public static final EventName stream_prepare_end = null;
        public static final EventName stream_sdk_dns_analysis_end = null;
        public static final EventName stream_set_surface_time = null;
        public static final EventName stream_start = null;
        public static final EventName stream_tcp_connect_end = null;
        public static final EventName stream_tcp_first_package_end = null;
        public static final EventName stream_tfo_fall_back_time = null;
        public static final EventName stream_video_device_open_end = null;
        public static final EventName stream_video_device_open_start = null;
        public static final EventName stream_video_device_wait_end = null;
        public static final EventName stream_video_device_wait_start = null;

        static {
            EventName r100 = new EventName("start_switch_stream", 0);
            start_switch_stream = r100;
            EventName r101 = new EventName("start_pull_stream", 1);
            start_pull_stream = r101;
            EventName r102 = new EventName(PortraitEngine.LABEL_FIRST_FRAME, 2);
            first_frame = r102;
            EventName r103 = new EventName("playing", 3);
            playing = r103;
            EventName r104 = new EventName("stream_start", 4);
            stream_start = r104;
            EventName r105 = new EventName("stream_sdk_dns_analysis_end", 5);
            stream_sdk_dns_analysis_end = r105;
            EventName r106 = new EventName("stream_prepare_block_end", 6);
            stream_prepare_block_end = r106;
            EventName r107 = new EventName("stream_player_dns_analysis_end", 7);
            stream_player_dns_analysis_end = r107;
            EventName r108 = new EventName("stream_tfo_fall_back_time", 8);
            stream_tfo_fall_back_time = r108;
            EventName r109 = new EventName("stream_tcp_connect_end", 9);
            stream_tcp_connect_end = r109;
            EventName r110 = new EventName("stream_tcp_first_package_end", 10);
            stream_tcp_first_package_end = r110;
            EventName r111 = new EventName("stream_first_video_package_end", 11);
            stream_first_video_package_end = r111;
            EventName r112 = new EventName("stream_first_audio_package_end", 12);
            stream_first_audio_package_end = r112;
            EventName r113 = new EventName("stream_first_video_frame_decode_end", 13);
            stream_first_video_frame_decode_end = r113;
            EventName r114 = new EventName("stream_first_audio_frame_decode_end", 14);
            stream_first_audio_frame_decode_end = r114;
            EventName r115 = new EventName("stream_first_frame_from_player_core", 15);
            stream_first_frame_from_player_core = r115;
            EventName r116 = new EventName("stream_first_frame_render_end", 16);
            stream_first_frame_render_end = r116;
            EventName r117 = new EventName("stream_video_device_open_start", 17);
            stream_video_device_open_start = r117;
            EventName r118 = new EventName("stream_video_device_open_end", 18);
            stream_video_device_open_end = r118;
            EventName r119 = new EventName("stream_audio_device_open_start", 19);
            stream_audio_device_open_start = r119;
            EventName r120 = new EventName("stream_audio_device_open_end", 20);
            stream_audio_device_open_end = r120;
            EventName r121 = new EventName("stream_prepare_end", 21);
            stream_prepare_end = r121;
            EventName r122 = new EventName("stream_set_surface_time", 22);
            stream_set_surface_time = r122;
            EventName r123 = new EventName("stream_video_device_wait_start", 23);
            stream_video_device_wait_start = r123;
            EventName r124 = new EventName("stream_video_device_wait_end", 24);
            stream_video_device_wait_end = r124;
            EventName r125 = new EventName("stream_find_stream_info_start", 25);
            stream_find_stream_info_start = r125;
            EventName r126 = new EventName("stream_find_stream_info_end", 26);
            stream_find_stream_info_end = r126;
            f110378a = new EventName[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126};
        }

        public static EventName valueOf(String r100) {
            return (EventName) a.a(EventName.class, r100);
        }

        public static EventName[] values() {
            return (EventName[]) f110378a.clone();
        }

        public EventName(String r100, int r101) {
            super(r100, r101);
        }
    }

    void a();

    void c(EventName r100);

    void d(JSONObject r100);

    void startTrace();
}
