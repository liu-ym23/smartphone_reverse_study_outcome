package cm9;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Long> f24222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f24223b;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f24224a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f24225b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f24224a == r101.f24224a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f24225b, r101.f24225b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f24224a * 31;
            Long r101 = this.f24225b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Pending(routeReason=" + this.f24224a + ", expiresAtMillis=" + this.f24225b + ')';
        }

        public b(int r100) {
            this.f24224a = r100;
            this.f24225b = null;
        }
    }

    static {
    }

    public final synchronized void a() {
        monitor-enter(this);
        this.f24223b = null;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public f(int r100) {
        Function0<Long> r101 = new e();
        Intrinsics.checkNotNullParameter(r101, "nowMillis");
        this.f24222a = r101;
    }
}
