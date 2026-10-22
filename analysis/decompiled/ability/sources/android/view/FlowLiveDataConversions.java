package android.view;

import C7.r;
import H7.h;
import J7.c;
import S7.n;
import android.view.FlowLiveDataConversions;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.RoomLambdaTrackingLiveData;
import com.stepos.taskrobot.llmapi.stepfun.InjectExperienceResult;
import java.time.Duration;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.a;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;
import m9.m0;
import n9.C1748d;
import o9.C1785k;
import o9.InterfaceC1786l;
import p9.t;
import s9.k;
import u9.d;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\t\u0010\n\u001a7\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\r¨\u0006\u000e"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lp9/c;", "LH7/h;", "context", "", "timeoutInMs", "Landroidx/lifecycle/LiveData;", "asLiveData", "(Lp9/c;LH7/h;J)Landroidx/lifecycle/LiveData;", "asFlow", "(Landroidx/lifecycle/LiveData;)Lp9/c;", "Ljava/time/Duration;", InjectExperienceResult.REASON_TIMEOUT, "(Lp9/c;Ljava/time/Duration;LH7/h;)Landroidx/lifecycle/LiveData;", "lifecycle-livedata_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FlowLiveDataConversions {

    @c(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1", f = "FlowLiveData.kt", l = {105, 106, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lo9/l;", "LC7/r;", "<anonymous>", "(Lo9/l;)V"}, k = 3, mv = {2, 0, 0})
    /* renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        final /* synthetic */ LiveData<T> $this_asFlow;
        private /* synthetic */ Object L$0;
        int label;

        @c(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1", f = "FlowLiveData.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 0, 0})
        /* renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01221 extends SuspendLambda implements n {
            final /* synthetic */ Observer<T> $observer;
            final /* synthetic */ LiveData<T> $this_asFlow;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01221(LiveData<T> liveData, Observer<T> observer, H7.c<? super C01221> cVar) {
                super(2, cVar);
                this.$this_asFlow = liveData;
                this.$observer = observer;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                return new C01221(this.$this_asFlow, this.$observer, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
                this.$this_asFlow.observeForever(this.$observer);
                return r.f317a;
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                return ((C01221) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        @c(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2", f = "FlowLiveData.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 0, 0})
        /* renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends SuspendLambda implements n {
            final /* synthetic */ Observer<T> $observer;
            final /* synthetic */ LiveData<T> $this_asFlow;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(LiveData<T> liveData, Observer<T> observer, H7.c<? super AnonymousClass2> cVar) {
                super(2, cVar);
                this.$this_asFlow = liveData;
                this.$observer = observer;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                return new AnonymousClass2(this.$this_asFlow, this.$observer, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
                this.$this_asFlow.removeObserver(this.$observer);
                return r.f317a;
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(LiveData<T> liveData, H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$this_asFlow = liveData;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(InterfaceC1786l interfaceC1786l, Object obj) {
            ((C1785k) interfaceC1786l).a(obj);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_asFlow, cVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [androidx.lifecycle.Observer, int] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Observer observer;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            ?? r1 = this.label;
            try {
            } catch (Throwable th) {
                d dVar = AbstractC1691I.f5315a;
                h hVarPlus = k.f6003a.d.plus(m0.f5330a);
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_asFlow, r1, null);
                this.L$0 = th;
                this.label = 3;
                if (AbstractC1683A.w(hVarPlus, anonymousClass2, this) != coroutineSingletons) {
                    throw th;
                }
            }
            if (r1 == 0) {
                b.b(obj);
                final InterfaceC1786l interfaceC1786l = (InterfaceC1786l) this.L$0;
                observer = new Observer() { // from class: androidx.lifecycle.e
                    @Override // android.view.Observer
                    public final void onChanged(Object obj2) {
                        FlowLiveDataConversions.AnonymousClass1.invokeSuspend$lambda$0(interfaceC1786l, obj2);
                    }
                };
                d dVar2 = AbstractC1691I.f5315a;
                C1748d c1748d = k.f6003a.d;
                C01221 c01221 = new C01221(this.$this_asFlow, observer, null);
                this.L$0 = observer;
                this.label = 1;
                if (AbstractC1683A.w(c1748d, c01221, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (r1 != 1) {
                    if (r1 == 2) {
                        b.b(obj);
                        throw new KotlinNothingValueException();
                    }
                    if (r1 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Throwable th2 = (Throwable) this.L$0;
                    b.b(obj);
                    throw th2;
                }
                observer = (Observer) this.L$0;
                b.b(obj);
            }
            this.L$0 = observer;
            this.label = 2;
            a.c(this);
            return coroutineSingletons;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1786l interfaceC1786l, H7.c<? super r> cVar) {
            return ((AnonymousClass1) create(interfaceC1786l, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "androidx.lifecycle.FlowLiveDataConversions$asLiveData$1", f = "FlowLiveData.kt", l = {78}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/LiveDataScope;", "LC7/r;", "<anonymous>", "(Landroidx/lifecycle/LiveDataScope;)V"}, k = 3, mv = {2, 0, 0})
    /* renamed from: androidx.lifecycle.FlowLiveDataConversions$asLiveData$1, reason: invalid class name and case insensitive filesystem */
    public static final class C07601 extends SuspendLambda implements n {
        final /* synthetic */ p9.c $this_asLiveData;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C07601(p9.c cVar, H7.c<? super C07601> cVar2) {
            super(2, cVar2);
            this.$this_asLiveData = cVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C07601 c07601 = new C07601(this.$this_asLiveData, cVar);
            c07601.L$0 = obj;
            return c07601;
        }

        @Override // S7.n
        public final Object invoke(LiveDataScope<T> liveDataScope, H7.c<? super r> cVar) {
            return ((C07601) create(liveDataScope, cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                final LiveDataScope liveDataScope = (LiveDataScope) this.L$0;
                p9.c cVar = this.$this_asLiveData;
                p9.d dVar = new p9.d() { // from class: androidx.lifecycle.FlowLiveDataConversions.asLiveData.1.1
                    @Override // p9.d
                    public final Object emit(T t9, H7.c<? super r> cVar2) {
                        Object objEmit = liveDataScope.emit(t9, cVar2);
                        return objEmit == CoroutineSingletons.f4909a ? objEmit : r.f317a;
                    }
                };
                this.label = 1;
                if (cVar.collect(dVar, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
            }
            return r.f317a;
        }
    }

    public static final <T> p9.c asFlow(LiveData<T> liveData) {
        kotlin.jvm.internal.k.f(liveData, "<this>");
        return kotlinx.coroutines.flow.d.b(kotlinx.coroutines.flow.d.c(new AnonymousClass1(liveData, null)), -1);
    }

    public static final <T> LiveData<T> asLiveData(p9.c cVar) {
        kotlin.jvm.internal.k.f(cVar, "<this>");
        return asLiveData$default(cVar, (h) null, 0L, 3, (Object) null);
    }

    public static /* synthetic */ LiveData asLiveData$default(p9.c cVar, h hVar, long j5, int i, Object obj) {
        if ((i & 1) != 0) {
            hVar = EmptyCoroutineContext.f4908a;
        }
        if ((i & 2) != 0) {
            j5 = 5000;
        }
        return asLiveData(cVar, hVar, j5);
    }

    public static final <T> LiveData<T> asLiveData(p9.c cVar, h context) {
        kotlin.jvm.internal.k.f(cVar, "<this>");
        kotlin.jvm.internal.k.f(context, "context");
        return asLiveData$default(cVar, context, 0L, 2, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> LiveData<T> asLiveData(p9.c cVar, h context, long j5) {
        kotlin.jvm.internal.k.f(cVar, "<this>");
        kotlin.jvm.internal.k.f(context, "context");
        RoomLambdaTrackingLiveData roomLambdaTrackingLiveData = (LiveData<T>) CoroutineLiveDataKt.liveData(context, j5, new C07601(cVar, null));
        if (cVar instanceof t) {
            if (ArchTaskExecutor.getInstance().isMainThread()) {
                roomLambdaTrackingLiveData.setValue(((t) cVar).getValue());
                return roomLambdaTrackingLiveData;
            }
            roomLambdaTrackingLiveData.postValue(((t) cVar).getValue());
        }
        return roomLambdaTrackingLiveData;
    }

    public static /* synthetic */ LiveData asLiveData$default(p9.c cVar, Duration duration, h hVar, int i, Object obj) {
        if ((i & 2) != 0) {
            hVar = EmptyCoroutineContext.f4908a;
        }
        return asLiveData(cVar, duration, hVar);
    }

    @RequiresApi(26)
    public static final <T> LiveData<T> asLiveData(p9.c cVar, Duration timeout, h context) {
        kotlin.jvm.internal.k.f(cVar, "<this>");
        kotlin.jvm.internal.k.f(timeout, "timeout");
        kotlin.jvm.internal.k.f(context, "context");
        return asLiveData(cVar, context, C0758Api26Impl.INSTANCE.toMillis(timeout));
    }
}
