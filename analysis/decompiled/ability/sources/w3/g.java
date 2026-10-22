package w3;

import aa.InterfaceC0315b;
import com.networknt.schema.SpecificationVersion;
import com.networknt.schema.keyword.KeywordType;
import java.util.Arrays;
import z3.C2160e;

/* loaded from: classes3.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final C2097b f6845a;

    static {
        InterfaceC0315b interfaceC0315b = C2097b.g;
        M9.f fVar = new M9.f("http://json-schema.org/draft-04/schema#");
        SpecificationVersion specificationVersion = SpecificationVersion.DRAFT_4;
        fVar.b = specificationVersion;
        fVar.f981a = "id";
        fVar.e(x3.e.f6875a);
        fVar.f(KeywordType.b(specificationVersion));
        fVar.f(Arrays.asList(new C2160e("$schema", 1), new C2160e("id", 1), new C2160e("title", 0), new C2160e("description", 0), new C2160e("default", 0), new C2160e("definitions", 1), new C2160e("additionalItems", 1), new C2160e("exampleSetFlag", 0), new C2160e("exclusiveMinimum", 1), new C2160e("exclusiveMaximum", 1)));
        f6845a = fVar.d();
    }
}
