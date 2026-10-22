package td;

import okio.ByteString;
import sd.x;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final ByteString f13075a;

    /* renamed from: b, reason: collision with root package name */
    public static final ByteString f13076b;

    /* renamed from: c, reason: collision with root package name */
    public static final ByteString f13077c;

    /* renamed from: d, reason: collision with root package name */
    public static final ByteString f13078d;

    /* renamed from: e, reason: collision with root package name */
    public static final ByteString f13079e;

    static {
        ByteString byteString = ByteString.f11312d;
        f13075a = ByteString.a.b("/");
        f13076b = ByteString.a.b("\\");
        f13077c = ByteString.a.b("/\\");
        f13078d = ByteString.a.b(".");
        f13079e = ByteString.a.b("..");
    }

    public static final int a(x xVar) {
        ByteString byteString = xVar.f11982a;
        if (byteString.d() != 0) {
            if (byteString.j(0) != 47) {
                if (byteString.j(0) == 92) {
                    if (byteString.d() > 2 && byteString.j(1) == 92) {
                        ByteString other = f13076b;
                        kotlin.jvm.internal.g.f(other, "other");
                        int iG = byteString.g(other.i(), 2);
                        return iG == -1 ? byteString.d() : iG;
                    }
                } else if (byteString.d() > 2 && byteString.j(1) == 58 && byteString.j(2) == 92) {
                    char cJ = (char) byteString.j(0);
                    if ('a' <= cJ && cJ < '{') {
                        return 3;
                    }
                    if ('A' <= cJ && cJ < '[') {
                        return 3;
                    }
                }
            }
            return 1;
        }
        return -1;
    }

    public static final x b(x xVar, x child, boolean z) {
        kotlin.jvm.internal.g.f(child, "child");
        if (a(child) != -1 || child.d() != null) {
            return child;
        }
        ByteString byteStringC = c(xVar);
        if (byteStringC == null && (byteStringC = c(child)) == null) {
            byteStringC = f(x.f11981b);
        }
        sd.e eVar = new sd.e();
        eVar.N0(xVar.f11982a);
        if (eVar.f11926b > 0) {
            eVar.N0(byteStringC);
        }
        eVar.N0(child.f11982a);
        return d(eVar, z);
    }

    public static final ByteString c(x xVar) {
        ByteString byteString = xVar.f11982a;
        ByteString byteString2 = f13075a;
        if (ByteString.h(byteString, byteString2) != -1) {
            return byteString2;
        }
        ByteString byteString3 = xVar.f11982a;
        ByteString byteString4 = f13076b;
        if (ByteString.h(byteString3, byteString4) != -1) {
            return byteString4;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x011b A[EDGE_INSN: B:101:0x011b->B:84:0x011b BREAK  A[LOOP:1: B:53:0x00ab->B:116:0x00ab], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0139  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final sd.x d(sd.e r17, boolean r18) throws java.io.EOFException {
        /*
            Method dump skipped, instructions count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: td.c.d(sd.e, boolean):sd.x");
    }

    public static final ByteString e(byte b10) {
        if (b10 == 47) {
            return f13075a;
        }
        if (b10 == 92) {
            return f13076b;
        }
        throw new IllegalArgumentException(ai.onnxruntime.providers.a.a(b10, "not a directory separator: "));
    }

    public static final ByteString f(String str) {
        if (kotlin.jvm.internal.g.b(str, "/")) {
            return f13075a;
        }
        if (kotlin.jvm.internal.g.b(str, "\\")) {
            return f13076b;
        }
        throw new IllegalArgumentException(ai.onnxruntime.a.k("not a directory separator: ", str));
    }
}
