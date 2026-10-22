package od;

import java.util.List;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f22567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f22568c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f22569d;

    public c(String r10, long r11, long r12, List r13) {
        q.g(r10, "id");
        q.g(r13, "layers");
        this.f22566a = r10;
        this.f22567b = r11;
        this.f22568c = r12;
        this.f22569d = r13;
    }

    public final long a() {
        return this.f22568c;
    }

    public final String b() {
        return this.f22566a;
    }

    public final List c() {
        return this.f22569d;
    }

    public final long d() {
        return this.f22567b;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof c) == true) goto L8;
        return false;
    L8:
        c r11 = (c) r10;
        if (q.b(this.f22566a, r11.f22566a) == true) goto L12;
        return false;
    L12:
        if (this.f22567b == r11.f22567b) goto L15;
        return false;
    L15:
        if (this.f22568c == r11.f22568c) goto L18;
        return false;
    L18:
        if (q.b(this.f22569d, r11.f22569d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f22566a.hashCode() * 31) + Long.hashCode(this.f22567b)) * 31) + Long.hashCode(this.f22568c)) * 31) + this.f22569d.hashCode();
    }

    public String toString() {
        return "EffectStage(id=" + this.f22566a + ", startMs=" + this.f22567b + ", durationMs=" + this.f22568c + ", layers=" + this.f22569d + ')';
    }
}
