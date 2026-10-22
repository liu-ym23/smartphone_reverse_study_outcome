package androidx.appfunctions.internal;

import C7.r;
import androidx.annotation.RestrictTo;
import androidx.appfunctions.ExecuteAppFunctionRequest;
import androidx.appfunctions.ExecuteAppFunctionResponse;
import androidx.appfunctions.metadata.AppFunctionMetadata;
import androidx.appfunctions.metadata.AppFunctionMetadataKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H¦@¢\u0006\u0004\b\u0007\u0010\bJ \u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH¦@¢\u0006\u0004\b\r\u0010\u000eJ \u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH¦@¢\u0006\u0004\b\u0012\u0010\u0013ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2 = {"Landroidx/appfunctions/internal/AppFunctionManagerApi;", "", "Landroidx/appfunctions/ExecuteAppFunctionRequest;", "request", "Landroidx/appfunctions/metadata/AppFunctionMetadata;", "functionMetadata", "Landroidx/appfunctions/ExecuteAppFunctionResponse;", "executeAppFunction", "(Landroidx/appfunctions/ExecuteAppFunctionRequest;Landroidx/appfunctions/metadata/AppFunctionMetadata;LH7/c;)Ljava/lang/Object;", "", "packageName", "functionId", "", "isAppFunctionEnabled", "(Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "", "newEnabledState", "LC7/r;", "setAppFunctionEnabled", "(Ljava/lang/String;ILH7/c;)Ljava/lang/Object;", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public interface AppFunctionManagerApi {
    Object executeAppFunction(ExecuteAppFunctionRequest executeAppFunctionRequest, AppFunctionMetadata appFunctionMetadata, H7.c<? super ExecuteAppFunctionResponse> cVar);

    Object isAppFunctionEnabled(String str, String str2, H7.c<? super Boolean> cVar);

    Object setAppFunctionEnabled(String str, int i, H7.c<? super r> cVar);
}
