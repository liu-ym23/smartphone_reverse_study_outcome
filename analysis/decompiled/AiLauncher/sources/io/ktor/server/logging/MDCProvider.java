package io.ktor.server.logging;

import Y8.t;
import e9.InterfaceC4014c;
import io.ktor.server.application.ApplicationCall;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J6\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u001c\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004H¦@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lio/ktor/server/logging/MDCProvider;", "", "Lio/ktor/server/application/ApplicationCall;", "call", "Lkotlin/Function1;", "Le9/c;", "LY8/t;", "block", "withMDCBlock", "(Lio/ktor/server/application/ApplicationCall;Lp9/l;Le9/c;)Ljava/lang/Object;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface MDCProvider {
    Object withMDCBlock(ApplicationCall applicationCall, InterfaceC5074l<? super InterfaceC4014c<? super t>, ? extends Object> interfaceC5074l, InterfaceC4014c<? super t> interfaceC4014c);
}
