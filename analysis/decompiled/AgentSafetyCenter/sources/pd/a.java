package pd;

import java.io.EOFException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f9997a;

    static {
        byte[] bytes = "0123456789abcdef".getBytes(hc.a.f5448a);
        bytes.getClass();
        f9997a = bytes;
    }

    public static final String a(od.i iVar, long j10) throws EOFException {
        if (j10 > 0) {
            long j11 = j10 - 1;
            if (iVar.C(j11) == 13) {
                String strT = iVar.T(j11, hc.a.f5448a);
                iVar.W(2L);
                return strT;
            }
        }
        String strT2 = iVar.T(j10, hc.a.f5448a);
        iVar.W(1L);
        return strT2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x005a, code lost:
    
        if (r18 == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005c, code lost:
    
        return -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007c, code lost:
    
        return r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int b(od.i r16, od.y r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 171
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: pd.a.b(od.i, od.y, boolean):int");
    }
}
