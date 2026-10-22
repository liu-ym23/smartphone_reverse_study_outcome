package X9;

import E9.b0;
import Z8.X;
import Z8.Z;
import java.util.Set;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import ya.AbstractC5990d0;
import ya.C5972G;

/* loaded from: classes5.dex */
public final class a extends C5972G {

    /* renamed from: d, reason: collision with root package name */
    public final TypeUsage f6866d;

    /* renamed from: e, reason: collision with root package name */
    public final JavaTypeFlexibility f6867e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f6868f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f6869g;

    /* renamed from: h, reason: collision with root package name */
    public final Set<b0> f6870h;

    /* renamed from: i, reason: collision with root package name */
    public final AbstractC5990d0 f6871i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public a(TypeUsage howThisTypeIsUsed, JavaTypeFlexibility flexibility, boolean z10, boolean z11, Set<? extends b0> set, AbstractC5990d0 abstractC5990d0) {
        super(howThisTypeIsUsed, set, abstractC5990d0);
        p.i(howThisTypeIsUsed, "howThisTypeIsUsed");
        p.i(flexibility, "flexibility");
        this.f6866d = howThisTypeIsUsed;
        this.f6867e = flexibility;
        this.f6868f = z10;
        this.f6869g = z11;
        this.f6870h = set;
        this.f6871i = abstractC5990d0;
    }

    public static /* synthetic */ a f(a aVar, TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z10, boolean z11, Set set, AbstractC5990d0 abstractC5990d0, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            typeUsage = aVar.f6866d;
        }
        if ((i10 & 2) != 0) {
            javaTypeFlexibility = aVar.f6867e;
        }
        if ((i10 & 4) != 0) {
            z10 = aVar.f6868f;
        }
        if ((i10 & 8) != 0) {
            z11 = aVar.f6869g;
        }
        if ((i10 & 16) != 0) {
            set = aVar.f6870h;
        }
        if ((i10 & 32) != 0) {
            abstractC5990d0 = aVar.f6871i;
        }
        Set set2 = set;
        AbstractC5990d0 abstractC5990d02 = abstractC5990d0;
        return aVar.e(typeUsage, javaTypeFlexibility, z10, z11, set2, abstractC5990d02);
    }

    @Override // ya.C5972G
    public AbstractC5990d0 a() {
        return this.f6871i;
    }

    @Override // ya.C5972G
    public TypeUsage b() {
        return this.f6866d;
    }

    @Override // ya.C5972G
    public Set<b0> c() {
        return this.f6870h;
    }

    public final a e(TypeUsage howThisTypeIsUsed, JavaTypeFlexibility flexibility, boolean z10, boolean z11, Set<? extends b0> set, AbstractC5990d0 abstractC5990d0) {
        p.i(howThisTypeIsUsed, "howThisTypeIsUsed");
        p.i(flexibility, "flexibility");
        return new a(howThisTypeIsUsed, flexibility, z10, z11, set, abstractC5990d0);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return p.d(aVar.a(), a()) && aVar.b() == b() && aVar.f6867e == this.f6867e && aVar.f6868f == this.f6868f && aVar.f6869g == this.f6869g;
    }

    public final JavaTypeFlexibility g() {
        return this.f6867e;
    }

    public final boolean h() {
        return this.f6869g;
    }

    @Override // ya.C5972G
    public int hashCode() {
        AbstractC5990d0 abstractC5990d0A = a();
        int iHashCode = abstractC5990d0A != null ? abstractC5990d0A.hashCode() : 0;
        int iHashCode2 = iHashCode + (iHashCode * 31) + b().hashCode();
        int iHashCode3 = iHashCode2 + (iHashCode2 * 31) + this.f6867e.hashCode();
        int i10 = iHashCode3 + (iHashCode3 * 31) + (this.f6868f ? 1 : 0);
        return i10 + (i10 * 31) + (this.f6869g ? 1 : 0);
    }

    public final boolean i() {
        return this.f6868f;
    }

    public final a j(boolean z10) {
        return f(this, null, null, z10, false, null, null, 59, null);
    }

    public a k(AbstractC5990d0 abstractC5990d0) {
        return f(this, null, null, false, false, null, abstractC5990d0, 31, null);
    }

    public final a l(JavaTypeFlexibility flexibility) {
        p.i(flexibility, "flexibility");
        return f(this, null, flexibility, false, false, null, null, 61, null);
    }

    @Override // ya.C5972G
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public a d(b0 typeParameter) {
        p.i(typeParameter, "typeParameter");
        return f(this, null, null, false, false, c() != null ? Z.p(c(), typeParameter) : X.d(typeParameter), null, 47, null);
    }

    public String toString() {
        return "JavaTypeAttributes(howThisTypeIsUsed=" + this.f6866d + ", flexibility=" + this.f6867e + ", isRaw=" + this.f6868f + ", isForAnnotationParameter=" + this.f6869g + ", visitedTypeParameters=" + this.f6870h + ", defaultType=" + this.f6871i + ')';
    }

    public /* synthetic */ a(TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z10, boolean z11, Set set, AbstractC5990d0 abstractC5990d0, int i10, kotlin.jvm.internal.i iVar) {
        this(typeUsage, (i10 & 2) != 0 ? JavaTypeFlexibility.INFLEXIBLE : javaTypeFlexibility, (i10 & 4) != 0 ? false : z10, (i10 & 8) != 0 ? false : z11, (i10 & 16) != 0 ? null : set, (i10 & 32) != 0 ? null : abstractC5990d0);
    }
}
