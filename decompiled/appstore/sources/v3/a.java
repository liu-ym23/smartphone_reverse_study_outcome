package v3;

import android.app.ActivityManager;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f25081a;

    /* JADX INFO: renamed from: v3.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0392a {
    }

    public static class b {
        public b() {
        }

        public abstract long a(ActivityManager.MemoryInfo r10);

        public /* synthetic */ b(C0392a r10) {
            this();
        }
    }

    public static class c extends b {
        public c() {
            super(null);
        }

        @Override // v3.a.b
        public long a(ActivityManager.MemoryInfo r10) {
            return r10.totalMem;
        }

        public /* synthetic */ c(C0392a r10) {
            this();
        }
    }

    static {
        f25081a = new c(null);
    }

    public static long a(ActivityManager.MemoryInfo r10) {
        return f25081a.a(r10);
    }
}
