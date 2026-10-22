package com.bytedance.apm6.consumer.slardar.send;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements rt3.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<h, ConcurrentLinkedQueue<c>> f190735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f190736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f190737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f190738d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f190739e;

    /* JADX INFO: loaded from: classes14.dex */
    public class a implements Comparator<File> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(File r100, File r101) {
            return r100.compareTo(r101);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f190740a = null;

        static {
            f190740a = new f();
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f190741a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f190742b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f190743c;

        public c(byte[] r100, int r101, long r102) {
            this.f190741a = r100;
            this.f190742b = r101;
            this.f190743c = r102;
        }
    }

    @Override // rt3.e
    public final String getName() {
        return "second_log_dir";
    }

    @Override // rt3.e
    public final long getSize() {
        com.bytedance.apm6.consumer.slardar.send.c r100 = com.bytedance.apm6.consumer.slardar.send.c.a.f190708a;
        r100.c();
        PolarisFileWrapper r101 = r100.f190703c;
        if (r101 != null) goto L5;
        File[] r102 = null;
    L6:
        long r103 = 0;
        if (r102 != null) goto L9;
        return 0;
    L9:
        int r104 = r102.length;
        int r105 = 0;
    L10:
        if (r105 >= r104) goto L12;
        r103 = r103 + r102[r105].length();
        r105 = r105 + 1;
        goto L10
    L12:
        return r103;
    L5:
        r102 = r101.listFiles();
        goto L6
    }

    public f() {
        this.f190735a = new LinkedHashMap();
        this.f190737c = 30000;
        this.f190738d = 0;
        this.f190739e = 1;
    }

    public static void c(f r110) {
        r110.getClass();
        if (NetworkUtils.isNetworkAvailable(xu3.a.getContext()) == true) goto L5;
        return;
    L5:
        if (d.a.f190725a.b() == false) goto L124;
        if (xu3.a.a() == false) goto L10;
        List<String> r100 = mt3.a.f515607a;
        av3.b.a("APM-Slardar", "trigger send.");
    L10:
        if (r110.f190735a.isEmpty() == false) goto L12;
        boolean r101 = true;
    L43:
        if (du3.a.o() == false) goto L115;
        Iterator r102 = ((ArrayList) i.f190757c).iterator();
        r101 = true;
    L46:
        if (r102.hasNext() == false) goto L115;
        h r103 = (h) r102.next();
        com.bytedance.apm6.consumer.slardar.send.c r104 = com.bytedance.apm6.consumer.slardar.send.c.a.f190708a;
        String r105 = r103.getName();
        monitor-enter(r104);
        String r106 = "." + r105;     // Catch: Throwable -> L110
        r104.e();     // Catch: Throwable -> L110
        if (xu3.a.a() == false) goto L53;
        List<String> r111 = mt3.a.f515607a;     // Catch: Throwable -> L110
        av3.b.a("APM-Slardar", "failedFiles:" + r104.f190707g + " " + r106);     // Catch: Throwable -> L110
    L53:
        if (r104.f190707g.size() != 0) goto L56;
        monitor-exit(r104);
    L65:
        r101 = r101;
        PolarisFileWrapper r107 = null;
    L90:
        if (r107 == null) goto L101;
        if (r107.exists() == false) goto L94;
        if (g.e(r103).g(xu3.b.b(r107)) == false) goto L102;
        if (xu3.a.a() == false) goto L100;
        List<String> r108 = mt3.a.f515607a;
        av3.b.a("APM-Slardar", "sendFile: success");
    L100:
        com.bytedance.apm6.consumer.slardar.send.c.a.f190708a.b(r107);
        goto L101
    L102:
        com.bytedance.apm6.consumer.slardar.send.c r109 = com.bytedance.apm6.consumer.slardar.send.c.a.f190708a;
        com.bytedance.apm6.consumer.slardar.send.c.b r112 = r109.d(r107);
        if (r112 == null) goto L105;
        int r113 = r112.f190709a + 1;
    L106:
        d.a.f190725a.getClass();
        long r114 = d.a(r113) + System.currentTimeMillis();
        r109.g(r107, r113, r114);
        if (xu3.a.a() == false) goto L109;
        List<String> r115 = mt3.a.f515607a;
        av3.b.a("APM-Slardar", "sendfile error retry count:" + r107.getName() + tb2.c.DEFAULT_TEXT + r113 + " nextRetryTime:" + r114);
    L109:
        r101 = false;
        goto L46
    L105:
        r113 = 0;
        goto L106
    L94:
        com.bytedance.apm6.consumer.slardar.send.c.a.f190708a.b(r107);
    L101:
        r101 = r101;
        goto L46
    L56:
        ArrayList r116 = new ArrayList();     // Catch: Throwable -> L110
        Iterator<String> r117 = r104.f190707g.iterator();     // Catch: Throwable -> L110
    L58:
        if (r117.hasNext() == false) goto L63;
        String r118 = r117.next();     // Catch: Throwable -> L110
        if (r118.endsWith(r106) == false) goto L58;
        r116.add(r118);     // Catch: Throwable -> L110
        goto L58
    L63:
        if (xu3.e.b(r116) == false) goto L66;
        monitor-exit(r104);
        goto L65
    L66:
        Collections.sort(r116, new com.bytedance.apm6.consumer.slardar.send.a());     // Catch: Throwable -> L110
        Iterator r119 = r116.iterator();     // Catch: Throwable -> L110
        r107 = null;
        com.bytedance.apm6.consumer.slardar.send.c.b r120 = null;
    L68:
        if (r119.hasNext() == false) goto L88;
        String r121 = (String) r119.next();     // Catch: Throwable -> L110
        com.bytedance.apm6.consumer.slardar.send.c r122 = com.bytedance.apm6.consumer.slardar.send.c.a.f190708a;     // Catch: Throwable -> L110
        r122.c();     // Catch: Throwable -> L110
        PolarisFileWrapper r123 = new PolarisFileWrapper(r122.f190703c, r121);     // Catch: Throwable -> L110
        com.bytedance.apm6.consumer.slardar.send.c.b r124 = r104.d(r123);     // Catch: Throwable -> L110
        if (r124 == null) goto L71;
        if (xu3.a.a() == false) goto L77;
        List<String> r125 = mt3.a.f515607a;     // Catch: Throwable -> L110
        av3.b.a("APM-Slardar", "list send file:" + r123.getName() + " " + r124.f190709a + " " + r124.f190710b + " " + System.currentTimeMillis());     // Catch: Throwable -> L110
    L77:
        if (r124.f190709a == 0) goto L87;
        if (r124.f190710b < System.currentTimeMillis()) goto L87;
        if (r120 != null) goto L84;
    L85:
        r120 = r124;
        r107 = r123;
    L86:
        r101 = r101;
        goto L68
    L84:
        if (r120.f190710b <= r124.f190710b) goto L86;
    L87:
        r107 = r123;
    L89:
        monitor-exit(r104);
        goto L90
    L71:
        r101 = r101;
        goto L87
    L88:
        r101 = r101;
    L110:
        th = move-exception;
        throw th;
    L115:
        if (r101 == false) goto L118;
        r110.f190739e = 1;
        r110.f190737c = 30000;
        goto L124
    L118:
        if (r110.f190737c >= 120000) goto L121;
        long r126 = r110.f190739e + 1;
        r110.f190737c = 30000 * r126;
        r110.f190739e = r126;
    L121:
        if (r110.f190737c <= 120000) goto L124;
        r110.f190737c = 120000;
        goto L124
    L12:
        Iterator<h> r127 = r110.f190735a.keySet().iterator();
        r101 = true;
    L14:
        if (r127.hasNext() == false) goto L43;
        h r128 = r127.next();
        ConcurrentLinkedQueue<c> r129 = r110.f190735a.get(r128);
        if (r129 == null) goto L14;
        c[] r130 = (c[]) r129.toArray(new c[0]);
        int r131 = r130.length;
        int r132 = 0;
    L19:
        if (r132 >= r131) goto L26;
        c r133 = r130[r132];
        if (r133.f190742b <= 0) goto L27;
        if ((System.currentTimeMillis() - r133.f190743c) > 0) goto L27;
        r132 = r132 + 1;
    L27:
        if (r133 == null) goto L29;
    L31:
        if (r133 == null) goto L14;
        if (xu3.a.a() == false) goto L36;
        List<String> r134 = mt3.a.f515607a;
        av3.b.a("APM-Slardar", "sendMemory");
    L36:
        boolean r135 = g.e(r128).g(r133.f190741a);
        if (r135 == false) goto L39;
        r129.remove(r133);
    L40:
        if (r135 == true) goto L14;
        r101 = false;
        goto L14
    L39:
        int r136 = r133.f190742b + 1;
        r133.f190742b = r136;
        d.a.f190725a.getClass();
        r133.f190743c = d.a(r136) + System.currentTimeMillis();
        goto L40
    L29:
        if (r129.size() <= 0) goto L31;
        r133 = r129.peek();
        goto L31
    L26:
        r133 = null;
    L124:
        if (xu3.a.a() == true) goto L126;
        return;
    L126:
        if (d.a.f190725a.b() == true) goto L164;
        List<String> r137 = mt3.a.f515607a;
        av3.b.a("APM-Slardar", "report log disable");
        return;
    }

    public static void d(List r100) {
        Iterator r101 = ((ArrayList) r100).iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        pt3.a r102 = (pt3.a) r101.next();
        File r103 = r102.f530636d;     // Catch: Exception -> L10
        if (r103 == null) goto L4;
        xu3.b.a(r103);     // Catch: Exception -> L10
    L10:
        List<String> r104 = mt3.a.f515607a;
        Objects.toString(r102.f530636d);
        av3.a r105 = av3.b.f16366a;
        if (r105 == null) goto L4;
        r105.a();
        goto L4
    }

    @Override // rt3.e
    public final void a(long r100) {
        com.bytedance.apm6.consumer.slardar.send.c r101 = com.bytedance.apm6.consumer.slardar.send.c.a.f190708a;
        r101.c();
        PolarisFileWrapper r102 = r101.f190703c;
        if (r102 != null) goto L5;
        File[] r103 = null;
    L6:
        if (r103 != null) goto L8;
        return;
    L8:
        int r104 = r103.length;
        int r105 = 0;
    L9:
        if (r105 >= r104) goto L24;
        File r106 = r103[r105];
        String r107 = r106.getName();     // Catch: Throwable -> L25
        if (r107.startsWith("priority_") == false) goto L14;
        r107 = r107.substring(9);     // Catch: Throwable -> L25
    L14:
        String[] r108 = r107.split("_");     // Catch: Throwable -> L25
        if (r108.length != 2) goto L19;
        long r109 = CastLongProtector.parseLong(r108[0]);     // Catch: Throwable -> L25
    L21:
        if (r109 > r100) goto L23;
        com.bytedance.apm6.consumer.slardar.send.c.a.f190708a.b(r106);
    L23:
        r105 = r105 + 1;
    L19:
        r109 = -1;
        goto L21
    L24:
        return;
    L5:
        r103 = r102.listFiles();
        goto L6
    }

    @Override // rt3.e
    public final void b(long r110) {
        com.bytedance.apm6.consumer.slardar.send.c r100 = com.bytedance.apm6.consumer.slardar.send.c.a.f190708a;
        r100.c();
        PolarisFileWrapper r101 = r100.f190703c;
        if (r101 != null) goto L5;
        File[] r102 = null;
    L6:
        if (r102 != null) goto L8;
        return;
    L8:
        Arrays.sort(r102, new a());
        int r103 = r102.length;
        int r104 = 0;
        long r105 = 0;
        long r106 = 0;
        int r107 = 0;
    L9:
        if (r107 >= r103) goto L16;
        File r108 = r102[r107];
        if (r108.exists() == false) goto L15;
        if (r108.isFile() == false) goto L15;
        r106 = r106 + r108.length();
    L15:
        r107 = r107 + 1;
        goto L9
    L16:
        int r109 = r102.length;
    L17:
        if (r104 >= r109) goto L28;
        File r111 = r102[r104];
        if ((r106 - r105) <= r110) goto L39;
        if (r111.exists() == false) goto L27;
        if (r111.isFile() == false) goto L27;
        long r112 = r111.length();
        if (com.bytedance.apm6.consumer.slardar.send.c.a.f190708a.b(r111) == false) goto L27;
        r105 = r105 + r112;
    L27:
        r104 = r104 + 1;
        goto L17
    L39:
        return;
    L28:
        return;
    L5:
        r102 = r101.listFiles();
        goto L6
    }

    public final void e(List<pt3.a> r210, int r211, boolean r212) {
        d r100 = d.a.f190725a;     // Catch: Throwable -> L93
        if (r100.f190724m == false) goto L17;
        long r101 = System.currentTimeMillis() - r100.f190722k.get();     // Catch: Throwable -> L93
        if (r100.f190713b <= r100.f190715d) goto L8;
        int r102 = r100.f190713b;     // Catch: Throwable -> L93
    L9:
        long r103 = r102;
        if (r103 > r100.f190716e) goto L14;
        r103 = r100.f190716e;     // Catch: Throwable -> L93
    L14:
        if (r101 > r103) goto L16;
        boolean r104 = true;
    L18:
        if (r104 == true) goto L20;
        Map<h, byte[]> r105 = i.b(r210, r211);     // Catch: Throwable -> L93
        if (r105 != null) goto L32;
        d(r210);     // Catch: Throwable -> L93
        return;
    L32:
        boolean r106 = NetworkUtils.isNetworkAvailable(xu3.a.getContext());     // Catch: Throwable -> L93
        HashMap r107 = (HashMap) r105;     // Catch: Throwable -> L93
        Iterator r108 = r107.keySet().iterator();     // Catch: Throwable -> L93
        boolean r109 = false;
    L34:
        if (r108.hasNext() == false) goto L89;
        h r110 = (h) r108.next();     // Catch: Throwable -> L93
        byte[] r111 = (byte[]) r107.get(r110);     // Catch: Throwable -> L93
        if (r111 == null) goto L34;
        if (d.a.f190725a.b() == false) goto L67;
        if (r106 == false) goto L67;
        if (xu3.a.a() == false) goto L50;
        List<JSONObject> r112 = ls3.a.d(r111);     // Catch: Throwable -> L93
        if (r112 == null) goto L50;
        Iterator r113 = ((ArrayList) r112).iterator();     // Catch: Throwable -> L93
    L48:
        if (r113.hasNext() == false) goto L50;
        ls3.a.b((JSONObject) r113.next(), "DATA_SEND_BEGIN");     // Catch: Throwable -> L93
    L50:
        boolean r114 = g.e(r110).g(r111);     // Catch: Throwable -> L93
        if (xu3.a.a() == true) goto L53;
    L66:
        this.f190738d = System.currentTimeMillis();     // Catch: Throwable -> L93
        r109 = r109 | r114;     // Catch: Throwable -> L93
        int r115 = 1;
    L69:
        if (xu3.a.a() == false) goto L71;
        List<String> r116 = mt3.a.f515607a;     // Catch: Throwable -> L93
        av3.b.a("APM-Slardar", "sendDirect:isReportLogEnable " + d.a.f190725a.b() + " :sendResult " + r114);     // Catch: Throwable -> L93
    L71:
        if (r114 == true) goto L87;
        d.a.f190725a.getClass();     // Catch: Throwable -> L93
        long r117 = d.a(r115);     // Catch: Throwable -> L93
        long r118 = System.currentTimeMillis() + r117;     // Catch: Throwable -> L93
        if (du3.a.o() == false) goto L75;
        long r119 = r118;
        r114 = com.bytedance.apm6.consumer.slardar.send.c.a.f190708a.f(r111, r110.getName(), r115, r119, r212);     // Catch: Throwable -> L93
    L77:
        if (xu3.a.a() == false) goto L79;
        List<String> r120 = mt3.a.f515607a;     // Catch: Throwable -> L93
        av3.b.a("APM-Slardar", "saveFile:Result:" + r114 + ":isMaiProcess:" + du3.a.o() + HTTP.HEADER_LINE_DELIM + r115 + " " + r117);     // Catch: Throwable -> L93
    L79:
        if (r114 == false) goto L81;
    L88:
        r108 = r108;
        goto L34
    L81:
        if (this.f190735a.containsKey(r110) == false) goto L83;
        ConcurrentLinkedQueue<c> r121 = this.f190735a.get(r110);     // Catch: Throwable -> L93
    L85:
        if (r121.size() <= 10) goto L88;
        r121.poll();     // Catch: Throwable -> L93
        goto L88
    L83:
        ConcurrentLinkedQueue<c> r122 = new ConcurrentLinkedQueue();     // Catch: Throwable -> L93
        r122.add(new c(r111, r115, r119));     // Catch: Throwable -> L93
        r121 = r122;
        goto L85
    L75:
        r119 = r118;
        goto L77
    L87:
        r108 = r108;
        goto L88
    L53:
        if (r114 == false) goto L62;
        Iterator r123 = ((ArrayList) ls3.a.d(r111)).iterator();     // Catch: Throwable -> L93
    L56:
        if (r123.hasNext() == false) goto L66;
        JSONObject r124 = (JSONObject) r123.next();     // Catch: Throwable -> L93
        JSONObject r125 = r124.optJSONObject("DATA_DOCTOR");     // Catch: Exception -> L96 Throwable -> L93
        if (r125 == null) goto L61;
        r125.put("DATA_SEND_RESULT", 200);     // Catch: Exception -> L96 Throwable -> L93
    L61:
        ls3.a.b(r124, "DATA_SEND_SUCCESS");     // Catch: Throwable -> L93
        ls3.a.b(r124, "DATA_SEND_END");     // Catch: Throwable -> L93
        goto L56
    L62:
        Iterator r126 = ((ArrayList) ls3.a.d(r111)).iterator();     // Catch: Throwable -> L93
    L64:
        if (r126.hasNext() == false) goto L66;
        JSONObject r127 = (JSONObject) r126.next();     // Catch: Throwable -> L93
        ls3.a.b(r127, "DATA_SEND_FAIL");     // Catch: Throwable -> L93
        ls3.a.b(r127, "DATA_SEND_END");     // Catch: Throwable -> L93
    L67:
        r115 = 0;
        r114 = false;
        goto L69
    L89:
        if (r109 == false) goto L91;
        this.f190739e = 1;     // Catch: Throwable -> L93
        this.f190737c = 30000;     // Catch: Throwable -> L93
    L91:
        d(r210);     // Catch: Throwable -> L93
        return;
    L20:
        if (xu3.a.a() == false) goto L22;
        List<String> r128 = mt3.a.f515607a;     // Catch: Throwable -> L93
        av3.b.a("APM-Slardar", "stop collect log");     // Catch: Throwable -> L93
    L22:
        Iterator r129 = ((ArrayList) r210).iterator();     // Catch: Throwable -> L93
        long r130 = 0;
        long r131 = 0;
    L24:
        if (r129.hasNext() == false) goto L26;
        pt3.a r132 = (pt3.a) r129.next();     // Catch: Throwable -> L93
        r130 = r130 + ((long) r132.f530634b);     // Catch: Throwable -> L93
        r131 = r131 + ((long) r132.f530635c);     // Catch: Throwable -> L93
        goto L24
    L26:
        DropDataMonitor.a.f190700a.c(r130, r131, System.currentTimeMillis(), DropDataMonitor.Reason.SERVER_DROP);     // Catch: Throwable -> L93
        d(r210);     // Catch: Throwable -> L93
        return;
    L16:
        r104 = false;
        goto L18
    L8:
        r102 = r100.f190715d;     // Catch: Throwable -> L93
        goto L9
    L17:
        r104 = r100.f190724m;     // Catch: Throwable -> L93
    L93:
        th = move-exception;
        List<String> r133 = mt3.a.f515607a;
        av3.b.c("APM-Slardar", "sendLog", th);
    }
}
