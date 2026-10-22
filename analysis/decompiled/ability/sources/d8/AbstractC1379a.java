package d8;

import G8.b;
import G8.c;
import G8.f;
import H4.o;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.internal.k;
import q8.u;

/* renamed from: d8.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1379a {

    /* renamed from: a, reason: collision with root package name */
    public static final LinkedHashSet f4303a;
    public static final b b;

    static {
        List<c> listN = o.N(u.f5611a, u.h, u.i, u.c, u.d, u.f);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (c topLevelFqName : listN) {
            k.f(topLevelFqName, "topLevelFqName");
            c cVarE = topLevelFqName.e();
            f fVarF = topLevelFqName.f();
            k.e(fVarF, "shortName(...)");
            linkedHashSet.add(new b(cVarE, fVarF));
        }
        f4303a = linkedHashSet;
        c REPEATABLE_ANNOTATION = u.g;
        k.e(REPEATABLE_ANNOTATION, "REPEATABLE_ANNOTATION");
        c cVarE2 = REPEATABLE_ANNOTATION.e();
        f fVarF2 = REPEATABLE_ANNOTATION.f();
        k.e(fVarF2, "shortName(...)");
        b = new b(cVarE2, fVarF2);
    }
}
