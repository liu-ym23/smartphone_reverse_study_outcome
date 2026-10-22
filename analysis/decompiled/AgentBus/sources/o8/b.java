package o8;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final e9.c f7780a = new e9.c("javax.annotation.meta.TypeQualifierNickname");

    /* renamed from: b, reason: collision with root package name */
    public static final e9.c f7781b = new e9.c("javax.annotation.meta.TypeQualifier");

    /* renamed from: c, reason: collision with root package name */
    public static final e9.c f7782c = new e9.c("javax.annotation.meta.TypeQualifierDefault");

    /* renamed from: d, reason: collision with root package name */
    public static final e9.c f7783d = new e9.c("kotlin.annotations.jvm.UnderMigration");

    /* renamed from: e, reason: collision with root package name */
    public static final List f7784e;

    /* renamed from: f, reason: collision with root package name */
    public static final Object f7785f;

    /* renamed from: g, reason: collision with root package name */
    public static final LinkedHashMap f7786g;

    /* renamed from: h, reason: collision with root package name */
    public static final Set f7787h;

    static {
        a aVar = a.TYPE_PARAMETER_BOUNDS;
        a aVar2 = a.TYPE_USE;
        a aVar3 = a.FIELD;
        a aVar4 = a.METHOD_RETURN_TYPE;
        a aVar5 = a.VALUE_PARAMETER;
        List listU0 = d7.s.u0(aVar3, aVar4, aVar5, aVar, aVar2);
        f7784e = listU0;
        e9.c cVar = y.f7877c;
        w8.h hVar = w8.h.f10900h;
        Map mapU = d7.e0.U(new c7.j(cVar, new n(new w8.i(hVar), listU0, false)), new c7.j(y.f7880f, new n(new w8.i(hVar), listU0, false)));
        f7785f = mapU;
        f7786g = d7.e0.W(d7.e0.U(new c7.j(new e9.c("javax.annotation.ParametersAreNullableByDefault"), new n(new w8.i(w8.h.f10899g), a.a.S(aVar5))), new c7.j(new e9.c("javax.annotation.ParametersAreNonnullByDefault"), new n(new w8.i(hVar), a.a.S(aVar5)))), mapU);
        f7787h = d7.n.x0(new e9.c[]{y.f7882h, y.f7883i});
    }
}
