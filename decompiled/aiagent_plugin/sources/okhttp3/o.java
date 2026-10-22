package okhttp3;

import com.bytedance.security.zenmobile.io.SensitiveType;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: Credentials.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f40181a = null;

    static {
        f40181a = new o();
    }

    private o() {
    }

    public static final String a(String r1, String r2, Charset r3) {
        d.h.b.o.e(r1, "username");
        d.h.b.o.e(r2, SensitiveType.PASSWORD);
        d.h.b.o.e(r3, "charset");
        return "Basic " + e.h.f38722a.a(r1 + ':' + r2, r3).e();
    }
}
