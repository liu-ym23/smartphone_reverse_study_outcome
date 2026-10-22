package u3;

import java.util.List;
import k4.o;
import k4.t;
import kotlin.jvm.internal.h;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d extends UnsupportedOperationException {

    /* renamed from: a, reason: collision with root package name */
    public final String f5634a;

    public d(h4.c cVar, h hVar, v5.c cVar2) {
        StringBuilder sb = new StringBuilder("\n        Expected response body of the type '");
        sb.append(cVar2);
        sb.append("' but was '");
        sb.append(hVar);
        sb.append("'\n        In response from `");
        sb.append(b8.h.q(cVar).u());
        sb.append("`\n        Response status `");
        sb.append(cVar.g());
        sb.append("`\n        Response header `ContentType: ");
        o oVarA = cVar.a();
        List list = t.f3636a;
        sb.append(oVarA.d("Content-Type"));
        sb.append("` \n        Request header `Accept: ");
        sb.append(b8.h.q(cVar).a().d("Accept"));
        sb.append("`\n        \n        You can read how to resolve NoTransformationFoundException at FAQ: \n        https://ktor.io/docs/faq.html#no-transformation-found-exception\n    ");
        this.f5634a = x5.o.Q0(sb.toString());
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.f5634a;
    }
}
