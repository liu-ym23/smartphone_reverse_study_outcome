package com.bytedance.android.livesdk.message.cache;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, C2363a> f153514a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C2363a f153515b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f153516c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CoroutineScope f153517d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f153518e = null;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.message.cache.a$a, reason: collision with other inner class name */
    public static final class C2363a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f153519a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f153520b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public C2363a f153521c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public C2363a f153522d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Job f153523e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C2363a) == false) goto L16;
            C2363a r101 = (C2363a) r100;
            if (Intrinsics.areEqual(this.f153519a, r101.f153519a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f153520b, r101.f153520b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f153521c, r101.f153521c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f153522d, r101.f153522d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.f153523e, r101.f153523e) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f153519a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Object r104 = this.f153520b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            C2363a r107 = this.f153521c;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            C2363a r110 = this.f153522d;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            Job r113 = this.f153523e;
            if (r113 == null) goto L22;
            r101 = r113.hashCode();
        L22:
            return r112 + r101;
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Node(key=" + this.f153519a + ", value=" + this.f153520b + ", prev=" + this.f153521c + ", next=" + this.f153522d + ", expirationJob=" + this.f153523e + ")";
        }

        public C2363a(Object r100) {
            Intrinsics.checkNotNullParameter("", "key");
            Intrinsics.checkNotNullParameter(r100, "value");
            this.f153519a = "";
            this.f153520b = r100;
            this.f153521c = null;
            this.f153522d = null;
            this.f153523e = null;
        }
    }

    public a() {
    }

    static {
        f153518e = new a();
        f153514a = new ConcurrentHashMap(10);
        C2363a r100 = new C2363a(new Object());
        f153515b = r100;
        C2363a r101 = new C2363a(new Object());
        f153516c = 60000;
        f153517d = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        r100.f153522d = r101;
        r101.f153521c = r100;
    }

    public final synchronized void a(C2363a r100) {
        monitor-enter(this);
        C2363a r101 = f153515b;     // Catch: Throwable -> L9
        r100.f153521c = r101;     // Catch: Throwable -> L9
        r100.f153522d = r101.f153522d;     // Catch: Throwable -> L9
        C2363a r102 = r101.f153522d;     // Catch: Throwable -> L9
        if (r102 == null) goto L6;
        r102.f153521c = r100;     // Catch: Throwable -> L9
    L6:
        r101.f153522d = r100;     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(C2363a r100) {
        monitor-enter(this);
        C2363a r101 = r100.f153521c;     // Catch: Throwable -> L11
        if (r101 == null) goto L6;
        r101.f153522d = r100.f153522d;     // Catch: Throwable -> L11
    L6:
        C2363a r102 = r100.f153522d;     // Catch: Throwable -> L11
        if (r102 == null) goto L9;
        r102.f153521c = r101;     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
