package kotlinx.coroutines.channels;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.selects.SelectClause1;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"kotlinx/coroutines/channels/ChannelsKt__ChannelsKt", "kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt", "kotlinx/coroutines/channels/ChannelsKt__DeprecatedKt"}, k = 4, mv = {1, 8, 0}, xi = 48)
public final class ChannelsKt {
    public static final String DEFAULT_CLOSE_MESSAGE = "Channel was closed";

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object any(ReceiveChannel r0, Continuation r1) {
        return ChannelsKt__DeprecatedKt.any(r0, r1);
    }

    public static final void cancelConsumed(ReceiveChannel<?> r0, Throwable r1) {
        ChannelsKt__Channels_commonKt.cancelConsumed(r0, r1);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    public static final <E, R> R consume(BroadcastChannel<E> r0, Function1<? super ReceiveChannel<? extends E>, ? extends R> r1) {
        return (R) ChannelsKt__Channels_commonKt.consume(r0, r1);
    }

    public static final <E, R> R consume(ReceiveChannel<? extends E> r0, Function1<? super ReceiveChannel<? extends E>, ? extends R> r1) {
        return (R) ChannelsKt__Channels_commonKt.consume(r0, r1);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    public static final <E> Object consumeEach(BroadcastChannel<E> r0, Function1<? super E, Unit> r1, Continuation<? super Unit> r2) {
        return ChannelsKt__Channels_commonKt.consumeEach(r0, r1, r2);
    }

    public static final <E> Object consumeEach(ReceiveChannel<? extends E> r0, Function1<? super E, Unit> r1, Continuation<? super Unit> r2) {
        return ChannelsKt__Channels_commonKt.consumeEach(r0, r1, r2);
    }

    public static final Function1<Throwable, Unit> consumes(ReceiveChannel<?> r0) {
        return ChannelsKt__DeprecatedKt.consumes(r0);
    }

    public static final Function1<Throwable, Unit> consumesAll(ReceiveChannel<?>... r0) {
        return ChannelsKt__DeprecatedKt.consumesAll(r0);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object count(ReceiveChannel r0, Continuation r1) {
        return ChannelsKt__DeprecatedKt.count(r0, r1);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel distinct(ReceiveChannel r0) {
        return ChannelsKt__DeprecatedKt.distinct(r0);
    }

    public static final <E, K> ReceiveChannel<E> distinctBy(ReceiveChannel<? extends E> r0, CoroutineContext r1, Function2<? super E, ? super Continuation<? super K>, ? extends Object> r2) {
        return ChannelsKt__DeprecatedKt.distinctBy(r0, r1, r2);
    }

    public static /* synthetic */ ReceiveChannel distinctBy$default(ReceiveChannel r0, CoroutineContext r1, Function2 r2, int r3, Object r4) {
        return ChannelsKt__DeprecatedKt.distinctBy$default(r0, r1, r2, r3, r4);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel drop(ReceiveChannel r0, int r1, CoroutineContext r2) {
        return ChannelsKt__DeprecatedKt.drop(r0, r1, r2);
    }

    public static /* synthetic */ ReceiveChannel drop$default(ReceiveChannel r0, int r1, CoroutineContext r2, int r3, Object r4) {
        return ChannelsKt__DeprecatedKt.drop$default(r0, r1, r2, r3, r4);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel dropWhile(ReceiveChannel r0, CoroutineContext r1, Function2 r2) {
        return ChannelsKt__DeprecatedKt.dropWhile(r0, r1, r2);
    }

    public static /* synthetic */ ReceiveChannel dropWhile$default(ReceiveChannel r0, CoroutineContext r1, Function2 r2, int r3, Object r4) {
        return ChannelsKt__DeprecatedKt.dropWhile$default(r0, r1, r2, r3, r4);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object elementAt(ReceiveChannel r0, int r1, Continuation r2) {
        return ChannelsKt__DeprecatedKt.elementAt(r0, r1, r2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object elementAtOrNull(ReceiveChannel r0, int r1, Continuation r2) {
        return ChannelsKt__DeprecatedKt.elementAtOrNull(r0, r1, r2);
    }

    public static final <E> ReceiveChannel<E> filter(ReceiveChannel<? extends E> r0, CoroutineContext r1, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> r2) {
        return ChannelsKt__DeprecatedKt.filter(r0, r1, r2);
    }

    public static /* synthetic */ ReceiveChannel filter$default(ReceiveChannel r0, CoroutineContext r1, Function2 r2, int r3, Object r4) {
        return ChannelsKt__DeprecatedKt.filter$default(r0, r1, r2, r3, r4);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel filterIndexed(ReceiveChannel r0, CoroutineContext r1, Function3 r2) {
        return ChannelsKt__DeprecatedKt.filterIndexed(r0, r1, r2);
    }

    public static /* synthetic */ ReceiveChannel filterIndexed$default(ReceiveChannel r0, CoroutineContext r1, Function3 r2, int r3, Object r4) {
        return ChannelsKt__DeprecatedKt.filterIndexed$default(r0, r1, r2, r3, r4);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel filterNot(ReceiveChannel r0, CoroutineContext r1, Function2 r2) {
        return ChannelsKt__DeprecatedKt.filterNot(r0, r1, r2);
    }

    public static /* synthetic */ ReceiveChannel filterNot$default(ReceiveChannel r0, CoroutineContext r1, Function2 r2, int r3, Object r4) {
        return ChannelsKt__DeprecatedKt.filterNot$default(r0, r1, r2, r3, r4);
    }

    public static final <E> ReceiveChannel<E> filterNotNull(ReceiveChannel<? extends E> r0) {
        return ChannelsKt__DeprecatedKt.filterNotNull(r0);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object filterNotNullTo(ReceiveChannel r0, Collection r1, Continuation r2) {
        return ChannelsKt__DeprecatedKt.filterNotNullTo(r0, r1, r2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object filterNotNullTo(ReceiveChannel r0, SendChannel r1, Continuation r2) {
        return ChannelsKt__DeprecatedKt.filterNotNullTo(r0, r1, r2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object first(ReceiveChannel r0, Continuation r1) {
        return ChannelsKt__DeprecatedKt.first(r0, r1);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object firstOrNull(ReceiveChannel r0, Continuation r1) {
        return ChannelsKt__DeprecatedKt.firstOrNull(r0, r1);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel flatMap(ReceiveChannel r0, CoroutineContext r1, Function2 r2) {
        return ChannelsKt__DeprecatedKt.flatMap(r0, r1, r2);
    }

    public static /* synthetic */ ReceiveChannel flatMap$default(ReceiveChannel r0, CoroutineContext r1, Function2 r2, int r3, Object r4) {
        return ChannelsKt__DeprecatedKt.flatMap$default(r0, r1, r2, r3, r4);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object indexOf(ReceiveChannel r0, Object r1, Continuation r2) {
        return ChannelsKt__DeprecatedKt.indexOf(r0, r1, r2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object last(ReceiveChannel r0, Continuation r1) {
        return ChannelsKt__DeprecatedKt.last(r0, r1);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object lastIndexOf(ReceiveChannel r0, Object r1, Continuation r2) {
        return ChannelsKt__DeprecatedKt.lastIndexOf(r0, r1, r2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object lastOrNull(ReceiveChannel r0, Continuation r1) {
        return ChannelsKt__DeprecatedKt.lastOrNull(r0, r1);
    }

    public static final <E, R> ReceiveChannel<R> map(ReceiveChannel<? extends E> r0, CoroutineContext r1, Function2<? super E, ? super Continuation<? super R>, ? extends Object> r2) {
        return ChannelsKt__DeprecatedKt.map(r0, r1, r2);
    }

    public static /* synthetic */ ReceiveChannel map$default(ReceiveChannel r0, CoroutineContext r1, Function2 r2, int r3, Object r4) {
        return ChannelsKt__DeprecatedKt.map$default(r0, r1, r2, r3, r4);
    }

    public static final <E, R> ReceiveChannel<R> mapIndexed(ReceiveChannel<? extends E> r0, CoroutineContext r1, Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> r2) {
        return ChannelsKt__DeprecatedKt.mapIndexed(r0, r1, r2);
    }

    public static /* synthetic */ ReceiveChannel mapIndexed$default(ReceiveChannel r0, CoroutineContext r1, Function3 r2, int r3, Object r4) {
        return ChannelsKt__DeprecatedKt.mapIndexed$default(r0, r1, r2, r3, r4);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel mapIndexedNotNull(ReceiveChannel r0, CoroutineContext r1, Function3 r2) {
        return ChannelsKt__DeprecatedKt.mapIndexedNotNull(r0, r1, r2);
    }

    public static /* synthetic */ ReceiveChannel mapIndexedNotNull$default(ReceiveChannel r0, CoroutineContext r1, Function3 r2, int r3, Object r4) {
        return ChannelsKt__DeprecatedKt.mapIndexedNotNull$default(r0, r1, r2, r3, r4);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel mapNotNull(ReceiveChannel r0, CoroutineContext r1, Function2 r2) {
        return ChannelsKt__DeprecatedKt.mapNotNull(r0, r1, r2);
    }

    public static /* synthetic */ ReceiveChannel mapNotNull$default(ReceiveChannel r0, CoroutineContext r1, Function2 r2, int r3, Object r4) {
        return ChannelsKt__DeprecatedKt.mapNotNull$default(r0, r1, r2, r3, r4);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object maxWith(ReceiveChannel r0, Comparator r1, Continuation r2) {
        return ChannelsKt__DeprecatedKt.maxWith(r0, r1, r2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object minWith(ReceiveChannel r0, Comparator r1, Continuation r2) {
        return ChannelsKt__DeprecatedKt.minWith(r0, r1, r2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object none(ReceiveChannel r0, Continuation r1) {
        return ChannelsKt__DeprecatedKt.none(r0, r1);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in the favour of 'onReceiveCatching'")
    public static final /* synthetic */ SelectClause1 onReceiveOrNull(ReceiveChannel r0) {
        return ChannelsKt__Channels_commonKt.onReceiveOrNull(r0);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in the favour of 'receiveCatching'", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    public static final /* synthetic */ Object receiveOrNull(ReceiveChannel r0, Continuation r1) {
        return ChannelsKt__Channels_commonKt.receiveOrNull(r0, r1);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Left for binary compatibility")
    public static final /* synthetic */ ReceiveChannel requireNoNulls(ReceiveChannel r0) {
        return ChannelsKt__DeprecatedKt.requireNoNulls(r0);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in the favour of 'trySendBlocking'. Consider handling the result of 'trySendBlocking' explicitly and rethrow exception if necessary", replaceWith = @ReplaceWith(expression = "trySendBlocking(element)", imports = {}))
    public static final /* synthetic */ void sendBlocking(SendChannel r0, Object r1) {
        ChannelsKt__ChannelsKt.sendBlocking(r0, r1);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object single(ReceiveChannel r0, Continuation r1) {
        return ChannelsKt__DeprecatedKt.single(r0, r1);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object singleOrNull(ReceiveChannel r0, Continuation r1) {
        return ChannelsKt__DeprecatedKt.singleOrNull(r0, r1);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel take(ReceiveChannel r0, int r1, CoroutineContext r2) {
        return ChannelsKt__DeprecatedKt.take(r0, r1, r2);
    }

    public static /* synthetic */ ReceiveChannel take$default(ReceiveChannel r0, int r1, CoroutineContext r2, int r3, Object r4) {
        return ChannelsKt__DeprecatedKt.take$default(r0, r1, r2, r3, r4);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel takeWhile(ReceiveChannel r0, CoroutineContext r1, Function2 r2) {
        return ChannelsKt__DeprecatedKt.takeWhile(r0, r1, r2);
    }

    public static /* synthetic */ ReceiveChannel takeWhile$default(ReceiveChannel r0, CoroutineContext r1, Function2 r2, int r3, Object r4) {
        return ChannelsKt__DeprecatedKt.takeWhile$default(r0, r1, r2, r3, r4);
    }

    public static final <E, C extends SendChannel<? super E>> Object toChannel(ReceiveChannel<? extends E> r0, C r1, Continuation<? super C> r2) {
        return ChannelsKt__DeprecatedKt.toChannel(r0, r1, r2);
    }

    public static final <E, C extends Collection<? super E>> Object toCollection(ReceiveChannel<? extends E> r0, C r1, Continuation<? super C> r2) {
        return ChannelsKt__DeprecatedKt.toCollection(r0, r1, r2);
    }

    public static final <E> Object toList(ReceiveChannel<? extends E> r0, Continuation<? super List<? extends E>> r1) {
        return ChannelsKt__Channels_commonKt.toList(r0, r1);
    }

    public static final <K, V, M extends Map<? super K, ? super V>> Object toMap(ReceiveChannel<? extends Pair<? extends K, ? extends V>> r0, M r1, Continuation<? super M> r2) {
        return ChannelsKt__DeprecatedKt.toMap(r0, r1, r2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object toMap(ReceiveChannel r0, Continuation r1) {
        return ChannelsKt__DeprecatedKt.toMap(r0, r1);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object toMutableList(ReceiveChannel r0, Continuation r1) {
        return ChannelsKt__DeprecatedKt.toMutableList(r0, r1);
    }

    public static final <E> Object toMutableSet(ReceiveChannel<? extends E> r0, Continuation<? super Set<E>> r1) {
        return ChannelsKt__DeprecatedKt.toMutableSet(r0, r1);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object toSet(ReceiveChannel r0, Continuation r1) {
        return ChannelsKt__DeprecatedKt.toSet(r0, r1);
    }

    public static final <E> Object trySendBlocking(SendChannel<? super E> r0, E r1) {
        return ChannelsKt__ChannelsKt.trySendBlocking(r0, r1);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel withIndex(ReceiveChannel r0, CoroutineContext r1) {
        return ChannelsKt__DeprecatedKt.withIndex(r0, r1);
    }

    public static /* synthetic */ ReceiveChannel withIndex$default(ReceiveChannel r0, CoroutineContext r1, int r2, Object r3) {
        return ChannelsKt__DeprecatedKt.withIndex$default(r0, r1, r2, r3);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel zip(ReceiveChannel r0, ReceiveChannel r1) {
        return ChannelsKt__DeprecatedKt.zip(r0, r1);
    }

    public static final <E, R, V> ReceiveChannel<V> zip(ReceiveChannel<? extends E> r0, ReceiveChannel<? extends R> r1, CoroutineContext r2, Function2<? super E, ? super R, ? extends V> r3) {
        return ChannelsKt__DeprecatedKt.zip(r0, r1, r2, r3);
    }

    public static /* synthetic */ ReceiveChannel zip$default(ReceiveChannel r0, ReceiveChannel r1, CoroutineContext r2, Function2 r3, int r4, Object r5) {
        return ChannelsKt__DeprecatedKt.zip$default(r0, r1, r2, r3, r4, r5);
    }
}
