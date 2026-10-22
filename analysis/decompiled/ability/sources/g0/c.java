package g0;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f4457a;
    public final long b;
    public long d;
    public long f;
    public long g;
    public StackTraceElement[] h;
    public StackTraceElement[] i;

    /* renamed from: j, reason: collision with root package name */
    public String f4458j;
    public String k;
    public JSONObject l;
    public JSONObject m;
    public long c = -1;
    public boolean e = false;

    public c(long j5, String str) {
        this.b = j5;
        this.f4457a = str;
    }

    public final c a() {
        c cVar = new c(this.b, this.f4457a);
        cVar.c = this.c;
        cVar.d = this.d;
        cVar.e = this.e;
        cVar.f = this.f;
        cVar.g = this.g;
        cVar.h = this.h;
        cVar.i = this.i;
        cVar.f4458j = this.f4458j;
        cVar.k = this.k;
        cVar.l = this.l;
        cVar.m = this.m;
        return cVar;
    }
}
