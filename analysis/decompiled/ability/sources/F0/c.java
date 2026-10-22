package F0;

import A6.l;
import H.h;
import L0.e;
import L0.f;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.compose.material3.internal.CalendarModelKt;
import androidx.core.app.NotificationCompat;
import com.bytedance.services.apm.api.IApmAgent;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import g1.AbstractC1451a;
import j0.AbstractC1591a;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import m0.C1669c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import v1.AbstractC2055a;

/* loaded from: classes2.dex */
public final class c implements C.a, G0.a, e, B.c {

    /* renamed from: D, reason: collision with root package name */
    public static final List f517D = Arrays.asList("timer", "count", "disk", "memory", "cpu", "fps", "traffic", "start", "page_load", "image_monitor", "network", "api_error", "common_log", "event_log", "performance_monitor", "flutter", "ui_action");
    public static final List E = Arrays.asList("block_monitor", "serious_block_monitor", "memory_object_monitor", "drop_frame_stack", "cpu_trace", "battery_trace");

    /* renamed from: F, reason: collision with root package name */
    public static final List f518F = Arrays.asList("tracing", "batch_tracing");

    /* renamed from: A, reason: collision with root package name */
    public long f519A;

    /* renamed from: a, reason: collision with root package name */
    public long f522a;
    public long b;
    public long c;
    public long e;
    public final LinkedList g;
    public volatile boolean h;
    public long m;
    public boolean n;
    public long p;

    /* renamed from: q, reason: collision with root package name */
    public long f524q;

    /* renamed from: r, reason: collision with root package name */
    public int f525r;

    /* renamed from: s, reason: collision with root package name */
    public int f526s;

    /* renamed from: t, reason: collision with root package name */
    public volatile int f527t;
    public int u;

    /* renamed from: v, reason: collision with root package name */
    public int f528v;

    /* renamed from: w, reason: collision with root package name */
    public long f529w;

    /* renamed from: x, reason: collision with root package name */
    public H0.b f530x;
    public H0.b y;

    /* renamed from: z, reason: collision with root package name */
    public H0.b f531z;
    public volatile boolean d = true;
    public int f = 100;
    public ArrayList i = AbstractC1591a.c;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f523j = AbstractC1591a.d;
    public ArrayList k = AbstractC1591a.f;
    public int l = 1;
    public boolean o = true;

    /* renamed from: B, reason: collision with root package name */
    public final List f520B = Arrays.asList("monitor", "exception", "tracing");

    /* renamed from: C, reason: collision with root package name */
    public i0.a f521C = new i0.a(new i0.a());

    public c() {
        try {
            this.g = (LinkedList) v1.b.f6765a.f903a;
        } catch (SQLiteDatabaseLockedException unused) {
        }
    }

