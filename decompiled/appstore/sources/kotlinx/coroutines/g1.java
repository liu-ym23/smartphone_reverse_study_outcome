package kotlinx.coroutines;

import kotlin.Unit;

/* JADX INFO: loaded from: classes4.dex */
public class g1 extends JobSupport implements CompletableJob {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f21565c;

    public g1(Job r10) {
        super(true);
        H(r10);
        this.f21565c = n0();
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean B() {
        return true;
    }

    @Override // kotlinx.coroutines.CompletableJob
    public boolean complete() {
        return M(Unit.f21064a);
    }

    @Override // kotlinx.coroutines.CompletableJob
    public boolean completeExceptionally(Throwable r10) {
        return M(new w(r10, false, 2, null));
    }

    public final boolean n0() {
        ChildHandle r10 = D();
        if ((r10 instanceof s) == false) goto L5;
        s r11 = (s) r10;
    L7:
        if (r11 == null) goto L22;
        JobSupport r12 = r11.p();
        if (r12 == null) goto L22;
    L12:
        if (r12.z() == true) goto L13;
        ChildHandle r13 = r12.D();
        if ((r13 instanceof s) == false) goto L18;
        s r14 = (s) r13;
    L19:
        if (r14 == null) goto L22;
        r12 = r14.p();
        if (r12 != null) goto L12;
    L18:
        r14 = null;
        goto L19
    L13:
        return true;
    L22:
        return false;
    L5:
        r11 = null;
        goto L7
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean z() {
        return this.f21565c;
    }
}
