package bja;

import cja.c;
import com.facebook.keyframes.model.KFAnimation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes33.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f19254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f19255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f19256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f19257d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f19258e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public T f19259f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public T f19260g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final gja.a<T> f19261h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Float f19262i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final KClass<T> f19263j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f19264k;

    public a() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L20;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f19258e, r101.f19258e) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f19259f, r101.f19259f) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f19260g, r101.f19260g) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f19261h, r101.f19261h) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f19262i, r101.f19262i) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f19263j, r101.f19263j) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.f19264k, r101.f19264k) == 0) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f19258e;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        T r104 = this.f19259f;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        T r107 = this.f19260g;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        gja.a<T> r110 = this.f19261h;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Float r113 = this.f19262i;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        KClass<T> r116 = this.f19263j;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return ((r115 + r101) * 31) + Float.floatToIntBits(this.f19264k);
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "AnimationInfo(property=" + this.f19258e + ", initialValue=" + this.f19259f + ", targetValue=" + this.f19260g + ", spec=" + this.f19261h + ", initialVelocity=" + this.f19262i + ", valueClass=" + this.f19263j + ", currentVelocity=" + this.f19264k + ")";
    }

    public final boolean a(long r100) {
        KClass<T> r101 = this.f19263j;
        if (Intrinsics.areEqual(r101, Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L7;
        cja.a r102 = cja.b.f23989a;
    L5:
        cja.a r103 = r102;
        if (this.f19254a >= 0) goto L17;
        gja.a<T> r104 = this.f19261h;
        T r105 = this.f19259f;
        T r106 = this.f19260g;
        Float r107 = this.f19262i;
        if (r107 == null) goto L14;
        float r108 = r107.floatValue();
    L15:
        this.f19254a = r104.b(r105, r106, r108);
        goto L17
    L14:
        r108 = 0.0f;
    L17:
        return r103.a(r100, this.f19254a, this.f19261h);
    L7:
        if (Intrinsics.areEqual(r101, Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L19;
        r102 = c.f23990a;
        goto L5
    L19:
        throw new IllegalArgumentException("Unsupported type " + this.f19263j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(String r100, Object r101, Object r102, gja.a r103, Float r104, KClass r105) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, "initialValue");
        Intrinsics.checkNotNullParameter(r102, "targetValue");
        Intrinsics.checkNotNullParameter(r103, "spec");
        Intrinsics.checkNotNullParameter(r105, "valueClass");
        this.f19258e = r100;
        this.f19259f = r101;
        this.f19260g = r102;
        this.f19261h = r103;
        this.f19262i = r104;
        this.f19263j = r105;
        this.f19264k = 0.0f;
        this.f19254a = -1;
        this.f19255b = -1;
        this.f19256c = -1;
        this.f19257d = true;
    }
}
