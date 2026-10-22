package io.ktor.server.sse;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import io.ktor.server.application.ApplicationCall;
import io.ktor.sse.ServerSentEvent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0005\u0010\u0006JL\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0096@¢\u0006\u0004\b\u0005\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004H¦@¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lio/ktor/server/sse/ServerSSESession;", "LUa/M;", "Lio/ktor/sse/ServerSentEvent;", "event", "LY8/t;", "send", "(Lio/ktor/sse/ServerSentEvent;Le9/c;)Ljava/lang/Object;", "", "data", "id", "", "retry", "comments", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "close", "(Le9/c;)Ljava/lang/Object;", "Lio/ktor/server/application/ApplicationCall;", "getCall", "()Lio/ktor/server/application/ApplicationCall;", "call", "ktor-server-sse"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ServerSSESession extends M {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Object send(ServerSSESession serverSSESession, String str, String str2, String str3, Long l10, String str4, InterfaceC4014c<? super t> interfaceC4014c) {
            Object objSend = serverSSESession.send(new ServerSentEvent(str, str2, str3, l10, str4), interfaceC4014c);
            return objSend == C4063a.g() ? objSend : t.f7040a;
        }

        public static /* synthetic */ Object send$default(ServerSSESession serverSSESession, String str, String str2, String str3, Long l10, String str4, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: send");
            }
            if ((i10 & 1) != 0) {
                str = null;
            }
            if ((i10 & 2) != 0) {
                str2 = null;
            }
            if ((i10 & 4) != 0) {
                str3 = null;
            }
            if ((i10 & 8) != 0) {
                l10 = null;
            }
            if ((i10 & 16) != 0) {
                str4 = null;
            }
            return serverSSESession.send(str, str2, str3, l10, str4, interfaceC4014c);
        }
    }

    Object close(InterfaceC4014c<? super t> interfaceC4014c);

    ApplicationCall getCall();

    @Override // Ua.M
    /* synthetic */ kotlin.coroutines.d getCoroutineContext();

    Object send(ServerSentEvent serverSentEvent, InterfaceC4014c<? super t> interfaceC4014c);

    Object send(String str, String str2, String str3, Long l10, String str4, InterfaceC4014c<? super t> interfaceC4014c);
}
