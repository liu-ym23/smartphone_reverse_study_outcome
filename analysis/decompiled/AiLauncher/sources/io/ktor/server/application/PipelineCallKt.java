package io.ktor.server.application;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.util.AttributeKey;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.t;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003\"\u0015\u0010\u0006\u001a\u00020\u0005*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"(\u0010\r\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\b\u001a\u00020\u00018F@@X\u0086\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\")\u0010\u0012\u001a\u00028\u0000\"\b\b\u0000\u0010\u000e*\u00020\u0004*\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lio/ktor/util/AttributeKey;", "Lio/ktor/util/reflect/TypeInfo;", "RECEIVE_TYPE_KEY", "Lio/ktor/util/AttributeKey;", "Lio/ktor/server/application/ApplicationCall;", "", "isHandled", "(Lio/ktor/server/application/ApplicationCall;)Z", UxipConstants.f30680s, "getReceiveType", "(Lio/ktor/server/application/ApplicationCall;)Lio/ktor/util/reflect/TypeInfo;", "setReceiveType", "(Lio/ktor/server/application/ApplicationCall;Lio/ktor/util/reflect/TypeInfo;)V", "receiveType", "C", "Lio/ktor/util/pipeline/PipelineContext;", "getCall", "(Lio/ktor/util/pipeline/PipelineContext;)Lio/ktor/server/application/ApplicationCall;", "call", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PipelineCallKt {
    private static final AttributeKey<TypeInfo> RECEIVE_TYPE_KEY;

    static {
        InterfaceC5755n interfaceC5755nM;
        InterfaceC5745d interfaceC5745dB = t.b(TypeInfo.class);
        try {
            interfaceC5755nM = t.m(TypeInfo.class);
        } catch (Throwable unused) {
            interfaceC5755nM = null;
        }
        RECEIVE_TYPE_KEY = new AttributeKey<>("ReceiveType", new TypeInfo(interfaceC5745dB, interfaceC5755nM));
    }

    public static final <C extends ApplicationCall> C getCall(PipelineContext<?, C> pipelineContext) {
        p.i(pipelineContext, "<this>");
        return pipelineContext.getContext();
    }

    public static final TypeInfo getReceiveType(ApplicationCall applicationCall) {
        p.i(applicationCall, "<this>");
        return (TypeInfo) applicationCall.getAttributes().get(RECEIVE_TYPE_KEY);
    }

    public static final boolean isHandled(ApplicationCall applicationCall) {
        p.i(applicationCall, "<this>");
        return applicationCall.getResponse().getResponded();
    }

    public static final void setReceiveType(ApplicationCall applicationCall, TypeInfo value) {
        p.i(applicationCall, "<this>");
        p.i(value, "value");
        applicationCall.getAttributes().put(RECEIVE_TYPE_KEY, value);
    }
}
