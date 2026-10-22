package io.ktor.utils.io;

import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import kotlin.Metadata;
import p9.p;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u001a8\u0010\u0007\u001a\u00020\u0004*\u00020\u00002\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001H\u0086@¢\u0006\u0004\b\u0007\u0010\b\u001a8\u0010\t\u001a\u00020\u0004*\u00020\u00002\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001H\u0086@¢\u0006\u0004\b\t\u0010\b*\n\u0010\n\"\u00020\u00022\u00020\u0002¨\u0006\u000b"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "Lkotlin/Function2;", "Lio/ktor/utils/io/LookAheadSuspendSession;", "Le9/c;", "LY8/t;", "", "block", "lookAhead", "(Lio/ktor/utils/io/ByteReadChannel;Lp9/p;Le9/c;)Ljava/lang/Object;", "lookAheadSuspend", "LookAheadSession", "ktor-io"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LookAheadSessionKt {
    public static final Object lookAhead(ByteReadChannel byteReadChannel, p<? super LookAheadSuspendSession, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objInvoke = pVar.invoke(new LookAheadSuspendSession(byteReadChannel), interfaceC4014c);
        return objInvoke == C4063a.g() ? objInvoke : t.f7040a;
    }

    public static final Object lookAheadSuspend(ByteReadChannel byteReadChannel, p<? super LookAheadSuspendSession, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objInvoke = pVar.invoke(new LookAheadSuspendSession(byteReadChannel), interfaceC4014c);
        return objInvoke == C4063a.g() ? objInvoke : t.f7040a;
    }
}
