package b8;

import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpStreamableServerSession;
import io.modelcontextprotocol.spec.McpStreamableServerTransport;
import java.util.Locale;
import java.util.function.Function;
import reactor.util.context.ContextView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class f0 implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1957a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1958b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f1959c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f1960d;

    public /* synthetic */ f0(int i) {
        this.f1957a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f1957a) {
            case 0:
                i iVar = (i) this.f1958b;
                c8.a aVar = (c8.a) this.f1959c;
                w7.f fVar = (w7.f) this.f1960d;
                w7.j jVarJ = iVar.j();
                jVarJ.f15293d = aVar;
                jVarJ.f15291b = fVar.f15311f;
                String str = ((h0) obj).f1965a;
                jVarJ.i = str;
                jVarJ.f15319l = (Locale) fVar.f15306a.f7721f;
                jVarJ.f15290a = str;
                jVarJ.f15294e = new Object[]{iVar.f1955e.f15331g.toString()};
                return jVarJ.a();
            default:
                return ((McpStreamableServerSession) this.f1958b).lambda$responseStream$5((McpStreamableServerTransport) this.f1959c, (McpSchema.JSONRPCRequest) this.f1960d, (ContextView) obj);
        }
    }
}
