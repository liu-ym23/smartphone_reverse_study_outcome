package i3;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.databind.PropertyName;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: f, reason: collision with root package name */
    public static final h f9510f = new h(PropertyName.f3754e, Object.class, null, false, null);

    /* renamed from: a, reason: collision with root package name */
    public final PropertyName f9511a;

    /* renamed from: b, reason: collision with root package name */
    public final Class<? extends ObjectIdGenerator<?>> f9512b;

    /* renamed from: c, reason: collision with root package name */
    public final Class<? extends com.fasterxml.jackson.annotation.a> f9513c;

    /* renamed from: d, reason: collision with root package name */
    public final Class<?> f9514d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f9515e;

    public h() {
        throw null;
    }

    /* JADX WARN: Incorrect type for immutable var: ssa=java.lang.Class<? extends com.fasterxml.jackson.annotation.a>, code=java.lang.Class, for r5v0, types: [java.lang.Class<? extends com.fasterxml.jackson.annotation.a>] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public h(com.fasterxml.jackson.databind.PropertyName r1, java.lang.Class<?> r2, java.lang.Class<? extends com.fasterxml.jackson.annotation.ObjectIdGenerator<?>> r3, boolean r4, java.lang.Class r5) {
        /*
            r0 = this;
            r0.<init>()
            r0.f9511a = r1
            r0.f9514d = r2
            r0.f9512b = r3
            r0.f9515e = r4
            if (r5 != 0) goto Lf
            java.lang.Class<com.fasterxml.jackson.annotation.b> r5 = com.fasterxml.jackson.annotation.b.class
        Lf:
            r0.f9513c = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.h.<init>(com.fasterxml.jackson.databind.PropertyName, java.lang.Class, java.lang.Class, boolean, java.lang.Class):void");
    }

    public final String toString() {
        return "ObjectIdInfo: propName=" + this.f9511a + ", scope=" + com.fasterxml.jackson.databind.util.a.y(this.f9514d) + ", generatorType=" + com.fasterxml.jackson.databind.util.a.y(this.f9512b) + ", alwaysAsId=" + this.f9515e;
    }
}
