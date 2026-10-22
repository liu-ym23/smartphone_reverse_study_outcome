package f4;

import a6.h1;
import c5.u;
import java.util.Map;
import java.util.Set;
import k4.h0;
import k4.q;
import k4.w;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final h0 f2596a;

    /* renamed from: b, reason: collision with root package name */
    public final w f2597b;

    /* renamed from: c, reason: collision with root package name */
    public final q f2598c;
    public final n4.e d;

    /* renamed from: e, reason: collision with root package name */
    public final h1 f2599e;

    /* renamed from: f, reason: collision with root package name */
    public final r4.d f2600f;

    /* renamed from: g, reason: collision with root package name */
    public final Set f2601g;

    public d(h0 h0Var, w method, q qVar, n4.e eVar, h1 executionContext, r4.d attributes) {
        Set setKeySet;
        p.e(method, "method");
        p.e(executionContext, "executionContext");
        p.e(attributes, "attributes");
        this.f2596a = h0Var;
        this.f2597b = method;
        this.f2598c = qVar;
        this.d = eVar;
        this.f2599e = executionContext;
        this.f2600f = attributes;
        Map map = (Map) attributes.d(w3.f.f6192a);
        this.f2601g = (map == null || (setKeySet = map.keySet()) == null) ? u.f1094a : setKeySet;
    }

    public final String toString() {
        return "HttpRequestData(url=" + this.f2596a + ", method=" + this.f2597b + ')';
    }
}
