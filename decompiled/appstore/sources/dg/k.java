package dg;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.m;

/* JADX INFO: loaded from: classes4.dex */
public final class k extends CoroutineDispatcher {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k f19219c = null;

    static {
        f19219c = new k();
    }

    public k() {
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void a(CoroutineContext r10, Runnable r11) {
        b.f19200i.f(r11, j.f19218h, false);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void b(CoroutineContext r10, Runnable r11) {
        b.f19200i.f(r11, j.f19218h, true);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public CoroutineDispatcher d(int r10) {
        m.a(r10);
        if (r10 < j.f19214d) goto L6;
        return this;
    L6:
        return super.d(r10);
    }
}
