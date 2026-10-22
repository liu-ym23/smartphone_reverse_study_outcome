package io.ktor.server.engine;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.http.ParametersBuilder;
import io.ktor.http.content.PartData;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lio/ktor/http/content/PartData;", "part", "LY8/t;", "<anonymous>", "(Lio/ktor/http/content/PartData;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "io.ktor.server.engine.DefaultTransformKt$installDefaultTransformations$2$transformed$1$1", f = "DefaultTransform.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class DefaultTransformKt$installDefaultTransformations$2$transformed$1$1 extends SuspendLambda implements p9.p<PartData, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ ParametersBuilder $this_build;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultTransformKt$installDefaultTransformations$2$transformed$1$1(ParametersBuilder parametersBuilder, InterfaceC4014c<? super DefaultTransformKt$installDefaultTransformations$2$transformed$1$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$this_build = parametersBuilder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        DefaultTransformKt$installDefaultTransformations$2$transformed$1$1 defaultTransformKt$installDefaultTransformations$2$transformed$1$1 = new DefaultTransformKt$installDefaultTransformations$2$transformed$1$1(this.$this_build, interfaceC4014c);
        defaultTransformKt$installDefaultTransformations$2$transformed$1$1.L$0 = obj;
        return defaultTransformKt$installDefaultTransformations$2$transformed$1$1;
    }

    @Override // p9.p
    public final Object invoke(PartData partData, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((DefaultTransformKt$installDefaultTransformations$2$transformed$1$1) create(partData, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String name;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        PartData partData = (PartData) this.L$0;
        if ((partData instanceof PartData.FormItem) && (name = partData.getName()) != null) {
            this.$this_build.append(name, ((PartData.FormItem) partData).getValue());
        }
        partData.getDispose().invoke();
        return Y8.t.f7040a;
    }
}
