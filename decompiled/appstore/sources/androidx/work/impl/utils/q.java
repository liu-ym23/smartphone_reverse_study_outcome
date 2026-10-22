package androidx.work.impl.utils;

import androidx.work.impl.c0;

/* JADX INFO: loaded from: classes.dex */
public class q implements Runnable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f5845d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f5846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.work.impl.t f5847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f5848c;

    static {
        f5845d = androidx.work.i.i("StopWorkRunnable");
    }

    public q(c0 r10, androidx.work.impl.t r11, boolean r12) {
        this.f5846a = r10;
        this.f5847b = r11;
        this.f5848c = r12;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f5848c == false) goto L5;
        boolean r10 = this.f5846a.n().p(this.f5847b);
    L6:
        androidx.work.i.e().a(f5845d, "StopWorkRunnable for " + this.f5847b.a().b() + "; Processor.stopWork = " + r10);
        return;
    L5:
        r10 = this.f5846a.n().q(this.f5847b);
        goto L6
    }
}
