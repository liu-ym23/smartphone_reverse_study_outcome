package Fa;

import Z8.C1173v;
import Z8.C1174w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes5.dex */
public abstract class e<K, T> extends AbstractC0821a<K, T> {

    /* renamed from: a, reason: collision with root package name */
    public c<T> f2636a;

    public e(c<T> arrayMap) {
        kotlin.jvm.internal.p.i(arrayMap, "arrayMap");
        this.f2636a = arrayMap;
    }

    @Override // Fa.AbstractC0821a
    public final c<T> b() {
        return this.f2636a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // Fa.AbstractC0821a
    public final void e(String keyQualifiedName, T value) {
        kotlin.jvm.internal.p.i(keyQualifiedName, "keyQualifiedName");
        kotlin.jvm.internal.p.i(value, "value");
        int iE = c().e(keyQualifiedName);
        int iB = this.f2636a.b();
        if (iB == 0) {
            c<T> cVar = this.f2636a;
            if (!(cVar instanceof i)) {
                throw new IllegalStateException(i(cVar, 0, "EmptyArrayMap"));
            }
            this.f2636a = new o(value, iE);
            return;
        }
        if (iB == 1) {
            c<T> cVar2 = this.f2636a;
            try {
                kotlin.jvm.internal.p.g(cVar2, "null cannot be cast to non-null type org.jetbrains.kotlin.util.OneElementArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>");
                o oVar = (o) cVar2;
                if (oVar.e() == iE) {
                    this.f2636a = new o(value, iE);
                    return;
                } else {
                    d dVar = new d();
                    dVar.c(oVar.e(), oVar.f());
                    this.f2636a = dVar;
                }
            } catch (ClassCastException e10) {
                throw new IllegalStateException(i(cVar2, 1, "OneElementArrayMap"), e10);
            }
        }
        this.f2636a.c(iE, value);
    }

    public final String i(c<T> cVar, int i10, String str) {
        T next;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Race condition happened, the size of ArrayMap is " + i10 + " but it isn't an `" + str + '`');
        sb2.append('\n');
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Type: ");
        sb3.append(cVar.getClass());
        sb2.append(sb3.toString());
        sb2.append('\n');
        StringBuilder sb4 = new StringBuilder();
        Map<String, Integer> mapB = c().b();
        sb4.append("[");
        sb4.append('\n');
        ArrayList arrayList = new ArrayList(C1174w.x(cVar, 10));
        int i11 = 0;
        for (T t10 : cVar) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                C1173v.w();
            }
            Iterator<T> it = mapB.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((Number) ((Map.Entry) next).getValue()).intValue() == i11) {
                    break;
                }
            }
            sb4.append("  " + ((Map.Entry) next) + '[' + i11 + "]: " + t10);
            sb4.append('\n');
            arrayList.add(sb4);
            i11 = i12;
        }
        sb4.append("]");
        sb4.append('\n');
        sb2.append("Content: " + sb4.toString());
        sb2.append('\n');
        return sb2.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public e() {
        i iVar = i.f2649a;
        kotlin.jvm.internal.p.g(iVar, "null cannot be cast to non-null type org.jetbrains.kotlin.util.ArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>");
        this(iVar);
    }
}
