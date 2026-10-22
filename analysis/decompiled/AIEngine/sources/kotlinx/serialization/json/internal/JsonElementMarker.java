package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.g;
import rc.e;
import tc.t;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class JsonElementMarker {

    /* renamed from: a, reason: collision with root package name */
    public final t f10125a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f10126b;

    public JsonElementMarker(e descriptor) {
        g.f(descriptor, "descriptor");
        this.f10125a = new t(descriptor, new JsonElementMarker$origin$1(2, this, JsonElementMarker.class, "readIfAbsent", "readIfAbsent(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", 0));
    }
}
