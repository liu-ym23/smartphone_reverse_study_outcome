package O8;

import O8.h;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class g implements h.c {

    /* renamed from: a, reason: collision with root package name */
    public final Pattern f5267a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f5268b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f5269c;

    /* renamed from: d, reason: collision with root package name */
    public final String f5270d;

    /* renamed from: e, reason: collision with root package name */
    public final h.a f5271e;

    public g(Pattern pattern, boolean z10, boolean z11, String str, h.a aVar) {
        this.f5267a = pattern;
        this.f5268b = z10;
        this.f5269c = z11;
        this.f5270d = str;
        this.f5271e = aVar;
    }

    @Override // O8.h.c
    public String a() {
        return this.f5270d;
    }

    @Override // O8.h.c
    public boolean c() {
        return this.f5269c;
    }

    @Override // O8.h.c
    public h.a d() {
        return this.f5271e;
    }

    @Override // O8.h.c
    public Pattern e() {
        return this.f5267a;
    }

    @Override // O8.h.c
    public boolean f() {
        return this.f5268b;
    }

    public String toString() {
        return k.b(this);
    }
}
