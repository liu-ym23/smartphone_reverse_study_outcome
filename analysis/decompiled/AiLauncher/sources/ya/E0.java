package ya;

import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes5.dex */
public abstract class E0 {

    /* renamed from: a, reason: collision with root package name */
    public static final b f44016a = new b(null);

    /* renamed from: b, reason: collision with root package name */
    public static final E0 f44017b = new a();

    public static final class a extends E0 {
        @Override // ya.E0
        public /* bridge */ /* synthetic */ B0 e(S s10) {
            return (B0) i(s10);
        }

        @Override // ya.E0
        public boolean f() {
            return true;
        }

        public Void i(S key) {
            kotlin.jvm.internal.p.i(key, "key");
            return null;
        }

        public String toString() {
            return "Empty TypeSubstitution";
        }
    }

    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.i iVar) {
            this();
        }

        public b() {
        }
    }

    public static final class c extends E0 {
        public c() {
        }

        @Override // ya.E0
        public boolean a() {
            return false;
        }

        @Override // ya.E0
        public boolean b() {
            return false;
        }

        @Override // ya.E0
        public F9.g d(F9.g annotations) {
            kotlin.jvm.internal.p.i(annotations, "annotations");
            return E0.this.d(annotations);
        }

        @Override // ya.E0
        public B0 e(S key) {
            kotlin.jvm.internal.p.i(key, "key");
            return E0.this.e(key);
        }

        @Override // ya.E0
        public boolean f() {
            return E0.this.f();
        }

        @Override // ya.E0
        public S g(S topLevelType, Variance position) {
            kotlin.jvm.internal.p.i(topLevelType, "topLevelType");
            kotlin.jvm.internal.p.i(position, "position");
            return E0.this.g(topLevelType, position);
        }
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return false;
    }

    public final TypeSubstitutor c() {
        TypeSubstitutor typeSubstitutorH = TypeSubstitutor.h(this);
        kotlin.jvm.internal.p.h(typeSubstitutorH, "create(...)");
        return typeSubstitutorH;
    }

    public F9.g d(F9.g annotations) {
        kotlin.jvm.internal.p.i(annotations, "annotations");
        return annotations;
    }

    public abstract B0 e(S s10);

    public boolean f() {
        return false;
    }

    public S g(S topLevelType, Variance position) {
        kotlin.jvm.internal.p.i(topLevelType, "topLevelType");
        kotlin.jvm.internal.p.i(position, "position");
        return topLevelType;
    }

    public final E0 h() {
        return new c();
    }
}
