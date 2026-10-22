package l3;

import java.io.EOFException;
import k3.C0694i;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* renamed from: l3.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0765a {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f13505a;

    static {
        Intrinsics.checkNotNullParameter("0123456789abcdef", "<this>");
        byte[] bytes = "0123456789abcdef".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        f13505a = bytes;
    }

    public static final String a(C0694i c0694i, long j4) throws EOFException {
        Intrinsics.checkNotNullParameter(c0694i, "<this>");
        if (j4 > 0) {
            long j5 = j4 - 1;
            if (c0694i.l(j5) == ((byte) 13)) {
                String strN = c0694i.N(j5, Charsets.UTF_8);
                c0694i.j(2L);
                return strN;
            }
        }
        c0694i.getClass();
        String strN2 = c0694i.N(j4, Charsets.UTF_8);
        c0694i.j(1L);
        return strN2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0063, code lost:
    
        if (r20 == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0065, code lost:
    
        return -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0066, code lost:
    
        return r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int b(k3.C0694i r18, k3.t r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 186
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l3.AbstractC0765a.b(k3.i, k3.t, boolean):int");
    }
}
