package l6;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ttnet.config.IImageStrategy;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c implements IImageStrategy {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile c f21870f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f21871g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile SharedPreferences f21872h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Context f21873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile int f21874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile long f21875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile int f21876d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile int f21877e;

    static {
        f21871g = new Object();
    }

    public c(Context r10) {
        if (r10 == null) goto L5;
        this.f21873a = r10.getApplicationContext();
    L5:
        d();
    }

    public static c a(Context r10) {
        if (f21870f != null) goto L16;
        Object r11 = f21871g;
        monitor-enter(r11);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f21870f != null) goto L11;
        f21870f = new c(r10);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r11);     // Catch: Throwable -> L9
    L16:
        return f21870f;
    }

    public static c b() {
        return f21870f;
    }

    public final SharedPreferences c() {
        if (f21872h != null) goto L6;
        f21872h = this.f21873a.getSharedPreferences("image_opt_table", 0);
    L6:
        return f21872h;
    }

    public final void d() {
        SharedPreferences r10 = c();     // Catch: Throwable -> L4
        this.f21874b = r10.getInt("image_opt_switch", 0);     // Catch: Throwable -> L4
        this.f21875c = r10.getLong("image_opt_black_interval", 0);     // Catch: Throwable -> L4
        this.f21876d = r10.getInt("image_opt_failed_times", 0);     // Catch: Throwable -> L4
        this.f21877e = r10.getInt("image_opt_limit_count", 0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void e(JSONObject r12) {
        if (r12 == null) goto L27;
    L10:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        if (r12.length() <= 0) goto L28;
        int r10 = r12.optInt("image_opt_switch", 0);     // Catch: Throwable -> L10
        long r11 = r12.optLong("image_opt_black_interval", 0);     // Catch: Throwable -> L10
        int r13 = r12.optInt("image_opt_failed_times", 0);     // Catch: Throwable -> L10
        int r14 = r12.optInt("image_opt_limit_count", 0);     // Catch: Throwable -> L10
        SharedPreferences.Editor r15 = c().edit();     // Catch: Throwable -> L10
        if (r10 == this.f21874b) goto L13;
        r15.putInt("image_opt_switch", r10);     // Catch: Throwable -> L10
    L13:
        if (r11 == this.f21875c) goto L16;
        r15.putLong("image_opt_black_interval", r11);     // Catch: Throwable -> L10
    L16:
        if (r13 == this.f21876d) goto L19;
        r15.putInt("image_opt_failed_times", r13);     // Catch: Throwable -> L10
    L19:
        if (r14 == this.f21877e) goto L21;
        r15.putInt("image_opt_limit_count", r14);     // Catch: Throwable -> L10
    L21:
        r15.apply();     // Catch: Throwable -> L10
        this.f21874b = r10;     // Catch: Throwable -> L10
        this.f21875c = r11;     // Catch: Throwable -> L10
        this.f21876d = r13;     // Catch: Throwable -> L10
        this.f21877e = r14;     // Catch: Throwable -> L10
        return;
    L28:
        return;
    }

    @Override // com.bytedance.ttnet.config.IImageStrategy
    public int getFailedTimes() {
        return this.f21876d;
    }

    @Override // com.bytedance.ttnet.config.IImageStrategy
    public long getHostInBlackInterval() {
        return this.f21875c;
    }

    @Override // com.bytedance.ttnet.config.IImageStrategy
    public int getLimitImageNumbers() {
        return this.f21877e;
    }

    @Override // com.bytedance.ttnet.config.IImageStrategy
    public NetworkUtils.NetworkType getNetWorkType() {
        return NetworkUtils.f(this.f21873a);
    }

    @Override // com.bytedance.ttnet.config.IImageStrategy
    public int getSwitch() {
        return this.f21874b;
    }

    @Override // com.bytedance.ttnet.config.IImageStrategy
    public List getUrlListForUrl(String r10) {
        return null;
    }
}
