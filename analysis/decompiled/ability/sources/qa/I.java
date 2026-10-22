package qa;

import F9.AbstractC0226d;
import F9.C0237o;
import fa.C1449a;
import io.modelcontextprotocol.spec.HttpHeaders;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class I {
    public static final char[] l = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final Pattern m = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");

    /* renamed from: a, reason: collision with root package name */
    public final String f5630a;
    public final F9.y b;
    public String c;
    public F9.x d;
    public final K1.a e = new K1.a();
    public final F9.v f;
    public F9.B g;
    public final boolean h;
    public final A5.c i;

    /* renamed from: j, reason: collision with root package name */
    public final C1449a f5631j;
    public F9.K k;

    public I(String str, F9.y yVar, String str2, F9.w wVar, F9.B b, boolean z10, boolean z11, boolean z12) {
        this.f5630a = str;
        this.b = yVar;
        this.c = str2;
        this.g = b;
        this.h = z10;
        if (wVar != null) {
            this.f = wVar.g();
        } else {
            this.f = new F9.v(0);
        }
        if (z11) {
            this.f5631j = new C1449a(1);
            return;
        }
        if (z12) {
            A5.c cVar = new A5.c(1);
            this.i = cVar;
            F9.B type = F9.D.f;
            kotlin.jvm.internal.k.f(type, "type");
            if (type.b.equals("multipart")) {
                cVar.c = type;
            } else {
                throw new IllegalArgumentException(("multipart != " + type).toString());
            }
        }
    }

    public final void a(String name, String str, boolean z10) {
        C1449a c1449a = this.f5631j;
        if (z10) {
            c1449a.getClass();
            kotlin.jvm.internal.k.f(name, "name");
            ((ArrayList) c1449a.b).add(C0237o.c(name, 0, true, " \"':;<=>@[]^`{}|/\\?#&!$(),~", 0, 83));
            ((ArrayList) c1449a.c).add(C0237o.c(str, 0, true, " \"':;<=>@[]^`{}|/\\?#&!$(),~", 0, 83));
            return;
        }
        c1449a.getClass();
        kotlin.jvm.internal.k.f(name, "name");
        ((ArrayList) c1449a.b).add(C0237o.c(name, 0, false, " \"':;<=>@[]^`{}|/\\?#&!$(),~", 0, 91));
        ((ArrayList) c1449a.c).add(C0237o.c(str, 0, false, " \"':;<=>@[]^`{}|/\\?#&!$(),~", 0, 91));
    }

    public final void b(String str, String str2, boolean z10) {
        if (HttpHeaders.CONTENT_TYPE.equalsIgnoreCase(str)) {
            try {
                Pattern pattern = F9.B.e;
                this.g = AbstractC0226d.g(str2);
                return;
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(B7.a.k("Malformed content type: ", str2), e);
            }
        }
        F9.v vVar = this.f;
        if (z10) {
            vVar.e(str, str2);
        } else {
            vVar.c(str, str2);
        }
    }

    public final void c(F9.w wVar, F9.K body) {
        A5.c cVar = this.i;
        cVar.getClass();
        kotlin.jvm.internal.k.f(body, "body");
        if (wVar.b(HttpHeaders.CONTENT_TYPE) != null) {
            throw new IllegalArgumentException("Unexpected header: Content-Type");
        }
        if (wVar.b(HttpHeaders.CONTENT_LENGTH) != null) {
            throw new IllegalArgumentException("Unexpected header: Content-Length");
        }
        ((ArrayList) cVar.d).add(new F9.C(wVar, body));
    }

    public final void d(String str, String str2, boolean z10) {
        String str3 = this.c;
        if (str3 != null) {
            F9.y yVar = this.b;
            F9.x xVarG = yVar.g(str3);
            this.d = xVarG;
            if (xVarG == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + yVar + ", Relative: " + this.c);
            }
            this.c = null;
        }
        if (z10) {
            this.d.a(str, str2);
        } else {
            this.d.b(str, str2);
        }
    }
}
