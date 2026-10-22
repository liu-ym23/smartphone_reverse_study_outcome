package com.bytedance.android.livesdk.diagnose;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.v2;
import com.bytedance.android.livesdkapi.service.IDiagnoseDataManager;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kt1.a;
import kt1.b;
import kt1.c;
import kt1.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class DiagnoseEngine {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile DiagnoseEngine f121939h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<JSONObject> f121940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedList<JSONObject> f121941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedList<JSONObject> f121942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedList<JSONObject> f121943d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<Integer, e> f121944e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f121945f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public v2 f121946g;

    public @interface DiagnoseReasonType {
    }

    public @interface DiagnoseType {
    }

    public static DiagnoseEngine d() {
        if (f121939h != null) goto L15;
        monitor-enter(DiagnoseEngine.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f121939h != null) goto L9;
        f121939h = new DiagnoseEngine();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DiagnoseEngine.class);     // Catch: Throwable -> L11
    L15:
        return f121939h;
    }

    public DiagnoseEngine() {
        this.f121940a = new LinkedList();
        this.f121941b = new LinkedList();
        this.f121942c = new LinkedList();
        this.f121943d = new LinkedList();
        this.f121944e = new ConcurrentHashMap();
        this.f121946g = null;
    }

    public final Map<String, String> a(DiagnoseResult r210) {
        String r100 = DiagnoseResult.KEY_DIAGNOSE_ASSISTANT_INFO;
        String r101 = IDiagnoseDataManager.TYPE_DATA_DIAGNOSE_KEY_BASIC_PERFORMANCE;
        HashMap r110 = new HashMap();
        r210.monitorInfo.put("diagnose_duration", this.f121946g.diagnoseOnceDuration);     // Catch: Exception -> L52
        StringBuilder r111 = new StringBuilder();     // Catch: Exception -> L52
        StringBuilder r112 = new StringBuilder();     // Catch: Exception -> L52
        StringBuilder r113 = new StringBuilder();     // Catch: Exception -> L52
        StringBuilder r114 = new StringBuilder();     // Catch: Exception -> L52
        if (this.f121940a.size() <= 0) goto L27;
        Iterator<JSONObject> r115 = this.f121940a.iterator();     // Catch: Exception -> L52
    L7:
        if (r115.hasNext() == false) goto L27;
        Iterator<JSONObject> r116 = r115;
        JSONObject r117 = r115.next();     // Catch: Exception -> L52
        String r118 = r100;
        if ((r117.opt(r101) instanceof Map) == false) goto L25;
        Map r102 = (Map) r117.opt(r101);     // Catch: Exception -> L52
        if (r102.isEmpty() == true) goto L25;
        String r119 = r101;
        if (TextUtils.isEmpty((CharSequence) r102.get("anchor_id")) == true) goto L17;
        r111.append((String) r102.get("anchor_id"));     // Catch: Exception -> L52
        r111.append("#");     // Catch: Exception -> L52
    L17:
        if (TextUtils.isEmpty((CharSequence) r102.get("room_id")) == true) goto L20;
        r112.append((String) r102.get("room_id"));     // Catch: Exception -> L52
        r112.append("#");     // Catch: Exception -> L52
    L20:
        if (TextUtils.isEmpty((CharSequence) r102.get(IPerformanceManager.Params.room_type)) == true) goto L23;
        r113.append((String) r102.get(IPerformanceManager.Params.room_type));     // Catch: Exception -> L52
        r113.append("#");     // Catch: Exception -> L52
    L23:
        if (TextUtils.isEmpty((CharSequence) r102.get("scene")) == true) goto L26;
        r114.append((String) r102.get("scene"));     // Catch: Exception -> L52
        r114.append("#");     // Catch: Exception -> L52
    L26:
        r100 = r118;
        r115 = r116;
        r101 = r119;
    L25:
        r119 = r101;
    L27:
        String r120 = r100;
        r110.put("cb_anchor_id_list", r111.toString());     // Catch: Exception -> L52
        r110.put("cb_room_id_list", r112.toString());     // Catch: Exception -> L52
        r110.put("cb_is_degraded", "-1");     // Catch: Exception -> L52
        r110.put("cb_degraded_list", "");     // Catch: Exception -> L52
        r110.put("cb_room_type_list", r113.toString());     // Catch: Exception -> L52
        if (c.b().f506005b == false) goto L30;
        String r103 = "1";
    L31:
        r110.put("cb_is_anchor", r103);     // Catch: Exception -> L52
        r110.put("cb_scene_list", r114.toString());     // Catch: Exception -> L52
        r110.put("cp_battery_state_duration", "-1");     // Catch: Exception -> L52
        r110.put("cp_cpu_total_rate_avg", "-1");     // Catch: Exception -> L52
        r110.put("cp_low_power_mode_duration", "-1");     // Catch: Exception -> L52
        r110.put("cp_pss_total_count", "-1");     // Catch: Exception -> L52
        r110.put("cp_pss_total_avg", "-1");     // Catch: Exception -> L52
        r110.put("cp_gc_count", "-1");     // Catch: Exception -> L52
        r110.put("cp_java_pss_count", "-1");     // Catch: Exception -> L52
        long r104 = 0;
        if (this.f121943d.size() <= 0) goto L42;
        Iterator<JSONObject> r105 = this.f121943d.iterator();     // Catch: Exception -> L52
    L34:
        boolean r106 = false;
    L36:
        if (r105.hasNext() == false) goto L42;
        if (r105.next().optBoolean(IDiagnoseDataManager.BusinessData.BUSINESS_KEY_IS_PK) == false) goto L34;
        if (r106 == false) goto L41;
        r104 = r104 + 15;     // Catch: Exception -> L52
    L41:
        r106 = true;
    L42:
        r110.put("ab_pk_duration", String.valueOf(r104));     // Catch: Exception -> L52
        r110.put("ab_sing_duration", "");     // Catch: Exception -> L52
        r110.put("ab_guest_count", "");     // Catch: Exception -> L52
        r110.put("ab_audience_count", "");     // Catch: Exception -> L52
        r110.put("ab_small_to_big_gift_count", "");     // Catch: Exception -> L52
        r110.put("ab_video_gift_avg", "");     // Catch: Exception -> L52
        r110.put("ab_effect_gift_avg", "");     // Catch: Exception -> L52
        r110.put("ab_comment_num", "");     // Catch: Exception -> L52
        r110.put("ab_digg_avg", "");     // Catch: Exception -> L52
        r110.put("ab_sticker_list", "");     // Catch: Exception -> L52
        r110.put("ab_video_gift_duration", "");     // Catch: Exception -> L52
        r110.put("ab_effect_gift_duration", "");     // Catch: Exception -> L52
        r110.put("ab_diagnose_comment", "");     // Catch: Exception -> L52
        Iterator<String> r107 = r210.monitorInfo.keys();     // Catch: Exception -> L52
    L44:
        if (r107.hasNext() == false) goto L46;
        String r108 = r107.next();     // Catch: Exception -> L52
        r110.put(r108, String.valueOf(r210.monitorInfo.get(r108)));     // Catch: Exception -> L52
        goto L44
    L46:
        JSONObject r109 = r210.monitorInfo.optJSONObject(r120);     // Catch: Exception -> L52
        if (r109 != null) goto L49;
    L54:
        return r110;
    L49:
        if (r109.length() <= 0) goto L54;
        r110.put(r120, r109.toString());     // Catch: Exception -> L52
        goto L54
    L30:
        r103 = "0";
    L52:
        e = move-exception;
        ALogger.e("DiagnoseDiagnoseEngine", e);
        goto L54
    }

    public final boolean b(int r100) {
        if (this.f121940a.isEmpty() == true) goto L5;
        this.f121940a.clear();
    L5:
        this.f121940a.addAll(c.b().f506007d);
        e(this.f121940a);
        if (this.f121940a.size() >= r100) goto L10;
        return false;
    L10:
        if (this.f121941b.isEmpty() == true) goto L12;
        this.f121941b.clear();
    L12:
        this.f121941b.addAll(c.b().f506009f);
        e(this.f121941b);
        if (this.f121942c.isEmpty() == true) goto L15;
        this.f121942c.clear();
    L15:
        this.f121942c.addAll(c.b().f506010g);
        e(this.f121942c);
        if (this.f121943d.isEmpty() == true) goto L18;
        this.f121943d.clear();
    L18:
        this.f121943d.addAll(c.b().f506011h);
        e(this.f121943d);
        return true;
    }

    public final void c(DiagnoseResult r100) {
        StringBuilder r101 = new StringBuilder();     // Catch: Exception -> L18
        if (this.f121940a.isEmpty() == true) goto L13;
        HashMap r102 = new HashMap();     // Catch: Exception -> L18
        r102.put("performanceData", this.f121940a);     // Catch: Exception -> L18
        boolean r103 = a.a(f121939h, r100);     // Catch: Exception -> L18
        if (r103 == false) goto L7;
        r101.append("网络异常#");     // Catch: Exception -> L18
    L7:
        boolean r104 = b.a(f121939h, r102, r100);     // Catch: Exception -> L18
        if (r104 == false) goto L10;
        r101.append("功耗异常");     // Catch: Exception -> L18
    L10:
        if (r103 == true) goto L12;
        if (r104 == false) goto L13;
    L12:
        boolean r105 = true;
    L14:
        if (r105 == true) goto L16;
        r101.append("其他");     // Catch: Exception -> L18
    L16:
        r100.monitorInfo.put(DiagnoseResult.KEY_DIAGNOSE_REASON, r101.toString());     // Catch: Exception -> L18
        return;
    L13:
        r105 = false;
    L18:
        e = move-exception;
        ALogger.e("DiagnoseDiagnoseEngine", e);
    }

    public final void e(LinkedList<JSONObject> r110) {
        long r100 = System.currentTimeMillis();     // Catch: Exception -> L19
        v2 r101 = this.f121946g;     // Catch: Exception -> L19
        if (r101 == null) goto L7;
        long r102 = r101.dataCacheDuration;     // Catch: Exception -> L19
        if (r102 <= 0) goto L7;
    L8:
        boolean r103 = false;
    L9:
        if (r110.isEmpty() == true) goto L32;
        if (r103 == true) goto L33;
        JSONObject r104 = r110.peek();     // Catch: Exception -> L19
        if (r104 == null) goto L18;
        if ((r100 - r104.optLong("addTime")) <= (1000 * r102)) goto L18;
        r110.poll();     // Catch: Exception -> L19
    L18:
        r103 = true;
        goto L9
    L33:
        return;
    L32:
        return;
    L7:
        r102 = 300;
    L19:
        e = move-exception;
        ALogger.e("DiagnoseDiagnoseDiagnoseEngine", e);
    }
}
