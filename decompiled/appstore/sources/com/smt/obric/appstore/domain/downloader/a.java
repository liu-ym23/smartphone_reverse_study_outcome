package com.smt.obric.appstore.domain.downloader;

import com.bytedance.apm.constant.PerfConsts;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0218a f18050c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f18051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue f18052b;

    /* JADX INFO: renamed from: com.smt.obric.appstore.domain.downloader.a$a, reason: collision with other inner class name */
    public static final class C0218a {
        public /* synthetic */ C0218a(DefaultConstructorMarker r10) {
            this();
        }

        public C0218a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f18053a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f18054b;

        public b(long r10, int r11) {
            this.f18053a = r10;
            this.f18054b = r11;
        }

        public final long a() {
            return this.f18053a;
        }

        public final int b() {
            return this.f18054b;
        }

        public final void c(long r10) {
            this.f18053a = r10;
        }

        public final void d(int r10) {
            this.f18054b = r10;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (this.f18053a == r11.f18053a) goto L12;
            return false;
        L12:
            if (this.f18054b == r11.f18054b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Long.hashCode(this.f18053a) * 31) + Integer.hashCode(this.f18054b);
        }

        public String toString() {
            return "LogMetadata(lastLogTime=" + this.f18053a + ", skippedCount=" + this.f18054b + ')';
        }
    }

    static {
        f18050c = new C0218a(null);
    }

    public a() {
        this.f18051a = new ConcurrentHashMap();
        this.f18052b = new ConcurrentLinkedQueue();
    }

    public final void a() {
        if (this.f18051a.size() > 100) goto L5;
        return;
    L5:
        int r10 = this.f18051a.size() - 90;
        Iterator r11 = this.f18052b.iterator();
        q.f(r11, "iterator(...)");
        int r12 = 0;
    L7:
        if (r11.hasNext() == false) goto L12;
        if (r12 >= r10) goto L19;
        if (this.f18051a.remove((String) r11.next()) == null) goto L7;
        r11.remove();
        r12 = r12 + 1;
        goto L7
    L19:
        return;
    }

    public final int b(String r10) {
        q.g(r10, "logKey");
        b r11 = (b) this.f18051a.get(r10);
        if (r11 != null) goto L7;
        return 0;
    L7:
        return r11.b();
    }

    public final void c(String r10) {
        q.g(r10, "logKey");
        b r11 = (b) this.f18051a.get(r10);
        if (r11 == null) goto L7;
        r11.d(0);
        return;
    }

    public final boolean d(String r10, boolean r11) {
        q.g(r10, "logKey");
        if (r11 == true) goto L5;
        return true;
    L5:
        long r12 = System.currentTimeMillis();
        b r13 = (b) this.f18051a.get(r10);
        if (r13 != null) goto L8;
    L11:
        if (r13 != null) goto L13;
        this.f18052b.offer(r10);
        this.f18051a.put(r10, new b(r12, 0));
    L14:
        a();
        return true;
    L13:
        r13.c(r12);
        goto L14
    L8:
        if ((r12 - r13.a()) >= PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS) goto L11;
        r13.d(r13.b() + 1);
        return false;
    }
}
