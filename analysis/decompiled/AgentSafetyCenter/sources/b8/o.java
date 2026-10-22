package b8;

import io.modelcontextprotocol.common.McpTransportContext;
import io.modelcontextprotocol.json.TypeRef;
import io.modelcontextprotocol.server.McpAsyncServer;
import io.modelcontextprotocol.server.McpAsyncServerExchange;
import io.modelcontextprotocol.server.McpStatelessAsyncServer;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpStreamableServerSession;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Supplier;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class o implements Supplier {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1993c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f1994f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ String f1995g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f1996h;
    public /* synthetic */ Object i;

    public /* synthetic */ o(int i) {
        this.f1993c = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f1993c) {
            case 0:
                w7.l lVar = (w7.l) this.f1994f;
                String str = this.f1995g;
                String str2 = (String) this.f1996h;
                w7.f fVar = (w7.f) this.i;
                androidx.room.q qVar = lVar.f15333j;
                w7.l lVar2 = (w7.l) ((ConcurrentMap) qVar.f1604g).get(str);
                if (lVar2 == null) {
                    return i.m(lVar, qVar, str2).g();
                }
                int iIndexOf = str.indexOf("#");
                String strSubstring = str.substring(iIndexOf);
                String strSubstring2 = str.substring(0, iIndexOf);
                Iterator itDescendingIterator = fVar.f15312g.descendingIterator();
                while (itDescendingIterator.hasNext()) {
                    w7.l lVar3 = (w7.l) itDescendingIterator.next();
                    w7.a aVar = lVar3.i.f15339a;
                    String str3 = aVar != null ? aVar.f15287a : "";
                    if (!str3.equals(strSubstring2)) {
                        w7.l lVar4 = (w7.l) ((ConcurrentMap) lVar3.f15333j.f1604g).get(w7.n.d(lVar3.i, strSubstring));
                        if (lVar4 != null) {
                            lVar2 = lVar4;
                        }
                        strSubstring2 = str3;
                    }
                }
                return lVar2;
            case 1:
                return i.n((w7.l) this.f1994f, (androidx.room.q) this.i, this.f1995g, (String) this.f1996h);
            case 2:
                return ((McpAsyncServer) this.f1994f).lambda$resourcesReadRequestHandler$28(this.f1995g, (McpAsyncServerExchange) this.f1996h, (McpSchema.ReadResourceRequest) this.i);
            case 3:
                return ((McpStatelessAsyncServer) this.f1994f).lambda$resourcesReadRequestHandler$20(this.f1995g, (McpTransportContext) this.f1996h, (McpSchema.ReadResourceRequest) this.i);
            default:
                return ((McpStreamableServerSession) this.f1994f).lambda$sendRequest$0(this.f1995g, this.f1996h, (TypeRef) this.i);
        }
    }
}
