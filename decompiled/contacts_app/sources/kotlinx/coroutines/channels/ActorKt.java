package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.PerfConsts;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: compiled from: Actor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u009c\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2-\b\u0002\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bj\u0004\u0018\u0001`\u00112-\u0010\u0012\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0013¢\u0006\u0002\b\u0017H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"actor", "Lkotlinx/coroutines/channels/SendChannel;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", PerfConsts.KEY_CURRENT_CAPACITY, "", "start", "Lkotlinx/coroutines/CoroutineStart;", "onCompletion", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ActorScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/SendChannel;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ActorKt {
    public static /* synthetic */ SendChannel actor$default(CoroutineScope r6, EmptyCoroutineContext r7, int r8, CoroutineStart r9, Function1 r10, Function2 r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r7 = EmptyCoroutineContext.INSTANCE;
    L5:
        CoroutineContext r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r8 = 0;
    L8:
        int r2 = r8;
        if ((r12 & 4) == 0) goto L11;
        r9 = CoroutineStart.DEFAULT;
    L11:
        CoroutineStart r3 = r9;
        if ((r12 & 8) == 0) goto L15;
        r10 = null;
    L15:
        return actor(r6, r1, r2, r3, r10, r11);
    }

    public static final <E> SendChannel<E> actor(CoroutineScope r1, CoroutineContext r2, int r3, CoroutineStart r4, Function1<? super Throwable, Unit> r5, Function2<? super ActorScope<E>, ? super Continuation<? super Unit>, ? extends Object> r6) {
        CoroutineContext r7 = CoroutineContextKt.newCoroutineContext(r1, r2);
        Channel r8 = ChannelKt.Channel$default(r3, null, null, 6, null);
        if (r4.isLazy() == false) goto L5;
        LazyActorCoroutine r9 = new LazyActorCoroutine(r7, r8, r6);
    L6:
        if (r5 == null) goto L8;
        r9.invokeOnCompletion(r5);
    L8:
        r9.start(r4, r9, r6);
        return r9;
    L5:
        r9 = new ActorCoroutine(r7, r8, true);
        goto L6
    }
}
