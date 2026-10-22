package io.modelcontextprotocol.server;

import io.modelcontextprotocol.common.McpTransportContext;
import io.modelcontextprotocol.json.TypeRef;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpStreamableServerSession;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Supplier;
import u3.C2035a;
import z3.C2163h;

/* loaded from: classes3.dex */
public final /* synthetic */ class m implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4713a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ m(Object obj, String str, Object obj2, Object obj3, int i) {
        this.f4713a = i;
        this.d = obj;
        this.b = str;
        this.e = obj2;
        this.c = obj3;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f4713a) {
            case 0:
                return ((McpAsyncServer) this.d).lambda$resourcesReadRequestHandler$28(this.b, (McpAsyncServerExchange) this.e, (McpSchema.ReadResourceRequest) this.c);
            case 1:
                return ((McpStatelessAsyncServer) this.d).lambda$resourcesReadRequestHandler$20(this.b, (McpTransportContext) this.e, (McpSchema.ReadResourceRequest) this.c);
            case 2:
                return ((McpStreamableServerSession) this.d).lambda$sendRequest$0(this.b, this.e, (TypeRef) this.c);
            case 3:
                u3.i iVar = (u3.i) this.d;
                String str = (String) this.e;
                u3.f fVar = (u3.f) this.c;
                G6.c cVar = iVar.f6703j;
                ConcurrentMap concurrentMap = (ConcurrentMap) cVar.g;
                String str2 = this.b;
                u3.i iVar2 = (u3.i) concurrentMap.get(str2);
                if (iVar2 == null) {
                    return C2163h.m(iVar, cVar, str).d();
                }
                int iIndexOf = str2.indexOf("#");
                String strSubstring = str2.substring(iIndexOf);
                String strSubstring2 = str2.substring(0, iIndexOf);
                Iterator itDescendingIterator = fVar.g.descendingIterator();
                while (itDescendingIterator.hasNext()) {
                    u3.i iVar3 = (u3.i) itDescendingIterator.next();
                    C2035a c2035a = iVar3.i.f6704a;
                    String str3 = c2035a != null ? c2035a.f6694a : "";
                    if (!str3.equals(strSubstring2)) {
                        u3.i iVar4 = (u3.i) ((ConcurrentMap) iVar3.f6703j.g).get(u3.j.d(iVar3.i, strSubstring));
                        if (iVar4 != null) {
                            iVar2 = iVar4;
                        }
                        strSubstring2 = str3;
                    }
                }
                return iVar2;
            default:
                return C2163h.n((u3.i) this.d, (G6.c) this.e, this.b, (String) this.c);
        }
    }

    public /* synthetic */ m(u3.i iVar, G6.c cVar, String str, String str2) {
        this.f4713a = 4;
        this.d = iVar;
        this.e = cVar;
        this.b = str;
        this.c = str2;
    }
}
