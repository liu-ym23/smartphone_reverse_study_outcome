package com.bytedance.ai.monitor;

import com.bytedance.ai.utils.g;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import com.ss.texturerender.VideoSurfaceTexture;
import java.util.Iterator;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mx7.c;
import org.json.JSONException;
import org.json.JSONObject;
import rx7.h;

/* JADX INFO: loaded from: classes43.dex */
public class AppletMonitorableEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f37140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f37141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public EventOrigin f37142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f37143d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f37144e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f37145f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f37146g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public JSONObject f37147h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public JSONObject f37148i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public JSONObject f37149j;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/monitor/AppletMonitorableEvent$EventOrigin;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "Unknown", "Native", "MainJS", "UI", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum EventOrigin extends Enum<EventOrigin> {
        public static final EventOrigin MainJS = null;
        public static final EventOrigin Native = null;
        public static final EventOrigin UI = null;
        public static final EventOrigin Unknown = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EventOrigin[] f37150a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f37151b = null;
        private final int type;

        public static EnumEntries<EventOrigin> getEntries() {
            return f37151b;
        }

        static {
            EventOrigin r100 = new EventOrigin("Unknown", 0, 0);
            Unknown = r100;
            EventOrigin r101 = new EventOrigin("Native", 1, 1);
            Native = r101;
            EventOrigin r102 = new EventOrigin("MainJS", 2, 2);
            MainJS = r102;
            EventOrigin r103 = new EventOrigin("UI", 3, 3);
            UI = r103;
            EventOrigin[] r104 = {r100, r101, r102, r103};
            f37150a = r104;
            f37151b = EnumEntriesKt.enumEntries(r104);
        }

        public static EventOrigin[] values() {
            return (EventOrigin[]) f37150a.clone();
        }

        public final int getType() {
            return this.type;
        }

        public static EventOrigin valueOf(String r100) {
            return (EventOrigin) r27.a.a(EventOrigin.class, r100);
        }

        public EventOrigin(String r100, int r101, int r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    public static final class a {
    }

    static {
    }

    public boolean b() {
        if (this.f37140a.length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
        return false;
    L8:
        if ((!StringsKt.isBlank(this.f37140a)) == false) goto L12;
        return true;
    L12:
        return false;
    L5:
        r100 = false;
        goto L6
    }

    public JSONObject n() {
        if (b() == false) goto L5;
        JSONObject r100 = new JSONObject();     // Catch: JSONException -> L8
        r100.put("event", this.f37140a);     // Catch: JSONException -> L8
        r100.put("type", this.f37141b);     // Catch: JSONException -> L8
        r100.put(PlayerResolution.SDKKEY.ORIGIN, this.f37142c.name());     // Catch: JSONException -> L8
        r100.put(VideoSurfaceTexture.KEY_TIME, this.f37144e);     // Catch: JSONException -> L8
        l("description", null, r100);     // Catch: JSONException -> L8
        l("packageId", this.f37145f, r100);     // Catch: JSONException -> L8
        l("appId", this.f37146g, r100);     // Catch: JSONException -> L8
        c(this.f37147h, r100);     // Catch: JSONException -> L8
        j(r100);     // Catch: JSONException -> L8
        return r100;
    L8:
        e = move-exception;
        g.f37637a.d("AppletMonitorableEvent", "failed to convert event to json: " + e.getMessage());
        return new JSONObject();
    L5:
        return new JSONObject();
    }

    public JSONObject a() {
        return this.f37148i;
    }

    public final String getType() {
        return this.f37141b;
    }

    public /* synthetic */ AppletMonitorableEvent(String r100) {
        this(r100, EventOrigin.Unknown);
    }

    public static void j(JSONObject r100) throws JSONException {
        Intrinsics.checkNotNullParameter(r100, "json");
        h2.a r101 = f2.b.f475099c;
        Object r102 = "";
        if (r101 == null) goto L6;
        String r103 = r101.f483563b;
        if (r103 == null) goto L6;
    L8:
        if (r103.length() != 0) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == false) goto L13;
        g.f37637a.e("AppletMonitorableEvent", "did is Empty, AISDK isInitialized is false");
    L13:
        r100.put(com.bytedance.android.ec.core.event.a.KEY_DID, r103);
        int r105 = com.bytedance.ai.utils.a.f37625a;
        Object r106 = "Product";
        if (f2.b.a() == false) goto L28;
        h2.a r107 = f2.b.f475099c;
        if (r107 == null) goto L28;
        if (r107.f483575n == false) goto L22;
        Object r108 = r107.f483576o;
    L25:
        if (r108 == null) goto L28;
        r106 = r108;
        goto L28
    L22:
        if (r107.f483577p == false) goto L24;
        r108 = r107.f483578q;
        goto L25
    L24:
        r108 = "Product";
    L28:
        r100.put("http_env", r106);
        if (f2.b.a() == false) goto L35;
        Object[] r109 = {"boe", EffectConstants.CHANNEL_TEST, "prd"};
        int r110 = h.f539828a;
        int r111 = c.b().getSharedPreferences("gecko_settings", 0).getInt("gecko_env", 2);
        if (r111 >= 3) goto L35;
        if (r111 < 0) goto L35;
        r102 = r109[r111];
    L35:
        r100.put("gecko_env", r102);
        r100.put("ai_sdk_version", "1.15.0-rc.7");
        return;
    L10:
        r104 = false;
    L6:
        r103 = "";
        goto L8
    }

    public final void h(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        if (this.f37147h != null) goto L17;
        this.f37147h = new JSONObject();
    L17:
        JSONObject r101 = this.f37147h;     // Catch: JSONException -> L14
        if (r100 == null) goto L21;
        if (r101 == null) goto L22;
        Iterator<Map.Entry<String, ? extends Object>> r102 = r100.entrySet().iterator();     // Catch: JSONException -> L14
    L11:
        if (r102.hasNext() == false) goto L23;
        Map.Entry<String, ? extends Object> r103 = r102.next();     // Catch: JSONException -> L14
        r101.put(r103.getKey(), r103.getValue());     // Catch: JSONException -> L14
        goto L11
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L14:
        e = move-exception;
        g.f37637a.e("AppletMonitorableEvent", ExceptionsKt.stackTraceToString(e));
    }

    public final void i(JSONObject r100) {
        Intrinsics.checkNotNullParameter("pageInfo", "key");
        Intrinsics.checkNotNullParameter(r100, "value");
        if (r100.length() <= 0) goto L6;
        k("pageInfo", r100);
        return;
    }

    public final void m(EventOrigin r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f37142c = r100;
    }

    public AppletMonitorableEvent(String r100, EventOrigin r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, PlayerResolution.SDKKEY.ORIGIN);
        this.f37141b = "common_event";
        this.f37144e = -1;
        this.f37140a = r100;
        this.f37142c = r101;
    }

