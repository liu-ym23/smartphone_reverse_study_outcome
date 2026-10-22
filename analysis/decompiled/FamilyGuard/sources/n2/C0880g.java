package n2;

import C4.E;
import C4.y;
import com.stepos.familyguard.encrypt.AESUtils;
import java.util.HashMap;
import java.util.Map;
import l0.AbstractC0822a;

/* renamed from: n2.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0880g extends E {

    /* renamed from: d, reason: collision with root package name */
    private static final y f18924d = y.c("text/json; charset=utf-8");

    /* renamed from: a, reason: collision with root package name */
    private final String f18925a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f18926b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f18927c;

    /* renamed from: n2.g$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Map<String, Object> f18928a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f18929b = true;

        /* renamed from: c, reason: collision with root package name */
        private boolean f18930c = true;

        public a(Map<String, Object> map) {
            this.f18928a = map;
        }

        public a a(String str, Object obj) {
            this.f18928a.put(str, obj);
            return this;
        }

        public C0880g b() {
            return c(T1.b.b());
        }

        public C0880g c(String str) {
            try {
                if (this.f18930c) {
                    this.f18928a.put("imei", str);
                    this.f18928a.put("app_version", Integer.valueOf(T1.b.d()));
                    this.f18928a.put("app_package", P1.a.a().getPackageName());
                }
                return new C0880g(AbstractC0822a.F(this.f18928a), this.f18929b);
            } catch (Exception e6) {
                e6.printStackTrace();
                return null;
            }
        }
    }

    public static a k() {
        return new a(new HashMap());
    }

    @Override // C4.E
    public long a() {
        return this.f18926b.length;
    }

    @Override // C4.E
    public y b() {
        return f18924d;
    }

    @Override // C4.E
    public void h(L4.f fVar) {
        byte[] bArr = this.f18926b;
        fVar.write(bArr, 0, bArr.length);
    }

    String i() {
        return this.f18925a;
    }

    boolean j() {
        return this.f18927c;
    }

    public String toString() {
        return "OkHttpRequestBody{params='" + this.f18925a + "'}";
    }

    private C0880g(String str, boolean z5) {
        this.f18925a = str;
        if (z5) {
            this.f18926b = AESUtils.b(str).getBytes();
        } else {
            this.f18926b = str.getBytes();
        }
        this.f18927c = z5;
    }
}
