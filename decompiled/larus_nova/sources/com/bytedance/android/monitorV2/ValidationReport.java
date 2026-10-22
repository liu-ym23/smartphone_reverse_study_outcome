package com.bytedance.android.monitorV2;

import android.app.Application;
import android.text.TextUtils;
import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.bytedance.android.monitorV2.event.HybridEvent;
import com.bytedance.android.monitorV2.hybridSetting.entity.HybridSettingInitConfig;
import com.bytedance.android.monitorV2.util.l;
import com.bytedance.android.monitorV2.util.q;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.EventConstant;
import java.io.IOException;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class ValidationReport {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HybridSettingInitConfig f162983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f162984b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f162985c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, String> f162986d = null;

    static {
        f162984b = LazyKt.lazy(ValidationReport$client$2.INSTANCE);
        f162985c = "/monitor/data/validation";
        Application r100 = g.e().f163040a;
        Pair[] r101 = new Pair[10];
        String r102 = HybridEvent.EventPhase.EVENT_CREATE.name();
        String r103 = null;
        if (r100 == null) goto L5;
        String r104 = r100.getString(R.string.event_create);
    L6:
        r101[0] = TuplesKt.to(r102, r104);
        String r105 = HybridEvent.EventPhase.EVENT_UPLOAD.name();
        if (r100 == null) goto L9;
        String r106 = r100.getString(R.string.event_upload);
    L10:
        r101[1] = TuplesKt.to(r105, r106);
        String r107 = HybridEvent.EventPhase.SAMPLE_THROW.name();
        if (r100 == null) goto L13;
        String r108 = r100.getString(R.string.sample_throw);
    L14:
        r101[2] = TuplesKt.to(r107, r108);
        String r109 = HybridEvent.EventPhase.EVENT_TERMINATED.name();
        if (r100 == null) goto L17;
        String r110 = r100.getString(R.string.event_terminated);
    L18:
        r101[3] = TuplesKt.to(r109, r110);
        String r111 = HybridEvent.TerminateType.SWITCH_OFF.name();
        if (r100 == null) goto L21;
        String r112 = r100.getString(R.string.switch_off);
    L22:
        r101[4] = TuplesKt.to(r111, r112);
        String r113 = HybridEvent.TerminateType.PARAM_EXCEPTION.name();
        if (r100 == null) goto L25;
        String r114 = r100.getString(R.string.param_exception);
    L26:
        r101[5] = TuplesKt.to(r113, r114);
        String r115 = HybridEvent.TerminateType.CATCH_EXCEPTION.name();
        if (r100 == null) goto L29;
        String r116 = r100.getString(R.string.catch_exception);
    L30:
        r101[6] = TuplesKt.to(r115, r116);
        String r117 = HybridEvent.TerminateType.EVENT_REPEATED.name();
        if (r100 == null) goto L33;
        String r118 = r100.getString(R.string.event_repeated);
    L34:
        r101[7] = TuplesKt.to(r117, r118);
        String r119 = HybridEvent.TerminateType.INVALID_CASE.name();
        if (r100 == null) goto L37;
        String r120 = r100.getString(R.string.invalid_case);
    L38:
        r101[8] = TuplesKt.to(r119, r120);
        String r121 = HybridEvent.TerminateType.BLOCK_LIST.name();
        if (r100 == null) goto L41;
        r103 = r100.getString(R.string.invalid_case);
    L41:
        r101[9] = TuplesKt.to(r121, r103);
        f162986d = MapsKt.hashMapOf(r101);
        return;
    L37:
        r120 = null;
        goto L38
    L33:
        r118 = null;
        goto L34
    L29:
        r116 = null;
        goto L30
    L25:
        r114 = null;
        goto L26
    L21:
        r112 = null;
        goto L22
    L17:
        r110 = null;
        goto L18
    L13:
        r108 = null;
        goto L14
    L9:
        r106 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    public static void a(String r100) {
        RequestBody r101 = RequestBody.create(MediaType.parse("application/json"), r100);
        Request.Builder r102 = new Request.Builder();
        StringBuilder r103 = new StringBuilder();
        HybridSettingInitConfig r104 = f162983a;
        if (r104 == null) goto L5;
        String r105 = r104.f163090b;
    L6:
        r103.append(r105);
        r103.append(f162985c);
        nz2.b.a("Validation", "report code " + ((OkHttpClient) f162984b.getValue()).newCall(r102.url(r103.toString()).method("POST", r101).addHeader("Content-Type", "application/json").build()).execute().code());     // Catch: IOException -> L9
        return;
    L9:
        e = move-exception;
        com.bytedance.android.monitorV2.util.f.b(e);
        return;
    L5:
        r105 = null;
        goto L6
    }

    public static void c(HybridEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        String r101 = null;
        if ((r100 instanceof com.bytedance.android.monitorV2.event.a) == false) goto L6;
        q.f163249a.getClass();
        JSONObject r102 = q.a((com.bytedance.android.monitorV2.event.a) r100);
    L9:
        JSONObject r103 = new JSONObject().put("extra", r102);
        JSONObject r104 = new JSONObject();
        l.q(r104, EventConstant.Key.MODULE, "monitor");
        HybridEvent.EventPhase r105 = HybridEvent.EventPhase.EVENT_UPLOAD;
        HybridEvent.EventPhase r106 = r100.f163004d.f163016a;
        if (r105 != r106) goto L12;
    L15:
        l.p(r104, ContainerPosition.BODY, r103);
    L16:
        l.q(r104, "ev_type", r100.f163001a);
        l.o(r104, "timestamp", System.currentTimeMillis());
        int r107 = 1;
        if (HybridEvent.EventPhase.SAMPLE_THROW == r100.f163004d.f163016a) goto L19;
        boolean r108 = true;
    L20:
        l.p(r104, "hit_sample", Boolean.valueOf(r108));
        HybridSettingInitConfig r109 = f162983a;
        if (r109 == null) goto L23;
        String r110 = r109.f163094f;
    L24:
        l.q(r104, "device_id", r110);
        HybridSettingInitConfig r111 = f162983a;
        if (r111 == null) goto L27;
        String r112 = r111.f163091c;
    L28:
        l.q(r104, "os", r112);
        l.q(r104, "container_name", b("container_name", r100.f163001a, r103));
        l.q(r104, ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE, r100.f163006f.containerType);
        l.q(r104, "url", b("url", r100.f163001a, r103));
        q.f163249a.getClass();
        l.q(r104, "bid", q.c(r100));
        HybridSettingInitConfig r113 = f162983a;
        if (r113 == null) goto L31;
        String r114 = r113.f163089a;
    L32:
        l.q(r104, "aid", r114);
        l.q(r104, "sdk_version", "10.4.0");
        l.q(r104, "sdk_name", "Android Hybrid Monitor");
        l.p(r104, BindCardPayConfirmConstants.Key.TRACE_ID, r100.a());
        HybridEvent.EventPhase r115 = r100.f163004d.f163016a;
        if (r105 != r115) goto L35;
    L38:
        l.n(r104, "trace_type", r107);
        HybridEvent.EventPhase r116 = HybridEvent.EventPhase.EVENT_TERMINATED;
        HybridEvent.a r117 = r100.f163004d;
        HybridEvent.EventPhase r118 = r117.f163016a;
        if (r116 != r118) goto L43;
        HybridEvent.TerminateType r119 = r117.f163017b;
        if (r119 == null) goto L45;
        r101 = r119.name();
    L45:
        String r120 = f162986d.get(r101);
        if (r120 == null) goto L49;
        r101 = r120;
    L49:
        l.q(r104, "trace_content", r101);
        a(r104.toString());
        return;
    L43:
        if (r118 == null) goto L45;
        r101 = r118.name();
        goto L45
    L35:
        if (HybridEvent.EventPhase.EVENT_CREATE == r115) goto L38;
        r107 = 0;
        goto L38
    L31:
        r114 = null;
        goto L32
    L27:
        r112 = null;
        goto L28
    L23:
        r110 = null;
        goto L24
    L19:
        r108 = false;
        goto L20
    L12:
        if (HybridEvent.EventPhase.SAMPLE_THROW == r106) goto L15;
        l.p(r104, ContainerPosition.BODY, new JSONObject());
        goto L16
    L6:
        if ((r100 instanceof com.bytedance.android.monitorV2.event.b) == false) goto L8;
        q.f163249a.getClass();
        r102 = q.b((com.bytedance.android.monitorV2.event.b) r100);
        goto L9
    L8:
        r102 = null;
        goto L9
    }

    public static String b(String r100, String r101, JSONObject r102) {
    L25:
        e = move-exception;
        com.bytedance.android.monitorV2.util.f.b(e);
    L27:
        String r103 = "";
    L28:
        if (r103 != null) goto L31;
        return "";
    L31:
        return r103;
    L5:
        if (TextUtils.equals("url", r100) == false) goto L17;
        if (TextUtils.equals("custom", r101) == false) goto L11;
        JSONObject r104 = r102.optJSONObject("extra");     // Catch: JSONException -> L25
        if (r104 == null) goto L24;
        r103 = r104.optString("url");     // Catch: JSONException -> L25
    L24:
        r103 = null;
        goto L28
    L11:
        JSONObject r105 = r102.optJSONObject("extra");     // Catch: JSONException -> L25
        if (r105 == null) goto L24;
        JSONObject r106 = r105.optJSONObject("nativeBase");     // Catch: JSONException -> L25
        if (r106 == null) goto L24;
        r103 = r106.optString(r100);     // Catch: JSONException -> L25
        goto L28
    L17:
        if (TextUtils.equals("container_name", r100) == false) goto L27;
        JSONObject r107 = r102.optJSONObject("extra");     // Catch: JSONException -> L25
        if (r107 == null) goto L24;
        JSONObject r108 = r107.optJSONObject("containerBase");     // Catch: JSONException -> L25
        if (r108 == null) goto L24;
        r103 = r108.optString(r100);     // Catch: JSONException -> L25
        goto L28
    L34:
        r103 = "";
        goto L28
    }
}
