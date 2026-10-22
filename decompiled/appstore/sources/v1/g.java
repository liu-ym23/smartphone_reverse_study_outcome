package v1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.bytedance.apm.constant.CommonServiceName;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BroadcastReceiver f25032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IntentFilter f25033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f25034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f25035d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f25036e;

    public class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f25037a;

        public a(g r10) {
            this.f25037a = r10;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r10, Intent r11) {
            if (r11 != null) goto L4;
            return;
        L4:
            g.a(this.f25037a, r11.getIntExtra(CommonServiceName.MONITOR_TYPE_TEMPERATURE, 0) / 10.0f);
            g.b(this.f25037a, r11.getIntExtra("status", 1));
            g.c(this.f25037a, r11.getIntExtra("plugged", -1));
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f25038a = null;

        static {
            f25038a = new g(null);
        }

        public static /* synthetic */ g a() {
            return f25038a;
        }
    }

    public /* synthetic */ g(a r10) {
        this();
    }

    public static /* synthetic */ float a(g r10, float r11) {
        r10.f25034c = r11;
        return r11;
    }

    public static /* synthetic */ int b(g r10, int r11) {
        r10.f25035d = r11;
        return r11;
    }

    public static /* synthetic */ int c(g r10, int r11) {
        r10.f25036e = r11;
        return r11;
    }

    public static g d() {
        return b.a();
    }

    public int e() {
        return this.f25035d;
    }

    public float f() {
        return this.f25034c;
    }

    public final void g() {
        this.f25032a = new a(this);
        this.f25033b = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    }

    public g() {
        g();
    }
}
