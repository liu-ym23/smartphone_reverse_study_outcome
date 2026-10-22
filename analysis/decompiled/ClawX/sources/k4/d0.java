package k4;

import com.stepos.stepclaw.SecurePrefs;
import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class d0 {

    /* renamed from: a, reason: collision with root package name */
    public static final List f3603a = a.a.S(SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);

    public static final int a(int i8, int i9, String str) {
        boolean z = false;
        while (i8 < i9) {
            char cCharAt = str.charAt(i8);
            if (cCharAt != ':') {
                if (cCharAt == '[') {
                    z = true;
                } else if (cCharAt == ']') {
                    z = false;
                }
            } else if (!z) {
                return i8;
            }
            i8++;
        }
        return -1;
    }

    public static final void b(c0 c0Var, String urlString) {
        kotlin.jvm.internal.p.e(c0Var, "<this>");
        kotlin.jvm.internal.p.e(urlString, "urlString");
        if (x5.n.t1(urlString)) {
            return;
        }
        try {
            c(c0Var, urlString);
        } catch (Throwable th) {
            throw new c6.m("Fail to parse url: ".concat(urlString), 2, th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x00e8 A[EDGE_INSN: B:284:0x00e8->B:78:0x00e8 BREAK  A[LOOP:3: B:62:0x00bd->B:76:0x00e0], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e0 A[LOOP:3: B:62:0x00bd->B:76:0x00e0, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void c(k4.c0 r18, java.lang.String r19) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 1058
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.d0.c(k4.c0, java.lang.String):void");
    }
}
