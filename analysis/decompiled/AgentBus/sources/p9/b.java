package p9;

import i8.n;
import v9.v;

/* loaded from: classes.dex */
public final class b extends a4.d {

    /* renamed from: g, reason: collision with root package name */
    public final n f8528g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public b(f8.b bVar, v vVar) {
        super(vVar);
        if (vVar == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "receiverType", "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver", "<init>"));
        }
        this.f8528g = (n) bVar;
    }

    public final String toString() {
        return getType() + ": Ext {" + this.f8528g + "}";
    }
}
