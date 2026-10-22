package T8;

import X8.C0280k;
import h8.InterfaceC1494B;
import h8.InterfaceC1497E;
import h8.InterfaceC1522e;
import h8.InterfaceC1540w;
import j8.InterfaceC1603b;
import j8.InterfaceC1605d;
import java.util.List;
import java.util.Set;
import kotlin.collections.EmptyList;
import v0.C2054a;

/* loaded from: classes4.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final W8.i f1222a;
    public final InterfaceC1540w b;
    public final l c;
    public final g d;
    public final InterfaceC0249a e;
    public final InterfaceC1497E f;
    public final l g;
    public final o h;
    public final p8.b i;

    /* renamed from: j, reason: collision with root package name */
    public final p f1223j;
    public final Iterable k;
    public final u1.d l;
    public final l m;
    public final InterfaceC1603b n;
    public final InterfaceC1605d o;
    public final H8.h p;

    /* renamed from: q, reason: collision with root package name */
    public final Y8.k f1224q;

    /* renamed from: r, reason: collision with root package name */
    public final List f1225r;

    /* renamed from: s, reason: collision with root package name */
    public final n f1226s;

    /* renamed from: t, reason: collision with root package name */
    public final i f1227t;

    public k(W8.i iVar, InterfaceC1540w moduleDescriptor, g gVar, InterfaceC0249a interfaceC0249a, InterfaceC1497E interfaceC1497E, o oVar, p pVar, Iterable fictitiousClassDescriptorFactories, u1.d dVar, InterfaceC1603b additionalClassPartsProvider, InterfaceC1605d platformDependentDeclarationFilter, H8.h extensionRegistryLite, Y8.k kotlinTypeChecker, C2054a c2054a, List list, n enumEntriesDeserializationSupport) {
        l lVar = l.c;
        l lVar2 = l.g;
        kotlin.jvm.internal.k.f(moduleDescriptor, "moduleDescriptor");
        kotlin.jvm.internal.k.f(fictitiousClassDescriptorFactories, "fictitiousClassDescriptorFactories");
        kotlin.jvm.internal.k.f(additionalClassPartsProvider, "additionalClassPartsProvider");
        kotlin.jvm.internal.k.f(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        kotlin.jvm.internal.k.f(extensionRegistryLite, "extensionRegistryLite");
        kotlin.jvm.internal.k.f(kotlinTypeChecker, "kotlinTypeChecker");
        kotlin.jvm.internal.k.f(enumEntriesDeserializationSupport, "enumEntriesDeserializationSupport");
        this.f1222a = iVar;
        this.b = moduleDescriptor;
        this.c = lVar;
        this.d = gVar;
        this.e = interfaceC0249a;
        this.f = interfaceC1497E;
        this.g = lVar2;
        this.h = oVar;
        this.i = p8.b.f5555a;
        this.f1223j = pVar;
        this.k = fictitiousClassDescriptorFactories;
        this.l = dVar;
        this.m = j.f1221a;
        this.n = additionalClassPartsProvider;
        this.o = platformDependentDeclarationFilter;
        this.p = extensionRegistryLite;
        this.f1224q = kotlinTypeChecker;
        this.f1225r = list;
        this.f1226s = enumEntriesDeserializationSupport;
        this.f1227t = new i(this);
    }

    public final m a(InterfaceC1494B interfaceC1494B, D8.f nameResolver, D8.j jVar, D8.k versionRequirementTable, D8.a metadataVersion, V8.j jVar2) {
        kotlin.jvm.internal.k.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.k.f(versionRequirementTable, "versionRequirementTable");
        kotlin.jvm.internal.k.f(metadataVersion, "metadataVersion");
        return new m(this, nameResolver, interfaceC1494B, jVar, versionRequirementTable, metadataVersion, jVar2, null, EmptyList.f4893a);
    }

    public final InterfaceC1522e b(G8.b classId) {
        kotlin.jvm.internal.k.f(classId, "classId");
        Set set = i.c;
        return this.f1227t.a(classId, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public k(W8.i iVar, InterfaceC1540w interfaceC1540w, A8.d dVar, C0250b c0250b, InterfaceC1497E interfaceC1497E, Iterable iterable, u1.d dVar2, InterfaceC1603b interfaceC1603b, InterfaceC1605d interfaceC1605d, H8.h hVar, Y8.k kVar, C2054a c2054a, int i) {
        Y8.k kVar2;
        l lVar = l.e;
        l lVar2 = l.f;
        if ((i & 65536) != 0) {
            Y8.k.b.getClass();
            kVar2 = Y8.j.b;
        } else {
            kVar2 = kVar;
        }
        this(iVar, interfaceC1540w, dVar, c0250b, interfaceC1497E, o.f1229a, lVar, iterable, dVar2, interfaceC1603b, interfaceC1605d, hVar, kVar2, c2054a, H4.o.M(C0280k.f1533a), (i & 524288) != 0 ? l.d : lVar2);
    }
}
