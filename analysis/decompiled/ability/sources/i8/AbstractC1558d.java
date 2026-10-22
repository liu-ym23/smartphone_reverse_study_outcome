package i8;

import L8.w;
import e8.n;
import kotlin.Pair;
import kotlin.collections.EmptyList;

/* renamed from: i8.d, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1558d {

    /* renamed from: a, reason: collision with root package name */
    public static final G8.f f4610a = G8.f.e("message");
    public static final G8.f b = G8.f.e("replaceWith");
    public static final G8.f c = G8.f.e("level");
    public static final G8.f d = G8.f.e("expression");
    public static final G8.f e = G8.f.e("imports");

    public static final C1563i a(e8.i iVar, String message, String replaceWith, String str) {
        kotlin.jvm.internal.k.f(iVar, "<this>");
        kotlin.jvm.internal.k.f(message, "message");
        kotlin.jvm.internal.k.f(replaceWith, "replaceWith");
        C1563i c1563i = new C1563i(iVar, n.o, kotlin.collections.a.R(new Pair(d, new w(replaceWith)), new Pair(e, new L8.b(new e8.g(iVar, 1), EmptyList.f4893a))));
        G8.c cVar = n.m;
        Pair pair = new Pair(f4610a, new w(message));
        Pair pair2 = new Pair(b, new L8.a((Object) c1563i));
        G8.c topLevelFqName = n.n;
        kotlin.jvm.internal.k.f(topLevelFqName, "topLevelFqName");
        G8.c cVarE = topLevelFqName.e();
        G8.f fVarF = topLevelFqName.f();
        kotlin.jvm.internal.k.e(fVarF, "shortName(...)");
        return new C1563i(iVar, cVar, kotlin.collections.a.R(pair, pair2, new Pair(c, new L8.i(new G8.b(cVarE, fVarF), G8.f.e(str)))));
    }
}
