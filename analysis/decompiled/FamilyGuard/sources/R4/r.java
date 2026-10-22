package R4;

import C4.D;
import C4.E;
import C4.t;
import C4.v;
import C4.w;
import C4.z;
import java.io.EOFException;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
final class r {

    /* renamed from: l, reason: collision with root package name */
    private static final char[] f5112l = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: m, reason: collision with root package name */
    private static final Pattern f5113m = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");

    /* renamed from: a, reason: collision with root package name */
    private final String f5114a;

    /* renamed from: b, reason: collision with root package name */
    private final C4.w f5115b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private String f5116c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private w.a f5117d;

    /* renamed from: e, reason: collision with root package name */
    private final D.a f5118e = new D.a();

    /* renamed from: f, reason: collision with root package name */
    private final v.a f5119f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    private C4.y f5120g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f5121h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private z.a f5122i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    private t.a f5123j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    private E f5124k;

    private static class a extends E {

        /* renamed from: a, reason: collision with root package name */
        private final E f5125a;

        /* renamed from: b, reason: collision with root package name */
        private final C4.y f5126b;

        a(E e6, C4.y yVar) {
            this.f5125a = e6;
            this.f5126b = yVar;
        }

        @Override // C4.E
        public long a() {
            return this.f5125a.a();
        }

        @Override // C4.E
        public C4.y b() {
            return this.f5126b;
        }

        @Override // C4.E
        public void h(L4.f fVar) {
            this.f5125a.h(fVar);
        }
    }

    r(String str, C4.w wVar, @Nullable String str2, @Nullable C4.v vVar, @Nullable C4.y yVar, boolean z5, boolean z6, boolean z7) {
        this.f5114a = str;
        this.f5115b = wVar;
        this.f5116c = str2;
        this.f5120g = yVar;
        this.f5121h = z5;
        if (vVar != null) {
            this.f5119f = vVar.f();
        } else {
            this.f5119f = new v.a();
        }
        if (z6) {
            this.f5123j = new t.a();
        } else if (z7) {
            z.a aVar = new z.a();
            this.f5122i = aVar;
            aVar.d(z.f985j);
        }
    }

    private static String i(String str, boolean z5) throws EOFException {
        int length = str.length();
        int iCharCount = 0;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt < 32 || iCodePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(iCodePointAt) != -1 || (!z5 && (iCodePointAt == 47 || iCodePointAt == 37))) {
                L4.e eVar = new L4.e();
                eVar.w0(str, 0, iCharCount);
                j(eVar, str, iCharCount, length, z5);
                return eVar.O();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str;
    }

    private static void j(L4.e eVar, String str, int i5, int i6, boolean z5) throws EOFException {
        L4.e eVar2 = null;
        while (i5 < i6) {
            int iCodePointAt = str.codePointAt(i5);
            if (!z5 || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt < 32 || iCodePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(iCodePointAt) != -1 || (!z5 && (iCodePointAt == 47 || iCodePointAt == 37))) {
                    if (eVar2 == null) {
                        eVar2 = new L4.e();
                    }
                    eVar2.z0(iCodePointAt);
                    while (!eVar2.t()) {
                        byte b6 = eVar2.readByte();
                        eVar.writeByte(37);
                        char[] cArr = f5112l;
                        eVar.writeByte(cArr[((b6 & 255) >> 4) & 15]);
                        eVar.writeByte(cArr[b6 & 15]);
                    }
                } else {
                    eVar.z0(iCodePointAt);
                }
            }
            i5 += Character.charCount(iCodePointAt);
        }
    }

    void a(String str, String str2, boolean z5) {
        if (z5) {
            this.f5123j.b(str, str2);
        } else {
            this.f5123j.a(str, str2);
        }
    }

    void b(String str, String str2) {
        if (!"Content-Type".equalsIgnoreCase(str)) {
            this.f5119f.a(str, str2);
            return;
        }
        try {
            this.f5120g = C4.y.b(str2);
        } catch (IllegalArgumentException e6) {
            throw new IllegalArgumentException("Malformed content type: " + str2, e6);
        }
    }

    void c(C4.v vVar) {
        this.f5119f.b(vVar);
    }

    void d(C4.v vVar, E e6) {
        this.f5122i.a(vVar, e6);
    }

    void e(z.b bVar) {
        this.f5122i.b(bVar);
    }

    void f(String str, String str2, boolean z5) throws EOFException {
        if (this.f5116c == null) {
            throw new AssertionError();
        }
        String strI = i(str2, z5);
        String strReplace = this.f5116c.replace("{" + str + "}", strI);
        if (!f5113m.matcher(strReplace).matches()) {
            this.f5116c = strReplace;
            return;
        }
        throw new IllegalArgumentException("@Path parameters shouldn't perform path traversal ('.' or '..'): " + str2);
    }

    void g(String str, @Nullable String str2, boolean z5) {
        String str3 = this.f5116c;
        if (str3 != null) {
            w.a aVarQ = this.f5115b.q(str3);
            this.f5117d = aVarQ;
            if (aVarQ == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f5115b + ", Relative: " + this.f5116c);
            }
            this.f5116c = null;
        }
        if (z5) {
            this.f5117d.a(str, str2);
        } else {
            this.f5117d.b(str, str2);
        }
    }

    <T> void h(Class<T> cls, @Nullable T t5) {
        this.f5118e.g(cls, t5);
    }

    D.a k() {
        C4.w wVarC;
        w.a aVar = this.f5117d;
        if (aVar != null) {
            wVarC = aVar.c();
        } else {
            wVarC = this.f5115b.C(this.f5116c);
            if (wVarC == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f5115b + ", Relative: " + this.f5116c);
            }
        }
        E aVar2 = this.f5124k;
        if (aVar2 == null) {
            t.a aVar3 = this.f5123j;
            if (aVar3 != null) {
                aVar2 = aVar3.c();
            } else {
                z.a aVar4 = this.f5122i;
                if (aVar4 != null) {
                    aVar2 = aVar4.c();
                } else if (this.f5121h) {
                    aVar2 = E.d(null, new byte[0]);
                }
            }
        }
        C4.y yVar = this.f5120g;
        if (yVar != null) {
            if (aVar2 != null) {
                aVar2 = new a(aVar2, yVar);
            } else {
                this.f5119f.a("Content-Type", yVar.toString());
            }
        }
        return this.f5118e.h(wVarC).d(this.f5119f.e()).e(this.f5114a, aVar2);
    }

    void l(E e6) {
        this.f5124k = e6;
    }

    void m(Object obj) {
        this.f5116c = obj.toString();
    }
}
