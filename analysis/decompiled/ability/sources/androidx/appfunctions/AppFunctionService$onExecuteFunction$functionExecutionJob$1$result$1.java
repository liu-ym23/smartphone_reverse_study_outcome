package androidx.appfunctions;

import C7.r;
import J7.c;
import S7.n;
import androidx.appfunctions.metadata.AppFunctionMetadata;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "androidx.appfunctions.AppFunctionService$onExecuteFunction$functionExecutionJob$1$result$1", f = "AppFunctionService.kt", l = {97}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Landroidx/appfunctions/ExecuteAppFunctionResponse;", "<anonymous>", "(Lm9/z;)Landroidx/appfunctions/ExecuteAppFunctionResponse;"}, k = 3, mv = {2, 1, 0})
/* loaded from: classes.dex */
public final class AppFunctionService$onExecuteFunction$functionExecutionJob$1$result$1 extends SuspendLambda implements n {
    final /* synthetic */ AppFunctionMetadata $appFunctionMetadata;
    final /* synthetic */ android.app.appfunctions.ExecuteAppFunctionRequest $request;
    int label;
    final /* synthetic */ AppFunctionService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppFunctionService$onExecuteFunction$functionExecutionJob$1$result$1(AppFunctionService appFunctionService, android.app.appfunctions.ExecuteAppFunctionRequest executeAppFunctionRequest, AppFunctionMetadata appFunctionMetadata, H7.c<? super AppFunctionService$onExecuteFunction$functionExecutionJob$1$result$1> cVar) {
        super(2, cVar);
        this.this$0 = appFunctionService;
        this.$request = executeAppFunctionRequest;
        this.$appFunctionMetadata = appFunctionMetadata;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new AppFunctionService$onExecuteFunction$functionExecutionJob$1$result$1(this.this$0, this.$request, this.$appFunctionMetadata, cVar);
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
        AppFunctionService appFunctionService = this.this$0;
        ExecuteAppFunctionRequest compatExecuteAppFunctionRequest = ExecuteAppFunctionRequest.INSTANCE.toCompatExecuteAppFunctionRequest(this.$request, this.$appFunctionMetadata);
        this.label = 1;
        Object objExecuteFunction = appFunctionService.executeFunction(compatExecuteAppFunctionRequest, this);
        return objExecuteFunction == coroutineSingletons ? coroutineSingletons : objExecuteFunction;
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super ExecuteAppFunctionResponse> cVar) {
        return ((AppFunctionService$onExecuteFunction$functionExecutionJob$1$result$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
