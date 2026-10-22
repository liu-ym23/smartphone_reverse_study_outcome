package com.bytedance.common.a;

import android.app.ActivityManager;
import android.os.Build;

/* JADX INFO: compiled from: JellyBeanV16Compat.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static C0148a f6674a;

    /* JADX INFO: renamed from: com.bytedance.common.a.a$1, reason: invalid class name */
    /* JADX INFO: compiled from: JellyBeanV16Compat.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: com.bytedance.common.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: JellyBeanV16Compat.java */
    private static class C0148a {
        public long a(ActivityManager.MemoryInfo r1) {
            return 0;
        }

        private C0148a() {
        }

        /* synthetic */ C0148a(AnonymousClass1 r1) {
            this();
        }
    }

    /* JADX INFO: compiled from: JellyBeanV16Compat.java */
    private static class b extends C0148a {
        private b() {
            super(null);
        }

        /* synthetic */ b(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.common.a.a.C0148a
        public long a(ActivityManager.MemoryInfo r1) {
            return r1.totalMem;
        }
    }

    static {
        AnonymousClass1 r1 = null;
        if (Build.VERSION.SDK_INT < 16) goto L5;
        f6674a = new b(r1);
        return;
    L5:
        f6674a = new C0148a(r1);
    }

    public static long a(ActivityManager.MemoryInfo r2) {
        return f6674a.a(r2);
    }
}
