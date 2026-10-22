package com.obric.autogui.session.b;

import d.h.b.h;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: CCBizLifecycleHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f30774a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f30775b;

    /* JADX INFO: compiled from: CCBizLifecycleHandler.kt */
    private static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f30774a = new a(null);
    }

    public d() {
        this.f30775b = new AtomicBoolean(false);
    }

    public final c a(boolean r1, Integer r2, boolean r3, boolean r4, boolean r5) {
        if (r1 == false) goto L24;
        if (r2 == null) goto L24;
        if (r2.intValue() == 1) goto L8;
        if (r3 == false) goto L11;
        if (r4 == false) goto L14;
        if (r5 == false) goto L19;
        return c.f30773e;
    L19:
        if (this.f30775b.compareAndSet(false, true) == false) goto L22;
        return c.g;
    L22:
        return c.f;
    L14:
        return c.f30772d;
    L11:
        return c.f30771c;
    L8:
        return c.f30770b;
    L24:
        return c.f30769a;
    }
}
