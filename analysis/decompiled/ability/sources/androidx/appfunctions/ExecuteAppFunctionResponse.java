package androidx.appfunctions;

import C7.r;
import android.app.appsearch.GenericDocument;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appfunctions.metadata.AppFunctionMetadata;
import androidx.appfunctions.metadata.AppFunctionMetadataKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/appfunctions/ExecuteAppFunctionResponse;", "", "Success", "Error", "Landroidx/appfunctions/ExecuteAppFunctionResponse$Error;", "Landroidx/appfunctions/ExecuteAppFunctionResponse$Success;", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface ExecuteAppFunctionResponse {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Landroidx/appfunctions/ExecuteAppFunctionResponse$Error;", "Landroidx/appfunctions/ExecuteAppFunctionResponse;", "error", "Landroidx/appfunctions/AppFunctionException;", AppAgent.CONSTRUCT, "(Landroidx/appfunctions/AppFunctionException;)V", "getError", "()Landroidx/appfunctions/AppFunctionException;", "toString", "", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Error implements ExecuteAppFunctionResponse {
        private final AppFunctionException error;

        public Error(AppFunctionException error) {
            k.f(error, "error");
            this.error = error;
        }

        public final AppFunctionException getError() {
            return this.error;
        }

        public String toString() {
            return "AppFunctionResponse.Error(error=" + this.error + ')';
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Landroidx/appfunctions/ExecuteAppFunctionResponse$Success;", "Landroidx/appfunctions/ExecuteAppFunctionResponse;", "Landroidx/appfunctions/AppFunctionData;", "returnValue", AppAgent.CONSTRUCT, "(Landroidx/appfunctions/AppFunctionData;)V", "Lcom/android/extensions/appfunctions/ExecuteAppFunctionResponse;", "toPlatformExtensionClass$appfunctions", "()Lcom/android/extensions/appfunctions/ExecuteAppFunctionResponse;", "toPlatformExtensionClass", "Landroid/app/appfunctions/ExecuteAppFunctionResponse;", "toPlatformExecuteAppFunctionResponse", "()Landroid/app/appfunctions/ExecuteAppFunctionResponse;", "Landroid/content/Context;", "context", "", "callingPackageName", "LC7/r;", "grantUriAccess$appfunctions", "(Landroid/content/Context;Ljava/lang/String;)V", "grantUriAccess", "copy", "(Landroidx/appfunctions/AppFunctionData;)Landroidx/appfunctions/ExecuteAppFunctionResponse$Success;", "Landroidx/appfunctions/AppFunctionData;", "getReturnValue", "()Landroidx/appfunctions/AppFunctionData;", "Companion", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Success implements ExecuteAppFunctionResponse {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final String PROPERTY_RETURN_VALUE = "androidAppfunctionsReturnValue";
        private final AppFunctionData returnValue;

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0001¢\u0006\u0002\b\fJ\u0014\u0010\r\u001a\u00020\u0007*\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/appfunctions/ExecuteAppFunctionResponse$Success$Companion;", "", AppAgent.CONSTRUCT, "()V", "PROPERTY_RETURN_VALUE", "", "fromPlatformExtensionClass", "Landroidx/appfunctions/ExecuteAppFunctionResponse$Success;", "response", "Lcom/android/extensions/appfunctions/ExecuteAppFunctionResponse;", "functionMetadata", "Landroidx/appfunctions/metadata/AppFunctionMetadata;", "fromPlatformExtensionClass$appfunctions", "toCompatExecuteAppFunctionResponse", "Landroid/app/appfunctions/ExecuteAppFunctionResponse;", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(e eVar) {
                this();
            }

            @RequiresApi(33)
            public final Success fromPlatformExtensionClass$appfunctions(com.android.extensions.appfunctions.ExecuteAppFunctionResponse response, AppFunctionMetadata functionMetadata) {
                k.f(response, "response");
                k.f(functionMetadata, "functionMetadata");
                GenericDocument resultDocument = response.getResultDocument();
                k.e(resultDocument, "getResultDocument(...)");
                Bundle extras = response.getExtras();
                k.e(extras, "getExtras(...)");
                return new Success(new AppFunctionData(resultDocument, extras).replaceSpecWith$appfunctions(functionMetadata.getResponse(), functionMetadata.getComponents()));
            }

            @RequiresApi(36)
            public final Success toCompatExecuteAppFunctionResponse(android.app.appfunctions.ExecuteAppFunctionResponse executeAppFunctionResponse, AppFunctionMetadata functionMetadata) {
                k.f(executeAppFunctionResponse, "<this>");
                k.f(functionMetadata, "functionMetadata");
                GenericDocument resultDocument = executeAppFunctionResponse.getResultDocument();
                k.e(resultDocument, "getResultDocument(...)");
                Bundle extras = executeAppFunctionResponse.getExtras();
                k.e(extras, "getExtras(...)");
                return new Success(new AppFunctionData(resultDocument, extras).replaceSpecWith$appfunctions(functionMetadata.getResponse(), functionMetadata.getComponents()));
            }

            private Companion() {
            }
        }

        public Success(AppFunctionData returnValue) {
            k.f(returnValue, "returnValue");
            this.returnValue = returnValue;
        }

        public static /* synthetic */ Success copy$default(Success success, AppFunctionData appFunctionData, int i, Object obj) {
            if ((i & 1) != 0) {
                appFunctionData = success.returnValue;
            }
            return success.copy(appFunctionData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final r grantUriAccess$lambda$0(Context context, String str, AppFunctionUriGrant uriGrant) {
            k.f(uriGrant, "uriGrant");
            context.grantUriPermission(str, uriGrant.getUri(), uriGrant.getModeFlags());
            return r.f317a;
        }

        @RequiresApi(36)
        public static final Success toCompatExecuteAppFunctionResponse(android.app.appfunctions.ExecuteAppFunctionResponse executeAppFunctionResponse, AppFunctionMetadata appFunctionMetadata) {
            return INSTANCE.toCompatExecuteAppFunctionResponse(executeAppFunctionResponse, appFunctionMetadata);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final Success copy(AppFunctionData returnValue) {
            k.f(returnValue, "returnValue");
            return new Success(returnValue);
        }

        public final AppFunctionData getReturnValue() {
            return this.returnValue;
        }

        @RequiresApi(33)
        public final void grantUriAccess$appfunctions(Context context, String callingPackageName) {
            k.f(context, "context");
            k.f(callingPackageName, "callingPackageName");
            this.returnValue.visitAppFunctionUriGrants(new R3.b(8, context, callingPackageName));
        }

        @RequiresApi(36)
        public final android.app.appfunctions.ExecuteAppFunctionResponse toPlatformExecuteAppFunctionResponse() {
            M3.a.D();
            return M3.a.i(this.returnValue.getGenericDocument(), this.returnValue.getExtras());
        }

        public final com.android.extensions.appfunctions.ExecuteAppFunctionResponse toPlatformExtensionClass$appfunctions() {
            return new com.android.extensions.appfunctions.ExecuteAppFunctionResponse(this.returnValue.getGenericDocument(), this.returnValue.getExtras());
        }
    }
}
