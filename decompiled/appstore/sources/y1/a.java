package y1;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.apm.constant.TrafficConsts;
import com.bytedance.apm.data.pipeline.ICommonDataInnerListener;
import com.bytedance.apm.data.pipeline.INetSlaInnerListener;
import com.bytedance.apm.util.k;
import com.bytedance.apm.util.w;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f25962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f25963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map f25964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map f25965d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map f25966e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map f25967f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map f25968g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map f25969h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public w f25970i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile long f25971j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Map f25972k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public double f25973l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public double f25974m;

    /* JADX INFO: renamed from: y1.a$a, reason: collision with other inner class name */
    public class C0410a implements INetSlaInnerListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f25975a;

        public C0410a(a r10) {
            this.f25975a = r10;
        }

        @Override // com.bytedance.apm.data.pipeline.INetSlaInnerListener
        public void deliver(String r10, JSONObject r11) {
            if (a.a(this.f25975a) == true) goto L5;
            return;
        L5:
            this.f25975a.m(r10, r11);
        }
    }

    public class b implements ICommonDataInnerListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f25976a;

        public b(a r10) {
            this.f25976a = r10;
        }

        @Override // com.bytedance.apm.data.pipeline.ICommonDataInnerListener
        public void deliver(String r10, String r11, JSONObject r12) {
            if (a.a(this.f25976a) == true) goto L5;
            return;
        L5:
            if ("image_monitor_v2".equals(r11) == false) goto L9;
            this.f25976a.n(r12);
            return;
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f25977a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map f25978b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f25979c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f25980d;

        public c(a r10, String r11) {
            this.f25980d = r10;
            this.f25979c = 0;
            this.f25977a = r11;
            this.f25978b = new HashMap();
        }

        public void a(String r10, long r11) {
            if (this.f25978b.containsKey(r10) == false) goto L5;
            Map r12 = this.f25978b;
            r12.put(r10, Long.valueOf(((Long) r12.get(r10)).longValue() + r11));
        L6:
            this.f25979c += r11;
            return;
        L5:
            this.f25978b.put(r10, Long.valueOf(r11));
            goto L6
        }

        public JSONObject b() {
            JSONObject r10 = new JSONObject();
            r10.put("biz", this.f25977a);     // Catch: JSONException -> L13
            r10.put("usage", this.f25979c);     // Catch: JSONException -> L13
            JSONArray r11 = new JSONArray();     // Catch: JSONException -> L13
            Map r12 = this.f25978b;     // Catch: JSONException -> L13
            if (r12 != null) goto L6;
        L11:
            r10.put("detail", r11);     // Catch: JSONException -> L13
            goto L12
        L6:
            if (r12.size() <= 0) goto L11;
            Iterator r13 = this.f25978b.entrySet().iterator();     // Catch: JSONException -> L13
        L9:
            if (r13.hasNext() == false) goto L11;
            Map.Entry r14 = (Map.Entry) r13.next();     // Catch: JSONException -> L13
            JSONObject r15 = new JSONObject();     // Catch: JSONException -> L13
            r15.put("source_id", r14.getKey());     // Catch: JSONException -> L13
            r15.put("usage", r14.getValue());     // Catch: JSONException -> L13
            r11.put(r15);     // Catch: JSONException -> L13
        L12:
            return r10;
        }

        public JSONObject c(long r10) {
            JSONObject r11 = new JSONObject();
            r11.put("biz", this.f25977a);     // Catch: JSONException -> L15
            r11.put("usage", this.f25979c);     // Catch: JSONException -> L15
            JSONArray r12 = new JSONArray();     // Catch: JSONException -> L15
            Map r13 = this.f25978b;     // Catch: JSONException -> L15
            if (r13 != null) goto L6;
        L13:
            r11.put("detail", r12);     // Catch: JSONException -> L15
            goto L14
        L6:
            if (r13.size() <= 0) goto L13;
            Iterator r14 = this.f25978b.entrySet().iterator();     // Catch: JSONException -> L15
        L9:
            if (r14.hasNext() == false) goto L13;
            Map.Entry r15 = (Map.Entry) r14.next();     // Catch: JSONException -> L15
            if (((Long) r15.getValue()).longValue() < r10) goto L9;
            JSONObject r16 = new JSONObject();     // Catch: JSONException -> L15
            r16.put("source_id", r15.getKey());     // Catch: JSONException -> L15
            r16.put("usage", r15.getValue());     // Catch: JSONException -> L15
            r12.put(r16);     // Catch: JSONException -> L15
        L14:
            return r11;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f25981a = null;

        static {
            f25981a = new a(null);
        }

        public static /* synthetic */ a a() {
            return f25981a;
        }
    }

    public /* synthetic */ a(C0410a r10) {
        this();
    }

    public static /* synthetic */ boolean a(a r10) {
        return r10.f25962a;
    }

    public static a j() {
        return d.a();
    }

    public final void b(String r10, long r11, String r12) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        boolean r13 = k.c(w0.c.g());
        ActivityLifecycleService r14 = (ActivityLifecycleService) o3.a.a(ActivityLifecycleService.class);
        if (r14 == null) goto L8;
        boolean r15 = r14.isForeground();
    L10:
        if (this.f25964c != null) goto L13;
        this.f25964c = new HashMap();
    L13:
        if (this.f25965d != null) goto L16;
        this.f25965d = new HashMap();
    L16:
        if (this.f25966e != null) goto L19;
        this.f25966e = new HashMap();
    L19:
        if (this.f25967f != null) goto L22;
        this.f25967f = new HashMap();
    L22:
        if (this.f25968g != null) goto L25;
        this.f25968g = new HashMap();
    L25:
        if (this.f25964c.containsKey(r10) == false) goto L27;
        ((c) this.f25964c.get(r10)).a(r12, r11);
    L28:
        if (r13 == false) goto L34;
        if (r15 == true) goto L34;
        if (this.f25965d.containsKey(r10) == false) goto L33;
        ((c) this.f25965d.get(r10)).a(r12, r11);
        goto L34
    L33:
        c r16 = new c(this, r10);
        r16.a(r12, r11);
        this.f25965d.put(r10, r16);
    L34:
        if (r13 == false) goto L40;
        if (r15 == false) goto L40;
        if (this.f25966e.containsKey(r10) == false) goto L39;
        ((c) this.f25966e.get(r10)).a(r12, r11);
        goto L40
    L39:
        c r17 = new c(this, r10);
        r17.a(r12, r11);
        this.f25966e.put(r10, r17);
    L40:
        if (r13 == true) goto L46;
        if (r15 == true) goto L46;
        if (this.f25967f.containsKey(r10) == false) goto L45;
        ((c) this.f25967f.get(r10)).a(r12, r11);
        goto L46
    L45:
        c r18 = new c(this, r10);
        r18.a(r12, r11);
        this.f25967f.put(r10, r18);
    L46:
        if (r13 == true) goto L53;
        if (r15 == false) goto L53;
        if (this.f25968g.containsKey(r10) == false) goto L51;
        ((c) this.f25968g.get(r10)).a(r12, r11);
        goto L53
    L51:
        c r19 = new c(this, r10);
        r19.a(r12, r11);
        this.f25968g.put(r10, r19);
    L53:
        if (this.f25969h != null) goto L56;
        this.f25969h = new HashMap();
    L56:
        if (this.f25969h.containsKey(r10) == false) goto L58;
        ((c) this.f25969h.get(r10)).a(r12, r11);
    L59:
        Map r20 = this.f25972k;
        if (r20 == null) goto L68;
        Iterator r21 = r20.entrySet().iterator();
    L63:
        if (r21.hasNext() == false) goto L75;
        Map r22 = (Map) ((Map.Entry) r21.next()).getValue();
        if (r22.containsKey(r10) == true) goto L66;
        c r23 = new c(this, r10);
        r23.a(r12, r11);
        r22.put(r10, r23);
        goto L63
    L66:
        ((c) r22.get(r10)).a(r12, r11);
        goto L63
    L75:
        return;
    L68:
        return;
    L58:
        c r24 = new c(this, r10);
        r24.a(r12, r11);
        this.f25969h.put(r10, r24);
        goto L59
    L27:
        c r25 = new c(this, r10);
        r25.a(r12, r11);
        this.f25964c.put(r10, r25);
        goto L28
    L8:
        r15 = false;
        goto L10
    }

    public void c() {
        Map r10 = this.f25964c;
        if (r10 == null) goto L5;
        r10.clear();
    L5:
        Map r11 = this.f25965d;
        if (r11 == null) goto L8;
        r11.clear();
    L8:
        Map r12 = this.f25966e;
        if (r12 == null) goto L11;
        r12.clear();
    L11:
        Map r13 = this.f25967f;
        if (r13 == null) goto L14;
        r13.clear();
    L14:
        Map r14 = this.f25968g;
        if (r14 == null) goto L17;
        r14.clear();
    L17:
        w r15 = this.f25970i;
        if (r15 == null) goto L20;
        r15.b();
    L20:
        this.f25971j = 0;
    }

    public long d() {
        return this.f25971j;
    }

    public Map e() {
        return this.f25967f;
    }

    public Map f() {
        return this.f25968g;
    }

    public Map g() {
        return this.f25964c;
    }

    public Map h() {
        return this.f25965d;
    }

    public Map i() {
        return this.f25966e;
    }

    public w k() {
        return this.f25970i;
    }

    public Map l() {
        return this.f25969h;
    }

    public void m(String r10, JSONObject r11) {
        if (this.f25962a == true) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r10) == true) goto L39;
        if (r11 != null) goto L9;
        return;
    L9:
        if (r11.length() == 0) goto L41;
        String r12 = new URL(r10).getPath();     // Catch: Throwable -> L35
        if (TextUtils.isEmpty(r12) == false) goto L14;
        return;
    L14:
        String r13 = r11.optString(TrafficConsts.KEY_NET_CONSUME_TYPE, "ttnet");     // Catch: Throwable -> L35
        JSONObject r14 = r11.optJSONObject("request_log");     // Catch: Throwable -> L35
        if (r14 != null) goto L19;
        String r15 = r11.optString("request_log");     // Catch: Throwable -> L35
        if (TextUtils.isEmpty(r15) == true) goto L19;
        r14 = new JSONObject(r15);     // Catch: Throwable -> L35
    L19:
        JSONObject r16 = r14.optJSONObject("response");     // Catch: Throwable -> L35
        if (r16 == null) goto L22;
        long r17 = r16.optLong("received_bytes") + r16.optLong("sent_bytes");     // Catch: Throwable -> L35
    L23:
        this.f25971j += r17;     // Catch: Throwable -> L35
        if (r17 <= this.f25973l) goto L30;
        if (this.f25970i != null) goto L28;
        this.f25970i = new w(30);     // Catch: Throwable -> L35
    L28:
        this.f25970i.a(new g(r12, r17, r13));     // Catch: Throwable -> L35
    L30:
        if (TextUtils.isEmpty(r10) == false) goto L38;
    L32:
        b(r13, r17, r10);
        y1.b.d().a(r17, r12, r13);
        return;
    L38:
        r10 = Uri.parse(r10).buildUpon().clearQuery().build().toString();     // Catch: Exception -> L34 Throwable -> L35
    L22:
        r17 = 0;
    L42:
        return;
    L41:
        return;
    }

    public void n(JSONObject r10) {
    }

    public void o(double r10) {
        this.f25974m = r10;
    }

    public final void p() {
        l1.a.p().q(new b(this));
    }

    public final void q(boolean r10) {
        this.f25962a = r10;
    }

    public final void r(boolean r10) {
        this.f25963b = r10;
        s1.a.i(r10);
    }

    public void s(double r10) {
        this.f25973l = r10;
    }

    public final void t() {
        l1.b.t().K(new C0410a(this));
    }

    public void u() {
        q(true);
        r(true);
        t();
        p();
    }

    public a() {
        this.f25971j = 0;
        this.f25973l = 102400.0d;
        this.f25974m = 102400.0d;
    }
}
