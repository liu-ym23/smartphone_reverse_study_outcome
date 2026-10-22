package c5a;

import android.util.Log;
import com.lynx.base.log.LynxLog;

/* JADX INFO: loaded from: classes32.dex */
public final class c {
    public static void e() {
        a.f22523a.booleanValue();
    }

    public static String a(String r100, Throwable r101) {
        String r102 = Log.getStackTraceString(r101);
        if (r102.isEmpty() == false) goto L6;
        return r100;
    L6:
        return r100 + '\n' + r102;
    }

    public static void c(String r100, String r101) {
        if (a.f22523a.booleanValue() == false) goto L6;
        d(4, r100, r101);
        return;
    }

    public static void b(String r100, String r101, Throwable r102) {
        d(6, r100, a(r101, r102));
    }

    public static void d(int r100, String r101, String r102) {
        int r103 = 2;
        if (r100 > 2) goto L6;
        r103 = 0;
    L14:
        LynxLog.internalLog(r103, r101, r102);
        return;
    L6:
        if (r100 != 3) goto L8;
        r103 = 1;
        goto L14
    L8:
        if (r100 == 4) goto L14;
        if (r100 == 5) goto L12;
        r103 = 4;
        goto L14
    L12:
        r103 = 3;
        goto L14
    }

    public static void f(String r100, String r101, Throwable r102) {
        d(5, r100, a(r101, r102));
    }
}
