package l8;

import h8.C1515X;
import h8.C1516Y;
import h8.C1517Z;
import h8.c0;
import h8.d0;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.internal.k;

/* renamed from: l8.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1664a extends d0 {
    public static final C1664a c = new C1664a("package", false);

    @Override // h8.d0
    public final Integer a(d0 visibility) {
        k.f(visibility, "visibility");
        if (this == visibility) {
            return 0;
        }
        MapBuilder mapBuilder = c0.f4579a;
        return (visibility == C1515X.c || visibility == C1516Y.c) ? 1 : -1;
    }

    @Override // h8.d0
    public final String b() {
        return "public/*package*/";
    }

    @Override // h8.d0
    public final d0 c() {
        return C1517Z.c;
    }
}
