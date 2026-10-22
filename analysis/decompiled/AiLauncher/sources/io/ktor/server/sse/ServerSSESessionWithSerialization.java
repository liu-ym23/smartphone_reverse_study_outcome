package io.ktor.server.sse;

import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import io.ktor.server.sse.ServerSSESession;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import p9.p;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R&\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lio/ktor/server/sse/ServerSSESessionWithSerialization;", "Lio/ktor/server/sse/ServerSSESession;", "Lkotlin/Function2;", "Lio/ktor/util/reflect/TypeInfo;", "", "", "getSerializer", "()Lp9/p;", "serializer", "ktor-server-sse"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ServerSSESessionWithSerialization extends ServerSSESession {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Object send(ServerSSESessionWithSerialization serverSSESessionWithSerialization, String str, String str2, String str3, Long l10, String str4, InterfaceC4014c<? super t> interfaceC4014c) {
            Object objSend = ServerSSESession.DefaultImpls.send(serverSSESessionWithSerialization, str, str2, str3, l10, str4, interfaceC4014c);
            return objSend == C4063a.g() ? objSend : t.f7040a;
        }
    }

    @Override // io.ktor.server.sse.ServerSSESession, Ua.M
    /* synthetic */ kotlin.coroutines.d getCoroutineContext();

    p<TypeInfo, Object, String> getSerializer();
}
