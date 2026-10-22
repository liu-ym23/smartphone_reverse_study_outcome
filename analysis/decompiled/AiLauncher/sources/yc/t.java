package yc;

import Mb.C0966d;
import Mb.InterfaceC0967e;
import com.autonavi.aps.amapapi.config.Const;
import java.io.EOFException;
import java.io.IOException;
import java.util.regex.Pattern;
import tb.AbstractC5529B;
import tb.C5528A;
import tb.C5551r;
import tb.u;
import tb.v;
import tb.y;

/* loaded from: classes5.dex */
public final class t {

    /* renamed from: l, reason: collision with root package name */
    public static final char[] f44417l = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: m, reason: collision with root package name */
    public static final Pattern f44418m = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");

    /* renamed from: a, reason: collision with root package name */
    public final String f44419a;

    /* renamed from: b, reason: collision with root package name */
    public final tb.v f44420b;

    /* renamed from: c, reason: collision with root package name */
    public String f44421c;

    /* renamed from: d, reason: collision with root package name */
    public v.a f44422d;

    /* renamed from: e, reason: collision with root package name */
    public final C5528A.a f44423e = new C5528A.a();

    /* renamed from: f, reason: collision with root package name */
    public final u.a f44424f;

    /* renamed from: g, reason: collision with root package name */
    public tb.x f44425g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f44426h;

    /* renamed from: i, reason: collision with root package name */
    public y.a f44427i;

    /* renamed from: j, reason: collision with root package name */
    public C5551r.a f44428j;

    /* renamed from: k, reason: collision with root package name */
    public AbstractC5529B f44429k;

    public static class a extends AbstractC5529B {

        /* renamed from: a, reason: collision with root package name */
        public final AbstractC5529B f44430a;

        /* renamed from: b, reason: collision with root package name */
        public final tb.x f44431b;

        public a(AbstractC5529B abstractC5529B, tb.x xVar) {
            this.f44430a = abstractC5529B;
            this.f44431b = xVar;
        }

        @Override // tb.AbstractC5529B
        public long a() throws IOException {
            return this.f44430a.a();
        }

        @Override // tb.AbstractC5529B
        /* renamed from: b */
        public tb.x getContentType() {
            return this.f44431b;
        }

        @Override // tb.AbstractC5529B
        public void g(InterfaceC0967e interfaceC0967e) throws IOException {
            this.f44430a.g(interfaceC0967e);
        }
    }

    public t(String str, tb.v vVar, String str2, tb.u uVar, tb.x xVar, boolean z10, boolean z11, boolean z12) {
        this.f44419a = str;
        this.f44420b = vVar;
        this.f44421c = str2;
        this.f44425g = xVar;
        this.f44426h = z10;
        if (uVar != null) {
            this.f44424f = uVar.i();
        } else {
            this.f44424f = new u.a();
        }
        if (z11) {
            this.f44428j = new C5551r.a();
        } else if (z12) {
            y.a aVar = new y.a();
            this.f44427i = aVar;
            aVar.d(tb.y.f42274k);
        }
    }

    public static String i(String str, boolean z10) throws EOFException {
        int length = str.length();
        int iCharCount = 0;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt < 32 || iCodePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(iCodePointAt) != -1 || (!z10 && (iCodePointAt == 47 || iCodePointAt == 37))) {
                C0966d c0966d = new C0966d();
                c0966d.R(str, 0, iCharCount);
                j(c0966d, str, iCharCount, length, z10);
                return c0966d.Y0();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str;
    }

