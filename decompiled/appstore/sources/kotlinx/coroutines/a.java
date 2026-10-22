package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a extends JobSupport implements Job, Continuation, CoroutineScope {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CoroutineContext f21301c;

    public a(CoroutineContext r10, boolean r11, boolean r12) {
        super(r12);
        if (r11 == false) goto L5;
        H((Job) r10.get(Job.Key));
    L5:
        this.f21301c = r10.plus(this);
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void G(Throwable r10) {
        a0.a(this.f21301c, r10);
    }

    @Override // kotlinx.coroutines.JobSupport
    public String P() {
        String r10 = CoroutineContextKt.b(this.f21301c);
        if (r10 != null) goto L7;
        return super.P();
    L7:
        return TokenParser.DQUOTE + r10 + "\":" + super.P();
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void W(Object r10) {
        if ((r10 instanceof w) == false) goto L5;
        w r11 = (w) r10;
        o0(r11.f21768a, r11.a());
        return;
    L5:
        p0(r10);
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.f21301c;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.f21301c;
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public boolean isActive() {
        return super.isActive();
    }

    public void n0(Object r10) {
        h(r10);
    }

    public void o0(Throwable r10, boolean r11) {
    }

    @Override // kotlinx.coroutines.JobSupport
    public String p() {
        return e0.a(this) + " was cancelled";
    }

    public void p0(Object r10) {
    }

    public final void q0(CoroutineStart r10, Object r11, Function2 r12) {
        r10.invoke(r12, r11, this);
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object r10) {
        Object r11 = N(z.d(r10, null, 1, null));
        if (r11 != l1.f21639b) goto L5;
        return;
    L5:
        n0(r11);
    }
}
