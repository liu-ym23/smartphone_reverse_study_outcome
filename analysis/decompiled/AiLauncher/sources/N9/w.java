package N9;

import kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementLevel;
import kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementVersionKind;

/* loaded from: classes5.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public KmVersionRequirementVersionKind f5029a;

    /* renamed from: b, reason: collision with root package name */
    public KmVersionRequirementLevel f5030b;

    /* renamed from: c, reason: collision with root package name */
    public Integer f5031c;

    /* renamed from: d, reason: collision with root package name */
    public String f5032d;

    /* renamed from: e, reason: collision with root package name */
    public v f5033e;

    public final KmVersionRequirementVersionKind a() {
        KmVersionRequirementVersionKind kmVersionRequirementVersionKind = this.f5029a;
        if (kmVersionRequirementVersionKind != null) {
            return kmVersionRequirementVersionKind;
        }
        kotlin.jvm.internal.p.A("kind");
        return null;
    }

    public final KmVersionRequirementLevel b() {
        KmVersionRequirementLevel kmVersionRequirementLevel = this.f5030b;
        if (kmVersionRequirementLevel != null) {
            return kmVersionRequirementLevel;
        }
        kotlin.jvm.internal.p.A("level");
        return null;
    }

    public final v c() {
        v vVar = this.f5033e;
        if (vVar != null) {
            return vVar;
        }
        kotlin.jvm.internal.p.A("version");
        return null;
    }

    public final void d(Integer num) {
        this.f5031c = num;
    }

    public final void e(KmVersionRequirementVersionKind kmVersionRequirementVersionKind) {
        kotlin.jvm.internal.p.i(kmVersionRequirementVersionKind, "<set-?>");
        this.f5029a = kmVersionRequirementVersionKind;
    }

    public final void f(KmVersionRequirementLevel kmVersionRequirementLevel) {
        kotlin.jvm.internal.p.i(kmVersionRequirementLevel, "<set-?>");
        this.f5030b = kmVersionRequirementLevel;
    }

    public final void g(String str) {
        this.f5032d = str;
    }

    public final void h(v vVar) {
        kotlin.jvm.internal.p.i(vVar, "<set-?>");
        this.f5033e = vVar;
    }

    public String toString() {
        return "KmVersionRequirement(kind=" + a() + ", level=" + b() + ", version=" + c() + ", errorCode=" + this.f5031c + ", message=" + this.f5032d + ')';
    }
}
