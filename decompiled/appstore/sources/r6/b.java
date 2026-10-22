package r6;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.e;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.frameworks.baselib.network.http.util.h;
import com.bytedance.frameworks.baselib.network.http.util.i;
import com.bytedance.frameworks.core.encrypt.RequestEncryptUtils;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.ttnet.clientkey.ClientKeyManager;
import com.bytedance.ttnet.utils.RequestTicketUtil;
import f6.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import p6.d;

/* JADX INFO: loaded from: classes.dex */
public final class b extends w4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f23767a = false;

    static {
    }

    public b() {
    }

    public static void d(boolean r10) {
        f23767a = r10;
    }

    @Override // w4.a
    public g6.b a(g6.b r10) {
        g6.b r11 = super.a(r10);
        if (r11 != null) goto L6;
        return null;
    L6:
        long r12 = SystemClock.uptimeMillis();
        g6.b.a r13 = r11.J();
        String r14 = e(r11.D());
        r13.c(r14);
        if (r11.y() == null) goto L9;
        RetrofitMetrics r15 = r11.y();
        r15.C = SystemClock.uptimeMillis() - r12;
    L9:
        long r16 = SystemClock.uptimeMillis();
        ArrayList r17 = new ArrayList();
        if (r11.u() == null) goto L13;
        r17.addAll(r11.u());
    L13:
        if (f23767a == false) goto L31;
        LinkedList r18 = new LinkedList();     // Catch: Throwable -> L17
        String r19 = RequestEncryptUtils.g(r14, r18);     // Catch: Throwable -> L17
        if (r19 == null) goto L20;
        r13.c(r19);     // Catch: Throwable -> L17
    L20:
        if (r18.isEmpty() == true) goto L31;
        Iterator r20 = r18.iterator();     // Catch: Throwable -> L17
    L22:
        if (r20.hasNext() == false) goto L31;
        Pair r21 = (Pair) r20.next();     // Catch: Throwable -> L17
        if (r21 == null) goto L22;
        r17.add(new g6.a((String) r21.first, (String) r21.second));     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.printStackTrace();
    L31:
        if (r11.y() == null) goto L33;
        RetrofitMetrics r22 = r11.y();
        r22.D = SystemClock.uptimeMillis() - r16;
    L33:
        long r23 = SystemClock.uptimeMillis();
        String r24 = RequestTicketUtil.g(r14);     // Catch: Throwable -> L38
        if (e.b(r24) == true) goto L41;
        r17.add(new g6.a("X-SS-REQ-TICKET", r24));     // Catch: Throwable -> L38
    L41:
        if (r11.y() == null) goto L43;
        RetrofitMetrics r25 = r11.y();
        r25.E = SystemClock.uptimeMillis() - r23;
    L43:
        long r26 = SystemClock.uptimeMillis();
        com.bytedance.ttnet.utils.a.h(r14, r17);
        if (r11.y() == null) goto L46;
        RetrofitMetrics r27 = r11.y();
        r27.G = SystemClock.uptimeMillis() - r26;
    L46:
        ClientKeyManager.j().a(r17, r11.y());
        r13.b(r17);
        return r13.a();
    L38:
        th = move-exception;
        th.printStackTrace();
        goto L41
    }

    @Override // w4.a
    public void b(g6.b r18, f r19) {
        super.b(r18, r19);
        if (r18 == null) goto L130;
        if (r19 == null) goto L132;
        g6.c r10 = r19.e();
        long r11 = SystemClock.uptimeMillis();
    L19:
        th = move-exception;
        th.printStackTrace();
    L25:
        if (r18.y() == null) goto L27;
        r18.y().K = SystemClock.uptimeMillis() - r11;
    L27:
        ClientKeyManager.j().g(r18, r10);
        long r12 = SystemClock.uptimeMillis();
        Object r13 = r10.b();
        int r14 = 0;
        String r15 = null;
        if ((r13 instanceof p6.b) == false) goto L48;
        p6.b r16 = (p6.b) r13;
        if (r16.f7163b == null) goto L112;
        JSONObject r17 = new JSONObject();
        List r110 = r10.d();
        int r111 = 0;
    L33:
        if (r111 >= r110.size()) goto L44;
        g6.a r20 = (g6.a) r110.get(r111);     // Catch: Exception -> L41
        if (r20 == null) goto L43;
        if (TextUtils.isEmpty(r20.a()) == true) goto L43;
        r17.put(r20.a().toUpperCase(), r20.b());     // Catch: Exception -> L41
    L43:
        r111 = r111 + 1;
    L41:
        e = move-exception;
        e.printStackTrace();
        goto L43
    L44:
        o4.a r21 = r16.f7163b;
        if ((r21 instanceof d) == false) goto L47;
        ((d) r21).f23349t = r17;
    L47:
        ((d) r21).f22479b = r10.e();
        ((d) r16.f7163b).f22478a = r16.f7162a;
    L112:
        String r22 = r18.D();     // Catch: Throwable -> L52
        g6.a r23 = r18.t("X-SS-REQ-TICKET");     // Catch: Throwable -> L52
        if (r23 == null) goto L54;
        String r24 = r23.b();     // Catch: Throwable -> L52
    L55:
        g6.a r25 = r10.c("X-SS-REQ-TICKET");     // Catch: Throwable -> L52
        if (r25 == null) goto L58;
        String r26 = r25.b();     // Catch: Throwable -> L52
    L59:
        if (r26 == null) goto L61;
        r15 = r26;
    L61:
        RequestTicketUtil.a(r22, r24, r15, r16);     // Catch: Throwable -> L52
    L116:
        String r27 = r18.D();     // Catch: Throwable -> L81
        Uri r28 = Uri.parse(r27);     // Catch: Throwable -> L81
        if (r28.getHost().endsWith(k6.a.b()) == true) goto L67;
        return;
    L67:
        String[] r29 = {"sessionid", "tt_sessionid"};     // Catch: Throwable -> L81
        List r30 = r10.f(new String[]{"Set-Cookie"}[0]);     // Catch: Throwable -> L81
        if (r30 == null) goto L103;
        if (r30.size() <= 0) goto L103;
        Iterator r31 = r30.iterator();     // Catch: Throwable -> L81
    L73:
        if (r31.hasNext() == false) goto L103;
        g6.a r112 = (g6.a) r31.next();     // Catch: Throwable -> L81
        int r113 = r14;
    L77:
        if (r113 >= 2) goto L73;
        String r114 = v4.a.a(r112.b(), r29[r113]);     // Catch: Throwable -> L81
        if (Logger.debug() == false) goto L84;
        Logger.d("SsOkHttpClient", r114);     // Catch: Throwable -> L81
    L84:
        if (e.b(r114) == true) goto L100;
        int r115 = r10.e();     // Catch: Throwable -> L81
        boolean r116 = r16.M;     // Catch: Throwable -> L81
        JSONObject r117 = new JSONObject();     // Catch: Throwable -> L81
        String r118 = r28.getEncodedQuery();     // Catch: Throwable -> L109
        if (e.b(r118) == true) goto L91;
        r117.put("url_query", r118);     // Catch: Throwable -> L109
    L91:
        if (e.b(r16.f7162a) == true) goto L94;
        r117.put(ICronetClient.KEY_REMOTE_IP, r16.f7162a);     // Catch: Throwable -> L81
    L94:
        if (r10.d() == null) goto L96;
        r117.put("header_list", r10.d().toString());     // Catch: Throwable -> L81
    L96:
        int r32 = r27.indexOf("?");     // Catch: Throwable -> L81
        if (r32 != (-1)) goto L99;
        r32 = r27.length();     // Catch: Throwable -> L81
    L99:
        RequestTicketUtil.d("set_cookie", r27.substring(0, r32), r115, r116, r117);     // Catch: Throwable -> L81
    L100:
        r113 = r113 + 1;
        r14 = 0;
    L103:
        if (r18.y() == null) goto L105;
        r18.y().F = SystemClock.uptimeMillis() - r12;
    L105:
        long r33 = SystemClock.uptimeMillis();
        com.bytedance.ttnet.utils.a.f(r18, r10, r16);
        if (r18.y() == null) goto L131;
        r18.y().f7893J = SystemClock.uptimeMillis() - r33;
        return;
    L131:
        return;
    L81:
        th = move-exception;
        th.printStackTrace();
        goto L103
    L58:
        r26 = null;
        goto L59
    L54:
        r24 = null;
    L52:
        th = move-exception;
        th.printStackTrace();
        goto L116
    L48:
        r16 = null;
        goto L112
    L8:
        if (NetworkParams.f() == null) goto L25;
        String r34 = NetworkParams.f().getHeaderKey();     // Catch: Throwable -> L19
        if (e.b(r34) == true) goto L25;
        List r35 = r10.f(r34);     // Catch: Throwable -> L19
        if (r35 == null) goto L25;
        if (r35.size() <= 0) goto L25;
        ArrayList r36 = new ArrayList();     // Catch: Throwable -> L19
        Iterator r37 = r35.iterator();     // Catch: Throwable -> L19
    L17:
        if (r37.hasNext() == false) goto L21;
        r36.add(((g6.a) r37.next()).b());     // Catch: Throwable -> L19
        goto L17
    L21:
        NetworkParams.f().onCommandReceived(r36);     // Catch: Throwable -> L19
        goto L25
    L132:
        return;
    }

    public final String e(String r10) {
        if (e.b(r10) == false) goto L54;
        return r10;
    L54:
        LinkedHashMap r11 = new LinkedHashMap();     // Catch: Throwable -> L27
        Pair r12 = i.k(r10, r11);     // Catch: Throwable -> L27
        if (r12 != null) goto L9;
        return r10;
    L9:
        if (r11.isEmpty() == true) goto L30;
        Iterator r13 = r11.entrySet().iterator();     // Catch: Throwable -> L27
    L12:
        if (r13.hasNext() == false) goto L30;
        Map.Entry r14 = (Map.Entry) r13.next();     // Catch: Throwable -> L27
        if (r14 == null) goto L12;
        List r15 = (List) r14.getValue();     // Catch: Throwable -> L27
        if (r15 == null) goto L12;
        if (r15.isEmpty() == true) goto L12;
        LinkedHashSet r16 = new LinkedHashSet();     // Catch: Throwable -> L27
        Iterator r17 = r15.iterator();     // Catch: Throwable -> L27
    L23:
        if (r17.hasNext() == false) goto L12;
        String r18 = (String) r17.next();     // Catch: Throwable -> L27
        if (r16.contains(r18) == true) goto L26;
        r16.add(r18);     // Catch: Throwable -> L27
        goto L23
    L26:
        r17.remove();     // Catch: Throwable -> L27
    L30:
        h r19 = new h(((String) r12.first) + ((String) r12.second));     // Catch: Throwable -> L27
        if (r11.isEmpty() == true) goto L50;
        Iterator r20 = r11.entrySet().iterator();     // Catch: Throwable -> L27
    L34:
        if (r20.hasNext() == false) goto L50;
        Map.Entry r21 = (Map.Entry) r20.next();     // Catch: Throwable -> L27
        if (r21 == null) goto L34;
        if (r21.getKey() == null) goto L34;
        List r22 = (List) r21.getValue();     // Catch: Throwable -> L27
        if (r22 == null) goto L34;
        if (r22.isEmpty() == true) goto L34;
        Iterator r23 = r22.iterator();     // Catch: Throwable -> L27
    L48:
        if (r23.hasNext() == false) goto L34;
        r19.b((String) r21.getKey(), (String) r23.next());     // Catch: Throwable -> L27
    L50:
        return r19.c();
    L27:
        th = move-exception;
        th.printStackTrace();
        return r10;
    }
}
