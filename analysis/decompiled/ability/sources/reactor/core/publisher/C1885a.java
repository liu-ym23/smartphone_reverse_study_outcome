package reactor.core.publisher;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import reactor.core.Scannable;
import reactor.core.publisher.FluxBufferTimeout;
import reactor.core.publisher.FluxCombineLatest;
import reactor.core.publisher.FluxSampleTimeout;
import reactor.core.publisher.Sinks;
import reactor.util.context.Context;
import reactor.util.function.Tuple2;

/* renamed from: reactor.core.publisher.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final /* synthetic */ class C1885a implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5903a;

    public /* synthetic */ C1885a(int i) {
        this.f5903a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f5903a) {
            case 0:
                return CallSiteSupplierFactory.lambda$static$0((String) obj);
            case 1:
                return ContextPropagation.lambda$static$0((Context) obj);
            case 2:
                return ContextPropagation.lambda$scopePassingOnScheduleHook$1((Runnable) obj);
            case 3:
                return Long.valueOf(FluxBufferTimeout.BufferTimeoutWithBackpressureSubscriber.setTimedOut(((Long) obj).longValue()));
            case 4:
                return Long.valueOf(FluxBufferTimeout.BufferTimeoutWithBackpressureSubscriber.incrementRequestIndex(((Long) obj).longValue()));
            case 5:
                return Long.valueOf(FluxBufferTimeout.BufferTimeoutWithBackpressureSubscriber.setTerminated(((Long) obj).longValue()));
            case 6:
                return Long.valueOf(FluxBufferTimeout.BufferTimeoutWithBackpressureSubscriber.setCancelled(((Long) obj).longValue()));
            case 7:
                return FluxBufferTimeout.BufferTimeoutWithBackpressureSubscriber.lambda$onNext$0((Long) obj);
            case 8:
                return ((FluxCombineLatest.SourceAndArray) obj).toStream();
            case 9:
                return FluxMetrics.lambda$resolveTags$0((Map.Entry) obj);
            case 10:
                return ((FluxSampleTimeout.SampleTimeoutOther) obj).toStream();
            case 11:
                return MonoCacheTime.lambda$new$1((Signal) obj);
            case 12:
                return MonoTimeout.lambda$static$0(obj);
            case 13:
                return Flux.lambda$null$14(obj);
            case 14:
                return Flux.lambda$timeout$36(obj);
            case 15:
                return ((Collection) obj).stream();
            case 16:
                return Scannable.from((Sinks.Many) obj);
            case 17:
                return Mono.lambda$zip$4(obj);
            case 18:
                return Mono.lambda$zip$3(obj);
            case 19:
                return Mono.lambda$zipDelayError$10(obj);
            case 20:
                return Mono.lambda$zip$8(obj);
            case 21:
                return Mono.lambda$zip$7(obj);
            case 22:
                return Mono.lambda$zip$5(obj);
            case 23:
                return Mono.lambda$zipDelayError$11(obj);
            case 24:
                return Mono.lambda$zipDelayError$16(obj);
            case 25:
                return Mono.lambda$zipDelayError$12(obj);
            case 26:
                return (Long) ((Tuple2) obj).getT1();
            case 27:
                return Mono.lambda$zip$6(obj);
            case 28:
                return Mono.lambda$zipDelayError$14(obj);
            default:
                return Mono.lambda$zipDelayError$13(obj);
        }
    }
}
