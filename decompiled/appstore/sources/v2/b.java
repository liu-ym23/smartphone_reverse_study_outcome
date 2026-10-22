package v2;

import com.bytedance.apm6.cpu.ApmCpuManager;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f25051a;

    public static String a() {
        return f25051a;
    }

    public static void b(String r10) {
        f25051a = r10;
    }

    public static boolean c() {
        return d();
    }

    public static boolean d() {
        f25051a = ApmCpuManager.c().b();
        return false;
    }

    public static boolean e(u2.b r10, double r11, boolean r12) {
        if (r12 == false) goto L29;
        if (r10.a().isEmpty() == true) goto L19;
        Iterator r13 = ApmCpuManager.c().a().iterator();
        double r14 = 0.0d;
    L8:
        if (r13.hasNext() == false) goto L21;
        String r15 = (String) r13.next();
        if (r10.a().containsKey(r15) == false) goto L8;
        double r16 = ((Double) r10.a().get(r15)).doubleValue();
        if (r16 < 0.0d) goto L8;
        if (r14 > r16) goto L8;
        r14 = r16;
    L21:
        if (r14 > 0.0d) goto L25;
        r14 = r10.c();
    L25:
        if (r11 > r14) goto L27;
        return false;
    L27:
        return true;
    L19:
        r14 = 0.0d;
        goto L21
    L29:
        if (r10.b().isEmpty() == true) goto L43;
        Iterator r17 = ApmCpuManager.c().a().iterator();
        double r18 = 0.0d;
    L32:
        if (r17.hasNext() == false) goto L45;
        String r19 = (String) r17.next();
        if (r10.b().containsKey(r19) == false) goto L32;
        double r20 = ((Double) r10.b().get(r19)).doubleValue();
        if (r20 < 0.0d) goto L32;
        if (r18 > r20) goto L32;
        r18 = r20;
    L45:
        if (r18 > 0.0d) goto L49;
        r18 = r10.d();
    L49:
        if (r11 > r18) goto L51;
        return false;
    L51:
        return true;
    L43:
        r18 = 0.0d;
        goto L45
    }
}
