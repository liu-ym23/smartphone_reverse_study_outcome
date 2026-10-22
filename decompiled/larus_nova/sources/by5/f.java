package by5;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements gy5.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicInteger f21427d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicLong f21428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue<b> f21429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f21430c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f21431a = null;

        static {
            f21431a = new f();
        }
    }

    /* JADX INFO: loaded from: classes19.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f21432a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f21433b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f21434c;

        public b(byte[] r100, int r101, long r102) {
            this.f21432a = r100;
            this.f21433b = r101;
            this.f21434c = r102;
        }
    }

    static {
        f21427d = new AtomicInteger(0);
    }

    public final void d() {
        PolarisFileWrapper r100 = null;
        int r101 = 0;
        ConnectivityManager r102 = (ConnectivityManager) n.getContext().getSystemService("connectivity");     // Catch: Exception -> L105
        if (r102 == null) goto L6;
        NetworkInfo r103 = r102.getActiveNetworkInfo();     // Catch: Exception -> L105
    L7:
        if (r103 == null) goto L11;
        if (r103.isConnected() == false) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == true) goto L14;
        return;
    L14:
        if (d.a.f21420a.b() == true) goto L16;
        return;
    L16:
        if (n.f21462e == false) goto L19;
        fy5.c.a("trigger send.");
    L19:
        if (this.f21429b.isEmpty() == true) goto L47;
        Object[] r105 = this.f21429b.toArray();
        int r106 = r105.length;
        int r107 = 0;
    L22:
        if (r107 >= r106) goto L32;
        b r108 = (b) r105[r107];
        long r110 = r108.f21433b;
        d.a.f21420a.getClass();
        if (r110 <= 5) goto L27;
        this.f21429b.remove(r108);
    L31:
        r107 = r107 + 1;
        goto L22
    L27:
        if (r108.f21433b <= 0) goto L33;
        if ((System.currentTimeMillis() - r108.f21434c) <= 0) goto L31;
    L33:
        if (r108 == null) goto L35;
    L37:
        if (r108 == null) goto L47;
        if (n.f21462e == false) goto L43;
        fy5.c.a("sendMemory");
    L43:
        if (j.a.f21454a.f(r108.f21432a) == false) goto L45;
        this.f21429b.remove(r108);
        goto L47
    L45:
        int r109 = r108.f21433b + 1;
        r108.f21433b = r109;
        d.a.f21420a.getClass();
        r108.f21434c = d.a(r109) + System.currentTimeMillis();
        goto L47
    L35:
        if (this.f21429b.size() <= 0) goto L37;
        r108 = this.f21429b.peek();
        goto L37
    L32:
        r108 = null;
    L47:
        if (n.d() == false) goto L128;
        h r111 = h.a.f21438a;
        monitor-enter(r111);
        File r112 = by5.a.c();     // Catch: Throwable -> L101
        if (r112 != null) goto L54;
        monitor-exit(r111);
    L85:
        if (r100 != null) goto L87;
        return;
    L87:
        if (r100.exists() == true) goto L90;
        return;
    L90:
        if (j.a.f21454a.f(xu3.b.b(r100)) == true) goto L92;
        h r113 = h.a.f21438a;
        h.b r114 = r113.c(r100);
        if (r114 == null) goto L98;
        r101 = r114.f21439a + 1;
    L98:
        d.a.f21420a.getClass();
        long r115 = d.a(r101) + System.currentTimeMillis();
        r113.e(r100, r101, r115);
        if (n.f21462e == false) goto L131;
        fy5.c.a("sendfile error retry count:" + r100.getName() + tb2.c.DEFAULT_TEXT + r101 + " nextRetryTime:" + r115);
        return;
    L131:
        return;
    L92:
        if (n.f21462e == false) goto L94;
        fy5.c.a("sendFile: success");
    L94:
        h.a.f21438a.a(r100);
        return;
    L54:
        String[] r116 = r112.list();     // Catch: Throwable -> L101
        if (r116 != null) goto L57;
    L84:
        monitor-exit(r111);
        goto L85
    L57:
        if (r116.length == 0) goto L84;
        List r117 = Arrays.asList(r116);     // Catch: Throwable -> L101
        Collections.sort(r117, new g());     // Catch: Throwable -> L101
        Iterator r118 = r117.iterator();     // Catch: Throwable -> L101
        h.b r119 = null;
    L60:
        if (r118.hasNext() == false) goto L82;
        PolarisFileWrapper r120 = new PolarisFileWrapper(r112, (String) r118.next());     // Catch: Throwable -> L101
        h.b r121 = r111.c(r120);     // Catch: Throwable -> L101
        if (r121 == null) goto L81;
        if (n.f21462e == false) goto L68;
        fy5.c.a("list send file:" + r120.getName() + " " + r121.f21439a + " " + r121.f21440b + " " + System.currentTimeMillis());     // Catch: Throwable -> L101
    L68:
        long r122 = r121.f21439a;     // Catch: Throwable -> L101
        d.a.f21420a.getClass();     // Catch: Throwable -> L101
        if (r122 > 5) goto L70;
        if (r121.f21439a == 0) goto L81;
        if (r121.f21440b < System.currentTimeMillis()) goto L81;
        if (r119 == null) goto L80;
        if (r119.f21440b <= r121.f21440b) goto L60;
    L80:
        r119 = r121;
        r100 = r120;
        goto L60
    L70:
        r111.a(r120);     // Catch: Throwable -> L101
        fy5.c.b("APM-SDK", "retry count reached top");     // Catch: Throwable -> L101
    L81:
        r100 = r120;
    L82:
        monitor-exit(r111);
    L101:
        th = move-exception;
        throw th;
    L128:
        return;
    L6:
        r103 = null;
    L11:
        r104 = false;
        goto L12
    }

    public f() {
        this.f21428a = new AtomicLong(0);
        this.f21429b = new ConcurrentLinkedQueue();
    }

    public static void a(Map r100) {
        if (n.f21462e == false) goto L14;
        StringBuilder r101 = new StringBuilder("sendLog: input sendList merged into ");
        HashMap r102 = (HashMap) r100;
        r101.append(r102.size());
        r101.append(" group(s)");
        fy5.c.a(r101.toString());
        Iterator r103 = r102.entrySet().iterator();
        int r104 = 0;
    L6:
        if (r103.hasNext() == false) goto L21;
        List r105 = (List) ((Map.Entry) r103.next()).getValue();
        if (r105 == null) goto L6;
        fy5.c.a("----------------");
        JSONObject r106 = dy5.a.c().b(((c) ListProtector.get(r105, 0)).f21405b, ((c) ListProtector.get(r105, 0)).f21404a);
        StringBuilder r107 = new StringBuilder("group ");
        int r108 = r104 + 1;
        r107.append(r104);
        r107.append(" aid ");
        r107.append(((c) ListProtector.get(r105, 0)).f21405b);
        r107.append(" headerId ");
        r107.append(((c) ListProtector.get(r105, 0)).f21404a);
        r107.append(" header:");
        r107.append(r106);
        fy5.c.a(r107.toString());
        int r109 = 0;
    L11:
        if (r109 >= r105.size()) goto L13;
        fy5.c.a("  log[" + r109 + "]=" + ((c) ListProtector.get(r105, r109)).toString());
        r109 = r109 + 1;
        goto L11
    L13:
        fy5.c.a("----------------");
        r104 = r108;
        goto L6
    L21:
        return;
    }

    public static void b(List r100) {
        Iterator r101 = ((ArrayList) r100).iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        by5.b r102 = (by5.b) r101.next();
        File r103 = r102.f21402c;     // Catch: Exception -> L10
        if (r103 == null) goto L4;
        xu3.b.a(r103);     // Catch: Exception -> L10
    L10:
        Objects.toString(r102.f21402c);
        av3.a r104 = fy5.c.f479288a;
        if (r104 == null) goto L4;
        r104.a();
        goto L4
    }

    public static Map c(List r100) {
        HashMap r101 = new HashMap();
        Iterator r102 = ((ArrayList) r100).iterator();
    L4:
        if (r102.hasNext() == false) goto L12;
        Iterator<c> r103 = ((by5.b) r102.next()).f21403d.iterator();
    L7:
        if (r103.hasNext() == false) goto L4;
        c r104 = r103.next();
        String r105 = r104.f21404a + "_" + r104.f21405b;
        List r106 = (List) r101.get(r105);
        if (r106 != null) goto L11;
        r106 = new ArrayList();
        r101.put(r105, r106);
    L11:
        r106.add(r104);
        goto L7
    L12:
        return r101;
    }

    public static byte[] f(List r100) {
        Map r101 = c(r100);     // Catch: Throwable -> L9
        a(r101);     // Catch: Throwable -> L9
        JSONArray r102 = g(r101);     // Catch: Throwable -> L9
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L9
        r103.put("list", r102);     // Catch: Throwable -> L9
        if (n.f21462e == false) goto L7;
        r103.toString();     // Catch: Throwable -> L9
        av3.a r104 = fy5.c.f479288a;     // Catch: Throwable -> L9
        if (r104 == null) goto L7;
        r104.a();     // Catch: Throwable -> L9
    L7:
        return xu3.g.a(r103.toString());
    L9:
        th = move-exception;
        fy5.c.c("LogSender serialize failed.", th);
        return null;
    }

    public static JSONArray g(Map r110) {
        JSONArray r100 = new JSONArray();
        Iterator r111 = ((HashMap) r110).entrySet().iterator();
    L4:
        if (r111.hasNext() == false) goto L37;
        Map.Entry r101 = (Map.Entry) r111.next();
        String r102 = (String) r101.getKey();
        List r103 = (List) r101.getValue();
        if (xu3.e.b(r103) == true) goto L4;
        JSONArray r104 = new JSONArray();
        int r105 = 0;
    L10:
        if (r105 >= r103.size()) goto L26;
        c r106 = (c) ListProtector.get(r103, r105);
        JSONObject r107 = new JSONObject(new String(r106.f21406c));     // Catch: Exception -> L23
        if (com.bytedance.framwork.core.sdklib.apm6.downgrade.a.C3505a.f244861a.b(r107, (int) r106.f21405b) == false) goto L15;
        JSONObject r108 = r107.optJSONObject("_debug_self");
        if (r108 == null) goto L43;
    L21:
        r108.put("debug_sender_number", f21427d.getAndIncrement());     // Catch: Exception -> L38
    L22:
        r104.put(r107);
    L25:
        r105 = r105 + 1;
        goto L10
    L43:
        r108 = new JSONObject();     // Catch: Exception -> L38
        r107.put("_debug_self", r108);     // Catch: Exception -> L38
    L15:
        if (n.f21462e == false) goto L25;
        fy5.c.a("failed to report: event is downgraded: " + r107.toString());     // Catch: Exception -> L23
    L23:
        e = move-exception;
        fy5.c.c("toJSON", e);
        goto L25
    L26:
        JSONObject r109 = dy5.a.c().b(((c) ListProtector.get(r103, 0)).f21405b, ((c) ListProtector.get(r103, 0)).f21404a);
        if (r109 == null) goto L29;
        JSONObject r112 = new JSONObject();     // Catch: Exception -> L35
        r112.put("data", r104);     // Catch: Exception -> L35
        r112.put("header", r109);     // Catch: Exception -> L35
        r100.put(r112);     // Catch: Exception -> L35
    L35:
        e = move-exception;
        fy5.c.c("toJSON", e);
        goto L4
    L29:
        if (n.f21462e == false) goto L4;
        av3.a r113 = fy5.c.f479288a;
        if (r113 == null) goto L4;
        r113.a();
        goto L4
    L37:
        return r100;
    }

    public final void e(List<by5.b> r110) {
        d r100 = d.a.f21420a;     // Catch: Throwable -> L59
        int r101 = 1;
        boolean r102 = false;
        if (r100.f21419l == false) goto L17;
        long r103 = System.currentTimeMillis() - r100.f21416i.get();     // Catch: Throwable -> L59
        if (r100.f21409b <= r100.f21411d) goto L8;
        int r104 = r100.f21409b;     // Catch: Throwable -> L59
    L9:
        long r111 = r104;
        if (r111 > r100.f21412e) goto L14;
        r111 = r100.f21412e;     // Catch: Throwable -> L59
    L14:
        if (r103 > r111) goto L16;
        boolean r105 = true;
    L18:
        if (r105 == true) goto L20;
        byte[] r106 = f(r110);     // Catch: Throwable -> L59
        if (r106 != null) goto L28;
        b(r110);     // Catch: Throwable -> L59
        return;
    L28:
        long r107 = System.currentTimeMillis();     // Catch: Throwable -> L59
        if ((r107 - this.f21428a.get()) < 5000) goto L48;
        this.f21428a.set(r107);     // Catch: Throwable -> L59
        if (r100.b() == true) goto L63;
    L44:
        r101 = 0;
    L46:
        if (n.f21462e == false) goto L49;
        fy5.c.a("sendDirect:isReportLogEnable " + r100.b() + " :sendResult " + r102);     // Catch: Throwable -> L59
    L49:
        if (r102 == true) goto L57;
        long r108 = d.a(r101);     // Catch: Throwable -> L59
        long r109 = System.currentTimeMillis() + r108;     // Catch: Throwable -> L59
        boolean r112 = h.a.f21438a.d(r106, r101, r109);     // Catch: Throwable -> L59
        if (n.f21462e == false) goto L53;
        fy5.c.a("saveFile:Result:" + r112 + " " + r101 + " " + r108);     // Catch: Throwable -> L59
    L53:
        if (r112 == true) goto L57;
        this.f21429b.add(new b(r106, r101, r109));     // Catch: Throwable -> L59
        if (this.f21429b.size() <= 10) goto L57;
        this.f21429b.poll();     // Catch: Throwable -> L59
    L57:
        b(r110);     // Catch: Throwable -> L59
        return;
    L63:
        ConnectivityManager r113 = (ConnectivityManager) n.getContext().getSystemService("connectivity");     // Catch: Exception -> L62 Throwable -> L59
        if (r113 == null) goto L36;
        NetworkInfo r114 = r113.getActiveNetworkInfo();     // Catch: Exception -> L62 Throwable -> L59
    L37:
        if (r114 == null) goto L41;
        if (r114.isConnected() == false) goto L41;
        boolean r115 = true;
    L42:
        if (r115 == false) goto L44;
        r102 = j.a.f21454a.f(r106);     // Catch: Throwable -> L59
        goto L46
    L36:
        r114 = null;
    L41:
        r115 = false;
        goto L42
    L48:
        r101 = 0;
        goto L49
    L20:
        if (n.f21462e == false) goto L22;
        fy5.c.b("APM-SDK", "stop collect log");     // Catch: Throwable -> L59
    L22:
        b(r110);     // Catch: Throwable -> L59
        return;
    L16:
        r105 = false;
        goto L18
    L8:
        r104 = r100.f21411d;     // Catch: Throwable -> L59
        goto L9
    L17:
        r105 = r100.f21419l;     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        fy5.c.c("sendLog", th);
    }

    @Override // gy5.b
    public final void onTimeEvent(long r100) {
        if ((r100 - this.f21430c) < 90000) goto L12;
        d();     // Catch: Throwable -> L6
    L8:
        this.f21430c = System.currentTimeMillis();
        return;
    L6:
        th = move-exception;
        fy5.c.c("onTimeEvent", th);
        goto L8
    }
}
