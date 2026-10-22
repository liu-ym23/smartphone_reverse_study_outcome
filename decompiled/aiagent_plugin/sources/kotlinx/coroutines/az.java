package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: Builders.common.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class az<T> extends kotlinx.coroutines.internal.ah<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f38865b = null;
    private volatile /* synthetic */ int _decision$volatile;

    static {
        f38865b = AtomicIntegerFieldUpdater.newUpdater(az.class, "_decision$volatile");
    }

    public static final /* synthetic */ AtomicIntegerFieldUpdater g() {
        return f38865b;
    }

    public az(d.c.g r3, d.c.d<? super T> r4) {
        super((d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    private final boolean t() {
        AtomicIntegerFieldUpdater r0 = g();
    L3:
        int r1 = r0.get(this);
        if (r1 != 0) goto L6;
        if (g().compareAndSet(this, 0, 1) == false) goto L3;
        return true;
    L6:
        if (r1 != 2) goto L9;
        return false;
    L9:
        throw new IllegalStateException("Already suspended".toString());
    }

    private final boolean u() {
        AtomicIntegerFieldUpdater r0 = g();
    L3:
        int r1 = r0.get(this);
        if (r1 != 0) goto L5;
        if (g().compareAndSet(this, 0, 2) == false) goto L3;
        return true;
    L5:
        if (r1 != 1) goto L8;
        return false;
    L8:
        throw new IllegalStateException("Already resumed".toString());
    }

    @Override // kotlinx.coroutines.internal.ah, kotlinx.coroutines.ci
    public void d(Object r1) {
        c(r1);
    }

    @Override // kotlinx.coroutines.internal.ah, kotlinx.coroutines.a
    public void c(Object r3) {
        if (u() == false) goto L5;
        return;
    L5:
        kotlinx.coroutines.internal.n.a(d.c.a.b.a(this.f39362c), ae.a(r3, this.f39362c), null, 2, null);
    }

    public final Object f() {
        if (t() == true) goto L5;
        Object r2 = cj.b(n());
        if (ZeusTransformUtils.instanceOf(r2, ab.class) == true) goto L10;
        return r2;
    L10:
        throw ((ab) ZeusTransformUtils.preCheckCast(r2, ab.class, "com.obric.aiagent.plugin")).f38830a;
    L5:
        return d.c.a.b.a();
    }
}
