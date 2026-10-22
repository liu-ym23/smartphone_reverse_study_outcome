package com.bumptech.glide.load.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Queue;

/* JADX INFO: compiled from: ModelCache.java */
/* JADX INFO: loaded from: classes.dex */
public class m<A, B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.f.g<a<A>, B> f3460a;

    /* JADX INFO: compiled from: ModelCache.java */
    static final class a<A> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Queue<a<?>> f3462a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f3463b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f3464c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private A f3465d;

        static {
            f3462a = com.bumptech.glide.f.k.a(0);
        }

        static <A> a<A> a(A r4, int r5, int r6) {
            Queue<a<?>> r0 = f3462a;
            monitor-enter(r0);
            a<A> r1 = (a) ZeusTransformUtils.preCheckCast(r0.poll(), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            if (r1 != null) goto L8;
            r1 = new a();
        L8:
            r1.b(r4, r5, r6);
            return r1;
        L10:
            th = move-exception;
            throw th;
        }

        private a() {
        }

        private void b(A r1, int r2, int r3) {
            this.f3465d = r1;
            this.f3464c = r2;
            this.f3463b = r3;
        }

        public void a() {
            Queue<a<?>> r0 = f3462a;
            monitor-enter(r0);
            r0.offer(this);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, a.class) == false) goto L12;
            a r5 = (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin");
            if (this.f3464c == r5.f3464c) goto L7;
            return false;
        L7:
            if (this.f3463b == r5.f3463b) goto L9;
            return false;
        L9:
            if (this.f3465d.equals(r5.f3465d) == false) goto L15;
            return true;
        L15:
            return false;
        L12:
            return false;
        }

        public int hashCode() {
            return (((this.f3463b * 31) + this.f3464c) * 31) + this.f3465d.hashCode();
        }
    }

    public m() {
        this(250);
    }

    public m(final long r2) {
        this.f3460a = new AnonymousClass1(this, r2);
    }

    public B a(A r1, int r2, int r3) {
        a<A> r4 = a.a(r1, r2, r3);
        B r0 = this.f3460a.b(r4);
        r4.a();
        return r0;
    }

    public void a(A r1, int r2, int r3, B r4) {
        a<A> r5 = a.a(r1, r2, r3);
        this.f3460a.b(r5, r4);
    }
}
