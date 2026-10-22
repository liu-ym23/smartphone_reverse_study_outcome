package cc;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedanceos.common.toolbox.ServerElements;
import ec.d;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.text.StringsKt__StringsKt;
import org.apache.http.message.TokenParser;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final C0070a f6118j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f6119k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f6120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f6121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f6123d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f6124e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkedHashMap f6125f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinkedHashMap f6126g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f6127h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Application.ActivityLifecycleCallbacks f6128i;

    /* JADX INFO: renamed from: cc.a$a, reason: collision with other inner class name */
    public static final class C0070a {
        public /* synthetic */ C0070a(DefaultConstructorMarker r10) {
            this();
        }

        public final a a() {
            return a.b();
        }

        public C0070a() {
        }
    }

    public static final class b implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f6129a;

        public b(a r10) {
            this.f6129a = r10;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r10, Bundle r11) {
            q.g(r10, "activity");
            hc.b.g("AppLaunchMonitor", "onCreate-> top=" + r10, null, 4, null);
            Intent r12 = r10.getIntent();
            long r13 = SystemClock.elapsedRealtime();
            cc.b r14 = cc.b.f6130a;
            int r15 = 0;
            if ((r13 - r14.a()) > PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS) goto L5;
            boolean r16 = true;
        L6:
            if (r12 == null) goto L32;
            if (r16 == false) goto L33;
            ComponentName r17 = r12.getComponent();
            if (r17 == null) goto L11;
            String r18 = r17.getClassName();
        L12:
            r14.g(r18);
            if (q.b("android.intent.action.MAIN", r12.getAction()) == false) goto L19;
            Set<String> r19 = r12.getCategories();
            if (r19 == null) goto L19;
            if (r19.contains("android.intent.category.LAUNCHER") != true) goto L19;
        L30:
            r14.h(r15);
            hc.b.g("AppLaunchMonitor", "【为" + r14.b() + "启动】scene: " + r14.c() + " :" + (SystemClock.elapsedRealtime() - a.c(this.f6129a)), null, 4, null);
            return;
        L19:
            String r20 = r14.b();
            if (r20 != null) goto L22;
        L24:
            String r21 = r14.b();
            if (r21 != null) goto L27;
        L29:
            r15 = 2;
            goto L30
        L27:
            if (StringsKt__StringsKt.D(r21, "activity", true) != true) goto L29;
            a.e(this.f6129a, SystemClock.elapsedRealtime());
            r15 = 1;
            goto L30
        L22:
            if (StringsKt__StringsKt.E(r20, a.a(this.f6129a), false, 2, null) != true) goto L24;
        L11:
            r18 = null;
            goto L12
        L33:
            return;
        L32:
            return;
        L5:
            r16 = false;
            goto L6
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r10) {
            q.g(r10, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r10) {
            q.g(r10, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r10) {
            q.g(r10, "activity");
            a.d(this.f6129a);
            r10.getApplication().unregisterActivityLifecycleCallbacks(this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity r10, Bundle r11) {
            q.g(r10, "activity");
            q.g(r11, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity r10) {
            q.g(r10, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity r10) {
            q.g(r10, "activity");
        }
    }

    static {
        f6118j = new C0070a(null);
        f6119k = new a();
    }

    public a() {
        this.f6120a = -1;
        this.f6121b = -1;
        this.f6124e = 1;
        this.f6125f = new LinkedHashMap();
        this.f6126g = new LinkedHashMap();
        this.f6127h = "";
        this.f6128i = new b(this);
    }

    public static final /* synthetic */ String a(a r10) {
        return r10.f6127h;
    }

    public static final /* synthetic */ a b() {
        return f6119k;
    }

    public static final /* synthetic */ long c(a r10) {
        return r10.f6120a;
    }

    public static final /* synthetic */ void d(a r10) {
        r10.j();
    }

    public static final /* synthetic */ void e(a r10, long r11) {
        r10.f6120a = r11;
    }

    public static final a f() {
        return f6118j.a();
    }

    public final void g(String r10) {
        q.g(r10, "period");
        if (this.f6123d == false) goto L6;
        return;
    L6:
        if (cc.b.f6130a.f() == true) goto L8;
        return;
    L8:
        if (this.f6121b <= 0) goto L14;
        long r11 = SystemClock.elapsedRealtime() - this.f6121b;
        this.f6126g.put(r10, Long.valueOf(r11));
        hc.b.g("AppLaunchMonitor", "markEnd " + r10 + TokenParser.SP + r11, null, 4, null);
        if (q.b(r10, "userdata_real_show") == false) goto L15;
        k();
        this.f6125f.clear();
        this.f6126g.clear();
        return;
    L15:
        return;
    }

    public final void h(String r10) {
        q.g(r10, "period");
        if (this.f6123d == false) goto L6;
        return;
    L6:
        if (cc.b.f6130a.f() == true) goto L8;
        return;
    L8:
        if (this.f6121b <= 0) goto L12;
        long r11 = SystemClock.elapsedRealtime() - this.f6121b;
        this.f6125f.put(r10, Long.valueOf(r11));
        hc.b.g("AppLaunchMonitor", "markStart " + r10 + TokenParser.SP + r11, null, 4, null);
        return;
    }

    public final void i(Application r10) {
        q.g(r10, ServerElements.APP);
        r10.registerActivityLifecycleCallbacks(this.f6128i);
    }

    public final void j() {
        if (this.f6122c == false) goto L6;
        return;
    L6:
        if (cc.b.f6130a.e() == false) goto L11;
        this.f6122c = true;
        long r10 = SystemClock.elapsedRealtime() - this.f6120a;
        if (r10 >= 10000) goto L12;
        hc.b.g("AppLaunchMonitor", "reportDuration: " + r10, null, 4, null);
        d.f19371l.a().u(r10);
        return;
    L12:
        return;
    }

    public final void k() {
        if (this.f6123d == false) goto L5;
        return;
    L5:
        this.f6123d = true;
        if (cc.b.f6130a.f() == true) goto L8;
        return;
    L8:
        if (this.f6121b <= 0) goto L40;
        JSONObject r10 = new JSONObject();
        if (this.f6126g.size() <= 0) goto L41;
        Iterator r11 = this.f6126g.entrySet().iterator();
    L13:
        if (r11.hasNext() == false) goto L17;
        Map.Entry r12 = (Map.Entry) r11.next();
        String r13 = (String) r12.getKey();
        long r14 = ((Number) r12.getValue()).longValue();
        Long r15 = (Long) this.f6125f.get(r13);
        if (r15 == null) goto L13;
        r10.put(r13, r14 - r15.longValue()).put(r13 + "_start", r15.longValue()).put(r13 + "_end", r14);
        goto L13
    L17:
        Long r16 = (Long) this.f6126g.get("first_frame_show");
        Long r17 = (Long) this.f6125f.get("home_fragment_create");
        if (r16 == null) goto L23;
        if (r17 == null) goto L23;
        if (r16.longValue() <= r17.longValue()) goto L23;
        r10.put("home_create_to_first_show", r16.longValue() - r17.longValue());
    L23:
        Long r18 = (Long) this.f6126g.get("userdata_real_show");
        if (r18 == null) goto L29;
        if (r17 == null) goto L29;
        if (r18.longValue() <= r17.longValue()) goto L29;
        r10.put("home_create_to_feed_show", r18.longValue() - r17.longValue());
    L29:
        StringBuilder r19 = new StringBuilder();
        r19.append("reportAppLaunchDuration() now = ");
        r19.append(SystemClock.elapsedRealtime());
        r19.append(" , appStartTime= ");
        cc.b r20 = cc.b.f6130a;
        r19.append(r20.a());
        hc.b.g("AppLaunchMonitor", r19.toString(), null, 4, null);
        long r21 = SystemClock.elapsedRealtime() - r20.a();
        if (r21 <= 0) goto L32;
        hc.b.g("AppLaunchMonitor", "reportAppLaunchDuration() total_duration= " + r21 + ", event= " + r10, null, 4, null);
        d.f19371l.a().v(r21, r10);
        return;
    L32:
        hc.b.d("AppLaunchMonitor", "reportAppLaunchDuration()数据非法 total_duration <= 0", null, 4, null);
        return;
    L41:
        return;
    }

    public final void l(String r10) {
        q.g(r10, "entranceActivity");
        cc.b r11 = cc.b.f6130a;
        r11.d();
        this.f6127h = r10;
        if (r11.e() == false) goto L6;
        this.f6120a = SystemClock.elapsedRealtime();
    L6:
        if (r11.f() == false) goto L9;
        this.f6121b = SystemClock.elapsedRealtime();
        h("app_attach");
        return;
    }
}
