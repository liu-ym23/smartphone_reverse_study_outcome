package androidx.appfunctions;

import android.app.appfunctions.ExecuteAppFunctionRequest;
import android.app.appsearch.GenericDocument;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appfunctions.metadata.AppFunctionMetadata;
import androidx.appfunctions.metadata.AppFunctionMetadataKt;
import com.android.extensions.appfunctions.ExecuteAppFunctionRequest;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u000bJ\r\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0007J\b\u0010\u0018\u001a\u00020\u0003H\u0016J0\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0007\u001a\u00020\b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Landroidx/appfunctions/ExecuteAppFunctionRequest;", "", "targetPackageName", "", "functionIdentifier", "functionParameters", "Landroidx/appfunctions/AppFunctionData;", "useJetpackSchema", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Landroidx/appfunctions/AppFunctionData;Z)V", "(Ljava/lang/String;Ljava/lang/String;Landroidx/appfunctions/AppFunctionData;)V", "getTargetPackageName", "()Ljava/lang/String;", "getFunctionIdentifier", "getFunctionParameters", "()Landroidx/appfunctions/AppFunctionData;", "getUseJetpackSchema", "()Z", "toPlatformExtensionClass", "Lcom/android/extensions/appfunctions/ExecuteAppFunctionRequest;", "toPlatformExtensionClass$appfunctions", "toPlatformExecuteAppFunctionRequest", "Landroid/app/appfunctions/ExecuteAppFunctionRequest;", "toString", "copy", "Companion", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ExecuteAppFunctionRequest {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String EXTRA_PARAMETERS = "androidXAppfunctionsExtraParameters";
    public static final String EXTRA_USE_JETPACK_SCHEMA = "androidXAppfunctionsExtraUseJetpackSchema";
    private final String functionIdentifier;
    private final AppFunctionData functionParameters;
    private final String targetPackageName;
    private final boolean useJetpackSchema;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0001¢\u0006\u0002\b\rJ\u0014\u0010\u000e\u001a\u00020\b*\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/appfunctions/ExecuteAppFunctionRequest$Companion;", "", AppAgent.CONSTRUCT, "()V", "EXTRA_PARAMETERS", "", "EXTRA_USE_JETPACK_SCHEMA", "fromPlatformExtensionClass", "Landroidx/appfunctions/ExecuteAppFunctionRequest;", "request", "Lcom/android/extensions/appfunctions/ExecuteAppFunctionRequest;", "functionMetadata", "Landroidx/appfunctions/metadata/AppFunctionMetadata;", "fromPlatformExtensionClass$appfunctions", "toCompatExecuteAppFunctionRequest", "Landroid/app/appfunctions/ExecuteAppFunctionRequest;", "createAppFunctionDataWithParameterSpec", "Landroidx/appfunctions/AppFunctionData;", "parametersAfd", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        @RequiresApi(33)
        private final AppFunctionData createAppFunctionDataWithParameterSpec(AppFunctionMetadata functionMetadata, AppFunctionData parametersAfd) {
            return parametersAfd.replaceSpecWith$appfunctions(functionMetadata.getParameters(), functionMetadata.getComponents());
        }

        @RequiresApi(33)
        public final ExecuteAppFunctionRequest fromPlatformExtensionClass$appfunctions(com.android.extensions.appfunctions.ExecuteAppFunctionRequest request, AppFunctionMetadata functionMetadata) {
            k.f(request, "request");
            k.f(functionMetadata, "functionMetadata");
            String targetPackageName = request.getTargetPackageName();
            k.e(targetPackageName, "getTargetPackageName(...)");
            String functionIdentifier = request.getFunctionIdentifier();
            k.e(functionIdentifier, "getFunctionIdentifier(...)");
            GenericDocument parameters = request.getParameters();
            k.e(parameters, "getParameters(...)");
            Bundle bundle = request.getExtras().getBundle(ExecuteAppFunctionRequest.EXTRA_PARAMETERS);
            if (bundle == null) {
                bundle = Bundle.EMPTY;
            }
            k.c(bundle);
            return new ExecuteAppFunctionRequest(targetPackageName, functionIdentifier, createAppFunctionDataWithParameterSpec(functionMetadata, new AppFunctionData(parameters, bundle)), request.getExtras().getBoolean(ExecuteAppFunctionRequest.EXTRA_USE_JETPACK_SCHEMA, false));
        }

        @RequiresApi(36)
        public final ExecuteAppFunctionRequest toCompatExecuteAppFunctionRequest(android.app.appfunctions.ExecuteAppFunctionRequest executeAppFunctionRequest, AppFunctionMetadata functionMetadata) {
            k.f(executeAppFunctionRequest, "<this>");
            k.f(functionMetadata, "functionMetadata");
            String targetPackageName = executeAppFunctionRequest.getTargetPackageName();
            k.e(targetPackageName, "getTargetPackageName(...)");
            String functionIdentifier = executeAppFunctionRequest.getFunctionIdentifier();
            k.e(functionIdentifier, "getFunctionIdentifier(...)");
            GenericDocument parameters = executeAppFunctionRequest.getParameters();
            k.e(parameters, "getParameters(...)");
            Bundle bundle = executeAppFunctionRequest.getExtras().getBundle(ExecuteAppFunctionRequest.EXTRA_PARAMETERS);
            if (bundle == null) {
                bundle = Bundle.EMPTY;
            }
            k.c(bundle);
            return new ExecuteAppFunctionRequest(targetPackageName, functionIdentifier, createAppFunctionDataWithParameterSpec(functionMetadata, new AppFunctionData(parameters, bundle)), executeAppFunctionRequest.getExtras().getBoolean(ExecuteAppFunctionRequest.EXTRA_USE_JETPACK_SCHEMA, false));
        }

        private Companion() {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ExecuteAppFunctionRequest(String targetPackageName, String functionIdentifier, AppFunctionData functionParameters, boolean z10) {
        k.f(targetPackageName, "targetPackageName");
        k.f(functionIdentifier, "functionIdentifier");
        k.f(functionParameters, "functionParameters");
        this.targetPackageName = targetPackageName;
        this.functionIdentifier = functionIdentifier;
        this.functionParameters = functionParameters;
        this.useJetpackSchema = z10;
    }

    public static /* synthetic */ ExecuteAppFunctionRequest copy$default(ExecuteAppFunctionRequest executeAppFunctionRequest, String str, String str2, AppFunctionData appFunctionData, boolean z10, int i, Object obj) {
        if ((i & 1) != 0) {
            str = executeAppFunctionRequest.targetPackageName;
        }
        if ((i & 2) != 0) {
            str2 = executeAppFunctionRequest.functionIdentifier;
        }
        if ((i & 4) != 0) {
            appFunctionData = executeAppFunctionRequest.functionParameters;
        }
        if ((i & 8) != 0) {
            z10 = executeAppFunctionRequest.useJetpackSchema;
        }
        return executeAppFunctionRequest.copy(str, str2, appFunctionData, z10);
    }

    @RequiresApi(36)
    public static final ExecuteAppFunctionRequest toCompatExecuteAppFunctionRequest(android.app.appfunctions.ExecuteAppFunctionRequest executeAppFunctionRequest, AppFunctionMetadata appFunctionMetadata) {
        return INSTANCE.toCompatExecuteAppFunctionRequest(executeAppFunctionRequest, appFunctionMetadata);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final ExecuteAppFunctionRequest copy(String targetPackageName, String functionIdentifier, AppFunctionData functionParameters, boolean useJetpackSchema) {
        k.f(targetPackageName, "targetPackageName");
        k.f(functionIdentifier, "functionIdentifier");
        k.f(functionParameters, "functionParameters");
        return new ExecuteAppFunctionRequest(targetPackageName, functionIdentifier, functionParameters, useJetpackSchema);
    }

    public final String getFunctionIdentifier() {
        return this.functionIdentifier;
    }

    public final AppFunctionData getFunctionParameters() {
        return this.functionParameters;
    }

    public final String getTargetPackageName() {
        return this.targetPackageName;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean getUseJetpackSchema() {
        return this.useJetpackSchema;
    }

    @RequiresApi(36)
    public final android.app.appfunctions.ExecuteAppFunctionRequest toPlatformExecuteAppFunctionRequest() {
        M3.a.C();
        ExecuteAppFunctionRequest.Builder parameters = M3.a.g(this.targetPackageName, this.functionIdentifier).setParameters(this.functionParameters.getGenericDocument());
        Bundle bundle = new Bundle();
        bundle.putBundle(EXTRA_PARAMETERS, this.functionParameters.getExtras());
        bundle.putBoolean(EXTRA_USE_JETPACK_SCHEMA, this.useJetpackSchema);
        android.app.appfunctions.ExecuteAppFunctionRequest executeAppFunctionRequestBuild = parameters.setExtras(bundle).build();
        k.e(executeAppFunctionRequestBuild, "build(...)");
        return executeAppFunctionRequestBuild;
    }

    public final com.android.extensions.appfunctions.ExecuteAppFunctionRequest toPlatformExtensionClass$appfunctions() {
        ExecuteAppFunctionRequest.Builder parameters = new ExecuteAppFunctionRequest.Builder(this.targetPackageName, this.functionIdentifier).setParameters(this.functionParameters.getGenericDocument());
        Bundle bundle = new Bundle();
        bundle.putBundle(EXTRA_PARAMETERS, this.functionParameters.getExtras());
        bundle.putBoolean(EXTRA_USE_JETPACK_SCHEMA, this.useJetpackSchema);
        com.android.extensions.appfunctions.ExecuteAppFunctionRequest executeAppFunctionRequestBuild = parameters.setExtras(bundle).build();
        k.e(executeAppFunctionRequestBuild, "build(...)");
        return executeAppFunctionRequestBuild;
    }

    public String toString() {
        return "ExecuteAppFunctionRequest(functionMetadata.packageName=" + this.targetPackageName + ", functionMetadata.id=" + this.functionIdentifier + ", functionParameters=" + this.functionParameters + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExecuteAppFunctionRequest(String targetPackageName, String functionIdentifier, AppFunctionData functionParameters) {
        this(targetPackageName, functionIdentifier, functionParameters, true);
        k.f(targetPackageName, "targetPackageName");
        k.f(functionIdentifier, "functionIdentifier");
        k.f(functionParameters, "functionParameters");
    }
}
