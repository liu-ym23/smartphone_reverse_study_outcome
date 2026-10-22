package ua;

import E9.InterfaceC0803h;
import com.fasterxml.jackson.core.JsonFactory;
import ea.AbstractC4017a;
import ea.InterfaceC4020d;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;
import wa.InterfaceC5793q;
import xa.InterfaceC5869l;

/* renamed from: ua.o, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5629o {

    /* renamed from: a, reason: collision with root package name */
    public final C5627m f42633a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC4020d f42634b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC0803h f42635c;

    /* renamed from: d, reason: collision with root package name */
    public final ea.h f42636d;

    /* renamed from: e, reason: collision with root package name */
    public final ea.j f42637e;

    /* renamed from: f, reason: collision with root package name */
    public final AbstractC4017a f42638f;

    /* renamed from: g, reason: collision with root package name */
    public final InterfaceC5793q f42639g;

    /* renamed from: h, reason: collision with root package name */
    public final TypeDeserializer f42640h;

    /* renamed from: i, reason: collision with root package name */
    public final C5601K f42641i;

    public C5629o(C5627m components, InterfaceC4020d nameResolver, InterfaceC0803h containingDeclaration, ea.h typeTable, ea.j versionRequirementTable, AbstractC4017a metadataVersion, InterfaceC5793q interfaceC5793q, TypeDeserializer typeDeserializer, List<ProtoBuf$TypeParameter> typeParameters) {
        String strA;
        kotlin.jvm.internal.p.i(components, "components");
        kotlin.jvm.internal.p.i(nameResolver, "nameResolver");
        kotlin.jvm.internal.p.i(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.p.i(typeTable, "typeTable");
        kotlin.jvm.internal.p.i(versionRequirementTable, "versionRequirementTable");
        kotlin.jvm.internal.p.i(metadataVersion, "metadataVersion");
        kotlin.jvm.internal.p.i(typeParameters, "typeParameters");
        this.f42633a = components;
        this.f42634b = nameResolver;
        this.f42635c = containingDeclaration;
        this.f42636d = typeTable;
        this.f42637e = versionRequirementTable;
        this.f42638f = metadataVersion;
        this.f42639g = interfaceC5793q;
        this.f42640h = new TypeDeserializer(this, typeDeserializer, typeParameters, "Deserializer for \"" + containingDeclaration.getName() + JsonFactory.DEFAULT_QUOTE_CHAR, (interfaceC5793q == null || (strA = interfaceC5793q.a()) == null) ? "[container not found]" : strA);
        this.f42641i = new C5601K(this);
    }

    public static /* synthetic */ C5629o b(C5629o c5629o, InterfaceC0803h interfaceC0803h, List list, InterfaceC4020d interfaceC4020d, ea.h hVar, ea.j jVar, AbstractC4017a abstractC4017a, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            interfaceC4020d = c5629o.f42634b;
        }
        InterfaceC4020d interfaceC4020d2 = interfaceC4020d;
        if ((i10 & 8) != 0) {
            hVar = c5629o.f42636d;
        }
        ea.h hVar2 = hVar;
        if ((i10 & 16) != 0) {
            jVar = c5629o.f42637e;
        }
        ea.j jVar2 = jVar;
        if ((i10 & 32) != 0) {
            abstractC4017a = c5629o.f42638f;
        }
        return c5629o.a(interfaceC0803h, list, interfaceC4020d2, hVar2, jVar2, abstractC4017a);
    }

    public final C5629o a(InterfaceC0803h descriptor, List<ProtoBuf$TypeParameter> typeParameterProtos, InterfaceC4020d nameResolver, ea.h typeTable, ea.j versionRequirementTable, AbstractC4017a metadataVersion) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        kotlin.jvm.internal.p.i(typeParameterProtos, "typeParameterProtos");
        kotlin.jvm.internal.p.i(nameResolver, "nameResolver");
        kotlin.jvm.internal.p.i(typeTable, "typeTable");
        kotlin.jvm.internal.p.i(versionRequirementTable, "versionRequirementTable");
        kotlin.jvm.internal.p.i(metadataVersion, "metadataVersion");
        return new C5629o(this.f42633a, nameResolver, descriptor, typeTable, ea.k.b(metadataVersion) ? versionRequirementTable : this.f42637e, metadataVersion, this.f42639g, this.f42640h, typeParameterProtos);
    }

    public final C5627m c() {
        return this.f42633a;
    }

    public final InterfaceC5793q d() {
        return this.f42639g;
    }

    public final InterfaceC0803h e() {
        return this.f42635c;
    }

    public final C5601K f() {
        return this.f42641i;
    }

    public final InterfaceC4020d g() {
        return this.f42634b;
    }

    public final InterfaceC5869l h() {
        return this.f42633a.u();
    }

    public final TypeDeserializer i() {
        return this.f42640h;
    }

    public final ea.h j() {
        return this.f42636d;
    }

    public final ea.j k() {
        return this.f42637e;
    }
}
