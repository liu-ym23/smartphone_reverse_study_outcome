package com.bytedance.applet.event;

import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.google.gson.JsonObject;
import com.larus.audioplayer.api.music.MusicPlayManagerDelegate;
import com.larus.audioplayer.api.stream.AudioStreamPlayerDelegate;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.audio.ObricTtsControlDelegate;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class u implements z2a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f191827a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Boolean> f191828b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Boolean> f191829c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, Boolean> f191830d = null;

    public u() {
    }

    static {
        f191827a = new u();
        f191828b = new ConcurrentHashMap();
        f191829c = new ConcurrentHashMap();
        f191830d = new ConcurrentHashMap();
    }

    public static void a(String r100, int r101) {
        long r102 = System.currentTimeMillis();
        JSONObject r103 = new JSONObject();
        r103.put("botId", r100);
        r103.put("state", r101);
        Unit r104 = Unit.INSTANCE;
        EventCenter.enqueueEvent(new Event("realtimeCallStateChanged", r102, new f66.d(new JSONObject(MapsKt.mapOf(TuplesKt.to("data", r103))))));
        Lazy r105 = l3.d.f507201a;
        JsonObject r106 = new JsonObject();
        r106.addProperty("botId", r100);
        r106.addProperty("state", Integer.valueOf(r101));
        l3.d.c(new l3.a("realtimeCallStateChanged", r106, 4));
    }

    @Override // z2a.b
    public final void onEnterRealtimeCall(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "botId");
        Intrinsics.checkNotNullParameter(r111, "conversationId");
        boolean r100 = false;
        if (z2.f365865a.realtimeCallAllSceneMixEnable() == true) goto L45;
    L11:
        boolean r101 = false;
    L13:
        if (r101 == false) goto L16;
        ((ConcurrentHashMap) f191830d).put(r110, Boolean.TRUE);
        FLogger.f375446a.i("RealtimeCallStateObserver", "onEnterRealtimeCall suppress event for call mix. botId=" + r110);
    L43:
        Map<String, Boolean> r102 = f191828b;
        Boolean r103 = Boolean.TRUE;
        ((ConcurrentHashMap) r102).put(r110, r103);
        ((ConcurrentHashMap) f191829c).put(r111, r103);
        return;
    L16:
        if (ObricTtsControlDelegate.f392839b.e() == false) goto L42;
        boolean r104 = z2.f365865a.realtimeCallAllSceneMixEnable();
        a88.e r105 = MusicPlayManagerDelegate.f290176b.a();     // Catch: Exception -> L20
    L49:
        c88.a r106 = AudioStreamPlayerDelegate.f290191b.f();     // Catch: Exception -> L24
    L26:
        FLogger r107 = FLogger.f375446a;
        StringBuilder r108 = new StringBuilder("onEnterRealtimeCall botId=");
        r108.append(r110);
        r108.append(", mixEnable=");
        r108.append(r104);
        r108.append(", hasMusic=");
        if (r105 == null) goto L29;
        boolean r109 = true;
    L30:
        r108.append(r109);
        r108.append(", hasStream=");
        if (r106 == null) goto L33;
        r100 = true;
    L33:
        r108.append(r100);
        r107.i("RealtimeCallStateObserver", r108.toString());
        if (r105 != null) goto L47;
    L38:
        if (r106 == null) goto L42;
        AudioStreamPlayerDelegate.f290191b.a(null, "realtime_call_enter");     // Catch: Exception -> L36
        r107.i("RealtimeCallStateObserver", "stopInAppMediaIfNeeded stopStream");     // Catch: Exception -> L36
    L36:
        e = move-exception;
        FLogger.f375446a.e("RealtimeCallStateObserver", "stopInAppMediaIfNeeded error", e);
        goto L42
    L47:
        r107.i("RealtimeCallStateObserver", "stopInAppMediaIfNeeded stopMusic musicId=" + r105.f2189a + ", result=" + MusicPlayManagerDelegate.f290176b.c(r105.f2189a));     // Catch: Exception -> L36
        goto L38
    L29:
        r109 = false;
    L24:
        e = move-exception;
        FLogger.f375446a.e("RealtimeCallStateObserver", "onEnterRealtimeCall getCurrentAudioSteamData error", e);
        r106 = null;
    L20:
        e = move-exception;
        FLogger.f375446a.e("RealtimeCallStateObserver", "onEnterRealtimeCall getCurrentMusic error", e);
        r105 = null;
    L42:
        a(r110, 1);
        goto L43
    L45:
        if (MusicPlayManagerDelegate.f290176b.a() != null) goto L9;
        if (AudioStreamPlayerDelegate.f290191b.f() == null) goto L11;
    L9:
        r101 = true;
        goto L13
    }

    @Override // z2a.b
    public final void onExitRealtimeCall(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        if (((ConcurrentHashMap) f191830d).remove(r100) == null) goto L5;
        FLogger.f375446a.i("RealtimeCallStateObserver", "onExitRealtimeCall suppress event for call mix. botId=" + r100);
    L6:
        ((ConcurrentHashMap) f191828b).remove(r100);
        ((ConcurrentHashMap) f191829c).remove(r101);
        return;
    L5:
        a(r100, 0);
        goto L6
    }
}
