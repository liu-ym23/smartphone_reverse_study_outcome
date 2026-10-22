package android.view;

import C7.r;
import H7.h;
import J7.c;
import S7.n;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import com.stepos.taskrobot.llmapi.stepfun.InjectExperienceResult;
import java.time.Duration;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;
import s9.k;
import u9.d;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a.\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0080@¢\u0006\u0004\b\u0005\u0010\u0006\u001aY\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2(\u0010\u0010\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000bH\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001aW\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\b\u001a\u00020\u00072(\u0010\u0010\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000bH\u0007¢\u0006\u0004\b\u0011\u0010\u0015\"\u0014\u0010\u0016\u001a\u00020\t8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017*V\b\u0000\u0010\u0018\u001a\u0004\b\u0000\u0010\u0000\"$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b2$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b¨\u0006\u0019"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/MediatorLiveData;", "Landroidx/lifecycle/LiveData;", AgentBusWakeContract.EXTRA_SOURCE, "Landroidx/lifecycle/EmittedSource;", "addDisposableSource", "(Landroidx/lifecycle/MediatorLiveData;Landroidx/lifecycle/LiveData;LH7/c;)Ljava/lang/Object;", "LH7/h;", "context", "", "timeoutInMs", "Lkotlin/Function2;", "Landroidx/lifecycle/LiveDataScope;", "LH7/c;", "LC7/r;", "", "block", "liveData", "(LH7/h;JLS7/n;)Landroidx/lifecycle/LiveData;", "Ljava/time/Duration;", InjectExperienceResult.REASON_TIMEOUT, "(Ljava/time/Duration;LH7/h;LS7/n;)Landroidx/lifecycle/LiveData;", "DEFAULT_TIMEOUT", "J", "Block", "lifecycle-livedata_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CoroutineLiveDataKt {
    public static final long DEFAULT_TIMEOUT = 5000;

    @c(c = "androidx.lifecycle.CoroutineLiveDataKt$addDisposableSource$2", f = "CoroutineLiveData.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Landroidx/lifecycle/EmittedSource;", "<anonymous>", "(Lm9/z;)Landroidx/lifecycle/EmittedSource;"}, k = 3, mv = {2, 0, 0})
    /* renamed from: androidx.lifecycle.CoroutineLiveDataKt$addDisposableSource$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ LiveData<T> $source;
        final /* synthetic */ MediatorLiveData<T> $this_addDisposableSource;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(MediatorLiveData<T> mediatorLiveData, LiveData<T> liveData, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$this_addDisposableSource = mediatorLiveData;
            this.$source = liveData;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final r invokeSuspend$lambda$0(MediatorLiveData mediatorLiveData, Object obj) {
            mediatorLiveData.setValue(obj);
            return r.f317a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass2(this.$this_addDisposableSource, this.$source, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            MediatorLiveData<T> mediatorLiveData = this.$this_addDisposableSource;
            mediatorLiveData.addSource(this.$source, new CoroutineLiveDataKt$sam$androidx_lifecycle_Observer$0(new C0768c(mediatorLiveData, 0)));
            return new EmittedSource(this.$source, this.$this_addDisposableSource);
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super EmittedSource> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public static final <T> Object addDisposableSource(MediatorLiveData<T> mediatorLiveData, LiveData<T> liveData, H7.c<? super EmittedSource> cVar) {
        d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(k.f6003a.d, new AnonymousClass2(mediatorLiveData, liveData, null), cVar);
    }

    public static final <T> LiveData<T> liveData(h context, n block) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(block, "block");
        return liveData$default(context, 0L, block, 2, (Object) null);
    }

    public static /* synthetic */ LiveData liveData$default(h hVar, long j5, n nVar, int i, Object obj) {
        if ((i & 1) != 0) {
            hVar = EmptyCoroutineContext.f4908a;
        }
        if ((i & 2) != 0) {
            j5 = 5000;
        }
        return liveData(hVar, j5, nVar);
    }

    public static final <T> LiveData<T> liveData(n block) {
        kotlin.jvm.internal.k.f(block, "block");
        return liveData$default((h) null, 0L, block, 3, (Object) null);
    }

    @RequiresApi(26)
    public static final <T> LiveData<T> liveData(Duration timeout, n block) {
        kotlin.jvm.internal.k.f(timeout, "timeout");
        kotlin.jvm.internal.k.f(block, "block");
        return liveData$default(timeout, (h) null, block, 2, (Object) null);
    }

    public static /* synthetic */ LiveData liveData$default(Duration duration, h hVar, n nVar, int i, Object obj) {
        if ((i & 2) != 0) {
            hVar = EmptyCoroutineContext.f4908a;
        }
        return liveData(duration, hVar, nVar);
    }

    public static final <T> LiveData<T> liveData(h context, long j5, n block) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(block, "block");
        return new CoroutineLiveData(context, j5, block);
    }

    @RequiresApi(26)
    public static final <T> LiveData<T> liveData(Duration timeout, h context, n block) {
        kotlin.jvm.internal.k.f(timeout, "timeout");
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(block, "block");
        return new CoroutineLiveData(context, C0758Api26Impl.INSTANCE.toMillis(timeout), block);
    }
}
