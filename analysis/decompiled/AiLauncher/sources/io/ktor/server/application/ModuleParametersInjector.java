package io.ktor.server.application;

import e9.InterfaceC4014c;
import io.ktor.http.ContentType;
import kotlin.Metadata;
import kotlin.reflect.KParameter;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bæ\u0080\u0001\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\"\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H¦@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lio/ktor/server/application/ModuleParametersInjector;", "", "Lio/ktor/server/application/Application;", ContentType.Application.TYPE, "Lkotlin/reflect/KParameter;", "parameter", "resolveParameter", "(Lio/ktor/server/application/Application;Lkotlin/reflect/KParameter;Le9/c;)Ljava/lang/Object;", "Companion", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ModuleParametersInjector {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/server/application/ModuleParametersInjector$Companion;", "", "<init>", "()V", "Lio/ktor/server/application/ModuleParametersInjector;", "Disabled", "Lio/ktor/server/application/ModuleParametersInjector;", "getDisabled$ktor_server_core", "()Lio/ktor/server/application/ModuleParametersInjector;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final ModuleParametersInjector Disabled = new ModuleParametersInjector() { // from class: io.ktor.server.application.ModuleParametersInjector$Companion$Disabled$1
            @Override // io.ktor.server.application.ModuleParametersInjector
            public final Object resolveParameter(Application application, KParameter kParameter, InterfaceC4014c<Object> interfaceC4014c) {
                throw new IllegalArgumentException("No module injector configured");
            }
        };

        private Companion() {
        }

        public final ModuleParametersInjector getDisabled$ktor_server_core() {
            return Disabled;
        }
    }

    Object resolveParameter(Application application, KParameter kParameter, InterfaceC4014c<Object> interfaceC4014c);
}
