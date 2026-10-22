package ea;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$MemberKind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility;
import kotlin.reflect.jvm.internal.impl.protobuf.f;

/* renamed from: ea.b, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C4018b {

    /* renamed from: A, reason: collision with root package name */
    public static final C0396b f32355A;

    /* renamed from: B, reason: collision with root package name */
    public static final C0396b f32356B;

    /* renamed from: C, reason: collision with root package name */
    public static final C0396b f32357C;

    /* renamed from: D, reason: collision with root package name */
    public static final C0396b f32358D;

    /* renamed from: E, reason: collision with root package name */
    public static final C0396b f32359E;

    /* renamed from: F, reason: collision with root package name */
    public static final C0396b f32360F;

    /* renamed from: G, reason: collision with root package name */
    public static final C0396b f32361G;

    /* renamed from: H, reason: collision with root package name */
    public static final C0396b f32362H;

    /* renamed from: I, reason: collision with root package name */
    public static final C0396b f32363I;

    /* renamed from: J, reason: collision with root package name */
    public static final C0396b f32364J;

    /* renamed from: K, reason: collision with root package name */
    public static final C0396b f32365K;

    /* renamed from: L, reason: collision with root package name */
    public static final C0396b f32366L;

    /* renamed from: M, reason: collision with root package name */
    public static final C0396b f32367M;

    /* renamed from: N, reason: collision with root package name */
    public static final C0396b f32368N;

    /* renamed from: O, reason: collision with root package name */
    public static final C0396b f32369O;

    /* renamed from: P, reason: collision with root package name */
    public static final C0396b f32370P;

    /* renamed from: Q, reason: collision with root package name */
    public static final C0396b f32371Q;

    /* renamed from: R, reason: collision with root package name */
    public static final C0396b f32372R;

    /* renamed from: S, reason: collision with root package name */
    public static final C0396b f32373S;

    /* renamed from: a, reason: collision with root package name */
    public static final C0396b f32374a;

    /* renamed from: b, reason: collision with root package name */
    public static final C0396b f32375b;

    /* renamed from: c, reason: collision with root package name */
    public static final C0396b f32376c;

    /* renamed from: d, reason: collision with root package name */
    public static final d<ProtoBuf$Visibility> f32377d;

    /* renamed from: e, reason: collision with root package name */
    public static final d<ProtoBuf$Modality> f32378e;

    /* renamed from: f, reason: collision with root package name */
    public static final d<ProtoBuf$Class.Kind> f32379f;

    /* renamed from: g, reason: collision with root package name */
    public static final C0396b f32380g;

    /* renamed from: h, reason: collision with root package name */
    public static final C0396b f32381h;

    /* renamed from: i, reason: collision with root package name */
    public static final C0396b f32382i;

    /* renamed from: j, reason: collision with root package name */
    public static final C0396b f32383j;

    /* renamed from: k, reason: collision with root package name */
    public static final C0396b f32384k;

    /* renamed from: l, reason: collision with root package name */
    public static final C0396b f32385l;

    /* renamed from: m, reason: collision with root package name */
    public static final C0396b f32386m;

    /* renamed from: n, reason: collision with root package name */
    public static final C0396b f32387n;

    /* renamed from: o, reason: collision with root package name */
    public static final C0396b f32388o;

    /* renamed from: p, reason: collision with root package name */
    public static final C0396b f32389p;

    /* renamed from: q, reason: collision with root package name */
    public static final d<ProtoBuf$MemberKind> f32390q;

    /* renamed from: r, reason: collision with root package name */
    public static final C0396b f32391r;

    /* renamed from: s, reason: collision with root package name */
    public static final C0396b f32392s;

    /* renamed from: t, reason: collision with root package name */
    public static final C0396b f32393t;

    /* renamed from: u, reason: collision with root package name */
    public static final C0396b f32394u;

    /* renamed from: v, reason: collision with root package name */
    public static final C0396b f32395v;

    /* renamed from: w, reason: collision with root package name */
    public static final C0396b f32396w;

    /* renamed from: x, reason: collision with root package name */
    public static final C0396b f32397x;

    /* renamed from: y, reason: collision with root package name */
    public static final C0396b f32398y;

    /* renamed from: z, reason: collision with root package name */
    public static final C0396b f32399z;

    /* renamed from: ea.b$b, reason: collision with other inner class name */
    public static class C0396b extends d<Boolean> {
        public C0396b(int i10) {
            super(i10, 1);
        }

        @Override // ea.C4018b.d
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Boolean d(int i10) {
            return Boolean.valueOf(((1 << this.f32401a) & i10) != 0);
        }

        @Override // ea.C4018b.d
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public int e(Boolean bool) {
            if (bool.booleanValue()) {
                return 1 << this.f32401a;
            }
            return 0;
        }
    }

    /* renamed from: ea.b$c */
    public static class c<E extends f.a> extends d<E> {

        /* renamed from: c, reason: collision with root package name */
        public final E[] f32400c;

        public c(int i10, E[] eArr) {
            super(i10, g(eArr));
            this.f32400c = eArr;
        }

        private static /* synthetic */ void f(int i10) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enumEntries", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$EnumLiteFlagField", "bitWidth"));
        }

        public static <E> int g(E[] eArr) {
            if (eArr == null) {
                f(0);
            }
            int length = eArr.length - 1;
            if (length == 0) {
                return 1;
            }
            for (int i10 = 31; i10 >= 0; i10--) {
                if (((1 << i10) & length) != 0) {
                    return i10 + 1;
                }
            }
            throw new IllegalStateException("Empty enum: " + eArr.getClass());
        }

        @Override // ea.C4018b.d
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public E d(int i10) {
            int i11 = (1 << this.f32402b) - 1;
            int i12 = this.f32401a;
            int i13 = (i10 & (i11 << i12)) >> i12;
            for (E e10 : this.f32400c) {
                if (e10.getNumber() == i13) {
                    return e10;
                }
            }
            return null;
        }

        @Override // ea.C4018b.d
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public int e(E e10) {
            return e10.getNumber() << this.f32401a;
        }
    }

    /* renamed from: ea.b$d */
    public static abstract class d<E> {

        /* renamed from: a, reason: collision with root package name */
        public final int f32401a;

        /* renamed from: b, reason: collision with root package name */
        public final int f32402b;

        /* JADX WARN: Incorrect types in method signature: <E::Lkotlin/reflect/jvm/internal/impl/protobuf/f$a;>(Lea/b$d<*>;[TE;)Lea/b$d<TE;>; */
        public static d a(d dVar, f.a[] aVarArr) {
            return new c(dVar.f32401a + dVar.f32402b, aVarArr);
        }

        public static C0396b b(d<?> dVar) {
            return new C0396b(dVar.f32401a + dVar.f32402b);
        }

        public static C0396b c() {
            return new C0396b(0);
        }

        public abstract E d(int i10);

        public abstract int e(E e10);

        public d(int i10, int i11) {
            this.f32401a = i10;
            this.f32402b = i11;
        }
    }

    static {
        C0396b c0396bC = d.c();
        f32374a = c0396bC;
        f32375b = d.b(c0396bC);
        C0396b c0396bC2 = d.c();
        f32376c = c0396bC2;
        d<ProtoBuf$Visibility> dVarA = d.a(c0396bC2, ProtoBuf$Visibility.values());
        f32377d = dVarA;
        d<ProtoBuf$Modality> dVarA2 = d.a(dVarA, ProtoBuf$Modality.values());
        f32378e = dVarA2;
        d<ProtoBuf$Class.Kind> dVarA3 = d.a(dVarA2, ProtoBuf$Class.Kind.values());
        f32379f = dVarA3;
        C0396b c0396bB = d.b(dVarA3);
        f32380g = c0396bB;
        C0396b c0396bB2 = d.b(c0396bB);
        f32381h = c0396bB2;
        C0396b c0396bB3 = d.b(c0396bB2);
        f32382i = c0396bB3;
        C0396b c0396bB4 = d.b(c0396bB3);
        f32383j = c0396bB4;
        C0396b c0396bB5 = d.b(c0396bB4);
        f32384k = c0396bB5;
        C0396b c0396bB6 = d.b(c0396bB5);
        f32385l = c0396bB6;
        f32386m = d.b(c0396bB6);
        C0396b c0396bB7 = d.b(dVarA);
        f32387n = c0396bB7;
        C0396b c0396bB8 = d.b(c0396bB7);
        f32388o = c0396bB8;
        f32389p = d.b(c0396bB8);
        d<ProtoBuf$MemberKind> dVarA4 = d.a(dVarA2, ProtoBuf$MemberKind.values());
        f32390q = dVarA4;
        C0396b c0396bB9 = d.b(dVarA4);
        f32391r = c0396bB9;
        C0396b c0396bB10 = d.b(c0396bB9);
        f32392s = c0396bB10;
        C0396b c0396bB11 = d.b(c0396bB10);
        f32393t = c0396bB11;
        C0396b c0396bB12 = d.b(c0396bB11);
        f32394u = c0396bB12;
        C0396b c0396bB13 = d.b(c0396bB12);
        f32395v = c0396bB13;
        C0396b c0396bB14 = d.b(c0396bB13);
        f32396w = c0396bB14;
        C0396b c0396bB15 = d.b(c0396bB14);
        f32397x = c0396bB15;
        C0396b c0396bB16 = d.b(c0396bB15);
        f32398y = c0396bB16;
        f32399z = d.b(c0396bB16);
        C0396b c0396bB17 = d.b(dVarA4);
        f32355A = c0396bB17;
        C0396b c0396bB18 = d.b(c0396bB17);
        f32356B = c0396bB18;
        C0396b c0396bB19 = d.b(c0396bB18);
        f32357C = c0396bB19;
        C0396b c0396bB20 = d.b(c0396bB19);
        f32358D = c0396bB20;
        C0396b c0396bB21 = d.b(c0396bB20);
        f32359E = c0396bB21;
        C0396b c0396bB22 = d.b(c0396bB21);
        f32360F = c0396bB22;
        C0396b c0396bB23 = d.b(c0396bB22);
        f32361G = c0396bB23;
        C0396b c0396bB24 = d.b(c0396bB23);
        f32362H = c0396bB24;
        C0396b c0396bB25 = d.b(c0396bB24);
        f32363I = c0396bB25;
        f32364J = d.b(c0396bB25);
        C0396b c0396bB26 = d.b(c0396bC2);
        f32365K = c0396bB26;
        C0396b c0396bB27 = d.b(c0396bB26);
        f32366L = c0396bB27;
        f32367M = d.b(c0396bB27);
        C0396b c0396bB28 = d.b(dVarA2);
        f32368N = c0396bB28;
        C0396b c0396bB29 = d.b(c0396bB28);
        f32369O = c0396bB29;
        f32370P = d.b(c0396bB29);
        C0396b c0396bC3 = d.c();
        f32371Q = c0396bC3;
        f32372R = d.b(c0396bC3);
        f32373S = d.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(int r5) {
        /*
            r0 = 3
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = 0
            r2 = 2
            r3 = 1
            if (r5 == r3) goto L2b
            if (r5 == r2) goto L26
            r4 = 5
            if (r5 == r4) goto L2b
            r4 = 6
            if (r5 == r4) goto L21
            r4 = 8
            if (r5 == r4) goto L2b
            r4 = 9
            if (r5 == r4) goto L21
            r4 = 11
            if (r5 == r4) goto L2b
            java.lang.String r4 = "visibility"
            r0[r1] = r4
            goto L2f
        L21:
            java.lang.String r4 = "memberKind"
            r0[r1] = r4
            goto L2f
        L26:
            java.lang.String r4 = "kind"
            r0[r1] = r4
            goto L2f
        L2b:
            java.lang.String r4 = "modality"
            r0[r1] = r4
        L2f:
            java.lang.String r1 = "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags"
            r0[r3] = r1
            switch(r5) {
                case 3: goto L4a;
                case 4: goto L45;
                case 5: goto L45;
                case 6: goto L45;
                case 7: goto L40;
                case 8: goto L40;
                case 9: goto L40;
                case 10: goto L3b;
                case 11: goto L3b;
                default: goto L36;
            }
        L36:
            java.lang.String r5 = "getClassFlags"
            r0[r2] = r5
            goto L4e
        L3b:
            java.lang.String r5 = "getAccessorFlags"
            r0[r2] = r5
            goto L4e
        L40:
            java.lang.String r5 = "getPropertyFlags"
            r0[r2] = r5
            goto L4e
        L45:
            java.lang.String r5 = "getFunctionFlags"
            r0[r2] = r5
            goto L4e
        L4a:
            java.lang.String r5 = "getConstructorFlags"
            r0[r2] = r5
        L4e:
            java.lang.String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            java.lang.String r5 = java.lang.String.format(r5, r0)
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ea.C4018b.a(int):void");
    }

    public static int b(boolean z10, ProtoBuf$Visibility protoBuf$Visibility, ProtoBuf$Modality protoBuf$Modality, boolean z11, boolean z12, boolean z13) {
        if (protoBuf$Visibility == null) {
            a(10);
        }
        if (protoBuf$Modality == null) {
            a(11);
        }
        return f32376c.e(Boolean.valueOf(z10)) | f32378e.e(protoBuf$Modality) | f32377d.e(protoBuf$Visibility) | f32368N.e(Boolean.valueOf(z11)) | f32369O.e(Boolean.valueOf(z12)) | f32370P.e(Boolean.valueOf(z13));
    }
}
