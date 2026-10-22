package O9;

import kotlin.jvm.internal.p;
import w9.InterfaceC5751j;
import w9.InterfaceC5752k;

/* loaded from: classes5.dex */
public final class a<Node> {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC5751j<Node, Integer> f5283a;

    /* renamed from: b, reason: collision with root package name */
    public final c f5284b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5285c;

    public a(InterfaceC5751j<Node, Integer> flags, c flag) {
        p.i(flags, "flags");
        p.i(flag, "flag");
        this.f5283a = flags;
        this.f5284b = flag;
        if (flag.a() == 1 && flag.c() == 1) {
            this.f5285c = 1 << flag.b();
            return;
        }
        throw new IllegalArgumentException(("BooleanFlagDelegate can work only with boolean flags (bitWidth = 1 and value = 1), but " + flag + " was passed").toString());
    }

    public final boolean a(Node node, InterfaceC5752k<?> property) {
        p.i(property, "property");
        return this.f5284b.d(this.f5283a.get(node).intValue());
    }

    public final void b(Node node, InterfaceC5752k<?> property, boolean z10) {
        p.i(property, "property");
        int iIntValue = this.f5283a.get(node).intValue();
        this.f5283a.set(node, Integer.valueOf(z10 ? iIntValue | this.f5285c : iIntValue & (~this.f5285c)));
    }
}
