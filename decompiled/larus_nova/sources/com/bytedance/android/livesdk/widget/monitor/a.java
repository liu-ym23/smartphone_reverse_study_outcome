package com.bytedance.android.livesdk.widget.monitor;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.i91;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f161840f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f161841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f161842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f161843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f161844d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f161845e;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.widget.monitor.a$a, reason: collision with other inner class name */
    public static final class C2474a {
    }

    static {
    }

    public a(DataCenter r100) {
        this.f161841a = PThreadExecutorsUtils.newSingleThreadExecutor(new m());
        this.f161842b = "ttlive_logger_widget_lifecycle";
        this.f161843c = "ttlive_logger_widget_load_state";
        this.f161844d = "ttlive_logger_widget_clear_screen";
        LinkedHashMap r101 = new LinkedHashMap();
        if (r100 == null) goto L7;
        Room r102 = (Room) r100.get("data_room", null);
        if (r102 == null) goto L7;
        String r103 = (String) r101.put("room_id", String.valueOf(r102.f162599id));
    L7:
        if (r100 == null) goto L13;
        LiveMode r104 = (LiveMode) r100.get("data_live_mode", LiveMode.VIDEO);
        if (r104 == null) goto L13;
        String r105 = r104.name();
        if (r105 == null) goto L13;
        String r106 = (String) r101.put("live_mode", r105);
    L13:
        if (r100 == null) goto L17;
        Boolean r107 = (Boolean) r100.get("data_is_anchor", Boolean.FALSE);
        if (r107 == null) goto L17;
        String r108 = (String) r101.put(IPerformanceManager.Params.is_anchor, String.valueOf(r107.booleanValue()));
    L17:
        if (r100 == null) goto L22;
        Boolean r109 = (Boolean) r100.get("data_is_portrait", Boolean.TRUE);
        if (r109 == null) goto L22;
        String r110 = (String) r101.put(IPerformanceManager.Params.is_portrait, String.valueOf(r109.booleanValue()));
    L22:
        if (am2.j.a() == null) goto L24;
        r101.put("is_first_start", String.valueOf(am2.j.f4288d));
    L24:
        Unit r111 = Unit.INSTANCE;
        this.f161845e = r101;
    }

    public final void b(String r100, Widget r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        d(this, this.f161842b, r100, r101);
    }

    public final void c(String r100, Widget r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        d(this, this.f161843c, r100, r101);
    }

    public static String a(String r100, String r101, Map r102) {
        JSONObject r103 = new JSONObject();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L17
        if (r102 == null) goto L15;
        Iterator r105 = r102.entrySet().iterator();     // Catch: Throwable -> L17
    L7:
        if (r105.hasNext() == false) goto L15;
        Map.Entry r106 = (Map.Entry) r105.next();     // Catch: Throwable -> L17
        if ((!StringsKt.isBlank((CharSequence) r106.getKey())) == false) goto L7;
        String r107 = (String) r106.getValue();     // Catch: Throwable -> L17
        if (r107 == null) goto L7;
        if ((!StringsKt.isBlank(r107)) != true) goto L7;
        r103.put((String) r106.getKey(), r106.getValue());     // Catch: Throwable -> L17
    L15:
        r103.put("tag", r100);     // Catch: Throwable -> L17
        Result.m9449constructorimpl(r103.put("msg", r101));     // Catch: Throwable -> L17
    L20:
        return r103.toString();
    L17:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    }

    public static void d(a r100, String r101, String r102, Widget r103) {
        r100.getClass();
        LinkedHashMap r104 = new LinkedHashMap();
        LinkedHashMap r105 = new LinkedHashMap();
        if (r103 == null) goto L7;
        String r106 = r103.getWidgetTag();
        if (r106 == null) goto L7;
        String r107 = (String) r105.put("widget_name", r106);
    L7:
        if (r103 == null) goto L9;
        String r108 = (String) r105.put("has_ui", String.valueOf(r103.getStatusHasUI()));
    L9:
        if (r103 == null) goto L11;
        String r109 = (String) r105.put("is_async", String.valueOf(r103.getStatusAsync()));
    L11:
        if (r103 == null) goto L13;
        r105.put("is_recycle", String.valueOf(r103.getStatusRecycle()));
    L13:
        r104.putAll(r105);
        r104.putAll(r100.f161845e);
        boolean r110 = false;
        if (com.bytedance.android.live.core.tetris.widgets.g.a() == false) goto L21;
        i91 r111 = com.bytedance.android.live.core.tetris.widgets.g.c();
        if (r111 == null) goto L18;
        boolean r112 = r111.b();
    L19:
        if (r112 == false) goto L21;
        r110 = true;
        goto L21
    L18:
        r112 = false;
    L21:
        if (r110 == false) goto L23;
        r100.f161841a.submit(new b(r100, r101, r102, r104));
        return;
    L23:
        ALogger.i(r101, a(r101, r102, r104));
    }
}
