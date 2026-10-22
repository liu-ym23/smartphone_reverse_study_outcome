package x9;

import d7.b0;
import d7.z;
import f8.n0;
import f8.o;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import m.x;
import o9.n;
import q7.k;

/* loaded from: classes.dex */
public class e implements n {

    /* renamed from: b, reason: collision with root package name */
    public final String f11291b;

    public e(int i2, String... strArr) {
        String str;
        x.t(i2, "kind");
        k.e(strArr, "formatParams");
        switch (i2) {
            case 1:
                str = "No member resolution should be done on captured type, it used only during constraint system resolution";
                break;
            case 2:
                str = "Scope for integer literal type (%s)";
                break;
            case 3:
                str = "Error scope for erased receiver type";
                break;
            case 4:
                str = "Scope for abbreviation %s";
                break;
            case 5:
                str = "Scope for stub type %s";
                break;
            case 6:
                str = "A scope for common supertype which is not a normal classifier";
                break;
            case 7:
                str = "Scope for error type %s";
                break;
            case 8:
                str = "Scope for unsupported type %s";
                break;
            case 9:
                str = "Error scope for class %s with arguments: %s";
                break;
            case 10:
                str = "Error resolution candidate for call %s";
                break;
            default:
                throw null;
        }
        Object[] objArrCopyOf = Arrays.copyOf(strArr, strArr.length);
        this.f11291b = String.format(str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
    }

    @Override // o9.q
    public f8.g b(e9.f fVar, n8.a aVar) {
        k.e(fVar, "name");
        k.e(aVar, "location");
        return new a(e9.f.g(String.format("<Error class: %s>", Arrays.copyOf(new Object[]{fVar}, 1))));
    }

    @Override // o9.n
    public Set c() {
        return b0.f2947f;
    }

    @Override // o9.n
    public Set d() {
        return b0.f2947f;
    }

    @Override // o9.q
    public Collection e(o9.f fVar, p7.k kVar) {
        k.e(fVar, "kindFilter");
        k.e(kVar, "nameFilter");
        return z.f2978f;
    }

    @Override // o9.n
    public Set g() {
        return b0.f2947f;
    }

    @Override // o9.q
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public Set f(e9.f fVar, n8.a aVar) {
        k.e(fVar, "name");
        a aVar2 = i.f11325c;
        k.e(aVar2, "containingDeclaration");
        b bVar = new b(aVar2, null, g8.h.f3888a, e9.f.g("<Error function>"), 1, n0.f3487b);
        f fVarC = i.c(h.f11304j, new String[0]);
        f8.n nVar = o.f3492e;
        z zVar = z.f2978f;
        bVar.L0(null, null, zVar, zVar, zVar, fVarC, 3, nVar);
        return ib.k.S(bVar);
    }

    @Override // o9.n
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public Set a(e9.f fVar, n8.c cVar) {
        k.e(fVar, "name");
        return i.f11328f;
    }

    public String toString() {
        return a1.a.l(new StringBuilder("ErrorScope{"), this.f11291b, '}');
    }
}
