package com.bytedance.android.shopping.monitor;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Choreographer;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.monitor.ECMonitorService;
import com.bytedance.android.ec.core.monitor.k;
import com.bytedance.apm.util.n;
import com.bytedance.crash.Npth;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f178665h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Map<String, d> f178666i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f178667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f178668b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Long> f178669c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Long> f178670d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f178671e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f178672f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, n<Long, Long>> f178673g;

    static {
        f178665h = new d();
        f178666i = new HashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g() {
        if (this.f178668b == false) goto L5;
        return;
    L5:
        JSONObject r100 = new JSONObject(this.f178671e);
        JSONObject r101 = new JSONObject();
        JSONObject r102 = new JSONObject(this.f178672f);
        Long r103 = (Long) ((HashMap) this.f178670d).get("duration");
        Iterator r104 = ((HashMap) this.f178670d).entrySet().iterator();
        Long r105 = r103;
    L7:
        if (r104.hasNext() == false) goto L23;
        Map.Entry r106 = (Map.Entry) r104.next();
        Long r110 = (Long) r106.getValue();
        if (r110 == null) goto L15;
        if (r110.longValue() <= 0) goto L15;
        r101.put((String) r106.getKey(), String.valueOf(r110));     // Catch: Exception -> L13
    L13:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L15:
        if (r105 == null) goto L7;
        if (r105.longValue() <= 0) goto L7;
        if (TextUtils.equals((CharSequence) r106.getKey(), "duration") == true) goto L7;
        r105 = Long.valueOf(r105.longValue() - r110.longValue());     // Catch: Exception -> L13
        goto L7
    L23:
        if (r105 != null) goto L25;
    L61:
        if (r105 != null) goto L63;
    L70:
        int r107 = ECMonitorService.f45110b;
        ECMonitorService.a.a(this.f178667a, r100, r101, r102);
        ((HashMap) f178666i).remove(toString());
        return;
    L63:
        if (r105.longValue() <= 0) goto L70;
        if (this.f178667a.equals("ec_anchor_v3_detail_duration") == true) goto L70;
        r101.put("render_duration", String.valueOf(r105));     // Catch: Exception -> L68
    L68:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L70
    L25:
        if (r105.longValue() <= 0) goto L61;
        if (((HashMap) this.f178673g).isEmpty() == true) goto L61;
        long r108 = r105.longValue();
        Long r109 = Long.valueOf(SystemClock.elapsedRealtime());
        Long r111 = Long.valueOf(SystemClock.elapsedRealtime());
        Iterator r112 = ((HashMap) this.f178673g).entrySet().iterator();
        Object r113 = r111;
        long r114 = 0;
        Object r115 = r109;
    L30:
        if (r112.hasNext() == false) goto L60;
        Map.Entry r116 = (Map.Entry) r112.next();
        n r117 = (n) r116.getValue();
        if (((Long) r117.f190676a).equals(r117.f190677b) == true) goto L30;
        r101.put((String) r116.getKey(), String.valueOf(((Long) r117.f190677b).longValue() - ((Long) r117.f190676a).longValue()));     // Catch: Exception -> L57
        if (((Long) r115).longValue() > ((Long) r117.f190676a).longValue()) goto L46;
        if (((Long) r113).longValue() < ((Long) r117.f190676a).longValue()) goto L43;
        if (((Long) r113).longValue() >= ((Long) r117.f190677b).longValue()) goto L43;
        Object r118 = r117.f190677b;     // Catch: Exception -> L57
    L41:
        r113 = r118;
    L43:
        if (((Long) r113).longValue() >= ((Long) r117.f190676a).longValue()) goto L30;
        r114 = r114 + (((Long) r117.f190676a).longValue() - ((Long) r113).longValue());     // Catch: Exception -> L57
        r118 = r117.f190677b;     // Catch: Exception -> L57
        goto L41
    L46:
        if (((Long) r115).longValue() > ((Long) r117.f190676a).longValue()) goto L48;
    L55:
        r114 = r114 + (((Long) r115).longValue() - ((Long) r117.f190677b).longValue());     // Catch: Exception -> L57
        Object r119 = r117.f190676a;     // Catch: Exception -> L57
    L56:
        r115 = r119;
        goto L30
    L48:
        if (((Long) r115).longValue() > ((Long) r117.f190677b).longValue()) goto L55;
        if (((Long) r113).longValue() > ((Long) r117.f190677b).longValue()) goto L53;
        r115 = r117.f190676a;     // Catch: Exception -> L57
        r118 = r117.f190677b;     // Catch: Exception -> L57
        goto L41
    L53:
        if (((Long) r113).longValue() <= ((Long) r117.f190677b).longValue()) goto L30;
        r119 = r117.f190676a;     // Catch: Exception -> L57
    L57:
        e = move-exception;
        ECExceptionMonitor.g(e.toString());
        goto L30
    L60:
        ((HashMap) this.f178673g).clear();
        r105 = Long.valueOf(r108 - ((((Long) r113).longValue() - ((Long) r115).longValue()) - r114));
        goto L61
    }

    public d() {
        this.f178668b = false;
        this.f178669c = new HashMap();
        this.f178670d = new HashMap();
        this.f178671e = new HashMap();
        this.f178672f = new HashMap();
        this.f178673g = new HashMap();
        this.f178668b = true;
    }

    public final void h() {
        Choreographer.getInstance().postFrameCallback(new c(this));
        Map<String, String> r100 = k.f45162a;
        k.f("ec_perf_duration_anchor_v3_detail", null);
    }

    public d(String r100) {
        this.f178668b = false;
        this.f178669c = new HashMap();
        this.f178670d = new HashMap();
        this.f178671e = new HashMap();
        this.f178672f = new HashMap();
        this.f178673g = new HashMap();
        this.f178667a = r100;
    }

    public static String c(String r100) {
        d r101 = new d(r100);
        String r102 = r101.toString();
        ((HashMap) f178666i).put(r102, r101);
        return r102;
    }

    public static d f(String r100) {
        Map<String, d> r101 = f178666i;
        if (((HashMap) r101).get(r100) != null) goto L7;
        return f178665h;
    L7:
        return (d) ((HashMap) r101).get(r100);
    }

    public static void j(String r100) {
        HashMap r101 = new HashMap();
        r101.put("e_commerce", r100);
        Npth.addTags(r101);
    }

    public final void a(String r100) {
        Map<String, Long> r101 = this.f178669c;
        HashMap r102 = (HashMap) r101;
        r102.put(r100, Long.valueOf(SystemClock.elapsedRealtime()));
    }

    public final void b(String r100) {
        Map<String, n<Long, Long>> r101 = this.f178673g;
        HashMap r102 = (HashMap) r101;
        r102.put(r100, new n(Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(SystemClock.elapsedRealtime())));
    }

    public final void d(String r100) {
        long r101 = SystemClock.elapsedRealtime();
        Long r102 = (Long) ((HashMap) this.f178669c).remove(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        long r103 = r101 - r102.longValue();
        if (r103 <= 0) goto L13;
        Map<String, Long> r104 = this.f178670d;
        HashMap r105 = (HashMap) r104;
        r105.put(r100, Long.valueOf(r103));
        if (TextUtils.equals(r100, com.bytedance.android.ec.core.event.a.KEY_API_DURATION) == true) goto L10;
        return;
    L10:
        if (TextUtils.equals(this.f178667a, "ec_anchor_v3_detail_duration") == false) goto L15;
        Map<String, Long> r106 = this.f178670d;
        HashMap r107 = (HashMap) r106;
        r107.put("pack_api_duration", Long.valueOf(r103));
        ((HashMap) this.f178670d).remove(com.bytedance.android.ec.core.event.a.KEY_API_DURATION);
        return;
    L15:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [S, java.lang.Long] */
    public final void e(String r100) {
        if (((HashMap) this.f178673g).get(r100) != null) goto L5;
        return;
    L5:
        long r101 = SystemClock.elapsedRealtime();
        if (((Long) ((n) ((HashMap) this.f178673g).get(r100)).f190676a).longValue() >= r101) goto L9;
        n r102 = (n) ((HashMap) this.f178673g).get(r100);
        r102.f190677b = Long.valueOf(r101);
        return;
    }

    public final void i(String r100, String r101) {
        ((HashMap) this.f178671e).put(r100, r101);
    }
}
