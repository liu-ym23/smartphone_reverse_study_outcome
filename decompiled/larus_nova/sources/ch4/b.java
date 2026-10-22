package ch4;

import android.os.SystemClock;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static b f23762d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f23763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f23764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f23765c;

    public b() {
        this.f23763a = new JSONObject();
        long r100 = SystemClock.uptimeMillis();
        this.f23764b = r100;
        this.f23765c = r100;
    }

    public static void a(String r100) {
        if (f23762d != null) goto L8;
        return;
    L8:
        long r101 = SystemClock.uptimeMillis();     // Catch: Throwable -> L7
        b r102 = f23762d;     // Catch: Throwable -> L7
        r102.f23763a.put(r100, r101 - r102.f23765c);     // Catch: Throwable -> L7
        f23762d.f23765c = r101;     // Catch: Throwable -> L7
        return;
    }
}
