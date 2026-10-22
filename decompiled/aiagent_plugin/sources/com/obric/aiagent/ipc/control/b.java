package com.obric.aiagent.ipc.control;

import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;

/* JADX INFO: compiled from: BinderControlConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18628a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f18629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f18630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f18631d;

    /* JADX INFO: compiled from: BinderControlConfig.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f18628a = new a(null);
    }

    public b() {
        this(0, 0, 0, 7, null);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
        return false;
    L8:
        b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.aiagent.plugin");
        if (this.f18629b == r10.f18629b) goto L12;
        return false;
    L12:
        if (this.f18630c == r10.f18630c) goto L15;
        return false;
    L15:
        if (this.f18631d == r10.f18631d) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Long.hashCode(this.f18629b) * 31) + Long.hashCode(this.f18630c)) * 31) + Long.hashCode(this.f18631d);
    }

    public String toString() {
        return "BinderControlConfig(waitConnectTimeLimitMs=" + this.f18629b + ", maxDiedRebindDelayMs=" + this.f18630c + ", maxFailRebindDelayMs=" + this.f18631d + ')';
    }

    public b(long r1, long r3, long r5) {
        this.f18629b = r1;
        this.f18630c = r3;
        this.f18631d = r5;
    }

    public /* synthetic */ b(long r8, long r10, long r12, int r14, h r15) {
        if ((r14 & 1) == 0) goto L5;
        r8 = 5000;
    L5:
        long r1 = r8;
        if ((r14 & 2) == 0) goto L8;
        r10 = 600000;
    L8:
        long r3 = r10;
        if ((r14 & 4) == 0) goto L11;
        r12 = OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS;
    L11:
        this(r1, r3, r12);
    }

    public final long a() {
        return this.f18629b;
    }

    public final long b() {
        return this.f18630c;
    }

    public final long c() {
        return this.f18631d;
    }
}
