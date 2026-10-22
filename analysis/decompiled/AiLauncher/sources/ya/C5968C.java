package ya;

import kotlin.reflect.jvm.internal.impl.types.Variance;

/* renamed from: ya.C, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5968C extends E0 {

    /* renamed from: e, reason: collision with root package name */
    public static final a f44010e = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public final E0 f44011c;

    /* renamed from: d, reason: collision with root package name */
    public final E0 f44012d;

    /* renamed from: ya.C$a */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final E0 a(E0 first, E0 second) {
            kotlin.jvm.internal.p.i(first, "first");
            kotlin.jvm.internal.p.i(second, "second");
            return first.f() ? second : second.f() ? first : new C5968C(first, second, null);
        }

        public a() {
        }
    }

    public /* synthetic */ C5968C(E0 e02, E0 e03, kotlin.jvm.internal.i iVar) {
        this(e02, e03);
    }

    public static final E0 i(E0 e02, E0 e03) {
        return f44010e.a(e02, e03);
    }

    @Override // ya.E0
    public boolean a() {
        return this.f44011c.a() || this.f44012d.a();
    }

    @Override // ya.E0
    public boolean b() {
        return this.f44011c.b() || this.f44012d.b();
    }

    @Override // ya.E0
    public F9.g d(F9.g annotations) {
        kotlin.jvm.internal.p.i(annotations, "annotations");
        return this.f44012d.d(this.f44011c.d(annotations));
    }

    @Override // ya.E0
    public B0 e(S key) {
        kotlin.jvm.internal.p.i(key, "key");
        B0 b0E = this.f44011c.e(key);
        return b0E == null ? this.f44012d.e(key) : b0E;
    }

    @Override // ya.E0
    public boolean f() {
        return false;
    }

    @Override // ya.E0
    public S g(S topLevelType, Variance position) {
        kotlin.jvm.internal.p.i(topLevelType, "topLevelType");
        kotlin.jvm.internal.p.i(position, "position");
        return this.f44012d.g(this.f44011c.g(topLevelType, position), position);
    }

    public C5968C(E0 e02, E0 e03) {
        this.f44011c = e02;
        this.f44012d = e03;
    }
}
