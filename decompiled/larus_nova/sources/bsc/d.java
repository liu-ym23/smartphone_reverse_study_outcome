package bsc;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.Path;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes41.dex */
@Serializable
public final class d {
    public static final b Companion = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy<juc.d<Object>>[] f20386g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f20387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<? extends List<Float>> f20388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<? extends List<Float>> f20389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<List<Float>> f20390d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<k> f20391e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f20392f;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f20393a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f20394b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f20394b;
        }

        static {
            a r100 = new a();
            f20393a = r100;
            g2 r101 = new g2("io.github.alexzhirkevich.compottie.internal.helpers.Bezier", r100, 4);
            r101.j("c", true);
            r101.j(RXScreenCaptureService.KEY_INDEX, true);
            r101.j("o", true);
            r101.j(BaseSwitches.V, true);
            f20394b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r100 = d.f20386g;
            return new juc.d[]{nuc.i.f520705a, r100[1].getValue(), r100[2].getValue(), r100[3].getValue()};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f20394b;
            muc.c r101 = r210.beginStructure(r100);
            Lazy<juc.d<Object>>[] r102 = d.f20386g;
            if (r101.decodeSequentially() == false) goto L5;
            boolean r103 = r101.decodeBooleanElement(r100, 0);
            List r104 = (List) r101.decodeSerializableElement(r100, 1, r102[1].getValue(), null);
            List r105 = (List) r101.decodeSerializableElement(r100, 2, r102[2].getValue(), null);
            List r110 = (List) r101.decodeSerializableElement(r100, 3, r102[3].getValue(), null);
            boolean r111 = r103;
            List r112 = r105;
            List r113 = r104;
            int r114 = 15;
        L21:
            r101.endStructure(r100);
            return new d(r114, r111, r113, r112, r110);
        L5:
            List r106 = null;
            List r115 = null;
            List r116 = null;
            boolean r107 = false;
            int r108 = 0;
            boolean r117 = true;
        L6:
            if (r117 == false) goto L20;
            int r118 = r101.decodeElementIndex(r100);
            if (r118 != (-1)) goto L9;
            r117 = false;
            goto L6
        L9:
            if (r118 != 0) goto L10;
            r107 = r101.decodeBooleanElement(r100, 0);
            r108 = r108 | 1;
            goto L6
        L10:
            if (r118 != 1) goto L11;
            r106 = (List) r101.decodeSerializableElement(r100, 1, r102[1].getValue(), r106);
            r108 = r108 | 2;
            goto L6
        L11:
            if (r118 != 2) goto L12;
            r115 = (List) r101.decodeSerializableElement(r100, 2, r102[2].getValue(), r115);
            r108 = r108 | 4;
            goto L6
        L12:
            if (r118 != 3) goto L15;
            r116 = (List) r101.decodeSerializableElement(r100, 3, r102[3].getValue(), r116);
            r108 = r108 | 8;
            goto L6
        L15:
            throw new UnknownFieldException(r118);
        L20:
            r111 = r107;
            r114 = r108;
            r113 = r106;
            r112 = r115;
            r110 = r116;
            goto L21
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            d r102 = (d) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f20394b;
            muc.d r104 = r100.beginStructure(r103);
            Lazy<juc.d<Object>>[] r105 = d.f20386g;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeBooleanElement(r103, 0, r102.f20387a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeSerializableElement(r103, 1, r105[1].getValue(), r102.f20388b);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
        L25:
            boolean r109 = true;
        L27:
            if (r109 == false) goto L30;
            r104.encodeSerializableElement(r103, 2, r105[2].getValue(), r102.f20389c);
        L30:
            if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L33;
        L34:
            r106 = true;
        L35:
            if (r106 == false) goto L37;
            r104.encodeSerializableElement(r103, 3, r105[3].getValue(), r102.f20390d);
        L37:
            r104.endStructure(r103);
            return;
        L33:
            if (Intrinsics.areEqual(r102.f20390d, CollectionsKt.emptyList()) == true) goto L35;
        L24:
            if (Intrinsics.areEqual(r102.f20389c, CollectionsKt.emptyList()) == false) goto L25;
            r109 = false;
            goto L27
        L15:
            if (Intrinsics.areEqual(r102.f20388b, CollectionsKt.emptyList()) == false) goto L16;
            r108 = false;
            goto L18
        L6:
            if (r102.f20387a == true) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<d> serializer() {
            return a.f20393a;
        }
    }

    public d() {
        this(0);
    }

    static {
        Companion = new b();
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        f20386g = new Lazy[]{null, LazyKt.lazy(r100, new bsc.a()), LazyKt.lazy(r100, new bsc.b()), LazyKt.lazy(r100, new c())};
    }

    public final void a() {
        List r100 = (List) ListProtector.get(this.f20390d, 0);
        List r101 = (List) CollectionsKt.last(this.f20390d);
        List<Float> r102 = (List) CollectionsKt.getOrNull(this.f20389c, CollectionsKt.getLastIndex(this.f20390d));
        if (r102 != null) goto L5;
        r102 = e.f20395a;
    L5:
        List<Float> r103 = (List) CollectionsKt.getOrNull(this.f20388b, 0);
        if (r103 != null) goto L8;
        r103 = e.f20395a;
    L8:
        float r104 = ((Number) ListProtector.get(r101, 0)).floatValue() + ((Number) ListProtector.get(r102, 0)).floatValue();
        float r105 = ((Number) ListProtector.get(r101, 1)).floatValue() + ((Number) ListProtector.get(r102, 1)).floatValue();
        long r106 = Float.floatToRawIntBits(r104);
        long r110 = Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r105)) & BodyPartID.bodyIdMax) | (r106 << 32));
        float r107 = ((Number) ListProtector.get(r100, 0)).floatValue() + ((Number) ListProtector.get(r103, 0)).floatValue();
        float r108 = ((Number) ListProtector.get(r100, 1)).floatValue() + ((Number) ListProtector.get(r103, 1)).floatValue();
        long r111 = Offset.m4574constructorimpl((Float.floatToRawIntBits(r107) << 32) | (Float.floatToRawIntBits(r108) & BodyPartID.bodyIdMax));
        ((ArrayList) this.f20391e).add(new k(r110, r111, fsc.b.d(r100)));
    }

    public /* synthetic */ d(int r100) {
        this(false, CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }

    public final void c(Path r110) {
        Intrinsics.checkNotNullParameter(r110, "outPath");
        r110.reset();
        char r100 = ' ';
        float r101 = Float.intBitsToFloat((int) (this.f20392f >> 32));
        long r102 = this.f20392f;
        long r111 = BodyPartID.bodyIdMax;
        r110.moveTo(r101, Float.intBitsToFloat((int) (r102 & BodyPartID.bodyIdMax)));
        long r103 = this.f20392f;
        List<k> r112 = this.f20391e;
        int r113 = r112.size();
        int r114 = 0;
    L3:
        if (r114 >= r113) goto L12;
        k r115 = (k) ListProtector.get(r112, r114);
        if (Offset.m4579equalsimpl0(r115.f20402a, r103) == true) goto L7;
    L9:
        float r104 = Float.intBitsToFloat((int) (r115.f20402a >> r100));
        float r105 = Float.intBitsToFloat((int) (r115.f20402a & r111));
        float r106 = Float.intBitsToFloat((int) (r115.f20403b >> r100));
        float r107 = Float.intBitsToFloat((int) (r115.f20403b & r111));
        float r108 = Float.intBitsToFloat((int) (r115.f20404c >> r100));
        long r109 = r115.f20404c;
        long r116 = BodyPartID.bodyIdMax;
        r110.cubicTo(r104, r105, r106, r107, r108, Float.intBitsToFloat((int) (r109 & BodyPartID.bodyIdMax)));
    L10:
        r103 = r115.f20404c;
        r114 = r114 + 1;
        r111 = r116;
        r100 = ' ';
        goto L3
    L7:
        if (Offset.m4579equalsimpl0(r115.f20403b, r115.f20404c) == false) goto L9;
        r110.lineTo(Float.intBitsToFloat((int) (r115.f20404c >> r100)), Float.intBitsToFloat((int) (r115.f20404c & r111)));
        r116 = r111;
        goto L10
    L12:
        if (this.f20387a == false) goto L18;
        r110.close();
        return;
    }

    public final void d(boolean r100) {
        if (this.f20387a != r100) goto L5;
        return;
    L5:
        this.f20387a = r100;
        if (r100 == false) goto L8;
        a();
        return;
    L8:
        CollectionsKt.removeLast(this.f20391e);
    }

    public final void b(d r110, d r111, float r210) {
        Intrinsics.checkNotNullParameter(r110, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        Intrinsics.checkNotNullParameter(r111, "b");
        if (r110.f20387a == false) goto L5;
    L8:
        boolean r100 = true;
    L9:
        this.f20387a = r100;
        int r101 = Math.min(((ArrayList) r110.f20391e).size(), ((ArrayList) r111.f20391e).size());
        if (((ArrayList) this.f20391e).size() >= r101) goto L15;
        int r102 = r101 - ((ArrayList) this.f20391e).size();
        int r103 = 0;
    L12:
        if (r103 >= r102) goto L15;
        List<k> r104 = this.f20391e;
        Offset.Companion r105 = Offset.Companion;
        ArrayList r106 = (ArrayList) r104;
        r106.add(new k(r105.m4598getZeroF1C5BW0(), r105.m4598getZeroF1C5BW0(), r105.m4598getZeroF1C5BW0()));
        r103 = r103 + 1;
    L15:
        if (((ArrayList) this.f20391e).size() <= r101) goto L19;
        int r107 = ((ArrayList) this.f20391e).size() - r101;
        int r108 = 0;
    L17:
        if (r108 >= r107) goto L19;
        CollectionsKt.removeLast(this.f20391e);
        r108 = r108 + 1;
    L19:
        this.f20392f = OffsetKt.m4605lerpWko1d7g(r110.f20392f, r111.f20392f, r210);
        List<k> r109 = this.f20391e;
        int r112 = r109.size();
        int r113 = 0;
    L20:
        if (r113 >= r112) goto L22;
        k r114 = (k) ListProtector.get(r109, r113);
        k r115 = (k) ListProtector.get(r110.f20391e, r113);
        k r116 = (k) ListProtector.get(r111.f20391e, r113);
        r114.f20402a = OffsetKt.m4605lerpWko1d7g(r115.f20402a, r116.f20402a, r210);
        r114.f20403b = OffsetKt.m4605lerpWko1d7g(r115.f20403b, r116.f20403b, r210);
        r114.f20404c = OffsetKt.m4605lerpWko1d7g(r115.f20404c, r116.f20404c, r210);
        r113 = r113 + 1;
        goto L20
    L22:
        return;
    L5:
        if (r111.f20387a == true) goto L8;
        r100 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(boolean r210, List<? extends List<Float>> r211, List<? extends List<Float>> r212, List<? extends List<Float>> r213) {
        Intrinsics.checkNotNullParameter(r211, "inTangents");
        Intrinsics.checkNotNullParameter(r212, "outTangents");
        Intrinsics.checkNotNullParameter(r213, "vertices");
        this.f20387a = r210;
        this.f20388b = r211;
        this.f20389c = r212;
        this.f20390d = r213;
        this.f20391e = new ArrayList(r213.size());
        this.f20392f = Offset.Companion.m4598getZeroF1C5BW0();
        if ((!r213.isEmpty()) == false) goto L21;
        this.f20392f = fsc.b.d((List) CollectionsKt.first(r213));
        int r100 = CollectionsKt.getLastIndex(r213);
        if (1 > r100) goto L17;
        int r101 = 1;
    L7:
        int r102 = r101 - 1;
        List r103 = (List) ListProtector.get(this.f20390d, r102);
        List<Float> r104 = (List) CollectionsKt.getOrNull(this.f20389c, r102);
        if (r104 != null) goto L10;
        r104 = e.f20395a;
    L10:
        List<Float> r105 = (List) CollectionsKt.getOrNull(this.f20388b, r101);
        if (r105 != null) goto L13;
        r105 = e.f20395a;
    L13:
        List r106 = (List) ListProtector.get(this.f20390d, r101);
        float r107 = ((Number) ListProtector.get(r103, 0)).floatValue() + ((Number) ListProtector.get(r104, 0)).floatValue();
        float r108 = ((Number) ListProtector.get(r103, 1)).floatValue() + ((Number) ListProtector.get(r104, 1)).floatValue();
        long r109 = Float.floatToRawIntBits(r107);
        long r110 = Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r108)) & BodyPartID.bodyIdMax) | (r109 << 32));
        float r111 = ((Number) ListProtector.get(r106, 0)).floatValue() + ((Number) ListProtector.get(r105, 0)).floatValue();
        float r112 = ((Number) ListProtector.get(r106, 1)).floatValue() + ((Number) ListProtector.get(r105, 1)).floatValue();
        long r113 = Float.floatToRawIntBits(r111);
        long r114 = Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r112)) & BodyPartID.bodyIdMax) | (r113 << 32));
        ((ArrayList) this.f20391e).add(new k(r110, r114, fsc.b.d(r106)));
        if (r101 == r100) goto L17;
        r101 = r101 + 1;
    L17:
        if (this.f20387a == false) goto L22;
        a();
        return;
    L22:
        return;
    }

    public d(int r210, boolean r211, List r212, List r213, List r214) {
        if ((r210 & 0) == 0) goto L5;
        b2.b(r210, 0, a.f20394b);
        throw null;
    L5:
        if ((r210 & 1) != 0) goto L7;
        this.f20387a = false;
    L9:
        if ((r210 & 2) != 0) goto L11;
        List r100 = CollectionsKt.emptyList();
    L12:
        this.f20388b = r100;
        if ((r210 & 4) != 0) goto L15;
        List r101 = CollectionsKt.emptyList();
    L16:
        this.f20389c = r101;
        if ((r210 & 8) != 0) goto L19;
        List r102 = CollectionsKt.emptyList();
    L20:
        this.f20390d = r102;
        this.f20391e = new ArrayList(r102.size());
        this.f20392f = Offset.Companion.m4598getZeroF1C5BW0();
        if ((!r102.isEmpty()) == false) goto L41;
        this.f20392f = fsc.b.d((List) CollectionsKt.first(r102));
        int r103 = CollectionsKt.getLastIndex(r102);
        if (1 > r103) goto L35;
        int r104 = 1;
    L25:
        int r105 = r104 - 1;
        List r106 = (List) ListProtector.get(this.f20390d, r105);
        List<Float> r107 = (List) CollectionsKt.getOrNull(this.f20389c, r105);
        if (r107 != null) goto L28;
        r107 = e.f20395a;
    L28:
        List<Float> r108 = (List) CollectionsKt.getOrNull(this.f20388b, r104);
        if (r108 != null) goto L31;
        r108 = e.f20395a;
    L31:
        List r109 = (List) ListProtector.get(this.f20390d, r104);
        float r110 = ((Number) ListProtector.get(r106, 0)).floatValue() + ((Number) ListProtector.get(r107, 0)).floatValue();
        float r111 = ((Number) ListProtector.get(r106, 1)).floatValue() + ((Number) ListProtector.get(r107, 1)).floatValue();
        long r112 = Float.floatToRawIntBits(r110);
        long r113 = Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r111)) & BodyPartID.bodyIdMax) | (r112 << 32));
        float r114 = ((Number) ListProtector.get(r109, 0)).floatValue() + ((Number) ListProtector.get(r108, 0)).floatValue();
        float r115 = ((Number) ListProtector.get(r109, 1)).floatValue() + ((Number) ListProtector.get(r108, 1)).floatValue();
        long r116 = Float.floatToRawIntBits(r114);
        long r117 = Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r115)) & BodyPartID.bodyIdMax) | (r116 << 32));
        ((ArrayList) this.f20391e).add(new k(r113, r117, fsc.b.d(r109)));
        if (r104 == r103) goto L35;
        r104 = r104 + 1;
    L35:
        if (this.f20387a == false) goto L42;
        a();
        return;
    L42:
        return;
    L41:
        return;
    L19:
        r102 = r214;
        goto L20
    L15:
        r101 = r213;
        goto L16
    L11:
        r100 = r212;
        goto L12
    L7:
        this.f20387a = r211;
        goto L9
    }
}
