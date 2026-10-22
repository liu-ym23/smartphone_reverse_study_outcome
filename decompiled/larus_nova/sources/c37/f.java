package c37;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes21.dex */
@Serializable
public final class f {
    public static final b Companion = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final juc.d<Object>[] f22314j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f22317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.bdnavigationsdk.pojo.a f22318d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.bdnavigationsdk.pojo.a f22319e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f22320f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f22321g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f22322h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<d> f22323i;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f22324a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f22325b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f22325b;
        }

        static {
            a r100 = new a();
            f22324a = r100;
            g2 r101 = new g2("com.bytedance.navigation.kmp.data.params.RoutePlanParams", r100, 9);
            r101.j("session_id", false);
            r101.j("business", false);
            r101.j("plan_type", false);
            r101.j(PlayerResolution.SDKKEY.ORIGIN, false);
            r101.j(com.bytedance.android.ec.core.event.a.KEY_DESTINATION, false);
            r101.j(com.bytedance.android.ec.core.event.a.KEY_ORIGIN_ID, true);
            r101.j("destination_id", true);
            r101.j("alternative_route", true);
            r101.j("waypoints", true);
            f22325b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            juc.d<Object>[] r100 = f.f22314j;
            v2 r101 = v2.f520790a;
            com.bytedance.bdnavigationsdk.pojo.a.C2885a r102 = com.bytedance.bdnavigationsdk.pojo.a.C2885a.f200332a;
            return new juc.d[]{r101, r101, r101, r102, r102, kuc.a.d(r101), kuc.a.d(r101), w0.f520792a, kuc.a.d(r100[8])};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f22325b;
            muc.c r101 = r210.beginStructure(r100);
            juc.d<Object>[] r102 = f.f22314j;
            int r103 = 8;
            if (r101.decodeSequentially() == false) goto L5;
            String r104 = r101.decodeStringElement(r100, 0);
            String r110 = r101.decodeStringElement(r100, 1);
            String r105 = r101.decodeStringElement(r100, 2);
            com.bytedance.bdnavigationsdk.pojo.a.C2885a r111 = com.bytedance.bdnavigationsdk.pojo.a.C2885a.f200332a;
            com.bytedance.bdnavigationsdk.pojo.a r106 = (com.bytedance.bdnavigationsdk.pojo.a) r101.decodeSerializableElement(r100, 3, r111, null);
            com.bytedance.bdnavigationsdk.pojo.a r107 = (com.bytedance.bdnavigationsdk.pojo.a) r101.decodeSerializableElement(r100, 4, r111, null);
            v2 r112 = v2.f520790a;
            String r108 = (String) r101.decodeNullableSerializableElement(r100, 5, r112, null);
            String r113 = (String) r101.decodeNullableSerializableElement(r100, 6, r112, null);
            int r109 = r101.decodeIntElement(r100, 7);
            List r114 = (List) r101.decodeNullableSerializableElement(r100, 8, r102[8], null);
            String r115 = r108;
            int r116 = r109;
            com.bytedance.bdnavigationsdk.pojo.a r117 = r107;
            String r118 = r110;
            String r119 = r113;
            int r120 = 511;
            com.bytedance.bdnavigationsdk.pojo.a r121 = r106;
            String r122 = r105;
            String r123 = r104;
        L25:
            r101.endStructure(r100);
            return new f(r120, r123, r118, r122, r121, r117, r115, r119, r116, r114);
        L5:
            String r124 = null;
            String r125 = null;
            List r126 = null;
            com.bytedance.bdnavigationsdk.pojo.a r127 = null;
            com.bytedance.bdnavigationsdk.pojo.a r128 = null;
            String r129 = null;
            String r130 = null;
            String r131 = null;
            int r132 = 0;
            int r133 = 0;
            boolean r211 = true;
        L6:
            if (r211 == false) goto L24;
            int r134 = r101.decodeElementIndex(r100);
            switch(r134) {
                case -1: goto L23;
                case 0: goto L21;
                case 1: goto L19;
                case 2: goto L18;
                case 3: goto L17;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r134);
        L23:
            r103 = 8;
            r211 = false;
            goto L6
        L11:
            r126 = (List) r101.decodeNullableSerializableElement(r100, r103, r102[r103], r126);
            r132 = r132 | 256;
        L22:
            r103 = 8;
            goto L6
        L12:
            r133 = r101.decodeIntElement(r100, 7);
            r132 = r132 | 128;
            goto L22
        L13:
            r125 = (String) r101.decodeNullableSerializableElement(r100, 6, v2.f520790a, r125);
            r132 = r132 | 64;
            goto L22
        L14:
            r124 = (String) r101.decodeNullableSerializableElement(r100, 5, v2.f520790a, r124);
            r132 = r132 | 32;
            goto L22
        L15:
            r128 = (com.bytedance.bdnavigationsdk.pojo.a) r101.decodeSerializableElement(r100, 4, com.bytedance.bdnavigationsdk.pojo.a.C2885a.f200332a, r128);
            r132 = r132 | 16;
            goto L22
        L17:
            r127 = (com.bytedance.bdnavigationsdk.pojo.a) r101.decodeSerializableElement(r100, 3, com.bytedance.bdnavigationsdk.pojo.a.C2885a.f200332a, r127);
            r132 = r132 | 8;
            goto L22
        L18:
            r130 = r101.decodeStringElement(r100, 2);
            r132 = r132 | 4;
            goto L22
        L19:
            r129 = r101.decodeStringElement(r100, 1);
            r132 = r132 | 2;
            goto L22
        L21:
            r132 = r132 | 1;
            r131 = r101.decodeStringElement(r100, 0);
            goto L22
        L24:
            r120 = r132;
            r117 = r128;
            r118 = r129;
            r114 = r126;
            r116 = r133;
            r121 = r127;
            r115 = r124;
            r119 = r125;
            r122 = r130;
            r123 = r131;
            goto L25
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            f r102 = (f) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f22325b;
            muc.d r104 = r100.beginStructure(r103);
            juc.d<Object>[] r105 = f.f22314j;
            boolean r106 = false;
            r104.encodeStringElement(r103, 0, r102.f22315a);
            r104.encodeStringElement(r103, 1, r102.f22316b);
            r104.encodeStringElement(r103, 2, r102.f22317c);
            com.bytedance.bdnavigationsdk.pojo.a.C2885a r107 = com.bytedance.bdnavigationsdk.pojo.a.C2885a.f200332a;
            r104.encodeSerializableElement(r103, 3, r107, r102.f22318d);
            r104.encodeSerializableElement(r103, 4, r107, r102.f22319e);
            if (r104.shouldEncodeElementDefault(r103, 5) == false) goto L6;
        L7:
            boolean r108 = true;
        L9:
            if (r108 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 5, v2.f520790a, r102.f22320f);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 6) == false) goto L15;
        L16:
            boolean r109 = true;
        L18:
            if (r109 == false) goto L21;
            r104.encodeNullableSerializableElement(r103, 6, v2.f520790a, r102.f22321g);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 7) == false) goto L24;
        L25:
            boolean r110 = true;
        L27:
            if (r110 == false) goto L30;
            r104.encodeIntElement(r103, 7, r102.f22322h);
        L30:
            if (r104.shouldEncodeElementDefault(r103, 8) == false) goto L33;
        L34:
            r106 = true;
        L35:
            if (r106 == false) goto L37;
            r104.encodeNullableSerializableElement(r103, 8, r105[8], r102.f22323i);
        L37:
            r104.endStructure(r103);
            return;
        L33:
            if (r102.f22323i == null) goto L35;
        L24:
            if (r102.f22322h != 1) goto L25;
            r110 = false;
            goto L27
        L15:
            if (r102.f22321g != null) goto L16;
            r109 = false;
            goto L18
        L6:
            if (r102.f22320f != null) goto L7;
            r108 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<f> serializer() {
            return a.f22324a;
        }
    }

    public f() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f22315a, r101.f22315a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f22316b, r101.f22316b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f22317c, r101.f22317c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f22318d, r101.f22318d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f22319e, r101.f22319e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f22320f, r101.f22320f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f22321g, r101.f22321g) == true) goto L30;
        return false;
    L30:
        if (this.f22322h == r101.f22322h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f22323i, r101.f22323i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f22315a.hashCode() * 31) + this.f22316b.hashCode()) * 31) + this.f22317c.hashCode()) * 31) + this.f22318d.hashCode()) * 31) + this.f22319e.hashCode()) * 31;
        String r101 = this.f22320f;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f22321g;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f22322h) * 31;
        List<d> r108 = this.f22323i;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "RoutePlanParams(sessionId=" + this.f22315a + ", businessId=" + this.f22316b + ", planType=" + this.f22317c + ", origin=" + this.f22318d + ", destination=" + this.f22319e + ", originId=" + this.f22320f + ", destinationId=" + this.f22321g + ", alternativeRoute=" + this.f22322h + ", wayPoints=" + this.f22323i + ")";
    }

    static {
        Companion = new b();
        f22314j = new juc.d[]{null, null, null, null, null, null, null, null, new nuc.f(d.a.f22296a)};
    }

    public f(String r100, String r101, String r102, com.bytedance.bdnavigationsdk.pojo.a r103, com.bytedance.bdnavigationsdk.pojo.a r104, String r105, List r106) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "businessId");
        Intrinsics.checkNotNullParameter(r102, "planType");
        Intrinsics.checkNotNullParameter(r103, PlayerResolution.SDKKEY.ORIGIN);
        Intrinsics.checkNotNullParameter(r104, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
        this.f22315a = r100;
        this.f22316b = r101;
        this.f22317c = r102;
        this.f22318d = r103;
        this.f22319e = r104;
        this.f22320f = null;
        this.f22321g = r105;
        this.f22322h = 1;
        this.f22323i = r106;
    }

    public f(int r100, String r101, String r102, String r103, com.bytedance.bdnavigationsdk.pojo.a r104, com.bytedance.bdnavigationsdk.pojo.a r105, String r110, String r111, int r112, List r113) {
        if (31 != (r100 & 31)) goto L21;
        this.f22315a = r101;
        this.f22316b = r102;
        this.f22317c = r103;
        this.f22318d = r104;
        this.f22319e = r105;
        if ((r100 & 32) != 0) goto L7;
        this.f22320f = null;
    L9:
        if ((r100 & 64) != 0) goto L11;
        this.f22321g = null;
    L13:
        if ((r100 & 128) != 0) goto L15;
        this.f22322h = 1;
    L17:
        if ((r100 & 256) != 0) goto L19;
        this.f22323i = null;
        return;
    L19:
        this.f22323i = r113;
        return;
    L15:
        this.f22322h = r112;
        goto L17
    L11:
        this.f22321g = r111;
        goto L13
    L7:
        this.f22320f = r110;
        goto L9
    L21:
        b2.b(r100, 31, a.f22325b);
        throw null;
    }
}
