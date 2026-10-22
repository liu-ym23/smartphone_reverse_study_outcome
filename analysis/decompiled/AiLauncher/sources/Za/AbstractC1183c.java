package Za;

import Za.AbstractC1183c;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u00020\u0002B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\fR\u0013\u0010\u0012\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000eR\u0013\u0010\u0003\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0017\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000eR\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u0004\u0018\u00018\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0011R\u0014\u0010\u001e\u001a\u00028\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0011R\u0013\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001f8\u0002X\u0082\u0004R\u0013\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u001f8\u0002X\u0082\u0004¨\u0006\""}, d2 = {"LZa/c;", "N", "", "prev", "<init>", "(LZa/c;)V", UxipConstants.f30680s, "", "o", "(LZa/c;)Z", "LY8/t;", Const.INTENT_KEY_PKGNAME, "()V", "m", "()Z", "n", "f", "()LZa/c;", "next", "l", "isTail", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "k", "isRemoved", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/lang/Object;", "nextOrClosed", Const.INTENT_KEY_UMID, "aliveSegmentLeft", "e", "aliveSegmentRight", "LOa/e;", "_next", "_prev", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: Za.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC1183c<N extends AbstractC1183c<N>> {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f7726a = AtomicReferenceFieldUpdater.newUpdater(AbstractC1183c.class, Object.class, "_next$volatile");

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f7727b = AtomicReferenceFieldUpdater.newUpdater(AbstractC1183c.class, Object.class, "_prev$volatile");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;

    public AbstractC1183c(N n10) {
        this._prev$volatile = n10;
    }

    public final void b() {
        f7727b.set(this, null);
    }

    public final N d() {
        N n10 = (N) h();
        while (n10 != null && n10.k()) {
            n10 = (N) f7727b.get(n10);
        }
        return n10;
    }

    public final N e() {
        AbstractC1183c abstractC1183cF;
        N n10 = (N) f();
        kotlin.jvm.internal.p.f(n10);
        while (n10.k() && (abstractC1183cF = n10.f()) != null) {
            n10 = (N) abstractC1183cF;
        }
        return n10;
    }

    public final N f() {
        Object objG = g();
        if (objG == C1182b.f7725a) {
            return null;
        }
        return (N) objG;
    }

    public final Object g() {
        return f7726a.get(this);
    }

    public final N h() {
        return (N) f7727b.get(this);
    }

    public abstract boolean k();

    public final boolean l() {
        return f() == null;
    }

    public final boolean m() {
        return f7726a.compareAndSet(this, null, C1182b.f7725a);
    }

    public final void n() {
        Object obj;
        if (l()) {
            return;
        }
        while (true) {
            AbstractC1183c abstractC1183cD = d();
            AbstractC1183c abstractC1183cE = e();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7727b;
            do {
                obj = atomicReferenceFieldUpdater.get(abstractC1183cE);
            } while (!atomicReferenceFieldUpdater.compareAndSet(abstractC1183cE, obj, ((AbstractC1183c) obj) == null ? null : abstractC1183cD));
            if (abstractC1183cD != null) {
                f7726a.set(abstractC1183cD, abstractC1183cE);
            }
            if (!abstractC1183cE.k() || abstractC1183cE.l()) {
                if (abstractC1183cD == null || !abstractC1183cD.k()) {
                    return;
                }
            }
        }
    }

    public final boolean o(N value) {
        return f7726a.compareAndSet(this, null, value);
    }
}
