package Y1;

import X1.e;
import Z1.f;
import com.stepos.core.error.AIEngineError;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f6988a = {100000000, 10000000, 1000000, AIEngineError.UNKNOWN, 10000, 1000, 100, 10, 1};

    public static String a(char[] cArr, int i10, e eVar) {
        return new String(cArr, 0, i10 + (eVar != null ? b(cArr, i10, eVar) : 0));
    }

    public static int b(char[] cArr, int i10, e eVar) {
        if (eVar.equals(e.f6846c)) {
            cArr[i10] = 'Z';
            return 1;
        }
        cArr[i10] = eVar.d() < 0 ? '-' : '+';
        f.e(Math.abs(eVar.a()), cArr, i10 + 1, 2);
        cArr[i10 + 3] = ':';
        f.e(Math.abs(eVar.b()), cArr, i10 + 4, 2);
        return 6;
    }
}
