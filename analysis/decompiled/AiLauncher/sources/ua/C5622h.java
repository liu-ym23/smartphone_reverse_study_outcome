package ua;

import ea.AbstractC4017a;
import ea.InterfaceC4020d;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;

/* renamed from: ua.h, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5622h {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC4020d f42597a;

    /* renamed from: b, reason: collision with root package name */
    public final ProtoBuf$Class f42598b;

    /* renamed from: c, reason: collision with root package name */
    public final AbstractC4017a f42599c;

    /* renamed from: d, reason: collision with root package name */
    public final E9.W f42600d;

    public C5622h(InterfaceC4020d nameResolver, ProtoBuf$Class classProto, AbstractC4017a metadataVersion, E9.W sourceElement) {
        kotlin.jvm.internal.p.i(nameResolver, "nameResolver");
        kotlin.jvm.internal.p.i(classProto, "classProto");
        kotlin.jvm.internal.p.i(metadataVersion, "metadataVersion");
        kotlin.jvm.internal.p.i(sourceElement, "sourceElement");
        this.f42597a = nameResolver;
        this.f42598b = classProto;
        this.f42599c = metadataVersion;
        this.f42600d = sourceElement;
    }

    public final InterfaceC4020d a() {
        return this.f42597a;
    }

    public final ProtoBuf$Class b() {
        return this.f42598b;
    }

    public final AbstractC4017a c() {
        return this.f42599c;
    }

    public final E9.W d() {
        return this.f42600d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5622h)) {
            return false;
        }
        C5622h c5622h = (C5622h) obj;
        return kotlin.jvm.internal.p.d(this.f42597a, c5622h.f42597a) && kotlin.jvm.internal.p.d(this.f42598b, c5622h.f42598b) && kotlin.jvm.internal.p.d(this.f42599c, c5622h.f42599c) && kotlin.jvm.internal.p.d(this.f42600d, c5622h.f42600d);
    }

    public int hashCode() {
        return (((((this.f42597a.hashCode() * 31) + this.f42598b.hashCode()) * 31) + this.f42599c.hashCode()) * 31) + this.f42600d.hashCode();
    }

    public String toString() {
        return "ClassData(nameResolver=" + this.f42597a + ", classProto=" + this.f42598b + ", metadataVersion=" + this.f42599c + ", sourceElement=" + this.f42600d + ')';
    }
}
