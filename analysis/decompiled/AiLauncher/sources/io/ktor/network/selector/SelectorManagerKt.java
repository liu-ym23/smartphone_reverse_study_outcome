package io.ktor.network.selector;

import java.io.Closeable;
import java.io.IOException;
import java.nio.channels.spi.SelectorProvider;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.d;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0017\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001aS\u0010\r\u001a\u00028\u0001\"\f\b\u0000\u0010\u0007*\u00060\u0005j\u0002`\u0006\"\u0004\b\u0001\u0010\b*\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00000\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\tH\u0086\bø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000f"}, d2 = {"Lkotlin/coroutines/d;", "dispatcher", "Lio/ktor/network/selector/SelectorManager;", "SelectorManager", "(Lkotlin/coroutines/d;)Lio/ktor/network/selector/SelectorManager;", "Ljava/io/Closeable;", "Lio/ktor/utils/io/core/Closeable;", "C", "R", "Lkotlin/Function1;", "Ljava/nio/channels/spi/SelectorProvider;", "create", "setup", "buildOrClose", "(Lio/ktor/network/selector/SelectorManager;Lp9/l;Lp9/l;)Ljava/lang/Object;", "ktor-network"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SelectorManagerKt {
    public static final SelectorManager SelectorManager(d dispatcher) {
        p.i(dispatcher, "dispatcher");
        return new ActorSelectorManager(dispatcher);
    }

    public static /* synthetic */ SelectorManager SelectorManager$default(d dVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            dVar = EmptyCoroutineContext.f34779a;
        }
        return SelectorManager(dVar);
    }

    public static final <C extends Closeable, R> R buildOrClose(SelectorManager selectorManager, InterfaceC5074l<? super SelectorProvider, ? extends C> create, InterfaceC5074l<? super C, ? extends R> setup) throws IOException {
        p.i(selectorManager, "<this>");
        p.i(create, "create");
        p.i(setup, "setup");
        C cInvoke = create.invoke(selectorManager.getProvider());
        try {
            return setup.invoke(cInvoke);
        } catch (Throwable th) {
            cInvoke.close();
            throw th;
        }
    }
}
