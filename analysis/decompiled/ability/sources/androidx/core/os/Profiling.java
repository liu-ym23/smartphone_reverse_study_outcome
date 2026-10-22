package androidx.core.os;

import C7.r;
import S7.n;
import android.content.Context;
import android.os.ProfilingManager;
import android.os.ProfilingResult;
import androidx.annotation.RequiresApi;
import androidx.core.os.Profiling;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import kotlinx.coroutines.flow.d;
import o9.C1785k;
import o9.InterfaceC1786l;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a-\u0010\u0004\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u0007¢\u0006\u0004\b\u0004\u0010\u000b\u001a%\u0010\f\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u0007¢\u0006\u0004\b\f\u0010\r\u001a9\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\"\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014\"\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014\"\u0014\u0010\u0016\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014\"\u0014\u0010\u0017\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0014\"\u0014\u0010\u0018\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0014\"\u0014\u0010\u0019\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0014\"\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c\"\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001c¨\u0006\u001e"}, d2 = {"Landroid/content/Context;", "context", "Lp9/c;", "Landroid/os/ProfilingResult;", "registerForAllProfilingResults", "(Landroid/content/Context;)Lp9/c;", "Ljava/util/concurrent/Executor;", "executor", "Ljava/util/function/Consumer;", "listener", "LC7/r;", "(Landroid/content/Context;Ljava/util/concurrent/Executor;Ljava/util/function/Consumer;)V", "unregisterForAllProfilingResults", "(Landroid/content/Context;Ljava/util/function/Consumer;)V", "Landroidx/core/os/ProfilingRequest;", "profilingRequest", "requestProfiling", "(Landroid/content/Context;Landroidx/core/os/ProfilingRequest;Ljava/util/concurrent/Executor;Ljava/util/function/Consumer;)V", "", Profiling.KEY_DURATION_MS, "Ljava/lang/String;", Profiling.KEY_SAMPLING_INTERVAL_BYTES, Profiling.KEY_TRACK_JAVA_ALLOCATIONS, Profiling.KEY_FREQUENCY_HZ, Profiling.KEY_SIZE_KB, Profiling.KEY_BUFFER_FILL_POLICY, "", "VALUE_BUFFER_FILL_POLICY_DISCARD", "I", "VALUE_BUFFER_FILL_POLICY_RING_BUFFER", "core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Profiling {
    private static final String KEY_BUFFER_FILL_POLICY = "KEY_BUFFER_FILL_POLICY";
    private static final String KEY_DURATION_MS = "KEY_DURATION_MS";
    private static final String KEY_FREQUENCY_HZ = "KEY_FREQUENCY_HZ";
    private static final String KEY_SAMPLING_INTERVAL_BYTES = "KEY_SAMPLING_INTERVAL_BYTES";
    private static final String KEY_SIZE_KB = "KEY_SIZE_KB";
    private static final String KEY_TRACK_JAVA_ALLOCATIONS = "KEY_TRACK_JAVA_ALLOCATIONS";
    private static final int VALUE_BUFFER_FILL_POLICY_DISCARD = 1;
    private static final int VALUE_BUFFER_FILL_POLICY_RING_BUFFER = 2;

    @J7.c(c = "androidx.core.os.Profiling$registerForAllProfilingResults$1", f = "Profiling.kt", l = {79}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lo9/l;", "Landroid/os/ProfilingResult;", "LC7/r;", "<anonymous>", "(Lo9/l;)V"}, k = 3, mv = {2, 0, 0})
    /* renamed from: androidx.core.os.Profiling$registerForAllProfilingResults$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        final /* synthetic */ Context $context;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$context = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(InterfaceC1786l interfaceC1786l, ProfilingResult profilingResult) {
            k.c(profilingResult);
            ((C1785k) interfaceC1786l).a(profilingResult);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final r invokeSuspend$lambda$2(ProfilingManager profilingManager, Consumer consumer) {
            profilingManager.unregisterForAllProfilingResults(consumer);
            return r.f317a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$context, cVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [androidx.core.os.a] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                final InterfaceC1786l interfaceC1786l = (InterfaceC1786l) this.L$0;
                final ?? r1 = new Consumer() { // from class: androidx.core.os.a
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj2) {
                        Profiling.AnonymousClass1.invokeSuspend$lambda$0(interfaceC1786l, (ProfilingResult) obj2);
                    }
                };
                final ProfilingManager profilingManagerA = androidx.compose.ui.text.android.b.a(this.$context.getSystemService(androidx.compose.ui.text.android.b.b()));
                profilingManagerA.registerForAllProfilingResults(new b(), r1);
                S7.a aVar = new S7.a() { // from class: androidx.core.os.c
                    @Override // S7.a
                    public final Object invoke() {
                        return Profiling.AnonymousClass1.invokeSuspend$lambda$2(profilingManagerA, r1);
                    }
                };
                this.label = 1;
                if (kotlinx.coroutines.channels.b.a(interfaceC1786l, aVar, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1786l interfaceC1786l, H7.c<? super r> cVar) {
            return ((AnonymousClass1) create(interfaceC1786l, cVar)).invokeSuspend(r.f317a);
        }
    }

    @RequiresApi(api = 35)
    public static final p9.c registerForAllProfilingResults(Context context) {
        k.f(context, "context");
        return d.c(new AnonymousClass1(context, null));
    }

    @RequiresApi(api = 35)
    public static final void requestProfiling(Context context, ProfilingRequest profilingRequest, Executor executor, Consumer<ProfilingResult> consumer) {
        k.f(context, "context");
        k.f(profilingRequest, "profilingRequest");
        androidx.compose.ui.text.android.b.a(context.getSystemService(androidx.compose.ui.text.android.b.b())).requestProfiling(profilingRequest.getProfilingType(), profilingRequest.getParams(), profilingRequest.getTag(), profilingRequest.getCancellationSignal(), executor, consumer);
    }

    @RequiresApi(api = 35)
    public static final void unregisterForAllProfilingResults(Context context, Consumer<ProfilingResult> listener) {
        k.f(context, "context");
        k.f(listener, "listener");
        androidx.compose.ui.text.android.b.a(context.getSystemService(androidx.compose.ui.text.android.b.b())).unregisterForAllProfilingResults(listener);
    }

    @RequiresApi(api = 35)
    public static final void registerForAllProfilingResults(Context context, Executor executor, Consumer<ProfilingResult> listener) {
        k.f(context, "context");
        k.f(executor, "executor");
        k.f(listener, "listener");
        androidx.compose.ui.text.android.b.a(context.getSystemService(androidx.compose.ui.text.android.b.b())).registerForAllProfilingResults(executor, listener);
    }
}
