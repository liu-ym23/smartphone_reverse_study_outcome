package androidx.appfunctions;

import C7.r;
import J7.c;
import S7.n;
import androidx.appfunctions.metadata.AppFunctionMetadata;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "androidx.appfunctions.ExtensionsAppFunctionService$onExecuteFunction$functionExecutionJob$1$result$1", f = "ExtensionsAppFunctionService.kt", l = {94}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Landroidx/appfunctions/ExecuteAppFunctionResponse;", "<anonymous>", "(Lm9/z;)Landroidx/appfunctions/ExecuteAppFunctionResponse;"}, k = 3, mv = {2, 1, 0})
/* loaded from: classes.dex */
public final class ExtensionsAppFunctionService$onExecuteFunction$functionExecutionJob$1$result$1 extends SuspendLambda implements n {
    final /* synthetic */ AppFunctionMetadata $appFunctionMetadata;
    final /* synthetic */ com.android.extensions.appfunctions.ExecuteAppFunctionRequest $request;
    int label;
    final /* synthetic */ ExtensionsAppFunctionService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExtensionsAppFunctionService$onExecuteFunction$functionExecutionJob$1$result$1(ExtensionsAppFunctionService extensionsAppFunctionService, com.android.extensions.appfunctions.ExecuteAppFunctionRequest executeAppFunctionRequest, AppFunctionMetadata appFunctionMetadata, H7.c<? super ExtensionsAppFunctionService$onExecuteFunction$functionExecutionJob$1$result$1> cVar) {
        super(2, cVar);
        this.this$0 = extensionsAppFunctionService;
        this.$request = executeAppFunctionRequest;
        this.$appFunctionMetadata = appFunctionMetadata;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new ExtensionsAppFunctionService$onExecuteFunction$functionExecutionJob$1$result$1(this.this$0, this.$request, this.$appFunctionMetadata, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            return obj;
        }
        kotlin.b.b(obj);
        ExtensionsAppFunctionService extensionsAppFunctionService = this.this$0;
        ExecuteAppFunctionRequest executeAppFunctionRequestFromPlatformExtensionClass$appfunctions = ExecuteAppFunctionRequest.INSTANCE.fromPlatformExtensionClass$appfunctions(this.$request, this.$appFunctionMetadata);
        this.label = 1;
        Object objExecuteFunction = extensionsAppFunctionService.executeFunction(executeAppFunctionRequestFromPlatformExtensionClass$appfunctions, this);
        return objExecuteFunction == coroutineSingletons ? coroutineSingletons : objExecuteFunction;
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super ExecuteAppFunctionResponse> cVar) {
        return ((ExtensionsAppFunctionService$onExecuteFunction$functionExecutionJob$1$result$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
