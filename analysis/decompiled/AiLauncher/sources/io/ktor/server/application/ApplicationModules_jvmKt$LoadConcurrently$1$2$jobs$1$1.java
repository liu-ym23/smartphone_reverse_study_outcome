package io.ktor.server.application;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;
import p9.q;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "io.ktor.server.application.ApplicationModules_jvmKt$LoadConcurrently$1$2$jobs$1$1", f = "ApplicationModules.jvm.kt", l = {75}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class ApplicationModules_jvmKt$LoadConcurrently$1$2$jobs$1$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ Application $application;
    final /* synthetic */ ClassLoader $classLoader;
    final /* synthetic */ DynamicApplicationModule $module;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplicationModules_jvmKt$LoadConcurrently$1$2$jobs$1$1(DynamicApplicationModule dynamicApplicationModule, Application application, ClassLoader classLoader, InterfaceC4014c<? super ApplicationModules_jvmKt$LoadConcurrently$1$2$jobs$1$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$module = dynamicApplicationModule;
        this.$application = application;
        this.$classLoader = classLoader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ApplicationModules_jvmKt$LoadConcurrently$1$2$jobs$1$1(this.$module, this.$application, this.$classLoader, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((ApplicationModules_jvmKt$LoadConcurrently$1$2$jobs$1$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            DynamicApplicationModule dynamicApplicationModule = this.$module;
            Application application = this.$application;
            ClassLoader classLoader = this.$classLoader;
            q<Application, ClassLoader, InterfaceC4014c<? super t>, Object> function = dynamicApplicationModule.getFunction();
            this.label = 1;
            if (function.invoke(application, classLoader, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return t.f7040a;
    }
}
