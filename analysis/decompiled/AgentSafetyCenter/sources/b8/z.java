package b8;

import com.google.crypto.tink.aead.internal.InsecureNonceXChaCha20;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import java.security.GeneralSecurityException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class z implements y0, e1.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2040a;

    public /* synthetic */ z(int i) {
        this.f2040a = i;
    }

    public static /* synthetic */ void c() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d(int i, int i3) {
        throw new ArrayIndexOutOfBoundsException("Failed writing " + ((char) i) + ((Object) " at index ") + i3);
    }

    public static /* synthetic */ void e(int i, int i3, Object obj, String str) {
        throw new IllegalArgumentException(str + i + obj + i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void f(int i, long j10) {
        throw new ArrayIndexOutOfBoundsException("Failed writing " + ((char) i) + ((Object) " at index ") + j10);
    }

    public static /* synthetic */ void g(int i, Object obj) {
        throw new IllegalStateException("Source subfield " + i + ((Object) " is present but null: ") + obj);
    }

    public static /* synthetic */ void h(int i, Object obj, Object obj2) {
        throw new IllegalArgumentException("Cannot create TypeBindings for class " + obj + obj2 + i);
    }

    public static /* synthetic */ void i(int i, StringBuilder sb2) {
        sb2.append(i);
        throw new IndexOutOfBoundsException(sb2.toString());
    }

    public static /* synthetic */ void j(Object obj) {
        throw new IllegalStateException(obj.toString());
    }

    public static /* synthetic */ void k(Object obj, String str) throws GeneralSecurityException {
        throw new GeneralSecurityException(str + obj);
    }

    public static /* synthetic */ void l(String str) throws GeneralSecurityException {
        throw new GeneralSecurityException(str);
    }

    public static /* synthetic */ void m(String str, Object obj, Object obj2) {
        throw new IllegalStateException(str + obj + obj2);
    }

    public static /* synthetic */ void n(String str, Object obj, Object obj2, Object obj3) {
        throw new IllegalArgumentException(str + obj + obj2 + obj3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void o(String str, Object obj, Object obj2, Object obj3, int i) {
        throw new IllegalArgumentException(str + obj + obj2 + obj3 + ((char) i));
    }

    public static /* synthetic */ void p(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        throw new IllegalArgumentException(str + obj + obj2 + obj3 + obj4);
    }

    public static /* synthetic */ void q(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        throw new IllegalArgumentException(str + obj + obj2 + obj3 + obj4 + obj5);
    }

    public static /* synthetic */ void r(String str, Object obj, Object obj2, Object obj3, Throwable th) {
        throw new IllegalArgumentException(str + obj + obj2 + obj3, th);
    }

    public static /* synthetic */ void s(String str, Throwable th) throws GeneralSecurityException {
        throw new GeneralSecurityException(str, th);
    }

    public static /* synthetic */ void t(String str, yd.a aVar, String str2, yd.a aVar2) {
        throw new ce.a(str, aVar, str2, aVar2);
    }

    public static /* synthetic */ void u(String str, Object[] objArr) {
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    public static /* synthetic */ void v(Throwable th, Object obj, String str) {
        throw new RuntimeException(str + obj, th);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007b  */
    @Override // b8.y0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b8.a a(w7.n r12, com.fasterxml.jackson.databind.JsonNode r13, w7.l r14, androidx.room.q r15) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b8.z.a(w7.n, com.fasterxml.jackson.databind.JsonNode, w7.l, androidx.room.q):b8.a");
    }

    @Override // e1.i
    public double b(double d7) {
        switch (this.f2040a) {
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                double d10 = d7 < 0.0d ? -d7 : d7;
                return Math.copySign(d10 >= 0.0031308049535603718d ? (Math.pow(d10, 0.4166666666666667d) - 0.05213270142180095d) / 0.9478672985781991d : d10 / 0.07739938080495357d, d7);
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                double d11 = d7 < 0.0d ? -d7 : d7;
                return Math.copySign(d11 >= 0.04045d ? Math.pow((0.9478672985781991d * d11) + 0.05213270142180095d, 2.4d) : d11 * 0.07739938080495357d, d7);
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                float[] fArr = e1.d.f3342a;
                return e1.d.b(e1.d.f3344c, d7);
            case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                float[] fArr2 = e1.d.f3342a;
                return e1.d.a(e1.d.f3344c, d7);
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                float[] fArr3 = e1.d.f3342a;
                return e1.d.d(e1.d.f3345d, d7);
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                float[] fArr4 = e1.d.f3342a;
                return e1.d.c(e1.d.f3345d, d7);
            default:
                return d7;
        }
    }
}
