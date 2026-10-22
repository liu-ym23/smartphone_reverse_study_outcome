package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u0011\u0010\u0003\u001a\u00020\u0004H¦Bø\u0001\u0000¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\u00028\u0000H¦\u0002¢\u0006\u0002\u0010\u0007J\u0013\u0010\b\u001a\u00028\u0000H\u0097@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/channels/ChannelIterator;", "E", "", "hasNext", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "next", "()Ljava/lang/Object;", "next0", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ChannelIterator<E> {

    public static final class DefaultImpls {
        public static /* synthetic */ Object a(ChannelIterator r10, Continuation r11) {
            if ((r11 instanceof ChannelIterator$next0$1) == false) goto L7;
            ChannelIterator$next0$1 r12 = (ChannelIterator$next0$1) r11;
            int r13 = r12.label;
            if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
            r12.label = r13 - Integer.MIN_VALUE;
        L8:
            Object r14 = r12.result;
            Object r15 = kotlin.coroutines.intrinsics.a.d();
            int r16 = r12.label;
            if (r16 == 0) goto L14;
            if (r16 != 1) goto L13;
            r10 = (ChannelIterator) r12.L$0;
            kotlin.c.b(r14);
        L18:
            if (((Boolean) r14).booleanValue() == false) goto L22;
            return r10.next();
        L22:
            throw new ClosedReceiveChannelException("Channel was closed");
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            kotlin.c.b(r14);
            r12.L$0 = r10;
            r12.label = 1;
            r14 = r10.hasNext(r12);
            if (r14 != r15) goto L18;
            return r15;
        L7:
            r12 = new ChannelIterator$next0$1(r11);
            goto L8
        }
    }

    @Nullable
    Object hasNext(@NotNull Continuation<? super Boolean> r10);

    E next();

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
    @JvmName(name = "next")
    /* synthetic */ Object next(Continuation r10);
}
