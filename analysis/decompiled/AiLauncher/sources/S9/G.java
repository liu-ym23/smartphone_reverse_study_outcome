package S9;

import C9.o;
import Z8.Y;
import Z8.Z;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public final class G {

    /* renamed from: a, reason: collision with root package name */
    public static final ga.c f5706a;

    /* renamed from: b, reason: collision with root package name */
    public static final ga.c f5707b;

    /* renamed from: c, reason: collision with root package name */
    public static final ga.c f5708c;

    /* renamed from: d, reason: collision with root package name */
    public static final ga.c f5709d;

    /* renamed from: e, reason: collision with root package name */
    public static final ga.c f5710e;

    /* renamed from: f, reason: collision with root package name */
    public static final ga.c f5711f;

    /* renamed from: g, reason: collision with root package name */
    public static final ga.c f5712g;

    /* renamed from: h, reason: collision with root package name */
    public static final ga.c f5713h;

    /* renamed from: i, reason: collision with root package name */
    public static final ga.c f5714i;

    /* renamed from: j, reason: collision with root package name */
    public static final ga.c f5715j;

    /* renamed from: k, reason: collision with root package name */
    public static final ga.c f5716k;

    /* renamed from: l, reason: collision with root package name */
    public static final ga.c f5717l;

    /* renamed from: m, reason: collision with root package name */
    public static final ga.c f5718m;

    /* renamed from: n, reason: collision with root package name */
    public static final ga.c f5719n;

    /* renamed from: o, reason: collision with root package name */
    public static final ga.c f5720o;

    /* renamed from: p, reason: collision with root package name */
    public static final ga.c f5721p;

    /* renamed from: q, reason: collision with root package name */
    public static final Set<ga.c> f5722q;

    /* renamed from: r, reason: collision with root package name */
    public static final Set<ga.c> f5723r;

    /* renamed from: s, reason: collision with root package name */
    public static final Set<ga.c> f5724s;

    /* renamed from: t, reason: collision with root package name */
    public static final Set<ga.c> f5725t;

    /* renamed from: u, reason: collision with root package name */
    public static final Set<ga.c> f5726u;

    /* renamed from: v, reason: collision with root package name */
    public static final Set<ga.c> f5727v;

    /* renamed from: w, reason: collision with root package name */
    public static final Set<ga.c> f5728w;

    /* renamed from: x, reason: collision with root package name */
    public static final Map<ga.c, ga.c> f5729x;

    /* renamed from: y, reason: collision with root package name */
    public static final ga.c f5730y;

    static {
        ga.c cVar = new ga.c("org.jspecify.nullness.Nullable");
        f5706a = cVar;
        ga.c cVar2 = new ga.c("org.jspecify.nullness.NullMarked");
        f5707b = cVar2;
        ga.c cVar3 = new ga.c("org.jspecify.nullness.NullnessUnspecified");
        f5708c = cVar3;
        ga.c cVar4 = new ga.c("org.jspecify.annotations.NonNull");
        f5709d = cVar4;
        ga.c cVar5 = new ga.c("org.jspecify.annotations.Nullable");
        f5710e = cVar5;
        ga.c cVar6 = new ga.c("org.jspecify.annotations.NullMarked");
        f5711f = cVar6;
        ga.c cVar7 = new ga.c("org.jspecify.annotations.NullnessUnspecified");
        f5712g = cVar7;
        ga.c cVar8 = new ga.c("org.jspecify.annotations.NullUnmarked");
        f5713h = cVar8;
        f5714i = new ga.c("javax.annotation.meta.TypeQualifier");
        f5715j = new ga.c("javax.annotation.meta.TypeQualifierNickname");
        f5716k = new ga.c("javax.annotation.meta.TypeQualifierDefault");
        ga.c cVar9 = new ga.c("javax.annotation.Nonnull");
        f5717l = cVar9;
        ga.c cVar10 = new ga.c("javax.annotation.Nullable");
        f5718m = cVar10;
        ga.c cVar11 = new ga.c("javax.annotation.CheckForNull");
        f5719n = cVar11;
        f5720o = new ga.c("javax.annotation.ParametersAreNonnullByDefault");
        f5721p = new ga.c("javax.annotation.ParametersAreNullableByDefault");
        f5722q = Y.j(cVar9, cVar11);
        ga.c JETBRAINS_NOT_NULL_ANNOTATION = F.f5694l;
        kotlin.jvm.internal.p.h(JETBRAINS_NOT_NULL_ANNOTATION, "JETBRAINS_NOT_NULL_ANNOTATION");
        Set<ga.c> setJ = Y.j(JETBRAINS_NOT_NULL_ANNOTATION, cVar4, new ga.c("android.annotation.NonNull"), new ga.c("androidx.annotation.NonNull"), new ga.c("androidx.annotation.RecentlyNonNull"), new ga.c("androidx.annotation.NonNull"), new ga.c("com.android.annotations.NonNull"), new ga.c("org.checkerframework.checker.nullness.compatqual.NonNullDecl"), new ga.c("org.checkerframework.checker.nullness.qual.NonNull"), new ga.c("edu.umd.cs.findbugs.annotations.NonNull"), new ga.c("io.reactivex.annotations.NonNull"), new ga.c("io.reactivex.rxjava3.annotations.NonNull"), new ga.c("org.eclipse.jdt.annotation.NonNull"), new ga.c("lombok.NonNull"), new ga.c("jakarta.annotation.Nonnull"));
        f5723r = setJ;
        ga.c JETBRAINS_NULLABLE_ANNOTATION = F.f5695m;
        kotlin.jvm.internal.p.h(JETBRAINS_NULLABLE_ANNOTATION, "JETBRAINS_NULLABLE_ANNOTATION");
        Set<ga.c> setJ2 = Y.j(JETBRAINS_NULLABLE_ANNOTATION, cVar, cVar5, cVar10, cVar11, new ga.c("android.annotation.Nullable"), new ga.c("androidx.annotation.Nullable"), new ga.c("androidx.annotation.RecentlyNullable"), new ga.c("androidx.annotation.Nullable"), new ga.c("com.android.annotations.Nullable"), new ga.c("org.checkerframework.checker.nullness.compatqual.NullableDecl"), new ga.c("org.checkerframework.checker.nullness.qual.Nullable"), new ga.c("edu.umd.cs.findbugs.annotations.Nullable"), new ga.c("edu.umd.cs.findbugs.annotations.PossiblyNull"), new ga.c("edu.umd.cs.findbugs.annotations.CheckForNull"), new ga.c("io.reactivex.annotations.Nullable"), new ga.c("io.reactivex.rxjava3.annotations.Nullable"), new ga.c("org.eclipse.jdt.annotation.Nullable"), new ga.c("jakarta.annotation.Nullable"));
        f5724s = setJ2;
        f5725t = Y.j(cVar3, cVar7);
        f5726u = Z.p(Z.p(Z.p(Z.p(Z.o(Z.o(new LinkedHashSet(), setJ), setJ2), cVar9), cVar2), cVar6), cVar8);
        f5727v = Y.j(F.f5697o, F.f5698p);
        f5728w = Y.j(F.f5696n, F.f5699q);
        f5729x = kotlin.collections.a.m(Y8.j.a(F.f5686d, o.a.f1860H), Y8.j.a(F.f5688f, o.a.f1868L), Y8.j.a(F.f5690h, o.a.f1942y), Y8.j.a(F.f5691i, o.a.f1876P));
        f5730y = new ga.c("kotlin.annotations.jvm.UnderMigration");
    }

    public static final Set<ga.c> a() {
        return f5722q;
    }

    public static final Set<ga.c> b() {
        return f5725t;
    }

    public static final ga.c c() {
        return f5717l;
    }

    public static final ga.c d() {
        return f5720o;
    }

    public static final ga.c e() {
        return f5721p;
    }

    public static final ga.c f() {
        return f5714i;
    }

    public static final ga.c g() {
        return f5716k;
    }

    public static final ga.c h() {
        return f5715j;
    }

    public static final ga.c i() {
        return f5711f;
    }

    public static final ga.c j() {
        return f5713h;
    }

    public static final ga.c k() {
        return f5707b;
    }

    public static final Set<ga.c> l() {
        return f5728w;
    }

    public static final Set<ga.c> m() {
        return f5723r;
    }

    public static final Set<ga.c> n() {
        return f5724s;
    }

    public static final Set<ga.c> o() {
        return f5727v;
    }

    public static final ga.c p() {
        return f5730y;
    }
}
