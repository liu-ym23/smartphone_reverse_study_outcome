package Xa;

import Za.C1184d;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlinx.coroutines.flow.StateFlowImpl;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0007\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n0\t2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u0004J\r\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b\u0011\u0010\u0012R(\u0010\u0018\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0014`\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"LXa/v;", "LYa/c;", "Lkotlinx/coroutines/flow/StateFlowImpl;", "<init>", "()V", "flow", "", Const.INTENT_KEY_UMID, "(Lkotlinx/coroutines/flow/StateFlowImpl;)Z", "", "Le9/c;", "LY8/t;", "f", "(Lkotlinx/coroutines/flow/StateFlowImpl;)[Le9/c;", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Z", "e", "(Le9/c;)Ljava/lang/Object;", "Ljava/util/concurrent/atomic/AtomicReference;", "", "Lkotlinx/coroutines/internal/WorkaroundAtomicReference;", Const.INTENT_KEY_APIKEY, "Ljava/util/concurrent/atomic/AtomicReference;", "_state", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class v extends Ya.c<StateFlowImpl<?>> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final AtomicReference<Object> _state = new AtomicReference<>(null);

    @Override // Ya.c
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(StateFlowImpl<?> flow) {
        if (C1184d.a(this._state) != null) {
            return false;
        }
        C1184d.b(this._state, u.f6907a);
        return true;
    }

    public final Object e(InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        kotlinx.coroutines.c cVar = new kotlinx.coroutines.c(IntrinsicsKt__IntrinsicsJvmKt.d(interfaceC4014c), 1);
        cVar.I();
        if (!this._state.compareAndSet(u.f6907a, cVar)) {
            Result.Companion companion = Result.INSTANCE;
            cVar.resumeWith(Result.b(Y8.t.f7040a));
        }
        Object objC = cVar.C();
        if (objC == C4063a.g()) {
            g9.f.c(interfaceC4014c);
        }
        return objC == C4063a.g() ? objC : Y8.t.f7040a;
    }

    @Override // Ya.c
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public InterfaceC4014c<Y8.t>[] b(StateFlowImpl<?> flow) {
        C1184d.b(this._state, null);
        return Ya.b.f7045a;
    }

    public final void g() {
        AtomicReference<Object> atomicReference = this._state;
        while (true) {
            Object objA = C1184d.a(atomicReference);
            if (objA == null || objA == u.f6908b) {
                return;
            }
            if (objA == u.f6907a) {
                if (this._state.compareAndSet(objA, u.f6908b)) {
                    return;
                }
            } else if (this._state.compareAndSet(objA, u.f6907a)) {
                ((kotlinx.coroutines.c) objA).resumeWith(Result.b(Y8.t.f7040a));
                return;
            }
        }
    }

    public final boolean h() {
        Object andSet = this._state.getAndSet(u.f6907a);
        kotlin.jvm.internal.p.f(andSet);
        return andSet == u.f6908b;
    }
}
