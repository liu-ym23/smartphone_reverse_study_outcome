package F1;

import A6.l;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.File;

/* loaded from: classes2.dex */
public final class c {
    public static volatile c b;
    public static b c;

    /* renamed from: a, reason: collision with root package name */
    public long f535a;

    public static boolean b() {
        long availableBytes = !TextUtils.isEmpty(D1.a.b().f) ? new StatFs(new File(D1.a.b().f).getPath()).getAvailableBytes() : "mounted".equals(Environment.getExternalStorageState()) ? new StatFs(Environment.getExternalStorageDirectory().getPath()).getAvailableBytes() : 0L;
        try {
            long jB = M.a.B();
            return availableBytes > 0 && jB > 0 && ((float) availableBytes) > ((float) jB) * 1.5f;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static c e() {
        if (b == null) {
            synchronized (c.class) {
                try {
                    if (b == null) {
                        c cVar = new c();
                        cVar.f535a = System.currentTimeMillis();
                        S0.b.L(D1.a.b().f371a, "You must call init() first before using !!!");
                        b = cVar;
                        c = b.b();
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public void a(long j5) {
        this.f535a = j5;
        H1.c.d().e();
        D1.a aVarB = D1.a.b();
        S0.b.L(aVarB.b, "a mustn't be null");
        if (aVarB.b.c == 2) {
            E1.a.b.execute(new l(this, 5));
        } else {
            d();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x01cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 465
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F1.c.c():void");
    }

    public void d() {
        try {
            if (b()) {
                c();
                I1.a aVarA = I1.a.a();
                aVarA.getClass();
                U7.a.j("finish dumpHeap", new Object[0]);
                aVarA.c = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
