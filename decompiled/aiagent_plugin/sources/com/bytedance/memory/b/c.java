package com.bytedance.memory.b;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: MemoryLog.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f8772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f8773b;

    /* JADX INFO: compiled from: MemoryLog.java */
    private static class a implements b {
        a() {
        }

        @Override // com.bytedance.memory.b.c.b
        public void a(String r3, Object... r4) {
            if (e.f8775a == false) goto L5;
        L7:
            String r2 = String.format(r3, r4);
            if (r2.length() >= 4000) goto L10;
            a("memory", r2);
            return;
        L10:
            String[] r5 = r2.split("\n", -1);
            int r6 = r5.length;
            int r7 = 0;
        L11:
            if (r7 >= r6) goto L15;
            a("memory", r5[r7]);
            r7 = r7 + 1;
            goto L11
        L15:
            return;
        L5:
            if (c.a() == true) goto L7;
        }

        @Override // com.bytedance.memory.b.c.b
        public void a(Throwable r2, String r3, Object... r4) {
            a(String.format(r3, r4) + '\n' + Log.getStackTraceString(r2), new Object[0]);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.d(r1, r2);
        }
    }

    /* JADX INFO: compiled from: MemoryLog.java */
    public interface b {
        void a(String r1, Object... r2);

        void a(Throwable r1, String r2, Object... r3);
    }

    static /* synthetic */ boolean a() {
        return f8773b;
    }

    static {
        f8772a = new a();
    }

    public static void a(String r1, Object... r2) {
        b r0 = f8772a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(r1, r2);
    }

    public static void a(Throwable r1, String r2, Object... r3) {
        b r0 = f8772a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(r1, r2, r3);
    }
}
