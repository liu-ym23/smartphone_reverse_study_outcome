package X8;

import h8.InterfaceC1507O;
import h8.InterfaceC1524g;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes4.dex */
public final class G extends L {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ G(Object obj, int i) {
        this.c = i;
        this.d = obj;
    }

    @Override // X8.P
    public boolean a() {
        switch (this.c) {
            case 1:
                return false;
            default:
                return super.a();
        }
    }

    @Override // X8.P
    public boolean e() {
        switch (this.c) {
            case 1:
                return ((Map) this.d).isEmpty();
            default:
                return super.e();
        }
    }

    @Override // X8.L
    public final N g(K key) {
        switch (this.c) {
            case 0:
                kotlin.jvm.internal.k.f(key, "key");
                if (!((ArrayList) this.d).contains(key)) {
                    return null;
                }
                InterfaceC1524g interfaceC1524gD = key.d();
                kotlin.jvm.internal.k.d(interfaceC1524gD, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
                return S.j((InterfaceC1507O) interfaceC1524gD);
            default:
                kotlin.jvm.internal.k.f(key, "key");
                return (N) ((Map) this.d).get(key);
        }
    }
}
