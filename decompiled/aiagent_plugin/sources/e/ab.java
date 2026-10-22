package e;

import com.bytedance.crash.dumper.Scraps;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Timeout.kt */
/* JADX INFO: loaded from: classes4.dex */
public class ab {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f38699c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ab f38700d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f38701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f38702b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f38703e;

    /* JADX INFO: compiled from: Timeout.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: Timeout.kt */
    public static final class b extends ab {
        @Override // e.ab
        public void x_() {
        }

        b() {
        }

        @Override // e.ab
        public ab a(long r1, TimeUnit r3) {
            d.h.b.o.e(r3, Scraps.INNER_UNIT);
            return (ab) ZeusTransformUtils.preCheckCast(this, ab.class, "com.obric.aiagent.plugin");
        }

        @Override // e.ab
        public ab a(long r1) {
            return (ab) ZeusTransformUtils.preCheckCast(this, ab.class, "com.obric.aiagent.plugin");
        }
    }

    public ab() {
    }

    public ab a(long r3, TimeUnit r5) {
        d.h.b.o.e(r5, Scraps.INNER_UNIT);
        if (r3 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        this.f38703e = r5.toNanos(r3);
        return this;
    L10:
        throw new IllegalArgumentException(("timeout < 0: " + r3).toString());
    L5:
        r0 = false;
        goto L6
    }

    public long y_() {
        return this.f38703e;
    }

    public boolean u_() {
        return this.f38701a;
    }

    public long d() {
        if (this.f38701a == false) goto L7;
        return this.f38702b;
    L7:
        throw new IllegalStateException("No deadline".toString());
    }

    public ab a(long r2) {
        this.f38701a = true;
        this.f38702b = r2;
        return this;
    }

    public ab v_() {
        this.f38703e = 0;
        return this;
    }

    public ab w_() {
        this.f38701a = false;
        return this;
    }

    public void x_() {
        if (Thread.currentThread().isInterrupted() == true) goto L13;
        if (this.f38701a == true) goto L7;
        return;
    L7:
        if ((this.f38702b - System.nanoTime()) <= 0) goto L10;
        return;
    L10:
        throw new InterruptedIOException("deadline reached");
    L13:
        throw new InterruptedIOException("interrupted");
    }

    static {
        f38699c = new a(null);
        f38700d = (ab) ZeusTransformUtils.preCheckCast(new b(), ab.class, "com.obric.aiagent.plugin");
    }
}
