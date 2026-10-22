package a5;

import ab.r;
import ab.s;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import k5.t;
import w7.e0;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: g, reason: collision with root package name */
    public static final r f227g;

    /* renamed from: a, reason: collision with root package name */
    public final String f228a;

    /* renamed from: b, reason: collision with root package name */
    public final na.d f229b;

    /* renamed from: c, reason: collision with root package name */
    public final t f230c;

    /* renamed from: d, reason: collision with root package name */
    public final v4.a f231d;

    /* renamed from: e, reason: collision with root package name */
    public final z5.c f232e;

    /* renamed from: f, reason: collision with root package name */
    public final ab.t f233f;

    static {
        Pattern pattern = r.f597c;
        f227g = e0.x("application/json; charset=utf-8");
    }

    public f(String str, na.d dVar, k5.g gVar, v4.a aVar, long j2, z5.c cVar) {
        q7.k.e(str, "baseUrl");
        q7.k.e(gVar, "logger");
        this.f228a = str;
        this.f229b = dVar;
        this.f230c = gVar;
        this.f231d = aVar;
        this.f232e = cVar;
        s sVar = new s();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        sVar.a(j2, timeUnit);
        sVar.b(j2, timeUnit);
        sVar.d(j2, timeUnit);
        this.f233f = new ab.t(sVar);
    }
}
