package E9;

import java.util.List;
import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public final class a extends c {

    /* renamed from: a, reason: collision with root package name */
    public final x9.b f496a;

    public a(x9.b serializer) {
        k.f(serializer, "serializer");
        this.f496a = serializer;
    }

    @Override // E9.c
    public final x9.b a(List typeArgumentsSerializers) {
        k.f(typeArgumentsSerializers, "typeArgumentsSerializers");
        return this.f496a;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && k.b(((a) obj).f496a, this.f496a);
    }

    public final int hashCode() {
        return this.f496a.hashCode();
    }
}
