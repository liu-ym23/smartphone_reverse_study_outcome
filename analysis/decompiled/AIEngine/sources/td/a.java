package td;

import java.io.EOFException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f13073a;

    static {
        byte[] bytes = "0123456789abcdef".getBytes(gc.a.f9106b);
        kotlin.jvm.internal.g.e(bytes, "getBytes(...)");
        f13073a = bytes;
    }

    public static final String a(sd.e eVar, long j10) throws EOFException {
        kotlin.jvm.internal.g.f(eVar, "<this>");
        if (j10 > 0) {
            long j11 = j10 - 1;
            if (eVar.S(j11) == 13) {
                String strI0 = eVar.I0(j11, gc.a.f9106b);
                eVar.skip(2L);
                return strI0;
            }
        }
        String strI02 = eVar.I0(j10, gc.a.f9106b);
        eVar.skip(1L);
        return strI02;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0061, code lost:
    
        if (r18 == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0063, code lost:
    
        return -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0083, code lost:
    
        return r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int b(sd.e r16, sd.w r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 178
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: td.a.b(sd.e, sd.w, boolean):int");
    }
}
