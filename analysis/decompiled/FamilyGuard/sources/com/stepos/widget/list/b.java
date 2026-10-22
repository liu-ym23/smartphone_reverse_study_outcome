package com.stepos.widget.list;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import g4.C0743a;
import j4.g;
import j4.k;
import l3.C0846d;
import l3.C0847e;
import l3.f;
import l3.m;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: V, reason: collision with root package name */
    public static final a f16254V = new a(null);

    /* renamed from: A, reason: collision with root package name */
    private final int f16255A;

    /* renamed from: B, reason: collision with root package name */
    private final boolean f16256B;

    /* renamed from: C, reason: collision with root package name */
    private final int f16257C;

    /* renamed from: D, reason: collision with root package name */
    private final boolean f16258D;

    /* renamed from: E, reason: collision with root package name */
    private final int f16259E;

    /* renamed from: F, reason: collision with root package name */
    private final boolean f16260F;

    /* renamed from: G, reason: collision with root package name */
    private final boolean f16261G;

    /* renamed from: H, reason: collision with root package name */
    private final int f16262H;

    /* renamed from: I, reason: collision with root package name */
    private final Integer f16263I;

    /* renamed from: J, reason: collision with root package name */
    private final int f16264J;

    /* renamed from: K, reason: collision with root package name */
    private final CharSequence f16265K;

    /* renamed from: L, reason: collision with root package name */
    private final int f16266L;

    /* renamed from: M, reason: collision with root package name */
    private final boolean f16267M;

    /* renamed from: N, reason: collision with root package name */
    private final boolean f16268N;

    /* renamed from: O, reason: collision with root package name */
    private final boolean f16269O;

    /* renamed from: P, reason: collision with root package name */
    private final boolean f16270P;

    /* renamed from: Q, reason: collision with root package name */
    private final int f16271Q;

    /* renamed from: R, reason: collision with root package name */
    private final int f16272R;

    /* renamed from: S, reason: collision with root package name */
    private final int f16273S;

    /* renamed from: T, reason: collision with root package name */
    private final int f16274T;

    /* renamed from: U, reason: collision with root package name */
    private final int f16275U;

    /* renamed from: a, reason: collision with root package name */
    private final int f16276a;

    /* renamed from: b, reason: collision with root package name */
    private final int f16277b;

    /* renamed from: c, reason: collision with root package name */
    private final int f16278c;

    /* renamed from: d, reason: collision with root package name */
    private final int f16279d;

    /* renamed from: e, reason: collision with root package name */
    private final int f16280e;

    /* renamed from: f, reason: collision with root package name */
    private final int f16281f;

    /* renamed from: g, reason: collision with root package name */
    private final int f16282g;

    /* renamed from: h, reason: collision with root package name */
    private final int f16283h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f16284i;

    /* renamed from: j, reason: collision with root package name */
    private final CharSequence f16285j;

    /* renamed from: k, reason: collision with root package name */
    private final CharSequence f16286k;

    /* renamed from: l, reason: collision with root package name */
    private final CharSequence f16287l;

    /* renamed from: m, reason: collision with root package name */
    private final CharSequence f16288m;

    /* renamed from: n, reason: collision with root package name */
    private final boolean f16289n;

    /* renamed from: o, reason: collision with root package name */
    private final Integer f16290o;

    /* renamed from: p, reason: collision with root package name */
    private final int f16291p;

    /* renamed from: q, reason: collision with root package name */
    private final boolean f16292q;

    /* renamed from: r, reason: collision with root package name */
    private final Integer f16293r;

    /* renamed from: s, reason: collision with root package name */
    private final boolean f16294s;

    /* renamed from: t, reason: collision with root package name */
    private final int f16295t;

    /* renamed from: u, reason: collision with root package name */
    private final boolean f16296u;

    /* renamed from: v, reason: collision with root package name */
    private final int f16297v;

    /* renamed from: w, reason: collision with root package name */
    private final boolean f16298w;

    /* renamed from: x, reason: collision with root package name */
    private final float f16299x;

    /* renamed from: y, reason: collision with root package name */
    private final int f16300y;

    /* renamed from: z, reason: collision with root package name */
    private final boolean f16301z;

    public static final class a {
        public /* synthetic */ a(g gVar) {
            this();
        }

        private final int a(AttributeSet attributeSet, String str) {
            if (attributeSet == null) {
                return -1;
            }
            int attributeCount = attributeSet.getAttributeCount();
            for (int i5 = 0; i5 < attributeCount; i5++) {
                if (k.b(attributeSet.getAttributeName(i5), str)) {
                    return i5;
                }
            }
            return -1;
        }

        private final boolean b(AttributeSet attributeSet, String str) {
            if (attributeSet == null) {
                return false;
            }
            return c(attributeSet, str);
        }

        private final boolean e(AttributeSet attributeSet, TypedArray typedArray, int i5, String str, boolean z5) {
            int iA = a(attributeSet, str);
            return (iA < 0 || attributeSet == null) ? typedArray.hasValue(i5) ? typedArray.getBoolean(i5, z5) : z5 : attributeSet.getAttributeBooleanValue(iA, z5);
        }

        private final int f(AttributeSet attributeSet, TypedArray typedArray, int i5, String str, int i6) {
            int iA = a(attributeSet, str);
            return (iA < 0 || attributeSet == null) ? typedArray.hasValue(i5) ? typedArray.getInt(i5, i6) : i6 : attributeSet.getAttributeIntValue(iA, i6);
        }

        private final int g(AttributeSet attributeSet, TypedArray typedArray, int i5, String str) {
            int attributeResourceValue;
            int iA = a(attributeSet, str);
            return (iA < 0 || attributeSet == null || (attributeResourceValue = attributeSet.getAttributeResourceValue(iA, 0)) == 0) ? typedArray.getResourceId(i5, 0) : attributeResourceValue;
        }

        private final CharSequence h(Context context, AttributeSet attributeSet, TypedArray typedArray, int i5, String str) {
            int iA = a(attributeSet, str);
            if (iA < 0 || attributeSet == null) {
                return typedArray.getText(i5);
            }
            int attributeResourceValue = attributeSet.getAttributeResourceValue(iA, 0);
            if (attributeResourceValue == 0) {
                return attributeSet.getAttributeValue(iA);
            }
            try {
                return context.getResources().getText(attributeResourceValue);
            } catch (Exception unused) {
                return null;
            }
        }

        public final boolean c(AttributeSet attributeSet, String str) {
            k.g(attributeSet, "attrs");
            k.g(str, "localName");
            int attributeCount = attributeSet.getAttributeCount();
            for (int i5 = 0; i5 < attributeCount; i5++) {
                if (k.b(attributeSet.getAttributeName(i5), str)) {
                    return true;
                }
            }
            return false;
        }

        public final b d(Context context, AttributeSet attributeSet, int i5, int i6) throws Exception {
            TypedArray typedArray;
            int dimensionPixelSize;
            int dimensionPixelSize2;
            int dimensionPixelSize3;
            int dimensionPixelSize4;
            int dimensionPixelSize5;
            int dimensionPixelSize6;
            int dimensionPixelSize7;
            int resourceId;
            int resourceId2;
            int resourceId3;
            a aVar;
            int iF;
            AttributeSet attributeSet2;
            k.g(context, "context");
            com.stepos.widget.list.a aVarB = com.stepos.widget.list.a.f16205U.b();
            Resources resources = context.getResources();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f18612T2, i5, i6);
            try {
                int dimensionPixelSize8 = resources.getDimensionPixelSize(C0847e.f18331L);
                int dimensionPixelSize9 = resources.getDimensionPixelSize(C0847e.f18343X);
                int dimensionPixelSize10 = resources.getDimensionPixelSize(C0847e.f18344Y);
                int dimensionPixelSize11 = resources.getDimensionPixelSize(C0847e.f18342W);
                dimensionPixelSize = resources.getDimensionPixelSize(C0847e.f18394z);
                dimensionPixelSize2 = resources.getDimensionPixelSize(C0847e.f18321B);
                dimensionPixelSize3 = resources.getDimensionPixelSize(C0847e.f18320A);
                dimensionPixelSize4 = typedArrayObtainStyledAttributes.getDimensionPixelSize(aVarB.y(), dimensionPixelSize8);
                dimensionPixelSize5 = typedArrayObtainStyledAttributes.getDimensionPixelSize(aVarB.z(), dimensionPixelSize9);
                dimensionPixelSize6 = typedArrayObtainStyledAttributes.getDimensionPixelSize(aVarB.A(), dimensionPixelSize10);
                dimensionPixelSize7 = typedArrayObtainStyledAttributes.getDimensionPixelSize(aVarB.u(), dimensionPixelSize11);
                resourceId = typedArrayObtainStyledAttributes.getResourceId(aVarB.R(), 0);
                resourceId2 = typedArrayObtainStyledAttributes.getResourceId(aVarB.M(), 0);
                resourceId3 = typedArrayObtainStyledAttributes.getResourceId(aVarB.V(), 0);
                aVar = b.f16254V;
                k.d(typedArrayObtainStyledAttributes);
                try {
                    iF = aVar.f(attributeSet, typedArrayObtainStyledAttributes, aVarB.L(), "steposListItemSubtitleMaxLines", 1);
                    typedArray = typedArrayObtainStyledAttributes;
                } catch (Throwable th) {
                    th = th;
                    typedArray = typedArrayObtainStyledAttributes;
                }
            } catch (Throwable th2) {
                th = th2;
                typedArray = typedArrayObtainStyledAttributes;
            }
            try {
                boolean z5 = typedArray.getBoolean(aVarB.f(), false);
                CharSequence charSequenceH = aVar.h(context, attributeSet, typedArray, aVarB.O(), "steposListItemTitle");
                CharSequence charSequenceH2 = aVar.h(context, attributeSet, typedArray, aVarB.P(), "steposListItemTitleEndText");
                CharSequence charSequenceH3 = aVar.h(context, attributeSet, typedArray, aVarB.K(), "steposListItemSubtitle");
                CharSequence charSequenceH4 = aVar.h(context, attributeSet, typedArray, aVarB.F(), "steposListItemRightText");
                TypedArray typedArray2 = typedArray;
                if (charSequenceH4 == null) {
                    charSequenceH4 = aVar.h(context, attributeSet, typedArray2, aVarB.T(), "steposListItemValue");
                    attributeSet2 = attributeSet;
                    typedArray2 = typedArray2;
                } else {
                    attributeSet2 = attributeSet;
                }
                CharSequence charSequence = charSequenceH4;
                boolean zB = aVar.b(attributeSet2, "steposListItemIconBackground");
                Integer numValueOf = (aVar.b(attributeSet2, "steposListItemIconBackground") && typedArray2.hasValue(aVarB.q())) ? Integer.valueOf(typedArray2.getColor(aVarB.q(), 0)) : null;
                int iG = aVar.g(attributeSet2, typedArray2, aVarB.p(), "steposListItemIcon");
                boolean zB2 = aVar.b(attributeSet2, "steposListItemIconTint");
                Integer numValueOf2 = (aVar.b(attributeSet2, "steposListItemIconTint") && typedArray2.hasValue(aVarB.v())) ? Integer.valueOf(typedArray2.getColor(aVarB.v(), 0)) : null;
                boolean zE = aVar.e(attributeSet2, typedArray2, aVarB.w(), "steposListItemIconVisible", true);
                int iF2 = aVar.f(attributeSet, typedArray2, aVarB.t(), "steposListItemIconStyle", 0);
                boolean z6 = aVar.b(attributeSet, "steposListItemIconSize") || typedArray2.hasValue(aVarB.s());
                int dimensionPixelSize12 = typedArray2.getDimensionPixelSize(aVarB.s(), 0);
                boolean z7 = aVar.b(attributeSet, "steposListItemIconCornerRadius") || typedArray2.hasValue(aVarB.r());
                float dimension = typedArray2.getDimension(aVarB.r(), 0.0f);
                int iF3 = aVar.f(attributeSet, typedArray2, aVarB.g(), "steposListItemBadgeStyle", 0);
                boolean z8 = aVar.b(attributeSet, "steposListItemBadgeTint") || typedArray2.hasValue(aVarB.h());
                int color = typedArray2.hasValue(aVarB.h()) ? typedArray2.getColor(aVarB.h(), 0) : 0;
                boolean zE2 = aVar.e(attributeSet, typedArray2, aVarB.H(), "steposListItemShowBadge", false);
                int iF4 = aVar.f(attributeSet, typedArray2, aVarB.C(), "steposListItemRightBadgeStyle", 1);
                boolean z9 = aVar.b(attributeSet, "steposListItemRightBadgeTint") || typedArray2.hasValue(aVarB.D());
                int color2 = typedArray2.hasValue(aVarB.D()) ? typedArray2.getColor(aVarB.D(), 0) : 0;
                boolean zE3 = aVar.e(attributeSet, typedArray2, aVarB.J(), "steposListItemShowRightBadge", false);
                boolean zE4 = aVar.e(attributeSet, typedArray2, aVarB.G(), "steposListItemShowAccessory", true);
                Integer numValueOf3 = Integer.valueOf(typedArray2.getResourceId(aVarB.E(), 0));
                if (numValueOf3.intValue() == 0) {
                    numValueOf3 = null;
                }
                int iIntValue = numValueOf3 != null ? numValueOf3.intValue() : typedArray2.getResourceId(aVarB.c(), f.f18401g);
                Integer numValueOf4 = typedArray2.hasValue(aVarB.d()) ? Integer.valueOf(typedArray2.getDimensionPixelSize(aVarB.d(), 0)) : null;
                int iF5 = aVar.f(attributeSet, typedArray2, aVarB.S(), "steposListItemTrailingType", 1);
                typedArrayObtainStyledAttributes = typedArray2;
                typedArray = typedArrayObtainStyledAttributes;
                b bVar = new b(dimensionPixelSize4, dimensionPixelSize5, dimensionPixelSize6, dimensionPixelSize7, resourceId, resourceId2, resourceId3, iF, z5, charSequenceH, charSequenceH2, charSequenceH3, charSequence, zB, numValueOf, iG, zB2, numValueOf2, zE, iF2, z6, dimensionPixelSize12, z7, dimension, iF3, z8, color, zE2, iF4, z9, color2, zE3, zE4, iIntValue, numValueOf4, iF5, aVar.h(context, attributeSet, typedArrayObtainStyledAttributes, aVarB.i(), "steposListItemButtonText"), aVar.f(attributeSet, typedArray, aVarB.x(), "steposListItemLineMode", 0), aVar.e(attributeSet, typedArray, aVarB.j(), "steposListItemChecked", false), aVar.e(attributeSet, typedArray, aVarB.N(), "steposListItemSwitchChecked", false), aVar.e(attributeSet, typedArray, aVarB.B(), "steposListItemPressScaleEnabled", false), aVar.e(attributeSet, typedArray, aVarB.I(), "steposListItemShowDivider", false), typedArray.getDimensionPixelSize(aVarB.l(), dimensionPixelSize), typedArray.getDimensionPixelSize(aVarB.n(), dimensionPixelSize2), typedArray.getDimensionPixelSize(aVarB.m(), dimensionPixelSize3), typedArray.getColor(aVarB.k(), context.getColor(C0846d.f18307n)), aVar.f(attributeSet, typedArray, aVarB.Q(), "steposListItemTitleStyle", 0));
                C0743a.a(typedArray, null);
                return bVar;
            } catch (Throwable th3) {
                th = th3;
                Throwable th4 = th;
                try {
                    throw th4;
                } catch (Throwable th5) {
                    C0743a.a(typedArray, th4);
                    throw th5;
                }
            }
        }

        private a() {
        }
    }

    public b(int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, boolean z5, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, boolean z6, Integer num, int i13, boolean z7, Integer num2, boolean z8, int i14, boolean z9, int i15, boolean z10, float f5, int i16, boolean z11, int i17, boolean z12, int i18, boolean z13, int i19, boolean z14, boolean z15, int i20, Integer num3, int i21, CharSequence charSequence5, int i22, boolean z16, boolean z17, boolean z18, boolean z19, int i23, int i24, int i25, int i26, int i27) {
        this.f16276a = i5;
        this.f16277b = i6;
        this.f16278c = i7;
        this.f16279d = i8;
        this.f16280e = i9;
        this.f16281f = i10;
        this.f16282g = i11;
        this.f16283h = i12;
        this.f16284i = z5;
        this.f16285j = charSequence;
        this.f16286k = charSequence2;
        this.f16287l = charSequence3;
        this.f16288m = charSequence4;
        this.f16289n = z6;
        this.f16290o = num;
        this.f16291p = i13;
        this.f16292q = z7;
        this.f16293r = num2;
        this.f16294s = z8;
        this.f16295t = i14;
        this.f16296u = z9;
        this.f16297v = i15;
        this.f16298w = z10;
        this.f16299x = f5;
        this.f16300y = i16;
        this.f16301z = z11;
        this.f16255A = i17;
        this.f16256B = z12;
        this.f16257C = i18;
        this.f16258D = z13;
        this.f16259E = i19;
        this.f16260F = z14;
        this.f16261G = z15;
        this.f16262H = i20;
        this.f16263I = num3;
        this.f16264J = i21;
        this.f16265K = charSequence5;
        this.f16266L = i22;
        this.f16267M = z16;
        this.f16268N = z17;
        this.f16269O = z18;
        this.f16270P = z19;
        this.f16271Q = i23;
        this.f16272R = i24;
        this.f16273S = i25;
        this.f16274T = i26;
        this.f16275U = i27;
    }

    public final int A() {
        return this.f16277b;
    }

    public final int B() {
        return this.f16278c;
    }

    public final boolean C() {
        return this.f16269O;
    }

    public final int D() {
        return this.f16257C;
    }

    public final int E() {
        return this.f16259E;
    }

    public final boolean F() {
        return this.f16258D;
    }

    public final CharSequence G() {
        return this.f16288m;
    }

    public final boolean H() {
        return this.f16261G;
    }

    public final boolean I() {
        return this.f16256B;
    }

    public final boolean J() {
        return this.f16270P;
    }

    public final boolean K() {
        return this.f16260F;
    }

    public final CharSequence L() {
        return this.f16287l;
    }

    public final int M() {
        return this.f16283h;
    }

    public final int N() {
        return this.f16281f;
    }

    public final boolean O() {
        return this.f16268N;
    }

    public final CharSequence P() {
        return this.f16285j;
    }

    public final CharSequence Q() {
        return this.f16286k;
    }

    public final int R() {
        return this.f16275U;
    }

    public final int S() {
        return this.f16280e;
    }

    public final int T() {
        return this.f16264J;
    }

    public final int U() {
        return this.f16282g;
    }

    public final int a() {
        return this.f16262H;
    }

    public final Integer b() {
        return this.f16263I;
    }

    public final boolean c() {
        return this.f16284i;
    }

    public final int d() {
        return this.f16300y;
    }

    public final int e() {
        return this.f16255A;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f16276a == bVar.f16276a && this.f16277b == bVar.f16277b && this.f16278c == bVar.f16278c && this.f16279d == bVar.f16279d && this.f16280e == bVar.f16280e && this.f16281f == bVar.f16281f && this.f16282g == bVar.f16282g && this.f16283h == bVar.f16283h && this.f16284i == bVar.f16284i && k.b(this.f16285j, bVar.f16285j) && k.b(this.f16286k, bVar.f16286k) && k.b(this.f16287l, bVar.f16287l) && k.b(this.f16288m, bVar.f16288m) && this.f16289n == bVar.f16289n && k.b(this.f16290o, bVar.f16290o) && this.f16291p == bVar.f16291p && this.f16292q == bVar.f16292q && k.b(this.f16293r, bVar.f16293r) && this.f16294s == bVar.f16294s && this.f16295t == bVar.f16295t && this.f16296u == bVar.f16296u && this.f16297v == bVar.f16297v && this.f16298w == bVar.f16298w && Float.compare(this.f16299x, bVar.f16299x) == 0 && this.f16300y == bVar.f16300y && this.f16301z == bVar.f16301z && this.f16255A == bVar.f16255A && this.f16256B == bVar.f16256B && this.f16257C == bVar.f16257C && this.f16258D == bVar.f16258D && this.f16259E == bVar.f16259E && this.f16260F == bVar.f16260F && this.f16261G == bVar.f16261G && this.f16262H == bVar.f16262H && k.b(this.f16263I, bVar.f16263I) && this.f16264J == bVar.f16264J && k.b(this.f16265K, bVar.f16265K) && this.f16266L == bVar.f16266L && this.f16267M == bVar.f16267M && this.f16268N == bVar.f16268N && this.f16269O == bVar.f16269O && this.f16270P == bVar.f16270P && this.f16271Q == bVar.f16271Q && this.f16272R == bVar.f16272R && this.f16273S == bVar.f16273S && this.f16274T == bVar.f16274T && this.f16275U == bVar.f16275U;
    }

    public final boolean f() {
        return this.f16301z;
    }

    public final CharSequence g() {
        return this.f16265K;
    }

    public final boolean h() {
        return this.f16267M;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((Integer.hashCode(this.f16276a) * 31) + Integer.hashCode(this.f16277b)) * 31) + Integer.hashCode(this.f16278c)) * 31) + Integer.hashCode(this.f16279d)) * 31) + Integer.hashCode(this.f16280e)) * 31) + Integer.hashCode(this.f16281f)) * 31) + Integer.hashCode(this.f16282g)) * 31) + Integer.hashCode(this.f16283h)) * 31) + Boolean.hashCode(this.f16284i)) * 31;
        CharSequence charSequence = this.f16285j;
        int iHashCode2 = (iHashCode + (charSequence == null ? 0 : charSequence.hashCode())) * 31;
        CharSequence charSequence2 = this.f16286k;
        int iHashCode3 = (iHashCode2 + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
        CharSequence charSequence3 = this.f16287l;
        int iHashCode4 = (iHashCode3 + (charSequence3 == null ? 0 : charSequence3.hashCode())) * 31;
        CharSequence charSequence4 = this.f16288m;
        int iHashCode5 = (((iHashCode4 + (charSequence4 == null ? 0 : charSequence4.hashCode())) * 31) + Boolean.hashCode(this.f16289n)) * 31;
        Integer num = this.f16290o;
        int iHashCode6 = (((((iHashCode5 + (num == null ? 0 : num.hashCode())) * 31) + Integer.hashCode(this.f16291p)) * 31) + Boolean.hashCode(this.f16292q)) * 31;
        Integer num2 = this.f16293r;
        int iHashCode7 = (((((((((((((((((((((((((((((((((iHashCode6 + (num2 == null ? 0 : num2.hashCode())) * 31) + Boolean.hashCode(this.f16294s)) * 31) + Integer.hashCode(this.f16295t)) * 31) + Boolean.hashCode(this.f16296u)) * 31) + Integer.hashCode(this.f16297v)) * 31) + Boolean.hashCode(this.f16298w)) * 31) + Float.hashCode(this.f16299x)) * 31) + Integer.hashCode(this.f16300y)) * 31) + Boolean.hashCode(this.f16301z)) * 31) + Integer.hashCode(this.f16255A)) * 31) + Boolean.hashCode(this.f16256B)) * 31) + Integer.hashCode(this.f16257C)) * 31) + Boolean.hashCode(this.f16258D)) * 31) + Integer.hashCode(this.f16259E)) * 31) + Boolean.hashCode(this.f16260F)) * 31) + Boolean.hashCode(this.f16261G)) * 31) + Integer.hashCode(this.f16262H)) * 31;
        Integer num3 = this.f16263I;
        int iHashCode8 = (((iHashCode7 + (num3 == null ? 0 : num3.hashCode())) * 31) + Integer.hashCode(this.f16264J)) * 31;
        CharSequence charSequence5 = this.f16265K;
        return ((((((((((((((((((((iHashCode8 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31) + Integer.hashCode(this.f16266L)) * 31) + Boolean.hashCode(this.f16267M)) * 31) + Boolean.hashCode(this.f16268N)) * 31) + Boolean.hashCode(this.f16269O)) * 31) + Boolean.hashCode(this.f16270P)) * 31) + Integer.hashCode(this.f16271Q)) * 31) + Integer.hashCode(this.f16272R)) * 31) + Integer.hashCode(this.f16273S)) * 31) + Integer.hashCode(this.f16274T)) * 31) + Integer.hashCode(this.f16275U);
    }

    public final int i() {
        return this.f16274T;
    }

    public final int j() {
        return this.f16271Q;
    }

    public final int k() {
        return this.f16273S;
    }

    public final int l() {
        return this.f16272R;
    }

    public final Integer m() {
        return this.f16290o;
    }

    public final boolean n() {
        return this.f16289n;
    }

    public final float o() {
        return this.f16299x;
    }

    public final boolean p() {
        return this.f16298w;
    }

    public final int q() {
        return this.f16291p;
    }

    public final int r() {
        return this.f16297v;
    }

    public final boolean s() {
        return this.f16296u;
    }

    public final int t() {
        return this.f16295t;
    }

    public String toString() {
        int i5 = this.f16276a;
        int i6 = this.f16277b;
        int i7 = this.f16278c;
        int i8 = this.f16279d;
        int i9 = this.f16280e;
        int i10 = this.f16281f;
        int i11 = this.f16282g;
        int i12 = this.f16283h;
        boolean z5 = this.f16284i;
        CharSequence charSequence = this.f16285j;
        CharSequence charSequence2 = this.f16286k;
        CharSequence charSequence3 = this.f16287l;
        CharSequence charSequence4 = this.f16288m;
        boolean z6 = this.f16289n;
        Integer num = this.f16290o;
        int i13 = this.f16291p;
        boolean z7 = this.f16292q;
        Integer num2 = this.f16293r;
        boolean z8 = this.f16294s;
        int i14 = this.f16295t;
        boolean z9 = this.f16296u;
        int i15 = this.f16297v;
        boolean z10 = this.f16298w;
        float f5 = this.f16299x;
        int i16 = this.f16300y;
        boolean z11 = this.f16301z;
        int i17 = this.f16255A;
        boolean z12 = this.f16256B;
        int i18 = this.f16257C;
        boolean z13 = this.f16258D;
        int i19 = this.f16259E;
        boolean z14 = this.f16260F;
        boolean z15 = this.f16261G;
        int i20 = this.f16262H;
        Integer num3 = this.f16263I;
        int i21 = this.f16264J;
        CharSequence charSequence5 = this.f16265K;
        return "PreferenceListItemBridgeState(minHeight=" + i5 + ", paddingHorizontal=" + i6 + ", paddingVertical=" + i7 + ", iconTextGap=" + i8 + ", titleTextAppearance=" + i9 + ", subtitleTextAppearance=" + i10 + ", valueTextAppearance=" + i11 + ", subtitleMaxLines=" + i12 + ", adaptiveTextLayoutEnabled=" + z5 + ", title=" + ((Object) charSequence) + ", titleEndText=" + ((Object) charSequence2) + ", subtitle=" + ((Object) charSequence3) + ", rightText=" + ((Object) charSequence4) + ", iconBackgroundExplicit=" + z6 + ", iconBackgroundColor=" + num + ", iconDrawableRes=" + i13 + ", iconTintExplicit=" + z7 + ", iconTint=" + num2 + ", iconVisible=" + z8 + ", iconStyle=" + i14 + ", iconSizeSet=" + z9 + ", iconSize=" + i15 + ", iconCornerRadiusSet=" + z10 + ", iconCornerRadius=" + f5 + ", badgeStyle=" + i16 + ", badgeTintSet=" + z11 + ", badgeTint=" + i17 + ", showBadge=" + z12 + ", rightBadgeStyle=" + i18 + ", rightBadgeTintSet=" + z13 + ", rightBadgeTint=" + i19 + ", showRightBadge=" + z14 + ", showAccessory=" + z15 + ", accessoryIconRes=" + i20 + ", accessorySize=" + num3 + ", trailingType=" + i21 + ", buttonText=" + ((Object) charSequence5) + ", lineMode=" + this.f16266L + ", checked=" + this.f16267M + ", switchChecked=" + this.f16268N + ", pressScaleEnabled=" + this.f16269O + ", showDivider=" + this.f16270P + ", dividerHeight=" + this.f16271Q + ", dividerInsetStart=" + this.f16272R + ", dividerInsetEnd=" + this.f16273S + ", dividerColor=" + this.f16274T + ", titleStyle=" + this.f16275U + ")";
    }

    public final int u() {
        return this.f16279d;
    }

    public final Integer v() {
        return this.f16293r;
    }

    public final boolean w() {
        return this.f16292q;
    }

    public final boolean x() {
        return this.f16294s;
    }

    public final int y() {
        return this.f16266L;
    }

    public final int z() {
        return this.f16276a;
    }
}
