package o8;

/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    public static final e9.c f7839a;

    /* renamed from: b, reason: collision with root package name */
    public static final e9.c[] f7840b;

    /* renamed from: c, reason: collision with root package name */
    public static final nb.f f7841c;

    /* renamed from: d, reason: collision with root package name */
    public static final r f7842d;

    static {
        e9.c cVar = new e9.c("org.jspecify.nullness");
        e9.c cVar2 = new e9.c("org.jspecify.annotations");
        f7839a = cVar2;
        e9.c cVar3 = new e9.c("io.reactivex.rxjava3.annotations");
        e9.c cVar4 = new e9.c("org.checkerframework.checker.nullness.compatqual");
        String strB = cVar3.b();
        f7840b = new e9.c[]{new e9.c(strB.concat(".Nullable")), new e9.c(strB.concat(".NonNull"))};
        e9.c cVar5 = new e9.c("org.jetbrains.annotations");
        r rVar = r.f7843d;
        c7.j jVar = new c7.j(cVar5, rVar);
        c7.j jVar2 = new c7.j(new e9.c("androidx.annotation"), rVar);
        c7.j jVar3 = new c7.j(new e9.c("android.support.annotation"), rVar);
        c7.j jVar4 = new c7.j(new e9.c("android.annotation"), rVar);
        c7.j jVar5 = new c7.j(new e9.c("com.android.annotations"), rVar);
        c7.j jVar6 = new c7.j(new e9.c("org.eclipse.jdt.annotation"), rVar);
        c7.j jVar7 = new c7.j(new e9.c("org.checkerframework.checker.nullness.qual"), rVar);
        c7.j jVar8 = new c7.j(cVar4, rVar);
        c7.j jVar9 = new c7.j(new e9.c("javax.annotation"), rVar);
        c7.j jVar10 = new c7.j(new e9.c("edu.umd.cs.findbugs.annotations"), rVar);
        c7.j jVar11 = new c7.j(new e9.c("io.reactivex.annotations"), rVar);
        e9.c cVar6 = new e9.c("androidx.annotation.RecentlyNullable");
        b0 b0Var = b0.WARN;
        c7.j jVar12 = new c7.j(cVar6, new r(b0Var, 4));
        c7.j jVar13 = new c7.j(new e9.c("androidx.annotation.RecentlyNonNull"), new r(b0Var, 4));
        c7.j jVar14 = new c7.j(new e9.c("lombok"), rVar);
        c7.e eVar = new c7.e(1, 9, 0);
        b0 b0Var2 = b0.STRICT;
        f7841c = new nb.f(d7.e0.U(jVar, jVar2, jVar3, jVar4, jVar5, jVar6, jVar7, jVar8, jVar9, jVar10, jVar11, jVar12, jVar13, jVar14, new c7.j(cVar, new r(b0Var, eVar, b0Var2)), new c7.j(cVar2, new r(b0Var, new c7.e(1, 9, 0), b0Var2)), new c7.j(cVar3, new r(b0Var, new c7.e(1, 8, 0), b0Var2))));
        f7842d = new r(b0Var, 4);
    }
}
