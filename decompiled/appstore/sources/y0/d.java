package y0;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.battery.config.Constants;
import com.bytedance.apm.constant.CommonServiceName;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.thread.AsyncEventManager;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d extends v1.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public BroadcastReceiver f25932g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public IntentFilter f25933h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f25934i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f25935j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f25936k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f25937l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f25938m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List f25939n;

    public class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f25940a;

        /* JADX INFO: renamed from: y0.d$a$a, reason: collision with other inner class name */
        public class RunnableC0409a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ float f25941a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ float f25942b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f25943c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ a f25944d;

            public RunnableC0409a(a r10, float r11, float r12, String r13) {
                this.f25944d = r10;
                this.f25941a = r11;
                this.f25942b = r12;
                this.f25943c = r13;
            }

            @Override // java.lang.Runnable
            public void run() {
                JSONObject r10 = new JSONObject();     // Catch: Exception -> L21
                r10.put(Constants.KEY_BATTERY_TEMPERATURE, this.f25941a);     // Catch: Exception -> L21
                r10.put(Constants.KEY_BATTERY_REMAINING_ENERGY, this.f25942b);     // Catch: Exception -> L21
                if (d.q(this.f25944d.f25940a) == false) goto L18;
                if (d.s(this.f25944d.f25940a) != null) goto L7;
            L12:
                JSONObject r11 = new JSONObject();     // Catch: Exception -> L21
                if (TextUtils.isEmpty(this.f25943c) == false) goto L15;
                String r12 = "background";
            L16:
                r11.put("scene", r12);     // Catch: Exception -> L21
                m1.e r13 = new m1.e(CommonServiceName.MONITOR_TYPE_TEMPERATURE, "", r10, r11, null);     // Catch: Exception -> L21
                v1.b.a(r13, false);     // Catch: Exception -> L21
                l1.a.p().e(r13);     // Catch: Exception -> L21
                goto L18
            L15:
                r12 = this.f25943c;     // Catch: Exception -> L21
                goto L16
            L7:
                if (d.s(this.f25944d.f25940a).isEmpty() == true) goto L12;
                Iterator r14 = d.s(this.f25944d.f25940a).iterator();     // Catch: Exception -> L21
            L10:
                if (r14.hasNext() == false) goto L12;
                ((ApmAgent.IBatteryDataListener) r14.next()).onData(this.f25942b, this.f25941a, this.f25943c);     // Catch: Exception -> L21
            L18:
                if (d.r(this.f25944d.f25940a) == false) goto L25;
                s1.a.d(Constants.TAG_BATTERY_LOCAL, r10.toString());     // Catch: Exception -> L21
                return;
            L25:
                return;
            }
        }

        public a(d r10) {
            this.f25940a = r10;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r10, Intent r11) {
            long r12 = SystemClock.elapsedRealtime();
            if ((r12 - d.n(this.f25940a)) > (d.p(this.f25940a) * 1000)) goto L5;
            return;
        L5:
            if (d.q(this.f25940a) == false) goto L7;
        L8:
            d.o(this.f25940a, r12);
            AsyncEventManager.e().h(new RunnableC0409a(this, r11.getIntExtra(CommonServiceName.MONITOR_TYPE_TEMPERATURE, 0) / 10.0f, (r11.getIntExtra("level", 0) * 100.0f) / r11.getIntExtra("scale", 100), ActivityLifeObserver.getInstance().getTopActivityClassName()));
            return;
        L7:
            if (d.r(this.f25940a) == true) goto L8;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f25945a = null;

        static {
            f25945a = new d();
        }

        public static /* synthetic */ d a() {
            return f25945a;
        }
    }

    public d() {
        this.f25935j = false;
        this.f25937l = 60;
        this.f24971e = "battery";
    }

    public static /* synthetic */ long n(d r10) {
        return r10.f25938m;
    }

    public static /* synthetic */ long o(d r10, long r11) {
        r10.f25938m = r11;
        return r11;
    }

    public static /* synthetic */ int p(d r10) {
        return r10.f25937l;
    }

    public static /* synthetic */ boolean q(d r10) {
        return r10.f25935j;
    }

    public static /* synthetic */ boolean r(d r10) {
        return r10.f25936k;
    }

    public static /* synthetic */ List s(d r10) {
        return r10.f25939n;
    }

    public static d t() {
        return b.a();
    }

    @Override // v1.a
    public void b(JSONObject r10) {
        super.b(r10);
        boolean r11 = false;
        if (r10.optInt(SlardarSettingsConsts.PERF_KEY_BATTERY_TEMPERATURE_ENABLE_UPLOAD, 0) != 1) goto L5;
        r11 = true;
    L5:
        this.f25935j = r11;
        this.f25937l = r10.optInt(SlardarSettingsConsts.PERF_KEY_BATTERY_TEMPERATURE_UPLOAD_INTERVAL, 60);
        if (this.f25935j == false) goto L8;
        return;
    L8:
        if (this.f25936k == true) goto L12;
        ActivityLifeObserver.getInstance().unregister(this);
        w();
        return;
    }

    @Override // v1.a
    public boolean e() {
        return false;
    }

    @Override // v1.a
    public void g() {
        this.f25932g = new a(this);
        this.f25933h = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        v();
    }

    @Override // v1.a
    public long m() {
        return 0;
    }

    @Override // v1.a, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onBackground(Activity r10) {
        super.onBackground(r10);
        w();
    }

    @Override // v1.a, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onFront(Activity r10) {
        super.onFront(r10);
        v();
    }

    public void u(boolean r10) {
        this.f25936k = r10;
        c();
    }

    public final void v() {
        if (this.f25934i == false) goto L8;
        return;
    L8:
        w0.c.g().registerReceiver(this.f25932g, this.f25933h);     // Catch: Exception -> L7
        this.f25934i = true;     // Catch: Exception -> L7
        return;
    }

    public final void w() {
        if (this.f25934i == true) goto L8;
        return;
    L8:
        w0.c.g().unregisterReceiver(this.f25932g);     // Catch: Exception -> L7
        this.f25934i = false;     // Catch: Exception -> L7
        return;
    }
}
