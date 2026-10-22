package kotlin.reflect.jvm.internal.impl.load.kotlin;

import ea.InterfaceC4020d;
import fa.AbstractC4067d;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;

/* loaded from: classes5.dex */
public final class g {

    /* renamed from: b, reason: collision with root package name */
    public static final a f35201b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f35202a;

    public static final class a {
        public /* synthetic */ a(i iVar) {
            this();
        }

        public final g a(String name, String desc) {
            p.i(name, "name");
            p.i(desc, "desc");
            return new g(name + '#' + desc, null);
        }

        public final g b(AbstractC4067d signature) {
            p.i(signature, "signature");
            if (signature instanceof AbstractC4067d.b) {
                AbstractC4067d.b bVar = (AbstractC4067d.b) signature;
                return d(bVar.e(), bVar.d());
            }
            if (!(signature instanceof AbstractC4067d.a)) {
                throw new NoWhenBranchMatchedException();
            }
            AbstractC4067d.a aVar = (AbstractC4067d.a) signature;
            return a(aVar.e(), aVar.d());
        }

        public final g c(InterfaceC4020d nameResolver, JvmProtoBuf.JvmMethodSignature signature) {
            p.i(nameResolver, "nameResolver");
            p.i(signature, "signature");
            return d(nameResolver.getString(signature.v()), nameResolver.getString(signature.u()));
        }

        public final g d(String name, String desc) {
            p.i(name, "name");
            p.i(desc, "desc");
            return new g(name + desc, null);
        }

        public final g e(g signature, int i10) {
            p.i(signature, "signature");
            return new g(signature.a() + '@' + i10, null);
        }

        public a() {
        }
    }

    public /* synthetic */ g(String str, i iVar) {
        this(str);
    }

    public final String a() {
        return this.f35202a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g) && p.d(this.f35202a, ((g) obj).f35202a);
    }

    public int hashCode() {
        return this.f35202a.hashCode();
    }

    public String toString() {
        return "MemberSignature(signature=" + this.f35202a + ')';
    }

    public g(String str) {
        this.f35202a = str;
    }
}
