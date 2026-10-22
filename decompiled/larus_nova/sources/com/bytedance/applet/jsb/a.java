package com.bytedance.applet.jsb;

import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.google.gson.JsonObject;
import com.larus.audioplayer.api.news.UrlAudioPlayStatus;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.o2;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements b88.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f192039a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, JSONObject> f192040b = null;

    /* JADX INFO: renamed from: com.bytedance.applet.jsb.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C2782a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f192041a = null;

        static {
            int[] r100 = new int[UrlAudioPlayStatus.values().length];
            r100[UrlAudioPlayStatus.PLAYING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[UrlAudioPlayStatus.PAUSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[UrlAudioPlayStatus.STOPPED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f192041a = r100;
        }
    }

    public a() {
    }

    static {
        f192039a = new a();
        f192040b = new ConcurrentHashMap();
    }

    @Override // b88.a
    public final void d(String r100, String r101, int r102, UrlAudioPlayStatus r110) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r110, "status");
        int r103 = e.f192051a;
        String r104 = r110.getValue();
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r104, "status");
        AppletEvent$BizEvent r105 = AppletEvent$BizEvent.AUDIO_PLAY_STATUS_CHANGE;
        String r106 = r105.getEventName();
        long r107 = System.currentTimeMillis();
        JSONObject r108 = new JSONObject();
        r108.put("url", r100);
        r108.put("status", r104);
        Unit r109 = Unit.INSTANCE;
        EventCenter.enqueueEvent(new Event(r106, r107, new f66.d(r108)));
        Lazy r111 = l3.d.f507201a;
        String r112 = r105.getEventName();
        JsonObject r113 = new JsonObject();
        r113.addProperty(r100, r100);
        r113.addProperty(r104, r104);
        l3.d.c(new l3.a(r112, r113, 4));
        String r114 = r110.getValue();
        HashSet<AppletRuntime> r115 = AppletRuntime.c.f36736a;
        JavaOnlyMap r116 = new JavaOnlyMap();
        r116.put("url", r100);
        r116.put("status", r114);
        AppletRuntime.c.a("audioPlayStatusChanged", r116);
        ConcurrentHashMap<String, JSONObject> r117 = f192040b;
        JSONObject r118 = r117.get(r100);
        if (r118 == null) goto L30;
        monitor-enter(r118);
        int r119 = C2782a.f192041a[r110.ordinal()];     // Catch: Throwable -> L26
        if (r119 != 1) goto L9;
        long r120 = System.currentTimeMillis();     // Catch: Throwable -> L26
        r118.remove(ILoadStallMonitor.START_TIME);     // Catch: Throwable -> L26
        o2.b(r118);     // Catch: Throwable -> L26
        r118.put(ILoadStallMonitor.START_TIME, r120);     // Catch: Throwable -> L26
    L24:
        monitor-exit(r118);
        return;
    L9:
        if (r119 == 2) goto L19;
        if (r119 != 3) goto L24;
        r117.remove(r100);     // Catch: Throwable -> L26
        if (r118.has(ILoadStallMonitor.START_TIME) == true) goto L17;
        monitor-exit(r118);
        return;
    L17:
        long r121 = r118.optLong(ILoadStallMonitor.START_TIME, 0);     // Catch: Throwable -> L26
        r118.remove(ILoadStallMonitor.START_TIME);     // Catch: Throwable -> L26
        o2.a(Long.valueOf(System.currentTimeMillis() - r121), r118);     // Catch: Throwable -> L26
        r118.remove("duration");     // Catch: Throwable -> L26
        goto L24
    L19:
        if (r118.has(ILoadStallMonitor.START_TIME) == true) goto L22;
        monitor-exit(r118);
        return;
    L22:
        long r122 = r118.optLong(ILoadStallMonitor.START_TIME, 0);     // Catch: Throwable -> L26
        r118.remove(ILoadStallMonitor.START_TIME);     // Catch: Throwable -> L26
        o2.a(Long.valueOf(System.currentTimeMillis() - r122), r118);     // Catch: Throwable -> L26
        r118.remove("duration");     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }
}
