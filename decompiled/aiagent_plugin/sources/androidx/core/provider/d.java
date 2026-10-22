package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import androidx.b.g;
import androidx.core.graphics.j;
import com.bytedance.keva.KevaImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: FontRequestWorker.java */
/* JADX INFO: loaded from: classes.dex */
class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final androidx.b.e<String, Typeface> f1304a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Object f1305b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final g<String, ArrayList<androidx.core.util.a<a>>> f1306c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ExecutorService f1307d = null;

    /* JADX INFO: compiled from: FontRequestWorker.java */
    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Typeface f1318a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f1319b;

        a(int r2) {
            this.f1318a = null;
            this.f1319b = r2;
        }

        a(Typeface r1) {
            this.f1318a = r1;
            this.f1319b = 0;
        }

        boolean a() {
            if (this.f1319b != 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        f1304a = new androidx.b.e(16);
        f1307d = e.a("fonts-androidx", 10, KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD);
        f1305b = new Object();
        f1306c = new g();
    }

    static Typeface a(Context r4, final c r5, androidx.core.provider.a r6, final int r7, int r8) {
        final Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        final String r0 = a(r5, r7);
        Typeface r2 = (Typeface) ZeusTransformUtils.preCheckCast(f1304a.a(r0), Typeface.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L7;
        r6.a(new a(r2));
        return r2;
    L7:
        if (r8 != (-1)) goto L10;
        a r10 = a(r0, r9, r5, r7);
        r6.a(r10);
        return r10.f1318a;
    L10:
        Callable<a> r3 = new AnonymousClass1(r0, r9, r5, r7);
        a r11 = (a) ZeusTransformUtils.preCheckCast(e.a(f1307d, r3, r8), a.class, "com.obric.aiagent.plugin");     // Catch: InterruptedException -> L13
        r6.a(r11);     // Catch: InterruptedException -> L13
        return r11.f1318a;
    L13:
        r6.a(new a(-3));
        return null;
    }

    static Typeface a(Context r6, final c r7, final int r8, Executor r9, final androidx.core.provider.a r10) {
        final Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        Executor r12 = (Executor) ZeusTransformUtils.wrapperContextForParams(r9, Executor.class, "com.obric.aiagent.plugin");
        final String r0 = a(r7, r8);
        Typeface r1 = (Typeface) ZeusTransformUtils.preCheckCast(f1304a.a(r0), Typeface.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L6;
        r10.a(new a(r1));
        return r1;
    L6:
        androidx.core.util.a<a> r2 = new AnonymousClass2(r10);
        Object r13 = f1305b;
        monitor-enter(r13);
        g<String, ArrayList<androidx.core.util.a<a>>> r3 = f1306c;     // Catch: Throwable -> L20
        ArrayList r4 = (ArrayList) ZeusTransformUtils.preCheckCast(r3.get(r0), ArrayList.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        if (r4 == null) goto L13;
        r4.add(r2);     // Catch: Throwable -> L20
        monitor-exit(r13);     // Catch: Throwable -> L20
        return null;
    L13:
        ArrayList<androidx.core.util.a<a>> r5 = new ArrayList();     // Catch: Throwable -> L20
        r5.add(r2);     // Catch: Throwable -> L20
        r3.put(r0, r5);     // Catch: Throwable -> L20
        monitor-exit(r13);     // Catch: Throwable -> L20
        Callable<a> r14 = new AnonymousClass3(r0, r11, r7, r8);
        if (r12 != null) goto L18;
        r12 = f1307d;
    L18:
        e.a(r12, r14, new AnonymousClass4(r0));
        return null;
    L20:
        th = move-exception;
        throw th;
    }

    private static String a(c r1, int r2) {
        return r1.f() + "-" + r2;
    }

    static a a(String r4, Context r5, c r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        androidx.b.e<String, Typeface> r0 = f1304a;
        Typeface r1 = (Typeface) ZeusTransformUtils.preCheckCast(r0.a(r4), Typeface.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L20;
        return new a(r1);
    L20:
        FontsContractCompat.a r9 = FontProvider.a(r8, r6, null);     // Catch: PackageManager.NameNotFoundException -> L18
        int r2 = a(r9);
        if (r2 != 0) goto L11;
        Typeface r10 = j.a(r8, null, r9.b(), r7);
        if (r10 == null) goto L17;
        r0.a(r4, r10);
        return new a(r10);
    L17:
        return new a(-3);
    L11:
        return new a(r2);
    L19:
        return new a(-1);
    }

    private static int a(FontsContractCompat.a r5) {
        int r2 = 1;
        if (r5.a() != 0) goto L5;
        FontsContractCompat.b[] r6 = r5.b();
        if (r6 != null) goto L12;
    L23:
        return r2;
    L12:
        if (r6.length == 0) goto L23;
        int r0 = r6.length;
        r2 = 0;
        int r3 = 0;
    L15:
        if (r3 >= r0) goto L23;
        int r4 = r6[r3].e();
        if (r4 != 0) goto L18;
        r3 = r3 + 1;
        goto L15
    L18:
        if (r4 >= 0) goto L21;
        return -3;
    L21:
        return r4;
    L5:
        if (r5.a() == 1) goto L7;
        return -3;
    L7:
        return -2;
    }
}
