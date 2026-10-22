package ua;

import E9.InterfaceC0797b;
import E9.InterfaceC0819y;
import G9.a;
import G9.c;
import Z8.C1172u;
import Z8.C1173v;
import ea.AbstractC4017a;
import ea.InterfaceC4020d;
import java.util.List;
import ma.AbstractC4927g;
import qa.InterfaceC5166a;
import ua.InterfaceC5635u;
import wa.InterfaceC5793q;
import xa.InterfaceC5869l;
import ya.C6016w;
import ya.r0;

/* renamed from: ua.m, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5627m {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC5869l f42611a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0819y f42612b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC5628n f42613c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC5623i f42614d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC5618d<F9.c, AbstractC4927g<?>> f42615e;

    /* renamed from: f, reason: collision with root package name */
    public final E9.F f42616f;

    /* renamed from: g, reason: collision with root package name */
    public final InterfaceC5591A f42617g;

    /* renamed from: h, reason: collision with root package name */
    public final InterfaceC5636v f42618h;

    /* renamed from: i, reason: collision with root package name */
    public final M9.c f42619i;

    /* renamed from: j, reason: collision with root package name */
    public final InterfaceC5637w f42620j;

    /* renamed from: k, reason: collision with root package name */
    public final Iterable<G9.b> f42621k;

    /* renamed from: l, reason: collision with root package name */
    public final E9.D f42622l;

    /* renamed from: m, reason: collision with root package name */
    public final InterfaceC5626l f42623m;

    /* renamed from: n, reason: collision with root package name */
    public final G9.a f42624n;

    /* renamed from: o, reason: collision with root package name */
    public final G9.c f42625o;

    /* renamed from: p, reason: collision with root package name */
    public final kotlin.reflect.jvm.internal.impl.protobuf.d f42626p;

    /* renamed from: q, reason: collision with root package name */
    public final kotlin.reflect.jvm.internal.impl.types.checker.e f42627q;

    /* renamed from: r, reason: collision with root package name */
    public final InterfaceC5166a f42628r;

    /* renamed from: s, reason: collision with root package name */
    public final List<r0> f42629s;

    /* renamed from: t, reason: collision with root package name */
    public final InterfaceC5635u f42630t;

    /* renamed from: u, reason: collision with root package name */
    public final C5625k f42631u;

    /* JADX WARN: Multi-variable type inference failed */
    public C5627m(InterfaceC5869l storageManager, InterfaceC0819y moduleDescriptor, InterfaceC5628n configuration, InterfaceC5623i classDataFinder, InterfaceC5618d<? extends F9.c, ? extends AbstractC4927g<?>> annotationAndConstantLoader, E9.F packageFragmentProvider, InterfaceC5591A localClassifierTypeSettings, InterfaceC5636v errorReporter, M9.c lookupTracker, InterfaceC5637w flexibleTypeDeserializer, Iterable<? extends G9.b> fictitiousClassDescriptorFactories, E9.D notFoundClasses, InterfaceC5626l contractDeserializer, G9.a additionalClassPartsProvider, G9.c platformDependentDeclarationFilter, kotlin.reflect.jvm.internal.impl.protobuf.d extensionRegistryLite, kotlin.reflect.jvm.internal.impl.types.checker.e kotlinTypeChecker, InterfaceC5166a samConversionResolver, List<? extends r0> typeAttributeTranslators, InterfaceC5635u enumEntriesDeserializationSupport) {
        kotlin.jvm.internal.p.i(storageManager, "storageManager");
        kotlin.jvm.internal.p.i(moduleDescriptor, "moduleDescriptor");
        kotlin.jvm.internal.p.i(configuration, "configuration");
        kotlin.jvm.internal.p.i(classDataFinder, "classDataFinder");
        kotlin.jvm.internal.p.i(annotationAndConstantLoader, "annotationAndConstantLoader");
        kotlin.jvm.internal.p.i(packageFragmentProvider, "packageFragmentProvider");
        kotlin.jvm.internal.p.i(localClassifierTypeSettings, "localClassifierTypeSettings");
        kotlin.jvm.internal.p.i(errorReporter, "errorReporter");
        kotlin.jvm.internal.p.i(lookupTracker, "lookupTracker");
        kotlin.jvm.internal.p.i(flexibleTypeDeserializer, "flexibleTypeDeserializer");
        kotlin.jvm.internal.p.i(fictitiousClassDescriptorFactories, "fictitiousClassDescriptorFactories");
        kotlin.jvm.internal.p.i(notFoundClasses, "notFoundClasses");
        kotlin.jvm.internal.p.i(contractDeserializer, "contractDeserializer");
        kotlin.jvm.internal.p.i(additionalClassPartsProvider, "additionalClassPartsProvider");
        kotlin.jvm.internal.p.i(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        kotlin.jvm.internal.p.i(extensionRegistryLite, "extensionRegistryLite");
        kotlin.jvm.internal.p.i(kotlinTypeChecker, "kotlinTypeChecker");
        kotlin.jvm.internal.p.i(samConversionResolver, "samConversionResolver");
        kotlin.jvm.internal.p.i(typeAttributeTranslators, "typeAttributeTranslators");
        kotlin.jvm.internal.p.i(enumEntriesDeserializationSupport, "enumEntriesDeserializationSupport");
        this.f42611a = storageManager;
        this.f42612b = moduleDescriptor;
        this.f42613c = configuration;
        this.f42614d = classDataFinder;
        this.f42615e = annotationAndConstantLoader;
        this.f42616f = packageFragmentProvider;
        this.f42617g = localClassifierTypeSettings;
        this.f42618h = errorReporter;
        this.f42619i = lookupTracker;
        this.f42620j = flexibleTypeDeserializer;
        this.f42621k = fictitiousClassDescriptorFactories;
        this.f42622l = notFoundClasses;
        this.f42623m = contractDeserializer;
        this.f42624n = additionalClassPartsProvider;
        this.f42625o = platformDependentDeclarationFilter;
        this.f42626p = extensionRegistryLite;
        this.f42627q = kotlinTypeChecker;
        this.f42628r = samConversionResolver;
        this.f42629s = typeAttributeTranslators;
        this.f42630t = enumEntriesDeserializationSupport;
        this.f42631u = new C5625k(this);
    }

    public final C5629o a(E9.E descriptor, InterfaceC4020d nameResolver, ea.h typeTable, ea.j versionRequirementTable, AbstractC4017a metadataVersion, InterfaceC5793q interfaceC5793q) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        kotlin.jvm.internal.p.i(nameResolver, "nameResolver");
        kotlin.jvm.internal.p.i(typeTable, "typeTable");
        kotlin.jvm.internal.p.i(versionRequirementTable, "versionRequirementTable");
        kotlin.jvm.internal.p.i(metadataVersion, "metadataVersion");
        return new C5629o(this, nameResolver, descriptor, typeTable, versionRequirementTable, metadataVersion, interfaceC5793q, null, C1173v.m());
    }

    public final InterfaceC0797b b(ga.b classId) {
        kotlin.jvm.internal.p.i(classId, "classId");
        return C5625k.f(this.f42631u, classId, null, 2, null);
    }

    public final G9.a c() {
        return this.f42624n;
    }

    public final InterfaceC5618d<F9.c, AbstractC4927g<?>> d() {
        return this.f42615e;
    }

    public final InterfaceC5623i e() {
        return this.f42614d;
    }

    public final C5625k f() {
        return this.f42631u;
    }

    public final InterfaceC5628n g() {
        return this.f42613c;
    }

    public final InterfaceC5626l h() {
        return this.f42623m;
    }

    public final InterfaceC5635u i() {
        return this.f42630t;
    }

    public final InterfaceC5636v j() {
        return this.f42618h;
    }

    public final kotlin.reflect.jvm.internal.impl.protobuf.d k() {
        return this.f42626p;
    }

    public final Iterable<G9.b> l() {
        return this.f42621k;
    }

    public final InterfaceC5637w m() {
        return this.f42620j;
    }

    public final kotlin.reflect.jvm.internal.impl.types.checker.e n() {
        return this.f42627q;
    }

    public final InterfaceC5591A o() {
        return this.f42617g;
    }

    public final M9.c p() {
        return this.f42619i;
    }

    public final InterfaceC0819y q() {
        return this.f42612b;
    }

    public final E9.D r() {
        return this.f42622l;
    }

    public final E9.F s() {
        return this.f42616f;
    }

    public final G9.c t() {
        return this.f42625o;
    }

    public final InterfaceC5869l u() {
        return this.f42611a;
    }

    public final List<r0> v() {
        return this.f42629s;
    }

    public /* synthetic */ C5627m(InterfaceC5869l interfaceC5869l, InterfaceC0819y interfaceC0819y, InterfaceC5628n interfaceC5628n, InterfaceC5623i interfaceC5623i, InterfaceC5618d interfaceC5618d, E9.F f10, InterfaceC5591A interfaceC5591A, InterfaceC5636v interfaceC5636v, M9.c cVar, InterfaceC5637w interfaceC5637w, Iterable iterable, E9.D d10, InterfaceC5626l interfaceC5626l, G9.a aVar, G9.c cVar2, kotlin.reflect.jvm.internal.impl.protobuf.d dVar, kotlin.reflect.jvm.internal.impl.types.checker.e eVar, InterfaceC5166a interfaceC5166a, List list, InterfaceC5635u interfaceC5635u, int i10, kotlin.jvm.internal.i iVar) {
        this(interfaceC5869l, interfaceC0819y, interfaceC5628n, interfaceC5623i, interfaceC5618d, f10, interfaceC5591A, interfaceC5636v, cVar, interfaceC5637w, iterable, d10, interfaceC5626l, (i10 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? a.C0039a.f2867a : aVar, (i10 & 16384) != 0 ? c.a.f2868a : cVar2, dVar, (65536 & i10) != 0 ? kotlin.reflect.jvm.internal.impl.types.checker.e.f36100b.a() : eVar, interfaceC5166a, (262144 & i10) != 0 ? C1172u.e(C6016w.f44130a) : list, (i10 & 524288) != 0 ? InterfaceC5635u.a.f42652a : interfaceC5635u);
    }
}
