package com.bytedance.applet.aibridge;

import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ixigua.lib.track.TrackParams;
import com.larus.audioplayer.api.music.MusicPlayManagerDelegate;
import com.larus.audioplayer.api.utils.MusicActionUtilDelegate;
import com.larus.trace.TriggeredAudioActionEnum;
import com.lynx.canvas.KryptonCamera;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class i implements a88.c, a88.b, a88.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f191168a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f191169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f191170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<String, JSONObject> f191171d = null;

    public i() {
    }

    static {
        i r100 = new i();
        f191168a = r100;
        f191170c = "stopped";
        f191171d = new ConcurrentHashMap();
        MusicPlayManagerDelegate r101 = MusicPlayManagerDelegate.f290176b;
        r101.l();
        r101.k(r100);
        MusicActionUtilDelegate.f290198b.a(r100);
    }

    @Override // a88.c
    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "musicId");
        f191169b = r100;
        f191170c = "prepare";
        m(r100, "prepare");
    }

    @Override // a88.b
    public final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "musicId");
        l(r100, 0, null);
    }

    @Override // a88.c
    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "musicId");
        f191169b = r100;
        m(r100, VideoEventOneOutSync.END_TYPE_FINISH);
    }

    @Override // a88.c
    public final void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "musicId");
        f191169b = r100;
        f191170c = "error";
        m(r100, "error");
    }

    public final String j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "originalResolution");
        switch(r100.hashCode()) {
            case 2249154: goto L18;
            case 68069317: goto L14;
            case 1377272541: goto L10;
            case 1670753181: goto L6;
            default: goto L21;
        };
    L21:
        return null;
    L6:
        if (r100.equals("SuperHigh") == false) goto L21;
        return "highest";
    L10:
        if (r100.equals("Standard") == false) goto L21;
        return KryptonCamera.Config.RESOLUTION_MEDIUM;
    L14:
        if (r100.equals("FourK") == false) goto L21;
        return "lossless";
    L18:
        if (r100.equals("High") == false) goto L21;
        return "higher";
    }

    public final String k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "mappedResolution");
        switch(r100.hashCode()) {
            case -1919475908: goto L18;
            case -1217394225: goto L14;
            case -1078030475: goto L10;
            case 915484836: goto L6;
            default: goto L21;
        };
    L21:
        return "Undefine";
    L6:
        if (r100.equals("highest") == false) goto L21;
        return "SuperHigh";
    L10:
        if (r100.equals(KryptonCamera.Config.RESOLUTION_MEDIUM) == false) goto L21;
        return "Standard";
    L14:
        if (r100.equals("higher") == false) goto L21;
        return "High";
    L18:
        if (r100.equals("lossless") == false) goto L21;
        return "FourK";
    }

    @Override // a88.c
    public final void onError(String r100) {
        Intrinsics.checkNotNullParameter(r100, "musicId");
        f191169b = r100;
        f191170c = "error";
        m(r100, "error");
    }

    public static void m(String r100, String r101) {
        if (Intrinsics.areEqual(r101, "playing") == false) goto L17;
        ConcurrentHashMap<String, Pair<String, String>> r102 = a.f190879d;
        if (r102.size() == 0) goto L17;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L15
        HashMap r104 = new HashMap(r102);     // Catch: Throwable -> L15
        r102.clear();     // Catch: Throwable -> L15
        Iterator r105 = r104.entrySet().iterator();     // Catch: Throwable -> L15
    L9:
        if (r105.hasNext() == false) goto L13;
        Map.Entry r106 = (Map.Entry) r105.next();     // Catch: Throwable -> L15
        String r107 = (String) r106.getKey();     // Catch: Throwable -> L15
        String r108 = (String) ((Pair) r106.getValue()).getFirst();     // Catch: Throwable -> L15
        String r109 = (String) ((Pair) r106.getValue()).getSecond();     // Catch: Throwable -> L15
        AppletRuntimeManager.INSTANCE.getClass();     // Catch: Throwable -> L15
        AppletRuntime r110 = AppletRuntimeManager.i(r107, null, r108);     // Catch: Throwable -> L15
        if (r110 == null) goto L9;
        Intrinsics.checkNotNull(r107);     // Catch: Throwable -> L15
        r110.t(r107, r109);     // Catch: Throwable -> L15
        goto L9
    L13:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L17:
        String r112 = MusicPlayManagerDelegate.f290176b.h(r100);
        Lazy r113 = l3.d.f507201a;
        JsonObject r114 = new JsonObject();
        r114.addProperty("musicId", r100);
        r114.addProperty("status", r101);
        if (r112 == null) goto L20;
        r114.addProperty("pausedReason", r112);
    L20:
        Unit r115 = Unit.INSTANCE;
        l3.d.c(new l3.a("applet.musicPlayStatusChanged", r114, 4));
    }

    @Override // a88.b
    public final void b(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "musicId");
        JsonObject r102 = new JsonObject();
        r102.addProperty("enterMethod", "system_button");
        Unit r103 = Unit.INSTANCE;
        l(r100, r101, r102);
    }

    @Override // a88.c
    public final void g(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "musicId");
        if (r101 == 0) goto L28;
        String r102 = "unknown";
        if (r101 != 1) goto L7;
        ConcurrentHashMap<String, JSONObject> r103 = f191171d;
        JSONObject r104 = r103.get(r100);
        if (r104 != null) goto L13;
    L27:
        r102 = "playing";
    L29:
        f191169b = r100;
        f191170c = r102;
        com.bytedance.applet.task.b.f192232a.getClass();
        com.bytedance.applet.task.b.c(r101);
        m(r100, r102);
        return;
    L13:
        if (Intrinsics.areEqual(MusicPlayManagerDelegate.f290176b.b(r100), "default") == false) goto L27;
        TriggeredAudioActionEnum r105 = TriggeredAudioActionEnum.PLAY_START;
        Long r106 = Long.valueOf(System.currentTimeMillis());
        Intrinsics.checkNotNullParameter(r104, "params");
        if (r104.has("scene") == true) goto L19;
        r104.put("scene", "unknown");
    L19:
        if (r105 == null) goto L22;
        r104.put("action", r105.getValue());
    L24:
        if (r106 == null) goto L26;
        r104.put("trigger_time", r106.longValue());
    L26:
        TrackParams r107 = new TrackParams().merge(r104);
        by7.a r108 = new by7.a("audio_action_triggered");
        r108.f21463a.merge(r107);
        r108.b();
        r103.remove(r100);
        goto L27
    L22:
        if (r104.has("action") == true) goto L24;
        r104.put("action", "unknown");
        goto L24
    L7:
        if (r101 != 2) goto L29;
        r102 = "paused";
        goto L29
    L28:
        r102 = "stopped";
        goto L29
    }

    @Override // a88.c
    public final void i(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "musicId");
        f191169b = r100;
        if (r101 != 3) goto L6;
        f191170c = "error";
        m(r100, "error");
        return;
    }

    public static void l(String r100, int r101, JsonObject r102) {
        Intrinsics.checkNotNullParameter(r100, "musicId");
        Lazy r103 = l3.d.f507201a;
        JsonObject r104 = new JsonObject();
        r104.addProperty("musicId", r100);
        r104.addProperty(ReportConstant.COMMON_ACTION_TYPE, Integer.valueOf(r101));
        if (r102 == null) goto L10;
        Set<Map.Entry<String, JsonElement>> r105 = r102.entrySet();
        if (r105 == null) goto L10;
        Iterator<T> r106 = r105.iterator();
    L8:
        if (r106.hasNext() == false) goto L10;
        Map.Entry r107 = (Map.Entry) r106.next();
        r104.add((String) r107.getKey(), (JsonElement) r107.getValue());
    L10:
        Unit r108 = Unit.INSTANCE;
        l3.d.c(new l3.a("applet.musicActionTriggered", r104, 4));
    }

    @Override // a88.b
    public final void a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "musicId");
        Intrinsics.checkNotNullParameter(r101, "fromProgress");
        Intrinsics.checkNotNullParameter(r102, "toProgress");
        JsonObject r103 = new JsonObject();
        r103.addProperty("enterMethod", "system_button");
        r103.addProperty("musicPrevProgress", r101);
        r103.addProperty("musicProgress", r102);
        Unit r104 = Unit.INSTANCE;
        l(r100, 3, r103);
    }

    @Override // a88.a
    public final void c(String r100, int r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "musicId");
        Lazy r103 = l3.d.f507201a;
        JsonObject r104 = new JsonObject();
        r104.addProperty("musicId", r100);
        r104.addProperty(ReportConstant.COMMON_ACTION_TYPE, Integer.valueOf(r101));
        if (r102 == null) goto L10;
        Set<Map.Entry<String, String>> r105 = r102.entrySet();
        if (r105 == null) goto L10;
        Iterator<T> r106 = r105.iterator();
    L8:
        if (r106.hasNext() == false) goto L10;
        Map.Entry r107 = (Map.Entry) r106.next();
        r104.addProperty((String) r107.getKey(), (String) r107.getValue());
    L10:
        Unit r108 = Unit.INSTANCE;
        l3.d.c(new l3.a("applet.doraMusicActionTriggered", r104, 4));
    }
}