    public static void c(JSONObject r100, JSONObject r101) throws JSONException {
        Intrinsics.checkNotNullParameter(r101, "dst");
        if (r100 == null) goto L11;
        Iterator<String> r102 = r100.keys();
        if (r102 != null) goto L7;
        return;
    L7:
        if (r102.hasNext() == false) goto L18;
        String r103 = r102.next();
        Object r104 = r100.opt(r103);
        if (r104 == null) goto L7;
        r101.put(r103, r104);
        goto L7
    L18:
        return;
    }

    public final void d(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        k(r100, Integer.valueOf(r101));
    }

    public final void e(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        k(r100, Long.valueOf(r101));
    }

    public final void f(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        if (r101.length() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        return;
    L8:
        if ((!StringsKt.isBlank(r101)) == false) goto L12;
        k(r100, r101);
        return;
    L12:
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void g(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        k(r100, Boolean.valueOf(r101));
    }

    public final void k(String r100, Object r101) {
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return;
    L8:
        if (StringsKt.isBlank(r100) == true) goto L24;
    L17:
        e = move-exception;
        g.f37637a.d("AppletMonitorableEvent", "error occurred when put extra info to event: " + e.getMessage());
        return;
    L11:
        if (this.f37147h != null) goto L13;
        this.f37147h = new JSONObject();     // Catch: JSONException -> L17
    L13:
        JSONObject r103 = this.f37147h;     // Catch: JSONException -> L17
        if (r103 == null) goto L23;
        r103.putOpt(r100, r101);     // Catch: JSONException -> L17
        return;
    L23:
        return;
    L24:
        return;
    L5:
        r102 = false;
        goto L6
    }

    public static void l(String r100, String r101, JSONObject r102) throws JSONException {
        Intrinsics.checkNotNullParameter(r102, "json");
        boolean r103 = true;
        if (r100.length() != 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == true) goto L15;
        if (r101 != null) goto L9;
    L12:
        if (r103 == true) goto L16;
        r102.put(r100, r101);
        return;
    L16:
        return;
    L9:
        if (r101.length() == 0) goto L12;
        r103 = false;
        goto L12
    L15:
        return;
    L5:
        r104 = false;
        goto L6
    }
}
