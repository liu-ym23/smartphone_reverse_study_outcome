package H9;

import E9.AbstractC0811p;
import E9.C0810o;
import E9.InterfaceC0803h;
import E9.InterfaceC0805j;
import E9.b0;
import E9.i0;
import E9.j0;
import H9.V;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ka.C4827g;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import p9.InterfaceC5063a;
import sa.C5457d;
import sa.InterfaceC5459f;
import ya.C5967B;
import ya.E0;

/* renamed from: H9.s, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0839s extends AbstractC0835n implements kotlin.reflect.jvm.internal.impl.descriptors.e {

    /* renamed from: A, reason: collision with root package name */
    public final kotlin.reflect.jvm.internal.impl.descriptors.e f3161A;

    /* renamed from: B, reason: collision with root package name */
    public final CallableMemberDescriptor.Kind f3162B;

    /* renamed from: C, reason: collision with root package name */
    public kotlin.reflect.jvm.internal.impl.descriptors.e f3163C;

    /* renamed from: D, reason: collision with root package name */
    public Map<a.InterfaceC0437a<?>, Object> f3164D;

    /* renamed from: e, reason: collision with root package name */
    public List<b0> f3165e;

    /* renamed from: f, reason: collision with root package name */
    public List<i0> f3166f;

    /* renamed from: g, reason: collision with root package name */
    public ya.S f3167g;

    /* renamed from: h, reason: collision with root package name */
    public List<E9.S> f3168h;

    /* renamed from: i, reason: collision with root package name */
    public E9.S f3169i;

    /* renamed from: j, reason: collision with root package name */
    public E9.S f3170j;

    /* renamed from: k, reason: collision with root package name */
    public Modality f3171k;

    /* renamed from: l, reason: collision with root package name */
    public AbstractC0811p f3172l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f3173m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f3174n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f3175o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f3176p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f3177q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f3178r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f3179s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f3180t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f3181u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f3182v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f3183w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f3184x;

    /* renamed from: y, reason: collision with root package name */
    public Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.e> f3185y;

    /* renamed from: z, reason: collision with root package name */
    public volatile InterfaceC5063a<Collection<kotlin.reflect.jvm.internal.impl.descriptors.e>> f3186z;

    /* renamed from: H9.s$a */
    public class a implements InterfaceC5063a<Collection<kotlin.reflect.jvm.internal.impl.descriptors.e>> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TypeSubstitutor f3187a;

        public a(TypeSubstitutor typeSubstitutor) {
            this.f3187a = typeSubstitutor;
        }

        @Override // p9.InterfaceC5063a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Collection<kotlin.reflect.jvm.internal.impl.descriptors.e> invoke() {
            Ia.j jVar = new Ia.j();
            Iterator<? extends kotlin.reflect.jvm.internal.impl.descriptors.e> it = AbstractC0839s.this.d().iterator();
            while (it.hasNext()) {
                jVar.add(it.next().c(this.f3187a));
            }
            return jVar;
        }
    }

    /* renamed from: H9.s$b */
    public static class b implements InterfaceC5063a<List<j0>> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f3189a;

        public b(List list) {
            this.f3189a = list;
        }

        @Override // p9.InterfaceC5063a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<j0> invoke() {
            return this.f3189a;
        }
    }

    /* renamed from: H9.s$c */
    public class c implements e.a<kotlin.reflect.jvm.internal.impl.descriptors.e> {

        /* renamed from: a, reason: collision with root package name */
        public E0 f3190a;

        /* renamed from: b, reason: collision with root package name */
        public InterfaceC0803h f3191b;

        /* renamed from: c, reason: collision with root package name */
        public Modality f3192c;

        /* renamed from: d, reason: collision with root package name */
        public AbstractC0811p f3193d;

        /* renamed from: e, reason: collision with root package name */
        public kotlin.reflect.jvm.internal.impl.descriptors.e f3194e;

        /* renamed from: f, reason: collision with root package name */
        public CallableMemberDescriptor.Kind f3195f;

        /* renamed from: g, reason: collision with root package name */
        public List<i0> f3196g;

        /* renamed from: h, reason: collision with root package name */
        public List<E9.S> f3197h;

        /* renamed from: i, reason: collision with root package name */
        public E9.S f3198i;

        /* renamed from: j, reason: collision with root package name */
        public E9.S f3199j;

        /* renamed from: k, reason: collision with root package name */
        public ya.S f3200k;

        /* renamed from: l, reason: collision with root package name */
        public ga.e f3201l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f3202m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f3203n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f3204o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f3205p;

        /* renamed from: q, reason: collision with root package name */
        public boolean f3206q;

        /* renamed from: r, reason: collision with root package name */
        public List<b0> f3207r;

        /* renamed from: s, reason: collision with root package name */
        public F9.g f3208s;

        /* renamed from: t, reason: collision with root package name */
        public boolean f3209t;

        /* renamed from: u, reason: collision with root package name */
        public Map<a.InterfaceC0437a<?>, Object> f3210u;

        /* renamed from: v, reason: collision with root package name */
        public Boolean f3211v;

        /* renamed from: w, reason: collision with root package name */
        public boolean f3212w;

        /* renamed from: x, reason: collision with root package name */
        public final /* synthetic */ AbstractC0839s f3213x;

        public c(AbstractC0839s abstractC0839s, E0 e02, InterfaceC0803h interfaceC0803h, Modality modality, AbstractC0811p abstractC0811p, CallableMemberDescriptor.Kind kind, List<i0> list, List<E9.S> list2, E9.S s10, ya.S s11, ga.e eVar) {
            if (e02 == null) {
                u(0);
            }
            if (interfaceC0803h == null) {
                u(1);
            }
            if (modality == null) {
                u(2);
            }
            if (abstractC0811p == null) {
                u(3);
            }
            if (kind == null) {
                u(4);
            }
            if (list == null) {
                u(5);
            }
            if (list2 == null) {
                u(6);
            }
            if (s11 == null) {
                u(7);
            }
            this.f3213x = abstractC0839s;
            this.f3194e = null;
            this.f3199j = abstractC0839s.f3170j;
            this.f3202m = true;
            this.f3203n = false;
            this.f3204o = false;
            this.f3205p = false;
            this.f3206q = abstractC0839s.w0();
            this.f3207r = null;
            this.f3208s = null;
            this.f3209t = abstractC0839s.z0();
            this.f3210u = new LinkedHashMap();
            this.f3211v = null;
            this.f3212w = false;
            this.f3190a = e02;
            this.f3191b = interfaceC0803h;
            this.f3192c = modality;
            this.f3193d = abstractC0811p;
            this.f3195f = kind;
            this.f3196g = list;
            this.f3197h = list2;
            this.f3198i = s10;
            this.f3200k = s11;
            this.f3201l = eVar;
        }

        public static /* synthetic */ void u(int i10) {
            String str;
            int i11;
            switch (i10) {
                case 9:
                case 11:
                case 13:
                case 15:
                case 16:
                case 18:
                case 20:
                case 22:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 38:
                case 40:
                case 41:
                case 42:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                case 10:
                case 12:
                case 14:
                case 17:
                case 19:
                case 21:
                case 23:
                case 25:
                case 35:
                case 37:
                case 39:
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i10) {
                case 9:
                case 11:
                case 13:
                case 15:
                case 16:
                case 18:
                case 20:
                case 22:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 38:
                case 40:
                case 41:
                case 42:
                    i11 = 2;
                    break;
                case 10:
                case 12:
                case 14:
                case 17:
                case 19:
                case 21:
                case 23:
                case 25:
                case 35:
                case 37:
                case 39:
                default:
                    i11 = 3;
                    break;
            }
            Object[] objArr = new Object[i11];
            switch (i10) {
                case 1:
                    objArr[0] = "newOwner";
                    break;
                case 2:
                    objArr[0] = "newModality";
                    break;
                case 3:
                    objArr[0] = "newVisibility";
                    break;
                case 4:
                case 14:
                    objArr[0] = "kind";
                    break;
                case 5:
                    objArr[0] = "newValueParameterDescriptors";
                    break;
                case 6:
                    objArr[0] = "newContextReceiverParameters";
                    break;
                case 7:
                    objArr[0] = "newReturnType";
                    break;
                case 8:
                    objArr[0] = "owner";
                    break;
                case 9:
                case 11:
                case 13:
                case 15:
                case 16:
                case 18:
                case 20:
                case 22:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 38:
                case 40:
                case 41:
                case 42:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 10:
                    objArr[0] = "modality";
                    break;
                case 12:
                    objArr[0] = "visibility";
                    break;
                case 17:
                    objArr[0] = "name";
                    break;
                case 19:
                case 21:
                    objArr[0] = "parameters";
                    break;
                case 23:
                    objArr[0] = "type";
                    break;
                case 25:
                    objArr[0] = "contextReceiverParameters";
                    break;
                case 35:
                    objArr[0] = "additionalAnnotations";
                    break;
                case 37:
                default:
                    objArr[0] = "substitution";
                    break;
                case 39:
                    objArr[0] = "userDataKey";
                    break;
            }
            switch (i10) {
                case 9:
                    objArr[1] = "setOwner";
                    break;
                case 10:
                case 12:
                case 14:
                case 17:
                case 19:
                case 21:
                case 23:
                case 25:
                case 35:
                case 37:
                case 39:
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 11:
                    objArr[1] = "setModality";
                    break;
                case 13:
                    objArr[1] = "setVisibility";
                    break;
                case 15:
                    objArr[1] = "setKind";
                    break;
                case 16:
                    objArr[1] = "setCopyOverrides";
                    break;
                case 18:
                    objArr[1] = "setName";
                    break;
                case 20:
                    objArr[1] = "setValueParameters";
                    break;
                case 22:
                    objArr[1] = "setTypeParameters";
                    break;
                case 24:
                    objArr[1] = "setReturnType";
                    break;
                case 26:
                    objArr[1] = "setContextReceiverParameters";
                    break;
                case 27:
                    objArr[1] = "setExtensionReceiverParameter";
                    break;
                case 28:
                    objArr[1] = "setDispatchReceiverParameter";
                    break;
                case 29:
                    objArr[1] = "setOriginal";
                    break;
                case 30:
                    objArr[1] = "setSignatureChange";
                    break;
                case 31:
                    objArr[1] = "setPreserveSourceElement";
                    break;
                case 32:
                    objArr[1] = "setDropOriginalInContainingParts";
                    break;
                case 33:
                    objArr[1] = "setHiddenToOvercomeSignatureClash";
                    break;
                case 34:
                    objArr[1] = "setHiddenForResolutionEverywhereBesideSupercalls";
                    break;
                case 36:
                    objArr[1] = "setAdditionalAnnotations";
                    break;
                case 38:
                    objArr[1] = "setSubstitution";
                    break;
                case 40:
                    objArr[1] = "putUserData";
                    break;
                case 41:
                    objArr[1] = "getSubstitution";
                    break;
                case 42:
                    objArr[1] = "setJustForTypeSubstitution";
                    break;
            }
            switch (i10) {
                case 8:
                    objArr[2] = "setOwner";
                    break;
                case 9:
                case 11:
                case 13:
                case 15:
                case 16:
                case 18:
                case 20:
                case 22:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 38:
                case 40:
                case 41:
                case 42:
                    break;
                case 10:
                    objArr[2] = "setModality";
                    break;
                case 12:
                    objArr[2] = "setVisibility";
                    break;
                case 14:
                    objArr[2] = "setKind";
                    break;
                case 17:
                    objArr[2] = "setName";
                    break;
                case 19:
                    objArr[2] = "setValueParameters";
                    break;
                case 21:
                    objArr[2] = "setTypeParameters";
                    break;
                case 23:
                    objArr[2] = "setReturnType";
                    break;
                case 25:
                    objArr[2] = "setContextReceiverParameters";
                    break;
                case 35:
                    objArr[2] = "setAdditionalAnnotations";
                    break;
                case 37:
                    objArr[2] = "setSubstitution";
                    break;
                case 39:
                    objArr[2] = "putUserData";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String str2 = String.format(str, objArr);
            switch (i10) {
                case 9:
                case 11:
                case 13:
                case 15:
                case 16:
                case 18:
                case 20:
                case 22:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 38:
                case 40:
                case 41:
                case 42:
                    throw new IllegalStateException(str2);
                case 10:
                case 12:
                case 14:
                case 17:
                case 19:
                case 21:
                case 23:
                case 25:
                case 35:
                case 37:
                case 39:
                default:
                    throw new IllegalArgumentException(str2);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        /* renamed from: B, reason: merged with bridge method [inline-methods] */
        public c h(F9.g gVar) {
            if (gVar == null) {
                u(35);
            }
            this.f3208s = gVar;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        /* renamed from: C, reason: merged with bridge method [inline-methods] */
        public c m(boolean z10) {
            this.f3202m = z10;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        /* renamed from: D, reason: merged with bridge method [inline-methods] */
        public c f(E9.S s10) {
            this.f3199j = s10;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        /* renamed from: E, reason: merged with bridge method [inline-methods] */
        public c a() {
            this.f3205p = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        /* renamed from: F, reason: merged with bridge method [inline-methods] */
        public c k(E9.S s10) {
            this.f3198i = s10;
            return this;
        }

        public c G(boolean z10) {
            this.f3211v = Boolean.valueOf(z10);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        /* renamed from: H, reason: merged with bridge method [inline-methods] */
        public c c() {
            this.f3209t = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        /* renamed from: I, reason: merged with bridge method [inline-methods] */
        public c g() {
            this.f3206q = true;
            return this;
        }

        public c J(boolean z10) {
            this.f3212w = z10;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        /* renamed from: K, reason: merged with bridge method [inline-methods] */
        public c q(CallableMemberDescriptor.Kind kind) {
            if (kind == null) {
                u(14);
            }
            this.f3195f = kind;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        /* renamed from: L, reason: merged with bridge method [inline-methods] */
        public c i(Modality modality) {
            if (modality == null) {
                u(10);
            }
            this.f3192c = modality;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        /* renamed from: M, reason: merged with bridge method [inline-methods] */
        public c n(ga.e eVar) {
            if (eVar == null) {
                u(17);
            }
            this.f3201l = eVar;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        /* renamed from: N, reason: merged with bridge method [inline-methods] */
        public c l(CallableMemberDescriptor callableMemberDescriptor) {
            this.f3194e = (kotlin.reflect.jvm.internal.impl.descriptors.e) callableMemberDescriptor;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        /* renamed from: O, reason: merged with bridge method [inline-methods] */
        public c s(InterfaceC0803h interfaceC0803h) {
            if (interfaceC0803h == null) {
                u(8);
            }
            this.f3191b = interfaceC0803h;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        /* renamed from: P, reason: merged with bridge method [inline-methods] */
        public c j() {
            this.f3204o = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        /* renamed from: Q, reason: merged with bridge method [inline-methods] */
        public c o(ya.S s10) {
            if (s10 == null) {
                u(23);
            }
            this.f3200k = s10;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        /* renamed from: R, reason: merged with bridge method [inline-methods] */
        public c t() {
            this.f3203n = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        /* renamed from: S, reason: merged with bridge method [inline-methods] */
        public c d(E0 e02) {
            if (e02 == null) {
                u(37);
            }
            this.f3190a = e02;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        /* renamed from: T, reason: merged with bridge method [inline-methods] */
        public c p(List<b0> list) {
            if (list == null) {
                u(21);
            }
            this.f3207r = list;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        /* renamed from: U, reason: merged with bridge method [inline-methods] */
        public c b(List<i0> list) {
            if (list == null) {
                u(19);
            }
            this.f3196g = list;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        /* renamed from: V, reason: merged with bridge method [inline-methods] */
        public c r(AbstractC0811p abstractC0811p) {
            if (abstractC0811p == null) {
                u(12);
            }
            this.f3193d = abstractC0811p;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        public kotlin.reflect.jvm.internal.impl.descriptors.e build() {
            return this.f3213x.G0(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        public <V> e.a<kotlin.reflect.jvm.internal.impl.descriptors.e> e(a.InterfaceC0437a<V> interfaceC0437a, V v10) {
            if (interfaceC0437a == null) {
                u(39);
            }
            this.f3210u.put(interfaceC0437a, v10);
            return this;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC0839s(InterfaceC0803h interfaceC0803h, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, F9.g gVar, ga.e eVar2, CallableMemberDescriptor.Kind kind, E9.W w10) {
        super(interfaceC0803h, gVar, eVar2, w10);
        if (interfaceC0803h == null) {
            T(0);
        }
        if (gVar == null) {
            T(1);
        }
        if (eVar2 == null) {
            T(2);
        }
        if (kind == null) {
            T(3);
        }
        if (w10 == null) {
            T(4);
        }
        this.f3172l = C0810o.f2477i;
        this.f3173m = false;
        this.f3174n = false;
        this.f3175o = false;
        this.f3176p = false;
        this.f3177q = false;
        this.f3178r = false;
        this.f3179s = false;
        this.f3180t = false;
        this.f3181u = false;
        this.f3182v = false;
        this.f3183w = true;
        this.f3184x = false;
        this.f3185y = null;
        this.f3186z = null;
        this.f3163C = null;
        this.f3164D = null;
        this.f3161A = eVar == null ? this : eVar;
        this.f3162B = kind;
    }

    public static List<i0> I0(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, List<i0> list, TypeSubstitutor typeSubstitutor) {
        if (list == null) {
            T(28);
        }
        if (typeSubstitutor == null) {
            T(29);
        }
        return J0(eVar, list, typeSubstitutor, false, false, null);
    }

    public static List<i0> J0(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, List<i0> list, TypeSubstitutor typeSubstitutor, boolean z10, boolean z11, boolean[] zArr) {
        if (list == null) {
            T(30);
        }
        if (typeSubstitutor == null) {
            T(31);
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (i0 i0Var : list) {
            ya.S type = i0Var.getType();
            Variance variance = Variance.IN_VARIANCE;
            ya.S sQ = typeSubstitutor.q(type, variance);
            ya.S sP0 = i0Var.p0();
            ya.S sQ2 = sP0 == null ? null : typeSubstitutor.q(sP0, variance);
            if (sQ == null) {
                return null;
            }
            if ((sQ != i0Var.getType() || sP0 != sQ2) && zArr != null) {
                zArr[0] = true;
            }
            arrayList.add(V.E0(eVar, z10 ? null : i0Var, i0Var.getIndex(), i0Var.getAnnotations(), i0Var.getName(), sQ, i0Var.v0(), i0Var.l0(), i0Var.j0(), sQ2, z11 ? i0Var.e() : E9.W.f2444a, i0Var instanceof V.b ? new b(((V.b) i0Var).J0()) : null));
        }
        return arrayList;
    }

    private static /* synthetic */ void T(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 10:
            case 11:
            case 12:
            case 17:
            case 22:
            case 24:
            case 25:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                i11 = 2;
                break;
            case 10:
            case 11:
            case 12:
            case 17:
            case 22:
            case 24:
            case 25:
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "source";
                break;
            case 5:
                objArr[0] = "contextReceiverParameters";
                break;
            case 6:
                objArr[0] = "typeParameters";
                break;
            case 7:
            case 28:
            case 30:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 8:
            case 10:
                objArr[0] = "visibility";
                break;
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 11:
                objArr[0] = "unsubstitutedReturnType";
                break;
            case 12:
                objArr[0] = "extensionReceiverParameter";
                break;
            case 17:
                objArr[0] = "overriddenDescriptors";
                break;
            case 22:
                objArr[0] = "originalSubstitutor";
                break;
            case 24:
            case 29:
            case 31:
                objArr[0] = "substitutor";
                break;
            case 25:
                objArr[0] = "configuration";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i10) {
            case 9:
                objArr[1] = McpSchema.METHOD_INITIALIZE;
                break;
            case 10:
            case 11:
            case 12:
            case 17:
            case 22:
            case 24:
            case 25:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 13:
                objArr[1] = "getContextReceiverParameters";
                break;
            case 14:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 15:
                objArr[1] = "getModality";
                break;
            case 16:
                objArr[1] = "getVisibility";
                break;
            case 18:
                objArr[1] = "getTypeParameters";
                break;
            case 19:
                objArr[1] = "getValueParameters";
                break;
            case 20:
                objArr[1] = "getOriginal";
                break;
            case 21:
                objArr[1] = "getKind";
                break;
            case 23:
                objArr[1] = "newCopyBuilder";
                break;
            case 26:
                objArr[1] = ChatTracker.CLICK_COPY;
                break;
            case 27:
                objArr[1] = "getSourceToUseForCopy";
                break;
        }
        switch (i10) {
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[2] = McpSchema.METHOD_INITIALIZE;
                break;
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                break;
            case 10:
                objArr[2] = "setVisibility";
                break;
            case 11:
                objArr[2] = "setReturnType";
                break;
            case 12:
                objArr[2] = "setExtensionReceiverParameter";
                break;
            case 17:
                objArr[2] = "setOverriddenDescriptors";
                break;
            case 22:
                objArr[2] = "substitute";
                break;
            case 24:
                objArr[2] = "newCopyBuilder";
                break;
            case 25:
                objArr[2] = "doSubstitute";
                break;
            case 28:
            case 29:
            case 30:
            case 31:
                objArr[2] = "getSubstitutedValueParameters";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                throw new IllegalStateException(str2);
            case 10:
            case 11:
            case 12:
            case 17:
            case 22:
            case 24:
            case 25:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    private void X0(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        this.f3163C = eVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean A() {
        return this.f3177q;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    /* renamed from: E0 */
    public kotlin.reflect.jvm.internal.impl.descriptors.e y(InterfaceC0803h interfaceC0803h, Modality modality, AbstractC0811p abstractC0811p, CallableMemberDescriptor.Kind kind, boolean z10) {
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarBuild = s().s(interfaceC0803h).i(modality).r(abstractC0811p).q(kind).m(z10).build();
        if (eVarBuild == null) {
            T(26);
        }
        return eVarBuild;
    }

    public abstract AbstractC0839s F0(InterfaceC0803h interfaceC0803h, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, CallableMemberDescriptor.Kind kind, ga.e eVar2, F9.g gVar, E9.W w10);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v3 */
    public kotlin.reflect.jvm.internal.impl.descriptors.e G0(c cVar) {
        ?? r15;
        N n10;
        kotlin.reflect.jvm.internal.impl.descriptors.e eVar;
        ya.S sQ;
        if (cVar == null) {
            T(25);
        }
        boolean[] zArr = new boolean[1];
        F9.g gVarA = cVar.f3208s != null ? F9.i.a(getAnnotations(), cVar.f3208s) : getAnnotations();
        InterfaceC0803h interfaceC0803h = cVar.f3191b;
        kotlin.reflect.jvm.internal.impl.descriptors.e eVar2 = cVar.f3194e;
        AbstractC0839s abstractC0839sF0 = F0(interfaceC0803h, eVar2, cVar.f3195f, cVar.f3201l, gVarA, H0(cVar.f3204o, eVar2));
        List<b0> typeParameters = cVar.f3207r == null ? getTypeParameters() : cVar.f3207r;
        zArr[0] = zArr[0] | (!typeParameters.isEmpty());
        ArrayList arrayList = new ArrayList(typeParameters.size());
        TypeSubstitutor typeSubstitutorC = C5967B.c(typeParameters, cVar.f3190a, abstractC0839sF0, arrayList, zArr);
        E9.S s10 = null;
        if (typeSubstitutorC == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        if (!cVar.f3197h.isEmpty()) {
            int i10 = 0;
            for (E9.S s11 : cVar.f3197h) {
                ya.S sQ2 = typeSubstitutorC.q(s11.getType(), Variance.IN_VARIANCE);
                if (sQ2 == null) {
                    return null;
                }
                int i11 = i10 + 1;
                arrayList2.add(C4827g.b(abstractC0839sF0, sQ2, ((InterfaceC5459f) s11.getValue()).a(), s11.getAnnotations(), i10));
                zArr[0] = zArr[0] | (sQ2 != s11.getType());
                i10 = i11;
            }
        }
        E9.S s12 = cVar.f3198i;
        if (s12 != null) {
            ya.S sQ3 = typeSubstitutorC.q(s12.getType(), Variance.IN_VARIANCE);
            if (sQ3 == null) {
                return null;
            }
            N n11 = new N(abstractC0839sF0, new C5457d(abstractC0839sF0, sQ3, cVar.f3198i.getValue()), cVar.f3198i.getAnnotations());
            zArr[0] = (sQ3 != cVar.f3198i.getType()) | zArr[0];
            r15 = 0;
            n10 = n11;
        } else {
            r15 = 0;
            n10 = null;
        }
        E9.S s13 = cVar.f3199j;
        if (s13 != null) {
            E9.S sC = s13.c(typeSubstitutorC);
            if (sC == null) {
                return null;
            }
            zArr[r15] = zArr[r15] | (sC != cVar.f3199j ? true : r15);
            eVar = null;
            s10 = sC;
        } else {
            eVar = null;
        }
        List<i0> listJ0 = J0(abstractC0839sF0, cVar.f3196g, typeSubstitutorC, cVar.f3205p, cVar.f3204o, zArr);
        if (listJ0 == null || (sQ = typeSubstitutorC.q(cVar.f3200k, Variance.OUT_VARIANCE)) == null) {
            return eVar;
        }
        boolean z10 = zArr[r15] | (sQ != cVar.f3200k ? true : r15);
        zArr[r15] = z10;
        if (!z10 && cVar.f3212w) {
            return this;
        }
        abstractC0839sF0.L0(n10, s10, arrayList2, arrayList, listJ0, sQ, cVar.f3192c, cVar.f3193d);
        abstractC0839sF0.Z0(this.f3173m);
        abstractC0839sF0.W0(this.f3174n);
        abstractC0839sF0.R0(this.f3175o);
        abstractC0839sF0.Y0(this.f3176p);
        abstractC0839sF0.c1(this.f3177q);
        abstractC0839sF0.b1(this.f3182v);
        abstractC0839sF0.Q0(this.f3178r);
        abstractC0839sF0.P0(this.f3179s);
        abstractC0839sF0.S0(this.f3183w);
        abstractC0839sF0.V0(cVar.f3206q);
        abstractC0839sF0.U0(cVar.f3209t);
        abstractC0839sF0.T0(cVar.f3211v != null ? cVar.f3211v.booleanValue() : this.f3184x);
        if (!cVar.f3210u.isEmpty() || this.f3164D != null) {
            Map<a.InterfaceC0437a<?>, Object> map = cVar.f3210u;
            Map<a.InterfaceC0437a<?>, Object> map2 = this.f3164D;
            if (map2 != null) {
                for (Map.Entry<a.InterfaceC0437a<?>, Object> entry : map2.entrySet()) {
                    if (!map.containsKey(entry.getKey())) {
                        map.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            if (map.size() == 1) {
                abstractC0839sF0.f3164D = Collections.singletonMap(map.keySet().iterator().next(), map.values().iterator().next());
            } else {
                abstractC0839sF0.f3164D = map;
            }
        }
        if (cVar.f3203n || m0() != null) {
            abstractC0839sF0.X0((m0() != null ? m0() : this).c(typeSubstitutorC));
        }
        if (cVar.f3202m && !a().d().isEmpty()) {
            if (cVar.f3190a.f()) {
                InterfaceC5063a<Collection<kotlin.reflect.jvm.internal.impl.descriptors.e>> interfaceC5063a = this.f3186z;
                if (interfaceC5063a != null) {
                    abstractC0839sF0.f3186z = interfaceC5063a;
                    return abstractC0839sF0;
                }
                abstractC0839sF0.x0(d());
                return abstractC0839sF0;
            }
            abstractC0839sF0.f3186z = new a(typeSubstitutorC);
        }
        return abstractC0839sF0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public E9.S H() {
        return this.f3170j;
    }

    public final E9.W H0(boolean z10, kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        E9.W wE;
        if (z10) {
            if (eVar == null) {
                eVar = a();
            }
            wE = eVar.e();
        } else {
            wE = E9.W.f2444a;
        }
        if (wE == null) {
            T(27);
        }
        return wE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public E9.S K() {
        return this.f3169i;
    }

    public boolean K0() {
        return this.f3183w;
    }

    public AbstractC0839s L0(E9.S s10, E9.S s11, List<E9.S> list, List<? extends b0> list2, List<i0> list3, ya.S s12, Modality modality, AbstractC0811p abstractC0811p) {
        if (list == null) {
            T(5);
        }
        if (list2 == null) {
            T(6);
        }
        if (list3 == null) {
            T(7);
        }
        if (abstractC0811p == null) {
            T(8);
        }
        this.f3165e = Z8.F.m1(list2);
        this.f3166f = Z8.F.m1(list3);
        this.f3167g = s12;
        this.f3171k = modality;
        this.f3172l = abstractC0811p;
        this.f3169i = s10;
        this.f3170j = s11;
        this.f3168h = list;
        for (int i10 = 0; i10 < list2.size(); i10++) {
            b0 b0Var = list2.get(i10);
            if (b0Var.getIndex() != i10) {
                throw new IllegalStateException(b0Var + " index is " + b0Var.getIndex() + " but position is " + i10);
            }
        }
        for (int i11 = 0; i11 < list3.size(); i11++) {
            i0 i0Var = list3.get(i11);
            if (i0Var.getIndex() != i11) {
                throw new IllegalStateException(i0Var + "index is " + i0Var.getIndex() + " but position is " + i11);
            }
        }
        return this;
    }

    public c M0(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            T(24);
        }
        return new c(this, typeSubstitutor.k(), b(), p(), getVisibility(), getKind(), i(), s0(), K(), getReturnType(), null);
    }

    public final void N0() {
        InterfaceC5063a<Collection<kotlin.reflect.jvm.internal.impl.descriptors.e>> interfaceC5063a = this.f3186z;
        if (interfaceC5063a != null) {
            this.f3185y = interfaceC5063a.invoke();
            this.f3186z = null;
        }
    }

    public <V> void O0(a.InterfaceC0437a<V> interfaceC0437a, Object obj) {
        if (this.f3164D == null) {
            this.f3164D = new LinkedHashMap();
        }
        this.f3164D.put(interfaceC0437a, obj);
    }

    public void P0(boolean z10) {
        this.f3179s = z10;
    }

    public void Q0(boolean z10) {
        this.f3178r = z10;
    }

    public void R0(boolean z10) {
        this.f3175o = z10;
    }

    @Override // E9.InterfaceC0816v
    public boolean S() {
        return this.f3179s;
    }

    public void S0(boolean z10) {
        this.f3183w = z10;
    }

    public void T0(boolean z10) {
        this.f3184x = z10;
    }

    public final void U0(boolean z10) {
        this.f3181u = z10;
    }

    public final void V0(boolean z10) {
        this.f3180t = z10;
    }

    public void W0(boolean z10) {
        this.f3174n = z10;
    }

    public void Y0(boolean z10) {
        this.f3176p = z10;
    }

    public void Z0(boolean z10) {
        this.f3173m = z10;
    }

    public void a1(ya.S s10) {
        if (s10 == null) {
            T(11);
        }
        this.f3167g = s10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public boolean b0() {
        return this.f3184x;
    }

    public void b1(boolean z10) {
        this.f3182v = z10;
    }

    public void c1(boolean z10) {
        this.f3177q = z10;
    }

    public Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.e> d() {
        N0();
        Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.e> collection = this.f3185y;
        if (collection == null) {
            collection = Collections.EMPTY_LIST;
        }
        if (collection == null) {
            T(14);
        }
        return collection;
    }

    public void d1(AbstractC0811p abstractC0811p) {
        if (abstractC0811p == null) {
            T(10);
        }
        this.f3172l = abstractC0811p;
    }

    @Override // E9.InterfaceC0816v
    public boolean e0() {
        return this.f3178r;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public CallableMemberDescriptor.Kind getKind() {
        CallableMemberDescriptor.Kind kind = this.f3162B;
        if (kind == null) {
            T(21);
        }
        return kind;
    }

    public ya.S getReturnType() {
        return this.f3167g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public List<b0> getTypeParameters() {
        List<b0> list = this.f3165e;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("typeParameters == null for " + this);
    }

    @Override // E9.InterfaceC0807l, E9.InterfaceC0816v
    public AbstractC0811p getVisibility() {
        AbstractC0811p abstractC0811p = this.f3172l;
        if (abstractC0811p == null) {
            T(16);
        }
        return abstractC0811p;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public List<i0> i() {
        List<i0> list = this.f3166f;
        if (list == null) {
            T(19);
        }
        return list;
    }

    @Override // E9.InterfaceC0816v
    public boolean isExternal() {
        return this.f3175o;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean isInfix() {
        if (this.f3174n) {
            return true;
        }
        Iterator<? extends kotlin.reflect.jvm.internal.impl.descriptors.e> it = a().d().iterator();
        while (it.hasNext()) {
            if (it.next().isInfix()) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean isInline() {
        return this.f3176p;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean isOperator() {
        if (this.f3173m) {
            return true;
        }
        Iterator<? extends kotlin.reflect.jvm.internal.impl.descriptors.e> it = a().d().iterator();
        while (it.hasNext()) {
            if (it.next().isOperator()) {
                return true;
            }
        }
        return false;
    }

    public boolean isSuspend() {
        return this.f3182v;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.descriptors.e m0() {
        return this.f3163C;
    }

    public <V> V o0(a.InterfaceC0437a<V> interfaceC0437a) {
        Map<a.InterfaceC0437a<?>, Object> map = this.f3164D;
        if (map == null) {
            return null;
        }
        return (V) map.get(interfaceC0437a);
    }

    @Override // E9.InterfaceC0816v
    public Modality p() {
        Modality modality = this.f3171k;
        if (modality == null) {
            T(15);
        }
        return modality;
    }

    public e.a<? extends kotlin.reflect.jvm.internal.impl.descriptors.e> s() {
        c cVarM0 = M0(TypeSubstitutor.f36088b);
        if (cVarM0 == null) {
            T(23);
        }
        return cVarM0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public List<E9.S> s0() {
        List<E9.S> list = this.f3168h;
        if (list == null) {
            T(13);
        }
        return list;
    }

    public <R, D> R v(InterfaceC0805j<R, D> interfaceC0805j, D d10) {
        return interfaceC0805j.i(this, d10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean w0() {
        return this.f3180t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void x0(Collection<? extends CallableMemberDescriptor> collection) {
        if (collection == 0) {
            T(17);
        }
        this.f3185y = collection;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (((kotlin.reflect.jvm.internal.impl.descriptors.e) it.next()).z0()) {
                this.f3181u = true;
                return;
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean z0() {
        return this.f3181u;
    }

    @Override // E9.Y
    public kotlin.reflect.jvm.internal.impl.descriptors.e c(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            T(22);
        }
        return typeSubstitutor.l() ? this : M0(typeSubstitutor).l(a()).j().J(true).build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.reflect.jvm.internal.impl.descriptors.e] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    @Override // H9.AbstractC0835n
    public kotlin.reflect.jvm.internal.impl.descriptors.e a() {
        kotlin.reflect.jvm.internal.impl.descriptors.e eVar = this.f3161A;
        ?? A10 = this;
        if (eVar != this) {
            A10 = eVar.a();
        }
        if (A10 == 0) {
            T(20);
        }
        return A10;
    }
}
