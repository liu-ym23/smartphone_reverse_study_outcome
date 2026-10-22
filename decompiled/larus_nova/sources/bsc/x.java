package bsc;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.github.alexzhirkevich.compottie.internal.animation.a0;
import io.github.alexzhirkevich.compottie.internal.animation.f1;
import io.github.alexzhirkevich.compottie.internal.animation.h1;
import io.github.alexzhirkevich.compottie.internal.animation.i1;
import io.github.alexzhirkevich.compottie.internal.animation.z;
import io.github.alexzhirkevich.compottie.internal.animation.z0;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;

/* JADX INFO: loaded from: classes41.dex */
@Serializable
public final class x extends z0 {
    public static final b Companion = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f1 f20475f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final f1 f20476g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f1 f20477h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.x f20478i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.x f20479j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.x f20480k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.x f20481l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.x f20482m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.x f20483n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.x f20484o;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f20485a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f20486b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f20486b;
        }

        static {
            a r100 = new a();
            f20485a = r100;
            g2 r101 = new g2("io.github.alexzhirkevich.compottie.internal.helpers.Transform", r100, 10);
            r101.j(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, true);
            r101.j("p", true);
            r101.j("s", true);
            r101.j("r", true);
            r101.j("rx", true);
            r101.j("ry", true);
            r101.j("rz", true);
            r101.j("o", true);
            r101.j("sk", true);
            r101.j("sa", true);
            f20486b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            i1 r100 = i1.f491059c;
            a0 r101 = a0.f490766c;
            return new juc.d[]{r100, r100, r100, r101, kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), r101, r101, r101};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f20486b;
            muc.c r101 = r210.beginStructure(r100);
            int r102 = 8;
            int r103 = 6;
            int r104 = 7;
            f1 r110 = null;
            if (r101.decodeSequentially() == false) goto L5;
            i1 r105 = i1.f491059c;
            f1 r111 = (f1) r101.decodeSerializableElement(r100, 0, r105, null);
            f1 r112 = (f1) r101.decodeSerializableElement(r100, 1, r105, null);
            f1 r106 = (f1) r101.decodeSerializableElement(r100, 2, r105, null);
            a0 r107 = a0.f490766c;
            io.github.alexzhirkevich.compottie.internal.animation.x r108 = (io.github.alexzhirkevich.compottie.internal.animation.x) r101.decodeSerializableElement(r100, 3, r107, null);
            io.github.alexzhirkevich.compottie.internal.animation.x r113 = (io.github.alexzhirkevich.compottie.internal.animation.x) r101.decodeNullableSerializableElement(r100, 4, r107, null);
            io.github.alexzhirkevich.compottie.internal.animation.x r109 = (io.github.alexzhirkevich.compottie.internal.animation.x) r101.decodeNullableSerializableElement(r100, 5, r107, null);
            io.github.alexzhirkevich.compottie.internal.animation.x r114 = (io.github.alexzhirkevich.compottie.internal.animation.x) r101.decodeNullableSerializableElement(r100, 6, r107, null);
            io.github.alexzhirkevich.compottie.internal.animation.x r115 = (io.github.alexzhirkevich.compottie.internal.animation.x) r101.decodeSerializableElement(r100, 7, r107, null);
            io.github.alexzhirkevich.compottie.internal.animation.x r116 = (io.github.alexzhirkevich.compottie.internal.animation.x) r101.decodeSerializableElement(r100, 8, r107, null);
            io.github.alexzhirkevich.compottie.internal.animation.x r117 = r109;
            io.github.alexzhirkevich.compottie.internal.animation.x r118 = r114;
            io.github.alexzhirkevich.compottie.internal.animation.x r119 = r115;
            io.github.alexzhirkevich.compottie.internal.animation.x r120 = (io.github.alexzhirkevich.compottie.internal.animation.x) r101.decodeSerializableElement(r100, 9, r107, null);
            f1 r121 = r111;
            f1 r122 = r112;
            int r123 = 1023;
            io.github.alexzhirkevich.compottie.internal.animation.x r124 = r108;
            io.github.alexzhirkevich.compottie.internal.animation.x r125 = r113;
            f1 r126 = r106;
        L27:
            r101.endStructure(r100);
            return new x(r123, r121, r122, r126, r124, r125, r117, r118, r119, r116, r120);
        L5:
            io.github.alexzhirkevich.compottie.internal.animation.x r127 = null;
            io.github.alexzhirkevich.compottie.internal.animation.x r128 = null;
            io.github.alexzhirkevich.compottie.internal.animation.x r129 = null;
            io.github.alexzhirkevich.compottie.internal.animation.x r130 = null;
            io.github.alexzhirkevich.compottie.internal.animation.x r131 = null;
            io.github.alexzhirkevich.compottie.internal.animation.x r132 = null;
            io.github.alexzhirkevich.compottie.internal.animation.x r133 = null;
            f1 r134 = null;
            f1 r135 = null;
            int r136 = 0;
            boolean r211 = true;
        L6:
            if (r211 == false) goto L26;
            int r137 = r101.decodeElementIndex(r100);
            switch(r137) {
                case -1: goto L25;
                case 0: goto L23;
                case 1: goto L21;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L17;
                case 5: goto L16;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r137);
        L25:
            r102 = 8;
            r103 = 6;
            r104 = 7;
            r211 = false;
            goto L6
        L11:
            r127 = (io.github.alexzhirkevich.compottie.internal.animation.x) r101.decodeSerializableElement(r100, 9, a0.f490766c, r127);
            r136 = r136 | 512;
        L20:
            f1 r138 = r134;
        L22:
            f1 r139 = r135;
        L24:
            r134 = r138;
            r135 = r139;
            r102 = 8;
            r103 = 6;
            r104 = 7;
            goto L6
        L12:
            r128 = (io.github.alexzhirkevich.compottie.internal.animation.x) r101.decodeSerializableElement(r100, r102, a0.f490766c, r128);
            r136 = r136 | 256;
            goto L20
        L13:
            r129 = (io.github.alexzhirkevich.compottie.internal.animation.x) r101.decodeSerializableElement(r100, r104, a0.f490766c, r129);
            r136 = r136 | 128;
            goto L20
        L14:
            r131 = (io.github.alexzhirkevich.compottie.internal.animation.x) r101.decodeNullableSerializableElement(r100, r103, a0.f490766c, r131);
            r136 = r136 | 64;
            goto L20
        L16:
            r130 = (io.github.alexzhirkevich.compottie.internal.animation.x) r101.decodeNullableSerializableElement(r100, 5, a0.f490766c, r130);
            r136 = r136 | 32;
            goto L20
        L17:
            r133 = (io.github.alexzhirkevich.compottie.internal.animation.x) r101.decodeNullableSerializableElement(r100, 4, a0.f490766c, r133);
            r136 = r136 | 16;
            goto L20
        L18:
            r132 = (io.github.alexzhirkevich.compottie.internal.animation.x) r101.decodeSerializableElement(r100, 3, a0.f490766c, r132);
            r136 = r136 | 8;
            goto L20
        L19:
            r134 = (f1) r101.decodeSerializableElement(r100, 2, i1.f491059c, r134);
            r136 = r136 | 4;
            goto L20
        L21:
            r138 = r134;
            r135 = (f1) r101.decodeSerializableElement(r100, 1, i1.f491059c, r135);
            r136 = r136 | 2;
            goto L22
        L23:
            r138 = r134;
            r139 = r135;
            r136 = r136 | 1;
            r110 = (f1) r101.decodeSerializableElement(r100, 0, i1.f491059c, r110);
            goto L24
        L26:
            r123 = r136;
            r120 = r127;
            r116 = r128;
            r121 = r110;
            r122 = r135;
            r117 = r130;
            r124 = r132;
            r118 = r131;
            r125 = r133;
            r119 = r129;
            r126 = r134;
            goto L27
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            x r102 = (x) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f20486b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = x.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeSerializableElement(r103, 0, i1.f491059c, r102.f20475f);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeSerializableElement(r103, 1, i1.f491059c, r102.f20476g);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
        L25:
            boolean r109 = true;
        L27:
            if (r109 == false) goto L30;
            r104.encodeSerializableElement(r103, 2, i1.f491059c, r102.f20477h);
        L30:
            if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L33;
        L34:
            boolean r110 = true;
        L36:
            if (r110 == false) goto L39;
            r104.encodeSerializableElement(r103, 3, a0.f490766c, r102.f20478i);
        L39:
            if (r104.shouldEncodeElementDefault(r103, 4) == false) goto L42;
        L43:
            boolean r111 = true;
        L45:
            if (r111 == false) goto L48;
            r104.encodeNullableSerializableElement(r103, 4, a0.f490766c, r102.f20479j);
        L48:
            if (r104.shouldEncodeElementDefault(r103, 5) == false) goto L51;
        L52:
            boolean r112 = true;
        L54:
            if (r112 == false) goto L57;
            r104.encodeNullableSerializableElement(r103, 5, a0.f490766c, r102.f20480k);
        L57:
            if (r104.shouldEncodeElementDefault(r103, 6) == false) goto L60;
        L61:
            boolean r113 = true;
        L63:
            if (r113 == false) goto L66;
            r104.encodeNullableSerializableElement(r103, 6, a0.f490766c, r102.f20481l);
        L66:
            if (r104.shouldEncodeElementDefault(r103, 7) == false) goto L69;
        L70:
            boolean r114 = true;
        L72:
            if (r114 == false) goto L75;
            r104.encodeSerializableElement(r103, 7, a0.f490766c, r102.f20482m);
        L75:
            if (r104.shouldEncodeElementDefault(r103, 8) == false) goto L78;
        L79:
            boolean r115 = true;
        L81:
            if (r115 == false) goto L84;
            r104.encodeSerializableElement(r103, 8, a0.f490766c, r102.f20483n);
        L84:
            if (r104.shouldEncodeElementDefault(r103, 9) == false) goto L87;
        L88:
            r106 = true;
        L89:
            if (r106 == false) goto L91;
            r104.encodeSerializableElement(r103, 9, a0.f490766c, r102.f20484o);
        L91:
            r104.endStructure(r103);
            return;
        L87:
            if (Intrinsics.areEqual(r102.f20484o, z.f(io.github.alexzhirkevich.compottie.internal.animation.x.Companion)) == true) goto L89;
        L78:
            if (Intrinsics.areEqual(r102.f20483n, z.e(io.github.alexzhirkevich.compottie.internal.animation.x.Companion)) == false) goto L79;
            r115 = false;
            goto L81
        L69:
            if (Intrinsics.areEqual(r102.f20482m, z.a(io.github.alexzhirkevich.compottie.internal.animation.x.Companion)) == false) goto L70;
            r114 = false;
            goto L72
        L60:
            if (r102.f20481l != null) goto L61;
            r113 = false;
            goto L63
        L51:
            if (r102.f20480k != null) goto L52;
            r112 = false;
            goto L54
        L42:
            if (r102.f20479j != null) goto L43;
            r111 = false;
            goto L45
        L33:
            if (Intrinsics.areEqual(r102.f20478i, z.c(io.github.alexzhirkevich.compottie.internal.animation.x.Companion)) == false) goto L34;
            r110 = false;
            goto L36
        L24:
            if (Intrinsics.areEqual(r102.f20477h, h1.e(f1.Companion)) == false) goto L25;
            r109 = false;
            goto L27
        L15:
            if (Intrinsics.areEqual(r102.f20476g, h1.d(f1.Companion)) == false) goto L16;
            r108 = false;
            goto L18
        L6:
            if (Intrinsics.areEqual(r102.f20475f, h1.c(f1.Companion)) == false) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<x> serializer() {
            return a.f20485a;
        }
    }

    public x() {
        this(0);
    }

    static {
        Companion = new b();
    }

    public final x I() {
        f1 r100 = this.f20475f.i();
        f1 r101 = this.f20476g.i();
        f1 r102 = this.f20477h.i();
        io.github.alexzhirkevich.compottie.internal.animation.x r103 = this.f20478i.i();
        io.github.alexzhirkevich.compottie.internal.animation.x r104 = this.f20479j;
        if (r104 == null) goto L5;
        io.github.alexzhirkevich.compottie.internal.animation.x r105 = r104.i();
    L6:
        io.github.alexzhirkevich.compottie.internal.animation.x r106 = this.f20480k;
        if (r106 == null) goto L9;
        io.github.alexzhirkevich.compottie.internal.animation.x r107 = r106.i();
    L10:
        io.github.alexzhirkevich.compottie.internal.animation.x r108 = this.f20481l;
        if (r108 == null) goto L13;
        io.github.alexzhirkevich.compottie.internal.animation.x r109 = r108.i();
    L15:
        return new x(r100, r101, r102, r103, r105, r107, r109, this.f20482m.i(), this.f20483n.i(), this.f20484o.i());
    L13:
        r109 = null;
        goto L15
    L9:
        r107 = null;
        goto L10
    L5:
        r105 = null;
        goto L6
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.z0
    public final io.github.alexzhirkevich.compottie.internal.animation.x A() {
        return this.f20478i;
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.z0
    public final io.github.alexzhirkevich.compottie.internal.animation.x B() {
        return this.f20479j;
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.z0
    public final io.github.alexzhirkevich.compottie.internal.animation.x C() {
        return this.f20480k;
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.z0
    public final io.github.alexzhirkevich.compottie.internal.animation.x D() {
        return this.f20481l;
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.z0
    public final f1 E() {
        return this.f20477h;
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.z0
    public final io.github.alexzhirkevich.compottie.internal.animation.x F() {
        return this.f20483n;
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.z0
    public final io.github.alexzhirkevich.compottie.internal.animation.x G() {
        return this.f20484o;
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.z0
    public final f1 f() {
        return this.f20475f;
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.z0
    public final io.github.alexzhirkevich.compottie.internal.animation.x y() {
        return this.f20482m;
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.z0
    public final f1 z() {
        return this.f20476g;
    }

    public /* synthetic */ x(int r110) {
        f1.b r111 = f1.Companion;
        f1.c r100 = h1.c(r111);
        f1.c r101 = h1.d(r111);
        f1.c r102 = h1.e(r111);
        io.github.alexzhirkevich.compottie.internal.animation.x.b r112 = io.github.alexzhirkevich.compottie.internal.animation.x.Companion;
        this(r100, r101, r102, z.c(r112), null, null, null, z.a(r112), z.e(r112), z.f(r112));
    }

    public x(f1 r100, f1 r101, f1 r102, io.github.alexzhirkevich.compottie.internal.animation.x r103, io.github.alexzhirkevich.compottie.internal.animation.x r104, io.github.alexzhirkevich.compottie.internal.animation.x r105, io.github.alexzhirkevich.compottie.internal.animation.x r106, io.github.alexzhirkevich.compottie.internal.animation.x r107, io.github.alexzhirkevich.compottie.internal.animation.x r110, io.github.alexzhirkevich.compottie.internal.animation.x r111) {
        Intrinsics.checkNotNullParameter(r100, "anchorPoint");
        Intrinsics.checkNotNullParameter(r101, "position");
        Intrinsics.checkNotNullParameter(r102, "scale");
        Intrinsics.checkNotNullParameter(r103, "rotation");
        Intrinsics.checkNotNullParameter(r107, GXTemplateKey.STYLE_OPACITY);
        Intrinsics.checkNotNullParameter(r110, "skew");
        Intrinsics.checkNotNullParameter(r111, "skewAxis");
        this.f20475f = r100;
        this.f20476g = r101;
        this.f20477h = r102;
        this.f20478i = r103;
        this.f20479j = r104;
        this.f20480k = r105;
        this.f20481l = r106;
        this.f20482m = r107;
        this.f20483n = r110;
        this.f20484o = r111;
    }

    public x(int r100, f1 r101, f1 r102, f1 r103, io.github.alexzhirkevich.compottie.internal.animation.x r104, io.github.alexzhirkevich.compottie.internal.animation.x r105, io.github.alexzhirkevich.compottie.internal.animation.x r106, io.github.alexzhirkevich.compottie.internal.animation.x r110, io.github.alexzhirkevich.compottie.internal.animation.x r111, io.github.alexzhirkevich.compottie.internal.animation.x r112, io.github.alexzhirkevich.compottie.internal.animation.x r113) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f20486b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        r101 = h1.c(f1.Companion);
    L7:
        this.f20475f = r101;
        if ((r100 & 2) != 0) goto L10;
        this.f20476g = h1.d(f1.Companion);
    L12:
        if ((r100 & 4) != 0) goto L14;
        this.f20477h = h1.e(f1.Companion);
    L16:
        if ((r100 & 8) != 0) goto L18;
        this.f20478i = z.c(io.github.alexzhirkevich.compottie.internal.animation.x.Companion);
    L20:
        if ((r100 & 16) != 0) goto L22;
        this.f20479j = null;
    L24:
        if ((r100 & 32) != 0) goto L26;
        this.f20480k = null;
    L28:
        if ((r100 & 64) != 0) goto L30;
        this.f20481l = null;
    L32:
        if ((r100 & 128) != 0) goto L34;
        this.f20482m = z.a(io.github.alexzhirkevich.compottie.internal.animation.x.Companion);
    L36:
        if ((r100 & 256) != 0) goto L38;
        this.f20483n = z.e(io.github.alexzhirkevich.compottie.internal.animation.x.Companion);
    L40:
        if ((r100 & 512) != 0) goto L42;
        this.f20484o = z.f(io.github.alexzhirkevich.compottie.internal.animation.x.Companion);
        return;
    L42:
        this.f20484o = r113;
        return;
    L38:
        this.f20483n = r112;
        goto L40
    L34:
        this.f20482m = r111;
        goto L36
    L30:
        this.f20481l = r110;
        goto L32
    L26:
        this.f20480k = r106;
        goto L28
    L22:
        this.f20479j = r105;
        goto L24
    L18:
        this.f20478i = r104;
        goto L20
    L14:
        this.f20477h = r103;
        goto L16
    L10:
        this.f20476g = r102;
        goto L12
    }
}
