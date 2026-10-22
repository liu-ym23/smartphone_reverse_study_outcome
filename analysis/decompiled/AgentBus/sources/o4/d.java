package o4;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: f, reason: collision with root package name */
    public static final ab.r f7319f;

    /* renamed from: a, reason: collision with root package name */
    public final String f7320a;

    /* renamed from: b, reason: collision with root package name */
    public final k5.t f7321b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7322c;

    /* renamed from: d, reason: collision with root package name */
    public final String f7323d;

    /* renamed from: e, reason: collision with root package name */
    public final ab.t f7324e;

    static {
        Pattern pattern = ab.r.f597c;
        f7319f = w7.e0.x("application/json; charset=utf-8");
    }

    public d(String str, k5.t tVar, String str2, String str3) {
        ab.s sVar = new ab.s();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        sVar.a(15L, timeUnit);
        sVar.b(15L, timeUnit);
        sVar.d(15L, timeUnit);
        ab.t tVar2 = new ab.t(sVar);
        q7.k.e(tVar, "logger");
        this.f7320a = str;
        this.f7321b = tVar;
        this.f7322c = str2;
        this.f7323d = str3;
        this.f7324e = tVar2;
    }
}
