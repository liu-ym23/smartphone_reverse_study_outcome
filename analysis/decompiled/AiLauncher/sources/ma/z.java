package ma;

import E9.InterfaceC0819y;
import java.util.List;
import ya.S;

/* loaded from: classes5.dex */
public final class z extends C4922b {

    /* renamed from: c, reason: collision with root package name */
    public final S f37209c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(List<? extends AbstractC4927g<?>> value, S type) {
        super(value, new y(type));
        kotlin.jvm.internal.p.i(value, "value");
        kotlin.jvm.internal.p.i(type, "type");
        this.f37209c = type;
    }

    public static final S c(S s10, InterfaceC0819y it) {
        kotlin.jvm.internal.p.i(it, "it");
        return s10;
    }

    public final S e() {
        return this.f37209c;
    }
}
