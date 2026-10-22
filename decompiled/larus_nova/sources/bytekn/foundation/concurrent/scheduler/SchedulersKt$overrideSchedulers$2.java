package bytekn.foundation.concurrent.scheduler;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lbytekn/foundation/concurrent/scheduler/i;", AbsMethodDelegate.TAG_INVOKE, "()Lbytekn/foundation/concurrent/scheduler/i;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final /* synthetic */ class SchedulersKt$overrideSchedulers$2 extends FunctionReference implements Function0<i> {
    public static final SchedulersKt$overrideSchedulers$2 INSTANCE = null;

    static {
        INSTANCE = new SchedulersKt$overrideSchedulers$2();
    }

    public SchedulersKt$overrideSchedulers$2() {
        super(0);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "createIoScheduler";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinPackage(b.class, "kn_common_release");
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "createIoScheduler()Lbytekn/foundation/concurrent/scheduler/Scheduler;";
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ i invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final i invoke() {
        TimeUnit.MINUTES.toMillis(1);
        return new e(new a(new ThreadFactoryImpl()));
    }
}
