package D8;

import D7.v;
import com.fasterxml.jackson.core.JsonPointer;
import java.util.LinkedList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Triple;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable;

/* loaded from: classes4.dex */
public final class g implements f {

    /* renamed from: a, reason: collision with root package name */
    public final ProtoBuf$StringTable f432a;
    public final ProtoBuf$QualifiedNameTable b;

    public g(ProtoBuf$StringTable strings, ProtoBuf$QualifiedNameTable qualifiedNames) {
        kotlin.jvm.internal.k.f(strings, "strings");
        kotlin.jvm.internal.k.f(qualifiedNames, "qualifiedNames");
        this.f432a = strings;
        this.b = qualifiedNames;
    }

    @Override // D8.f
    public final boolean a(int i) {
        return ((Boolean) c(i).c).booleanValue();
    }

    @Override // D8.f
    public final String b(int i) {
        Triple tripleC = c(i);
        List list = (List) tripleC.f4891a;
        String strI0 = v.I0((List) tripleC.b, ".", null, null, null, 62);
        if (list.isEmpty()) {
            return strI0;
        }
        return v.I0(list, "/", null, null, null, 62) + JsonPointer.SEPARATOR + strI0;
    }

    public final Triple c(int i) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        boolean z10 = false;
        while (i != -1) {
            ProtoBuf$QualifiedNameTable.QualifiedName qualifiedName = (ProtoBuf$QualifiedNameTable.QualifiedName) this.b.b.get(i);
            String str = (String) this.f432a.b.get(qualifiedName.d);
            ProtoBuf$QualifiedNameTable.QualifiedName.Kind kind = qualifiedName.e;
            kotlin.jvm.internal.k.c(kind);
            int iOrdinal = kind.ordinal();
            if (iOrdinal == 0) {
                linkedList2.addFirst(str);
            } else if (iOrdinal == 1) {
                linkedList.addFirst(str);
            } else {
                if (iOrdinal != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                linkedList2.addFirst(str);
                z10 = true;
            }
            i = qualifiedName.c;
        }
        return new Triple(linkedList, linkedList2, Boolean.valueOf(z10));
    }

    @Override // D8.f
    public final String getString(int i) {
        String str = (String) this.f432a.b.get(i);
        kotlin.jvm.internal.k.e(str, "getString(...)");
        return str;
    }
}
