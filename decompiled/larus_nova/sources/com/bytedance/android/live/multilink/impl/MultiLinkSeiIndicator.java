package com.bytedance.android.live.multilink.impl;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.livesdk.config.ub1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.player.ILivePlatformPlayerProxy;
import com.bytedance.android.livesdkapi.model.PlayerFirstFrameInfo;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerClientContext;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ttvideoengine.portrait.PortraitEngine;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class MultiLinkSeiIndicator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ub1 f83312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f83313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f83314c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f83315d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f83316e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f83317f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f83318g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public HashMap<String, String> f83319h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f83320i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f83321j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f83322k;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/multilink/impl/MultiLinkSeiIndicator$Source;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "LINK_END", "LEAVE_ROOM", "SWITCH_RESOLUTION", "multilink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Source extends Enum<Source> {
        public static final Source LEAVE_ROOM = null;
        public static final Source LINK_END = null;
        public static final Source SWITCH_RESOLUTION = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Source[] f83323a = null;
        private final String type;

        static {
            Source r100 = new Source("LINK_END", 0, "link_end");
            LINK_END = r100;
            Source r101 = new Source("LEAVE_ROOM", 1, "leave_room");
            LEAVE_ROOM = r101;
            Source r102 = new Source("SWITCH_RESOLUTION", 2, "switch_resolution");
            SWITCH_RESOLUTION = r102;
            f83323a = new Source[]{r100, r101, r102};
        }

        public static Source valueOf(String r100) {
            return (Source) r27.a.a(Source.class, r100);
        }

        public static Source[] values() {
            return (Source[]) f83323a.clone();
        }

        public final String getType() {
            return this.type;
        }

        public Source(String r100, int r101, String r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    public static final class a {
    }

    static {
    }

    public final HashMap<String, String> a() {
        ILivePlatformPlayerProxy r100 = hs0.a.f486938b.curRoomPlayer();
        if (r100 == null) goto L5;
        ILivePlayerClient r101 = r100.player();
    L6:
        if (r101 != null) goto L8;
        return null;
    L8:
        HashMap<String, String> r102 = new HashMap();
        JSONObject r103 = r101.getStatsLog();
        String r104 = r101.getCurrentResolution();
        if (r103 == null) goto L14;
        r102.put(IPerformanceManager.Stream.stream_cdn_ip, r103.optString("cdn_ip:"));
        r102.put(IPerformanceManager.Stream.stream_cdn_play_url, r103.optString("url:"));
        if (r104 != null) goto L13;
        r104 = r103.optString("resolution:");
    L13:
        r102.put("resolution", r104);
        r102.put("download_speed", r103.optString("download_Speed:"));
        r102.put("domain", r103.optString("domain:"));
        r102.put("play_protocol", r103.optString("play_protocol:"));
        r102.put("play_format", r103.optString("play_format:"));
        r102.put(TTVideoEngineInterface.PLAY_API_KEY_CODEC, r103.optString("Codec_Type:"));
        r102.put("codec_name", r103.optString("Codec_Name:"));
    L14:
        String r105 = r101.getEventHub().getPlayerMediaError().getValue();
        if (r105 != null) goto L17;
    L21:
        Boolean r106 = r101.getEventHub().getPlayPrepared().getValue();
        if (r106 != null) goto L24;
        r106 = Boolean.FALSE;
    L24:
        String r107 = "1";
        if (r106.booleanValue() == false) goto L27;
        String r108 = "1";
    L28:
        r102.put("play_prepared", r108);
        if (r101.isPlaying() == false) goto L31;
        String r109 = "1";
    L32:
        r102.put("is_playing", r109);
        Boolean r110 = r101.getEventHub().getFirstFrame().getValue();
        if (r110 != null) goto L36;
        r110 = Boolean.FALSE;
    L36:
        if (r110.booleanValue() == false) goto L38;
        String r111 = "1";
    L39:
        r102.put(PortraitEngine.LABEL_FIRST_FRAME, r111);
        if (this.f83320i == true) goto L43;
        r107 = "0";
    L43:
        r102.put(LocationMonitorConst.IS_BACKGROUND, r107);
        IRoom r112 = je0.d.e(null);
        if (r112 == null) goto L46;
        r102.put("room_id", String.valueOf(r112.getRoomId()));
    L46:
        r102.put("scene", String.valueOf(je0.d.f()));
        r102.put("ui_layout", String.valueOf(je0.d.h()));
        return r102;
    L38:
        r111 = "0";
        goto L39
    L31:
        r109 = "0";
        goto L32
    L27:
        r108 = "0";
        goto L28
    L17:
        if (StringsKt.isBlank(r105) == true) goto L21;
        JSONObject r113 = new JSONObject(r105);     // Catch: Exception -> L20
        r102.put("pull_stream_error_code", r113.optString("error_code"));     // Catch: Exception -> L20
        r102.put("pull_stream_error_reason", r113.optString("error_description"));     // Catch: Exception -> L20
        goto L21
    L5:
        r101 = null;
        goto L6
    }

    public MultiLinkSeiIndicator() {
        this.f83312a = (ub1) vm2.h.G5.getValue(null, vm2.h.f556082a[343(0x157, float:4.8E-43)]);
        this.f83314c = -1;
        this.f83315d = -1;
        this.f83321j = true;
    }

    public final void c(String r110) {
        Intrinsics.checkNotNullParameter(r110, "seiString");
        if (this.f83312a.b() == true) goto L6;
        return;
    L6:
        if (this.f83318g > 0) goto L8;
        return;
    L8:
        LiveSeiUtil.f71508i.getClass();
        if (LiveSeiUtil.b(r110) == false) goto L53;
        Disposable r100 = this.f83313b;
        if (r100 == null) goto L14;
        r100.dispose();
    L14:
        if (this.f83321j == false) goto L52;
        ILivePlatformPlayerProxy r101 = hs0.a.f486938b.curRoomPlayer();
        PlayerFirstFrameInfo r102 = null;
        if (r101 == null) goto L18;
        ILivePlayerClient r103 = r101.player();
    L19:
        if (r103 == null) goto L23;
        LivePlayerClientContext r104 = r103.context();
        if (r104 == null) goto L23;
        r102 = r104.getFirstFrameInfo();
    L23:
        if (r102 == null) goto L52;
        long r105 = r102.getTs();
        long r106 = System.currentTimeMillis();
        String r107 = r102.getSei();
        if (r107 != null) goto L27;
    L37:
        boolean r108 = true;
    L38:
        long r109 = this.f83322k;
        long r111 = r106 - r109;
        long r112 = r109 - r105;
        HashMap r113 = new HashMap();
        HashMap<String, String> r114 = a();
        if (r114 == null) goto L41;
        r113.putAll(r114);
    L41:
        r113.put("current_mode", String.valueOf(this.f83318g));
        if (r108 == false) goto L44;
        String r115 = "1";
    L45:
        r113.put(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, r115);
        r113.put("biz_to_sei_duration", String.valueOf(r111));
        r113.put("firstsei_to_biz_duration", String.valueOf(r112));
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_multi_link_first_biz_sei", r113, new Object[]{IRoom.class});
        if (this.f83312a.c() == false) goto L52;
        TalkRoomBusinessFullLinkMonitor.f71456a.getClass();
        Intrinsics.checkNotNullParameter(r113, "logMap");
        JSONObject r116 = new JSONObject();
        Iterator r117 = r113.entrySet().iterator();
    L49:
        if (r117.hasNext() == false) goto L51;
        Map.Entry r118 = (Map.Entry) r117.next();
        r116.put((String) r118.getKey(), r118.getValue());
        goto L49
    L51:
        nd0.c.o(nd0.c.f518746a, LinkMonitorData.MultiLinkFirstBizSei, r116, 0, null, true, 12);
        goto L52
    L44:
        r115 = "0";
        goto L45
    L27:
        if (r107.length() <= 0) goto L29;
        boolean r119 = true;
    L30:
        if (r119 != true) goto L37;
        String r120 = r102.getSei();
        if (r120 == null) goto L37;
        if (r120.equals(r110) == true) goto L37;
        r108 = false;
        goto L38
    L29:
        r119 = false;
        goto L30
    L18:
        r103 = null;
    L52:
        this.f83321j = false;
        com.bytedance.android.livesdk.log.b0 r121 = com.bytedance.android.livesdk.log.b0.o();
        String r122 = "onSei mode=" + this.f83318g + ' ' + r110;
        r121.getClass();
        com.bytedance.android.live.core.log.g.i("MultiLinkSeiIndicator", r122);
    L53:
        LiveSeiUtil.f71508i.getClass();
        JSONObject r123 = LiveSeiUtil.c(r110);
        if (r123.has("sei_index") == false) goto L68;
        Integer r124 = StringsKt.toIntOrNull(r123.optString("sei_index"));
        if (r124 == null) goto L69;
        int r125 = r124.intValue();
        if (this.f83314c >= 0) goto L60;
        this.f83314c = r125;
        this.f83315d = r125;
        this.f83319h = a();
        return;
    L60:
        int r126 = this.f83315d;
        if (r125 <= r126) goto L71;
        int r127 = (r125 - r126) - 1;
        if (r127 <= 0) goto L65;
        this.f83317f = r127;
    L65:
        this.f83316e += r127;
        this.f83315d = r125;
        return;
    L71:
        return;
    L69:
        return;
    }

    public final void b(int r100, Source r110) {
        if (this.f83315d > 0) goto L5;
        return;
    L5:
        if (this.f83314c <= 0) goto L31;
        HashMap r101 = new HashMap();
        HashMap<String, String> r102 = this.f83319h;
        if (r102 == null) goto L9;
        r101.putAll(r102);
    L13:
        if (r110 != Source.SWITCH_RESOLUTION) goto L17;
        int r103 = this.f83317f;
        if (r103 <= 0) goto L17;
        this.f83316e -= r103;
        this.f83317f = 0;
    L17:
        r101.put("current_mode", String.valueOf(r100));
        r101.put("source", r110.getType());
        int r104 = this.f83315d - this.f83314c;
        r101.put("expected_sei_count", String.valueOf(r104));
        int r111 = r104 - this.f83316e;
        r101.put("received_sei_count", String.valueOf(r111));
        if (r104 <= 0) goto L20;
        String r105 = String.valueOf((r111 * 1.0f) / r104);
    L21:
        r101.put("arrival_rate", r105);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_multi_link_sei_arrival_rate", r101, new Object[]{IRoom.class});
        if (this.f83312a.c() == false) goto L32;
        TalkRoomBusinessFullLinkMonitor.f71456a.getClass();
        Intrinsics.checkNotNullParameter(r101, "logMap");
        JSONObject r106 = new JSONObject();
        Iterator r107 = r101.entrySet().iterator();
    L25:
        if (r107.hasNext() == false) goto L27;
        Map.Entry r112 = (Map.Entry) r107.next();
        r106.put((String) r112.getKey(), r112.getValue());
        goto L25
    L27:
        nd0.c.o(nd0.c.f518746a, LinkMonitorData.MultiLinkSeiArrivalRate, r106, 0, null, true, 12);
        return;
    L32:
        return;
    L20:
        r105 = "";
        goto L21
    L9:
        HashMap<String, String> r108 = a();
        if (r108 == null) goto L13;
        r101.putAll(r108);
        goto L13
    }
}
