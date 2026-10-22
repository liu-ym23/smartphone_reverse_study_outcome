package T8;

import com.fasterxml.jackson.core.JsonFactory;
import h8.InterfaceC1527j;
import java.util.List;

/* loaded from: classes4.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final k f1228a;
    public final D8.f b;
    public final InterfaceC1527j c;
    public final D8.j d;
    public final D8.k e;
    public final D8.a f;
    public final V8.j g;
    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.a h;
    public final v i;

    public m(k kVar, D8.f nameResolver, InterfaceC1527j containingDeclaration, D8.j jVar, D8.k versionRequirementTable, D8.a metadataVersion, V8.j jVar2, kotlin.reflect.jvm.internal.impl.serialization.deserialization.a aVar, List typeParameters) {
        String strF;
        kotlin.jvm.internal.k.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.k.f(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.k.f(versionRequirementTable, "versionRequirementTable");
        kotlin.jvm.internal.k.f(metadataVersion, "metadataVersion");
        kotlin.jvm.internal.k.f(typeParameters, "typeParameters");
        this.f1228a = kVar;
        this.b = nameResolver;
        this.c = containingDeclaration;
        this.d = jVar;
        this.e = versionRequirementTable;
        this.f = metadataVersion;
        this.g = jVar2;
        this.h = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.a(this, aVar, typeParameters, "Deserializer for \"" + containingDeclaration.getName() + JsonFactory.DEFAULT_QUOTE_CHAR, (jVar2 == null || (strF = jVar2.f()) == null) ? "[container not found]" : strF);
        this.i = new v(this);
    }

    public final m a(InterfaceC1527j interfaceC1527j, List typeParameterProtos, D8.f nameResolver, D8.j jVar, D8.k versionRequirementTable, D8.a metadataVersion) {
        kotlin.jvm.internal.k.f(typeParameterProtos, "typeParameterProtos");
        kotlin.jvm.internal.k.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.k.f(versionRequirementTable, "versionRequirementTable");
        kotlin.jvm.internal.k.f(metadataVersion, "metadataVersion");
        int i = metadataVersion.b;
        if ((i != 1 || metadataVersion.c < 4) && i <= 1) {
            versionRequirementTable = this.e;
        }
        return new m(this.f1228a, nameResolver, interfaceC1527j, jVar, versionRequirementTable, metadataVersion, this.g, this.h, typeParameterProtos);
    }
}
