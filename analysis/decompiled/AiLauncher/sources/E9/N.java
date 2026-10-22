package E9;

import java.util.List;
import ya.B0;

/* loaded from: classes5.dex */
public final class N {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0800e f2432a;

    /* renamed from: b, reason: collision with root package name */
    public final List<B0> f2433b;

    /* renamed from: c, reason: collision with root package name */
    public final N f2434c;

    /* JADX WARN: Multi-variable type inference failed */
    public N(InterfaceC0800e classifierDescriptor, List<? extends B0> arguments, N n10) {
        kotlin.jvm.internal.p.i(classifierDescriptor, "classifierDescriptor");
        kotlin.jvm.internal.p.i(arguments, "arguments");
        this.f2432a = classifierDescriptor;
        this.f2433b = arguments;
        this.f2434c = n10;
    }

    public final List<B0> a() {
        return this.f2433b;
    }

    public final InterfaceC0800e b() {
        return this.f2432a;
    }

    public final N c() {
        return this.f2434c;
    }
}
