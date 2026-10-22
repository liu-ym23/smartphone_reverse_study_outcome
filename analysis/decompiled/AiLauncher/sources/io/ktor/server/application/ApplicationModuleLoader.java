package io.ktor.server.application;

import Y8.t;
import e9.InterfaceC4014c;
import io.ktor.http.ContentType;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bà\u0080\u0001\u0018\u00002\u00020\u0001J.\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H¦@¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/server/application/ApplicationModuleLoader;", "", "Lio/ktor/server/application/Application;", ContentType.Application.TYPE, "Ljava/lang/ClassLoader;", "classLoader", "", "Lio/ktor/server/application/DynamicApplicationModule;", "modules", "LY8/t;", "loadModules", "(Lio/ktor/server/application/Application;Ljava/lang/ClassLoader;Ljava/util/List;Le9/c;)Ljava/lang/Object;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ApplicationModuleLoader {
    Object loadModules(Application application, ClassLoader classLoader, List<DynamicApplicationModule> list, InterfaceC4014c<? super t> interfaceC4014c);
}
