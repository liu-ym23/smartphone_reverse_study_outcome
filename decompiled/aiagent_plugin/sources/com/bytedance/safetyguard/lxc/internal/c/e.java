package com.bytedance.safetyguard.lxc.internal.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ProxyResult.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9825a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l f9826b;

    /* JADX INFO: compiled from: ProxyResult.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f9825a = new a(null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
        if (this.f9826b == r6.f9826b) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f9826b.hashCode();
    }

    public String toString() {
        return "OpenTcpResult(resultCode=" + this.f9826b + ')';
    }

    public e(l r2) {
        d.h.b.o.e(r2, "resultCode");
        this.f9826b = r2;
    }

    public final byte[] a() {
        return o.f9861a.a(d.a.p.a(n.a.a(n.f9857a, 257, this.f9826b.a(), 0, 4, null)));
    }
}
