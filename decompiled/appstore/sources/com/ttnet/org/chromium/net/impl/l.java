package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.InlineExecutionProhibitedException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes4.dex */
public final class l implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f18880a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f18881a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Thread f18882b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public InlineExecutionProhibitedException f18883c;

        public /* synthetic */ a(Runnable r10, Thread r11, k r12) {
            this(r10, r11);
        }

        public static /* synthetic */ InlineExecutionProhibitedException a(a r10) {
            return r10.f18883c;
        }

        public static /* synthetic */ Thread b(a r10, Thread r11) {
            r10.f18882b = r11;
            return r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Thread.currentThread() != this.f18882b) goto L6;
            this.f18883c = new InlineExecutionProhibitedException();
            return;
        L6:
            this.f18881a.run();
        }

        public a(Runnable r10, Thread r11) {
            this.f18881a = r10;
            this.f18882b = r11;
        }
    }

    public l(Executor r10) {
        this.f18880a = r10;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r10) {
        a r11 = new a(r10, Thread.currentThread(), null);
        this.f18880a.execute(r11);
        if (a.a(r11) != null) goto L7;
        a.b(r11, null);
        return;
    L7:
        throw a.a(r11);
    }
}
