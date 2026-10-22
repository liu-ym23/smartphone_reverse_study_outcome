package kotlin.reflect.jvm.internal.impl.types.checker;

import X8.AbstractC0272c;
import X8.C0281l;
import X8.I;
import X8.U;
import Y8.g;
import kotlin.jvm.internal.k;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
abstract class TypeIntersector$ResultNullability {

    /* renamed from: a, reason: collision with root package name */
    public static final START f5145a;
    public static final ACCEPT_NULL b;
    public static final UNKNOWN c;
    public static final NOT_NULL d;
    public static final /* synthetic */ TypeIntersector$ResultNullability[] e;

    public static final class ACCEPT_NULL extends TypeIntersector$ResultNullability {
        public ACCEPT_NULL() {
            super("ACCEPT_NULL", 1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector$ResultNullability
        public final TypeIntersector$ResultNullability a(U nextType) {
            k.f(nextType, "nextType");
            return TypeIntersector$ResultNullability.b(nextType);
        }
    }

    public static final class NOT_NULL extends TypeIntersector$ResultNullability {
        public NOT_NULL() {
            super("NOT_NULL", 3);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector$ResultNullability
        public final TypeIntersector$ResultNullability a(U nextType) {
            k.f(nextType, "nextType");
            return this;
        }
    }

    public static final class START extends TypeIntersector$ResultNullability {
        public START() {
            super("START", 0);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector$ResultNullability
        public final TypeIntersector$ResultNullability a(U nextType) {
            k.f(nextType, "nextType");
            return TypeIntersector$ResultNullability.b(nextType);
        }
    }

    public static final class UNKNOWN extends TypeIntersector$ResultNullability {
        public UNKNOWN() {
            super("UNKNOWN", 2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector$ResultNullability
        public final TypeIntersector$ResultNullability a(U nextType) {
            k.f(nextType, "nextType");
            TypeIntersector$ResultNullability typeIntersector$ResultNullabilityB = TypeIntersector$ResultNullability.b(nextType);
            return typeIntersector$ResultNullabilityB == TypeIntersector$ResultNullability.b ? this : typeIntersector$ResultNullabilityB;
        }
    }

    static {
        START start = new START();
        f5145a = start;
        ACCEPT_NULL accept_null = new ACCEPT_NULL();
        b = accept_null;
        UNKNOWN unknown = new UNKNOWN();
        c = unknown;
        NOT_NULL not_null = new NOT_NULL();
        d = not_null;
        TypeIntersector$ResultNullability[] typeIntersector$ResultNullabilityArr = {start, accept_null, unknown, not_null};
        e = typeIntersector$ResultNullabilityArr;
        kotlin.enums.a.a(typeIntersector$ResultNullabilityArr);
    }

    public static TypeIntersector$ResultNullability b(U u) {
        k.f(u, "<this>");
        if (u.W()) {
            return b;
        }
        if (u instanceof C0281l) {
        }
        return AbstractC0272c.h(g.l(false, null, 24), AbstractC0272c.m(u), I.b) ? d : c;
    }

    public static TypeIntersector$ResultNullability valueOf(String str) {
        return (TypeIntersector$ResultNullability) Enum.valueOf(TypeIntersector$ResultNullability.class, str);
    }

    public static TypeIntersector$ResultNullability[] values() {
        return (TypeIntersector$ResultNullability[]) e.clone();
    }

    public abstract TypeIntersector$ResultNullability a(U u);
}
