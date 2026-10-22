package io.ktor.server.logging;

import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import io.ktor.server.application.ApplicationCall;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u001c\u0010\n\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006H\u0096@¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/server/logging/EmptyMDCProvider;", "Lio/ktor/server/logging/MDCProvider;", "<init>", "()V", "Lio/ktor/server/application/ApplicationCall;", "call", "Lkotlin/Function1;", "Le9/c;", "LY8/t;", "", "block", "withMDCBlock", "(Lio/ktor/server/application/ApplicationCall;Lp9/l;Le9/c;)Ljava/lang/Object;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
final class EmptyMDCProvider implements MDCProvider {
    public static final EmptyMDCProvider INSTANCE = new EmptyMDCProvider();

    private EmptyMDCProvider() {
    }

    @Override // io.ktor.server.logging.MDCProvider
    public Object withMDCBlock(ApplicationCall applicationCall, InterfaceC5074l<? super InterfaceC4014c<? super t>, ? extends Object> interfaceC5074l, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objInvoke = interfaceC5074l.invoke(interfaceC4014c);
        return objInvoke == C4063a.g() ? objInvoke : t.f7040a;
    }
}
