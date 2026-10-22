package com.bytedance.applog.monitor.v3.impl;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.applog.log.n;
import com.bytedance.applog.monitor.v3.EventStage;
import com.bytedance.applog.monitor.v3.StageEventType;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.socialbase.appdownloader.ah.DevicePlans;
import ex3.g;
import ex3.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Handler.Callback {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final List<String> f192531h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, a> f192532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f192533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f192534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SharedPreferences f192535d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ex3.b f192536e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f192537f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f192538g;

    /* JADX INFO: loaded from: classes6.dex */
    public static class a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final List<EventStage> f192539e = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f192540a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public EventStage f192541b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f192542c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final JSONObject f192543d;

        static {
            f192539e = Arrays.asList(new EventStage[]{EventStage.COLLECTED, EventStage.PROCESS_END, EventStage.DB_SAVE_END, EventStage.PACK_INSERT_END, EventStage.POST_ISOLATE, EventStage.POST_FAILED, EventStage.POST_START, EventStage.REPORT_END});
        }

        public final String b() {
            StringBuilder r100 = new StringBuilder("v4|");
            if (TextUtils.isEmpty(this.f192540a.f474713e) == false) goto L5;
            String r101 = "";
        L6:
            r100.append(r101);
            r100.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            r100.append(this.f192540a.f474714f);
            r100.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            r100.append(this.f192541b.name());
            r100.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            r100.append(this.f192540a.f474709a);
            r100.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            r100.append(this.f192540a.f474711c);
            r100.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            r100.append(this.f192540a.f474712d.name());
            r100.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            r100.append(this.f192543d);
            return r100.toString();
        L5:
            r101 = this.f192540a.f474713e;
            goto L6
        }

        public final void a(JSONObject r100) {
            Iterator<String> r101 = r100.keys();
        L4:
            if (r101.hasNext() == false) goto L11;
            String r102 = r101.next();
            if (this.f192543d.has(r102) == true) goto L4;
            this.f192543d.put(r102, r100.get(r102));     // Catch: JSONException -> L10
            goto L4
        }

        public a(EventStage r100, i r101) {
            this.f192542c = false;
            this.f192543d = new JSONObject();
            this.f192541b = r100;
            this.f192540a = r101;
        }
    }

    static {
        f192531h = Collections.singletonList("SentryMonitor");
    }

    public final boolean d() {
        if (this.f192537f == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f192536e.f474645o == true) goto L8;
        return false;
    }

    public final void f() {
        if (this.f192535d != null) goto L5;
        return;
    L5:
        int r100 = 0;
        n.w().k(8, f192531h, "start load cache map from sp...", new Object[0]);
        long r101 = this.f192535d.getLong("uptime", 0);
        if (r101 > 0) goto L8;
    L11:
        Map<String, ?> r102 = this.f192535d.getAll();
        if (r102.isEmpty() == false) goto L14;
        return;
    L14:
        int r103 = 2;
        HashMap r104 = new HashMap(r102.size() * 2);
        Iterator<Map.Entry<String, ?>> r105 = r102.entrySet().iterator();
    L16:
        if (r105.hasNext() == false) goto L76;
        Map.Entry<String, ?> r106 = r105.next();
        String r107 = r106.getKey();
        if (TextUtils.isEmpty(r107) == true) goto L16;
        if ("uptime".equals(r107) == true) goto L16;
        String r108 = (String) r106.getValue();
        List<EventStage> r109 = a.f192539e;
        a r110 = null;
        String r111 = null;
        r110 = null;
        String r112 = null;
        r110 = null;
        if (TextUtils.isEmpty(r108) == true) goto L72;
        AtomicLong r113 = g.f474706a;
        if (r108 != null) goto L28;
    L38:
        ArrayList r114 = new ArrayList();
    L39:
        ArrayList r115 = r114;
        if (r115.isEmpty() == true) goto L72;
        int r116 = -1;
        if (((String) ListProtector.get(r115, r100)).equals(DevicePlans.DEVICE_PLAN_VIVO4) == false) goto L54;
        r116 = CastIntegerProtector.parseInt((String) ListProtector.get(r115, r103));     // Catch: Throwable -> L45
    L46:
        EventStage r117 = EventStage.fromName((String) ListProtector.get(r115, 3));
        if (TextUtils.isEmpty((CharSequence) ListProtector.get(r115, 1)) == true) goto L50;
        r112 = (String) ListProtector.get(r115, 1);
    L50:
        a r118 = new a(r117, new i(r112, r116, (String) ListProtector.get(r115, 4), r107, CastLongProtector.parseLong((String) ListProtector.get(r115, 5)), StageEventType.parse((String) ListProtector.get(r115, 6))));
        r118.a(new JSONObject((String) ListProtector.get(r115, 7)));     // Catch: Throwable -> L93
    L67:
        r110 = r118;
        goto L72
    L54:
        if (((String) ListProtector.get(r115, r100)).equals("v3") == false) goto L65;
        r116 = CastIntegerProtector.parseInt((String) ListProtector.get(r115, 2));     // Catch: Throwable -> L58
    L59:
        EventStage r119 = EventStage.fromName((String) ListProtector.get(r115, 3));
        if (TextUtils.isEmpty((CharSequence) ListProtector.get(r115, 1)) == true) goto L63;
        r111 = (String) ListProtector.get(r115, 1);
    L63:
        r118 = new a(r119, new i(r111, r116, (String) ListProtector.get(r115, 4), r107, CastLongProtector.parseLong((String) ListProtector.get(r115, 5)), StageEventType.parse((String) ListProtector.get(r115, 6))));
        goto L67
    L65:
        if (r115.size() != 4) goto L69;
        r118 = new a(EventStage.fromName((String) ListProtector.get(r115, 0)), new i((String) ListProtector.get(r115, 1), r107, CastLongProtector.parseLong((String) ListProtector.get(r115, 2)), StageEventType.V3_EVENT));
        goto L67
    L69:
        if (r115.size() != 5) goto L72;
        r110 = new a(EventStage.fromName((String) ListProtector.get(r115, 0)), new i((String) ListProtector.get(r115, 1), r107, CastLongProtector.parseLong((String) ListProtector.get(r115, 2)), StageEventType.parse((String) ListProtector.get(r115, 3))));
        goto L72
    L28:
        if (r108.isEmpty() == true) goto L38;
        r114 = new ArrayList();
        int r120 = r108.length();
        int r121 = 0;
        int r122 = 0;
    L31:
        if (r121 >= r120) goto L36;
        if (r108.charAt(r121) != '|') goto L35;
        r114.add(r108.substring(r122, r121));
        r122 = r121 + 1;
    L35:
        r121 = r121 + 1;
        goto L31
    L36:
        if (r122 > r120) goto L39;
        r114.add(r108.substring(r122));
    L72:
        if (r110 == null) goto L75;
        r110.f192542c = true;
        r104.put(r107, r110);
    L75:
        r100 = 0;
        r103 = 2;
        goto L16
    L76:
        Map<String, a> r123 = this.f192532a;
        monitor-enter(r123);
        Iterator r124 = r104.entrySet().iterator();     // Catch: Throwable -> L90
    L80:
        if (r124.hasNext() == false) goto L88;
        Map.Entry r125 = (Map.Entry) r124.next();     // Catch: Throwable -> L90
        String r126 = (String) r125.getKey();     // Catch: Throwable -> L90
        a r127 = (a) r125.getValue();     // Catch: Throwable -> L90
        if (this.f192532a.containsKey(r125.getKey()) == false) goto L87;
        a r128 = this.f192532a.get(r125.getKey());     // Catch: Throwable -> L90
        if (r128 == null) goto L87;
        r127.f192542c = false;     // Catch: Throwable -> L90
        r127.f192540a.a(r128.f192540a);     // Catch: Throwable -> L90
    L87:
        this.f192532a.put(r126, r127);     // Catch: Throwable -> L90
        goto L80
    L88:
        monitor-exit(r123);     // Catch: Throwable -> L90
        return;
    L90:
        th = move-exception;
        throw th;
    L8:
        if ((System.currentTimeMillis() - r101) <= TimeUnit.DAYS.toMillis(this.f192536e.f474639i)) goto L11;
        this.f192535d.edit().clear().apply();
    }

    public d(ex3.b r100) {
        this.f192532a = Collections.synchronizedMap(new LinkedHashMap());
        this.f192533b = true;
        this.f192537f = true;
        this.f192538g = new AtomicBoolean(false);
        this.f192536e = r100;
    }

    public final void a(a r100) {
        n.w().k(8, f192531h, "start handle stage ({})", new Object[]{r100});
        Map<String, a> r101 = this.f192532a;
        monitor-enter(r101);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (e(r100.f192540a.f474709a) == true) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L20
        return;
    L8:
        a r102 = this.f192532a.get(r100.f192540a.f474710b);     // Catch: Throwable -> L20
        if (r102 != null) goto L11;
        this.f192532a.put(r100.f192540a.f474710b, r100);     // Catch: Throwable -> L20
    L15:
        monitor-exit(r101);     // Catch: Throwable -> L20
        Handler r103 = this.f192534c;
        if (r103 == null) goto L24;
        r103.removeMessages(4);
        this.f192534c.sendEmptyMessageDelayed(4, 500);
        return;
    L24:
        return;
    L11:
        r102.f192542c = false;     // Catch: Throwable -> L20
        r102.f192540a.a(r100.f192540a);     // Catch: Throwable -> L20
        if (r100.f192541b.ordinal() <= r102.f192541b.ordinal()) goto L14;
        r102.f192541b = r100.f192541b;     // Catch: Throwable -> L20
    L14:
        r102.a(r100.f192543d);     // Catch: Throwable -> L20
        goto L15
    }

    public final Pair<Map<String, a>, Long> c(long r100) {
        if (this.f192532a.isEmpty() == true) goto L5;
        LinkedHashMap r101 = new LinkedHashMap();
        Map<String, a> r102 = this.f192532a;
        monitor-enter(r102);
        Iterator<Map.Entry<String, a>> r103 = this.f192532a.entrySet().iterator();     // Catch: Throwable -> L20
    L10:
        if (r103.hasNext() == false) goto L17;
        Map.Entry<String, a> r104 = r103.next();     // Catch: Throwable -> L20
        a r105 = r104.getValue();     // Catch: Throwable -> L20
        r101.put(r104.getKey(), r105);     // Catch: Throwable -> L20
        i r106 = r105.f192540a;     // Catch: Throwable -> L20
        if (r106 == null) goto L14;
        int r107 = r106.f474709a.length();     // Catch: Throwable -> L20
    L15:
        r100 = r100 - ((long) (r107 + 223));     // Catch: Throwable -> L20
        if (r100 >= 0) goto L10;
    L14:
        r107 = 0;
    L17:
        monitor-exit(r102);     // Catch: Throwable -> L20
        return new Pair(r101, Long.valueOf(r100));
    L20:
        th = move-exception;
        throw th;
    L5:
        return new Pair(null, Long.valueOf(r100));
    }

    public final boolean e(String r100) {
        if (d() == false) goto L6;
        return true;
    L6:
        Map<String, Integer> r101 = this.f192536e.f474643m;
        if (r101 != null) goto L11;
        return false;
    L11:
        return r101.containsKey(r100);
    }

    public final void g(Map<String, a> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == true) goto L34;
        SharedPreferences r101 = this.f192535d;
        if (r101 == null) goto L9;
        SharedPreferences.Editor r102 = r101.edit();
    L10:
        Map<String, a> r103 = this.f192532a;
        monitor-enter(r103);
        Iterator<String> r104 = r100.keySet().iterator();     // Catch: Throwable -> L22
    L14:
        if (r104.hasNext() == false) goto L18;
        String r105 = r104.next();     // Catch: Throwable -> L22
        this.f192532a.remove(r105);     // Catch: Throwable -> L22
        if (r102 == null) goto L14;
        r102.remove(r105);     // Catch: Throwable -> L22
        goto L14
    L18:
        monitor-exit(r103);     // Catch: Throwable -> L22
        if (r102 == null) goto L33;
        r102.apply();
        return;
    L33:
        return;
    L22:
        th = move-exception;
        throw th;
    L9:
        r102 = null;
        goto L10
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r100) {
        int r101 = r100.what;
        if (r101 == 4) goto L10;
        if (r101 != 8) goto L6;
        a((a) r100.obj);
    L22:
        return false;
    L6:
        if (r101 != 12) goto L22;
        f();
        goto L22
    L10:
        n.w().k(8, f192531h, "start flush cache map (size={}) to sp...", new Object[]{Integer.valueOf(this.f192532a.size())});
        SharedPreferences.Editor r102 = this.f192535d.edit();
        Map<String, a> r103 = this.f192532a;
        monitor-enter(r103);
        Iterator<Map.Entry<String, a>> r104 = this.f192532a.entrySet().iterator();     // Catch: Throwable -> L23
    L14:
        if (r104.hasNext() == false) goto L20;
        a r105 = r104.next().getValue();     // Catch: Throwable -> L23
        if (r105.f192542c == true) goto L14;
        if (e(r105.f192540a.f474709a) == false) goto L14;
        r102.putString(r105.f192540a.f474710b, r105.b());     // Catch: Throwable -> L23
        r105.f192542c = true;     // Catch: Throwable -> L23
        goto L14
    L20:
        monitor-exit(r103);     // Catch: Throwable -> L23
        r102.putLong("uptime", System.currentTimeMillis());
        r102.apply();
    L23:
        th = move-exception;
        throw th;
    }

    public static void b(Map r110, JSONArray r111) {
        if (r110.isEmpty() == false) goto L5;
        return;
    L5:
        HashMap r100 = new HashMap();
        Iterator r112 = r110.values().iterator();
    L7:
        if (r112.hasNext() == false) goto L31;
        a r101 = (a) r112.next();
        JSONArray r102 = (JSONArray) r100.get(r101.f192541b);
        if (r102 != null) goto L11;
        r102 = new JSONArray();
        r100.put(r101.f192541b, r102);
    L11:
        JSONObject r103 = new JSONObject();
        r103.put("monitor_id", r101.f192540a.f474710b);     // Catch: Throwable -> L39
        StageEventType r104 = r101.f192540a.f474712d;     // Catch: Throwable -> L39
        if (r104 == null) goto L16;
        r103.put("event_type", r104.getLabel());     // Catch: Throwable -> L39
    L16:
        if (TextUtils.isEmpty(r101.f192540a.f474709a) == true) goto L18;
        r103.put("event", r101.f192540a.f474709a);     // Catch: Throwable -> L39
    L18:
        long r105 = r101.f192540a.f474711c;     // Catch: Throwable -> L39
        if (r105 <= 0) goto L22;
        r103.put("local_time_ms", r105);     // Catch: Throwable -> L39
    L22:
        if (TextUtils.isEmpty(r101.f192540a.f474713e) == true) goto L24;
        r103.put("event_priority", r101.f192540a.f474713e);     // Catch: Throwable -> L39
    L24:
        int r106 = r101.f192540a.f474714f;     // Catch: Throwable -> L39
        if (r106 < 0) goto L28;
        r103.put("global_priority", r106);     // Catch: Throwable -> L39
    L28:
        if (r101.f192543d.length() <= 0) goto L30;
        r103.put("stage_ms", r101.f192543d);     // Catch: Throwable -> L39
    L30:
        r102.put(r103);
        goto L7
    L31:
        JSONObject r113 = new JSONObject();
        r113.put("event", "sdk_stage");     // Catch: Throwable -> L40
        JSONObject r107 = new JSONObject();     // Catch: Throwable -> L40
        Iterator r108 = r100.entrySet().iterator();     // Catch: Throwable -> L40
    L34:
        if (r108.hasNext() == false) goto L36;
        Map.Entry r109 = (Map.Entry) r108.next();     // Catch: Throwable -> L40
        r107.put(((EventStage) r109.getKey()).toString(), r109.getValue());     // Catch: Throwable -> L40
        goto L34
    L36:
        r113.put("params", r107);     // Catch: Throwable -> L40
        r113.put("local_time_ms", System.currentTimeMillis());     // Catch: Throwable -> L40
        r113.put("event_id", g.f474707b.incrementAndGet());     // Catch: Throwable -> L40
        r113.put(SheetInputData.InputData.DateType.DATETIME, g.a());     // Catch: Throwable -> L40
    L37:
        r111.put(r113);
    }
}
