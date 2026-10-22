package io.ktor.server.plugins;

import io.ktor.http.RequestConnectionPoint;
import io.ktor.server.application.ApplicationCall;
import io.ktor.server.request.ApplicationRequest;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.t;
import p9.InterfaceC5063a;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"&\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\"\u0015\u0010\u0010\u001a\u00020\u0006*\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lio/ktor/server/request/ApplicationRequest;", "Lio/ktor/http/RequestConnectionPoint;", "getOrigin", "(Lio/ktor/server/request/ApplicationRequest;)Lio/ktor/http/RequestConnectionPoint;", "origin", "Lio/ktor/util/AttributeKey;", "Lio/ktor/server/plugins/MutableOriginConnectionPoint;", "MutableOriginConnectionPointKey", "Lio/ktor/util/AttributeKey;", "getMutableOriginConnectionPointKey", "()Lio/ktor/util/AttributeKey;", "getMutableOriginConnectionPointKey$annotations", "()V", "Lio/ktor/server/application/ApplicationCall;", "getMutableOriginConnectionPoint", "(Lio/ktor/server/application/ApplicationCall;)Lio/ktor/server/plugins/MutableOriginConnectionPoint;", "mutableOriginConnectionPoint", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OriginConnectionPointKt {
    private static final AttributeKey<MutableOriginConnectionPoint> MutableOriginConnectionPointKey;

    static {
        InterfaceC5755n interfaceC5755nM;
        InterfaceC5745d interfaceC5745dB = t.b(MutableOriginConnectionPoint.class);
        try {
            interfaceC5755nM = t.m(MutableOriginConnectionPoint.class);
        } catch (Throwable unused) {
            interfaceC5755nM = null;
        }
        MutableOriginConnectionPointKey = new AttributeKey<>("MutableOriginConnectionPointKey", new TypeInfo(interfaceC5745dB, interfaceC5755nM));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableOriginConnectionPoint _get_mutableOriginConnectionPoint_$lambda$0(ApplicationCall applicationCall) {
        return new MutableOriginConnectionPoint(new OriginConnectionPoint(applicationCall));
    }

    public static final MutableOriginConnectionPoint getMutableOriginConnectionPoint(final ApplicationCall applicationCall) {
        p.i(applicationCall, "<this>");
        return (MutableOriginConnectionPoint) applicationCall.getAttributes().computeIfAbsent(MutableOriginConnectionPointKey, new InterfaceC5063a() { // from class: io.ktor.server.plugins.o
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return OriginConnectionPointKt._get_mutableOriginConnectionPoint_$lambda$0(applicationCall);
            }
        });
    }

    public static final AttributeKey<MutableOriginConnectionPoint> getMutableOriginConnectionPointKey() {
        return MutableOriginConnectionPointKey;
    }

    public static /* synthetic */ void getMutableOriginConnectionPointKey$annotations() {
    }

    public static final RequestConnectionPoint getOrigin(ApplicationRequest applicationRequest) {
        p.i(applicationRequest, "<this>");
        MutableOriginConnectionPoint mutableOriginConnectionPoint = (MutableOriginConnectionPoint) applicationRequest.getCall().getAttributes().getOrNull(MutableOriginConnectionPointKey);
        return mutableOriginConnectionPoint != null ? mutableOriginConnectionPoint : applicationRequest.getLocal();
    }
}
