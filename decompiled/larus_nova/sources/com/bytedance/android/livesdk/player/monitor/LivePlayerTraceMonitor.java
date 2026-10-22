package com.bytedance.android.livesdk.player.monitor;

import com.bytedance.android.livesdk.player.LivePlayerClient;
import com.bytedance.android.livesdk.player.LivePlayerService;
import com.bytedance.android.livesdkapi.host.ILivePlayerHostService;
import com.bytedance.android.livesdkapi.log.ILivePlayerTraceMonitor;
import com.bytedance.android.livesdkapi.model.PlayerTraceLogData;
import com.bytedance.android.livesdkapi.model.PlayerTraceMonitorConfig;
import com.bytedance.android.livesdkapi.player.LivePlayerEventListenerAdapter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class LivePlayerTraceMonitor extends LivePlayerEventListenerAdapter implements ILivePlayerTraceMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PlayerTraceMonitorConfig f155703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f155704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f155705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, StringBuilder> f155706d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LivePlayerTraceMonitor$startPullObserver$1 f155707e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LivePlayerTraceMonitor$stopObserver$1 f155708f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LivePlayerTraceMonitor$releaseObserver$1 f155709g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LivePlayerClient f155710h;

    @Override // com.bytedance.android.livesdkapi.player.LivePlayerEventListenerAdapter, com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void onRelease() {
        this.f155709g.a(Boolean.TRUE);
    }

    @Override // com.bytedance.android.livesdkapi.player.LivePlayerEventListenerAdapter, com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void onStartPul() {
        this.f155707e.a(Boolean.TRUE);
    }

    @Override // com.bytedance.android.livesdkapi.player.LivePlayerEventListenerAdapter, com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void onStop() {
        this.f155708f.a(Boolean.TRUE);
    }

    public LivePlayerTraceMonitor(LivePlayerClient r100) {
        Intrinsics.checkNotNullParameter(r100, "client");
        this.f155710h = r100;
        this.f155703a = (PlayerTraceMonitorConfig) LivePlayerService.INSTANCE.getConfig(PlayerTraceMonitorConfig.class);
        this.f155706d = new ConcurrentHashMap();
        this.f155707e = new LivePlayerTraceMonitor$startPullObserver$1(this);
        this.f155708f = new LivePlayerTraceMonitor$stopObserver$1(this);
        this.f155709g = new LivePlayerTraceMonitor$releaseObserver$1(this);
    }

    @Override // com.bytedance.android.livesdkapi.log.ILivePlayerTraceMonitor
    public final void insertPlayEndParamToEvent(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Iterator<Map.Entry<String, StringBuilder>> r101 = this.f155706d.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<String, StringBuilder> r102 = r101.next();
        r100.put(r102.getKey(), r102.getValue().toString());
        goto L4
    }

    @Override // com.bytedance.android.livesdkapi.log.ILivePlayerTraceMonitor
    public final void injectPlayEndParam(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        if (r102 == false) goto L8;
        StringBuilder r103 = this.f155706d.get(r100);
        if (r103 != null) goto L7;
        r103 = new StringBuilder();
    L7:
        r103.append(r101);
    L9:
        this.f155706d.put(r100, r103);
        return;
    L8:
        r103 = new StringBuilder(r101);
        goto L9
    }

    @Override // com.bytedance.android.livesdkapi.log.ILivePlayerTraceMonitor
    public final void reportTrace(String r100, JSONObject r101, Map<String, ? extends Object> r110) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        LivePlayerClient r102 = this.f155710h;
        if ((!Intrinsics.areEqual(String.valueOf(r102.hashCode()), r102.getIdentifier())) == false) goto L5;
        String r103 = r102.getIdentifier();
    L6:
        String r104 = r103;
        JSONObject r105 = new JSONObject();
        f r106 = this.f155710h.getLivePlayerLogger$live_player_impl_saasRelease();
        if (r106 == null) goto L14;
        g r107 = r106.f155847f;
        if (r107 == null) goto L14;
        Iterator<Map.Entry<String, String>> r108 = r107.assembleFullParams().entrySet().iterator();
    L12:
        if (r108.hasNext() == false) goto L14;
        Map.Entry<String, String> r109 = r108.next();
        r105.put(r109.getKey(), r109.getValue());
    L14:
        if (r101 == null) goto L21;
        Iterator<String> r111 = r101.keys();
        if (r111 == null) goto L21;
    L18:
        if (r111.hasNext() == false) goto L21;
        String r112 = r111.next();
        r105.put(r112, r101.opt(r112));
    L21:
        if (Intrinsics.areEqual(r100, "ttlive_live_player_play_end") == false) goto L23;
    L24:
        f r113 = this.f155710h.getLivePlayerLogger$live_player_impl_saasRelease();
        if (r113 == null) goto L29;
        g r114 = r113.f155847f;
        if (r114 == null) goto L29;
        Map<String, String> r115 = r114.assembleLivePlayerParams();
    L30:
        if (r115 == null) goto L37;
        Set<String> r116 = r115.keySet();
        if (r116 == null) goto L37;
        Iterator<T> r117 = r116.iterator();
    L35:
        if (r117.hasNext() == false) goto L37;
        String r118 = (String) r117.next();
        r105.put(r118, r115.get(r118));
    L37:
        f r119 = this.f155710h.getLivePlayerLogger$live_player_impl_saasRelease();
        if (r119 == null) goto L42;
        g r120 = r119.f155847f;
        if (r120 == null) goto L42;
        HashMap<String, String> r121 = r120.assembleTimeCostParams(this.f155710h.getEventController().f154953c);
    L43:
        if (r121 == null) goto L50;
        Set<String> r122 = r121.keySet();
        if (r122 == null) goto L50;
        Iterator<T> r123 = r122.iterator();
    L48:
        if (r123.hasNext() == false) goto L50;
        String r124 = (String) r123.next();
        r105.put(r124, r121.get(r124));
    L50:
        insertPlayEndParamToEvent(r105);
    L51:
        f r125 = this.f155710h.getLivePlayerLogger$live_player_impl_saasRelease();
        if (r125 == null) goto L56;
        g r126 = r125.f155847f;
        if (r126 == null) goto L56;
        Map<String, Object> r127 = r126.assembleTraceIndexes();
    L57:
        if (r110 == null) goto L60;
        if (r127 == null) goto L60;
        r127.putAll(r110);
    L60:
        PlayerTraceLogData r128 = new PlayerTraceLogData(r100, "ttliveplayer_trace_report", r104, r127, r105);
        ILivePlayerHostService r129 = LivePlayerService.INSTANCE.hostService();
        if (r129 == null) goto L68;
        r129.traceLog(r128);
        return;
    L68:
        return;
    L56:
        r127 = null;
    L42:
        r121 = null;
    L29:
        r115 = null;
        goto L30
    L23:
        if (Intrinsics.areEqual(r100, "ttlive_live_player_exception") == false) goto L51;
    L5:
        r103 = "";
        goto L6
    }
}
