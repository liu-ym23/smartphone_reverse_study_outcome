package androidx.compose.ui.platform;

import C7.r;
import android.view.Choreographer;
import androidx.compose.runtime.MonotonicFrameClock;
import androidx.compose.runtime.internal.StabilityInferred;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import m9.C1718k;
import m9.InterfaceC1717j;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\bJ*\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00000\nH\u0096@¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/platform/AndroidUiFrameClock;", "Landroidx/compose/runtime/MonotonicFrameClock;", "Landroid/view/Choreographer;", "choreographer", "Landroidx/compose/ui/platform/AndroidUiDispatcher;", "dispatcher", AppAgent.CONSTRUCT, "(Landroid/view/Choreographer;Landroidx/compose/ui/platform/AndroidUiDispatcher;)V", "(Landroid/view/Choreographer;)V", "R", "Lkotlin/Function1;", "", "onFrame", "withFrameNanos", "(LS7/k;LH7/c;)Ljava/lang/Object;", "Landroid/view/Choreographer;", "getChoreographer", "()Landroid/view/Choreographer;", "Landroidx/compose/ui/platform/AndroidUiDispatcher;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidUiFrameClock implements MonotonicFrameClock {
    public static final int $stable = 8;
    private final Choreographer choreographer;
    private final AndroidUiDispatcher dispatcher;

    public AndroidUiFrameClock(Choreographer choreographer, AndroidUiDispatcher androidUiDispatcher) {
        this.choreographer = choreographer;
        this.dispatcher = androidUiDispatcher;
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock, H7.h
    public <R> R fold(R r5, S7.n nVar) {
        return (R) MonotonicFrameClock.DefaultImpls.fold(this, r5, nVar);
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock, H7.h
    public <E extends H7.f> E get(H7.g gVar) {
        return (E) MonotonicFrameClock.DefaultImpls.get(this, gVar);
    }

    public final Choreographer getChoreographer() {
        return this.choreographer;
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock, H7.h
    public H7.h minusKey(H7.g gVar) {
        return MonotonicFrameClock.DefaultImpls.minusKey(this, gVar);
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock, H7.h
    public H7.h plus(H7.h hVar) {
        return MonotonicFrameClock.DefaultImpls.plus(this, hVar);
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock
    public <R> Object withFrameNanos(final S7.k kVar, H7.c<? super R> cVar) {
        final AndroidUiDispatcher androidUiDispatcher = this.dispatcher;
        if (androidUiDispatcher == null) {
            H7.f fVar = cVar.getContext().get(H7.d.f758a);
            androidUiDispatcher = fVar instanceof AndroidUiDispatcher ? (AndroidUiDispatcher) fVar : null;
        }
        final C1718k c1718k = new C1718k(1, U7.a.I(cVar));
        c1718k.y();
        final Choreographer.FrameCallback frameCallback = new Choreographer.FrameCallback() { // from class: androidx.compose.ui.platform.AndroidUiFrameClock$withFrameNanos$2$callback$1
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j5) {
                Object objA;
                InterfaceC1717j interfaceC1717j = c1718k;
                try {
                    objA = kVar.invoke(Long.valueOf(j5));
                } catch (Throwable th) {
                    objA = kotlin.b.a(th);
                }
                interfaceC1717j.resumeWith(objA);
            }
        };
        if (androidUiDispatcher == null || !kotlin.jvm.internal.k.b(androidUiDispatcher.getChoreographer(), getChoreographer())) {
            getChoreographer().postFrameCallback(frameCallback);
            c1718k.j(new S7.k() { // from class: androidx.compose.ui.platform.AndroidUiFrameClock$withFrameNanos$2$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Throwable) obj);
                    return r.f317a;
                }

                public final void invoke(Throwable th) {
                    this.this$0.getChoreographer().removeFrameCallback(frameCallback);
                }
            });
        } else {
            androidUiDispatcher.postFrameCallback$ui_release(frameCallback);
            c1718k.j(new S7.k() { // from class: androidx.compose.ui.platform.AndroidUiFrameClock$withFrameNanos$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Throwable) obj);
                    return r.f317a;
                }

                public final void invoke(Throwable th) {
                    androidUiDispatcher.removeFrameCallback$ui_release(frameCallback);
                }
            });
        }
        Object objX = c1718k.x();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        return objX;
    }

    public AndroidUiFrameClock(Choreographer choreographer) {
        this(choreographer, null);
    }
}
