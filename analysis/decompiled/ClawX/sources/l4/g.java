package l4;

import a6.y;
import io.ktor.utils.io.o0;
import java.util.List;
import java.util.Set;
import k4.z;
import kotlin.jvm.internal.p;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final Set f3814a = c5.l.k0(new Character[]{'/', '?', '#', '@'});

    /* renamed from: b, reason: collision with root package name */
    public static final int f3815b;

    static {
        List list = o0.f3224b;
        f3815b = 6;
        z.e(c5.l.S(new String[]{"HTTP/1.0", "HTTP/1.1"}), new com.stepos.stepclaw.gateway.d(22), new y(11));
    }

    public static final void a(m4.c cVar, char c3) {
        throw new c6.m("Character with code " + (c3 & 255) + " is not allowed in header names, \n" + ((Object) cVar));
    }

    public static final int b(m4.c cVar, e0.j jVar) {
        int i8 = jVar.f2312c;
        for (int i9 = jVar.f2311b; i9 < i8; i9++) {
            char cCharAt = cVar.charAt(i9);
            if (cCharAt == ':' && i9 != jVar.f2311b) {
                jVar.f2311b = i9 + 1;
                return i9;
            }
            if (p.g(cCharAt, 32) <= 0 || n.h1("\"(),/:;<=>?@[\\]{}", cCharAt)) {
                int i10 = jVar.f2311b;
                if (cCharAt == ':') {
                    throw new c6.m("Empty header names are not allowed as per RFC7230.", false);
                }
                if (i9 == i10) {
                    throw new c6.m("Multiline headers via line folding is not supported since it is deprecated as per RFC7230.", false);
                }
                a(cVar, cCharAt);
                throw null;
            }
        }
        throw new c6.m("No colon in HTTP header in " + cVar.subSequence(jVar.f2311b, jVar.f2312c).toString() + " in builder: \n" + ((Object) cVar));
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00c4, code lost:
    
        a(r3, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00c7, code lost:
    
        throw null;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0079 A[Catch: all -> 0x007d, TryCatch #0 {all -> 0x007d, blocks: (B:23:0x0070, B:25:0x0079, B:29:0x0081, B:32:0x008c, B:35:0x0098, B:38:0x00a4, B:40:0x00a9, B:56:0x00d4, B:19:0x0058, B:43:0x00b0, B:52:0x00c4, B:53:0x00c7, B:54:0x00c8, B:55:0x00ce, B:57:0x00e3, B:58:0x00ea, B:59:0x00eb, B:61:0x00f5), top: B:65:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0081 A[Catch: all -> 0x007d, TryCatch #0 {all -> 0x007d, blocks: (B:23:0x0070, B:25:0x0079, B:29:0x0081, B:32:0x008c, B:35:0x0098, B:38:0x00a4, B:40:0x00a9, B:56:0x00d4, B:19:0x0058, B:43:0x00b0, B:52:0x00c4, B:53:0x00c7, B:54:0x00c8, B:55:0x00ce, B:57:0x00e3, B:58:0x00ea, B:59:0x00eb, B:61:0x00f5), top: B:65:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x006b -> B:65:0x0070). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(io.ktor.utils.io.p r17, m4.c r18, e0.j r19, h5.c r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l4.g.c(io.ktor.utils.io.p, m4.c, e0.j, h5.c):java.lang.Object");
    }

    public static final void d(m4.b bVar) {
        if (n.k1(bVar, ":")) {
            throw new c6.m("Host header with ':' should contains port: " + ((Object) bVar));
        }
        for (int i8 = 0; i8 < bVar.length(); i8++) {
            Character chValueOf = Character.valueOf(bVar.charAt(i8));
            Set set = f3814a;
            if (set.contains(chValueOf)) {
                throw new c6.m("Host cannot contain any of the following symbols: " + set);
            }
        }
    }
}
