package y4;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.util.h;
import com.bytedance.frameworks.baselib.network.http.util.i;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedanceos.common.ad.param.AdReportParam;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlinx.coroutines.channels.Channel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile d f26113e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f26114f = "d";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile String f26115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f26116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f26117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f26118d;

    public class a implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f26119a;

        public a(d r10) {
            this.f26119a = r10;
        }

        public int a(c r10, c r11) {
            return r10.d() - r11.d();
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
            return a((c) r10, (c) r11);
        }
    }

    static {
    }

    public d() {
        this.f26116b = false;
        this.f26117c = new CopyOnWriteArrayList();
        this.f26118d = new CopyOnWriteArrayList();
    }

    public static d e() {
        if (f26113e != null) goto L16;
        monitor-enter(d.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f26113e != null) goto L11;
        f26113e = new d();     // Catch: Throwable -> L9
    L11:
        monitor-exit(d.class);     // Catch: Throwable -> L9
    L16:
        return f26113e;
    }

    public static void h(JSONArray r10, List r11) {
        if (r10 == null) goto L12;
        if (r11 == null) goto L19;
        int r12 = 0;
    L14:
        if (r12 >= r10.length()) goto L21;
        String r13 = r10.getString(r12);     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r13) == true) goto L11;
        r11.add(r13);     // Catch: JSONException -> L13
    L11:
        r12 = r12 + 1;
        goto L14
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }

    public static void k(g6.b.a r10, g6.b r11, String r12) {
        if (r11.H() == false) goto L5;
    L7:
        ArrayList r13 = new ArrayList();
        if (TextUtils.isEmpty(r12) == true) goto L11;
        r13.add(new g6.a("x-tt-encrypt-queries", r12));
    L11:
        if (r11.u() == null) goto L14;
        r13.addAll(r11.u());
    L14:
        if (r11.G() == false) goto L20;
        TypedOutput r14 = r11.r();
        if ((r14 instanceof h6.a) == false) goto L20;
        long r15 = System.currentTimeMillis();
        boolean r16 = ((h6.a) r14).a();
        RetrofitMetrics r17 = r11.y();
        if (r17 == null) goto L22;
        r17.M = System.currentTimeMillis() - r15;
    L22:
        if (r16 == true) goto L24;
    L26:
        if (r16 == false) goto L29;
        r13.add(new g6.a("x-tt-cipher-version", "1.0.0"));
        r13.add(new g6.a("x-tt-encrypt-info", "1"));
    L31:
        r10.b(r13);
        return;
    L29:
        if (r11.H() == false) goto L31;
        r13.add(new g6.a("x-tt-cipher-version", "1.0.0"));
        r13.add(new g6.a("x-tt-encrypt-info", AdReportParam.ClickPosType.SKIP));
        goto L31
    L24:
        if (r11.H() == false) goto L26;
        r13.add(new g6.a("x-tt-cipher-version", "1.0.0"));
        r13.add(new g6.a("x-tt-encrypt-info", "2"));
    L20:
        r16 = false;
        goto L22
    L5:
        if (r11.G() == true) goto L7;
    }

    public final JSONArray a(List r10) {
        JSONArray r11 = new JSONArray();
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        y4.a r13 = (y4.a) r12.next();
        JSONObject r14 = new JSONObject();     // Catch: JSONException -> L8
        r14.put("hit", r13.c());     // Catch: JSONException -> L8
        r14.put("priority", r13.a());     // Catch: JSONException -> L8
        r14.put("consume", r13.b());     // Catch: JSONException -> L8
        r11.put(r14);     // Catch: JSONException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L10:
        Logger.d(f26114f, "action info: " + r11.toString());
        return r11;
    }

    public final boolean b(g6.b r10, Map r11) {
        ArrayList r12 = new ArrayList();
        boolean r13 = false;
        r10.P(0);
        Iterator r14 = this.f26117c.iterator();
    L4:
        if (r14.hasNext() == false) goto L8;
        if (((c) r14.next()).m(r10, r11, r12) == false) goto L4;
        r13 = true;
        goto L4
    L8:
        Logger.d(f26114f, "dispatchQueryMap hit: " + r13);
        if (r10.y() == null) goto L11;
        r10.y().P = a(r12);
    L11:
        return r13;
    }

    public void c(boolean r10) {
        this.f26116b = r10;
    }

    public g6.b d(g6.b r10) {
        if (this.f26116b == true) goto L6;
        Logger.d(f26114f, "Query filter engine is not enabled");
        return null;
    L6:
        String r11 = r10.D();
        if (TextUtils.isEmpty(r11) == false) goto L53;
        return null;
    L53:
        LinkedHashMap r12 = new LinkedHashMap();     // Catch: Throwable -> L26
        Pair r13 = i.k(r11, r12);     // Catch: Throwable -> L26
        if (r13 != null) goto L12;
    L50:
        return null;
    L12:
        if (r12.isEmpty() == true) goto L50;
        if (b(r10, r12) == true) goto L18;
        return null;
    L18:
        if (r10.H() == true) goto L20;
    L28:
        String r14 = null;
    L29:
        h r15 = new h(((String) r13.first) + ((String) r13.second));     // Catch: Throwable -> L26
        if (r12.isEmpty() == true) goto L48;
        Iterator r16 = r12.entrySet().iterator();     // Catch: Throwable -> L26
    L33:
        if (r16.hasNext() == false) goto L48;
        Map.Entry r17 = (Map.Entry) r16.next();     // Catch: Throwable -> L26
        if (r17 == null) goto L33;
        if (r17.getKey() == null) goto L33;
        List r18 = (List) r17.getValue();     // Catch: Throwable -> L26
        if (r18 == null) goto L33;
        if (r18.isEmpty() == true) goto L33;
        Iterator r19 = r18.iterator();     // Catch: Throwable -> L26
    L46:
        if (r19.hasNext() == false) goto L33;
        r15.b((String) r17.getKey(), (String) r19.next());     // Catch: Throwable -> L26
    L48:
        g6.b.a r20 = r10.J();     // Catch: Throwable -> L26
        k(r20, r10, r14);     // Catch: Throwable -> L26
        r20.c(r15.c());     // Catch: Throwable -> L26
        return r20.a();
    L20:
        if (r12.containsKey("x-tt-encrypt-queries") == false) goto L28;
        List r21 = (List) r12.get("x-tt-encrypt-queries");     // Catch: Throwable -> L26
        if (r21 == null) goto L28;
        if (r21.size() <= 0) goto L28;
        r14 = (String) r21.get(0);     // Catch: Throwable -> L26
        r12.remove("x-tt-encrypt-queries");     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public void f(String r10) {
        Logger.d(f26114f, "onNetConfigChanged config: " + r10 + " enabled: " + this.f26116b);
        if (this.f26116b == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L15;
        i(r10);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public final void g(JSONObject r10, ArrayList r11) {
        String r12 = r10.getString("action");
        int r13 = r10.getInt("act_priority");
        if (r13 >= 0) goto L5;
        return;
    L5:
        JSONObject r14 = r10.getJSONObject("param");
        int r15 = r10.optInt("set_req_priority", r13);
        if (r15 != (-1)) goto L8;
        r15 = Channel.UNLIMITED;
    L8:
        c r16 = c.a(r12, r13, r15, r14);
        if (r16 == null) goto L12;
        r11.add(r16);
        return;
    }

    public final synchronized void i(String r10) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (TextUtils.isEmpty(this.f26115a) == false) goto L6;
    L12:
        ArrayList r11 = new ArrayList();     // Catch: Throwable -> L10
        JSONArray r12 = new JSONArray(r10);     // Catch: Throwable -> L10
        int r13 = 0;
    L14:
        if (r13 >= r12.length()) goto L16;
        g(r12.getJSONObject(r13), r11);     // Catch: Throwable -> L10
        r13 = r13 + 1;     // Catch: Throwable -> L10
        goto L14
    L16:
        Collections.sort(r11, new a(this));     // Catch: Throwable -> L10
        this.f26117c.clear();     // Catch: Throwable -> L10
        this.f26117c.addAll(r11);     // Catch: Throwable -> L10
        this.f26115a = r10;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L6:
        if (this.f26115a.equals(r10) == false) goto L12;
        Logger.d(f26114f, "Config is same with local config, do not parse.");     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public void j(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        this.f26118d.clear();
        JSONArray r11 = new JSONArray(r10);     // Catch: JSONException -> L11
        int r12 = 0;
    L8:
        if (r12 >= r11.length()) goto L17;
        String r13 = r11.getString(r12);     // Catch: JSONException -> L11
        this.f26118d.add(r13);     // Catch: JSONException -> L11
        r12 = r12 + 1;
        goto L8
    L17:
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
    }
}
