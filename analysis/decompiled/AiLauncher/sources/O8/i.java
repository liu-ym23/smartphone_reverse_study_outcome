package O8;

import O8.h;
import java.util.List;

/* loaded from: classes4.dex */
public class i implements h.d {

    /* renamed from: a, reason: collision with root package name */
    public final String f5273a;

    /* renamed from: b, reason: collision with root package name */
    public final List<? extends h.b> f5274b;

    /* renamed from: c, reason: collision with root package name */
    public final String f5275c;

    /* renamed from: d, reason: collision with root package name */
    public final String f5276d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f5277e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f5278f;

    public i(String str, List<? extends h.b> list, String str2, String str3, boolean z10, boolean z11) {
        this.f5273a = str;
        this.f5274b = list;
        this.f5275c = str2;
        this.f5276d = str3;
        this.f5277e = z10;
        this.f5278f = z11;
    }

    @Override // O8.h.d
    public String a() {
        return this.f5275c;
    }

    @Override // O8.h.d
    public List<? extends h.b> b() {
        return this.f5274b;
    }

    @Override // O8.h.d
    public boolean c() {
        return this.f5277e;
    }

    @Override // O8.h.b
    public int d() {
        return this.f5276d.length();
    }

    @Override // O8.h.b
    public final boolean e() {
        return true;
    }

    public String toString() {
        return "SyntaxImpl{type='" + this.f5273a + "', children=" + this.f5274b + ", alias='" + this.f5275c + "', matchedString='" + this.f5276d + "', greedy=" + this.f5277e + ", tokenized=" + this.f5278f + '}';
    }

    @Override // O8.h.d
    public String type() {
        return this.f5273a;
    }
}
