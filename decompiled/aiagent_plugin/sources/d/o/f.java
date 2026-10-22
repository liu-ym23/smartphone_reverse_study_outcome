package d.o;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Regex.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f38636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.l.j f38637b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
        return false;
    L8:
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f38636a, r6.f38636a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f38637b, r6.f38637b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f38636a.hashCode() * 31) + this.f38637b.hashCode();
    }

    public String toString() {
        return "MatchGroup(value=" + this.f38636a + ", range=" + this.f38637b + ')';
    }

    public f(String r2, d.l.j r3) {
        d.h.b.o.e(r2, "value");
        d.h.b.o.e(r3, "range");
        this.f38636a = r2;
        this.f38637b = r3;
    }

    public final String a() {
        return this.f38636a;
    }
}
