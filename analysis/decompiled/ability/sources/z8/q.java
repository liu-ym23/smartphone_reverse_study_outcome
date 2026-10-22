package z8;

import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;
import m8.C1682b;
import n8.AbstractC1744c;

/* loaded from: classes4.dex */
public final class q implements V8.j {

    /* renamed from: a, reason: collision with root package name */
    public final C1682b f6987a;

    public q(C1682b c1682b, DeserializedContainerAbiStability deserializedContainerAbiStability) {
        this.f6987a = c1682b;
    }

    @Override // V8.j
    public final String f() {
        return "Class '" + AbstractC1744c.a(this.f6987a.f5307a).a().b() + '\'';
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        com.stepos.statsrpk.service.c.q(sb, q.class, ": ");
        sb.append(this.f6987a);
        return sb.toString();
    }
}
