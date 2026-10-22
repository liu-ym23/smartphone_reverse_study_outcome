package u2;

import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: u2.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2034c {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f6693a = {AppAgent.ON_CREATE, "onStart", "onResume", "onPause"};
    public static final AtomicInteger b = new AtomicInteger(1);

    public static C2032a a(Throwable th, String str, String str2, HashSet hashSet, ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C2032a c2032a = (C2032a) it.next();
            c2032a.getClass();
            if (TextUtils.isEmpty(c2032a.e) || c2032a.e.equals(str)) {
                if (TextUtils.isEmpty(c2032a.b) || c2032a.b.equals(str2)) {
                    String message = th.getMessage();
                    if (!TextUtils.isEmpty(message) || TextUtils.isEmpty(c2032a.f)) {
                        if (TextUtils.isEmpty(message) || TextUtils.isEmpty(c2032a.f) || message.contains(c2032a.f)) {
                            if (!TextUtils.isEmpty(c2032a.g) && c2032a.g.equals(th.getClass().getName())) {
                                if (TextUtils.isEmpty(c2032a.c) && TextUtils.isEmpty(c2032a.d)) {
                                    if (Looper.myLooper() != Looper.getMainLooper()) {
                                        return c2032a;
                                    }
                                } else if (!TextUtils.isEmpty(c2032a.c) && !TextUtils.isEmpty(c2032a.d)) {
                                    if (hashSet.contains(c2032a.c + "." + c2032a.d)) {
                                        return c2032a;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public static boolean c(Throwable th, HashSet hashSet) {
        HashSet hashSet2 = new HashSet();
        while (true) {
            if (th == null) {
                break;
            }
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                hashSet2.add(stackTraceElement.getMethodName());
                hashSet.add(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName());
            }
            th = th.getCause();
        }
        for (int i = 0; i < 4; i++) {
            if (hashSet2.contains(f6693a[i])) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(java.lang.Throwable r7, java.lang.Thread r8, java.lang.String r9, java.lang.String r10) {
        /*
            r6 = this;
            r6 = 0
            java.util.concurrent.atomic.AtomicInteger r0 = u2.C2034c.b     // Catch: java.lang.Throwable -> L6d
            int r0 = r0.get()     // Catch: java.lang.Throwable -> L6d
            int r1 = z2.b.f6926a     // Catch: java.lang.Throwable -> L6d
            java.util.HashMap r1 = z2.d.c     // Catch: java.lang.Throwable -> L2a
            com.apm.insight.MonitorCrash r2 = com.apm.insight.f.b     // Catch: java.lang.Throwable -> L2a
            java.lang.String r2 = n2.c.f(r2)     // Catch: java.lang.Throwable -> L2a
            java.lang.Object r1 = r1.get(r2)     // Catch: java.lang.Throwable -> L2a
            z2.d r1 = (z2.d) r1     // Catch: java.lang.Throwable -> L2a
            org.json.JSONObject r1 = r1.f6928a     // Catch: java.lang.Throwable -> L2a
            if (r1 != 0) goto L1c
            goto L2a
        L1c:
            java.lang.String r2 = "protector_module"
            java.lang.String r3 = "max_portrait_count_per_proc"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}     // Catch: java.lang.Throwable -> L2a
            r3 = 5
            int r1 = D7.N.b(r1, r3, r2)     // Catch: java.lang.Throwable -> L2a
            goto L2b
        L2a:
            r1 = r6
        L2b:
            if (r0 <= r1) goto L2e
            goto L6d
        L2e:
            java.lang.Class<u2.c> r0 = u2.C2034c.class
            monitor-enter(r0)     // Catch: java.lang.Throwable -> L6d
            java.util.ArrayList r1 = w0.C2085f.a()     // Catch: java.lang.Throwable -> L3d
            boolean r2 = r1.isEmpty()     // Catch: java.lang.Throwable -> L3d
            if (r2 == 0) goto L3f
        L3b:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3d
            goto L6d
        L3d:
            r7 = move-exception
            goto L6b
        L3f:
            com.apm.insight.f.k()     // Catch: java.lang.Throwable -> L3d
            java.lang.String r2 = r8.getName()     // Catch: java.lang.Throwable -> L3d
            android.content.Context r3 = com.apm.insight.g.f2160a     // Catch: java.lang.Throwable -> L3d
            java.lang.String r3 = com.stepos.statsrpk.d.o()     // Catch: java.lang.Throwable -> L3d
            java.util.HashSet r4 = new java.util.HashSet     // Catch: java.lang.Throwable -> L3d
            r4.<init>()     // Catch: java.lang.Throwable -> L3d
            boolean r5 = c(r7, r4)     // Catch: java.lang.Throwable -> L3d
            if (r5 != 0) goto L58
            goto L3b
        L58:
            if (r7 == 0) goto L3b
            u2.a r5 = a(r7, r2, r3, r4, r1)     // Catch: java.lang.Throwable -> L3d
            if (r5 == 0) goto L66
            w0.C2085f.d(r7, r8, r5, r9, r10)     // Catch: java.lang.Throwable -> L3d
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3d
            r6 = 1
            return r6
        L66:
            java.lang.Throwable r7 = r7.getCause()     // Catch: java.lang.Throwable -> L3d
            goto L58
        L6b:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3d
            throw r7     // Catch: java.lang.Throwable -> L6d
        L6d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.C2034c.b(java.lang.Throwable, java.lang.Thread, java.lang.String, java.lang.String):boolean");
    }
}
