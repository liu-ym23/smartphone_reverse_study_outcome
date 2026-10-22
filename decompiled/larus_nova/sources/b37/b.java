package b37;

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
public final class b {
    public static final C0258b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17205c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f17206a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f17207b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            return new juc.d[]{kuc.a.d(r100), w0.f520792a, kuc.a.d(r100)};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f17207b;
        }

        static {
            a r100 = new a();
            f17206a = r100;
            g2 r101 = new g2("com.bytedance.navigation.kmp.data.KMPRouteUpdateRequestResult", r100, 3);
            r101.j("routeUpdateId", true);
            r101.j("code", false);
            r101.j("message", true);
            f17207b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f17207b;
            muc.c r111 = r110.beginStructure(r100);
            if (r111.decodeSequentially() == false) goto L5;
            v2 r101 = v2.f520790a;
            String r102 = (String) r111.decodeNullableSerializableElement(r100, 0, r101, null);
            int r103 = r111.decodeIntElement(r100, 1);
            String r104 = (String) r111.decodeNullableSerializableElement(r100, 2, r101, null);
            int r105 = 7;
        L19:
            r111.endStructure(r100);
            return new b(r105, r102, r103, r104);
        L5:
            String r106 = null;
            String r107 = null;
            int r108 = 0;
            int r109 = 0;
            boolean r112 = true;
        L6:
            if (r112 == false) goto L18;
            int r113 = r111.decodeElementIndex(r100);
            if (r113 != (-1)) goto L9;
            r112 = false;
            goto L6
        L9:
            if (r113 != 0) goto L10;
            r106 = (String) r111.decodeNullableSerializableElement(r100, 0, v2.f520790a, r106);
            r108 = r108 | 1;
            goto L6
        L10:
            if (r113 != 1) goto L11;
            r109 = r111.decodeIntElement(r100, 1);
            r108 = r108 | 2;
            goto L6
        L11:
            if (r113 != 2) goto L14;
            r107 = (String) r111.decodeNullableSerializableElement(r100, 2, v2.f520790a, r107);
            r108 = r108 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r113);
        L18:
            r105 = r108;
            r103 = r109;
            r102 = r106;
            r104 = r107;
            goto L19
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            b r102 = (b) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f17207b;
            muc.d r104 = r100.beginStructure(r103);
            C0258b r105 = b.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L11;
            r104.encodeNullableSerializableElement(r103, 0, v2.f520790a, r102.f17203a);
        L11:
            r104.encodeIntElement(r103, 1, r102.f17204b);
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L15;
        L16:
            r106 = true;
        L17:
            if (r106 == false) goto L19;
            r104.encodeNullableSerializableElement(r103, 2, v2.f520790a, r102.f17205c);
        L19:
            r104.endStructure(r103);
            return;
        L15:
            if (r102.f17205c == null) goto L17;
        L6:
            if (r102.f17203a != null) goto L7;
            r107 = false;
            goto L9
        }
    }

    /* JADX INFO: renamed from: b37.b$b, reason: collision with other inner class name */
    public static final class C0258b {
        public C0258b() {
        }

        public final juc.d<b> serializer() {
            return a.f17206a;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f17203a, r101.f17203a) == true) goto L12;
        return false;
    L12:
        if (this.f17204b == r101.f17204b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f17205c, r101.f17205c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f17203a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f17204b) * 31;
        String r104 = this.f17205c;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "KMPRouteUpdateRequestResult(routeUpdateId=" + this.f17203a + ", code=" + this.f17204b + ", message=" + this.f17205c + ")";
    }

    static {
        Companion = new C0258b();
    }

    public b(String r100, int r101, String r102) {
        this.f17203a = r100;
        this.f17204b = r101;
        this.f17205c = r102;
    }

    public b(int r100, String r101, int r102, String r103) {
        if (2 == (r100 & 2)) goto L5;
        b2.b(r100, 2, a.f17207b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f17203a = null;
    L8:
        this.f17204b = r102;
        if ((r100 & 4) != 0) goto L11;
        this.f17205c = null;
        return;
    L11:
        this.f17205c = r103;
        return;
    L7:
        this.f17203a = r101;
        goto L8
    }
}
