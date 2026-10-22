package f4;

import io.ktor.utils.io.p;
import k4.q;
import k4.x;
import k4.y;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final y f2615a;

    /* renamed from: b, reason: collision with root package name */
    public final u4.d f2616b;

    /* renamed from: c, reason: collision with root package name */
    public final q f2617c;
    public final x d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f2618e;

    /* renamed from: f, reason: collision with root package name */
    public final f5.h f2619f;

    /* renamed from: g, reason: collision with root package name */
    public final u4.d f2620g;

    public g(y yVar, u4.d requestTime, q qVar, x version, p body, f5.h callContext) {
        kotlin.jvm.internal.p.e(requestTime, "requestTime");
        kotlin.jvm.internal.p.e(version, "version");
        kotlin.jvm.internal.p.e(body, "body");
        kotlin.jvm.internal.p.e(callContext, "callContext");
        this.f2615a = yVar;
        this.f2616b = requestTime;
        this.f2617c = qVar;
        this.d = version;
        this.f2618e = body;
        this.f2619f = callContext;
        this.f2620g = u4.a.a(null);
    }

    public final String toString() {
        return "HttpResponseData=(statusCode=" + this.f2615a + ')';
    }
}