    public static int h(LinkedList linkedList) {
        int iL;
        char c;
        Iterator it;
        int i;
        char c2 = 65535;
        if (S0.b.a0(linkedList)) {
            return -1;
        }
        if (h.b) {
            Log.v("LogReportManager", U7.a.e(new String[]{"need deleteUploadedLogs count: " + linkedList.size()}));
        }
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            C1669c c1669c = (C1669c) it2.next();
            if (c1669c != null) {
                long j5 = c1669c.f5294a;
                if (TextUtils.equals(c1669c.b, "network")) {
                    linkedList2.add(Long.valueOf(j5));
                } else {
                    linkedList3.add(Long.valueOf(j5));
                }
            }
        }
        if (linkedList3.isEmpty()) {
            iL = 0;
        } else {
            K1.a aVar = v1.b.f6765a;
            aVar.getClass();
            iL = TextUtils.equals("", "network") ? ((x1.b) aVar.d).l(linkedList3) : ((x1.b) aVar.c).l(linkedList3);
        }
        if (!linkedList2.isEmpty()) {
            K1.a aVar2 = v1.b.f6765a;
            aVar2.getClass();
            iL += TextUtils.equals("network", "network") ? ((x1.b) aVar2.d).l(linkedList2) : ((x1.b) aVar2.c).l(linkedList2);
        }
        if (h.b) {
            Log.v("LogReportManager", U7.a.e(new String[]{B7.a.h(iL, "finish deleteUploadedLogs count: ")}));
        }
        HashMap map = v1.d.f6766a;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - v1.d.b < 3600000) {
            return iL;
        }
        JSONObject jSONObject = new JSONObject();
        Iterator it3 = v1.d.f6766a.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry entry = (Map.Entry) it3.next();
            if (!TextUtils.isEmpty((CharSequence) entry.getKey())) {
                File file = new File((String) entry.getKey());
                if (file.exists()) {
                    HashSet hashSet = (HashSet) entry.getValue();
                    long length = file.length();
                    long jB = v1.d.c.b() * 1048576;
                    int iA = v1.d.c.a();
                    try {
                        jSONObject.put("before_size", length);
                        Iterator it4 = hashSet.iterator();
                        while (it4.hasNext()) {
                            w1.b bVar = (w1.b) it4.next();
                            c = c2;
                            try {
                                it = it3;
                                i = iL;
                                try {
                                    jSONObject.put("before_count_" + bVar.i(), bVar.c(null));
                                    c2 = c;
                                    iL = i;
                                    it3 = it;
                                } catch (JSONException unused) {
                                }
                            } catch (JSONException unused2) {
                            }
                        }
                    } catch (JSONException unused3) {
                    }
                    c = c2;
                    it = it3;
                    i = iL;
                    Iterator it5 = hashSet.iterator();
                    while (it5.hasNext()) {
                        ((w1.b) it5.next()).f(jCurrentTimeMillis - (iA * CalendarModelKt.MillisecondsIn24Hours));
                    }
                    if (length > jB) {
                        do {
                            iA--;
                            Iterator it6 = hashSet.iterator();
                            while (it6.hasNext()) {
                                ((w1.b) it6.next()).f(jCurrentTimeMillis - (iA * CalendarModelKt.MillisecondsIn24Hours));
                            }
                            length = file.length();
                            if (length >= jB) {
                            }
                        } while (iA > 1);
                    }
                    try {
                        jSONObject.put("after_size", length);
                        Iterator it7 = hashSet.iterator();
                        while (it7.hasNext()) {
                            w1.b bVar2 = (w1.b) it7.next();
                            jSONObject.put("after_count_" + bVar2.i(), bVar2.c(null));
                        }
                    } catch (JSONException unused4) {
                    }
                    c2 = c;
                    iL = i;
                    it3 = it;
                }
            }
        }
        int i6 = iL;
        IApmAgent iApmAgent = (IApmAgent) L2.a.a(IApmAgent.class);
        if (iApmAgent != null) {
            iApmAgent.monitorEvent("apm_db_size", null, jSONObject, null);
        }
        v1.d.a("special_monitor_v2");
        v1.d.a("default_ss_local_monitor");
        v1.d.a("ss_local_monitor");
        v1.d.a("ss_app_monitor");
        v1.d.b = jCurrentTimeMillis;
        return i6;
    }

    public static JSONArray j(String str, JSONArray jSONArray) {
        if (TextUtils.isEmpty(str) || !str.equals("monitor")) {
            return jSONArray;
        }
        JSONArray jSONArray2 = new JSONArray();
        if (jSONArray != null) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
                    if (jSONObject != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("payload", jSONObject);
                        jSONObject2.put("log_type", jSONObject.opt(NotificationCompat.CATEGORY_SERVICE));
                        jSONArray2.put(jSONObject2);
                    }
                } catch (Exception unused) {
                }
            }
        }
        return jSONArray2;
    }

    public static List m(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "monitor")) {
            return f517D;
        }
        if (TextUtils.equals(str, "exception")) {
            return E;
        }
        if (TextUtils.equals(str, "tracing")) {
            return f518F;
        }
        return null;
    }

    @Override // G0.a
    public final int a() {
        return this.u;
    }

    @Override // G0.a
    public final boolean b() {
        return this.h ? this.h : this.n;
    }

    @Override // B.c
    public final void c(Activity activity) {
    }

    @Override // G0.a
    public final long d() {
        return this.m;
    }

    @Override // L0.e
    public final void e(long j5) {
        long j6 = this.f524q;
        if (j6 > 0 && j5 - this.p > j6) {
            this.h = false;
            N.c.f1004a.getClass();
            this.d = true;
        }
        k(false);
    }

    @Override // B.c
    public final void f(Activity activity) {
        this.f527t = this.f526s;
        L0.d.f925a.b(new l(this, 4));
    }

    @Override // B.c
    public final void g(Bundle bundle) {
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00fe A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0015 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List i(int r17, java.util.List r18, long r19, long r21) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.c.i(int, java.util.List, long, long):java.util.List");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:(1:139)(11:142|(3:144|(1:146)|147)|277|148|259|149|150|261|151|152|(2:154|(4:164|(2:166|(3:168|169|170)(2:171|(3:192|193|194)(2:(1:180)|(3:182|(4:185|(4:187|188|189|296)(2:190|295)|191|183)|294))))(1:195)|196|(4:198|199|(1:203)(1:204)|(7:279|206|209|210|211|(3:213|214|(7:216|255|217|218|(2:289|220)|221|290)(1:291))(2:223|292)|222)(4:224|225|293|222))(0))(6:269|157|(1:159)(0)|(0)(0)|196|(0)(0)))(5:161|(1:163)(0)|(0)(0)|196|(0)(0)))|277|148|259|149|150|261|151|152|(0)(0)) */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0321 A[Catch: all -> 0x031e, JSONException -> 0x03eb, TryCatch #7 {JSONException -> 0x03eb, blocks: (B:157:0x0313, B:168:0x0331, B:170:0x0338, B:196:0x039d, B:198:0x03a1, B:210:0x03c3, B:171:0x0343, B:174:0x0349, B:183:0x035f, B:185:0x0365, B:187:0x036d, B:189:0x0378, B:191:0x0385, B:178:0x0352, B:192:0x0388, B:194:0x038f, B:195:0x039a, B:161:0x0321), top: B:269:0x0313 }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x039a A[Catch: all -> 0x031e, JSONException -> 0x03eb, TryCatch #7 {JSONException -> 0x03eb, blocks: (B:157:0x0313, B:168:0x0331, B:170:0x0338, B:196:0x039d, B:198:0x03a1, B:210:0x03c3, B:171:0x0343, B:174:0x0349, B:183:0x035f, B:185:0x0365, B:187:0x036d, B:189:0x0378, B:191:0x0385, B:178:0x0352, B:192:0x0388, B:194:0x038f, B:195:0x039a, B:161:0x0321), top: B:269:0x0313 }] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x03a1 A[Catch: all -> 0x031e, JSONException -> 0x03eb, TRY_LEAVE, TryCatch #7 {JSONException -> 0x03eb, blocks: (B:157:0x0313, B:168:0x0331, B:170:0x0338, B:196:0x039d, B:198:0x03a1, B:210:0x03c3, B:171:0x0343, B:174:0x0349, B:183:0x035f, B:185:0x0365, B:187:0x036d, B:189:0x0378, B:191:0x0385, B:178:0x0352, B:192:0x0388, B:194:0x038f, B:195:0x039a, B:161:0x0321), top: B:269:0x0313 }] */
    /* JADX WARN: Removed duplicated region for block: B:204:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0418 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:282:0x022b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0227 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0217 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(boolean r28) {
        /*
            Method dump skipped, instructions count: 1104
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.c.k(boolean):void");
    }

    public final boolean l(String str, JSONArray jSONArray, JSONArray jSONArray2, long j5, boolean z10) {
        try {
            JSONArray jSONArrayJ = j(str, jSONArray);
            JSONArray jSONArrayJ2 = j(str, jSONArray2);
            JSONObject jSONObject = new JSONObject();
            if (jSONArrayJ != null && jSONArrayJ.length() > 0) {
                jSONObject.put(SettingsConfig.KEY_DATA, jSONArrayJ);
            }
            if (jSONArrayJ2 != null && jSONArrayJ2.length() > 0) {
                jSONObject.put("timer", jSONArrayJ2);
            }
            if (S0.b.s0(jSONObject) || h.d() == null) {
                return false;
            }
            try {
                JSONObject jSONObjectD = h.d();
                if (jSONObjectD != null && TextUtils.isEmpty(jSONObjectD.optString("device_id"))) {
                    L.a aVar = h.e;
                    String did = aVar != null ? aVar.getDid() : "";
                    if (!TextUtils.isEmpty(did)) {
                        jSONObjectD.put("device_id", did);
                    }
                }
                AbstractC1451a.o(jSONObjectD);
            } catch (Throwable unused) {
            }
            JSONObject jSONObject2 = new JSONObject(h.d().toString());
            S0.b.V(jSONObject2, AbstractC2055a.f6764a.a(j5));
            jSONObject2.put("current_update_version_code", h.d().optString("update_version_code"));
            jSONObject2.put("debug_fetch", z10 ? 1 : 0);
            if (h.e != null) {
                jSONObject2.put("uid", "");
                jSONObject2.put("user_unique_id", h.e.b());
                jSONObject2.put("ab_sdk_version", h.e.a());
                jSONObject2.put("ssid", h.e.c());
                jSONObject2.put("user_id", h.e.getUserId());
                jSONObject2.put("device_id", h.e.getDid());
            }
            jSONObject2.put("sdk_report_mode", this.f521C.f4596a);
            jSONObject.put("header", jSONObject2);
            if (h.b) {
                U7.a.o("<monitor><verify>", "report", jSONObject.toString());
                S0.b.j1("DATA_SAVE_TO_SEND_DB", jSONObject);
            }
            return H0.c.a(str, jSONObject.toString());
        } catch (Throwable unused2) {
            return false;
        }
    }

    @Override // B.c
    public final void onActivityStarted(Activity activity) {
    }

    @Override // C.a
    public final void onReady() {
        H0.c.b = this;
        this.f530x = new H0.b("monitor");
        this.y = new H0.b("exception");
        this.f531z = new H0.b("tracing");
        H0.b bVar = this.f530x;
        if (!TextUtils.isEmpty("monitor") && bVar != null) {
            H0.c.f726a.put("monitor", bVar);
        }
        H0.b bVar2 = this.y;
        if (!TextUtils.isEmpty("exception") && bVar2 != null) {
            H0.c.f726a.put("exception", bVar2);
        }
        H0.b bVar3 = this.f531z;
        if (!TextUtils.isEmpty("tracing") && bVar3 != null) {
            H0.c.f726a.put("tracing", bVar3);
        }
        f fVar = L0.d.f925a;
        fVar.getClass();
        try {
            if (fVar.c) {
                fVar.g.add(this);
                fVar.b.a(fVar.e);
                fVar.b.b(fVar.e, f.h);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0052  */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v17, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List] */
    @Override // C.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onRefresh(org.json.JSONObject r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 422
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.c.onRefresh(org.json.JSONObject, boolean):void");
    }

    @Override // G0.a
    public final List a(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.equals(str, "monitor")) ? this.i : TextUtils.equals(str, "exception") ? this.k : TextUtils.equals(str, "tracing") ? this.f523j : Collections.EMPTY_LIST;
    }

    @Override // G0.a
    public final int c() {
        return this.f528v;
    }

    @Override // B.c
    /* renamed from: c, reason: collision with other method in class */
    public final void mo0c() {
        this.f527t = this.f525r;
    }
}
