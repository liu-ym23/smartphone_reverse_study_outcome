package i8;

import com.google.protobuf.a1;
import com.google.protobuf.g1;
import com.google.protobuf.x0;
import com.google.protobuf.y0;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class t implements f8.s {
    public Boolean A;
    public boolean B;
    public final /* synthetic */ u C;

    /* renamed from: f, reason: collision with root package name */
    public v9.s0 f4852f;

    /* renamed from: g, reason: collision with root package name */
    public f8.j f4853g;

    /* renamed from: h, reason: collision with root package name */
    public int f4854h;

    /* renamed from: i, reason: collision with root package name */
    public f8.n f4855i;

    /* renamed from: j, reason: collision with root package name */
    public f8.t f4856j;

    /* renamed from: k, reason: collision with root package name */
    public int f4857k;

    /* renamed from: l, reason: collision with root package name */
    public List f4858l;

    /* renamed from: m, reason: collision with root package name */
    public final List f4859m;

    /* renamed from: n, reason: collision with root package name */
    public v f4860n;

    /* renamed from: o, reason: collision with root package name */
    public v f4861o;

    /* renamed from: p, reason: collision with root package name */
    public v9.v f4862p;

    /* renamed from: q, reason: collision with root package name */
    public e9.f f4863q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f4864r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f4865s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f4866t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f4867u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f4868v;

    /* renamed from: w, reason: collision with root package name */
    public d7.z f4869w;

    /* renamed from: x, reason: collision with root package name */
    public g8.j f4870x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f4871y;

    /* renamed from: z, reason: collision with root package name */
    public final LinkedHashMap f4872z;

    public t(u uVar, v9.s0 s0Var, f8.j jVar, int i2, f8.n nVar, int i10, List list, List list2, v vVar, v9.v vVar2) {
        if (s0Var == null) {
            e(0);
            throw null;
        }
        if (jVar == null) {
            e(1);
            throw null;
        }
        if (i2 == 0) {
            e(2);
            throw null;
        }
        if (nVar == null) {
            e(3);
            throw null;
        }
        if (i10 == 0) {
            e(4);
            throw null;
        }
        if (list == null) {
            e(5);
            throw null;
        }
        if (list2 == null) {
            e(6);
            throw null;
        }
        if (vVar2 == null) {
            e(7);
            throw null;
        }
        this.C = uVar;
        this.f4856j = null;
        this.f4861o = uVar.f4878o;
        this.f4864r = true;
        this.f4865s = false;
        this.f4866t = false;
        this.f4867u = false;
        this.f4868v = uVar.f4887x;
        this.f4869w = null;
        this.f4870x = null;
        this.f4871y = uVar.f4888y;
        this.f4872z = new LinkedHashMap();
        this.A = null;
        this.B = false;
        this.f4852f = s0Var;
        this.f4853g = jVar;
        this.f4854h = i2;
        this.f4855i = nVar;
        this.f4857k = i10;
        this.f4858l = list;
        this.f4859m = list2;
        this.f4860n = vVar;
        this.f4862p = vVar2;
        this.f4863q = null;
    }

    public static /* synthetic */ void e(int i2) {
        String str;
        int i10;
        switch (i2) {
            case 9:
            case 11:
            case 13:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case 16:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case 20:
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
            case 24:
            case 26:
            case a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
            case 28:
            case 29:
            case 30:
            case a1.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
            case 32:
            case 33:
            case 34:
            case a1.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
            case 38:
            case a1.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
            case a1.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
            case 42:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 10:
            case 12:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case 17:
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
            case 25:
            case g1.FEATURES_FIELD_NUMBER /* 35 */:
            case a1.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
            case a1.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 9:
            case 11:
            case 13:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case 16:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case 20:
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
            case 24:
            case 26:
            case a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
            case 28:
            case 29:
            case 30:
            case a1.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
            case 32:
            case 33:
            case 34:
            case a1.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
            case 38:
            case a1.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
            case a1.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
            case 42:
                i10 = 2;
                break;
            case 10:
            case 12:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case 17:
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
            case 25:
            case g1.FEATURES_FIELD_NUMBER /* 35 */:
            case a1.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
            case a1.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
            default:
                i10 = 3;
                break;
        }
        Object[] objArr = new Object[i10];
        switch (i2) {
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
            case y0.EDITION_FIELD_NUMBER /* 14 */:
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
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case 16:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case 20:
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
            case 24:
            case 26:
            case a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
            case 28:
            case 29:
            case 30:
            case a1.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
            case 32:
            case 33:
            case 34:
            case a1.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
            case 38:
            case a1.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
            case a1.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
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
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
                objArr[0] = "parameters";
                break;
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
                objArr[0] = "type";
                break;
            case 25:
                objArr[0] = "contextReceiverParameters";
                break;
            case g1.FEATURES_FIELD_NUMBER /* 35 */:
                objArr[0] = "additionalAnnotations";
                break;
            case a1.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
            default:
                objArr[0] = "substitution";
                break;
            case a1.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                objArr[0] = "userDataKey";
                break;
        }
        switch (i2) {
            case 9:
                objArr[1] = "setOwner";
                break;
            case 10:
            case 12:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case 17:
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
            case 25:
            case g1.FEATURES_FIELD_NUMBER /* 35 */:
            case a1.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
            case a1.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                break;
            case 11:
                objArr[1] = "setModality";
                break;
            case 13:
                objArr[1] = "setVisibility";
                break;
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                objArr[1] = "setKind";
                break;
            case 16:
                objArr[1] = "setCopyOverrides";
                break;
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                objArr[1] = "setName";
                break;
            case 20:
                objArr[1] = "setValueParameters";
                break;
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
                objArr[1] = "setTypeParameters";
                break;
            case 24:
                objArr[1] = "setReturnType";
                break;
            case 26:
                objArr[1] = "setContextReceiverParameters";
                break;
            case a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
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
            case a1.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
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
            case a1.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                objArr[1] = "setAdditionalAnnotations";
                break;
            case 38:
                objArr[1] = "setSubstitution";
                break;
            case a1.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                objArr[1] = "putUserData";
                break;
            case a1.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
                objArr[1] = "getSubstitution";
                break;
            case 42:
                objArr[1] = "setJustForTypeSubstitution";
                break;
        }
        switch (i2) {
            case 8:
                objArr[2] = "setOwner";
                break;
            case 9:
            case 11:
            case 13:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case 16:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case 20:
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
            case 24:
            case 26:
            case a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
            case 28:
            case 29:
            case 30:
            case a1.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
            case 32:
            case 33:
            case 34:
            case a1.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
            case 38:
            case a1.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
            case a1.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
            case 42:
                break;
            case 10:
                objArr[2] = "setModality";
                break;
            case 12:
                objArr[2] = "setVisibility";
                break;
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                objArr[2] = "setKind";
                break;
            case 17:
                objArr[2] = "setName";
                break;
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
                objArr[2] = "setValueParameters";
                break;
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
                objArr[2] = "setTypeParameters";
                break;
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
                objArr[2] = "setReturnType";
                break;
            case 25:
                objArr[2] = "setContextReceiverParameters";
                break;
            case g1.FEATURES_FIELD_NUMBER /* 35 */:
                objArr[2] = "setAdditionalAnnotations";
                break;
            case a1.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                objArr[2] = "setSubstitution";
                break;
            case a1.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                objArr[2] = "putUserData";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i2) {
            case 9:
            case 11:
            case 13:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case 16:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case 20:
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
            case 24:
            case 26:
            case a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
            case 28:
            case 29:
            case 30:
            case a1.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
            case 32:
            case 33:
            case 34:
            case a1.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
            case 38:
            case a1.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
            case a1.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
            case 42:
                throw new IllegalStateException(str2);
            case 10:
            case 12:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case 17:
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
            case 25:
            case g1.FEATURES_FIELD_NUMBER /* 35 */:
            case a1.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
            case a1.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // f8.s
    public final f8.s C() {
        this.f4872z.put(q8.e.L, Boolean.TRUE);
        return this;
    }

    @Override // f8.s
    public final f8.s D() {
        this.f4871y = true;
        return this;
    }

    @Override // f8.s
    public final f8.s H() {
        this.f4865s = true;
        return this;
    }

    @Override // f8.s
    public final f8.s a() {
        this.f4864r = false;
        return this;
    }

    @Override // f8.s
    public final f8.s b(g8.j jVar) {
        if (jVar != null) {
            this.f4870x = jVar;
            return this;
        }
        e(35);
        throw null;
    }

    @Override // f8.s
    public final f8.t build() {
        return this.C.J0(this);
    }

    @Override // f8.s
    public final f8.s c(e9.f fVar) {
        if (fVar != null) {
            this.f4863q = fVar;
            return this;
        }
        e(17);
        throw null;
    }

    @Override // f8.s
    public final f8.s d(List list) {
        this.f4858l = list;
        return this;
    }

    @Override // f8.s
    public final f8.s g() {
        this.f4869w = d7.z.f2978f;
        return this;
    }

    @Override // f8.s
    public final f8.s m() {
        this.f4868v = true;
        return this;
    }

    @Override // f8.s
    public final f8.s o(int i2) {
        if (i2 != 0) {
            this.f4857k = i2;
            return this;
        }
        e(14);
        throw null;
    }

    @Override // f8.s
    public final f8.s r() {
        this.f4866t = true;
        return this;
    }

    @Override // f8.s
    public final f8.s s(f8.n nVar) {
        if (nVar != null) {
            this.f4855i = nVar;
            return this;
        }
        e(12);
        throw null;
    }

    @Override // f8.s
    public final f8.s v(v vVar) {
        this.f4861o = vVar;
        return this;
    }

    @Override // f8.s
    public final f8.s w(v9.v vVar) {
        if (vVar != null) {
            this.f4862p = vVar;
            return this;
        }
        e(23);
        throw null;
    }

    @Override // f8.s
    public final f8.s x(f8.j jVar) {
        if (jVar != null) {
            this.f4853g = jVar;
            return this;
        }
        e(8);
        throw null;
    }

    @Override // f8.s
    public final f8.s z(int i2) {
        if (i2 != 0) {
            this.f4854h = i2;
            return this;
        }
        e(10);
        throw null;
    }
}
