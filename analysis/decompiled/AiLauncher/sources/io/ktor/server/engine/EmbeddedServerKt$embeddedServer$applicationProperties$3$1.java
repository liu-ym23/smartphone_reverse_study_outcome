package io.ktor.server.engine;

import e9.InterfaceC4014c;
import io.ktor.server.application.Application;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public /* synthetic */ class EmbeddedServerKt$embeddedServer$applicationProperties$3$1 extends FunctionReferenceImpl implements p9.p<Application, InterfaceC4014c<? super Y8.t>, Object> {
    public EmbeddedServerKt$embeddedServer$applicationProperties$3$1(Object obj) {
        super(2, obj, p.a.class, "suspendConversion0", "embeddedServer$lambda$13$suspendConversion0$12(Lkotlin/jvm/functions/Function1;Lio/ktor/server/application/Application;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // p9.p
    public final Object invoke(Application application, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return EmbeddedServerKt.embeddedServer$lambda$13$suspendConversion0$12((InterfaceC5074l) this.receiver, application, interfaceC4014c);
    }
}
