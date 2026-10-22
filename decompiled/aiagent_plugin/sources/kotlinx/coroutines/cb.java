package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class cb extends CancellationException implements ag<cb> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient ca f39182a;

    @Override // kotlinx.coroutines.ag
    public /* synthetic */ Throwable a() {
        return (Throwable) ZeusTransformUtils.preCheckCast(b(), Throwable.class, "com.obric.aiagent.plugin");
    }

    public cb(String r3, Throwable r4, ca r5) {
        ca r6 = (ca) ZeusTransformUtils.wrapperContextForParams(r5, ca.class, "com.obric.aiagent.plugin");
        super(r3);
        this.f39182a = r6;
        if (r4 == null) goto L6;
        initCause(r4);
        return;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        if (aq.b() == true) goto L5;
        setStackTrace(new StackTraceElement[0]);
        return (Throwable) ZeusTransformUtils.preCheckCast(this, Throwable.class, "com.obric.aiagent.plugin");
    L5:
        return super.fillInStackTrace();
    }

    public cb b() {
        if (aq.b() == false) goto L6;
        String r1 = getMessage();
        d.h.b.o.a(r1);
        return new cb(r1, (Throwable) ZeusTransformUtils.preCheckCast(this, Throwable.class, "com.obric.aiagent.plugin"), this.f39182a);
    L6:
        return null;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + "; job=" + this.f39182a;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L5;
    L14:
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r5, cb.class) == true) goto L7;
    L13:
        return false;
    L7:
        if (d.h.b.o.a(((cb) ZeusTransformUtils.preCheckCast(r5, cb.class, "com.obric.aiagent.plugin")).getMessage(), getMessage()) == false) goto L13;
        if (d.h.b.o.a(((cb) ZeusTransformUtils.preCheckCast(r5, cb.class, "com.obric.aiagent.plugin")).f39182a, this.f39182a) == false) goto L13;
        if (d.h.b.o.a(((cb) ZeusTransformUtils.preCheckCast(r5, cb.class, "com.obric.aiagent.plugin")).getCause(), getCause()) == false) goto L13;
        goto L13
    }

    public int hashCode() {
        String r0 = getMessage();
        d.h.b.o.a(r0);
        int r1 = ((r0.hashCode() * 31) + this.f39182a.hashCode()) * 31;
        Throwable r2 = getCause();
        if (r2 == null) goto L5;
        int r3 = r2.hashCode();
    L7:
        return r1 + r3;
    L5:
        r3 = 0;
        goto L7
    }
}
