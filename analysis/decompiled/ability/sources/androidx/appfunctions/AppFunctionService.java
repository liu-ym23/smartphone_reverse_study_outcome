package androidx.appfunctions;

import H7.c;
import android.content.pm.SigningInfo;
import android.os.CancellationSignal;
import android.os.OutcomeReceiver;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.RequiresApi;
import androidx.appfunctions.internal.Dispatchers;
import androidx.appfunctions.metadata.AppFunctionMetadataKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;

@RequiresApi(36)
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0013H§@¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0010H\u0017¢\u0006\u0004\b\u0017\u0010\u0003R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Landroidx/appfunctions/AppFunctionService;", "Landroid/app/appfunctions/AppFunctionService;", AppAgent.CONSTRUCT, "()V", "Landroid/app/appfunctions/ExecuteAppFunctionRequest;", "request", "", "callingPackage", "Landroid/content/pm/SigningInfo;", "signingInfo", "Landroid/os/CancellationSignal;", "cancellationSignal", "Landroid/os/OutcomeReceiver;", "Landroid/app/appfunctions/ExecuteAppFunctionResponse;", "Landroid/app/appfunctions/AppFunctionException;", "callback", "LC7/r;", "onExecuteFunction", "(Landroid/app/appfunctions/ExecuteAppFunctionRequest;Ljava/lang/String;Landroid/content/pm/SigningInfo;Landroid/os/CancellationSignal;Landroid/os/OutcomeReceiver;)V", "Landroidx/appfunctions/ExecuteAppFunctionRequest;", "Landroidx/appfunctions/ExecuteAppFunctionResponse;", "executeFunction", "(Landroidx/appfunctions/ExecuteAppFunctionRequest;LH7/c;)Ljava/lang/Object;", "onDestroy", "Lm9/z;", "workerCoroutineScope", "Lm9/z;", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AppFunctionService extends android.app.appfunctions.AppFunctionService {
    private final InterfaceC1733z workerCoroutineScope = AbstractC1683A.b(Dispatchers.INSTANCE.getWorker());

    @MainThread
    public abstract Object executeFunction(ExecuteAppFunctionRequest executeAppFunctionRequest, c<? super ExecuteAppFunctionResponse> cVar);

    @Override // android.app.Service
    @CallSuper
    public void onDestroy() {
        super.onDestroy();
        AbstractC1683A.e(this.workerCoroutineScope, null);
    }

    public final void onExecuteFunction(android.app.appfunctions.ExecuteAppFunctionRequest request, String callingPackage, SigningInfo signingInfo, CancellationSignal cancellationSignal, OutcomeReceiver<android.app.appfunctions.ExecuteAppFunctionResponse, android.app.appfunctions.AppFunctionException> callback) {
        k.f(request, "request");
        k.f(callingPackage, "callingPackage");
        k.f(signingInfo, "signingInfo");
        k.f(cancellationSignal, "cancellationSignal");
        k.f(callback, "callback");
        cancellationSignal.setOnCancelListener(new b(AbstractC1683A.n(this.workerCoroutineScope, null, new AppFunctionService$onExecuteFunction$functionExecutionJob$1(this, request, callingPackage, callback, null), 3), 0));
    }
}
