package E9;

import Ca.h;
import java.util.List;
import java.util.Map;
import kotlin.Pair;

/* renamed from: E9.z, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0820z<Type extends Ca.h> extends g0<Type> {

    /* renamed from: a, reason: collision with root package name */
    public final List<Pair<ga.e, Type>> f2491a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<ga.e, Type> f2492b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public C0820z(List<? extends Pair<ga.e, ? extends Type>> underlyingPropertyNamesToTypes) {
        super(null);
        kotlin.jvm.internal.p.i(underlyingPropertyNamesToTypes, "underlyingPropertyNamesToTypes");
        this.f2491a = underlyingPropertyNamesToTypes;
        this.f2492b = kotlin.collections.a.y(c());
    }

    @Override // E9.g0
    public boolean a(ga.e name) {
        kotlin.jvm.internal.p.i(name, "name");
        return this.f2492b.containsKey(name);
    }

    public List<Pair<ga.e, Type>> c() {
        return this.f2491a;
    }

    public String toString() {
        return "MultiFieldValueClassRepresentation(underlyingPropertyNamesToTypes=" + c() + ')';
    }
}
