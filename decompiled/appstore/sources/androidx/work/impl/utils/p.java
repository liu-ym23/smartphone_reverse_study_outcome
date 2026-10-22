package androidx.work.impl.utils;

import androidx.work.WorkerParameters;
import androidx.work.impl.c0;

/* JADX INFO: loaded from: classes.dex */
public class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c0 f5842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public androidx.work.impl.t f5843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WorkerParameters.a f5844c;

    public p(c0 r10, androidx.work.impl.t r11, WorkerParameters.a r12) {
        this.f5842a = r10;
        this.f5843b = r11;
        this.f5844c = r12;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5842a.n().m(this.f5843b, this.f5844c);
    }
}
