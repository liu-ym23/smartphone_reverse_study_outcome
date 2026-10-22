package com.bytedance.android.sdk.bdticketguard.math;

import com.amap.api.col.s.ce;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import java.math.BigInteger;
import java.security.spec.ECParameterSpec;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes12.dex */
public final class Secp256r1Math {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f163949a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f163950b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f163951c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f163952d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f163953e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f163954f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f163955g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Secp256r1Math f163956h = null;

    public static final class a {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f163957g = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BigInteger f163958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BigInteger f163959b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final BigInteger f163960c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public BigInteger f163961d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public BigInteger f163962e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f163963f;

        /* JADX INFO: renamed from: com.bytedance.android.sdk.bdticketguard.math.Secp256r1Math$a$a, reason: collision with other inner class name */
        public static final class C2501a {
            public C2501a() {
            }

            public static a a(BigInteger r100, BigInteger r101, BigInteger r110) {
                a r102 = a.f163957g;
                if (Intrinsics.areEqual(r110, BigInteger.ZERO) == false) goto L5;
                boolean r103 = true;
            L7:
                return new a(r100, r101, r110, null, null, r103);
            L5:
                r103 = false;
                goto L7
            }
        }

        public /* synthetic */ a() {
            throw null;
        }

        static {
            new C2501a();
            BigInteger r100 = BigInteger.ZERO;
            f163957g = new a(r100, r100, r100, null, null, true);
        }

        public final void a() {
            if (this.f163963f == true) goto L16;
            if (this.f163961d == null) goto L10;
            if (this.f163962e == null) goto L10;
            return;
        L10:
            if (Intrinsics.areEqual(this.f163960c, BigInteger.ZERO) == true) goto L14;
            Secp256r1Math r100 = Secp256r1Math.f163956h;
            BigInteger r101 = this.f163960c;
            r100.getClass();
            BigInteger r102 = r101.modInverse(Secp256r1Math.b());
            BigInteger r103 = Secp256r1Math.c(r102.multiply(r102));
            BigInteger r104 = Secp256r1Math.c(r103.multiply(r102));
            this.f163961d = Secp256r1Math.c(this.f163958a.multiply(r103));
            this.f163962e = Secp256r1Math.c(this.f163959b.multiply(r104));
            return;
        L14:
            throw new IllegalStateException("Invalid Jacobian point (Z=0)");
        L16:
            throw new IllegalStateException("Point at infinity has no affine coordinates");
        }

        public final boolean b() {
            if (this.f163963f == false) goto L5;
        L7:
            return false;
        L5:
            if (Intrinsics.areEqual(this.f163960c, BigInteger.ONE) == false) goto L7;
            return true;
        }

        public a(BigInteger r100, BigInteger r101, BigInteger r102, BigInteger r103, BigInteger r104, boolean r105) {
            this.f163958a = r100;
            this.f163959b = r101;
            this.f163960c = r102;
            this.f163961d = r103;
            this.f163962e = r104;
            this.f163963f = r105;
        }
    }

