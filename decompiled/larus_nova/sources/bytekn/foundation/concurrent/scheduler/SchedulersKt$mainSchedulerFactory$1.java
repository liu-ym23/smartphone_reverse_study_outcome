package bytekn.foundation.concurrent.scheduler;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lbytekn/foundation/concurrent/scheduler/i;", AbsMethodDelegate.TAG_INVOKE, "()Lbytekn/foundation/concurrent/scheduler/i;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final /* synthetic */ class SchedulersKt$mainSchedulerFactory$1 extends FunctionReference implements Function0<i> {
    public static final SchedulersKt$mainSchedulerFactory$1 INSTANCE = null;

    static {
        INSTANCE = new SchedulersKt$mainSchedulerFactory$1();
    }

    public SchedulersKt$mainSchedulerFactory$1() {
        super(0);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "createMainScheduler";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinPackage(c.class, "kn_common_release");
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "createMainScheduler()Lbytekn/foundation/concurrent/scheduler/Scheduler;";
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ i invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final i invoke() {
        return new g();
    }
}
