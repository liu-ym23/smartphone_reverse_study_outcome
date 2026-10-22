package c37;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b0;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes21.dex */
@Serializable
public final class d {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f22291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f22292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f22293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f22294d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f22295e;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f22296a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f22297b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            b0 r100 = b0.f520644a;
            v2 r101 = v2.f520790a;
            return new juc.d[]{r100, r100, kuc.a.d(r101), kuc.a.d(w0.f520792a), kuc.a.d(r101)};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f22297b;
        }

        static {
            a r100 = new a();
            f22296a = r100;
            g2 r101 = new g2("com.bytedance.navigation.kmp.data.params.KMPRouteWayPoint", r100, 5);
            r101.j("latitude", false);
            r101.j("longitude", false);
            r101.j("poiId", true);
            r101.j("poiType", true);
            r101.j("poiName", true);
            f22297b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f22297b;
            muc.c r101 = r210.beginStructure(r100);
            String r102 = null;
            if (r101.decodeSequentially() == false) goto L5;
            double r103 = r101.decodeDoubleElement(r100, 0);
            double r110 = r101.decodeDoubleElement(r100, 1);
            v2 r104 = v2.f520790a;
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 2, r104, null);
            Integer r106 = (Integer) r101.decodeNullableSerializableElement(r100, 3, w0.f520792a, null);
            String r211 = (String) r101.decodeNullableSerializableElement(r100, 4, r104, null);
            String r212 = r105;
            Integer r213 = r106;
            double r111 = r103;
            double r214 = r110;
            int r112 = 31;
        L25:
            r101.endStructure(r100);
            return new d(r112, r111, r214, r212, r213, r211);
        L5:
            double r113 = 0.0d;
            double r114 = 0.0d;
            int r107 = 0;
            boolean r115 = true;
            Integer r108 = null;
            String r116 = null;
        L6:
            if (r115 == false) goto L24;
            int r109 = r101.decodeElementIndex(r100);
            if (r109 != (-1)) goto L9;
            r115 = false;
            goto L6
        L9:
            if (r109 != 0) goto L10;
            r113 = r101.decodeDoubleElement(r100, 0);
            r107 = r107 | 1;
            goto L6
        L10:
            if (r109 != 1) goto L12;
            r114 = r101.decodeDoubleElement(r100, 1);
            r107 = r107 | 2;
            goto L6
        L12:
            if (r109 == 2) goto L19;
            if (r109 == 3) goto L18;
            if (r109 != 4) goto L17;
            r107 = r107 | 16;
            r116 = (String) r101.decodeNullableSerializableElement(r100, 4, v2.f520790a, r116);
            goto L6
        L17:
            throw new UnknownFieldException(r109);
        L18:
            r107 = r107 | 8;
            r108 = (Integer) r101.decodeNullableSerializableElement(r100, 3, w0.f520792a, r108);
            goto L6
        L19:
            r107 = r107 | 4;
            r102 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r102);
            goto L6
        L24:
            r112 = r107;
            r212 = r102;
            r213 = r108;
            r211 = r116;
            r111 = r113;
            r214 = r114;
            goto L25
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            d r102 = (d) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f22297b;
            muc.d r104 = r100.beginStructure(r103);
            boolean r105 = false;
            r104.encodeDoubleElement(r103, 0, r102.f22291a);
            r104.encodeDoubleElement(r103, 1, r102.f22292b);
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L6;
        L7:
            boolean r106 = true;
        L9:
            if (r106 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 2, v2.f520790a, r102.f22293c);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L15;
        L16:
            boolean r107 = true;
        L18:
            if (r107 == false) goto L21;
            r104.encodeNullableSerializableElement(r103, 3, w0.f520792a, r102.f22294d);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 4) == false) goto L24;
        L25:
            r105 = true;
        L26:
            if (r105 == false) goto L28;
            r104.encodeNullableSerializableElement(r103, 4, v2.f520790a, r102.f22295e);
        L28:
            r104.endStructure(r103);
            return;
        L24:
            if (r102.f22295e == null) goto L26;
        L15:
            if (r102.f22294d != null) goto L16;
            r107 = false;
            goto L18
        L6:
            if (r102.f22293c != null) goto L7;
            r106 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<d> serializer() {
            return a.f22296a;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Double.compare(this.f22291a, r101.f22291a) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.f22292b, r101.f22292b) == 0) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f22293c, r101.f22293c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f22294d, r101.f22294d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f22295e, r101.f22295e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        long r100 = Double.doubleToLongBits(this.f22291a);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = Double.doubleToLongBits(this.f22292b);
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        String r104 = this.f22293c;
        int r105 = 0;
        if (r104 != null) goto L5;
        int r106 = 0;
    L6:
        int r107 = (r103 + r106) * 31;
        Integer r108 = this.f22294d;
        if (r108 != null) goto L9;
        int r109 = 0;
    L10:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f22295e;
        if (r111 == null) goto L15;
        r105 = r111.hashCode();
    L15:
        return r110 + r105;
    L9:
        r109 = r108.hashCode();
        goto L10
    L5:
        r106 = r104.hashCode();
        goto L6
    }

    public final String toString() {
        return "KMPRouteWayPoint(latitude=" + this.f22291a + ", longitude=" + this.f22292b + ", poiId=" + this.f22293c + ", poiType=" + this.f22294d + ", poiName=" + this.f22295e + ")";
    }

    static {
        Companion = new b();
    }

    public d(double r100, double r101, String r102, Integer r103, String r104) {
        this.f22291a = r100;
        this.f22292b = r101;
        this.f22293c = r102;
        this.f22294d = r103;
        this.f22295e = r104;
    }

    public d(int r100, double r101, double r102, String r103, Integer r110, String r111) {
        if (3 != (r100 & 3)) goto L17;
        this.f22291a = r101;
        this.f22292b = r102;
        if ((r100 & 4) != 0) goto L7;
        this.f22293c = null;
    L9:
        if ((r100 & 8) != 0) goto L11;
        this.f22294d = null;
    L13:
        if ((r100 & 16) != 0) goto L15;
        this.f22295e = null;
        return;
    L15:
        this.f22295e = r111;
        return;
    L11:
        this.f22294d = r110;
        goto L13
    L7:
        this.f22293c = r103;
        goto L9
    L17:
        b2.b(r100, 3, a.f22297b);
        throw null;
    }
}
