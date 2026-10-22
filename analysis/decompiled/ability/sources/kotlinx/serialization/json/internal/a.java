package kotlinx.serialization.json.internal;

import B9.C0192t;
import kotlin.jvm.internal.k;
import z9.g;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final C0192t f5267a;
    public boolean b;

    public a(g descriptor) {
        k.f(descriptor, "descriptor");
        this.f5267a = new C0192t(descriptor, new JsonElementMarker$origin$1(2, this, a.class, "readIfAbsent", "readIfAbsent(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", 0));
    }
}
