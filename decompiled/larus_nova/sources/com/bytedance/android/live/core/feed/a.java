package com.bytedance.android.live.core.feed;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f64794c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C1064a f64795d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f64796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f64797b;

    /* JADX INFO: renamed from: com.bytedance.android.live.core.feed.a$a, reason: collision with other inner class name */
    public static final class C1064a {
        public C1064a() {
        }

        @JvmStatic
        public final synchronized a a() {
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (a.f64794c != null) goto L6;
            a.f64794c = new a();     // Catch: Throwable -> L9
        L6:
            a r100 = a.f64794c;     // Catch: Throwable -> L9
            Intrinsics.checkNotNull(r100);     // Catch: Throwable -> L9
            monitor-exit(this);
            return r100;
        }
    }

    @JvmStatic
    public static final synchronized a a() {
        monitor-enter(a.class);
        a r100 = f64795d.a();     // Catch: Throwable -> L7
        monitor-exit(a.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    static {
        f64795d = new C1064a();
    }

    public a() {
        this.f64797b = -1;
    }

    public final boolean b(Long r100) {
        if (r100 == null) goto L8;
        r100.longValue();
        if (this.f64797b != r100.longValue()) goto L9;
        return true;
    L9:
        return false;
    L8:
        return false;
    }

    public final boolean c(Long r100) {
        if (r100 == null) goto L11;
        long r101 = r100.longValue();
        if (this.f64796a == false) goto L8;
        nn2.a r102 = nn2.a.f519628d;
        if (nn2.a.C6941a.a().b(r101) == true) goto L8;
        return true;
    L8:
        return false;
    L11:
        return this.f64796a;
    }
}
