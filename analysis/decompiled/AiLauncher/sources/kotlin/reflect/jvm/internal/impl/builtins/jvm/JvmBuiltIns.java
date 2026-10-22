package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import C9.j;
import D9.e;
import D9.f;
import D9.g;
import E9.InterfaceC0819y;
import H9.F;
import h9.InterfaceC4149a;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.t;
import p9.InterfaceC5063a;
import w9.InterfaceC5752k;
import xa.C5868k;
import xa.InterfaceC5865h;
import xa.InterfaceC5869l;

/* loaded from: classes5.dex */
public final class JvmBuiltIns extends j {

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC5752k<Object>[] f34978k = {t.i(new PropertyReference1Impl(JvmBuiltIns.class, "customizer", "getCustomizer()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer;", 0))};

    /* renamed from: h, reason: collision with root package name */
    public final Kind f34979h;

    /* renamed from: i, reason: collision with root package name */
    public InterfaceC5063a<a> f34980i;

    /* renamed from: j, reason: collision with root package name */
    public final InterfaceC5865h f34981j;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Kind {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Kind[] $VALUES;
        public static final Kind FROM_DEPENDENCIES = new Kind("FROM_DEPENDENCIES", 0);
        public static final Kind FROM_CLASS_LOADER = new Kind("FROM_CLASS_LOADER", 1);
        public static final Kind FALLBACK = new Kind("FALLBACK", 2);

        private static final /* synthetic */ Kind[] $values() {
            return new Kind[]{FROM_DEPENDENCIES, FROM_CLASS_LOADER, FALLBACK};
        }

        static {
            Kind[] kindArr$values = $values();
            $VALUES = kindArr$values;
            $ENTRIES = kotlin.enums.a.a(kindArr$values);
        }

        private Kind(String str, int i10) {
        }

        public static Kind valueOf(String str) {
            return (Kind) Enum.valueOf(Kind.class, str);
        }

        public static Kind[] values() {
            return (Kind[]) $VALUES.clone();
        }
    }

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final InterfaceC0819y f34982a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f34983b;

        public a(InterfaceC0819y ownerModuleDescriptor, boolean z10) {
            p.i(ownerModuleDescriptor, "ownerModuleDescriptor");
            this.f34982a = ownerModuleDescriptor;
            this.f34983b = z10;
        }

        public final InterfaceC0819y a() {
            return this.f34982a;
        }

        public final boolean b() {
            return this.f34983b;
        }
    }

    public static final /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34984a;

        static {
            int[] iArr = new int[Kind.values().length];
            try {
                iArr[Kind.FROM_DEPENDENCIES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Kind.FROM_CLASS_LOADER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Kind.FALLBACK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f34984a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmBuiltIns(InterfaceC5869l storageManager, Kind kind) {
        super(storageManager);
        p.i(storageManager, "storageManager");
        p.i(kind, "kind");
        this.f34979h = kind;
        this.f34981j = storageManager.i(new e(this, storageManager));
        int i10 = b.f34984a[kind.ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                f(false);
            } else {
                if (i10 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                f(true);
            }
        }
    }

    public static final JvmBuiltInsCustomizer J0(JvmBuiltIns jvmBuiltIns, InterfaceC5869l interfaceC5869l) {
        F fS = jvmBuiltIns.s();
        p.h(fS, "getBuiltInsModule(...)");
        return new JvmBuiltInsCustomizer(fS, interfaceC5869l, new g(jvmBuiltIns));
    }

    public static final a K0(JvmBuiltIns jvmBuiltIns) {
        InterfaceC5063a<a> interfaceC5063a = jvmBuiltIns.f34980i;
        if (interfaceC5063a == null) {
            throw new AssertionError("JvmBuiltins instance has not been initialized properly");
        }
        a aVarInvoke = interfaceC5063a.invoke();
        jvmBuiltIns.f34980i = null;
        return aVarInvoke;
    }

    public static final a O0(InterfaceC0819y interfaceC0819y, boolean z10) {
        return new a(interfaceC0819y, z10);
    }

    @Override // C9.j
    /* renamed from: L0, reason: merged with bridge method [inline-methods] */
    public List<G9.b> w() {
        Iterable<G9.b> iterableW = super.w();
        p.h(iterableW, "getClassDescriptorFactories(...)");
        InterfaceC5869l interfaceC5869lV = V();
        p.h(interfaceC5869lV, "getStorageManager(...)");
        F fS = s();
        p.h(fS, "getBuiltInsModule(...)");
        return Z8.F.Q0(iterableW, new c(interfaceC5869lV, fS, null, 4, null));
    }

    public final JvmBuiltInsCustomizer M0() {
        return (JvmBuiltInsCustomizer) C5868k.a(this.f34981j, this, f34978k[0]);
    }

    @Override // C9.j
    public G9.c N() {
        return M0();
    }

    public final void N0(InterfaceC0819y moduleDescriptor, boolean z10) {
        p.i(moduleDescriptor, "moduleDescriptor");
        P0(new f(moduleDescriptor, z10));
    }

    public final void P0(InterfaceC5063a<a> computation) {
        p.i(computation, "computation");
        this.f34980i = computation;
    }

    @Override // C9.j
    public G9.a g() {
        return M0();
    }
}
