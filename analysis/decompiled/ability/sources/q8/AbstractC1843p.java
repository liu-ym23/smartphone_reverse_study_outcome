package q8;

import fa.C1449a;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.load.java.ReportLevel;

/* renamed from: q8.p, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1843p {

    /* renamed from: a, reason: collision with root package name */
    public static final G8.c f5606a;
    public static final G8.c[] b;
    public static final C1449a c;
    public static final C1844q d;

    static {
        G8.c cVar = new G8.c("org.jspecify.nullness");
        G8.c cVar2 = new G8.c("org.jspecify.annotations");
        f5606a = cVar2;
        G8.c cVar3 = new G8.c("io.reactivex.rxjava3.annotations");
        G8.c cVar4 = new G8.c("org.checkerframework.checker.nullness.compatqual");
        String strB = cVar3.b();
        b = new G8.c[]{new G8.c(strB.concat(".Nullable")), new G8.c(strB.concat(".NonNull"))};
        G8.c cVar5 = new G8.c("org.jetbrains.annotations");
        C1844q c1844q = C1844q.d;
        Pair pair = new Pair(cVar5, c1844q);
        Pair pair2 = new Pair(new G8.c("androidx.annotation"), c1844q);
        Pair pair3 = new Pair(new G8.c("android.support.annotation"), c1844q);
        Pair pair4 = new Pair(new G8.c("android.annotation"), c1844q);
        Pair pair5 = new Pair(new G8.c("com.android.annotations"), c1844q);
        Pair pair6 = new Pair(new G8.c("org.eclipse.jdt.annotation"), c1844q);
        Pair pair7 = new Pair(new G8.c("org.checkerframework.checker.nullness.qual"), c1844q);
        Pair pair8 = new Pair(cVar4, c1844q);
        Pair pair9 = new Pair(new G8.c("javax.annotation"), c1844q);
        Pair pair10 = new Pair(new G8.c("edu.umd.cs.findbugs.annotations"), c1844q);
        Pair pair11 = new Pair(new G8.c("io.reactivex.annotations"), c1844q);
        G8.c cVar6 = new G8.c("androidx.annotation.RecentlyNullable");
        ReportLevel reportLevel = ReportLevel.c;
        Pair pair12 = new Pair(cVar6, new C1844q(reportLevel, 4));
        Pair pair13 = new Pair(new G8.c("androidx.annotation.RecentlyNonNull"), new C1844q(reportLevel, 4));
        Pair pair14 = new Pair(new G8.c("lombok"), c1844q);
        C7.e eVar = new C7.e(2, 1, 0);
        ReportLevel reportLevel2 = ReportLevel.d;
        c = new C1449a(kotlin.collections.a.R(pair, pair2, pair3, pair4, pair5, pair6, pair7, pair8, pair9, pair10, pair11, pair12, pair13, pair14, new Pair(cVar, new C1844q(reportLevel, eVar, reportLevel2)), new Pair(cVar2, new C1844q(reportLevel, new C7.e(2, 1, 0), reportLevel2)), new Pair(cVar3, new C1844q(reportLevel, new C7.e(1, 8, 0), reportLevel2))));
        d = new C1844q(reportLevel, 4);
    }
}
