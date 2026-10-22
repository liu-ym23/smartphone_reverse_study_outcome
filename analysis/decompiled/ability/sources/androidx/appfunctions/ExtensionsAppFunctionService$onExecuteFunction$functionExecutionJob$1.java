package androidx.appfunctions;

import C7.r;
import J7.c;
import S7.n;
import android.os.OutcomeReceiver;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "androidx.appfunctions.ExtensionsAppFunctionService$onExecuteFunction$functionExecutionJob$1", f = "ExtensionsAppFunctionService.kt", l = {86, 93}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 1, 0})
/* loaded from: classes.dex */
public final class ExtensionsAppFunctionService$onExecuteFunction$functionExecutionJob$1 extends SuspendLambda implements n {
    final /* synthetic */ OutcomeReceiver<com.android.extensions.appfunctions.ExecuteAppFunctionResponse, com.android.extensions.appfunctions.AppFunctionException> $callback;
    final /* synthetic */ String $callingPackage;
    final /* synthetic */ com.android.extensions.appfunctions.ExecuteAppFunctionRequest $request;
    int label;
    final /* synthetic */ ExtensionsAppFunctionService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExtensionsAppFunctionService$onExecuteFunction$functionExecutionJob$1(ExtensionsAppFunctionService extensionsAppFunctionService, com.android.extensions.appfunctions.ExecuteAppFunctionRequest executeAppFunctionRequest, String str, OutcomeReceiver<com.android.extensions.appfunctions.ExecuteAppFunctionResponse, com.android.extensions.appfunctions.AppFunctionException> outcomeReceiver, H7.c<? super ExtensionsAppFunctionService$onExecuteFunction$functionExecutionJob$1> cVar) {
        super(2, cVar);
        this.this$0 = extensionsAppFunctionService;
        this.$request = executeAppFunctionRequest;
        this.$callingPackage = str;
        this.$callback = outcomeReceiver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new ExtensionsAppFunctionService$onExecuteFunction$functionExecutionJob$1(this.this$0, this.$request, this.$callingPackage, this.$callback, cVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0057, code lost:
    
        if (r8 == r1) goto L22;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.String r0 = "No function found with identifier: "
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r7.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L20
            if (r2 == r4) goto L1c
            if (r2 != r3) goto L14
            kotlin.b.b(r8)     // Catch: androidx.appfunctions.AppFunctionException -> L12
            goto L5a
        L12:
            r8 = move-exception
            goto L83
        L14:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L1c:
            kotlin.b.b(r8)     // Catch: androidx.appfunctions.AppFunctionException -> L12
            goto L3d
        L20:
            kotlin.b.b(r8)
            androidx.appfunctions.internal.AppFunctionMetadataUtils r8 = androidx.appfunctions.internal.AppFunctionMetadataUtils.INSTANCE     // Catch: androidx.appfunctions.AppFunctionException -> L12
            androidx.appfunctions.ExtensionsAppFunctionService r2 = r7.this$0     // Catch: androidx.appfunctions.AppFunctionException -> L12
            android.content.Context r2 = (android.content.Context) r2     // Catch: androidx.appfunctions.AppFunctionException -> L12
            com.android.extensions.appfunctions.ExecuteAppFunctionRequest r5 = r7.$request     // Catch: androidx.appfunctions.AppFunctionException -> L12
            java.lang.String r5 = r5.getFunctionIdentifier()     // Catch: androidx.appfunctions.AppFunctionException -> L12
            java.lang.String r6 = "getFunctionIdentifier(...)"
            kotlin.jvm.internal.k.e(r5, r6)     // Catch: androidx.appfunctions.AppFunctionException -> L12
            r7.label = r4     // Catch: androidx.appfunctions.AppFunctionException -> L12
            java.lang.Object r8 = r8.getAppFunctionMetadata(r2, r5, r7)     // Catch: androidx.appfunctions.AppFunctionException -> L12
            if (r8 != r1) goto L3d
            goto L59
        L3d:
            androidx.appfunctions.metadata.AppFunctionMetadata r8 = (androidx.appfunctions.metadata.AppFunctionMetadata) r8     // Catch: androidx.appfunctions.AppFunctionException -> L12
            if (r8 == 0) goto L5d
            androidx.appfunctions.internal.Dispatchers r0 = androidx.appfunctions.internal.Dispatchers.INSTANCE     // Catch: androidx.appfunctions.AppFunctionException -> L12
            m9.v r0 = r0.getMain()     // Catch: androidx.appfunctions.AppFunctionException -> L12
            androidx.appfunctions.ExtensionsAppFunctionService$onExecuteFunction$functionExecutionJob$1$result$1 r2 = new androidx.appfunctions.ExtensionsAppFunctionService$onExecuteFunction$functionExecutionJob$1$result$1     // Catch: androidx.appfunctions.AppFunctionException -> L12
            androidx.appfunctions.ExtensionsAppFunctionService r4 = r7.this$0     // Catch: androidx.appfunctions.AppFunctionException -> L12
            com.android.extensions.appfunctions.ExecuteAppFunctionRequest r5 = r7.$request     // Catch: androidx.appfunctions.AppFunctionException -> L12
            r6 = 0
            r2.<init>(r4, r5, r8, r6)     // Catch: androidx.appfunctions.AppFunctionException -> L12
            r7.label = r3     // Catch: androidx.appfunctions.AppFunctionException -> L12
            java.lang.Object r8 = m9.AbstractC1683A.w(r0, r2, r7)     // Catch: androidx.appfunctions.AppFunctionException -> L12
            if (r8 != r1) goto L5a
        L59:
            return r1
        L5a:
            androidx.appfunctions.ExecuteAppFunctionResponse r8 = (androidx.appfunctions.ExecuteAppFunctionResponse) r8     // Catch: androidx.appfunctions.AppFunctionException -> L12
            goto L89
        L5d:
            androidx.appfunctions.AppFunctionFunctionNotFoundException r8 = new androidx.appfunctions.AppFunctionFunctionNotFoundException     // Catch: androidx.appfunctions.AppFunctionException -> L12
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: androidx.appfunctions.AppFunctionException -> L12
            r1.<init>(r0)     // Catch: androidx.appfunctions.AppFunctionException -> L12
            com.android.extensions.appfunctions.ExecuteAppFunctionRequest r0 = r7.$request     // Catch: androidx.appfunctions.AppFunctionException -> L12
            java.lang.String r0 = r0.getFunctionIdentifier()     // Catch: androidx.appfunctions.AppFunctionException -> L12
            r1.append(r0)     // Catch: androidx.appfunctions.AppFunctionException -> L12
            java.lang.String r0 = " in package: "
            r1.append(r0)     // Catch: androidx.appfunctions.AppFunctionException -> L12
            androidx.appfunctions.ExtensionsAppFunctionService r0 = r7.this$0     // Catch: androidx.appfunctions.AppFunctionException -> L12
            java.lang.String r0 = r0.getPackageName()     // Catch: androidx.appfunctions.AppFunctionException -> L12
            r1.append(r0)     // Catch: androidx.appfunctions.AppFunctionException -> L12
            java.lang.String r0 = r1.toString()     // Catch: androidx.appfunctions.AppFunctionException -> L12
            r8.<init>(r0)     // Catch: androidx.appfunctions.AppFunctionException -> L12
            throw r8     // Catch: androidx.appfunctions.AppFunctionException -> L12
        L83:
            androidx.appfunctions.ExecuteAppFunctionResponse$Error r0 = new androidx.appfunctions.ExecuteAppFunctionResponse$Error
            r0.<init>(r8)
            r8 = r0
        L89:
            boolean r0 = r8 instanceof androidx.appfunctions.ExecuteAppFunctionResponse.Success
            if (r0 == 0) goto La2
            androidx.appfunctions.ExecuteAppFunctionResponse$Success r8 = (androidx.appfunctions.ExecuteAppFunctionResponse.Success) r8
            androidx.appfunctions.ExtensionsAppFunctionService r0 = r7.this$0
            android.content.Context r0 = (android.content.Context) r0
            java.lang.String r1 = r7.$callingPackage
            r8.grantUriAccess$appfunctions(r0, r1)
            android.os.OutcomeReceiver<com.android.extensions.appfunctions.ExecuteAppFunctionResponse, com.android.extensions.appfunctions.AppFunctionException> r7 = r7.$callback
            com.android.extensions.appfunctions.ExecuteAppFunctionResponse r8 = r8.toPlatformExtensionClass$appfunctions()
            r7.onResult(r8)
            goto Lb7
        La2:
            boolean r0 = r8 instanceof androidx.appfunctions.ExecuteAppFunctionResponse.Error
            if (r0 == 0) goto Lba
            android.os.OutcomeReceiver<com.android.extensions.appfunctions.ExecuteAppFunctionResponse, com.android.extensions.appfunctions.AppFunctionException> r7 = r7.$callback
            androidx.appfunctions.ExecuteAppFunctionResponse$Error r8 = (androidx.appfunctions.ExecuteAppFunctionResponse.Error) r8
            androidx.appfunctions.AppFunctionException r8 = r8.getError()
            com.android.extensions.appfunctions.AppFunctionException r8 = r8.toPlatformExtensionsClass()
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r7.onError(r8)
        Lb7:
            C7.r r7 = C7.r.f317a
            return r7
        Lba:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appfunctions.ExtensionsAppFunctionService$onExecuteFunction$functionExecutionJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
        return ((ExtensionsAppFunctionService$onExecuteFunction$functionExecutionJob$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
