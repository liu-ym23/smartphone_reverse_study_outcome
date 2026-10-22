package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: NonCancellable.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class co extends d.c.a implements ca {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final co f39209b = null;

    static {
        f39209b = new co();
    }

    @Override // kotlinx.coroutines.ca, kotlinx.coroutines.a.s
    public void a(CancellationException r1) {
    }

    @Override // kotlinx.coroutines.ca
    public boolean b() {
        return true;
    }

    @Override // kotlinx.coroutines.ca
    public ca h() {
        return null;
    }

    @Override // kotlinx.coroutines.ca
    public boolean i() {
        return false;
    }

    @Override // kotlinx.coroutines.ca
    public boolean j() {
        return false;
    }

    @Override // kotlinx.coroutines.ca
    public boolean s_() {
        return false;
    }

    public String toString() {
        return "NonCancellable";
    }

    private co() {
        super((d.c.g.c) ZeusTransformUtils.preCheckCast(ca.f39180a, d.c.g.c.class, "com.obric.aiagent.plugin"));
    }

    @Override // kotlinx.coroutines.ca
    public Object b(d.c.d<? super d.x> r2) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin");
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // kotlinx.coroutines.ca
    public CancellationException k() {
        throw new IllegalStateException("This job is always active");
    }

    @Override // kotlinx.coroutines.ca
    public bf a_(d.h.a.b<? super Throwable, d.x> r2) {
        d.h.a.b r1 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin");
        return (bf) ZeusTransformUtils.preCheckCast(cp.f39210a, bf.class, "com.obric.aiagent.plugin");
    }

    @Override // kotlinx.coroutines.ca
    public bf a(boolean r1, boolean r2, d.h.a.b<? super Throwable, d.x> r3) {
        d.h.a.b r0 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        return (bf) ZeusTransformUtils.preCheckCast(cp.f39210a, bf.class, "com.obric.aiagent.plugin");
    }

    @Override // kotlinx.coroutines.ca
    public t a(v r2) {
        v r1 = (v) ZeusTransformUtils.wrapperContextForParams(r2, v.class, "com.obric.aiagent.plugin");
        return (t) ZeusTransformUtils.preCheckCast(cp.f39210a, t.class, "com.obric.aiagent.plugin");
    }
}