    public static void j(C0966d c0966d, String str, int i10, int i11, boolean z10) throws EOFException {
        C0966d c0966d2 = null;
        while (i10 < i11) {
            int iCodePointAt = str.codePointAt(i10);
            if (!z10 || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt < 32 || iCodePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(iCodePointAt) != -1 || (!z10 && (iCodePointAt == 47 || iCodePointAt == 37))) {
                    if (c0966d2 == null) {
                        c0966d2 = new C0966d();
                    }
                    c0966d2.z(iCodePointAt);
                    long size = c0966d2.getSize();
                    for (long j10 = 0; j10 < size; j10++) {
                        byte bY = c0966d2.Y(j10);
                        c0966d.writeByte(37);
                        char[] cArr = f44417l;
                        c0966d.writeByte(cArr[((bY & 255) >> 4) & 15]);
                        c0966d.writeByte(cArr[bY & 15]);
                    }
                    c0966d2.g();
                } else {
                    c0966d.z(iCodePointAt);
                }
            }
            i10 += Character.charCount(iCodePointAt);
        }
    }

    public void a(String str, String str2, boolean z10) {
        if (z10) {
            this.f44428j.b(str, str2);
        } else {
            this.f44428j.a(str, str2);
        }
    }

    public void b(String str, String str2, boolean z10) {
        if (!"Content-Type".equalsIgnoreCase(str)) {
            if (z10) {
                this.f44424f.e(str, str2);
                return;
            } else {
                this.f44424f.a(str, str2);
                return;
            }
        }
        try {
            this.f44425g = tb.x.e(str2);
        } catch (IllegalArgumentException e10) {
            throw new IllegalArgumentException("Malformed content type: " + str2, e10);
        }
    }

    public void c(tb.u uVar) {
        this.f44424f.b(uVar);
    }

    public void d(tb.u uVar, AbstractC5529B abstractC5529B) {
        this.f44427i.a(uVar, abstractC5529B);
    }

    public void e(y.c cVar) {
        this.f44427i.b(cVar);
    }

    public void f(String str, String str2, boolean z10) throws EOFException {
        if (this.f44421c == null) {
            throw new AssertionError();
        }
        String strI = i(str2, z10);
        String strReplace = this.f44421c.replace(Const.STR_MART_JSON_BEGIN + str + "}", strI);
        if (!f44418m.matcher(strReplace).matches()) {
            this.f44421c = strReplace;
            return;
        }
        throw new IllegalArgumentException("@Path parameters shouldn't perform path traversal ('.' or '..'): " + str2);
    }

    public void g(String str, String str2, boolean z10) {
        String str3 = this.f44421c;
        if (str3 != null) {
            v.a aVarK = this.f44420b.k(str3);
            this.f44422d = aVarK;
            if (aVarK == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f44420b + ", Relative: " + this.f44421c);
            }
            this.f44421c = null;
        }
        if (z10) {
            this.f44422d.a(str, str2);
        } else {
            this.f44422d.b(str, str2);
        }
    }

    public <T> void h(Class<T> cls, T t10) {
        this.f44423e.r(cls, t10);
    }

    public C5528A.a k() {
        tb.v vVarS;
        v.a aVar = this.f44422d;
        if (aVar != null) {
            vVarS = aVar.c();
        } else {
            vVarS = this.f44420b.s(this.f44421c);
            if (vVarS == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f44420b + ", Relative: " + this.f44421c);
            }
        }
        AbstractC5529B aVar2 = this.f44429k;
        if (aVar2 == null) {
            C5551r.a aVar3 = this.f44428j;
            if (aVar3 != null) {
                aVar2 = aVar3.c();
            } else {
                y.a aVar4 = this.f44427i;
                if (aVar4 != null) {
                    aVar2 = aVar4.c();
                } else if (this.f44426h) {
                    aVar2 = AbstractC5529B.d(null, new byte[0]);
                }
            }
        }
        tb.x xVar = this.f44425g;
        if (xVar != null) {
            if (aVar2 != null) {
                aVar2 = new a(aVar2, xVar);
            } else {
                this.f44424f.a("Content-Type", xVar.getMediaType());
            }
        }
        return this.f44423e.u(vVarS).m(this.f44424f.f()).n(this.f44419a, aVar2);
    }

    public void l(AbstractC5529B abstractC5529B) {
        this.f44429k = abstractC5529B;
    }

    public void m(Object obj) {
        this.f44421c = obj.toString();
    }
}
