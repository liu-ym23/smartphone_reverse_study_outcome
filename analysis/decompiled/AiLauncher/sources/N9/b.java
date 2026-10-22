package N9;

import Z8.F;
import Z8.T;
import java.util.Map;
import kotlin.Pair;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f4892a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<String, c> f4893b;

    /* JADX WARN: Multi-variable type inference failed */
    public b(String className, Map<String, ? extends c> arguments) {
        kotlin.jvm.internal.p.i(className, "className");
        kotlin.jvm.internal.p.i(arguments, "arguments");
        this.f4892a = className;
        this.f4893b = arguments;
    }

    public static final CharSequence b(Pair pair) {
        kotlin.jvm.internal.p.i(pair, "<destruct>");
        return ((String) pair.a()) + " = " + ((c) pair.b());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return kotlin.jvm.internal.p.d(this.f4892a, bVar.f4892a) && kotlin.jvm.internal.p.d(this.f4893b, bVar.f4893b);
    }

    public int hashCode() {
        return (this.f4892a.hashCode() * 31) + this.f4893b.hashCode();
    }

    public String toString() {
        return '@' + this.f4892a + '(' + F.A0(T.E(this.f4893b), null, null, null, 0, null, a.f4891a, 31, null) + ')';
    }
}
