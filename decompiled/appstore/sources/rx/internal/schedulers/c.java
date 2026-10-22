package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes4.dex */
public final class c extends jg.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadFactory f24339a;

    public c(ThreadFactory r10) {
        this.f24339a = r10;
    }

    @Override // jg.a
    public jg.a.AbstractC0284a createWorker() {
        return new d(this.f24339a);
    }
}
