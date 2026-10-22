package com.bytedance.bdtracker;

import com.stepos.pps.data.util.Constants;

/* loaded from: classes.dex */
public abstract class c0 {
    public int a;
    public volatile boolean b;
    public long c;
    public volatile boolean d;
    public final e0 e;
    public final d f;

    public c0(e0 e0Var) {
        this.e = e0Var;
        this.f = e0Var.d;
    }

    public final long a() {
        String str;
        str = "failed";
        long jB = b();
        if (jB > System.currentTimeMillis()) {
            return jB;
        }
        this.e.d.D.debug("The worker:{} start to work...", d());
        try {
            boolean zC = c();
            this.c = System.currentTimeMillis();
            this.a = zC ? 0 : this.a + 1;
            this.e.d.D.debug("The worker:{} worked:{}.", d(), zC ? "success" : "failed");
        } catch (Throwable th) {
            try {
                this.e.d.D.error("Work do failed.", th, new Object[0]);
            } finally {
                this.c = System.currentTimeMillis();
                this.a++;
                this.e.d.D.debug("The worker:{} worked:{}.", d(), "failed");
            }
        }
        return b();
    }

    public final long b() {
        long jH;
        long jCurrentTimeMillis;
        if (!g() || j5.b(this.e.b(), this.e.n.a()).a()) {
            if (this.b) {
                jH = 0;
                this.c = 0L;
                this.b = false;
            } else {
                int i = this.a;
                if (i > 0) {
                    long[] jArrE = e();
                    jH = jArrE[(i - 1) % jArrE.length];
                } else {
                    jH = h();
                }
            }
            jCurrentTimeMillis = this.c;
        } else {
            this.e.d.D.debug("Check work time is not net available.", new Object[0]);
            jCurrentTimeMillis = System.currentTimeMillis();
            jH = Constants.IPC_TIMEOUT;
        }
        return jCurrentTimeMillis + jH;
    }

    public abstract boolean c();

    public abstract String d();

    public abstract long[] e();

    public boolean f() {
        return this.d;
    }

    public abstract boolean g();

    public abstract long h();

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends c0> T i() {
        this.b = true;
        return this;
    }

    public void setStop(boolean z) {
        this.d = z;
    }
}
