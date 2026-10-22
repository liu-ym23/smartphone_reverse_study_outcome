package w3;

import aa.InterfaceC0315b;
import com.networknt.schema.SpecificationVersion;
import com.networknt.schema.keyword.KeywordType;
import java.util.Collections;
import java.util.HashMap;
import z3.C2160e;

/* renamed from: w3.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2100e {

    /* renamed from: a, reason: collision with root package name */
    public static final C2097b f6843a;

    static {
        InterfaceC0315b interfaceC0315b = C2097b.g;
        M9.f fVar = new M9.f("https://json-schema.org/draft/2020-12/schema");
        SpecificationVersion specificationVersion = SpecificationVersion.DRAFT_2020_12;
        fVar.b = specificationVersion;
        fVar.f981a = "$id";
        fVar.e(x3.e.f6875a);
        fVar.f(KeywordType.b(specificationVersion));
        fVar.f(Collections.singletonList(new C2160e("definitions", 1)));
        ((HashMap) fVar.f).putAll(f.f6844a);
        f6843a = fVar.d();
    }
}
