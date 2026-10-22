package io.modelcontextprotocol.kotlin.sdk.shared;

import Ua.C1087w;
import Ua.InterfaceC1083u;
import j8.C4785k;
import j8.InterfaceC4782h;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.time.DurationUnit;
import kotlin.time.a;
import kotlinx.serialization.json.ClassDiscriminatorMode;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import qb.AbstractC5171a;
import qb.C5174d;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0014\u0010\u0001\u001a\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0014\u0010\u0004\u001a\u00020\u00038\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005\"!\u0010\r\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\"\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\" \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018*\"\u0010\u001b\"\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00140\u00192\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00140\u0019¨\u0006\u001c"}, d2 = {"Lj8/h;", "LOGGER", "Lj8/h;", "", "IMPLEMENTATION_NAME", "Ljava/lang/String;", "Lqb/a;", "McpJson$delegate", "LY8/h;", "getMcpJson", "()Lqb/a;", "getMcpJson$annotations", "()V", "McpJson", "Lkotlin/time/a;", "DEFAULT_REQUEST_TIMEOUT", "J", "getDEFAULT_REQUEST_TIMEOUT", "()J", "LUa/u;", "LY8/t;", "COMPLETED", "LUa/u;", "getCOMPLETED", "()LUa/u;", "Lkotlin/Function1;", "Lio/modelcontextprotocol/kotlin/sdk/Progress;", "ProgressCallback", "kotlin-sdk"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ProtocolKt {
    private static final InterfaceC1083u<Y8.t> COMPLETED;
    private static final long DEFAULT_REQUEST_TIMEOUT;
    public static final String IMPLEMENTATION_NAME = "mcp-ktor";
    private static final InterfaceC4782h LOGGER = C4785k.f34533a.b(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.shared.y
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return Y8.t.f7040a;
        }
    });
    private static final Y8.h McpJson$delegate = C4848b.b(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.shared.z
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return ProtocolKt.McpJson_delegate$lambda$2();
        }
    });

    static {
        a.Companion companion = kotlin.time.a.INSTANCE;
        DEFAULT_REQUEST_TIMEOUT = kotlin.time.b.s(60000, DurationUnit.MILLISECONDS);
        Y8.t tVar = Y8.t.f7040a;
        InterfaceC1083u<Y8.t> interfaceC1083uA = C1087w.a(tVar);
        interfaceC1083uA.complete(tVar);
        COMPLETED = interfaceC1083uA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AbstractC5171a McpJson_delegate$lambda$2() {
        return qb.v.b(null, new InterfaceC5074l() { // from class: io.modelcontextprotocol.kotlin.sdk.shared.A
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ProtocolKt.McpJson_delegate$lambda$2$lambda$1((C5174d) obj);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t McpJson_delegate$lambda$2$lambda$1(C5174d Json) {
        kotlin.jvm.internal.p.i(Json, "$this$Json");
        Json.g(true);
        Json.e(true);
        Json.h(true);
        Json.c(ClassDiscriminatorMode.NONE);
        Json.f(false);
        return Y8.t.f7040a;
    }

    public static final InterfaceC1083u<Y8.t> getCOMPLETED() {
        return COMPLETED;
    }

    public static final long getDEFAULT_REQUEST_TIMEOUT() {
        return DEFAULT_REQUEST_TIMEOUT;
    }

    public static final AbstractC5171a getMcpJson() {
        return (AbstractC5171a) McpJson$delegate.getValue();
    }

    public static /* synthetic */ void getMcpJson$annotations() {
    }
}
