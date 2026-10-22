package z2;

import android.app.Application;
import android.content.Context;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f6933a = false;
    public static boolean b = false;
    public static boolean c = false;
    public static boolean d = false;
    public static boolean e = false;
    public static final M9.f f;
    public static volatile boolean g;
    public static boolean h;

    static {
        M9.f fVar = new M9.f();
        fVar.f981a = new CopyOnWriteArrayList();
        fVar.b = new CopyOnWriteArrayList();
        fVar.c = new CopyOnWriteArrayList();
        fVar.d = new CopyOnWriteArrayList();
        fVar.e = new CopyOnWriteArrayList();
        fVar.f = new CopyOnWriteArrayList();
        f = fVar;
        g = false;
        h = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0044, code lost:
    
        if (r9 != false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized void a(android.app.Application r9, android.content.Context r10, boolean r11, boolean r12, boolean r13, boolean r14) {
        /*
            java.lang.String r0 = "Npth.init takes "
            java.lang.Class<z2.k> r1 = z2.k.class
            monitor-enter(r1)
            long r2 = android.os.SystemClock.uptimeMillis()     // Catch: java.lang.Throwable -> L50
            boolean r4 = z2.k.f6933a     // Catch: java.lang.Throwable -> L50
            if (r4 == 0) goto Lf
            monitor-exit(r1)
            return
        Lf:
            r4 = 1
            z2.k.f6933a = r4     // Catch: java.lang.Throwable -> L50
            if (r10 == 0) goto Lca
            if (r9 == 0) goto Lca
            com.apm.insight.g.d(r9, r10)     // Catch: java.lang.Throwable -> L50
            boolean r5 = com.apm.insight.g.f2166v     // Catch: java.lang.Throwable -> L50
            r6 = 0
            if (r5 == 0) goto L53
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L2e
            java.lang.String r7 = N9.j.C(r9)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r8 = "npth"
            r5.<init>(r7, r8)     // Catch: java.lang.Throwable -> L2e
            boolean r5 = r5.exists()     // Catch: java.lang.Throwable -> L2e
            goto L2f
        L2e:
            r5 = r6
        L2f:
            if (r5 != 0) goto L47
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L43
            android.content.pm.ApplicationInfo r9 = r9.getApplicationInfo()     // Catch: java.lang.Throwable -> L43
            java.lang.String r9 = r9.nativeLibraryDir     // Catch: java.lang.Throwable -> L43
            java.lang.String r7 = "libnpth.so"
            r5.<init>(r9, r7)     // Catch: java.lang.Throwable -> L43
            boolean r9 = r5.exists()     // Catch: java.lang.Throwable -> L43
            goto L44
        L43:
            r9 = r6
        L44:
            if (r9 != 0) goto L47
            goto L53
        L47:
            java.lang.String r9 = "apminsight"
            java.lang.String r10 = "Inner npth checked."
            android.util.Log.e(r9, r10)     // Catch: java.lang.Throwable -> L50
            monitor-exit(r1)
            return
        L50:
            r9 = move-exception
            goto Ld2
        L53:
            if (r11 != 0) goto L57
            if (r12 == 0) goto L71
        L57:
            q2.b r9 = q2.C1797b.c()     // Catch: java.lang.Throwable -> L50
            if (r12 == 0) goto L65
            com.zyql.ability.sdk.client.b r12 = new com.zyql.ability.sdk.client.b     // Catch: java.lang.Throwable -> L50
            r5 = 2
            r12.<init>(r10, r5)     // Catch: java.lang.Throwable -> L50
            r9.b = r12     // Catch: java.lang.Throwable -> L50
        L65:
            if (r11 == 0) goto L6f
            com.zyql.ability.sdk.client.b r11 = new com.zyql.ability.sdk.client.b     // Catch: java.lang.Throwable -> L50
            r12 = 1
            r11.<init>(r10, r12)     // Catch: java.lang.Throwable -> L50
            r9.c = r11     // Catch: java.lang.Throwable -> L50
        L6f:
            z2.k.b = r4     // Catch: java.lang.Throwable -> L50
        L71:
            boolean r9 = com.apm.insight.nativecrash.NativeImpl.b     // Catch: java.lang.Throwable -> L50
            if (r9 == 0) goto L76
            goto L84
        L76:
            com.apm.insight.nativecrash.NativeImpl.b = r4     // Catch: java.lang.Throwable -> L50
            boolean r9 = com.apm.insight.nativecrash.NativeImpl.f2193a     // Catch: java.lang.Throwable -> L50
            if (r9 != 0) goto L84
            java.lang.String r9 = "apminsighta"
            java.lang.System.loadLibrary(r9)     // Catch: java.lang.Throwable -> L82
            r6 = r4
        L82:
            com.apm.insight.nativecrash.NativeImpl.f2193a = r6     // Catch: java.lang.Throwable -> L50
        L84:
            if (r13 == 0) goto L90
            boolean r9 = com.apm.insight.nativecrash.NativeImpl.g(r10)     // Catch: java.lang.Throwable -> L50
            z2.k.d = r9     // Catch: java.lang.Throwable -> L50
            if (r9 != 0) goto L90
            z2.k.e = r4     // Catch: java.lang.Throwable -> L50
        L90:
            if (r14 == 0) goto La1
            android.os.Looper r9 = android.os.Looper.myLooper()     // Catch: java.lang.Throwable -> L50
            android.os.Looper r10 = android.os.Looper.getMainLooper()     // Catch: java.lang.Throwable -> L50
            if (r9 != r10) goto La1
            z2.k.g = r4     // Catch: java.lang.Throwable -> L50
            com.apm.insight.nativecrash.NativeImpl.w()     // Catch: java.lang.Throwable -> L50
        La1:
            z2.r r9 = z2.l.i()     // Catch: java.lang.Throwable -> L50
            r2.b r10 = new r2.b     // Catch: java.lang.Throwable -> L50
            r10.<init>(r14)     // Catch: java.lang.Throwable -> L50
            r11 = 0
            r9.b(r10, r11)     // Catch: java.lang.Throwable -> L50
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L50
            r9.<init>(r0)     // Catch: java.lang.Throwable -> L50
            long r10 = android.os.SystemClock.uptimeMillis()     // Catch: java.lang.Throwable -> L50
            long r10 = r10 - r2
            r9.append(r10)     // Catch: java.lang.Throwable -> L50
            java.lang.String r10 = " ms."
            r9.append(r10)     // Catch: java.lang.Throwable -> L50
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> L50
            S0.b.N(r9)     // Catch: java.lang.Throwable -> L50
            monitor-exit(r1)
            return
        Lca:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L50
            java.lang.String r10 = "context or Application must be not null."
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L50
            throw r9     // Catch: java.lang.Throwable -> L50
        Ld2:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L50
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: z2.k.a(android.app.Application, android.content.Context, boolean, boolean, boolean, boolean):void");
    }

    public static synchronized void b(Context context, boolean z10, boolean z11, boolean z12, boolean z13) {
        Application application = com.apm.insight.g.b;
        if (application == null) {
            if (context instanceof Application) {
                application = (Application) context;
                if (application.getBaseContext() == null) {
                    throw new IllegalArgumentException("初始化时传入的Application还未attach, 请在init时传入attachBaseContext的参数, 并在init之前手动调用Npth.setApplication(Application).");
                }
            } else {
                application = (Application) context.getApplicationContext();
                if (application == null) {
                    throw new IllegalArgumentException("初始化时传入了baseContext, 导致无法获取Application实例, 请在init之前手动调用Npth.setApplication(Application).");
                }
                if (application.getBaseContext() != null) {
                    context = application.getBaseContext();
                }
            }
        }
        a(application, context, z10, z11, z12, z13);
    }

    public static void c(ICrashCallback iCrashCallback, CrashType crashType) {
        M9.f fVar = f;
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) fVar.d;
        CopyOnWriteArrayList copyOnWriteArrayList2 = (CopyOnWriteArrayList) fVar.b;
        CopyOnWriteArrayList copyOnWriteArrayList3 = (CopyOnWriteArrayList) fVar.f981a;
        CopyOnWriteArrayList copyOnWriteArrayList4 = (CopyOnWriteArrayList) fVar.c;
        int i = c.f6927a[crashType.ordinal()];
        if (i == 1) {
            copyOnWriteArrayList3.add(iCrashCallback);
            copyOnWriteArrayList2.add(iCrashCallback);
            copyOnWriteArrayList4.add(iCrashCallback);
            copyOnWriteArrayList.add(iCrashCallback);
            return;
        }
        if (i == 2) {
            copyOnWriteArrayList.add(iCrashCallback);
            return;
        }
        if (i == 3) {
            copyOnWriteArrayList2.add(iCrashCallback);
        } else if (i == 4) {
            copyOnWriteArrayList3.add(iCrashCallback);
        } else {
            if (i != 5) {
                return;
            }
            copyOnWriteArrayList4.add(iCrashCallback);
        }
    }

    public static void d(ICrashCallback iCrashCallback, CrashType crashType) {
        M9.f fVar = f;
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) fVar.d;
        CopyOnWriteArrayList copyOnWriteArrayList2 = (CopyOnWriteArrayList) fVar.b;
        CopyOnWriteArrayList copyOnWriteArrayList3 = (CopyOnWriteArrayList) fVar.f981a;
        CopyOnWriteArrayList copyOnWriteArrayList4 = (CopyOnWriteArrayList) fVar.c;
        int i = c.f6927a[crashType.ordinal()];
        if (i == 1) {
            copyOnWriteArrayList3.remove(iCrashCallback);
            copyOnWriteArrayList2.remove(iCrashCallback);
            copyOnWriteArrayList4.remove(iCrashCallback);
            copyOnWriteArrayList.remove(iCrashCallback);
            return;
        }
        if (i == 2) {
            copyOnWriteArrayList.remove(iCrashCallback);
            return;
        }
        if (i == 3) {
            copyOnWriteArrayList2.remove(iCrashCallback);
        } else if (i == 4) {
            copyOnWriteArrayList3.remove(iCrashCallback);
        } else {
            if (i != 5) {
                return;
            }
            copyOnWriteArrayList4.remove(iCrashCallback);
        }
    }
}
