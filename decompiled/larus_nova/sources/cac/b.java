package cac;

import android.os.SystemClock;
import com.bytedance.lark.sdk.Sdk;
import com.bytedance.lark.sdk.d;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements cac.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f22982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f22983b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f22984a = null;

        static {
            f22984a = new b();
        }
    }

    public b() {
    }

    @Override // cac.a
    public final long a(long r100) {
        if (this.f22982a != 0) goto L5;
    L9:
        Map<Long, se6.b> r101 = d.f254138e;
        this.f22982a = Sdk._getNtpTime();
        this.f22983b = SystemClock.elapsedRealtime();
        return this.f22982a;
    L5:
        if ((SystemClock.elapsedRealtime() - this.f22983b) > r100) goto L9;
        return this.f22982a + (SystemClock.elapsedRealtime() - this.f22983b);
    }
}