    static {
        f163949a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Secp256r1Math.class), "ecSpec", "getEcSpec$bd_ticket_guard_core_release()Ljava/security/spec/ECParameterSpec;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Secp256r1Math.class), "p", "getP()Ljava/math/BigInteger;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Secp256r1Math.class), BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "getA()Ljava/math/BigInteger;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Secp256r1Math.class), "b", "getB()Ljava/math/BigInteger;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Secp256r1Math.class), OfficeSDKRequestTag.KEY_NEW_USER, "getN()Ljava/math/BigInteger;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Secp256r1Math.class), ce.f26391f, "getG()Lcom/bytedance/android/sdk/bdticketguard/math/Secp256r1Math$Point;"))};
        f163956h = new Secp256r1Math();
        f163950b = LazyKt.lazy(Secp256r1Math$ecSpec$2.INSTANCE);
        f163951c = LazyKt.lazy(Secp256r1Math$p$2.INSTANCE);
        f163952d = LazyKt.lazy(a.AnonymousClass2.INSTANCE);
        f163953e = LazyKt.lazy(AnonymousClass2.INSTANCE);
        f163954f = LazyKt.lazy(Secp256r1Math$n$2.INSTANCE);
        f163955g = LazyKt.lazy(C102662.INSTANCE);
    }

    public Secp256r1Math() {
    }

    public static ECParameterSpec a() {
        Lazy r100 = f163950b;
        KProperty r101 = f163949a[0];
        return (ECParameterSpec) r100.getValue();
    }

    public static BigInteger b() {
        Lazy r100 = f163951c;
        KProperty r101 = f163949a[1];
        return (BigInteger) r100.getValue();
    }

    public static BigInteger c(BigInteger r100) {
        BigInteger r101 = r100.mod(b());
        if (r101.signum() < 0) goto L6;
        return r101;
    L6:
        return r101.add(b());
    }

    public static BigInteger d(BigInteger r100) {
        BigInteger r101 = r100.shiftLeft(1);
        if (r101.compareTo(b()) >= 0) goto L5;
        return r101;
    L5:
        return r101.subtract(b());
    }

    public static BigInteger e(BigInteger r100) {
        Lazy r101 = f163954f;
        KProperty[] r102 = f163949a;
        KProperty r103 = r102[4];
        BigInteger r104 = r100.mod((BigInteger) r101.getValue());
        if (r104.signum() >= 0) goto L7;
        KProperty r105 = r102[4];
        return r104.add((BigInteger) r101.getValue());
    L7:
        return r104;
    }

    public static BigInteger f(BigInteger r100, BigInteger r101) {
        BigInteger r102 = r100.subtract(r101);
        if (r102.compareTo(BigInteger.ZERO) < 0) goto L5;
        return r102;
    L5:
        return r102.add(b());
    }

    public static a g(BigInteger r210, a r211) {
        if (r211.f163963f == false) goto L5;
        return r211;
    L5:
        BigInteger r100 = e(r210);
        if (Intrinsics.areEqual(r100, BigInteger.ZERO) == true) goto L8;
        int[] r101 = new int[r100.bitLength() + 1];
        int r102 = 0;
    L10:
        int r103 = -1;
        if (r100.signum() == 0) goto L20;
        if (r100.testBit(0) == true) goto L15;
        int r104 = r102 + 1;
        r101[r102] = 0;
    L19:
        r102 = r104;
        r100 = r100.shiftRight(1);
        goto L10
    L15:
        if (r100.and(BigInteger.valueOf(3)).intValue() != 1) goto L17;
        r103 = 1;
    L17:
        r104 = r102 + 1;
        r101[r102] = r103;
        r100 = r100.subtract(BigInteger.valueOf(r103));
        goto L19
    L20:
        boolean r105 = r211.b();
        BigInteger r106 = r211.f163958a;
        BigInteger r110 = r211.f163959b;
        BigInteger r111 = r211.f163960c;
        BigInteger r112 = c(b().subtract(r211.f163959b));
        BigInteger r107 = r211.f163960c;
        BigInteger r108 = BigInteger.ZERO;
        BigInteger[] r113 = {r108, r108, r108};
        int r109 = r102 - 1;
        BigInteger r114 = r108;
        BigInteger r115 = r114;
    L21:
        if (r109 < 0) goto L36;
        j(r108, r114, r115, r113);
        r108 = r113[0];
        r114 = r113[1];
        r115 = r113[2];
        int r116 = r101[r109];
        if (r116 == (-1)) goto L30;
        if (r116 == 1) goto L26;
        BigInteger[] r117 = r113;
        r111 = r111;
    L35:
        r109 = r109 - 1;
        r113 = r117;
        r111 = r111;
        goto L21
    L26:
        if (r105 == false) goto L28;
        r117 = r113;
        i(r108, r114, r115, r106, r110, r113);
    L29:
        r108 = r117[0];
        r114 = r117[1];
        r115 = r117[2];
        goto L35
    L28:
        r117 = r113;
        h(r108, r114, r115, r106, r110, r111, r117);
        goto L29
    L30:
        r117 = r113;
        r111 = r111;
        if (r105 == false) goto L33;
        i(r108, r114, r115, r106, r112, r117);
    L34:
        r108 = r117[0];
        r114 = r117[1];
        r115 = r117[2];
        goto L35
    L33:
        h(r108, r114, r115, r106, r112, r107, r117);
        goto L34
    L36:
        a r118 = a.f163957g;
        return a.C2501a.a(r108, r114, r115);
    L8:
        return a.f163957g;
    }

    public static void j(BigInteger r100, BigInteger r101, BigInteger r110, BigInteger[] r111) {
        BigInteger r102 = BigInteger.ZERO;
        if (Intrinsics.areEqual(r110, r102) == false) goto L5;
    L12:
        r111[0] = r102;
        r111[1] = r102;
        r111[2] = r102;
        return;
    L5:
        if (Intrinsics.areEqual(r101, r102) == true) goto L12;
        BigInteger r103 = r101.multiply(r101).mod(b());
        BigInteger r104 = r100.multiply(r103).shiftLeft(2).mod(b());
        BigInteger r105 = r110.multiply(r110).mod(b());
        BigInteger r106 = r100.add(r105);
        if (r106.compareTo(b()) < 0) goto L10;
        r106 = r106.subtract(b());
    L10:
        BigInteger r107 = r106.multiply(f(r100, r105)).multiply(BigInteger.valueOf(3)).mod(b());
        BigInteger r108 = f(r107.multiply(r107).mod(b()), d(r104));
        BigInteger r109 = r103.multiply(r103).mod(b());
        BigInteger r112 = f(r107.multiply(f(r104, r108)).mod(b()), d(d(d(r109))));
        BigInteger r113 = d(r101).multiply(r110).mod(b());
        r111[0] = r108;
        r111[1] = r112;
        r111[2] = r113;
    }

    public static void i(BigInteger r100, BigInteger r101, BigInteger r102, BigInteger r103, BigInteger r110, BigInteger[] r111) {
        BigInteger r104 = BigInteger.ZERO;
        if (Intrinsics.areEqual(r102, r104) == false) goto L6;
        r111[0] = r103;
        r111[1] = r110;
        r111[2] = BigInteger.ONE;
        return;
    L6:
        BigInteger r105 = r102.multiply(r102).mod(b());
        BigInteger r106 = r103.multiply(r105).mod(b());
        BigInteger r112 = r110.multiply(r105.multiply(r102).mod(b())).mod(b());
        BigInteger r107 = f(r106, r100);
        BigInteger r113 = f(r112, r101);
        if (Intrinsics.areEqual(r107, r104) == true) goto L9;
        BigInteger r108 = r107.multiply(r107).mod(b());
        BigInteger r109 = r108.multiply(r107).mod(b());
        BigInteger r114 = r100.multiply(r108).mod(b());
        BigInteger r115 = f(f(r113.multiply(r113).mod(b()), r109), d(r114));
        BigInteger r116 = f(r113.multiply(f(r114, r115)).mod(b()), r101.multiply(r109).mod(b()));
        BigInteger r117 = r107.multiply(r102).mod(b());
        r111[0] = r115;
        r111[1] = r116;
        r111[2] = r117;
        return;
    L9:
        if (Intrinsics.areEqual(r113, r104) == false) goto L11;
        j(r100, r101, r102, r111);
        return;
    L11:
        r111[0] = r104;
        r111[1] = r104;
        r111[2] = r104;
    }

    public static void h(BigInteger r100, BigInteger r101, BigInteger r110, BigInteger r111, BigInteger r112, BigInteger r113, BigInteger[] r114) {
        BigInteger r102 = BigInteger.ZERO;
        if (Intrinsics.areEqual(r110, r102) == false) goto L7;
        r114[0] = r111;
        r114[1] = r112;
        r114[2] = r113;
        return;
    L7:
        if (Intrinsics.areEqual(r113, r102) == false) goto L10;
        r114[0] = r100;
        r114[1] = r101;
        r114[2] = r110;
        return;
    L10:
        BigInteger r103 = r110.multiply(r110).mod(b());
        BigInteger r104 = r113.multiply(r113).mod(b());
        BigInteger r105 = r100.multiply(r104).mod(b());
        BigInteger r115 = r111.multiply(r103).mod(b());
        BigInteger r106 = r103.multiply(r110).mod(b());
        BigInteger r107 = r101.multiply(r104.multiply(r113).mod(b())).mod(b());
        BigInteger r116 = r112.multiply(r106).mod(b());
        BigInteger r117 = f(r115, r105);
        BigInteger r118 = f(r116, r107);
        if (Intrinsics.areEqual(r117, r102) == true) goto L13;
        BigInteger r108 = r117.multiply(r117).mod(b());
        BigInteger r109 = r108.multiply(r117).mod(b());
        BigInteger r119 = r105.multiply(r108).mod(b());
        BigInteger r120 = f(f(r118.multiply(r118).mod(b()), r109), d(r119));
        BigInteger r121 = f(r118.multiply(f(r119, r120)).mod(b()), r107.multiply(r109).mod(b()));
        BigInteger r122 = r117.multiply(r110).multiply(r113).mod(b());
        r114[0] = r120;
        r114[1] = r121;
        r114[2] = r122;
        return;
    L13:
        if (Intrinsics.areEqual(r118, r102) == false) goto L15;
        j(r100, r101, r110, r114);
        return;
    L15:
        r114[0] = r102;
        r114[1] = r102;
        r114[2] = r102;
    }
}
