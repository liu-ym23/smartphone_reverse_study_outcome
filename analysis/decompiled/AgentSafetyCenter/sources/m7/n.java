package m7;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import p7.q;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class n {
    public final Object fromJson(Reader reader) {
        return read(new u7.a(reader));
    }

    public final Object fromJsonTree(g gVar) {
        try {
            p7.o oVar = new p7.o(p7.o.f9881x);
            oVar.f9883t = new Object[32];
            oVar.f9884u = 0;
            oVar.f9885v = new String[32];
            oVar.f9886w = new int[32];
            oVar.n0(gVar);
            return read(oVar);
        } catch (IOException e10) {
            throw new h(e10);
        }
    }

    public final n nullSafe() {
        if (this instanceof m) {
            return this;
        }
        m mVar = new m();
        mVar.f8268a = this;
        VarHandle.storeStoreFence();
        return mVar;
    }

    public abstract Object read(u7.a aVar);

    public final String toJson(Object obj) {
        StringBuilder sb2 = new StringBuilder();
        try {
            toJson(o7.h.n(sb2), obj);
            return sb2.toString();
        } catch (IOException e10) {
            throw new h(e10);
        }
    }

    public final g toJsonTree(Object obj) {
        try {
            q qVar = new q(q.f9887v);
            ArrayList arrayList = new ArrayList();
            qVar.f9889s = arrayList;
            qVar.f9891u = i.f8265c;
            VarHandle.storeStoreFence();
            write(qVar, obj);
            if (arrayList.isEmpty()) {
                return qVar.f9891u;
            }
            throw new IllegalStateException("Expected one JSON element but was " + arrayList);
        } catch (IOException e10) {
            throw new h(e10);
        }
    }

    public abstract void write(u7.c cVar, Object obj);

    public final Object fromJson(String str) {
        return fromJson(new StringReader(str));
    }

    public final void toJson(Writer writer, Object obj) {
        write(new u7.c(writer), obj);
    }
}
