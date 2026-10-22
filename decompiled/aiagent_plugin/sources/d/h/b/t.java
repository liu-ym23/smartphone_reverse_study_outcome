package d.h.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PackageReference.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class t implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<?> f38496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f38497b;

    public t(Class<?> r2, String r3) {
        o.e(r2, "jClass");
        o.e(r3, "moduleName");
        this.f38496a = r2;
        this.f38497b = r3;
    }

    @Override // d.h.b.e
    public Class<?> a() {
        return this.f38496a;
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, t.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (o.a(a(), ((t) ZeusTransformUtils.preCheckCast(r3, t.class, "com.obric.aiagent.plugin")).a()) == false) goto L7;
        return true;
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
