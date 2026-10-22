package k0;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: k0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0673a implements i {

    /* renamed from: a, reason: collision with root package name */
    public final String f13319a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f13320b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0673a(String query) {
        this(query, null);
        Intrinsics.checkNotNullParameter(query, "query");
    }

    @Override // k0.i
    public final void a(h statement) {
        Intrinsics.checkNotNullParameter(statement, "statement");
        E3.b.c(statement, this.f13320b);
    }

    @Override // k0.i
    public final String b() {
        return this.f13319a;
    }

    public C0673a(String query, Object[] objArr) {
        Intrinsics.checkNotNullParameter(query, "query");
        this.f13319a = query;
        this.f13320b = objArr;
    }
}
