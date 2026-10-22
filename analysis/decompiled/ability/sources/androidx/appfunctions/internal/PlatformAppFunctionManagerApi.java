package androidx.appfunctions.internal;

import C7.f;
import C7.r;
import D6.i;
import android.app.appfunctions.AppFunctionException;
import android.app.appfunctions.AppFunctionManager;
import android.content.Context;
import android.os.CancellationSignal;
import android.os.OutcomeReceiver;
import androidx.annotation.RequiresApi;
import androidx.appfunctions.ExecuteAppFunctionRequest;
import androidx.appfunctions.ExecuteAppFunctionResponse;
import androidx.appfunctions.metadata.AppFunctionMetadata;
import androidx.appfunctions.metadata.AppFunctionMetadataKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.k;
import m9.C1718k;

@RequiresApi(36)
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ \u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0096@¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\u0012\u0010\u0013J \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0096@¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001bR\u001b\u0010!\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Landroidx/appfunctions/internal/PlatformAppFunctionManagerApi;", "Landroidx/appfunctions/internal/AppFunctionManagerApi;", "Landroid/content/Context;", "context", AppAgent.CONSTRUCT, "(Landroid/content/Context;)V", "", "enabledState", "convertToPlatformEnabledState", "(I)I", "", "packageName", "functionId", "", "isAppFunctionEnabled", "(Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "newEnabledState", "LC7/r;", "setAppFunctionEnabled", "(Ljava/lang/String;ILH7/c;)Ljava/lang/Object;", "Landroidx/appfunctions/ExecuteAppFunctionRequest;", "request", "Landroidx/appfunctions/metadata/AppFunctionMetadata;", "functionMetadata", "Landroidx/appfunctions/ExecuteAppFunctionResponse;", "executeAppFunction", "(Landroidx/appfunctions/ExecuteAppFunctionRequest;Landroidx/appfunctions/metadata/AppFunctionMetadata;LH7/c;)Ljava/lang/Object;", "Landroid/content/Context;", "Landroid/app/appfunctions/AppFunctionManager;", "appFunctionManager$delegate", "LC7/f;", "getAppFunctionManager", "()Landroid/app/appfunctions/AppFunctionManager;", "appFunctionManager", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PlatformAppFunctionManagerApi implements AppFunctionManagerApi {

    /* renamed from: appFunctionManager$delegate, reason: from kotlin metadata */
    private final f appFunctionManager;
    private final Context context;

    public PlatformAppFunctionManagerApi(Context context) {
        k.f(context, "context");
        this.context = context;
        this.appFunctionManager = kotlin.a.a(new i(this, 8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppFunctionManager appFunctionManager_delegate$lambda$0(PlatformAppFunctionManagerApi platformAppFunctionManagerApi) {
        return M3.a.d(platformAppFunctionManagerApi.context.getSystemService(M3.a.p()));
    }

    private final int convertToPlatformEnabledState(int enabledState) {
        if (enabledState == 0) {
            return 0;
        }
        if (enabledState == 1) {
            return 1;
        }
        if (enabledState == 2) {
            return 2;
        }
        throw new IllegalArgumentException(B7.a.h(enabledState, "Unknown enabled state "));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppFunctionManager getAppFunctionManager() {
        Object f4884a = this.appFunctionManager.getF4884a();
        k.e(f4884a, "getValue(...)");
        return M3.a.d(f4884a);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.appfunctions.internal.PlatformAppFunctionManagerApi$executeAppFunction$2$3] */
    @Override // androidx.appfunctions.internal.AppFunctionManagerApi
    public Object executeAppFunction(ExecuteAppFunctionRequest executeAppFunctionRequest, final AppFunctionMetadata appFunctionMetadata, H7.c<? super ExecuteAppFunctionResponse> cVar) {
        final C1718k c1718k = new C1718k(1, U7.a.I(cVar));
        c1718k.y();
        final CancellationSignal cancellationSignal = new CancellationSignal();
        c1718k.j(new S7.k() { // from class: androidx.appfunctions.internal.PlatformAppFunctionManagerApi$executeAppFunction$2$1
            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return r.f317a;
            }

            public final void invoke(Throwable th) {
                cancellationSignal.cancel();
            }
        });
        getAppFunctionManager().executeAppFunction(executeAppFunctionRequest.toPlatformExecuteAppFunctionRequest(), new c(0), cancellationSignal, new OutcomeReceiver<android.app.appfunctions.ExecuteAppFunctionResponse, AppFunctionException>() { // from class: androidx.appfunctions.internal.PlatformAppFunctionManagerApi$executeAppFunction$2$3
            @Override // android.os.OutcomeReceiver
            public /* bridge */ /* synthetic */ void onError(Throwable th) {
                onError(M3.a.c(th));
            }

            @Override // android.os.OutcomeReceiver
            public /* bridge */ /* synthetic */ void onResult(android.app.appfunctions.ExecuteAppFunctionResponse executeAppFunctionResponse) {
                onResult2(M3.a.j(executeAppFunctionResponse));
            }

            public void onError(AppFunctionException error) {
                k.f(error, "error");
                c1718k.resumeWith(new ExecuteAppFunctionResponse.Error(androidx.appfunctions.AppFunctionException.INSTANCE.fromPlatformClass(error)));
            }

            @RequiresApi(36)
            /* renamed from: onResult, reason: avoid collision after fix types in other method */
            public void onResult2(android.app.appfunctions.ExecuteAppFunctionResponse result) {
                k.f(result, "result");
                c1718k.resumeWith(ExecuteAppFunctionResponse.Success.INSTANCE.toCompatExecuteAppFunctionResponse(result, appFunctionMetadata));
            }
        });
        Object objX = c1718k.x();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        return objX;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [androidx.appfunctions.internal.PlatformAppFunctionManagerApi$isAppFunctionEnabled$2$2] */
    @Override // androidx.appfunctions.internal.AppFunctionManagerApi
    public Object isAppFunctionEnabled(String str, String str2, H7.c<? super Boolean> cVar) {
        final C1718k c1718k = new C1718k(1, U7.a.I(cVar));
        c1718k.y();
        getAppFunctionManager().isAppFunctionEnabled(str2, str, new c(0), new OutcomeReceiver<Boolean, Exception>() { // from class: androidx.appfunctions.internal.PlatformAppFunctionManagerApi$isAppFunctionEnabled$2$2
            @Override // android.os.OutcomeReceiver
            public void onError(Exception error) {
                k.f(error, "error");
                c1718k.resumeWith(kotlin.b.a(error));
            }

            @Override // android.os.OutcomeReceiver
            public void onResult(Boolean result) {
                if (result == null) {
                    c1718k.resumeWith(kotlin.b.a(new IllegalStateException("Something went wrong")));
                } else {
                    c1718k.resumeWith(result);
                }
            }
        });
        Object objX = c1718k.x();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        return objX;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [androidx.appfunctions.internal.PlatformAppFunctionManagerApi$setAppFunctionEnabled$2$2] */
    @Override // androidx.appfunctions.internal.AppFunctionManagerApi
    public Object setAppFunctionEnabled(String str, int i, H7.c<? super r> cVar) {
        int iConvertToPlatformEnabledState = convertToPlatformEnabledState(i);
        final C1718k c1718k = new C1718k(1, U7.a.I(cVar));
        c1718k.y();
        getAppFunctionManager().setAppFunctionEnabled(str, iConvertToPlatformEnabledState, new c(0), new OutcomeReceiver<Void, Exception>() { // from class: androidx.appfunctions.internal.PlatformAppFunctionManagerApi$setAppFunctionEnabled$2$2
            @Override // android.os.OutcomeReceiver
            public void onError(Exception error) {
                k.f(error, "error");
                c1718k.resumeWith(kotlin.b.a(error));
            }

            @Override // android.os.OutcomeReceiver
            public void onResult(Void result) {
                c1718k.resumeWith(r.f317a);
            }
        });
        Object objX = c1718k.x();
        return objX == CoroutineSingletons.f4909a ? objX : r.f317a;
    }
}
