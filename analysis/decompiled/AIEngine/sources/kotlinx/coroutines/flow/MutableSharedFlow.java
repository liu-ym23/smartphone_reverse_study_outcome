package kotlinx.coroutines.flow;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface MutableSharedFlow<T> extends SharedFlow<T>, FlowCollector<T> {
    StateFlow<Integer> getSubscriptionCount();

    boolean tryEmit(T t8);
}
