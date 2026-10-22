package androidx.appfunctions;

import H7.c;
import android.os.CancellationSignal;
import android.os.OutcomeReceiver;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appfunctions.internal.Dispatchers;
import androidx.appfunctions.metadata.AppFunctionMetadataKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;

@RequiresApi(34)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0011H§@¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000eH\u0017¢\u0006\u0004\b\u0015\u0010\u0003R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Landroidx/appfunctions/ExtensionsAppFunctionService;", "Lcom/android/extensions/appfunctions/AppFunctionService;", AppAgent.CONSTRUCT, "()V", "Lcom/android/extensions/appfunctions/ExecuteAppFunctionRequest;", "request", "", "callingPackage", "Landroid/os/CancellationSignal;", "cancellationSignal", "Landroid/os/OutcomeReceiver;", "Lcom/android/extensions/appfunctions/ExecuteAppFunctionResponse;", "Lcom/android/extensions/appfunctions/AppFunctionException;", "callback", "LC7/r;", "onExecuteFunction", "(Lcom/android/extensions/appfunctions/ExecuteAppFunctionRequest;Ljava/lang/String;Landroid/os/CancellationSignal;Landroid/os/OutcomeReceiver;)V", "Landroidx/appfunctions/ExecuteAppFunctionRequest;", "Landroidx/appfunctions/ExecuteAppFunctionResponse;", "executeFunction", "(Landroidx/appfunctions/ExecuteAppFunctionRequest;LH7/c;)Ljava/lang/Object;", "onDestroy", "Lm9/z;", "workerCoroutineScope", "Lm9/z;", "Companion", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public abstract class ExtensionsAppFunctionService extends com.android.extensions.appfunctions.AppFunctionService {
    public static final String SERVICE_INTERFACE = "android.app.appfunctions.AppFunctionService";
    private final InterfaceC1733z workerCoroutineScope = AbstractC1683A.b(Dispatchers.INSTANCE.getWorker());

    @MainThread
    public abstract Object executeFunction(ExecuteAppFunctionRequest executeAppFunctionRequest, c<? super ExecuteAppFunctionResponse> cVar);

    @CallSuper
    public void onDestroy() {
        super.onDestroy();
        AbstractC1683A.e(this.workerCoroutineScope, null);
    }

    public final void onExecuteFunction(com.android.extensions.appfunctions.ExecuteAppFunctionRequest request, String callingPackage, CancellationSignal cancellationSignal, OutcomeReceiver<com.android.extensions.appfunctions.ExecuteAppFunctionResponse, com.android.extensions.appfunctions.AppFunctionException> callback) {
        k.f(request, "request");
        k.f(callingPackage, "callingPackage");
        k.f(cancellationSignal, "cancellationSignal");
        k.f(callback, "callback");
        cancellationSignal.setOnCancelListener(new b(AbstractC1683A.n(this.workerCoroutineScope, null, new ExtensionsAppFunctionService$onExecuteFunction$functionExecutionJob$1(this, request, callingPackage, callback, null), 3), 1));
    }
}
