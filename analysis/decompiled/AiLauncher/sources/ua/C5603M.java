package ua;

import Z8.C1174w;
import ea.AbstractC4017a;
import ea.InterfaceC4020d;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment;
import p9.InterfaceC5074l;
import v9.C5685n;

/* renamed from: ua.M, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5603M implements InterfaceC5623i {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC4020d f42550a;

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC4017a f42551b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC5074l<ga.b, E9.W> f42552c;

    /* renamed from: d, reason: collision with root package name */
    public final Map<ga.b, ProtoBuf$Class> f42553d;

    /* JADX WARN: Multi-variable type inference failed */
    public C5603M(ProtoBuf$PackageFragment proto, InterfaceC4020d nameResolver, AbstractC4017a metadataVersion, InterfaceC5074l<? super ga.b, ? extends E9.W> classSource) {
        kotlin.jvm.internal.p.i(proto, "proto");
        kotlin.jvm.internal.p.i(nameResolver, "nameResolver");
        kotlin.jvm.internal.p.i(metadataVersion, "metadataVersion");
        kotlin.jvm.internal.p.i(classSource, "classSource");
        this.f42550a = nameResolver;
        this.f42551b = metadataVersion;
        this.f42552c = classSource;
        List<ProtoBuf$Class> listJ = proto.J();
        kotlin.jvm.internal.p.h(listJ, "getClass_List(...)");
        List<ProtoBuf$Class> list = listJ;
        LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Z8.Q.e(C1174w.x(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(C5602L.a(this.f42550a, ((ProtoBuf$Class) obj).H0()), obj);
        }
        this.f42553d = linkedHashMap;
    }

    @Override // ua.InterfaceC5623i
    public C5622h a(ga.b classId) {
        kotlin.jvm.internal.p.i(classId, "classId");
        ProtoBuf$Class protoBuf$Class = this.f42553d.get(classId);
        if (protoBuf$Class == null) {
            return null;
        }
        return new C5622h(this.f42550a, protoBuf$Class, this.f42551b, this.f42552c.invoke(classId));
    }

    public final Collection<ga.b> b() {
        return this.f42553d.keySet();
    }
}
