package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "R", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ CoroutineDispatcher $lifecycleDispatcher;
    final /* synthetic */ q0 $observer;
    final /* synthetic */ Lifecycle $this_suspendWithStateAtLeastUnchecked;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Lifecycle f3494a;

        public a(Lifecycle r10, q0 r11) {
            this.f3494a = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f3494a.d(null);
        }
    }

    public WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2(CoroutineDispatcher r10, Lifecycle r11, q0 r12) {
        this.$lifecycleDispatcher = r10;
        this.$this_suspendWithStateAtLeastUnchecked = r11;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable r10) {
        invoke2(r10);
        return Unit.f21064a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable Throwable r10) {
        CoroutineDispatcher r11 = this.$lifecycleDispatcher;
        EmptyCoroutineContext r12 = EmptyCoroutineContext.INSTANCE;
        if (r11.c(r12) == false) goto L5;
        this.$lifecycleDispatcher.a(r12, new a(this.$this_suspendWithStateAtLeastUnchecked, null));
        return;
    L5:
        this.$this_suspendWithStateAtLeastUnchecked.d(null);
    }
}
