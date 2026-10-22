package io.ktor.server.engine;

import io.ktor.server.application.Application;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.InterfaceC5063a;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public /* synthetic */ class EmbeddedServer$engine$1 extends FunctionReferenceImpl implements InterfaceC5063a<Application> {
    public EmbeddedServer$engine$1(Object obj) {
        super(0, obj, EmbeddedServer.class, "currentApplication", "currentApplication()Lio/ktor/server/application/Application;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p9.InterfaceC5063a
    public final Application invoke() {
        return ((EmbeddedServer) this.receiver).currentApplication();
    }
}
