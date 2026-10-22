package io.ktor.client.plugins.observer;

import db.C3966a;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0001\u001a\u00020\u0000H\u0080@¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Lkotlin/coroutines/d;", "getResponseObserverContext", "(Le9/c;)Ljava/lang/Object;", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ResponseObserverContextJvmKt {
    public static final Object getResponseObserverContext(InterfaceC4014c<? super kotlin.coroutines.d> interfaceC4014c) {
        C3966a c3966a = (C3966a) interfaceC4014c.getContext().get(C3966a.INSTANCE);
        return c3966a != null ? c3966a : EmptyCoroutineContext.f34779a;
    }
}
