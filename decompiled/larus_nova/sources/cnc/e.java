package cnc;

import android.text.TextUtils;
import com.bytedance.android.live.wallet.model.OrderParamsKey;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import com.ss.videoarch.liveplayer.VeLivePlayerDef$VeLivePlayerFormat;
import com.ss.videoarch.liveplayer.VeLivePlayerDef$VeLivePlayerStreamType;
import com.ss.videoarch.liveplayer.i0;
import com.ss.videoarch.liveplayer.w;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class e {
    public e() {
    }

    public static final URL build(String r100) {
        return new URL(r100);
    L4:
        e = move-exception;
        com.ss.videoarch.liveplayer.log.c.d("URLBuilder", e.toString());
        return null;
    }

    public static JSONObject buildStreamDataJson(i0 r210, w r211) {
        JSONObject r100 = new JSONObject();
        JSONObject r101 = new JSONObject();     // Catch: JSONException -> L87
        ArrayList r102 = new ArrayList();     // Catch: JSONException -> L87
        ArrayList r103 = new ArrayList();     // Catch: JSONException -> L87
        r210.getClass();     // Catch: JSONException -> L87
        HashMap r104 = new HashMap();     // Catch: JSONException -> L87
        if (r103.size() <= 0) goto L81;
        Iterator r105 = r103.iterator();     // Catch: JSONException -> L87
    L7:
        if (r105.hasNext() == false) goto L81;
        i0.a r106 = (i0.a) r105.next();     // Catch: JSONException -> L87
        String r107 = c.convertResolutionStr(r106.f458857a);     // Catch: JSONException -> L87
        if (TextUtils.isEmpty(r107) == true) goto L80;
        r102.add(r107);     // Catch: JSONException -> L87
        String r110 = c.convertFormatStr(r106.f458858b);     // Catch: JSONException -> L87
        if (TextUtils.isEmpty(null) == true) goto L80;
        if (TextUtils.isEmpty(r110) == true) goto L80;
        if (r104.isEmpty() == false) goto L18;
    L27:
        JSONObject r111 = null;
        JSONObject r112 = null;
    L28:
        if (r111 != null) goto L30;
        r111 = new JSONObject();     // Catch: JSONException -> L87
    L30:
        VeLivePlayerDef$VeLivePlayerFormat r113 = r106.f458858b;     // Catch: JSONException -> L87
        VeLivePlayerDef$VeLivePlayerFormat r108 = VeLivePlayerDef$VeLivePlayerFormat.VeLivePlayerFormatRTM;     // Catch: JSONException -> L87
        if (r113.equals(r108) == true) goto L34;
        r111.put(r110, null);     // Catch: JSONException -> L87
    L36:
        JSONObject r114 = new JSONObject();     // Catch: JSONException -> L87
        r114.put(GearStrategyConsts.EV_VIDEO_BITRATE, 0);     // Catch: JSONException -> L87
        String r115 = c.convertFormatStr(r210.f458855b);     // Catch: JSONException -> L87
        if (r210.f458855b.equals(r108) == false) goto L56;
        r114.put("SuggestFormat", "lls");     // Catch: JSONException -> L87
        String r109 = tmc.b.getLLSConfig(0);     // Catch: JSONException -> L87
        if (TextUtils.isEmpty(r109) == false) goto L42;
        r109 = "{\n            \"DisableRtmStat\": 1,\n            \"EnableCustomLog\": 1,\n            \"EnableDtls\": false,\n            \"EnablePreload\": 0,\n            \"EnableRTCOes\": 1,\n            \"EnableRtsOffScreen\": 1,\n            \"EnableRtsSDK\": 5,\n            \"EnableSDKDns\": 1,\n            \"EnableMiniSdp\":1,\n            \"EngineParams\": {\n                \"engine_ANM\": {\n                    \"jitterbuffer\": {\n                        \"buffer_level_range\": 6,\n                        \"enable_adapt_scale\": true,\n                        \"enable_target_level_unit_ms\": true,\n                        \"force_play_threshold_ms\": 1000,\n                        \"histogram\": {\n                            \"enable_quick_respond_histogram\": true,\n                            \"max_history_ms\": 1000,\n                            \"quick_respond_histogram_version\": 1\n                        },\n                        \"jb_min_delay_ms\": 300,\n                        \"max_span_delay_ms\": 1000,\n                        \"maxdelay\": 1000,\n                        \"maxpacket\": 500,\n                        \"peak_detector\": {\n                            \"enable_multi_check_peak\": true,\n                            \"peak_max_peak_height_ms_level0\": 1000,\n                            \"peak_max_peak_height_ms_level1\": 160,\n                            \"peak_max_peak_height_ms_level2\": 100,\n                            \"peak_max_peak_hold_ms_level0\": 4000,\n                            \"peak_max_peak_hold_ms_level1\": 6000,\n                            \"peak_max_peak_hold_ms_level2\": 10000,\n                            \"peak_min_peak_hold_ms_level0\": 2000,\n                            \"peak_min_peak_hold_ms_level1\": 2600,\n                            \"peak_min_peak_hold_ms_level2\": 5000\n                        },\n                        \"plc\": {\n                            \"max_plc_fb_consecutive_num\": 3,\n                            \"plc_hold_ms\": 15000\n                        }\n                    }\n                },\n                \"engine_Log\": {\n                    \"adm_level\": \"info\",\n                    \"default_level\": \"info\",\n                    \"enable_logging_into_file\": false\n                },\n                \"engine_Performance\": {\n                    \"stats\": {\n                        \"on\": false\n                    }\n                },\n                \"engine_VNM\": {\n                    \"jitterbuffer\": {\n                        \"avsync\": {\n                            \"enable_smooth_sync\": true,\n                            \"enable_sr_sync_monitor\": true,\n                            \"enable_sync_monitor\": false,\n                            \"quick_av_sync_filter_num\": 30,\n                            \"quick_av_sync_interval\": 100,\n                            \"quick_av_sync_mode\": true\n                        },\n                        \"congestion\": {\n                            \"enable_drop_frames\": false\n                        },\n                        \"delay_render\": {\n                            \"enable_delayed_frames_render\": true\n                        },\n                        \"enable_update_jitter_no_dec_frame\": true,\n                        \"enable_video_del_nack_list_on_dec\": true,\n                        \"jb_history_max_ms\": 300,\n                        \"low_delay\": {\n                            \"enable_low_delay_jitter_mode\": true,\n                            \"limit_extrapolate_localtime_ms\": 50,\n                            \"low_delay_adaptive_max_ms\": 800,\n                            \"low_delay_adaptive_min_ms\": 300,\n                            \"low_delay_noise_std_devs\": 3.13,\n                            \"low_jitter_update_interval_ms\": 120,\n                            \"max_jitter_by_frame_bps_var_ms\": 25,\n                            \"stall_count_timeout_ms\": 25000\n                        },\n                        \"min_target_delay\": 600,\n                        \"packet_buffer_max_size\": 16384,\n                        \"smooth_render\": {\n                            \"max_smooth_delay\": 1000,\n                            \"stall_threshold\": 200\n                        },\n                        \"video_jb_mode\": 2,\n                        \"video_stall_threshold\": 200\n                    },\n                    \"use_old_configure\": false\n                },\n                \"engine_VPM\": {\n                    \"enable_bframe_decode\": true\n                },\n                \"engine_firstFrame\": {\n                    \"force_to_send_last_packet_enabled\": true,\n                    \"fps_limit_seconds\": 1,\n                    \"store_packet_enabled\": true\n                },\n                \"engine_videocodec\": {\n                    \"bytevc1\": {\n                        \"hw_dec\": {\n                            \"enable\": true\n                        }\n                    },\n                    \"hw_decode_smooth_output\": false,\n                    \"specl_cfg\": {\n                        \"dec_slow_send_strategy\": {\n                            \"max_allowed_cache_frames\": 0\n                        }\n                    }\n                },\n                \"targetCodec\": \"ByteVC1\"\n            },\n            \"FallbackThreshold\":5000,\n            \"MaxRetryCount\":20,\n            \"PlayingLogInterval\":2000,\n            \"RtcProfileParameter\": {\n                \"alog_has_rts\": 1,\n                \"audio_pre_threshold\": 3000,\n                \"audio_to_sleep_threshold\": 0,\n                \"auido_frames_max_in_cache\": 0,\n                \"decoder_frames_limit\": 20,\n                \"decoder_frames_limit_adjust\": 0,\n                \"enable_audio_pts_adjust\": 1,\n                \"enable_codec_ready_msg_simu\": 0,\n                \"enable_memory_pool\": 1,\n                \"enable_parse_mediainfo_from_sdp\": 1,\n                \"enable_rts_log_to_alog\": 1,\n                \"enable_rts_render_avsync\": 1,\n                \"enable_skip_sei_in_key_frame\": 1,\n                \"enable_sync_buffer_timestamp_adjust\": 1,\n                \"enable_video_refresh_drop\": 0,\n                \"enable_video_resolution_change\": 0,\n                \"firstframe_timeout\": 1000,\n                \"fix_log_crash\": 1,\n                \"looper_sync_to_async_for_rts\": 1,\n                \"max_expand_change_scale\": 30,\n                \"max_render_series_ms\": 3000,\n                \"max_shrink_change_scale\": 20,\n                \"mini_sdp_port\":8000,\n                \"minisdp_version\": 1,\n                \"offer_have_aac_config\": 0,\n                \"rtm_switch\": 4225,\n                \"rtsplay_udp_start_timeout\": 1000,\n                \"sync_version\": 2,\n                \"use_fast_offer\": 0,\n                \"use_fdk_aac\": 1,\n                \"use_pre_codec\": 1,\n                \"video_pre_threshold\": 3000,\n                \"pc_bundle_policy\":0\n            },\n            \"RtsOn32BitOff\": 1\n        }";
    L42:
        JSONObject r116 = new JSONObject(r109);     // Catch: JSONException -> L87
        if (r211 == null) goto L55;
        boolean r117 = r211.f459659b;     // Catch: JSONException -> L87
        if (r117 == false) goto L49;
        int r118 = r211.f459660c;     // Catch: JSONException -> L87
        if (r118 == 5000) goto L55;
        if (r118 <= 0) goto L55;
    L49:
        if (r117 == true) goto L51;
        JSONObject r119 = r116.optJSONObject("EngineParams");     // Catch: JSONException -> L87
        r119.put("engine_videocodec", new JSONObject("{\"bytevc1\": {\"hw_dec\": {\"enable\": false}},\"h264\": {\"hw_dec\": {\"enable\": false}}}"));     // Catch: JSONException -> L87
        r116.put("EngineParams", r119);     // Catch: JSONException -> L87
    L51:
        int r120 = r211.f459660c;     // Catch: JSONException -> L87
        if (r120 == 5000) goto L55;
        if (r120 <= 0) goto L55;
        r116.put("FallbackThreshold", r120);     // Catch: JSONException -> L87
        r116.optJSONObject("RtcProfileParameter").put("firstframe_timeout", r211.f459660c);     // Catch: JSONException -> L87
    L55:
        r114.put("LLSConfig", r116);     // Catch: JSONException -> L87
    L57:
        String r121 = c.convertProtocolStr(r210.f458856c);     // Catch: JSONException -> L87
        if (TextUtils.isEmpty(r121) == true) goto L66;
        r114.put("SuggestProtocol", r121);     // Catch: JSONException -> L87
        if (r121.equals("quic") == false) goto L66;
        JSONObject r122 = tmc.b.getQuicConfig(0);     // Catch: JSONException -> L87
        if (r122 != null) goto L64;
        r114.put("EnableSaveSCFG", 1);     // Catch: JSONException -> L87
        r114.put("ProtocolDowngrade", 1);     // Catch: JSONException -> L87
        r114.put("QuicVersion", 43);     // Catch: JSONException -> L87
        goto L66
    L64:
        tmc.b.mergeJSONObject(r122, r114);     // Catch: JSONException -> L87
    L66:
        if (tmc.b.enableAbr(0) == false) goto L68;
        tmc.b.mergeJSONObject(tmc.b.getAbrMethodConfig(0), r114);     // Catch: JSONException -> L87
    L68:
        JSONObject r123 = tmc.b.generateNetAdapt(0);     // Catch: JSONException -> L87
        if (r123 == null) goto L71;
        tmc.b.mergeJSONObject(r123, r114);     // Catch: JSONException -> L87
    L71:
        r111.put(OrderParamsKey.KEY_SDK_PARAM, r114);     // Catch: JSONException -> L87
        if (r112 != null) goto L75;
        r112 = new JSONObject();     // Catch: JSONException -> L87
    L75:
        if (r106.f458859c != VeLivePlayerDef$VeLivePlayerStreamType.VeLivePlayerStreamTypeMain) goto L77;
        String r124 = PullConfiguration.PROCESS_NAME_MAIN;
    L78:
        r112.put(r124, r111);     // Catch: JSONException -> L87
        r104.put(r107, r112);     // Catch: JSONException -> L87
        goto L80
    L77:
        r124 = "backup";
        goto L78
    L56:
        r114.put("SuggestFormat", r115);     // Catch: JSONException -> L87
        goto L57
    L34:
        r111.put("lls", null);     // Catch: JSONException -> L87
        goto L36
    L18:
        if (r104.get(r107) == null) goto L27;
        r112 = (JSONObject) r104.get(r107);     // Catch: JSONException -> L87
        if (r112 != null) goto L22;
        r111 = null;
        goto L28
    L22:
        if (r106.f458859c != VeLivePlayerDef$VeLivePlayerStreamType.VeLivePlayerStreamTypeMain) goto L24;
        String r125 = PullConfiguration.PROCESS_NAME_MAIN;
    L25:
        r111 = r112.optJSONObject(r125);     // Catch: JSONException -> L87
        goto L28
    L24:
        r125 = "backup";
    L80:
        r102 = r102;
        r105 = r105;
    L81:
        Iterator r126 = r104.entrySet().iterator();     // Catch: JSONException -> L87
    L83:
        if (r126.hasNext() == false) goto L85;
        Map.Entry r127 = (Map.Entry) r126.next();     // Catch: JSONException -> L87
        r101.put((String) r127.getKey(), r127.getValue());     // Catch: JSONException -> L87
        goto L83
    L85:
        r100.put("data", r101);     // Catch: JSONException -> L87
    L89:
        return r100;
    L87:
        e = move-exception;
        e.printStackTrace();
        goto L89
    }
}
