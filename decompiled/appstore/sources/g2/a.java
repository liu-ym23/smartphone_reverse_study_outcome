package g2;

import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.g;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import m1.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a implements AsyncEventManager.IMonitorTimeTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f19888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f19889b;

    /* JADX INFO: renamed from: g2.a$a, reason: collision with other inner class name */
    public class RunnableC0255a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19890a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f19891b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f19892c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f19893d;

        public RunnableC0255a(a r10, String r11, Map r12, float r13) {
            this.f19893d = r10;
            this.f19890a = r11;
            this.f19891b = r12;
            this.f19892c = r13;
        }

        @Override // java.lang.Runnable
        public void run() {
            b r10 = (b) a.a(this.f19893d).get(this.f19890a);
            if (r10 != null) goto L5;
            b r11 = new b(this.f19891b, this.f19890a, this.f19892c);
            a.a(this.f19893d).put(this.f19890a, r11);
            return;
        L5:
            r10.a(this.f19892c);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f19894a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map f19895b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f19896c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f19897d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f19898e;

        public b(Map r10, String r11, float r12) {
            this.f19895b = r10;
            this.f19894a = r11;
            this.f19896c = r12;
            this.f19897d = System.currentTimeMillis();
            this.f19898e = 1;
        }

        public void a(float r10) {
            this.f19896c += r10;
            this.f19898e++;
        }

        public float b() {
            int r10 = this.f19898e;
            if (r10 > 0) goto L5;
            return -1.0f;
        L5:
            return this.f19896c / r10;
        }

        public boolean c(long r10) {
            if ((r10 - this.f19897d) <= 120000) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f19899a = null;

        static {
            f19899a = new a(null);
        }

        public static /* synthetic */ a a() {
            return f19899a;
        }
    }

    public /* synthetic */ a(RunnableC0255a r10) {
        this();
    }

    public static /* synthetic */ HashMap a(a r10) {
        return r10.f19889b;
    }

    public static a c() {
        return c.a();
    }

    public void b(Map r10, String r11, float r12) {
        AsyncEventManager.e().h(new RunnableC0255a(this, r11, r10, r12));
    }

    @Override // com.bytedance.apm.thread.AsyncEventManager.IMonitorTimeTask
    public void onTimeEvent(long r11) {
        if (this.f19889b.isEmpty() == true) goto L31;
        Iterator r10 = this.f19889b.entrySet().iterator();
        int r12 = g.e();
    L6:
        if (r10.hasNext() == false) goto L44;
        Map.Entry r13 = (Map.Entry) r10.next();
        String r14 = (String) r13.getKey();
        b r15 = (b) r13.getValue();
        if (r15.c(r11) == false) goto L6;
        r10.remove();
        float r16 = r15.b();
        if (w0.c.B() == false) goto L13;
        s1.c.d(s1.b.f24485c, new String[]{"aggregate fps: " + r14 + " , value: " + r16});
    L13:
        if (r16 <= 0.0f) goto L6;
        float r17 = r12;
        if (r16 <= r17) goto L33;
        r16 = r17;
    L33:
        JSONObject r18 = new JSONObject();     // Catch: Exception -> L32
        r18.put("fps", r16);     // Catch: Exception -> L32
        JSONObject r19 = new JSONObject();     // Catch: Exception -> L32
        r19.put("scene", r14);     // Catch: Exception -> L32
        e r20 = new e("fps", r14, r18, r19, null);     // Catch: Exception -> L32
        m3.b.a(r20, true);     // Catch: Exception -> L32
        JSONObject r21 = r20.f22047g;     // Catch: Exception -> L32
        r21.put("refresh_rate", r12);     // Catch: Exception -> L32
        if (this.f19888a == false) goto L21;
        this.f19888a = false;     // Catch: Exception -> L32
        r21.put("device_max_refresh_rate", g.b());     // Catch: Exception -> L32
        r21.put("refresh_rate_restricted", true ^ g.h());     // Catch: Exception -> L32
    L21:
        Map r22 = r15.f19895b;     // Catch: Exception -> L32
        if (r22 != null) goto L24;
    L29:
        l1.a.p().e(r20);     // Catch: Exception -> L32
        goto L6
    L24:
        if (r22.isEmpty() == true) goto L29;
        Iterator r23 = r15.f19895b.entrySet().iterator();     // Catch: Exception -> L32
    L27:
        if (r23.hasNext() == false) goto L29;
        Map.Entry r24 = (Map.Entry) r23.next();     // Catch: Exception -> L32
        r20.f22047g.put((String) r24.getKey(), r24.getValue());     // Catch: Exception -> L32
        goto L27
    L44:
        return;
    }

    public a() {
        this.f19889b = new HashMap();
        this.f19888a = true;
        AsyncEventManager.e().addTimeTask(this);
    }
}
