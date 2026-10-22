package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;

/* loaded from: classes5.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    public static final d f35871b = new d(true);

    /* renamed from: a, reason: collision with root package name */
    public final Map<a, GeneratedMessageLite.e<?, ?>> f35872a;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Object f35873a;

        /* renamed from: b, reason: collision with root package name */
        public final int f35874b;

        public a(Object obj, int i10) {
            this.f35873a = obj;
            this.f35874b = i10;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f35873a == aVar.f35873a && this.f35874b == aVar.f35874b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f35873a) * 65535) + this.f35874b;
        }
    }

    public d() {
        this.f35872a = new HashMap();
    }

    public static d c() {
        return f35871b;
    }

    public static d d() {
        return new d();
    }

    public final void a(GeneratedMessageLite.e<?, ?> eVar) {
        this.f35872a.put(new a(eVar.b(), eVar.d()), eVar);
    }

    public <ContainingType extends h> GeneratedMessageLite.e<ContainingType, ?> b(ContainingType containingtype, int i10) {
        return (GeneratedMessageLite.e) this.f35872a.get(new a(containingtype, i10));
    }

    public d(boolean z10) {
        this.f35872a = Collections.EMPTY_MAP;
    }
}
