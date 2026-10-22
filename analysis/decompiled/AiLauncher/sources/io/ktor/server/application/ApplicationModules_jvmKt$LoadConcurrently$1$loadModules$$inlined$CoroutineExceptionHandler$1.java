package io.ktor.server.application;

import Ua.J;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"io/ktor/server/application/ApplicationModules_jvmKt$LoadConcurrently$1$loadModules$$inlined$CoroutineExceptionHandler$1", "Lkotlin/coroutines/a;", "LUa/J;", "Lkotlin/coroutines/d;", "context", "", "exception", "LY8/t;", "handleException", "(Lkotlin/coroutines/d;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ApplicationModules_jvmKt$LoadConcurrently$1$loadModules$$inlined$CoroutineExceptionHandler$1 extends kotlin.coroutines.a implements J {
    final /* synthetic */ Application $application$inlined;
    final /* synthetic */ List $errors$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplicationModules_jvmKt$LoadConcurrently$1$loadModules$$inlined$CoroutineExceptionHandler$1(J.Companion companion, Application application, List list) {
        super(companion);
        this.$application$inlined = application;
        this.$errors$inlined = list;
    }

    @Override // Ua.J
    public void handleException(kotlin.coroutines.d context, Throwable exception) {
        this.$application$inlined.getEnvironment().getLog().error("Failed to load module", exception);
        this.$errors$inlined.add(exception);
    }
}
