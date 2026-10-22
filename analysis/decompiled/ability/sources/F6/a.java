package F6;

import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: A, reason: collision with root package name */
    public final int f555A;

    /* renamed from: B, reason: collision with root package name */
    public final boolean f556B;

    /* renamed from: C, reason: collision with root package name */
    public final int f557C;

    /* renamed from: D, reason: collision with root package name */
    public final boolean f558D;
    public final int E;

    /* renamed from: F, reason: collision with root package name */
    public final boolean f559F;

    /* renamed from: G, reason: collision with root package name */
    public final boolean f560G;

    /* renamed from: H, reason: collision with root package name */
    public final int f561H;

    /* renamed from: I, reason: collision with root package name */
    public final Integer f562I;

    /* renamed from: J, reason: collision with root package name */
    public final int f563J;

    /* renamed from: K, reason: collision with root package name */
    public final CharSequence f564K;

    /* renamed from: L, reason: collision with root package name */
    public final int f565L;

    /* renamed from: M, reason: collision with root package name */
    public final boolean f566M;

    /* renamed from: N, reason: collision with root package name */
    public final boolean f567N;

    /* renamed from: O, reason: collision with root package name */
    public final boolean f568O;

    /* renamed from: P, reason: collision with root package name */
    public final boolean f569P;

    /* renamed from: Q, reason: collision with root package name */
    public final int f570Q;

    /* renamed from: R, reason: collision with root package name */
    public final int f571R;

    /* renamed from: S, reason: collision with root package name */
    public final int f572S;

    /* renamed from: T, reason: collision with root package name */
    public final int f573T;

    /* renamed from: U, reason: collision with root package name */
    public final int f574U;

    /* renamed from: a, reason: collision with root package name */
    public final int f575a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final boolean i;

    /* renamed from: j, reason: collision with root package name */
    public final CharSequence f576j;
    public final CharSequence k;
    public final CharSequence l;
    public final CharSequence m;
    public final boolean n;
    public final Integer o;
    public final int p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f577q;

    /* renamed from: r, reason: collision with root package name */
    public final Integer f578r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f579s;

    /* renamed from: t, reason: collision with root package name */
    public final int f580t;
    public final boolean u;

    /* renamed from: v, reason: collision with root package name */
    public final int f581v;

    /* renamed from: w, reason: collision with root package name */
    public final boolean f582w;

    /* renamed from: x, reason: collision with root package name */
    public final float f583x;
    public final int y;

    /* renamed from: z, reason: collision with root package name */
    public final boolean f584z;

    public a(int i, int i6, int i10, int i11, int i12, int i13, int i14, int i15, boolean z10, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, boolean z11, Integer num, int i16, boolean z12, Integer num2, boolean z13, int i17, boolean z14, int i18, boolean z15, float f, int i19, boolean z16, int i20, boolean z17, int i21, boolean z18, int i22, boolean z19, boolean z20, int i23, Integer num3, int i24, CharSequence charSequence5, int i25, boolean z21, boolean z22, boolean z23, boolean z24, int i26, int i27, int i28, int i29, int i30) {
        this.f575a = i;
        this.b = i6;
        this.c = i10;
        this.d = i11;
        this.e = i12;
        this.f = i13;
        this.g = i14;
        this.h = i15;
        this.i = z10;
        this.f576j = charSequence;
        this.k = charSequence2;
        this.l = charSequence3;
        this.m = charSequence4;
        this.n = z11;
        this.o = num;
        this.p = i16;
        this.f577q = z12;
        this.f578r = num2;
        this.f579s = z13;
        this.f580t = i17;
        this.u = z14;
        this.f581v = i18;
        this.f582w = z15;
        this.f583x = f;
        this.y = i19;
        this.f584z = z16;
        this.f555A = i20;
        this.f556B = z17;
        this.f557C = i21;
        this.f558D = z18;
        this.E = i22;
        this.f559F = z19;
        this.f560G = z20;
        this.f561H = i23;
        this.f562I = num3;
        this.f563J = i24;
        this.f564K = charSequence5;
        this.f565L = i25;
        this.f566M = z21;
        this.f567N = z22;
        this.f568O = z23;
        this.f569P = z24;
        this.f570Q = i26;
        this.f571R = i27;
        this.f572S = i28;
        this.f573T = i29;
        this.f574U = i30;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f575a == aVar.f575a && this.b == aVar.b && this.c == aVar.c && this.d == aVar.d && this.e == aVar.e && this.f == aVar.f && this.g == aVar.g && this.h == aVar.h && this.i == aVar.i && k.b(this.f576j, aVar.f576j) && k.b(this.k, aVar.k) && k.b(this.l, aVar.l) && k.b(this.m, aVar.m) && this.n == aVar.n && k.b(this.o, aVar.o) && this.p == aVar.p && this.f577q == aVar.f577q && k.b(this.f578r, aVar.f578r) && this.f579s == aVar.f579s && this.f580t == aVar.f580t && this.u == aVar.u && this.f581v == aVar.f581v && this.f582w == aVar.f582w && Float.compare(this.f583x, aVar.f583x) == 0 && this.y == aVar.y && this.f584z == aVar.f584z && this.f555A == aVar.f555A && this.f556B == aVar.f556B && this.f557C == aVar.f557C && this.f558D == aVar.f558D && this.E == aVar.E && this.f559F == aVar.f559F && this.f560G == aVar.f560G && this.f561H == aVar.f561H && k.b(this.f562I, aVar.f562I) && this.f563J == aVar.f563J && k.b(this.f564K, aVar.f564K) && this.f565L == aVar.f565L && this.f566M == aVar.f566M && this.f567N == aVar.f567N && this.f568O == aVar.f568O && this.f569P == aVar.f569P && this.f570Q == aVar.f570Q && this.f571R == aVar.f571R && this.f572S == aVar.f572S && this.f573T == aVar.f573T && this.f574U == aVar.f574U;
    }

    public final int hashCode() {
        int iD = androidx.appfunctions.metadata.a.d(androidx.constraintlayout.core.dsl.a.a(this.h, androidx.constraintlayout.core.dsl.a.a(this.g, androidx.constraintlayout.core.dsl.a.a(this.f, androidx.constraintlayout.core.dsl.a.a(this.e, androidx.constraintlayout.core.dsl.a.a(this.d, androidx.constraintlayout.core.dsl.a.a(this.c, androidx.constraintlayout.core.dsl.a.a(this.b, Integer.hashCode(this.f575a) * 31, 31), 31), 31), 31), 31), 31), 31), 31, this.i);
        CharSequence charSequence = this.f576j;
        int iHashCode = (iD + (charSequence == null ? 0 : charSequence.hashCode())) * 31;
        CharSequence charSequence2 = this.k;
        int iHashCode2 = (iHashCode + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
        CharSequence charSequence3 = this.l;
        int iHashCode3 = (iHashCode2 + (charSequence3 == null ? 0 : charSequence3.hashCode())) * 31;
        CharSequence charSequence4 = this.m;
        int iD2 = androidx.appfunctions.metadata.a.d((iHashCode3 + (charSequence4 == null ? 0 : charSequence4.hashCode())) * 31, 31, this.n);
        Integer num = this.o;
        int iD3 = androidx.appfunctions.metadata.a.d(androidx.constraintlayout.core.dsl.a.a(this.p, (iD2 + (num == null ? 0 : num.hashCode())) * 31, 31), 31, this.f577q);
        Integer num2 = this.f578r;
        int iA = androidx.constraintlayout.core.dsl.a.a(this.f561H, androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.d(androidx.constraintlayout.core.dsl.a.a(this.E, androidx.appfunctions.metadata.a.d(androidx.constraintlayout.core.dsl.a.a(this.f557C, androidx.appfunctions.metadata.a.d(androidx.constraintlayout.core.dsl.a.a(this.f555A, androidx.appfunctions.metadata.a.d(androidx.constraintlayout.core.dsl.a.a(this.y, androidx.appfunctions.metadata.a.b(this.f583x, androidx.appfunctions.metadata.a.d(androidx.constraintlayout.core.dsl.a.a(this.f581v, androidx.appfunctions.metadata.a.d(androidx.constraintlayout.core.dsl.a.a(this.f580t, androidx.appfunctions.metadata.a.d((iD3 + (num2 == null ? 0 : num2.hashCode())) * 31, 31, this.f579s), 31), 31, this.u), 31), 31, this.f582w), 31), 31), 31, this.f584z), 31), 31, this.f556B), 31), 31, this.f558D), 31), 31, this.f559F), 31, this.f560G), 31);
        Integer num3 = this.f562I;
        int iA2 = androidx.constraintlayout.core.dsl.a.a(this.f563J, (iA + (num3 == null ? 0 : num3.hashCode())) * 31, 31);
        CharSequence charSequence5 = this.f564K;
        return Integer.hashCode(this.f574U) + androidx.constraintlayout.core.dsl.a.a(this.f573T, androidx.constraintlayout.core.dsl.a.a(this.f572S, androidx.constraintlayout.core.dsl.a.a(this.f571R, androidx.constraintlayout.core.dsl.a.a(this.f570Q, androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.d(androidx.constraintlayout.core.dsl.a.a(this.f565L, (iA2 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31, 31), 31, this.f566M), 31, this.f567N), 31, this.f568O), 31, this.f569P), 31), 31), 31), 31);
    }

    public final String toString() {
        StringBuilder sbS = androidx.appfunctions.metadata.a.s(this.f575a, "PreferenceListItemBridgeState(minHeight=", this.b, ", paddingHorizontal=", ", paddingVertical=");
        androidx.constraintlayout.core.dsl.a.y(sbS, this.c, ", iconTextGap=", this.d, ", titleTextAppearance=");
        androidx.constraintlayout.core.dsl.a.y(sbS, this.e, ", subtitleTextAppearance=", this.f, ", valueTextAppearance=");
        androidx.constraintlayout.core.dsl.a.y(sbS, this.g, ", subtitleMaxLines=", this.h, ", adaptiveTextLayoutEnabled=");
        sbS.append(this.i);
        sbS.append(", title=");
        sbS.append((Object) this.f576j);
        sbS.append(", titleEndText=");
        sbS.append((Object) this.k);
        sbS.append(", subtitle=");
        sbS.append((Object) this.l);
        sbS.append(", rightText=");
        sbS.append((Object) this.m);
        sbS.append(", iconBackgroundExplicit=");
        sbS.append(this.n);
        sbS.append(", iconBackgroundColor=");
        sbS.append(this.o);
        sbS.append(", iconDrawableRes=");
        sbS.append(this.p);
        sbS.append(", iconTintExplicit=");
        sbS.append(this.f577q);
        sbS.append(", iconTint=");
        sbS.append(this.f578r);
        sbS.append(", iconVisible=");
        sbS.append(this.f579s);
        sbS.append(", iconStyle=");
        sbS.append(this.f580t);
        sbS.append(", iconSizeSet=");
        sbS.append(this.u);
        sbS.append(", iconSize=");
        sbS.append(this.f581v);
        sbS.append(", iconCornerRadiusSet=");
        sbS.append(this.f582w);
        sbS.append(", iconCornerRadius=");
        sbS.append(this.f583x);
        sbS.append(", badgeStyle=");
        sbS.append(this.y);
        sbS.append(", badgeTintSet=");
        sbS.append(this.f584z);
        sbS.append(", badgeTint=");
        sbS.append(this.f555A);
        sbS.append(", showBadge=");
        sbS.append(this.f556B);
        sbS.append(", rightBadgeStyle=");
        sbS.append(this.f557C);
        sbS.append(", rightBadgeTintSet=");
        sbS.append(this.f558D);
        sbS.append(", rightBadgeTint=");
        sbS.append(this.E);
        sbS.append(", showRightBadge=");
        sbS.append(this.f559F);
        sbS.append(", showAccessory=");
        sbS.append(this.f560G);
        sbS.append(", accessoryIconRes=");
        sbS.append(this.f561H);
        sbS.append(", accessorySize=");
        sbS.append(this.f562I);
        sbS.append(", trailingType=");
        sbS.append(this.f563J);
        sbS.append(", buttonText=");
        sbS.append((Object) this.f564K);
        sbS.append(", lineMode=");
        sbS.append(this.f565L);
        sbS.append(", checked=");
        sbS.append(this.f566M);
        sbS.append(", switchChecked=");
        sbS.append(this.f567N);
        sbS.append(", pressScaleEnabled=");
        sbS.append(this.f568O);
        sbS.append(", showDivider=");
        sbS.append(this.f569P);
        sbS.append(", dividerHeight=");
        androidx.constraintlayout.core.dsl.a.y(sbS, this.f570Q, ", dividerInsetStart=", this.f571R, ", dividerInsetEnd=");
        androidx.constraintlayout.core.dsl.a.y(sbS, this.f572S, ", dividerColor=", this.f573T, ", titleStyle=");
        return androidx.appfunctions.metadata.a.o(sbS, ")", this.f574U);
    }
}
