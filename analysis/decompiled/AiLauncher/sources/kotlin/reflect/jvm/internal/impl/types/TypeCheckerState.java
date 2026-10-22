package kotlin.reflect.jvm.internal.impl.types;

import Ca.g;
import Ca.h;
import Ca.q;
import Ia.k;
import Y8.t;
import h9.InterfaceC4149a;
import java.util.ArrayDeque;
import java.util.Set;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import ya.AbstractC6010p;
import ya.AbstractC6011q;

/* loaded from: classes5.dex */
public class TypeCheckerState {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f36073a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f36074b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f36075c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f36076d;

    /* renamed from: e, reason: collision with root package name */
    public final q f36077e;

    /* renamed from: f, reason: collision with root package name */
    public final AbstractC6010p f36078f;

    /* renamed from: g, reason: collision with root package name */
    public final AbstractC6011q f36079g;

    /* renamed from: h, reason: collision with root package name */
    public int f36080h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f36081i;

    /* renamed from: j, reason: collision with root package name */
    public ArrayDeque<h> f36082j;

    /* renamed from: k, reason: collision with root package name */
    public Set<h> f36083k;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class LowerCapturedTypePolicy {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ LowerCapturedTypePolicy[] $VALUES;
        public static final LowerCapturedTypePolicy CHECK_ONLY_LOWER = new LowerCapturedTypePolicy("CHECK_ONLY_LOWER", 0);
        public static final LowerCapturedTypePolicy CHECK_SUBTYPE_AND_LOWER = new LowerCapturedTypePolicy("CHECK_SUBTYPE_AND_LOWER", 1);
        public static final LowerCapturedTypePolicy SKIP_LOWER = new LowerCapturedTypePolicy("SKIP_LOWER", 2);

        private static final /* synthetic */ LowerCapturedTypePolicy[] $values() {
            return new LowerCapturedTypePolicy[]{CHECK_ONLY_LOWER, CHECK_SUBTYPE_AND_LOWER, SKIP_LOWER};
        }

        static {
            LowerCapturedTypePolicy[] lowerCapturedTypePolicyArr$values = $values();
            $VALUES = lowerCapturedTypePolicyArr$values;
            $ENTRIES = kotlin.enums.a.a(lowerCapturedTypePolicyArr$values);
        }

        private LowerCapturedTypePolicy(String str, int i10) {
        }

        public static LowerCapturedTypePolicy valueOf(String str) {
            return (LowerCapturedTypePolicy) Enum.valueOf(LowerCapturedTypePolicy.class, str);
        }

        public static LowerCapturedTypePolicy[] values() {
            return (LowerCapturedTypePolicy[]) $VALUES.clone();
        }
    }

    public interface a {

        /* renamed from: kotlin.reflect.jvm.internal.impl.types.TypeCheckerState$a$a, reason: collision with other inner class name */
        public static final class C0459a implements a {

            /* renamed from: a, reason: collision with root package name */
            public boolean f36084a;

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.a
            public void a(InterfaceC5063a<Boolean> block) {
                p.i(block, "block");
                if (this.f36084a) {
                    return;
                }
                this.f36084a = block.invoke().booleanValue();
            }

            public final boolean b() {
                return this.f36084a;
            }
        }

        void a(InterfaceC5063a<Boolean> interfaceC5063a);
    }

    public static abstract class b {

        public static abstract class a extends b {
            public a() {
                super(null);
            }
        }

        /* renamed from: kotlin.reflect.jvm.internal.impl.types.TypeCheckerState$b$b, reason: collision with other inner class name */
        public static final class C0460b extends b {

            /* renamed from: a, reason: collision with root package name */
            public static final C0460b f36085a = new C0460b();

            public C0460b() {
                super(null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.b
            public h a(TypeCheckerState state, g type) {
                p.i(state, "state");
                p.i(type, "type");
                return state.j().z0(type);
            }
        }

        public static final class c extends b {

            /* renamed from: a, reason: collision with root package name */
            public static final c f36086a = new c();

            public c() {
                super(null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.b
            public /* bridge */ /* synthetic */ h a(TypeCheckerState typeCheckerState, g gVar) {
                return (h) b(typeCheckerState, gVar);
            }

            public Void b(TypeCheckerState state, g type) {
                p.i(state, "state");
                p.i(type, "type");
                throw new UnsupportedOperationException("Should not be called");
            }
        }

        public static final class d extends b {

            /* renamed from: a, reason: collision with root package name */
            public static final d f36087a = new d();

            public d() {
                super(null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.b
            public h a(TypeCheckerState state, g type) {
                p.i(state, "state");
                p.i(type, "type");
                return state.j().E(type);
            }
        }

        public /* synthetic */ b(i iVar) {
            this();
        }

        public abstract h a(TypeCheckerState typeCheckerState, g gVar);

        public b() {
        }
    }

    public TypeCheckerState(boolean z10, boolean z11, boolean z12, boolean z13, q typeSystemContext, AbstractC6010p kotlinTypePreparator, AbstractC6011q kotlinTypeRefiner) {
        p.i(typeSystemContext, "typeSystemContext");
        p.i(kotlinTypePreparator, "kotlinTypePreparator");
        p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
        this.f36073a = z10;
        this.f36074b = z11;
        this.f36075c = z12;
        this.f36076d = z13;
        this.f36077e = typeSystemContext;
        this.f36078f = kotlinTypePreparator;
        this.f36079g = kotlinTypeRefiner;
    }

    public static /* synthetic */ Boolean d(TypeCheckerState typeCheckerState, g gVar, g gVar2, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addSubtypeConstraint");
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return typeCheckerState.c(gVar, gVar2, z10);
    }

    public Boolean c(g subType, g superType, boolean z10) {
        p.i(subType, "subType");
        p.i(superType, "superType");
        return null;
    }

    public final void e() {
        ArrayDeque<h> arrayDeque = this.f36082j;
        p.f(arrayDeque);
        arrayDeque.clear();
        Set<h> set = this.f36083k;
        p.f(set);
        set.clear();
        this.f36081i = false;
    }

    public boolean f(g subType, g superType) {
        p.i(subType, "subType");
        p.i(superType, "superType");
        return true;
    }

    public LowerCapturedTypePolicy g(h subType, Ca.b superType) {
        p.i(subType, "subType");
        p.i(superType, "superType");
        return LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER;
    }

    public final ArrayDeque<h> h() {
        return this.f36082j;
    }

    public final Set<h> i() {
        return this.f36083k;
    }

    public final q j() {
        return this.f36077e;
    }

    public final void k() {
        this.f36081i = true;
        if (this.f36082j == null) {
            this.f36082j = new ArrayDeque<>(4);
        }
        if (this.f36083k == null) {
            this.f36083k = k.f3419c.a();
        }
    }

    public final boolean l(g type) {
        p.i(type, "type");
        return this.f36076d && this.f36077e.C(type);
    }

    public final boolean m() {
        return this.f36075c;
    }

    public final boolean n() {
        return this.f36073a;
    }

    public final boolean o() {
        return this.f36074b;
    }

    public final g p(g type) {
        p.i(type, "type");
        return this.f36078f.a(type);
    }

    public final g q(g type) {
        p.i(type, "type");
        return this.f36079g.a(type);
    }

    public boolean r(InterfaceC5074l<? super a, t> block) {
        p.i(block, "block");
        a.C0459a c0459a = new a.C0459a();
        block.invoke(c0459a);
        return c0459a.b();
    }
}
