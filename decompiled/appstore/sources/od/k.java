package od;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f22594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f22595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f22596d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f22597e;

    public k(String r10, int r11, long r12, g r13, List r14) {
        q.g(r10, "id");
        q.g(r13, "loop");
        q.g(r14, "stages");
        this.f22593a = r10;
        this.f22594b = r11;
        this.f22595c = r12;
        this.f22596d = r13;
        this.f22597e = r14;
    }

    public final long a() {
        return this.f22595c;
    }

    public final String b() {
        return this.f22593a;
    }

    public final g c() {
        return this.f22596d;
    }

    public final List d() {
        return this.f22597e;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof k) == true) goto L8;
        return false;
    L8:
        k r11 = (k) r10;
        if (q.b(this.f22593a, r11.f22593a) == true) goto L12;
        return false;
    L12:
        if (this.f22594b == r11.f22594b) goto L15;
        return false;
    L15:
        if (this.f22595c == r11.f22595c) goto L18;
        return false;
    L18:
        if (q.b(this.f22596d, r11.f22596d) == true) goto L21;
        return false;
    L21:
        if (q.b(this.f22597e, r11.f22597e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.f22593a.hashCode() * 31) + Integer.hashCode(this.f22594b)) * 31) + Long.hashCode(this.f22595c)) * 31) + this.f22596d.hashCode()) * 31) + this.f22597e.hashCode();
    }

    public String toString() {
        return "TextEffectSpec(id=" + this.f22593a + ", version=" + this.f22594b + ", durationMs=" + this.f22595c + ", loop=" + this.f22596d + ", stages=" + this.f22597e + ')';
    }

    public /* synthetic */ k(String r10, int r11, long r12, g r13, List r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 2) == 0) goto L5;
        r11 = 1;
    L5:
        int r17 = r11;
        if ((r15 & 8) == 0) goto L8;
        r13 = g.b.f22582a;
    L8:
        this(r10, r17, r12, r13, r14);
    }
}
